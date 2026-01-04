package com.huawei.android.hicloud.cloudbackup.pmsbrieffile;

import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsFullBriefFilesInfoOperator;
import com.huawei.android.hicloud.cloudbackup.pmsbrieffile.p077db.operator.PmsMetaStatusOperator;
import com.huawei.android.hicloud.cloudbackup.process.CacheTask;
import com.huawei.android.hicloud.cloudbackup.process.util.ProgressCallback;
import com.huawei.android.hicloud.cloudbackup.process.util.ScanAppDataUtil;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudBackupStatus;
import fk.C9721b;
import p514o9.C11839m;
import p744wl.C13617a;
import sl.C12815f;

/* loaded from: classes2.dex */
public class PmsDataManagement {
    private static final int MAX_RETRY_TIMES = 3;
    private static final String TAG = "PmsDataManagement";
    private String appId;
    private CloudBackupStatus backupStatus;
    private CacheTask client;
    private PmsBriefFileProcessor pmsBriefFileProcessor;
    private String pmsBriefMetaDb;
    private PmsDataProcessor pmsDataProcessor;

    public static class PmsResult {
        int briefCode;
        int executeStatus;
        boolean isPmsSupportGetBriefCmd;

        public int getBriefCode() {
            return this.briefCode;
        }

        public int getExecuteStatus() {
            return this.executeStatus;
        }

        public boolean isPmsSupportGetBriefCmd() {
            return this.isPmsSupportGetBriefCmd;
        }

        public void setBriefCode(int i10) {
            this.briefCode = i10;
        }

        public void setExecuteStatus(int i10) {
            this.executeStatus = i10;
        }

        public void setPmsSupportGetBriefCmd(boolean z10) {
            this.isPmsSupportGetBriefCmd = z10;
        }
    }

    public PmsDataManagement(String str, CacheTask cacheTask, String str2, String str3, String str4, String str5, String str6, ScanAppDataUtil scanAppDataUtil, ProgressCallback progressCallback, CloudBackupStatus cloudBackupStatus, boolean z10) {
        String strM81914C = C13617a.m81914C(str, 0);
        this.pmsBriefMetaDb = strM81914C;
        this.pmsBriefFileProcessor = new PmsBriefFileProcessor(str, strM81914C, progressCallback, cacheTask, str2, str3, str4, str5, str6, scanAppDataUtil, z10);
        this.pmsDataProcessor = new PmsDataProcessor(str, this.pmsBriefMetaDb, cacheTask, scanAppDataUtil, progressCallback);
        this.client = cacheTask;
        this.appId = str;
        this.backupStatus = cloudBackupStatus;
    }

    private void isStop() throws InterruptedException, C9721b {
        this.client.isCancel();
    }

    public int backup3rdAppDataIncrement(int i10) throws Throwable {
        isStop();
        C11839m.m70688i(TAG, "backup3rdAppDataIncrement begin");
        if (i10 >= 3) {
            throw new C9721b(1037, "pms copy data retry failed, appId = " + this.appId);
        }
        int iProcessPmsBriefFile = this.pmsBriefFileProcessor.processPmsBriefFile();
        if (iProcessPmsBriefFile == -3) {
            String str = this.appId;
            ICBUtil.checkModuleNeedLocalSize(str, str, false);
            return iProcessPmsBriefFile;
        }
        if (iProcessPmsBriefFile != 0) {
            throw new C9721b(2101, "pms brief file failed, briefCode = " + iProcessPmsBriefFile);
        }
        isStop();
        String str2 = this.appId;
        ICBUtil.checkModuleNeedLocalSize(str2, str2, false);
        this.backupStatus.mo29449x0(2);
        new C12815f().m76934m(this.backupStatus);
        this.pmsDataProcessor.processPmsData();
        isStop();
        if (this.pmsBriefFileProcessor.isNeedReprocessPmsBriefFile()) {
            C11839m.m70688i(TAG, "backup3rdAppDataIncrement need reprocess pms brief file");
            new PmsFullBriefFilesInfoOperator(this.pmsBriefMetaDb).renameToTemp();
            new PmsMetaStatusOperator(this.pmsBriefMetaDb).updateStatus(0);
            isStop();
            backup3rdAppDataIncrement(i10 + 1);
        } else {
            isStop();
            C11839m.m70688i(TAG, "backup3rdAppDataIncrement generate brief file to backup");
            this.pmsDataProcessor.generateBriefFileToBackup();
            this.pmsDataProcessor.checkPmsData();
        }
        C11839m.m70688i(TAG, "backup3rdAppDataIncrement end");
        return iProcessPmsBriefFile;
    }
}
