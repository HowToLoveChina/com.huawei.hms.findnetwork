package com.google.flatbuffers;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class LongVector extends BaseVector {
    public LongVector __assign(int i10, ByteBuffer byteBuffer) {
        __reset(i10, 8, byteBuffer);
        return this;
    }

    public long get(int i10) {
        return this.f9443bb.getLong(__element(i10));
    }
}
