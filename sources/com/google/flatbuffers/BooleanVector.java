package com.google.flatbuffers;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class BooleanVector extends BaseVector {
    public BooleanVector __assign(int i10, ByteBuffer byteBuffer) {
        __reset(i10, 1, byteBuffer);
        return this;
    }

    public boolean get(int i10) {
        return this.f9443bb.get(__element(i10)) != 0;
    }
}
