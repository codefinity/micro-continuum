package com.codefinity.microcontinuum.common.domain.model;

public abstract class Validator {

    private ValidationNotificationHandler notificationHandler;

    public Validator(ValidationNotificationHandler aHandler) {
        super();

        this.setNotificationHandler(aHandler);
    }

    public abstract void validate();

    protected ValidationNotificationHandler notificationHandler() {
        return this.notificationHandler;
    }

    private void setNotificationHandler(ValidationNotificationHandler aHandler) {
        this.notificationHandler = aHandler;
    }
}
