package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.xf */
/* loaded from: classes8.dex */
public final class C8238xf extends Table {

    /* renamed from: com.huawei.openalliance.ad.xf$a */
    public static final class a extends BaseVector {
        /* renamed from: a */
        public a m51437a(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        /* renamed from: a */
        public C8238xf m51438a(int i10) {
            return m51439a(new C8238xf(), i10);
        }

        /* renamed from: a */
        public C8238xf m51439a(C8238xf c8238xf, int i10) {
            return c8238xf.m51435b(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    /* renamed from: a */
    public String m51433a() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: b */
    public C8238xf m51435b(int i10, ByteBuffer byteBuffer) {
        m51434a(i10, byteBuffer);
        return this;
    }

    /* renamed from: a */
    public void m51434a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    /* renamed from: b */
    public String m51436b() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }
}
