/*package com.codefinity.microcontinuum.common.domain.model.process;

import java.util.Date;

public interface Process {

    public enum ProcessCompletionType {
        NotCompleted,
        CompletedNormally,
        TimedOut
    }

    public long allowableDuration();

    public boolean canTimeout();

    public long currentDuration();

    public String description();

    public boolean didProcessingComplete();

    public void informTimeout(Date aTimedOutDate);

    public boolean isCompleted();

    public boolean isTimedOut();

    public boolean notCompleted();

    public ProcessCompletionType processCompletionType();

    public ProcessId processId();

    public Date startTime();

    public TimeConstrainedProcessTracker timeConstrainedProcessTracker();

    public Date timedOutDate();

    public long totalAllowableDuration();

    public int totalRetriesPermitted();
}
*/