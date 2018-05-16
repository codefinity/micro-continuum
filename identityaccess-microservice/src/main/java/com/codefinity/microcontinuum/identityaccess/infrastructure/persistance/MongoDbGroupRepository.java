package com.codefinity.microcontinuum.identityaccess.infrastructure.persistance;
/*package com.codefinity.microcontinuum.identityaccess.infrastructure.persistance;

import java.util.Collection;

import javax.management.Query;
import javax.validation.ConstraintViolationException;

import com.codefinity.microcontinuum.common.port.adapter.persistance.hibernate.AbstractHibernateSession;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.Group;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.GroupRepository;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.TenantId;

public class HibernateGroupRepository
        extends AbstractHibernateSession
        implements GroupRepository {

    public HibernateGroupRepository() {
        super();
    }

    @Override
    public void add(Group aGroup) {
        try {
            this.session().saveOrUpdate(aGroup);
        } catch (ConstraintViolationException e) {
            throw new IllegalStateException("Group is not unique.", e);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Group> allGroups(TenantId aTenantId) {
        Query query = this.session().createQuery(
                "from com.saasovation.identityaccess.domain.model.identity.Group as _obj_ "
                + "where _obj_.tenantId = ? "
                  + "and _obj_.name not like '" + Group.ROLE_GROUP_PREFIX + "%'");

        query.setParameter(0, aTenantId);

        return (Collection<Group>) query.list();
    	
    	return null;
    }

    @Override
    public Group groupNamed(TenantId aTenantId, String aName) {
        if (aName.startsWith(Group.ROLE_GROUP_PREFIX)) {
            throw new IllegalArgumentException("May not find internal groups.");
        }

        Query query = this.session().createQuery(
                "from com.saasovation.identityaccess.domain.model.identity.Group as _obj_ "
                + "where _obj_.tenantId = ? "
                  + "and _obj_.name = ?");

        query.setParameter(0, aTenantId);
        query.setParameter(1, aName, org.hibernate.Hibernate.STRING);

        return (Group) query.uniqueResult();
    	
    	return null;
    }

    @Override
    public void remove(Group aGroup) {
        this.session().delete(aGroup);
    }
}
*/