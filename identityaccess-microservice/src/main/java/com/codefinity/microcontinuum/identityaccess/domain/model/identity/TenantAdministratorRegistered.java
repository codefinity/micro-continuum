package com.codefinity.microcontinuum.identityaccess.domain.model.identity;

import java.util.Date;

import com.codefinity.microcontinuum.common.domain.model.DomainEvent;

public class TenantAdministratorRegistered implements DomainEvent {

    private FullName administratorName;
    private EmailAddress emailAddress;
    private int eventVersion;
    private Date occurredOn;
    private String temporaryPassword;
    private TenantId tenantId;
    private String tenantName;
    private String username;

    public TenantAdministratorRegistered(
            TenantId aTenantId,
            String aTenantName,
            FullName anAdministratorName,
            EmailAddress anEmailAddress,
            String aUsername,
            String aTemporaryPassword) {

        super();

        this.administratorName = anAdministratorName;
        this.emailAddress = anEmailAddress;
        this.eventVersion = 1;
        this.occurredOn = new Date();
        this.temporaryPassword = aTemporaryPassword;
        this.tenantId = aTenantId;
        this.tenantName = aTenantName;
        this.username = aUsername;
    }

    public FullName administratorName() {
        return this.administratorName;
    }

    public EmailAddress emailAddress() {
        return this.emailAddress;
    }

    @Override
    public int eventVersion() {
        return this.eventVersion;
    }

    @Override
    public Date occurredOn() {
        return this.occurredOn;
    }

    public String temporaryPassword() {
        return this.temporaryPassword;
    }

    public TenantId tenantId() {
        return this.tenantId;
    }

    public String getTenantName() {
        return this.tenantName;
    }

    public String username() {
        return this.username;
    }
}
