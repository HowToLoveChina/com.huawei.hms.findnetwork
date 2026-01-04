package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.xi */
/* loaded from: classes8.dex */
public final class C8241xi extends Table {
    /* renamed from: a */
    public String m51469a() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: b */
    public int m51471b() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: a */
    public void m51470a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    /* renamed from: b */
    public C8241xi m51472b(int i10, ByteBuffer byteBuffer) {
        m51470a(i10, byteBuffer);
        return this;
    }
}
