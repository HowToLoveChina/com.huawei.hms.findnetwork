package com.huawei.hicloud.notification.task;

import com.huawei.hicloud.notification.manager.SpaceNoticeV3Manager;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* loaded from: classes6.dex */
public class SpaceNoticeV3ConfigDownloadTask extends AbstractC12367d {
    private static final String TAG = "SpaceNoticeV3ConfigDownloadTask";

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        SpaceNoticeV3Manager.getInstance().requestConfig();
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.SYNC_CONFIG;
    }
}
