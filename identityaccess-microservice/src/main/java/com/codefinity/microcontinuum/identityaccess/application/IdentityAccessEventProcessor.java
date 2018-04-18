package com.codefinity.microcontinuum.identityaccess.application;

import org.aspectj.lang.annotation.Aspect;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.codefinity.microcontinuum.common.domain.model.DomainEvent;
import com.codefinity.microcontinuum.common.domain.model.DomainEventPublisher;
import com.codefinity.microcontinuum.common.domain.model.DomainEventSubscriber;
import com.codefinity.microcontinuum.common.event.EventStore;

@Aspect
public class IdentityAccessEventProcessor {

    @Autowired
    private EventStore eventStore;

    /**
     * Registers a IdentityAccessEventProcessor to listen
     * and forward all domain events to external subscribers.
     * This factory method is provided in the case where
     * Spring AOP wiring is not desired.
     */
    public static void register() {
        (new IdentityAccessEventProcessor()).listen();
    }

    /**
     * Constructs my default state.
     */
    public IdentityAccessEventProcessor() {
        super();
    }

    /**
     * Listens for all domain events and stores them.
     */
    //Commented because:  Unable to resolve dependencies
    //@Before("execution(* com.saasovation.identityaccess.application.*.*(..))")
    public void listen() {
        DomainEventPublisher
            .instance()
            .subscribe(new DomainEventSubscriber<DomainEvent>() {

                public void handleEvent(DomainEvent aDomainEvent) {
                    store(aDomainEvent);
                }

                public Class<DomainEvent> subscribedToEventType() {
                    return DomainEvent.class; // all domain events
                }
            });
    }

    /**
     * Stores aDomainEvent to the event store.
     * @param aDomainEvent the DomainEvent to store
     */
    private void store(DomainEvent aDomainEvent) {
        this.eventStore().append(aDomainEvent);
    }

    /**
     * Answers my EventStore.
     * @return EventStore
     */
    private EventStore eventStore() {
        return this.eventStore;
    }
}
