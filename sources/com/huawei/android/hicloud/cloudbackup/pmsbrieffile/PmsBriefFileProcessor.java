package com.huawei.android.hicloud.cloudbackup.pmsbrieffile;

import android.content.Context;
import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.AppInfoList;
import com.huawei.android.hicloud.cloudbackup.bean.CloudBackup;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.QueryDeletePmsMetaIndexBuilder;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMeta;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMetaStatus;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsBatchFilesInfoCopySuccessOperator;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsBatchFilesInfoToCopyOperator;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoOperator;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaStatusOperator;
import com.huawei.android.hicloud.cloudbackup.process.CacheTask;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreConstans;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeManagementService;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.bean.SnapshotBackupMeta;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.util.SafeString;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import mm.AbstractC11494p;
import mm.InterfaceC11495q;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;
import p617rl.C12519c;
import p617rl.C12526j;
import p618rm.C12571m;
import p618rm.C12590s0;
import p744wl.C13617a;
import sl.C12815f;

/* loaded from: classes2.dex */
public class PmsBriefFileProcessor {
    public static final String ALIAS_SNAPSHOT_DB_NAME = "last";
    public static final String EXCLUDE_DATA_PATH_PREFIX = "[exclude]";
    public static final String INCLUDE_DATA_PATH_PREFIX = "[include]";
    private static final String TAG = "PmsBriefFileProcessor";
    private String appId;
    private boolean autoBackup;
    private String backupId;
    private ProgressCallback callback;
    private CacheTask client;
    private Context context;
    private String curVersion;
    private int dataAcptErrNum;
    private int dataAcptErrRate;
    private String dataLocation;
    private Context deContext;
    private String lastSuccessBackupId;
    private String lastVersion;
    private String location = "/data/data/com.huawei.hidisk/files/cloudbackup";
    private String pmsBriefMetaDb;
    private PmsFullBriefFilesInfoOperator pmsDataOperator;
    private ScanAppDataUtil scanAppDataUtil;
    private SnapshotTreeManagementService snapshotV2Service;
    private PmsMetaStatusOperator statusOperator;

    public PmsBriefFileProcessor(String str, String str2, ProgressCallback progressCallback, CacheTask cacheTask, String str3, String str4, String str5, String str6, String str7, ScanAppDataUtil scanAppDataUtil, boolean z10) {
        this.appId = str;
        this.callback = progressCallback;
        this.client = cacheTask;
        this.lastSuccessBackupId = str3;
        this.lastVersion = str4;
        this.backupId = str5;
        this.curVersion = str6;
        this.dataLocation = str7;
        this.scanAppDataUtil = scanAppDataUtil;
        Context contextM1377a = C0213f.m1377a();
        this.context = contextM1377a;
        this.deContext = contextM1377a.createDeviceProtectedStorageContext();
        this.snapshotV2Service = SnapshotTreeManagementService.getInstance();
        this.pmsBriefMetaDb = str2;
        this.pmsDataOperator = new PmsFullBriefFilesInfoOperator(str2);
        this.statusOperator = new PmsMetaStatusOperator(str2);
        this.autoBackup = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void batchDeleteLocalCache(AbstractC11494p abstractC11494p, int i10) throws C9721b {
        for (int i11 = 1; i11 <= i10; i11++) {
            PmsMeta pmsMeta = (PmsMeta) abstractC11494p.query(i11);
            String data = pmsMeta.getData();
            if (pmsMeta.getEncoded() == 1) {
                data = ICBUtil.getDecodedPath(pmsMeta.getData());
            }
            String strConvertCachePath = convertCachePath(data);
            C12571m.m75547i(strConvertCachePath);
            C11839m.m70686d(TAG, "delete local cache path: " + strConvertCachePath);
        }
    }

    private void checkTempFullBrief() throws C9721b {
        PmsFullBriefFilesInfoOperator pmsFullBriefFilesInfoOperator = new PmsFullBriefFilesInfoOperator(this.pmsBriefMetaDb);
        pmsFullBriefFilesInfoOperator.temp();
        if (!this.pmsDataOperator.isExistTable() || this.pmsDataOperator.queryCount() <= 0 || pmsFullBriefFilesInfoOperator.isExistTable()) {
            return;
        }
        C11839m.m70688i(TAG, "processPmsBriefFile rename to temp file");
        this.pmsDataOperator.renameToTemp();
    }

    private String convertCachePath(String str) {
        return this.dataLocation + str.substring(4);
    }

    private String convertDataPathPrefix(String str) {
        return BackupRestoreConstans.getUserPath() + File.separator + SafeString.substring(str, 11);
    }

    private void generatePmsByFile() throws Throwable {
        File fileM63442h = C10278a.m63442h(getDataTempDir(this.appId) + "/filter.txt");
        if (fileM63442h.exists() && !fileM63442h.delete()) {
            C11839m.m70687e(TAG, "generatePmsByFile delete byfile error: " + fileM63442h.getName());
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "delete cache brief file error");
        }
        List<String> dataPath = this.scanAppDataUtil.getDataPath(this.appId);
        List<String> excludeDataPathWithoutRegex = this.scanAppDataUtil.getExcludeDataPathWithoutRegex(this.appId);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (!fileM63442h.createNewFile()) {
                    C11839m.m70687e(TAG, "generate byfile error");
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "generate byfile error");
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(fileM63442h);
                try {
                    for (String strConvertDataPathPrefix : dataPath) {
                        if (strConvertDataPathPrefix.startsWith(BackupRestoreConstans.DATA_PATH)) {
                            strConvertDataPathPrefix = convertDataPathPrefix(strConvertDataPathPrefix);
                        }
                        C11839m.m70686d(TAG, "generatePmsByFile includePath: " + strConvertDataPathPrefix);
                        fileOutputStream2.write(("[include]" + strConvertDataPathPrefix + "\n").getBytes(Constants.UTF_8));
                    }
                    for (String strConvertDataPathPrefix2 : excludeDataPathWithoutRegex) {
                        if (strConvertDataPathPrefix2.startsWith(BackupRestoreConstans.DATA_PATH)) {
                            strConvertDataPathPrefix2 = convertDataPathPrefix(strConvertDataPathPrefix2);
                        }
                        C11839m.m70686d(TAG, "generatePmsByFile excludePath: " + strConvertDataPathPrefix2);
                        fileOutputStream2.write(("[exclude]" + strConvertDataPathPrefix2 + "\n").getBytes(Constants.UTF_8));
                    }
                    C0209d.m1263i(fileOutputStream2);
                } catch (FileNotFoundException unused) {
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "generatePmsByFile FileNotFoundException");
                } catch (IOException e10) {
                    e = e10;
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "generatePmsByFile IOException: " + e.getMessage());
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    C0209d.m1263i(fileOutputStream);
                    throw th;
                }
            } catch (FileNotFoundException unused2) {
            } catch (IOException e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void getDataAcptErrValue(String str, C12526j c12526j) {
        CloudBackup cloudBackup;
        this.dataAcptErrNum = c12526j.m75354P();
        this.dataAcptErrRate = c12526j.m75356Q();
        List<AppInfoList> listM75300k = new C12519c().m75300k(str);
        if (listM75300k.isEmpty() || (cloudBackup = listM75300k.get(0).getCloudBackup()) == null) {
            return;
        }
        int dataAcptErrNum = cloudBackup.getDataAcptErrNum();
        int dataAcptErrRate = cloudBackup.getDataAcptErrRate();
        if (dataAcptErrNum < 0 || dataAcptErrRate < 0) {
            return;
        }
        this.dataAcptErrNum = dataAcptErrNum;
        this.dataAcptErrRate = dataAcptErrRate;
    }

    private String getPmsDataLocation(String str) {
        return this.dataLocation + File.separator + str;
    }

    private boolean isNeedGenerateFullBriefTable() throws C9721b {
        PmsMetaStatus pmsMetaStatusQuery = this.statusOperator.query();
        if (pmsMetaStatusQuery != null) {
            return pmsMetaStatusQuery.getStatus() == 1;
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "isNeedGenerateFullBriefTable error, metaStatus is null");
    }

    private boolean isNeedGetPmsBriefFile() throws C9721b {
        if (!isPmsBriefFileValid()) {
            C11839m.m70688i(TAG, "isNeedGetPmsBriefFile: pms brief is invalid, return true.");
            return true;
        }
        PmsMetaStatus pmsMetaStatusQuery = this.statusOperator.query();
        if (pmsMetaStatusQuery == null) {
            C11839m.m70688i(TAG, "isNeedGetPmsBriefFile: metaStatus is null, return true.");
            return true;
        }
        int status = pmsMetaStatusQuery.getStatus();
        boolean z10 = status == 0;
        if (1 == status) {
            String str = getDataTempDir(this.appId) + "/" + this.appId + ".txt";
            if (!C10278a.m63442h(str).exists()) {
                C11839m.m70688i(TAG, "isNeedGetPmsBriefFile: metaStatus =  " + status + ", but " + str + " not exist, return ture");
                this.statusOperator.updateStatus(0);
                return true;
            }
        }
        C11839m.m70688i(TAG, "isNeedGetPmsBriefFile: metaStatus =  " + status + ", return " + z10);
        return z10;
    }

    private boolean isPmsBriefFileValid() throws C9721b {
        C12526j c12526j = new C12526j();
        PmsMetaStatus pmsMetaStatusQuery = this.statusOperator.query();
        return System.currentTimeMillis() - (pmsMetaStatusQuery != null ? pmsMetaStatusQuery.getModifytime() : 0L) <= c12526j.m75408n0(this.autoBackup);
    }

    private void isStop() throws InterruptedException, C9721b {
        this.client.isCancel();
    }

    private void updateStatusByInvalidFullBriefTable() throws C9721b {
        PmsFullBriefFilesInfoOperator pmsFullBriefFilesInfoOperator = new PmsFullBriefFilesInfoOperator(this.pmsBriefMetaDb);
        pmsFullBriefFilesInfoOperator.temp();
        if (pmsFullBriefFilesInfoOperator.isExistTable()) {
            C11839m.m70688i(TAG, "processPmsBriefFile update status by invalid full brief table start");
            this.pmsDataOperator.updateMetaByInvalidFullBrief();
            pmsFullBriefFilesInfoOperator.updateTempMetaToDelete();
            new QueryDeletePmsMetaIndexBuilder(pmsFullBriefFilesInfoOperator).execute(new InterfaceC11495q() { // from class: com.huawei.android.hicloud.cloudbackup.pmsbrieffile.b
                @Override // mm.InterfaceC11495q
                /* renamed from: a */
                public final void mo1695a(AbstractC11494p abstractC11494p, int i10) throws C9721b {
                    this.f11673a.batchDeleteLocalCache(abstractC11494p, i10);
                }
            });
            pmsFullBriefFilesInfoOperator.drop();
            C11839m.m70688i(TAG, "processPmsBriefFile update status by invalid full brief table end");
        }
    }

    private void verifyPmsMetaStatusValid() throws C9721b {
        PmsMetaStatus pmsMetaStatusQuery = this.statusOperator.query();
        if (pmsMetaStatusQuery != null) {
            PmsFullBriefFilesInfoOperator pmsFullBriefFilesInfoOperator = new PmsFullBriefFilesInfoOperator(this.pmsBriefMetaDb);
            pmsFullBriefFilesInfoOperator.temp();
            boolean zIsExistTable = pmsFullBriefFilesInfoOperator.isExistTable();
            if (3 == pmsMetaStatusQuery.getStatus() && zIsExistTable) {
                C11839m.m70688i(TAG, "verifyPmsMetaStatusValid reset status to default");
                this.statusOperator.updateStatus(0);
            }
        }
    }

    public void generateFullBriefFilesInfoTable() throws C9721b {
        String str = getDataTempDir(this.appId) + "/" + this.appId + ".txt";
        if (!this.pmsDataOperator.isExistTable()) {
            this.pmsDataOperator.createTable();
        }
        new FileExchangeDb(this.callback, this.appId).readTxtFileToDb(str, this.pmsDataOperator, false, this.scanAppDataUtil);
    }

    public String getDataTempDir(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.dataLocation);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("cache");
        sb2.append(str2);
        sb2.append(str);
        return sb2.toString();
    }

    public int getPmsBriefFileWithByfile() throws Throwable {
        generatePmsByFile();
        return new BackupRestoreUtil(this.context, this.callback, this.location).getBrief(CloudBackupConstant.Command.PMS_OPTION_FILE, getDataTempDir(this.appId) + "/filter.txt", getDataTempDir(this.appId) + "/" + this.appId + ".txt");
    }

    public boolean isNeedReprocessPmsBriefFile() throws C9721b {
        int iQueryCountByIsvalid = this.pmsDataOperator.queryCountByIsvalid(1);
        int iQueryCountByIsvalid2 = this.pmsDataOperator.queryCountByIsvalid(2);
        long jQueryCount = this.pmsDataOperator.queryCount();
        int i10 = iQueryCountByIsvalid + iQueryCountByIsvalid2;
        C12526j c12526j = new C12526j();
        getDataAcptErrValue(this.appId, c12526j);
        List<String> listM75360S = c12526j.m75360S();
        C11839m.m70688i(TAG, "isNeedReprocessPmsBriefFile dataAcptErrNum: " + this.dataAcptErrNum + ", dataAcptErrRate: " + this.dataAcptErrRate + ", changeMetasCount: " + iQueryCountByIsvalid + ", deleteMetasCount: " + iQueryCountByIsvalid2);
        float f10 = jQueryCount != 0 ? (i10 / jQueryCount) * 100.0f : 0.0f;
        C11839m.m70688i(TAG, "isNeedReprocessPmsBriefFile: prorate = " + f10);
        if (f10 <= 0.0f) {
            C11839m.m70688i(TAG, "isNeedReprocessPmsBriefFile: false, prorate = 0,");
            return false;
        }
        if (listM75360S == null || listM75360S.isEmpty()) {
            C11839m.m70688i(TAG, "isNeedReprocessPmsBriefFile dataErrAppList is null");
        } else if (listM75360S.contains(this.appId) || listM75360S.contains("*")) {
            C11839m.m70688i(TAG, "isNeedReprocessPmsBriefFile dataAcptErrNum: " + this.dataAcptErrNum + ", dataAcptErrRate: " + this.dataAcptErrRate + ", count: " + i10 + ", prorate: " + f10);
            if (i10 <= this.dataAcptErrNum && f10 <= this.dataAcptErrRate) {
                C11839m.m70688i(TAG, "isNeedReprocessPmsBriefFile: false");
                return false;
            }
            C11839m.m70688i(TAG, "isNeedReprocessPmsBriefFile prorate is illegal");
        } else {
            C11839m.m70688i(TAG, "isNeedReprocessPmsBriefFile: dataErrAppList not contains " + this.appId + ", dataErrAppList: " + listM75360S.toString());
        }
        C11839m.m70688i(TAG, "isNeedReprocessPmsBriefFile: true");
        return true;
    }

    public int processPmsBriefFile() throws Throwable {
        int pmsBriefFileWithByfile;
        PmsMetaStatusOperator pmsMetaStatusOperator = new PmsMetaStatusOperator(this.pmsBriefMetaDb);
        verifyPmsMetaStatusValid();
        if (isNeedGetPmsBriefFile()) {
            isStop();
            pmsBriefFileWithByfile = getPmsBriefFileWithByfile();
            if (pmsBriefFileWithByfile == -3) {
                pmsMetaStatusOperator.clear();
                C11839m.m70688i(TAG, "processPmsBriefFile get briefCode is PMS_UN_SUPPORTED");
                return pmsBriefFileWithByfile;
            }
            if (pmsBriefFileWithByfile != 0) {
                throw new C9721b(2101, "pms get brief file failed, briefCode = " + pmsBriefFileWithByfile);
            }
            isStop();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (pmsMetaStatusOperator.query() == null) {
                PmsMetaStatus pmsMetaStatus = new PmsMetaStatus();
                pmsMetaStatus.setStatus(1);
                pmsMetaStatus.setModifytime(jCurrentTimeMillis);
                pmsMetaStatusOperator.replace(pmsMetaStatus);
            } else {
                pmsMetaStatusOperator.updateStatus(1);
                pmsMetaStatusOperator.updateModifytime(jCurrentTimeMillis);
            }
            isStop();
            C11839m.m70688i(TAG, "processPmsBriefFile get pms brief file with byFile interface success");
            if (C12590s0.m75873l1(this.curVersion)) {
                C12815f c12815f = new C12815f();
                CloudBackupStatus cloudBackupStatusM76928g = c12815f.m76928g(this.appId);
                if (cloudBackupStatusM76928g != null) {
                    cloudBackupStatusM76928g.m29342C1(jCurrentTimeMillis);
                    c12815f.m76934m(cloudBackupStatusM76928g);
                }
                C11839m.m70688i(TAG, "processPmsBriefFile update v3 cloudBackupStatus dateInvalid");
            } else {
                SnapshotBackupMeta rootNode = this.snapshotV2Service.getRootNode(this.appId, this.backupId);
                rootNode.setDateInvalid(jCurrentTimeMillis);
                this.snapshotV2Service.updateRootNode(this.backupId, rootNode);
                C11839m.m70688i(TAG, "processPmsBriefFile update v2 root node dateInvalid");
                File fileM63442h = C10278a.m63442h(C13617a.m81939u(this.backupId));
                if (fileM63442h.exists() && !fileM63442h.delete()) {
                    C11839m.m70688i(TAG, "processPmsBriefFile delete v3 invalid dir error.");
                }
            }
            isStop();
            checkTempFullBrief();
        } else {
            pmsBriefFileWithByfile = 0;
        }
        isStop();
        if (isNeedGenerateFullBriefTable()) {
            C11839m.m70688i(TAG, "processPmsBriefFile generate full breif files innfo table");
            generateFullBriefFilesInfoTable();
            isStop();
            pmsMetaStatusOperator.updateStatus(2);
        }
        isStop();
        updateStatusByLastSuccessfulRecord();
        isStop();
        updateStatusByBatchFilesCopyResult();
        isStop();
        updateStatusByInvalidFullBriefTable();
        return pmsBriefFileWithByfile;
    }

    public void updateMetaByV2Snapshot() throws C9721b, SQLException {
        File databasePath = this.deContext.getDatabasePath(SnapshotDBManager.getDBName(this.lastSuccessBackupId));
        if (databasePath == null || !databasePath.exists()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateMetaBySnapshot error, backupId: " + this.lastSuccessBackupId + " snapshot db is not exist");
        }
        this.pmsDataOperator.attach(databasePath.getPath());
        try {
            try {
                this.pmsDataOperator.updateFileMetaBySnapshot("last", this.appId);
                this.pmsDataOperator.updateFolderMetaBySnapshot("last", this.appId);
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "updateMetaBySnapshot error: " + e10.getMessage());
                throw e10;
            }
        } finally {
            this.pmsDataOperator.detach();
        }
    }

    public void updateMetaByV3Snapshot() throws C9721b, SQLException {
        File databasePath = this.deContext.getDatabasePath(C13617a.m81942x(this.lastSuccessBackupId, this.appId, 0, 0));
        if (databasePath == null || !databasePath.exists()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateMetaBySnapshot error, backupId: " + this.lastSuccessBackupId + " snapshot db is not exist");
        }
        this.pmsDataOperator.attach(databasePath.getPath());
        try {
            try {
                this.pmsDataOperator.updateFileMetaBySnapshot("last", this.appId);
                this.pmsDataOperator.updateFolderMetaBySnapshot("last", this.appId);
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "updateMetaBySnapshot error: " + e10.getMessage());
                throw e10;
            }
        } finally {
            this.pmsDataOperator.detach();
        }
    }

    public void updateStatusByBatchFilesCopyResult() throws InterruptedException, C9721b {
        C11839m.m70688i(TAG, "processPmsBriefFile update status by batch files copy result start");
        PmsBatchFilesInfoCopySuccessOperator pmsBatchFilesInfoCopySuccessOperator = new PmsBatchFilesInfoCopySuccessOperator(this.pmsBriefMetaDb);
        if (pmsBatchFilesInfoCopySuccessOperator.queryCount() <= 0) {
            String str = getPmsDataLocation(this.appId) + File.separator + this.appId + ".txt";
            if (C10278a.m63442h(str).exists()) {
                C11839m.m70688i(TAG, "processPmsBriefFile generate BatchFilesInfoCopySuccessTable by pms breif file");
                try {
                    new FileExchangeDb(this.callback, this.appId).readTxtFileToDb(str, pmsBatchFilesInfoCopySuccessOperator, true, this.scanAppDataUtil);
                } catch (C9721b unused) {
                    C11839m.m70689w(TAG, "processPmsBriefFile generate BatchFilesInfoCopySuccessTable by pms breif file error");
                    pmsBatchFilesInfoCopySuccessOperator.clear();
                    return;
                }
            }
        }
        isStop();
        PmsBatchFilesInfoToCopyOperator pmsBatchFilesInfoToCopyOperator = new PmsBatchFilesInfoToCopyOperator(this.pmsBriefMetaDb);
        C11839m.m70688i(TAG, "processPmsBriefFile update status by copy result");
        pmsBatchFilesInfoToCopyOperator.updateStatusByCopyResult();
        isStop();
        C11839m.m70688i(TAG, "processPmsBriefFile update changed file info status");
        pmsBatchFilesInfoToCopyOperator.updateChangedFileInfoStatus();
        isStop();
        C11839m.m70688i(TAG, "processPmsBriefFile delete files by status");
        pmsBatchFilesInfoToCopyOperator.deleteMetaByStatus();
        isStop();
        C11839m.m70688i(TAG, "processPmsBriefFile update PmsFullBriefFilesInfoTable status by copy result");
        this.pmsDataOperator.updateStatusByCopyResult();
        pmsBatchFilesInfoCopySuccessOperator.clear();
        pmsBatchFilesInfoToCopyOperator.clear();
        C11839m.m70688i(TAG, "processPmsBriefFile update status by batch files copy result end");
    }

    public void updateStatusByLastSuccessfulRecord() throws InterruptedException, C9721b, SQLException {
        PmsMetaStatus pmsMetaStatusQuery = this.statusOperator.query();
        if (pmsMetaStatusQuery == null) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateStatusByLastSuccessfulRecord error, metaStatus is null");
        }
        if (5 == pmsMetaStatusQuery.getStatus()) {
            return;
        }
        if (TextUtils.isEmpty(this.lastSuccessBackupId)) {
            C11839m.m70688i(TAG, "last success backupId is empty");
            return;
        }
        C11839m.m70688i(TAG, "processPmsBriefFile update status by last successful record start");
        boolean zM75925y1 = C12590s0.m75925y1(this.lastVersion);
        boolean zExistSnapshotDataBase = this.snapshotV2Service.existSnapshotDataBase(this.lastSuccessBackupId);
        boolean zM75873l1 = C12590s0.m75873l1(this.lastVersion);
        boolean zM81937s = C13617a.m81937s(this.lastSuccessBackupId, this.appId, 0);
        if (zM75925y1 && zExistSnapshotDataBase) {
            isStop();
            C11839m.m70688i(TAG, "processPmsBriefFile update status by v2 record");
            updateMetaByV2Snapshot();
        }
        if (zM75873l1 && zM81937s) {
            isStop();
            C11839m.m70688i(TAG, "processPmsBriefFile update status by v3 record");
            updateMetaByV3Snapshot();
        }
        if (zExistSnapshotDataBase && !zM81937s) {
            File fileM63442h = C10278a.m63442h(C13617a.m81939u(this.lastSuccessBackupId));
            if (fileM63442h.exists() && !fileM63442h.delete()) {
                C11839m.m70688i(TAG, "processPmsBriefFile delete v3 invalid dir error.");
            }
        }
        C11839m.m70688i(TAG, "processPmsBriefFile update status by last successful record end");
    }
}
