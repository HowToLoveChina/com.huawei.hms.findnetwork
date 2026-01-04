package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.wg */
/* loaded from: classes8.dex */
public final class C8212wg extends Table {

    /* renamed from: com.huawei.openalliance.ad.wg$a */
    public static final class a extends BaseVector {
        /* renamed from: a */
        public a m51052a(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        /* renamed from: a */
        public C8212wg m51053a(int i10) {
            return m51054a(new C8212wg(), i10);
        }

        /* renamed from: a */
        public C8212wg m51054a(C8212wg c8212wg, int i10) {
            return c8212wg.m51050b(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    /* renamed from: a */
    public String m51048a() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: b */
    public C8212wg m51050b(int i10, ByteBuffer byteBuffer) {
        m51049a(i10, byteBuffer);
        return this;
    }

    /* renamed from: a */
    public void m51049a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    /* renamed from: b */
    public String m51051b() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }
}
