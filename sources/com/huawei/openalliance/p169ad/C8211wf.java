package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.wf */
/* loaded from: classes8.dex */
public final class C8211wf extends Table {

    /* renamed from: com.huawei.openalliance.ad.wf$a */
    public static final class a extends BaseVector {
        /* renamed from: a */
        public a m51044a(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        /* renamed from: a */
        public C8211wf m51045a(int i10) {
            return m51046a(new C8211wf(), i10);
        }

        /* renamed from: a */
        public C8211wf m51046a(C8211wf c8211wf, int i10) {
            return c8211wf.m51041b(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    /* renamed from: a */
    public String m51039a() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: b */
    public C8211wf m51041b(int i10, ByteBuffer byteBuffer) {
        m51040a(i10, byteBuffer);
        return this;
    }

    /* renamed from: c */
    public int m51043c() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: a */
    public void m51040a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    /* renamed from: b */
    public String m51042b() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }
}
