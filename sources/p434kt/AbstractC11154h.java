package p434kt;

import android.os.Build;
import android.util.Log;

/* renamed from: kt.h */
/* loaded from: classes2.dex */
public abstract class AbstractC11154h {
    /* renamed from: a */
    public static int m67075a(String str, String str2) {
        try {
            return ((Integer) Class.forName(str).getDeclaredField(str2).get(null)).intValue();
        } catch (Throwable th2) {
            Log.w("SystemUtil", "getIntFieldValue Exception:" + th2.getClass().getSimpleName());
            return 0;
        }
    }

    /* renamed from: b */
    public static String m67076b(String str) {
        StringBuilder sb2;
        String str2;
        Class<?> cls;
        try {
            try {
                cls = Class.forName(m67077c() ? "com.hihonor.android.os.SystemPropertiesEx" : "com.huawei.android.os.SystemPropertiesEx");
            } catch (RuntimeException e10) {
                e = e10;
                sb2 = new StringBuilder();
                str2 = "getSystemProperties RuntimeException:";
                sb2.append(str2);
                sb2.append(e.getClass().getSimpleName());
                Log.w("SystemUtil", sb2.toString());
                return null;
            } catch (Throwable th2) {
                e = th2;
                sb2 = new StringBuilder();
                str2 = "getSystemProperties Exception:";
                sb2.append(str2);
                sb2.append(e.getClass().getSimpleName());
                Log.w("SystemUtil", sb2.toString());
                return null;
            }
        } catch (ClassNotFoundException unused) {
            cls = Class.forName("android.os.SystemProperties");
        }
        return (String) cls.getMethod("get", String.class).invoke(cls, str);
    }

    /* renamed from: c */
    public static boolean m67077c() {
        try {
            int iM67075a = m67075a("com.hihonor.android.os.Build$VERSION", "MAGIC_SDK_INT");
            int iM67075a2 = m67075a("com.hihonor.android.os.Build$VERSION_CODES", "MAGIC_6_0");
            if (Build.MANUFACTURER.equalsIgnoreCase("HONOR")) {
                return Build.VERSION.SDK_INT >= 31 && iM67075a >= iM67075a2;
            }
            return false;
        } catch (Throwable th2) {
            Log.e("SystemUtil", "isHonor6UpPhone Error:" + th2.getClass().getSimpleName());
            return false;
        }
    }
}
