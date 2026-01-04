package com.huawei.android.hicloud.task;

import android.app.job.JobParameters;
import android.app.job.JobService;
import p514o9.C11839m;
import p572qb.C12311h;

/* loaded from: classes3.dex */
public class DesktopDialogCheckJobService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        C11839m.m70688i("DesktopDialogCheckJobService", "onStartJob");
        C12311h.m74013c().m74024l();
        jobFinished(jobParameters, false);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        C11839m.m70688i("DesktopDialogCheckJobService", "onStopJob");
        return false;
    }
}
