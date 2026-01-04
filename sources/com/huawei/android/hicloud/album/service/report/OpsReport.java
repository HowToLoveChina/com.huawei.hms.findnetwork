package com.huawei.android.hicloud.album.service.report;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.hms.network.embedded.C6110u3;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import p015ak.C0209d;
import p015ak.C0213f;
import p031b7.C1120a;
import p031b7.C1122c;
import p783xp.C13843a;

/* loaded from: classes2.dex */
public class OpsReport {

    /* renamed from: s */
    public static final Map<String, String> f11630s = new C2435a();

    /* renamed from: a */
    public Context f11631a;

    /* renamed from: c */
    public String f11633c;

    /* renamed from: d */
    public String f11634d;

    /* renamed from: e */
    public String f11635e;

    /* renamed from: f */
    public String f11636f;

    /* renamed from: g */
    public String f11637g;

    /* renamed from: h */
    public String f11638h;

    /* renamed from: i */
    public String f11639i;

    /* renamed from: j */
    public String f11640j;

    /* renamed from: k */
    public String f11641k;

    /* renamed from: q */
    public String f11647q;

    /* renamed from: r */
    public ExtraData f11648r;

    /* renamed from: l */
    public String f11642l = "0:1";

    /* renamed from: m */
    public String f11643m = "OK";

    /* renamed from: n */
    public String f11644n = "null";

    /* renamed from: o */
    public String f11645o = "null";

    /* renamed from: p */
    public String f11646p = "null";

    /* renamed from: b */
    public String f11632b = "com.huawei.hidisk\u0001_cloudalbum";

    /* renamed from: com.huawei.android.hicloud.album.service.report.OpsReport$a */
    public class C2435a extends HashMap<String, String> {
        public C2435a() {
            put("cloudphoto.file.geturl", "Download.Media.get");
            put("cloudphoto.file.create", "General.Media.create.metadata");
            put("cloudphoto.file.create.share", "Share.Media.create.metadata");
        }
    }

    public OpsReport(Context context) {
        this.f11631a = context;
        String strM83101w = C13843a.m83101w(C1122c.m6774e0());
        this.f11633c = strM83101w;
        this.f11634d = C1122c.m6728Q0(strM83101w);
        this.f11638h = C1122c.m6748X(context);
        this.f11639i = C1122c.m6725P0(context);
        this.f11640j = C1122c.m6704I0();
        this.f11641k = C1122c.m6851z0(context);
    }

    /* renamed from: b */
    public static String m15253b(String str) {
        if (!CloudAlbumSettings.m14363h().m14376l()) {
            return str;
        }
        Map<String, String> map = f11630s;
        return map.containsKey(str) ? map.get(str) : str;
    }

    /* renamed from: d */
    public static String m15254d() {
        return m15261l("04001");
    }

    /* renamed from: f */
    public static String m15255f() {
        return m15261l("04006");
    }

    /* renamed from: g */
    public static String m15256g() {
        return C1122c.m6707J0();
    }

    /* renamed from: h */
    public static String m15257h() {
        return m15261l("04007");
    }

    /* renamed from: i */
    public static String m15258i() {
        return m15261l("04009");
    }

    /* renamed from: j */
    public static String m15259j() {
        return m15261l("04011");
    }

    /* renamed from: k */
    public static String m15260k() {
        return m15261l("04014");
    }

    /* renamed from: l */
    public static String m15261l(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str + "_" + HiAnalyticsConstant.KeyAndValue.NUMBER_01 + "_" + (System.currentTimeMillis() / 1000) + "_" + m15256g();
    }

    /* renamed from: m */
    public static void m15262m(Context context, String str, String str2) {
        new CommonOpsReport(context).m15208B(str2, str);
    }

    /* renamed from: a */
    public final String m15263a(String str) {
        return TextUtils.isEmpty(str) ? "null" : str;
    }

    /* renamed from: c */
    public String m15264c() {
        return this.f11633c;
    }

    /* renamed from: e */
    public String m15265e(String str) {
        return (TextUtils.isEmpty(str) || str.length() <= 5) ? "04001" : str.substring(0, 5);
    }

    /* renamed from: n */
    public void m15266n() {
        if (!C1122c.m6843w1(this.f11631a)) {
            C1120a.m6675d("BaseOpsReport", "user experience involved");
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("domain", this.f11633c);
        linkedHashMap.put("server_ip", this.f11634d);
        linkedHashMap.put("error_code", this.f11642l);
        linkedHashMap.put("error_msg", this.f11643m);
        linkedHashMap.put("pn", this.f11632b);
        linkedHashMap.put("resource_path", this.f11644n);
        linkedHashMap.put("clientErrorCode", this.f11645o);
        linkedHashMap.put("clientErrorMsg", this.f11646p);
        linkedHashMap.put("operation_type", this.f11647q);
        linkedHashMap.put("total_time", this.f11635e);
        linkedHashMap.put("size_download", this.f11636f);
        linkedHashMap.put("battery", this.f11638h);
        linkedHashMap.put("screen", this.f11639i);
        linkedHashMap.put(C6110u3.f28488m, this.f11640j);
        linkedHashMap.put("mobile_network", this.f11641k);
        linkedHashMap.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, String.valueOf(C0209d.m1225Y(C0213f.m1377a())));
        LinkedHashMap<String, String> linkedHashMapM15223b = this.f11648r.m15223b(linkedHashMap);
        try {
            C1122c.m6772d2(this.f11631a, linkedHashMapM15223b.get("traceID"), linkedHashMapM15223b);
        } catch (Exception e10) {
            C1120a.m6676e("BaseOpsReport", "safeReportEvent error: " + e10.toString());
        }
    }

    /* renamed from: o */
    public void m15267o(int i10, String str) {
        this.f11645o = String.valueOf(i10);
        this.f11646p = str;
    }

    /* renamed from: p */
    public void m15268p(String str) {
        this.f11633c = str;
    }

    /* renamed from: q */
    public void m15269q(String str) {
        this.f11643m = m15263a(str);
    }

    /* renamed from: r */
    public void m15270r(ExtraData extraData) {
        this.f11648r = extraData;
    }

    /* renamed from: s */
    public void m15271s(String str) {
        this.f11647q = m15263a(str);
    }

    /* renamed from: t */
    public void m15272t(String str) {
        this.f11644n = m15263a(str);
    }

    public String toString() {
        return "BaseOpsReport{packageName='" + this.f11632b + "', domain='" + this.f11633c + "', serverIp='" + this.f11634d + "', totalTime='" + this.f11635e + "', sizeDownload='" + this.f11636f + "', sizeUpload='" + this.f11637g + "', batteryStatus='" + this.f11638h + "', returnCode='" + this.f11642l + "', errorReason='" + this.f11643m + "', resourcePath='" + this.f11644n + "', clientErrorCode='" + this.f11645o + "', operationType='" + this.f11647q + "', extraData=" + this.f11648r + '}';
    }

    /* renamed from: u */
    public void m15273u(int i10) {
        m15274v(i10, true);
    }

    /* renamed from: v */
    public void m15274v(int i10, boolean z10) {
        if (i10 == 0) {
            this.f11642l = "0:1";
            return;
        }
        this.f11642l = (z10 ? "001_" : "101_") + i10 + ":1";
    }

    /* renamed from: w */
    public void m15275w(String str) {
        this.f11642l = m15263a(str);
    }

    /* renamed from: x */
    public void m15276x(String str) {
        this.f11634d = str;
    }

    /* renamed from: y */
    public void m15277y(long j10) {
        this.f11636f = String.valueOf(j10);
    }

    /* renamed from: z */
    public void m15278z(String str) {
        this.f11635e = str;
    }
}
