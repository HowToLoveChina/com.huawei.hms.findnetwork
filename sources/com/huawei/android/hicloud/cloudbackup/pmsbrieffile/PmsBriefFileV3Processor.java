package com.huawei.android.hicloud.cloudbackup.pmsbrieffile;

import am.InterfaceC0275i1;
import android.content.Context;
import android.database.SQLException;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.QueryDeletePmsMetaIndexBuilder;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMeta;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMetaStatus;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsBatchFilesInfoCopySuccessOperatorV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsBatchFilesInfoToCopyOperatorV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoOperatorV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaStatusOperatorV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.script.PmsMetaDBScript;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreConstans;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.PmsUtils;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.snapshottree.SnapshotTreeManagementService;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.SnapshotDBManager;
import com.huawei.android.hicloud.cloudbackup.snapshottree.p078db.operator.SnapshotBackupMetaOperator;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.android.hicloud.commonlib.util.DatabaseRepairUtil;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.secure.android.common.util.SafeString;
import fk.C9721b;
import hk.C10278a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import mm.AbstractC11494p;
import mm.InterfaceC11495q;
import om.C11963c;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0241z;
import p292fn.C9733f;
import p429kk.C11058a;
import p429kk.C11060c;
import p455ll.C11308a;
import p455ll.C11309b;
import p455ll.C11311d;
import p514o9.C11835i;
import p514o9.C11839m;
import p617rl.C12526j;
import p618rm.C12571m;
import p618rm.C12583q;
import p618rm.C12585q1;
import p618rm.C12590s0;
import p618rm.C12610z0;
import p682ul.C13216j;
import p709vj.C13452e;
import p744wl.C13617a;
import pl.C12164f;
import sl.C12815f;

/* loaded from: classes2.dex */
public class PmsBriefFileV3Processor {
    public static final String ALIAS_SNAPSHOT_DB_NAME = "last";
    public static final String EXCLUDE_DATA_PATH_PREFIX = "[exclude]";
    public static final String INCLUDE_DATA_PATH_PREFIX = "[include]";
    private static final Object LOCK = new Object();
    private static final String TAG = "PmsBriefFileV3Processor";
    private String appId;
    private String backupId;
    private ProgressCallback callback;
    private C4879a client;
    private Context context;
    private Context deContext;
    private String location = "/data/data/com.huawei.hidisk/files/cloudbackup";
    private CloudBackupStatus mBackupStatus;
    private String originAppId;
    private String pmsBriefMetaDb;
    private ScanAppDataUtil scanAppDataUtil;
    private SnapshotTreeManagementService snapshotV2Service;
    private List<Bak> successBak;
    private int uid;

    public PmsBriefFileV3Processor(C4879a c4879a, ProgressCallback progressCallback, List<Bak> list, String str, ScanAppDataUtil scanAppDataUtil, CloudBackupStatus cloudBackupStatus) {
        this.originAppId = "";
        this.appId = cloudBackupStatus.m29870d();
        this.originAppId = cloudBackupStatus.mo29421n();
        this.uid = cloudBackupStatus.m29861N();
        this.callback = progressCallback;
        this.client = c4879a;
        this.successBak = list;
        this.backupId = str;
        this.scanAppDataUtil = scanAppDataUtil;
        Context contextM1377a = C0213f.m1377a();
        this.context = contextM1377a;
        this.deContext = contextM1377a.createDeviceProtectedStorageContext();
        this.snapshotV2Service = SnapshotTreeManagementService.getInstance();
        this.pmsBriefMetaDb = C13617a.m81914C(this.appId, this.uid);
        this.mBackupStatus = cloudBackupStatus;
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

    private long[] calcAppDataSizeThroughTxtFile(String str, ScanAppDataUtil scanAppDataUtil) throws Throwable {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        File fileM63442h = C10278a.m63442h(str);
        long[] jArr = {-1, -1};
        BufferedReader bufferedReader = null;
        try {
            C11839m.m70688i(TAG, "calcAppDataSizeThroughTxtFile start ");
            fileInputStream = new FileInputStream(fileM63442h);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                        try {
                            long j10 = 0;
                            int i10 = 0;
                            for (String line = bufferedReader2.readLine(); line != null; line = bufferedReader2.readLine()) {
                                i10++;
                                String[] strArrSplit = line.split(";");
                                String str2 = strArrSplit[0];
                                boolean z10 = C0241z.m1685c(strArrSplit[2]) == 0;
                                long jM1688f = C0241z.m1688f(strArrSplit[3]);
                                if (z10 && !isFilterExcludeDataPath(str2, scanAppDataUtil)) {
                                    j10 += jM1688f;
                                }
                            }
                            jArr[0] = i10;
                            jArr[1] = j10;
                            C11839m.m70686d(TAG, "calcAppDataSizeThroughTxtFile , appid = " + this.appId + ", sum = " + i10 + ", totalSize = " + j10);
                            C0209d.m1263i(bufferedReader2);
                        } catch (Exception e10) {
                            e = e10;
                            bufferedReader = bufferedReader2;
                            C11839m.m70687e(TAG, "calcAppDataSizeThroughTxtFile Exception: " + e.getMessage());
                            C0209d.m1263i(bufferedReader);
                            C0209d.m1263i(inputStreamReader);
                            C0209d.m1263i(fileInputStream);
                            return jArr;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader = bufferedReader2;
                            C0209d.m1263i(bufferedReader);
                            C0209d.m1263i(inputStreamReader);
                            C0209d.m1263i(fileInputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Exception e11) {
                    e = e11;
                }
            } catch (Exception e12) {
                e = e12;
                inputStreamReader = null;
            } catch (Throwable th4) {
                th = th4;
                inputStreamReader = null;
            }
        } catch (Exception e13) {
            e = e13;
            inputStreamReader = null;
            fileInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            inputStreamReader = null;
            fileInputStream = null;
        }
        C0209d.m1263i(inputStreamReader);
        C0209d.m1263i(fileInputStream);
        return jArr;
    }

    private void checkTempFullBrief() throws C9721b {
        PmsFullBriefFilesInfoOperatorV3 pmsFullBriefFilesInfoOperatorV3 = new PmsFullBriefFilesInfoOperatorV3(this.pmsBriefMetaDb);
        PmsFullBriefFilesInfoOperatorV3 pmsFullBriefFilesInfoOperatorV32 = new PmsFullBriefFilesInfoOperatorV3(this.pmsBriefMetaDb);
        pmsFullBriefFilesInfoOperatorV32.temp();
        if (!pmsFullBriefFilesInfoOperatorV3.isExistTable() || pmsFullBriefFilesInfoOperatorV3.queryCount() <= 0 || pmsFullBriefFilesInfoOperatorV32.isExistTable()) {
            return;
        }
        C11839m.m70688i(TAG, "checkTempFullBrief rename to temp file");
        pmsFullBriefFilesInfoOperatorV3.renameToTemp();
    }

    private void checkUpdateException(File file, C9721b c9721b) throws InterruptedException, C9721b {
        isStop();
        if (c9721b != null) {
            PmsFullBriefFilesInfoOperatorV3 pmsFullBriefFilesInfoOperatorV3 = new PmsFullBriefFilesInfoOperatorV3(this.pmsBriefMetaDb);
            if (!file.exists() || !pmsFullBriefFilesInfoOperatorV3.integrityCheck()) {
                throw new C9721b(3930, c9721b.getMessage());
            }
        }
    }

    private void checkUploadMetaValid() throws InterruptedException, C9721b {
        long jM75406m0 = new C12526j().m75406m0(this.client.isAutoBackup());
        long jCurrentTimeMillis = System.currentTimeMillis() - jM75406m0;
        PmsFullBriefFilesInfoOperatorV3 pmsFullBriefFilesInfoOperatorV3 = new PmsFullBriefFilesInfoOperatorV3(this.pmsBriefMetaDb);
        List<String> listQueryInvalidUploadMeta = pmsFullBriefFilesInfoOperatorV3.queryInvalidUploadMeta(jCurrentTimeMillis);
        C11839m.m70688i(TAG, "check upload meta valid start, fileId size = " + listQueryInvalidUploadMeta.size() + ", cacheDuration = " + jM75406m0 + ", validTime = " + jCurrentTimeMillis);
        String strM81942x = C13617a.m81942x(this.backupId, this.appId, 0, this.uid);
        for (String str : listQueryInvalidUploadMeta) {
            isStop();
            pmsFullBriefFilesInfoOperatorV3.updateInvalidUploadMetaDefault(str);
            C13216j.c cVar = C13216j.c.SNAPSHOT;
            C11309b c11309b = new C11309b(C13216j.m79427l(cVar, strM81942x));
            List<C11308a> listM67913e = c11309b.m67913e(str);
            C11311d c11311d = new C11311d(C13216j.m79427l(cVar, strM81942x));
            for (C11308a c11308a : listM67913e) {
                c11311d.m67939b(c11308a.m67883a());
                c11309b.m67909a(c11308a.m67892j());
            }
        }
        C11839m.m70688i(TAG, "check upload meta valid end, cacheDuration = " + jM75406m0 + ", validTime = " + jCurrentTimeMillis);
    }

    private String convertCachePath(String str) {
        return C12583q.m75680p(0) + str.substring(4);
    }

    private void generatePmsByFile(String str) throws Throwable {
        File fileM63442h = C10278a.m63442h(str);
        if (fileM63442h.exists() && !fileM63442h.delete()) {
            C11839m.m70687e(TAG, "v3 generatePmsByFile delete byfile error: " + fileM63442h.getName());
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "v3 delete cache brief file error");
        }
        List<String> dataPath = this.scanAppDataUtil.getDataPath(this.originAppId, this.uid);
        List<String> excludeDataPathWithoutRegex = this.scanAppDataUtil.getExcludeDataPathWithoutRegex(this.originAppId);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (!fileM63442h.createNewFile()) {
                    C11839m.m70687e(TAG, "v3 generate byfile error");
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "v3 generate byfile error");
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(fileM63442h);
                try {
                    PmsUtils.generatePmsFilterFileContent(dataPath, excludeDataPathWithoutRegex, fileOutputStream2, this.uid);
                    C0209d.m1263i(fileOutputStream2);
                } catch (FileNotFoundException unused) {
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "v3 generatePmsByFile FileNotFoundException");
                } catch (IOException e10) {
                    e = e10;
                    throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "v3 generatePmsByFile IOException: " + e.getMessage());
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

    private String getPmsDataLocation(String str) {
        return C12583q.m75680p(0) + File.separator + str;
    }

    private boolean isFilterExcludeDataPath(String str, ScanAppDataUtil scanAppDataUtil) throws C9721b {
        if (scanAppDataUtil == null) {
            return false;
        }
        List<String> excludeDataPathWithRegex = scanAppDataUtil.getExcludeDataPathWithRegex(this.originAppId);
        if (excludeDataPathWithRegex.isEmpty()) {
            return false;
        }
        if (str == null) {
            C11839m.m70688i(TAG, "isFilterExcludeDataPath path is null");
            return true;
        }
        String str2 = BackupRestoreConstans.DATA_USER_PATH + this.uid + File.separator;
        if (str.startsWith(BackupRestoreConstans.DATA_USER_PATH)) {
            str = BackupRestoreConstans.DATA_PATH + SafeString.substring(str, str2.length());
        }
        for (String str3 : excludeDataPathWithRegex) {
            if (str3.startsWith(BackupRestoreConstans.DATA_PATH)) {
                if ((str.endsWith("/") ? str : str + "/").startsWith(str3)) {
                    return true;
                }
            } else if (str3.startsWith("REG:/data/data/") || str3.startsWith("REG:^/data/data/")) {
                if (C12585q1.m75706p(str, str3.substring(4))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isNeedGenerateFullBriefTable() throws C9721b {
        PmsMetaStatus pmsMetaStatusQuery = new PmsMetaStatusOperatorV3(this.pmsBriefMetaDb).query();
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
        PmsMetaStatusOperatorV3 pmsMetaStatusOperatorV3 = new PmsMetaStatusOperatorV3(this.pmsBriefMetaDb);
        PmsMetaStatus pmsMetaStatusQuery = pmsMetaStatusOperatorV3.query();
        if (pmsMetaStatusQuery == null) {
            C11839m.m70688i(TAG, "isNeedGetPmsBriefFile: metaStatus is null, return true.");
            return true;
        }
        int status = pmsMetaStatusQuery.getStatus();
        boolean z10 = status == 0;
        if (1 == status) {
            String str = getPmsBriefMetaDataLocation(this.appId) + "/" + this.appId + ".txt";
            if (!C10278a.m63442h(str).exists()) {
                C11839m.m70688i(TAG, "isNeedGetPmsBriefFile: metaStatus =  " + status + ", but " + str + " not exist, return ture");
                pmsMetaStatusOperatorV3.updateStatus(0);
                return true;
            }
        }
        C11839m.m70688i(TAG, "isNeedGetPmsBriefFile: metaStatus =  " + status + ", return " + z10);
        return z10;
    }

    private boolean isPmsBriefFileValid() throws C9721b {
        C12526j c12526j = new C12526j();
        PmsMetaStatus pmsMetaStatusQuery = new PmsMetaStatusOperatorV3(this.pmsBriefMetaDb).query();
        return System.currentTimeMillis() - (pmsMetaStatusQuery != null ? pmsMetaStatusQuery.getModifytime() : 0L) <= c12526j.m75408n0(this.client.isAutoBackup());
    }

    private void isStop() throws InterruptedException, C9721b {
        this.client.isCancel();
    }

    private void iterationTar() {
        if (this.client.m29648L0()) {
            C11839m.m70688i(TAG, "iterationTar start");
            PmsFullBriefFilesInfoOperatorV3 pmsFullBriefFilesInfoOperatorV3 = new PmsFullBriefFilesInfoOperatorV3(this.pmsBriefMetaDb);
            try {
                pmsFullBriefFilesInfoOperatorV3.caclTarRefrenceRote(this.client.m29638G0(), this.client.m29652N0());
            } catch (C9721b e10) {
                C11839m.m70687e(TAG, "iterationTar error: " + e10.getMessage());
                try {
                    pmsFullBriefFilesInfoOperatorV3.dropCaclTarRefRatioTable();
                } catch (C9721b e11) {
                    C11839m.m70687e(TAG, "dropTarTable error: " + e11.getMessage());
                }
            }
            C11839m.m70688i(TAG, "iterationTar end");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPmsBriefFileWithByfile$0(CloudBackupStatus cloudBackupStatus, long j10) {
        cloudBackupStatus.mo29416l0(cloudBackupStatus.m29879o() + j10);
        C11963c.m71970y(cloudBackupStatus, this.client.m29713i0());
    }

    private void updateStatusByInvalidFullBriefTable() throws C9721b {
        PmsFullBriefFilesInfoOperatorV3 pmsFullBriefFilesInfoOperatorV3 = new PmsFullBriefFilesInfoOperatorV3(this.pmsBriefMetaDb);
        pmsFullBriefFilesInfoOperatorV3.temp();
        if (pmsFullBriefFilesInfoOperatorV3.isExistTable()) {
            C11839m.m70688i(TAG, "update status by invalid full brief table start");
            new PmsFullBriefFilesInfoOperatorV3(this.pmsBriefMetaDb).updateMetaByInvalidFullBrief();
            pmsFullBriefFilesInfoOperatorV3.updateTempMetaToDelete();
            new QueryDeletePmsMetaIndexBuilder(pmsFullBriefFilesInfoOperatorV3).execute(new InterfaceC11495q() { // from class: com.huawei.android.hicloud.cloudbackup.pmsbrieffile.c
                @Override // mm.InterfaceC11495q
                /* renamed from: a */
                public final void mo1695a(AbstractC11494p abstractC11494p, int i10) throws C9721b {
                    this.f11674a.batchDeleteLocalCache(abstractC11494p, i10);
                }
            });
            pmsFullBriefFilesInfoOperatorV3.drop();
            C11839m.m70688i(TAG, "update status by invalid full brief table end");
        }
    }

    private void updateTempTableStatusByCopyResult() {
        try {
            PmsFullBriefFilesInfoOperatorV3 pmsFullBriefFilesInfoOperatorV3 = new PmsFullBriefFilesInfoOperatorV3(this.pmsBriefMetaDb);
            pmsFullBriefFilesInfoOperatorV3.temp();
            boolean zIsExistTable = pmsFullBriefFilesInfoOperatorV3.isExistTable();
            C11839m.m70686d(TAG, "isTempTableExist:" + zIsExistTable);
            if (zIsExistTable) {
                pmsFullBriefFilesInfoOperatorV3.updateStatusByCopyResult("full_brief_files_info_v3_temp");
            }
        } catch (Exception e10) {
            C11839m.m70688i(TAG, "updateTempTableStatusByCopyResult Exception = " + e10.getMessage());
        }
    }

    private void verifyPmsMetaStatusValid() throws C9721b {
        PmsMetaStatusOperatorV3 pmsMetaStatusOperatorV3 = new PmsMetaStatusOperatorV3(this.pmsBriefMetaDb);
        PmsMetaStatus pmsMetaStatusQuery = pmsMetaStatusOperatorV3.query();
        if (pmsMetaStatusQuery != null) {
            PmsFullBriefFilesInfoOperatorV3 pmsFullBriefFilesInfoOperatorV3 = new PmsFullBriefFilesInfoOperatorV3(this.pmsBriefMetaDb);
            pmsFullBriefFilesInfoOperatorV3.temp();
            boolean zIsExistTable = pmsFullBriefFilesInfoOperatorV3.isExistTable();
            if (3 == pmsMetaStatusQuery.getStatus() && zIsExistTable) {
                C11839m.m70688i(TAG, "verifyPmsMetaStatusValid reset status to default");
                pmsMetaStatusOperatorV3.updateStatus(0);
            }
        }
    }

    public void generateFullBriefFilesInfoTable() throws C9721b {
        String str = getPmsBriefMetaDataLocation(this.appId) + "/" + this.appId + ".txt";
        PmsFullBriefFilesInfoOperatorV3 pmsFullBriefFilesInfoOperatorV3 = new PmsFullBriefFilesInfoOperatorV3(this.pmsBriefMetaDb);
        if (!pmsFullBriefFilesInfoOperatorV3.isExistTable()) {
            pmsFullBriefFilesInfoOperatorV3.createTable();
        }
        new FileExchangeDb(this.callback, this.mBackupStatus, this.client.isRefurbishment(), this.client.mo29591n()).readTxtFileToDb(str, pmsFullBriefFilesInfoOperatorV3, false, this.scanAppDataUtil);
        pmsFullBriefFilesInfoOperatorV3.updateMetaFileType();
    }

    public long[] getAppDataSizeByBriefFile(ScanAppDataUtil scanAppDataUtil) throws C9721b {
        String pmsBriefMetaDataLocation;
        String str = this.appId + ThreadLocalRandom.current().nextInt(ExceptionCode.CRASH_EXCEPTION) + System.currentTimeMillis();
        synchronized (LOCK) {
            pmsBriefMetaDataLocation = getPmsBriefMetaDataLocation(this.appId);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(pmsBriefMetaDataLocation);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(str);
        sb2.append("_dataSizeFilter.txt");
        String string = sb2.toString();
        String str3 = pmsBriefMetaDataLocation + str2 + str + "_dataSize.txt";
        try {
            generatePmsByFile(string);
            int brief = new BackupRestoreUtil(this.context, this.client, this.location).getBrief(CloudBackupConstant.Command.PMS_OPTION_FILE, string, str3);
            if (brief == 0) {
                C11839m.m70688i(TAG, "getAppDataSizeByBriefFile success");
                return calcAppDataSizeThroughTxtFile(str3, scanAppDataUtil);
            }
            C11839m.m70688i(TAG, "getAppDataSizeByBriefFile get briefCode is " + brief);
            return new long[]{-1, -1};
        } finally {
            C11835i.m70643g(string);
            C11835i.m70643g(str3);
        }
    }

    public int getPmsBriefFileWithByfile(final CloudBackupStatus cloudBackupStatus) throws Throwable {
        String str = getPmsBriefMetaDataLocation(this.appId) + "/filter.txt";
        String str2 = getPmsBriefMetaDataLocation(this.appId) + "/" + this.appId + ".txt";
        File fileM63442h = C10278a.m63442h(getPmsBriefMetaDataLocation(this.appId));
        if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
            C11839m.m70687e(TAG, "v3 getPmsBriefFileWithByfile create desFile error: " + fileM63442h.getPath());
        }
        generatePmsByFile(str);
        BackupRestoreUtil backupRestoreUtil = new BackupRestoreUtil(this.context, this.client, this.location, new InterfaceC0275i1() { // from class: com.huawei.android.hicloud.cloudbackup.pmsbrieffile.d
            @Override // am.InterfaceC0275i1
            /* renamed from: a */
            public final void mo1767a(long j10) {
                this.f11675a.lambda$getPmsBriefFileWithByfile$0(cloudBackupStatus, j10);
            }
        });
        backupRestoreUtil.setPmsBriefFileSpeed(BackupRestoreUtil.PMS_DEFAULT_TXT_SPEED);
        return backupRestoreUtil.getBrief(CloudBackupConstant.Command.PMS_OPTION_FILE, str, str2);
    }

    public String getPmsBriefMetaDataLocation(String str) {
        return C12583q.m75656J(str, this.uid);
    }

    public int processPmsBriefFileV3(CloudBackupStatus cloudBackupStatus) throws Throwable {
        int pmsBriefFileWithByfile;
        PmsMetaStatusOperatorV3 pmsMetaStatusOperatorV3 = new PmsMetaStatusOperatorV3(this.pmsBriefMetaDb);
        verifyPmsMetaStatusValid();
        if (isNeedGetPmsBriefFile()) {
            cloudBackupStatus.mo29416l0(0L);
            BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(this.appId, this.client.m29722l0().mo1759d());
            long dataBytes = backupOptionItemQueryItem == null ? 0L : backupOptionItemQueryItem.getDataBytes();
            long jM1688f = C0241z.m1688f(backupOptionItemQueryItem == null ? "" : backupOptionItemQueryItem.getData2());
            long j10 = dataBytes - jM1688f;
            C11839m.m70688i(TAG, "processPmsBriefFileV3 dataBytes: " + dataBytes + " ,sdcardBytes: " + jM1688f);
            if (j10 <= 0) {
                j10 = 1;
            }
            cloudBackupStatus.mo29424o0(j10);
            C11963c.m71970y(cloudBackupStatus, this.client.m29713i0());
            isStop();
            pmsBriefFileWithByfile = getPmsBriefFileWithByfile(cloudBackupStatus);
            if (pmsBriefFileWithByfile == -3) {
                pmsMetaStatusOperatorV3.clear();
                C11839m.m70688i(TAG, "processPmsBriefFileV3 get briefCode is PMS_UN_SUPPORTED");
                return pmsBriefFileWithByfile;
            }
            if (pmsBriefFileWithByfile != 0) {
                throw new C9721b(2101, "pms get brief file failed, briefCode = " + pmsBriefFileWithByfile);
            }
            isStop();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (pmsMetaStatusOperatorV3.query() == null) {
                PmsMetaStatus pmsMetaStatus = new PmsMetaStatus();
                pmsMetaStatus.setStatus(1);
                pmsMetaStatus.setModifytime(jCurrentTimeMillis);
                pmsMetaStatusOperatorV3.replace(pmsMetaStatus);
            } else {
                pmsMetaStatusOperatorV3.updateStatus(1);
                pmsMetaStatusOperatorV3.updateModifytime(jCurrentTimeMillis);
            }
            isStop();
            C11839m.m70688i(TAG, "processPmsBriefFileV3 get pms brief file with byFile interface success");
            C12815f c12815f = new C12815f(this.client.m29713i0());
            CloudBackupStatus cloudBackupStatusM76929h = c12815f.m76929h(this.appId, this.uid);
            if (cloudBackupStatusM76929h != null) {
                cloudBackupStatusM76929h.m29342C1(jCurrentTimeMillis);
                c12815f.m76934m(cloudBackupStatusM76929h);
            }
            C11839m.m70688i(TAG, "processPmsBriefFileV3 update v3 cloudBackupStatus dateInvalid");
            isStop();
            checkTempFullBrief();
        } else {
            pmsBriefFileWithByfile = 0;
        }
        cloudBackupStatus.m29343D0();
        C11963c.m71970y(cloudBackupStatus, this.client.m29713i0());
        isStop();
        if (isNeedGenerateFullBriefTable()) {
            C11839m.m70688i(TAG, "processPmsBriefFileV3 generate full breif files innfo table");
            generateFullBriefFilesInfoTable();
            isStop();
            pmsMetaStatusOperatorV3.updateStatus(2);
        }
        isStop();
        updateStatusByLastSuccessfulRecord();
        isStop();
        updateStatusByBatchFilesCopyResult();
        isStop();
        updateStatusByInvalidFullBriefTable();
        isStop();
        checkUploadMetaValid();
        return pmsBriefFileWithByfile;
    }

    public void updateMetaByV2Snapshot(boolean z10, String str) throws InterruptedException, C9721b, SQLException {
        File databasePath = this.deContext.getDatabasePath(SnapshotDBManager.getDBName(str));
        if (databasePath == null || !databasePath.exists()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateMetaBySnapshot error, backupId: " + str + " snapshot db is not exist");
        }
        PmsFullBriefFilesInfoOperatorV3 pmsFullBriefFilesInfoOperatorV3 = new PmsFullBriefFilesInfoOperatorV3(this.pmsBriefMetaDb);
        String path = databasePath.getPath();
        if (z10 && !new SnapshotBackupMetaOperator(str).checkTableExist()) {
            C11839m.m70688i(TAG, "updateMetaByV2Snapshot attach snapshotDbPath " + path + " snapshot_data table is not exist!!");
            return;
        }
        pmsFullBriefFilesInfoOperatorV3.attach(path);
        C11839m.m70688i(TAG, "updateMetaByV2Snapshot attach snapshotDbPath " + path);
        try {
            try {
                pmsFullBriefFilesInfoOperatorV3.updateFileMetaByV2Snapshot("last", this.appId);
                pmsFullBriefFilesInfoOperatorV3.updateFolderMetaBySnapshot("last", this.appId);
                pmsFullBriefFilesInfoOperatorV3.updateFileMetaByV2SnapshotModifytime("last", this.appId);
                pmsFullBriefFilesInfoOperatorV3.updateCopyTypeByLastSuccessBackupRecord("last", this.appId);
                C11839m.m70688i(TAG, "updateMetaByV2Snapshot detach ");
                try {
                    pmsFullBriefFilesInfoOperatorV3.detach();
                    e = null;
                } catch (C9721b e10) {
                    e = e10;
                    C11839m.m70687e(TAG, "detach error");
                    checkUpdateException(databasePath, e);
                    pmsFullBriefFilesInfoOperatorV3.updatePmsMetaStatusByLostFile(this.appId, this.uid);
                }
            } catch (C9721b e11) {
                e = e11;
                C11839m.m70687e(TAG, "updateMetaBySnapshot error: " + e.getMessage());
                C11839m.m70688i(TAG, "updateMetaByV2Snapshot detach ");
                try {
                    pmsFullBriefFilesInfoOperatorV3.detach();
                } catch (C9721b unused) {
                    C11839m.m70687e(TAG, "detach error");
                    checkUpdateException(databasePath, e);
                    pmsFullBriefFilesInfoOperatorV3.updatePmsMetaStatusByLostFile(this.appId, this.uid);
                }
            }
            checkUpdateException(databasePath, e);
            pmsFullBriefFilesInfoOperatorV3.updatePmsMetaStatusByLostFile(this.appId, this.uid);
        } catch (Throwable th2) {
            C11839m.m70688i(TAG, "updateMetaByV2Snapshot detach ");
            try {
                pmsFullBriefFilesInfoOperatorV3.detach();
            } catch (C9721b unused2) {
                C11839m.m70687e(TAG, "detach error");
            }
            throw th2;
        }
    }

    public void updateMetaByV3Snapshot(boolean z10, String str) throws InterruptedException, C9721b, SQLException {
        File databasePath = this.deContext.getDatabasePath(C13617a.m81942x(str, this.appId, 0, this.uid));
        if (databasePath == null || !databasePath.exists()) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateMetaBySnapshot error, backupId: " + str + " snapshot db is not exist");
        }
        C11839m.m70688i(TAG, "updateMetaByV3Snapshot attach ");
        PmsFullBriefFilesInfoOperatorV3 pmsFullBriefFilesInfoOperatorV3 = new PmsFullBriefFilesInfoOperatorV3(this.pmsBriefMetaDb);
        String path = databasePath.getPath();
        if (z10 && !new C12164f(str, this.appId, 0, this.uid).m73103s()) {
            C11839m.m70689w(TAG, "isExistSnapshotDataTable has not snapshot_data table");
            return;
        }
        pmsFullBriefFilesInfoOperatorV3.attach(path);
        C11839m.m70688i(TAG, "updateMetaByV3Snapshot attach snapshotDbPath " + path);
        try {
            try {
                pmsFullBriefFilesInfoOperatorV3.updateFileMetaByV3Snapshot("last", this.appId, this.client.m29705f1());
                pmsFullBriefFilesInfoOperatorV3.updateFolderMetaBySnapshot("last", this.appId);
                pmsFullBriefFilesInfoOperatorV3.updateFileMetaByV3SnapshotModifytime("last", this.appId);
                pmsFullBriefFilesInfoOperatorV3.updateCopyTypeByLastSuccessBackupRecord("last", this.appId);
                C11839m.m70688i(TAG, "updateMetaByV3Snapshot detach ");
                try {
                    pmsFullBriefFilesInfoOperatorV3.detach();
                    e = null;
                } catch (C9721b e10) {
                    e = e10;
                    C11839m.m70687e(TAG, "detach error");
                    checkUpdateException(databasePath, e);
                    pmsFullBriefFilesInfoOperatorV3.updatePmsMetaStatusByLostFile(this.appId, this.uid);
                }
            } catch (C9721b e11) {
                e = e11;
                C11839m.m70687e(TAG, "updateMetaBySnapshot error: " + e.getMessage());
                C11839m.m70688i(TAG, "updateMetaByV3Snapshot detach ");
                try {
                    pmsFullBriefFilesInfoOperatorV3.detach();
                } catch (C9721b unused) {
                    C11839m.m70687e(TAG, "detach error");
                    checkUpdateException(databasePath, e);
                    pmsFullBriefFilesInfoOperatorV3.updatePmsMetaStatusByLostFile(this.appId, this.uid);
                }
            }
            checkUpdateException(databasePath, e);
            pmsFullBriefFilesInfoOperatorV3.updatePmsMetaStatusByLostFile(this.appId, this.uid);
        } catch (Throwable th2) {
            C11839m.m70688i(TAG, "updateMetaByV3Snapshot detach ");
            try {
                pmsFullBriefFilesInfoOperatorV3.detach();
            } catch (C9721b unused2) {
                C11839m.m70687e(TAG, "detach error");
            }
            throw th2;
        }
    }

    public void updateStatusByBatchFilesCopyResult() throws InterruptedException, C9721b {
        C11839m.m70688i(TAG, "update status by batch files copy result start");
        PmsBatchFilesInfoCopySuccessOperatorV3 pmsBatchFilesInfoCopySuccessOperatorV3 = new PmsBatchFilesInfoCopySuccessOperatorV3(this.pmsBriefMetaDb);
        if (pmsBatchFilesInfoCopySuccessOperatorV3.queryCount() <= 0) {
            String str = getPmsDataLocation(this.appId) + File.separator + this.appId + ".txt";
            if (C10278a.m63442h(str).exists()) {
                C11839m.m70688i(TAG, "generate BatchFilesInfoCopySuccessTable by pms breif file");
                try {
                    new FileExchangeDb(this.callback, this.mBackupStatus).readTxtFileToDb(str, pmsBatchFilesInfoCopySuccessOperatorV3, true, this.scanAppDataUtil);
                } catch (C9721b unused) {
                    C11839m.m70689w(TAG, "generate BatchFilesInfoCopySuccessTable by pms breif file error");
                    pmsBatchFilesInfoCopySuccessOperatorV3.clear();
                    return;
                }
            }
        }
        PmsBatchFilesInfoToCopyOperatorV3 pmsBatchFilesInfoToCopyOperatorV3 = new PmsBatchFilesInfoToCopyOperatorV3(this.pmsBriefMetaDb);
        isStop();
        C11839m.m70688i(TAG, "update status by copy result");
        pmsBatchFilesInfoToCopyOperatorV3.updateStatusByCopyResult();
        isStop();
        C11839m.m70688i(TAG, "update changed file info status");
        pmsBatchFilesInfoToCopyOperatorV3.updateChangedFileInfoStatus();
        isStop();
        C11839m.m70688i(TAG, "delete files by status");
        pmsBatchFilesInfoToCopyOperatorV3.deleteMetaByStatus();
        isStop();
        PmsFullBriefFilesInfoOperatorV3 pmsFullBriefFilesInfoOperatorV3 = new PmsFullBriefFilesInfoOperatorV3(this.pmsBriefMetaDb);
        C11839m.m70688i(TAG, "update PmsFullBriefFilesInfoTable status by copy result");
        pmsFullBriefFilesInfoOperatorV3.updateStatusByCopyResult(PmsMetaDBScript.TABLE_NAME_FULL_BRIEF_FILES_INFO_V3);
        updateTempTableStatusByCopyResult();
        pmsBatchFilesInfoCopySuccessOperatorV3.clear();
        pmsBatchFilesInfoToCopyOperatorV3.clear();
        C11839m.m70688i(TAG, "update status by batch files copy result end");
    }

    public void updateStatusByLastSuccessfulRecord() throws InterruptedException, C9721b, SQLException {
        PmsMetaStatus pmsMetaStatusQuery = new PmsMetaStatusOperatorV3(this.pmsBriefMetaDb).query();
        if (pmsMetaStatusQuery == null) {
            throw new C9721b(FamilyShareConstants.StatusCode.SPACE_SHARE_NOT_OPEN, "updateStatusByLastSuccessfulRecord error, metaStatus is null");
        }
        if (5 == pmsMetaStatusQuery.getStatus()) {
            return;
        }
        List<Bak> list = this.successBak;
        if (list == null || list.isEmpty()) {
            C11839m.m70688i(TAG, "success bak is empty");
            return;
        }
        C11839m.m70688i(TAG, "update status by last successful record start");
        for (Bak bak : this.successBak) {
            String backupVersion = bak.getBackupVersion();
            String id2 = bak.getId();
            if (!C12590s0.m75921x1(backupVersion)) {
                C4879a c4879a = this.client;
                C12610z0 c12610z0 = new C12610z0(c4879a, c4879a.m29713i0(), this.client.m29654O0(), id2, backupVersion, bak.getProperties());
                boolean zM75925y1 = C12590s0.m75925y1(backupVersion);
                boolean zM75873l1 = C12590s0.m75873l1(backupVersion);
                boolean zExistSnapshotDataBase = this.snapshotV2Service.existSnapshotDataBase(id2);
                boolean zM81938t = C13617a.m81938t(id2, this.appId, 0, this.uid);
                boolean zM60720O = C9733f.m60705z().m60720O("cloudBackupWithIntegrityCheck");
                if (zM75925y1 && !this.client.m29705f1()) {
                    isStop();
                    c12610z0.m76088e();
                    zExistSnapshotDataBase = this.snapshotV2Service.existSnapshotDataBase(id2);
                    C11839m.m70688i(TAG, "update status by v2 record");
                    if (zExistSnapshotDataBase) {
                        File databasePath = this.deContext.getDatabasePath(SnapshotDBManager.getDBName(this.backupId));
                        C11060c c11060cM66626a = C11058a.m66626a(this.client.m29654O0(), "DatabaseRepairUtil", C13452e.m80781L().m80971t0());
                        if (!zM60720O || DatabaseRepairUtil.m15913c(databasePath, c11060cM66626a)) {
                            updateMetaByV2Snapshot(zM60720O, id2);
                        }
                    }
                } else if (zM75873l1 && c12610z0.m76096m(id2, this.appId, this.uid)) {
                    isStop();
                    c12610z0.m76091h(this.appId, this.uid);
                    zM81938t = C13617a.m81938t(id2, this.appId, 0, this.uid);
                    C11839m.m70688i(TAG, "update status by v3 record");
                    if (zM81938t) {
                        File databasePath2 = this.deContext.getDatabasePath(C13617a.m81942x(this.backupId, this.appId, 0, this.uid));
                        C11060c c11060cM66626a2 = C11058a.m66626a(this.client.m29654O0(), "DatabaseRepairUtil", C13452e.m80781L().m80971t0());
                        if (!zM60720O || DatabaseRepairUtil.m15913c(databasePath2, c11060cM66626a2)) {
                            updateMetaByV3Snapshot(zM60720O, id2);
                        }
                    }
                }
                if (zExistSnapshotDataBase && !zM81938t) {
                    File fileM63442h = C10278a.m63442h(C13617a.m81939u(id2));
                    if (fileM63442h.exists() && !fileM63442h.delete()) {
                        C11839m.m70688i(TAG, "delete v3 invalid dir error.");
                    }
                }
            }
        }
        C11839m.m70688i(TAG, "update status by last successful record end");
        iterationTar();
    }

    public PmsBriefFileV3Processor(String str, String str2, int i10, ScanAppDataUtil scanAppDataUtil) {
        this.appId = str;
        this.originAppId = str2;
        this.uid = i10;
        Context contextM1377a = C0213f.m1377a();
        this.context = contextM1377a;
        this.deContext = contextM1377a.createDeviceProtectedStorageContext();
        this.scanAppDataUtil = scanAppDataUtil;
    }
}
