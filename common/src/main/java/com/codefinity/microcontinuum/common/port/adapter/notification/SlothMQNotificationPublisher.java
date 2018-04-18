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
import com.codefinity.microcontinuum.common.port.adapter.messaging.slothmq.ExchangePublisher;

public class SlothMQNotificationPublisher implements NotificationPublisher {

    private EventStore eventStore;
    private String exchangeName;
    private ExchangePublisher exchangePublisher;
    private PublishedNotificationTrackerStore publishedNotificationTrackerStore;

    public SlothMQNotificationPublisher(
            EventStore anEventStore,
            PublishedNotificationTrackerStore aPublishedNotificationTrackerStore,
            Object aMessagingLocator) {

        super();

        this.setEventStore(anEventStore);
        this.setExchangeName((String) aMessagingLocator);
        this.setExchangePublisher(new ExchangePublisher(this.exchangeName()));
        this.setPublishedNotificationTrackerStore(aPublishedNotificationTrackerStore);
    }

    @Override
    public void publishNotifications() {
        PublishedNotificationTracker publishedNotificationTracker =
                this.publishedNotificationTrackerStore().publishedNotificationTracker();

        List<Notification> notifications =
            this.listUnpublishedNotifications(
                    publishedNotificationTracker.mostRecentPublishedNotificationId());

        try {
            for (Notification notification : notifications) {
                this.publish(notification);
            }

            this.publishedNotificationTrackerStore()
                .trackMostRecentPublishedNotification(
                    publishedNotificationTracker,
                    notifications);
        } catch (Exception e) {
            System.out.println("SLOTH: NotificationPublisher problem: " + e.getMessage());
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

    private ExchangePublisher exchangePublisher() {
        return exchangePublisher;
    }

    private void setExchangePublisher(ExchangePublisher anExchangePublisher) {
        this.exchangePublisher = anExchangePublisher;
    }

    private List<Notification> listUnpublishedNotifications(
            long aMostRecentPublishedMessageId) {
        List<StoredEvent> storedEvents =
            this.eventStore().allStoredEventsSince(aMostRecentPublishedMessageId);

        List<Notification> notifications =
            this.notificationsFrom(storedEvents);

        return notifications;
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

    private void publish(Notification aNotification) {

        String notification =
            NotificationSerializer
                .instance()
                .serialize(aNotification);

        this.exchangePublisher().publish(aNotification.typeName(), notification);
    }

    private PublishedNotificationTrackerStore publishedNotificationTrackerStore() {
        return publishedNotificationTrackerStore;
    }

    private void setPublishedNotificationTrackerStore(PublishedNotificationTrackerStore publishedNotificationTrackerStore) {
        this.publishedNotificationTrackerStore = publishedNotificationTrackerStore;
    }
}
