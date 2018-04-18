package com.codefinity.microcontinuum.identityaccess.domain.model.access;

import com.codefinity.microcontinuum.common.AssertionConcern;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.GroupMemberService;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.GroupRepository;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.TenantId;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.User;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.UserRepository;

public class AuthorizationService extends AssertionConcern {

    private GroupRepository groupRepository;
    private RoleRepository roleRepository;
    private UserRepository userRepository;

    public AuthorizationService(
            UserRepository aUserRepository,
            GroupRepository aGroupRepository,
            RoleRepository aRoleRepository) {

        super();

        this.groupRepository = aGroupRepository;
        this.roleRepository = aRoleRepository;
        this.userRepository = aUserRepository;
    }

    public boolean isUserInRole(TenantId aTenantId, String aUsername, String aRoleName) {
        this.assertArgumentNotNull(aTenantId, "TenantId must not be null.");
        this.assertArgumentNotEmpty(aUsername, "Username must not be provided.");
        this.assertArgumentNotEmpty(aRoleName, "Role name must not be null.");

        User user = this.userRepository().userWithUsername(aTenantId, aUsername);

        return user == null ? false : this.isUserInRole(user, aRoleName);
    }

    public boolean isUserInRole(User aUser, String aRoleName) {
        this.assertArgumentNotNull(aUser, "User must not be null.");
        this.assertArgumentNotEmpty(aRoleName, "Role name must not be null.");

        boolean authorized = false;

        if (aUser.isEnabled()) {
            Role role = this.roleRepository().roleNamed(aUser.tenantId(), aRoleName);

            if (role != null) {
                GroupMemberService groupMemberService =
                        new GroupMemberService(
                                this.userRepository(),
                                this.groupRepository());

                authorized = role.isInRole(aUser, groupMemberService);
            }
        }

        return authorized;
    }

    private GroupRepository groupRepository() {
        return this.groupRepository;
    }

    private RoleRepository roleRepository() {
        return this.roleRepository;
    }

    private UserRepository userRepository() {
        return this.userRepository;
    }
}
