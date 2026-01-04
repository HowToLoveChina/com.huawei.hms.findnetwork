package com.huawei.android.hicloud.sync.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.android.hicloud.complexutil.CloudSyncUtil;
import com.huawei.secure.android.common.intent.SafeIntent;
import p015ak.C0206b0;
import p015ak.C0213f;
import p514o9.C11839m;
import p573qc.C12338d;
import p836z8.C14158g;

/* loaded from: classes3.dex */
public class RecordingBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (!CloudSyncUtil.m16052u0(C0213f.m1377a(), "autorecordingkey")) {
            C11839m.m70688i("RecordingBroadcastReceiver", "recording switch not open.");
            return;
        }
        if (C0206b0.m1131c("funcfg_cloud_backup", C0213f.m1377a())) {
            C11839m.m70688i("RecordingBroadcastReceiver", "support cloudbackup, no need recording upload.");
            return;
        }
        if (!C0206b0.m1131c("funcfg_recordings_up", C0213f.m1377a())) {
            C11839m.m70688i("RecordingBroadcastReceiver", "not support recording up.");
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        String action = safeIntent.getAction();
        if (action == null || !"com.huawei.soundrecorder.action.NEW_RECORD_COMPLETED".equals(action)) {
            return;
        }
        long longExtra = safeIntent.getLongExtra("timestamp", 0L);
        C11839m.m70688i("RecordingBroadcastReceiver", "ACTION_NEW_RECORD_COMPLETED,timestamp: " + longExtra);
        C14158g.m84966c(longExtra, C0213f.m1377a());
        C12338d.m74195s().m74244q();
    }
}
