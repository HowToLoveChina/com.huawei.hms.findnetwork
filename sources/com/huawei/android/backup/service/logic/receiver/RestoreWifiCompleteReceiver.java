package com.huawei.android.backup.service.logic.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;

/* loaded from: classes.dex */
public class RestoreWifiCompleteReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            C2111d.m12648d("RestoreWifiCompleteReceiver", "context or intent is null.");
        } else if ("com.hicloud.android.clone.RESTORE_WIFICONFIG_COMPLETE".equals(intent.getAction())) {
            C2111d.m12653i("RestoreWifiCompleteReceiver", "receive com.hicloud.android.clone.RESTORE_WIFICONFIG_COMPLETE.");
            BackupObject.setRestoreWifiComplete(true);
        }
    }
}
