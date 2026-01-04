package com.huawei.android.hicloud.sync.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import p015ak.C0206b0;
import p015ak.C0213f;
import p015ak.C0241z;
import p514o9.C11839m;
import p573qc.C12338d;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p836z8.C14158g;

/* loaded from: classes3.dex */
public class SMSJobService extends JobService {

    /* renamed from: com.huawei.android.hicloud.sync.jobscheduler.SMSJobService$b */
    public static class C2914b extends AbstractC12367d {
        public C2914b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            if (C12338d.m74195s().m74236m("autosmslistkey")) {
                C12338d.m74195s().m74204H();
            }
        }
    }

    /* renamed from: a */
    public final void m17698a() {
        C11839m.m70688i("SMSJobService", "scheduleRefresh");
        C12338d.m74195s().m74262z0();
        if (C0206b0.m1131c("funcfg_cloud_backup", C0213f.m1377a())) {
            return;
        }
        C12338d.m74195s().m74227e0();
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        long jM1688f = C0241z.m1688f(C14158g.m84964a("autosmslistkey_time", C0213f.m1377a()));
        long jCurrentTimeMillis = System.currentTimeMillis() - jM1688f;
        C11839m.m70688i("SMSJobService", "sms job lastBackTime: " + jM1688f + ",intervalTime: " + jCurrentTimeMillis);
        if (jCurrentTimeMillis > 2100000) {
            C11839m.m70688i("SMSJobService", "sms job start");
            C12515a.m75110o().m75172d(new C2914b());
        } else if (!C12338d.m74195s().m74196A(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH)) {
            C12338d.m74195s().m74225c0();
        }
        jobFinished(jobParameters, false);
        m17698a();
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
