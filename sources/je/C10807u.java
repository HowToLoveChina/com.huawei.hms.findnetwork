package je;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import p015ak.C0209d;
import p514o9.C11839m;

/* renamed from: je.u */
/* loaded from: classes3.dex */
public class C10807u {

    /* renamed from: a */
    public static final String[] f51584a = {"com.noshufou.android.su", "com.thirdparty.superuser", "eu.chainfire.supersu", "com.koushikdutta.superuser", "com.zachspong.temprootremovejb", "com.ramdroid.appquarantine"};

    /* renamed from: a */
    public static boolean m65785a() {
        String str = Build.TAGS;
        if (str == null || !str.contains("test-keys")) {
            return false;
        }
        C11839m.m70688i("RootUtil", "checkBuildTags: device is rooted");
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m65786b() {
        /*
            java.lang.String r0 = android.os.Build.HARDWARE
            java.lang.String r1 = "goldfish"
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L41
            java.lang.String r0 = android.os.Build.FINGERPRINT
            java.lang.String r1 = "generic"
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L41
            java.lang.String r0 = android.os.Build.MODEL
            java.lang.String r1 = "google_sdk"
            boolean r2 = r0.contains(r1)
            if (r2 != 0) goto L41
            java.lang.String r2 = "Emulator"
            boolean r2 = r0.contains(r2)
            if (r2 != 0) goto L41
            java.lang.String r2 = "Android SDK built for x86"
            boolean r2 = r0.contains(r2)
            if (r2 != 0) goto L41
            java.lang.String r2 = "Android SDK built for arm64"
            boolean r0 = r0.contains(r2)
            if (r0 != 0) goto L41
            java.lang.String r0 = android.os.Build.PRODUCT
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L3f
            goto L41
        L3f:
            r0 = 0
            goto L42
        L41:
            r0 = 1
        L42:
            if (r0 == 0) goto L4b
            java.lang.String r1 = "RootUtil"
            java.lang.String r2 = "Device is emulator"
            p514o9.C11839m.m70688i(r1, r2)
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: je.C10807u.m65786b():boolean");
    }

    /* renamed from: c */
    public static boolean m65787c(Context context) {
        if (context == null) {
            return false;
        }
        int i10 = 0;
        while (true) {
            String[] strArr = f51584a;
            if (i10 >= strArr.length) {
                return false;
            }
            if (C0209d.m1184K0(context, strArr[i10])) {
                C11839m.m70688i("RootUtil", "checkRootApp: device is rooted, root app installed: " + i10);
                return true;
            }
            i10++;
        }
    }

    /* renamed from: d */
    public static boolean m65788d() {
        String strM65791g = m65791g();
        if (strM65791g == null || strM65791g.isEmpty() || "0".equals(strM65791g)) {
            return false;
        }
        C11839m.m70688i("RootUtil", "checkRootProperty: device is rooted");
        return true;
    }

    /* renamed from: e */
    public static boolean m65789e() {
        if (!"0".equals(m65792h("ro.secure"))) {
            return false;
        }
        C11839m.m70688i("RootUtil", "checkSecureProperty: device is rooted");
        return true;
    }

    /* renamed from: f */
    public static boolean m65790f() {
        String str = System.getenv("PATH");
        if (str == null) {
            C11839m.m70687e("RootUtil", "checkSu cannot obtain $PATH, using default");
            str = "/sbin:/vendor/bin:/system/sbin:/system/bin:/system/xbin";
        }
        for (String str2 : str.split(":")) {
            if (new File(str2 + "/su").exists()) {
                C11839m.m70688i("RootUtil", "checkSu: device is rooted");
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    public static String m65791g() {
        return m65792h("persist.sys.root.status");
    }

    /* renamed from: h */
    public static String m65792h(String str) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object objInvoke = cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (ClassNotFoundException unused) {
            C11839m.m70687e("RootUtil", "getSystemProperties, ClassNotFoundException.");
            return null;
        } catch (IllegalAccessException unused2) {
            C11839m.m70687e("RootUtil", "getSystemProperties, IllegalAccessException.");
            return null;
        } catch (IllegalArgumentException unused3) {
            C11839m.m70687e("RootUtil", "getSystemProperties, IllegalArgumentException.");
            return null;
        } catch (NoSuchMethodException unused4) {
            C11839m.m70687e("RootUtil", "getSystemProperties, NoSuchMethodException.");
            return null;
        } catch (InvocationTargetException unused5) {
            C11839m.m70687e("RootUtil", "getSystemProperties, InvocationTargetException.");
            return null;
        } catch (Exception unused6) {
            C11839m.m70687e("RootUtil", "getSystemProperties, Excetion.");
            return null;
        }
    }

    /* renamed from: i */
    public static boolean m65793i(Context context) {
        if (m65790f() || m65788d() || m65789e() || m65785a() || m65786b() || m65787c(context)) {
            return true;
        }
        C11839m.m70688i("RootUtil", "Device is not rooted");
        return false;
    }
}
