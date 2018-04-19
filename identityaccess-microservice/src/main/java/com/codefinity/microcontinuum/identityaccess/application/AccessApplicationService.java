package com.codefinity.microcontinuum.identityaccess.application;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;

import com.codefinity.microcontinuum.identityaccess.application.command.AssignUserToRoleCommand;
import com.codefinity.microcontinuum.identityaccess.application.command.ProvisionRoleCommand;
import com.codefinity.microcontinuum.identityaccess.domain.model.access.Role;
import com.codefinity.microcontinuum.identityaccess.domain.model.access.RoleRepository;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.GroupMemberService;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.GroupRepository;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.Tenant;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.TenantId;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.TenantRepository;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.User;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.UserRepository;

public class AccessApplicationService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    private UserRepository userRepository;

    public AccessApplicationService() {
        super();
    }

    //@Transactional
    public void assignUserToRole(AssignUserToRoleCommand aCommand) {

        TenantId tenantId = new TenantId(aCommand.getTenantId());

        User user =
                this.userRepository()
                    .userWithUsername(
                            tenantId,
                            aCommand.getUsername());

        if (user != null) {
            Role role =
                    this.roleRepository()
                        .roleNamed(
                                tenantId,
                                aCommand.getRoleName());

            if (role != null) {
                role.assignUser(user);
            }
        }
    }

    //@Transactional(readOnly=true)
    public boolean isUserInRole(
            String aTenantId,
            String aUsername,
            String aRoleName) {

        User user = this.userInRole(aTenantId, aUsername, aRoleName);

        return user != null;
    }

    //@Transactional
    public void provisionRole(ProvisionRoleCommand aCommand) {

        TenantId tenantId = new TenantId(aCommand.getTenantId());

        Tenant tenant = this.tenantRepository().tenantOfId(tenantId);

        Role role =
                tenant.provisionRole(
                        aCommand.getRoleName(),
                        aCommand.getDescription(),
                        aCommand.isSupportsNesting());

        this.roleRepository().add(role);
    }

    //@Transactional(readOnly=true)
    public User userInRole(
            String aTenantId,
            String aUsername,
            String aRoleName) {

        User userInRole = null;

        TenantId tenantId = new TenantId(aTenantId);

        User user =
                this.userRepository()
                    .userWithUsername(
                            tenantId,
                            aUsername);

        if (user != null) {
            Role role =
                    this.roleRepository()
                        .roleNamed(tenantId, aRoleName);

            if (role != null) {
                GroupMemberService groupMemberService =
                        new GroupMemberService(
                                this.userRepository(),
                                this.groupRepository());

                if (role.isInRole(user, groupMemberService)) {
                    userInRole = user;
                }
            }
        }

        return userInRole;
    }

    private GroupRepository groupRepository() {
        return this.groupRepository;
    }

    private RoleRepository roleRepository() {
        return this.roleRepository;
    }

    private TenantRepository tenantRepository() {
        return this.tenantRepository;
    }

    private UserRepository userRepository() {
        return this.userRepository;
    }
}
