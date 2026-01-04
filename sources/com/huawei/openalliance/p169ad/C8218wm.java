package com.huawei.openalliance.p169ad;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.IntVector;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Table;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.openalliance.p169ad.C8212wg;
import com.huawei.openalliance.p169ad.C8215wj;
import com.huawei.openalliance.p169ad.C8222wq;
import com.huawei.openalliance.p169ad.C8227wv;
import com.huawei.openalliance.p169ad.C8230wy;
import com.huawei.openalliance.p169ad.C8234xb;
import com.huawei.openalliance.p169ad.C8236xd;
import java.nio.ByteBuffer;

/* renamed from: com.huawei.openalliance.ad.wm */
/* loaded from: classes8.dex */
public final class C8218wm extends Table {

    /* renamed from: com.huawei.openalliance.ad.wm$a */
    public static final class a extends BaseVector {
        /* renamed from: a */
        public a m51227a(int i10, int i11, ByteBuffer byteBuffer) {
            __reset(i10, i11, byteBuffer);
            return this;
        }

        /* renamed from: a */
        public C8218wm m51228a(int i10) {
            return m51229a(new C8218wm(), i10);
        }

        /* renamed from: a */
        public C8218wm m51229a(C8218wm c8218wm, int i10) {
            return c8218wm.m51202b(Table.__indirect(__element(i10), this.f9443bb), this.f9443bb);
        }
    }

    /* renamed from: A */
    public String m51148A() {
        int i__offset = __offset(78);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: B */
    public String m51149B() {
        int i__offset = __offset(80);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: C */
    public C8241xi m51150C() {
        return m51189a(new C8241xi());
    }

    /* renamed from: D */
    public String m51151D() {
        int i__offset = __offset(84);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: E */
    public int m51152E() {
        int i__offset = __offset(90);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: F */
    public float m51153F() {
        int i__offset = __offset(92);
        if (i__offset != 0) {
            return this.f9449bb.getFloat(i__offset + this.bb_pos);
        }
        return 0.0f;
    }

    /* renamed from: G */
    public String m51154G() {
        int i__offset = __offset(94);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: H */
    public int m51155H() {
        int i__offset = __offset(98);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: I */
    public C8227wv.a m51156I() {
        return m51182a(new C8227wv.a());
    }

    /* renamed from: J */
    public int m51157J() {
        int i__offset = __offset(104);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: K */
    public int m51158K() {
        int i__offset = __offset(106);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: L */
    public String m51159L() {
        int i__offset = __offset(108);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: M */
    public String m51160M() {
        int i__offset = __offset(112);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: N */
    public C8222wq.a m51161N() {
        return m51181a(new C8222wq.a());
    }

    /* renamed from: O */
    public C8229wx m51162O() {
        return m51183a(new C8229wx());
    }

    /* renamed from: P */
    public C8236xd.a m51163P() {
        return m51187a(new C8236xd.a());
    }

    /* renamed from: Q */
    public C8244xl m51164Q() {
        return m51190a(new C8244xl());
    }

    /* renamed from: R */
    public C8215wj.a m51165R() {
        return m51177a(new C8215wj.a());
    }

    /* renamed from: S */
    public int m51166S() {
        int i__offset = __offset(SyncType.AUTO_SYNC_RECORD);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: T */
    public String m51167T() {
        int i__offset = __offset(SyncType.OPEN_SWITCH_FROM_GUIDE);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: U */
    public String m51168U() {
        int i__offset = __offset(SyncType.AUTO_SYNC_PHONE_MANAGER);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: V */
    public C8220wo m51169V() {
        return m51179a(new C8220wo());
    }

    /* renamed from: W */
    public String m51170W() {
        int i__offset = __offset(148);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: X */
    public C8221wp m51171X() {
        return m51180a(new C8221wp());
    }

    /* renamed from: Y */
    public C8212wg.a m51172Y() {
        return m51176a(new C8212wg.a());
    }

    /* renamed from: Z */
    public String m51173Z() {
        int i__offset = __offset(156);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: a */
    public IntVector m51174a(IntVector intVector) {
        int i__offset = __offset(58);
        if (i__offset != 0) {
            return intVector.__assign(__vector(i__offset), this.f9449bb);
        }
        return null;
    }

    /* renamed from: aa */
    public String m51193aa() {
        int i__offset = __offset(RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: ab */
    public String m51194ab() {
        int i__offset = __offset(162);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: ac */
    public String m51195ac() {
        int i__offset = __offset(164);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: ad */
    public String m51196ad() {
        int i__offset = __offset(166);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: ae */
    public int m51197ae() {
        int i__offset = __offset(168);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: af */
    public String m51198af() {
        int i__offset = __offset(170);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: b */
    public long m51199b() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    /* renamed from: c */
    public int m51203c() {
        int i__offset = __offset(10);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: d */
    public int m51204d() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: e */
    public C8237xe m51205e() {
        return m51188a(new C8237xe());
    }

    /* renamed from: f */
    public C8233xa m51206f() {
        return m51185a(new C8233xa());
    }

    /* renamed from: g */
    public String m51207g() {
        int i__offset = __offset(28);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: h */
    public int m51208h() {
        int i__offset = __offset(30);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: i */
    public String m51209i() {
        int i__offset = __offset(32);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: j */
    public long m51210j() {
        int i__offset = __offset(34);
        if (i__offset != 0) {
            return this.f9449bb.getLong(i__offset + this.bb_pos);
        }
        return 0L;
    }

    /* renamed from: k */
    public StringVector m51211k() {
        return m51175a(new StringVector());
    }

    /* renamed from: l */
    public StringVector m51212l() {
        return m51201b(new StringVector());
    }

    /* renamed from: m */
    public C8234xb.a m51213m() {
        return m51186a(new C8234xb.a());
    }

    /* renamed from: n */
    public C8230wy.a m51214n() {
        return m51184a(new C8230wy.a());
    }

    /* renamed from: o */
    public String m51215o() {
        int i__offset = __offset(48);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: p */
    public C8217wl m51216p() {
        return m51178a(new C8217wl());
    }

    /* renamed from: q */
    public String m51217q() {
        int i__offset = __offset(52);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: r */
    public String m51218r() {
        int i__offset = __offset(54);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: s */
    public int m51219s() {
        int i__offset = __offset(56);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: t */
    public IntVector m51220t() {
        return m51174a(new IntVector());
    }

    /* renamed from: u */
    public String m51221u() {
        int i__offset = __offset(60);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: v */
    public String m51222v() {
        int i__offset = __offset(62);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: w */
    public IntVector m51223w() {
        return m51200b(new IntVector());
    }

    /* renamed from: x */
    public int m51224x() {
        int i__offset = __offset(68);
        if (i__offset != 0) {
            return this.f9449bb.getInt(i__offset + this.bb_pos);
        }
        return 0;
    }

    /* renamed from: y */
    public String m51225y() {
        int i__offset = __offset(70);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: z */
    public String m51226z() {
        int i__offset = __offset(76);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: a */
    public StringVector m51175a(StringVector stringVector) {
        int i__offset = __offset(40);
        if (i__offset != 0) {
            return stringVector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: b */
    public IntVector m51200b(IntVector intVector) {
        int i__offset = __offset(66);
        if (i__offset != 0) {
            return intVector.__assign(__vector(i__offset), this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public C8212wg.a m51176a(C8212wg.a aVar) {
        int i__offset = __offset(154);
        if (i__offset != 0) {
            return aVar.m51052a(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: b */
    public StringVector m51201b(StringVector stringVector) {
        int i__offset = __offset(42);
        if (i__offset != 0) {
            return stringVector.__assign(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public C8215wj.a m51177a(C8215wj.a aVar) {
        int i__offset = __offset(130);
        if (i__offset != 0) {
            return aVar.m51132a(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: b */
    public C8218wm m51202b(int i10, ByteBuffer byteBuffer) {
        m51192a(i10, byteBuffer);
        return this;
    }

    /* renamed from: a */
    public C8217wl m51178a(C8217wl c8217wl) {
        int i__offset = __offset(50);
        if (i__offset != 0) {
            return c8217wl.m51145b(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public C8220wo m51179a(C8220wo c8220wo) {
        int i__offset = __offset(140);
        if (i__offset != 0) {
            return c8220wo.m51238b(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public C8221wp m51180a(C8221wp c8221wp) {
        int i__offset = __offset(152);
        if (i__offset != 0) {
            return c8221wp.m51241b(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public C8222wq.a m51181a(C8222wq.a aVar) {
        int i__offset = __offset(114);
        if (i__offset != 0) {
            return aVar.m51252a(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public C8227wv.a m51182a(C8227wv.a aVar) {
        int i__offset = __offset(102);
        if (i__offset != 0) {
            return aVar.m51290a(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public C8229wx m51183a(C8229wx c8229wx) {
        int i__offset = __offset(118);
        if (i__offset != 0) {
            return c8229wx.m51301b(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public C8230wy.a m51184a(C8230wy.a aVar) {
        int i__offset = __offset(46);
        if (i__offset != 0) {
            return aVar.m51318a(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public C8233xa m51185a(C8233xa c8233xa) {
        int i__offset = __offset(24);
        if (i__offset != 0) {
            return c8233xa.m51368b(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public C8234xb.a m51186a(C8234xb.a aVar) {
        int i__offset = __offset(44);
        if (i__offset != 0) {
            return aVar.m51401a(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public C8236xd.a m51187a(C8236xd.a aVar) {
        int i__offset = __offset(126);
        if (i__offset != 0) {
            return aVar.m51424a(__vector(i__offset), 4, this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public C8237xe m51188a(C8237xe c8237xe) {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return c8237xe.m51429b(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public C8241xi m51189a(C8241xi c8241xi) {
        int i__offset = __offset(82);
        if (i__offset != 0) {
            return c8241xi.m51472b(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public C8244xl m51190a(C8244xl c8244xl) {
        int i__offset = __offset(128);
        if (i__offset != 0) {
            return c8244xl.m51490b(__indirect(i__offset + this.bb_pos), this.f9449bb);
        }
        return null;
    }

    /* renamed from: a */
    public String m51191a() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return __string(i__offset + this.bb_pos);
        }
        return null;
    }

    /* renamed from: a */
    public void m51192a(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }
}
