package com.codefinity.microcontinuum.identityaccess.application.command;

public class ChangePrimaryTelephoneCommand {
    private String tenantId;
    private String username;
    private String telephone;

    public ChangePrimaryTelephoneCommand(String tenantId, String username, String telephone) {
        super();

        this.tenantId = tenantId;
        this.username = username;
        this.telephone = telephone;
    }

    public ChangePrimaryTelephoneCommand() {
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
