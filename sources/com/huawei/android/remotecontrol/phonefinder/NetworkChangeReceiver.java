package com.huawei.android.remotecontrol.phonefinder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.secure.android.common.intent.SafeIntent;
import p015ak.C0209d;
import p809yg.C13981a;

/* loaded from: classes4.dex */
public class NetworkChangeReceiver extends BroadcastReceiver {

    /* renamed from: a */
    public InterfaceC4379a f20019a;

    /* renamed from: com.huawei.android.remotecontrol.phonefinder.NetworkChangeReceiver$a */
    public interface InterfaceC4379a {
        /* renamed from: a */
        void mo26438a(Context context);
    }

    public NetworkChangeReceiver(InterfaceC4379a interfaceC4379a) {
        this.f20019a = interfaceC4379a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(new SafeIntent(intent).getAction()) && C0209d.m1333z1(context) && this.f20019a != null) {
            C13981a.m83989i("NetworkChangeReceiver", "NetworkChangeReceiver network connected");
            this.f20019a.mo26438a(context);
        }
    }
}
