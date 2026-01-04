package com.huawei.android.hicloud.cloudbackup.process.task;

import android.content.Context;
import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.android.backup.filelogic.utils.PmsCheckUtil;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupFileTask;
import com.huawei.android.hicloud.cloudbackup.p076db.temp.AlbumsTempScript;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.android.hicloud.cloudbackup.restore.CloudRestoreClient;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeManagementService;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeUtil;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.connect.progress.ICallback;
import com.huawei.android.hicloud.p081cs.bean.UploadReq;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import p015ak.C0213f;
import p015ak.C0241z;
import p514o9.C11835i;
import p514o9.C11839m;
import p606r9.C12478a;
import p618rm.C12583q;
import p618rm.C12586r;
import p618rm.C12590s0;
import p652t9.EnumC12999a;

/* loaded from: classes2.dex */
public class UploadTask extends CloudBackupFileTask {
    private static final String TAG = "UploadTask";
    private String appId;
    private String backupRecordId;
    private ICallback callback;
    private boolean isFullBackup;
    private String lastSuccessBackupId;
    private String location;
    private String mNsserverpath;
    private SnapshotBackupMeta records;
    private SnapshotTreeManagementService snapshotTreeService;
    private ICBTaskCallback taskCallback;
    private String traceId;

    public UploadTask(ICBTaskCallback iCBTaskCallback, SnapshotBackupMeta snapshotBackupMeta, ProgressCallback progressCallback, String str, String str2, String str3, String str4, String str5, String str6, boolean z10) {
        super(str4, 0);
        this.taskCallback = iCBTaskCallback;
        this.records = snapshotBackupMeta;
        this.traceId = str;
        this.callback = progressCallback;
        this.location = str2;
        this.mNsserverpath = str3;
        this.appId = str4;
        this.backupRecordId = str5;
        this.lastSuccessBackupId = str6;
        this.snapshotTreeService = SnapshotTreeManagementService.getInstance();
        this.isFullBackup = z10;
    }

    private void appUpload(String str) throws C9721b, SQLException {
        String strValue = CloudRestoreClient.value(CloudRestoreClient.params(this.records.getExtend()), SnapshotBackupMeta.KEY_STRING_APP_VERSION_CODE);
        int iIntValue = 0;
        Object[] objArrAppUpload = appUpload(str, this.appId, strValue, 0);
        if (objArrAppUpload.length >= 1) {
            this.records.setAppSlice((String) objArrAppUpload[0]);
            if (objArrAppUpload.length >= 2) {
                iIntValue = ((Integer) objArrAppUpload[1]).intValue();
            }
        }
        long j10 = iIntValue;
        this.records.setAppType(j10);
        SnapshotBackupMeta snapshotBackupMetaQueryAppIconFile = this.snapshotTreeService.queryAppIconFile(this.appId, this.backupRecordId);
        if (snapshotBackupMetaQueryAppIconFile != null) {
            snapshotBackupMetaQueryAppIconFile.setAppType(j10);
            SnapshotTreeUtil.setMetaHashInfo(C10278a.m63442h(ICBUtil.convertToAbsolutePath(snapshotBackupMetaQueryAppIconFile.getRoot() + snapshotBackupMetaQueryAppIconFile.getData(), this.location)), snapshotBackupMetaQueryAppIconFile, this.location);
        }
        if (iIntValue != C0241z.m1685c("3")) {
            uploadUnstandApk(str);
            uploadUnstandIcon(str, snapshotBackupMetaQueryAppIconFile, strValue);
            return;
        }
        this.records.setStatus(-4);
        this.snapshotTreeService.updateLeafNodeInfo(this.appId, -4L, this.records.getAppSlice(), iIntValue, this.records.getExtend(), this.records.getHash1(), this.records.getHash2(), this.records.getCloudHash(), this.records.getCloudPath(), this.records.getData(), this.records.getRoot(), this.backupRecordId);
        uploadStandIcon(str, snapshotBackupMetaQueryAppIconFile, strValue);
        if (snapshotBackupMetaQueryAppIconFile != null) {
            snapshotBackupMetaQueryAppIconFile.setStatus(-4);
            this.snapshotTreeService.updateLeafNodeInfo(this.appId, -4L, snapshotBackupMetaQueryAppIconFile.getAppSlice(), iIntValue, snapshotBackupMetaQueryAppIconFile.getExtend(), snapshotBackupMetaQueryAppIconFile.getHash1(), snapshotBackupMetaQueryAppIconFile.getHash2(), snapshotBackupMetaQueryAppIconFile.getCloudHash(), snapshotBackupMetaQueryAppIconFile.getCloudPath(), snapshotBackupMetaQueryAppIconFile.getData(), snapshotBackupMetaQueryAppIconFile.getRoot(), this.backupRecordId);
        }
    }

    private void checkAPKIsExistOrNot(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70689w(TAG, "check APK file, path is empty.");
        } else {
            if (C10278a.m63442h(str).exists()) {
                return;
            }
            C11839m.m70689w(TAG, "check APK file is not exist, path = " + str);
        }
    }

    private void commonUpload(String str, SnapshotBackupMeta snapshotBackupMeta) throws C9721b, SQLException {
        if (snapshotBackupMeta == null || str == null) {
            return;
        }
        UploadReq uploadReq = new UploadReq();
        uploadReq.setFile(C10278a.m63442h(str));
        uploadReq.setKeyType(1);
        uploadReq.setServer(setServerPath(snapshotBackupMeta));
        uploadReq.setCallback(this.callback);
        new C12478a(EnumC12999a.CLOUD_BACKUP, this.traceId).m74909e(uploadReq);
        this.snapshotTreeService.updateLeafNodeInfo(this.appId, -4L, snapshotBackupMeta.getAppSlice(), (int) snapshotBackupMeta.getAppType(), snapshotBackupMeta.getExtend(), snapshotBackupMeta.getHash1(), snapshotBackupMeta.getHash2(), snapshotBackupMeta.getCloudHash(), snapshotBackupMeta.getCloudPath(), snapshotBackupMeta.getData(), snapshotBackupMeta.getRoot(), this.backupRecordId);
    }

    private boolean isSkip(SnapshotBackupMeta snapshotBackupMeta) {
        int status = snapshotBackupMeta.getStatus();
        if (status != 4 && status != 5) {
            return status == 6;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - snapshotBackupMeta.getDateCreate();
        return jCurrentTimeMillis <= 21600000 && jCurrentTimeMillis > 0;
    }

    private boolean isUploaded(String str, SnapshotBackupMeta snapshotBackupMeta) throws SQLException {
        boolean z10 = false;
        if (this.isFullBackup) {
            return false;
        }
        try {
            if (TextUtils.isEmpty(this.lastSuccessBackupId)) {
                return false;
            }
            SnapshotBackupMeta snapshotBackupMetaQueryLeafNodeByHash = this.snapshotTreeService.queryLeafNodeByHash(str, this.lastSuccessBackupId, snapshotBackupMeta.getCloudHash(), snapshotBackupMeta.getData());
            if (snapshotBackupMetaQueryLeafNodeByHash == null || snapshotBackupMetaQueryLeafNodeByHash.getStatus() != 6) {
                return false;
            }
            snapshotBackupMeta.setAppSlice(snapshotBackupMetaQueryLeafNodeByHash.getAppSlice());
            snapshotBackupMeta.setAppType(snapshotBackupMetaQueryLeafNodeByHash.getAppType());
            snapshotBackupMeta.setExtend(snapshotBackupMetaQueryLeafNodeByHash.getExtend());
            this.snapshotTreeService.updateLeafNodeInfo(str, -6L, snapshotBackupMeta.getAppSlice(), (int) snapshotBackupMeta.getAppType(), snapshotBackupMeta.getExtend(), snapshotBackupMeta.getHash1(), snapshotBackupMeta.getHash2(), snapshotBackupMeta.getCloudHash(), snapshotBackupMeta.getCloudPath(), snapshotBackupMeta.getData(), snapshotBackupMeta.getRoot(), this.backupRecordId);
            z10 = true;
            C11839m.m70688i(TAG, "already uploaded. file = " + this.records.getData());
            return true;
        } catch (C9721b unused) {
            C11839m.m70686d(TAG, "is uploaded not.");
            return z10;
        }
    }

    private boolean retryUpload(String str, SnapshotBackupMeta snapshotBackupMeta) throws Throwable {
        if (TextUtils.isEmpty(str) || !str.startsWith(C12583q.m75670f(0, ICBUtil.ANDROID_DATA, this.appId))) {
            C11839m.m70688i(TAG, "not Android data file, " + str);
            return false;
        }
        if (!PmsCheckUtil.m12611e()) {
            C11839m.m70688i(TAG, "retry upload not support PMS, " + str);
            return false;
        }
        File fileM63442h = C10278a.m63442h(str);
        if (fileM63442h.exists() && !C11835i.m70650n(fileM63442h)) {
            String str2 = null;
            try {
                try {
                    Context contextM1377a = C0213f.m1377a();
                    Long localLeftSpace = ICBUtil.getLocalLeftSpace();
                    long length = fileM63442h.length() + C12590s0.m75856h0();
                    if (localLeftSpace != null && localLeftSpace.longValue() - length <= 0) {
                        C11839m.m70688i(TAG, "appid = " + this.appId + ", space not enough " + localLeftSpace + " limitSpace: " + length);
                        if (!C11835i.m70643g(null)) {
                            C11839m.m70688i(TAG, "retry upload delete " + ((String) null) + " failed");
                        }
                        return false;
                    }
                    String str3 = this.appId;
                    String strM75715f = C12586r.m75715f(str3, str3, 0, str);
                    if (TextUtils.equals(strM75715f, str)) {
                        C11839m.m70688i(TAG, "appid = " + this.appId + ", filepath transfer error " + strM75715f);
                        if (!C11835i.m70643g(null)) {
                            C11839m.m70688i(TAG, "retry upload delete " + ((String) null) + " failed");
                        }
                        return false;
                    }
                    try {
                        File fileM63442h2 = C10278a.m63442h(strM75715f);
                        File fileM63437c = C10278a.m63437c(fileM63442h2);
                        if (fileM63437c != null && !fileM63437c.exists() && !fileM63437c.mkdirs()) {
                            C11839m.m70688i(TAG, "retryUpload mkdir not success");
                        }
                        int iBackupAndroid = new BackupRestoreUtil(contextM1377a, this.callback, this.location).backupAndroid(this.appId, 0, str, strM75715f);
                        C11839m.m70688i(TAG, "appid = " + this.appId + ", retry upload file = " + strM75715f + " result: " + iBackupAndroid);
                        if (iBackupAndroid != 0) {
                            if (!C11835i.m70643g(strM75715f)) {
                                C11839m.m70688i(TAG, "retry upload delete " + strM75715f + " failed");
                            }
                            return false;
                        }
                        SnapshotTreeUtil.setMetaHashInfo(fileM63442h, fileM63442h2, this.records, this.location);
                        commonUpload(strM75715f, snapshotBackupMeta);
                        this.taskCallback.onReturnSize(true);
                        this.taskCallback.onTaskSuccess();
                        C11839m.m70688i(TAG, "appid = " + this.appId + ", retry upload file = " + strM75715f + ", success");
                        if (!C11835i.m70643g(strM75715f)) {
                            C11839m.m70688i(TAG, "retry upload delete " + strM75715f + " failed");
                        }
                        return true;
                    } catch (Exception e10) {
                        e = e10;
                        str2 = strM75715f;
                        C11839m.m70688i(TAG, "retry upload failed, " + str + ", exception: " + e.getMessage());
                        if (!C11835i.m70643g(str2)) {
                            C11839m.m70688i(TAG, "retry upload delete " + str2 + " failed");
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        str2 = strM75715f;
                        if (!C11835i.m70643g(str2)) {
                            C11839m.m70688i(TAG, "retry upload delete " + str2 + " failed");
                        }
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return false;
    }

    private String setServerPath(SnapshotBackupMeta snapshotBackupMeta) {
        if (!"music".equals(this.appId)) {
            return this.mNsserverpath + this.appId + "/" + this.records.getCloudPath();
        }
        return this.mNsserverpath + this.appId + "/" + snapshotBackupMeta.getAppSlice() + "/" + this.records.getCloudPath();
    }

    private void uploadStandIcon(String str, SnapshotBackupMeta snapshotBackupMeta, String str2) throws C9721b {
        if (snapshotBackupMeta != null) {
            String strConvertToAbsolutePath = ICBUtil.convertToAbsolutePath(snapshotBackupMeta.getRoot() + snapshotBackupMeta.getData(), this.location);
            checkAPKIsExistOrNot(str);
            Object[] objArrAppUpload = appUpload(strConvertToAbsolutePath, this.appId, str2, 1);
            if (objArrAppUpload.length >= 1) {
                snapshotBackupMeta.setAppSlice((String) objArrAppUpload[0]);
            }
        }
    }

    private void uploadUnstandApk(String str) throws C9721b, SQLException {
        commonUpload(str, this.records);
    }

    private void uploadUnstandIcon(String str, SnapshotBackupMeta snapshotBackupMeta, String str2) throws C9721b, SQLException {
        if (snapshotBackupMeta != null) {
            if (!TextUtils.isEmpty(snapshotBackupMeta.getCloudPath())) {
                snapshotBackupMeta.setAppSlice("/" + this.appId + "/" + str2 + "/" + snapshotBackupMeta.getCloudPath());
            }
            String strConvertToAbsolutePath = ICBUtil.convertToAbsolutePath(snapshotBackupMeta.getRoot() + snapshotBackupMeta.getData(), this.location);
            checkAPKIsExistOrNot(str);
            commonUpload(strConvertToAbsolutePath, snapshotBackupMeta);
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void call() {
        String localPath;
        String str = this.appId;
        String str2 = null;
        try {
            try {
                localPath = SnapshotTreeUtil.getLocalPath(this.records, this.location);
            } catch (C9721b e10) {
                e = e10;
            }
            try {
                if (TextUtils.isEmpty(localPath)) {
                    this.taskCallback.onTaskFail();
                    return;
                }
                SnapshotTreeUtil.setMetaHashInfo(C10278a.m63442h(localPath), this.records, this.location);
                if (!this.records.getCloudPath().startsWith(AlbumsTempScript.DATABASE_NAME)) {
                    C11839m.m70688i(TAG, "appid = " + str + ",file = " + this.records.getCloudPath());
                    this.taskCallback.onTaskBegin(null);
                }
                if (ICBUtil.isIconFile(localPath, this.location, str)) {
                    this.taskCallback.onReturnSize(false);
                    this.taskCallback.onTaskSuccess();
                    return;
                }
                if (ICBUtil.isApkFile(localPath, this.location, str)) {
                    appUpload(localPath);
                    this.taskCallback.onReturnSize(false);
                    this.taskCallback.onTaskSuccess();
                } else if (isSkip(this.records)) {
                    this.taskCallback.onTaskSuccess();
                } else {
                    if (isUploaded(str, this.records)) {
                        this.taskCallback.onTaskSuccess();
                        return;
                    }
                    commonUpload(localPath, this.records);
                    this.taskCallback.onReturnSize(false);
                    this.taskCallback.onTaskSuccess();
                }
            } catch (C9721b e11) {
                e = e11;
                str2 = localPath;
                if (retryUpload(str2, this.records)) {
                    return;
                }
                if (!C10278a.m63442h(str2).exists()) {
                    this.taskCallback.onTaskFail();
                    return;
                }
                if (e.m60659c() == 1013) {
                    this.taskCallback.onTaskFail();
                    return;
                }
                C11839m.m70687e(TAG, "upload error. file = " + this.records.getData() + e.getMessage());
                this.taskCallback.onTaskAbort(e);
            }
        } catch (Exception e12) {
            C11839m.m70687e(TAG, "upload error catch Exception. file = " + this.records.getData() + e12.getMessage());
            this.taskCallback.onTaskAbort(new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, e12.getMessage(), TAG));
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public boolean isAbort() {
        ICallback iCallback = this.callback;
        return iCallback != null ? iCallback.onStop() : super.isAbort();
    }

    private Object[] appUpload(String str, String str2, String str3, int i10) throws C9721b {
        return new C12478a(EnumC12999a.CLOUD_BACKUP, this.traceId).m74905a(C10278a.m63442h(str), str2, str3, i10, this.callback);
    }
}
