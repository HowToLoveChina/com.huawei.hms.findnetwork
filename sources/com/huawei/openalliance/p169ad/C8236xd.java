package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.xd */
/* loaded from: classes8.dex */
public final class C8236xd extends Table {

    /* renamed from: com.huawei.openalliance.ad.xd$a */
    public static final class a extends BaseVector {
        /* renamed from: a */
        public a m51424a(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        /* renamed from: a */
        public C8236xd m51425a(int i10) {
            return m51426a(new C8236xd(), i10);
        }

        /* renamed from: a */
        public C8236xd m51426a(C8236xd c8236xd, int i10) {
            return c8236xd.m51421b(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    /* renamed from: a */
    public long m51419a() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    /* renamed from: b */
    public C8236xd m51421b(int i10, ByteBuffer byteBuffer) {
        m51420a(i10, byteBuffer);
        return this;
    }

    /* renamed from: c */
    public int m51423c() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: a */
    public void m51420a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    /* renamed from: b */
    public String m51422b() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }
}
