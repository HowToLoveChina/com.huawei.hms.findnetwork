package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.wj */
/* loaded from: classes8.dex */
public final class C8215wj extends Table {

    /* renamed from: com.huawei.openalliance.ad.wj$a */
    public static final class a extends BaseVector {
        /* renamed from: a */
        public a m51132a(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        /* renamed from: a */
        public C8215wj m51133a(int i10) {
            return m51134a(new C8215wj(), i10);
        }

        /* renamed from: a */
        public C8215wj m51134a(C8215wj c8215wj, int i10) {
            return c8215wj.m51125b(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    /* renamed from: a */
    public long m51119a() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    /* renamed from: b */
    public C8215wj m51125b(int i10, ByteBuffer byteBuffer) {
        m51124a(i10, byteBuffer);
        return this;
    }

    /* renamed from: d */
    public C8225wt m51128d() {
        return m51121a(new C8225wt());
    }

    /* renamed from: e */
    public C8247xo m51129e() {
        return m51123a(new C8247xo());
    }

    /* renamed from: f */
    public C8219wn m51130f() {
        return m51120a(new C8219wn());
    }

    /* renamed from: g */
    public String m51131g() {
        int i__offset = __offset(20);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: a */
    public C8219wn m51120a(C8219wn c8219wn) {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return c8219wn.m51233b(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    /* renamed from: b */
    public String m51126b() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: c */
    public C8246xn m51127c() {
        return m51122a(new C8246xn());
    }

    /* renamed from: a */
    public C8225wt m51121a(C8225wt c8225wt) {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return c8225wt.m51269b(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public C8246xn m51122a(C8246xn c8246xn) {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return c8246xn.m51512b(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public C8247xo m51123a(C8247xo c8247xo) {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return c8247xo.m51515b(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public void m51124a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }
}
