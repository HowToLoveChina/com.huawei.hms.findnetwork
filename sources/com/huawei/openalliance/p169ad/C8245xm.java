package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.xm */
/* loaded from: classes8.dex */
public final class C8245xm extends Table {

    /* renamed from: com.huawei.openalliance.ad.xm$a */
    public static final class a extends BaseVector {
        /* renamed from: a */
        public a m51506a(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        /* renamed from: a */
        public C8245xm m51507a(int i10) {
            return m51508a(new C8245xm(), i10);
        }

        /* renamed from: a */
        public C8245xm m51508a(C8245xm c8245xm, int i10) {
            return c8245xm.m51502b(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    /* renamed from: a */
    public int m51499a() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: b */
    public int m51501b() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: d */
    public String m51504d() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: e */
    public int m51505e() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: a */
    public void m51500a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    /* renamed from: b */
    public C8245xm m51502b(int i10, ByteBuffer byteBuffer) {
        m51500a(i10, byteBuffer);
        return this;
    }

    /* renamed from: c */
    public String m51503c() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }
}
