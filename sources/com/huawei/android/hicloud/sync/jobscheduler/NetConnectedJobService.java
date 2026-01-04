package com.huawei.android.hicloud.sync.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;
import p573qc.C12338d;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* loaded from: classes3.dex */
public class NetConnectedJobService extends JobService {

    /* renamed from: com.huawei.android.hicloud.sync.jobscheduler.NetConnectedJobService$b */
    public static class C2904b extends AbstractC12367d {
        public C2904b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C12338d.m74195s().m74201E();
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        boolean zM1333z1 = C0209d.m1333z1(C0213f.m1377a());
        C11839m.m70688i("NetConnectedJobService", "networkConnect = " + zM1333z1);
        if (zM1333z1) {
            C12515a.m75110o().m75172d(new C2904b());
        }
        jobFinished(jobParameters, false);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
