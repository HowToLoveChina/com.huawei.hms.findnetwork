package com.huawei.hicloud.cloudbackup.p104v3.task;

import android.os.SystemClock;
import androidx.annotation.Keep;
import com.huawei.android.hicloud.cloudbackup.process.CacheTask;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupConditionsUtil;
import com.huawei.hicloud.bean.CPUOffloadSleepDuration;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import java.util.LinkedHashMap;
import p015ak.C0209d;
import p015ak.C0219i;
import p292fn.C9733f;
import p371ik.C10527a;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p529op.C11984f;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import pm.InterfaceC12198y;
import tj.C13019a;

@Keep
/* loaded from: classes6.dex */
public class BackupLoadController implements InterfaceC12198y {
    public static final long NO_NEED_TO_SLEEP_DURATION = -1;
    private static final String SLEEP_DURATION_FLAG = "sleepDuration is";
    private static final String TAG = "BackupLoadController";
    private volatile String conditionCheckResult;
    private volatile boolean isEnableCpuLoadReduction;
    private volatile boolean isHarmonyOsFour;
    private volatile long sleepDuration = -1;
    private volatile boolean conditionHasChecked = false;
    private volatile boolean lastCheckSatisfied = false;
    private volatile boolean isScreenOn = false;
    private final C4890a loadControlScreenListener = new C4890a();

    /* renamed from: com.huawei.hicloud.cloudbackup.v3.task.BackupLoadController$a */
    public class C4890a implements C11984f.d {
        public C4890a() {
        }

        @Override // p529op.C11984f.d
        public void onScreenOff() {
            C11839m.m70686d(BackupLoadController.TAG, "LoadControlScreenListener:screen is off");
            BackupLoadController.this.isScreenOn = false;
        }

        @Override // p529op.C11984f.d
        public void onScreenOn() {
            C11839m.m70686d(BackupLoadController.TAG, "LoadControlScreenListener:screen is on");
            BackupLoadController.this.isScreenOn = true;
        }

        @Override // p529op.C11984f.d
        public void onUserPresent() {
        }
    }

    public BackupLoadController() {
        C11839m.m70686d(TAG, "backupLoadController");
    }

    private boolean conditionSatisfy(CacheTask cacheTask) {
        if (!this.conditionHasChecked) {
            C11839m.m70688i(TAG, "first time to check condition.");
            this.isHarmonyOsFour = C0209d.m1253f1();
            this.isEnableCpuLoadReduction = C9733f.m60705z().m60720O("enableCPULoadReduction") || (C9733f.m60705z().m60720O("enableCPULoadReductionForBeta") && C0209d.m1193N0());
            this.isScreenOn = CloudBackupConditionsUtil.isScreenOn();
            this.conditionHasChecked = true;
        }
        if (!this.isHarmonyOsFour) {
            recordCheckResultWhenNotSatisfy("no need to loadControl:current OS is not harmonyOS 4.0 or later");
            return false;
        }
        if (!this.isEnableCpuLoadReduction) {
            recordCheckResultWhenNotSatisfy("no need to loadControl:cpuLoadReduction switch is closed");
            return false;
        }
        if (!isAutoBackup(cacheTask)) {
            recordCheckResultWhenNotSatisfy("no need to loadControl:isAutoBackup is false");
            return false;
        }
        if (!this.isScreenOn) {
            recordCheckResultWhenNotSatisfy("no need to loadControl:screen is off");
            return false;
        }
        if (C13019a.m78347n().m78350l() <= 0) {
            return true;
        }
        recordCheckResultWhenNotSatisfy("no need to loadControl:cloudDrive is running foreground");
        return false;
    }

    private boolean isAutoBackup(CacheTask cacheTask) {
        if (cacheTask instanceof C4879a) {
            return ((C4879a) cacheTask).isAutoBackup();
        }
        return false;
    }

    private void printLog(String str) {
        if (str == null || str.equals(this.conditionCheckResult)) {
            return;
        }
        this.conditionCheckResult = str;
        C11839m.m70688i(TAG, this.conditionCheckResult);
    }

    private void printNoNeedSleepLog(long j10) {
        if (this.conditionCheckResult == null || this.conditionCheckResult.contains(SLEEP_DURATION_FLAG)) {
            return;
        }
        printLog("sleepDuration is:" + j10 + ",no need to loadControl.");
    }

    private void recordCheckResultWhenNotSatisfy(String str) {
        if (str == null) {
            return;
        }
        printLog(str);
        if (this.lastCheckSatisfied) {
            reportLoadControl(str, -1L);
        }
    }

    private void reportLoadControl(String str, long j10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02313"), "backupLoadControlRecord", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        linkedHashMapM79497A.put("errorReason", str);
        linkedHashMapM79497A.put("sleepDuration", String.valueOf(j10));
        int iM1463a = C0219i.m1463a();
        linkedHashMapM79497A.put("EMUI_API_LEVEL", String.valueOf(iM1463a));
        C11839m.m70688i(TAG, "reportLoadControl,sleepDuration is:" + j10 + ",apiLevel is:" + iM1463a + ",checkResult:" + str);
        C13622a.m81971q(c11060cM66626a, linkedHashMapM79497A, false, true);
    }

    public long getSleepDuration() {
        if (this.sleepDuration > -1) {
            return this.sleepDuration;
        }
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            C11839m.m70688i(TAG, "hiCloudSysParamMap is null,return default sleep duration:200ms");
            this.sleepDuration = 200L;
            return this.sleepDuration;
        }
        String cpuOffloadSleepDuration = hiCloudSysParamMapM60757p.getCpuOffloadSleepDuration();
        CPUOffloadSleepDuration cPUOffloadSleepDuration = (CPUOffloadSleepDuration) C10527a.m64629g(cpuOffloadSleepDuration, CPUOffloadSleepDuration.class);
        this.sleepDuration = cPUOffloadSleepDuration != null ? cPUOffloadSleepDuration.getBackup() : 200L;
        printLog("cpuOffloadSleepDuration config is:" + cpuOffloadSleepDuration + ",backup sleepDuration is:" + this.sleepDuration + "ms");
        return this.sleepDuration;
    }

    @Override // pm.InterfaceC12198y
    public void loadControl(CacheTask cacheTask) {
        if (!this.conditionHasChecked) {
            C11984f.m72128c().m72129b(this.loadControlScreenListener);
        }
        if (!conditionSatisfy(cacheTask)) {
            this.lastCheckSatisfied = false;
            return;
        }
        long sleepDuration = getSleepDuration();
        if (sleepDuration <= 0) {
            printNoNeedSleepLog(sleepDuration);
            return;
        }
        if (!this.lastCheckSatisfied) {
            reportLoadControl("all condition satisfied", sleepDuration);
        }
        this.lastCheckSatisfied = true;
        SystemClock.sleep(sleepDuration);
    }

    @Override // pm.InterfaceC12198y
    public void onTaskFinish() {
        C11839m.m70688i(TAG, "backup task is finished,unregister screen broadcast");
        C11984f.m72128c().m72131e(this.loadControlScreenListener);
    }
}
