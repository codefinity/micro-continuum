package com.codefinity.microcontinuum.common.port.adapter.notification;

import java.util.ArrayList;
import java.util.List;

import com.codefinity.microcontinuum.common.domain.model.DomainEvent;
import com.codefinity.microcontinuum.common.event.EventStore;
import com.codefinity.microcontinuum.common.event.StoredEvent;
import com.codefinity.microcontinuum.common.notification.Notification;
import com.codefinity.microcontinuum.common.notification.NotificationPublisher;
import com.codefinity.microcontinuum.common.notification.NotificationSerializer;
import com.codefinity.microcontinuum.common.notification.PublishedNotificationTracker;
import com.codefinity.microcontinuum.common.notification.PublishedNotificationTrackerStore;
import com.codefinity.microcontinuum.common.port.adapter.messaging.rabbitmq.ConnectionSettings;
import com.codefinity.microcontinuum.common.port.adapter.messaging.rabbitmq.Exchange;
import com.codefinity.microcontinuum.common.port.adapter.messaging.rabbitmq.MessageParameters;
import com.codefinity.microcontinuum.common.port.adapter.messaging.rabbitmq.MessageProducer;

public class RabbitMQNotificationPublisher implements NotificationPublisher {

    private EventStore eventStore;
    private String exchangeName;

    private PublishedNotificationTrackerStore publishedNotificationTrackerStore;

    public RabbitMQNotificationPublisher(
            EventStore anEventStore,
            PublishedNotificationTrackerStore aPublishedNotificationTrackerStore,
            Object aMessagingLocator) {

        super();

        this.setEventStore(anEventStore);
        this.setExchangeName((String) aMessagingLocator);
        this.setPublishedNotificationTrackerStore(aPublishedNotificationTrackerStore);
    }

    @Override
    public void publishNotifications() {
        PublishedNotificationTracker publishedNotificationTracker =
                this.publishedNotificationTrackerStore().publishedNotificationTracker();

        List<Notification> notifications =
            this.listUnpublishedNotifications(
                    publishedNotificationTracker.mostRecentPublishedNotificationId());

        MessageProducer messageProducer = this.messageProducer();

        try {
            for (Notification notification : notifications) {
                this.publish(notification, messageProducer);
            }

            this.publishedNotificationTrackerStore()
                .trackMostRecentPublishedNotification(
                    publishedNotificationTracker,
                    notifications);
        } finally {
            messageProducer.close();
        }
    }

    @Override
    public boolean internalOnlyTestConfirmation() {
        throw new UnsupportedOperationException("Not supported by production implementation.");
    }

    private EventStore eventStore() {
        return this.eventStore;
    }

    private void setEventStore(EventStore anEventStore) {
        this.eventStore = anEventStore;
    }

    private String exchangeName() {
        return this.exchangeName;
    }

    private void setExchangeName(String anExchangeName) {
        this.exchangeName = anExchangeName;
    }

    private List<Notification> listUnpublishedNotifications(
            long aMostRecentPublishedMessageId) {
        List<StoredEvent> storedEvents =
            this.eventStore().allStoredEventsSince(aMostRecentPublishedMessageId);

        List<Notification> notifications =
            this.notificationsFrom(storedEvents);

        return notifications;
    }

    private MessageProducer messageProducer() {

        // creates my exchange if non-existing
        Exchange exchange =
            Exchange.fanOutInstance(
                    ConnectionSettings.instance(),
                    this.exchangeName(),
                    true);

        // create a message producer used to forward events
        MessageProducer messageProducer = MessageProducer.instance(exchange);

        return messageProducer;
    }

    private List<Notification> notificationsFrom(List<StoredEvent> aStoredEvents) {
        List<Notification> notifications =
            new ArrayList<Notification>(aStoredEvents.size());

        for (StoredEvent storedEvent : aStoredEvents) {
            DomainEvent domainEvent = storedEvent.toDomainEvent();

            Notification notification =
                new Notification(storedEvent.eventId(), domainEvent);

            notifications.add(notification);
        }

        return notifications;
    }

    private void publish(
            Notification aNotification,
            MessageProducer aMessageProducer) {

        MessageParameters messageParameters =
            MessageParameters.durableTextParameters(
                    aNotification.typeName(),
                    Long.toString(aNotification.notificationId()),
                    aNotification.occurredOn());

        String notification =
            NotificationSerializer
                .instance()
                .serialize(aNotification);

        aMessageProducer.send(notification, messageParameters);
    }

    private PublishedNotificationTrackerStore publishedNotificationTrackerStore() {
        return publishedNotificationTrackerStore;
    }

    private void setPublishedNotificationTrackerStore(PublishedNotificationTrackerStore publishedNotificationTrackerStore) {
        this.publishedNotificationTrackerStore = publishedNotificationTrackerStore;
    }
}
