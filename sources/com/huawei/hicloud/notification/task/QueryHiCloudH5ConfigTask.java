package com.huawei.hicloud.notification.task;

import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import fk.C9721b;
import p581qk.AbstractC12367d;

/* loaded from: classes6.dex */
public class QueryHiCloudH5ConfigTask extends AbstractC12367d {
    private static final String TAG = "QueryHiCloudH5ConfigTask";

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        HicloudH5ConfigManager.getInstance().requestVersion();
    }
}
