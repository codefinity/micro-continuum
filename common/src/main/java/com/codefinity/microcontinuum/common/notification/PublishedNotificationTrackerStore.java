package com.codefinity.microcontinuum.common.notification;

import java.util.List;

public interface PublishedNotificationTrackerStore {

    public PublishedNotificationTracker publishedNotificationTracker();

    public PublishedNotificationTracker publishedNotificationTracker(String aTypeName);

    public void trackMostRecentPublishedNotification(
            PublishedNotificationTracker aPublishedNotificationTracker,
            List<Notification> aNotifications);

    public String typeName();
}
