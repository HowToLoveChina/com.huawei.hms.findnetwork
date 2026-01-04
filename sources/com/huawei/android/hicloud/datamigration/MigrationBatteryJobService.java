package com.huawei.android.hicloud.datamigration;

import android.app.job.JobParameters;
import android.app.job.JobService;
import gp.C10028c;
import p011aa.C0085e;
import p514o9.C11839m;
import p616rk.C12515a;

/* loaded from: classes3.dex */
public class MigrationBatteryJobService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        C11839m.m70688i("MigrationBatteryJobService", "MigrationBatteryJobService onStartJob");
        if (C10028c.m62182c0().m62219H() == 4) {
            C11839m.m70688i("MigrationBatteryJobService", "MigrationBatteryJobService retryMigrationTask");
            C12515a.m75110o().m75172d(new C0085e());
        }
        jobFinished(jobParameters, false);
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        C11839m.m70688i("MigrationBatteryJobService", "MigrationBatteryJobService onStartJob");
        return false;
    }
}
