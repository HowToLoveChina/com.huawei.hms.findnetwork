package com.huawei.android.hicloud.common.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import gp.C10028c;
import p015ak.C0219i;
import p514o9.C11829c;
import p514o9.C11839m;
import p572qb.C12301c;
import p573qc.C12338d;

/* loaded from: classes3.dex */
public class CloudSyncReceiver extends BroadcastReceiver {
    /* renamed from: a */
    public final void m15780a(Context context) {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (c10028cM62182c0.m62388s("addressbook") || c10028cM62182c0.m62388s("wlan") || c10028cM62182c0.m62388s("backup_key") || c10028cM62182c0.m62216G1(context)) {
            C11839m.m70688i("BackupCommonRecevier", "open service");
            C12301c.m73945b().m73954j(context);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            C11839m.m70686d("BackupCommonRecevier", "intent is empty");
            return;
        }
        String action = intent.getAction();
        C11839m.m70688i("BackupCommonRecevier", "get action : " + action);
        if ("android.intent.action.BOOT_COMPLETED".equals(action)) {
            C11839m.m70688i("BackupCommonRecevier", "ACTION_BOOT_COMPLETED");
            C12301c.m73945b().m73947c();
            if (C11829c.m70611r0()) {
                if (C0219i.m1463a() >= 23) {
                    C12338d.m74195s().m74233k0();
                }
                m15780a(context);
            } else {
                C12338d.m74195s().m74251u();
                C12338d.m74195s().m74253v();
                if (C0219i.m1463a() >= 23) {
                    C12301c.m73945b().m73955k(context);
                }
            }
        }
    }
}
