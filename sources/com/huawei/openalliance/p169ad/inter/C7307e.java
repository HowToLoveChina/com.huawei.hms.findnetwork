package com.huawei.openalliance.p169ad.inter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.activity.SafeIntent;
import com.huawei.openalliance.p169ad.constant.Action;
import com.huawei.openalliance.p169ad.utils.C7735ai;

/* renamed from: com.huawei.openalliance.ad.inter.e */
/* loaded from: classes2.dex */
public class C7307e extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            AbstractC7185ho.m43821b("HwAccountReceiver", "onReceive action: %s", action);
            if (!TextUtils.isEmpty(safeIntent.getPackage())) {
                AbstractC7185ho.m43821b("HwAccountReceiver", "duplicate broadcast to: %s", safeIntent.getPackage());
            } else if (Action.ACTION_HW_ACCOUNT_LOGIN.equalsIgnoreCase(action) || Action.ACTION_HW_ACCOUNT_LOGOUT.equalsIgnoreCase(action)) {
                C7735ai.m47488b(context.getApplicationContext());
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("HwAccountReceiver", "onReceive Exception: %s", th2.getClass().getSimpleName());
        }
    }
}
