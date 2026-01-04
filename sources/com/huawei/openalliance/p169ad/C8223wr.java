package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.wr */
/* loaded from: classes8.dex */
public final class C8223wr extends Table {
    /* renamed from: a */
    public int m51255a() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: b */
    public long m51257b() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    /* renamed from: a */
    public void m51256a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    /* renamed from: b */
    public C8223wr m51258b(int i10, ByteBuffer byteBuffer) {
        m51256a(i10, byteBuffer);
        return this;
    }
}
