package com.huawei.hicloud.notification.task;

import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.UserActiveRecommendManager;
import com.huawei.hicloud.notification.util.TimerCheckCallback;
import java.util.Timer;

/* loaded from: classes6.dex */
public class ActiveRecommendTimer implements TimerCheckCallback {
    private static final int MAX_CHECK_TIMES = 3;
    private static final long PERIOD = 300000;
    private static final String TAG = "ActiveRecommendTimer";
    private int currentRetry = 0;
    private Timer timer = new Timer();

    @Override // com.huawei.hicloud.notification.util.TimerCheckCallback
    public void checkFailed() {
        NotifyLogger.m29915i(TAG, "check failed");
        if (this.currentRetry < 3) {
            execute();
        } else {
            this.timer.cancel();
        }
    }

    @Override // com.huawei.hicloud.notification.util.TimerCheckCallback
    public void checkSuccess() {
        NotifyLogger.m29915i(TAG, "check success");
        UserActiveRecommendManager.getInstance().showDialog();
        this.timer.cancel();
    }

    public void execute() {
        this.currentRetry++;
        NotifyLogger.m29915i(TAG, "timer execute cuurentRetry=" + this.currentRetry);
        this.timer.schedule(new ActiveRecommendTimerTask(this), 300000L);
    }
}
