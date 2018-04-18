package com.codefinity.microcontinuum.common.media.canonical;

public enum EncodingMarker {

    Begin(0x81),
    Key(0xa7),
    Null(0xc0),
    True(0xc1),
    False(0xc2),
    Int8(0xc3),
    Int16(0xc4),
    Int32(0xc5),
    Int64(0xc6),
    Array(0xc7),
    Map(0xc8),

    Undefined(0xcf);

    private int marker;

    EncodingMarker(int aMarker) {
        this.marker = aMarker;
    }

    public byte marker() {
        return (byte) this.marker;
    }
}
