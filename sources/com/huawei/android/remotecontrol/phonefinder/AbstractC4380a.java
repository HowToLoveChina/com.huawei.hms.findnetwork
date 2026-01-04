package com.huawei.android.remotecontrol.phonefinder;

import android.content.Context;
import android.content.IntentFilter;
import com.huawei.android.remotecontrol.phonefinder.NetworkChangeReceiver;
import p015ak.C0209d;
import p809yg.C13981a;

/* renamed from: com.huawei.android.remotecontrol.phonefinder.a */
/* loaded from: classes4.dex */
public abstract class AbstractC4380a implements NetworkChangeReceiver.InterfaceC4379a {

    /* renamed from: b */
    public static final Object f20020b = new Object();

    /* renamed from: a */
    public NetworkChangeReceiver f20021a;

    @Override // com.huawei.android.remotecontrol.phonefinder.NetworkChangeReceiver.InterfaceC4379a
    /* renamed from: a */
    public void mo26438a(Context context) {
        C13981a.m83989i("NetWorkConnectedRetry", "network has changed");
        if (this.f20021a == null || context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        applicationContext.unregisterReceiver(this.f20021a);
        this.f20021a = null;
        mo26440c(applicationContext);
    }

    /* renamed from: b */
    public void m26439b(Context context) {
        synchronized (f20020b) {
            try {
                if (context == null) {
                    return;
                }
                if (this.f20021a == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (C0209d.m1333z1(applicationContext)) {
                        C13981a.m83989i("NetWorkConnectedRetry", "current network is connected");
                        return;
                    }
                    this.f20021a = new NetworkChangeReceiver(this);
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    applicationContext.registerReceiver(this.f20021a, intentFilter);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: c */
    public abstract void mo26440c(Context context);
}
