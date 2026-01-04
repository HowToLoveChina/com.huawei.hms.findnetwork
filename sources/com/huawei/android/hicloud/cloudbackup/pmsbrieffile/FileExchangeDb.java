package com.huawei.android.hicloud.cloudbackup.pmsbrieffile;

import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMeta;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaBaseOperator;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreConstans;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.secure.android.common.util.SafeString;
import fk.C9721b;
import hk.C10278a;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import om.C11963c;
import p015ak.C0209d;
import p015ak.C0241z;
import p514o9.C11839m;
import p618rm.C12583q;
import p618rm.C12585q1;
import p618rm.C12590s0;

/* loaded from: classes2.dex */
public class FileExchangeDb {
    private static final int BATCH_REPLACE_SIZE = 120;
    private static final Object EXCEPTION_LOCK = new Object();
    private static final int PMS_TXT_SPLITE_SIZE = 5;
    private static final String TAG = "PMSFileExchangeDb";
    private String dataPathPrefix;
    private List<String> excludeDataPath;
    private String mAppId;
    private int mAppType;
    private CloudBackupStatus mBackupStatus;
    private C9721b mCException;
    private int mIndex;
    private boolean mIsRefurbish;
    private boolean mIsTempBackup;
    private List<PmsMeta> mPMSdataMetas;
    private String mPath;
    private int mUid;
    private String originAppId;
    private ProgressCallback progressCallback;

    public FileExchangeDb(ProgressCallback progressCallback, String str) {
        this.mPMSdataMetas = new ArrayList();
        this.originAppId = "";
        this.progressCallback = progressCallback;
        this.mAppId = str;
        this.mUid = 0;
        this.dataPathPrefix = BackupRestoreConstans.DATA_USER_PATH + this.mUid + File.separator;
    }

    private void batchReplaceToDb(PmsMetaBaseOperator pmsMetaBaseOperator, boolean z10) throws C9721b {
        if (this.mPMSdataMetas.size() > 120 || z10) {
            ProgressCallback progressCallback = this.progressCallback;
            if (progressCallback != null && progressCallback.onStop()) {
                C11839m.m70687e(TAG, "pms data management backup is stop");
                throw new C9721b(1001, "pms data management backup is stop");
            }
            try {
                try {
                    pmsMetaBaseOperator.batchReplace(this.mPMSdataMetas);
                } catch (C9721b e10) {
                    C11839m.m70689w(TAG, "insertCustInfo error: " + e10.toString());
                }
            } finally {
                this.mPMSdataMetas.clear();
            }
        }
    }

    private String getName(String str) {
        int iLastIndexOf = str.lastIndexOf("/") + 1;
        int length = str.length();
        if (iLastIndexOf < length) {
            return str.substring(iLastIndexOf, length);
        }
        C11839m.m70686d(TAG, "getName start >= end: " + str);
        return "";
    }

    private String getPmsDataString(PmsMeta pmsMeta) {
        return pmsMeta.getFilePath() + ";" + pmsMeta.getMode() + ";" + pmsMeta.getIsdir() + ";" + pmsMeta.getSize() + ";" + (pmsMeta.getModifytime() / 1000) + "\n";
    }

    private String getSnapshotData(String str) {
        String strSubstring = str.substring(str.indexOf(this.originAppId));
        StringBuilder sb2 = new StringBuilder();
        if (this.mUid == 0) {
            sb2.append("data");
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append(this.mAppId);
            sb2.append(str2);
            sb2.append(strSubstring);
        } else {
            sb2.append("data");
            String str3 = File.separator;
            sb2.append(str3);
            sb2.append(this.mAppId);
            sb2.append(str3);
            sb2.append(strSubstring.replaceFirst(this.originAppId, this.mAppId));
        }
        return sb2.toString();
    }

    private void insertTarPmsMetaInfo(String[] strArr, PmsMetaBaseOperator pmsMetaBaseOperator, boolean z10) throws C9721b {
        if (isStrIllegal(strArr)) {
            batchReplaceToDb(pmsMetaBaseOperator, z10);
            return;
        }
        PmsMeta pmsMetaObj = pmsMetaBaseOperator.getPmsMetaObj();
        String snapshotData = getSnapshotData(strArr[0]);
        if (ICBUtil.hasEmojiCharacter(snapshotData)) {
            snapshotData = ICBUtil.getEncodedPath(snapshotData);
            pmsMetaObj.setEncoded(1);
        }
        String name = getName(strArr[0]);
        int i10 = this.mIndex;
        this.mIndex = i10 + 1;
        pmsMetaObj.setId(i10);
        pmsMetaObj.setName(name);
        pmsMetaObj.setFilePath(strArr[0]);
        pmsMetaObj.setData(snapshotData);
        pmsMetaObj.setMode(strArr[1]);
        pmsMetaObj.setIsdir(C0241z.m1685c(strArr[2]));
        pmsMetaObj.setSize(C0241z.m1688f(strArr[3]));
        pmsMetaObj.setModifytime(C0241z.m1688f(strArr[4]) * 1000);
        pmsMetaObj.setData2("1");
        this.mPMSdataMetas.add(pmsMetaObj);
        batchReplaceToDb(pmsMetaBaseOperator, z10);
    }

    private boolean isFilterExcludeDataPath(PmsMeta pmsMeta, ScanAppDataUtil scanAppDataUtil) throws C9721b {
        if (this.excludeDataPath == null) {
            this.excludeDataPath = scanAppDataUtil.getExcludeDataPathWithRegex(this.originAppId);
        }
        if (this.excludeDataPath.isEmpty()) {
            return false;
        }
        String filePath = pmsMeta.getFilePath();
        if (filePath == null) {
            C11839m.m70688i(TAG, "isFilterExcludeDataPath path is null");
            return true;
        }
        if (filePath.startsWith(BackupRestoreConstans.DATA_USER_PATH)) {
            filePath = BackupRestoreConstans.DATA_PATH + SafeString.substring(filePath, this.dataPathPrefix.length());
        }
        for (String str : this.excludeDataPath) {
            if (str.startsWith(BackupRestoreConstans.DATA_PATH)) {
                if ((filePath.endsWith("/") ? filePath : filePath + "/").startsWith(str)) {
                    return true;
                }
            } else if (str.startsWith("REG:/data/data/") || str.startsWith("REG:^/data/data/")) {
                if (C12585q1.m75706p(filePath, str.substring(4))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isStrIllegal(String[] strArr) {
        if (strArr.length < 5 || strArr.length > 5) {
            C11839m.m70689w(TAG, "isStrIllegal: " + strArr.length);
            return true;
        }
        String str = strArr[0];
        if (str == null || !str.startsWith("/")) {
            C11839m.m70689w(TAG, "isStrIllegal firstStr: " + str);
            return true;
        }
        if (str.contains(this.originAppId)) {
            return false;
        }
        C11839m.m70689w(TAG, "isStrIllegal firstStr: " + str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$readDbToTxtFile$0(File file, String str, List list, int i10) throws Throwable {
        readDbToTxt(list, file, str);
    }

    private void readDbToTxt(List<PmsMeta> list, File file, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        int iM60659c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, true);
            } catch (FileNotFoundException e10) {
                e = e10;
            } catch (IOException e11) {
                e = e11;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            } catch (FileNotFoundException e12) {
                e = e12;
            } catch (IOException e13) {
                e = e13;
            } catch (Throwable th3) {
                th = th3;
                C0209d.m1263i(bufferedOutputStream2);
                C0209d.m1263i(fileOutputStream);
                throw th;
            }
            try {
                C11839m.m70688i(TAG, "readDbToTxt begin");
                int i10 = 0;
                for (PmsMeta pmsMeta : list) {
                    if (isError()) {
                        C11839m.m70687e(TAG, "readDbToTxt is error");
                        String message = "";
                        C9721b c9721b = this.mCException;
                        if (c9721b != null) {
                            message = c9721b.getMessage();
                            iM60659c = this.mCException.m60659c();
                        } else {
                            iM60659c = 1008;
                        }
                        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "readDbToTxt is error,code:  " + iM60659c + ", error：" + message);
                    }
                    if (pmsMeta.getName().endsWith(".dbhashfile") || pmsMeta.getName().endsWith(".differencepacket")) {
                        C11839m.m70688i(TAG, "jump over diff pack");
                    } else if (pmsMeta.getIsvalid() != 2 && (pmsMeta.getStatus() == 1 || pmsMeta.getStatus() == 2 || pmsMeta.getStatus() == 3)) {
                        bufferedOutputStream.write(getPmsDataString(pmsMeta).getBytes(StandardCharsets.UTF_8));
                        i10++;
                    }
                }
                CloudBackupStatus cloudBackupStatus = this.mBackupStatus;
                if (cloudBackupStatus != null) {
                    this.mBackupStatus.mo29437t0(cloudBackupStatus.m29883s() + list.size());
                    C11963c.m71970y(this.mBackupStatus, str);
                }
                bufferedOutputStream.flush();
                ProgressCallback progressCallback = this.progressCallback;
                if (progressCallback != null && progressCallback.onStop()) {
                    C11839m.m70687e(TAG, "pms data management backup is stop");
                    throw new C9721b(1001, "pms data management backup is stop");
                }
                C11839m.m70688i(TAG, "readDbToTxt flush, count = " + i10 + " ,duration: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                C0209d.m1263i(bufferedOutputStream);
                C0209d.m1263i(fileOutputStream);
            } catch (FileNotFoundException e14) {
                e = e14;
                throw new C9721b(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "readDbToTxt FileNotFoundException " + e.toString());
            } catch (IOException e15) {
                e = e15;
                throw new C9721b(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "readDbToTxt IOException " + e.toString());
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream2 = bufferedOutputStream;
                C0209d.m1263i(bufferedOutputStream2);
                C0209d.m1263i(fileOutputStream);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
        }
    }

    public void insertCustInfo(String[] strArr, PmsMetaBaseOperator pmsMetaBaseOperator, boolean z10, boolean z11, ScanAppDataUtil scanAppDataUtil) throws C9721b {
        if (isStrIllegal(strArr)) {
            batchReplaceToDb(pmsMetaBaseOperator, z10);
            return;
        }
        PmsMeta pmsMetaObj = pmsMetaBaseOperator.getPmsMetaObj();
        String snapshotData = getSnapshotData(strArr[0]);
        if (ICBUtil.hasEmojiCharacter(snapshotData)) {
            snapshotData = ICBUtil.getEncodedPath(snapshotData);
            pmsMetaObj.setEncoded(1);
        }
        String name = getName(strArr[0]);
        int i10 = this.mIndex;
        this.mIndex = i10 + 1;
        pmsMetaObj.setId(i10);
        pmsMetaObj.setName(name);
        pmsMetaObj.setFilePath(strArr[0]);
        pmsMetaObj.setData(snapshotData);
        pmsMetaObj.setMode(strArr[1]);
        pmsMetaObj.setIsdir(C0241z.m1685c(strArr[2]));
        pmsMetaObj.setSize(C0241z.m1688f(strArr[3]));
        pmsMetaObj.setModifytime(C0241z.m1688f(strArr[4]) * 1000);
        if (C12590s0.m75819Y0(pmsMetaObj, this.mUid, this.mAppId, this.mAppType, this.mIsRefurbish, this.mIsTempBackup)) {
            pmsMetaObj.setData2("1");
        }
        if (z11) {
            String data = pmsMetaObj.getData();
            if (this.mBackupStatus.mo29370Q() && data != null && data.startsWith(this.originAppId)) {
                data = data.replaceFirst(this.originAppId, this.mAppId);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ICBUtil.RELATIVE_SDATA_PATH);
            String str = File.separator;
            sb2.append(str);
            sb2.append(data);
            String string = sb2.toString();
            if (pmsMetaObj.getEncoded() == 1) {
                string = ICBUtil.RELATIVE_SDATA_PATH + str + ICBUtil.getDecodedPath(data);
            }
            String strM75659M = C12583q.m75659M(string, 0, this.mUid);
            if (!C10278a.m63442h(strM75659M).exists()) {
                C11839m.m70689w(TAG, "insertCustInfo, file : " + strM75659M + " , not exist");
                return;
            }
        }
        if (!isFilterExcludeDataPath(pmsMetaObj, scanAppDataUtil)) {
            this.mPMSdataMetas.add(pmsMetaObj);
        }
        batchReplaceToDb(pmsMetaBaseOperator, z10);
    }

    public boolean isError() {
        boolean z10;
        synchronized (EXCEPTION_LOCK) {
            z10 = this.mCException != null;
        }
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void readDbToTxtFile(java.lang.String r5, com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaBaseOperator r6, final java.lang.String r7) throws fk.C9721b {
        /*
            r4 = this;
            java.lang.String r0 = "PMSFileExchangeDb"
            r4.mPath = r5
            int r5 = r6.queryCount()     // Catch: fk.C9721b -> L1f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: fk.C9721b -> L1d
            r1.<init>()     // Catch: fk.C9721b -> L1d
            java.lang.String r2 = "readDbToTxtFile query count = "
            r1.append(r2)     // Catch: fk.C9721b -> L1d
            r1.append(r5)     // Catch: fk.C9721b -> L1d
            java.lang.String r1 = r1.toString()     // Catch: fk.C9721b -> L1d
            p514o9.C11839m.m70688i(r0, r1)     // Catch: fk.C9721b -> L1d
            goto L39
        L1d:
            r1 = move-exception
            goto L21
        L1f:
            r1 = move-exception
            r5 = 0
        L21:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "queryCount error: "
            r2.append(r3)
            java.lang.String r1 = r1.toString()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            p514o9.C11839m.m70689w(r0, r1)
        L39:
            if (r5 > 0) goto L41
            java.lang.String r5 = "allCount <= 0"
            p514o9.C11839m.m70689w(r0, r5)
            goto L90
        L41:
            java.lang.String r5 = r4.mPath
            java.io.File r5 = hk.C10278a.m63442h(r5)
            boolean r1 = r5.exists()
            if (r1 == 0) goto L83
            boolean r1 = r5.delete()
            if (r1 == 0) goto L54
            goto L83
        L54:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "readDbToTxtFile delete failed: "
            r5.append(r6)
            java.lang.String r7 = r4.mPath
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            p514o9.C11839m.m70687e(r0, r5)
            fk.b r5 = new fk.b
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            java.lang.String r4 = r4.mPath
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            r6 = 1008(0x3f0, float:1.413E-42)
            r5.<init>(r6, r4)
            throw r5
        L83:
            com.huawei.android.hicloud.cloudbackup.pmsbrieffile.db.QueryAllPmsMetaIndexBuilder r0 = new com.huawei.android.hicloud.cloudbackup.pmsbrieffile.db.QueryAllPmsMetaIndexBuilder
            r0.<init>(r6)
            com.huawei.android.hicloud.cloudbackup.pmsbrieffile.a r6 = new com.huawei.android.hicloud.cloudbackup.pmsbrieffile.a
            r6.<init>()
            r0.batchExecute(r6)
        L90:
            com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus r5 = r4.mBackupStatus
            if (r5 == 0) goto L9c
            r5.m29445v2()
            com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus r4 = r4.mBackupStatus
            om.C11963c.m71970y(r4, r7)
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.pmsbrieffile.FileExchangeDb.readDbToTxtFile(java.lang.String, com.huawei.android.hicloud.cloudbackup.pmsbrieffile.db.operator.PmsMetaBaseOperator, java.lang.String):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.io.Closeable, java.io.InputStreamReader, java.io.Reader] */
    public void readDestTarTxtFileToDb(PmsMetaBaseOperator pmsMetaBaseOperator, File file) throws Throwable {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader = null;
        try {
            try {
                C11839m.m70688i(TAG, "readDestTarTxtFileToDb start ");
                fileInputStream = new FileInputStream((File) file);
                try {
                    file = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(file);
                        try {
                            String line = bufferedReader2.readLine();
                            int i10 = 0;
                            while (line != null) {
                                i10++;
                                String[] strArrSplit = line.split(";");
                                String line2 = bufferedReader2.readLine();
                                insertTarPmsMetaInfo(strArrSplit, pmsMetaBaseOperator, line2 == null);
                                line = line2;
                            }
                            C11839m.m70688i(TAG, "readDestTarTxtFileToDb sum = " + i10);
                            C0209d.m1263i(bufferedReader2);
                            C0209d.m1263i(file);
                            C0209d.m1263i(fileInputStream);
                        } catch (FileNotFoundException e10) {
                            e = e10;
                            C11839m.m70687e(TAG, "readDestTarTxtFileToDb FileNotFoundException: " + e.toString());
                            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "readDestTarTxtFileToDb FileNotFoundException delete error " + e.toString());
                        } catch (IOException e11) {
                            e = e11;
                            C11839m.m70687e(TAG, "readDestTarTxtFileToDb IOException: " + e.toString());
                            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "readDestTarTxtFileToDb IOException delete error " + e.toString());
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader2;
                            C0209d.m1263i(bufferedReader);
                            C0209d.m1263i(file);
                            C0209d.m1263i(fileInputStream);
                            throw th;
                        }
                    } catch (FileNotFoundException e12) {
                        e = e12;
                    } catch (IOException e13) {
                        e = e13;
                    } catch (Throwable th3) {
                        th = th3;
                        C0209d.m1263i(bufferedReader);
                        C0209d.m1263i(file);
                        C0209d.m1263i(fileInputStream);
                        throw th;
                    }
                } catch (FileNotFoundException e14) {
                    e = e14;
                } catch (IOException e15) {
                    e = e15;
                } catch (Throwable th4) {
                    th = th4;
                    file = 0;
                }
            } catch (FileNotFoundException e16) {
                e = e16;
            } catch (IOException e17) {
                e = e17;
            } catch (Throwable th5) {
                th = th5;
                file = 0;
                fileInputStream = null;
            }
        } catch (Throwable th6) {
            th = th6;
            fileInputStream = null;
        }
    }

    public void readTxtFileToDb(String str, PmsMetaBaseOperator pmsMetaBaseOperator, boolean z10, ScanAppDataUtil scanAppDataUtil) throws C9721b {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        int iM60659c;
        File fileM63442h = C10278a.m63442h(str);
        BufferedReader bufferedReader = null;
        try {
            try {
                C11839m.m70688i(TAG, "readTxtFileToDb start ");
                this.excludeDataPath = scanAppDataUtil.getExcludeDataPathWithRegex(this.originAppId);
                fileInputStream = new FileInputStream(fileM63442h);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                        try {
                            String line = bufferedReader2.readLine();
                            int i10 = 0;
                            while (line != null) {
                                if (isError()) {
                                    C11839m.m70687e(TAG, "readTxtFileByFileUtils is error, index: " + i10);
                                    String message = "";
                                    C9721b c9721b = this.mCException;
                                    if (c9721b != null) {
                                        message = c9721b.getMessage();
                                        iM60659c = this.mCException.m60659c();
                                    } else {
                                        iM60659c = 1008;
                                    }
                                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "readTxtFileByFileUtils error,code:  " + iM60659c + ", error：" + message);
                                }
                                int i11 = i10 + 1;
                                String[] strArrSplit = line.split(";");
                                String line2 = bufferedReader2.readLine();
                                insertCustInfo(strArrSplit, pmsMetaBaseOperator, line2 == null, z10, scanAppDataUtil);
                                i10 = i11;
                                line = line2;
                            }
                            C11839m.m70688i(TAG, "readTxtFileByFileUtils index: " + i10);
                            C11839m.m70688i(TAG, "readTxtFileToDb sum = " + i10);
                            C0209d.m1263i(bufferedReader2);
                            C0209d.m1263i(inputStreamReader);
                            C0209d.m1263i(fileInputStream);
                        } catch (FileNotFoundException e10) {
                            e = e10;
                            C11839m.m70687e(TAG, "readTxtFileByFileUtils FileNotFoundException: " + e.toString());
                            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "readTxtFileByFileUtils FileNotFoundException delete error " + e.toString());
                        } catch (IOException e11) {
                            e = e11;
                            C11839m.m70687e(TAG, "readTxtFileByFileUtils IOException: " + e.toString());
                            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "readTxtFileByFileUtils IOException delete error " + e.toString());
                        } catch (Exception e12) {
                            e = e12;
                            C11839m.m70687e(TAG, "unknown error: " + e.getMessage());
                            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "unknown error: " + e.getMessage());
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader2;
                            C0209d.m1263i(bufferedReader);
                            C0209d.m1263i(inputStreamReader);
                            C0209d.m1263i(fileInputStream);
                            throw th;
                        }
                    } catch (FileNotFoundException e13) {
                        e = e13;
                    } catch (IOException e14) {
                        e = e14;
                    } catch (Exception e15) {
                        e = e15;
                    } catch (Throwable th3) {
                        th = th3;
                        C0209d.m1263i(bufferedReader);
                        C0209d.m1263i(inputStreamReader);
                        C0209d.m1263i(fileInputStream);
                        throw th;
                    }
                } catch (FileNotFoundException e16) {
                    e = e16;
                } catch (IOException e17) {
                    e = e17;
                } catch (Exception e18) {
                    e = e18;
                } catch (Throwable th4) {
                    th = th4;
                    inputStreamReader = null;
                }
            } catch (FileNotFoundException e19) {
                e = e19;
            } catch (IOException e20) {
                e = e20;
            } catch (Exception e21) {
                e = e21;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
                inputStreamReader = null;
            }
        } catch (Throwable th6) {
            th = th6;
            fileInputStream = null;
        }
    }

    public void safeReadDestTarTxtFileToDb(PmsMetaBaseOperator pmsMetaBaseOperator, File file) throws C9721b {
        try {
            pmsMetaBaseOperator.clear();
            readDestTarTxtFileToDb(pmsMetaBaseOperator, file);
        } catch (C9721b e10) {
            pmsMetaBaseOperator.clear();
            throw e10;
        }
    }

    public synchronized void setCException(C9721b c9721b) {
        this.mCException = c9721b;
    }

    public FileExchangeDb(ProgressCallback progressCallback, CloudBackupStatus cloudBackupStatus) {
        this(progressCallback, cloudBackupStatus, false, false);
    }

    public FileExchangeDb(ProgressCallback progressCallback, CloudBackupStatus cloudBackupStatus, boolean z10, boolean z11) {
        this.mPMSdataMetas = new ArrayList();
        this.originAppId = "";
        this.progressCallback = progressCallback;
        this.mAppId = cloudBackupStatus.m29870d();
        this.originAppId = cloudBackupStatus.mo29421n();
        this.mUid = cloudBackupStatus.m29861N();
        this.dataPathPrefix = BackupRestoreConstans.DATA_USER_PATH + this.mUid + File.separator;
        this.mBackupStatus = cloudBackupStatus;
        this.mAppType = cloudBackupStatus.m29872f();
        this.mIsRefurbish = z10;
        this.mIsTempBackup = z11;
    }
}
