package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Table;
import com.huawei.openalliance.p169ad.C8212wg;
import com.huawei.openalliance.p169ad.C8218wm;
import com.huawei.openalliance.p169ad.C8227wv;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.wd */
/* loaded from: classes8.dex */
public final class C8209wd extends Table {

    /* renamed from: com.huawei.openalliance.ad.wd$a */
    public static final class a extends BaseVector {
        /* renamed from: a */
        public a m51012a(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        /* renamed from: a */
        public C8209wd m51013a(int i10) {
            return m51014a(new C8209wd(), i10);
        }

        /* renamed from: a */
        public C8209wd m51014a(C8209wd c8209wd, int i10) {
            return c8209wd.m51005b(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    /* renamed from: a */
    public C8212wg.a m50998a(C8212wg.a aVar) {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return aVar.m51052a(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: b */
    public int m51004b() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: d */
    public C8218wm.a m51007d() {
        return m50999a(new C8218wm.a());
    }

    /* renamed from: e */
    public C8227wv.a m51008e() {
        return m51001a(new C8227wv.a());
    }

    /* renamed from: f */
    public int m51009f() {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: g */
    public C8212wg.a m51010g() {
        return m50998a(new C8212wg.a());
    }

    /* renamed from: h */
    public C8223wr m51011h() {
        return m51000a(new C8223wr());
    }

    /* renamed from: a */
    public C8218wm.a m50999a(C8218wm.a aVar) {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return aVar.m51227a(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: b */
    public C8209wd m51005b(int i10, ByteBuffer byteBuffer) {
        m51003a(i10, byteBuffer);
        return this;
    }

    /* renamed from: c */
    public String m51006c() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: a */
    public C8223wr m51000a(C8223wr c8223wr) {
        int i__offset = __offset(20);
        if (i__offset != 0) {
            return c8223wr.m51258b(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public C8227wv.a m51001a(C8227wv.a aVar) {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return aVar.m51290a(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public String m51002a() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: a */
    public void m51003a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }
}
