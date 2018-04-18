package com.codefinity.microcontinuum.identityaccess.infrastructure.persistance;

import java.util.Collection;

import javax.management.Query;
import javax.validation.ConstraintViolationException;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties.Hibernate;

import com.codefinity.microcontinuum.common.port.adapter.persistance.hibernate.AbstractHibernateSession;
import com.codefinity.microcontinuum.identityaccess.domain.model.access.Role;
import com.codefinity.microcontinuum.identityaccess.domain.model.access.RoleRepository;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.TenantId;

public class HibernateRoleRepository
        extends AbstractHibernateSession
        implements RoleRepository {

    public HibernateRoleRepository() {
        super();
    }

    @Override
    public void add(Role aRole) {
        try {
            this.session().saveOrUpdate(aRole);
        } catch (ConstraintViolationException e) {
            throw new IllegalStateException("Role is not unique.", e);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Role> allRoles(TenantId aTenantId) {
        /*Query query = this.session().createQuery(
                "from com.saasovation.identityaccess.domain.model.access.Role as _obj_ "
                + "where _obj_.tenantId = ?");

        query.setParameter(0, aTenantId);

        return (Collection<Role>) query.list();*/
    	
    	return null;
    }

    @Override
    public void remove(Role aRole) {
        this.session().delete(aRole);
    }

    @Override
    public Role roleNamed(TenantId aTenantId, String aRoleName) {
        /*Query query = this.session().createQuery(
                "from com.saasovation.identityaccess.domain.model.access.Role as _obj_ "
                + "where _obj_.tenantId = ? "
                  + "and _obj_.name = ?");

        query.setParameter(0, aTenantId);
        query.setParameter(1, aRoleName, Hibernate.STRING);

        return (Role) query.uniqueResult();*/
    	
    	return null;
    }
}
