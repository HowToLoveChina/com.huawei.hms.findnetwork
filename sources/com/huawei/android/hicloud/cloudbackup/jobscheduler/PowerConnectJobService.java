package com.huawei.android.hicloud.cloudbackup.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupConditionsUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker;
import com.huawei.android.hicloud.cloudbackup.service.ICBServiceProtocol;
import p514o9.C11839m;
import p618rm.C12590s0;
import p711vl.C13463c;
import p851zp.InterfaceC14358e;

/* loaded from: classes2.dex */
public class PowerConnectJobService extends JobService {
    private static final long DAY_MILLIS = 86400000;
    private static final String TAG = "PowerConnectJobService";

    private static void doGetBackupOptions(Context context) {
        long jM81025d = C13463c.m81022c(context).m81025d("lastPowerConnectTime");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - jM81025d >= 86400000) {
            if (C12590s0.m75837c1()) {
                C11839m.m70688i(TAG, "isJustBoot");
            } else {
                C13463c.m81022c(context).m81028g("lastPowerConnectTime", jCurrentTimeMillis);
                ICBServiceProtocol.getInstance().doGetBackupOptions();
            }
        }
    }

    public static void doPowerConnectJob(boolean z10, final Context context) {
        C11839m.m70688i(TAG, "doPowerConnectJob isAgreeTerms: " + z10);
        final ICycleChecker cycleChecker = CloudBackupConditionsUtil.getCycleChecker();
        final boolean zIsCycleSatisfy = cycleChecker.isCycleSatisfy();
        long jCheckDelayTime = CloudBackupConditionsUtil.checkDelayTime(CloudBackupConditionsUtil.getTargetBackupTime(zIsCycleSatisfy, cycleChecker, CloudBackupConditionsUtil.isRetryIntervalSatisfy(), CloudBackupConditionsUtil.isNextBackupTimeSatisfy()));
        CloudBackupJobManager.getInstance().unRegisterBackupScheduler();
        CloudBackupJobManager.getInstance().registerBackupScheduler(jCheckDelayTime, z10, 0, 0, new InterfaceC14358e() { // from class: com.huawei.android.hicloud.cloudbackup.jobscheduler.e
            @Override // p851zp.InterfaceC14358e
            public final void execute() {
                PowerConnectJobService.lambda$doPowerConnectJob$0(cycleChecker, zIsCycleSatisfy, context);
            }
        });
        doGetBackupOptions(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doPowerConnectJob$0(ICycleChecker iCycleChecker, boolean z10, Context context) {
        CloudBackupConditionsUtil.recordCycleCondition(iCycleChecker.getType() + z10, context);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        C11839m.m70688i(TAG, "PowerConnectJobService onStartJob");
        doPowerConnectJob((jobParameters == null || jobParameters.getExtras() == null) ? false : jobParameters.getExtras().getBoolean("isAgreeTerms"), getApplicationContext());
        jobFinished(jobParameters, false);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        C11839m.m70688i(TAG, "PowerConnectJobService onStopJob");
        return false;
    }
}
