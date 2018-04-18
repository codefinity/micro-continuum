package com.codefinity.microcontinuum.identityaccess.infrastructure.persistance;

import java.util.Collection;

import javax.management.Query;
import javax.validation.ConstraintViolationException;

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties.Hibernate;

import com.codefinity.microcontinuum.common.port.adapter.persistance.hibernate.AbstractHibernateSession;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.TenantId;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.User;
import com.codefinity.microcontinuum.identityaccess.domain.model.identity.UserRepository;

public class HibernateUserRepository
        extends AbstractHibernateSession
        implements UserRepository {

    public HibernateUserRepository() {
        super();
    }

    @Override
    public void add(User aUser) {
        try {
            this.session().saveOrUpdate(aUser);
        } catch (ConstraintViolationException e) {
            throw new IllegalStateException("User is not unique.", e);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<User> allSimilarlyNamedUsers(
            TenantId aTenantId,
            String aFirstNamePrefix,
            String aLastNamePrefix) {

        /*if (aFirstNamePrefix.endsWith("%") || aLastNamePrefix.endsWith("%")) {
            throw new IllegalArgumentException("Name prefixes must not include %.");
        }

        Query query = this.session().createQuery(
                "from com.saasovation.identityaccess.domain.model.identity.User as _obj_ "
                + "where _obj_.tenantId = ? "
                +   "and _obj_.person.name.firstName like ? "
                +   "and _obj_.person.name.lastName like ?");

        query.setParameter(0, aTenantId);
        query.setParameter(1, aFirstNamePrefix + "%", Hibernate.STRING);
        query.setParameter(2, aLastNamePrefix + "%", Hibernate.STRING);

        return query.list();*/
    	
    	return null;
    }

    @Override
    public void remove(User aUser) {
        this.session().delete(aUser);
    }

    @Override
    public User userFromAuthenticCredentials(
            TenantId aTenantId,
            String aUsername,
            String anEncryptedPassword) {

        /*Query query = this.session().createQuery(
                "from com.saasovation.identityaccess.domain.model.identity.User as _obj_ "
                + "where _obj_.tenantId = ? "
                  + "and _obj_.username = ? "
                  + "and _obj_.password = ?");

        query.setParameter(0, aTenantId);
        query.setParameter(1, aUsername, Hibernate.STRING);
        query.setParameter(2, anEncryptedPassword, Hibernate.STRING);

        return (User) query.uniqueResult();*/
    		
    	return null;
    }

    @Override
    public User userWithUsername(
            TenantId aTenantId,
            String aUsername) {

        /*Query query = this.session().createQuery(
                "from com.saasovation.identityaccess.domain.model.identity.User as _obj_ "
                + "where _obj_.tenantId = ? "
                  + "and _obj_.username = ?");

        query.setParameter(0, aTenantId);
        query.setParameter(1, aUsername, Hibernate.STRING);

        return (User) query.uniqueResult();*/
    	
    	return null;
    }
}
