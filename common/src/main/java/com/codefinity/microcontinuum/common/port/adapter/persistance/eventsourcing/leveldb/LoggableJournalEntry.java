package com.codefinity.microcontinuum.common.port.adapter.persistance.eventsourcing.leveldb;

public class LoggableJournalEntry {

    private String primaryResourceName;
    private String referenceKey;
    private String value;

    public LoggableJournalEntry(
            String aValue,
            String aReferenceKey,
            String aPrimaryResourceName) {

        super();

        this.setPrimaryResourceName(aPrimaryResourceName);
        this.setReferenceKey(aReferenceKey);
        this.setValue(aValue);
    }

    public String primaryResourceName() {
        return this.primaryResourceName;
    }

    public String referenceKey() {
        return this.referenceKey;
    }

    public String value() {
        return this.value;
    }

    private void setPrimaryResourceName(String aPrimaryResourceName) {
        this.primaryResourceName = aPrimaryResourceName;
    }

    private void setReferenceKey(String aReferenceKey) {
        this.referenceKey = aReferenceKey;
    }

    private void setValue(String aValue) {
        this.value = aValue;
    }
}
