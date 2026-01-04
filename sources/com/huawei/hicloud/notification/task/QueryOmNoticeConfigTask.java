package com.huawei.hicloud.notification.task;

import android.content.Intent;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.NotificationConfigManager;
import java.util.concurrent.CountDownLatch;
import p015ak.C0213f;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p664u0.C13108a;

/* loaded from: classes6.dex */
public class QueryOmNoticeConfigTask extends AbstractC12367d {
    private static final String TAG = "QueryOmNoticeConfigTask";
    private CountDownLatch mGlobalLatch;

    public QueryOmNoticeConfigTask() {
        this.mGlobalLatch = null;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        NotifyLogger.m29915i(TAG, TAG);
        new NotificationConfigManager().queryConfigVersion();
        C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent(NotifyConstants.GET_CONFIG_COMPLETE_ACTION));
        CountDownLatch countDownLatch = this.mGlobalLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.SYNC_CONFIG;
    }

    public QueryOmNoticeConfigTask(CountDownLatch countDownLatch) {
        this.mGlobalLatch = countDownLatch;
    }
}
