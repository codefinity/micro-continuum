package com.codefinity.microcontinuum.identityaccess.application.representation;

import com.codefinity.microcontinuum.identityaccess.domain.model.identity.TenantId;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.User;

public class UserRepresentation {

    private String emailAddress;
    private boolean enabled;
    private String firstName;
    private String lastName;
    private TenantId tenantId;
    private String username;

    public UserRepresentation(User aUser) {
        super();

        this.initializeFrom(aUser);
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getTenantId() {
        return this.tenantId.id();
    }

    public String getUsername() {
        return this.username;
    }

    protected UserRepresentation() {
        super();
    }

    private void initializeFrom(User aUser) {
        this.emailAddress = aUser.person().emailAddress().address();
        this.enabled = aUser.isEnabled();
        this.firstName = aUser.person().name().firstName();
        this.lastName = aUser.person().name().lastName();
        this.tenantId = aUser.tenantId();
        this.username = aUser.username();
    }
}
