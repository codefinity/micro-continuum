package com.codefinity.microcontinuum.common.event.sourcing;

import java.util.List;

import com.codefinity.microcontinuum.common.domain.model.DomainEvent;

public interface EventStream {

    public List<DomainEvent> events();

    public int version();
}
