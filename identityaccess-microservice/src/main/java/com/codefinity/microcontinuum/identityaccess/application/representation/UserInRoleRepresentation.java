package com.codefinity.microcontinuum.identityaccess.application.representation;

import com.codefinity.microcontinuum.identityaccess.domain.model.identity.User;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.UserDescriptor;

public class UserInRoleRepresentation {

    private String emailAddress;
    private String firstName;
    private String lastName;
    private String role;
    private String tenantId;
    private String username;

    public UserInRoleRepresentation(User aUser, String aRole) {
        this();

        this.initializeFrom(aUser, aRole);
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getRole() {
        return this.role;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public String getUsername() {
        return this.username;
    }

    protected UserInRoleRepresentation() {
        super();
    }

    private void initializeFrom(User aUser, String aRole) {
        UserDescriptor desc = aUser.userDescriptor();
        this.setEmailAddress(desc.emailAddress());
        this.setFirstName(aUser.person().name().firstName());
        this.setLastName(aUser.person().name().lastName());
        this.setRole(aRole);
        this.setTenantId(desc.tenantId().id());
        this.setUsername(desc.username());
    }

    private void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setRole(String aRole) {
        this.role = aRole;
    }

    private void setTenantId(String aTenantId) {
        this.tenantId = aTenantId;
    }

    private void setUsername(String aUsername) {
        this.username = aUsername;
    }
}
