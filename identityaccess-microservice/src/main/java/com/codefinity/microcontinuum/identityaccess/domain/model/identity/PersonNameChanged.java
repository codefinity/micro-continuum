package com.codefinity.microcontinuum.identityaccess.domain.model.identity;

import java.util.Date;

import com.codefinity.microcontinuum.common.domain.model.DomainEvent;

public class PersonNameChanged implements DomainEvent {

    private int eventVersion;
    private FullName name;
    private Date occurredOn;
    private TenantId tenantId;
    private String username;

    public PersonNameChanged(TenantId aTenantId, String aUsername, FullName aName) {
        super();

        this.eventVersion = 1;
        this.name = aName;
        this.occurredOn = new Date();
        this.tenantId = aTenantId;
        this.username = aUsername;
    }

    @Override
    public int eventVersion() {
        return this.eventVersion;
    }

    public FullName name() {
        return this.name;
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
