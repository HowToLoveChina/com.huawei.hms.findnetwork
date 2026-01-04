package com.huawei.android.hicloud.cloudbackup.jobscheduler;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupConditionsUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.cloudbackup.obsever.CloudBackupObserverService;
import gp.C10028c;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Optional;
import java.util.Random;
import kn.C11074k;
import p015ak.C0206b0;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0219i;
import p015ak.C0241z;
import p020ap.C1009d;
import p292fn.C9733f;
import p514o9.C11829c;
import p514o9.C11839m;
import p572qb.C12299b;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p617rl.C12526j;
import p709vj.C13452e;
import p711vl.C13466f;
import p851zp.InterfaceC14358e;

/* loaded from: classes2.dex */
public class CloudBackupJobManager {
    private static final long BACKUP_TIMER_CYCLE = 300000;
    private static final int DELAY_END_HOUR = 30;
    private static final int DELAY_MAX = 120;
    private static final int DELAY_MIN = 1;
    private static final int DELAY_START_HOUR = 20;
    private static final String DS_PROCESS_NAME = "com.huawei.android.ds";
    private static final CloudBackupJobManager INSTANCE = new CloudBackupJobManager();
    private static final int JOB_ID_CLOUD_BACKUP_CACHE_TIMER = 1024;
    private static final int JOB_ID_CLOUD_BACKUP_TIMER = 1020;
    private static final int JOB_ID_CLOUD_RESTORE_TIMER = 1022;
    private static final int JOB_ID_COLLECT_TIME_WINDOW = 1025;
    private static final int JOB_ID_NOTIFY_TIMER = 1023;
    private static final int JOB_ID_POWER_CONNECT = 1021;
    private static final long NOTIFY_DAY_MILLS = 90000000;
    private static final long ONE_DAY_MILLS = 86400000;
    private static final long RESTORE_TIMER_CYCLE = 240000;
    private static final String TAG = "CloudBackupJobManager";

    public static class SyncCloudBackupDataToDS extends AbstractC12367d {
        private SyncCloudBackupDataToDS() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C11839m.m70688i(CloudBackupJobManager.TAG, "retry sync data to Ds");
            SettingOperator settingOperator = new SettingOperator();
            long jQuerynextbackuptime = settingOperator.querynextbackuptime();
            long jQuerydelayedstarttime = settingOperator.querydelayedstarttime();
            long jQuerybreakedtime = settingOperator.querybreakedtime();
            long jQuerylastsuccesstime = settingOperator.querylastsuccesstime();
            long jQuerylastfailedtime = settingOperator.querylastfailedtime();
            long jQuerylastnotifytime = settingOperator.querylastnotifytime();
            long jQueryinitopentime = settingOperator.queryinitopentime();
            long jQuerynotifycycle = settingOperator.querynotifycycle();
            ContentValues omConfigContentValues = getOmConfigContentValues();
            omConfigContentValues.put("nextbackuptime", Long.valueOf(jQuerynextbackuptime));
            omConfigContentValues.put("delayedstarttime", Long.valueOf(jQuerydelayedstarttime));
            omConfigContentValues.put("breakedtime", Long.valueOf(jQuerybreakedtime));
            omConfigContentValues.put("lastsuccesstime", Long.valueOf(jQuerylastsuccesstime));
            omConfigContentValues.put("lastfailedtime", Long.valueOf(jQuerylastfailedtime));
            omConfigContentValues.put("lastnotifytime", Long.valueOf(jQuerylastnotifytime));
            omConfigContentValues.put("lastbackuptime", Long.valueOf(jQueryinitopentime));
            omConfigContentValues.put("notifycycle", Long.valueOf(jQuerynotifycycle));
            C12299b.m73937s(omConfigContentValues);
            C10028c c10028cM62182c0 = C10028c.m62182c0();
            if (c10028cM62182c0.m62368o("backup_key")) {
                C12299b.m73934p(c10028cM62182c0.m62388s("backup_key"));
            }
            C12299b.m73931m(C1009d.m6109e().m6115g());
            C12526j c12526j = new C12526j();
            if (c12526j.m75407n("disperseRule") != null) {
                C12299b.m73930l(c12526j.m75372Y());
            }
            if (c12526j.m75407n("batteryChargeConnected") != null) {
                int iM75425w = c12526j.m75425w();
                ContentValues contentValues = new ContentValues();
                contentValues.put("batteryChargeConnected", String.valueOf(iM75425w));
                C12299b.m73929k(contentValues, "autoBackupBatteryCharge");
            }
            if (c12526j.m75407n("thermalControl") != null) {
                C12299b.m73936r(c12526j.m75348M("thermalControl"));
            }
            if (c12526j.m75385d1("thermalControlGroup")) {
                C12299b.m73935q(c12526j.m75348M("thermalControlGroup"));
            }
            if (c12526j.m75407n("restoreRetry") != null) {
                C12299b.m73932n("restoreRetry", c12526j.m75327B0());
            }
            String strM80790C = C13452e.m80781L().m80790C();
            C12299b.m73932n("CACHED_GRADE_CODE", strM80790C);
            boolean zM62303a1 = C10028c.m62182c0().m62303a1();
            C11839m.m70688i(CloudBackupJobManager.TAG, "refresh baseBackupOn: " + zM62303a1 + " ,gradeCode: " + strM80790C);
            C12299b.m73928j("base_backup_new_key", Boolean.valueOf(zM62303a1));
        }

        public ContentValues getOmConfigContentValues() {
            C12526j c12526j = new C12526j();
            ContentValues contentValues = new ContentValues();
            if (c12526j.m75407n("backupCycle") != null) {
                contentValues.put("backupCycle", Long.valueOf(C0241z.m1689g(c12526j.m75407n("backupCycle").m75434b(), 7L)));
            }
            if (c12526j.m75407n("retryInterval") != null) {
                contentValues.put("retryInterval", Long.valueOf(c12526j.m75331D0()));
            }
            if (c12526j.m75407n("timeAdvanced") != null) {
                contentValues.put("timeAdvanced", Long.valueOf(C0241z.m1689g(c12526j.m75407n("timeAdvanced").m75434b(), 20L)));
            }
            if (c12526j.m75407n("checkInterval") != null) {
                contentValues.put("checkInterval", Long.valueOf(C0241z.m1689g(c12526j.m75407n("checkInterval").m75434b(), 2L)));
            }
            if (c12526j.m75407n("checkIntervalMax") != null) {
                contentValues.put("checkIntervalMax", Long.valueOf(C0241z.m1689g(c12526j.m75407n("checkIntervalMax").m75434b(), 30L)));
            }
            if (c12526j.m75407n("defaultRedDot") != null) {
                contentValues.put("defaultRedDot", Integer.valueOf(c12526j.m75409o()));
            }
            return contentValues;
        }

        public /* synthetic */ SyncCloudBackupDataToDS(C24771 c24771) {
            this();
        }
    }

    private void cancelScheduler(int i10) {
        JobScheduler jobScheduler = (JobScheduler) getContext().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70688i(TAG, "cancel job, scheduler is null.");
        } else {
            jobScheduler.cancel(i10);
        }
    }

    private static Context getContext() {
        return C0213f.m1377a();
    }

    public static CloudBackupJobManager getInstance() {
        return INSTANCE;
    }

    private long getNotifyDelayMillis() {
        long jM66721x = C11074k.m66721x(20, 30);
        long jCurrentTimeMillis = jM66721x < System.currentTimeMillis() ? NOTIFY_DAY_MILLS : (jM66721x - System.currentTimeMillis()) - (new Random().nextInt(7200) * 1000);
        C11839m.m70688i(TAG, "compute delayTime is:" + jM66721x + ",delayMillis is:" + jCurrentTimeMillis);
        return jCurrentTimeMillis;
    }

    private static boolean isChecked() {
        return C13466f.m81073d().m81075b("backup_key", false);
    }

    private boolean isJobServiceOn(int i10) {
        JobScheduler jobScheduler = (JobScheduler) getContext().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e(TAG, "job scheduler is null");
            return false;
        }
        Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
        while (it.hasNext()) {
            if (it.next().getId() == i10) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ void lambda$registerBackupScheduler$0() {
        CloudBackupConditionsUtil.recordCycleCondition("", getContext());
    }

    private void scheduler(JobInfo jobInfo) {
        JobScheduler jobScheduler = (JobScheduler) getContext().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70689w(TAG, "scheduler job, scheduler is null");
        } else {
            jobScheduler.schedule(jobInfo);
        }
    }

    private void startBackupObserverService() {
        C11839m.m70688i(TAG, "start cloud backup observer service.");
        Context context = getContext();
        Intent intent = new Intent(context, (Class<?>) CloudBackupObserverService.class);
        intent.setAction("com.huawei.hicloud.cloudbackup.observer.service");
        context.startService(intent);
    }

    public boolean isCloudBackupFrequencyOnDeviceIdle() {
        int userBackUpFrequency = CloudBackupConditionsUtil.getUserBackUpFrequency();
        boolean zM60720O = C9733f.m60705z().m60720O("enableCloudBackupFrequencyOnDeviceIdle");
        int iM75340I = new C12526j().m75340I();
        C11839m.m70688i(TAG, "isCloudBackupFrequencyOnDeviceIdle frequency = " + userBackUpFrequency + ", enableCloudBackupFrequencyOnDeviceIdle = " + zM60720O + ", cloudBackupFrequencyOnDeviceIdle = " + iM75340I);
        return zM60720O && matchFrequency(userBackUpFrequency, iM75340I);
    }

    public boolean matchFrequency(int i10, int i11) {
        if (i10 == 7 && (i11 & 8) != 0) {
            return true;
        }
        if (i10 == 5 && (i11 & 4) != 0) {
            return true;
        }
        if (i10 != 3 || (i11 & 2) == 0) {
            return i10 == 1 && (i11 & 1) != 0;
        }
        return true;
    }

    public void registerAllBackupScheduler() {
        if (C0209d.m1293p1()) {
            C11839m.m70688i(TAG, "registerAllBackupScheduler isInkScreen");
            return;
        }
        boolean zM1131c = C0206b0.m1131c("is_hicloud_terms_confirm", getContext());
        C11839m.m70688i(TAG, "registerAllBackupScheduler isAgreeTerms: " + zM1131c + ", isChecked: " + isChecked());
        if (zM1131c && isChecked()) {
            C11839m.m70688i(TAG, "begin register all backup scheduler");
            unRegisterPowerConnectScheduler();
            unRegisterNotifyScheduler();
            registerPowerConnectScheduler(true, 0L);
            registerNotifyScheduler(false);
            if (CBAccess.hasRestoreTask()) {
                registerRestoreScheduler(Long.valueOf(RestoreUtil.getRestoreDelayTime()));
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public void registerBackupCacheScheduler(long j10, String str, String str2) {
        C11839m.m70688i(TAG, "registerBackupCacheScheduler backup cache scheduler delay = " + j10);
        cancelScheduler(1024);
        JobInfo.Builder builder = new JobInfo.Builder(1024, new ComponentName(getContext(), (Class<?>) CloudBackupCacheJobService.class));
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("cloneTempPath", str);
        persistableBundle.putString("dataTempPath", str2);
        builder.setPersisted(true);
        builder.setExtras(persistableBundle);
        builder.setMinimumLatency(j10);
        scheduler(builder.build());
    }

    @SuppressLint({"MissingPermission"})
    public void registerBackupScheduler(long j10, boolean z10, int i10, int i11, InterfaceC14358e interfaceC14358e) {
        if (C0209d.m1293p1()) {
            C11839m.m70688i(TAG, "registerBackupScheduler isInkScreen");
            return;
        }
        if (isJobServiceOn(JOB_ID_CLOUD_BACKUP_TIMER)) {
            C11839m.m70688i(TAG, "backup scheduler job is exist.");
            return;
        }
        String backUpCheckType = CloudBackupConditionsUtil.getBackUpCheckType();
        C11839m.m70688i(TAG, "registerBackupScheduler delay time: " + j10 + ", isAgreeTerms: " + z10 + ", satisfyCount: " + i10 + ", disSatisfyCount: " + i11 + ", cloudBackupFrequencyOnDeviceIdleType: " + backUpCheckType);
        ((InterfaceC14358e) Optional.ofNullable(interfaceC14358e).orElse(new InterfaceC14358e() { // from class: com.huawei.android.hicloud.cloudbackup.jobscheduler.a
            @Override // p851zp.InterfaceC14358e
            public final void execute() {
                CloudBackupJobManager.lambda$registerBackupScheduler$0();
            }
        })).execute();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putBoolean("isAgreeTerms", z10);
        persistableBundle.putInt("satisfyCount", i10);
        persistableBundle.putInt("disSatisfyCount", i11);
        persistableBundle.putString("checkType", backUpCheckType);
        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID_CLOUD_BACKUP_TIMER, new ComponentName(getContext(), (Class<?>) CloudBackupJobService.class));
        builder.setPersisted(true);
        builder.setExtras(persistableBundle);
        if (j10 == 0) {
            builder.setOverrideDeadline(300000L);
        } else {
            builder.setMinimumLatency(j10);
        }
        scheduler(builder.build());
    }

    public void registerDsRestoreScheduler(long j10) {
        C12299b.m73922d(getContext(), true, j10);
    }

    @SuppressLint({"MissingPermission"})
    public void registerNotifyScheduler(boolean z10) {
        if (isJobServiceOn(1023)) {
            C11839m.m70688i(TAG, "backup notify scheduler job is exist.");
            return;
        }
        JobInfo.Builder builder = new JobInfo.Builder(1023, new ComponentName(getContext(), (Class<?>) CloudBackupNotifyJobService.class));
        builder.setPersisted(true);
        builder.setMinimumLatency(getNotifyDelayMillis());
        scheduler(builder.build());
        if (z10) {
            C11839m.m70688i(TAG, "registerNotifyScheduler isDelay: true");
            return;
        }
        int iM1260h0 = C0209d.m1260h0(1, 120);
        C11839m.m70688i(TAG, "registerNotifyScheduler isDelay: false, start delay JobTask: " + iM1260h0);
        C12515a.m75110o().m75172d(new CloudBackupNotifyJobTask(iM1260h0));
    }

    @SuppressLint({"MissingPermission"})
    public void registerPowerConnectScheduler(boolean z10, long j10) {
        C11839m.m70688i(TAG, "registerPowerConnectScheduler");
        if (C0209d.m1293p1()) {
            C11839m.m70688i(TAG, "startService isInkScreen");
            return;
        }
        if (isJobServiceOn(1021)) {
            C11839m.m70688i(TAG, "power connect job is exist.");
            return;
        }
        if (j10 <= 0 && CloudBackupConditionsUtil.isConfigureBatteryChanger()) {
            CloudBackupConditionsUtil.ChargeAttr chargeAttr = CloudBackupConditionsUtil.getChargeAttr();
            if (!chargeAttr.isCharging() && CloudBackupConditionsUtil.isSmartCharging(chargeAttr)) {
                C11839m.m70688i(TAG, "registerPowerConnectScheduler doDsPowerConnectJob delayTime: " + j10);
                C12299b.m73920b(getContext(), z10);
                return;
            }
        }
        C11839m.m70688i(TAG, "begin register power connect job scheduler, delayTime:" + j10);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putBoolean("isAgreeTerms", z10);
        JobInfo.Builder builder = new JobInfo.Builder(1021, new ComponentName(getContext(), (Class<?>) PowerConnectJobService.class));
        builder.setRequiresCharging(true).setExtras(persistableBundle).setPersisted(true);
        if (j10 > 0) {
            builder.setMinimumLatency(j10);
            builder.setOverrideDeadline(300000L);
        }
        boolean zIsCloudBackupFrequencyOnDeviceIdle = isCloudBackupFrequencyOnDeviceIdle();
        CloudBackupConditionsUtil.saveCheckTypeToSp(zIsCloudBackupFrequencyOnDeviceIdle ? "1" : "0");
        if (zIsCloudBackupFrequencyOnDeviceIdle) {
            C11839m.m70688i(TAG, "registerPowerConnectScheduler isCloudBackupFrequencyOnDeviceIdle true");
            builder.setRequiresDeviceIdle(true);
        }
        scheduler(builder.build());
    }

    @SuppressLint({"MissingPermission"})
    public void registerRestoreScheduler(Long l10) {
        if (isJobServiceOn(1022)) {
            C11839m.m70688i(TAG, "restore scheduler job is exist.");
            return;
        }
        C11839m.m70688i(TAG, "register restore scheduler delayTime: " + l10);
        JobInfo.Builder builder = new JobInfo.Builder(1022, new ComponentName(getContext(), (Class<?>) CloudRestoreJobService.class));
        builder.setPersisted(true).setRequiredNetworkType(2);
        if (l10 != null) {
            builder.setMinimumLatency(10000L);
        } else {
            builder.setOverrideDeadline(RESTORE_TIMER_CYCLE);
        }
        scheduler(builder.build());
    }

    public void registerTimeWindowScheduler() {
        boolean zM1131c = C0206b0.m1131c("is_hicloud_terms_confirm", getContext());
        boolean zIsChecked = isChecked();
        C11839m.m70688i(TAG, "registerTimeWindowScheduler isAgreeTerms: " + zM1131c + ", isChecked: " + zIsChecked);
        if (zM1131c && zIsChecked) {
            int periodRandomFactor = new C12526j().m75421u().getPeriodRandomFactor();
            registerTimeWindowScheduler(((long) Math.ceil(periodRandomFactor * new SecureRandom().nextDouble())) * 86400000, (System.currentTimeMillis() + (periodRandomFactor * 86400000)) - 86400000, true);
        }
    }

    public void startAutoBackupListenerWithSwitchOpen() {
        if (!C11829c.m70611r0()) {
            getInstance().stopService();
            getInstance().unRegisterPowerConnectScheduler();
            getInstance().registerPowerConnectScheduler(true, 0L);
        } else {
            getInstance().startBackupObserverService();
            if (C0219i.m1463a() >= 23) {
                getInstance().unRegisterAllScheduler();
            }
        }
    }

    public void startService() {
        if (C0209d.m1293p1()) {
            C11839m.m70688i(TAG, "startService isInkScreen");
        } else if (isChecked()) {
            startBackupObserverService();
            if (CBAccess.hasRestoreTask()) {
                registerDsRestoreScheduler(RestoreUtil.getRestoreDelayTime());
            }
        }
    }

    public void stopService() {
        C11839m.m70688i(TAG, "stop cloud backup observer service.");
        unRegisterDsRestoreScheduler();
        Context context = getContext();
        context.stopService(new Intent(context, (Class<?>) CloudBackupObserverService.class));
    }

    public void syncDataToDS(boolean z10) {
        boolean zM73933o = C12299b.m73933o();
        C11839m.m70686d(TAG, "syncDataTIoDS,isInit:" + z10 + ",isUpdateSuccess:" + zM73933o);
        if (z10 || !zM73933o) {
            C12515a.m75110o().m75172d(new SyncCloudBackupDataToDS());
        }
    }

    public void unRegisterAllBackupScheduler() {
        C11839m.m70688i(TAG, "register all backup scheduler");
        stopService();
        unRegisterPowerConnectScheduler();
        unRegisterBackupScheduler();
        unRegisterNotifyScheduler();
    }

    public void unRegisterAllScheduler() {
        C11839m.m70688i(TAG, "register all scheduler");
        unRegisterPowerConnectScheduler();
        unRegisterBackupScheduler();
        unRegisterNotifyScheduler();
        unRegisterRestoreScheduler();
    }

    public void unRegisterBackupCacheScheduler() {
        C11839m.m70688i(TAG, "unRegisterBackupCacheScheduler");
        cancelScheduler(1024);
    }

    public void unRegisterBackupScheduler() {
        C11839m.m70688i(TAG, "unRegisterBackupScheduler");
        cancelScheduler(JOB_ID_CLOUD_BACKUP_TIMER);
    }

    public void unRegisterDsRestoreScheduler() {
        if (ICBUtil.isProcessAlive(getContext(), DS_PROCESS_NAME)) {
            C12299b.m73922d(getContext(), false, 0L);
        }
    }

    public void unRegisterNotifyScheduler() {
        C11839m.m70688i(TAG, "unRegisterNotifyScheduler");
        cancelScheduler(1023);
    }

    public void unRegisterPowerConnectScheduler() {
        C11839m.m70688i(TAG, "unRegisterPowerConnectScheduler");
        cancelScheduler(1021);
    }

    public void unRegisterRestoreScheduler() {
        C11839m.m70688i(TAG, "unRegisterRestoreScheduler");
        cancelScheduler(1022);
    }

    public void unRegisterTimeWindowScheduler() {
        C11839m.m70688i(TAG, "unRegisterTimeWindowScheduler");
        cancelScheduler(1025);
    }

    @SuppressLint({"MissingPermission"})
    public void registerTimeWindowScheduler(long j10, long j11, boolean z10) {
        if (isJobServiceOn(1025)) {
            C11839m.m70688i(TAG, "collect time window scheduler job already exists.");
            return;
        }
        if (z10 && !C9733f.m60705z().m60720O("cloudBackupTimeWindowCollectEx")) {
            C11839m.m70689w(TAG, "isNewPeriod. timeWindowCollectSwitch is close.");
            return;
        }
        C11839m.m70688i(TAG, "registerTimeWindowScheduler");
        JobInfo.Builder builder = new JobInfo.Builder(1025, new ComponentName(getContext(), (Class<?>) CloudBackupTimeWindowService.class));
        builder.setPersisted(true);
        builder.setMinimumLatency(j10);
        builder.setOverrideDeadline(j11);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putBoolean(CloudBackupConstant.TimeWindowConstant.KEY_IS_NEW_PERIOD, z10);
        builder.setExtras(persistableBundle);
        builder.setRequiresCharging(true);
        scheduler(builder.build());
    }
}
