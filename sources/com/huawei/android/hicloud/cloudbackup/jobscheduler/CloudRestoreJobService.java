package com.huawei.android.hicloud.cloudbackup.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreRetry;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import fk.C9721b;
import p514o9.C11839m;
import p617rl.C12526j;
import p744wl.C13619c;
import tl.C13029h;
import tl.C13030i;

/* loaded from: classes2.dex */
public class CloudRestoreJobService extends JobService {
    private static final String TAG = "CloudRestoreJobService";

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        C13029h c13029hM78495f;
        C11839m.m70688i(TAG, "CloudRestoreJobService onStartJob");
        if (!CBAccess.hasRestoreTask()) {
            jobFinished(jobParameters, false);
            CloudBackupJobManager.getInstance().unRegisterRestoreScheduler();
            C11839m.m70688i(TAG, "CloudRestoreJobService !hasRestoreTask");
            return true;
        }
        try {
            c13029hM78495f = new C13030i().m78495f(3);
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "tags is null " + e10.getMessage());
            c13029hM78495f = null;
        }
        RestoreRetry restoreRetryM75325A0 = new C12526j().m75325A0();
        if (!RestoreUtil.checkIsRegisterAutoRestore(c13029hM78495f, restoreRetryM75325A0)) {
            C11839m.m70688i(TAG, "query tags is null or !checkIsRegister.");
            jobFinished(jobParameters, false);
            CloudBackupJobManager.getInstance().unRegisterRestoreScheduler();
            return false;
        }
        if (RestoreUtil.checkAutoRestoreCondition(restoreRetryM75325A0, getApplicationContext())) {
            if (C13619c.m81952h(c13029hM78495f.m78480t())) {
                C11839m.m70688i(TAG, "restore retry v3 process");
                CloudBackupService.getInstance().restoreRetryV3(false, true, true);
            } else {
                C11839m.m70688i(TAG, "restore retry v2 process");
                CloudBackupService.getInstance().restoreRetry(false, true, true);
            }
        }
        jobFinished(jobParameters, false);
        CloudBackupJobManager.getInstance().unRegisterRestoreScheduler();
        CloudBackupJobManager.getInstance().registerRestoreScheduler(Long.valueOf(RestoreUtil.getRestoreDelayTime()));
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        C11839m.m70688i(TAG, "CloudRestoreJobService onStopJob");
        return false;
    }
}
