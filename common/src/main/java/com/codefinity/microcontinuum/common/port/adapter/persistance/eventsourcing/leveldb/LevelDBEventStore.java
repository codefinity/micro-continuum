package com.codefinity.microcontinuum.common.port.adapter.persistance.eventsourcing.leveldb;

import java.util.ArrayList;
import java.util.List;

import com.codefinity.microcontinuum.common.domain.model.DomainEvent;
import com.codefinity.microcontinuum.common.event.EventSerializer;
import com.codefinity.microcontinuum.common.event.sourcing.DispatchableDomainEvent;
import com.codefinity.microcontinuum.common.event.sourcing.EventNotifiable;
import com.codefinity.microcontinuum.common.event.sourcing.EventStore;
import com.codefinity.microcontinuum.common.event.sourcing.EventStoreException;
import com.codefinity.microcontinuum.common.event.sourcing.EventStream;
import com.codefinity.microcontinuum.common.event.sourcing.EventStreamId;
import com.codefinity.microcontinuum.common.port.adapter.persistance.eventsourcing.DefaultEventStream;

/**
 * I am an EventStore for LevelDB. I am a pure Java implementation
 * using the org.iq80 (Dain Sundstrom) implementation of LevelDB.
 *
 * @author Vaughn Vernon
 */
public class LevelDBEventStore implements EventStore {

    private static LevelDBEventStore instance;

    private EventNotifiable eventNotifiable;
    private LevelDBJournal journal;
    private EventSerializer serializer;

    public static synchronized LevelDBEventStore instance(String aDirectoryPath) {
        if (instance == null) {
            instance = new LevelDBEventStore(aDirectoryPath);
        } else {
            // normally unnecessary, but tests close the journal
            instance.setJournal(LevelDBJournal.initializeInstance(aDirectoryPath));
        }

        return instance;
    }

    @Override
    public void appendWith(EventStreamId aStartingIdentity, List<DomainEvent> anEvents) {

        LoggableJournalEntry[] entries =
                new LoggableJournalEntry[anEvents.size()];

        JournalKeyProvider keyProvider =
                new StreamKeyProvider(
                        aStartingIdentity.streamName(),
                        aStartingIdentity.streamVersion());

        int entryIndex = 0;

        for (DomainEvent event : anEvents) {

            String streamKey = keyProvider.nextReferenceKey();

            String eventValue =
                    this.journal()
                        .valueWithMetadata(
                                this.serializer().serialize(event),
                                event.getClass().getName());

            entries[entryIndex++] =
                    new LoggableJournalEntry(
                            eventValue,
                            streamKey,
                            keyProvider.primaryResourceName());
        }

        this.journal().logEntries(entries);

        this.notifyDispatchableEvents();
    }

    @Override
    public void close() {
        this.journal().close();
    }

    @Override
    public List<DispatchableDomainEvent> eventsSince(long aLastReceivedEvent) {

        List<DispatchableDomainEvent> events = null;

        try {
            List<LoggedJournalEntry> entries =
                    this.journal()
                        .loggedJournalEntriesSince(aLastReceivedEvent);

            events = this.toDispatchableDomainEvents(entries);

        } catch (Throwable t) {
            throw new EventStoreException(
                    "Cannot query event store for events since: "
                        + aLastReceivedEvent
                        + " because: "
                        + t.getMessage(),
                    t);
        }

        return events;
    }

    @Override
    public EventStream eventStreamSince(EventStreamId anIdentity) {
        List<DomainEvent> events = null;

        int version = 0;

        try {
            JournalKeyProvider keyProvider =
                new StreamKeyProvider(
                        anIdentity.streamName(),
                        anIdentity.streamVersion());

            List<LoggedJournalEntry> entries =
                    this.journal()
                        .referencedLoggedJournalEntries(
                                keyProvider);

            events = this.toDomainEvents(entries);

            LoggedJournalEntry entry = entries.get(entries.size() - 1);

            String streamVersion = keyProvider.lastKeyPart(entry.referenceKey());

            version = Integer.parseInt(streamVersion);

        } catch (Throwable t) {
            throw new EventStoreException(
                    "Cannot query event stream for: "
                        + anIdentity.streamName()
                        + " since version: "
                        + anIdentity.streamVersion()
                        + " because: "
                        + t.getMessage(),
                    t);
        }

        if (events.isEmpty()) {
            throw new EventStoreException(
                    "There is no such event stream: "
                    + anIdentity.streamName()
                    + " : "
                    + anIdentity.streamVersion());
        }

        return new DefaultEventStream(events, version);
    }

    @Override
    public EventStream fullEventStreamFor(EventStreamId anIdentity) {
        return this.eventStreamSince(anIdentity.withStreamVersion(1));
    }

    @Override
    public void purge() {
        this.journal().purge();
    }

    @Override
    public void registerEventNotifiable(EventNotifiable anEventNotifiable) {
        this.eventNotifiable = anEventNotifiable;
    }

    private LevelDBEventStore(String aDirectoryPath) {
        super();

        this.setJournal(LevelDBJournal.initializeInstance(aDirectoryPath));
        this.setSerializer(EventSerializer.instance());
    }

    private EventNotifiable eventNotifiable() {
        return this.eventNotifiable;
    }

    private LevelDBJournal journal() {
        return this.journal;
    }

    private void setJournal(LevelDBJournal aJournal) {
        this.journal = aJournal;
    }

    private void notifyDispatchableEvents() {
        EventNotifiable eventNotifiable = this.eventNotifiable();

        if (eventNotifiable != null) {
            this.eventNotifiable().notifyDispatchableEvents();
        }
    }

    private EventSerializer serializer() {
        return this.serializer;
    }

    private void setSerializer(EventSerializer aSerializer) {
        this.serializer = aSerializer;
    }

    @SuppressWarnings("unchecked")
    private List<DomainEvent> toDomainEvents(
            List<LoggedJournalEntry> anEntries)
    throws Exception {

        List<DomainEvent> events = new ArrayList<DomainEvent>();

        for (LoggedJournalEntry entry : anEntries) {

            String eventClassName = entry.nextMetadataValue();

            String eventBody = entry.value();

            Class<DomainEvent> eventClass =
                    (Class<DomainEvent>) Class.forName(eventClassName);

            DomainEvent domainEvent =
                    this.serializer().deserialize(eventBody, eventClass);

            events.add(domainEvent);
        }

        return events;
    }

    @SuppressWarnings("unchecked")
    private List<DispatchableDomainEvent> toDispatchableDomainEvents(
            List<LoggedJournalEntry> anEntries)
    throws Exception {

        List<DispatchableDomainEvent> events = new ArrayList<DispatchableDomainEvent>();

        for (LoggedJournalEntry entry : anEntries) {

            String eventClassName = entry.nextMetadataValue();

            String eventBody = entry.value();

            Class<DomainEvent> eventClass =
                    (Class<DomainEvent>) Class.forName(eventClassName);

            DomainEvent domainEvent =
                    this.serializer().deserialize(eventBody, eventClass);

            events.add(new DispatchableDomainEvent(entry.journalSequence(), domainEvent));
        }

        return events;
    }

    private class StreamKeyProvider
            extends JournalKeyProvider {

        private String streamName;
        private int streamVersion;

        public StreamKeyProvider(String aStreamName, int aStartingStreamVersion) {
            super();

            this.streamName = aStreamName;
            this.streamVersion = aStartingStreamVersion;
        }

        @Override
        public String nextReferenceKey() {
            String key =
                    this.compositeReferenceKeyFrom(
                                streamName,
                                ""+streamVersion);

            ++streamVersion;

            return key;
        }

        @Override
        public String primaryResourceName() {
            return this.streamName;
        }
    }
}
