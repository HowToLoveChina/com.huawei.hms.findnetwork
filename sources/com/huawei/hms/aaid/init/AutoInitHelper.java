package com.huawei.hms.aaid.init;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.opendevice.C6271i;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public class AutoInitHelper {
    public static void doAutoInit(Context context) {
        try {
            if (isAutoInitEnabled(context)) {
                HMSLog.m36988i("AutoInit", "Push init start");
                new Thread(new RunnableC5045a(context)).start();
            }
        } catch (Exception e10) {
            HMSLog.m36987e("AutoInit", "Push init failed", e10);
        }
    }

    public static boolean isAutoInitEnabled(Context context) {
        C6271i c6271iM36434a = C6271i.m36434a(context);
        if (c6271iM36434a.containsKey("push_kit_auto_init_enabled")) {
            return c6271iM36434a.getBoolean("push_kit_auto_init_enabled");
        }
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("push_kit_auto_init_enabled");
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            return false;
        }
    }

    public static void setAutoInitEnabled(Context context, boolean z10) {
        C6271i c6271iM36434a = C6271i.m36434a(context);
        boolean z11 = c6271iM36434a.getBoolean("push_kit_auto_init_enabled");
        c6271iM36434a.saveBoolean("push_kit_auto_init_enabled", z10);
        if (!z10 || z11) {
            return;
        }
        doAutoInit(context);
    }
}
