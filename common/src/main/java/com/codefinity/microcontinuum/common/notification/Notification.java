package com.codefinity.microcontinuum.common.notification;

import java.io.Serializable;
import java.util.Date;

import com.codefinity.microcontinuum.common.AssertionConcern;
import com.codefinity.microcontinuum.common.domain.model.DomainEvent;

public class Notification extends AssertionConcern implements Serializable {

    private static final long serialVersionUID = 1L;

    private DomainEvent event;
    private long notificationId;
    private Date occurredOn;
    private String typeName;
    private int version;

    public Notification(
            long aNotificationId,
            DomainEvent anEvent) {

        this();

        this.setEvent(anEvent);
        this.setNotificationId(aNotificationId);
        this.setOccurredOn(anEvent.occurredOn());
        this.setTypeName(anEvent.getClass().getName());
        this.setVersion(anEvent.eventVersion());
    }

    @SuppressWarnings("unchecked")
    public <T extends DomainEvent> T event() {
        return (T) this.event;
    }

    public long notificationId() {
        return this.notificationId;
    }

    public Date occurredOn() {
        return this.occurredOn;
    }

    public String typeName() {
        return this.typeName;
    }

    public int version() {
        return version;
    }

    @Override
    public boolean equals(Object anObject) {
        boolean equalObjects = false;

        if (anObject != null && this.getClass() == anObject.getClass()) {
            Notification typedObject = (Notification) anObject;
            equalObjects = this.notificationId() == typedObject.notificationId();
        }

        return equalObjects;
    }

    @Override
    public int hashCode() {
        int hashCodeValue =
            + (3017 * 197)
            + (int) this.notificationId();

        return hashCodeValue;
    }

    @Override
    public String toString() {
        return "Notification [event=" + event + ", notificationId=" + notificationId
                + ", occurredOn=" + occurredOn + ", typeName="
                + typeName + ", version=" + version + "]";
    }

    protected Notification() {
        super();
    }

    protected void setEvent(DomainEvent anEvent) {
        this.assertArgumentNotNull(anEvent, "The event is required.");

        this.event = anEvent;
    }

    protected void setNotificationId(long aNotificationId) {
        this.notificationId = aNotificationId;
    }

    protected void setOccurredOn(Date anOccurredOn) {
        this.occurredOn = anOccurredOn;
    }

    protected void setTypeName(String aTypeName) {
        this.assertArgumentNotEmpty(aTypeName, "The type name is required.");
        this.assertArgumentLength(aTypeName, 100, "The type name must be 100 characters or less.");

        this.typeName = aTypeName;
    }

    private void setVersion(int aVersion) {
        this.version = aVersion;
    }
}
