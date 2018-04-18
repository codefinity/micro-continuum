package com.codefinity.microcontinuum.common.event.sourcing;

import com.codefinity.microcontinuum.common.domain.model.DomainEvent;

public class DispatchableDomainEvent {

    private DomainEvent domainEvent;
    private long eventId;

    public DispatchableDomainEvent(long anEventId, DomainEvent aDomainEvent) {
        super();

        this.domainEvent = aDomainEvent;
        this.eventId = anEventId;
    }

    public DomainEvent domainEvent() {
        return this.domainEvent;
    }

    public long eventId() {
        return this.eventId;
    }
}
