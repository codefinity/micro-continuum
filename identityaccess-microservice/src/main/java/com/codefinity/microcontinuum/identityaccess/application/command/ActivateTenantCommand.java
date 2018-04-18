package com.codefinity.microcontinuum.identityaccess.application.command;

public class ActivateTenantCommand {
    private String tenantId;

    public ActivateTenantCommand(String tenantId) {
        super();

        this.tenantId = tenantId;
    }

    public ActivateTenantCommand() {
        super();
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
