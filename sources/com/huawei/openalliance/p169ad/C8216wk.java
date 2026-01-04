package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.wk */
/* loaded from: classes8.dex */
public final class C8216wk extends Table {
    /* renamed from: a */
    public long m51135a() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    /* renamed from: b */
    public C8216wk m51137b(int i10, ByteBuffer byteBuffer) {
        m51136a(i10, byteBuffer);
        return this;
    }

    /* renamed from: c */
    public long m51139c() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    /* renamed from: d */
    public String m51140d() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: e */
    public String m51141e() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: a */
    public void m51136a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    /* renamed from: b */
    public String m51138b() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }
}
