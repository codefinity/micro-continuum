package com.codefinity.microcontinuum.common.event.sourcing;

public interface EventDispatcher {

    public void dispatch(DispatchableDomainEvent aDispatchableDomainEvent);

    public void registerEventDispatcher(EventDispatcher anEventDispatcher);

    public boolean understands(DispatchableDomainEvent aDispatchableDomainEvent);
}
