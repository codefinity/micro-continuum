package com.codefinity.microcontinuum.common.port.adapter.persistance.eventsourcing.leveldb;

public class LoggedJournalEntry {

    private int currentMetadataIndex;
    private long journalSequence;
    private String referenceKey;
    private String value;

    public LoggedJournalEntry(
            long aJournalSequence,
            String aReferenceKey,
            String aValue) {

        super();

        this.setCurrentMetadataIndex(0);
        this.setJournalSequence(aJournalSequence);
        this.setReferenceKey(aReferenceKey);
        this.setValue(aValue);
    }

    public void discardNextMetadataValue() {
        this.nextMetadataValue();
    }

    public long journalSequence() {
        return this.journalSequence;
    }

    public String nextMetadataValue() {
        String metadataValue = null;

        String value = this.value();

        int nextIndex =
                value.indexOf(
                        LevelDBJournal.ES_METADATA_DELIMITER,
                        0);

        if (nextIndex != -1) {
            metadataValue = value.substring(0, nextIndex);

            this.setCurrentMetadataIndex(nextIndex + 1);
        }

        return metadataValue;
    }

    public String referenceKey() {
        return this.referenceKey;
    }

    public String value() {
        int index = this.currentMetadataIndex();

        this.setValue(this.value.substring(index));

        this.setCurrentMetadataIndex(0);

        return this.value;
    }

    private int currentMetadataIndex() {
        return this.currentMetadataIndex;
    }

    private void setCurrentMetadataIndex(int anIndex) {
        this.currentMetadataIndex = anIndex;
    }

    private void setJournalSequence(long aJournalSequence) {
        this.journalSequence = aJournalSequence;
    }

    private void setReferenceKey(String aReferenceKey) {
        this.referenceKey = aReferenceKey;
    }

    private void setValue(String aValue) {
        this.value = aValue;
    }
}
