package com.huawei.android.hicloud.sync.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.secure.android.common.intent.SafeIntent;
import p514o9.C11829c;
import p514o9.C11839m;
import p573qc.C12338d;
import p783xp.C13843a;

/* loaded from: classes3.dex */
public class PackagesChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String dataString;
        if (intent == null) {
            C11839m.m70689w("PackagesChangeReceiver", "intent is empty");
            return;
        }
        if (C11829c.m70611r0()) {
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        String action = safeIntent.getAction();
        C11839m.m70688i("PackagesChangeReceiver", "receive packagesChangeReceiver action = " + action);
        if (!"android.intent.action.PACKAGE_REMOVED".equals(action) || (dataString = safeIntent.getDataString()) == null) {
            return;
        }
        if (dataString.contains("com.huawei.contacts.sync") || dataString.contains("com.hihonor.contacts.sync")) {
            C11839m.m70688i("PackagesChangeReceiver", "receive contact sync removed broadcast");
            if (C13843a.m83073Y(context)) {
                return;
            }
            C12338d.m74195s().m74251u();
            C12338d.m74195s().m74218V();
            C12338d.m74195s().m74219W();
        }
    }
}
