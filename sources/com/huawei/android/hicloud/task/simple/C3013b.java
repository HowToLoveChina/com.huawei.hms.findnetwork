package com.huawei.android.hicloud.task.simple;

import com.huawei.hicloud.notification.manager.NotifyTimerSpManager;
import com.huawei.hicloud.notification.util.TimerCheckCallback;
import java.util.TimerTask;
import p514o9.C11839m;

/* renamed from: com.huawei.android.hicloud.task.simple.b */
/* loaded from: classes3.dex */
public class C3013b extends TimerTask {

    /* renamed from: a */
    public TimerCheckCallback f13147a;

    public C3013b(TimerCheckCallback timerCheckCallback) {
        this.f13147a = timerCheckCallback;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        NotifyTimerSpManager.getInstance().recordAutoBackupNotifyTimerEnd();
        TimerCheckCallback timerCheckCallback = this.f13147a;
        if (timerCheckCallback == null) {
            C11839m.m70687e("AutoBackupNotifyTimerTask", "callback null");
        } else {
            timerCheckCallback.checkSuccess();
        }
    }
}
