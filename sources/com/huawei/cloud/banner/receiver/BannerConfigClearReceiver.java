package com.huawei.cloud.banner.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import p258ei.C9492a;
import p514o9.C11839m;

/* loaded from: classes.dex */
public class BannerConfigClearReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || context == null) {
            C11839m.m70687e("BannerConfigClearReceiver", "intent null");
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            C11839m.m70687e("BannerConfigClearReceiver", "action invalid");
        } else if ("com.huawei.android.hicloud.CLEAR_BANNER".equals(action)) {
            C11839m.m70688i("BannerConfigClearReceiver", "BannerConfigClearReceiver onReceive CLEAR_ACTION");
            C9492a.m59357h().m59359b();
        }
    }
}
