package com.huawei.android.hicloud.commonlib.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Handler;
import android.os.Message;
import p448l9.C11262a;
import p514o9.C11839m;

/* loaded from: classes3.dex */
public class HiCloudJobService extends JobService {

    /* renamed from: a */
    public Handler f12036a = new Handler(new C2773a());

    /* renamed from: com.huawei.android.hicloud.commonlib.jobscheduler.HiCloudJobService$a */
    public class C2773a implements Handler.Callback {
        public C2773a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5 || i10 == 6) {
                Object obj = message.obj;
                if (obj instanceof JobParameters) {
                    HiCloudJobService.this.jobFinished((JobParameters) obj, false);
                }
            }
            return false;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C11839m.m70686d("HiCloudJobService", "Service created");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C11839m.m70686d("HiCloudJobService", "Service destroyed");
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        int jobId = jobParameters.getJobId();
        C11839m.m70689w("HiCloudJobService", "onStartJob job id is " + jobId);
        if (jobId == 3 || jobId == 4) {
            for (CommonJobCallBack commonJobCallBack : new C11262a().m67601d()) {
                if (commonJobCallBack.mo15902a(getApplicationContext(), this.f12036a, jobParameters)) {
                    C11262a.m67598i(commonJobCallBack);
                }
            }
            return true;
        }
        C11839m.m70689w("HiCloudJobService", "deprecation JobService" + jobId + ", jobFinished");
        jobFinished(jobParameters, false);
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        C11839m.m70689w("HiCloudJobService", "onStopJob" + jobParameters.getJobId());
        return false;
    }
}
