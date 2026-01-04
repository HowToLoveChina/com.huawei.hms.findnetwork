package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.Table;
import com.huawei.openalliance.p169ad.C8235xc;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.xk */
/* loaded from: classes8.dex */
public final class C8243xk extends Table {
    /* renamed from: a */
    public C8235xc.a m51479a(C8235xc.a aVar) {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return aVar.m51415a(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: b */
    public C8243xk m51482b(int i10, ByteBuffer byteBuffer) {
        m51481a(i10, byteBuffer);
        return this;
    }

    /* renamed from: c */
    public C8235xc.a m51484c() {
        return m51479a(new C8235xc.a());
    }

    /* renamed from: d */
    public String m51485d() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: a */
    public String m51480a() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: b */
    public String m51483b() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: a */
    public void m51481a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }
}
