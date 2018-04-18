package com.codefinity.microcontinuum.common.event.sourcing;

import java.util.List;

import com.codefinity.microcontinuum.common.domain.model.DomainEvent;

public interface EventStore {

    public void appendWith(EventStreamId aStartingIdentity, List<DomainEvent> anEvents);

    public void close();

    public List<DispatchableDomainEvent> eventsSince(long aLastReceivedEvent);

    public EventStream eventStreamSince(EventStreamId anIdentity);

    public EventStream fullEventStreamFor(EventStreamId anIdentity);

    public void purge(); // mainly used for testing

    public void registerEventNotifiable(EventNotifiable anEventNotifiable);
}
