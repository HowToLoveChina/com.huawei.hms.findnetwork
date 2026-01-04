package com.huawei.android.hicloud.sync.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import p015ak.C0206b0;
import p015ak.C0213f;
import p514o9.C11839m;
import p573qc.C12338d;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* loaded from: classes3.dex */
public class PhoneManagerJobService extends JobService {

    /* renamed from: com.huawei.android.hicloud.sync.jobscheduler.PhoneManagerJobService$b */
    public static class C2906b extends AbstractC12367d {
        public C2906b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (C12338d.m74195s().m74236m("autophonemanagerkey")) {
                C12338d.m74195s().m74231i0(SyncType.AUTO_SYNC_PHONE_MANAGER);
            }
        }
    }

    /* renamed from: a */
    public final void m17696a() {
        C11839m.m70688i("PhoneManagerJobService", "scheduleRefresh");
        C12338d.m74195s().m74252u0();
        if (C0206b0.m1131c("funcfg_cloud_backup", C0213f.m1377a())) {
            return;
        }
        C12338d.m74195s().m74221Y();
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        C11839m.m70688i("PhoneManagerJobService", "phone manager job start");
        C12515a.m75110o().m75172d(new C2906b());
        jobFinished(jobParameters, false);
        m17696a();
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
