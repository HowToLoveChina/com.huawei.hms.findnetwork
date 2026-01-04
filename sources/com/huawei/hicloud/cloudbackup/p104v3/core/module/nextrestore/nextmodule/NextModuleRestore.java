package com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule;

import am.InterfaceC0275i1;
import android.content.Context;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.p018os.IBackupSessionCallback;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.process.util.AppDataSizeUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.connect.progress.ICallback;
import com.huawei.android.remotecontrol.tag.p092ui.view.RippleView;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4880b;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hms.network.embedded.C5863b6;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.util.ArrayList;
import p015ak.C0209d;
import p015ak.C0241z;
import p386j6.C10713c;
import p514o9.C11839m;
import p618rm.C12590s0;
import p847zk.C14316i;
import pl.C12164f;

/* loaded from: classes6.dex */
public abstract class NextModuleRestore {
    private static final String KEY_COUNT_LIST = "count_list";
    private static final String KEY_PERMIT = "permit";
    private static final String KEY_SOURCE = "sourceModule";
    private static final String KEY_URI_LIST = "uri_list";
    private static final String KEY_VERSION = "version";
    private static final Object LOCK = new Object();
    private static final int LOG_OUTPUT_TIME_INTERVAL = 2000;
    private static final int MAX_WAIT_COUNT = 20;
    private static final String METHOD_RECOVER_COMPLETE = "backup_recover_complete";
    private static final String METHOD_RECOVER_START = "backup_recover_start";
    private static final String NEXT_DATA_PATH = "/nextdata";
    private static final int NEXT_VERSION_CODE = 999;
    protected static final int NOT_NEED_RESTORE = 100;
    private static final long ONCE_WAIT_MILLISECOND = 500;
    protected static final String PREFIX_PATH_MAIN_USER = "/data/data/";
    protected static final String PREFIX_PATH_SUB_USER = "/data/user/";
    private static final int SLEEP_TIME = 100;
    private static final String TAG = "NextModuleRestore";
    private static final int WAIT_DATA_TIMEOUT = 3600000;
    protected Context mContext;
    private InterfaceC0275i1 mPmsCopyProgressCallback;
    protected ICallback mProgressCallback;
    protected CloudRestoreStatusV3 mRestoreStatus;
    protected C4880b mTask;
    private int mTaskId = -1;
    private int mSessionId = -1;
    private boolean mTaskIdFinish = false;
    private boolean mTaskIdException = false;
    private long mReceiveTime = 0;
    private long mLogStartTime = 0;
    private long mReceivedAppendData = 0;
    protected String mRestorePkgName = "";
    private final IBackupSessionCallback mSessionCallback = new IBackupSessionCallback.Stub() { // from class: com.huawei.hicloud.cloudbackup.v3.core.module.nextrestore.nextmodule.NextModuleRestore.1
        @Override // android.p018os.IBackupSessionCallback
        public void onTaskFileDescriptorCreated(int i10, int i11, long j10, long j11, ParcelFileDescriptor parcelFileDescriptor) {
            C11839m.m70688i(NextModuleRestore.TAG, "onTaskFileDescriptorCreated fileSize: " + j10 + " modifiedTime: " + j11);
        }

        @Override // android.p018os.IBackupSessionCallback
        public void onTaskStatusChanged(int i10, int i11, int i12, String str) {
            C11839m.m70686d(NextModuleRestore.TAG, "onTaskStatusChanged:sessionId = " + NextModuleRestore.this.mSessionId + "/" + i10 + ",taskId = " + NextModuleRestore.this.mTaskId + "/" + i11 + ",statusCode = " + i12 + ",appendData = " + str);
            if (NextModuleRestore.this.mSessionId == i10 || i11 == NextModuleRestore.this.mTaskId) {
                NextModuleRestore.this.mReceiveTime = System.currentTimeMillis();
                long jM1688f = C0241z.m1688f(str);
                if (i12 == 3 && jM1688f > NextModuleRestore.this.mReceivedAppendData) {
                    NextModuleRestore.this.mReceivedAppendData = jM1688f;
                }
                if (i12 != -1) {
                    if (i12 == 0) {
                        C11839m.m70688i(NextModuleRestore.TAG, "PMS copy file success.");
                        NextModuleRestore nextModuleRestore = NextModuleRestore.this;
                        nextModuleRestore.updatePmsProgress(String.valueOf(nextModuleRestore.mReceivedAppendData));
                        NextModuleRestore.this.mTaskIdFinish = true;
                        return;
                    }
                    if (i12 == 1) {
                        C11839m.m70688i(NextModuleRestore.TAG, "PMS copy file begin.");
                        NextModuleRestore nextModuleRestore2 = NextModuleRestore.this;
                        nextModuleRestore2.mLogStartTime = nextModuleRestore2.mReceiveTime;
                        NextModuleRestore.this.mReceivedAppendData = 0L;
                        return;
                    }
                    if (i12 != 2) {
                        if (i12 == 3 && NextModuleRestore.this.mReceiveTime - NextModuleRestore.this.mLogStartTime >= RippleView.SINGLE_RIPPLE_TIME) {
                            NextModuleRestore nextModuleRestore3 = NextModuleRestore.this;
                            nextModuleRestore3.mLogStartTime = nextModuleRestore3.mReceiveTime;
                            C11839m.m70688i(NextModuleRestore.TAG, "PMS running, statusCode: " + i12 + ";appendData: " + str);
                            NextModuleRestore.this.updatePmsProgress(str);
                            return;
                        }
                        return;
                    }
                }
                C11839m.m70688i(NextModuleRestore.TAG, "PMS copy file error, statusCode: " + i12);
                NextModuleRestore.this.mTaskIdFinish = true;
                NextModuleRestore.this.mTaskIdException = true;
            }
        }
    };

    public NextModuleRestore(Context context, C4880b c4880b, CloudRestoreStatusV3 cloudRestoreStatusV3) {
        this.mContext = context;
        this.mTask = c4880b;
        this.mRestoreStatus = cloudRestoreStatusV3;
    }

    private void checkLocalSpaceBeforePmsRestore(String str, int i10, C4880b c4880b) throws C9721b, NoSuchMethodException, ClassNotFoundException, SecurityException {
        C12164f c12164f = new C12164f(c4880b.getBackupId(), str, 1, i10);
        Long localLeftSpace = ICBUtil.getLocalLeftSpace();
        if (localLeftSpace != null) {
            long jM73076e0 = c12164f.m73076e0();
            long jM75856h0 = C12590s0.m75856h0();
            long packageSize = AppDataSizeUtil.getPackageSize(this.mContext, str, i10);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("pms restore size check appId: " + str);
            sb2.append(" ,packageSize: " + packageSize);
            sb2.append(" ,datasize: " + jM73076e0);
            sb2.append(" ,localRsize: " + jM75856h0);
            sb2.append(" ,leftSpace: " + localLeftSpace);
            C11839m.m70688i(TAG, sb2.toString());
            if (jM73076e0 + jM75856h0 <= localLeftSpace.longValue() + packageSize) {
                return;
            }
            throw new C9721b(1007, "pms restore size not enough  " + ((Object) sb2));
        }
    }

    private void endRestore() {
        C11839m.m70688i(TAG, "call provider restore complete");
        C2108a.m12616b(this.mContext, getBackupProviderUri(), METHOD_RECOVER_COMPLETE, null, null);
    }

    private int execute(String str) {
        int iExecuteCmd;
        synchronized (LOCK) {
            iExecuteCmd = executeCmd(str);
        }
        return iExecuteCmd;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x005a: MOVE (r2 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r3 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:12:0x005a */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int executeCmd(java.lang.String r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextModuleRestore.executeCmd(java.lang.String):int");
    }

    private void init() {
        this.mTaskIdFinish = false;
        this.mTaskIdException = false;
        this.mSessionId = -1;
        this.mTaskId = -1;
    }

    private boolean isAbort() throws InterruptedException {
        ICallback iCallback = this.mProgressCallback;
        if (iCallback != null && iCallback.onStop()) {
            C11839m.m70687e(TAG, "pmsBackup backup mProgressCallback is abort");
            return true;
        }
        try {
            C4880b c4880b = this.mTask;
            if (c4880b == null) {
                return false;
            }
            c4880b.isCancel();
            return false;
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "pmsBackup backup task is isAbort: " + e10.getMessage());
            return true;
        }
    }

    private boolean isInValid(int i10) {
        return i10 == -4 || i10 == -3 || i10 == -2 || i10 == -1;
    }

    private void pmsFailWaitBeforeRetry(C4880b c4880b) throws C9721b {
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (i10 >= 20) {
                return;
            }
            c4880b.isRelease();
            SystemClock.sleep(500L);
            i10 = i11;
        }
    }

    private int pmsRestore(String str) {
        return execute("restore " + CloudBackupConstant.Command.PMS_OPTION_DIR + " " + str + " " + getTargetPath());
    }

    private Bundle startRestore() {
        C11839m.m70688i(TAG, "call provider restore start: " + getBackupProviderUri() + "appId: " + getAppId());
        Bundle bundle = new Bundle();
        bundle.putInt("version", 999);
        bundle.putString(KEY_SOURCE, getAppId());
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        bundle.putStringArrayList(KEY_URI_LIST, arrayList);
        bundle.putIntegerArrayList(KEY_COUNT_LIST, arrayList2);
        return C2108a.m12616b(this.mContext, getBackupProviderUri(), METHOD_RECOVER_START, null, bundle);
    }

    private void syncLock() {
        this.mReceiveTime = System.currentTimeMillis();
        while (!this.mTaskIdFinish) {
            if (isAbort()) {
                C11839m.m70689w(TAG, "pms execute is abort");
                this.mTaskIdFinish = true;
                this.mTaskIdException = true;
                return;
            } else if (waitSleep()) {
                C11839m.m70689w(TAG, "pms execute time out");
                this.mTaskIdFinish = true;
                this.mTaskIdException = true;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePmsProgress(String str) {
        if (this.mPmsCopyProgressCallback == null) {
            return;
        }
        long jM1688f = C0241z.m1688f(str);
        if (jM1688f <= 0) {
            return;
        }
        this.mPmsCopyProgressCallback.mo1767a(jM1688f);
    }

    private boolean waitSleep() {
        SystemClock.sleep(100L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.mReceiveTime <= C5863b6.g.f26453g) {
            return false;
        }
        C11839m.m70687e(TAG, "Time = " + (jCurrentTimeMillis - this.mReceiveTime));
        return true;
    }

    public abstract String getApkModuleName();

    public String getAppId() {
        CloudRestoreStatusV3 cloudRestoreStatusV3 = this.mRestoreStatus;
        return cloudRestoreStatusV3 == null ? "" : cloudRestoreStatusV3.getAppId();
    }

    public abstract String getBackupProviderUri();

    public String getSrcPath() {
        return this.mTask.getLocation() + File.separator + getAppId();
    }

    public String getTargetPath() {
        if (this.mRestoreStatus.getUid() == 0) {
            return "/data/data/" + this.mRestorePkgName + NEXT_DATA_PATH;
        }
        return "/data/user/" + this.mRestorePkgName + File.separator + getAppId() + NEXT_DATA_PATH;
    }

    public int onRestore(C12164f c12164f) throws C9721b, NoSuchMethodException, ClassNotFoundException, SecurityException {
        C11839m.m70688i(TAG, "onRestore begin");
        if (this.mContext == null || this.mRestoreStatus == null || this.mTask == null) {
            C11839m.m70687e(TAG, "params error");
            return -1;
        }
        if (!PmsCheckUtil.m12611e()) {
            C11839m.m70688i(TAG, "not support pms restore");
            return -3;
        }
        if (C0209d.m1269j1()) {
            C11839m.m70688i(TAG, "not support honor");
            return -5;
        }
        this.mRestorePkgName = getApkModuleName();
        int iRestoreSandBoxFiles = restoreSandBoxFiles();
        if (iRestoreSandBoxFiles == 100) {
            return 0;
        }
        if (iRestoreSandBoxFiles != 0) {
            return iRestoreSandBoxFiles;
        }
        try {
            C11839m.m70688i(TAG, "apply power kit apply:" + this.mRestorePkgName);
            C14316i.m85291e().m85293b(this.mRestorePkgName, "user-cloudBackupClone_apply");
            Bundle bundleStartRestore = startRestore();
            if (bundleStartRestore != null) {
                C11839m.m70687e(TAG, "notify app recover start: " + C10713c.m65391a(bundleStartRestore, KEY_PERMIT));
            }
            endRestore();
            C11839m.m70688i(TAG, "release power kit apply:" + this.mRestorePkgName);
            C14316i.m85291e().m85298h(this.mRestorePkgName, "user-cloudBackupClone_apply");
            return iRestoreSandBoxFiles;
        } catch (Throwable th2) {
            C11839m.m70688i(TAG, "release power kit apply:" + this.mRestorePkgName);
            C14316i.m85291e().m85298h(this.mRestorePkgName, "user-cloudBackupClone_apply");
            throw th2;
        }
    }

    public void registerPmsRestoreStatus(InterfaceC0275i1 interfaceC0275i1) {
        this.mPmsCopyProgressCallback = interfaceC0275i1;
    }

    public int restoreSandBoxFiles() throws C9721b, NoSuchMethodException, ClassNotFoundException, SecurityException {
        C11839m.m70688i(TAG, "restoreSandBoxFiles begin");
        if (!C10278a.m63442h(this.mTask.getLocation() + File.separator + getAppId() + NEXT_DATA_PATH).exists()) {
            C11839m.m70688i(TAG, "no nextdata, success.");
            return 0;
        }
        int uid = this.mRestoreStatus.getUid();
        if (TextUtils.isEmpty(this.mTask.getLocation())) {
            C11839m.m70687e(TAG, "pmsRestore mLocation is empty");
            return -1;
        }
        checkLocalSpaceBeforePmsRestore(getAppId(), uid, this.mTask);
        int iPmsRestore = pmsRestore(getSrcPath());
        if (iPmsRestore == 0) {
            return iPmsRestore;
        }
        this.mTask.isRelease();
        pmsFailWaitBeforeRetry(this.mTask);
        int iPmsRestore2 = pmsRestore(getSrcPath());
        C11839m.m70688i(TAG, "pms restore data retry: " + getAppId() + " uid: " + uid + " result: " + iPmsRestore2);
        return iPmsRestore2;
    }
}
