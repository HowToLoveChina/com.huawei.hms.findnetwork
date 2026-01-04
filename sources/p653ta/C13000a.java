package p653ta;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.LinkedHashMap;
import p015ak.C0209d;
import p015ak.C0213f;
import p429kk.C11058a;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12368e;
import p616rk.C12515a;
import p709vj.C13452e;

/* renamed from: ta.a */
/* loaded from: classes3.dex */
public class C13000a {

    /* renamed from: ta.a$a */
    public class a extends AbstractC12368e {

        /* renamed from: a */
        public final /* synthetic */ C13001b f59228a;

        /* renamed from: b */
        public final /* synthetic */ LinkedHashMap f59229b;

        public a(C13001b c13001b, LinkedHashMap linkedHashMap) {
            this.f59228a = c13001b;
            this.f59229b = linkedHashMap;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C13000a.m78148c(this.f59228a, this.f59229b);
        }
    }

    /* renamed from: b */
    public static LinkedHashMap<String, String> m78147b(C13001b c13001b) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("pn", c13001b.m78155e());
        linkedHashMap.put("operationType", c13001b.m78154d());
        linkedHashMap.put("business_id", c13001b.m78151a());
        linkedHashMap.put("business_type", Build.MODEL);
        linkedHashMap.put("traceID", c13001b.m78157g());
        linkedHashMap.put(HwPayConstant.KEY_USER_ID, c13001b.m78158h());
        linkedHashMap.put("returnCode", c13001b.m78152b());
        linkedHashMap.put("errorReason", c13001b.m78153c());
        if (!TextUtils.isEmpty(c13001b.m78156f())) {
            linkedHashMap.put("taskType", c13001b.m78156f());
        }
        if ("dealObjectCompleted".equals(c13001b.m78151a()) || "download".equals(c13001b.m78151a())) {
            linkedHashMap.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, String.valueOf(C0209d.m1225Y(C0213f.m1377a())));
        }
        return linkedHashMap;
    }

    /* renamed from: c */
    public static void m78148c(C13001b c13001b, LinkedHashMap<String, String> linkedHashMap) {
        LinkedHashMap<String, String> linkedHashMapM78147b = m78147b(c13001b);
        if (linkedHashMap != null) {
            linkedHashMapM78147b.putAll(linkedHashMap);
        }
        C11829c.m70515F1(c13001b.m78157g(), linkedHashMapM78147b, false);
    }

    /* renamed from: d */
    public static void m78149d(C13001b c13001b, LinkedHashMap<String, String> linkedHashMap) {
        try {
            C12515a.m75110o().m75168b1(new a(c13001b, linkedHashMap));
        } catch (Exception e10) {
            C11839m.m70688i("ReportUtil", "reportEvent exception: " + e10.toString());
        }
    }

    /* renamed from: e */
    public static void m78150e(int i10, String str, String str2, String str3, LinkedHashMap<String, String> linkedHashMap) {
        C13001b c13001b = new C13001b();
        c13001b.m78163m("com.huawei.hidisk\u0001_syncdisk");
        if (TextUtils.isEmpty(str2)) {
            str2 = C11058a.m66627b("09004");
        }
        c13001b.m78164n(str2);
        c13001b.m78162l("09004");
        c13001b.m78160j(String.valueOf(i10));
        c13001b.m78161k(str);
        c13001b.m78159i(str3);
        c13001b.m78165o(C13452e.m80781L().m80971t0());
        m78149d(c13001b, linkedHashMap);
    }
}
