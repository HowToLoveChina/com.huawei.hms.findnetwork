package com.huawei.android.hicloud.cloudbackup.process.task;

import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupFileTask;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.android.hicloud.cloudbackup.snapshottree.QueryBackupTarByCloudPath;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeManagementService;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeUtil;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.connect.progress.ICallback;
import com.huawei.android.hicloud.p081cs.bean.UploadReq;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.util.Iterator;
import p514o9.C11839m;
import p606r9.C12478a;
import p618rm.C12571m;
import p652t9.EnumC12999a;

/* loaded from: classes2.dex */
public class TarFileUploadTask extends CloudBackupFileTask {
    private static final String TAG = "TarFileUploadTask";
    private String location;
    private String mAppId;
    private String mBackupId;
    private ICallback mCallback;
    private String mNsserverpath;
    private File mTarFile;
    private ICBTarTaskCallback mTaskCallback;
    private String mTraceId;
    private SnapshotTreeManagementService snapshotTreeService;
    private long tarfileModifytime;
    private String uuid;

    public TarFileUploadTask(ICBTarTaskCallback iCBTarTaskCallback, File file, String str, ProgressCallback progressCallback, String str2, String str3, String str4, String str5, String str6) {
        super(str4, 0);
        this.mTaskCallback = iCBTarTaskCallback;
        this.uuid = str;
        this.mTarFile = file;
        this.tarfileModifytime = file.lastModified();
        this.mTraceId = str2;
        this.mCallback = progressCallback;
        this.mNsserverpath = str3;
        this.mAppId = str4;
        this.mBackupId = str5;
        this.location = str6;
        this.snapshotTreeService = SnapshotTreeManagementService.getInstance();
    }

    private void commonUpload(String str) throws C9721b, SQLException {
        if (str == null) {
            return;
        }
        String name = this.mTarFile.getName();
        UploadReq uploadReq = new UploadReq();
        uploadReq.setFile(C10278a.m63442h(str));
        uploadReq.setKeyType(1);
        uploadReq.setServer(ICBUtil.getTarPathByCloudPath(this.mNsserverpath, name, this.mAppId));
        uploadReq.setCallback(this.mCallback);
        new C12478a(EnumC12999a.CLOUD_BACKUP, this.mTraceId).m74909e(uploadReq);
        this.snapshotTreeService.updateLeafNodeStatusByAppIdAndCloudPath(-4, name, this.mAppId, this.mBackupId);
    }

    private void setOriginFileInfo(String str, SnapshotBackupMeta snapshotBackupMeta) throws C9721b, SQLException {
        File fileM63442h = C10278a.m63442h(SnapshotTreeUtil.getLocalPath(snapshotBackupMeta, this.location));
        try {
            try {
                SnapshotTreeUtil.setMetaHashInfo(fileM63442h, snapshotBackupMeta, this.location);
            } catch (C9721b e10) {
                SnapshotTreeUtil.setCloudPath(fileM63442h, snapshotBackupMeta, ICBUtil.getRelativePath(C10279b.m63452a(fileM63442h), this.location), this.location);
                C11839m.m70687e(TAG, "setMetaHashInfo err: " + e10.toString());
            }
            this.snapshotTreeService.updateTarLeafNodeInfo(this.mAppId, 0, 7, snapshotBackupMeta.getHash1(), snapshotBackupMeta.getHash2(), snapshotBackupMeta.getCloudHash(), str, snapshotBackupMeta.getData(), snapshotBackupMeta.getRoot(), this.mBackupId);
        } catch (C9721b e11) {
            C11839m.m70687e(TAG, "setOriginFileInfo err: " + e11.toString());
            if (fileM63442h.exists()) {
                throw e11;
            }
            this.mTaskCallback.onOriginFileFail(snapshotBackupMeta);
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void call() {
        StringBuilder sb2;
        String strM63452a;
        String str = this.mAppId;
        String str2 = null;
        try {
            try {
                strM63452a = C10279b.m63452a(this.mTarFile);
            } catch (C9721b e10) {
                e = e10;
            } catch (Exception e11) {
                e = e11;
            }
            try {
                C11839m.m70688i(TAG, "appid = " + str + ",file = " + strM63452a);
                this.mTaskCallback.onTaskBegin(null);
            } catch (C9721b e12) {
                e = e12;
                str2 = strM63452a;
                if (!C10278a.m63442h(str2).exists()) {
                    e = new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "file not found. file = " + str2 + e.getMessage());
                }
                C11839m.m70687e(TAG, "upload error. file = " + str2 + e.getMessage());
                this.mTaskCallback.onTaskAbort(e);
                if (this.tarfileModifytime != this.mTarFile.lastModified()) {
                    sb2 = new StringBuilder();
                    sb2.append("delete return tarfileModifytime: ");
                    sb2.append(this.tarfileModifytime);
                    sb2.append(" ,current: ");
                    sb2.append(this.mTarFile.lastModified());
                    C11839m.m70686d(TAG, sb2.toString());
                    return;
                }
                C12571m.m75547i(C10279b.m63452a(this.mTarFile));
            } catch (Exception e13) {
                e = e13;
                str2 = strM63452a;
                C11839m.m70687e(TAG, "upload error catch Exception. file = " + str2 + e.getMessage());
                this.mTaskCallback.onTaskAbort(new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, e.getMessage(), "UploadTask"));
                if (this.tarfileModifytime != this.mTarFile.lastModified()) {
                    sb2 = new StringBuilder();
                    sb2.append("delete return tarfileModifytime: ");
                    sb2.append(this.tarfileModifytime);
                    sb2.append(" ,current: ");
                    sb2.append(this.mTarFile.lastModified());
                    C11839m.m70686d(TAG, sb2.toString());
                    return;
                }
                C12571m.m75547i(C10279b.m63452a(this.mTarFile));
            }
            if (TextUtils.isEmpty(strM63452a)) {
                this.mTaskCallback.onTaskFail();
                if (this.tarfileModifytime == this.mTarFile.lastModified()) {
                    C12571m.m75547i(C10279b.m63452a(this.mTarFile));
                    return;
                }
                C11839m.m70686d(TAG, "delete return tarfileModifytime: " + this.tarfileModifytime + " ,current: " + this.mTarFile.lastModified());
                return;
            }
            String name = this.mTarFile.getName();
            this.snapshotTreeService.updateCloudPathByCloudPath(name, this.uuid, this.mAppId, this.mBackupId);
            QueryBackupTarByCloudPath queryBackupTarByCloudPath = new QueryBackupTarByCloudPath(this.mAppId, this.mBackupId, name);
            while (queryBackupTarByCloudPath.hasNext()) {
                if (this.mCallback.onStop()) {
                    throw new C9721b(1002, "tarupload net disable or canceled by user");
                }
                Iterator<SnapshotBackupMeta> it = queryBackupTarByCloudPath.getNext().iterator();
                while (it.hasNext()) {
                    setOriginFileInfo(name, it.next());
                }
            }
            commonUpload(strM63452a);
            this.mTaskCallback.onReturnSize(false);
            this.mTaskCallback.onTaskSuccess();
            this.mTarFile.lastModified();
            C12571m.m75547i(C10279b.m63452a(this.mTarFile));
        } catch (Throwable th2) {
            if (this.tarfileModifytime != this.mTarFile.lastModified()) {
                C11839m.m70686d(TAG, "delete return tarfileModifytime: " + this.tarfileModifytime + " ,current: " + this.mTarFile.lastModified());
            } else {
                C12571m.m75547i(C10279b.m63452a(this.mTarFile));
            }
            throw th2;
        }
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public boolean isAbort() {
        ICallback iCallback = this.mCallback;
        return iCallback != null ? iCallback.onStop() : super.isAbort();
    }
}
