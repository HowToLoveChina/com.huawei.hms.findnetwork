package com.huawei.hicloud.notification.task;

import android.content.Context;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.util.TimerCheckCallback;
import java.util.TimerTask;
import p015ak.C0209d;
import p015ak.C0213f;

/* loaded from: classes6.dex */
public class ActiveRecommendTimerTask extends TimerTask {
    private static final String TAG = "ActiveRecommendTimerTask";
    private TimerCheckCallback callback;

    public ActiveRecommendTimerTask(TimerCheckCallback timerCheckCallback) {
        this.callback = timerCheckCallback;
    }

    private boolean isSatisfy() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a != null) {
            return C0209d.m1265i1(contextM1377a) && C0209d.m1194N1(contextM1377a);
        }
        NotifyLogger.m29914e(TAG, "isSatisfy context null");
        return false;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.callback == null) {
            NotifyLogger.m29914e(TAG, "callback null");
        } else if (isSatisfy()) {
            this.callback.checkSuccess();
        } else {
            this.callback.checkFailed();
        }
    }
}
