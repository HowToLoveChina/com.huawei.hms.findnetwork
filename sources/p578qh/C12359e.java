package p578qh;

import th.C13012a;

/* renamed from: qh.e */
/* loaded from: classes4.dex */
public class C12359e {
    /* renamed from: a */
    public static int m74385a(String str, int i10) throws ClassNotFoundException {
        String str2;
        try {
            return ((Integer) Class.forName("android.os.SystemProperties").getMethod("getInt", String.class, Integer.TYPE).invoke(null, str, Integer.valueOf(i10))).intValue();
        } catch (ClassNotFoundException e10) {
            e = e10;
            str2 = "ClassNotFoundException while getting system property: ";
            C13012a.m78316b("SystemPropertiesEx", str2, e);
            return i10;
        } catch (Exception e11) {
            e = e11;
            str2 = "Exception while getting system property: ";
            C13012a.m78316b("SystemPropertiesEx", str2, e);
            return i10;
        }
    }

    /* renamed from: b */
    public static String m74386b(String str) {
        String str2;
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (ClassNotFoundException e10) {
            e = e10;
            str2 = "ClassNotFoundException while getting system property: ";
            C13012a.m78316b("SystemPropertiesEx", str2, e);
            return "";
        } catch (Exception e11) {
            e = e11;
            str2 = "Exception while getting system property: ";
            C13012a.m78316b("SystemPropertiesEx", str2, e);
            return "";
        }
    }

    /* renamed from: c */
    public static String m74387c(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (ClassNotFoundException e10) {
            C13012a.m78316b("SystemPropertiesEx", "ClassNotFoundException while getting system property: ", e10);
            return "";
        } catch (Exception e11) {
            C13012a.m78316b("SystemPropertiesEx", "Exception while getting system property: ", e11);
            return str2;
        }
    }

    /* renamed from: d */
    public static boolean m74388d(String str, boolean z10) throws ClassNotFoundException {
        String str2;
        try {
            return ((Boolean) Class.forName("android.os.SystemProperties").getMethod("getBoolean", String.class, Boolean.TYPE).invoke(null, str, Boolean.valueOf(z10))).booleanValue();
        } catch (ClassNotFoundException e10) {
            e = e10;
            str2 = "ClassNotFoundException while getting system property: ";
            C13012a.m78316b("SystemPropertiesEx", str2, e);
            return z10;
        } catch (Exception e11) {
            e = e11;
            str2 = "Exception while getting system property: ";
            C13012a.m78316b("SystemPropertiesEx", str2, e);
            return z10;
        }
    }
}
