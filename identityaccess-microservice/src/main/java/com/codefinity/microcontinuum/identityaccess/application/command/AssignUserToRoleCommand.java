package com.codefinity.microcontinuum.identityaccess.application.command;

public class AssignUserToRoleCommand {

    private String tenantId;
    private String username;
    private String roleName;

    public AssignUserToRoleCommand(String tenantId, String username, String roleName) {
        super();

        this.tenantId = tenantId;
        this.username = username;
        this.roleName = roleName;
    }

    public AssignUserToRoleCommand() {
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

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
