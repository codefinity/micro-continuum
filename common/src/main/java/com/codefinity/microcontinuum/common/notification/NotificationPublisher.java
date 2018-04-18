package com.codefinity.microcontinuum.common.notification;

public interface NotificationPublisher {

    public void publishNotifications();

    public boolean internalOnlyTestConfirmation();
}
