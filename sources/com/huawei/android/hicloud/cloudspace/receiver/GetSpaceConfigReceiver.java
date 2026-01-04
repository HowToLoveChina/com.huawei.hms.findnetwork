package com.huawei.android.hicloud.cloudspace.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class GetSpaceConfigReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            return;
        }
        C11839m.m70688i("GetSpaceConfigReceiver", "onReceive: " + intent.getAction());
    }
}
