package com.codefinity.microcontinuum.identityaccess.application.command;

public class ChangeSecondaryTelephoneCommand {
    private String tenantId;
    private String username;
    private String telephone;

    public ChangeSecondaryTelephoneCommand(String tenantId, String username, String telephone) {
        super();

        this.tenantId = tenantId;
        this.username = username;
        this.telephone = telephone;
    }

    public ChangeSecondaryTelephoneCommand() {
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

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
