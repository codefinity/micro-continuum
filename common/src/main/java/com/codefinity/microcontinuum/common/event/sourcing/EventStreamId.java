package com.codefinity.microcontinuum.common.event.sourcing;

public final class EventStreamId {

    private String streamName;
    private int streamVersion;

    public EventStreamId(String aStreamName) {
        this(aStreamName, 1);
    }

    public EventStreamId(String aStreamName, int aStreamVersion) {
        super();

        this.setStreamName(aStreamName);
        this.setStreamVersion(aStreamVersion);
    }

    public EventStreamId(String aStreamNameSegment1, String aStreamNameSegment2) {
        this(aStreamNameSegment1, aStreamNameSegment2, 1);
    }

    public EventStreamId(String aStreamNameSegment1, String aStreamNameSegment2, int aStreamVersion) {
        this(aStreamNameSegment1 + ":" + aStreamNameSegment2, aStreamVersion);
    }

    public String streamName() {
        return this.streamName;
    }

    public int streamVersion() {
        return this.streamVersion;
    }

    public EventStreamId withStreamVersion(int aStreamVersion) {
        return new EventStreamId(this.streamName(), aStreamVersion);
    }

    private void setStreamName(String aStreamName) {
        this.streamName = aStreamName;
    }

    private void setStreamVersion(int aStreamVersion) {
        this.streamVersion = aStreamVersion;
    }
}
