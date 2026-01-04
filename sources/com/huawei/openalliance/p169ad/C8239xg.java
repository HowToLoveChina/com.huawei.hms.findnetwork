package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Table;
import com.huawei.openalliance.p169ad.C8215wj;
import com.huawei.openalliance.p169ad.C8226wu;
import com.huawei.openalliance.p169ad.C8231wz;
import com.huawei.openalliance.p169ad.C8244xl;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.xg */
/* loaded from: classes8.dex */
public final class C8239xg extends Table {

    /* renamed from: com.huawei.openalliance.ad.xg$a */
    public static final class a extends BaseVector {
        /* renamed from: a */
        public a m51462a(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        /* renamed from: a */
        public C8239xg m51463a(int i10) {
            return m51464a(new C8239xg(), i10);
        }

        /* renamed from: a */
        public C8239xg m51464a(C8239xg c8239xg, int i10) {
            return c8239xg.m51449b(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    /* renamed from: a */
    public C8215wj.a m51441a(C8215wj.a aVar) {
        int i__offset = __offset(28);
        if (i__offset != 0) {
            return aVar.m51132a(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: b */
    public C8239xg m51449b(int i10, ByteBuffer byteBuffer) {
        m51448a(i10, byteBuffer);
        return this;
    }

    /* renamed from: c */
    public int m51451c() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: d */
    public C8226wu.a m51452d() {
        return m51442a(new C8226wu.a());
    }

    /* renamed from: e */
    public String m51453e() {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: f */
    public C8231wz.a m51454f() {
        return m51443a(new C8231wz.a());
    }

    /* renamed from: g */
    public C8248xp m51455g() {
        return m51446a(new C8248xp());
    }

    /* renamed from: h */
    public int m51456h() {
        int i__offset = __offset(22);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: i */
    public C8244xl m51457i() {
        return m51445a(new C8244xl());
    }

    /* renamed from: j */
    public C8215wj.a m51458j() {
        return m51441a(new C8215wj.a());
    }

    /* renamed from: k */
    public int m51459k() {
        int i__offset = __offset(30);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: l */
    public C8244xl.a m51460l() {
        return m51444a(new C8244xl.a());
    }

    /* renamed from: m */
    public int m51461m() {
        int i__offset = __offset(34);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: a */
    public C8226wu.a m51442a(C8226wu.a aVar) {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return aVar.m51282a(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: b */
    public String m51450b() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: a */
    public C8231wz.a m51443a(C8231wz.a aVar) {
        int i__offset = __offset(18);
        if (i__offset != 0) {
            return aVar.m51333a(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public C8244xl.a m51444a(C8244xl.a aVar) {
        int i__offset = __offset(32);
        if (i__offset != 0) {
            return aVar.m51495a(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public C8244xl m51445a(C8244xl c8244xl) {
        int i__offset = __offset(26);
        if (i__offset != 0) {
            return c8244xl.m51490b(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public C8248xp m51446a(C8248xp c8248xp) {
        int i__offset = __offset(20);
        if (i__offset != 0) {
            return c8248xp.m51526b(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public String m51447a() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: a */
    public void m51448a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }
}
