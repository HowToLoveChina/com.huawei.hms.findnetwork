package com.google.flatbuffers;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class FloatVector extends BaseVector {
    public FloatVector __assign(int i10, ByteBuffer byteBuffer) {
        __reset(i10, 4, byteBuffer);
        return this;
    }

    public float get(int i10) {
        return this.f9443bb.getFloat(__element(i10));
    }
}
