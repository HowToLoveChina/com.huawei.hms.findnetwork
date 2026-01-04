package p746wn;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.network.file.core.util.Utils;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import fk.C9721b;
import gp.C10028c;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedHashMap;
import java.util.Map;
import p015ak.C0209d;
import p015ak.C0213f;
import p399jk.AbstractC10896a;
import p429kk.C11058a;
import p429kk.C11059b;
import p429kk.C11060c;
import p581qk.AbstractC12367d;
import p581qk.AbstractC12368e;
import p616rk.C12515a;
import p684un.C13224c;
import p684un.C13225d;
import p684un.C13226e;
import p684un.C13227f;
import p684un.C13228g;
import p684un.C13230i;
import p709vj.C13452e;
import p783xp.C13843a;
import tm.C13040c;

/* renamed from: wn.a */
/* loaded from: classes6.dex */
public class C13622a {

    /* renamed from: wn.a$a */
    public class a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ String f61278a;

        /* renamed from: b */
        public final /* synthetic */ Context f61279b;

        /* renamed from: c */
        public final /* synthetic */ String f61280c;

        public a(String str, Context context, String str2) {
            this.f61278a = str;
            this.f61279b = context;
            this.f61280c = str2;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            AbstractC10896a.m65887i("ReportUtil", "STInvalidReportTask, local method is: " + this.f61278a);
            C13622a.m81964j(this.f61279b, "", 0, this.f61280c, "03008", this.f61278a, C13622a.m81958d("03008"));
        }
    }

    /* renamed from: wn.a$b */
    public class b extends AbstractC12368e {

        /* renamed from: a */
        public final /* synthetic */ C11060c f61281a;

        /* renamed from: b */
        public final /* synthetic */ Map f61282b;

        /* renamed from: c */
        public final /* synthetic */ boolean f61283c;

        /* renamed from: d */
        public final /* synthetic */ boolean f61284d;

        public b(C11060c c11060c, Map map, boolean z10, boolean z11) {
            this.f61281a = c11060c;
            this.f61282b = map;
            this.f61283c = z10;
            this.f61284d = z11;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C13622a.m81967m(this.f61281a, this.f61282b, this.f61283c, this.f61284d);
        }
    }

    /* renamed from: wn.a$c */
    public class c extends AbstractC12368e {

        /* renamed from: a */
        public final /* synthetic */ C11060c f61285a;

        /* renamed from: b */
        public final /* synthetic */ Map f61286b;

        /* renamed from: c */
        public final /* synthetic */ boolean f61287c;

        public c(C11060c c11060c, Map map, boolean z10) {
            this.f61285a = c11060c;
            this.f61286b = map;
            this.f61287c = z10;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C13622a.m81967m(this.f61285a, this.f61286b, this.f61287c, false);
        }
    }

    /* renamed from: b */
    public static String m81956b(int i10, String str) {
        if (i10 == 0) {
            return "0";
        }
        if (TextUtils.isEmpty(str)) {
            return "001_" + i10;
        }
        return str + "_" + i10;
    }

    /* renamed from: c */
    public static String m81957c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "commonsync";
        }
        if (str.startsWith("addressbook") || "./contact".equalsIgnoreCase(str)) {
            return "contactsync";
        }
        if (str.startsWith("wlan")) {
            return "wifisettingssync";
        }
        if (str.startsWith("calendar")) {
            return "calendarsync";
        }
        if (str.startsWith("notepad")) {
            return "notepadsync";
        }
        if (str.startsWith("browser")) {
            return "browsersync";
        }
        if (str.startsWith("atlas")) {
            return "gallerysync";
        }
        if (str.startsWith("huaweipay")) {
            return "huaweipaysync";
        }
        return str + "sync";
    }

    /* renamed from: d */
    public static String m81958d(String str) {
        return C11058a.m66627b(str);
    }

    /* renamed from: e */
    public static String m81959e() throws C9721b {
        return C13843a.m83101w(C13040c.m78609F().m78670w());
    }

    /* renamed from: f */
    public static C13230i m81960f(String str) {
        if (TextUtils.isEmpty(str)) {
            return C13227f.m79492i1();
        }
        str.hashCode();
        switch (str) {
            case "com.huawei.hidisk_cloudbackup":
                return C13225d.m79490f1();
            case "com.huawei.hidisk_notepadsync":
                return C13226e.m79491f1();
            case "com.huawei.hidisk_cloudalbum":
                return C13224c.m79487f1();
            case "com.huawei.hidisk_cloudspace":
            case "com.huawei.hidisk_cloud":
                return C13227f.m79492i1();
            default:
                return C13230i.m79504I();
        }
    }

    /* renamed from: g */
    public static String m81961g(String str) throws UnknownHostException {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            InetAddress[] allByName = InetAddress.getAllByName(str);
            return allByName.length > 0 ? allByName[0].getHostAddress() : "";
        } catch (UnknownHostException e10) {
            AbstractC10896a.m65886e("ReportUtil", "Get ip address UnknownHostException: " + e10.getMessage());
            return "";
        } catch (Exception e11) {
            AbstractC10896a.m65886e("ReportUtil", "Get ip address error: " + e11.toString());
            return "";
        }
    }

    /* renamed from: h */
    public static LinkedHashMap<String, String> m81962h(C11060c c11060c, Map<String, String> map) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        if (c11060c.m66647c() == null || c11060c.m66647c().isEmpty()) {
            return null;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        String strM66653i = c11060c.m66653i();
        String strM66645a = c11060c.m66645a();
        if (!TextUtils.isEmpty(strM66645a)) {
            linkedHashMap.put("appId", strM66645a);
        }
        if (C11059b.m66631d().contains(strM66653i)) {
            linkedHashMap.put("isFastUpload", c11060c.m66650f());
            str = "server_ip";
            str2 = "error_code";
            str3 = "error_msg";
            str4 = "operation_type";
            str8 = "total_time";
            str5 = "size_download";
            str6 = "size_upload";
            str7 = "resource_path";
        } else {
            str = "serverIp";
            str2 = "returnCode";
            str3 = "errorReason";
            str4 = "operationType";
            str5 = "sizeDownload";
            str6 = "sizeUpload";
            str7 = "resourcePath";
            str8 = Utils.TOTAL_TIME;
        }
        linkedHashMap.put("pn", c11060c.m66654j());
        linkedHashMap.put("domain", c11060c.m66648d());
        linkedHashMap.put(str, c11060c.m66656l());
        linkedHashMap.put(str2, c11060c.m66647c());
        linkedHashMap.put(str3, c11060c.m66652h());
        linkedHashMap.put(str4, c11060c.m66653i());
        linkedHashMap.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, String.valueOf(C0209d.m1225Y(C0213f.m1377a())));
        linkedHashMap.put("business_id", c11060c.m66646b());
        linkedHashMap.put("business_type", Build.MODEL);
        linkedHashMap.put("traceID", c11060c.m66661q());
        linkedHashMap.put(HwPayConstant.KEY_USER_ID, c11060c.m66662r());
        linkedHashMap.put("logVersion", c11060c.m66651g());
        linkedHashMap.put("endTrace", c11060c.m66649e());
        String strM66655k = c11060c.m66655k();
        if (strM66655k != null && !strM66655k.isEmpty()) {
            String strM66660p = c11060c.m66660p();
            if (strM66660p == null || strM66660p.isEmpty()) {
                strM66660p = c11060c.m66659o().get(Utils.TOTAL_TIME);
            }
            linkedHashMap.put(str8, strM66660p);
            linkedHashMap.put(str5, c11060c.m66657m());
            linkedHashMap.put(str6, c11060c.m66658n());
            linkedHashMap.put(str7, c11060c.m66655k());
        }
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    /* renamed from: i */
    public static String m81963i() {
        return C13452e.m80781L().m80979v0();
    }

    /* renamed from: j */
    public static void m81964j(Context context, String str, int i10, String str2, String str3, String str4, String str5) {
        m81965k(context, str, i10, "", str2, str3, str4, str5);
    }

    /* renamed from: k */
    public static void m81965k(Context context, String str, int i10, String str2, String str3, String str4, String str5, String str6) {
        m81966l(context, str, i10, str2, str3, str4, str5, str6, null, false);
    }

    /* renamed from: l */
    public static void m81966l(Context context, String str, int i10, String str2, String str3, String str4, String str5, String str6, LinkedHashMap<String, String> linkedHashMap, boolean z10) {
        if (context == null) {
            AbstractC10896a.m65887i("ReportUtil", "context is null");
            return;
        }
        if (C10028c.m62182c0().m62221H1()) {
            try {
                String strM81959e = m81959e();
                String strM81977w = m81977w(str5);
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                linkedHashMap2.put("pn", "com.huawei.hidisk\u0001_" + m81957c(str));
                linkedHashMap2.put("domain", strM81959e);
                linkedHashMap2.put("serverIp", m81961g(strM81959e));
                linkedHashMap2.put("returnCode", m81956b(i10, str2));
                linkedHashMap2.put("errorReason", str3);
                linkedHashMap2.put("operationType", str4);
                linkedHashMap2.put("resourcePath", str5);
                linkedHashMap2.put("business_id", str5);
                linkedHashMap2.put("business_type", Build.MODEL);
                linkedHashMap2.put("traceID", str6);
                linkedHashMap2.put("syncType", str);
                linkedHashMap2.put(HwPayConstant.KEY_USER_ID, C13452e.m80781L().m80971t0());
                linkedHashMap2.put("logVersion", "2.0");
                linkedHashMap2.put("endTrace", strM81977w);
                if (linkedHashMap != null) {
                    linkedHashMap2.putAll(linkedHashMap);
                }
                m81974t(str6, linkedHashMap2, z10, "");
            } catch (C9721b e10) {
                AbstractC10896a.m65886e("ReportUtil", "getPIMDomain exception " + e10.toString());
            }
        }
    }

    /* renamed from: m */
    public static void m81967m(C11060c c11060c, Map<String, String> map, boolean z10, boolean z11) {
        LinkedHashMap<String, String> linkedHashMapM81962h = m81962h(c11060c, map);
        if (z10) {
            m81976v(c11060c.m66661q(), linkedHashMapM81962h, z11, m81960f(c11060c.m66654j()));
        } else {
            m81975u(c11060c.m66661q(), linkedHashMapM81962h, z11, m81960f(c11060c.m66654j()));
        }
    }

    /* renamed from: n */
    public static void m81968n(Context context, C11060c c11060c) {
        m81969o(context, c11060c, null);
    }

    /* renamed from: o */
    public static void m81969o(Context context, C11060c c11060c, Map<String, String> map) {
        m81970p(c11060c, map, false);
    }

    /* renamed from: p */
    public static void m81970p(C11060c c11060c, Map<String, String> map, boolean z10) {
        if (c11060c == null) {
            return;
        }
        C12515a.m75110o().m75168b1(new c(c11060c, map, z10));
    }

    /* renamed from: q */
    public static void m81971q(C11060c c11060c, Map<String, String> map, boolean z10, boolean z11) {
        if (c11060c == null) {
            return;
        }
        C12515a.m75110o().m75168b1(new b(c11060c, map, z10, z11));
    }

    /* renamed from: r */
    public static void m81972r(String str, String str2, Map<String, String> map) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        if (map != null && !map.isEmpty()) {
            linkedHashMapM79497A.putAll(map);
        }
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b(str), str2, C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        m81971q(c11060cM66626a, linkedHashMapM79497A, false, true);
    }

    /* renamed from: s */
    public static void m81973s(Context context, String str, String str2) {
        C12515a.m75110o().m75172d(new a(str2, context, str));
    }

    /* renamed from: t */
    public static void m81974t(String str, LinkedHashMap<String, String> linkedHashMap, boolean z10, String str2) {
        m81975u(str, linkedHashMap, z10, m81960f(str2));
    }

    /* renamed from: u */
    public static void m81975u(String str, LinkedHashMap<String, String> linkedHashMap, boolean z10, C13230i c13230i) {
        if (TextUtils.isEmpty(str)) {
            AbstractC10896a.m65886e("ReportUtil", "safeReportEvent eventID is illegal");
            return;
        }
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            AbstractC10896a.m65886e("ReportUtil", "safeReportEvent map is illegal");
            return;
        }
        try {
            if (c13230i instanceof C13227f) {
                ((C13227f) c13230i).m79575V(str, linkedHashMap, z10);
            } else if (c13230i instanceof C13226e) {
                ((C13226e) c13230i).m79575V(str, linkedHashMap, z10);
            } else if (c13230i instanceof C13224c) {
                ((C13224c) c13230i).m79575V(str, linkedHashMap, z10);
            } else if (c13230i instanceof C13225d) {
                ((C13225d) c13230i).m79575V(str, linkedHashMap, z10);
            } else if (c13230i instanceof C13228g) {
                ((C13228g) c13230i).m79575V(str, linkedHashMap, z10);
            } else {
                c13230i.m79575V(str, linkedHashMap, z10);
            }
        } catch (Exception e10) {
            AbstractC10896a.m65886e("ReportUtil", "safeReportEvent error: " + e10.toString());
        }
    }

    /* renamed from: v */
    public static void m81976v(String str, LinkedHashMap<String, String> linkedHashMap, boolean z10, C13230i c13230i) {
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            AbstractC10896a.m65886e("ReportUtil", "safeReportEvent map is illegal");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            AbstractC10896a.m65886e("ReportUtil", "safeReportEvent eventID is illegal");
            return;
        }
        try {
            c13230i.m79576W(str, linkedHashMap, z10);
        } catch (Exception e10) {
            AbstractC10896a.m65886e("ReportUtil", "safeReportEvent error: " + e10.toString());
        }
    }

    /* renamed from: w */
    public static String m81977w(String str) {
        return ("success".equals(str) || "fail".equals(str) || "local_end".equals(str) || "PutSettingServlet".equals(str) || "PutDevInfoServlet".equals(str) || "ClientRest".equals(str) || "local_receive_push".equals(str) || "notification".equals(str) || "verify_account".equals(str) || "click".equals(str) || "account_dialog".equals(str) || "cancel_verify".equals(str)) ? "1" : "0";
    }
}
