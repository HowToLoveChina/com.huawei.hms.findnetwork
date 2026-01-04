package je;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.syncdrive.cloudsync.model.Asset;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import gp.C10028c;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import p015ak.C0209d;
import p015ak.C0213f;
import p037bp.C1270a;
import p232dp.InterfaceC9282a;
import p429kk.C11058a;
import p514o9.C11839m;
import p581qk.AbstractC12368e;
import p616rk.C12515a;
import p684un.C13226e;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import vn.C13471c;

/* renamed from: je.z */
/* loaded from: classes3.dex */
public class C10812z {

    /* renamed from: a */
    public static final Map<String, HashMap> f51586a = new HashMap();

    /* renamed from: je.z$a */
    public class a extends AbstractC12368e {

        /* renamed from: a */
        public final /* synthetic */ Context f51587a;

        /* renamed from: b */
        public final /* synthetic */ String f51588b;

        /* renamed from: c */
        public final /* synthetic */ int f51589c;

        /* renamed from: d */
        public final /* synthetic */ String f51590d;

        /* renamed from: e */
        public final /* synthetic */ String f51591e;

        /* renamed from: f */
        public final /* synthetic */ String f51592f;

        /* renamed from: g */
        public final /* synthetic */ String f51593g;

        /* renamed from: h */
        public final /* synthetic */ String f51594h;

        public a(Context context, String str, int i10, String str2, String str3, String str4, String str5, String str6) {
            this.f51587a = context;
            this.f51588b = str;
            this.f51589c = i10;
            this.f51590d = str2;
            this.f51591e = str3;
            this.f51592f = str4;
            this.f51593g = str5;
            this.f51594h = str6;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C10812z.m65838g(this.f51587a, this.f51588b, this.f51589c, this.f51590d, this.f51591e, this.f51592f, this.f51593g, this.f51594h);
        }
    }

    /* renamed from: je.z$b */
    public class b extends AbstractC12368e {

        /* renamed from: a */
        public final /* synthetic */ String f51595a;

        /* renamed from: b */
        public final /* synthetic */ int f51596b;

        /* renamed from: c */
        public final /* synthetic */ int f51597c;

        /* renamed from: d */
        public final /* synthetic */ String f51598d;

        /* renamed from: e */
        public final /* synthetic */ Context f51599e;

        /* renamed from: f */
        public final /* synthetic */ String f51600f;

        /* renamed from: g */
        public final /* synthetic */ String f51601g;

        public b(String str, int i10, int i11, String str2, Context context, String str3, String str4) {
            this.f51595a = str;
            this.f51596b = i10;
            this.f51597c = i11;
            this.f51598d = str2;
            this.f51599e = context;
            this.f51600f = str3;
            this.f51601g = str4;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("deleteStatus", this.f51595a);
            linkedHashMap.put("totalSize", String.valueOf(this.f51596b));
            linkedHashMap.put("reportStatus", this.f51597c == 1 ? "delete" : "retain");
            linkedHashMap.put("extra", this.f51598d);
            linkedHashMap.put(HwPayConstant.KEY_USER_ID, C13471c.m81133f());
            C10812z.m65846o(this.f51599e, this.f51600f, 0, "", "03001", this.f51601g, C10812z.m65832a("03001"), linkedHashMap, true);
        }
    }

    /* renamed from: a */
    public static String m65832a(String str) {
        return C11058a.m66627b(str);
    }

    /* renamed from: b */
    public static LinkedHashMap<String, String> m65833b(String str) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        if (m65835d(str)) {
            HashMap map = f51586a.get(str);
            linkedHashMap.put("packageName", (String) map.get("packageName"));
            linkedHashMap.put("versionName", (String) map.get("versionName"));
            String str2 = (String) map.get("appId");
            if (!TextUtils.isEmpty(str2)) {
                linkedHashMap.put("appId", str2);
            }
        }
        return linkedHashMap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0052  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m65834c(android.content.Context r5, java.lang.String r6, java.lang.String r7) {
        /*
            if (r5 == 0) goto L7c
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto La
            goto L7c
        La:
            int r0 = r6.hashCode()
            r1 = 1
            r2 = 4
            r3 = 3
            r4 = 2
            switch(r0) {
                case -1376863011: goto L48;
                case -178324674: goto L3e;
                case 3652034: goto L34;
                case 93144203: goto L2a;
                case 150940456: goto L20;
                case 2129240929: goto L16;
                default: goto L15;
            }
        L15:
            goto L52
        L16:
            java.lang.String r0 = "notepad"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L52
            r6 = r4
            goto L53
        L20:
            java.lang.String r0 = "browser"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L52
            r6 = 5
            goto L53
        L2a:
            java.lang.String r0 = "atlas"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L52
            r6 = r3
            goto L53
        L34:
            java.lang.String r0 = "wlan"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L52
            r6 = r2
            goto L53
        L3e:
            java.lang.String r0 = "calendar"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L52
            r6 = r1
            goto L53
        L48:
            java.lang.String r0 = "addressbook"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L52
            r6 = 0
            goto L53
        L52:
            r6 = -1
        L53:
            java.lang.String r0 = "com.huawei.hidisk"
            if (r6 == 0) goto L70
            if (r6 == r1) goto L6b
            if (r6 == r4) goto L66
            if (r6 == r3) goto L61
            if (r6 == r2) goto L60
            return r7
        L60:
            return r0
        L61:
            java.lang.String r5 = p783xp.C13843a.m83054F(r5)
            return r5
        L66:
            java.lang.String r5 = p783xp.C13843a.m83050B(r5)
            return r5
        L6b:
            java.lang.String r5 = p783xp.C13843a.m83093o(r5)
            return r5
        L70:
            boolean r6 = p783xp.C13843a.m83073Y(r5)
            if (r6 == 0) goto L7b
            java.lang.String r5 = p783xp.C13843a.m83094p(r5)
            return r5
        L7b:
            return r0
        L7c:
            java.lang.String r5 = ""
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: je.C10812z.m65834c(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: d */
    public static boolean m65835d(String str) {
        return f51586a.containsKey(str);
    }

    /* renamed from: e */
    public static boolean m65836e() {
        InterfaceC9282a interfaceC9282a = (InterfaceC9282a) C1270a.m7534b().m7535a(InterfaceC9282a.class);
        if (interfaceC9282a != null) {
            return interfaceC9282a.mo58442m0();
        }
        C11839m.m70688i("SyncReportUtil", "cloudAlbumRouterImpl is null");
        return false;
    }

    /* renamed from: f */
    public static void m65837f(Context context, String str, int i10, String str2, String str3, String str4, String str5) {
        m65838g(context, str, i10, "", str2, str3, str4, str5);
    }

    /* renamed from: g */
    public static void m65838g(Context context, String str, int i10, String str2, String str3, String str4, String str5, String str6) {
        m65839h(context, str, i10, str2, str3, str4, str5, str6, null, false);
    }

    /* renamed from: h */
    public static void m65839h(Context context, String str, int i10, String str2, String str3, String str4, String str5, String str6, LinkedHashMap<String, String> linkedHashMap, boolean z10) {
        m65842k(context, str, "", i10, str2, str3, str4, str5, str6, linkedHashMap, z10);
    }

    /* renamed from: i */
    public static void m65840i(Context context, String str, String str2, int i10, String str3, String str4, String str5, String str6) {
        m65841j(context, str, str2, i10, "", str3, str4, str5, str6);
    }

    /* renamed from: j */
    public static void m65841j(Context context, String str, String str2, int i10, String str3, String str4, String str5, String str6, String str7) {
        m65842k(context, str, str2, i10, str3, str4, str5, str6, str7, null, false);
    }

    /* renamed from: k */
    public static void m65842k(Context context, String str, String str2, int i10, String str3, String str4, String str5, String str6, String str7, LinkedHashMap<String, String> linkedHashMap, boolean z10) {
        if (context == null) {
            C11839m.m70688i("SyncReportUtil", "context is null");
            return;
        }
        if (C10028c.m62182c0().m62221H1()) {
            String strM81977w = C13622a.m81977w(str6);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("pn", "com.huawei.hidisk\u0001_" + C13622a.m81957c(str));
            linkedHashMap2.put("returnCode", C13622a.m81956b(i10, str3));
            linkedHashMap2.put("errorReason", str4);
            linkedHashMap2.put("operationType", str5);
            linkedHashMap2.put("business_id", str6);
            linkedHashMap2.put("traceID", str7);
            linkedHashMap2.put("syncType", str);
            if (!TextUtils.isEmpty(str2)) {
                linkedHashMap2.put("dataType", str2);
            }
            linkedHashMap2.put(HwPayConstant.KEY_USER_ID, C13452e.m80781L().m80971t0());
            linkedHashMap2.put("logVersion", "2.0");
            linkedHashMap2.put("endTrace", strM81977w);
            if (!TextUtils.isEmpty(str) && str.startsWith("atlas")) {
                linkedHashMap2.put("mobile_network", m65836e() + "");
                linkedHashMap2.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, String.valueOf(C0209d.m1225Y(C0213f.m1377a())));
            }
            if (linkedHashMap != null) {
                linkedHashMap2.putAll(linkedHashMap);
            }
            C13622a.m81974t(str7, linkedHashMap2, z10, "com.huawei.hidisk\u0001_notepadsync");
        }
    }

    /* renamed from: l */
    public static void m65843l(Context context, String str, String str2, int i10, int i11, String str3, String str4) {
        C12515a.m75110o().m75168b1(new b(str, i10, i11, str3, context, str2, str4));
    }

    /* renamed from: m */
    public static void m65844m(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        linkedHashMap.putAll(C13230i.m79499C(C13452e.m80781L().m80971t0()));
        C13226e.m79491f1().m79567R(str, linkedHashMap);
        UBAAnalyze.m29947H("CKC", str, linkedHashMap);
    }

    /* renamed from: n */
    public static void m65845n(Context context, String str, int i10, String str2, String str3, String str4, String str5, String str6) {
        C12515a.m75110o().m75168b1(new a(context, str, i10, str2, str3, str4, str5, str6));
    }

    /* renamed from: o */
    public static void m65846o(Context context, String str, int i10, String str2, String str3, String str4, String str5, LinkedHashMap<String, String> linkedHashMap, boolean z10) {
        m65839h(context, str, i10, "", str2, str3, str4, str5, linkedHashMap, z10);
    }

    /* renamed from: p */
    public static void m65847p(Context context, String str, String str2, int i10, String str3, String str4, String str5, String str6, LinkedHashMap<String, String> linkedHashMap, boolean z10) {
        m65842k(context, str, str2, i10, "", str3, str4, str5, str6, linkedHashMap, z10);
    }

    /* renamed from: q */
    public static void m65848q(String str, String str2, String str3) {
        HashMap map = new HashMap();
        map.put("packageName", str3);
        map.put("versionName", str2);
        f51586a.put(str, map);
    }

    /* renamed from: r */
    public static void m65849r(String str, String str2, String str3, String str4) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            map.put("appId", str2);
        }
        map.put("packageName", str4);
        map.put("versionName", str3);
        f51586a.put(str, map);
    }

    /* renamed from: s */
    public static void m65850s(Map<String, String> map, Asset asset) {
        if (asset == null) {
            C11839m.m70687e("SyncReportUtil", "setUploadTime asset is null");
            return;
        }
        String createdTime = asset.getCreatedTime();
        if (createdTime == null) {
            C11839m.m70687e("SyncReportUtil", "setUploadTime createdTime is null");
        } else {
            map.put("createTime", createdTime);
        }
    }
}
