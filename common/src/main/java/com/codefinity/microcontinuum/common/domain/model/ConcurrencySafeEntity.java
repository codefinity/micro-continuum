package com.codefinity.microcontinuum.common.domain.model;

public class ConcurrencySafeEntity extends Entity {

    private static final long serialVersionUID = 1L;

    private int concurrencyVersion;

    protected ConcurrencySafeEntity() {
        super();
    }

    public int concurrencyVersion() {
        return this.concurrencyVersion;
    }

    public void setConcurrencyVersion(int aVersion) {
        this.failWhenConcurrencyViolation(aVersion);
        this.concurrencyVersion = aVersion;
    }

    public void failWhenConcurrencyViolation(int aVersion) {
        if (aVersion != this.concurrencyVersion()) {
            throw new IllegalStateException(
                    "Concurrency Violation: Stale data detected. Entity was already modified.");
        }
    }
}
