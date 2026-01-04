package com.huawei.openalliance.p169ad.inter.data;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.p169ad.beans.metadata.MetaData;
import com.huawei.openalliance.p169ad.beans.metadata.Monitor;
import com.huawei.openalliance.p169ad.beans.metadata.ShareInfo;
import com.huawei.openalliance.p169ad.beans.metadata.TextState;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.p171db.bean.EncryptionField;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;
import com.huawei.openalliance.p169ad.utils.AbstractC7810dc;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Callable;

@OuterVisible
/* loaded from: classes2.dex */
public class AdLandingPageData implements Serializable {

    /* renamed from: B */
    private int f33547B;

    /* renamed from: C */
    private int f33548C;

    /* renamed from: D */
    private String f33549D;

    /* renamed from: E */
    private String f33550E;

    /* renamed from: F */
    private String f33551F;

    /* renamed from: G */
    private String f33552G;

    /* renamed from: H */
    private String f33553H;

    /* renamed from: I */
    private String f33554I;

    /* renamed from: J */
    private List<Integer> f33555J;

    /* renamed from: L */
    private String f33557L;

    /* renamed from: M */
    private String f33558M;

    /* renamed from: N */
    private String f33559N;

    /* renamed from: O */
    private long f33560O;

    /* renamed from: P */
    private boolean f33561P;

    /* renamed from: Q */
    private String f33562Q;

    /* renamed from: R */
    private int f33563R;

    /* renamed from: S */
    private int f33564S;

    /* renamed from: T */
    private String f33565T;

    /* renamed from: U */
    private String f33566U;

    /* renamed from: V */
    private int f33567V;

    /* renamed from: W */
    private String f33568W;

    /* renamed from: X */
    private String f33569X;

    /* renamed from: a */
    private EncryptionField<String> f33572a;

    /* renamed from: b */
    private String f33573b;

    /* renamed from: c */
    private int f33574c;

    /* renamed from: d */
    private String f33575d;

    /* renamed from: e */
    private String f33576e;

    /* renamed from: f */
    private ShareInfo f33577f;

    /* renamed from: g */
    private AppInfo f33578g;

    /* renamed from: h */
    private EncryptionField<List<Monitor>> f33579h;

    /* renamed from: i */
    private boolean f33580i;

    /* renamed from: j */
    private byte[] f33581j;

    /* renamed from: k */
    private String f33582k;

    /* renamed from: l */
    private String f33583l;

    /* renamed from: m */
    private List<TextState> f33584m;

    /* renamed from: n */
    private List<String> f33585n;

    /* renamed from: o */
    private String f33586o;

    /* renamed from: p */
    private String f33587p;

    /* renamed from: q */
    private String f33588q;

    /* renamed from: r */
    private String f33589r;

    /* renamed from: s */
    private EncryptionField<String> f33590s;

    /* renamed from: w */
    private String f33594w;

    /* renamed from: x */
    private String f33595x;

    /* renamed from: y */
    private String f33596y;

    /* renamed from: z */
    private String f33597z;

    /* renamed from: t */
    private boolean f33591t = false;

    /* renamed from: u */
    private boolean f33592u = false;

    /* renamed from: v */
    private boolean f33593v = true;

    /* renamed from: A */
    private int f33546A = 0;

    /* renamed from: K */
    private boolean f33556K = true;

    /* renamed from: Y */
    private long f33570Y = 500;

    /* renamed from: Z */
    private int f33571Z = 50;

    /* renamed from: com.huawei.openalliance.ad.inter.data.AdLandingPageData$a */
    public static class CallableC7290a implements Callable<byte[]> {

        /* renamed from: a */
        private final Context f33598a;

        public CallableC7290a(Context context) {
            this.f33598a = context.getApplicationContext();
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public byte[] call() {
            return AbstractC7796cp.m48089b(this.f33598a);
        }
    }

    @OuterVisible
    public AdLandingPageData() {
    }

    /* renamed from: A */
    public void m44251A(String str) {
        this.f33569X = str;
    }

    /* renamed from: B */
    public String m44253B() {
        return this.f33557L;
    }

    /* renamed from: C */
    public String m44254C() {
        return this.f33558M;
    }

    /* renamed from: D */
    public String m44255D() {
        return this.f33559N;
    }

    /* renamed from: E */
    public long m44256E() {
        return this.f33560O;
    }

    /* renamed from: F */
    public boolean m44257F() {
        return this.f33561P;
    }

    /* renamed from: G */
    public String m44258G() {
        return this.f33562Q;
    }

    /* renamed from: H */
    public int m44259H() {
        return this.f33563R;
    }

    /* renamed from: I */
    public int m44260I() {
        return this.f33564S;
    }

    /* renamed from: J */
    public String m44261J() {
        return this.f33569X;
    }

    /* renamed from: a */
    public EncryptionField<String> m44262a() {
        return this.f33572a;
    }

    /* renamed from: b */
    public String m44271b() {
        return this.f33565T;
    }

    /* renamed from: c */
    public String m44277c() {
        return this.f33575d;
    }

    /* renamed from: d */
    public EncryptionField<List<Monitor>> m44283d() {
        return this.f33579h;
    }

    /* renamed from: e */
    public String m44287e() {
        return this.f33582k;
    }

    /* renamed from: f */
    public String m44290f() {
        return this.f33583l;
    }

    /* renamed from: g */
    public List<TextState> m44293g() {
        return this.f33584m;
    }

    @OuterVisible
    public int getAdType() {
        return this.f33574c;
    }

    @OuterVisible
    public AppInfo getAppInfo() {
        return this.f33578g;
    }

    @OuterVisible
    public String getContentId() {
        return this.f33576e;
    }

    @OuterVisible
    public String getLandingUrl() {
        return this.f33573b;
    }

    @OuterVisible
    public ShareInfo getShareInfo() {
        return this.f33577f;
    }

    @OuterVisible
    public String getSlotId() {
        return this.f33586o;
    }

    @OuterVisible
    public String getUniqueId() {
        return this.f33589r;
    }

    /* renamed from: h */
    public List<String> m44295h() {
        return this.f33585n;
    }

    /* renamed from: i */
    public String m44297i() {
        return this.f33587p;
    }

    @OuterVisible
    public boolean isShowPageTitle() {
        return this.f33580i;
    }

    /* renamed from: j */
    public String m44299j() {
        return this.f33588q;
    }

    /* renamed from: k */
    public EncryptionField<String> m44301k() {
        return this.f33590s;
    }

    /* renamed from: l */
    public void m44303l(String str) {
        this.f33596y = str;
    }

    /* renamed from: m */
    public void m44305m(String str) {
        this.f33597z = str;
    }

    /* renamed from: n */
    public String m44307n() {
        return this.f33594w;
    }

    /* renamed from: o */
    public String m44309o() {
        return this.f33596y;
    }

    /* renamed from: p */
    public String m44311p() {
        return this.f33597z;
    }

    /* renamed from: q */
    public String m44313q() {
        return this.f33595x;
    }

    /* renamed from: r */
    public int m44315r() {
        return this.f33547B;
    }

    /* renamed from: s */
    public int m44317s() {
        return this.f33548C;
    }

    /* renamed from: t */
    public String m44319t() {
        return this.f33554I;
    }

    /* renamed from: u */
    public int m44321u() {
        return this.f33546A;
    }

    /* renamed from: v */
    public String m44323v() {
        return this.f33566U;
    }

    /* renamed from: w */
    public void m44325w(String str) {
        this.f33557L = str;
    }

    /* renamed from: x */
    public String m44327x() {
        return this.f33568W;
    }

    /* renamed from: y */
    public ContentRecord m44329y() {
        ContentRecord contentRecord = new ContentRecord();
        contentRecord.m41543d(getSlotId());
        contentRecord.m41555f(m44297i());
        contentRecord.m41406L(m44261J());
        contentRecord.m41608t(m44299j());
        contentRecord.m41549e(getContentId());
        contentRecord.m41507b(getAdType());
        contentRecord.m41441a(m44262a());
        contentRecord.m41579k(getLandingUrl());
        contentRecord.m41536c(m44277c());
        contentRecord.m41509b(m44283d());
        contentRecord.m41605s(m44290f());
        contentRecord.m41562g(m44295h());
        contentRecord.m41535c(m44301k());
        contentRecord.m41447a(m44304l());
        contentRecord.m41616x(m44307n());
        contentRecord.m41618y(m44309o());
        contentRecord.m41479ab(m44311p());
        contentRecord.m41511b(m44319t());
        contentRecord.m41592o(m44321u());
        contentRecord.m41550e(m44331z());
        contentRecord.m41396G(m44253B());
        contentRecord.m41398H(m44254C());
        contentRecord.m41402J(m44255D());
        contentRecord.m41560g(m44256E());
        contentRecord.m41545d(m44257F());
        contentRecord.m41587m(m44258G());
        contentRecord.m41607t(m44259H());
        contentRecord.m41604s(m44260I());
        contentRecord.m41416Q(m44271b());
        contentRecord.m41569i(m44315r());
        contentRecord.m41551e(m44326w());
        contentRecord.m41420S(m44323v());
        contentRecord.m41410N(m44327x());
        if (getAppInfo() != null && !TextUtils.isEmpty(getAppInfo().getUniqueId())) {
            contentRecord.m41612v(getAppInfo().getUniqueId());
        }
        return contentRecord;
    }

    /* renamed from: z */
    public List<Integer> m44331z() {
        return this.f33555J;
    }

    public AdLandingPageData(ContentRecord contentRecord, Context context, boolean z10) {
        ApkInfo apkInfoM40339s;
        m44291f(contentRecord.m41588n());
        m44263a(contentRecord.m41552f());
        m44265a((EncryptionField<String>) m44250a(contentRecord.m41395G(), context));
        m44274b(contentRecord.m41386B());
        m44280c(contentRecord.m41577k());
        m44275b(contentRecord.m41431Y());
        this.f33547B = contentRecord.m41388C();
        this.f33548C = contentRecord.m41392E();
        MetaData metaDataM41568i = contentRecord.m41568i();
        if (metaDataM41568i != null) {
            ShareInfo shareInfoM40338r = metaDataM41568i.m40338r();
            if (shareInfoM40338r != null) {
                m44267a(new ShareInfo(shareInfoM40338r));
            }
            if (z10 && (apkInfoM40339s = metaDataM41568i.m40339s()) != null) {
                AppInfo appInfo = new AppInfo(apkInfoM40339s);
                appInfo.m44415m(metaDataM41568i.m40332o());
                appInfo.m44433v(contentRecord.m41478ab());
                appInfo.m44351F(contentRecord.m41496ar());
                appInfo.m44353G(contentRecord.m41497as());
                appInfo.m44402h(metaDataM41568i.m40266C());
                this.f33578g = appInfo;
            }
            m44269a(metaDataM41568i.m40343w());
            m44308n(metaDataM41568i.m40266C());
            m44310o(metaDataM41568i.m40328m());
            m44312p(metaDataM41568i.m40341u());
            m44314q(metaDataM41568i.m40330n());
            m44318s(metaDataM41568i.m40332o());
            m44316r(metaDataM41568i.m40264A());
        }
        m44273b((EncryptionField<List<Monitor>>) m44250a(contentRecord.m41405L(), context));
        m44270a(contentRecord.m41413P() == 1);
        m44285d(contentRecord.m41425V());
        m44288e(contentRecord.m41427W());
        m44294g(contentRecord.m41585m());
        m44296h(contentRecord.m41591o());
        m44298i(contentRecord.m41433Z());
        m44300j(contentRecord.m41478ab());
        m44279c((EncryptionField<String>) m44250a(contentRecord.m41480ac(), context));
        m44276b(contentRecord.m41482ad());
        m44302k(contentRecord.m41483ae());
        m44303l(contentRecord.m41486ah());
        m44305m(contentRecord.m41529bp());
        m44272b(contentRecord.m41492an());
        m44320t(contentRecord.m41563h());
        m44281c(contentRecord.m41409N());
        m44325w(contentRecord.m41450aB());
        m44328x(contentRecord.m41451aC());
        m44330y(contentRecord.m41456aH());
        m44292f(contentRecord.m41462aN());
        m44332z(contentRecord.m41397H());
        m44278c(contentRecord.m41472aX());
        m44284d(contentRecord.m41464aP());
        m44251A(contentRecord.m41463aO());
        m44268a(contentRecord.m41474aZ());
        m44286d(contentRecord.m41517bd());
        m44322u(contentRecord.m41516bc());
        m44324v(contentRecord.m41466aR());
    }

    /* renamed from: a */
    private EncryptionField m44250a(EncryptionField encryptionField, Context context) {
        if (encryptionField == null) {
            return null;
        }
        if (!encryptionField.m41659c() && encryptionField.m41658b()) {
            if (this.f33581j == null) {
                this.f33581j = (byte[]) AbstractC7810dc.m48272b(new CallableC7290a(context));
            }
            encryptionField.m41656a(encryptionField.m41657b(this.f33581j));
        }
        encryptionField.m41655a((EncryptionField) null);
        return encryptionField;
    }

    /* renamed from: A */
    public boolean m44252A() {
        return this.f33556K;
    }

    /* renamed from: b */
    public void m44272b(int i10) {
        this.f33546A = i10;
    }

    /* renamed from: c */
    public void m44278c(int i10) {
        this.f33563R = i10;
    }

    /* renamed from: d */
    public void m44284d(int i10) {
        this.f33564S = i10;
    }

    /* renamed from: e */
    public void m44288e(String str) {
        this.f33583l = str;
    }

    /* renamed from: f */
    public void m44291f(String str) {
        this.f33576e = str;
    }

    /* renamed from: g */
    public void m44294g(String str) {
        this.f33586o = str;
    }

    /* renamed from: h */
    public void m44296h(String str) {
        this.f33587p = str;
    }

    /* renamed from: i */
    public void m44298i(String str) {
        this.f33588q = str;
    }

    /* renamed from: j */
    public void m44300j(String str) {
        this.f33589r = str;
    }

    /* renamed from: k */
    public void m44302k(String str) {
        this.f33594w = str;
    }

    /* renamed from: l */
    public boolean m44304l() {
        return true;
    }

    /* renamed from: m */
    public boolean m44306m() {
        return this.f33593v;
    }

    /* renamed from: n */
    public void m44308n(String str) {
        this.f33595x = str;
    }

    /* renamed from: o */
    public void m44310o(String str) {
        this.f33549D = str;
    }

    /* renamed from: p */
    public void m44312p(String str) {
        this.f33550E = str;
    }

    /* renamed from: q */
    public void m44314q(String str) {
        this.f33551F = str;
    }

    /* renamed from: r */
    public void m44316r(String str) {
        this.f33553H = str;
    }

    /* renamed from: s */
    public void m44318s(String str) {
        this.f33552G = str;
    }

    /* renamed from: t */
    public void m44320t(String str) {
        this.f33554I = str;
    }

    /* renamed from: u */
    public void m44322u(String str) {
        this.f33566U = str;
    }

    /* renamed from: v */
    public void m44324v(String str) {
        this.f33568W = str;
    }

    /* renamed from: w */
    public boolean m44326w() {
        return this.f33567V == 1;
    }

    /* renamed from: x */
    public void m44328x(String str) {
        this.f33558M = str;
    }

    /* renamed from: y */
    public void m44330y(String str) {
        this.f33559N = str;
    }

    /* renamed from: z */
    public void m44332z(String str) {
        this.f33562Q = str;
    }

    /* renamed from: a */
    public void m44263a(int i10) {
        this.f33574c = i10;
    }

    /* renamed from: b */
    public void m44273b(EncryptionField<List<Monitor>> encryptionField) {
        this.f33579h = encryptionField;
    }

    /* renamed from: c */
    public void m44279c(EncryptionField<String> encryptionField) {
        this.f33590s = encryptionField;
    }

    /* renamed from: d */
    public void m44285d(String str) {
        this.f33582k = str;
    }

    /* renamed from: e */
    public void m44289e(boolean z10) {
        this.f33556K = z10;
    }

    /* renamed from: f */
    public void m44292f(boolean z10) {
        this.f33561P = z10;
    }

    /* renamed from: a */
    public void m44264a(long j10) {
        this.f33560O = j10;
    }

    /* renamed from: b */
    public void m44274b(String str) {
        this.f33573b = str;
    }

    /* renamed from: c */
    public void m44280c(String str) {
        this.f33575d = str;
    }

    /* renamed from: d */
    public void m44286d(boolean z10) {
        this.f33567V = z10 ? 1 : 0;
    }

    /* renamed from: a */
    public void m44265a(EncryptionField<String> encryptionField) {
        this.f33572a = encryptionField;
    }

    /* renamed from: b */
    public void m44275b(List<String> list) {
        this.f33585n = list;
    }

    /* renamed from: c */
    public void m44281c(List<Integer> list) {
        this.f33555J = list;
    }

    /* renamed from: a */
    public void m44266a(AppInfo appInfo) {
        this.f33578g = appInfo;
    }

    /* renamed from: b */
    public void m44276b(boolean z10) {
        this.f33591t = z10;
    }

    /* renamed from: c */
    public void m44282c(boolean z10) {
        this.f33592u = z10;
    }

    /* renamed from: a */
    public void m44267a(ShareInfo shareInfo) {
        this.f33577f = shareInfo;
    }

    /* renamed from: a */
    public void m44268a(String str) {
        this.f33565T = str;
    }

    /* renamed from: a */
    public void m44269a(List<TextState> list) {
        this.f33584m = list;
    }

    /* renamed from: a */
    public void m44270a(boolean z10) {
        this.f33580i = z10;
    }
}
