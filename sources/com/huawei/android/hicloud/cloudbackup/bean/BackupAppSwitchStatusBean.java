package com.huawei.android.hicloud.cloudbackup.bean;

/* loaded from: classes2.dex */
public class BackupAppSwitchStatusBean {
    private String appId;
    private String beginTime;
    private String dataSize;
    private String endTime;
    private String increase1;
    private String increase2;
    private String isBackupData;
    private String switchStatus;

    /* renamed from: ts */
    private String f11653ts;

    public String getAppId() {
        return this.appId;
    }

    public String getBeginTime() {
        return this.beginTime;
    }

    public String getCurrentIncrease() {
        return this.increase2;
    }

    public String getDataSize() {
        return this.dataSize;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getIsBackupData() {
        return this.isBackupData;
    }

    public String getSwitchStatus() {
        return this.switchStatus;
    }

    public String getTotalIncrease() {
        return this.increase1;
    }

    public String getTs() {
        return this.f11653ts;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setBeginTime(String str) {
        this.beginTime = str;
    }

    public void setCurrentIncrease(String str) {
        this.increase2 = str;
    }

    public void setDataSize(String str) {
        this.dataSize = str;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setIsBackupData(String str) {
        this.isBackupData = str;
    }

    public void setSwitchStatus(String str) {
        this.switchStatus = str;
    }

    public void setTotalIncrease(String str) {
        this.increase1 = str;
    }

    public void setTs(String str) {
        this.f11653ts = str;
    }
}
