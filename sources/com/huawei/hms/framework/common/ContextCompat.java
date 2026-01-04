package com.huawei.hms.framework.common;

import android.content.Context;
import android.os.Process;

/* loaded from: classes8.dex */
public class ContextCompat {
    private static final String TAG = "ContextCompat";

    public static boolean checkSelfPermission(Context context, String str) {
        if (context == null || str == null) {
            Logger.m32145w(TAG, "param is null");
            return false;
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (RuntimeException e10) {
            Logger.m32139e(TAG, "dealType rethrowFromSystemServer:", e10);
            return false;
        }
    }

    public static Context getProtectedStorageContext(Context context) {
        if (context != null) {
            return context.createDeviceProtectedStorageContext();
        }
        Logger.m32145w(TAG, "context is null");
        return null;
    }

    public static Object getSystemService(Context context, String str) {
        if (context == null) {
            Logger.m32145w(TAG, "context is null");
            return null;
        }
        try {
            return context.getSystemService(str);
        } catch (RuntimeException e10) {
            Logger.m32139e(TAG, "SystemServer error:", e10);
            return null;
        }
    }
}
