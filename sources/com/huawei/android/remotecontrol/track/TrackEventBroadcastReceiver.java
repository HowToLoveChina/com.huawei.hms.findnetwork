package com.huawei.android.remotecontrol.track;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public class TrackEventBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        if (!context.getPackageName().equals(C4452n.m27023c(context))) {
            C13981a.m83989i("TrackEventBroadcastReceiver", "TrackEventBroadcastReceiver from:" + C4452n.m27023c(context));
            return;
        }
        String action = hiCloudSafeIntent.getAction();
        if (action == null) {
            C13981a.m83988e("TrackEventBroadcastReceiver", " TrackEventBroadcastReceiver get action is null ");
            return;
        }
        C13981a.m83989i("TrackEventBroadcastReceiver", "action:" + action);
        if ("com.huawei.android.remotecontrol.intent.PHONEFINDER_RESULT".equals(action)) {
            if (hiCloudSafeIntent.getBooleanExtra("phonefinder_result", true)) {
                return;
            }
            C4443e.m26985i(context);
        } else if ("com.huawei.android.remotecontrol.intent.STOP_TRACK".equals(action)) {
            C4443e.m26985i(context);
        }
    }
}
