package com.huawei.android.hicloud.sync.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import p488n8.C11653a;
import p514o9.C11839m;
import p573qc.C12338d;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* loaded from: classes3.dex */
public class CalllogRetryJobService extends JobService {

    /* renamed from: com.huawei.android.hicloud.sync.jobscheduler.CalllogRetryJobService$b */
    public static class C2895b extends AbstractC12367d {
        public C2895b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (C12338d.m74195s().m74236m("autocallloglistkey")) {
                C11653a.m69582l().m69587c();
            }
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        C11839m.m70688i("CalllogRetryJobService", "calllog Retry job start");
        C12515a.m75110o().m75172d(new C2895b());
        jobFinished(jobParameters, false);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
