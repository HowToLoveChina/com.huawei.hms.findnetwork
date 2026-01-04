package p336he;

import android.app.NotificationManager;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.LinkedHashMap;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: he.i */
/* loaded from: classes3.dex */
public class C10158i {
    /* renamed from: a */
    public static void m63317a(String str, LinkedHashMap<String, String> linkedHashMap) {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
                linkedHashMapM79497A.putAll(linkedHashMap);
            }
            C13227f.m79492i1().m79567R(str, linkedHashMapM79497A);
            UBAAnalyze.m29947H("PVC", str, linkedHashMapM79497A);
        } catch (Exception e10) {
            NotifyLogger.m29914e("HonorUpdateReportUtil", "biReport exception: " + e10.getMessage());
        }
    }

    /* renamed from: b */
    public static C11060c m63318b(String str) {
        return C11058a.m66626a(C11058a.m66627b("07070"), str, C13452e.m80781L().m80971t0());
    }

    /* renamed from: c */
    public static void m63319c(String str, LinkedHashMap<String, String> linkedHashMap, String str2, String str3) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            linkedHashMapM79497A.putAll(linkedHashMap);
        }
        try {
            C11060c c11060cM63318b = m63318b(str);
            c11060cM63318b.m66665u(str2);
            c11060cM63318b.m66635A(str3);
            C13622a.m81969o(C0213f.m1377a(), c11060cM63318b, linkedHashMapM79497A);
        } catch (Exception e10) {
            NotifyLogger.m29914e("HonorUpdateReportUtil", "omReport exception: " + e10.getMessage());
        }
    }

    /* renamed from: d */
    public static void m63320d(String str, LinkedHashMap<String, String> linkedHashMap) {
        m63317a(str, linkedHashMap);
        m63319c(str, linkedHashMap, "0", "ok");
    }

    /* renamed from: e */
    public static void m63321e(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("clickId", str);
        m63320d("honor_update_click_event", linkedHashMap);
    }

    /* renamed from: f */
    public static void m63322f(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("download_channel", str);
        m63320d("honor_update_download_channel", linkedHashMap);
    }

    /* renamed from: g */
    public static void m63323g() {
        m63320d("honor_update_notification_cancel", null);
    }

    /* renamed from: h */
    public static void m63324h(String str, LinkedHashMap<String, String> linkedHashMap) {
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("show_channel", str);
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            linkedHashMap2.putAll(linkedHashMap);
        }
        if ("1".equals(str)) {
            linkedHashMap2.put("notify_switch_enable", String.valueOf(((NotificationManager) C0213f.m1377a().getSystemService("notification")).areNotificationsEnabled() ? 1 : 0));
        }
        m63320d("honor_update_show_channel", linkedHashMap2);
    }
}
