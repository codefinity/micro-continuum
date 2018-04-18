package com.codefinity.microcontinuum.identityaccess.application.command;

public class DeactivateTenantCommand {
    private String tenantId;

    public DeactivateTenantCommand(String tenantId) {
        super();

        this.tenantId = tenantId;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
