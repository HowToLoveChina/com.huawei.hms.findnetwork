package com.huawei.hms.network.embedded;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.network.inner.api.NetworkKitInnerImpl;
import com.huawei.hms.network.inner.api.NetworkReceiver;
import com.huawei.secure.android.common.intent.SafeBroadcastReceiver;
import java.util.Iterator;

/* renamed from: com.huawei.hms.network.embedded.y0 */
/* loaded from: classes8.dex */
public class C6159y0 extends SafeBroadcastReceiver {

    /* renamed from: a */
    public static final String f29129a = "NetworkStateReceiver";

    public static void registerNetworkState(Context context) {
        if (context == null) {
            Logger.m32145w(f29129a, "invalid parameter");
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            context.registerReceiver(new C6159y0(), intentFilter);
        } catch (RuntimeException unused) {
            Logger.m32145w(f29129a, "the broadcast register failed!");
        }
        Logger.m32143v(f29129a, "Register Network State Listen Success!");
    }

    @Override // com.huawei.secure.android.common.intent.SafeBroadcastReceiver
    public void onReceiveMsg(Context context, Intent intent) {
        Logger.m32143v(f29129a, "Capture network state change");
        NetworkUtil.updateCurrentNetworkType();
        Iterator<NetworkReceiver> it = NetworkKitInnerImpl.getInstance().getNetworkBroadcastManager().m34651a().iterator();
        while (it.hasNext()) {
            it.next().onReceiveMsg(context, intent);
        }
    }
}
