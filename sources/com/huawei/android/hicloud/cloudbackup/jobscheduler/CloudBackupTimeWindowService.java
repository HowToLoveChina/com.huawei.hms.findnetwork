package com.huawei.android.hicloud.cloudbackup.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.BackupTimeWindowBean;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupConditionsUtil;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.openalliance.p169ad.constant.ConfigMapDefValues;
import fk.C9721b;
import hm.C10321z;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p015ak.C0213f;
import p015ak.C0226l0;
import p015ak.C0241z;
import p429kk.C11058a;
import p514o9.C11837k;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p711vl.C13464d;
import p814yl.C13998b0;

/* loaded from: classes2.dex */
public class CloudBackupTimeWindowService extends JobService {
    private static final String PRE_CONTENT_URI = "content://com.huawei.hidisk.cloudbackup.backupstate/";
    private static final String TAG = "CloudBackupTimeWindowService";
    private JobParameters jobParameters;
    private int periodRandomFactor;
    private int timingInterval;
    private TimeWindowObserverReceiver mReceiver = null;
    private final Context mContext = C0213f.m1377a();
    private long nextDelayTime = 0;
    private long nextDeadLineTime = 0;

    public class TimeWindowCollectTask extends AbstractC12367d {
        public TimeWindowCollectTask() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws InterruptedException, C9721b {
            C11839m.m70688i(CloudBackupTimeWindowService.TAG, "TimeWindowCollectTask start");
            CloudBackupTimeWindowService.this.saveJobInfo();
            while (getFuture() != null && !getFuture().isCancelled()) {
                CloudBackupTimeWindowService.this.timeWindowCollectJob();
                C0226l0.m1581a(CloudBackupTimeWindowService.this.timingInterval * 60000);
            }
        }
    }

    public class TimeWindowObserverReceiver extends BroadcastReceiver {
        public TimeWindowObserverReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            if (context == null) {
                C11839m.m70689w(CloudBackupTimeWindowService.TAG, "TimeWindowObserverReceiver error, context is null.");
                return;
            }
            String action = hiCloudSafeIntent.getAction();
            action.hashCode();
            switch (action) {
                case "android.intent.action.SCREEN_OFF":
                    C11839m.m70688i(CloudBackupTimeWindowService.TAG, "screen off");
                    if (CloudBackupTimeWindowService.this.checkRecordTimeWindowStart() && CloudBackupTimeWindowService.this.checkAutoBackupCondition()) {
                        CloudBackupTimeWindowService.this.queryAboutTimes(true, false);
                        return;
                    }
                    return;
                case "android.intent.action.ACTION_POWER_DISCONNECTED":
                    break;
                case "android.net.wifi.WIFI_STATE_CHANGED":
                    int intExtra = hiCloudSafeIntent.getIntExtra("wifi_state", 1);
                    if (intExtra == 1) {
                        C11839m.m70688i(CloudBackupTimeWindowService.TAG, "wifi close");
                        if (CloudBackupTimeWindowService.this.checkRecordTimeWindowEnd()) {
                            CloudBackupTimeWindowService.this.queryAboutTimes(false, false);
                            return;
                        }
                        return;
                    }
                    if (intExtra == 3) {
                        C11839m.m70688i(CloudBackupTimeWindowService.TAG, "wifi open");
                        if (CloudBackupTimeWindowService.this.checkRecordTimeWindowStart() && CloudBackupTimeWindowService.this.checkAutoBackupCondition()) {
                            CloudBackupTimeWindowService.this.queryAboutTimes(true, false);
                            return;
                        }
                        return;
                    }
                    return;
                case "android.intent.action.SCREEN_ON":
                    C11839m.m70688i(CloudBackupTimeWindowService.TAG, "screen on");
                    break;
                default:
                    C11839m.m70689w(CloudBackupTimeWindowService.TAG, "unknown action");
                    return;
            }
            C11839m.m70688i(CloudBackupTimeWindowService.TAG, "power disconnected");
            if (CloudBackupTimeWindowService.this.checkRecordTimeWindowEnd()) {
                CloudBackupTimeWindowService.this.queryAboutTimes(false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkAutoBackupCondition() {
        boolean z10 = !CloudBackupConditionsUtil.isScreenOn();
        boolean zIsWiFiActive = CloudBackupConditionsUtil.isWiFiActive();
        boolean zIsCharging = CloudBackupConditionsUtil.getChargeAttr().isCharging();
        boolean zIsSmartCharging = CloudBackupConditionsUtil.isSmartCharging();
        boolean z11 = (zIsCharging || zIsSmartCharging) && zIsWiFiActive && z10;
        C11839m.m70688i(TAG, "checkAutoBackupCondition isScreenOff: " + z10 + ", isWiFiActive: " + zIsWiFiActive + ", isCharging: " + zIsCharging + ", isSmartCharging: " + zIsSmartCharging);
        return z11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkRecordTimeWindowEnd() {
        String strM81039j = C13464d.m81030f(this.mContext).m81039j(CloudBackupConstant.TimeWindowConstant.KEY_TIME_WINDOW_RESULT, "");
        return !TextUtils.isEmpty(strM81039j) && strM81039j.endsWith(",");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkRecordTimeWindowStart() {
        String strM81039j = C13464d.m81030f(this.mContext).m81039j(CloudBackupConstant.TimeWindowConstant.KEY_TIME_WINDOW_RESULT, "");
        return TextUtils.isEmpty(strM81039j) || strM81039j.endsWith("|");
    }

    private int getTodayMinutes(long j10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        return (calendar.get(11) * 60) + calendar.get(12);
    }

    private void jobFinished() {
        JobParameters jobParameters = this.jobParameters;
        if (jobParameters == null) {
            C11839m.m70687e(TAG, "jobParameters is null");
        } else {
            jobFinished(jobParameters, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$sortTimeWindow$0(String str) {
        return str.contains(",") && !str.endsWith(",");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$sortTimeWindow$1(String str, String str2) {
        return Integer.parseInt(str.split(",")[0]) <= Integer.parseInt(str2.split(",")[0]) ? -1 : 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processTimeWindowResult() {
        C13464d c13464dM81030f = C13464d.m81030f(this.mContext);
        reportTimeWindow(sortTimeWindow(c13464dM81030f.m81039j(CloudBackupConstant.TimeWindowConstant.KEY_TIME_WINDOW_RESULT, "")));
        c13464dM81030f.m81049t(CloudBackupConstant.TimeWindowConstant.KEY_TIME_WINDOW_RESULT, "");
        c13464dM81030f.m81048s(CloudBackupConstant.TimeWindowConstant.KEY_TASK_START_TIME, 0L);
        c13464dM81030f.m81045p(CloudBackupConstant.TimeWindowConstant.KEY_IS_NEW_PERIOD, true);
        jobFinished();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queryAboutTimes(final boolean z10, final boolean z11) {
        C12515a.m75110o().m75172d(new AbstractC12367d() { // from class: com.huawei.android.hicloud.cloudbackup.jobscheduler.CloudBackupTimeWindowService.2
            @Override // p616rk.AbstractRunnableC12516b
            public void call() {
                long jLongValue;
                C11839m.m70688i(CloudBackupTimeWindowService.TAG, "request server time");
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    try {
                        jLongValue = new C13998b0().m84137z("serverTime", C11058a.m66627b("02101")).getServerTime().longValue();
                    } catch (C9721b e10) {
                        C11839m.m70687e(CloudBackupTimeWindowService.TAG, "request server time error: " + e10.getMessage());
                        if (z10) {
                            CloudBackupTimeWindowService.this.recordTimeWindowStart(jCurrentTimeMillis);
                            return;
                        } else {
                            CloudBackupTimeWindowService.this.recordTimeWindowEnd(jCurrentTimeMillis);
                            if (!z11) {
                                return;
                            }
                        }
                    }
                    if (z10) {
                        CloudBackupTimeWindowService.this.recordTimeWindowStart(jLongValue);
                        return;
                    }
                    CloudBackupTimeWindowService.this.recordTimeWindowEnd(jLongValue);
                    if (!z11) {
                        return;
                    }
                    CloudBackupTimeWindowService.this.processTimeWindowResult();
                } catch (Throwable th2) {
                    if (z10) {
                        CloudBackupTimeWindowService.this.recordTimeWindowStart(jCurrentTimeMillis);
                    } else {
                        CloudBackupTimeWindowService.this.recordTimeWindowEnd(jCurrentTimeMillis);
                        if (z11) {
                            CloudBackupTimeWindowService.this.processTimeWindowResult();
                        }
                    }
                    throw th2;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordTimeWindowEnd(long j10) {
        String strSubstring;
        C13464d c13464dM81030f = C13464d.m81030f(this.mContext);
        String strM81039j = c13464dM81030f.m81039j(CloudBackupConstant.TimeWindowConstant.KEY_TIME_WINDOW_RESULT, "");
        if (!TextUtils.isEmpty(strM81039j) && strM81039j.endsWith(",")) {
            long jM1688f = C0241z.m1688f(strM81039j.substring(strM81039j.lastIndexOf("|") + 1, strM81039j.lastIndexOf(",")));
            int todayMinutes = getTodayMinutes(j10);
            long j11 = todayMinutes;
            if (j11 < jM1688f) {
                C11839m.m70688i(TAG, "recordTimeWindowEnd split time window");
                String str = strM81039j + ConfigMapDefValues.DEFAULT_APPLIST_INTERVAL + "|";
                if (todayMinutes != 0) {
                    strSubstring = ("0," + todayMinutes + "|") + str;
                } else {
                    strM81039j = str;
                    c13464dM81030f.m81049t(CloudBackupConstant.TimeWindowConstant.KEY_TIME_WINDOW_RESULT, strM81039j);
                }
            } else if (j11 == jM1688f) {
                C11839m.m70688i(TAG, "recordTimeWindowEnd remove this time window");
                strSubstring = strM81039j.substring(0, strM81039j.lastIndexOf("|") + 1);
            } else {
                strSubstring = strM81039j + todayMinutes + "|";
            }
            strM81039j = strSubstring;
            c13464dM81030f.m81049t(CloudBackupConstant.TimeWindowConstant.KEY_TIME_WINDOW_RESULT, strM81039j);
        }
        C11839m.m70688i(TAG, "recordTimeWindowEnd result: " + strM81039j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordTimeWindowStart(long j10) {
        C13464d c13464dM81030f = C13464d.m81030f(this.mContext);
        String strM81039j = c13464dM81030f.m81039j(CloudBackupConstant.TimeWindowConstant.KEY_TIME_WINDOW_RESULT, "");
        int todayMinutes = getTodayMinutes(j10);
        if (TextUtils.isEmpty(strM81039j) || strM81039j.endsWith("|")) {
            strM81039j = strM81039j + todayMinutes + ",";
            c13464dM81030f.m81049t(CloudBackupConstant.TimeWindowConstant.KEY_TIME_WINDOW_RESULT, strM81039j);
        }
        C11839m.m70688i(TAG, "recordTimeWindowStart result: " + strM81039j);
    }

    private void registerNextTimeWindowScheduler() {
        C13464d c13464dM81030f = C13464d.m81030f(this.mContext);
        if (!c13464dM81030f.m81033c("backup_key")) {
            C11839m.m70689w(TAG, "registerNextTimeWindowScheduler backup switch is false");
            return;
        }
        boolean zM81033c = c13464dM81030f.m81033c(CloudBackupConstant.TimeWindowConstant.KEY_IS_NEW_PERIOD);
        C11839m.m70688i(TAG, "registerNextTimeWindowScheduler, nextDelayTime: " + this.nextDelayTime);
        CloudBackupJobManager.getInstance().registerTimeWindowScheduler(this.nextDelayTime, this.nextDeadLineTime, zM81033c);
    }

    private void registerReceiver() {
        if (this.mReceiver == null) {
            this.mReceiver = new TimeWindowObserverReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
            C11839m.m70688i(TAG, "registerReceiver");
            registerReceiver(this.mReceiver, intentFilter);
        }
    }

    private void reportTimeWindow(final String str) {
        C12515a.m75110o().m75172d(new AbstractC12367d() { // from class: com.huawei.android.hicloud.cloudbackup.jobscheduler.CloudBackupTimeWindowService.1
            @Override // p616rk.AbstractRunnableC12516b
            public void call() {
                try {
                    new C10321z().m63539D(str, null);
                } catch (C9721b e10) {
                    C11839m.m70687e(CloudBackupTimeWindowService.TAG, "reportTimeWindowCondition error: " + e10.toString());
                }
            }

            @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
            public void release() {
                super.release();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveJobInfo() {
        C13464d c13464dM81030f = C13464d.m81030f(this.mContext);
        if (!c13464dM81030f.m81033c(CloudBackupConstant.TimeWindowConstant.KEY_IS_NEW_PERIOD)) {
            if (c13464dM81030f.m81037h(CloudBackupConstant.TimeWindowConstant.KEY_TASK_START_TIME) != 0) {
                C11839m.m70688i(TAG, "is not new period");
                this.timingInterval = c13464dM81030f.m81036g(CloudBackupConstant.TimeWindowConstant.KEY_TIMING_INTERVAL, 10);
                this.periodRandomFactor = c13464dM81030f.m81036g(CloudBackupConstant.TimeWindowConstant.KEY_PERIOD_RANDOM_FACTOR, 7);
                return;
            }
            c13464dM81030f.m81045p(CloudBackupConstant.TimeWindowConstant.KEY_IS_NEW_PERIOD, true);
        }
        syncTimeWindowOmConfig();
        C11839m.m70688i(TAG, "is new period. timingInterval: " + this.timingInterval + ", periodRandomFactor: " + this.periodRandomFactor);
        c13464dM81030f.m81049t(CloudBackupConstant.TimeWindowConstant.KEY_TIME_WINDOW_RESULT, "");
        c13464dM81030f.m81048s(CloudBackupConstant.TimeWindowConstant.KEY_TASK_START_TIME, System.currentTimeMillis());
        if (checkAutoBackupCondition()) {
            queryAboutTimes(true, false);
        }
        HashMap<String, Integer> map = new HashMap<>();
        map.put(CloudBackupConstant.TimeWindowConstant.KEY_TIMING_INTERVAL, Integer.valueOf(this.timingInterval));
        map.put(CloudBackupConstant.TimeWindowConstant.KEY_PERIOD_RANDOM_FACTOR, Integer.valueOf(this.periodRandomFactor));
        c13464dM81030f.m81047r(map);
    }

    private String sortTimeWindow(String str) {
        C11839m.m70688i(TAG, "sortTimeWindow spResult: " + str);
        String str2 = (String) ((List) Arrays.stream(str.split("\\|")).filter(new Predicate() { // from class: com.huawei.android.hicloud.cloudbackup.jobscheduler.c
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CloudBackupTimeWindowService.lambda$sortTimeWindow$0((String) obj);
            }
        }).collect(Collectors.toList())).stream().sorted(new Comparator() { // from class: com.huawei.android.hicloud.cloudbackup.jobscheduler.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return CloudBackupTimeWindowService.lambda$sortTimeWindow$1((String) obj, (String) obj2);
            }
        }).collect(Collectors.joining("|"));
        C11839m.m70688i(TAG, "report timeWindowResult: " + str2);
        return str2;
    }

    private void syncTimeWindowOmConfig() {
        ContentResolver contentResolver = this.mContext.getContentResolver();
        BackupTimeWindowBean backupTimeWindowBean = new BackupTimeWindowBean();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = contentResolver.query(Uri.parse("content://com.huawei.hidisk.cloudbackup.backupstate/queryTimeWindowOmConfig"), null, null, null, null);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    while (cursorQuery.moveToNext()) {
                        backupTimeWindowBean.setTimingInterval(cursorQuery.getInt(cursorQuery.getColumnIndex(CloudBackupConstant.TimeWindowConstant.KEY_TIMING_INTERVAL)));
                        backupTimeWindowBean.setPeriodRandomFactor(cursorQuery.getInt(cursorQuery.getColumnIndex(CloudBackupConstant.TimeWindowConstant.KEY_PERIOD_RANDOM_FACTOR)));
                        backupTimeWindowBean.setStandAloneTask(cursorQuery.getInt(cursorQuery.getColumnIndex(CloudBackupConstant.TimeWindowConstant.STAND_ALONE_TASK)));
                    }
                }
            } catch (Exception e10) {
                C11839m.m70689w(TAG, "syncTimeWindowOmConfig error, use default time window config. error: " + e10.getMessage());
            }
        } finally {
            C11837k.m70678a(cursorQuery);
            this.timingInterval = backupTimeWindowBean.getTimingInterval();
            this.periodRandomFactor = backupTimeWindowBean.getPeriodRandomFactor();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void timeWindowCollectJob() {
        C13464d c13464dM81030f = C13464d.m81030f(this.mContext);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jM81037h = c13464dM81030f.m81037h(CloudBackupConstant.TimeWindowConstant.KEY_TASK_START_TIME);
        C11839m.m70688i(TAG, "timeWindowCollectJob periodTaskStartTime: " + jM81037h);
        long j10 = jCurrentTimeMillis - jM81037h;
        if (j10 > 86400000) {
            C11839m.m70688i(TAG, "The job in this period is complete");
            int i10 = this.periodRandomFactor;
            this.nextDelayTime = (((i10 * 86400000) + jM81037h) - jCurrentTimeMillis) + (((long) Math.ceil(i10 * new SecureRandom().nextDouble())) * 86400000);
            this.nextDeadLineTime = (jM81037h + (this.periodRandomFactor * 172800000)) - 86400000;
            if (checkRecordTimeWindowEnd() && checkAutoBackupCondition()) {
                queryAboutTimes(false, true);
                return;
            } else {
                processTimeWindowResult();
                return;
            }
        }
        if (j10 < 0) {
            C11839m.m70689w(TAG, "The job in this period is error end.");
            c13464dM81030f.m81049t(CloudBackupConstant.TimeWindowConstant.KEY_TIME_WINDOW_RESULT, "");
            c13464dM81030f.m81048s(CloudBackupConstant.TimeWindowConstant.KEY_TASK_START_TIME, 0L);
            c13464dM81030f.m81045p(CloudBackupConstant.TimeWindowConstant.KEY_IS_NEW_PERIOD, true);
            this.nextDelayTime = ((long) Math.ceil(this.periodRandomFactor * new SecureRandom().nextDouble())) * 86400000;
            this.nextDeadLineTime = (jCurrentTimeMillis + (this.periodRandomFactor * 86400000)) - 86400000;
            jobFinished();
            return;
        }
        String strM81039j = c13464dM81030f.m81039j(CloudBackupConstant.TimeWindowConstant.KEY_TIME_WINDOW_RESULT, "");
        c13464dM81030f.m81045p(CloudBackupConstant.TimeWindowConstant.KEY_IS_NEW_PERIOD, false);
        C11839m.m70688i(TAG, "The job in this period is not complete. TimeWindowResult: " + strM81039j);
        this.nextDelayTime = 0L;
        this.nextDeadLineTime = System.currentTimeMillis();
    }

    private void unRegisterReceiver() {
        if (this.mReceiver != null) {
            C11839m.m70688i(TAG, "unregisterReceiver");
            unregisterReceiver(this.mReceiver);
            this.mReceiver = null;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        C11839m.m70688i(TAG, "onDestroy");
        unRegisterReceiver();
        C12515a.m75110o().m75166b(TimeWindowCollectTask.class.getName());
        CloudBackupJobManager.getInstance().unRegisterTimeWindowScheduler();
        registerNextTimeWindowScheduler();
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        C11839m.m70688i(TAG, "onStartJob start");
        if (this.mContext == null || jobParameters == null || jobParameters.getExtras() == null) {
            C11839m.m70689w(TAG, "onStartJob error, context or params is null");
            jobFinished(jobParameters, false);
            CloudBackupJobManager.getInstance().unRegisterTimeWindowScheduler();
            return true;
        }
        C13464d c13464dM81030f = C13464d.m81030f(this.mContext);
        if (!c13464dM81030f.m81033c("backup_key")) {
            C11839m.m70689w(TAG, "onStartJob backup switch is false");
            jobFinished(jobParameters, false);
            CloudBackupJobManager.getInstance().unRegisterTimeWindowScheduler();
            return false;
        }
        this.jobParameters = jobParameters;
        c13464dM81030f.m81045p(CloudBackupConstant.TimeWindowConstant.KEY_IS_NEW_PERIOD, jobParameters.getExtras().getBoolean(CloudBackupConstant.TimeWindowConstant.KEY_IS_NEW_PERIOD));
        registerReceiver();
        C12515a.m75110o().m75175e(new TimeWindowCollectTask(), false);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        C11839m.m70688i(TAG, "onStopJob");
        unRegisterReceiver();
        C12515a.m75110o().m75166b(TimeWindowCollectTask.class.getName());
        CloudBackupJobManager.getInstance().unRegisterTimeWindowScheduler();
        registerNextTimeWindowScheduler();
        return false;
    }
}
