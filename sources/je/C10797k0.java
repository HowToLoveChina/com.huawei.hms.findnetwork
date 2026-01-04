package je;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import ca.C1398a;
import ca.C1403f;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.hwcloudjs.C6618c;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import dj.C9158a;
import fk.C9721b;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0213f;
import p315gj.C9948a;
import p315gj.C9949b;
import p360i7.C10451a;
import p514o9.C11829c;
import p514o9.C11839m;
import p616rk.C12515a;
import p651t8.C12996d;
import p652t9.EnumC12999a;
import p684un.C13225d;
import p709vj.C13452e;
import p846zj.C14306d;
import to.C13049a;

/* renamed from: je.k0 */
/* loaded from: classes3.dex */
public class C10797k0 {

    /* renamed from: c */
    public static String f51552c;

    /* renamed from: d */
    public static String f51553d;

    /* renamed from: a */
    public String f51554a;

    /* renamed from: b */
    public boolean f51555b;

    /* renamed from: je.k0$a */
    public class a implements Callable<String> {

        /* renamed from: a */
        public int f51556a;

        /* renamed from: b */
        public String f51557b;

        /* renamed from: c */
        public String f51558c;

        /* renamed from: d */
        public String f51559d;

        /* renamed from: e */
        public String f51560e;

        /* renamed from: f */
        public String f51561f;

        public a(int i10, String str, String str2, String str3, String str4, String str5) {
            this.f51556a = i10;
            this.f51557b = str;
            this.f51558c = str2;
            this.f51559d = str3;
            this.f51560e = str4;
            this.f51561f = str5;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public String call() throws JSONException, NumberFormatException {
            int i10;
            int iM60659c;
            C11839m.m70688i("WebViewManagerUtil", "start queryServiceInfoTask");
            JSONObject jSONObject = new JSONObject();
            try {
                int i11 = this.f51556a;
                i10 = 30000;
                if (i11 == 1) {
                    int iM85218s = C14306d.m85218s();
                    C10797k0.this.m65704m(1, iM85218s);
                    C11839m.m70688i("WebViewManagerUtil", "QueryServiceInfoTask refresh campagin service country result = " + iM85218s);
                    jSONObject = C10797k0.this.m65709r(30000, C9949b.m61704j().m61705a(this.f51557b, this.f51558c, this.f51559d, null, this.f51561f));
                } else if (i11 == 2) {
                    int iM85218s2 = C14306d.m85218s();
                    C10797k0.this.m65704m(1, iM85218s2);
                    C11839m.m70688i("WebViewManagerUtil", "QueryServiceInfoTask refresh bussiness service country result = " + iM85218s2);
                    jSONObject = C10797k0.this.m65709r(30000, C9948a.m61631C().m61662c(this.f51557b, this.f51558c, null, this.f51561f));
                } else if (i11 == 3) {
                    jSONObject = C10797k0.this.m65709r(30000, C10803q.m65748c().m65753f(this.f51557b, this.f51558c, null));
                } else if (i11 == 4) {
                    jSONObject = C10797k0.this.m65709r(30000, new C13049a(EnumC12999a.CLOUD_MORE, null, 20).m78727b(this.f51557b, this.f51558c, this.f51559d, null, this.f51561f));
                }
                iM60659c = 0;
            } catch (C9721b e10) {
                C11839m.m70686d("WebViewManagerUtil", "queryServiceInfoTask CException " + e10.getMessage());
                iM60659c = e10.m60659c();
                jSONObject = C10797k0.this.m65708q(e10);
                int i12 = -1;
                try {
                    String string = jSONObject.getString("responseCode");
                    if (!TextUtils.isEmpty(string)) {
                        i12 = Integer.parseInt(string);
                    }
                } catch (JSONException unused) {
                }
                i10 = i12;
            } catch (Exception e11) {
                C11839m.m70686d("WebViewManagerUtil", "queryServiceInfoTask Exception " + e11.getMessage());
                i10 = 30009;
                jSONObject = C10797k0.this.m65709r(30009, e11.getMessage());
                iM60659c = 30009;
            }
            String string2 = jSONObject.toString();
            this.f51560e = string2;
            C10797k0.this.m65705n(iM60659c, i10, string2);
            C11839m.m70688i("WebViewManagerUtil", "end queryServiceInfoTask");
            return this.f51560e;
        }
    }

    public C10797k0(String str) {
        this(str, false);
    }

    /* renamed from: e */
    public static void m65694e() {
        f51552c = "";
        f51553d = "";
    }

    /* renamed from: h */
    public static Map<String, String> m65695h() throws JSONException {
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(C1398a.m8018k());
            String string = jSONObject.getString(NotifyConstants.MarketingConstant.CID_KEY);
            String string2 = jSONObject.getString("adId");
            String string3 = jSONObject.getString(NotifyConstants.MarketingConstant.CSOURCE_KEY);
            map.put(NotifyConstants.MarketingConstant.CID_KEY, string);
            map.put("adId", string2);
            map.put(NotifyConstants.MarketingConstant.CSOURCE_KEY, string3);
        } catch (Exception e10) {
            C11839m.m70688i("WebViewManagerUtil", "JSONException: " + e10.getMessage());
        }
        return map;
    }

    /* renamed from: v */
    public static void m65696v(Handler handler, String str, String str2) {
        C11839m.m70688i("WebViewManagerUtil", "reportCampaignDownload: " + str + " " + str2);
        Map<String, String> mapM65695h = m65695h();
        mapM65695h.put("cType", "dlApp");
        if (!C13452e.m80781L().m80803F0().booleanValue()) {
            m65697w(handler, str, str2);
            return;
        }
        mapM65695h.put("dlItem", str);
        mapM65695h.put("timestamp", String.valueOf(System.currentTimeMillis()));
        mapM65695h.put("version", String.valueOf(4));
        mapM65695h.put(FaqConstants.FAQ_CHANNEL, str2);
        C9158a.m57503F().m57538e0(handler, mapM65695h);
    }

    /* renamed from: w */
    public static void m65697w(Handler handler, String str, String str2) {
        if (StringUtil.equals(str, f51552c) && StringUtil.equals(str2, f51553d)) {
            C11839m.m70688i("WebViewManagerUtil", "app name is same and not reported:" + str + " " + str2);
            return;
        }
        C11839m.m70688i("WebViewManagerUtil", "reportCampaignLaunched: " + str + " " + str2);
        f51552c = str;
        f51553d = str2;
        Map<String, String> mapM65695h = m65695h();
        mapM65695h.put("cType", "dlApp");
        mapM65695h.put("launchItem", str);
        mapM65695h.put("timestamp", String.valueOf(System.currentTimeMillis()));
        mapM65695h.put("version", String.valueOf(4));
        mapM65695h.put(FaqConstants.FAQ_CHANNEL, str2);
        C9158a.m57503F().m57540f0(handler, mapM65695h, str);
    }

    /* renamed from: f */
    public final void m65698f(String str, String str2, String str3) {
        if (!C1403f.m8066n().m8105w()) {
            C11839m.m70688i("WebViewManagerUtil", "reportClickEvent click om not support");
            return;
        }
        C11839m.m70686d("WebViewManagerUtil", "reportClickEvent, ReportAGEventTask");
        C12515a.m75110o().m75175e(new C10451a(str, str2, str3, "click", this.f51555b), false);
    }

    /* renamed from: g */
    public Bundle m65699g(String str) {
        Bundle bundle = new Bundle();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strOptString = jSONObject.optString(next);
                if (strOptString != null) {
                    bundle.putString(next, strOptString);
                }
            }
        } catch (JSONException e10) {
            C11839m.m70688i("WebViewManagerUtil", "JSONException: " + e10.getMessage());
        }
        return bundle;
    }

    /* renamed from: i */
    public final INativeAd m65700i(String str, String str2) {
        return this.f51555b ? C12996d.m77971n().m77999m(str, str2) : C1403f.m8066n().m8098p(str, str2);
    }

    /* renamed from: j */
    public String m65701j(String str, String[] strArr, int i10, String str2, String str3, String str4, String str5) {
        C11839m.m70686d("WebViewManagerUtil", "GetOperationResp, serviceType = " + i10 + ", cmd = " + str2 + ", reqBody = " + str3 + ", method = " + str4 + ", omExpandHeader = " + str5);
        String str6 = "";
        if (!C11829c.m70583i(str, strArr, "getOperationResp")) {
            C11839m.m70687e("WebViewManagerUtil", "GetOperationResp, url is invalid");
            m65707p(C11829c.m70560a0(str), Arrays.toString(strArr));
            return "";
        }
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(2);
        try {
            try {
                try {
                    m65703l(i10, str2, str3, str4);
                } catch (InterruptedException | ExecutionException e10) {
                    C11839m.m70687e("WebViewManagerUtil", "getOperationResp exception " + e10.getMessage());
                    m65705n(PayStatusCodes.ORDER_STATUS_HANDLING, PayStatusCodes.ORDER_STATUS_HANDLING, String.valueOf(PayStatusCodes.ORDER_STATUS_HANDLING));
                }
            } catch (TimeoutException e11) {
                C11839m.m70687e("WebViewManagerUtil", "getOperationResp timeout exception " + e11.getMessage());
                m65705n(PayStatusCodes.PAY_STATE_NO_SUPPORT, PayStatusCodes.PAY_STATE_NO_SUPPORT, String.valueOf(PayStatusCodes.PAY_STATE_NO_SUPPORT));
            }
            if (TextUtils.isEmpty(str2)) {
                m65705n(PayStatusCodes.PAY_STATE_PARAM_ERROR, PayStatusCodes.PAY_STATE_PARAM_ERROR, String.valueOf(PayStatusCodes.PAY_STATE_PARAM_ERROR));
                return m65709r(PayStatusCodes.PAY_STATE_PARAM_ERROR, "cmd is empty").toString();
            }
            if (TextUtils.isEmpty(str3)) {
                m65705n(PayStatusCodes.PAY_STATE_PARAM_ERROR, PayStatusCodes.PAY_STATE_PARAM_ERROR, String.valueOf(PayStatusCodes.PAY_STATE_PARAM_ERROR));
                return m65709r(PayStatusCodes.PAY_STATE_PARAM_ERROR, "reqBody is empty").toString();
            }
            if (!C0209d.m1208S0(C0213f.m1377a())) {
                m65705n(30004, 30004, String.valueOf(30004));
                return m65709r(30004, "net is inavailable").toString();
            }
            Future futureSubmit = executorServiceNewFixedThreadPool.submit(new a(i10, str2, str3, str4, "", str5));
            str6 = futureSubmit != null ? (String) futureSubmit.get(20L, TimeUnit.SECONDS) : "";
            C11839m.m70686d("WebViewManagerUtil", "getOperationResp, response = " + str6);
            return str6;
        } finally {
            executorServiceNewFixedThreadPool.shutdown();
        }
    }

    /* renamed from: k */
    public final boolean m65702k(String str, String str2, String str3) {
        if (!C1403f.m8066n().m8105w()) {
            C11839m.m70688i("WebViewManagerUtil", "recordImpressionEvent show om not support");
            C1403f.m8066n().m8071E(str, str2, "impression_agd_ads_event", "N");
            return true;
        }
        C11839m.m70686d("WebViewManagerUtil", "recordImpressionEvent, ReportAGEventTask");
        C12515a.m75110o().m75175e(new C10451a(str, str2, str3, ParamConstants.CallbackMethod.ON_SHOW, this.f51555b), false);
        return true;
    }

    /* renamed from: l */
    public final void m65703l(int i10, String str, String str2, String str3) {
        HashMap map = new HashMap();
        map.put(NotifyConstants.NotificationReport.PARAM_WISEMARKETING_TRACE_ID, this.f51554a);
        map.put(NotifyConstants.NotificationReport.PARAM_WISEMARKETING_SERVICETYPE, String.valueOf(i10));
        map.put("cmd", str);
        map.put(NotifyConstants.NotificationReport.PARAM_WISEMARKETING_REQUEST_BODY, str2);
        map.put("method", str3);
        NotificationReportUtil.reportWiseMarketingOperaitonResult("0019", map, NotifyConstants.NotificationReport.RESULT_NAME_WISEMARKETING_SUC);
    }

    /* renamed from: m */
    public final void m65704m(int i10, int i11) {
        HashMap map = new HashMap();
        map.put(NotifyConstants.NotificationReport.PARAM_WISEMARKETING_TRACE_ID, this.f51554a);
        map.put(NotifyConstants.NotificationReport.PARAM_WISEMARKETING_REFRESH_SERVICE_COUNTRY_OPERATION, String.valueOf(i10));
        map.put(NotifyConstants.NotificationReport.PARAM_WISEMARKETING_REFRESH_SERVICE_COUNTRY_RESULT, String.valueOf(i11));
        NotificationReportUtil.reportWiseMarketingOperaitonResult("0021", map, String.valueOf(i11));
    }

    /* renamed from: n */
    public final void m65705n(int i10, int i11, String str) {
        HashMap map = new HashMap();
        map.put(NotifyConstants.NotificationReport.PARAM_WISEMARKETING_TRACE_ID, this.f51554a);
        map.put(NotifyConstants.NotificationReport.PARAM_WISEMARKETING_REFRESH_SERVICE_ORIGIN_RESULT_CODE, String.valueOf(i10));
        map.put(NotifyConstants.NotificationReport.PARAM_WISEMARKETING_REFRESH_SERVICE_RESPONSE_RESULT_CODE, String.valueOf(i11));
        if (i11 != 30000) {
            map.put(NotifyConstants.NotificationReport.PARAM_WISEMARKETING_REFRESH_SERVICE_RESPONSE, str);
        }
        NotificationReportUtil.reportWiseMarketingOperaitonResult("0020", map, String.valueOf(i11));
    }

    /* renamed from: o */
    public void m65706o(String str) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(NotifyConstants.NotificationReport.PARAM_WISEMARKETING_TRACE_ID, this.f51554a);
        linkedHashMap.put(NotifyConstants.NotificationReport.PARAM_WEBVIEW_SHARE_APP, str);
        NotificationReportUtil.reportWiseMarketingOperaitonResult("0023", linkedHashMap, String.valueOf(true));
        C13225d.m79490f1().m79567R("0023", linkedHashMap);
        UBAAnalyze.m29958S("CKC", "0023", "3", "47", linkedHashMap);
    }

    /* renamed from: p */
    public void m65707p(String str, String str2) {
        HashMap map = new HashMap();
        map.put(NotifyConstants.NotificationReport.PARAM_WISEMARKETING_TRACE_ID, this.f51554a);
        map.put(NotifyConstants.NotificationReport.PARAM_WEBVIEW_CURRENT_HOST, str);
        map.put(NotifyConstants.NotificationReport.PARAM_WEBVIEW_WHITE_LIST, str2);
        map.put(NotifyConstants.NotificationReport.PARAM_WEBVIEW_WHITE_LIST_CHECK_RESULT, String.valueOf(false));
        NotificationReportUtil.reportWiseMarketingOperaitonResult("0022", map, String.valueOf(false));
    }

    /* renamed from: q */
    public final JSONObject m65708q(C9721b c9721b) {
        C11839m.m70687e("WebViewManagerUtil", "processConnectionException errorCode = " + c9721b.m60659c() + ", errorMsg = " + c9721b.getMessage());
        int iM60659c = c9721b.m60659c();
        if (iM60659c != 1) {
            if (iM60659c == 6) {
                return m65709r(30007, c9721b.getMessage());
            }
            if (iM60659c == 1199) {
                return m65709r(30004, c9721b.getMessage());
            }
            if (iM60659c == 3012) {
                return m65709r(PayStatusCodes.PAY_STATE_TIME_OUT, c9721b.getMessage());
            }
            if (iM60659c != 4002) {
                if (iM60659c != 9100) {
                    if (iM60659c != 30001) {
                        if (iM60659c == 30005 || iM60659c == 30010) {
                            return m65709r(c9721b.m60659c(), c9721b.getMessage());
                        }
                        switch (iM60659c) {
                            case ConnectionResult.NETWORK_ERROR /* 9000 */:
                            case ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED /* 9002 */:
                            case 9003:
                            case ConnectionResult.SERVICE_UPDATING /* 9004 */:
                            case ConnectionResult.SIGN_IN_FAILED /* 9005 */:
                            case C6618c.f30770o /* 9006 */:
                            case 9007:
                                break;
                            case ConnectionResult.RESOLUTION_REQUIRED /* 9001 */:
                                return m65709r(30003, c9721b.getMessage());
                            default:
                                return m65709r(30008, c9721b.getMessage());
                        }
                    }
                }
            }
            return m65709r(PayStatusCodes.PAY_STATE_PARAM_ERROR, c9721b.getMessage());
        }
        return m65709r(PayStatusCodes.PAY_OTHER_ERROR, c9721b.getMessage());
    }

    /* renamed from: r */
    public final JSONObject m65709r(int i10, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("responseCode", i10);
            jSONObject.put("responseMessage", str);
        } catch (JSONException e10) {
            C11839m.m70687e("WebViewManagerUtil", "putJsonResult error " + e10.getMessage());
        }
        return jSONObject;
    }

    /* renamed from: s */
    public boolean m65710s(String str, String[] strArr, String str2, String str3, String str4) {
        if (!C11829c.m70583i(str, strArr, "recordClickEvent")) {
            C11839m.m70687e("WebViewManagerUtil", "recordClickEvent, url is invalid");
            m65707p(C11829c.m70560a0(str), Arrays.toString(strArr));
            return false;
        }
        INativeAd iNativeAdM65700i = m65700i(str2, str3);
        if (iNativeAdM65700i == null) {
            C11839m.m70687e("WebViewManagerUtil", "recordClickEvent, ad is null");
            return false;
        }
        C11839m.m70688i("WebViewManagerUtil", "recordClickEvent,uniqueId: " + str3);
        return iNativeAdM65700i.recordClickEvent(C0213f.m1377a(), m65699g(str4));
    }

    /* renamed from: t */
    public boolean m65711t(String str, String[] strArr, String str2, String str3, String str4) {
        C11839m.m70688i("WebViewManagerUtil", "recordImpressionEvent reportAGEvent adId: " + str2 + " uniqueId: " + str3);
        if (!C11829c.m70583i(str, strArr, "recordImpressionEvent")) {
            C11839m.m70687e("WebViewManagerUtil", "recordImpressionEvent, url is invalid");
            m65707p(C11829c.m70560a0(str), Arrays.toString(strArr));
            return false;
        }
        if (this.f51555b) {
            if (!C12996d.m77971n().m78000q(str2)) {
                return m65702k(str2, str3, str4);
            }
            INativeAd iNativeAdM77999m = C12996d.m77971n().m77999m(str2, str3);
            if (iNativeAdM77999m == null) {
                C11839m.m70687e("WebViewManagerUtil", "recordImpressionEvent, ad is null");
                return false;
            }
            C11839m.m70686d("WebViewManagerUtil", "recordImpressionEvent, recordImpressionEvent");
            return iNativeAdM77999m.recordImpressionEvent(C0213f.m1377a(), m65699g(str4));
        }
        if (!C1403f.m8066n().m8103u(str2, str3) && !C1403f.m8066n().m8104v(str2, str3)) {
            if (C1403f.m8066n().m8100r(str2)) {
                return m65702k(str2, str3, str4);
            }
            C11839m.m70686d("WebViewManagerUtil", "recordImpressionEvent, null");
            return true;
        }
        INativeAd iNativeAdM8098p = C1403f.m8066n().m8098p(str2, str3);
        if (iNativeAdM8098p == null) {
            C11839m.m70687e("WebViewManagerUtil", "recordImpressionEvent, ad is null");
            return false;
        }
        C11839m.m70686d("WebViewManagerUtil", "recordImpressionEvent, recordImpressionEvent");
        return iNativeAdM8098p.recordImpressionEvent(C0213f.m1377a(), m65699g(str4));
    }

    /* renamed from: u */
    public boolean m65712u(String str, String[] strArr, String str2, String str3, String str4) {
        if (!C11829c.m70583i(str, strArr, "recordShowStartEvent")) {
            C11839m.m70687e("WebViewManagerUtil", "recordShowStartEvent, url is invalid");
            m65707p(C11829c.m70560a0(str), Arrays.toString(strArr));
            return false;
        }
        INativeAd iNativeAdM65700i = m65700i(str2, str3);
        if (iNativeAdM65700i == null) {
            C11839m.m70687e("WebViewManagerUtil", "recordShowStartEvent, ad is null");
            return false;
        }
        C11839m.m70686d("WebViewManagerUtil", "recordShowStartEvent, recordShowStartEvent");
        return iNativeAdM65700i.recordShowStartEvent(C0213f.m1377a(), m65699g(str4));
    }

    /* renamed from: x */
    public void m65713x(String str, String[] strArr, String str2, String str3, String str4) {
        C11839m.m70688i("WebViewManagerUtil", "reportClickEvent reportAGEvent adId: " + str2 + " uniqueId: " + str3);
        if (!C11829c.m70583i(str, strArr, "reportClickEvent")) {
            C11839m.m70687e("WebViewManagerUtil", "reportClickEvent, url is invalid");
            m65707p(C11829c.m70560a0(str), Arrays.toString(strArr));
        } else if (this.f51555b) {
            if (C12996d.m77971n().m78000q(str2)) {
                return;
            }
            m65698f(str2, str3, str4);
        } else if (C1403f.m8066n().m8100r(str2)) {
            m65698f(str2, str3, str4);
        }
    }

    /* renamed from: y */
    public void m65714y(String str, String[] strArr, String str2, String str3, String str4) {
        if (!C11829c.m70583i(str, strArr, "triggerClick")) {
            C11839m.m70687e("WebViewManagerUtil", "triggerClick, url is invalid");
            m65707p(C11829c.m70560a0(str), Arrays.toString(strArr));
            return;
        }
        C11839m.m70688i("WebViewManagerUtil", str4);
        INativeAd iNativeAdM65700i = m65700i(str2, str3);
        if (iNativeAdM65700i == null) {
            C11839m.m70687e("WebViewManagerUtil", "triggerClick, ad is null");
        } else {
            C11839m.m70686d("WebViewManagerUtil", "triggerClick, triggerClick");
            iNativeAdM65700i.triggerClick(C0213f.m1377a(), m65699g(str4));
        }
    }

    public C10797k0(String str, boolean z10) {
        this.f51554a = str;
        this.f51555b = z10;
    }
}
