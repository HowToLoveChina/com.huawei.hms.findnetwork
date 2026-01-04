package com.huawei.updatesdk.p177a.p178a.p183d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.android.content.pm.ApplicationInfoEx;
import com.huawei.ohos.localability.base.BundleInfo;
import com.huawei.updatesdk.p177a.p178a.C8774a;
import com.huawei.updatesdk.p177a.p186b.p187a.C8793a;
import com.huawei.updatesdk.p191b.p201h.C8834b;
import gt.C10046b;
import ht.C10339b;
import java.lang.reflect.Field;
import java.util.Optional;

/* renamed from: com.huawei.updatesdk.a.a.d.e */
/* loaded from: classes9.dex */
public class C8783e {

    /* renamed from: a */
    private static boolean f45076a = false;

    /* renamed from: b */
    private static boolean f45077b = false;

    /* renamed from: a */
    public static PackageInfo m56045a(PackageInfo packageInfo) {
        BundleInfo bundleInfoM56046a;
        if (m56053d() && (bundleInfoM56046a = m56046a(packageInfo.packageName)) != null) {
            packageInfo.versionName = bundleInfoM56046a.m38548h();
            packageInfo.versionCode = bundleInfoM56046a.m38547g();
            packageInfo.applicationInfo.targetSdkVersion = m56051c(packageInfo.packageName);
            if (bundleInfoM56046a.m38550j()) {
                packageInfo.baseRevisionCode = packageInfo.versionCode;
            }
        }
        return packageInfo;
    }

    /* renamed from: b */
    private static BundleInfo m56049b(String str) {
        try {
            Optional<BundleInfo> optionalM62453a = C10046b.m62453a(str, 0);
            if (optionalM62453a.isPresent()) {
                return optionalM62453a.get();
            }
            return null;
        } catch (Throwable th2) {
            C8774a.m56008a("HarmonyUtils", "get BundleInfo exception, pkg:" + str + ", e:" + th2.getMessage());
            return null;
        }
    }

    /* renamed from: c */
    public static int m56051c(String str) {
        try {
            if (m56053d()) {
                Pair<Integer, Integer> pairM62455c = C10046b.m62455c(str);
                if (pairM62455c != null) {
                    return ((Integer) pairM62455c.second).intValue();
                }
                C8774a.m56008a("HarmonyUtils", "pair is null getHarmonySdkVersionInfo fail");
            }
        } catch (Throwable unused) {
            C8774a.m56008a("HarmonyUtils", "getHarmonySdkVersionInfo fail");
        }
        return 0;
    }

    /* renamed from: d */
    private static boolean m56053d() {
        if (!f45077b) {
            f45076a = m56048a(C8793a.m56132c().m56133a(), C8793a.m56132c().m56133a().getPackageName()) && m56052c();
            f45077b = true;
        }
        return f45076a;
    }

    /* renamed from: a */
    private static BundleInfo m56046a(String str) {
        if (m56053d()) {
            return m56049b(str);
        }
        return null;
    }

    /* renamed from: b */
    public static String m56050b() {
        C10339b c10339bM56047a;
        return (m56053d() && (c10339bM56047a = m56047a()) != null) ? c10339bM56047a.m63671a() : "";
    }

    /* renamed from: c */
    private static boolean m56052c() {
        try {
            new C10046b();
            return true;
        } catch (Throwable unused) {
            C8774a.m56008a("HarmonyUtils", "not Integrate HarmonySdk ");
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m56054d(String str) {
        if (m56053d() && !TextUtils.isEmpty(str)) {
            try {
                return C10046b.m62458f(str);
            } catch (Throwable unused) {
                C8774a.m56008a("HarmonyUtils", "get isHarmonyApp fail");
            }
        }
        return false;
    }

    /* renamed from: a */
    private static C10339b m56047a() {
        try {
            return C10046b.m62454b();
        } catch (Throwable unused) {
            C8774a.m56008a("HarmonyDeviceInfo", "get DeviceInfo fail");
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m56048a(Context context, String str) {
        Class<?> cls;
        Field declaredField;
        ApplicationInfo applicationInfo;
        try {
            cls = Class.forName("android.content.pm.AbsApplicationInfo");
            declaredField = cls.getDeclaredField("PARSE_IS_ZIDANE_APK");
            PackageInfo packageInfoM56313a = C8834b.m56313a(str, context);
            applicationInfo = packageInfoM56313a != null ? packageInfoM56313a.applicationInfo : null;
        } catch (Throwable th2) {
            C8774a.m56008a("HarmonyUtils", "isHarmonyByHwFlag exception for pkg: " + str + ", throwable : " + th2.getMessage());
        }
        if (applicationInfo != null) {
            int hwFlags = new ApplicationInfoEx(applicationInfo).getHwFlags();
            int i10 = declaredField.getInt(cls);
            boolean z10 = (hwFlags & i10) == i10;
            C8774a.m56009b("HarmonyUtils", "isHarmonyByHwFlag: " + z10 + ", packageName: " + str);
            return z10;
        }
        C8774a.m56010c("HarmonyUtils", "applicationInfo is null for pkg: " + str);
        return false;
    }
}
