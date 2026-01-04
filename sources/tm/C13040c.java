package tm;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.feedback.mail.zip.p099sp.SharedPreferencesStorage;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.api.entity.sns.SNSCode;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9721b;
import java.util.Map;
import p015ak.C0213f;
import p015ak.C0214f0;
import p399jk.AbstractC10896a;
import p709vj.C13452e;

/* renamed from: tm.c */
/* loaded from: classes6.dex */
public class C13040c extends AbstractC13038a {

    /* renamed from: b */
    public long f59360b;

    /* renamed from: c */
    public C13039b f59361c;

    /* renamed from: tm.c$b */
    public static class b {

        /* renamed from: a */
        public static C13040c f59362a = new C13040c();
    }

    /* renamed from: F */
    public static C13040c m78609F() {
        return b.f59362a;
    }

    /* renamed from: A */
    public String m78610A() throws C9721b {
        return m78630V("com.huawei.hicloud.v2", "filingUrl");
    }

    /* renamed from: B */
    public String m78611B() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", m78613D("generalconfig"));
    }

    /* renamed from: C */
    public String m78612C() {
        return this.f59361c.m78600h();
    }

    /* renamed from: D */
    public String m78613D(String str) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), SharedPreferencesStorage.BACKUPOPTION_SPFILE, 0);
        if (sharedPreferencesM1382b == null || sharedPreferencesM1382b.getInt("encrypt_mode", 0) == 0 || AbstractC13038a.f59353a.contains(str)) {
            return str;
        }
        return str + "-encrypt";
    }

    /* renamed from: E */
    public String m78614E(String str) {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(C0213f.m1377a(), SharedPreferencesStorage.BACKUPOPTION_SPFILE, 0);
        int i10 = sharedPreferencesM1382b != null ? sharedPreferencesM1382b.getInt("basic_encrypt_mode", 0) : 0;
        AbstractC10896a.m65885d("GlobalRoutingServiceImpl", "get service key for init and refresh, encrypt mode = " + i10);
        if (i10 == 0) {
            return str;
        }
        return str + "-encrypt";
    }

    /* renamed from: G */
    public String m78615G() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", m78613D(Constants.SCHEME_MARKET));
    }

    /* renamed from: H */
    public String m78616H() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", m78613D("migrate"));
    }

    /* renamed from: I */
    public String m78617I() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", HwPayConstant.KEY_NOTIFY_URL);
    }

    /* renamed from: J */
    public String m78618J() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", "omcdnBypass");
    }

    /* renamed from: K */
    public String m78619K() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", "omcdn");
    }

    /* renamed from: L */
    public String m78620L() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", m78613D("opensource"));
    }

    /* renamed from: M */
    public String m78621M() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", "operationKey");
    }

    /* renamed from: N */
    public String m78622N() throws C9721b {
        String strM78627S;
        C13039b c13039b;
        String strM78613D = m78613D("phonefinder");
        try {
            strM78627S = m78627S("com.huawei.hicloud.v2", strM78613D);
        } catch (C9721b unused) {
            AbstractC10896a.m65886e("GlobalRoutingServiceImpl", "phoneFinderUrl isEmpty");
            strM78627S = "";
        }
        return (!TextUtils.isEmpty(strM78627S) || (c13039b = this.f59361c) == null) ? strM78627S : c13039b.m78593a("com.huawei.hicloud.v2", strM78613D);
    }

    /* renamed from: O */
    public String m78623O() throws C9721b {
        String strM78613D = m78613D("phonefinder");
        C13039b c13039b = this.f59361c;
        return c13039b != null ? c13039b.m78593a("com.huawei.hicloud.v2", strM78613D) : "";
    }

    /* renamed from: P */
    public String m78624P() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", m78613D("portalsite"));
    }

    /* renamed from: Q */
    public String m78625Q() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", m78613D("portal"));
    }

    /* renamed from: R */
    public String m78626R() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", m78613D("robortim"));
    }

    /* renamed from: S */
    public String m78627S(String str, String str2) throws C9721b {
        if (!C13452e.m80781L().m80842P0() || !C13041d.m78675e().m78681g() || !str.equals("com.huawei.hicloud.v2")) {
            return m78629U(str, str2);
        }
        AbstractC10896a.m65885d("GlobalRoutingServiceImpl", "getServiceUrl = " + str2);
        String strM78680f = C13041d.m78675e().m78680f(str2);
        if (!TextUtils.isEmpty(strM78680f)) {
            return strM78680f;
        }
        m78643e();
        throw new C9721b(ConnectionResult.RESOLUTION_REQUIRED, "grs serviceUrl is null");
    }

    /* renamed from: T */
    public String m78628T(String str, String str2, String str3) throws C9721b {
        String strM78627S = m78627S(str, m78613D(str2));
        return TextUtils.isEmpty(strM78627S) ? str3 : strM78627S;
    }

    /* renamed from: U */
    public final String m78629U(String str, String str2) throws C9721b {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strM78593a = this.f59361c.m78593a(str, str2);
        if (TextUtils.isEmpty(strM78593a)) {
            AbstractC10896a.m65886e("GlobalRoutingServiceImpl", "get " + (str + "." + str2 + " url = null,total " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms"));
        }
        if (TextUtils.isEmpty(strM78593a)) {
            throw new C9721b(ConnectionResult.RESOLUTION_REQUIRED, "grs serviceUrl is null");
        }
        return strM78593a;
    }

    /* renamed from: V */
    public final String m78630V(String str, String str2) throws C9721b {
        String strM78627S;
        try {
            strM78627S = m78627S(str, str2);
        } catch (C9721b e10) {
            AbstractC10896a.m65886e("GlobalRoutingServiceImpl", "getServiceUrl exception, key = " + str2 + ", e = " + e10.toString());
            strM78627S = null;
        }
        return TextUtils.isEmpty(strM78627S) ? m78629U(str, str2) : strM78627S;
    }

    /* renamed from: W */
    public Map<String, String> m78631W() throws C9721b {
        Map<String, String> mapM78594b = this.f59361c.m78594b("com.huawei.hicloud.v2");
        if (mapM78594b == null || mapM78594b.isEmpty()) {
            throw new C9721b(ConnectionResult.RESOLUTION_REQUIRED, "grs serviceUrls is null");
        }
        return mapM78594b;
    }

    /* renamed from: X */
    public String m78632X() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", m78613D("smartrobot"));
    }

    /* renamed from: Y */
    public String m78633Y() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", "syncdrive");
    }

    /* renamed from: Z */
    public String m78634Z() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", m78613D("termsBase"));
    }

    /* renamed from: a */
    public int m78635a(String str) throws C9721b {
        String strM78627S;
        int i10;
        String strM78627S2 = null;
        try {
            strM78627S = m78627S("com.huawei.hicloud.v2", str);
        } catch (C9721b e10) {
            AbstractC10896a.m65887i("GlobalRoutingServiceImpl", "checkAddressStatus getServiceUrl : " + e10);
            strM78627S = null;
        }
        try {
            strM78627S2 = m78627S("com.huawei.hicloud.v2", str + "-encrypt");
        } catch (C9721b e11) {
            AbstractC10896a.m65887i("GlobalRoutingServiceImpl", "checkAddressStatus getServiceUrl : " + e11);
        }
        if (!TextUtils.isEmpty(strM78627S) && !TextUtils.isEmpty(strM78627S2)) {
            i10 = 3;
        } else if (!TextUtils.isEmpty(strM78627S)) {
            i10 = 1;
        } else {
            if (TextUtils.isEmpty(strM78627S2)) {
                throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "checkAddressStatus " + str + " get all url from grs is null");
            }
            i10 = 2;
        }
        AbstractC10896a.m65887i("GlobalRoutingServiceImpl", "checkAddressStatus " + str + " status = " + i10);
        return i10;
    }

    /* renamed from: a0 */
    public String m78636a0() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", m78613D("terms"));
    }

    /* renamed from: b */
    public int m78637b(Map<String, String> map, String str) throws C9721b {
        int i10;
        String str2 = map.get("basic-encrypt");
        String str3 = map.get(CloudBackupConstant.RestoreDataDictionaryType.BASIC);
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
            i10 = 3;
        } else if (!TextUtils.isEmpty(str3)) {
            i10 = 1;
        } else {
            if (TextUtils.isEmpty(str2)) {
                throw new C9721b(SNSCode.Status.HW_ACCOUNT_FAILED, "checkAddressStatus from urlsmap " + str + " get all url from grs is null");
            }
            i10 = 2;
        }
        AbstractC10896a.m65887i("GlobalRoutingServiceImpl", "checkAddressStatus from urlsmap " + str + " status = " + i10);
        return i10;
    }

    /* renamed from: b0 */
    public String m78638b0() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", "toolGateUrl");
    }

    /* renamed from: c */
    public int m78639c() throws C9721b {
        return m78635a(CloudBackupConstant.RestoreDataDictionaryType.BASIC);
    }

    /* renamed from: c0 */
    public String m78640c0() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", m78613D("uba"));
    }

    /* renamed from: d */
    public int m78641d(Map<String, String> map) throws C9721b {
        return m78637b(map, CloudBackupConstant.RestoreDataDictionaryType.BASIC);
    }

    /* renamed from: d0 */
    public String m78642d0() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", m78613D("userdomain"));
    }

    /* renamed from: e */
    public final void m78643e() {
        boolean zM80842P0 = C13452e.m80781L().m80842P0();
        boolean zM78682h = C13041d.m78675e().m78682h();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j10 = jCurrentTimeMillis - this.f59360b;
        if (zM80842P0 && zM78682h && j10 >= 100000) {
            C13452e.m80781L().m80988x1("from_url_sp_empty");
            this.f59360b = jCurrentTimeMillis;
        }
    }

    /* renamed from: e0 */
    public String m78644e0() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", m78613D("user"));
    }

    /* renamed from: f */
    public void m78645f() {
        AbstractC10896a.m65885d("GlobalRoutingServiceImpl", CloudBackupConstant.REPORT_TYPE_BASE_CLEAR_CACHE);
        this.f59361c.m78596d();
    }

    /* renamed from: f0 */
    public String m78646f0() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", "userdrive");
    }

    /* renamed from: g */
    public void m78647g() {
        C13042e.m78685c().m78687a();
    }

    /* renamed from: g0 */
    public String m78648g0() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", m78613D("userkey"));
    }

    /* renamed from: h */
    public void m78649h() {
        m78645f();
        C13039b c13039b = this.f59361c;
        if (c13039b != null) {
            c13039b.m78606p(null);
            this.f59361c.m78597e();
            this.f59361c.m78598f();
        }
    }

    /* renamed from: h0 */
    public String m78650h0() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", m78613D("vfs"));
    }

    /* renamed from: i */
    public void m78651i() {
        this.f59361c.m78598f();
    }

    /* renamed from: i0 */
    public synchronized void m78652i0(Context context, String str, boolean z10) {
        AbstractC10896a.m65887i("GlobalRoutingServiceImpl", "initGRSParams,country code is " + str);
        this.f59361c.m78605o(context);
        this.f59361c.m78606p(str);
        this.f59361c.m78604m(z10);
    }

    /* renamed from: j */
    public String m78653j() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", "album-faq");
    }

    /* renamed from: j0 */
    public void m78654j0(Context context, String str, boolean z10) {
        m78651i();
        m78652i0(context, str, z10);
    }

    /* renamed from: k */
    public String m78655k() throws C9721b {
        return m78630V("com.huawei.hicloud.v2", "appDownloadUrl");
    }

    /* renamed from: k0 */
    public void m78656k0() {
        AbstractC10896a.m65887i("GlobalRoutingServiceImpl", "refreshChinaRegionGrs");
        if (C13452e.m80781L().m80803F0().booleanValue()) {
            m78654j0(C0213f.m1377a(), C13452e.m80781L().m80942m(), true);
        }
    }

    /* renamed from: l */
    public String m78657l() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", m78613D("appGalleryOpenUrl"));
    }

    /* renamed from: l0 */
    public void m78658l0(String str) {
        this.f59361c.m78607q(str);
    }

    /* renamed from: m */
    public String m78659m() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", m78613D("backupcontent"));
    }

    /* renamed from: m0 */
    public void m78660m0(String str) {
        this.f59361c.m78608r(str);
    }

    /* renamed from: n */
    public String m78661n() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", m78613D(CloudBackupConstant.RestoreDataDictionaryType.BASIC));
    }

    /* renamed from: o */
    public String m78662o() throws C9721b {
        return m78630V("com.huawei.hicloud.v2", m78613D(CloudBackupConstant.RestoreDataDictionaryType.BASIC));
    }

    /* renamed from: p */
    public String m78663p() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", m78614E(CloudBackupConstant.RestoreDataDictionaryType.BASIC));
    }

    /* renamed from: q */
    public String m78664q() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", m78613D("business"));
    }

    /* renamed from: r */
    public String m78665r() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", m78613D("cbs"));
    }

    /* renamed from: s */
    public String m78666s() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", m78613D("cbsv3"));
    }

    /* renamed from: t */
    public String m78667t() throws C9721b {
        return m78630V("com.huawei.hicloud.v2", m78613D("casDomain"));
    }

    /* renamed from: u */
    public String m78668u() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", "cloudphotodrive");
    }

    /* renamed from: v */
    public String m78669v() throws C9721b {
        return m78630V("com.huawei.hicloud.v2", m78613D("cloudServiceAgreement"));
    }

    /* renamed from: w */
    public String m78670w() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", "cloudsyncdrive");
    }

    /* renamed from: x */
    public String m78671x() throws C9721b {
        return m78630V("com.huawei.hicloud.v2", m78613D("cloudsyncdrive"));
    }

    /* renamed from: y */
    public String m78672y() throws C9721b {
        return m78630V("com.huawei.hicloud.v2", m78613D("consumer"));
    }

    /* renamed from: z */
    public String m78673z() throws C9721b {
        return m78627S("com.huawei.hicloud.v2", m78613D("content"));
    }

    public C13040c() {
        this.f59360b = 0L;
        this.f59361c = new C13039b();
    }
}
