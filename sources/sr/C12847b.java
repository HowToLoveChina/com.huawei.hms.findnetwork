package sr;

import android.text.TextUtils;
import as.C1016d;
import com.huawei.feedback.constant.FeedbackConst;
import com.huawei.hms.commonkit.config.Config;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.location.BuildConfig;
import com.huawei.location.lite.common.adapter.CountryCodeAdapter;
import es.C9538c;
import es.C9552q;
import es.C9555t;
import gs.C10043a;
import gs.C10044b;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p531or.C11991a;

/* renamed from: sr.b */
/* loaded from: classes8.dex */
public class C12847b {

    /* renamed from: a */
    public static String f58587a;

    /* renamed from: b */
    public static String m77147b(String str, String str2, String str3) {
        if (C10044b.m62450a(str)) {
            return null;
        }
        if (TextUtils.equals(str2, BuildConfig.LIBRARY_PACKAGE_NAME)) {
            return m77152g("SG", str2, str3);
        }
        if (!TextUtils.equals("UNKNOWN", str) && (TextUtils.equals(str3, "LOGSERVERROUTE") || TextUtils.equals(str2, "LOGSERVERROUTE"))) {
            return m77152g("SG", str2, str3);
        }
        if (TextUtils.equals(str2, "com.huawei.tsms") && C9552q.m59643a() == 100) {
            return m77152g("SG", str2, str3);
        }
        return null;
    }

    /* renamed from: c */
    public static String m77148c(String str, String str2, String str3) {
        String strM77152g = m77152g(str, str2, str3);
        return !TextUtils.isEmpty(strM77152g) ? strM77152g : m77147b(str, str2, str3);
    }

    /* renamed from: d */
    public static String m77149d(String str) {
        return m77151f(C10043a.m62448a(), str, "ROOT");
    }

    /* renamed from: e */
    public static String m77150e(String str, String str2) {
        return m77151f(str, str2, "ROOT");
    }

    /* renamed from: f */
    public static String m77151f(final String str, final String str2, final String str3) {
        String str4;
        String str5;
        if (CountryCodeAdapter.isCountryCodeSet()) {
            C1016d.m6186f("LocationNlpGrsHelper", "use app countryCode, before: " + str + ", after: " + CountryCodeAdapter.getCountryCode());
            str = CountryCodeAdapter.getCountryCode();
        }
        FutureTask futureTask = new FutureTask(new Callable() { // from class: sr.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return C12847b.m77154i(str2, str, str3);
            }
        });
        try {
            futureTask.run();
            str5 = (String) futureTask.get(5L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            str4 = "getGrsHostAddress future interr error";
            C1016d.m6183c("LocationNlpGrsHelper", str4);
            str5 = null;
            C1016d.m6181a("LocationNlpGrsHelper", "getGrsHostAddress finally serviceName:" + str2 + ", host:" + str5);
            return str5;
        } catch (ExecutionException unused2) {
            str4 = "getGrsHostAddress future exec error";
            C1016d.m6183c("LocationNlpGrsHelper", str4);
            str5 = null;
            C1016d.m6181a("LocationNlpGrsHelper", "getGrsHostAddress finally serviceName:" + str2 + ", host:" + str5);
            return str5;
        } catch (TimeoutException unused3) {
            str4 = "getGrsHostAddress future timeOut error";
            C1016d.m6183c("LocationNlpGrsHelper", str4);
            str5 = null;
            C1016d.m6181a("LocationNlpGrsHelper", "getGrsHostAddress finally serviceName:" + str2 + ", host:" + str5);
            return str5;
        }
        C1016d.m6181a("LocationNlpGrsHelper", "getGrsHostAddress finally serviceName:" + str2 + ", host:" + str5);
        return str5;
    }

    /* renamed from: g */
    public static String m77152g(String str, String str2, String str3) {
        String string;
        if (C9552q.m59643a() == 100) {
            GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
            if (TextUtils.equals(str2, "SITEROUTE") || TextUtils.equals(str2, "HIANALYTICROUTE")) {
                grsBaseInfo.setIssueCountry(str.toUpperCase(Locale.ROOT));
            } else {
                grsBaseInfo.setSerCountry(str.toUpperCase(Locale.ROOT));
            }
            string = new GrsClient(C11991a.m72145a(), grsBaseInfo).synGetGrsUrl(str2, str3);
        } else {
            Locale locale = Locale.ENGLISH;
            string = Config.getString("GRS", "grs://" + str2 + "/" + str3 + "?issueCountry=" + str + "&serCountry=" + str + "&regCountry=" + str);
        }
        f58587a = str;
        C1016d.m6186f("LocationNlpGrsHelper", "getGrsHostAddress serviceName:" + str2 + ", host:" + string + ", addressesKey:" + str3 + ", countryCode:" + str);
        return string;
    }

    /* renamed from: h */
    public static String m77153h() {
        return m77152g("UNKNOWN", BuildConfig.LIBRARY_PACKAGE_NAME, "ROOT");
    }

    /* renamed from: i */
    public static /* synthetic */ String m77154i(String str, String str2, String str3) throws Exception {
        String strM77148c;
        str.getClass();
        switch (str) {
            case "SITEROUTE":
            case "HIGEOROUTE":
                strM77148c = m77148c(str2, BuildConfig.LIBRARY_PACKAGE_NAME, str);
                break;
            case "HIANALYTICROUTE":
            case "LOGSERVERROUTE":
            case "MAPROUTE":
            case "AGREEMENTROUTE":
                strM77148c = m77148c(str2, "com.huawei.location.extService", str);
                break;
            case "com.huawei.hms.oobe":
                Locale locale = Locale.ENGLISH;
                strM77148c = Config.getString("GRS", "grs://" + str + "/ROOT");
                break;
            default:
                strM77148c = m77148c(str2, str, str3);
                break;
        }
        if (!TextUtils.isEmpty(strM77148c) || !str.equals("LOGSERVERROUTE") || C9538c.m59567f(C11991a.m72145a()) != 8) {
            return strM77148c;
        }
        C1016d.m6181a("LocationNlpGrsHelper", "host is null,device is car, getMcc()");
        return FeedbackConst.SDK.MCC_ZHCN.equals(C9555t.m59660e()) ? m77148c("CN", "com.huawei.location.extService", str) : strM77148c;
    }
}
