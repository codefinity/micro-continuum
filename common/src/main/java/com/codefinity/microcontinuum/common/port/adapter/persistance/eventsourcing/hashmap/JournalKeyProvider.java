package com.codefinity.microcontinuum.common.port.adapter.persistance.eventsourcing.hashmap;

public class JournalKeyProvider {

    protected static final String ES_JOURNAL_PREFIX_KEY = "ES_J:";
    protected static final String ES_KEY_DELIMITER = ":";
    protected static final String ES_REFERENCE_PREFIX_KEY = "ES_R:";

    public String compositeReferenceKeyFrom(String aKeyPart1, String aKeyPart2) {
        String referenceKey =
                this.referenceKeyFrom(
                        aKeyPart1
                        + ES_KEY_DELIMITER
                        + aKeyPart2);

        return referenceKey;
    }

    public String firstKeyPart(String aCompositeKey) {
        return aCompositeKey.substring(0, aCompositeKey.indexOf(ES_KEY_DELIMITER));
    }

    public String lastKeyPart(String aCompositeKey) {
        return aCompositeKey.substring(aCompositeKey.lastIndexOf(ES_KEY_DELIMITER) + 1);
    }

    public String nextReferenceKey() {
        throw new UnsupportedOperationException("Must be implemented by subclass.");
    }

    public String primaryResourceName() {
        throw new UnsupportedOperationException("Must be implemented by subclass.");
    }

    public String referenceKeyFrom(String aKey) {
        String referenceKey =
                ES_REFERENCE_PREFIX_KEY
                + aKey;

        return referenceKey;
    }
}
