package com.codefinity.microcontinuum.identityaccess.application.command;

public class RemoveGroupFromGroupCommand {

    private String tenantId;
    private String childGroupName;
    private String parentGroupName;

    public RemoveGroupFromGroupCommand(String tenantId, String parentGroupName, String childGroupName) {
        super();

        this.tenantId = tenantId;
        this.parentGroupName = parentGroupName;
        this.childGroupName = childGroupName;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getChildGroupName() {
        return childGroupName;
    }

    public void setChildGroupName(String childGroupName) {
        this.childGroupName = childGroupName;
    }

    public String getParentGroupName() {
        return parentGroupName;
    }

    public void setParentGroupName(String parentGroupName) {
        this.parentGroupName = parentGroupName;
    }
}
