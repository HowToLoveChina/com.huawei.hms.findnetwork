package com.huawei.cloud.pay.p098ui.broadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.secure.android.common.intent.SafeIntent;
import p054cj.C1442a;

/* loaded from: classes5.dex */
public class AcceptGiftSuccessBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a */
    public Activity f21467a;

    public AcceptGiftSuccessBroadcastReceiver(Activity activity) {
        this.f21467a = activity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Activity activity;
        String action = new SafeIntent(intent).getAction();
        C1442a.m8290i("AcceptGiftSuccessBroadcastReceiver", "receive broadcast action = " + action);
        if (!"com.huawei.hicloud.intent.action.accept.gift.success".equals(action) || (activity = this.f21467a) == null || activity.isFinishing()) {
            return;
        }
        this.f21467a.finish();
        C1442a.m8290i("AcceptGiftSuccessBroadcastReceiver", "receive broadcast, and finish activity success.");
    }
}
