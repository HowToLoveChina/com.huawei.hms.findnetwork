package com.huawei.android.remotecontrol.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import eg.AbstractC9478g;
import p575qe.C12347f;
import p616rk.C12515a;
import p809yg.C13981a;
import ug.C13171a;

/* loaded from: classes4.dex */
public class SystemServerCompleteReceiver extends BroadcastReceiver {

    public static class InitTaTask extends AbstractC9478g {

        /* renamed from: a */
        public final Context f20063a;

        public InitTaTask(Context context) {
            this.f20063a = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (C13171a.m79199e()) {
                C13171a.m79195a();
            }
            C12347f.m74285n().m74307t(this.f20063a);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C13981a.m83989i("SystemServerCompleteReceiver", "onReceive:" + new HiCloudSafeIntent(intent).getAction());
        if (C13171a.m79199e()) {
            C13981a.m83987d("SystemServerCompleteReceiver", "support true,not need init again");
            return;
        }
        C13981a.m83989i("SystemServerCompleteReceiver", "support false,reInit TA");
        C13171a.m79201g();
        C12515a.m75110o().m75172d(new InitTaTask(context));
    }
}
