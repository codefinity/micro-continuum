package com.codefinity.microcontinuum.identityaccess.infrastructure.persistance;
/*package com.codefinity.microcontinuum.identityaccess.infrastructure.persistance;

import java.util.UUID;

import javax.management.Query;
import javax.validation.ConstraintViolationException;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties.Hibernate;

import com.codefinity.microcontinuum.common.port.adapter.persistance.hibernate.AbstractHibernateSession;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.Tenant;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.TenantId;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.TenantRepository;

public class HibernateTenantRepository
        extends AbstractHibernateSession
        implements TenantRepository {

    public HibernateTenantRepository() {
        super();
    }

    @Override
    public void add(Tenant aTenant) {
        try {
            this.session().saveOrUpdate(aTenant);
        } catch (ConstraintViolationException e) {
            throw new IllegalStateException("Tenant is not unique.", e);
        }
    }

    @Override
    public TenantId nextIdentity() {
        return new TenantId(UUID.randomUUID().toString().toUpperCase());
    }

    @Override
    public void remove(Tenant aTenant) {
        this.session().delete(aTenant);
    }

    @Override
    public Tenant tenantNamed(String aName) {
        Query query = this.session().createQuery(
                "from com.saasovation.identityaccess.domain.model.identity.Tenant as _obj_ "
                + "where _obj_.name = ?");

        query.setParameter(0, aName, Hibernate.STRING);

        return (Tenant) query.uniqueResult();
    	
    	return null;
    }

    @Override
    public Tenant tenantOfId(TenantId aTenantId) {
        Query query = this.session().createQuery(
                "from com.saasovation.identityaccess.domain.model.identity.Tenant as _obj_ "
                + "where _obj_.tenantId = ?");

        query.setParameter(0, aTenantId);

        return (Tenant) query.uniqueResult();
    	
    	return null;
    }
}
*/