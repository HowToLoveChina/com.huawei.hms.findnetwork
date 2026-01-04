package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.huawei.hms.hatool.o */
/* loaded from: classes8.dex */
public abstract class AbstractC5555o {

    /* renamed from: com.huawei.hms.hatool.o$a */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    private static Object m32663a(Class cls, String str, Class[] clsArr, Object[] objArr) throws a {
        String str2;
        if (cls == null) {
            throw new a("class is null in invokeStaticFun");
        }
        if (clsArr == null) {
            if (objArr != null) {
                throw new a("paramsType is null, but params is not null");
            }
        } else {
            if (objArr == null) {
                throw new a("paramsType or params should be same");
            }
            if (clsArr.length != objArr.length) {
                throw new a("paramsType len:" + clsArr.length + " should equal params.len:" + objArr.length);
            }
        }
        try {
            try {
                return cls.getMethod(str, clsArr).invoke(null, objArr);
            } catch (IllegalAccessException unused) {
                str2 = "invokeStaticFun(): method invoke Exception!";
                C5571v.m32797f("hmsSdk", str2);
                return null;
            } catch (IllegalArgumentException unused2) {
                str2 = "invokeStaticFun(): Illegal Argument!";
                C5571v.m32797f("hmsSdk", str2);
                return null;
            } catch (InvocationTargetException unused3) {
                str2 = "invokeStaticFun(): Invocation Target Exception!";
                C5571v.m32797f("hmsSdk", str2);
                return null;
            }
        } catch (NoSuchMethodException unused4) {
            C5571v.m32797f("hmsSdk", "invokeStaticFun(): cls.getMethod(),No Such Method !");
        }
    }

    /* renamed from: b */
    public static String m32669b() {
        String strM32668a = m32668a("com.huawei.android.os.SystemPropertiesEx", "ro.huawei.build.display.id", "");
        C5571v.m32786a("hmsSdk", "SystemPropertiesEx: get rom_ver: " + strM32668a);
        if (!TextUtils.isEmpty(strM32668a)) {
            return strM32668a;
        }
        String str = Build.DISPLAY;
        C5571v.m32792c("hmsSdk", "SystemProperties: get rom_ver: " + str);
        return str;
    }

    /* renamed from: c */
    public static String m32671c(Context context) {
        return context == null ? "" : context.getPackageName();
    }

    /* renamed from: d */
    public static String m32672d(Context context) throws PackageManager.NameNotFoundException {
        if (context == null) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(m32671c(context), 16384);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (PackageManager.NameNotFoundException unused) {
            C5571v.m32797f("hmsSdk", "getVersion(): The package name is not correct!");
            return "";
        }
    }

    /* renamed from: a */
    private static Object m32664a(String str, String str2, Class[] clsArr, Object[] objArr) {
        String str3;
        try {
            return m32663a(Class.forName(str), str2, clsArr, objArr);
        } catch (a unused) {
            str3 = "invokeStaticFun(): Static function call Exception ";
            C5571v.m32797f("hmsSdk", str3);
            return null;
        } catch (ClassNotFoundException unused2) {
            str3 = "invokeStaticFun() Not found class!";
            C5571v.m32797f("hmsSdk", str3);
            return null;
        }
    }

    /* renamed from: b */
    public static String m32670b(Context context) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("CHANNEL")) == null) {
                return "Unknown";
            }
            String string = obj.toString();
            return string.length() > 256 ? "Unknown" : string;
        } catch (PackageManager.NameNotFoundException unused) {
            C5571v.m32797f("hmsSdk", "getChannel(): The packageName is not correct!");
            return "Unknown";
        }
    }

    /* renamed from: a */
    public static String m32665a() {
        return m32667a("ro.build.version.emui", "");
    }

    @SuppressLint({"HardwareIds"})
    /* renamed from: a */
    public static String m32666a(Context context) {
        return context == null ? "" : Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    /* renamed from: a */
    public static String m32667a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String strM32668a = m32668a("android.os.SystemProperties", str, str2);
        return TextUtils.isEmpty(strM32668a) ? m32668a("com.huawei.android.os.SystemPropertiesEx", str, str2) : strM32668a;
    }

    /* renamed from: a */
    private static String m32668a(String str, String str2, String str3) {
        Object objM32664a = m32664a(str, "get", new Class[]{String.class, String.class}, new Object[]{str2, str3});
        return objM32664a != null ? (String) objM32664a : str3;
    }
}
