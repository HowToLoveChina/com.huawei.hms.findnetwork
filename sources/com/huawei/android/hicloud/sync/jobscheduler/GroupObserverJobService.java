package com.huawei.android.hicloud.sync.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import p514o9.C11839m;
import p573qc.C12338d;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* loaded from: classes3.dex */
public class GroupObserverJobService extends JobService {

    /* renamed from: com.huawei.android.hicloud.sync.jobscheduler.GroupObserverJobService$b */
    public static class C2902b extends AbstractC12367d {
        public C2902b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C12338d.m74195s().m74203G();
        }
    }

    /* renamed from: a */
    public final void m17695a() {
        C11839m.m70688i("GroupObserverJobService", "scheduleRefresh");
        C12338d.m74195s().m74248s0();
        C12338d.m74195s().m74219W();
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        C11839m.m70688i("GroupObserverJobService", "group job start");
        C12515a.m75110o().m75172d(new C2902b());
        jobFinished(jobParameters, false);
        m17695a();
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
