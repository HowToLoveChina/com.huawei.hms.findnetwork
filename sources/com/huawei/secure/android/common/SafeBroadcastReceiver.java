package com.huawei.secure.android.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

@Deprecated
/* loaded from: classes5.dex */
public abstract class SafeBroadcastReceiver extends BroadcastReceiver {
    /* renamed from: a */
    public final boolean m53570a(Context context, Intent intent) {
        if (context == null || intent == null) {
            return false;
        }
        try {
            intent.getStringExtra("TestIntent");
            return intent.getAction() != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Deprecated
    /* renamed from: b */
    public abstract void m53571b(Context context, Intent intent);

    @Override // android.content.BroadcastReceiver
    @Deprecated
    public final void onReceive(Context context, Intent intent) {
        if (m53570a(context, intent)) {
            m53571b(context, new SafeIntent(intent));
        }
    }
}
