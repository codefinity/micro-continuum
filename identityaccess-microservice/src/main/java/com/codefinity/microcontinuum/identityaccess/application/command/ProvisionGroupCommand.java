package com.codefinity.microcontinuum.identityaccess.application.command;

public class ProvisionGroupCommand {

    private String description;
    private String groupName;
    private String tenantId;

    public ProvisionGroupCommand(
            String tenantId,
            String groupName,
            String description) {

        super();

        this.description = description;
        this.groupName = groupName;
        this.tenantId = tenantId;
    }

    public ProvisionGroupCommand() {
        super();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
