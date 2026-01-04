package p368ih;

import android.app.UiModeManager;
import android.content.Context;
import com.huawei.android.app.PackageManagerEx;

/* renamed from: ih.d */
/* loaded from: classes4.dex */
public class C10505d {

    /* renamed from: a */
    public static int f50669a = -1;

    /* renamed from: a */
    public static int m64589a(Context context) {
        int i10 = f50669a;
        if (i10 >= 0) {
            return i10;
        }
        f50669a = m64594f(context) ? 1 : m64595g(context) ? 2 : m64592d(context) ? 3 : m64590b() ? 4 : m64593e(context) ? 7 : 0;
        return f50669a;
    }

    /* renamed from: b */
    public static boolean m64590b() {
        return m64591c("com.huawei.software.features.kidpad");
    }

    /* renamed from: c */
    public static boolean m64591c(String str) {
        try {
            return PackageManagerEx.hasHwSystemFeature(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m64592d(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.automotive");
    }

    /* renamed from: e */
    public static boolean m64593e(Context context) {
        return context.getPackageManager().hasSystemFeature("com.huawei.software.features.car");
    }

    /* renamed from: f */
    public static boolean m64594f(Context context) {
        return ((UiModeManager) context.getSystemService("uimode")).getCurrentModeType() == 4;
    }

    /* renamed from: g */
    public static boolean m64595g(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }
}
