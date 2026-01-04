package com.huawei.android.hicloud.cloudbackup.process;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.jobscheduler.CloudBackupJobManager;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupTaskManager;
import com.huawei.android.hicloud.cloudbackup.process.CacheTask;
import com.huawei.android.hicloud.cloudbackup.process.clone.ClonePowerKit;
import com.huawei.android.hicloud.cloudbackup.process.task.DeleteRecordsTask;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeManagementService;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupStateUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.frequency.FrequencyManager;
import com.huawei.hicloud.notification.util.CheckAppStatus;
import com.huawei.hicloud.request.opengw.bean.Result;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import je.C10782d;
import mk.C11476b;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0221j;
import p015ak.C0224k0;
import p020ap.C1009d;
import p292fn.C9733f;
import p336he.C10153d;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11829c;
import p514o9.C11835i;
import p514o9.C11839m;
import p572qb.C12299b;
import p606r9.C12478a;
import p616rk.C12515a;
import p617rl.C12526j;
import p618rm.C12565k;
import p618rm.C12571m;
import p652t9.EnumC12999a;
import p682ul.C13216j;
import p684un.C13225d;
import p709vj.C13452e;
import p711vl.C13466f;
import p744wl.C13617a;
import p746wn.C13622a;
import p847zk.C14317j;
import tl.C13029h;

/* loaded from: classes2.dex */
public abstract class ICBBaseTask extends CacheTask {
    protected static final Object LOCK = new Object();
    private static final String TAG = "ICBBaseTask";
    private AutoBackupKeepTimer autoBackupKeepTimer;
    protected String backupId;
    protected int backupType;
    protected String dataLocation;
    protected String deviceId;
    protected int deviceType;
    protected String galleryDB;
    protected String installAppPath;
    protected boolean isBackup;
    protected String location;
    private CBLockTimer lockTimer;
    private PowerManager.WakeLock mWakeLock;
    private boolean mkfileLgrScrPwr;
    protected String serverPath;
    protected SnapshotTreeManagementService snapshotTreeService;
    protected String traceID;
    protected List<String> defaultModules = new ArrayList();
    protected CloneService cloneService = CloneService.getInstance();
    protected ProgressCallback progressCallback = new ProgressCallback();
    protected String current = "";
    protected String currentAppName = "";
    protected boolean manualAbort = false;
    protected boolean isSuccess = false;
    protected boolean isGoogleGmsInstalled = true;
    protected List<String> clientActionList = null;
    private ICBBaseReceiver mObserverReceiver = null;
    protected String powerKitApplyType = "user-cloudBackup_apply";

    /* renamed from: com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask$1 */
    public static /* synthetic */ class C25041 {

        /* renamed from: $SwitchMap$com$huawei$android$hicloud$cloudbackup$process$CacheTask$State */
        static final /* synthetic */ int[] f11683xde96b013;

        static {
            int[] iArr = new int[CacheTask.State.values().length];
            f11683xde96b013 = iArr;
            try {
                iArr[CacheTask.State.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11683xde96b013[CacheTask.State.UPDATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11683xde96b013[CacheTask.State.DONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ICBBaseTask(String str, int i10) {
        this.deviceId = str;
        this.deviceType = i10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(CacheTask.isEncrypt() ? "" : "/Backup");
        sb2.append("/CloudBackup/");
        sb2.append(C11476b.m68626h(str));
        sb2.append("/");
        this.serverPath = sb2.toString();
        C0221j.m1478F(CacheTask.getContext());
        this.installAppPath = ICBUtil.getHwCloudApkInstallCachePath();
        this.location = getLocation();
        this.dataLocation = this.location + File.separator + "data";
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.location);
        sb3.append("/gallery/gallery.db");
        this.galleryDB = sb3.toString();
        this.snapshotTreeService = SnapshotTreeManagementService.getInstance();
        this.isBackup = this instanceof CloudBackupTask;
    }

    private void cleanCloneCache() {
        if (C12565k.m75529o()) {
            ScanAppDataUtil.executePmsMoveProcess(C0213f.m1377a().getFilesDir() + "/app_medaicache");
            ScanAppDataUtil.executePmsMoveProcess(C0213f.m1377a().getFilesDir() + "/mediacache");
        }
    }

    public static boolean isGoogleGmsInstalled() throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        try {
            packageInfo = CacheTask.getContext().getPackageManager().getPackageInfo(Constants.GMS_PGK, 16384);
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            packageInfo = null;
        }
        boolean z10 = (packageInfo == null || TextUtils.isEmpty(C0224k0.a.m1573b("ro.com.google.gmsversion", ""))) ? false : true;
        C11839m.m70688i(TAG, "isGoogleGmsInstalled, isInstall: " + z10);
        return z10;
    }

    public void processBatteryChanged(Intent intent) {
        C11839m.m70688i(TAG, "process Battery Changed");
        if (intent == null) {
            return;
        }
        int intExtra = 0;
        try {
            intExtra = intent.getIntExtra(FaqConstants.FAQ_LEVEL, 0);
        } catch (RuntimeException unused) {
            C11839m.m70688i(TAG, "intent Serializable error.");
        }
        C10153d.m63243g(intExtra);
        int intExtra2 = 1;
        try {
            intExtra2 = intent.getIntExtra("status", 1);
        } catch (RuntimeException unused2) {
            C11839m.m70688i(TAG, "intent Serializable error.");
        }
        C11839m.m70688i(TAG, "batteryStatus: " + intExtra2);
        if (intExtra2 == 2 || intExtra2 == 5) {
            return;
        }
        if (!(this instanceof CloudRestoreTask)) {
            if (intExtra < 10) {
                C11839m.m70689w(TAG, "battery level lower than 10%");
                processBatteryNotEnough();
                return;
            }
            return;
        }
        int pauseBattery = new C12526j().m75325A0().getPauseBattery();
        if (intExtra < pauseBattery) {
            C11839m.m70689w(TAG, "battery level lower than batteryLevel: " + intExtra + " pauseBattery" + pauseBattery);
            processBatteryNotEnough();
        }
    }

    private void registerObserverReceiver() {
        this.mObserverReceiver = new ICBBaseReceiver(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        CacheTask.getContext().registerReceiver(this.mObserverReceiver, intentFilter);
        registerV2AutoRestore(C11829c.m70611r0(), true);
    }

    private void unRegisterObserverReceiver() {
        if (this.mObserverReceiver != null) {
            CacheTask.getContext().unregisterReceiver(this.mObserverReceiver);
            this.mObserverReceiver = null;
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.CacheTask, p581qk.AbstractC12365b
    public void abort() {
        super.abort();
        executeAsyncTask(new CacheTask.AsyncTask(new CacheTask.IAsyncTask() { // from class: com.huawei.android.hicloud.cloudbackup.process.r0
            @Override // com.huawei.android.hicloud.cloudbackup.process.CacheTask.IAsyncTask
            public final void run() {
                this.f11707a.release();
            }
        }));
    }

    public boolean abortRequired() {
        int i10 = C25041.f11683xde96b013[getState().ordinal()];
        return ((i10 == 1 || i10 == 2 || i10 == 3) && this.mkfileLgrScrPwr) ? false : true;
    }

    public void addEntryType(LinkedHashMap<String, String> linkedHashMap) {
    }

    public void autoBackupKeepLock() {
        this.autoBackupKeepTimer = null;
        this.autoBackupKeepTimer = new AutoBackupKeepTimer();
        C12515a.m75110o().m75172d(this.autoBackupKeepTimer);
    }

    public void autoBackupKeepUnLock() {
        AutoBackupKeepTimer autoBackupKeepTimer = this.autoBackupKeepTimer;
        if (autoBackupKeepTimer != null) {
            autoBackupKeepTimer.cancel();
            this.autoBackupKeepTimer = null;
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            C11839m.m70688i(TAG, "task start.");
            if (this instanceof CloudBackupTask) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("doBackupTime", Long.valueOf(System.currentTimeMillis()));
                C12299b.m73937s(contentValues);
                autoBackupKeepLock();
            }
            isCancel();
            setState(CacheTask.State.PREPARE);
            init();
            isCancel();
            onPrepare();
            isCancel();
            setState(CacheTask.State.RUN);
            onStart();
            reportEachStageTime(jCurrentTimeMillis, System.currentTimeMillis(), "Prepare data");
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            isCancel();
            onOperate();
            isCancel();
            setState(CacheTask.State.CREATED);
            onPostFix();
            setState(CacheTask.State.UPDATED);
            reportEachStageTime(jCurrentTimeMillis2, System.currentTimeMillis(), "Operate cloudbackup");
            this.isSuccess = true;
            C11839m.m70688i(TAG, "task end.");
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.CacheTask, p581qk.AbstractC12365b
    public void callback(Message message) {
        BackupPowerKitKeepTimer.getInstance().keepAlive(this.powerKitApplyType);
        super.callback(message);
    }

    public void cancelOldLockTimer() {
        CBLockTimer cBLockTimer = this.lockTimer;
        if (cBLockTimer != null) {
            cBLockTimer.cancelTimer();
            this.lockTimer = null;
        }
    }

    public void closeWakeLock() {
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock == null || !wakeLock.isHeld()) {
            return;
        }
        this.mWakeLock.release();
        C11839m.m70688i(TAG, "cloudbackup wakelock release.");
    }

    public void downloadSnapshotDb(String str, String str2) throws C9721b {
        C12478a c12478a = new C12478a(EnumC12999a.CLOUD_BACKUP, this.traceID);
        String parent = C0213f.m1378b().getDatabasePath(str2).getParent();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.location);
        String str3 = File.separator;
        sb2.append(str3);
        sb2.append(str2);
        String string = sb2.toString();
        File fileM63442h = C10278a.m63442h(string);
        if (fileM63442h.exists() && !fileM63442h.delete()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadSnapshotDb tempFile delete file error");
        }
        c12478a.m74913i(str, string, this.progressCallback);
        File fileM63442h2 = C10278a.m63442h(parent + str3 + str2);
        if (fileM63442h2.exists() && !fileM63442h2.delete()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadSnapshot delete file error");
        }
        if (!C11835i.m70654r(fileM63442h, fileM63442h2)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadSnapshot snapFile rename error");
        }
    }

    public void executeDeleteRecordsTask(int i10, ProgressCallback progressCallback, boolean z10) {
        if (C13466f.m81073d().m81075b("isStartDeleteTask", false)) {
            C12515a.m75110o().m75172d(new DeleteRecordsTask(this.deviceId, this.backupId, this.deviceType, i10, this.traceID, progressCallback, z10));
            C13466f.m81073d().m81081i("isStartDeleteTask", false);
        }
    }

    public String getCurrent() {
        return this.current;
    }

    public String getDataCacheTempDir(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.dataLocation);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("cache");
        sb2.append(str2);
        sb2.append(str);
        return sb2.toString();
    }

    public String getDataTempDir(String str) {
        return this.dataLocation + File.separator + str;
    }

    public Map<String, String> getExpandInfo(String str) {
        HashMap map = new HashMap();
        for (String str2 : str.split("&")) {
            String[] strArrSplit = str2.split("=");
            if (strArrSplit.length == 2) {
                map.put(strArrSplit[0], strArrSplit[1]);
            }
        }
        return map;
    }

    public boolean getFullBackupInfo() throws C9721b {
        C11839m.m70688i(TAG, "start getFullBackupInfo ");
        CBLockTimer cBLockTimer = this.lockTimer;
        if (cBLockTimer == null) {
            return false;
        }
        List<String> clientActionList = cBLockTimer.getClientActionList();
        this.clientActionList = clientActionList;
        if (clientActionList == null || clientActionList.isEmpty() || !this.clientActionList.contains("1")) {
            return false;
        }
        C11839m.m70688i(TAG, "getFullBackupInfo clientActionList " + this.clientActionList.toString());
        C13617a.m81920b(true, true);
        return true;
    }

    public abstract String getLocation();

    public void init() throws Throwable {
        C11839m.m70688i(TAG, "task init begin.");
        BackupPowerKitKeepTimer.getInstance().keepAlive(this.powerKitApplyType);
        ClonePowerKit.getInstance().init();
        C10782d.m65634a().m65641h(C9733f.m60705z().m60717L());
        isDataResetFinished();
        new CheckAppStatus().checkAll();
        initTempDirs();
        C13216j.m79421f();
        CloudBackupTaskManager.getInstance().setMaxFileTaskSize(0);
        this.mkfileLgrScrPwr = new C12526j().m75394h0();
        C12565k.m75521g();
        C12565k.m75522h();
        C12565k.m75520f();
        C12565k.m75519e();
        C12565k.m75524j();
        cleanCloneCache();
        this.isGoogleGmsInstalled = isGoogleGmsInstalled();
        ICBUtil.dealDefaultMoudles(this.defaultModules);
        registThermalCallback();
        registerObserverReceiver();
        C11839m.m70688i(TAG, "task init end.");
    }

    public Set<String> initCompares(String str) {
        HashSet hashSet = new HashSet();
        File fileM63442h = C10278a.m63442h(this.location + File.separator + str);
        hashSet.add(fileM63442h.getAbsolutePath());
        hashSet.add(C10279b.m63452a(fileM63442h));
        File fileM63442h2 = C10278a.m63442h(getDataTempDir(str));
        hashSet.add(fileM63442h2.getAbsolutePath());
        hashSet.add(C10279b.m63452a(fileM63442h2));
        String strM1513w = C0221j.m1513w();
        if (!TextUtils.isEmpty(strM1513w)) {
            hashSet.add(strM1513w);
        }
        String strM1512v = C0221j.m1512v();
        if (!TextUtils.isEmpty(strM1512v)) {
            hashSet.add(strM1512v);
        }
        String strM1473A = C0221j.m1473A();
        if (!TextUtils.isEmpty(strM1473A)) {
            hashSet.add(strM1473A);
        }
        return hashSet;
    }

    public void initTempDirs() throws C9721b {
        File fileM63442h = C10278a.m63442h(this.location);
        if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
            C11839m.m70687e(TAG, "process file init error.");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "process file init error.");
        }
        C12571m.m75543e(this.location);
        File fileM63442h2 = C10278a.m63442h(this.installAppPath);
        if (fileM63442h2.exists() || fileM63442h2.mkdirs()) {
            return;
        }
        C11839m.m70687e(TAG, "process apkPathDir init error.");
        throw new C9721b(FamilyShareConstants.StatusCode.USER_JOIN_IS_FROZEN, "process apkPathDir init error.");
    }

    public void isDataResetFinished() throws C9721b {
        if (C1009d.m6109e().m6115g() != 0) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "client reset data ,not finish.");
        }
    }

    public void lock() {
        this.lockTimer = null;
        this.lockTimer = new CBLockTimer(this.deviceId, this.traceID, this.deviceType, this.powerKitApplyType);
        C12515a.m75110o().m75172d(this.lockTimer);
    }

    public abstract boolean noAbortCondition(int i10);

    public abstract void onClose();

    public abstract void onOperate() throws C9721b;

    public abstract void onPostFix() throws C9721b;

    public abstract void onPrepare() throws C9721b;

    public abstract void onStart() throws C9721b;

    public void openWakeLock() {
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) CacheTask.getContext().getSystemService("power")).newWakeLock(1, "CloudBackup");
        this.mWakeLock = wakeLockNewWakeLock;
        wakeLockNewWakeLock.acquire();
        C11839m.m70688i(TAG, "cloudbackup wakelock acquire.");
    }

    @Override // com.huawei.android.hicloud.cloudbackup.process.CacheTask, p581qk.AbstractC12365b
    public void pause() {
        super.pause();
        this.progressCallback.pause();
    }

    public abstract void processBatteryNotEnough();

    public void processNetworkChanged(Context context, Handler handler) {
        C11839m.m70688i(TAG, "process net changed");
        if (C0209d.m1333z1(context)) {
            return;
        }
        C11839m.m70688i(TAG, "send abort delayed and do pause.");
        pause();
        C11839m.m70688i(TAG, "send  delayed and do pause CMD_TYPE_CBABORT_WIFI.");
        handler.sendEmptyMessageDelayed(3202, 10000L);
    }

    public abstract void processPowerDisconnect(HiCloudSafeIntent hiCloudSafeIntent);

    public abstract void processScreenOff(Intent intent, Handler handler);

    public abstract void processUserPresent(Intent intent, Handler handler);

    public void registThermalCallback() {
    }

    public void registerV2AutoRestore(boolean z10, boolean z11) {
    }

    @Override // p581qk.AbstractC12365b, p616rk.AbstractRunnableC12516b
    public void release() {
        synchronized (this) {
            try {
                CacheTask.State state = CacheTask.State.DONE;
                if (state.equals(getState())) {
                    C11839m.m70688i(TAG, "task already released.");
                    return;
                }
                setState(state);
                C11839m.m70688i(TAG, "task released start.");
                this.progressCallback.abort();
                onClose();
                unRegisterObserverReceiver();
                unRegistThermalCallback();
                reportEvent();
                closeWakeLock();
                unNewLock();
                unLock();
                this.cloneService.unBindService();
                CBAccess.removeTask(this);
                C14317j.m85300d().m85320u(false, (this.isBackup && this.isSuccess) ? 1 : 0);
                autoBackupKeepUnLock();
                ContentValues contentValues = new ContentValues();
                contentValues.put("doBackupTime", (Long) 0L);
                C12299b.m73937s(contentValues);
                if (!C11829c.m70611r0()) {
                    C11839m.m70688i(TAG, "ds is start not sticky, errorCode: " + getErrCode());
                    if (1005 == getErrCode()) {
                        CloudBackupJobManager.getInstance().unRegisterPowerConnectScheduler();
                        CloudBackupJobManager.getInstance().registerPowerConnectScheduler(true, 0L);
                    } else {
                        CloudBackupJobManager.getInstance().unRegisterBackupScheduler();
                        CloudBackupJobManager.getInstance().registerBackupScheduler(0L, true, 0, 0, null);
                    }
                }
                BackupPowerKitKeepTimer.getInstance().remove(this.powerKitApplyType);
                ClonePowerKit.getInstance().release();
                if ((this instanceof CloudBackupTask) && this.isSuccess) {
                    executeDeleteRecordsTask(this.backupType, null, true);
                }
                C11839m.m70688i(TAG, "task released success.");
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public abstract void reportEachStageTime(long j10, long j11, String str);

    public void reportEachTask(C13029h c13029h, String str, String str2) {
        LinkedHashMap<String, String> linkedHashMap;
        C11839m.m70686d(TAG, "report each period");
        linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("traceId", c13029h.m78444J());
        linkedHashMap.put("backupId", c13029h.m78465h());
        linkedHashMap.put("id", c13029h.m78436B());
        linkedHashMap.put("backupVersion", "V2");
        addEntryType(linkedHashMap);
        str.hashCode();
        switch (str) {
            case "cloudbackup_total_size":
            case "restore_total_size":
                C11839m.m70686d(TAG, "report total size");
                linkedHashMap.put("totalSize", str2);
                linkedHashMap.put("isSuccess", String.valueOf(this.isSuccess));
                linkedHashMap.put("code", c13029h.m78474q());
                linkedHashMap.put("errMsg", this.errMsg);
                break;
            case "restore_each_size":
            case "cloudbackup_each_backup_size":
                C11839m.m70686d(TAG, "report each backup or restore datasize. ");
                linkedHashMap.put("data_size", str2);
                break;
            case "restore_each_period":
            case "cloudbackup_each_period":
                C11839m.m70686d(TAG, "report each period. ");
                linkedHashMap.put("startTime", String.valueOf(c13029h.m78440F()));
                linkedHashMap.put(FrequencyManager.H5DialogConstant.BEGIN_TIME, String.valueOf(c13029h.m78469k()));
                linkedHashMap.put("endTime", String.valueOf(c13029h.m78464f()));
                break;
        }
        if (!TextUtils.equals("cloudbackup_each_period", str) && !TextUtils.equals("restore_each_period", str)) {
            linkedHashMap.put("is_system_retread", String.valueOf(CloudBackupStateUtil.isFromSystemRetreadTask(1, this.backupId)));
        }
        C13225d.m79490f1().m79603z0(str, linkedHashMap);
    }

    public abstract void reportEvent();

    public void reportInterruptOrAuto(C13029h c13029h, String str) {
        LinkedHashMap<String, String> linkedHashMap;
        C11839m.m70686d(TAG, "report interrupt status");
        linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("traceId", c13029h.m78444J());
        linkedHashMap.put("backupId", c13029h.m78465h());
        linkedHashMap.put("id", c13029h.m78436B());
        addEntryType(linkedHashMap);
        str.hashCode();
        switch (str) {
            case "cloudbackup_auto_times":
                C11839m.m70686d(TAG, "report autobackup times");
                linkedHashMap.put("count", String.valueOf(c13029h.m78476r()));
                break;
            case "restore_interrupt_times":
                C11839m.m70686d(TAG, "report interrupt times");
                linkedHashMap.put("times", "1");
                linkedHashMap.put("is_system_retread", String.valueOf(CloudBackupStateUtil.isFromSystemRetreadTask(1, this.backupId)));
                break;
            case "restore_interrupt_report":
                C11839m.m70686d(TAG, "report interrupt details");
                linkedHashMap.put("reason", c13029h.m78474q());
                linkedHashMap.put(FrequencyManager.H5DialogConstant.BEGIN_TIME, String.valueOf(c13029h.m78469k()));
                linkedHashMap.put("endTime", String.valueOf(c13029h.m78464f()));
                linkedHashMap.put("is_system_retread", String.valueOf(CloudBackupStateUtil.isFromSystemRetreadTask(1, this.backupId)));
                break;
        }
        C13225d.m79490f1().m79603z0(str, linkedHashMap);
    }

    public void reportQuerySingleRecord(String str) {
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02006"), "querySingleRecordDetail", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66666v("isSuccess", "0", "1", "query one backup record detail, backupId: " + str);
        C13622a.m81968n(CacheTask.getContext(), c11060cM66626a);
    }

    public void reportVFSGetattrFail(List<Result.ErrMsg> list) throws C9721b {
        C11839m.m70688i(TAG, "report getattr fail file");
        int i10 = 0;
        for (Result.ErrMsg errMsg : list) {
            C11839m.m70689w(TAG, "getattr fail file err: " + errMsg.toString());
            if (errMsg.getErrCode() != 103) {
                throw new C9721b(3207, errMsg.getErrCode(), errMsg.getErrMsg());
            }
            i10++;
        }
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02009"), "restoreFileExits", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66666v("isSuccess", "0", "1", "query vfs failed, file path is not exits, count: " + i10);
        C13622a.m81968n(CacheTask.getContext(), c11060cM66626a);
    }

    public abstract void taskErrorEnd();

    public void unLock() {
        CBLockTimer cBLockTimer = this.lockTimer;
        if (cBLockTimer != null) {
            cBLockTimer.cancel();
            this.lockTimer = null;
        }
    }

    public void unNewLock() {
    }

    public void unRegistThermalCallback() {
    }

    public void waitForCountDownLatch(CountDownLatch countDownLatch) throws InterruptedException, C9721b {
        isCancel();
        if (countDownLatch == null) {
            return;
        }
        boolean z10 = this.exception != null;
        boolean zIsAbort = isAbort();
        while (countDownLatch.getCount() > 0 && !zIsAbort && !z10) {
            SystemClock.sleep(500L);
            zIsAbort = isAbort();
            z10 = this.exception != null;
        }
        isCancel();
    }

    public class ICBBaseReceiver extends BroadcastReceiver {
        private static final String TAG = "ICBBaseReceiver";
        private Handler handler;

        /* renamed from: com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask$ICBBaseReceiver$1 */
        public class HandlerC25051 extends Handler {
            public HandlerC25051(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                C11839m.m70688i(ICBBaseReceiver.TAG, "mCloudBackupHandler get message");
                int i10 = message.what;
                if (i10 == 3202) {
                    if (C0209d.m1254f2(C0213f.m1377a())) {
                        return;
                    }
                    C11839m.m70688i(ICBBaseReceiver.TAG, "net disable");
                    ICBBaseTask.this.abort(1002);
                    return;
                }
                if (i10 != 3204) {
                    return;
                }
                if (ICBBaseTask.this.abortRequired()) {
                    ICBBaseTask.this.abort(1006);
                }
                C11839m.m70688i(ICBBaseReceiver.TAG, "handleMessage USER_PRESENT.");
            }
        }

        private ICBBaseReceiver() {
            this.handler = new Handler(Looper.getMainLooper()) { // from class: com.huawei.android.hicloud.cloudbackup.process.ICBBaseTask.ICBBaseReceiver.1
                public HandlerC25051(Looper looper) {
                    super(looper);
                }

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    C11839m.m70688i(ICBBaseReceiver.TAG, "mCloudBackupHandler get message");
                    int i10 = message.what;
                    if (i10 == 3202) {
                        if (C0209d.m1254f2(C0213f.m1377a())) {
                            return;
                        }
                        C11839m.m70688i(ICBBaseReceiver.TAG, "net disable");
                        ICBBaseTask.this.abort(1002);
                        return;
                    }
                    if (i10 != 3204) {
                        return;
                    }
                    if (ICBBaseTask.this.abortRequired()) {
                        ICBBaseTask.this.abort(1006);
                    }
                    C11839m.m70688i(ICBBaseReceiver.TAG, "handleMessage USER_PRESENT.");
                }
            };
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C11839m.m70689w(TAG, "intent is empty");
                return;
            }
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            String action = hiCloudSafeIntent.getAction();
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                C11839m.m70688i(TAG, "action connectivity change");
                ICBBaseTask.this.processNetworkChanged(context, this.handler);
                return;
            }
            if ("android.intent.action.BATTERY_CHANGED".equals(action)) {
                C11839m.m70688i(TAG, "action battery change");
                ICBBaseTask.this.processBatteryChanged(hiCloudSafeIntent);
                return;
            }
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                C11839m.m70688i(TAG, "action screen off.");
                ICBBaseTask.this.processScreenOff(hiCloudSafeIntent, this.handler);
            } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                C11839m.m70688i(TAG, "action user present");
                ICBBaseTask.this.processUserPresent(hiCloudSafeIntent, this.handler);
            } else if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
                C11839m.m70688i(TAG, "action power disconnect");
                ICBBaseTask.this.processPowerDisconnect(hiCloudSafeIntent);
            }
        }

        public /* synthetic */ ICBBaseReceiver(ICBBaseTask iCBBaseTask, C25041 c25041) {
            this();
        }
    }

    public void abort(int i10) {
        abort(i10, null);
    }

    public void abort(int i10, String str) {
        if (noAbortCondition(i10)) {
            C11839m.m70688i(TAG, "abort condition not match: " + i10);
            return;
        }
        C11839m.m70688i(TAG, "abortCode = " + i10 + ", cmd = " + str);
        if (1001 == i10) {
            this.manualAbort = true;
        }
        setErrCode(i10, str);
        abort();
    }
}
