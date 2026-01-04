package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.xo */
/* loaded from: classes8.dex */
public final class C8247xo extends Table {
    /* renamed from: a */
    public String m51513a() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: b */
    public C8247xo m51515b(int i10, ByteBuffer byteBuffer) {
        m51514a(i10, byteBuffer);
        return this;
    }

    /* renamed from: c */
    public int m51517c() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: d */
    public int m51518d() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: e */
    public int m51519e() {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: f */
    public String m51520f() {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: g */
    public int m51521g() {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: h */
    public int m51522h() {
        int i__offset = __offset(20);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: a */
    public void m51514a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    /* renamed from: b */
    public String m51516b() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }
}
