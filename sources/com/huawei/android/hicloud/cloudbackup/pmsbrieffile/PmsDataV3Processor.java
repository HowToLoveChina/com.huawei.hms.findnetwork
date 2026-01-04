package com.huawei.android.hicloud.cloudbackup.pmsbrieffile;

import am.InterfaceC0275i1;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.huawei.android.hicloud.cloudbackup.bean.BackupDataAcptErrPolicy;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.QueryToCopyPmsMetaIndexBuilder;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMeta;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMetaStatus;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsBatchFilesInfoCopySuccessOperatorV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsBatchFilesInfoToCopyOperatorV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoForUploadOperatorV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoOperatorV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaStatusOperatorV3;
import com.huawei.android.hicloud.cloudbackup.process.util.AppDataSizeUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.SplitAppUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import dm.C9215i0;
import dm.C9247q0;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import mm.AbstractC11494p;
import mm.InterfaceC11495q;
import om.C11963c;
import p015ak.C0209d;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11835i;
import p514o9.C11839m;
import p617rl.C12526j;
import p618rm.C12583q;
import p618rm.C12588r1;
import p618rm.C12590s0;
import p709vj.C13452e;
import p746wn.C13622a;
import sl.C12815f;
import tl.C13026e;

/* loaded from: classes2.dex */
public class PmsDataV3Processor {
    private static final int MAX_WAIT_COUNT = 30;
    private static final long ONCE_WAIT_MILLISECOND = 1000;
    private static final long PMS_BATCH_COPY_NUM = 100000;
    private static final String TAG = "PmsDataV3Processor";
    public static final String TENCENT_DIFF_DB = "EnMicroMsg.db";
    public static final String TENCENT_PKG = "com.tencent.mm";
    private final CloudBackupAppDataUtil appDataUtil;
    protected String appId;
    private volatile long batchSize;
    private final C4879a client;
    private final boolean isSupportDiff;
    private final CloudBackupStatus mBackupStatus;
    private C9721b mCException;
    private final C9215i0 operate;
    protected String originAppId;
    private final PmsBatchFilesInfoCopySuccessOperatorV3 pmsBatchDataCopySuccessOperatorV3;
    private final PmsBatchFilesInfoToCopyOperatorV3 pmsBatchDataToCopyOperatorV3;
    private final String pmsBriefMetaDb;
    private final PmsFullBriefFilesInfoOperatorV3 pmsDataOperatorV3;
    private final PmsMetaStatusOperatorV3 pmsMetaStatusOperatorV3;
    private final ProgressCallback progressCallback;
    private long reservedSize;
    private final ScanAppDataUtil scanAppDataUtil;
    private final int uid;
    private boolean isFirstBatchCopy = true;
    private final Map<String, String> batchRecordInfo = new HashMap();

    public PmsDataV3Processor(C4879a c4879a, C9215i0 c9215i0, CloudBackupStatus cloudBackupStatus, ProgressCallback progressCallback, ScanAppDataUtil scanAppDataUtil, CloudBackupAppDataUtil cloudBackupAppDataUtil, String str) {
        this.client = c4879a;
        this.operate = c9215i0;
        this.pmsDataOperatorV3 = new PmsFullBriefFilesInfoOperatorV3(str);
        this.pmsBatchDataToCopyOperatorV3 = new PmsBatchFilesInfoToCopyOperatorV3(str);
        this.pmsBatchDataCopySuccessOperatorV3 = new PmsBatchFilesInfoCopySuccessOperatorV3(str);
        this.pmsMetaStatusOperatorV3 = new PmsMetaStatusOperatorV3(str);
        this.appId = cloudBackupStatus.m29870d();
        this.originAppId = cloudBackupStatus.mo29421n();
        this.uid = cloudBackupStatus.m29861N();
        this.progressCallback = progressCallback;
        this.scanAppDataUtil = scanAppDataUtil;
        this.mBackupStatus = cloudBackupStatus;
        this.appDataUtil = cloudBackupAppDataUtil;
        this.pmsBriefMetaDb = str;
        this.isSupportDiff = c9215i0 != null && c9215i0.m57874X();
    }

    private void batchCopyPmsDataV3() throws InterruptedException, C9721b {
        String str;
        String briefFileToCopy = getBriefFileToCopy();
        if (!C10278a.m63442h(briefFileToCopy).exists()) {
            C11839m.m70687e(TAG, "batchCopyPmsDataV3 copy data error:" + briefFileToCopy + " is not exist");
            return;
        }
        C11839m.m70688i(TAG, "batchCopyPmsDataV3 copy data begin, left space: " + ICBUtil.getLocalLeftSpace());
        String pmsDataLocation = getPmsDataLocation(this.appId);
        CloudBackupStatus cloudBackupStatus = this.mBackupStatus;
        if (cloudBackupStatus == null || !cloudBackupStatus.mo29370Q()) {
            str = null;
        } else {
            str = pmsDataLocation;
            pmsDataLocation = C12583q.m75653G(this.originAppId);
        }
        File fileM63442h = C10278a.m63442h(pmsDataLocation);
        if (!fileM63442h.exists() && !fileM63442h.mkdirs()) {
            C11839m.m70687e(TAG, "batchCopyPmsDataV3 create pms data path error");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "batchCopyPmsDataV3 create pms data path error");
        }
        final long[] jArr = {0};
        BackupRestoreUtil backupRestoreUtil = new BackupRestoreUtil(C0213f.m1377a(), this.client, pmsDataLocation, new InterfaceC0275i1() { // from class: com.huawei.android.hicloud.cloudbackup.pmsbrieffile.i
            @Override // am.InterfaceC0275i1
            /* renamed from: a */
            public final void mo1767a(long j10) {
                this.f11681a.lambda$batchCopyPmsDataV3$1(jArr, j10);
            }
        });
        int[] iArr = new int[2];
        int iBackup = backupRestoreUtil.backup(CloudBackupConstant.Command.PMS_OPTION_FILE, briefFileToCopy, pmsDataLocation);
        iArr[0] = iBackup;
        if (this.isSupportDiff) {
            this.batchRecordInfo.put(String.valueOf(System.currentTimeMillis()), "first pms backup call :" + iBackup);
        }
        if (iBackup != 0) {
            ICBUtil.checkDataLocalLimitSpace(this.appId + " pms copy v3 data local size not enough left space: ");
            C11839m.m70688i(TAG, "pms copy file error, wait a moment.");
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                if (i10 >= 30) {
                    break;
                }
                isStop();
                SystemClock.sleep(1000L);
                i10 = i11;
            }
            isStop();
            C11839m.m70688i(TAG, "pms copy file error, try again.");
            iBackup = backupRestoreUtil.backup(CloudBackupConstant.Command.PMS_OPTION_FILE, briefFileToCopy, pmsDataLocation);
            if (this.isSupportDiff) {
                this.batchRecordInfo.put(String.valueOf(System.currentTimeMillis()), "second pms backup call :" + iBackup);
            }
            iArr[1] = iBackup;
        }
        if (iBackup == 0) {
            if (str != null) {
                splitAppDataRename(pmsDataLocation, str);
            }
            this.isFirstBatchCopy = false;
            getPmsDataCopyResultV3();
            C11839m.m70688i(TAG, "batchCopyPmsDataV3 copy data end, left space: " + ICBUtil.getLocalLeftSpace());
            return;
        }
        ICBUtil.checkDataLocalLimitSpace(this.appId + " pms copy v3 data local size not enough left space: ");
        isStop();
        throw new C9721b(2101, "batchCopyPmsDataV3 pms copy data failed, path = " + pmsDataLocation + " pms result: " + Arrays.toString(iArr));
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void batchCopyPmsMetas(mm.AbstractC11494p r32, int r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 699
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.pmsbrieffile.PmsDataV3Processor.batchCopyPmsMetas(mm.p, int):void");
    }

    private void checkFileSize() throws C9721b, NoSuchMethodException, ClassNotFoundException, SecurityException {
        if (this.batchSize <= 0 || !C12590s0.m75913v1(this.client.isRefurbishment(), this.client.mo29591n())) {
            checkFileSizeExceedUpperLimit();
        }
    }

    private void checkFileSizeExceedUpperLimit() throws C9721b, NoSuchMethodException, ClassNotFoundException, SecurityException {
        PmsFullBriefFilesInfoOperatorV3 pmsFullBriefFilesInfoOperatorV3 = new PmsFullBriefFilesInfoOperatorV3(this.pmsBriefMetaDb);
        Long localLeftSpace = ICBUtil.getLocalLeftSpace();
        List<PmsMeta> listQueryMaxSize = pmsFullBriefFilesInfoOperatorV3.queryMaxSize();
        if (listQueryMaxSize.isEmpty()) {
            return;
        }
        long size = listQueryMaxSize.get(0).getSize();
        String data = listQueryMaxSize.get(0).getData();
        long jM75856h0 = C12590s0.m75856h0();
        if (localLeftSpace != null) {
            long j10 = jM75856h0 + size;
            if (j10 > localLeftSpace.longValue()) {
                long appDataSize = AppDataSizeUtil.getAppDataSize(this.originAppId, this.uid, C0213f.m1377a());
                C11839m.m70688i(TAG, "checkFileSizeExceedUpperLimit appDataSize: " + appDataSize + " maxSize: " + size);
                if (size > appDataSize) {
                    j10 = jM75856h0 + appDataSize;
                }
                long jLongValue = j10 - localLeftSpace.longValue();
                if (jLongValue > 0) {
                    j10 = jLongValue;
                }
                C12590s0.m75777N2(j10);
                throw new C9721b("1", 1007, "local left space not enough in v3, left space:" + localLeftSpace + " , reserved size: " + jM75856h0 + ", max file size: " + size + ", max file path: " + data + " appDataSize: " + appDataSize);
            }
        }
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
            this.pmsMetaStatusOperatorV3.updateStatus(3);
        }
    }

    private void checkRestartAppService() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            int iQueryCountByStatusAndIsvalid = this.pmsDataOperatorV3.queryCountByStatusAndIsvalid(0, 0);
            C11839m.m70686d(TAG, "checkRestartAppService left count: " + iQueryCountByStatusAndIsvalid);
            if (iQueryCountByStatusAndIsvalid > 0 || this.operate.m57877a0()) {
                return;
            }
            if (!TextUtils.isEmpty(C12590s0.m75920x0(this.appId, this.originAppId, this.pmsBriefMetaDb, this.client.m29750u1(), this.appDataUtil, BackupDataAcptErrPolicy.getPolicyByAppId(this.appId, this.client.m29716j0()), null))) {
                C11839m.m70688i(TAG, "checkRestartAppService needReprocessPmsBriefFileV3 retry");
            } else {
                C12590s0.m75753H2(this.originAppId, this.appDataUtil, this.uid);
                this.operate.m57895p0(true);
            }
        } catch (C9721b e10) {
            C11839m.m70687e(TAG, "queryCountByStatusAndIsvalid error: " + e10.getMessage());
        }
    }

    private void clearBatchFilesInfoCopyCache() throws C9721b {
        if (this.pmsBatchDataToCopyOperatorV3.isExistTable()) {
            C11839m.m70688i(TAG, "clear cache batch_files_info_to_copy");
            this.pmsBatchDataToCopyOperatorV3.clear();
        }
        if (this.pmsBatchDataCopySuccessOperatorV3.isExistTable()) {
            C11839m.m70688i(TAG, "clear cache batch_files_info_copy_success");
            this.pmsBatchDataCopySuccessOperatorV3.clear();
        }
        File fileM63442h = C10278a.m63442h(getBriefFileToCopy());
        File fileM63442h2 = C10278a.m63442h(fileM63442h.getParent());
        if (!fileM63442h2.exists() || C11835i.m70642f(fileM63442h2)) {
            return;
        }
        C11839m.m70687e(TAG, "delete batch breif file cache error: " + fileM63442h.getName());
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "delete brief file cache error" + fileM63442h.getName());
    }

    private void copyData(long j10, long j11, boolean z10) throws IllegalAccessException, InterruptedException, C9721b, IllegalArgumentException, InvocationTargetException {
        isStop();
        if (this.isSupportDiff) {
            this.batchRecordInfo.put(String.valueOf(System.currentTimeMillis()), "copyData:" + j10 + "|" + j11);
        }
        batchCopyPmsDataV3();
        isStop();
        updatePmsDataCopyStatus();
        isStop();
        recordChangedFilesInfo();
        isStop();
        updateFullBriefFileInfoTableStatus();
        checkRestartAppService();
        clearBatchFilesInfoCopyCache();
        if (this.isSupportDiff) {
            this.batchRecordInfo.put(String.valueOf(System.currentTimeMillis()), "delete brief:" + j10 + "|" + j11);
        }
        isStop();
        if (this.batchSize > 0) {
            upload(j10, j11);
            if (!z10) {
                waitBackup(this.batchSize > 0, "waitBatchCopyFinish.");
            }
        }
        isStop();
        obtainBatchSize();
    }

    private void dealPmsMetasCopyType(PmsFullBriefFilesInfoOperatorV3 pmsFullBriefFilesInfoOperatorV3, PmsMeta pmsMeta) throws C9721b {
        if (pmsFullBriefFilesInfoOperatorV3 == null || pmsMeta == null) {
            return;
        }
        String strQueryPmsCopyTypeByFilePath = pmsFullBriefFilesInfoOperatorV3.queryPmsCopyTypeByFilePath(pmsMeta.getFilePath());
        if ("1".equals(strQueryPmsCopyTypeByFilePath)) {
            pmsMeta.setData2("1");
            C9215i0 c9215i0 = this.operate;
            if (c9215i0 == null || c9215i0.m57870T().containsKey("isPMSTarCopy")) {
                return;
            }
            this.operate.m57870T().put("isPMSTarCopy", String.valueOf(true));
            return;
        }
        if (!C12590s0.m75905t1(pmsMeta, this.client.isRefurbishment(), this.client.mo29591n(), this.reservedSize)) {
            if ("2".equals(strQueryPmsCopyTypeByFilePath) && pmsFullBriefFilesInfoOperatorV3.updatePmsCopyTypeByFilePath("", pmsMeta.getFilePath())) {
                pmsMeta.setData2("");
                return;
            }
            return;
        }
        if (pmsFullBriefFilesInfoOperatorV3.updatePmsCopyTypeByFilePath("2", pmsMeta.getFilePath())) {
            pmsMeta.setData2("2");
            C9215i0 c9215i02 = this.operate;
            if (c9215i02 == null || c9215i02.m57870T().containsKey("isSoftLinkUpload")) {
                return;
            }
            this.operate.m57870T().put("isSoftLinkUpload", String.valueOf(true));
        }
    }

    private void generateBriefFileToCopyV3(List<PmsMeta> list) throws Throwable {
        if (list == null || list.isEmpty()) {
            return;
        }
        File fileM63442h = C10278a.m63442h(getBriefFileToCopy());
        File fileM63442h2 = C10278a.m63442h(fileM63442h.getParent());
        if (!fileM63442h2.exists() && !fileM63442h2.mkdirs()) {
            C11839m.m70687e(TAG, "generate brief file v3 parent error");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "generate brief file v3 parent error");
        }
        try {
            if (!fileM63442h.exists() && !fileM63442h.createNewFile()) {
                C11839m.m70687e(TAG, "generate brief file v3 error");
                throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "generate brief v3 file error");
            }
            writePmsMetaToFile(fileM63442h, list);
        } catch (IOException unused) {
            C11839m.m70687e(TAG, "generate brief file v3 IOException");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "generate brief file v3 IOException");
        }
    }

    private void getBatchFilesInfoToCopy(List<PmsMeta> list) throws C9721b {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.pmsBatchDataToCopyOperatorV3.batchReplace(list);
    }

    private long getBatchSize() {
        return this.batchSize;
    }

    private String getBriefFileCopied() {
        return getPmsDataLocation(this.appId) + File.separator + this.appId + ".txt";
    }

    private String getBriefFileToCopy() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C12583q.m75656J(this.appId, this.uid));
        String str = File.separator;
        sb2.append(str);
        sb2.append("cache");
        sb2.append(str);
        sb2.append(this.appId);
        sb2.append(".txt");
        return sb2.toString();
    }

    private int getFilesNumToCopy() {
        try {
            return this.pmsDataOperatorV3.queryCount();
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "queryCount error: " + e10.toString());
            return 0;
        }
    }

    private void getPmsDataCopyResultV3() throws C9721b {
        C11839m.m70688i(TAG, "getPmsDataCopyResultV3 get pms copy data result begin");
        String briefFileCopied = getBriefFileCopied();
        File fileM63442h = C10278a.m63442h(briefFileCopied);
        if (!fileM63442h.exists()) {
            C11839m.m70687e(TAG, "getPmsDataCopyResultV3 get pms copy data result error:" + briefFileCopied + " is not exist");
            return;
        }
        new FileExchangeDb(this.progressCallback, this.mBackupStatus, this.client.isRefurbishment(), this.client.mo29591n()).readTxtFileToDb(briefFileCopied, this.pmsBatchDataCopySuccessOperatorV3, true, this.scanAppDataUtil);
        C11839m.m70688i(TAG, "getPmsDataCopyResultV3 delete copied brief file");
        if (fileM63442h.exists() && !fileM63442h.delete()) {
            C11839m.m70689w(TAG, "getPmsDataCopyResultV3 delete copied brief file error");
        }
        C11839m.m70688i(TAG, "getPmsDataCopyResultV3 get pms copy data result end");
    }

    private String getPmsDataLocation(String str) {
        return C12583q.m75680p(0) + File.separator + str;
    }

    private int getPmsMetaStatus() throws C9721b {
        PmsMetaStatus pmsMetaStatusQuery = this.pmsMetaStatusOperatorV3.query();
        if (pmsMetaStatusQuery != null) {
            return pmsMetaStatusQuery.getStatus();
        }
        return 0;
    }

    private String getSplitAppBriefFileCopied() {
        return getPmsDataLocation(this.appId) + File.separator + this.originAppId + ".txt";
    }

    private void handleNoSpaceInPmsDataV3(int i10) throws C9721b {
        String str;
        Long l10;
        if (i10 != 3001) {
            return;
        }
        long jQueryBackupTotalSize = new PmsFullBriefFilesInfoOperatorV3(this.pmsBriefMetaDb).queryBackupTotalSize();
        if (this.uid == 0) {
            str = this.appId;
        } else {
            str = this.appId + this.uid;
        }
        Map<String, Long> mapM61895M = this.client.m29731o0().m61895M();
        if (mapM61895M.size() <= 0 || !mapM61895M.containsKey(str) || (l10 = mapM61895M.get(str)) == null || l10.longValue() >= jQueryBackupTotalSize) {
            return;
        }
        C11839m.m70688i(TAG, "update module increment size, module: " + str + ", backupTotalSize: " + jQueryBackupTotalSize + ", incrementSize: " + l10);
        mapM61895M.put(str, Long.valueOf(jQueryBackupTotalSize));
    }

    private boolean isPmsDataProcessed() {
        int iQueryCountByStatusAndIsvalid;
        try {
            iQueryCountByStatusAndIsvalid = this.pmsDataOperatorV3.queryCountByStatusAndIsvalid(0, 0);
        } catch (C9721b e10) {
            C11839m.m70689w(TAG, "isPmsDataProcessed queryCount error: " + e10.toString());
        }
        if (iQueryCountByStatusAndIsvalid <= 0) {
            return true;
        }
        C11839m.m70689w(TAG, "isPmsDataProcessed illegal data count = " + iQueryCountByStatusAndIsvalid);
        return false;
    }

    private void isStop() throws InterruptedException, C9721b {
        this.operate.m59511j();
        C9721b c9721b = this.mCException;
        if (c9721b != null) {
            throw c9721b;
        }
    }

    public /* synthetic */ void lambda$batchCopyPmsDataV3$1(long[] jArr, long j10) {
        CloudBackupStatus cloudBackupStatus = this.mBackupStatus;
        if (cloudBackupStatus != null) {
            cloudBackupStatus.mo29427p0((cloudBackupStatus.m29882r() + j10) - jArr[0]);
            if (!this.isFirstBatchCopy || !this.client.m29731o0().m61907Y()) {
                C11963c.m71970y(this.mBackupStatus, this.client.m29713i0());
            }
            jArr[0] = j10;
        }
    }

    public /* synthetic */ void lambda$processPmsDataV3$0(Map map) {
        map.put("batchCopyRecord", this.batchRecordInfo.toString());
    }

    private void obtainBatchSize() throws InterruptedException, C9721b {
        Long localLeftSpace = ICBUtil.getLocalLeftSpace();
        long jM75719a = (C12588r1.m75718c().m75719a() / 2) + C12590s0.m75856h0();
        C11839m.m70688i(TAG, "obtain batch size, left space: " + localLeftSpace + ", limit space: " + jM75719a);
        if (localLeftSpace != null && localLeftSpace.longValue() <= jM75719a) {
            waitBackup(true, "obtainBatchSize.");
        }
        getBatchCopySize();
    }

    private void processPmsData() throws InterruptedException, C9721b, NoSuchMethodException, ClassNotFoundException, SecurityException {
        boolean z10 = getBatchSize() > 0;
        if (z10) {
            this.mBackupStatus.mo29449x0(3);
            if (this.mBackupStatus.m29860M() != 4) {
                this.mBackupStatus.mo29289A0(4);
            }
        } else {
            this.mBackupStatus.mo29449x0(2);
        }
        this.reservedSize = new C12526j().m75428x0();
        new C12815f(this.client.m29713i0()).m76934m(this.mBackupStatus);
        updateFullBriefFileMidStatus();
        setDataPrepareProgress(z10);
        uploadCopiedFiles(z10);
        checkFileSize();
        new QueryToCopyPmsMetaIndexBuilder(this.pmsDataOperatorV3).execute(new InterfaceC11495q() { // from class: com.huawei.android.hicloud.cloudbackup.pmsbrieffile.f
            @Override // mm.InterfaceC11495q
            /* renamed from: a */
            public final void mo1695a(AbstractC11494p abstractC11494p, int i10) throws Throwable {
                this.f11679a.batchCopyPmsMetas(abstractC11494p, i10);
            }
        });
        checkPmsCopyResult();
    }

    private void recordChangedFilesInfo() throws C9721b {
        C11839m.m70688i(TAG, "update changed files info");
        this.pmsBatchDataToCopyOperatorV3.updateChangedFileInfoStatus();
        C11839m.m70688i(TAG, "update not exist files info");
        this.pmsBatchDataToCopyOperatorV3.updateNotExistFileInfoStatus();
        C11839m.m70688i(TAG, "record changed files info end");
    }

    private void reportBatchInfo(JsonArray jsonArray, long j10) {
        C9215i0 c9215i0 = this.operate;
        if (c9215i0 == null) {
            C11839m.m70687e(TAG, "reportBatchInfo operate is null");
            return;
        }
        long jM57866P = c9215i0.m57866P();
        if (jM57866P >= 50) {
            C11839m.m70689w(TAG, "reportBatchInfo warning batchNumber = " + jM57866P);
            return;
        }
        try {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("batchSize", String.valueOf(getBatchSize()));
            jsonObject.addProperty("incrementSize", String.valueOf(j10));
            jsonObject.addProperty("batchNumber", String.valueOf(jM57866P));
            Long localLeftSpace = ICBUtil.getLocalLeftSpace();
            if (localLeftSpace != null) {
                jsonObject.addProperty("localLeftSize", String.valueOf(localLeftSpace));
            }
            jsonArray.add(jsonObject);
            this.operate.m57892n0(jM57866P + 1);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "reportBatchInfo exception " + e10.getMessage());
        }
    }

    private void reportBatchSize(long j10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("backupTransID", this.client.m29654O0());
        linkedHashMap.put("appId", this.appId);
        linkedHashMap.put("batchSize", String.valueOf(j10));
        C11060c c11060cM66626a = C11058a.m66626a(this.client.m29654O0(), "batchSize", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66665u("010_200");
        linkedHashMap.put("userType", C13452e.m80781L().m80987x0());
        linkedHashMap.put("gradeCode", C12590s0.m75747G0());
        C13622a.m81971q(c11060cM66626a, linkedHashMap, false, true);
    }

    private void sdcardScan4BatchCopy(boolean z10) throws C9721b {
        if (z10) {
            C9247q0 c9247q0 = new C9247q0(this.client, this.operate, this.mBackupStatus, this.appDataUtil, this.scanAppDataUtil);
            setSplitAppBackupAndroidStrategy();
            c9247q0.m58075m(this.mBackupStatus, this.appDataUtil, 0L);
        }
    }

    private void setBatchCopyProgress() throws C9721b {
        PmsFullBriefFilesInfoOperatorV3 pmsFullBriefFilesInfoOperatorV3 = new PmsFullBriefFilesInfoOperatorV3(this.pmsBriefMetaDb);
        int iQueryCountByType = pmsFullBriefFilesInfoOperatorV3.queryCountByType(0);
        long jQuerySum = pmsFullBriefFilesInfoOperatorV3.querySum();
        long jQueryFilesSizeByStatus = pmsFullBriefFilesInfoOperatorV3.queryFilesSizeByStatus(2);
        int iQueryCountByStatusAndIsvalid = pmsFullBriefFilesInfoOperatorV3.queryCountByStatusAndIsvalid(2, 0);
        C12815f c12815f = new C12815f(this.client.m29713i0());
        this.mBackupStatus.mo29310W(iQueryCountByStatusAndIsvalid).mo29325f0(iQueryCountByType).mo29327g0(iQueryCountByType).mo29308V(jQueryFilesSizeByStatus).mo29323e0(jQuerySum).mo29434s0(jQuerySum).mo29427p0(jQueryFilesSizeByStatus).mo29440u0(iQueryCountByType).mo29437t0(0L).m29453y1(1);
        c12815f.m76934m(this.mBackupStatus);
        C11839m.m70688i(TAG, "setBatchCopyProgress appId: " + this.appId + ", itemCount: " + iQueryCountByType + " dataSize: " + jQuerySum + " ,dataLastExistSize: " + jQueryFilesSizeByStatus);
        C11963c.m71970y(this.mBackupStatus, this.client.m29713i0());
    }

    private void setBatchUploadProgress() throws C9721b {
        PmsFullBriefFilesInfoOperatorV3 pmsFullBriefFilesInfoOperatorV3 = new PmsFullBriefFilesInfoOperatorV3(this.pmsBriefMetaDb);
        int iQueryCountByType = pmsFullBriefFilesInfoOperatorV3.queryCountByType(0);
        long jQuerySum = pmsFullBriefFilesInfoOperatorV3.querySum();
        long jQueryFilesSizeByStatus = pmsFullBriefFilesInfoOperatorV3.queryFilesSizeByStatus(3);
        long jQueryFilesSizeByStatus2 = pmsFullBriefFilesInfoOperatorV3.queryFilesSizeByStatus(0);
        long jQueryFilesSizeByStatus3 = pmsFullBriefFilesInfoOperatorV3.queryFilesSizeByStatus(2);
        int iQueryCountByStatusAndIsvalid = pmsFullBriefFilesInfoOperatorV3.queryCountByStatusAndIsvalid(2, 0);
        int iQueryCountByStatusAndIsvalid2 = pmsFullBriefFilesInfoOperatorV3.queryCountByStatusAndIsvalid(3, 0);
        C11839m.m70688i(TAG, "setBatchUploadProgress appId: " + this.appId + " dataSize: " + jQuerySum + " ,dataUploadedSize: " + jQueryFilesSizeByStatus + " ,dataLastExistSize: " + jQueryFilesSizeByStatus3);
        long[] jArrM75723A0 = C12590s0.m75723A0(this.appId, this.originAppId, this.uid, this.appDataUtil, this.client.m29722l0().mo1759d());
        C11839m.m70688i(TAG, "setBatchUploadProgress appId: " + this.appId + " uid : " + this.uid + " , sdcard dataBytes = " + jArrM75723A0[1] + ", itemCount = " + jArrM75723A0[0]);
        long j10 = (long) iQueryCountByType;
        long j11 = j10 + jArrM75723A0[0];
        long j12 = jQuerySum + jArrM75723A0[1];
        long jM29402f1 = this.mBackupStatus.m29402f1();
        long jM75410o0 = new C12526j().m75410o0(this.client.isAutoBackup());
        C12815f c12815f = new C12815f(this.client.m29713i0());
        long jM29875i = this.mBackupStatus.m29875i();
        int i10 = (int) j11;
        this.mBackupStatus.mo29310W(iQueryCountByStatusAndIsvalid2 + iQueryCountByStatusAndIsvalid).mo29325f0(i10).mo29327g0(i10).mo29308V(jQueryFilesSizeByStatus + jQueryFilesSizeByStatus3).mo29323e0(j12).mo29446w0(jArrM75723A0[0]).mo29434s0(jQuerySum).mo29443v0(0L).mo29437t0(0L).mo29440u0(j10).mo29427p0(jQuerySum - jQueryFilesSizeByStatus2).m29453y1(1);
        if (jM29402f1 > 0 && System.currentTimeMillis() - jM29402f1 < jM75410o0) {
            CloudBackupStatus cloudBackupStatus = this.mBackupStatus;
            cloudBackupStatus.mo29443v0(cloudBackupStatus.m29856A());
        }
        c12815f.m76934m(this.mBackupStatus);
        C11839m.m70688i(TAG, "setBatchUploadProgress beforeDataByte: " + jM29875i + " total dataBytes: " + j12 + ", itemCount: " + j11 + " ,scanSdcardAlready: " + this.mBackupStatus.m29856A());
        if (jM29875i == 0 && j12 > 0) {
            C11963c.m71947b(this.mBackupStatus, this.client.m29713i0());
            C13026e c13026eMo1759d = this.client.m29722l0().mo1759d();
            BackupOptionItem backupOptionItemQueryItem = TransferedUtil.queryItem(this.appId, c13026eMo1759d);
            if (backupOptionItemQueryItem != null) {
                backupOptionItemQueryItem.setDataBytes(j12);
                c13026eMo1759d.m78382Q(backupOptionItemQueryItem);
            }
        }
        if (this.client.m29731o0().m61907Y()) {
            return;
        }
        C11963c.m71970y(this.mBackupStatus, this.client.m29713i0());
    }

    private void setDataPrepareProgress(boolean z10) throws C9721b {
        if (z10) {
            setBatchUploadProgress();
        } else {
            setBatchCopyProgress();
        }
    }

    private void setSplitAppBackupAndroidStrategy() throws C9721b {
        if (this.mBackupStatus.mo29370Q()) {
            if (SplitAppUtil.notSupportSplitAndroidScanVersion()) {
                this.mBackupStatus.m29432r1("2");
                C11839m.m70688i(TAG, "version < R, isSupportGetBriefCmd by brief");
            } else {
                this.mBackupStatus.m29432r1("0");
                C11839m.m70688i(TAG, "version < R, isSupportGetBriefCmd scan file backup");
            }
            new C12815f().m76934m(this.mBackupStatus);
        }
    }

    private void splitAppDataRename(String str, String str2) throws C9721b {
        File fileM63442h = C10278a.m63442h(str2);
        File fileM63442h2 = C10278a.m63442h(str);
        File fileM63441g = C10278a.m63441g(fileM63442h2, this.originAppId);
        File fileM63441g2 = C10278a.m63441g(fileM63442h2, this.originAppId + ".txt");
        File fileM63441g3 = C10278a.m63441g(fileM63442h2, this.appId);
        if (fileM63441g.exists() && !fileM63441g.renameTo(fileM63441g3)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "appPmsDataChildDir rename failed: " + C10279b.m63452a(fileM63441g) + " ," + C10279b.m63452a(fileM63441g3));
        }
        File fileM63441g4 = C10278a.m63441g(fileM63442h2, this.appId + ".txt");
        if (fileM63441g2.exists() && !fileM63441g2.renameTo(fileM63441g4)) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "appPmsDataTxt rename failed: " + C10279b.m63452a(fileM63441g2) + " ," + C10279b.m63452a(fileM63441g4));
        }
        SplitAppUtil.deleteDir(fileM63442h);
        if (fileM63442h2.renameTo(fileM63442h)) {
            return;
        }
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "appPmsDataDir rename failed: " + C10279b.m63452a(fileM63442h2) + " ," + C10279b.m63452a(fileM63442h));
    }

    private void updateFullBriefFileInfoTableStatus() throws C9721b {
        C11839m.m70688i(TAG, "update full brief file info status begin");
        this.pmsDataOperatorV3.updateFullBriefStatusByToCopyResult();
        C11839m.m70688i(TAG, "update full brief file info status end");
    }

    private void updateFullBriefFileMidStatus() throws C9721b {
        PmsFullBriefFilesInfoForUploadOperatorV3 pmsFullBriefFilesInfoForUploadOperatorV3 = new PmsFullBriefFilesInfoForUploadOperatorV3(this.pmsBriefMetaDb);
        if (pmsFullBriefFilesInfoForUploadOperatorV3.isExistTable()) {
            pmsFullBriefFilesInfoForUploadOperatorV3.updateUploadMidStatus();
            pmsFullBriefFilesInfoForUploadOperatorV3.updateLastExistMidStatus();
        }
    }

    private void updatePmsDataCopyStatus() throws C9721b {
        C11839m.m70688i(TAG, "update pms copy data status begin");
        this.pmsBatchDataToCopyOperatorV3.updateStatusByCopyResult();
        C11839m.m70688i(TAG, "update pms copy data status end");
    }

    private void uploadCopiedFiles(boolean z10) throws InterruptedException, C9721b {
        if (!z10) {
            C11839m.m70688i(TAG, "batch copy tags is false.");
            return;
        }
        PmsFullBriefFilesInfoOperatorV3 pmsFullBriefFilesInfoOperatorV3 = new PmsFullBriefFilesInfoOperatorV3(this.pmsBriefMetaDb);
        if (pmsFullBriefFilesInfoOperatorV3.queryCopiedFilesTotalSize() <= 0) {
            C11839m.m70688i(TAG, "copied files total size is less than 0.");
            return;
        }
        Pair<Integer, Integer> pairQueryCopiedFilesIndex = pmsFullBriefFilesInfoOperatorV3.queryCopiedFilesIndex();
        if (((Integer) pairQueryCopiedFilesIndex.first).intValue() == -1 || ((Integer) pairQueryCopiedFilesIndex.second).intValue() == -1) {
            C11839m.m70688i(TAG, "files index is invalid");
            return;
        }
        C11839m.m70688i(TAG, "upload copied files start, first: " + pairQueryCopiedFilesIndex.first + ", second: " + pairQueryCopiedFilesIndex.second);
        isStop();
        upload((long) ((Integer) pairQueryCopiedFilesIndex.first).intValue(), (long) ((Integer) pairQueryCopiedFilesIndex.second).intValue());
        while (true) {
            isStop();
            if (!this.client.m29731o0().m61907Y()) {
                C11839m.m70688i(TAG, "upload copied files end");
                return;
            }
            SystemClock.sleep(500L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.io.BufferedOutputStream, java.io.Closeable, java.io.OutputStream] */
    private void writePmsMetaToFile(File file, List<PmsMeta> list) throws Throwable {
        FileOutputStream fileOutputStream;
        Closeable closeable = null;
        try {
            try {
                fileOutputStream = new FileOutputStream((File) file, true);
                try {
                    file = new BufferedOutputStream(fileOutputStream);
                } catch (FileNotFoundException unused) {
                } catch (IOException unused2) {
                } catch (Throwable th2) {
                    th = th2;
                    C0209d.m1263i(closeable);
                    C0209d.m1263i(fileOutputStream);
                    throw th;
                }
            } catch (FileNotFoundException unused3) {
            } catch (IOException unused4) {
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
            try {
                for (PmsMeta pmsMeta : list) {
                    isStop();
                    if (!"1".equals(pmsMeta.getData2()) && !"2".equals(pmsMeta.getData2())) {
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
                            C11839m.m70687e(TAG, "write pms data str is empty");
                        } else {
                            file.write(string.getBytes(Constants.UTF_8));
                        }
                    }
                }
                file.flush();
                C0209d.m1263i(file);
                C0209d.m1263i(fileOutputStream);
            } catch (FileNotFoundException unused5) {
                throw new C9721b(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "writePmsMetaToFile FileNotFoundException");
            } catch (IOException unused6) {
                throw new C9721b(FamilyShareConstants.StatusCode.USER_ROLE_NOT_ALLOWED, "writePmsMetaToFile IOException");
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

    public void checkPmsDataV3() throws InterruptedException, C9721b {
        C11839m.m70688i(TAG, "checkPmsDataV3 begin");
        int pmsMetaStatus = getPmsMetaStatus();
        if (pmsMetaStatus == 5) {
            C11839m.m70688i(TAG, "checkPmsDataV3 end, no need check");
            return;
        }
        if (getFilesNumToCopy() <= 0) {
            C11839m.m70688i(TAG, "checkPmsDataV3 end, no backup files");
            this.pmsMetaStatusOperatorV3.updateStatus(5);
            return;
        }
        if (pmsMetaStatus != 4) {
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "checkPmsDataV3, staus illegal, status = " + pmsMetaStatus);
        }
        String briefFileCopied = getBriefFileCopied();
        if (C10278a.m63442h(briefFileCopied).exists()) {
            isStop();
            this.pmsMetaStatusOperatorV3.updateStatus(5);
            C11839m.m70688i(TAG, "checkPmsDataV3 end");
            return;
        }
        C11839m.m70687e(TAG, "checkPmsDataV3 pms biref file not exist: " + briefFileCopied);
        throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "checkPmsDataV3 pms biref file not exist: " + briefFileCopied);
    }

    public void error(C9721b c9721b) {
        if (this.mCException == null) {
            this.mCException = c9721b;
        }
    }

    public void generateBriefFileToBackupV3() throws InterruptedException, C9721b {
        C11839m.m70688i(TAG, "generateBriefFileToBackupV3 begin");
        int pmsMetaStatus = getPmsMetaStatus();
        if (pmsMetaStatus == 4 || pmsMetaStatus == 5) {
            C11839m.m70688i(TAG, "generateBriefFileToBackupV3 end, no need generate breif file");
            return;
        }
        if (getFilesNumToCopy() <= 0) {
            C11839m.m70688i(TAG, "generateBriefFileToBackupV3 end, no backup files");
            this.pmsMetaStatusOperatorV3.updateStatus(4);
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
            C11839m.m70687e(TAG, "generateBriefFileToBackupV3 mkdirs  parentFile error:" + parent);
        }
        if (fileM63442h.exists() && !fileM63442h.delete()) {
            C11839m.m70687e(TAG, "generateBriefFileToBackupV3 delete cache:" + briefFileCopied + " error");
            throw new C9721b(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST, "generateBriefFileToBackupV3 delete brief file cache error");
        }
        isStop();
        C11839m.m70688i(TAG, "generateBriefFileToBackupV3 generate brief file");
        new FileExchangeDb(this.progressCallback, this.mBackupStatus).readDbToTxtFile(briefFileCopied, this.pmsDataOperatorV3, this.client.m29713i0());
        C11839m.m70688i(TAG, "generateBriefFileToBackupV3 generate brief file success");
        isStop();
        this.pmsMetaStatusOperatorV3.updateStatus(4);
        C11839m.m70688i(TAG, "generateBriefFileToBackupV3 end");
    }

    public long getBatchCopySize() {
        this.batchSize = C12588r1.m75718c().m75721d();
        reportBatchSize(this.batchSize);
        return this.batchSize;
    }

    public String getPmsBriefMetaDb() {
        return this.pmsBriefMetaDb;
    }

    public void processPmsDataV3() throws InterruptedException, NoSuchMethodException, C9721b, ClassNotFoundException, SecurityException {
        try {
            processPmsData();
            if (this.isSupportDiff) {
                Optional.ofNullable(this.operate).map(new Function() { // from class: com.huawei.android.hicloud.cloudbackup.pmsbrieffile.g
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return ((C9215i0) obj).m57870T();
                    }
                }).ifPresent(new Consumer() { // from class: com.huawei.android.hicloud.cloudbackup.pmsbrieffile.h
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f11680a.lambda$processPmsDataV3$0((Map) obj);
                    }
                });
            }
        } catch (C9721b e10) {
            if (getBatchSize() > 0) {
                handleNoSpaceInPmsDataV3(e10.m60659c());
                waitBackup(true, "processPmsDataV3Error.");
            }
            throw e10;
        }
    }

    public void upload(long j10, long j11) throws InterruptedException, C9721b {
        this.client.m29751u2(false, this.appId, this.uid);
        while (true) {
            isStop();
            if (!this.client.m29731o0().m61907Y()) {
                break;
            } else {
                SystemClock.sleep(500L);
            }
        }
        if (this.isSupportDiff) {
            this.batchRecordInfo.put(String.valueOf(System.currentTimeMillis()), "upload:" + j10 + "|" + j11);
        }
        this.operate.m57857G(this, this.mBackupStatus, j10, j11);
    }

    public void waitBackup(boolean z10, String str) throws InterruptedException, C9721b {
        C11839m.m70688i(TAG, "wait back up start in " + str);
        while (true) {
            isStop();
            if (!z10) {
                C11839m.m70688i(TAG, "no need to wait back up.");
                break;
            } else {
                if (!this.client.m29731o0().m61907Y()) {
                    C11839m.m70688i(TAG, "wait back up break.");
                    break;
                }
                SystemClock.sleep(500L);
            }
        }
        C11839m.m70688i(TAG, "wait back up end in " + str);
    }
}
