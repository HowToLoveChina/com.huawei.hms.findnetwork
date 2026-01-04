package com.huawei.hicloud.notification.task;

import com.huawei.feedback.log.BaseLogger;
import com.huawei.hicloud.notification.manager.HiCloudForceUpgradeConfigManager;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* loaded from: classes6.dex */
public class HiCloudUpgradeConfigDownloadTask extends AbstractC12367d {
    private static final String TAG = "HiCloudUpgradeConfigDownloadTask";

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        BaseLogger.m28729d(TAG, "call: HiCloudUpgradeConfigManager.getInstance().requestConfig()");
        HiCloudForceUpgradeConfigManager.getInstance().requestConfig();
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.SYNC_CONFIG;
    }
}
