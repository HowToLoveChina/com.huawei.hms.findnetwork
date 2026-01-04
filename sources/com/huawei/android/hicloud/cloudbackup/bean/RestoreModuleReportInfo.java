package com.huawei.android.hicloud.cloudbackup.bean;

import com.huawei.hicloud.cloudbackup.model.RestoreStatus;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import com.huawei.hicloud.cloudbackup.store.database.tags.CloudRestoreStatus;

/* loaded from: classes2.dex */
public class RestoreModuleReportInfo extends RestoreStatus {
    private Boolean agdDownloadSuccess;
    private String agdDownloadVersion;
    private String apkDownloadSource;
    private String data1;
    private long endTime;
    private Boolean ppsDownloadSuccess;
    private String ppsDownloadVersion;
    private String subSourceInfo;
    private int version;
    private int versionCode;
    private String errorReason = "success";
    private String versionName = "";
    private String message = "";
    private String backupSignatures = "";
    private String localSignatures = "";
    private String signCheckResult = "";
    private boolean isCitOpt = false;
    private long startTime = System.currentTimeMillis();

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getAgdDownloadVersion() {
        return this.agdDownloadVersion;
    }

    public String getApkDownloadSource() {
        return this.apkDownloadSource;
    }

    public String getBackupSignatures() {
        return this.backupSignatures;
    }

    public String getData1() {
        return this.data1;
    }

    public String getErrorReason() {
        return this.errorReason;
    }

    public String getLocalSignatures() {
        return this.localSignatures;
    }

    public String getMessage() {
        return this.message;
    }

    public String getPpsDownloadVersion() {
        return this.ppsDownloadVersion;
    }

    public long getReportEndTime() {
        return this.endTime;
    }

    public String getSignCheckResult() {
        return this.signCheckResult;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public String getSubSourceInfo() {
        return this.subSourceInfo;
    }

    public int getVersion() {
        return this.version;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        String str = this.versionName;
        return str == null ? "" : str;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    public int hashCode() {
        return super.hashCode();
    }

    public Boolean isAgdDownloadSuccess() {
        return this.agdDownloadSuccess;
    }

    public boolean isCitOpt() {
        return this.isCitOpt;
    }

    public Boolean isPpsDownloadSuccess() {
        return this.ppsDownloadSuccess;
    }

    public void setAgdDownloadSuccess(Boolean bool) {
        this.agdDownloadSuccess = bool;
    }

    public void setAgdDownloadVersion(String str) {
        this.agdDownloadVersion = str;
    }

    public void setApkDownloadSource(String str) {
        this.apkDownloadSource = str;
    }

    public void setBackupSignatures(String str) {
        this.backupSignatures = str;
    }

    public void setData1(String str) {
        this.data1 = str;
    }

    public void setErrorReason(String str) {
        this.errorReason = str;
    }

    public void setIsCitOpt(boolean z10) {
        this.isCitOpt = z10;
    }

    public void setLocalSignatures(String str) {
        this.localSignatures = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setPpsDownloadSuccess(Boolean bool) {
        this.ppsDownloadSuccess = bool;
    }

    public void setPpsDownloadVersion(String str) {
        this.ppsDownloadVersion = str;
    }

    public void setReportEndTime(long j10) {
        this.endTime = j10;
    }

    public void setSignCheckResult(String str) {
        this.signCheckResult = str;
    }

    public void setStartTime(long j10) {
        this.startTime = j10;
    }

    public void setSubSourceInfo(String str) {
        this.subSourceInfo = str;
    }

    public void setVersion(int i10) {
        this.version = i10;
    }

    public void setVersionCode(int i10) {
        this.versionCode = i10;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    @Override // com.huawei.hicloud.cloudbackup.model.RestoreStatus
    public void update(RestoreStatus restoreStatus) {
        super.update(restoreStatus);
        if (getAppId().equals(restoreStatus.getAppId())) {
            this.endTime = System.currentTimeMillis();
            if (restoreStatus instanceof CloudRestoreStatus) {
                CloudRestoreStatus cloudRestoreStatus = (CloudRestoreStatus) restoreStatus;
                setVersionName(cloudRestoreStatus.getVersionName());
                setVersionCode(cloudRestoreStatus.getVersionCode());
                setVersion(cloudRestoreStatus.getVersion());
                setSubSourceInfo(cloudRestoreStatus.m29546t());
                setApkDownloadSource(cloudRestoreStatus.m29542q());
                return;
            }
            if (restoreStatus instanceof CloudRestoreStatusV3) {
                CloudRestoreStatusV3 cloudRestoreStatusV3 = (CloudRestoreStatusV3) restoreStatus;
                setVersionName(cloudRestoreStatusV3.getVersionName());
                setVersionCode(cloudRestoreStatusV3.getVersionCode());
                setVersion(cloudRestoreStatusV3.m29466K());
                setData1(cloudRestoreStatusV3.getData1());
                setSubSourceInfo(cloudRestoreStatusV3.m29497r());
                setApkDownloadSource(cloudRestoreStatusV3.m29494p());
                setMessage(cloudRestoreStatusV3.getMessage());
                setIsCitOpt(cloudRestoreStatusV3.m29472N().contains("isCitOpt"));
            }
        }
    }
}
