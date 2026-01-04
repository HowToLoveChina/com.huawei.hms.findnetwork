package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.wz */
/* loaded from: classes8.dex */
public final class C8231wz extends Table {

    /* renamed from: com.huawei.openalliance.ad.wz$a */
    public static final class a extends BaseVector {
        /* renamed from: a */
        public a m51333a(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        /* renamed from: a */
        public C8231wz m51334a(int i10) {
            return m51335a(new C8231wz(), i10);
        }

        /* renamed from: a */
        public C8231wz m51335a(C8231wz c8231wz, int i10) {
            return c8231wz.m51325b(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    /* renamed from: a */
    public String m51322a() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: b */
    public int m51324b() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: c */
    public int m51326c() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: d */
    public long m51327d() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    /* renamed from: e */
    public String m51328e() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: f */
    public String m51329f() {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: g */
    public int m51330g() {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: h */
    public int m51331h() {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: i */
    public int m51332i() {
        int i__offset = __offset(20);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: a */
    public void m51323a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    /* renamed from: b */
    public C8231wz m51325b(int i10, ByteBuffer byteBuffer) {
        m51323a(i10, byteBuffer);
        return this;
    }
}
