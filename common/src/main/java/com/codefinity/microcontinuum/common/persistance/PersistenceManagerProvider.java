package com.codefinity.microcontinuum.common.persistance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.codefinity.microcontinuum.common.spring.ApplicationContextProvider;

public class PersistenceManagerProvider {

    private Session hibernateSession;

    public static PersistenceManagerProvider forHibernateSessionNamed(
            String aHibernateSessionFactoryName) {

        SessionFactory sessionFactory = (SessionFactory)
                ApplicationContextProvider
                    .instance()
                    .applicationContext()
                    .getBean(aHibernateSessionFactoryName);

        return new PersistenceManagerProvider(sessionFactory.openSession());
    }

    public PersistenceManagerProvider(Session aHibernateSession) {
        super();

        this.setHibernateSession(aHibernateSession);
    }

    public Session hibernateSession() {
        return this.hibernateSession;
    }

    public boolean hasHibernateSession() {
        return this.hibernateSession() != null;
    }

    protected PersistenceManagerProvider() {
        super();
    }

    private void setHibernateSession(Session aHibernateSession) {
        this.hibernateSession = aHibernateSession;
    }
}
