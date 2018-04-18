package com.codefinity.microcontinuum.common.notification;

class NotificationLogInfo {

    private NotificationLogId notificationLogId;
    private long totalLogged;

    public NotificationLogInfo(NotificationLogId aNotificationLogId, long aTotalLogged) {
        super();

        this.notificationLogId = aNotificationLogId;
        this.totalLogged = aTotalLogged;
    }

    public NotificationLogId notificationLogId() {
        return this.notificationLogId;
    }

    public long totalLogged() {
        return this.totalLogged;
    }
}
