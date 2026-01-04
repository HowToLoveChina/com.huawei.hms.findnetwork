package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.push.C6290i;
import com.huawei.hms.push.C6301t;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* loaded from: classes8.dex */
public class PushMsgReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private static void m36704a(Context context, Intent intent) {
        if (intent.hasExtra("selfshow_info")) {
            if (!C6290i.m36530a(context)) {
                HMSLog.m36988i("PushMsgReceiver", context.getPackageName() + " disable display notification.");
                if (!intent.hasExtra("selfshow_event_id")) {
                    return;
                }
            }
            C6301t.m36601a(context, intent);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || context == null) {
            return;
        }
        HMSLog.m36988i("PushMsgReceiver", "push receive broadcast message, Intent:" + intent.getAction() + " pkgName:" + context.getPackageName());
        try {
            intent.getStringExtra("TestIntent");
            String action = intent.getAction();
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context.getApplicationContext());
            }
            if ("com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(action) || ("com.huawei.intent.action.PUSH".equals(action) && HwBuildEx.VERSION.EMUI_SDK_INT < 10)) {
                m36704a(context, intent);
            } else {
                HMSLog.m36988i("PushMsgReceiver", "message can't be recognised.");
            }
        } catch (Exception unused) {
            HMSLog.m36986e("PushMsgReceiver", "intent has some error");
        }
    }
}
