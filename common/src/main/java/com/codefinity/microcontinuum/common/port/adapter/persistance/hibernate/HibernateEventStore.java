/*package com.codefinity.microcontinuum.common.port.adapter.persistance.hibernate;

import java.util.List;

import org.hibernate.Query;

import com.codefinity.microcontinuum.common.domain.model.DomainEvent;
import com.codefinity.microcontinuum.common.event.EventSerializer;
import com.codefinity.microcontinuum.common.event.EventStore;
import com.codefinity.microcontinuum.common.event.StoredEvent;
import com.codefinity.microcontinuum.common.persistance.PersistenceManagerProvider;

public class HibernateEventStore
    extends AbstractHibernateSession
    implements EventStore {

    public HibernateEventStore(PersistenceManagerProvider aPersistenceManagerProvider) {
        this();

        if (!aPersistenceManagerProvider.hasHibernateSession()) {
            throw new IllegalArgumentException("The PersistenceManagerProvider must have a Hibernate Session.");
        }

        this.setSession(aPersistenceManagerProvider.hibernateSession());
    }

    public HibernateEventStore() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<StoredEvent> allStoredEventsBetween(long aLowStoredEventId, long aHighStoredEventId) {
        Query query =
                this.session().createQuery(
                        "from StoredEvent as _obj_ "
                        + "where _obj_.eventId between ? and ? "
                        + "order by _obj_.eventId");

        query.setParameter(0, aLowStoredEventId);
        query.setParameter(1, aHighStoredEventId);

        List<StoredEvent> storedEvents = query.list();

        return storedEvents;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<StoredEvent> allStoredEventsSince(long aStoredEventId) {
        Query query =
                this.session().createQuery(
                        "from StoredEvent as _obj_ "
                        + "where _obj_.eventId > ? "
                        + "order by _obj_.eventId");

        query.setParameter(0, aStoredEventId);

        List<StoredEvent> storedEvents = query.list();

        return storedEvents;
    }

    @Override
    public StoredEvent append(DomainEvent aDomainEvent) {
        String eventSerialization =
                EventSerializer.instance().serialize(aDomainEvent);

        StoredEvent storedEvent =
                new StoredEvent(
                        aDomainEvent.getClass().getName(),
                        aDomainEvent.occurredOn(),
                        eventSerialization);

        this.session().save(storedEvent);

        return storedEvent;
    }

    @Override
    public void close() {
        // no-op
    }

    @Override
    public long countStoredEvents() {
        Query query =
                this.session().createQuery("select count(*) from StoredEvent");

        long count = ((Long) query.uniqueResult()).longValue();

        return count;
    }
}
*/