package com.huawei.hms.videokit.player;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.network.NetworkKit;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.videokit.player.j */
/* loaded from: classes8.dex */
public class C6580j {

    /* renamed from: c */
    private static final int f30532c;

    /* renamed from: d */
    private static final int f30533d;

    /* renamed from: e */
    private static final Object f30534e;

    /* renamed from: f */
    private static volatile C6580j f30535f;

    /* renamed from: g */
    private static String f30536g;

    /* renamed from: h */
    private static String f30537h;

    /* renamed from: i */
    private static String f30538i;

    /* renamed from: j */
    private static int f30539j;

    /* renamed from: k */
    private static int f30540k;

    /* renamed from: a */
    private Context f30541a = null;

    /* renamed from: b */
    private boolean f30542b = false;

    /* renamed from: com.huawei.hms.videokit.player.j$a */
    public class a extends NetworkKit.Callback {
        @Override // com.huawei.hms.network.NetworkKit.Callback
        public void onResult(boolean z10) {
            C6550c1.m37264c("VideoManager", z10 ? "init rest client success" : "init rest client fail");
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f30532c = iAvailableProcessors;
        f30533d = iAvailableProcessors * 2;
        f30534e = new Object();
        f30536g = "";
        f30537h = "";
        f30538i = "";
        f30539j = -1;
        f30540k = 0;
    }

    /* renamed from: a */
    public static String m37436a() {
        return f30537h;
    }

    /* renamed from: b */
    public static String m37442b() {
        return f30538i;
    }

    /* renamed from: c */
    public static int m37445c() {
        return f30539j;
    }

    /* renamed from: d */
    public static C6580j m37447d() {
        if (f30535f == null) {
            synchronized (f30534e) {
                try {
                    if (f30535f == null) {
                        f30535f = new C6580j();
                    }
                } finally {
                }
            }
        }
        return f30535f;
    }

    /* renamed from: e */
    public static String m37449e() {
        return f30536g;
    }

    /* renamed from: f */
    public static int m37450f() {
        return f30540k;
    }

    /* renamed from: g */
    public boolean m37453g() {
        return this.f30542b;
    }

    /* renamed from: h */
    public boolean m37454h() {
        String strM37641a;
        try {
            strM37641a = C6597s.m37641a("videoepg");
        } catch (JSONException e10) {
            C6550c1.m37258a("VideoManager", "get grs service url fail ", e10);
            strM37641a = "";
        }
        return !TextUtils.isEmpty(strM37641a);
    }

    /* renamed from: a */
    private String m37437a(String str) {
        C6550c1.m37256a("VideoManager", "correctServeCountry, serveCountry:" + str);
        if (C6600t0.m37680b(str)) {
            str = GrsApp.getInstance().getIssueCountryCode(this.f30541a);
            C6550c1.m37256a("VideoManager", "correctServeCountry, IssueCountryCode:" + str);
        }
        if (C6600t0.m37680b(str)) {
            return "";
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        if (upperCase.length() == 2) {
            return upperCase;
        }
        C6550c1.m37264c("VideoManager", "Illegal country codes are not supported");
        return "";
    }

    /* renamed from: b */
    public static void m37443b(int i10) {
        f30540k = i10;
    }

    /* renamed from: c */
    private static void m37446c(String str) {
        f30538i = str;
    }

    /* renamed from: d */
    private static void m37448d(String str) {
        f30536g = str;
    }

    /* renamed from: e */
    public void m37452e(String str) {
        String strM37437a = m37437a(str);
        if (strM37437a.equals(C6597s.m37640a())) {
            C6550c1.m37256a("VideoManager", "updateServeCountry, same as last time");
            return;
        }
        C6597s.m37642a(this.f30541a, strM37437a);
        C6609y.m37724b().m37726a(this.f30541a, true);
        C6543b.m37207b().m37208a();
    }

    /* renamed from: a */
    private static void m37438a(int i10) {
        f30539j = i10;
    }

    /* renamed from: b */
    public static void m37444b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f30537h = str;
    }

    /* renamed from: a */
    private static void m37439a(Context context, WisePlayerFactoryOptionsExt wisePlayerFactoryOptionsExt) throws JSONException {
        C6550c1.m37264c("VideoManager", "init rest client ");
        NetworkKit.init(context, new a());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ha_tag", "hwid_tag");
            jSONObject.put("enable_ipv6", wisePlayerFactoryOptionsExt.isEnableIPv6() ? FaqConstants.DISABLE_HA_REPORT : "false");
            NetworkKit.getInstance().setOptions(jSONObject.toString());
        } catch (JSONException e10) {
            C6550c1.m37258a("VideoManager", "JSONException", e10);
        }
        NetworkKit.getInstance().initConnectionPool(f30533d, 5L, TimeUnit.MINUTES);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x003d A[Catch: Exception -> 0x003b, TryCatch #0 {Exception -> 0x003b, blocks: (B:30:0x0026, B:32:0x0030, B:36:0x004a, B:38:0x0056, B:39:0x0060, B:35:0x003d), top: B:43:0x0026 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m37451a(android.content.Context r2, com.huawei.hms.videokit.player.WisePlayerFactoryOptionsExt r3, java.lang.String r4) throws org.json.JSONException {
        /*
            r1 = this;
            m37448d(r4)
            r1.f30541a = r2
            java.lang.String r2 = com.huawei.hms.videokit.player.C6600t0.m37685d(r2)
            java.lang.String r4 = ":player"
            boolean r2 = r2.endsWith(r4)
            if (r2 != 0) goto L23
            java.lang.String r2 = r3.getServeCountry()
            java.lang.String r2 = r1.m37437a(r2)
            android.content.Context r0 = r1.f30541a
            com.huawei.hms.videokit.player.C6597s.m37642a(r0, r2)
            android.content.Context r2 = r1.f30541a
            m37439a(r2, r3)
        L23:
            r2 = 1
            if (r3 == 0) goto L3d
            java.lang.String r0 = r3.getDeviceId()     // Catch: java.lang.Exception -> L3b
            boolean r0 = com.huawei.hms.videokit.player.C6600t0.m37683c(r0)     // Catch: java.lang.Exception -> L3b
            if (r0 != 0) goto L3d
            java.lang.String r3 = r3.getDeviceId()     // Catch: java.lang.Exception -> L3b
            m37446c(r3)     // Catch: java.lang.Exception -> L3b
            m37438a(r2)     // Catch: java.lang.Exception -> L3b
            goto L4a
        L3b:
            r1 = move-exception
            goto L64
        L3d:
            android.content.Context r3 = r1.f30541a     // Catch: java.lang.Exception -> L3b
            java.lang.String r3 = com.huawei.hms.videokit.player.C6598s0.m37646c(r3)     // Catch: java.lang.Exception -> L3b
            m37446c(r3)     // Catch: java.lang.Exception -> L3b
            r3 = 2
            m37438a(r3)     // Catch: java.lang.Exception -> L3b
        L4a:
            android.content.Context r3 = r1.f30541a     // Catch: java.lang.Exception -> L3b
            java.lang.String r3 = com.huawei.hms.videokit.player.C6600t0.m37685d(r3)     // Catch: java.lang.Exception -> L3b
            boolean r3 = r3.endsWith(r4)     // Catch: java.lang.Exception -> L3b
            if (r3 != 0) goto L60
            com.huawei.hms.videokit.player.y r3 = com.huawei.hms.videokit.player.C6609y.m37724b()     // Catch: java.lang.Exception -> L3b
            android.content.Context r4 = r1.f30541a     // Catch: java.lang.Exception -> L3b
            r0 = 0
            r3.m37726a(r4, r0)     // Catch: java.lang.Exception -> L3b
        L60:
            r1.m37441a(r2)     // Catch: java.lang.Exception -> L3b
            goto L6b
        L64:
            java.lang.String r2 = "VideoManager"
            java.lang.String r3 = "init e:"
            com.huawei.hms.videokit.player.C6550c1.m37258a(r2, r3, r1)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.videokit.player.C6580j.m37451a(android.content.Context, com.huawei.hms.videokit.player.WisePlayerFactoryOptionsExt, java.lang.String):void");
    }

    /* renamed from: a */
    public static void m37440a(String str, Context context) {
        C6550c1.m37256a("VideoManager", "commitAbnormalEvent");
        C6611z c6611z = new C6611z(context);
        if (TextUtils.isEmpty(str)) {
            C6550c1.m37256a("VideoManager", "ErrorMessage is empty");
            return;
        }
        c6611z.m37731a(str);
        c6611z.m37730a(0);
        if (str.contains("Dmp_UnsatisfiedLinkError")) {
            c6611z.m37732b(0);
        } else {
            c6611z.m37732b(1);
        }
        c6611z.m37733h();
        c6611z.m37734i();
    }

    /* renamed from: a */
    private void m37441a(boolean z10) {
        this.f30542b = z10;
    }
}
