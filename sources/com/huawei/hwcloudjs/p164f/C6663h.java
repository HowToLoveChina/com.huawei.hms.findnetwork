package com.huawei.hwcloudjs.p164f;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.Closeable;
import java.io.IOException;

/* renamed from: com.huawei.hwcloudjs.f.h */
/* loaded from: classes8.dex */
public class C6663h {

    /* renamed from: a */
    private static final String f30901a = "Utils";

    /* renamed from: b */
    private static int f30902b;

    /* renamed from: a */
    public static int m37899a() {
        int i10 = f30902b;
        f30902b = i10 + 1;
        return i10;
    }

    /* renamed from: b */
    public static String m37902b(Context context, String str) {
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    return packageManager.getPackageInfo(str, 16384).versionName;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                C6659d.m37881b("Utils", " NameNotFoundException .. ", true);
            }
        }
        return "";
    }

    /* renamed from: c */
    public static boolean m37903c(Context context, String str) throws PackageManager.NameNotFoundException {
        String str2;
        if (context == null || str == null) {
            str2 = "packageInstalled is null or context fail";
        } else {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                try {
                    packageManager.getPackageInfo(str, 16384);
                    return true;
                } catch (PackageManager.NameNotFoundException unused) {
                    C6659d.m37881b("Utils", "PackageManager NameNotFoundException ", true);
                }
            }
            str2 = "packageInstalled false";
        }
        C6659d.m37881b("Utils", str2, true);
        return false;
    }

    /* renamed from: a */
    public static int m37900a(Context context, String str) {
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    return packageManager.getPackageInfo(str, 16384).versionCode;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                C6659d.m37881b("Utils", " NameNotFoundException .. ", true);
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static void m37901a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                C6659d.m37881b("Utils", "closeStream IOException", true);
            }
        }
    }
}
