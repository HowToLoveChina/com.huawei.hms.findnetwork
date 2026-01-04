package com.huawei.android.hicloud.cloudbackup.process.task;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.SQLException;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.content.p019pm.PackageInfoCompat;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.manager.CloudBackupModuleTask;
import com.huawei.android.hicloud.cloudbackup.p076db.bean.Albums;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.AlbumOperator;
import com.huawei.android.hicloud.cloudbackup.p076db.temp.AlbumsTempOperator;
import com.huawei.android.hicloud.cloudbackup.p076db.temp.AlbumsTempScript;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.PmsDataManagement;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMetaStatus;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoOperator;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaStatusOperator;
import com.huawei.android.hicloud.cloudbackup.process.CacheTask;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.android.hicloud.cloudbackup.process.MusicBackup;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupCacheRecord;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreConstans;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.TarFileUtil;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeManagementService;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeUtil;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.operator.SnapshotBackupMetaOperator;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.cloudbackup.util.QueryAppMarketDataUtil;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.util.SafeString;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import mk.C11476b;
import om.C11963c;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;
import p617rl.C12519c;
import p617rl.C12526j;
import p618rm.C12565k;
import p618rm.C12571m;
import p618rm.C12574n;
import p618rm.C12590s0;
import p744wl.C13617a;
import p848zl.C14333b;
import sl.C12815f;

/* loaded from: classes2.dex */
public class CloudBackupOneModuleTask extends CloudBackupModuleTask {
    private static final int FILE_SIZE_MIN_APP_DATA = 4;
    private static final int FILE_SIZE_PROGRESS_CONTROL = 50;
    private static final int MAX_LINE = 1000;
    private static final String TAG = "CloudBackupOneModuleTask";
    private String appId;
    private boolean autoBackup;
    private C12526j backupConfigOperator;
    private String backupId;
    private CloudBackupStatus backupStatus;
    private ProgressCallback callback;
    private CacheTask client;
    private CloneService cloneService;
    private CloudBackupAppDataUtil cloudBackupAppDataUtil;
    private String dataLocation;
    private int fileNum;
    private long fileSize;
    private boolean isSystemApp;
    private boolean isVirtual;
    private String lastSuccessBackupId;
    private String location;
    private IOneModuleTaskCallback mModuleTaskCallback;
    private boolean needBackup3rdAppData;
    private SnapshotBackupMeta rootMeta;
    private ScanAppDataUtil scanAppDataUtil;
    private String serverPath;
    private SnapshotTreeManagementService snapshotTreeService;
    private String traceID;

    public CloudBackupOneModuleTask(SnapshotBackupMeta snapshotBackupMeta, CloudBackupStatus cloudBackupStatus, ProgressCallback progressCallback, String str, String str2, String str3, String str4, CloudBackupAppDataUtil cloudBackupAppDataUtil, boolean z10, String str5, CacheTask cacheTask, boolean z11) {
        super(snapshotBackupMeta.getAppId());
        this.fileNum = -1;
        this.fileSize = 0L;
        this.needBackup3rdAppData = false;
        this.isSystemApp = false;
        this.isVirtual = false;
        this.appId = snapshotBackupMeta.getAppId();
        this.backupStatus = cloudBackupStatus;
        this.rootMeta = snapshotBackupMeta;
        this.callback = progressCallback;
        this.location = str;
        this.dataLocation = str + "/data";
        this.backupId = str2;
        this.traceID = str3;
        this.serverPath = str4;
        this.client = cacheTask;
        this.snapshotTreeService = SnapshotTreeManagementService.getInstance();
        this.cloneService = CloneService.getInstance();
        this.cloudBackupAppDataUtil = cloudBackupAppDataUtil;
        this.isVirtual = z10;
        this.lastSuccessBackupId = str5;
        this.autoBackup = z11;
        initBackupConfigs();
    }

    private void build3rdAppSnapshotTree(String str, SnapshotBackupMeta snapshotBackupMeta) throws Throwable {
        if (!this.needBackup3rdAppData || isNeedScanData(snapshotBackupMeta)) {
            deleteDataFromSnapshot(str);
            scan3rdAppCloneFiles(this.cloudBackupAppDataUtil, str, snapshotBackupMeta);
            List<String> list = get3rdAppDataPaths();
            if (isPmsBriefProcess(str, this.dataLocation)) {
                scan3rdAppDataFilesByPmsBriefDb(list, str, snapshotBackupMeta);
            } else {
                scan3rdAppDataFiles(list, this.cloudBackupAppDataUtil, str, snapshotBackupMeta);
            }
            snapshotBackupMeta.setDateInvalid(System.currentTimeMillis());
            snapshotBackupMeta.setStatus(2);
            this.snapshotTreeService.updateRootNode(this.backupId, snapshotBackupMeta);
        }
        build3rdSdCardSnapshotTree(str, snapshotBackupMeta);
    }

    private void build3rdSdCardSnapshotTree(String str, SnapshotBackupMeta snapshotBackupMeta) throws Throwable {
        this.snapshotTreeService.deleteSdcardFromSnapshot(str, this.backupId);
        scan3rdAppSdcardFiles(get3rdAppSdcardPaths(), this.cloudBackupAppDataUtil, str, snapshotBackupMeta);
        boolean zQueryIsHaveAppDataFile = this.snapshotTreeService.queryIsHaveAppDataFile(str, this.backupId);
        if (this.needBackup3rdAppData && zQueryIsHaveAppDataFile) {
            snapshotBackupMeta.setData1(String.valueOf(1));
        } else {
            snapshotBackupMeta.setData1(String.valueOf(0));
        }
        C11839m.m70688i(TAG, "build3rdAppSnapshotTree: " + zQueryIsHaveAppDataFile);
        isCancel();
        this.snapshotTreeService.addFileMeta(null, this.backupId, true);
        if (!this.isVirtual) {
            sendPrepareProgress();
        } else if (this.fileSize >= 0) {
            sendPrepareProgress();
        }
    }

    private void buildSystemAppSnapshotTree(String str, SnapshotBackupMeta snapshotBackupMeta) throws Throwable {
        this.snapshotTreeService.deleteMetaByAppId(str, this.backupId);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.location);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(str);
        String string = sb2.toString();
        snapshotBackupMeta.setRoot(C10279b.m63452a(C10278a.m63442h(this.location)) + str2);
        File fileM63442h = C10278a.m63442h(C10279b.m63452a(getContext().getDir("medaicache", 0)) + str2 + str);
        if (fileM63442h.exists() && !fileM63442h.renameTo(C10278a.m63443i(string, str))) {
            C11839m.m70689w(TAG, "temp file rename fail!");
        }
        long[] directorySnapshotBackupMetas = getDirectorySnapshotBackupMetas(null, str, C10278a.m63442h(string), snapshotBackupMeta.getLeft(), true);
        this.snapshotTreeService.treeCreationCompleted(snapshotBackupMeta, snapshotBackupMeta.getLeft() + (directorySnapshotBackupMetas[0] * 2) + 1, directorySnapshotBackupMetas[1]);
        isCancel();
        this.snapshotTreeService.addFileMeta(null, this.backupId, true);
    }

    private boolean checkFile(File file) {
        return file == null || !file.exists() || file.length() <= 0;
    }

    private boolean checkFileList(File[] fileArr) {
        return fileArr == null || fileArr.length == 0;
    }

    private boolean checkFname(String str, String str2, String str3) throws C9721b {
        if (C14333b.m85477l().contains(str3) || !TextUtils.isEmpty(str)) {
            return false;
        }
        C11839m.m70686d(TAG, "checkFname fname is empty: " + str2);
        if (str2 == null || !str2.startsWith(getDataTempDir(str3))) {
            return true;
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "checkFname fname is emtpty: " + str2);
    }

    private void countFileSize(long j10) {
        int i10;
        this.fileSize += j10;
        this.fileNum++;
        if (!isSystemApp() && (i10 = this.fileNum) >= 0 && i10 % 50 == 0) {
            sendPrepareProgress();
        }
    }

    private SnapshotBackupMeta createSnapshotLeafMeta(String str, File file, long j10, boolean z10) throws C9721b {
        SnapshotBackupMeta snapshotBackupMeta = new SnapshotBackupMeta();
        String relativePath = ICBUtil.getRelativePath(C10279b.m63452a(file), this.location);
        String rootPath = ICBUtil.getRootPath(relativePath);
        if (ICBUtil.hasEmojiCharacter(relativePath)) {
            snapshotBackupMeta.setCloudEncoded(1L);
            relativePath = ICBUtil.getEncodedPath(relativePath);
        }
        snapshotBackupMeta.setRoot(rootPath);
        snapshotBackupMeta.setData(relativePath.substring(rootPath.length()));
        snapshotBackupMeta.setAppId(str);
        String strTrim = file.getName().trim();
        if (ICBUtil.hasEmojiCharacter(strTrim) || ICBUtil.checkFileName(strTrim)) {
            strTrim = C11476b.m68626h(strTrim);
        }
        snapshotBackupMeta.setName(strTrim);
        snapshotBackupMeta.setLeft(j10);
        snapshotBackupMeta.setStatus(0);
        snapshotBackupMeta.setDateModify(file.lastModified());
        if (file.exists()) {
            if (file.isFile()) {
                countFileSize(file.length());
                snapshotBackupMeta.setType(6L);
                snapshotBackupMeta.setSize(file.length());
                snapshotBackupMeta.setDateCreate(System.currentTimeMillis());
                snapshotBackupMeta.setCloudSize(file.length());
                if (z10) {
                    SnapshotTreeUtil.setMetaHashInfo(file, snapshotBackupMeta, this.location);
                }
                snapshotBackupMeta.setRight(j10 + 1);
            } else {
                snapshotBackupMeta.setType(5L);
                snapshotBackupMeta.setDateCreate(file.lastModified());
            }
        }
        return snapshotBackupMeta;
    }

    private void deleteDataFromSnapshot(String str) throws C9721b, SQLException {
        File fileM63442h = C10278a.m63442h(getIconPath(str));
        if (fileM63442h.exists() && !fileM63442h.delete()) {
            C11839m.m70688i(TAG, "deleteDataFromSnapshot delete iconfile error");
        }
        this.snapshotTreeService.deleteDataFromSnapshot(str, this.backupId);
    }

    private void deleteFromTempDir(File file, List<String> list, CloudBackupAppDataUtil cloudBackupAppDataUtil, File file2) throws C9721b {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file3 : fileArrListFiles) {
            String strM63452a = C10279b.m63452a(file3);
            boolean zIsDirectory = file3.isDirectory();
            if (isFilterDataPath(file2, file3, list, cloudBackupAppDataUtil)) {
                C11839m.m70686d(TAG, "isFilterDataPath  true " + strM63452a + " ," + zIsDirectory);
                C12571m.m75547i(strM63452a);
                if (file3.exists()) {
                    throw new C9721b(1017, "deleteFromTempDir error = " + strM63452a + " ,directory " + zIsDirectory);
                }
            } else if (zIsDirectory) {
                deleteFromTempDir(file3, list, cloudBackupAppDataUtil, file2);
            }
        }
    }

    private void deleteTXTLine(File file, List<String> list) throws Throwable {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        File fileM63441g = C10278a.m63441g(C10278a.m63437c(file), "tempfile");
        if (fileM63441g.exists() && !fileM63441g.delete()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "filterDataFile tempFile delete error");
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            stringBuffer.append("(");
            stringBuffer.append(BackupRestoreConstans.getUserPath());
            stringBuffer.append("/");
            stringBuffer.append(next);
            stringBuffer.append(")");
            if (it.hasNext()) {
                stringBuffer.append("|");
            }
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("(");
        stringBuffer2.append(stringBuffer);
        stringBuffer2.append(")");
        stringBuffer2.append("[\\s\\S]*?[;]+[0-9]+[\\n]");
        String string = stringBuffer2.toString();
        C11839m.m70686d(TAG, "regex = " + string);
        StringBuffer stringBuffer3 = new StringBuffer();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream, Constants.UTF_8);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                    } catch (FileNotFoundException e10) {
                        e = e10;
                    } catch (IOException e11) {
                        e = e11;
                    } catch (Throwable th2) {
                        th = th2;
                        C0209d.m1263i(bufferedReader2);
                        C0209d.m1263i(inputStreamReader);
                        C0209d.m1263i(fileInputStream);
                        throw th;
                    }
                } catch (FileNotFoundException e12) {
                    e = e12;
                } catch (IOException e13) {
                    e = e13;
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamReader = null;
                }
            } catch (FileNotFoundException e14) {
                e = e14;
            } catch (IOException e15) {
                e = e15;
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = null;
                inputStreamReader = null;
            }
            try {
                String line = bufferedReader.readLine();
                if (!TextUtils.isEmpty(line) && line.startsWith(BackupRestoreConstans.getUserPath())) {
                    stringBuffer3.append(line);
                    stringBuffer3.append("\n");
                    int i10 = 0;
                    while (true) {
                        String line2 = bufferedReader.readLine();
                        if (line2 == null) {
                            break;
                        }
                        isCancel();
                        i10++;
                        if (i10 >= 1000 && line2.startsWith(BackupRestoreConstans.getUserPath())) {
                            matchAndWriteString(fileM63441g, string, stringBuffer3);
                            stringBuffer3.delete(0, stringBuffer3.length());
                            i10 = 0;
                        }
                        stringBuffer3.append(line2);
                        stringBuffer3.append("\n");
                    }
                    C0209d.m1263i(bufferedReader);
                    C0209d.m1263i(inputStreamReader);
                    C0209d.m1263i(fileInputStream);
                    if (stringBuffer3.length() > 0) {
                        matchAndWriteString(fileM63441g, string, stringBuffer3);
                    }
                    boolean zDelete = file.delete();
                    if (zDelete && fileM63441g.renameTo(file)) {
                        C11839m.m70688i(TAG, "regex end");
                        return;
                    }
                    throw new C9721b(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "filterDataFile delete error or rename error = " + zDelete);
                }
                C11839m.m70689w(TAG, "deleteTXTLine first line is invalid.");
                C0209d.m1263i(bufferedReader);
                C0209d.m1263i(inputStreamReader);
                C0209d.m1263i(fileInputStream);
            } catch (FileNotFoundException e16) {
                e = e16;
                C11839m.m70687e(TAG, "filterDataFile FileNotFoundException: " + e.toString());
                throw new C9721b(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "filterDataFile FileNotFoundException delete error");
            } catch (IOException e17) {
                e = e17;
                C11839m.m70687e(TAG, "filterDataFile IOException: " + e.toString());
                throw new C9721b(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "filterDataFile IOException delete error");
            } catch (Throwable th5) {
                th = th5;
                bufferedReader2 = bufferedReader;
                C0209d.m1263i(bufferedReader2);
                C0209d.m1263i(inputStreamReader);
                C0209d.m1263i(fileInputStream);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            fileInputStream = null;
        }
    }

    private boolean distinctFileAndDirectory(File file, List<File> list, List<File> list2, CloudBackupAppDataUtil cloudBackupAppDataUtil) {
        File[] fileArrM63440f = C10278a.m63440f(file);
        if (checkFileList(fileArrM63440f)) {
            return false;
        }
        for (File file2 : fileArrM63440f) {
            if (cloudBackupAppDataUtil != null && cloudBackupAppDataUtil.isFilterFile(file2)) {
                C11839m.m70686d(TAG, "filter file = " + C10279b.m63452a(file2));
            } else if (file2.exists()) {
                if (file2.isFile()) {
                    list.add(file2);
                } else {
                    list2.add(file2);
                }
            }
        }
        return true;
    }

    private void doBackupOneModule(Bundle bundle, int i10) throws InterruptedException, C9721b {
        try {
            isCancel();
            this.cloneService.doBackupOneModule(this.appId, this.location, bundle, null);
        } catch (C9721b e10) {
            String message = e10.getMessage();
            C11839m.m70687e(TAG, "clone module " + this.appId + " error, errorReason: " + message + ", retryTime: " + i10);
            this.cloneService.reportBackupOneModuleError(this.appId, message, this.traceID, i10);
            if (i10 >= 1) {
                throw new C9721b(e10.m60659c(), message, "doBackupOneModule");
            }
            int i11 = 0;
            while (i11 < 30000) {
                try {
                    isCancel();
                    Thread.sleep(400L);
                    i11 += 400;
                } catch (InterruptedException e11) {
                    C11839m.m70687e(TAG, "InterruptedException : " + e11.toString());
                }
            }
            doBackupOneModule(bundle, i10 + 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v11, types: [java.io.Closeable, java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v8 */
    private void filterAbnormalFile(File file, File file2) throws Throwable {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        ?? fileOutputStream;
        Object obj;
        Object obj2;
        if (!file2.exists()) {
            C11839m.m70688i(TAG, "filterAbnormalFile txt file not exist " + this.appId);
            return;
        }
        if (!C10278a.m63441g(file, this.appId).exists()) {
            C11839m.m70688i(TAG, "filterAbnormalFile tempPackageDir not exist");
            return;
        }
        C11839m.m70688i(TAG, this.appId + " filterAbnormalFile start");
        File fileM63441g = C10278a.m63441g(C10278a.m63437c(file2), "temp_index_file");
        if (fileM63441g.exists() && !fileM63441g.delete()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "filterAbnormalFile tempFile delete error");
        }
        BufferedReader bufferedReader = null;
        try {
            try {
                fileInputStream = new FileInputStream(file2);
            } catch (FileNotFoundException e10) {
                e = e10;
            } catch (IOException e11) {
                e = e11;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
                inputStreamReader = null;
            }
            try {
                inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                    try {
                        fileOutputStream = new FileOutputStream(fileM63441g, true);
                        try {
                            StringBuffer stringBuffer = new StringBuffer();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("(");
                            sb2.append(BackupRestoreConstans.getUserPath());
                            sb2.append("/[^;\\n]+)+(;\\d+){4}");
                            C11839m.m70688i(TAG, this.appId + " filterAbnormalFile regexNormal=" + sb2.toString());
                            Pattern patternCompile = Pattern.compile(sb2.toString());
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("(");
                            sb3.append(BackupRestoreConstans.getUserPath());
                            sb3.append("/)+[\\s\\S]+(;\\d+){4}");
                            C11839m.m70688i(TAG, this.appId + " filterAbnormalFile regexAbnormal=" + sb3.toString());
                            Pattern patternCompile2 = Pattern.compile(sb3.toString());
                            while (true) {
                                String line = bufferedReader2.readLine();
                                if (line == null) {
                                    break;
                                }
                                isCancel();
                                if (stringBuffer.length() > 0) {
                                    stringBuffer.append("\n");
                                    stringBuffer.append(line);
                                    C11839m.m70686d(TAG, " filterAbnormalFile deal new line=" + stringBuffer.toString());
                                    if (patternCompile2.matcher(stringBuffer).matches()) {
                                        String str = this.appId;
                                        C12574n.m75560m(str, str, 0, stringBuffer.toString(), file);
                                        stringBuffer.delete(0, stringBuffer.length());
                                    }
                                } else if (patternCompile.matcher(line).matches()) {
                                    C11839m.m70686d(TAG, "filterAbnormalFile normal line=" + line);
                                    Charset charset = StandardCharsets.UTF_8;
                                    fileOutputStream.write(line.getBytes(charset));
                                    fileOutputStream.write("\n".getBytes(charset));
                                } else {
                                    C11839m.m70686d(TAG, "filterAbnormalFile abnormal line=" + line);
                                    if (patternCompile2.matcher(line).matches()) {
                                        String str2 = this.appId;
                                        C12574n.m75560m(str2, str2, 0, line, file);
                                    } else {
                                        C11839m.m70686d(TAG, "filterAbnormalFile new line=" + line);
                                        stringBuffer.append(line);
                                    }
                                }
                            }
                            C0209d.m1263i(bufferedReader2);
                            C0209d.m1263i(inputStreamReader);
                            C0209d.m1263i(fileInputStream);
                            C0209d.m1263i(fileOutputStream);
                            boolean zDelete = file2.delete();
                            if (!zDelete || !fileM63441g.renameTo(file2)) {
                                throw new C9721b(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "filterAbnormalFile delete error or rename error = " + zDelete);
                            }
                            C11839m.m70688i(TAG, this.appId + " filterAbnormalFile end");
                        } catch (FileNotFoundException e12) {
                            e = e12;
                            C11839m.m70687e(TAG, "filterAbnormalFile FileNotFoundException: " + e.toString());
                            throw new C9721b(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "filterAbnormalFile FileNotFoundException " + e.toString());
                        } catch (IOException e13) {
                            e = e13;
                            C11839m.m70687e(TAG, "filterAbnormalFile IOException: " + e.toString());
                            throw new C9721b(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "filterAbnormalFile IOException " + e.toString());
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = bufferedReader2;
                            inputStreamReader2 = fileOutputStream;
                            C0209d.m1263i(bufferedReader);
                            C0209d.m1263i(inputStreamReader);
                            C0209d.m1263i(fileInputStream);
                            C0209d.m1263i(inputStreamReader2);
                            throw th;
                        }
                    } catch (FileNotFoundException e14) {
                        e = e14;
                    } catch (IOException e15) {
                        e = e15;
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = 0;
                    }
                } catch (FileNotFoundException e16) {
                    e = e16;
                    obj2 = null;
                    C11839m.m70687e(TAG, "filterAbnormalFile FileNotFoundException: " + e.toString());
                    throw new C9721b(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "filterAbnormalFile FileNotFoundException " + e.toString());
                } catch (IOException e17) {
                    e = e17;
                    obj = null;
                    C11839m.m70687e(TAG, "filterAbnormalFile IOException: " + e.toString());
                    throw new C9721b(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "filterAbnormalFile IOException " + e.toString());
                } catch (Throwable th5) {
                    th = th5;
                    inputStreamReader2 = null;
                    C0209d.m1263i(bufferedReader);
                    C0209d.m1263i(inputStreamReader);
                    C0209d.m1263i(fileInputStream);
                    C0209d.m1263i(inputStreamReader2);
                    throw th;
                }
            } catch (FileNotFoundException e18) {
                e = e18;
                obj2 = null;
            } catch (IOException e19) {
                e = e19;
                obj = null;
            } catch (Throwable th6) {
                th = th6;
                inputStreamReader = null;
                inputStreamReader2 = inputStreamReader;
                C0209d.m1263i(bufferedReader);
                C0209d.m1263i(inputStreamReader);
                C0209d.m1263i(fileInputStream);
                C0209d.m1263i(inputStreamReader2);
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            fileInputStream = null;
        }
    }

    private void filterDataFile(File file, File file2, CloudBackupAppDataUtil cloudBackupAppDataUtil) throws Throwable {
        if (!file2.exists()) {
            C11839m.m70688i(TAG, "filterDataFile txt file not exist " + this.appId);
            return;
        }
        if (!cloudBackupAppDataUtil.needFilterData()) {
            C11839m.m70688i(TAG, this.appId + " no data path filter");
            return;
        }
        C11839m.m70688i(TAG, this.appId + " filterDataFile start");
        ArrayList arrayList = new ArrayList();
        File fileM63441g = C10278a.m63441g(file, this.appId);
        if (!fileM63441g.exists()) {
            C11839m.m70688i(TAG, "filterDataFile tempPackageDir not exist");
            return;
        }
        deleteFromTempDir(fileM63441g, arrayList, cloudBackupAppDataUtil, file);
        if (arrayList.isEmpty()) {
            C11839m.m70688i(TAG, "filterDataFile end deletePaths.isEmpty");
            return;
        }
        String[] list = fileM63441g.list();
        if (list != null && list.length > 0) {
            deleteTXTLine(file2, arrayList);
            C11839m.m70688i(TAG, "filterDataFile end");
        } else {
            C11839m.m70688i(TAG, "filterDataFile end deletePaths.isEmpty()");
            if (file2.exists() && !file2.delete()) {
                throw new C9721b(1017, "filterDataFile delete txt error");
            }
        }
    }

    private List<String> get3rdAppDataPaths() {
        ArrayList arrayList = new ArrayList();
        if (!this.needBackup3rdAppData) {
            return arrayList;
        }
        String dataTempDir = getDataTempDir(this.appId);
        File fileM63442h = C10278a.m63442h(dataTempDir);
        if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
            C11839m.m70688i(TAG, "get3rdAppDataPaths mkdir error, path: " + dataTempDir);
        }
        arrayList.add(dataTempDir);
        return arrayList;
    }

    private List<String> get3rdAppSdcardPaths() throws C9721b {
        ScanAppDataUtil scanAppDataUtil;
        ArrayList arrayList = new ArrayList();
        if (this.needBackup3rdAppData && (scanAppDataUtil = this.scanAppDataUtil) != null) {
            arrayList.addAll(scanAppDataUtil.getSdcardAndAndroidDataPaths(0));
        }
        return arrayList;
    }

    private String get3rdExtend(String str, String str2) throws C9721b, PackageManager.NameNotFoundException, SQLException {
        if (str2 == null) {
            BackupCacheRecord.delete(getContext(), str);
            this.snapshotTreeService.defaultRootNodeStatus(str, this.backupId);
            throw new C9721b(1009, "get package info path is null.");
        }
        C11839m.m70688i(TAG, "get3rdExtend begin, appId = " + str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(ICBUtil.getBundleBackupDirPath(this.location, str));
        String str3 = File.separator;
        sb2.append(str3);
        String string = sb2.toString();
        String str4 = ICBUtil.getHarmonyBackupDirPath(this.location, str) + str3;
        boolean zStartsWith = str2.startsWith(string);
        boolean zStartsWith2 = str2.startsWith(str4);
        boolean zM75528n = zStartsWith2 ? C12565k.m75528n(str) : false;
        PackageManager packageManager = getContext().getPackageManager();
        try {
            C11839m.m70688i(TAG, "get packageInfo");
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 16384);
            String string2 = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            String str5 = packageInfo.versionName;
            long longVersionCode = PackageInfoCompat.getLongVersionCode(packageInfo);
            C11839m.m70688i(TAG, "get app name and version code success");
            String installerPackageName = packageManager.getInstallerPackageName(str);
            String pkgChannelId = QueryAppMarketDataUtil.getPkgChannelId(getContext(), str);
            C11839m.m70688i(TAG, "get subSource: " + installerPackageName + ", pkgChannelId: " + pkgChannelId);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(SnapshotBackupMeta.KEY_STRING_APP_NAME);
            sb3.append("=");
            sb3.append(string2);
            sb3.append("&");
            sb3.append(SnapshotBackupMeta.KEY_STRING_APP_VERSION);
            sb3.append("=");
            sb3.append(str5);
            sb3.append("&");
            sb3.append(SnapshotBackupMeta.KEY_STRING_APP_VERSION_CODE);
            sb3.append("=");
            sb3.append(longVersionCode);
            sb3.append("&");
            sb3.append(SnapshotBackupMeta.KEY_STRING_APP_EXTEND);
            sb3.append("=");
            sb3.append(zStartsWith ? 1 : zStartsWith2 ? 2 : 0);
            sb3.append("&");
            sb3.append(CloudBackupConstant.ReportAppMarket.KEY_SUB_SOURCE);
            sb3.append("=");
            sb3.append(installerPackageName);
            sb3.append("&");
            sb3.append(CloudBackupConstant.ReportAppMarket.KEY_PKG_CHANNEL_ID);
            sb3.append("=");
            sb3.append(pkgChannelId);
            if (zM75528n) {
                sb3.append("&");
                sb3.append("ohosArk");
                sb3.append("=");
                sb3.append(1);
                sb3.append("&");
                sb3.append("ohosArkVersion");
                sb3.append("=");
                sb3.append(C12565k.m75516b(str, true));
            }
            String string3 = sb3.toString();
            String locationIconFilePath = ICBUtil.getLocationIconFilePath(this.location, str);
            C11839m.m70688i(TAG, "get icon file from packageInfo");
            ICBUtil.drawable2File(packageInfo.applicationInfo.loadIcon(packageManager), locationIconFilePath);
            C11839m.m70688i(TAG, "get3rdExtend end, appId = " + str);
            return string3;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            C11839m.m70689w(TAG, "name not fount. appId = " + str);
            BackupCacheRecord.delete(getContext(), str);
            this.snapshotTreeService.defaultRootNodeStatus(str, this.backupId);
            throw new C9721b(1998, "package name not found, appId =" + str, "get3rdExtend");
        }
    }

    private Context getContext() {
        return C0213f.m1377a();
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta> getCopyFilesMetas(java.lang.String r18, java.io.File r19, long r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.task.CloudBackupOneModuleTask.getCopyFilesMetas(java.lang.String, java.io.File, long):java.util.List");
    }

    private long[] getDirectorySnapshotBackupMetas(CloudBackupAppDataUtil cloudBackupAppDataUtil, String str, File file, long j10, boolean z10) throws Throwable {
        isCancel();
        long[] jArr = new long[2];
        long j11 = j10 + 1;
        if (!file.exists()) {
            return jArr;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!distinctFileAndDirectory(file, arrayList, arrayList2, cloudBackupAppDataUtil)) {
            return jArr;
        }
        String str2 = str + ".apk";
        long j12 = 0;
        long size = 0;
        long j13 = j11;
        for (File file2 : arrayList) {
            isCancel();
            String strM63452a = C10279b.m63452a(file2);
            String strTrim = file2.getName().trim();
            if (!checkFname(strTrim, strM63452a, str)) {
                if (isSounderFile(str, strTrim)) {
                    List<SnapshotBackupMeta> copyFilesMetas = getCopyFilesMetas(str, file2, j13);
                    int size2 = copyFilesMetas.size();
                    for (SnapshotBackupMeta snapshotBackupMeta : copyFilesMetas) {
                        if (snapshotBackupMeta != null) {
                            size += snapshotBackupMeta.getSize();
                            isCancel();
                            this.snapshotTreeService.addFileMeta(snapshotBackupMeta, this.backupId, false);
                        }
                    }
                    j12 += size2;
                    j13 += size2 * 2;
                } else if (strM63452a.endsWith(str2)) {
                    String str3 = get3rdExtend(str, C10279b.m63452a(file2));
                    long j14 = j13;
                    SnapshotBackupMeta snapshotBackupMetaCreateSnapshotLeafMeta = createSnapshotLeafMeta(str, file2, j13, z10);
                    snapshotBackupMetaCreateSnapshotLeafMeta.setType(C12565k.m75518d(str));
                    snapshotBackupMetaCreateSnapshotLeafMeta.setExtend(str3);
                    isCancel();
                    this.snapshotTreeService.addFileMeta(snapshotBackupMetaCreateSnapshotLeafMeta, this.backupId, false);
                    size += snapshotBackupMetaCreateSnapshotLeafMeta.getSize();
                    long j15 = j12 + 1;
                    long j16 = j14 + 2;
                    File fileM63442h = C10278a.m63442h(getIconPath(str));
                    if (fileM63442h.exists()) {
                        C11839m.m70688i(TAG, "addIconFileNode start, appId = " + str);
                        SnapshotBackupMeta snapshotBackupMetaCreateSnapshotLeafMeta2 = createSnapshotLeafMeta(str, fileM63442h, j16, z10);
                        snapshotBackupMetaCreateSnapshotLeafMeta2.setExtend(str3);
                        j15 = j12 + 2;
                        j16 = j14 + 4;
                        size += snapshotBackupMetaCreateSnapshotLeafMeta2.getSize();
                        isCancel();
                        this.snapshotTreeService.addFileMeta(snapshotBackupMetaCreateSnapshotLeafMeta2, this.backupId, false);
                    }
                    j12 = j15;
                    j13 = j16;
                } else {
                    isCancel();
                    SnapshotBackupMeta snapshotBackupMetaCreateSnapshotLeafMeta3 = createSnapshotLeafMeta(str, file2, j13, z10);
                    this.snapshotTreeService.addFileMeta(snapshotBackupMetaCreateSnapshotLeafMeta3, this.backupId, false);
                    size += snapshotBackupMetaCreateSnapshotLeafMeta3.getSize();
                    j12++;
                    j13 += 2;
                }
            }
        }
        long j17 = j13;
        char c10 = 0;
        arrayList.clear();
        for (File file3 : arrayList2) {
            long[] directorySnapshotBackupMetas = getDirectorySnapshotBackupMetas(cloudBackupAppDataUtil, str, file3, j17, z10);
            long j18 = directorySnapshotBackupMetas[c10];
            long j19 = directorySnapshotBackupMetas[1];
            SnapshotBackupMeta snapshotBackupMetaCreateSnapshotLeafMeta4 = createSnapshotLeafMeta(str, file3, j17, z10);
            j12 = j12 + 1 + j18;
            long left = snapshotBackupMetaCreateSnapshotLeafMeta4.getLeft() + (j18 * 2);
            j17 = left + 2;
            snapshotBackupMetaCreateSnapshotLeafMeta4.setRight(left + 1);
            snapshotBackupMetaCreateSnapshotLeafMeta4.setSize(j19);
            size += j19;
            isCancel();
            this.snapshotTreeService.addFileMeta(snapshotBackupMetaCreateSnapshotLeafMeta4, this.backupId, false);
            c10 = 0;
        }
        arrayList2.clear();
        isCancel();
        this.snapshotTreeService.addFileMeta(null, this.backupId, true);
        jArr[c10] = j12;
        jArr[1] = size;
        return jArr;
    }

    private long getGalleryDBSnapshotNode(String str, long j10) throws C9721b, SQLException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.location);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(HNConstants.DataType.MEDIA);
        sb2.append(str2);
        sb2.append(AlbumsTempScript.DATABASE_NAME);
        File fileM63442h = C10278a.m63442h(sb2.toString());
        List<Albums> listQueryAllAlbums = new AlbumOperator().queryAllAlbums();
        AlbumsTempOperator albumsTempOperator = new AlbumsTempOperator();
        albumsTempOperator.clear();
        albumsTempOperator.replace((Albums[]) listQueryAllAlbums.toArray(new Albums[listQueryAllAlbums.size()]));
        albumsTempOperator.close();
        if (listQueryAllAlbums.isEmpty()) {
            C11839m.m70688i(TAG, "empty albums!");
            return 0L;
        }
        SnapshotBackupMeta snapshotBackupMetaCreateSnapshotLeafMeta = createSnapshotLeafMeta(str, fileM63442h, j10, true);
        isCancel();
        this.snapshotTreeService.addFileMeta(snapshotBackupMetaCreateSnapshotLeafMeta, this.backupId, true);
        return 1L;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:39:0x0114
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:195)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:62)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.processExcHandler(ExcHandlersRegionMaker.java:144)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:77)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e0 A[PHI: r12
  0x00e0: PHI (r12v7 android.database.Cursor) = (r12v6 android.database.Cursor), (r12v9 android.database.Cursor) binds: [B:35:0x0102, B:28:0x00de] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private long getGallerySnapshotBackupMetas(java.lang.String r23, com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 505
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.task.CloudBackupOneModuleTask.getGallerySnapshotBackupMetas(java.lang.String, com.huawei.android.hicloud.cloudbackup.snapshottree.db.bean.SnapshotBackupMeta):long");
    }

    private String getIconPath(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.location);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(str);
        sb2.append(str2);
        sb2.append(str);
        sb2.append(".icon");
        return sb2.toString();
    }

    private long getMusicSnapshotBackupMetas(String str, SnapshotBackupMeta snapshotBackupMeta, MusicBackup musicBackup) throws C9721b, SQLException {
        int i10;
        this.snapshotTreeService.deleteMetaByAppId(str, this.backupId);
        List<MusicBackup.MusicFileData> allMusicMetas = musicBackup.getAllMusicMetas();
        long j10 = 1;
        long left = snapshotBackupMeta.getLeft() + 1;
        if (allMusicMetas == null || allMusicMetas.size() <= 0) {
            C11839m.m70689w(TAG, "getMusicSnapshotBackupMetas: no music data need to backup.");
            return 0L;
        }
        int size = allMusicMetas.size();
        long j11 = left;
        long j12 = 0;
        long j13 = 0;
        int i11 = 0;
        for (MusicBackup.MusicFileData musicFileData : allMusicMetas) {
            isCancel();
            int i12 = i11 + 1;
            String path = musicFileData.getPath();
            String musicApkName = musicFileData.getMusicApkName();
            try {
                SnapshotBackupMeta snapshotBackupMetaCreateSnapshotLeafMeta = createSnapshotLeafMeta(str, C10278a.m63442h(path), j11, true);
                snapshotBackupMetaCreateSnapshotLeafMeta.setAppSlice(musicApkName);
                j11 += 2;
                j12 += j10;
                long size2 = j13 + snapshotBackupMetaCreateSnapshotLeafMeta.getSize();
                try {
                    snapshotBackupMeta.setSize(size2);
                    isCancel();
                    i10 = i12;
                    try {
                        this.snapshotTreeService.addFileMeta(snapshotBackupMetaCreateSnapshotLeafMeta, this.backupId, i10 == size);
                        j13 = size2;
                    } catch (C9721b unused) {
                        j13 = size2;
                        C11839m.m70687e(TAG, "getMusicSnapshotBackupMetas get file md5 and hash error fPath = " + path);
                        i11 = i10;
                        j10 = 1;
                    }
                } catch (C9721b unused2) {
                    i10 = i12;
                }
            } catch (C9721b unused3) {
                i10 = i12;
            }
            i11 = i10;
            j10 = 1;
        }
        isCancel();
        this.snapshotTreeService.addFileMeta(null, this.backupId, true);
        this.snapshotTreeService.treeCreationCompleted(snapshotBackupMeta, 1 + snapshotBackupMeta.getLeft() + (2 * j12), j13);
        return j12;
    }

    private void initBackupConfigs() {
        this.backupConfigOperator = new C12526j();
        this.isSystemApp = C14333b.m85477l().contains(this.appId);
        if (this.cloudBackupAppDataUtil != null && this.rootMeta.isOmConfigAble() && this.rootMeta.getAppSwitch()) {
            this.needBackup3rdAppData = true;
            this.scanAppDataUtil = new ScanAppDataUtil(this.appId, this.cloudBackupAppDataUtil.getmCloudBackupInclude(), this.cloudBackupAppDataUtil.getmCloudBackupExclude());
        }
    }

    private boolean isFilterDataPath(File file, File file2, List<String> list, CloudBackupAppDataUtil cloudBackupAppDataUtil) throws C9721b {
        String strSubstring = SafeString.substring(C10279b.m63452a(file2), C10279b.m63452a(file).length() + 1);
        if (!isMatchOMPath(BackupRestoreConstans.DATA_PATH + strSubstring, cloudBackupAppDataUtil)) {
            return false;
        }
        list.add(strSubstring);
        return true;
    }

    private boolean isMatchOMPath(String str, CloudBackupAppDataUtil cloudBackupAppDataUtil) throws C9721b {
        boolean zIsMatchPathInfo = cloudBackupAppDataUtil.isMatchPathInfo(str, cloudBackupAppDataUtil.getmCloudBackupExclude(), true);
        C11839m.m70686d(TAG, "isMatchOMPath absultPath = " + str + " ," + zIsMatchPathInfo);
        return zIsMatchPathInfo;
    }

    private boolean isNeedScanData(SnapshotBackupMeta snapshotBackupMeta) {
        int status = snapshotBackupMeta.getStatus();
        if (status == 2 || status == 3) {
            long jM75408n0 = this.backupConfigOperator.m75408n0(this.autoBackup);
            long jCurrentTimeMillis = System.currentTimeMillis() - snapshotBackupMeta.getDateInvalid();
            if (jCurrentTimeMillis > 0 && jCurrentTimeMillis < jM75408n0) {
                return false;
            }
        } else if (status == 4) {
            long jM75406m0 = this.backupConfigOperator.m75406m0(this.autoBackup);
            long jCurrentTimeMillis2 = System.currentTimeMillis() - snapshotBackupMeta.getDateCreate();
            if (jCurrentTimeMillis2 > 0 && jCurrentTimeMillis2 < jM75406m0) {
                return false;
            }
        } else if (status == 5 || status == 6) {
            return false;
        }
        return true;
    }

    public static boolean isPmsBriefProcess(String str, String str2) {
        String strM81914C = C13617a.m81914C(str, 0);
        if (!C10278a.m63442h(strM81914C).exists()) {
            return false;
        }
        try {
            PmsMetaStatus pmsMetaStatusQuery = new PmsMetaStatusOperator(strM81914C).query();
            if (pmsMetaStatusQuery != null) {
                if (pmsMetaStatusQuery.getStatus() == 5) {
                    return true;
                }
            }
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "isPmsBriefProcess: " + e10.toString());
        }
        return false;
    }

    private boolean isSounderFile(String str, String str2) {
        return C14333b.m85477l().contains(str) && str.equals(str2);
    }

    private boolean isSystemApp() {
        return this.isSystemApp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scanMedialibFile$0(long j10, File file) throws C9721b {
        isCancel();
        this.snapshotTreeService.addFileMeta(createSnapshotLeafMeta(this.appId, file, j10, false), this.backupId, false);
    }

    private void matchAndWriteString(File file, String str, StringBuffer stringBuffer) throws Throwable {
        String string = stringBuffer.toString();
        if (TextUtils.isEmpty(string)) {
            C11839m.m70688i(TAG, "str is empty");
            return;
        }
        String strReplaceAll = Pattern.compile(str).matcher(string).replaceAll("");
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
                try {
                    fileOutputStream2.write(strReplaceAll.getBytes(Constants.UTF_8));
                    C0209d.m1263i(fileOutputStream2);
                } catch (FileNotFoundException unused) {
                    throw new C9721b(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "matchAndWriteString FileNotFoundException");
                } catch (IOException unused2) {
                    throw new C9721b(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "matchAndWriteString IOException");
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    C0209d.m1263i(fileOutputStream);
                    throw th;
                }
            } catch (FileNotFoundException unused3) {
            } catch (IOException unused4) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void pmsCopyAppData(ScanAppDataUtil scanAppDataUtil, CloudBackupAppDataUtil cloudBackupAppDataUtil) throws Throwable {
        String dataTempDir = getDataTempDir(this.appId);
        File fileM63442h = C10278a.m63442h(dataTempDir);
        this.backupStatus.mo29449x0(1);
        new C12815f().m76934m(this.backupStatus);
        BackupCacheRecord.delete(getContext(), this.appId);
        C12571m.m75547i(dataTempDir);
        scanAppDataUtil.appDataPrepare(dataTempDir, this.callback, this.appId);
        File fileM63441g = C10278a.m63441g(fileM63442h, this.appId + ".txt");
        filterDataFile(fileM63442h, fileM63441g, cloudBackupAppDataUtil);
        filterAbnormalFile(fileM63442h, fileM63441g);
    }

    private void scan3rdAppCloneFiles(CloudBackupAppDataUtil cloudBackupAppDataUtil, String str, SnapshotBackupMeta snapshotBackupMeta) throws Throwable {
        isCancel();
        C11839m.m70688i(TAG, "scan3rdAppCloneFiles begin, " + str);
        String str2 = this.location + File.separator + str;
        File fileM63442h = C10278a.m63442h(str2);
        if (!fileM63442h.exists()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "scan3rdAppCloneFiles error path = " + str2 + " is not exist");
        }
        long[] directorySnapshotBackupMetas = getDirectorySnapshotBackupMetas(cloudBackupAppDataUtil, str, fileM63442h, snapshotBackupMeta.getLeft(), true);
        this.snapshotTreeService.treeCreationCompleted(snapshotBackupMeta, snapshotBackupMeta.getLeft() + (directorySnapshotBackupMetas[0] * 2) + 1, directorySnapshotBackupMetas[1]);
        C11839m.m70688i(TAG, "scan3rdAppCloneFiles end, " + str);
    }

    private void scan3rdAppDataFiles(List<String> list, CloudBackupAppDataUtil cloudBackupAppDataUtil, String str, SnapshotBackupMeta snapshotBackupMeta) throws Throwable {
        isCancel();
        long right = snapshotBackupMeta.getRight();
        long size = snapshotBackupMeta.getSize();
        C11839m.m70688i(TAG, "scan3rdAppDataFiles begin, " + str);
        long j10 = right;
        long size2 = size;
        for (String str2 : list) {
            File fileM63442h = C10278a.m63442h(str2);
            if (!fileM63442h.exists()) {
                this.snapshotTreeService.defaultRootNodeStatus(str, this.backupId);
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "scan3rdAppDataFiles error path = " + str2 + " is not exist");
            }
            if (fileM63442h.isDirectory() && !checkFileList(C10278a.m63440f(fileM63442h))) {
                SnapshotBackupMeta snapshotBackupMetaCreateSnapshotLeafMeta = createSnapshotLeafMeta(str, fileM63442h, j10, true);
                long[] directorySnapshotBackupMetas = getDirectorySnapshotBackupMetas(cloudBackupAppDataUtil, str, fileM63442h, snapshotBackupMetaCreateSnapshotLeafMeta.getLeft(), true);
                long j11 = directorySnapshotBackupMetas[0];
                this.snapshotTreeService.treeCreationCompleted(snapshotBackupMetaCreateSnapshotLeafMeta, snapshotBackupMetaCreateSnapshotLeafMeta.getLeft() + (2 * j11) + 1, directorySnapshotBackupMetas[1]);
                if (j11 == 0) {
                    C11839m.m70686d(TAG, "node child is empty path :" + str2);
                } else {
                    long right2 = snapshotBackupMetaCreateSnapshotLeafMeta.getRight() + 1;
                    size2 += snapshotBackupMetaCreateSnapshotLeafMeta.getSize();
                    j10 = right2;
                }
            }
        }
        this.snapshotTreeService.treeCreationCompleted(snapshotBackupMeta, j10, size2);
        isCancel();
        this.snapshotTreeService.addFileMeta(null, this.backupId, true);
        C11839m.m70688i(TAG, "scan3rdAppDataFiles end, " + str);
    }

    private void scan3rdAppDataFilesByPmsBriefDb(List<String> list, String str, SnapshotBackupMeta snapshotBackupMeta) throws C9721b, SQLException {
        isCancel();
        if (list.isEmpty()) {
            C11839m.m70688i(TAG, "scan3rdAppDataFilesByPmsBriefDb paths is empty");
            return;
        }
        C11839m.m70688i(TAG, "scan3rdAppDataFilesByPmsBriefDb begin, " + str);
        File databasePath = C0213f.m1378b().getDatabasePath(SnapshotDBManager.getDBName(this.backupId));
        if (databasePath == null || !databasePath.exists()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "scan3rdAppDataFilesByPmsBriefDb error, backupId: " + this.backupId + " snapshot db is not exist");
        }
        PmsFullBriefFilesInfoOperator pmsFullBriefFilesInfoOperator = new PmsFullBriefFilesInfoOperator(C13617a.m81914C(str, 0));
        long jQuerySum = pmsFullBriefFilesInfoOperator.querySum();
        int iQueryCount = pmsFullBriefFilesInfoOperator.queryCount();
        C11839m.m70688i(TAG, "scan3rdAppDataFilesByPmsBriefDb pmsMetaSize: " + jQuerySum + ", pmsMetaCount: " + iQueryCount);
        if (iQueryCount <= 0) {
            C11839m.m70688i(TAG, "scan3rdAppDataFilesByPmsBriefDb no pms data");
            return;
        }
        pmsFullBriefFilesInfoOperator.attach(databasePath.getPath());
        try {
            try {
                pmsFullBriefFilesInfoOperator.pmsMetaToSnapshot(str);
                pmsFullBriefFilesInfoOperator.detach();
                this.fileSize += jQuerySum;
                snapshotBackupMeta.setSize(snapshotBackupMeta.getSize() + jQuerySum);
                File fileM63442h = C10278a.m63442h(getDataTempDir(str) + File.separator + str + ".txt");
                if (!fileM63442h.exists()) {
                    new PmsMetaStatusOperator(C13617a.m81914C(str, 0)).clear();
                    pmsFullBriefFilesInfoOperator.clear();
                    throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "v2 scan3rdAppDataFilesByPmsBriefDb error, txtFile not exist or count is 0");
                }
                isCancel();
                SnapshotTreeManagementService.getInstance().addFileMeta(createSnapshotLeafMeta(str, fileM63442h, snapshotBackupMeta.getLeft(), true), this.backupId, true);
                C11839m.m70688i(TAG, "scan3rdAppDataFilesByPmsBriefDb end, " + str);
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "pmsMetaToSnapshot error: " + e10.toString());
                throw e10;
            }
        } catch (Throwable th2) {
            pmsFullBriefFilesInfoOperator.detach();
            throw th2;
        }
    }

    private void scan3rdAppSdcardFiles(List<String> list, CloudBackupAppDataUtil cloudBackupAppDataUtil, String str, SnapshotBackupMeta snapshotBackupMeta) throws Throwable {
        isCancel();
        long right = snapshotBackupMeta.getRight();
        long size = snapshotBackupMeta.getSize();
        scanMedialibFile(right, new ScanAppDataUtil(str, cloudBackupAppDataUtil.getmCloudBackupInclude(), cloudBackupAppDataUtil.getmCloudBackupExclude()));
        C11839m.m70688i(TAG, "scan3rdAppSdcardFiles begin, " + str);
        long j10 = right;
        long size2 = size;
        for (String str2 : list) {
            File fileM63442h = C10278a.m63442h(str2);
            if (!fileM63442h.exists()) {
                this.snapshotTreeService.defaultRootNodeStatus(str, this.backupId);
                throw new C9721b(FamilyShareConstants.StatusCode.SHARE_SPACE_NOT_ENOUGH, "scan3rdAppSdcardFiles error path = " + str2 + " is not exist");
            }
            if (fileM63442h.isDirectory() && !checkFileList(C10278a.m63440f(fileM63442h))) {
                SnapshotBackupMeta snapshotBackupMetaCreateSnapshotLeafMeta = createSnapshotLeafMeta(str, fileM63442h, j10, false);
                long[] directorySnapshotBackupMetas = getDirectorySnapshotBackupMetas(cloudBackupAppDataUtil, str, fileM63442h, snapshotBackupMetaCreateSnapshotLeafMeta.getLeft(), false);
                long j11 = directorySnapshotBackupMetas[0];
                this.snapshotTreeService.treeCreationCompleted(snapshotBackupMetaCreateSnapshotLeafMeta, snapshotBackupMetaCreateSnapshotLeafMeta.getLeft() + (2 * j11) + 1, directorySnapshotBackupMetas[1]);
                if (j11 == 0) {
                    C11839m.m70686d(TAG, "scan3rdAppSdcardFiles node child is empty path :" + str2);
                } else {
                    long right2 = snapshotBackupMetaCreateSnapshotLeafMeta.getRight() + 1;
                    size2 += snapshotBackupMetaCreateSnapshotLeafMeta.getSize();
                    j10 = right2;
                }
            }
        }
        this.snapshotTreeService.treeCreationCompleted(snapshotBackupMeta, j10, size2);
        isCancel();
        this.snapshotTreeService.addFileMeta(null, this.backupId, true);
        C11839m.m70688i(TAG, "scan3rdAppSdcardFiles end, " + str);
    }

    private void scanMedialibFile(final long j10, ScanAppDataUtil scanAppDataUtil) {
        scanAppDataUtil.startScanMediaFile(new ScanMediaCallback() { // from class: com.huawei.android.hicloud.cloudbackup.process.task.e
            @Override // com.huawei.android.hicloud.cloudbackup.process.task.ScanMediaCallback
            public final void onScanEnd(File file) throws C9721b {
                this.f11719a.lambda$scanMedialibFile$0(j10, file);
            }
        });
    }

    private void sendPrepareProgress() {
        int i10 = this.fileNum;
        if (i10 < 4) {
            return;
        }
        this.backupStatus.mo29310W(i10).mo29308V(this.fileSize);
        C11963c.m71970y(this.backupStatus, "auto");
    }

    private void tarBundleApk(String str, File[] fileArr) throws C9721b {
        HashSet hashSet = new HashSet();
        hashSet.add(str);
        TarFileUtil tarFileUtil = new TarFileUtil(hashSet, true);
        File fileM63442h = C10278a.m63442h(str + "/" + this.appId + ".apk");
        ArrayList<File> arrayList = new ArrayList();
        try {
            for (File file : fileArr) {
                isCancel();
                if (file != null && file.length() > 0) {
                    tarFileUtil.tarFile(fileM63442h, file);
                    arrayList.add(file);
                }
            }
            File fileEndCurrentTar = tarFileUtil.endCurrentTar(fileM63442h);
            tarFileUtil.closeTarStream();
            if (arrayList.isEmpty()) {
                throw new C9721b(2005, "tar apk error files size all zero. " + this.appId);
            }
            boolean z10 = fileEndCurrentTar != null && fileEndCurrentTar.exists();
            if (!z10 || !fileEndCurrentTar.renameTo(fileM63442h)) {
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "tar apk error exists: " + z10 + " ,appId: " + this.appId);
            }
            C11839m.m70688i(TAG, "tar end ");
            for (File file2 : arrayList) {
                if (!file2.delete()) {
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "delete origin apk error: " + file2.getName() + " ,appId: " + this.appId);
                }
            }
            C11839m.m70688i(TAG, "delete origin apk end ");
        } catch (Throwable th2) {
            tarFileUtil.closeTarStream();
            throw th2;
        }
    }

    public boolean backup3rdAppDataByPms(boolean z10, CloudBackupAppDataUtil cloudBackupAppDataUtil) throws Throwable {
        if (!this.needBackup3rdAppData) {
            return z10;
        }
        C11839m.m70688i(TAG, "backup3rdAppDataByPms, appid = " + this.appId + ", lastSuccessBackupId: " + this.lastSuccessBackupId);
        if (ICBUtil.isForGroundProcess(this.appId, getContext(), this.backupStatus.m29861N(), null)) {
            C11839m.m70689w(TAG, "isForeGroundProcess = " + this.appId);
            if (!cloudBackupAppDataUtil.isBackupForegroundApp()) {
                throw new C9721b(FamilyShareConstants.StatusCode.SHARE_UNUSED_SPACE_NOT_ENOUGH, "ForeGroundProcess is running");
            }
            if (cloudBackupAppDataUtil.isKillForegroundApp()) {
                ICBUtil.closeBackGroundProcess(this.appId, getContext(), this.backupStatus.m29861N());
            }
        } else if (cloudBackupAppDataUtil.isKillBackgroundApp()) {
            ICBUtil.closeBackGroundProcess(this.appId, getContext(), this.backupStatus.m29861N());
        }
        if (!z10) {
            pmsCopyAppData(this.scanAppDataUtil, this.cloudBackupAppDataUtil);
            return false;
        }
        int iBackup3rdAppDataIncrement = new PmsDataManagement(this.appId, this.client, this.lastSuccessBackupId, "V2", this.backupId, "V2", this.dataLocation, this.scanAppDataUtil, this.callback, this.backupStatus, this.autoBackup).backup3rdAppDataIncrement(0);
        if (iBackup3rdAppDataIncrement != -4) {
            if (iBackup3rdAppDataIncrement == -3) {
                pmsCopyAppData(this.scanAppDataUtil, this.cloudBackupAppDataUtil);
                return false;
            }
            if (iBackup3rdAppDataIncrement != -2 && iBackup3rdAppDataIncrement != -1) {
                if (iBackup3rdAppDataIncrement != 0) {
                    return true;
                }
                PmsMetaStatusOperator pmsMetaStatusOperator = new PmsMetaStatusOperator(C13617a.m81914C(this.appId, 0));
                if (pmsMetaStatusOperator.query() != null) {
                    pmsMetaStatusOperator.updateModifytime(System.currentTimeMillis());
                }
                return true;
            }
        }
        C11839m.m70689w(TAG, "PackageManagerEx finishBackupSession fail " + this.appId);
        return true;
    }

    public void backupDataByClone(Bundle bundle) throws InterruptedException, C9721b {
        String str = this.location + File.separator + this.appId;
        BackupCacheRecord.delete(getContext(), this.appId);
        C12571m.m75547i(str);
        if (C10278a.m63442h(str).exists()) {
            C11839m.m70688i(TAG, "use pms move delete cache file, path = " + str);
            ScanAppDataUtil.executePmsMoveProcess(str);
        }
        doBackupOneModule(bundle, 0);
        if (isSystemApp()) {
            return;
        }
        CloudBackupStatus cloudBackupStatus = new CloudBackupStatus();
        cloudBackupStatus.mo29313Y(this.appId);
        cloudBackupStatus.mo29340B0(0);
        cloudBackupStatus.mo29413k0(this.appId);
        C12590s0.m75766L(cloudBackupStatus, this.location);
    }

    public void buildModuleSnapshotTree(SnapshotBackupMeta snapshotBackupMeta, MusicBackup musicBackup) throws Throwable {
        snapshotBackupMeta.setSize(0L);
        this.fileNum = 0;
        this.fileSize = 0L;
        ICBUtil.checkDataLocalLimitSpace("build module snapshot tree, left space: ");
        if (HNConstants.DataType.MEDIA.equals(this.appId)) {
            getGallerySnapshotBackupMetas(this.appId, snapshotBackupMeta);
        } else if ("music".equals(this.appId)) {
            getMusicSnapshotBackupMetas(this.appId, snapshotBackupMeta, musicBackup);
        } else if (isSystemApp()) {
            buildSystemAppSnapshotTree(this.appId, snapshotBackupMeta);
        } else if (this.isVirtual) {
            String strM75305p = new C12519c().m75305p(this.appId);
            C11839m.m70688i(TAG, "virtual app showType=" + strM75305p);
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(snapshotBackupMeta.getExtend())) {
                sb2.append(snapshotBackupMeta.getExtend());
                sb2.append("&");
            }
            sb2.append(SnapshotBackupMeta.KEY_SHOW_TYPE);
            sb2.append("=");
            sb2.append(strM75305p);
            build3rdSdCardSnapshotTree(this.appId, snapshotBackupMeta);
            long jQueryMetasSizeByAppId = new SnapshotBackupMetaOperator(this.backupId).queryMetasSizeByAppId(this.appId);
            sb2.append("&");
            sb2.append("count");
            sb2.append("=");
            sb2.append(jQueryMetasSizeByAppId);
            snapshotBackupMeta.setExtend(sb2.toString());
        } else {
            build3rdAppSnapshotTree(this.appId, snapshotBackupMeta);
        }
        this.snapshotTreeService.endTree(this.appId, this.backupId);
        snapshotBackupMeta.setDateModify(System.currentTimeMillis());
        snapshotBackupMeta.setStatus(3);
        this.snapshotTreeService.updateRootNode(this.backupId, snapshotBackupMeta);
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void call() {
    }

    public void condition() {
        this.abort = true;
    }

    public CloudBackupAppDataUtil getCloudBackupAppDataUtil() {
        return this.cloudBackupAppDataUtil;
    }

    public String getDataTempDir(String str) {
        return this.dataLocation + File.separator + str;
    }

    public int getFileNum() {
        return this.fileNum;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getLocation() {
        return this.location;
    }

    public boolean getNeedBackup3rdAppData() {
        return this.needBackup3rdAppData;
    }

    public void isCancel() throws C9721b {
        IOneModuleTaskCallback iOneModuleTaskCallback = this.mModuleTaskCallback;
        if (iOneModuleTaskCallback != null) {
            iOneModuleTaskCallback.isCancel();
        }
    }

    public void setFileSize(long j10) {
        this.fileSize = j10;
    }

    public void setMetaHashInfo(File file, SnapshotBackupMeta snapshotBackupMeta) throws C9721b {
        SnapshotTreeUtil.setMetaHashInfo(file, snapshotBackupMeta, this.location);
    }

    public void setModuleTaskCallback(IOneModuleTaskCallback iOneModuleTaskCallback) {
        this.mModuleTaskCallback = iOneModuleTaskCallback;
    }
}
