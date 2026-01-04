package com.huawei.android.hicloud.task.simple;

import ca.C1399b;
import java.util.concurrent.CountDownLatch;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* renamed from: com.huawei.android.hicloud.task.simple.f2 */
/* loaded from: classes3.dex */
public class C3032f2 extends AbstractC12367d {

    /* renamed from: a */
    public CountDownLatch f13269a = null;

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Throwable {
        C11839m.m70688i("QueryHiCloudActivesConfigTask", "QueryHiCloudActivesConfigTask start");
        C1399b.m8034o().m8049p();
        CountDownLatch countDownLatch = this.f13269a;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.HICLOUD_ACTIVES;
    }
}
