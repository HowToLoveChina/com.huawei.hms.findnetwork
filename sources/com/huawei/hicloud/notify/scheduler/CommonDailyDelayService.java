package com.huawei.hicloud.notify.scheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import com.huawei.hicloud.notification.log.NotifyLogger;
import mn.C11500d;
import p015ak.C0213f;

/* loaded from: classes6.dex */
public class CommonDailyDelayService extends JobService {
    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        NotifyLogger.m29913d("CommonDailyDelayService", "CommonDailyDelayService created");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        NotifyLogger.m29913d("CommonDailyDelayService", "CommonDailyDelayService destroyed");
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        int jobId = jobParameters.getJobId();
        jobFinished(jobParameters, false);
        NotifyLogger.m29915i("CommonDailyDelayService", "CommonDailyDelayService onStartJob job id is " + jobId);
        if (jobId != 90002) {
            C11500d.m68648g().m68650b(jobParameters);
            return true;
        }
        NotifyLogger.m29915i("CommonDailyDelayService", "JOB_ID_DELAY");
        C11500d.m68648g().m68651c(jobParameters);
        C11500d.m68648g().m68660m(C0213f.m1377a());
        C11500d.m68648g().m68650b(jobParameters);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        NotifyLogger.m29916w("CommonDailyDelayService", "CommonDailyDelayService onStopJob " + jobParameters.getJobId());
        if (Build.VERSION.SDK_INT < 31) {
            return false;
        }
        NotifyLogger.m29916w("CommonDailyDelayService", "CommonDailyJobService onStopJob " + jobParameters.getJobId() + ", stopReason = " + jobParameters.getStopReason());
        return false;
    }
}
