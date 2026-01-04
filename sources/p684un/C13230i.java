package p684un;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.hianalytics.p101v2.HiAnalytics;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.util.HiAnalyticTools;
import com.huawei.hicloud.base.bean.CloudSpace;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.NetworkKit;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import fk.C9721b;
import gp.C10028c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0216g0;
import p015ak.C0228m0;
import p399jk.AbstractC10896a;
import p429kk.C11058a;
import p429kk.C11059b;
import p429kk.C11060c;
import p581qk.AbstractC12367d;
import p581qk.AbstractC12368e;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p709vj.C13452e;
import p746wn.C13622a;
import p846zj.C14306d;
import tm.C13040c;
import vn.C13469a;
import vn.C13470b;
import vn.C13471c;

/* renamed from: un.i */
/* loaded from: classes6.dex */
public class C13230i {

    /* renamed from: a */
    public static Context f59873a = null;

    /* renamed from: b */
    public static String f59874b = "";

    /* renamed from: c */
    public static String f59875c = "";

    /* renamed from: d */
    public static boolean f59876d = false;

    /* renamed from: e */
    public static boolean f59877e;

    /* renamed from: g */
    public static String f59879g;

    /* renamed from: h */
    public static LinkedHashMap<String, String> f59880h;

    /* renamed from: i */
    public static HiAnalyticsConfig.Builder f59881i;

    /* renamed from: j */
    public static HiAnalyticsInstance f59882j;

    /* renamed from: k */
    public static HiAnalyticsInstance f59883k;

    /* renamed from: l */
    public static HiAnalyticsInstance f59884l;

    /* renamed from: m */
    public static HiAnalyticsInstance f59885m;

    /* renamed from: n */
    public static HiAnalyticsInstance f59886n;

    /* renamed from: o */
    public static HiAnalyticsInstance f59887o;

    /* renamed from: p */
    public static HiAnalyticsInstance f59888p;

    /* renamed from: f */
    public static CountDownLatch f59878f = new CountDownLatch(1);

    /* renamed from: q */
    public static final C13230i f59889q = new C13230i();

    /* renamed from: un.i$a */
    public class a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ Context f59890a;

        /* renamed from: b */
        public final /* synthetic */ String f59891b;

        public a(Context context, String str) {
            this.f59890a = context;
            this.f59891b = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws JSONException {
            AbstractC10896a.m65885d("HiAnalyticsUtil", "HiAnalyticsUtil init");
            Context unused = C13230i.f59873a = this.f59890a;
            String unused2 = C13230i.f59874b = this.f59891b;
            HiAnalyticsInstance unused3 = C13230i.f59882j = C13230i.this.m79550B("hicloudTag");
            HiAnalyticsInstance unused4 = C13230i.f59883k = C13230i.this.m79550B("clouddrive_common");
            HiAnalyticsInstance unused5 = C13230i.f59884l = C13230i.this.m79550B("clouddrive_cloudbackup");
            HiAnalyticsInstance unused6 = C13230i.f59885m = C13230i.this.m79550B("clouddrive_cloudsync");
            HiAnalyticsInstance unused7 = C13230i.f59886n = C13230i.this.m79550B("clouddrive_clouddisk");
            HiAnalyticsInstance unused8 = C13230i.f59887o = C13230i.this.m79550B("clouddrive_cloudalbum");
            HiAnalyticsInstance unused9 = C13230i.f59888p = C13230i.this.m79550B("clouddrive_find");
            C13230i.this.m79578X0("hicloudTag");
            C13230i.f59878f.countDown();
            if (C13230i.f59877e || TextUtils.isEmpty(C13230i.f59879g) || C13230i.f59880h.isEmpty()) {
                return;
            }
            C13230i.this.m79567R(C13230i.f59879g, C13230i.f59880h);
            C13230i.m79512W0(true, "", new LinkedHashMap());
        }
    }

    /* renamed from: un.i$b */
    public class b extends AbstractC12368e {

        /* renamed from: a */
        public final /* synthetic */ LinkedHashMap f59893a;

        /* renamed from: b */
        public final /* synthetic */ String f59894b;

        public b(LinkedHashMap linkedHashMap, String str) {
            this.f59893a = linkedHashMap;
            this.f59894b = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws InterruptedException {
            String strM80987x0 = C13452e.m80781L().m80987x0();
            if (TextUtils.isEmpty(strM80987x0)) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e10) {
                    AbstractC10896a.m65886e("HiAnalyticsUtil", "get userType error: " + e10.toString());
                }
                strM80987x0 = C13452e.m80781L().m80987x0();
            }
            this.f59893a.put("userType", strM80987x0);
            C13230i.this.m79567R(this.f59894b, this.f59893a);
            C13230i.this.m79573U(this.f59894b, this.f59893a);
            UBAAnalyze.m29947H("CKC", this.f59894b, this.f59893a);
        }
    }

    /* renamed from: un.i$c */
    public class c extends AbstractC12368e {

        /* renamed from: a */
        public final /* synthetic */ LinkedHashMap f59896a;

        /* renamed from: b */
        public final /* synthetic */ String f59897b;

        public c(LinkedHashMap linkedHashMap, String str) {
            this.f59896a = linkedHashMap;
            this.f59897b = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws InterruptedException {
            String strM80987x0 = C13452e.m80781L().m80987x0();
            if (TextUtils.isEmpty(strM80987x0)) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e10) {
                    AbstractC10896a.m65886e("HiAnalyticsUtil", "get userType error: " + e10.toString());
                }
                strM80987x0 = C13452e.m80781L().m80987x0();
            }
            this.f59896a.put("userType", strM80987x0);
            C13230i.this.m79567R(this.f59897b, this.f59896a);
            UBAAnalyze.m29947H("PVC", this.f59897b, this.f59896a);
        }
    }

    /* renamed from: un.i$d */
    public static class d extends AbstractC12367d {
        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            if (C13230i.f59882j != null) {
                C13230i.f59882j.clearData();
            }
            if (C13230i.f59887o != null) {
                C13230i.f59887o.clearData();
            }
            if (C13230i.f59883k != null) {
                C13230i.f59883k.clearData();
            }
            if (C13230i.f59886n != null) {
                C13230i.f59886n.clearData();
            }
            if (C13230i.f59885m != null) {
                C13230i.f59885m.clearData();
            }
            if (C13230i.f59888p != null) {
                C13230i.f59888p.clearData();
            }
            if (C13230i.f59884l != null) {
                C13230i.f59884l.clearData();
            }
        }
    }

    /* renamed from: un.i$e */
    public class e extends AbstractC12367d {

        /* renamed from: a */
        public LinkedHashMap<String, String> f59899a;

        public e(LinkedHashMap<String, String> linkedHashMap) {
            this.f59899a = linkedHashMap;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws InterruptedException {
            try {
                Thread.sleep(5000L);
                C13230i.this.m79567R("open_cloud_space", this.f59899a);
                UBAAnalyze.m29947H("CKC", "open_cloud_space", this.f59899a);
            } catch (Exception e10) {
                AbstractC10896a.m65886e("DelayReportOpenCloudTask", "sleep exception: " + e10.toString());
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.STOCK_ACTIVE;
        }
    }

    /* renamed from: A */
    public static LinkedHashMap<String, String> m79497A(String str) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("uid", str);
        return linkedHashMap;
    }

    /* renamed from: B0 */
    public static void m79498B0(LinkedHashMap linkedHashMap) {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07048"), "mecloud_main_ecology_load_error", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("0");
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
    }

    /* renamed from: C */
    public static LinkedHashMap m79499C(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("uid", str);
        return linkedHashMap;
    }

    /* renamed from: C0 */
    public static void m79500C0(Context context, String str, String str2, String str3) {
        try {
            boolean zM62221H1 = C10028c.m62182c0().m62221H1();
            if (context != null && zM62221H1 && C13452e.m80781L().m80850R0()) {
                C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07040"), "07040", C13452e.m80781L().m80971t0());
                c11060cM66626a.m66665u("0");
                HashMap map = new HashMap();
                map.put("interfaceName", str);
                map.put("externalModule", str2);
                map.put("methodName", str3);
                C13622a.m81969o(context, c11060cM66626a, map);
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "reportExternalInvoke exception:" + e10.toString());
        }
    }

    /* renamed from: D */
    public static String m79501D(Activity activity) {
        Intent intent;
        if (activity == null || (intent = activity.getIntent()) == null) {
            return "";
        }
        try {
            return intent.getStringExtra("hi_anlytics_type_refer");
        } catch (Exception unused) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "getActivityTypeValue getStringExtra Exception");
            return "";
        }
    }

    /* renamed from: E */
    public static String m79502E(Activity activity) {
        Intent intent;
        if (activity == null || (intent = activity.getIntent()) == null) {
            return "";
        }
        try {
            return intent.getStringExtra("hi_anlytics_type_value_refer");
        } catch (Exception unused) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "getActivityTypeValue getStringExtra Exception");
            return "";
        }
    }

    /* renamed from: F */
    public static String m79503F() {
        String strM78628T = "";
        try {
            strM78628T = C13040c.m78609F().m78628T("com.huawei.cloud.hianalytics", "HIANALYTICS", "");
            AbstractC10896a.m65885d("HiAnalyticsUtil", "get url from grs: " + strM78628T);
        } catch (C9721b unused) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "get grs url error " + strM78628T);
        }
        if (!TextUtils.isEmpty(strM78628T)) {
            C0212e0.m1372v(f59873a, "hianlytics_url", "hianlytics_url", strM78628T);
        }
        return strM78628T;
    }

    /* renamed from: I */
    public static C13230i m79504I() {
        return f59889q;
    }

    /* renamed from: K */
    public static String m79505K() {
        if (f59876d) {
            return m79503F();
        }
        String strM1363m = C0212e0.m1363m(f59873a, "hianlytics_url", "hianlytics_url", "");
        AbstractC10896a.m65885d("HiAnalyticsUtil", "get url from sp:" + strM1363m);
        return strM1363m;
    }

    /* renamed from: N */
    public static boolean m79506N() {
        if (!C10028c.m62182c0().m62221H1()) {
            AbstractC10896a.m65885d("HiAnalyticsUtil", "disagree hicloud terms");
            return false;
        }
        if (!TextUtils.isEmpty(f59875c) && !TextUtils.isEmpty(f59874b)) {
            return true;
        }
        AbstractC10896a.m65887i("HiAnalyticsUtil", "hiAnalyticsURL or useID is empty");
        return false;
    }

    /* renamed from: N0 */
    public static void m79507N0(LinkedHashMap linkedHashMap) {
        if (linkedHashMap != null) {
            linkedHashMap.put("brand_type", C0209d.m1285n1() ? "0" : C0209d.m1269j1() ? "1" : "-1");
        } else {
            AbstractC10896a.m65887i("HiAnalyticsUtil", "reportPhoneType eventObject is null");
        }
    }

    /* renamed from: O */
    public static boolean m79508O(boolean z10) {
        if (!z10) {
            AbstractC10896a.m65885d("HiAnalyticsUtil", "disagree hicloud terms");
            return false;
        }
        if (!TextUtils.isEmpty(f59875c) && !TextUtils.isEmpty(f59874b)) {
            return true;
        }
        AbstractC10896a.m65887i("HiAnalyticsUtil", "hiAnalyticsURL or useID is empty");
        return false;
    }

    /* renamed from: P */
    public static boolean m79509P(String str) {
        return "USER_TAGS_KEY".equals(str) || "userTag".equals(str);
    }

    /* renamed from: Q */
    public static HiAnalyticsInstance m79510Q(String str) {
        str.hashCode();
        switch (str) {
            case "clouddrive_common":
                return f59883k;
            case "clouddrive_clouddisk":
                return f59886n;
            case "clouddrive_cloudsync":
                return f59885m;
            case "clouddrive_cloudalbum":
                return f59887o;
            case "clouddrive_cloudbackup":
                return f59884l;
            case "clouddrive_find":
                return f59888p;
            default:
                return f59882j;
        }
    }

    /* renamed from: V0 */
    public static void m79511V0(HiAnalyticsConfig.Builder builder) {
        if (builder == null) {
            return;
        }
        boolean zM62221H1 = C10028c.m62182c0().m62221H1();
        if (!C13452e.m80781L().m80842P0() || !zM62221H1) {
            String strM79505K = m79505K();
            f59875c = strM79505K;
            builder.setCollectURL(strM79505K);
            AbstractC10896a.m65887i("HiAnalyticsUtil", "reset unlogin analytics url to " + f59875c);
            return;
        }
        try {
            f59875c = C13040c.m78609F().m78628T("com.huawei.cloud.hianalytics", "HIANALYTICS", "");
        } catch (C9721b unused) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "reset analytics url to " + f59875c);
        }
        builder.setCollectURL(f59875c);
        C0212e0.m1372v(f59873a, "hianlytics_url", "hianlytics_url", f59875c);
        AbstractC10896a.m65887i("HiAnalyticsUtil", "reset analytics url to " + f59875c);
    }

    /* renamed from: W0 */
    public static void m79512W0(boolean z10, String str, LinkedHashMap<String, String> linkedHashMap) {
        f59877e = z10;
        f59879g = str;
        f59880h = linkedHashMap;
    }

    /* renamed from: Y0 */
    public static void m79513Y0(LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap == null) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "map is null");
            return;
        }
        linkedHashMap.put("deviceId", C0228m0.m1597b().m1599c());
        linkedHashMap.put(JsbMapKeyNames.H5_DEVICE_TYPE, C0209d.m1209S1("6"));
        linkedHashMap.put("deviceUUID", C0228m0.m1597b().m1599c());
        linkedHashMap.put(FaqConstants.FAQ_ROMVERSION, C0209d.m1319w());
        linkedHashMap.put(FaqConstants.FAQ_EMUIVERSION, C0209d.m1186L());
        linkedHashMap.put("appVersion", "16.0.0.300");
        linkedHashMap.put("osBrand", C0209d.m1276l0());
        linkedHashMap.put("DEVICE_MANUFACTURER", C0209d.m1164E());
        linkedHashMap.put("DEVICE_BRAND", C0209d.m1160D());
        linkedHashMap.put("ACCOUNT_BRAND_ID", C14306d.m85201b());
        linkedHashMap.put("APP_BRAND_ID", C0209d.m1156C());
    }

    /* renamed from: Z0 */
    public static void m79514Z0(LinkedHashMap<String, String> linkedHashMap, boolean z10, boolean z11) {
        if (linkedHashMap == null) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "map is null");
            return;
        }
        if (m79537o0(linkedHashMap)) {
            m79539p0(linkedHashMap);
        } else {
            linkedHashMap.put(JsbMapKeyNames.H5_USER_ID, C13452e.m80781L().m80971t0());
        }
        linkedHashMap.put("userType", C13452e.m80781L().m80987x0());
        linkedHashMap.put("deviceId", z10 ? C13452e.m80781L().m80954p() : "");
        linkedHashMap.put(JsbMapKeyNames.H5_DEVICE_TYPE, z10 ? C13452e.m80781L().m80970t() : "");
        linkedHashMap.put("deviceUUID", C0228m0.m1597b().m1599c());
        linkedHashMap.put(FaqConstants.FAQ_ROMVERSION, C0209d.m1319w());
        linkedHashMap.put(FaqConstants.FAQ_EMUIVERSION, C0209d.m1186L());
        linkedHashMap.put("appVersion", "16.0.0.300");
        linkedHashMap.put("osBrand", C0209d.m1276l0());
        linkedHashMap.put("APP_BRAND_ID", C0209d.m1156C());
        linkedHashMap.put("data_state", String.valueOf(C13452e.m80781L().m80946n()));
        linkedHashMap.put("grade_code", C13452e.m80781L().m80790C());
        linkedHashMap.put("is_new_bm_type", String.valueOf(C13452e.m80781L().m80887a1()));
        if (z11) {
            linkedHashMap.put("ACCOUNT_BRAND_ID", C14306d.m85201b());
            linkedHashMap.put("userTag", C13452e.m80781L().m80979v0());
            linkedHashMap.put("DEVICE_MANUFACTURER", C0209d.m1164E());
            linkedHashMap.put("DEVICE_BRAND", C0209d.m1160D());
            C0216g0.m1402e(C0213f.m1377a()).m1415M(linkedHashMap);
        }
        m79524e0(linkedHashMap);
    }

    /* renamed from: a1 */
    public static void m79516a1(LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap == null) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "map is null");
            return;
        }
        try {
            Iterator<Map.Entry<String, String>> it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (UBAAnalyze.m29940A(key) || UBAAnalyze.m29941B(key) || m79509P(key)) {
                    linkedHashMap.put(key, "");
                }
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "setOnEventIdEmpty exception: " + e10.toString());
        }
    }

    /* renamed from: b1 */
    public static void m79518b1(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "map is null");
            return;
        }
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (UBAAnalyze.m29940A(next) || UBAAnalyze.m29941B(next) || m79509P(next)) {
                    jSONObject.put(next, "");
                }
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "setOnEventIdEmpty exception: " + e10.toString());
        }
    }

    /* renamed from: c1 */
    public static void m79520c1(String str, LinkedHashMap<String, String> linkedHashMap, boolean z10) {
        if (!m79506N()) {
            AbstractC10896a.m65885d("HiAnalyticsUtil", "user experience involved");
            return;
        }
        try {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.putAll(linkedHashMap);
            m79514Z0(linkedHashMap2, true, false);
            HiAnalytics.onEvent(1, str, (LinkedHashMap<String, String>) linkedHashMap2);
            if (z10) {
                HiAnalytics.onReport();
            }
            if (C1443a.f6214b.booleanValue()) {
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                linkedHashMap3.putAll(linkedHashMap2);
                m79516a1(linkedHashMap3);
                AbstractC10896a.m65885d("HiAnalyticsUtil", "syncDiskOMEvent:" + str + " values:" + linkedHashMap3.toString());
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "report exception: " + e10.toString());
        }
    }

    /* renamed from: d1 */
    public static void m79522d1(Bundle bundle, String str, String str2) {
        if (bundle == null) {
            return;
        }
        bundle.putString("hi_anlytics_type_value_refer", str2);
        bundle.putString("hi_anlytics_type_refer", str);
    }

    /* renamed from: e0 */
    public static void m79524e0(LinkedHashMap<String, String> linkedHashMap) {
        if (C11059b.m66634g().contains(linkedHashMap.get("operationType")) || C11059b.m66634g().contains(linkedHashMap.get("business_id"))) {
            linkedHashMap.remove("deviceId");
            linkedHashMap.remove("deviceUUID");
        }
    }

    /* renamed from: e1 */
    public static void m79525e1(Intent intent, String str, String str2) {
        if (intent == null) {
            return;
        }
        intent.putExtra("hi_anlytics_type_value_refer", str2);
        intent.putExtra("hi_anlytics_type_refer", str);
    }

    /* renamed from: n0 */
    public static void m79535n0(String str, LinkedHashMap<String, String> linkedHashMap, String str2) {
        if (C1443a.f6214b.booleanValue()) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.putAll(linkedHashMap);
            m79516a1(linkedHashMap2);
            AbstractC10896a.m65885d("HiAnalyticsUtil", str2 + " " + str + ", values:" + linkedHashMap2.toString());
        }
    }

    /* renamed from: o0 */
    public static boolean m79537o0(LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap.containsKey("operationType") && linkedHashMap.containsKey("business_id")) {
            return C11059b.m66629b().contains(linkedHashMap.get("operationType")) || C11059b.m66629b().contains(linkedHashMap.get("business_id"));
        }
        return false;
    }

    /* renamed from: p0 */
    public static void m79539p0(LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap.containsKey(HwPayConstant.KEY_USER_ID)) {
            linkedHashMap.remove("uid");
            linkedHashMap.remove(JsbMapKeyNames.H5_USER_ID);
        }
    }

    /* renamed from: u */
    public static void m79544u(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (i10 != 2 || TextUtils.isEmpty(str)) {
            return;
        }
        linkedHashMap.put("entranceOfRestore", str);
    }

    /* renamed from: v */
    public static void m79545v() throws InterruptedException {
        try {
            AbstractC10896a.m65887i("HiAnalyticsUtil", "awaitl start");
            AbstractC10896a.m65887i("HiAnalyticsUtil", "awaitResult = " + f59878f.await(1500L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e10) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "doInBackground exception:" + e10.toString());
        }
    }

    /* renamed from: w */
    public static LinkedHashMap m79546w(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("uid", C13452e.m80781L().m80971t0());
        linkedHashMap.put("tabName", str);
        return linkedHashMap;
    }

    /* renamed from: x */
    public static void m79547x() {
        f59874b = "";
        f59875c = "";
        C12515a.m75110o().m75172d(new d());
        AbstractC10896a.m65887i("HiAnalyticsUtil", "clean analytics");
    }

    /* renamed from: x0 */
    public static void m79548x0(String str) {
        AbstractC10896a.m65885d("HiAnalyticsUtil", "reportClickNetButton");
        LinkedHashMap<String, String> linkedHashMapM79499C = m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("click_net_btn_activity", str);
        C13469a.m81112f().m81113a("click_net_button", linkedHashMapM79499C);
        C13469a.m81112f().m81114b("CKC", "click_net_button", "", "", linkedHashMapM79499C);
    }

    /* renamed from: A0 */
    public void m79549A0(String str, LinkedHashMap<String, String> linkedHashMap) {
        C12515a.m75110o().m75168b1(new c(linkedHashMap, str));
    }

    /* renamed from: B */
    public HiAnalyticsInstance m79550B(String str) {
        AbstractC10896a.m65887i("HiAnalyticsUtil", "createHiAnalyticsInstance");
        f59881i = new HiAnalyticsConfig.Builder();
        if (C1443a.f6214b.booleanValue()) {
            HiAnalyticTools.enableLog(f59873a, 3);
        } else {
            HiAnalyticTools.enableLog(f59873a, 4);
        }
        if (C0209d.m1202Q0()) {
            f59881i.setEnableImei(true);
        }
        f59881i.setEnableUDID(true);
        m79511V0(f59881i);
        AbstractC10896a.m65887i("HiAnalyticsUtil", "HiAnalyticsUtil hmsbiInit");
        HiAnalyticsConfig hiAnalyticsConfigBuild = f59881i.build();
        HiAnalyticsConfig hiAnalyticsConfigBuild2 = f59881i.build();
        HiAnalyticsInstance hiAnalyticsInstanceRefresh = new HiAnalyticsInstance.Builder(f59873a).setMaintConf(hiAnalyticsConfigBuild).setOperConf(hiAnalyticsConfigBuild2).setDiffConf(f59881i.build()).refresh(str);
        if (hiAnalyticsInstanceRefresh != null) {
            hiAnalyticsInstanceRefresh.setHansetBrandId(C0209d.m1160D());
            hiAnalyticsInstanceRefresh.setAppBrandId(C0209d.m1156C());
            hiAnalyticsInstanceRefresh.setAccountBrandId(C14306d.m85201b());
            hiAnalyticsInstanceRefresh.setHandsetManufacturer(C0209d.m1164E());
            hiAnalyticsInstanceRefresh.setAppid("com.huawei.hidisk");
        } else {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "instance is null");
        }
        return hiAnalyticsInstanceRefresh;
    }

    /* renamed from: D0 */
    public void m79551D0(String str, String str2) {
        AbstractC10896a.m65885d("HiAnalyticsUtil", "reportLogout start");
        String strM81133f = C13471c.m81133f();
        String strM81129b = C13471c.m81129b();
        if (TextUtils.isEmpty(strM81133f) || TextUtils.isEmpty(strM81129b)) {
            AbstractC10896a.m65885d("HiAnalyticsUtil", "reportLogout:uId or deviceId is null");
            return;
        }
        LinkedHashMap<String, String> linkedHashMapM79499C = m79499C(strM81133f);
        linkedHashMapM79499C.put("deviceId", strM81129b);
        linkedHashMapM79499C.put("type", str);
        linkedHashMapM79499C.put("status", str2);
        AbstractC10896a.m65885d("HiAnalyticsUtil", "reportLogout:" + str2 + " values:" + linkedHashMapM79499C.toString());
        m79567R("mecloud_logout_account", linkedHashMapM79499C);
        UBAAnalyze.m29947H("CKC", "mecloud_logout_account", linkedHashMapM79499C);
    }

    /* renamed from: E0 */
    public void m79552E0(String str, LinkedHashMap<String, String> linkedHashMap) {
        try {
            m79567R(str, linkedHashMap);
            UBAAnalyze.m29947H("PVC", str, linkedHashMap);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "biReport exception: " + e10.toString());
        }
    }

    /* renamed from: F0 */
    public void m79553F0(String str) {
        LinkedHashMap linkedHashMapM79499C = m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("type", 1);
        m79591l0(str, linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", str, "1", "100", linkedHashMapM79499C);
    }

    /* renamed from: G */
    public synchronized HiAnalyticsInstance mo79488G() throws C9721b {
        return m79555H(mo79489J());
    }

    /* renamed from: G0 */
    public void m79554G0(String str, boolean z10, int i10, boolean z11, boolean z12, long j10, int i11) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put("source", Integer.valueOf(i10));
        if (z10) {
            linkedHashMap.put("status", "1");
        } else {
            linkedHashMap.put("status", "2");
        }
        linkedHashMap.put("cbDelete", String.valueOf(z12));
        linkedHashMap.put("moduleSize", String.valueOf(j10));
        if (i11 >= 0) {
            linkedHashMap.put("bmFullDataAppCount", String.valueOf(i11));
        }
        linkedHashMap.put("is_refurbish", Boolean.valueOf(z11));
        m79591l0("mecloud_backupmain_option_click_switch", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "mecloud_backupmain_option_click_switch", linkedHashMap);
        AbstractC10896a.m65887i("HiAnalyticsUtil", "backup option report module status, appid = " + str + " status = " + z10);
    }

    /* renamed from: H */
    public synchronized HiAnalyticsInstance m79555H(String str) throws C9721b {
        HiAnalyticsInstance hiAnalyticsInstanceM79510Q;
        try {
            hiAnalyticsInstanceM79510Q = m79510Q(str);
            if (hiAnalyticsInstanceM79510Q == null) {
                hiAnalyticsInstanceM79510Q = HiAnalyticsManager.getInstanceByTag(str);
            }
            if (hiAnalyticsInstanceM79510Q == null) {
                hiAnalyticsInstanceM79510Q = m79550B(str);
            }
            if (hiAnalyticsInstanceM79510Q == null) {
                AbstractC10896a.m65886e("HiAnalyticsUtil", "createHiAnalyticsInstance is null");
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "create HiAnalyticsInstance cause error " + str);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return hiAnalyticsInstanceM79510Q;
    }

    /* renamed from: H0 */
    public void m79556H0(int i10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(JsbMapKeyNames.H5_USER_ID, C13452e.m80781L().m80971t0());
        linkedHashMap.put("notification_enable_status", Integer.toString(i10));
        m79591l0("notification_enable_status", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "notification_enable_status", linkedHashMap);
        AbstractC10896a.m65887i("HiAnalyticsUtil", "NotificationEnabledStatus : " + i10);
    }

    /* renamed from: I0 */
    public void m79557I0(String str) {
        m79559K0(str, null, null, Boolean.TRUE, null);
    }

    /* renamed from: J */
    public String mo79489J() {
        return "hicloudTag";
    }

    /* renamed from: J0 */
    public void m79558J0(String str) {
        AbstractC10896a.m65885d("HiAnalyticsUtil", "reportOpenCloudBackup：" + str);
        Boolean bool = Boolean.TRUE;
        m79559K0(str, null, null, bool, bool);
    }

    /* renamed from: K0 */
    public void m79559K0(String str, Integer num, String str2, Boolean bool, Boolean bool2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LinkedHashMap<String, String> linkedHashMapM79499C = m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("channel_of_open_switch", str);
        if (num != null) {
            linkedHashMapM79499C.put("entryType", String.valueOf(num));
            m79544u(num.intValue(), str2, linkedHashMapM79499C);
        }
        if (!C13452e.m80781L().m80887a1()) {
            m79603z0("cloudbackup_open_switch", linkedHashMapM79499C);
            return;
        }
        if (bool != null) {
            m79603z0("cloudbackup_base_open_switch", linkedHashMapM79499C);
        }
        if (bool2 != null) {
            m79603z0("cloudbackup_full_open_switch", linkedHashMapM79499C);
        }
    }

    /* renamed from: L */
    public void m79560L(Context context, String str) {
        C12515a.m75110o().m75172d(new a(context, str));
    }

    /* renamed from: L0 */
    public void m79561L0(String str) {
        AbstractC10896a.m65885d("HiAnalyticsUtil", "reportOpenCloudSpace:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LinkedHashMap linkedHashMapM79499C = m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("channel_of_open_cloud_space", str);
        C12515a.m75110o().m75175e(new e(linkedHashMapM79499C), false);
    }

    /* renamed from: M */
    public void m79562M(Context context, boolean z10) {
        m79560L(context, "");
        f59876d = z10;
    }

    /* renamed from: M0 */
    public void m79563M0(String str) {
        m79559K0(str, null, null, null, Boolean.TRUE);
    }

    /* renamed from: O0 */
    public void m79564O0(String str, String str2) {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("userType", C13452e.m80781L().m80987x0());
            linkedHashMapM79497A.put("deviceId", C13452e.m80781L().m80954p());
            linkedHashMapM79497A.put(FaqConstants.FAQ_ROMVERSION, C0209d.m1319w());
            linkedHashMapM79497A.put(FaqConstants.FAQ_EMUIVERSION, C0209d.m1186L());
            linkedHashMapM79497A.put("appVersion", "16.0.0.300");
            linkedHashMapM79497A.put("sceneCode", str);
            linkedHashMapM79497A.put("osBrand", C0209d.m1276l0());
            m79567R(str2, linkedHashMapM79497A);
            UBAAnalyze.m29947H("CKC", str2, linkedHashMapM79497A);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "reportQueryStorage error :" + e10.getMessage());
        }
    }

    /* renamed from: P0 */
    public void m79565P0(String str, LinkedHashMap<String, String> linkedHashMap) {
        AbstractC10896a.m65885d("HiAnalyticsUtil", "reportOpenCloudSpace:" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        linkedHashMap.put("channel_of_open_cloud_space", str);
        C12515a.m75110o().m75175e(new e(linkedHashMap), false);
    }

    /* renamed from: Q0 */
    public void m79566Q0(String str, String str2, String str3, String str4) {
        try {
            AbstractC10896a.m65887i("HiAnalyticsUtil", "reportSetLockScreen");
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("fromActivity", str3);
            linkedHashMap.put("result", str4);
            linkedHashMap.put(HwPayConstant.KEY_USER_ID, str);
            linkedHashMap.put("appVersion", C1443a.f6213a);
            UBAAnalyze.m29947H("CKP", str2, linkedHashMap);
            linkedHashMap.put("business_id", str2);
            linkedHashMap.put("pn", "com.huawei.hidisk\u0001_phonefinder");
            linkedHashMap.put("operationType", str2);
            linkedHashMap.put("returnCode", str4);
            linkedHashMap.put("errorReason", str2);
            linkedHashMap.put("business_type", Build.MODEL);
            m79573U("HUAWEICLOUD", linkedHashMap);
            m79581a0(1);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "reportSetLockScreen exception: " + e10.toString());
        }
    }

    /* renamed from: R */
    public void m79567R(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (!m79506N() || !C13470b.m81125a().m81126b()) {
            AbstractC10896a.m65885d("HiAnalyticsUtil", "user experience involved");
            return;
        }
        try {
            LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
            linkedHashMap2.putAll(linkedHashMap);
            m79514Z0(linkedHashMap2, true, true);
            mo79488G().onEvent(0, str, linkedHashMap2);
            m79535n0(str, linkedHashMap2, "onBIEvent:");
        } catch (Exception e10) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "report exception: " + e10.toString());
        }
    }

    /* renamed from: R0 */
    public void m79568R0(String str, boolean z10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        if (z10) {
            linkedHashMap.put("status", "1");
        } else {
            linkedHashMap.put("status", "2");
        }
        m79591l0("mecloud_main_switch_suggest_status", linkedHashMap);
        m79573U("mecloud_main_switch_suggest_status", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "mecloud_main_switch_suggest_status", linkedHashMap);
        AbstractC10896a.m65887i("HiAnalyticsUtil", "backup option report module status, appid = " + str + " status = " + z10);
    }

    /* renamed from: S */
    public void m79569S(String str, LinkedHashMap<String, String> linkedHashMap, boolean z10) {
        if (m79508O(z10)) {
            try {
                LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
                linkedHashMap2.putAll(linkedHashMap);
                m79514Z0(linkedHashMap2, true, true);
                mo79488G().onEvent(0, str, linkedHashMap2);
                m79535n0(str, linkedHashMap2, "onBIEventForDs:");
            } catch (Exception e10) {
                AbstractC10896a.m65886e("HiAnalyticsUtil", "report exception: " + e10.toString());
            }
        }
    }

    /* renamed from: S0 */
    public void m79570S0(String str, String str2, int i10, int i11, int i12, int i13, int i14, int i15) {
        AbstractC10896a.m65887i("HiAnalyticsUtil", "reportSyncDataSizeBI start");
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("syncType", str);
        linkedHashMap.put("dataType", str2);
        linkedHashMap.put("localDataSize", Integer.valueOf(i10));
        linkedHashMap.put("cloudDataSize", Integer.valueOf(i11));
        linkedHashMap.put("localAddDataSize", Integer.valueOf(i12));
        linkedHashMap.put("localDeleteDataSize", Integer.valueOf(i13));
        linkedHashMap.put("localToRecycleDataSize", Integer.valueOf(i14));
        linkedHashMap.put("recycleToLocalDataSize", Integer.valueOf(i15));
        m79567R("mecloud_cloud_sync_data_size", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "mecloud_cloud_sync_data_size", linkedHashMap);
    }

    /* renamed from: T */
    public void m79571T(LinkedHashMap<String, String> linkedHashMap) {
        if (m79506N() && C13470b.m81125a().m81126b()) {
            try {
                LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
                linkedHashMap2.putAll(linkedHashMap);
                m79514Z0(linkedHashMap2, true, true);
                mo79488G().onEvent(0, "HUAWEICLOUD", linkedHashMap2);
                mo79488G().onReport(0);
                m79535n0("HUAWEICLOUD", linkedHashMap2, "onBIEventForOld:");
            } catch (Exception e10) {
                AbstractC10896a.m65886e("HiAnalyticsUtil", "report exception: " + e10.toString());
            }
        }
    }

    /* renamed from: T0 */
    public void m79572T0(String str, String str2, String str3) {
        AbstractC10896a.m65885d("HiAnalyticsUtil", "reportUpdate start");
        LinkedHashMap<String, String> linkedHashMapM79499C = m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("versionID", str);
        linkedHashMapM79499C.put("clientversion", C1443a.f6213a);
        linkedHashMapM79499C.put("operateType", str2);
        linkedHashMapM79499C.put("descinfo", str3);
        AbstractC10896a.m65885d("HiAnalyticsUtil", "reportUpdate:" + str2 + " values:" + linkedHashMapM79499C.toString());
        m79567R("mecloud_update_new_version", linkedHashMapM79499C);
        UBAAnalyze.m29947H("CKC", "mecloud_update_new_version", linkedHashMapM79499C);
    }

    /* renamed from: U */
    public void m79573U(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (!m79506N()) {
            AbstractC10896a.m65885d("HiAnalyticsUtil", "user experience involved");
            return;
        }
        try {
            LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
            linkedHashMap2.putAll(linkedHashMap);
            m79514Z0(linkedHashMap2, true, false);
            mo79488G().onEvent(1, str, linkedHashMap2);
            m79535n0(str, linkedHashMap2, "onOMEvent:");
        } catch (Exception e10) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "report exception: " + e10.toString());
        }
    }

    /* renamed from: U0 */
    public void m79574U0(String str, Date date) {
        AbstractC10896a.m65887i("HiAnalyticsUtil", "reportUsingTime eventID：" + str);
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String str2 = simpleDateFormat.format(Long.valueOf(date.getTime()));
        String str3 = simpleDateFormat.format(Long.valueOf(date2.getTime()));
        int time = ((int) (date2.getTime() - date.getTime())) / 1000;
        String id2 = TimeZone.getDefault().getID();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("start_time", str2);
        linkedHashMap.put("end_time", str3);
        linkedHashMap.put("duration", Integer.valueOf(time));
        linkedHashMap.put("timeZone", id2);
        m79567R(str, linkedHashMap);
        UBAAnalyze.m29947H("CKC", str, linkedHashMap);
    }

    /* renamed from: V */
    public void m79575V(String str, LinkedHashMap<String, String> linkedHashMap, boolean z10) {
        if (m79506N()) {
            m79576W(str, linkedHashMap, z10);
        } else {
            AbstractC10896a.m65885d("HiAnalyticsUtil", "user experience involved");
        }
    }

    /* renamed from: W */
    public void m79576W(String str, LinkedHashMap<String, String> linkedHashMap, boolean z10) {
        try {
            LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
            linkedHashMap2.putAll(linkedHashMap);
            m79514Z0(linkedHashMap2, true, false);
            mo79488G().onEvent(1, str, linkedHashMap2);
            if (z10) {
                mo79488G().onReport(1);
            }
            m79535n0(str, linkedHashMap2, "onOMEvent:");
        } catch (Exception e10) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "report exception: " + e10.toString());
        }
    }

    /* renamed from: X */
    public void m79577X(Context context) {
        if (m79506N() && C13470b.m81125a().m81126b()) {
            m79579Y(context, null, null);
        }
    }

    /* renamed from: X0 */
    public void m79578X0(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("core_ha_tag", str);
            NetworkKit.init(f59873a, null);
            NetworkKit.getInstance().setOptions(jSONObject.toString());
        } catch (Exception e10) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "setNetworkKitHaTag exception " + e10.getMessage());
        }
        AbstractC10896a.m65887i("HiAnalyticsUtil", "setNetworkKitHaTag end");
    }

    /* renamed from: Y */
    public void m79579Y(Context context, String str, String str2) {
        if (m79506N() && C13470b.m81125a().m81126b()) {
            try {
                LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
                if (!TextUtils.isEmpty(str2)) {
                    linkedHashMap.put(FaqConstants.FAQ_CHANNEL, str2);
                }
                if (!TextUtils.isEmpty(f59874b)) {
                    linkedHashMap.put("uid", f59874b);
                }
                if (!TextUtils.isEmpty(str)) {
                    linkedHashMap.put("type", str);
                }
                m79514Z0(linkedHashMap, true, true);
                mo79488G().onPause(context, linkedHashMap);
                m79535n0(context.getClass().getCanonicalName(), linkedHashMap, "onPause:");
            } catch (Exception e10) {
                AbstractC10896a.m65886e("HiAnalyticsUtil", "report exception: " + e10.toString());
            }
        }
    }

    /* renamed from: Z */
    public void m79580Z(String str) {
        if (m79506N() && C13470b.m81125a().m81126b()) {
            try {
                LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
                if (!TextUtils.isEmpty(f59874b)) {
                    linkedHashMap.put("uid", f59874b);
                }
                m79514Z0(linkedHashMap, true, true);
                mo79488G().onPause(str, linkedHashMap);
                m79535n0(str, linkedHashMap, "onPause:");
            } catch (Exception e10) {
                AbstractC10896a.m65886e("HiAnalyticsUtil", "report exception: " + e10.toString());
            }
        }
    }

    /* renamed from: a0 */
    public void m79581a0(int i10) {
        try {
            if (m79506N() && C13470b.m81125a().m81126b()) {
                mo79488G().onReport(i10);
                return;
            }
            AbstractC10896a.m65885d("HiAnalyticsUtil", "user experience involved");
        } catch (Exception e10) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "report exception: " + e10.toString());
        }
    }

    /* renamed from: b0 */
    public void m79582b0(Context context) {
        if (m79506N() && C13470b.m81125a().m81126b()) {
            m79583c0(context, null, null);
        }
    }

    /* renamed from: c0 */
    public void m79583c0(Context context, String str, String str2) {
        if (m79506N() && C13470b.m81125a().m81126b()) {
            try {
                LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
                if (!TextUtils.isEmpty(str)) {
                    linkedHashMap.put("type", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    linkedHashMap.put(FaqConstants.FAQ_CHANNEL, str2);
                }
                if (!TextUtils.isEmpty(f59874b)) {
                    linkedHashMap.put("uid", f59874b);
                }
                m79514Z0(linkedHashMap, true, true);
                mo79488G().onResume(context, linkedHashMap);
                m79535n0(context.getClass().getCanonicalName(), linkedHashMap, "onResume:");
            } catch (Exception e10) {
                AbstractC10896a.m65886e("HiAnalyticsUtil", "report exception: " + e10.toString());
            }
        }
    }

    /* renamed from: d0 */
    public void m79584d0(String str) {
        if (m79506N() && C13470b.m81125a().m81126b()) {
            try {
                LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
                if (!TextUtils.isEmpty(f59874b)) {
                    linkedHashMap.put("uid", f59874b);
                }
                m79514Z0(linkedHashMap, true, true);
                mo79488G().onResume(str, linkedHashMap);
                m79535n0(str, linkedHashMap, "onResume:");
            } catch (Exception e10) {
                AbstractC10896a.m65886e("HiAnalyticsUtil", "report exception: " + e10.toString());
            }
        }
    }

    /* renamed from: f0 */
    public void m79585f0(String str, String str2) {
        m79591l0(str, m79499C(str2));
    }

    /* renamed from: g0 */
    public void m79586g0(String str, String str2, String str3) {
        LinkedHashMap linkedHashMapM79499C = m79499C(str2);
        linkedHashMapM79499C.put("gradeCode", str3);
        m79591l0(str, linkedHashMapM79499C);
    }

    /* renamed from: h0 */
    public void m79587h0(String str, String str2, String str3, String str4) {
        LinkedHashMap<String, String> linkedHashMapM79499C = m79499C(str4);
        if (!TextUtils.isEmpty(str2)) {
            linkedHashMapM79499C.put("type", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            linkedHashMapM79499C.put("status", str3);
        }
        m79567R(str, linkedHashMapM79499C);
    }

    /* renamed from: i0 */
    public void m79588i0(String str, String str2, String str3, String str4, int i10) {
        LinkedHashMap<String, String> linkedHashMapM79499C = m79499C(str4);
        if (!TextUtils.isEmpty(str2)) {
            linkedHashMapM79499C.put("type", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            linkedHashMapM79499C.put("status", str3);
        }
        linkedHashMapM79499C.put("operationType", String.valueOf(i10));
        m79567R(str, linkedHashMapM79499C);
    }

    /* renamed from: j0 */
    public void m79589j0(String str, String str2, String str3, String str4, int i10, int i11) {
        LinkedHashMap<String, String> linkedHashMapM79499C = m79499C(str4);
        if (!TextUtils.isEmpty(str2)) {
            linkedHashMapM79499C.put("type", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            linkedHashMapM79499C.put("status", str3);
        }
        linkedHashMapM79499C.put("operationType", String.valueOf(i10));
        linkedHashMapM79499C.put("openingMode", String.valueOf(i11));
        m79567R(str, linkedHashMapM79499C);
    }

    /* renamed from: k0 */
    public void m79590k0(String str, String str2, String str3, String str4, LinkedHashMap linkedHashMap) {
        LinkedHashMap<String, String> linkedHashMapM79499C = m79499C(str4);
        if (!TextUtils.isEmpty(str2)) {
            linkedHashMapM79499C.put("type", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            linkedHashMapM79499C.put("status", str3);
        }
        if (linkedHashMap != null) {
            linkedHashMapM79499C.putAll(linkedHashMap);
        }
        m79567R(str, linkedHashMapM79499C);
    }

    /* renamed from: l0 */
    public void m79591l0(String str, LinkedHashMap linkedHashMap) {
        m79567R(str, linkedHashMap);
    }

    /* renamed from: m0 */
    public void m79592m0(String str, LinkedHashMap linkedHashMap) {
        m79591l0(str, linkedHashMap);
    }

    /* renamed from: q0 */
    public void m79593q0(String str) {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = m79497A(C13452e.m80781L().m80971t0());
            m79567R(str, linkedHashMapM79497A);
            UBAAnalyze.m29947H("PVC", str, linkedHashMapM79497A);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "biReport exception: " + e10.toString());
        }
    }

    /* renamed from: r0 */
    public void m79594r0(String str, LinkedHashMap<String, String> linkedHashMap) {
        try {
            m79567R(str, linkedHashMap);
            UBAAnalyze.m29947H("PVC", str, linkedHashMap);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "biReport exception: " + e10.toString());
        }
    }

    /* renamed from: s0 */
    public void m79595s0(String str, String str2, String str3) {
        AbstractC10896a.m65885d("HiAnalyticsUtil", "reportAutoUploadToCloudSpace eventID：" + str);
        String strM80954p = C13452e.m80781L().m80954p();
        String strM80971t0 = C13452e.m80781L().m80971t0();
        if (TextUtils.isEmpty(strM80954p) || TextUtils.isEmpty(strM80971t0)) {
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(JsbMapKeyNames.H5_USER_ID, strM80971t0);
        linkedHashMap.put("deviceId", strM80954p);
        linkedHashMap.put("appId", str2);
        linkedHashMap.put("triggerPage", str3);
        m79567R(str, linkedHashMap);
        UBAAnalyze.m29947H("CKC", str, linkedHashMap);
    }

    /* renamed from: t0 */
    public void m79596t0(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appId", str);
        linkedHashMap.put("deviceId", C13452e.m80781L().m80954p());
        linkedHashMap.put(JsbMapKeyNames.H5_DEVICE_TYPE, C13452e.m80781L().m80970t());
        linkedHashMap.put(FaqConstants.FAQ_EMUIVERSION, C0209d.m1186L());
        linkedHashMap.put("appVersion", "16.0.0.300");
        linkedHashMap.put("gradeCode", C13452e.m80781L().m80790C());
        m79591l0("mecloud_backupmain_option_click_switch", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "mecloud_backupmain_option_click_switch", linkedHashMap);
    }

    /* renamed from: u0 */
    public void m79597u0(String str, C13471c.f fVar, boolean z10) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ParamConstants.Param.CONTEXT, str);
        linkedHashMap.put("switchType", fVar.m81136b());
        C13622a.m81972r("02317", z10 ? "open switch" : "close switch", linkedHashMap);
        m79567R("02317", linkedHashMap);
        UBAAnalyze.m29947H("PVC", "02317", linkedHashMap);
    }

    /* renamed from: v0 */
    public void m79598v0(Context context, Intent intent, String str) throws JSONException {
        String str2;
        AbstractC10896a.m65887i("HiAnalyticsUtil", "reportChannelInfo");
        try {
            if (intent == null) {
                AbstractC10896a.m65886e("HiAnalyticsUtil", "intent is null");
                return;
            }
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            String stringExtra = hiCloudSafeIntent.getStringExtra("channel_refer");
            String stringExtra2 = hiCloudSafeIntent.getStringExtra("srcChannel");
            String stringExtra3 = hiCloudSafeIntent.getStringExtra("salChannel");
            String stringExtra4 = hiCloudSafeIntent.getStringExtra("sceneCode");
            String stringExtra5 = hiCloudSafeIntent.getStringExtra("activityCode");
            String stringExtra6 = hiCloudSafeIntent.getStringExtra("pkg_name");
            StringBuilder sb2 = new StringBuilder();
            try {
                sb2.append("external_entran_enter_");
                sb2.append(str);
                String string = sb2.toString();
                String strM80790C = C13452e.m80781L().m80790C();
                try {
                    JSONObject jSONObjectM79464f = C13222a.m79464f(context, string, "1", C13452e.m80781L().m80971t0(), stringExtra);
                    jSONObjectM79464f.put("enter_activity_entranChannel", stringExtra);
                    jSONObjectM79464f.put("enter_activity_salChannel", stringExtra3);
                    jSONObjectM79464f.put("enter_activity_srcChannel", stringExtra2);
                    jSONObjectM79464f.put("sceneCode", stringExtra4);
                    jSONObjectM79464f.put("enter_activity_entran_activityCode", stringExtra5);
                    jSONObjectM79464f.put("enter_activity_entran_pkg_name", stringExtra6);
                    jSONObjectM79464f.put("gradeCode", strM80790C);
                    LinkedHashMap linkedHashMapM79499C = m79499C(C13452e.m80781L().m80971t0());
                    linkedHashMapM79499C.put("enter_activity_entranChannel", stringExtra);
                    linkedHashMapM79499C.put("enter_activity_salChannel", stringExtra3);
                    linkedHashMapM79499C.put("enter_activity_srcChannel", stringExtra2);
                    linkedHashMapM79499C.put("sceneCode", stringExtra4);
                    linkedHashMapM79499C.put("enter_activity_entran_activityCode", stringExtra5);
                    linkedHashMapM79499C.put("enter_activity_entran_pkg_name", stringExtra6);
                    linkedHashMapM79499C.put("gradeCode", strM80790C);
                    m79602z(jSONObjectM79464f);
                    m79591l0(string, linkedHashMapM79499C);
                    UBAAnalyze.m29963X("PVC", string, "5", "48", jSONObjectM79464f);
                } catch (JSONException e10) {
                    str2 = "HiAnalyticsUtil";
                    try {
                        AbstractC10896a.m65886e(str2, "reportChannelInfo exception " + e10.getMessage());
                    } catch (Exception e11) {
                        e = e11;
                        AbstractC10896a.m65886e(str2, "reportChannelInfo failed:" + e.toString());
                    }
                }
            } catch (Exception e12) {
                e = e12;
                str2 = "HiAnalyticsUtil";
                AbstractC10896a.m65886e(str2, "reportChannelInfo failed:" + e.toString());
            }
        } catch (Exception e13) {
            e = e13;
            str2 = "HiAnalyticsUtil";
        }
    }

    /* renamed from: w0 */
    public void m79599w0(boolean z10, String str, String str2) {
        LinkedHashMap<String, String> linkedHashMapM79497A = m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("switchStatue", String.valueOf(z10));
        linkedHashMapM79497A.put("serviceId", str2);
        m79567R(str, linkedHashMapM79497A);
        UBAAnalyze.m29947H("PVC", str, linkedHashMapM79497A);
    }

    /* renamed from: y */
    public void m79600y(String str, String str2) {
        if (str == null || str2 == null) {
            AbstractC10896a.m65888w("HiAnalyticsUtil", "params is null, collectEvent failed");
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("key", str);
        linkedHashMap.put("value", str2);
        m79571T(linkedHashMap);
    }

    /* renamed from: y0 */
    public void m79601y0(long j10, CloudSpace cloudSpace) {
        AbstractC10896a.m65885d("HiAnalyticsUtil", "reportCloseCloudBackup");
        Long lValueOf = Long.valueOf(System.currentTimeMillis() - j10);
        String str = cloudSpace.getTotal() - cloudSpace.getUsed() == 0 ? "1" : "0";
        String strM80971t0 = C13452e.m80781L().m80971t0();
        if (strM80971t0 == null) {
            strM80971t0 = C13471c.m81133f();
        }
        LinkedHashMap<String, String> linkedHashMapM79499C = m79499C(strM80971t0);
        linkedHashMapM79499C.put("opening_time", lValueOf.toString());
        linkedHashMapM79499C.put("space_status", str);
        m79603z0("cloudbackup_closed_status", linkedHashMapM79499C);
    }

    /* renamed from: z */
    public void m79602z(JSONObject jSONObject) {
        if (jSONObject == null) {
            AbstractC10896a.m65888w("HiAnalyticsUtil", "params is null, collectEvent failed");
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next)) {
                    linkedHashMap.put(next, jSONObject.getString(next));
                }
            }
            if (linkedHashMap.isEmpty()) {
                return;
            }
            m79571T(linkedHashMap);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("HiAnalyticsUtil", "collectEvent error occur, " + e10.getMessage());
        }
    }

    /* renamed from: z0 */
    public void m79603z0(String str, LinkedHashMap<String, String> linkedHashMap) {
        C12515a.m75110o().m75168b1(new b(linkedHashMap, str));
    }
}
