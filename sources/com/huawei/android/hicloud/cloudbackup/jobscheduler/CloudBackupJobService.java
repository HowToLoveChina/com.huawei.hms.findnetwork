package com.huawei.android.hicloud.cloudbackup.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupConditionsUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ICycleChecker;
import com.huawei.android.hicloud.cloudbackup.process.util.ThermalChecker;
import com.huawei.android.hicloud.cloudbackup.service.ICBServiceProtocol;
import com.huawei.android.hicloud.p088ui.uiutil.NewHiSyncUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import p015ak.C0206b0;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p529op.C11979a;
import p618rm.C12590s0;
import p684un.C13225d;
import p711vl.C13463c;
import p711vl.C13464d;
import p746wn.C13622a;
import p851zp.InterfaceC14358e;

/* loaded from: classes2.dex */
public class CloudBackupJobService extends JobService {
    private static final String BACKUP_SATISFY_TIME_KEY = "backupSatisfyTimeKey";
    private static final long DEFAULT_CHECKCYCLE = 120000;
    private static final String FLAG_JOB_DISPERSED = "hasDispersedjob";
    private static final long MINITE_MILLIS = 60000;
    private static final String REASON = "reason";
    private static final String REGISTER_POWER_COUNT_KEY = "registerPowerCountKey";
    private static final String REGISTER_POWER_TIME_KEY = "registerPowerTimeKey";
    private static final long SECONDS = 1000;
    private static final String TAG = "CloudBackupJobService";
    private ICycleChecker cycleChecker;
    private boolean hasTempBackup;
    private boolean isSmartCharging;
    private boolean result;
    private boolean isAgreeTerms = false;
    private int satisfyCount = 0;
    private int disSatisfyCount = 0;
    private boolean isCharging = false;
    private boolean isScreenOff = false;
    private boolean isThermalControlSatisfy = true;
    private boolean isWiFiActive = false;
    private boolean isCycleSatisfy = false;
    private boolean isRetryIntervalSatisfy = false;
    private boolean isNextBackupTimeSatisfy = false;
    private long checkInterval = 0;
    private long checkIntervalMax = 0;
    private long registerDelayTime = 0;
    private boolean hasDispersed = false;
    private int thermalLevel = -1;

    private void biReportConditions(String str) {
        C13463c c13463cM81022c = C13463c.m81022c(getApplicationContext());
        boolean zM81024b = c13463cM81022c.m81024b("isSatisfy");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (zM81024b) {
            C13464d c13464dM81030f = C13464d.m81030f(getApplicationContext());
            String strM81042m = c13464dM81030f.m81042m();
            String strM81043n = c13464dM81030f.m81043n("user_type");
            int iM25633c = NewHiSyncUtil.m25633c(getApplicationContext());
            if (!TextUtils.isEmpty(strM81042m) && !TextUtils.isEmpty(strM81043n)) {
                long jM81025d = c13463cM81022c.m81025d("satisfyTime");
                LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
                linkedHashMap.put(JsbMapKeyNames.H5_USER_ID, strM81042m);
                linkedHashMap.put("satisfy_time", String.valueOf(jM81025d));
                linkedHashMap.put("dissatisfy_time", String.valueOf(jCurrentTimeMillis));
                linkedHashMap.put("period", String.valueOf(jCurrentTimeMillis - jM81025d));
                linkedHashMap.put("reason", str);
                linkedHashMap.put("userType", strM81043n);
                linkedHashMap.put("gradeCode", C12590s0.m75747G0());
                linkedHashMap.put("batteryLevel", String.valueOf(iM25633c));
                linkedHashMap.put("chargePlug", String.valueOf(c13464dM81030f.m81036g("chargePlug", -1)));
                linkedHashMap.put("checkType", CloudBackupConditionsUtil.getBackUpCheckType());
                linkedHashMap.put("freqInfo", String.valueOf(c13464dM81030f.m81033c("freqInfo")));
                boolean zM81033c = c13464dM81030f.m81033c("noticeBeforeCheckResult");
                boolean zM81033c2 = c13464dM81030f.m81033c("autoBackupDlgCheckResult");
                if (zM81033c) {
                    linkedHashMap.put("noticeBeforeCheckResult", String.valueOf(true));
                }
                if (zM81033c2) {
                    linkedHashMap.put("autoBackupDlgCheckResult", String.valueOf(true));
                }
                C11839m.m70688i(TAG, "report condition " + str);
                C13225d.m79490f1().m79569S("cloudbackup_auto_condition_cycle", linkedHashMap, this.isAgreeTerms);
                UBAAnalyze.m29947H("CKC", "cloudbackup_auto_condition_cycle", linkedHashMap);
            }
            long jM81025d2 = c13463cM81022c.m81025d("lastPowerConnectTime");
            c13463cM81022c.m81023a();
            c13463cM81022c.m81028g("lastPowerConnectTime", jM81025d2);
        }
    }

    private boolean checkCondition() {
        if (CloudBackupConditionsUtil.isResetStatus()) {
            return false;
        }
        this.isThermalControlSatisfy = isThermalControlByDs();
        this.isScreenOff = !CloudBackupConditionsUtil.isScreenOn();
        this.isWiFiActive = CloudBackupConditionsUtil.isWiFiActive();
        this.isCycleSatisfy = this.cycleChecker.isCycleSatisfy();
        this.isRetryIntervalSatisfy = CloudBackupConditionsUtil.isRetryIntervalSatisfy();
        this.isNextBackupTimeSatisfy = CloudBackupConditionsUtil.isNextBackupTimeSatisfy();
        C11839m.m70688i(TAG, "cloud backup condition check result, [isScreenOff:" + this.isScreenOff + ", isWiFiActive:" + this.isWiFiActive + ", isThermalControlSatisfy:" + this.isThermalControlSatisfy + ", isCycleSatisfy:" + this.isCycleSatisfy + ", isRetryIntervalSatisfy:" + this.isRetryIntervalSatisfy + ", isNextBackupTimeSatisfy:" + this.isNextBackupTimeSatisfy + "]");
        if (this.isScreenOff && this.isWiFiActive && this.isThermalControlSatisfy) {
            this.satisfyCount++;
            this.disSatisfyCount = 0;
            return true;
        }
        this.disSatisfyCount++;
        this.satisfyCount = 0;
        return false;
    }

    private void checkIntervalTime() throws NoSuchAlgorithmException {
        long targetBackupTime = CloudBackupConditionsUtil.getTargetBackupTime(this.isCycleSatisfy, this.cycleChecker, this.isRetryIntervalSatisfy, this.isNextBackupTimeSatisfy);
        boolean z10 = this.isCycleSatisfy && (this.isRetryIntervalSatisfy || this.isNextBackupTimeSatisfy);
        C11839m.m70688i(TAG, "checkIntervalTime targetBackupTime: " + targetBackupTime + ", isIntervalSatisfy: " + z10);
        if (!z10) {
            this.registerDelayTime = CloudBackupConditionsUtil.checkDelayTime(targetBackupTime);
            return;
        }
        int iDelayedAutoBackup = CloudBackupConditionsUtil.delayedAutoBackup(C13464d.m81030f(getApplicationContext()).m81034d(), this.hasDispersed);
        if (iDelayedAutoBackup == 0) {
            this.result = ICBServiceProtocol.getInstance().doNewBackup(this.cycleChecker.getType());
            recordAutoStartTime();
            this.registerDelayTime = this.checkInterval * 60000;
            return;
        }
        this.registerDelayTime = iDelayedAutoBackup * 1000;
        C11839m.m70688i(TAG, "CloudBackupJobService will be delayed in " + iDelayedAutoBackup + " s");
        C13464d.m81030f(getApplicationContext()).m81045p(FLAG_JOB_DISPERSED, true);
    }

    private void checkRegisterPowerConnectScheduler(JobParameters jobParameters) {
        C13464d c13464dM81030f = C13464d.m81030f(getApplicationContext());
        long jM81037h = c13464dM81030f.m81037h(REGISTER_POWER_TIME_KEY);
        int iM81036g = c13464dM81030f.m81036g(REGISTER_POWER_COUNT_KEY, 0);
        C11839m.m70688i(TAG, "lastRegisterPowerTime: " + jM81037h + "lastRegisterPowerCount: " + iM81036g);
        if (jM81037h == 0) {
            c13464dM81030f.m81048s(REGISTER_POWER_TIME_KEY, System.currentTimeMillis());
            c13464dM81030f.m81046q(REGISTER_POWER_COUNT_KEY, 1);
            registerPowerScheduler(jobParameters, this.isAgreeTerms, 0L);
            C11839m.m70688i(TAG, "register power connect scheduler at first");
            return;
        }
        if (System.currentTimeMillis() - jM81037h > 1000) {
            c13464dM81030f.m81048s(REGISTER_POWER_TIME_KEY, System.currentTimeMillis());
            c13464dM81030f.m81046q(REGISTER_POWER_COUNT_KEY, 1);
            registerPowerScheduler(jobParameters, this.isAgreeTerms, 0L);
            C11839m.m70688i(TAG, "register power connect scheduler time over 1 seconds.");
            return;
        }
        if (iM81036g >= 3) {
            c13464dM81030f.m81048s(REGISTER_POWER_TIME_KEY, System.currentTimeMillis());
            c13464dM81030f.m81046q(REGISTER_POWER_COUNT_KEY, 1);
            registerPowerScheduler(jobParameters, this.isAgreeTerms, 120000L);
            C11839m.m70688i(TAG, "register power connect scheduler times over: " + iM81036g);
            return;
        }
        int i10 = iM81036g + 1;
        c13464dM81030f.m81046q(REGISTER_POWER_COUNT_KEY, i10);
        registerPowerScheduler(jobParameters, this.isAgreeTerms, 0L);
        C11839m.m70688i(TAG, "register power connect scheduler times: " + i10);
    }

    private boolean checkSwitchWithMainProcess(C13464d c13464d) {
        boolean zM1131c = C0206b0.m1131c("backup_key", getApplicationContext());
        C11839m.m70688i(TAG, "checkSwitchWithMainProcess mainBackupSwitch: " + zM1131c);
        if (!zM1131c) {
            return false;
        }
        c13464d.m81045p("backup_key", true);
        return true;
    }

    private void dealAutoBackupCheck() throws NoSuchAlgorithmException {
        boolean zCheckCondition = checkCondition();
        C11839m.m70688i(TAG, "satisfyCount: " + this.satisfyCount + ", disSatisfyCount: " + this.disSatisfyCount);
        if (!zCheckCondition) {
            long j10 = this.checkInterval;
            int i10 = this.disSatisfyCount;
            if (i10 * j10 < this.checkIntervalMax) {
                this.registerDelayTime = j10 * i10 * 60000;
            } else {
                C11839m.m70688i(TAG, "checkInterval * i is already over checkIntervalMax, register backup scheduler with checkIntervalMax");
                this.registerDelayTime = this.checkIntervalMax * 60000;
            }
        } else if (this.satisfyCount == 2 || this.hasDispersed) {
            this.satisfyCount = 0;
            this.disSatisfyCount = 0;
            checkIntervalTime();
        } else {
            this.registerDelayTime = this.checkInterval * 60000;
        }
        String conditionReason = getConditionReason(this.isCharging, this.isScreenOff, this.isWiFiActive, this.isCycleSatisfy, this.isRetryIntervalSatisfy, this.isNextBackupTimeSatisfy, this.isSmartCharging, this.isThermalControlSatisfy, this.hasTempBackup);
        omReportConditions(conditionReason);
        if ((!this.isCharging && !this.isSmartCharging) || !this.isScreenOff || !this.isWiFiActive || !this.isCycleSatisfy || !this.isThermalControlSatisfy || (!this.isRetryIntervalSatisfy && !this.isNextBackupTimeSatisfy)) {
            biReportConditions(conditionReason);
            return;
        }
        C13463c c13463cM81022c = C13463c.m81022c(getApplicationContext());
        if (c13463cM81022c.m81024b("isSatisfy")) {
            return;
        }
        c13463cM81022c.m81027f("isSatisfy", true);
        c13463cM81022c.m81028g("satisfyTime", System.currentTimeMillis());
    }

    private void dealCloudBackupOpen(JobParameters jobParameters) throws NoSuchAlgorithmException {
        CloudBackupConditionsUtil.ChargeAttr chargeAttr = CloudBackupConditionsUtil.getChargeAttr();
        this.isCharging = chargeAttr.isCharging();
        int chargePlug = chargeAttr.getChargePlug();
        C13464d.m81030f(getApplicationContext()).m81046q("chargePlug", chargePlug);
        boolean zIsSmartCharging = isSmartCharging(chargeAttr);
        this.isSmartCharging = zIsSmartCharging;
        if (this.isCharging || zIsSmartCharging) {
            C11839m.m70688i(TAG, "isCharging register backup scheduler.");
            long jM81037h = C13464d.m81030f(getApplicationContext()).m81037h("doBackupTime");
            if (System.currentTimeMillis() - jM81037h >= 240000 || jM81037h == 0) {
                dealAutoBackupCheck();
            } else {
                C11839m.m70688i(TAG, "already do backup, keep jobshceduler alive");
                this.registerDelayTime = this.checkInterval * 60000;
            }
            jobFinished(jobParameters, false);
            CloudBackupJobManager.getInstance().unRegisterBackupScheduler();
            unRegisterThermalCallback();
            CloudBackupJobManager.getInstance().registerBackupScheduler(this.registerDelayTime, this.isAgreeTerms, this.satisfyCount, this.disSatisfyCount, new InterfaceC14358e() { // from class: com.huawei.android.hicloud.cloudbackup.jobscheduler.b
                @Override // p851zp.InterfaceC14358e
                public final void execute() {
                    this.f11666a.lambda$dealCloudBackupOpen$0();
                }
            });
            return;
        }
        C11839m.m70688i(TAG, "cloud backup switch is on, but is not charging, need register power connect scheduler.");
        String conditionReason = getConditionReason(this.isCharging, true, true, true, true, true, this.isSmartCharging, this.isThermalControlSatisfy, this.hasTempBackup);
        biReportConditions(conditionReason);
        omReportConditions(conditionReason);
        if (chargePlug != 1 && chargePlug != 2 && chargePlug != 4) {
            checkRegisterPowerConnectScheduler(jobParameters);
            return;
        }
        C11839m.m70688i(TAG, "current battery status error, just register backup scheduler");
        this.registerDelayTime = this.checkInterval * 60000;
        jobFinished(jobParameters, false);
        CloudBackupJobManager.getInstance().unRegisterBackupScheduler();
        unRegisterThermalCallback();
        CloudBackupJobManager.getInstance().registerBackupScheduler(this.registerDelayTime, this.isAgreeTerms, this.satisfyCount, this.disSatisfyCount, null);
    }

    private String getConditionReason(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18) {
        StringBuilder sb2 = new StringBuilder(parseCondition(z10));
        sb2.append(parseCondition(z11));
        sb2.append(parseCondition(z12));
        boolean z19 = true;
        sb2.append(parseCondition(true));
        sb2.append(parseCondition(z13));
        if (!z14 && !z15) {
            z19 = false;
        }
        sb2.append(parseCondition(z19));
        sb2.append(parseCondition(z16));
        sb2.append(parseCondition(z17));
        sb2.append(parseCondition(z18));
        return sb2.toString();
    }

    private boolean isSmartCharging(CloudBackupConditionsUtil.ChargeAttr chargeAttr) {
        return CloudBackupConditionsUtil.isConfigureBatteryChanger() && CloudBackupConditionsUtil.isSmartCharging(chargeAttr);
    }

    private boolean isThermalControlByDs() {
        if (!ThermalChecker.matchThermalControlDevice(true) || ThermalChecker.isBlowOut(true) || CloudBackupConditionsUtil.isInterimBackupThermalControlDisable("0".equals(this.cycleChecker.getType()))) {
            return true;
        }
        int iM72105j = C11979a.m72102l().m72105j();
        this.thermalLevel = iM72105j;
        return ThermalChecker.isThermalControlByDs(iM72105j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dealCloudBackupOpen$0() {
        CloudBackupConditionsUtil.recordCycleCondition(this.cycleChecker.getType() + this.isCycleSatisfy, getApplicationContext());
    }

    private void omReportConditions(String str) {
        C13464d c13464dM81030f = C13464d.m81030f(getApplicationContext());
        String strM81039j = c13464dM81030f.m81039j("reason", "");
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jM81037h = c13464dM81030f.m81037h(CloudBackupConstant.ReportReason.REPORT_REASON_TIME);
        C11839m.m70686d(TAG, "reason: " + strM81039j + ", currentReason: " + str + ", currentTime: " + jCurrentTimeMillis + ", lastReportTime: " + jM81037h);
        if (!strM81039j.equals(str) || jCurrentTimeMillis - jM81037h > 1800000) {
            c13464dM81030f.m81049t("reason", str);
            c13464dM81030f.m81048s(CloudBackupConstant.ReportReason.REPORT_REASON_TIME, jCurrentTimeMillis);
            int iM25633c = NewHiSyncUtil.m25633c(getApplicationContext());
            String strM81042m = c13464dM81030f.m81042m();
            String strM81043n = c13464dM81030f.m81043n("user_type");
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02012"), "success", strM81042m);
            c11060cM66626a.m66665u("0");
            if (TextUtils.isEmpty(strM81042m) || TextUtils.isEmpty(strM81043n)) {
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(JsbMapKeyNames.H5_USER_ID, strM81042m);
            linkedHashMap.put("userType", strM81043n);
            linkedHashMap.put("gradeCode", C12590s0.m75747G0());
            linkedHashMap.put("pn", "com.huawei.hidisk\u0001_cloudbackup");
            linkedHashMap.put("reason", str);
            linkedHashMap.put("batteryLevel", String.valueOf(iM25633c));
            linkedHashMap.put("chargePlug", String.valueOf(c13464dM81030f.m81036g("chargePlug", -1)));
            linkedHashMap.put("time", String.valueOf(System.currentTimeMillis()));
            linkedHashMap.put("lastSuccesTime", String.valueOf(c13464dM81030f.m81037h("lastsuccesstime")));
            linkedHashMap.put("backup_frequency", String.valueOf(c13464dM81030f.m81035e()));
            linkedHashMap.put("timeAdvanced", String.valueOf(c13464dM81030f.m81037h("timeAdvanced")));
            linkedHashMap.put("isCycleSatisfy", String.valueOf(this.isCycleSatisfy));
            linkedHashMap.put("isNextBackupTimeSatisfy", String.valueOf(this.isNextBackupTimeSatisfy));
            linkedHashMap.put("isRetryIntervalSatisfy", String.valueOf(this.isRetryIntervalSatisfy));
            linkedHashMap.put("checkType", CloudBackupConditionsUtil.getBackUpCheckType());
            linkedHashMap.put("freqInfo", String.valueOf(c13464dM81030f.m81033c("freqInfo")));
            C13622a.m81971q(c11060cM66626a, linkedHashMap, this.isAgreeTerms, true);
            C11839m.m70688i(TAG, "om report condition " + str);
        }
    }

    private String parseCondition(boolean z10) {
        return z10 ? "0" : "1";
    }

    private void recordAutoStartTime() {
        C13464d c13464dM81030f = C13464d.m81030f(getApplicationContext());
        if (c13464dM81030f.m81037h("autobackupstarttime") == 0) {
            c13464dM81030f.m81048s("autobackupstarttime", System.currentTimeMillis());
            c13464dM81030f.m81048s("autobackupblowouttime", 0L);
        }
    }

    private void registerPowerScheduler(JobParameters jobParameters, boolean z10, long j10) {
        jobFinished(jobParameters, false);
        CloudBackupJobManager.getInstance().unRegisterPowerConnectScheduler();
        CloudBackupJobManager.getInstance().registerPowerConnectScheduler(z10, j10);
    }

    private void unRegisterThermalCallback() {
        C11979a.m72102l().m72111q(1);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) throws NoSuchAlgorithmException {
        C11839m.m70688i(TAG, "CloudBackupJobService onStartJob");
        boolean zM81033c = C13464d.m81030f(getApplicationContext()).m81033c(FLAG_JOB_DISPERSED);
        this.hasDispersed = zM81033c;
        if (zM81033c) {
            C13464d.m81030f(getApplicationContext()).m81045p(FLAG_JOB_DISPERSED, false);
        }
        this.cycleChecker = CloudBackupConditionsUtil.getCycleChecker();
        if (jobParameters != null && jobParameters.getExtras() != null) {
            this.isAgreeTerms = jobParameters.getExtras().getBoolean("isAgreeTerms");
            this.satisfyCount = jobParameters.getExtras().getInt("satisfyCount");
            this.disSatisfyCount = jobParameters.getExtras().getInt("disSatisfyCount");
        }
        C13464d c13464dM81030f = C13464d.m81030f(getApplicationContext());
        boolean zM81033c2 = c13464dM81030f.m81033c("backup_key");
        this.hasTempBackup = "interim".equals(c13464dM81030f.m81039j("backupAction", ""));
        this.checkInterval = c13464dM81030f.m81037h("checkInterval");
        this.checkIntervalMax = c13464dM81030f.m81037h("checkIntervalMax");
        this.registerDelayTime = this.checkInterval * 60000;
        boolean zCheckSwitchWithMainProcess = zM81033c2 || this.hasTempBackup;
        if (!zCheckSwitchWithMainProcess) {
            zCheckSwitchWithMainProcess = checkSwitchWithMainProcess(c13464dM81030f);
        }
        if (zCheckSwitchWithMainProcess) {
            dealCloudBackupOpen(jobParameters);
        } else {
            C11839m.m70688i(TAG, "cloud backup switch is off, close job service.");
            c13464dM81030f.m81048s(BACKUP_SATISFY_TIME_KEY, 0L);
            jobFinished(jobParameters, false);
        }
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        C11839m.m70688i(TAG, "CloudBackupJobService onStopJob");
        return false;
    }
}
