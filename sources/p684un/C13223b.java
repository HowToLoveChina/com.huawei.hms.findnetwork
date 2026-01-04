package p684un;

import android.content.Context;
import android.content.Intent;
import com.huawei.hicloud.base.bean.CloudDiskModuleRst;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import p399jk.AbstractC10896a;
import vn.C13471c;

/* renamed from: un.b */
/* loaded from: classes6.dex */
public class C13223b {

    /* renamed from: a */
    public static int f59866a;

    /* renamed from: b */
    public static int f59867b;

    @Deprecated
    /* renamed from: a */
    public static void m79473a(Context context, String str, String str2) {
        if (str == null || str2 == null) {
            AbstractC10896a.m65888w("BIUtil", "params is null, collectEvent failed");
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("key", str);
        linkedHashMap.put("value", str2);
        C13230i.m79504I().m79571T(linkedHashMap);
    }

    /* renamed from: b */
    public static void m79474b(Context context, String str, String str2, int i10) {
        if (str == null || str2 == null) {
            AbstractC10896a.m65888w("BIUtil", "params is null, collectEvent failed");
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("key", str);
        linkedHashMap.put("value", str2);
        linkedHashMap.put("operationType", String.valueOf(i10));
        C13230i.m79504I().m79571T(linkedHashMap);
    }

    /* renamed from: c */
    public static void m79475c(Context context, String str, String str2, String str3, String str4) {
        C13222a.m79460b(context, str, str2, str3, str4);
    }

    @Deprecated
    /* renamed from: d */
    public static void m79476d(Context context, String str, boolean z10) {
        if (z10) {
            m79473a(context, C13471c.m81132e().get(str), "1");
        } else {
            m79473a(context, C13471c.m81131d().get(str), "1");
        }
    }

    /* renamed from: e */
    public static void m79477e(Context context, String str, boolean z10, int i10) {
        if (z10) {
            m79474b(context, C13471c.m81132e().get(str), "1", i10);
        } else {
            m79474b(context, C13471c.m81131d().get(str), "1", i10);
        }
    }

    /* renamed from: f */
    public static void m79478f(String str, String str2, String str3, String str4, String str5) {
        C13222a.m79462d(str, str2, str3, str4, str5);
    }

    /* renamed from: g */
    public static void m79479g(Context context, String str) {
        m79473a(context, C13471c.m81132e().get(str), "MOREDATA_CLICK_MORE_DATA");
    }

    /* renamed from: h */
    public static void m79480h(Context context, int i10, String str) {
        m79473a(context, C13471c.m81130c().get(Integer.valueOf(i10)) + str, "1");
        UBAAnalyze.m29943D("CKC", C13471c.m81130c().get(Integer.valueOf(i10)) + str);
    }

    /* renamed from: i */
    public static void m79481i(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("com.huawei.android.intent.action.settings.HICLOUD_ENTTRANCE".equals(action)) {
                m79473a(context, "CLOUDBACKUP_ENTRANCE_SETTING", "1");
                UBAAnalyze.m29954O("PVC", "CLOUDBACKUP_ENTRANCE_SETTING", "1", "4");
                return;
            }
            if ("com.huawei.android.intent.action.phonemanager.HICLOUD_ENTTRANCE".equals(action)) {
                m79473a(context, "CLOUDBACKUP_ENTRANCE_PHONEMANAGER", "1");
                UBAAnalyze.m29954O("PVC", "CLOUDBACKUP_ENTRANCE_PHONEMANAGER", "1", "6");
            } else if ("android.intent.action.MAIN".equals(action)) {
                m79473a(context, "CLOUDBACKUP_ENTRANCE_LAUNCHER", "1");
                UBAAnalyze.m29954O("PVC", "CLOUDBACKUP_ENTRANCE_LAUNCHER", "1", "22");
            } else if ("com.huawei.android.intent.action.otherapp.HICLOUD_ENTTRANCE".equals(action)) {
                m79473a(context, "CLOUDBACKUP_ENTRANCE_OTHERAPP", "1");
                UBAAnalyze.m29954O("PVC", "CLOUDBACKUP_ENTRANCE_OTHERAPP", "1", "100");
            }
        }
    }

    /* renamed from: j */
    public static JSONObject m79482j(Context context, String str, String str2, String str3, String str4) {
        return C13222a.m79464f(context, str, str2, str3, str4);
    }

    /* renamed from: k */
    public static void m79483k(CloudDiskModuleRst cloudDiskModuleRst) {
        f59866a = 0;
        f59867b = 0;
        int retCode = cloudDiskModuleRst.getRetCode();
        if (retCode == -10 || retCode == -2 || retCode == -1) {
            int failNum = cloudDiskModuleRst.getFailNum();
            if (failNum < 0) {
                failNum = 0;
            }
            f59866a = cloudDiskModuleRst.getSuccessNum() + failNum;
            f59867b = 0;
            return;
        }
        if (retCode == 0) {
            f59866a = cloudDiskModuleRst.getSuccessNum();
            f59867b = cloudDiskModuleRst.getSuccessNum();
        } else if (retCode == 1) {
            f59866a = 0;
            f59867b = 0;
        } else if (retCode == 2 || retCode == 3) {
            int failNum2 = cloudDiskModuleRst.getFailNum();
            f59866a = cloudDiskModuleRst.getSuccessNum() + (failNum2 >= 0 ? failNum2 : 0);
            f59867b = cloudDiskModuleRst.getSuccessNum();
        }
    }

    /* renamed from: l */
    public static void m79484l(Context context, int i10, int i11) {
        if (context == null) {
            AbstractC10896a.m65888w("BIUtil", "context is null, pushNotifyStatusBIReport failed");
            return;
        }
        String str = "pushSwitch:" + i10 + "," + FaqConstants.FAQ_CHANNEL + ":" + i11;
        C13227f.m79492i1().m79600y("pushNotifyStatus", str);
        UBAAnalyze.m29949J("CKC", "pushNotifyStatus", "value", str);
    }

    /* renamed from: m */
    public static void m79485m(Context context, CloudDiskModuleRst cloudDiskModuleRst, String str) {
        m79483k(cloudDiskModuleRst);
        if (f59867b == f59866a || !cloudDiskModuleRst.getBiCode().equals("0")) {
            m79473a(context, C13471c.m81128a().get(str), m79486n(String.valueOf(f59867b), String.valueOf(f59866a), cloudDiskModuleRst.getBiCode()));
            UBAAnalyze.m29949J("CKC", C13471c.m81128a().get(str), "value", m79486n(String.valueOf(f59867b), String.valueOf(f59866a), cloudDiskModuleRst.getBiCode()));
        } else {
            m79473a(context, C13471c.m81128a().get(str), m79486n(String.valueOf(f59867b), String.valueOf(f59866a), "-1"));
            UBAAnalyze.m29949J("CKC", C13471c.m81128a().get(str), "value", m79486n(String.valueOf(f59867b), String.valueOf(f59866a), "-1"));
        }
    }

    /* renamed from: n */
    public static String m79486n(String str, String str2, String str3) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ALL", str2);
            jSONObject.put("SUC", str);
            jSONObject.put("CODE", str3);
            return jSONObject.toString();
        } catch (Exception e10) {
            AbstractC10896a.m65886e("BIUtil", "put error: " + e10.toString());
            return null;
        }
    }
}
