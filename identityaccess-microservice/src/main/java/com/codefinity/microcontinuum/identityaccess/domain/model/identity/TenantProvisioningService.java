package com.codefinity.microcontinuum.identityaccess.domain.model.identity;

import com.codefinity.microcontinuum.common.domain.model.DomainEventPublisher;
import com.codefinity.microcontinuum.identityaccess.domain.model.DomainRegistry;
import com.codefinity.microcontinuum.identityaccess.domain.model.access.Role;
import com.codefinity.microcontinuum.identityaccess.domain.model.access.RoleRepository;

public class TenantProvisioningService {

    private RoleRepository roleRepository;
    private TenantRepository tenantRepository;
    private UserRepository userRepository;

    public TenantProvisioningService(
            TenantRepository aTenantRepository,
            UserRepository aUserRepository,
            RoleRepository aRoleRepository) {

        super();

        this.roleRepository = aRoleRepository;
        this.tenantRepository = aTenantRepository;
        this.userRepository = aUserRepository;
    }

    public Tenant provisionTenant(
            String aTenantName,
            String aTenantDescription,
            FullName anAdministorName,
            EmailAddress anEmailAddress,
            PostalAddress aPostalAddress,
            Telephone aPrimaryTelephone,
            Telephone aSecondaryTelephone) {

        try {
            Tenant tenant = new Tenant(
                        this.tenantRepository().nextIdentity(),
                        aTenantName,
                        aTenantDescription,
                        true); // must be active to register admin

            this.tenantRepository().add(tenant);

            this.registerAdministratorFor(
                    tenant,
                    anAdministorName,
                    anEmailAddress,
                    aPostalAddress,
                    aPrimaryTelephone,
                    aSecondaryTelephone);

            DomainEventPublisher
                .instance()
                .publish(new TenantProvisioned(
                        tenant.tenantId()));

            return tenant;

        } catch (Throwable t) {
            throw new IllegalStateException(
                    "Cannot provision tenant because: "
                    + t.getMessage());
        }
    }

    private void registerAdministratorFor(
            Tenant aTenant,
            FullName anAdministorName,
            EmailAddress anEmailAddress,
            PostalAddress aPostalAddress,
            Telephone aPrimaryTelephone,
            Telephone aSecondaryTelephone) {

        RegistrationInvitation invitation =
                aTenant.offerRegistrationInvitation("init").openEnded();

        String strongPassword =
                DomainRegistry
                    .passwordService()
                    .generateStrongPassword();

        User admin =
            aTenant.registerUser(
                    invitation.invitationId(),
                    "admin",
                    strongPassword,
                    Enablement.indefiniteEnablement(),
                    new Person(
                            aTenant.tenantId(),
                            anAdministorName,
                            new ContactInformation(
                                    anEmailAddress,
                                    aPostalAddress,
                                    aPrimaryTelephone,
                                    aSecondaryTelephone)));

        aTenant.withdrawInvitation(invitation.invitationId());

        this.userRepository().add(admin);

        Role adminRole =
            aTenant.provisionRole(
                    "Administrator",
                    "Default " + aTenant.name() + " administrator.");

        adminRole.assignUser(admin);

        this.roleRepository().add(adminRole);

        DomainEventPublisher.instance().publish(
                new TenantAdministratorRegistered(
                        aTenant.tenantId(),
                        aTenant.name(),
                        anAdministorName,
                        anEmailAddress,
                        admin.username(),
                        strongPassword));
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
