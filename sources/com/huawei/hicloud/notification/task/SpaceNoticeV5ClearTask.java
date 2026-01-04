package com.huawei.hicloud.notification.task;

import com.huawei.hicloud.notification.manager.BackupSpaceInsuffNoticeV5Manager;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* loaded from: classes6.dex */
public class SpaceNoticeV5ClearTask extends AbstractC12367d {
    private static final String TAG = "SpaceNoticeV4ClearTask";

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        BackupSpaceInsuffNoticeV5Manager.getInstance().clearAllConfig();
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.SYNC_CONFIG;
    }
}
