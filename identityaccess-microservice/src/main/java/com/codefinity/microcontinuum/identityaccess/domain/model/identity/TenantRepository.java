package com.codefinity.microcontinuum.identityaccess.domain.model.identity;

public interface TenantRepository {

    public void add(Tenant aTenant);

    public TenantId nextIdentity();

    public void remove(Tenant aTenant);

    public Tenant tenantNamed(String aName);

    public Tenant tenantOfId(TenantId aTenantId);
}
