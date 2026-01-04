package com.huawei.android.hicloud.cloudbackup.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.android.hicloud.cloudbackup.service.ICBServiceProtocol;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.ExtraNoticeConfigManager;
import com.huawei.hicloud.notification.p106db.bean.ExtraNotificationBean;
import java.util.Iterator;
import java.util.List;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p711vl.C13464d;

/* loaded from: classes2.dex */
public class CloudBackupNotifyJobService extends JobService {
    private static final long DAY_MILLIS = 86400000;
    private static final String TAG = "CloudBackupNotifyJobService";
    private long millis = 0;
    private long lastSuccessTime = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public void doNotifyCheck(JobParameters jobParameters) {
        C13464d c13464dM81030f = C13464d.m81030f(getApplicationContext());
        boolean zM81033c = c13464dM81030f.m81033c("backup_key");
        C11839m.m70688i(TAG, "doNotifyCheck isOpen: " + zM81033c);
        if (!zM81033c) {
            jobFinished(jobParameters, false);
            return;
        }
        if (!TextUtils.equals(c13464dM81030f.m81039j("backup_end_code", ""), "001_1007")) {
            List<ExtraNotificationBean> extraNotificationBean = ExtraNoticeConfigManager.getInstance().getExtraNotificationBean(NotifyConstants.BACKUP_CYCLE, UserSpaceUtil.getUserTagsUseCache("BackupNotifyJobService"));
            long jM81037h = c13464dM81030f.m81037h("notifycycle");
            if (extraNotificationBean != null && extraNotificationBean.size() != 0) {
                Iterator<ExtraNotificationBean> it = extraNotificationBean.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    long unBackupDays = it.next().getUnBackupDays();
                    if (unBackupDays == 0) {
                        unBackupDays = jM81037h;
                    }
                    if (checkNotifyCondition(getApplicationContext(), unBackupDays)) {
                        ICBServiceProtocol.getInstance().doNewBackupNotify(this.millis, this.lastSuccessTime);
                        break;
                    }
                }
            } else if (checkNotifyCondition(getApplicationContext(), jM81037h)) {
                ICBServiceProtocol.getInstance().doNewBackupNotify(this.millis, this.lastSuccessTime);
            }
        } else {
            C11839m.m70688i(TAG, "doNotifyCheck internal nosapce");
        }
        jobFinished(jobParameters, false);
        CloudBackupJobManager.getInstance().unRegisterNotifyScheduler();
        CloudBackupJobManager.getInstance().registerNotifyScheduler(true);
    }

    public boolean checkNotifyCondition(Context context, long j10) {
        C13464d c13464dM81030f = C13464d.m81030f(context);
        long jM81037h = c13464dM81030f.m81037h("lastsuccesstime");
        long jM81037h2 = c13464dM81030f.m81037h("lastbackuptime");
        long jM81037h3 = c13464dM81030f.m81037h("lastnotifytime");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jM81037h == 0) {
            this.millis = jCurrentTimeMillis - jM81037h2;
            this.lastSuccessTime = jM81037h2;
            C11839m.m70688i(TAG, "has no backup record, day = " + ((this.millis - 1) / 86400000));
        } else {
            this.millis = jCurrentTimeMillis - jM81037h;
            this.lastSuccessTime = jM81037h;
            C11839m.m70688i(TAG, "has success backup record, day = " + ((this.millis - 1) / 86400000));
        }
        long j11 = j10 * 86400000;
        boolean z10 = this.millis > j11 && jCurrentTimeMillis - jM81037h3 > j11;
        C11839m.m70688i(TAG, "notify flag = " + z10);
        return z10;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters jobParameters) {
        C11839m.m70688i(TAG, "CloudBackupNotifyJobService onStartJob");
        C12515a.m75110o().m75172d(new AbstractC12367d() { // from class: com.huawei.android.hicloud.cloudbackup.jobscheduler.CloudBackupNotifyJobService.1
            @Override // p616rk.AbstractRunnableC12516b
            public void call() {
                CloudBackupNotifyJobService.this.doNotifyCheck(jobParameters);
            }

            @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
            public void release() {
                super.release();
            }
        });
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        C11839m.m70688i(TAG, "CloudBackupNotifyJobService onStopJob");
        return false;
    }
}
