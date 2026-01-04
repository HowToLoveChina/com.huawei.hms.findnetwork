package sg;

import android.content.Context;
import android.os.Build;
import ck.C1443a;
import com.huawei.android.remotecontrol.controller.cmd.PushCmdParser;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.security.SecureRandom;
import java.util.LinkedHashMap;
import p521og.C11873f;
import p521og.C11881n;
import p655te.C13009a;
import p709vj.C13452e;
import p783xp.C13843a;
import p809yg.C13981a;
import pg.AbstractC12139d;
import tm.C13040c;

/* renamed from: sg.b */
/* loaded from: classes4.dex */
public class C12797b {
    /* renamed from: a */
    public static String m76774a(String str) {
        C13981a.m83989i("AppEventLogParam", "creatTransId begin:" + str);
        if (str == null) {
            C13981a.m83988e("AppEventLogParam", "creatTransId error");
            return null;
        }
        return str + "_" + HiAnalyticsConstant.KeyAndValue.NUMBER_01 + "_" + System.currentTimeMillis() + "_" + m76775d();
    }

    /* renamed from: d */
    public static String m76775d() {
        StringBuilder sb2 = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        while (sb2.length() < 8) {
            sb2.append("0123456789".charAt(secureRandom.nextInt(10)));
        }
        return sb2.toString();
    }

    /* renamed from: f */
    public static String m76776f(String str, String str2) {
        if (str != null) {
            return str;
        }
        if ("01011".equals(str2)) {
            C13981a.m83989i("AppEventLogParam", "CMD_ACTIVE_ON,operationType:" + str2);
            return C11873f.m71178f().m71182d().get("activetrue");
        }
        if (!"01012".equals(str2)) {
            return str;
        }
        C13981a.m83989i("AppEventLogParam", "CMD_ACTIVE_OFF,operationType:" + str2);
        return C11873f.m71178f().m71182d().get("activefalse");
    }

    /* renamed from: l */
    public static void m76777l(Context context, String str, String str2, String str3, int i10, String str4, String str5, String str6, String str7) {
        if (context == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("returnCode", str4);
        linkedHashMap.put("errorReason", str5);
        linkedHashMap.put("resourcePath", "resourcePath");
        linkedHashMap.put("appVersion", C1443a.f6213a);
        linkedHashMap.put("operationType", str3);
        linkedHashMap.put("pn", "com.huawei.hidisk\u0001_phonefinder");
        linkedHashMap.put("traceID", str2);
        linkedHashMap.put("business_id", str);
        linkedHashMap.put("endTrace", String.valueOf(i10));
        linkedHashMap.put(HwPayConstant.KEY_USER_ID, str6);
        linkedHashMap.put("gradeCode", C13452e.m80781L().m80790C());
        linkedHashMap.put("loginType", str7);
        linkedHashMap.put("business_type", Build.MODEL);
        linkedHashMap.put("logversion", "1.4");
        linkedHashMap.put("androidVersion", Build.VERSION.RELEASE);
        C13981a.m83989i("AppEventLogParam", "wrapCollectEvent");
        C13009a.m78308c(context, linkedHashMap);
    }

    /* renamed from: b */
    public final String m76778b(LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        return linkedHashMap.toString();
    }

    /* renamed from: c */
    public final String m76779c(String str) {
        if (str == null) {
            C13981a.m83988e("AppEventLogParam", "getOperationType begin,operation is null");
            return null;
        }
        if ("locate".equals(str)) {
            return "01001";
        }
        if (!"bell".equals(str)) {
            if ("clear".equals(str)) {
                return "01002";
            }
            if ("inactive".equals(str)) {
                return "01010";
            }
            if ("openLostPattern".equals(str)) {
                return "01004";
            }
            if ("editLostPattern".equals(str)) {
                return "01005";
            }
            if ("stopLostPattern".equals(str)) {
                return "01006";
            }
            if ("lockScreen".equals(str)) {
                return "01009";
            }
            if (!"alarm".equals(str)) {
                return "shareLocate".equals(str) ? "01046" : str;
            }
        }
        return "01007";
    }

    /* renamed from: e */
    public final String m76780e(String str, int i10) {
        if ("001_3004".equals(str)) {
            return "007_" + i10;
        }
        if (!"001_2001".equals(str)) {
            return str;
        }
        return "001_" + i10;
    }

    /* renamed from: g */
    public void m76781g(Context context, String str, String str2, int i10, String str3, String str4, PushCmdParser pushCmdParser, String str5, boolean z10) {
        if (pushCmdParser != null) {
            m76784j(context, str, m76780e(str2, i10), str3, str4, pushCmdParser.getOperation(), pushCmdParser.getTraceID(), str5, z10);
            return;
        }
        C13981a.m83989i("AppEventLogParam", "AppLogApi reportEvent mParser is null:" + str);
    }

    /* renamed from: h */
    public void m76782h(Context context, String str, String str2, int i10, String str3, String str4, String str5, String str6, String str7, boolean z10) {
        m76784j(context, str, m76780e(str2, i10), str3, str4, str5, str6, str7, z10);
    }

    /* renamed from: i */
    public void m76783i(Context context, String str, String str2, String str3, String str4, PushCmdParser pushCmdParser, String str5, boolean z10) {
        if (pushCmdParser != null) {
            m76784j(context, str, str2, str3, str4, pushCmdParser.getOperation(), pushCmdParser.getTraceID(), str5, z10);
            return;
        }
        C13981a.m83989i("AppEventLogParam", "AppLogApi reportEvent mParser is null:" + str);
    }

    /* renamed from: j */
    public void m76784j(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z10) {
        m76785k(context, str, str2, str3, str4, str5, str6, str7, z10, null);
    }

    /* renamed from: k */
    public void m76785k(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z10, LinkedHashMap<String, String> linkedHashMap) {
        try {
            C13981a.m83989i("AppEventLogParam", "AppLogApi reportEvent operationType: " + str5);
            if (context == null) {
                C13981a.m83989i("AppEventLogParam", "AppLogApi reportEvent context is null");
                return;
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            String strM76776f = m76776f(str6, str5);
            String strM76779c = m76779c(str5);
            linkedHashMap2.put("returnCode", str2);
            linkedHashMap2.put("logTag", str);
            linkedHashMap2.put("errorReason", str3);
            linkedHashMap2.put("clientErrorCode", str4);
            linkedHashMap2.put("operationType", strM76779c);
            linkedHashMap2.put("resourcePath", "resourcePath");
            linkedHashMap2.put("pn", "com.huawei.hidisk\u0001_phonefinder");
            linkedHashMap2.put("appVersion", C1443a.f6213a);
            linkedHashMap2.put("business_id", str7);
            linkedHashMap2.put("traceID", strM76776f);
            linkedHashMap2.put("operation_type", strM76779c);
            linkedHashMap2.put("business_type", Build.MODEL);
            linkedHashMap2.put(HwPayConstant.KEY_USER_ID, AbstractC12139d.m72766e(context).getUserID());
            linkedHashMap2.put("gradeCode", C13452e.m80781L().m80790C());
            linkedHashMap2.put("logversion", "1.4");
            linkedHashMap2.put("endTrace", z10 ? "1" : "0");
            linkedHashMap2.put("androidVersion", Build.VERSION.RELEASE);
            String strM83101w = C13843a.m83101w(C13040c.m78609F().m78622N());
            linkedHashMap2.put("domain", strM83101w);
            linkedHashMap2.put("server_ip", C11881n.m71370t(strM83101w));
            linkedHashMap2.put("extraData", m76778b(linkedHashMap));
            C13009a.m78308c(context, linkedHashMap2);
        } catch (RuntimeException e10) {
            C13981a.m83988e("AppEventLogParam", "hiAnalyticsReport RuntimeException:" + e10.getMessage());
        } catch (Exception e11) {
            C13981a.m83988e("AppEventLogParam", "hiAnalyticsReport Exception:" + e11.getMessage());
        }
    }
}
