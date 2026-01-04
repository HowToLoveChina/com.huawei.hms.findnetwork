package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.framework.network.restclient.dnkeeper.InterfaceC5483d;
import com.huawei.hms.network.embedded.C5966j2;
import com.huawei.openalliance.p169ad.beans.base.ReqBean;
import com.huawei.openalliance.p169ad.beans.server.ConsentConfigReq;
import com.huawei.openalliance.p169ad.beans.server.EventReportReq;
import com.huawei.openalliance.p169ad.constant.Config;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.net.http.C7500c;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7742ap;
import com.huawei.openalliance.p169ad.utils.AbstractC7796cp;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7827f;
import com.huawei.openalliance.p169ad.utils.C7775bv;
import com.huawei.openalliance.p169ad.utils.C7845x;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.jy */
/* loaded from: classes8.dex */
public class C7351jy extends C7500c {

    /* renamed from: a */
    private Context f34289a;

    /* renamed from: b */
    private boolean f34290b = false;

    /* renamed from: c */
    private String f34291c = "POST";

    public C7351jy(Context context) {
        this.f34289a = context;
    }

    /* renamed from: a */
    private String m45433a(ReqBean reqBean, String str) {
        String strMo39254a = reqBean.mo39254a();
        String strValueOf = String.valueOf(AbstractC7741ao.m47566c());
        return "Digest username=" + str + ",realm=" + strMo39254a + ",nonce=" + strValueOf + ",response=" + m45434a(str, strMo39254a, strValueOf, reqBean.mo39255a(this.f34289a), reqBean.mo39256b()) + ",algorithm=HmacSHA256";
    }

    /* renamed from: b */
    private void m45436b() {
        String strMo41173b = C6982bz.m41148a(this.f34289a).mo41173b();
        if (AbstractC7806cz.m48165b(strMo41173b)) {
            return;
        }
        m46051a("X-HW-AD-Model", strMo41173b.toUpperCase(Locale.ENGLISH));
    }

    /* renamed from: c */
    private void m45438c() {
        if (AbstractC7806cz.m48165b(m46049a().get("X-HW-AD-Oaid")) && this.f34290b && !C6982bz.m41152b(this.f34289a) && C6982bz.m41148a(this.f34289a).mo41175d()) {
            m46051a("X-HW-AD-Androidid", AbstractC7807d.m48239g(this.f34289a));
        }
    }

    /* renamed from: d */
    private void m45439d() {
        String strM48538b = C7845x.m48538b();
        if (AbstractC7806cz.m48165b(strM48538b)) {
            return;
        }
        m46051a("X-HW-AD-Model", strM48538b.toUpperCase(Locale.ENGLISH));
    }

    /* renamed from: e */
    private void m45440e() {
        Pair<String, Boolean> pairM48217b = AbstractC7807d.m48217b(this.f34289a, true);
        if (pairM48217b == null || TextUtils.isEmpty((CharSequence) pairM48217b.first) || ((Boolean) pairM48217b.second).booleanValue()) {
            return;
        }
        m46051a("X-HW-AD-Oaid", (String) pairM48217b.first);
    }

    /* renamed from: a */
    private String m45434a(String str, String str2, String str3, String str4, String str5) {
        return AbstractC7742ap.m47597a(str + ":" + str2 + ":" + AbstractC7827f.m48400b(str4, AbstractC7796cp.m48082a(this.f34289a)), str3 + ":" + this.f34291c + ":" + str5);
    }

    /* renamed from: b */
    public void m45444b(ReqBean reqBean) {
        m46051a("X-HW-AD-Sdkver", Config.SDK_VERSION);
        m46051a("X-HW-App-Id", reqBean.mo39257c());
        m45437b(reqBean, "100003");
    }

    /* renamed from: b */
    private void m45437b(ReqBean reqBean, String str) {
        m45439d();
        m46051a(C5966j2.f27080v, Constants.GZIP);
        String strM45433a = m45433a(reqBean, str);
        if (!TextUtils.isEmpty(strM45433a)) {
            m46051a(FeedbackWebConstants.AUTHORIZATION, strM45433a);
        }
        m46051a("Content-Type", InterfaceC5483d.f25084j);
        m45440e();
    }

    /* renamed from: a */
    public void m45441a(ReqBean reqBean) {
        Pair pair;
        m45436b();
        m46051a("X-HW-AD-Sdkver", Config.SDK_VERSION);
        m46051a("X-HW-AD-Pkgname", this.f34289a.getPackageName());
        m46051a("X-HW-AD-Osver", Build.VERSION.RELEASE);
        if (reqBean instanceof EventReportReq) {
            m46051a("User-Agent", AbstractC7807d.m48247k(this.f34289a));
        }
        Pair<Integer, Pair<String, String>> pairM42943d = C7095ek.m42934a(this.f34289a).m42943d();
        if (pairM42943d == null) {
            pairM42943d = C7775bv.m47832f(this.f34289a);
        }
        if (pairM42943d != null && (pair = (Pair) pairM42943d.second) != null) {
            m46051a("X-HW-AD-Mcc", (String) pair.first);
            m46051a("X-HW-AD-Mnc", (String) pair.second);
        }
        m46051a(C5966j2.f27080v, Constants.GZIP);
        m46051a(FeedbackWebConstants.AUTHORIZATION, m45433a(reqBean, "100003"));
        m46051a("Content-Type", InterfaceC5483d.f25084j);
        m45440e();
        m45438c();
    }

    /* renamed from: a */
    public void m45442a(ConsentConfigReq consentConfigReq) {
        m46051a("X-HW-AD-KitVersion", consentConfigReq.m40944d());
        m46051a("X-HW-App-Id", consentConfigReq.mo39257c());
        m45437b(consentConfigReq, consentConfigReq.mo39257c());
    }

    /* renamed from: a */
    public static void m45435a(Map<String, String> map) {
        map.remove("X-HW-AD-Androidid");
        map.remove("X-HW-AD-Mcc");
        map.remove("X-HW-AD-Mnc");
    }

    /* renamed from: a */
    public void m45443a(boolean z10) {
        this.f34290b = z10;
    }
}
