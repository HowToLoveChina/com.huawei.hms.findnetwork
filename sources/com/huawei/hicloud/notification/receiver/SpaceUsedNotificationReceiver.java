package com.huawei.hicloud.notification.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hicloud.notification.log.NotifyLogger;

/* loaded from: classes6.dex */
public class SpaceUsedNotificationReceiver extends BroadcastReceiver {
    private static final String TAG = "SpaceUsedNotificationReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NotifyLogger.m29915i(TAG, "SpaceUsedNotificationReceiver onReceive");
    }
}
