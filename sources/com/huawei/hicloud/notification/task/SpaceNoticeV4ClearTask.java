package com.huawei.hicloud.notification.task;

import android.database.SQLException;
import com.huawei.hicloud.notification.manager.SpaceInsuffNoticeV4Manager;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* loaded from: classes6.dex */
public class SpaceNoticeV4ClearTask extends AbstractC12367d {
    private static final String TAG = "SpaceNoticeV4ClearTask";

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws SQLException {
        SpaceInsuffNoticeV4Manager.getInstance().clearAllConfig();
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.SYNC_CONFIG;
    }
}
