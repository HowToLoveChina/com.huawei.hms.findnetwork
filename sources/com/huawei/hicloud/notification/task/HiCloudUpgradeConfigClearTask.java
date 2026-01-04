package com.huawei.hicloud.notification.task;

import com.huawei.hicloud.notification.manager.HiCloudForceUpgradeConfigManager;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* loaded from: classes6.dex */
public class HiCloudUpgradeConfigClearTask extends AbstractC12367d {
    private static final String TAG = "HiCloudUpgradeConfigClearTask";

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        HiCloudForceUpgradeConfigManager.getInstance().clearAllConfig();
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.SYNC_CONFIG;
    }
}
