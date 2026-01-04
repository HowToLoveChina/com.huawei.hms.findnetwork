package p655te;

import android.content.Context;
import android.text.TextUtils;
import ck.C1443a;
import gp.C10028c;
import java.util.LinkedHashMap;
import p684un.C13222a;
import p684un.C13230i;
import p809yg.C13981a;
import pg.AbstractC12139d;
import vn.C13470b;

/* renamed from: te.a */
/* loaded from: classes4.dex */
public class C13009a {
    /* renamed from: a */
    public static void m78306a(Context context, int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (!C10028c.m62182c0().m62221H1() || linkedHashMap == null || linkedHashMap.isEmpty()) {
            return;
        }
        try {
            LinkedHashMap<String, String> linkedHashMap2 = new LinkedHashMap<>();
            linkedHashMap2.putAll(linkedHashMap);
            C13230i.m79514Z0(linkedHashMap2, true, false);
            C13230i.m79504I().m79573U(str, linkedHashMap2);
            C13230i.m79504I().m79581a0(1);
            if (C1443a.f6214b.booleanValue()) {
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                linkedHashMap3.putAll(linkedHashMap2);
                C13230i.m79516a1(linkedHashMap3);
                C13981a.m83987d("BIUtils", "BI DATA = " + linkedHashMap3.toString());
            }
        } catch (Exception e10) {
            C13981a.m83988e("BIUtils", "report exception: " + e10.toString());
        }
    }

    /* renamed from: b */
    public static void m78307b(Context context, String str, String str2, String str3) {
        if (context == null) {
            C13981a.m83990w("BIUtils", "context is null, collectEvent failed");
            return;
        }
        if (C10028c.m62182c0().m62221H1() && C13470b.m81125a().m81126b()) {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            try {
                linkedHashMap.put("key", str);
                linkedHashMap.put("value", str2);
                linkedHashMap.put("gradeCode", str3);
            } catch (Exception unused) {
                C13981a.m83988e("BIUtils", "collectEvent Exception ");
            }
            C13230i.m79514Z0(linkedHashMap, true, true);
            C13230i.m79504I().m79567R("HUAWEICLOUD", linkedHashMap);
            C13230i.m79504I().m79581a0(0);
        }
    }

    /* renamed from: c */
    public static void m78308c(Context context, LinkedHashMap<String, String> linkedHashMap) {
        m78306a(context, 1, "HUAWEICLOUD", linkedHashMap);
    }

    /* renamed from: d */
    public static void m78309d(String str, String str2, String str3, String str4, String str5) {
        C13222a.m79462d(str, str2, str3, str4, str5);
    }

    /* renamed from: e */
    public static void m78310e(Context context, String str, String str2, String str3) {
        if (context == null) {
            C13981a.m83990w("BIUtils", "context is null, collectEvent failed");
            return;
        }
        if (C10028c.m62182c0().m62221H1() && C13470b.m81125a().m81126b()) {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            if (!TextUtils.isEmpty(str2)) {
                linkedHashMap.put("domId", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                linkedHashMap.put("gradeCode", str3);
            }
            C13230i.m79514Z0(linkedHashMap, true, true);
            C13230i.m79504I().m79567R(str, linkedHashMap);
            C13230i.m79504I().m79581a0(0);
        }
    }

    /* renamed from: f */
    public static String m78311f(Context context, String str, int i10, int i11) {
        if (TextUtils.isEmpty(str)) {
            C13981a.m83988e("BIUtils", "BI getCmdCapBiMsg traceID is null! ");
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(AbstractC12139d.m72766e(context).getUserID());
        stringBuffer.append("|");
        stringBuffer.append(i10);
        stringBuffer.append("|");
        stringBuffer.append(i11);
        stringBuffer.append("|");
        stringBuffer.append(str);
        C13981a.m83987d("BIUtils", "cmd:" + i10 + ", responseRlt:" + i11);
        return stringBuffer.toString();
    }

    /* renamed from: g */
    public static String m78312g(boolean z10) {
        return z10 ? "st login" : "standard login";
    }

    /* renamed from: h */
    public static String m78313h(boolean z10) {
        return z10 ? "system account" : "normal account";
    }
}
