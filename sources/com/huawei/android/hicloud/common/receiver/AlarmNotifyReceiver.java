package com.huawei.android.hicloud.common.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import p015ak.C0209d;
import p015ak.C0214f0;
import p020ap.C1008c;
import p336he.C10153d;
import p514o9.C11839m;
import p709vj.C13452e;

/* loaded from: classes3.dex */
public class AlarmNotifyReceiver extends BroadcastReceiver {
    /* renamed from: a */
    public final void m15778a(Context context, String[] strArr, String str) {
        if (strArr != null && strArr.length > 0) {
            C11839m.m70688i("AlarmNotifyReceiver", "BackupConstant.AUTOBACKUP_TIMER_ACTION, modulesName = " + strArr[0]);
        }
        if (TextUtils.isEmpty(C13452e.m80781L().m80971t0())) {
            C11839m.m70689w("AlarmNotifyReceiver", "uid is empty");
            return;
        }
        if (C10153d.m63239c() < 10) {
            C11839m.m70689w("AlarmNotifyReceiver", "batterylever lower than 10%");
            return;
        }
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(context, "deviceNameSp", 0);
        if (!"autophonemanagerkey".equals(str)) {
            if ("autorecordingkey".equals(str)) {
                C1008c.m6035v().m6083k0(context, "com.huawei.android.hicloud.sync.syncobserverservice.filelistener");
            }
        } else if (C0209d.m1208S0(context)) {
            C1008c.m6035v().m6094q();
        } else {
            sharedPreferencesM1382b.edit().putBoolean("autophonemanagerkeynotAllSucess", true).commit();
        }
    }

    /* renamed from: b */
    public final void m15779b(Context context, String str) {
        if (context == null || str == null) {
            C11839m.m70687e("AlarmNotifyReceiver", "context is null or itemStr is null");
            return;
        }
        C1008c.m6035v().m6042G(context.getApplicationContext());
        if (HNConstants.DataType.CONTACT.equals(str)) {
            C11839m.m70688i("AlarmNotifyReceiver", "receive contact retry alarm,start sync again");
            C1008c.m6035v().m6096r(3, 3);
        } else if ("wlan".equals(str)) {
            C11839m.m70688i("AlarmNotifyReceiver", "receive wlan retry alarm,start sync again");
            C1008c.m6035v().m6098s(3, 3);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        C11839m.m70686d("AlarmNotifyReceiver", "onReceive: " + safeIntent.getAction());
        if ("autobackupphonemanagertimeraction".equals(safeIntent.getAction())) {
            m15778a(context, new String[]{"phonemanager"}, "autophonemanagerkey");
            return;
        }
        if ("autobackupsmstimeraction".equals(safeIntent.getAction())) {
            m15778a(context, new String[]{"autosmslistkey"}, "autosmslistkey");
            return;
        }
        if ("autobackuprecording".equals(safeIntent.getAction())) {
            m15778a(context, new String[]{"autorecordingkey"}, "autorecordingkey");
        } else if ("com.huawei.android.intent.action.CONTACT_SYNC_TASK_RETRY".equals(safeIntent.getAction())) {
            m15779b(context, HNConstants.DataType.CONTACT);
        } else if ("com.huawei.android.intent.action.WLAN_SYNC_TASK_RETRY".equals(safeIntent.getAction())) {
            m15779b(context, "wlan");
        }
    }
}
