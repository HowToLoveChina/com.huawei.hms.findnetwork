package com.huawei.android.hicloud.sync.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import p015ak.C0206b0;
import p015ak.C0213f;
import p514o9.C11839m;
import p573qc.C12338d;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* loaded from: classes3.dex */
public class CalllogJobService extends JobService {

    /* renamed from: com.huawei.android.hicloud.sync.jobscheduler.CalllogJobService$b */
    public static class C2893b extends AbstractC12367d {
        public C2893b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (C12338d.m74195s().m74236m("autocallloglistkey")) {
                C12338d.m74195s().m74199C();
            }
        }
    }

    /* renamed from: a */
    public final void m17693a() {
        C11839m.m70688i("CalllogJobService", "scheduleRefresh");
        C12338d.m74195s().m74239n0();
        if (C0206b0.m1131c("funcfg_cloud_backup", C0213f.m1377a())) {
            return;
        }
        C12338d.m74195s().m74215S();
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        C11839m.m70688i("CalllogJobService", "calllog job start");
        C12515a.m75110o().m75172d(new C2893b());
        jobFinished(jobParameters, false);
        m17693a();
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
