package au;

import android.os.Build;
import com.huawei.android.os.SystemPropertiesEx;
import p039bu.C1289b;

/* renamed from: au.a */
/* loaded from: classes5.dex */
public class C1026a {
    /* renamed from: a */
    public static boolean m6217a() {
        boolean zM7645d = C1289b.m7645d("hw_sc.product.useBrandCust", false);
        if (zM7645d) {
            return zM7645d;
        }
        try {
            return SystemPropertiesEx.getBoolean("hw_sc.product.useBrandCust", false);
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m6218b() {
        return Build.MANUFACTURER.equalsIgnoreCase("HONOR");
    }

    /* renamed from: c */
    public static boolean m6219c() {
        return Build.MANUFACTURER.equalsIgnoreCase("HUAWEI") || m6217a();
    }

    /* renamed from: d */
    public static boolean m6220d() {
        return m6218b() || m6219c();
    }
}
