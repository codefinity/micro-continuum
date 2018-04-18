package com.codefinity.microcontinuum.identityaccess.application.command;

public class ChangeEmailAddressCommand {
    private String tenantId;
    private String username;
    private String emailAddress;

    public ChangeEmailAddressCommand(String tenantId, String username, String emailAddress) {
        super();

        this.tenantId = tenantId;
        this.username = username;
        this.emailAddress = emailAddress;
    }

    public ChangeEmailAddressCommand() {
        super();
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
