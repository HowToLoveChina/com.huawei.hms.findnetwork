package com.huawei.hicloud.base.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import p664u0.C13108a;

/* loaded from: classes6.dex */
public abstract class CommonBaseBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a */
    public boolean f22143a = false;

    /* renamed from: a */
    public final void m29111a(Context context, IntentFilter intentFilter) {
        if (this.f22143a) {
            return;
        }
        this.f22143a = true;
        C13108a.m78878b(context).m78880c(this, intentFilter);
    }

    /* renamed from: b */
    public final void m29112b(Context context) {
        if (this.f22143a) {
            this.f22143a = false;
            C13108a.m78878b(context).m78883f(this);
        }
    }
}
