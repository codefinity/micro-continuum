package com.codefinity.microcontinuum.identityaccess.domain.model;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.codefinity.microcontinuum.identityaccess.domain.model.access.AuthorizationService;
import com.codefinity.microcontinuum.identityaccess.domain.model.access.RoleRepository;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.AuthenticationService;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.EncryptionService;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.GroupMemberService;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.GroupRepository;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.PasswordService;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.TenantProvisioningService;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.TenantRepository;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.UserRepository;

public class DomainRegistry implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static AuthenticationService authenticationService() {
        return (AuthenticationService) applicationContext.getBean("authenticationService");
    }

    public static AuthorizationService authorizationService() {
        return (AuthorizationService) applicationContext.getBean("authorizationService");
    }

    public static EncryptionService encryptionService() {
        return (EncryptionService) applicationContext.getBean("encryptionService");
    }

    public static GroupMemberService groupMemberService() {
        return (GroupMemberService) applicationContext.getBean("groupMemberService");
    }

    public static GroupRepository groupRepository() {
        return (GroupRepository) applicationContext.getBean("groupRepository");
    }

    public static PasswordService passwordService() {
        return (PasswordService) applicationContext.getBean("passwordService");
    }

    public static RoleRepository roleRepository() {
        return (RoleRepository) applicationContext.getBean("roleRepository");
    }

    public static TenantProvisioningService tenantProvisioningService() {
        return (TenantProvisioningService) applicationContext.getBean("tenantProvisioningService");
    }

    public static TenantRepository tenantRepository() {
        return (TenantRepository) applicationContext.getBean("tenantRepository");
    }

    public static UserRepository userRepository() {
        return (UserRepository) applicationContext.getBean("userRepository");
    }

    @Override
    public synchronized void setApplicationContext(
            ApplicationContext anApplicationContext)
    throws BeansException {

        if (DomainRegistry.applicationContext == null) {
            DomainRegistry.applicationContext = anApplicationContext;
        }
    }
}
