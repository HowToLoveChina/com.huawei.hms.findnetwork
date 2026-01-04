package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.wt */
/* loaded from: classes8.dex */
public final class C8225wt extends Table {
    /* renamed from: a */
    public C8224ws m51265a(C8224ws c8224ws) {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return c8224ws.m51262b(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    /* renamed from: b */
    public int m51268b() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: c */
    public int m51270c() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: d */
    public C8224ws m51271d() {
        return m51265a(new C8224ws());
    }

    /* renamed from: a */
    public String m51266a() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: b */
    public C8225wt m51269b(int i10, ByteBuffer byteBuffer) {
        m51267a(i10, byteBuffer);
        return this;
    }

    /* renamed from: a */
    public void m51267a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }
}
