package com.huawei.updatesdk.service.otaupdate;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a;

/* renamed from: com.huawei.updatesdk.service.otaupdate.a */
/* loaded from: classes9.dex */
public abstract class AbstractC8866a {
    /* renamed from: a */
    public static void m56439a(Context context, BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver == null || context == null) {
            return;
        }
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (IllegalArgumentException e10) {
            C8777a.m56028b("ActivityUtil", "unregisterReceiver error:" + e10.getMessage());
        }
    }

    /* renamed from: a */
    public static void m56440a(Context context, IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        if (intentFilter == null || broadcastReceiver == null || m56441a(context)) {
            return;
        }
        try {
            context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (IllegalArgumentException e10) {
            C8777a.m56028b("ActivityUtil", "registerReceiver error:" + e10.getMessage());
        }
    }

    /* renamed from: a */
    public static boolean m56441a(Context context) {
        if (context == null) {
            return true;
        }
        if (!(context instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context;
        if (!activity.isFinishing() && !activity.isDestroyed()) {
            return false;
        }
        C8777a.m56028b("ActivityUtil", "activity has bean finished, cannot instance:" + activity);
        return true;
    }
}
