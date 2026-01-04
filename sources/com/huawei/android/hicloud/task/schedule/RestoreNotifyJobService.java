package com.huawei.android.hicloud.task.schedule;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import com.huawei.android.hicloud.task.simple.C3052k2;
import p514o9.C11839m;
import p616rk.C12515a;

/* loaded from: classes3.dex */
public class RestoreNotifyJobService extends JobService {

    /* renamed from: a */
    public Context f13068a;

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        C11839m.m70688i("RestoreNotifyJobService", "onStartJob");
        Context applicationContext = getApplicationContext();
        this.f13068a = applicationContext;
        C12515a.m75110o().m75175e(new C3052k2(applicationContext, 4), false);
        jobFinished(jobParameters, false);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
