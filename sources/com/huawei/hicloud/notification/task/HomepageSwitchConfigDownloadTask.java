package com.huawei.hicloud.notification.task;

import com.huawei.hicloud.notification.manager.HomepageSwitchNoticeManager;
import fk.C9721b;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* loaded from: classes6.dex */
public class HomepageSwitchConfigDownloadTask extends AbstractC12367d {
    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        HomepageSwitchNoticeManager.getInstance().requestConfig();
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.SYNC_CONFIG;
    }
}
