/*package com.codefinity.microcontinuum.common.port.adapter.persistance.eventsourcing;

import java.util.List;

import com.codefinity.microcontinuum.common.domain.model.DomainEvent;
import com.codefinity.microcontinuum.common.event.sourcing.EventStream;

public class DefaultEventStream implements EventStream {

    private List<DomainEvent> events;
    private int version;

    public DefaultEventStream(List<DomainEvent> anEventsList, int aVersion) {
        super();

        this.setEvents(anEventsList);
        this.setVersion(aVersion);
    }

    @Override
    public List<DomainEvent> events() {
        return this.events;
    }

    @Override
    public int version() {
        return this.version;
    }

    private void setEvents(List<DomainEvent> anEventsList) {
        this.events = anEventsList;
    }

    private void setVersion(int aVersion) {
        this.version = aVersion;
    }
}
*/