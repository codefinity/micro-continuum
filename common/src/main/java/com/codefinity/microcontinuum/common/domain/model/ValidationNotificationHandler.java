package com.codefinity.microcontinuum.common.domain.model;

public interface ValidationNotificationHandler {

    public void handleError(String aNotificationMessage);

    public void handleError(String aNotification, Object anObject);

    public void handleInfo(String aNotificationMessage);

    public void handleInfo(String aNotification, Object anObject);

    public void handleWarning(String aNotificationMessage);

    public void handleWarning(String aNotification, Object anObject);
}
