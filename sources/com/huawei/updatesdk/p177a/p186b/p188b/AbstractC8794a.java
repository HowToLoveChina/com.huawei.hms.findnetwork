package com.huawei.updatesdk.p177a.p186b.p188b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.huawei.updatesdk.a.b.b.a */
/* loaded from: classes9.dex */
public abstract class AbstractC8794a extends BroadcastReceiver {
    /* renamed from: a */
    public abstract void mo56135a(Context context, C8795b c8795b);

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        mo56135a(context, C8795b.m56136a(intent));
    }
}
