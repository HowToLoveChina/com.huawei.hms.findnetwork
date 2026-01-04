package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.wo */
/* loaded from: classes8.dex */
public final class C8220wo extends Table {
    /* renamed from: a */
    public String m51235a() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: b */
    public int m51237b() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: a */
    public void m51236a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    /* renamed from: b */
    public C8220wo m51238b(int i10, ByteBuffer byteBuffer) {
        m51236a(i10, byteBuffer);
        return this;
    }
}
