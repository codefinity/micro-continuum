package com.codefinity.microcontinuum.identityaccess.domain.model.identity;

import java.util.Date;

import com.codefinity.microcontinuum.common.domain.model.DomainEvent;

public class PersonContactInformationChanged implements DomainEvent {

    private ContactInformation contactInformation;
    private int eventVersion;
    private Date occurredOn;
    private TenantId tenantId;
    private String username;

    public PersonContactInformationChanged(
            TenantId aTenantId,
            String aUsername,
            ContactInformation aContactInformation) {

        super();

        this.contactInformation = aContactInformation;
        this.eventVersion = 1;
        this.occurredOn = new Date();
        this.tenantId = aTenantId;
        this.username = aUsername;
    }

    public ContactInformation contactInformation() {
        return this.contactInformation;
    }

    @Override
    public int eventVersion() {
        return this.eventVersion;
    }

    @Override
    public Date occurredOn() {
        return this.occurredOn;
    }

    public TenantId tenantId() {
        return this.tenantId;
    }

    public String username() {
        return this.username;
    }
}
