package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.xl */
/* loaded from: classes8.dex */
public final class C8244xl extends Table {

    /* renamed from: com.huawei.openalliance.ad.xl$a */
    public static final class a extends BaseVector {
        /* renamed from: a */
        public a m51495a(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        /* renamed from: a */
        public C8244xl m51496a(int i10) {
            return m51497a(new C8244xl(), i10);
        }

        /* renamed from: a */
        public C8244xl m51497a(C8244xl c8244xl, int i10) {
            return c8244xl.m51490b(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    /* renamed from: a */
    public C8243xk m51487a(C8243xk c8243xk) {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return c8243xk.m51482b(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    /* renamed from: b */
    public C8244xl m51490b(int i10, ByteBuffer byteBuffer) {
        m51489a(i10, byteBuffer);
        return this;
    }

    /* renamed from: d */
    public String m51493d() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: e */
    public String m51494e() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: a */
    public String m51488a() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: b */
    public String m51491b() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: c */
    public C8243xk m51492c() {
        return m51487a(new C8243xk());
    }

    /* renamed from: a */
    public void m51489a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }
}
