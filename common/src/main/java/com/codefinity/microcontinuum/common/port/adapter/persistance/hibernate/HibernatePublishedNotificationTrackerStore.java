/*package com.codefinity.microcontinuum.common.port.adapter.persistance.hibernate;

import java.util.List;

import org.hibernate.Query;

import com.codefinity.microcontinuum.common.notification.Notification;
import com.codefinity.microcontinuum.common.notification.PublishedNotificationTracker;
import com.codefinity.microcontinuum.common.notification.PublishedNotificationTrackerStore;
import com.codefinity.microcontinuum.common.persistance.PersistenceManagerProvider;

public class HibernatePublishedNotificationTrackerStore
    extends AbstractHibernateSession
    implements PublishedNotificationTrackerStore {

    private String typeName;

    public HibernatePublishedNotificationTrackerStore(
            PersistenceManagerProvider aPersistenceManagerProvider,
            String aPublishedNotificationTrackerType) {
        this();

        if (!aPersistenceManagerProvider.hasHibernateSession()) {
            throw new IllegalArgumentException("The PersistenceManagerProvider must have a Hibernate Session.");
        }

        this.setSession(aPersistenceManagerProvider.hibernateSession());
        this.setTypeName(aPublishedNotificationTrackerType);
    }

    public HibernatePublishedNotificationTrackerStore() {
        super();
    }

    @Override
    public PublishedNotificationTracker publishedNotificationTracker() {
        return this.publishedNotificationTracker(this.typeName());
    }

    @Override
    public PublishedNotificationTracker publishedNotificationTracker(String aTypeName) {
        Query query =
                this.session().createQuery(
                        "from PublishedNotificationTracker as pnt "
                        + "where pnt.typeName = ?");

        query.setParameter(0, aTypeName);

        PublishedNotificationTracker publishedNotificationTracker = null;

        try {
            publishedNotificationTracker =
                    (PublishedNotificationTracker) query.uniqueResult();
        } catch (Exception e) {
            // fall through
        }

        if (publishedNotificationTracker == null) {
            publishedNotificationTracker =
                    new PublishedNotificationTracker(this.typeName());
        }

        return publishedNotificationTracker;
    }

    @Override
    public void trackMostRecentPublishedNotification(
            PublishedNotificationTracker aPublishedNotificationTracker,
            List<Notification> aNotifications) {
        int lastIndex = aNotifications.size() - 1;

        if (lastIndex >= 0) {
            long mostRecentId = aNotifications.get(lastIndex).notificationId();

            aPublishedNotificationTracker.setMostRecentPublishedNotificationId(mostRecentId);

            this.session().save(aPublishedNotificationTracker);
        }
    }

    @Override
    public String typeName() {
        return typeName;
    }

    private void setTypeName(String aTypeName) {
        this.typeName = aTypeName;
    }
}
*/