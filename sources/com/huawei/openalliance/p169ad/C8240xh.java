package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.xh */
/* loaded from: classes8.dex */
public final class C8240xh extends Table {
    /* renamed from: a */
    public int m51465a() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: b */
    public C8240xh m51467b(int i10, ByteBuffer byteBuffer) {
        m51466a(i10, byteBuffer);
        return this;
    }

    /* renamed from: a */
    public void m51466a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    /* renamed from: b */
    public String m51468b() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }
}
