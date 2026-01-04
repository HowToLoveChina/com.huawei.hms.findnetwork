package com.huawei.android.hicloud.common.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.CBLockAndFlowControlManager;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* loaded from: classes3.dex */
public class FlowControlReceiver extends BroadcastReceiver {

    public static class FlowControlTask extends AbstractC12367d {

        /* renamed from: a */
        public Context f11990a;

        public FlowControlTask(Context context) {
            this.f11990a = context;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            boolean zHasDeleteTask = CBAccess.hasDeleteTask();
            boolean zHasTaskWorking = CBAccess.hasTaskWorking();
            C11839m.m70688i("FlowControlReceiver", "start flow control request hasTaskWorking: " + zHasTaskWorking + " ,existDeleteTask: " + zHasDeleteTask);
            if (zHasTaskWorking || zHasDeleteTask) {
                CBAccess.keepLock();
            } else {
                CBLockAndFlowControlManager.cancelAlarm(this.f11990a.getApplicationContext());
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || context == null) {
            C11839m.m70687e("FlowControlReceiver", "intent null");
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            C11839m.m70687e("FlowControlReceiver", "action invalid");
        } else if (CloudBackupConstant.BackupFlowControl.FLOW_CONTROL_ACTION.equals(action)) {
            C12515a.m75110o().m75172d(new FlowControlTask(context));
        } else {
            C11839m.m70687e("FlowControlReceiver", "action not right");
        }
    }
}
