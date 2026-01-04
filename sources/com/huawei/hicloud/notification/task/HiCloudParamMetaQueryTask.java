package com.huawei.hicloud.notification.task;

import com.huawei.hicloud.notification.manager.HiCloudParamMetaManager;
import fk.C9721b;
import java.util.concurrent.CountDownLatch;
import p015ak.C0209d;
import p399jk.AbstractC10896a;
import p581qk.AbstractC12367d;

/* loaded from: classes6.dex */
public class HiCloudParamMetaQueryTask extends AbstractC12367d {
    public static final String TAG = "HiCloudParamMetaQueryTask";
    private CountDownLatch mGlobalLatch;

    public HiCloudParamMetaQueryTask(CountDownLatch countDownLatch) {
        this.mGlobalLatch = countDownLatch;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        try {
            try {
                HiCloudParamMetaManager.getInstance().requestConfig();
            } catch (Exception unused) {
                AbstractC10896a.m65886e(TAG, "get  HiCloudParamMeta error");
            }
        } finally {
            C0209d.m1275l(this.mGlobalLatch);
        }
    }

    public HiCloudParamMetaQueryTask() {
        this.mGlobalLatch = null;
    }
}
