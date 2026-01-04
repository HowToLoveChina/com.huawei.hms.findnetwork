package je;

import android.text.TextUtils;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import p015ak.C0213f;
import p015ak.C0234s;
import p429kk.C11058a;
import p429kk.C11060c;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: je.y */
/* loaded from: classes3.dex */
public class C10811y {
    /* renamed from: a */
    public static void m65817a(String str, LinkedHashMap<String, String> linkedHashMap) {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("deviceId", C13452e.m80781L().m80954p());
            if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
                linkedHashMapM79497A.putAll(linkedHashMap);
            }
            C13225d.m79490f1().m79567R(str, linkedHashMapM79497A);
            UBAAnalyze.m29947H("PVC", str, linkedHashMapM79497A);
        } catch (Exception e10) {
            NotifyLogger.m29914e("SpaceInsuffWindowReportUtil", "biReport exception: " + e10.getMessage());
        }
    }

    /* renamed from: b */
    public static C11060c m65818b(String str) {
        return C11058a.m66626a(C11058a.m66627b("07068"), str, C13452e.m80781L().m80971t0());
    }

    /* renamed from: c */
    public static void m65819c(String str, LinkedHashMap<String, String> linkedHashMap, String str2, String str3) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("deviceId", C13452e.m80781L().m80954p());
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            linkedHashMapM79497A.putAll(linkedHashMap);
        }
        try {
            C11060c c11060cM65818b = m65818b(str);
            c11060cM65818b.m66665u(str2);
            c11060cM65818b.m66635A(str3);
            C13622a.m81969o(C0213f.m1377a(), c11060cM65818b, linkedHashMapM79497A);
        } catch (Exception e10) {
            NotifyLogger.m29914e("SpaceInsuffWindowReportUtil", "omReport exception: " + e10.getMessage());
        }
    }

    /* renamed from: d */
    public static void m65820d(String str, LinkedHashMap<String, String> linkedHashMap) {
        m65817a(str, linkedHashMap);
        m65819c(str, linkedHashMap, "0", "ok");
    }

    /* renamed from: e */
    public static void m65821e(boolean z10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("silentDelay", String.valueOf(z10));
        m65820d("backup_fail_dialog_muted_V5", linkedHashMap);
    }

    /* renamed from: f */
    public static void m65822f(String str, String str2, String str3) {
        m65819c(str, null, str2, str3);
    }

    /* renamed from: g */
    public static void m65823g(String str, String str2, String str3, String str4, int i10, HashMap<String, String> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("clickId", str);
        linkedHashMap.put("linkUri", str2);
        linkedHashMap.put("dialogLevel", str3);
        linkedHashMap.put("buttonsNum", String.valueOf(i10));
        if (map != null) {
            linkedHashMap.putAll(map);
        }
        if (!TextUtils.isEmpty(str4)) {
            linkedHashMap.put("buttonInfo", str4);
        }
        m65820d("backup_space_insuff_window_click_event", linkedHashMap);
    }

    /* renamed from: h */
    public static void m65824h(boolean z10, String str, JSONArray jSONArray, LinkedHashMap<String, String> linkedHashMap) {
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put("showSetting", String.valueOf(z10));
        linkedHashMap2.put("reminderId", String.valueOf(str));
        linkedHashMap2.put("buttonsNum", String.valueOf(jSONArray.length()));
        linkedHashMap2.put("current_language", C0234s.m1631i());
        if (linkedHashMap != null) {
            linkedHashMap2.putAll(linkedHashMap);
        }
        if (jSONArray.length() > 0) {
            linkedHashMap2.put("buttonsInfo", jSONArray.toString());
        }
        m65820d("backup_space_insuff_window_show_event", linkedHashMap2);
    }

    /* renamed from: i */
    public static void m65825i(String str, String str2, long j10, long j11, long j12, int i10, HashMap<String, String> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("clickId", str);
        linkedHashMap.put("checkedItem", str2);
        linkedHashMap.put("buttonsNum", String.valueOf(i10));
        linkedHashMap.put("usedSize", String.valueOf(j11));
        linkedHashMap.put("totalSize", String.valueOf(j10));
        linkedHashMap.put("deviceBackupSize", String.valueOf(j12));
        if (map != null) {
            linkedHashMap.putAll(map);
        }
        m65820d("no_more_reminder_window_click_event", linkedHashMap);
    }

    /* renamed from: j */
    public static void m65826j(String str, int i10, HashMap<String, String> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("remindType", str);
        linkedHashMap.put("buttonsNum", String.valueOf(i10));
        if (map != null) {
            linkedHashMap.putAll(map);
        }
        m65820d("no_more_reminder_window_show_event", linkedHashMap);
    }

    /* renamed from: k */
    public static void m65827k(SafeIntent safeIntent) {
        if ("backup_space_insuff_notify_bar_click_event".equals(safeIntent.getStringExtra(RemoteMessageConst.FROM)) && !TextUtils.isEmpty(safeIntent.getStringExtra("gotoDeeplink"))) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("linkUri", safeIntent.getStringExtra("gotoDeeplink"));
            m65820d("backup_space_insuff_notify_bar_click_event", linkedHashMap);
        }
    }

    /* renamed from: l */
    public static void m65828l() {
        m65820d("backup_space_insuff_notify_bar_show_event", null);
    }

    /* renamed from: m */
    public static void m65829m(String str, HashMap<String, String> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("clickId", str);
        if (map != null) {
            linkedHashMap.putAll(map);
        }
        m65820d("secondary_retention_window_click_event", linkedHashMap);
    }

    /* renamed from: n */
    public static void m65830n(String str, int i10, int i11, HashMap<String, String> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("linkUri", str);
        linkedHashMap.put("dialogType", String.valueOf(i10));
        linkedHashMap.put("buttonsNum", String.valueOf(i11));
        if (map != null) {
            linkedHashMap.putAll(map);
        }
        m65820d("secondary_retention_window_show_event", linkedHashMap);
    }

    /* renamed from: o */
    public static void m65831o(boolean z10, String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("autoBackup", String.valueOf(z10));
        linkedHashMap.put("backupSpaceNotEnoughNeedData", str);
        m65820d("send_space_not_enough_V5", linkedHashMap);
    }
}
