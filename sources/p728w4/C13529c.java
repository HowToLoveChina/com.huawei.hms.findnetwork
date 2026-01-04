package p728w4;

import com.huawei.android.backup.filelogic.utils.C2111d;

/* renamed from: w4.c */
/* loaded from: classes.dex */
public class C13529c {
    /* renamed from: a */
    public static String m81423a(String str) {
        try {
            return (String) C13527a.m81406l("android.os.SystemProperties").m81409b("get", str).m81413g();
        } catch (C13530d unused) {
            C2111d.m12648d("InnerReflectSysProperties", "err Reflect SystemProperties get no param");
            return "";
        }
    }

    /* renamed from: b */
    public static String m81424b(String str, String str2) {
        try {
            return (String) C13527a.m81406l("android.os.SystemProperties").m81409b("get", str, str2).m81413g();
        } catch (C13530d unused) {
            C2111d.m12648d("InnerReflectSysProperties", "err Reflect SystemProperties get has param");
            return str2;
        }
    }

    /* renamed from: c */
    public static boolean m81425c(String str, boolean z10) {
        try {
            return ((Boolean) C13527a.m81406l("android.os.SystemProperties").m81410c("getBoolean", str, Boolean.valueOf(z10)).m81413g()).booleanValue();
        } catch (C13530d unused) {
            C2111d.m12648d("InnerReflectSysProperties", "err Reflect SystemProperties getBoolean");
            return z10;
        }
    }
}
