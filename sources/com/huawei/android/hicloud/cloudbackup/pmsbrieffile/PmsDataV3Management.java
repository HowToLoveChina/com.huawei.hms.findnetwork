package com.huawei.android.hicloud.cloudbackup.pmsbrieffile;

import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.bean.BackupDataAcptErrPolicy;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.bean.PmsMetaV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoForUploadOperatorV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoOperatorV3;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaStatusOperatorV3;
import com.huawei.android.hicloud.cloudbackup.process.util.CloudBackupAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4879a;
import com.huawei.hicloud.cloudbackup.p104v3.server.model.Bak;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import dm.C9215i0;
import fk.C9721b;
import hk.C10278a;
import hk.C10279b;
import java.util.List;
import p514o9.C11839m;
import p618rm.C12571m;
import p618rm.C12583q;
import p618rm.C12588r1;
import p618rm.C12590s0;
import p744wl.C13617a;

/* loaded from: classes2.dex */
public class PmsDataV3Management {
    private static final int PAGE_SIZE = 3000;
    private static final String TAG = "PmsDataV3Management";
    private CloudBackupAppDataUtil appDataUtil;
    private String appId;
    private C4879a client;
    private String originAppId;
    private PmsBriefFileV3Processor pmsBriefFileV3Processor;
    private String pmsBriefMetaDb;
    private PmsDataV3Processor pmsDataV3Processor;
    private int uid;

    public PmsDataV3Management(C4879a c4879a, C9215i0 c9215i0, ProgressCallback progressCallback, CloudBackupStatus cloudBackupStatus, List<Bak> list, String str, ScanAppDataUtil scanAppDataUtil, CloudBackupAppDataUtil cloudBackupAppDataUtil) {
        this.client = c4879a;
        this.appId = cloudBackupStatus.m29870d();
        this.originAppId = cloudBackupStatus.mo29421n();
        this.appDataUtil = cloudBackupAppDataUtil;
        int iM29861N = cloudBackupStatus.m29861N();
        this.uid = iM29861N;
        this.pmsBriefMetaDb = C13617a.m81914C(this.appId, iM29861N);
        this.pmsBriefFileV3Processor = new PmsBriefFileV3Processor(c4879a, progressCallback, list, str, scanAppDataUtil, cloudBackupStatus);
        this.pmsDataV3Processor = new PmsDataV3Processor(c4879a, c9215i0, cloudBackupStatus, progressCallback, scanAppDataUtil, cloudBackupAppDataUtil, this.pmsBriefMetaDb);
    }

    private void checkBatchNeedLocalSize(String str) throws C9721b {
        Long localLeftSpace = ICBUtil.getLocalLeftSpace();
        if (localLeftSpace == null) {
            C11839m.m70689w(TAG, "checkBatchNeedLocalSize getLocalLeftSpace is null.");
            return;
        }
        long jM75720b = C12588r1.m75718c().m75720b() + C12590s0.m75856h0();
        C11839m.m70688i(TAG, "checkBatchNeedLocalSize: " + str + " , need local space: " + jM75720b);
        long jLongValue = jM75720b - localLeftSpace.longValue();
        if (jLongValue <= 0) {
            C11839m.m70688i(TAG, "no need more space.");
            return;
        }
        C12590s0.m75777N2(jLongValue);
        throw new C9721b(1007, "checkBatchNeedLocalSize appId: " + str + ", needMoreSize: " + jLongValue);
    }

    private void checkSuccessWaitDeleteMeta() throws InterruptedException, C9721b {
        PmsFullBriefFilesInfoForUploadOperatorV3 pmsFullBriefFilesInfoForUploadOperatorV3 = new PmsFullBriefFilesInfoForUploadOperatorV3(this.pmsBriefMetaDb);
        while (true) {
            List<PmsMetaV3> listQueryTarWaitDeleteMetaByLimit = pmsFullBriefFilesInfoForUploadOperatorV3.queryTarWaitDeleteMetaByLimit(3000L);
            if (listQueryTarWaitDeleteMetaByLimit.isEmpty()) {
                return;
            }
            C11839m.m70688i(TAG, "checkSuccessWaitDeleteMeta " + this.appId + " size: " + listQueryTarWaitDeleteMetaByLimit.size());
            for (PmsMetaV3 pmsMetaV3 : listQueryTarWaitDeleteMetaByLimit) {
                isStop();
                String data = pmsMetaV3.getData();
                if (pmsMetaV3.getEncoded() == 1) {
                    data = ICBUtil.getDecodedPath(pmsMetaV3.getData());
                }
                C12571m.m75547i(C10279b.m63452a(C10278a.m63443i(C12583q.m75674j(0), data)));
                pmsFullBriefFilesInfoForUploadOperatorV3.updateDeleteFlagByFilePath(pmsMetaV3.getFilePath());
            }
        }
    }

    private int getMaxRetryTimes() {
        BackupDataAcptErrPolicy backupDataAcptErrPolicyM29716j0 = this.client.m29716j0();
        if (backupDataAcptErrPolicyM29716j0 != null) {
            return backupDataAcptErrPolicyM29716j0.getRetryTimes();
        }
        return 2;
    }

    private String getTraceId() {
        if (BackupDataAcptErrPolicy.isReport(this.client.m29716j0())) {
            return this.client.m29654O0();
        }
        return null;
    }

    private void isStop() throws InterruptedException, C9721b {
        this.client.isCancel();
    }

    public void backup3rdAppDataIncrementV3(int i10, CloudBackupStatus cloudBackupStatus, String str) throws C9721b {
        isStop();
        int maxRetryTimes = getMaxRetryTimes();
        C11839m.m70688i(TAG, "backup3rdAppDataIncrementV3 begin retryTime: " + i10 + " ,max: " + maxRetryTimes);
        if (i10 > maxRetryTimes) {
            throw new C9721b(1037, "v3 pms copy data retry failed, appId = " + this.appId + " ,reason: " + str);
        }
        long batchCopySize = this.pmsDataV3Processor.getBatchCopySize();
        if (batchCopySize < 0) {
            cloudBackupStatus.mo29449x0(2);
        } else {
            cloudBackupStatus.mo29449x0(3);
        }
        int iProcessPmsBriefFileV3 = this.pmsBriefFileV3Processor.processPmsBriefFileV3(cloudBackupStatus);
        if (iProcessPmsBriefFileV3 != 0) {
            throw new C9721b(2101, "v3 pms brief file failed, briefCode = " + iProcessPmsBriefFileV3);
        }
        Long localLeftSpace = ICBUtil.getLocalLeftSpace();
        long jM75719a = (C12588r1.m75718c().m75719a() * 2) + (C12590s0.m75856h0() * 2);
        if (localLeftSpace != null && localLeftSpace.longValue() <= jM75719a) {
            this.pmsDataV3Processor.waitBackup(true, "waitModuleFinish.");
        }
        isStop();
        if (batchCopySize == 0) {
            ICBUtil.checkModuleNeedLocalSize(this.appId, cloudBackupStatus.mo29421n(), true);
        } else if (batchCopySize < 0) {
            checkBatchNeedLocalSize(this.appId);
        } else {
            checkSuccessWaitDeleteMeta();
        }
        this.pmsDataV3Processor.processPmsDataV3();
        isStop();
        String strM75920x0 = C12590s0.m75920x0(this.appId, this.originAppId, this.pmsBriefMetaDb, this.client.m29750u1(), this.appDataUtil, BackupDataAcptErrPolicy.getPolicyByAppId(this.originAppId, this.client.m29716j0()), getTraceId());
        if (TextUtils.isEmpty(strM75920x0)) {
            isStop();
            C11839m.m70688i(TAG, "backup3rdAppDataIncrementV3 generate brief file to backup");
            this.pmsDataV3Processor.generateBriefFileToBackupV3();
            this.pmsDataV3Processor.checkPmsDataV3();
        } else {
            C11839m.m70688i(TAG, "backup3rdAppDataIncrementV3 need reprocess pms brief file");
            new PmsFullBriefFilesInfoOperatorV3(this.pmsBriefMetaDb).renameToTemp();
            new PmsMetaStatusOperatorV3(this.pmsBriefMetaDb).updateStatus(0);
            isStop();
            backup3rdAppDataIncrementV3(i10 + 1, cloudBackupStatus, strM75920x0);
        }
        C11839m.m70688i(TAG, "backup3rdAppDataIncrementV3 end");
    }
}
