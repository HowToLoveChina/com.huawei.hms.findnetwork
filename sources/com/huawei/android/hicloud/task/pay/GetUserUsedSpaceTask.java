package com.huawei.android.hicloud.task.pay;

import com.huawei.hicloud.request.opengw.bean.QuotaSpace;
import fk.C9721b;
import java.util.concurrent.CountDownLatch;
import p341hj.AbstractC10222e;
import p429kk.C11058a;
import p514o9.C11839m;
import p652t9.EnumC12999a;
import to.C13049a;

/* loaded from: classes3.dex */
public class GetUserUsedSpaceTask extends AbstractC10222e {

    /* renamed from: b */
    public CountDownLatch f13065b;

    /* renamed from: c */
    public GetUserUsedSpaceTaskCallback f13066c;

    public interface GetUserUsedSpaceTaskCallback {
        /* renamed from: b */
        void mo18039b();

        /* renamed from: d */
        void mo18040d(long j10);
    }

    public GetUserUsedSpaceTask(CountDownLatch countDownLatch, GetUserUsedSpaceTaskCallback getUserUsedSpaceTaskCallback) {
        this.f13065b = countDownLatch;
        this.f13066c = getUserUsedSpaceTaskCallback;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        if (this.f13066c == null) {
            C11839m.m70687e("GetUserUsedSpaceTask", "callback is null.");
            return;
        }
        try {
            QuotaSpace quotaSpaceM78759x = new C13049a(EnumC12999a.CLOUD_PAY, C11058a.m66627b("06008"), 1500).m78759x();
            this.f13066c.mo18040d(quotaSpaceM78759x.getTotal() - quotaSpaceM78759x.getUsed());
            CountDownLatch countDownLatch = this.f13065b;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        } catch (C9721b e10) {
            C11839m.m70687e("GetUserUsedSpaceTask", "runTask err ： " + e10.getMessage());
            CountDownLatch countDownLatch2 = this.f13065b;
            if (countDownLatch2 != null) {
                countDownLatch2.countDown();
            }
            this.f13066c.mo18039b();
        }
    }
}
