package com.huawei.android.hicloud.cloudbackup.process.task;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupFileTask;
import com.huawei.android.hicloud.cloudbackup.process.CacheTask;
import com.huawei.android.hicloud.cloudbackup.process.RestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.TarFileUtil;
import com.huawei.android.hicloud.cloudbackup.progress.RestoreProgress;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.cloudbackup.store.database.tags.CloudRestoreStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import p015ak.C0213f;
import p015ak.C0219i;
import p015ak.C0221j;
import p015ak.C0241z;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11835i;
import p514o9.C11839m;
import p618rm.C12590s0;
import p709vj.C13452e;
import p746wn.C13622a;
import p848zl.C14333b;
import pl.C12168j;
import pl.C12169k;

/* loaded from: classes2.dex */
public class CloudRestoreOneFileTask extends CloudBackupFileTask {
    private static final String TAG = "CloudRestoreOneFileTask";
    private Set<String> compares;
    private String destination;
    private CloudRestoreOneFileCallback fileCallback;
    private String location;
    private List<String> pathList;
    private C12168j restoreMeta;
    private CloudRestoreStatus restoreStatus;
    private boolean sdcardFileIgnore;

    public CloudRestoreOneFileTask(int i10, C12168j c12168j, CloudRestoreOneFileCallback cloudRestoreOneFileCallback, String str, Set<String> set, boolean z10, CloudRestoreStatus cloudRestoreStatus) {
        super(c12168j.m73172a(), i10);
        this.destination = "";
        this.pathList = new ArrayList();
        this.restoreMeta = c12168j;
        this.fileCallback = cloudRestoreOneFileCallback;
        this.location = str;
        this.compares = set;
        this.sdcardFileIgnore = z10;
        this.restoreStatus = cloudRestoreStatus;
    }

    private void dateTakenScan(String str, File file) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        if (!isStringNull(str)) {
            intent.putExtra("datetaken", C0241z.m1688f(str));
        }
        intent.setData(Uri.fromFile(file));
        getContext().sendBroadcast(intent);
        C11839m.m70686d(TAG, "dateTakenScan date_taken = " + str + " file is = " + C10279b.m63452a(file));
    }

    private String destination(C12168j c12168j) throws C9721b {
        String strM73181j = c12168j.m73181j();
        if ("1".equals(c12168j.m73178g())) {
            strM73181j = ICBUtil.getDecodedPath(strM73181j);
        }
        String strConvertToAbsolutePath = ICBUtil.convertToAbsolutePath(strM73181j, this.location, c12168j.m73172a());
        if (isStringNull(strConvertToAbsolutePath)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "download file local path is null.");
        }
        String strTranAndroidPath = tranAndroidPath(strConvertToAbsolutePath, this.appId);
        C12590s0.m75838c2(strTranAndroidPath);
        return strTranAndroidPath;
    }

    private void downloadFile(String str, String str2, long j10) throws C9721b {
        this.fileCallback.onRestoreOneFile(str, str2, j10);
    }

    private void downloadNormalFile(String str) throws C9721b {
        File fileM63442h = C10278a.m63442h(str);
        if (!fileM63442h.exists()) {
            downloadFile(this.restoreMeta.m73180i(), str, this.restoreMeta.m73182k());
        } else if (C14333b.m85446B().contains(this.restoreMeta.m73172a())) {
            updateExistFileSize(fileM63442h);
            return;
        } else if (RestoreUtil.isSameFile(fileM63442h, this.restoreMeta.m73184m(), this.restoreMeta.m73185n())) {
            updateExistFileSize(fileM63442h);
        } else {
            C11839m.m70686d(TAG, " file already exists. start to download the file again. " + str);
            downloadFile(this.restoreMeta.m73180i(), str, this.restoreMeta.m73182k());
        }
        String strM73172a = this.restoreMeta.m73172a();
        if (HNConstants.DataType.MEDIA.equals(strM73172a) || "music".equals(strM73172a)) {
            String strM73173b = this.restoreMeta.m73173b();
            if (!isStringNull(strM73173b)) {
                long jM1688f = C0241z.m1688f(strM73173b);
                if (jM1688f > 0) {
                    C11839m.m70686d(TAG, "setLastModified result = " + fileM63442h.setLastModified(jM1688f) + ", path = " + str + ", emui = " + C0219i.m1463a());
                }
            }
            if (HNConstants.DataType.MEDIA.equals(strM73172a)) {
                dateTakenScan(this.restoreMeta.m73174c(), fileM63442h);
            }
        }
        new C12169k().m73218u(this.restoreMeta.m73172a(), this.restoreMeta.m73181j(), 1);
    }

    private long downloadTARFile() throws Throwable {
        String strM73180i = this.restoreMeta.m73180i();
        if (isStringNull(strM73180i)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadTarFile error cloudPath is empty");
        }
        String tarNameByCloudPath = ICBUtil.getTarNameByCloudPath(strM73180i);
        if (isStringNull(tarNameByCloudPath)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadFiles tar name is empty");
        }
        String localTarPath = ICBUtil.getLocalTarPath(this.location, this.restoreMeta.m73172a());
        File fileM63441g = C10278a.m63441g(C10278a.m63442h(localTarPath), tarNameByCloudPath);
        if (fileM63441g.exists()) {
            this.restoreStatus.addBytesDownloaded(false, fileM63441g.length());
            RestoreProgress.updateStatus(this.restoreStatus);
            C11839m.m70686d(TAG, "tarFile exist,the size is: " + fileM63441g.length());
        } else {
            downloadFile(strM73180i, C10279b.m63452a(fileM63441g), this.restoreMeta.m73182k());
        }
        C11839m.m70686d(TAG, "downloadTARFile untar start " + strM73180i);
        String str = localTarPath + File.separator + UUID.randomUUID();
        try {
            TarFileUtil.unTarAll(fileM63441g, str);
        } catch (C9721b e10) {
            String str2 = "unTar error srcFile: " + C10279b.m63452a(fileM63441g) + " , " + e10.toString();
            C11839m.m70689w(TAG, str2);
            CloudBackupReport.reportUnTarError(C11058a.m66627b("02009"), str2);
        }
        long jMoveOriginFiles = moveOriginFiles(strM73180i, str);
        new C12169k().m73217t(this.restoreMeta.m73172a(), this.restoreMeta.m73180i(), 1);
        if (!fileM63441g.delete()) {
            C11839m.m70689w(TAG, "downloadTARFile " + tarNameByCloudPath + " ,delete error");
        }
        return jMoveOriginFiles;
    }

    private void error(String str, int i10, long j10, C9721b c9721b) {
        if (this.sdcardFileIgnore && 6 == i10) {
            boolean z10 = "soundrecorder".equals(str) || "callRecorder".equals(str);
            if ((!this.destination.startsWith("/data") || z10) && c9721b.m60659c() == 404) {
                C11839m.m70686d(TAG, "download file error. ignore path = " + this.destination);
                restoreSuccess(i10, j10);
                return;
            }
        }
        this.fileCallback.onRestoreFailed(c9721b);
    }

    private Context getContext() {
        return C0213f.m1377a();
    }

    private String getFileEndPath(C12168j c12168j) throws C9721b {
        String strM73181j = c12168j.m73181j();
        if ("1".equals(c12168j.m73178g())) {
            strM73181j = ICBUtil.getDecodedPath(strM73181j);
        }
        String strCheckTarPrePathMoveRoot = ICBUtil.checkTarPrePathMoveRoot(strM73181j);
        if (!TextUtils.isEmpty(strCheckTarPrePathMoveRoot) && !TextUtils.equals(strCheckTarPrePathMoveRoot, strM73181j)) {
            C11839m.m70686d(TAG, "getTarFileEndPath path: " + strM73181j + " ,checkResult: " + strCheckTarPrePathMoveRoot);
            return strCheckTarPrePathMoveRoot;
        }
        String strConvertToAbsolutePath = ICBUtil.convertToAbsolutePath(strM73181j, this.location, this.restoreMeta.m73172a());
        if (isStringNull(strConvertToAbsolutePath)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "download file local path is null.");
        }
        for (String str : this.compares) {
            if (strConvertToAbsolutePath.startsWith(str)) {
                return strConvertToAbsolutePath.substring(str.length());
            }
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "getFileEndPath error path " + strConvertToAbsolutePath);
    }

    private boolean isFile(File file) {
        if (file == null) {
            return false;
        }
        if (file.isFile()) {
            return true;
        }
        return file.getParentFile() != null && file.getParentFile().isFile();
    }

    private boolean isStringNull(String str) {
        return str == null || str.isEmpty();
    }

    private long moveOriginFiles(String str, String str2) throws C9721b {
        long jM73182k = 0;
        for (C12168j c12168j : new C12169k().m73202e(this.restoreMeta.m73172a(), str, this.restoreMeta.m73179h())) {
            jM73182k += c12168j.m73182k();
            String fileEndPath = getFileEndPath(c12168j);
            String str3 = str2 + fileEndPath;
            C11839m.m70686d(TAG, "getFileEndPath localDestination = " + c12168j.m73181j() + " ,path = " + fileEndPath + " ,tempFilePath = " + str3);
            File fileM63442h = C10278a.m63442h(str3);
            if (fileM63442h.exists()) {
                String strDestination = destination(c12168j);
                File fileM63442h2 = C10278a.m63442h(strDestination);
                this.pathList.add(strDestination);
                if (!fileM63442h2.isDirectory()) {
                    if (fileM63442h2.exists()) {
                        if (RestoreUtil.isSameFile(fileM63442h2, c12168j.m73184m(), c12168j.m73185n())) {
                            C11839m.m70686d(TAG, "downloadTARFile destination " + strDestination + " exist");
                        } else {
                            C11839m.m70686d(TAG, "downloadTARFile destination " + strDestination + " exist");
                            if (!fileM63442h2.delete()) {
                                C11839m.m70689w(TAG, "downloadTARFile destination " + strDestination + " exist hash not equal, delete error");
                            }
                        }
                    }
                    renameFile(fileM63442h2, fileM63442h);
                } else if (!fileM63442h2.exists() && !fileM63442h2.mkdirs()) {
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "downloadTARFile origin file " + strDestination + " create dir error: " + c12168j.m73180i());
                }
            } else {
                C11839m.m70687e(TAG, "downloadTARFile origin file " + c12168j.m73181j() + " not exist, tarfile: " + c12168j.m73180i());
                C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02009"), "moveOriginFiles", C13452e.m80781L().m80971t0());
                c11060cM66626a.m66666v("isSuccess", "0", "1", c12168j.m73181j() + " not exist, tar: " + c12168j.m73180i());
                C13622a.m81968n(getContext(), c11060cM66626a);
            }
        }
        C11839m.m70686d(TAG, "downloadTARFile untar end " + str);
        return jM73182k;
    }

    private void renameFile(File file, File file2) throws C9721b {
        File fileM63437c = C10278a.m63437c(file);
        C12590s0.m75820Y1(C10279b.m63452a(fileM63437c));
        if (file.exists() && !file.delete()) {
            C11839m.m70686d(TAG, "rename file, delete old file error.");
            throw new C9721b(4001, "rename file, delete old file error,  file = " + C10279b.m63452a(file2));
        }
        boolean zM70640d = C11835i.m70640d(file2, file);
        boolean z10 = false;
        if (!zM70640d) {
            C11839m.m70686d(TAG, "use pms copy file, delete cache = " + file.delete());
            zM70640d = new BackupRestoreUtil(C0213f.m1377a(), (CacheTask) null, this.location).backup(CloudBackupConstant.Command.PMS_OPTION_ONE_FILE, C10279b.m63452a(file2), C10279b.m63452a(file)) == 0;
            C11839m.m70686d(TAG, "use pms copy file result = " + zM70640d);
        }
        if (zM70640d) {
            C11839m.m70686d(TAG, "copy file success, delete source file = " + file2.delete());
            if (file.exists()) {
                return;
            }
            throw new C9721b(4001, "copy file success, but file not exist, file = " + C10279b.m63452a(file2));
        }
        C11839m.m70686d(TAG, "copy file failed, delete source file = " + file2.delete());
        C9721b c9721b = new C9721b(4001, "renameFile error src = " + C10279b.m63452a(file2) + ", dest = " + C10279b.m63452a(file) + ", result = " + file.delete());
        String strM63452a = C10279b.m63452a(fileM63437c);
        if (strM63452a != null && strM63452a.startsWith(C0221j.m1512v())) {
            z10 = true;
        }
        if (!isFile(fileM63437c) && !z10) {
            throw c9721b;
        }
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("02009"), "renameFile", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("113_" + c9721b.m60659c());
        c11060cM66626a.m66635A(C10279b.m63452a(file) + ", " + c9721b.getMessage());
        C13622a.m81968n(getContext(), c11060cM66626a);
    }

    private void restoreSuccess(int i10, long j10) {
        if (this.restoreStatus.isShowRestoreProgressTotal() && i10 == 7) {
            this.fileCallback.onRestoreSuccess(this.pathList);
        } else {
            this.fileCallback.onRestoreSuccess(this.destination, j10);
        }
    }

    private String tranAndroidPath(String str, String str2) {
        return this.fileCallback.tranAndroidPath(str, str2);
    }

    private void updateExistFileSize(File file) {
        C11839m.m70688i(TAG, "file is exists,the length is : " + file.length());
        this.restoreStatus.addBytesDownloaded(false, file.length());
        RestoreProgress.updateStatus(this.restoreStatus);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void call() {
        C9721b c9721b;
        StringBuilder sb2;
        int iM1685c = C0241z.m1685c(this.restoreMeta.m73179h());
        long jM73182k = this.restoreMeta.m73182k();
        String strM73172a = this.restoreMeta.m73172a();
        try {
            try {
                this.destination = destination(this.restoreMeta);
                C11839m.m70686d(TAG, "download file begin, name = " + this.restoreMeta.m73180i() + ", fileType = " + iM1685c + ", path = " + this.destination);
                switch (iM1685c) {
                    case 6:
                    case 8:
                    case 9:
                        downloadNormalFile(this.destination);
                        break;
                    case 7:
                        jM73182k = downloadTARFile();
                        break;
                }
                C11839m.m70686d(TAG, "download file success. name = " + this.restoreMeta.m73180i());
                restoreSuccess(iM1685c, jM73182k);
                sb2 = new StringBuilder();
            } catch (Exception e10) {
                long j10 = jM73182k;
                if (e10 instanceof C9721b) {
                    c9721b = (C9721b) e10;
                } else {
                    c9721b = new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "download file error. name = " + this.restoreMeta.m73180i() + ",error msg: " + e10.getMessage());
                }
                C11839m.m70686d(TAG, "download file error. " + c9721b);
                error(strM73172a, iM1685c, j10, c9721b);
                sb2 = new StringBuilder();
            }
            sb2.append("download file end. name = ");
            sb2.append(this.restoreMeta.m73180i());
            C11839m.m70686d(TAG, sb2.toString());
            this.fileCallback.onRestoreEnd();
        } catch (Throwable th2) {
            C11839m.m70686d(TAG, "download file end. name = " + this.restoreMeta.m73180i());
            this.fileCallback.onRestoreEnd();
            throw th2;
        }
    }
}
