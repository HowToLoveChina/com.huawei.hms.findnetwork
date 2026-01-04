package tm;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsApi;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.network.embedded.C5863b6;
import java.util.HashMap;
import java.util.Map;
import mk.C11477c;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p399jk.AbstractC10896a;
import p709vj.C13452e;

/* renamed from: tm.b */
/* loaded from: classes6.dex */
public class C13039b {

    /* renamed from: c */
    public static volatile boolean f59354c = false;

    /* renamed from: d */
    public static volatile String f59355d;

    /* renamed from: e */
    public static final Object f59356e = new Object();

    /* renamed from: f */
    public static final Object f59357f = new Object();

    /* renamed from: a */
    public Context f59358a;

    /* renamed from: b */
    public String f59359b;

    public C13039b() {
        m78592n(false);
    }

    /* renamed from: i */
    public static boolean m78591i() {
        return f59354c;
    }

    /* renamed from: n */
    public static synchronized void m78592n(boolean z10) {
        f59354c = z10;
    }

    /* renamed from: a */
    public synchronized String m78593a(String str, String str2) {
        if (!m78591i()) {
            AbstractC10896a.m65885d("GRSManager", "callGrsApiGetGrsUrlSync call getGrsUrl grs sdk need to init first, call grsSdkInit");
            m78595c();
            if (!m78602k(false)) {
                AbstractC10896a.m65886e("GRSManager", "callGrsApiGetGrsUrlSync grsSdkInit failed, call getGrsUrl abort");
                return null;
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        AbstractC10896a.m65885d("GRSManager", "callGrsApiGetGrsUrlSync call getGrsUrl start, time = " + jCurrentTimeMillis);
        String strSynGetGrsUrl = GrsApi.synGetGrsUrl(str, str2);
        AbstractC10896a.m65887i("GRSManager", "GrsUrlApi.getGrsUrl: " + (m78603l(str, str2) + " return " + strSynGetGrsUrl + ",totalTime= " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms"));
        return strSynGetGrsUrl;
    }

    /* renamed from: b */
    public synchronized Map<String, String> m78594b(String str) {
        HashMap map = new HashMap();
        if (!m78591i()) {
            AbstractC10896a.m65885d("GRSManager", "callGrsApiGetGrsUrlsSync call getGrsUrl grs sdk need to init first, call grsSdkInit");
            m78595c();
            if (!m78602k(false)) {
                AbstractC10896a.m65886e("GRSManager", "callGrsApiGetGrsUrlsSync grsSdkInit failed, call getGrsUrl abort");
                return map;
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        AbstractC10896a.m65885d("GRSManager", "callGrsApiGetGrsUrlsSync call getGrsUrls start, time = " + jCurrentTimeMillis);
        Map<String, String> mapSynGetGrsUrls = GrsApi.synGetGrsUrls(str);
        AbstractC10896a.m65887i("GRSManager", "GrsUrlApi.getGrsUrls: " + (str + " return ,totalTime= " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms"));
        return mapSynGetGrsUrls;
    }

    /* renamed from: c */
    public final void m78595c() {
        if (this.f59358a == null) {
            this.f59358a = C0213f.m1377a();
        }
    }

    /* renamed from: d */
    public void m78596d() {
        m78592n(false);
        f59355d = null;
    }

    /* renamed from: e */
    public void m78597e() {
        SharedPreferences sharedPreferencesM78601j = m78601j();
        if (sharedPreferencesM78601j == null) {
            return;
        }
        sharedPreferencesM78601j.edit().clear().commit();
    }

    /* renamed from: f */
    public void m78598f() {
        AbstractC10896a.m65887i("GRSManager", "foreRefreshGrsUrl");
        try {
            GrsApi.forceExpire();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("GRSManager", "foreRefreshGrsUrl error " + e10.toString());
        }
        m78597e();
    }

    /* renamed from: g */
    public final String m78599g(Context context) {
        String str;
        if (TextUtils.isEmpty(this.f59359b)) {
            this.f59359b = C13452e.m80781L().m80942m();
            str = "";
        } else {
            str = this.f59359b;
        }
        if (TextUtils.isEmpty(this.f59359b)) {
            AbstractC10896a.m65887i("GRSManager", "cloud not login,use phone finder countryCode to init grs");
            this.f59359b = C11477c.m68633c(C13042e.m78685c().m78688b("key_country_code"));
        }
        if (!TextUtils.isEmpty(this.f59359b)) {
            str = this.f59359b;
        }
        if (TextUtils.isEmpty(this.f59359b)) {
            this.f59359b = C0209d.m1328y0(context);
        }
        if (!TextUtils.isEmpty(this.f59359b)) {
            str = this.f59359b;
        }
        AbstractC10896a.m65885d("GRSManager", "getAccountRegCountryCode countryCode = " + str);
        return str;
    }

    /* renamed from: h */
    public String m78600h() {
        if (m78591i()) {
            return f59355d;
        }
        return null;
    }

    /* renamed from: j */
    public final SharedPreferences m78601j() {
        return C0214f0.m1382b(this.f59358a, "url_request_fail_record", 0);
    }

    /* renamed from: k */
    public final boolean m78602k(boolean z10) {
        synchronized (f59357f) {
            try {
                if (m78591i() && !z10) {
                    return true;
                }
                Context context = this.f59358a;
                if (context == null) {
                    AbstractC10896a.m65887i("GRSManager", "grsSdkInit failed，context is null");
                    return false;
                }
                String strM78599g = m78599g(context);
                if (TextUtils.isEmpty(strM78599g)) {
                    AbstractC10896a.m65887i("GRSManager", "grsSdkInit failed，countryCode is null");
                    return false;
                }
                f59355d = strM78599g;
                GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
                grsBaseInfo.setAppName("hicloud");
                grsBaseInfo.setRegCountry(strM78599g);
                grsBaseInfo.setCountrySource("APP");
                GrsApi.grsSdkInit(this.f59358a, grsBaseInfo);
                m78592n(true);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: l */
    public String m78603l(String str, String str2) {
        return str + "." + str2;
    }

    /* renamed from: m */
    public final void m78604m(boolean z10) {
        if (m78591i()) {
            m78602k(z10);
            AbstractC10896a.m65887i("GRSManager", "routingInit exit, grs sdk has been initialized, no need to init");
        } else if (this.f59358a == null) {
            AbstractC10896a.m65888w("GRSManager", "routingInit failed，Context is null");
        } else {
            m78602k(z10);
        }
    }

    /* renamed from: o */
    public void m78605o(Context context) {
        if (context != null) {
            this.f59358a = context;
        }
    }

    /* renamed from: p */
    public void m78606p(String str) {
        this.f59359b = str;
    }

    /* renamed from: q */
    public void m78607q(String str) {
        synchronized (f59356e) {
            try {
                if (TextUtils.isEmpty(str)) {
                    AbstractC10896a.m65888w("GRSManager", "urlRequestFail host is empty");
                    return;
                }
                SharedPreferences sharedPreferencesM78601j = m78601j();
                if (sharedPreferencesM78601j == null) {
                    return;
                }
                long j10 = sharedPreferencesM78601j.getLong(str, -1L);
                if (j10 > 0 && sharedPreferencesM78601j.contains(str)) {
                    if (System.currentTimeMillis() - j10 > C5863b6.g.f26453g) {
                        AbstractC10896a.m65887i("GRSManager", "urlRequestFail host = " + str);
                        m78598f();
                        m78602k(true);
                        C13452e.m80781L().m80988x1("from_url_request_fail");
                    }
                    return;
                }
                Map<String, ?> all = sharedPreferencesM78601j.getAll();
                if (all != null && all.size() > 50) {
                    sharedPreferencesM78601j.edit().clear().commit();
                    AbstractC10896a.m65888w("GRSManager", "urlRequestFail url-host map beyond 50, clear sp");
                }
                sharedPreferencesM78601j.edit().putLong(str, System.currentTimeMillis()).commit();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: r */
    public void m78608r(String str) {
        synchronized (f59356e) {
            try {
                if (TextUtils.isEmpty(str)) {
                    AbstractC10896a.m65888w("GRSManager", "urlRequestSuccess host is empty");
                    return;
                }
                SharedPreferences sharedPreferencesM78601j = m78601j();
                if (sharedPreferencesM78601j == null) {
                    return;
                }
                if (sharedPreferencesM78601j.contains(str)) {
                    sharedPreferencesM78601j.edit().remove(str).commit();
                    AbstractC10896a.m65887i("GRSManager", "urlRequestSuccess remove host = " + str);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
