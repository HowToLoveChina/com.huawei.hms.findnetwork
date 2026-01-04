package com.huawei.android.hicloud.cloudbackup.pmsbrieffile;

import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.QueryToCopyPmsMetaIndexBuilder;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMeta;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMetaStatus;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsBatchFilesInfoCopySuccessOperator;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsBatchFilesInfoToCopyOperator;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoOperator;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaStatusOperator;
import com.huawei.android.hicloud.cloudbackup.process.CacheTask;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mm.AbstractC11494p;
import mm.InterfaceC11495q;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11835i;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class PmsDataProcessor {
    private static final long PMS_BATCH_COPY_NUM = 100000;
    private static final String TAG = "PmsDataProcessor";
    private String appId;
    private CacheTask client;
    private PmsBatchFilesInfoCopySuccessOperator pmsBatchDataCopySuccessOperator;
    private PmsBatchFilesInfoToCopyOperator pmsBatchDataToCopyOperator;
    private PmsFullBriefFilesInfoOperator pmsDataOperator;
    private PmsMetaStatusOperator pmsMetaStatusOperator;
    private ProgressCallback progressCallback;
    private ScanAppDataUtil scanAppDataUtil;
    private String dataLocation = getDataLocation();
    private String dataCacheLocation = getDataCacheLocation();

    public PmsDataProcessor(String str, String str2, CacheTask cacheTask, ScanAppDataUtil scanAppDataUtil, ProgressCallback progressCallback) {
        this.pmsDataOperator = new PmsFullBriefFilesInfoOperator(str2);
        this.pmsBatchDataToCopyOperator = new PmsBatchFilesInfoToCopyOperator(str2);
        this.pmsBatchDataCopySuccessOperator = new PmsBatchFilesInfoCopySuccessOperator(str2);
        this.pmsMetaStatusOperator = new PmsMetaStatusOperator(str2);
        this.progressCallback = progressCallback;
        this.appId = str;
        this.client = cacheTask;
        this.scanAppDataUtil = scanAppDataUtil;
    }

    private void batchCopyPmsData() throws InterruptedException, C9721b {
        String briefFileToCopy = getBriefFileToCopy();
        if (!C10278a.m63442h(briefFileToCopy).exists()) {
            C11839m.m70687e(TAG, "pms copy data error:" + briefFileToCopy + " is not exist");
            return;
        }
        C11839m.m70688i(TAG, "pms copy data begin");
        String pmsDataLocation = getPmsDataLocation(this.appId);
        File fileM63442h = C10278a.m63442h(pmsDataLocation);
        if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
            C11839m.m70687e(TAG, "create pms data path error");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "create pms data path error");
        }
        BackupRestoreUtil backupRestoreUtil = new BackupRestoreUtil(C0213f.m1377a(), this.progressCallback, pmsDataLocation);
        int iBackup = backupRestoreUtil.backup(CloudBackupConstant.Command.PMS_OPTION_FILE, briefFileToCopy, pmsDataLocation);
        if (iBackup != 0) {
            ICBUtil.checkDataLocalLimitSpace(this.appId + " pms copy v3 data local size not enough left space: ");
            C11839m.m70688i(TAG, "pms copy file error, wait a moment.");
            SystemClock.sleep(30000L);
            C11839m.m70688i(TAG, "pms copy file error, try again.");
            iBackup = backupRestoreUtil.backup(CloudBackupConstant.Command.PMS_OPTION_FILE, briefFileToCopy, pmsDataLocation);
        }
        if (iBackup == 0) {
            getPmsDataCopyResult();
            C11839m.m70688i(TAG, "pms copy data end");
            return;
        }
        ICBUtil.checkDataLocalLimitSpace(this.appId + " pms copy data local size not enough left space: ");
        isStop();
        throw new C9721b(2101, "pms copy data failed, path = " + pmsDataLocation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void batchCopyPmsMetas(AbstractC11494p abstractC11494p, int i10) throws Throwable {
        long j10 = i10;
        C11839m.m70688i(TAG, "batch process pms data begin, size = " + j10);
        clearBatchFilesInfoCopyCache();
        long j11 = 0L;
        for (int i11 = 1; i11 <= i10; i11++) {
            isStop();
            j11++;
            ArrayList arrayList = new ArrayList();
            PmsMeta pmsMeta = (PmsMeta) abstractC11494p.query(i11);
            arrayList.add(pmsMeta);
            C11839m.m70686d(TAG, "batch process pms data, sum = " + j11 + ", path " + pmsMeta.getFilePath());
            getBatchFilesInfoToCopy(arrayList);
            isStop();
            generateBriefFileToCopy(arrayList);
            if ((j11 >= PMS_BATCH_COPY_NUM && j11 % PMS_BATCH_COPY_NUM == 0) || j11 >= j10) {
                isStop();
                batchCopyPmsData();
                isStop();
                updatePmsDataCopyStatus();
                isStop();
                recordChangedFilesInfo();
                isStop();
                updateFullBriefFileInfoTableStatus();
                clearBatchFilesInfoCopyCache();
            }
        }
        C11839m.m70688i(TAG, "batch process pms data end");
    }

    private void checkPmsCopyResult() throws InterruptedException, C9721b {
        if (!isPmsDataProcessed()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "some pms meta status illegal");
        }
        int pmsMetaStatus = getPmsMetaStatus();
        if (pmsMetaStatus == 3 || pmsMetaStatus == 4 || pmsMetaStatus == 5) {
            C11839m.m70688i(TAG, "batch process pms data end, no need updata status");
        } else {
            isStop();
            this.pmsMetaStatusOperator.updateStatus(3);
        }
    }

    private void clearBatchFilesInfoCopyCache() throws C9721b {
        if (this.pmsBatchDataToCopyOperator.isExistTable()) {
            C11839m.m70688i(TAG, "clear cache batch_files_info_to_copy");
            this.pmsBatchDataToCopyOperator.clear();
        }
        if (this.pmsBatchDataCopySuccessOperator.isExistTable()) {
            C11839m.m70688i(TAG, "clear cache batch_files_info_copy_success");
            this.pmsBatchDataCopySuccessOperator.clear();
        }
        File fileM63442h = C10278a.m63442h(getBriefFileToCopy());
        File fileM63442h2 = C10278a.m63442h(fileM63442h.getParent());
        if (!fileM63442h2.exists() || C11835i.m70642f(fileM63442h2)) {
            return;
        }
        C11839m.m70687e(TAG, "delete cache batch breif file error: " + fileM63442h.getName());
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "delete cache brief file error" + fileM63442h.getName());
    }

    private void generateBriefFileToCopy(List<PmsMeta> list) throws Throwable {
        if (list == null || list.isEmpty()) {
            return;
        }
        C11839m.m70688i(TAG, "generateBriefFileToCopy begin: size = " + list.size());
        File fileM63442h = C10278a.m63442h(getBriefFileToCopy());
        File fileM63442h2 = C10278a.m63442h(fileM63442h.getParent());
        if (!fileM63442h2.exists() && !fileM63442h2.mkdirs()) {
            C11839m.m70687e(TAG, "generate brief file parent error");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "generate brief file parent error");
        }
        try {
            if (!fileM63442h.exists() && !fileM63442h.createNewFile()) {
                C11839m.m70687e(TAG, "generate brief file error");
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "generate brief file error");
            }
            writeFile(fileM63442h, list);
            C11839m.m70688i(TAG, "generateBriefFileToCopy end");
        } catch (IOException unused) {
            C11839m.m70687e(TAG, "generate brief file IOException");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "generate brief file IOException");
        }
    }

    private void getBatchFilesInfoToCopy(List<PmsMeta> list) throws C9721b {
        if (list == null || list.isEmpty()) {
            return;
        }
        C11839m.m70688i(TAG, "getBatchFilesInfoToCopy: size = " + list.size());
        this.pmsBatchDataToCopyOperator.batchReplace(list);
    }

    private String getBriefFileCopied() {
        return getPmsDataLocation(this.appId) + File.separator + this.appId + ".txt";
    }

    private String getBriefFileToCopy() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.dataCacheLocation);
        String str = File.separator;
        sb2.append(str);
        sb2.append(this.appId);
        sb2.append(str);
        sb2.append("cache");
        sb2.append(str);
        sb2.append(this.appId);
        sb2.append(".txt");
        return sb2.toString();
    }

    private String getDataCacheLocation() {
        return this.dataLocation + File.separator + "cache";
    }

    private String getDataLocation() {
        return C10279b.m63452a(C10278a.m63442h(C0213f.m1377a().getFilesDir() + "/cloudbackup" + File.separator + "data"));
    }

    private int getFilesNumToCopy() {
        try {
            return this.pmsDataOperator.queryCount();
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "queryCount error: " + e10.toString());
            return 0;
        }
    }

    private void getPmsDataCopyResult() throws C9721b {
        C11839m.m70688i(TAG, "get pms copy data result begin");
        String briefFileCopied = getBriefFileCopied();
        File fileM63442h = C10278a.m63442h(briefFileCopied);
        if (!fileM63442h.exists()) {
            C11839m.m70687e(TAG, "get pms copy data result error:" + briefFileCopied + " is not exist");
            return;
        }
        new FileExchangeDb(this.progressCallback, this.appId).readTxtFileToDb(briefFileCopied, this.pmsBatchDataCopySuccessOperator, true, this.scanAppDataUtil);
        C11839m.m70688i(TAG, "delete copied brief file");
        if (fileM63442h.exists() && !fileM63442h.delete()) {
            C11839m.m70689w(TAG, "delete copied brief file error");
        }
        C11839m.m70688i(TAG, "get pms copy data result end");
    }

    private String getPmsDataLocation(String str) {
        return this.dataLocation + File.separator + str;
    }

    private int getPmsMetaStatus() throws C9721b {
        PmsMetaStatus pmsMetaStatusQuery = this.pmsMetaStatusOperator.query();
        if (pmsMetaStatusQuery != null) {
            return pmsMetaStatusQuery.getStatus();
        }
        return 0;
    }

    private boolean isPmsDataProcessed() {
        int iQueryCountByStatusAndIsvalid;
        try {
            iQueryCountByStatusAndIsvalid = this.pmsDataOperator.queryCountByStatusAndIsvalid(0, 0);
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "queryCount error: " + e10.toString());
        }
        if (iQueryCountByStatusAndIsvalid <= 0) {
            return true;
        }
        C11839m.m70689w(TAG, "illegal data count = " + iQueryCountByStatusAndIsvalid);
        return false;
    }

    private void isStop() throws InterruptedException, C9721b {
        this.client.isCancel();
    }

    private void recordChangedFilesInfo() throws C9721b {
        C11839m.m70688i(TAG, "update changed files info");
        this.pmsBatchDataToCopyOperator.updateChangedFileInfoStatus();
        C11839m.m70688i(TAG, "update not exist files info");
        this.pmsBatchDataToCopyOperator.updateNotExistFileInfoStatus();
        C11839m.m70688i(TAG, "record changed files info end");
    }

    private void updateFullBriefFileInfoTableStatus() throws C9721b {
        C11839m.m70688i(TAG, "update full brief file info status begin");
        this.pmsDataOperator.updateFullBriefStatusByToCopyResult();
        C11839m.m70688i(TAG, "update full brief file info status end");
    }

    private void updatePmsDataCopyStatus() throws C9721b {
        C11839m.m70688i(TAG, "update pms copy data status begin");
        this.pmsBatchDataToCopyOperator.updateStatusByCopyResult();
        C11839m.m70688i(TAG, "update pms copy data status end");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.io.BufferedOutputStream, java.io.Closeable, java.io.OutputStream] */
    private void writeFile(File file, List<PmsMeta> list) throws Throwable {
        FileOutputStream fileOutputStream;
        Closeable closeable = null;
        try {
            try {
                fileOutputStream = new FileOutputStream((File) file, true);
                try {
                    file = new BufferedOutputStream(fileOutputStream);
                } catch (FileNotFoundException e10) {
                    e = e10;
                } catch (IOException e11) {
                    e = e11;
                } catch (Throwable th2) {
                    th = th2;
                    C0209d.m1263i(closeable);
                    C0209d.m1263i(fileOutputStream);
                    throw th;
                }
            } catch (FileNotFoundException e12) {
                e = e12;
            } catch (IOException e13) {
                e = e13;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
            try {
                for (PmsMeta pmsMeta : list) {
                    isStop();
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(pmsMeta.getFilePath());
                    stringBuffer.append(";");
                    stringBuffer.append(pmsMeta.getMode());
                    stringBuffer.append(";");
                    stringBuffer.append(pmsMeta.getIsdir());
                    stringBuffer.append(";");
                    stringBuffer.append(pmsMeta.getSize());
                    stringBuffer.append(";");
                    stringBuffer.append(pmsMeta.getModifytime() / 1000);
                    stringBuffer.append("\n");
                    String string = stringBuffer.toString();
                    if (TextUtils.isEmpty(string)) {
                        C11839m.m70689w(TAG, "pms data str is empty");
                    } else {
                        file.write(string.getBytes(Constants.UTF_8));
                    }
                }
                file.flush();
                C0209d.m1263i(file);
                C0209d.m1263i(fileOutputStream);
            } catch (FileNotFoundException e14) {
                e = e14;
                throw new C9721b(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "writeFile FileNotFoundException " + e.toString());
            } catch (IOException e15) {
                e = e15;
                throw new C9721b(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "writeFile IOException " + e.toString());
            } catch (Throwable th4) {
                th = th4;
                closeable = file;
                C0209d.m1263i(closeable);
                C0209d.m1263i(fileOutputStream);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
        }
    }

    public void checkPmsData() throws InterruptedException, C9721b {
        C11839m.m70688i(TAG, "check pms data begin");
        int pmsMetaStatus = getPmsMetaStatus();
        if (pmsMetaStatus == 5) {
            C11839m.m70688i(TAG, "check pms data end, no need check");
            return;
        }
        if (getFilesNumToCopy() <= 0) {
            C11839m.m70688i(TAG, "check pms data end, no backup files");
            this.pmsMetaStatusOperator.updateStatus(5);
            return;
        }
        if (pmsMetaStatus != 4) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "check pms data, staus illegal, status = " + pmsMetaStatus);
        }
        String briefFileCopied = getBriefFileCopied();
        if (C10278a.m63442h(briefFileCopied).exists()) {
            isStop();
            this.pmsMetaStatusOperator.updateStatus(5);
            C11839m.m70688i(TAG, "check pms data end");
            return;
        }
        C11839m.m70687e(TAG, "check pms biref file not exist: " + briefFileCopied);
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "check pms biref file not exist: " + briefFileCopied);
    }

    public void generateBriefFileToBackup() throws InterruptedException, C9721b {
        C11839m.m70688i(TAG, "generateBriefFileToBackup begin");
        int pmsMetaStatus = getPmsMetaStatus();
        if (pmsMetaStatus == 4 || pmsMetaStatus == 5) {
            C11839m.m70688i(TAG, "generateBriefFileToBackup end, no need generate breif file");
            return;
        }
        if (getFilesNumToCopy() <= 0) {
            C11839m.m70688i(TAG, "generateBriefFileToBackup end, no backup files");
            this.pmsMetaStatusOperator.updateStatus(4);
            return;
        }
        if (pmsMetaStatus != 3) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "pms meta status illegal, status = " + pmsMetaStatus);
        }
        String briefFileCopied = getBriefFileCopied();
        File fileM63442h = C10278a.m63442h(briefFileCopied);
        String parent = fileM63442h.getParent();
        File fileM63442h2 = C10278a.m63442h(parent);
        if (!fileM63442h2.exists() && fileM63442h2.mkdirs()) {
            C11839m.m70687e(TAG, "mkdirs  parentFile error:" + parent);
        }
        if (fileM63442h.exists() && !fileM63442h.delete()) {
            C11839m.m70687e(TAG, "delete cache:" + briefFileCopied + " error");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "delete brief file cache error");
        }
        isStop();
        C11839m.m70688i(TAG, "generate brief file");
        new FileExchangeDb(this.progressCallback, this.appId).readDbToTxtFile(briefFileCopied, this.pmsDataOperator, "auto");
        C11839m.m70688i(TAG, "generate brief file success");
        isStop();
        this.pmsMetaStatusOperator.updateStatus(4);
        C11839m.m70688i(TAG, "generateBriefFileToBackup end");
    }

    public void processPmsData() throws InterruptedException, C9721b {
        C11839m.m70688i(TAG, "processPmsData start");
        new QueryToCopyPmsMetaIndexBuilder(this.pmsDataOperator).execute(new InterfaceC11495q() { // from class: com.huawei.android.hicloud.cloudbackup.pmsbrieffile.e
            @Override // mm.InterfaceC11495q
            /* renamed from: a */
            public final void mo1695a(AbstractC11494p abstractC11494p, int i10) throws Throwable {
                this.f11678a.batchCopyPmsMetas(abstractC11494p, i10);
            }
        });
        checkPmsCopyResult();
        C11839m.m70688i(TAG, "processPmsData end");
    }
}
