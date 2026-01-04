package com.huawei.android.hicloud.task.pay;

import com.huawei.android.hicloud.task.pay.GetUserUsedSpaceTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p341hj.AbstractC10222e;
import p459lp.C11333k;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class ActionRouteTask extends AbstractC10222e implements GetUserUsedSpaceTask.GetUserUsedSpaceTaskCallback {

    /* renamed from: b */
    public ActionRouteTaskCallback f13064b;

    public interface ActionRouteTaskCallback {
        /* renamed from: a */
        void mo18041a();

        /* renamed from: b */
        void mo18042b();
    }

    public ActionRouteTask(ActionRouteTaskCallback actionRouteTaskCallback) {
        this.f13064b = actionRouteTaskCallback;
    }

    @Override // com.huawei.android.hicloud.logic.threadpool.TaskObject
    /* renamed from: a */
    public void mo16407a() {
        if (this.f13064b == null) {
            C11839m.m70687e("ActionRouteTask", "runTask, callback is null.");
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new GetUserUsedSpaceTask(countDownLatch, this).m63381g();
        try {
            if (countDownLatch.await(1500L, TimeUnit.MILLISECONDS)) {
                C11839m.m70688i("ActionRouteTask", "ActionRouteTask success");
            } else {
                C11839m.m70687e("ActionRouteTask", "ActionRouteTask request timeout");
                this.f13064b.mo18042b();
                this.f13064b = null;
            }
        } catch (InterruptedException e10) {
            C11839m.m70687e("ActionRouteTask", "ActionRouteTask doInBackground exception:" + e10.toString());
            this.f13064b.mo18042b();
            this.f13064b = null;
        }
    }

    @Override // com.huawei.android.hicloud.task.pay.GetUserUsedSpaceTask.GetUserUsedSpaceTaskCallback
    /* renamed from: b */
    public void mo18039b() {
        if (this.f13064b == null) {
            C11839m.m70687e("ActionRouteTask", "onFailed, callback is null.");
        } else {
            C11839m.m70687e("ActionRouteTask", "task failed.");
            this.f13064b.mo18042b();
        }
    }

    @Override // com.huawei.android.hicloud.task.pay.GetUserUsedSpaceTask.GetUserUsedSpaceTaskCallback
    /* renamed from: d */
    public void mo18040d(long j10) {
        if (this.f13064b == null) {
            C11839m.m70687e("ActionRouteTask", "onSuccess, callback is null.");
            return;
        }
        boolean zM68090e = C11333k.m68086b().m68090e(j10);
        C11839m.m70688i("ActionRouteTask", "usedSpace = " + j10 + ", isFull = " + zM68090e);
        if (zM68090e) {
            this.f13064b.mo18041a();
        } else {
            this.f13064b.mo18042b();
        }
    }
}
