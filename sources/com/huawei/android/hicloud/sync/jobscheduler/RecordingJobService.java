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
import p836z8.C14158g;

/* loaded from: classes3.dex */
public class RecordingJobService extends JobService {

    /* renamed from: com.huawei.android.hicloud.sync.jobscheduler.RecordingJobService$b */
    public static class C2910b extends AbstractC12367d {
        public C2910b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (C12338d.m74195s().m74236m("autorecordingkey")) {
                C14158g.m84966c(0L, C0213f.m1377a());
                C12338d.m74195s().m74231i0(SyncType.AUTO_SYNC_RECORD);
            }
        }
    }

    /* renamed from: a */
    public final void m17697a() {
        C11839m.m70688i("RecordingJobService", "scheduleRefresh");
        C12338d.m74195s().m74256w0();
        if (C0206b0.m1131c("funcfg_cloud_backup", C0213f.m1377a())) {
            return;
        }
        C12338d.m74195s().m74223a0();
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        C11839m.m70688i("RecordingJobService", "recording job start");
        C12515a.m75110o().m75172d(new C2910b());
        jobFinished(jobParameters, false);
        m17697a();
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
