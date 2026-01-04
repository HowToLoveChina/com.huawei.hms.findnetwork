package kp;

import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.LinkedHashMap;
import java.util.Map;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: kp.d */
/* loaded from: classes7.dex */
public class C11128d {
    /* renamed from: a */
    public static void m66918a(String str, LinkedHashMap<String, String> linkedHashMap) {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            if (linkedHashMap != null) {
                linkedHashMapM79497A.putAll(linkedHashMap);
            }
            C13227f.m79492i1().m79567R(str, linkedHashMapM79497A);
            UBAAnalyze.m29947H("PVC", str, linkedHashMapM79497A);
        } catch (Exception e10) {
            NotifyLogger.m29914e("TextLinkReportUtil", "biReport exception: " + e10.toString());
        }
    }

    /* renamed from: b */
    public static void m66919b(String str, Map<String, String> map) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        if (linkedHashMapM79497A != null) {
            linkedHashMapM79497A.putAll(map);
        }
        try {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06020"), str, C13452e.m80781L().m80971t0());
            c11060cM66626a.m66665u("0");
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, linkedHashMapM79497A);
        } catch (Exception e10) {
            NotifyLogger.m29914e("TextLinkReportUtil", "omReport exception: " + e10.toString());
        }
    }

    /* renamed from: c */
    public static void m66920c(String str, LinkedHashMap<String, String> linkedHashMap) {
        m66918a(str, linkedHashMap);
        m66919b(str, linkedHashMap);
    }

    /* renamed from: d */
    public static void m66921d(String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(NotifyConstants.TextLinkConst.ENTRANCE_KEY, str);
        m66920c(str2, linkedHashMap);
    }

    /* renamed from: e */
    public static void m66922e(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(NotifyConstants.TextLinkConst.TEXT_LINK_ID, str2);
        linkedHashMap.put(NotifyConstants.TextLinkConst.ENTRANCE_KEY, str);
        linkedHashMap.put(NotifyConstants.TextLinkConst.TEXT_LINK_NOTIFY_TYPE, str3);
        m66920c(NotifyConstants.TextLinkConst.TEXT_LINK_EVENT_CLICK, linkedHashMap);
    }

    /* renamed from: f */
    public static void m66923f(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(NotifyConstants.TextLinkConst.TEXT_LINK_ID, str2);
        linkedHashMap.put(NotifyConstants.TextLinkConst.ENTRANCE_KEY, str);
        linkedHashMap.put(NotifyConstants.TextLinkConst.TEXT_LINK_NOTIFY_TYPE, str3);
        m66920c(NotifyConstants.TextLinkConst.TEXT_LINK_EVENT_CLOSE, linkedHashMap);
    }

    /* renamed from: g */
    public static void m66924g(String str, String str2, String str3, String str4) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(NotifyConstants.TextLinkConst.TEXT_LINK_ID, str2);
        linkedHashMap.put(NotifyConstants.TextLinkConst.ENTRANCE_KEY, str);
        linkedHashMap.put(NotifyConstants.TextLinkConst.TEXT_LINK_EVENT_GOTO_FAILED_REASON, str3);
        linkedHashMap.put(NotifyConstants.TextLinkConst.TEXT_LINK_NOTIFY_TYPE, str4);
        m66920c(NotifyConstants.TextLinkConst.TEXT_LINK_EVENT_GOTO_FAILED, linkedHashMap);
    }

    /* renamed from: h */
    public static void m66925h(String str, String str2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(NotifyConstants.TextLinkConst.TEXT_LINK_ID, str2);
        linkedHashMap.put(NotifyConstants.TextLinkConst.ENTRANCE_KEY, str);
        linkedHashMap.put(NotifyConstants.TextLinkConst.TEXT_LINK_NOTIFY_TYPE, str3);
        m66920c(NotifyConstants.TextLinkConst.TEXT_LINK_EVENT_SHOW, linkedHashMap);
    }
}
