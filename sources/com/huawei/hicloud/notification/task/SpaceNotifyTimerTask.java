package com.huawei.hicloud.notification.task;

import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.NotifyTimerSpManager;
import com.huawei.hicloud.notification.util.TimerCheckCallback;
import java.util.TimerTask;

/* loaded from: classes6.dex */
public class SpaceNotifyTimerTask extends TimerTask {
    private static final String TAG = "SpaceNotifyTimerTask";
    private TimerCheckCallback callback;

    public SpaceNotifyTimerTask(TimerCheckCallback timerCheckCallback) {
        this.callback = timerCheckCallback;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        NotifyTimerSpManager.getInstance().recordSpaceNotifyTimerEnd();
        TimerCheckCallback timerCheckCallback = this.callback;
        if (timerCheckCallback == null) {
            NotifyLogger.m29914e(TAG, "callback null");
        } else {
            timerCheckCallback.checkSuccess();
        }
    }
}
