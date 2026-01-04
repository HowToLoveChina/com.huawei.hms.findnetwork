package com.huawei.android.hicloud.task.schedule;

import android.content.Context;
import com.huawei.android.hicloud.p088ui.notification.BackupNotificationManager;
import com.huawei.hms.network.embedded.C5976k;
import p514o9.C11839m;
import p581qk.AbstractC12369f;

/* loaded from: classes3.dex */
public class BackupNotifyCancelTimer extends AbstractC12369f {

    /* renamed from: a */
    public Context f13067a;

    public BackupNotifyCancelTimer(Context context) {
        super(C5976k.b.f27175m, C5976k.b.f27175m);
        this.f13067a = context;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70688i("BackupNotifyCancelTimer", "cancel backup notification!");
        Context context = this.f13067a;
        if (context == null) {
            C11839m.m70687e("BackupNotifyCancelTimer", "call context is null");
        } else {
            new BackupNotificationManager(context).cancelNotification(24);
            super.cancel();
        }
    }
}
