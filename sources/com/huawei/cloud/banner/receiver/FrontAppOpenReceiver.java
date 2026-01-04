package com.huawei.cloud.banner.receiver;

import android.content.Context;
import android.content.Intent;
import com.huawei.hicloud.base.common.CommonBaseBroadcastReceiver;
import com.huawei.secure.android.common.intent.SafeIntent;
import p258ei.C9494c;
import p514o9.C11839m;

/* loaded from: classes.dex */
public class FrontAppOpenReceiver extends CommonBaseBroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || context == null) {
            C11839m.m70687e("FrontAppOpenReceiver", "intent or context is empty");
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        if ("com.huawei.hicloud.intent.action.ACTION_FRONT_APP_OPEN".equals(safeIntent.getAction())) {
            C11839m.m70688i("FrontAppOpenReceiver", "open app notify click");
            C9494c.m59390r().m59396H(safeIntent.getStringExtra("appPackageName"));
        }
    }
}
