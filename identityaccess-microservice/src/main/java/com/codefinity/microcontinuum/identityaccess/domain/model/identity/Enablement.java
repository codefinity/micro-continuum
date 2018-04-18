package com.codefinity.microcontinuum.identityaccess.domain.model.identity;


import java.io.Serializable;
import java.util.Date;

import com.codefinity.microcontinuum.common.AssertionConcern;

public final class Enablement extends AssertionConcern implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean enabled;
    private Date endDate;
    private Date startDate;

    public static Enablement indefiniteEnablement() {
        return new Enablement(true, null, null);
    }

    public Enablement(boolean anEnabled, Date aStartDate, Date anEndDate) {
        super();

        if (aStartDate != null || anEndDate != null) {
            this.assertArgumentNotNull(aStartDate, "The start date must be provided.");
            this.assertArgumentNotNull(anEndDate, "The end date must be provided.");
            this.assertArgumentFalse(aStartDate.after(anEndDate), "Enablement start and/or end date is invalid.");
        }

        this.setEnabled(anEnabled);
        this.setEndDate(anEndDate);
        this.setStartDate(aStartDate);
    }

    public Enablement(Enablement anEnablement) {
        this(anEnablement.isEnabled(), anEnablement.startDate(), anEnablement.endDate());
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isEnablementEnabled() {
        boolean enabled = false;

        if (this.isEnabled()) {
            if (!this.isTimeExpired()) {
                enabled = true;
            }
        }

        return enabled;
    }

    public Date endDate() {
        return this.endDate;
    }

    public boolean isTimeExpired() {
        boolean timeExpired = false;

        if (this.startDate() != null && this.endDate() != null) {
            Date now = new Date();
            if (now.before(this.startDate()) ||
                now.after(this.endDate())) {
                timeExpired = true;
            }
        }

        return timeExpired;
    }

    public Date startDate() {
        return this.startDate;
    }

    @Override
    public boolean equals(Object anObject) {
        boolean equalObjects = false;

        if (anObject != null && this.getClass() == anObject.getClass()) {
            Enablement typedObject = (Enablement) anObject;
            equalObjects =
                this.isEnabled() == typedObject.isEnabled() &&
                ((this.startDate() == null && typedObject.startDate() == null) ||
                 (this.startDate() != null && this.startDate().equals(typedObject.startDate()))) &&
                ((this.endDate() == null && typedObject.endDate() == null) ||
                 (this.endDate() != null && this.endDate().equals(typedObject.endDate())));
        }

        return equalObjects;
    }

    @Override
    public int hashCode() {
        int hashCodeValue =
            + (19563 * 181)
            + (this.isEnabled() ? 1:0)
            + (this.startDate() == null ? 0:this.startDate().hashCode())
            + (this.endDate() == null ? 0:this.endDate().hashCode());

        return hashCodeValue;
    }

    @Override
    public String toString() {
        return "Enablement [enabled=" + enabled + ", endDate=" + endDate + ", startDate=" + startDate + "]";
    }

    protected Enablement() {
        super();
    }

    private void setEnabled(boolean anEnabled) {
        this.enabled = anEnabled;
    }

    private void setEndDate(Date anEndDate) {
        this.endDate = anEndDate;
    }

    private void setStartDate(Date aStartDate) {
        this.startDate = aStartDate;
    }
}
