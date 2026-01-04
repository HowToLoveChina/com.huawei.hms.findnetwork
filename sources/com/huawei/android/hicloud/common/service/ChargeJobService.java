package com.huawei.android.hicloud.common.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import p514o9.C11839m;
import p572qb.C12305e;

/* loaded from: classes3.dex */
public class ChargeJobService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        C11839m.m70688i("ChargeJobService", "ChargeJobService  onStartJob");
        C12305e.m73982f().m73986e();
        C12305e.m73982f().m73991k();
        jobFinished(jobParameters, false);
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        C11839m.m70688i("ChargeJobService", "ChargeJobService  onStopJob");
        return false;
    }
}
