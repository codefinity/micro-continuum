/*package com.codefinity.microcontinuum.common.port.adapter.persistance.hibernate;

import org.hibernate.Session;

import com.codefinity.microcontinuum.common.spring.SpringHibernateSessionProvider;

public abstract class AbstractHibernateSession {

    private Session session;
    private SpringHibernateSessionProvider sessionProvider;

    protected AbstractHibernateSession() {
        super();
    }

    protected AbstractHibernateSession(Session aSession) {
        this();

        this.setSession(aSession);
    }

    protected Session session() {
        Session actualSession = this.session;

        if (actualSession == null) {
            if (this.sessionProvider == null) {
                throw new IllegalStateException("Requires either a Session or SpringHibernateSessionProvider.");
            }

            actualSession = this.sessionProvider.session();

            // This is not a lazy creation and should not be set on
            // this.session. Setting the session instance assumes that
            // you have used the single argument constructor for a single
            // use. If actualSession is set by the sessionProvider then
            // this instance is for use only by the current thread and
            // must not be retained for subsequent requests.
        }

        return actualSession;
    }

    protected void setSession(Session aSession) {
        this.session = aSession;
    }

    public void setSessionProvider(SpringHibernateSessionProvider aSessionProvider) {
        this.sessionProvider = aSessionProvider;
    }
}
*/