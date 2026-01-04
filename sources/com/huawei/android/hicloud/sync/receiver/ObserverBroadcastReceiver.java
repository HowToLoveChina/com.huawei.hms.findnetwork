package com.huawei.android.hicloud.sync.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.secure.android.common.intent.SafeIntent;
import gp.C10028c;
import p015ak.C0213f;
import p336he.C10155f;
import p514o9.C11829c;
import p514o9.C11839m;
import p573qc.C12338d;

/* loaded from: classes3.dex */
public class ObserverBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = new SafeIntent(intent).getAction();
        if (action == null || !"android.net.wifi.CONFIGURED_NETWORKS_CHANGE".equals(action) || C11829c.m70611r0()) {
            return;
        }
        if (!C10028c.m62182c0().m62221H1()) {
            C11839m.m70689w("ObserverBroadcastReceiver", "terms is not confirmed");
            return;
        }
        if (!C10155f.m63259L(context)) {
            C11839m.m70689w("ObserverBroadcastReceiver", "user is locked, ignore CONFIGURED_NETWORKS_CHANGE");
            return;
        }
        C11839m.m70686d("ObserverBroadcastReceiver", "CONFIGURED_NETWORKS_CHANGE");
        C12338d.m74195s().m74234l();
        if (!CloudSyncUtil.m15964M0(C0213f.m1377a())) {
            C11839m.m70689w("ObserverBroadcastReceiver", "wlan switch is closed");
        } else if (CloudSyncUtil.m16046s0()) {
            C11839m.m70686d("ObserverBroadcastReceiver", "CONFIGURED_NETWORKS_CHANGE isInDelayTime.");
        } else {
            C12338d.m74195s().m74240o();
        }
    }
}
