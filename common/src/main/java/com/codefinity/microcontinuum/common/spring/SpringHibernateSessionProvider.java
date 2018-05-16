/*package com.codefinity.microcontinuum.common.spring;

import java.sql.Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.engine.SessionFactoryImplementor;

public class SpringHibernateSessionProvider {

    private static final ThreadLocal<Session> sessionHolder = new ThreadLocal<Session>();

    private SessionFactory sessionFactory;

    public SpringHibernateSessionProvider() {
        super();
    }

    public Connection connection() {
        Connection connection = null;

        try {
            SessionFactoryImplementor sfi =
                   (SessionFactoryImplementor) this.sessionFactory;

            ConnectionProvider connectionProvider = sfi.getConnectionProvider();

            connection = connectionProvider.getConnection();

        } catch (Exception e) {
            throw new IllegalStateException(
                    "Cannot get connection from session factory because: "
                    + e.getMessage(),
                    e);
        }

        return connection;
    }

    public Session session() {
        Session threadBoundSession = sessionHolder.get();

        if (threadBoundSession == null) {
            threadBoundSession = this.sessionFactory.openSession();
            sessionHolder.set(threadBoundSession);
        }

        return threadBoundSession;
    }

    public void setSessionFactory(SessionFactory aSessionFactory) {
        this.sessionFactory = aSessionFactory;
    }
}
*/