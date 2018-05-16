/*package com.codefinity.microcontinuum.common.port.adapter.persistance.leveldb;

import java.util.List;

import com.codefinity.microcontinuum.common.notification.Notification;
import com.codefinity.microcontinuum.common.notification.PublishedNotificationTracker;
import com.codefinity.microcontinuum.common.notification.PublishedNotificationTrackerStore;

public class LevelDBPublishedNotificationTrackerStore
    extends AbstractLevelDBRepository
    implements PublishedNotificationTrackerStore {

    private static final String PRIMARY = "PUBNOTIF_TRACKER#PK";

    private String typeName;

    public LevelDBPublishedNotificationTrackerStore(
            String aLevelDBDirectoryPath,
            String aPublishedNotificationTrackerType) {
        super(aLevelDBDirectoryPath);

        this.setTypeName(aPublishedNotificationTrackerType);
    }

    @Override
    public PublishedNotificationTracker publishedNotificationTracker() {
        return this.publishedNotificationTracker(this.typeName());
    }

    @Override
    public PublishedNotificationTracker publishedNotificationTracker(String aTypeName) {
        LevelDBUnitOfWork uow = LevelDBUnitOfWork.readOnly(this.database());

        LevelDBKey primaryKey = new LevelDBKey(PRIMARY, this.typeName());

        PublishedNotificationTracker publishedNotificationTracker =
                uow.readObject(primaryKey, PublishedNotificationTracker.class);

        if (publishedNotificationTracker == null) {
            publishedNotificationTracker = new PublishedNotificationTracker(this.typeName());
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

            LevelDBKey lockKey = new LevelDBKey(PRIMARY, this.typeName());

            LevelDBUnitOfWork uow = LevelDBUnitOfWork.start(this.database());

            uow.lock(lockKey.key());

            this.save(aPublishedNotificationTracker, uow);
        }
    }

    @Override
    public String typeName() {
        return this.typeName;
    }

    private void save(
            PublishedNotificationTracker aPublishedNotificationTracker,
            LevelDBUnitOfWork aUoW) {

        LevelDBKey primaryKey = new LevelDBKey(PRIMARY, this.typeName());

        aUoW.write(primaryKey, aPublishedNotificationTracker);
    }

    private void setTypeName(String aTypeName) {
        this.typeName = aTypeName;
    }
}
*/