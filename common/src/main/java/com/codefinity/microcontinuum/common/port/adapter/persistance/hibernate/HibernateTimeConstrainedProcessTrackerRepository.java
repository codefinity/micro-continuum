package com.codefinity.microcontinuum.common.port.adapter.persistance.hibernate;

import java.util.Collection;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.exception.ConstraintViolationException;

import com.codefinity.microcontinuum.common.domain.model.process.ProcessId;
import com.codefinity.microcontinuum.common.domain.model.process.TimeConstrainedProcessTracker;
import com.codefinity.microcontinuum.common.domain.model.process.TimeConstrainedProcessTrackerRepository;
import com.codefinity.microcontinuum.common.persistance.PersistenceManagerProvider;

public class HibernateTimeConstrainedProcessTrackerRepository
    extends AbstractHibernateSession
    implements TimeConstrainedProcessTrackerRepository {

    public HibernateTimeConstrainedProcessTrackerRepository() {
        super();
    }

    public HibernateTimeConstrainedProcessTrackerRepository(
            PersistenceManagerProvider aPersistenceManagerProvider) {
        this();

        if (!aPersistenceManagerProvider.hasHibernateSession()) {
            throw new IllegalArgumentException("The PersistenceManagerProvider must have a Hibernate Session.");
        }

        this.setSession(aPersistenceManagerProvider.hibernateSession());
    }

    @Override
    public void add(TimeConstrainedProcessTracker aTimeConstrainedProcessTracker) {
        this.save(aTimeConstrainedProcessTracker);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<TimeConstrainedProcessTracker> allTimedOut() {
        Query query =
                this.session().createQuery(
                    "from TimeConstrainedProcessTracker as tcpt "
                        + "where tcpt.completed = false and"
                        + " tcpt.processInformedOfTimeout = false and"
                        + " tcpt.timeoutOccursOn <= ?");

        query.setParameter(0, (new Date()).getTime());

        return (Collection<TimeConstrainedProcessTracker>) query.uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<TimeConstrainedProcessTracker> allTimedOutOf(String aTenantId) {
        Query query =
                this.session().createQuery(
                    "from TimeConstrainedProcessTracker as tcpt "
                        + "where tcpt.tenantId = ?"
                        + " tcpt.completed = false and"
                        + " tcpt.processInformedOfTimeout = false and"
                        + " tcpt.timeoutOccursOn <= ?");

        query.setParameter(0, aTenantId);
        query.setParameter(1, (new Date()).getTime());

        return (Collection<TimeConstrainedProcessTracker>) query.uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<TimeConstrainedProcessTracker> allTrackers(String aTenantId) {
        Query query =
                this.session().createQuery(
                    "from TimeConstrainedProcessTracker as tcpt where tcpt.tenantId = ?");

        query.setParameter(0, aTenantId);

        return (Collection<TimeConstrainedProcessTracker>) query.uniqueResult();
    }

    @Override
    public void save(TimeConstrainedProcessTracker aTimeConstrainedProcessTracker) {
        try {
            this.session().saveOrUpdate(aTimeConstrainedProcessTracker);
        } catch (ConstraintViolationException e) {
            throw new IllegalStateException("Either TimeConstrainedProcessTracker is not unique or another constraint has been violated.", e);
        }
    }

    @Override
    public TimeConstrainedProcessTracker trackerOfProcessId(String aTenantId, ProcessId aProcessId) {
        Query query =
                this.session().createQuery(
                    "from TimeConstrainedProcessTracker as tcpt "
                    + "where tcpt.tenantId = ? and tcpt.processId = ?");

        query.setParameter(0, aTenantId);
        query.setParameter(1, aProcessId);

        return (TimeConstrainedProcessTracker) query.uniqueResult();
    }
}
