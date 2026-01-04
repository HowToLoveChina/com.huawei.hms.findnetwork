package ve;

import android.content.Context;
import java.util.LinkedHashMap;
import org.json.JSONObject;
import p227dg.C9120m0;
import p575qe.C12347f;
import p809yg.C13981a;
import sg.C12797b;

/* renamed from: ve.t */
/* loaded from: classes4.dex */
public class C13428t {
    /* renamed from: a */
    public static void m80716a(String str, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject) {
        try {
            Context contextM74301m = C12347f.m74285n().m74301m();
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("deviceId", C9120m0.m57351R(str));
            linkedHashMap.put("preDeviceType", str2);
            if (jSONObject != null) {
                linkedHashMap.put("info", jSONObject.toString());
            }
            new C12797b().m76785k(contextM74301m, "AncillaryDeviceReportUtil", str3, str4, "", str5, "", str6, true, linkedHashMap);
        } catch (Exception e10) {
            C13981a.m83988e("AncillaryDeviceReportUtil", "AncDeviceReport exception: " + e10.getMessage());
        }
    }
}
