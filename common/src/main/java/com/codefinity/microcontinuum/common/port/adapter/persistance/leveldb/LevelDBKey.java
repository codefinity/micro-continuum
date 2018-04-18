package com.codefinity.microcontinuum.common.port.adapter.persistance.leveldb;

import java.util.ArrayList;
import java.util.List;

public class LevelDBKey {

    private String cachedKey;
    private byte[] cachedKeyBytes;
    private String category;
    private int numberOfSegments;
    private LevelDBKey primaryKey;
    private List<String> segments;

    public LevelDBKey(String aCategory, int aNumberOfSegments) {
        this(null, aCategory, aNumberOfSegments);
    }

    public LevelDBKey(String aCategory, String... aSegments) {
        this(null, aCategory, aSegments.length);

        for (String segment : aSegments) {
            this.specifyNextSegment(segment);
        }
    }

    public LevelDBKey(LevelDBKey aPrimaryKey, String aCategory, String... aSegments) {
        this(aPrimaryKey, aCategory, aSegments.length);

        for (String segment : aSegments) {
            this.specifyNextSegment(segment);
        }
    }

    public LevelDBKey(LevelDBKey aPrimaryKey, String aCategory, int aNumberOfSegments) {
        super();

        this.setCategory(aCategory);
        this.setNumberOfSegments(aNumberOfSegments);
        this.setPrimaryKey(aPrimaryKey);
        this.setSegments(new ArrayList<String>(aNumberOfSegments));
    }

    public String key() {
        if (this.cachedKey == null) {
            StringBuffer buf = new StringBuffer(this.category());

            for (String segment : this.segments()) {
                buf.append(':').append(segment);
            }

            this.cachedKey = buf.toString();
        }

        return this.cachedKey;
    }

    public byte[] keyAsBytes() {
        if (this.cachedKeyBytes == null) {
            this.cachedKeyBytes = this.key().getBytes();
        }

        return this.cachedKeyBytes;
    }

    public String primaryKeyValue() {
        if (this.primaryKey() == null) {
            throw new IllegalStateException("Unknown primary key.");
        }

        return this.primaryKey().key();
    }

    public void specifyNextSegment(String aSegment) {
        if (this.segments().size() == this.numberOfSegments()) {
            throw new IllegalStateException("Specified too many segments.");
        }

        this.cachedKey = null;
        this.cachedKeyBytes = null;

        this.segments().add(aSegment);
    }

    private String category() {
        return this.category;
    }

    private void setCategory(String aCategory) {
        if (aCategory == null || aCategory.trim().isEmpty()) {
            throw new IllegalArgumentException("The category must be provided.");
        }

        this.category = aCategory;
    }

    private int numberOfSegments() {
        return this.numberOfSegments;
    }

    private void setNumberOfSegments(int aNumberOfSegments) {
        this.numberOfSegments = aNumberOfSegments;
    }

    private LevelDBKey primaryKey() {
        return this.primaryKey;
    }

    private void setPrimaryKey(LevelDBKey aPrimaryKey) {
        this.primaryKey = aPrimaryKey;
    }

    private List<String> segments() {
        return this.segments;
    }

    private void setSegments(List<String> aSegments) {
        this.segments = aSegments;
    }
}
