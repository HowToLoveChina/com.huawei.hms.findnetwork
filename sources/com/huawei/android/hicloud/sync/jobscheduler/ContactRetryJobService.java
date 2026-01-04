package com.huawei.android.hicloud.sync.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import com.huawei.android.hicloud.sync.service.aidl.ICSServiceProtocol;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* loaded from: classes3.dex */
public class ContactRetryJobService extends JobService {

    /* renamed from: com.huawei.android.hicloud.sync.jobscheduler.ContactRetryJobService$b */
    public static class C2900b extends AbstractC12367d {
        public C2900b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            ICSServiceProtocol.getInstance().doSyncContact(SyncType.RETRY_SYNC);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        C11839m.m70688i("ContactRetryJobService", "contact retry job start");
        C12515a.m75110o().m75172d(new C2900b());
        jobFinished(jobParameters, false);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
