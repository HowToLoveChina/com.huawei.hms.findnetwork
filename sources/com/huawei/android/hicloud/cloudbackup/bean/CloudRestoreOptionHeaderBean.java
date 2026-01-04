package com.huawei.android.hicloud.cloudbackup.bean;

import com.huawei.hicloud.cloudbackup.model.CloudRestoreItem;

/* loaded from: classes2.dex */
public class CloudRestoreOptionHeaderBean {
    private CloudRestoreItem baseDataItem;
    private int bmDataType;
    private boolean hasAppData;
    private boolean isBaseChecked;
    private boolean isMainSwitchEnable;
    private String recordVersion;
    private long selectedSize;
    private String recordBackupTime = "";
    private boolean isMainSwitchCheck = true;

    public CloudRestoreItem getBaseDataItem() {
        return this.baseDataItem;
    }

    public int getBmDataType() {
        return this.bmDataType;
    }

    public String getRecordBackupTime() {
        return this.recordBackupTime;
    }

    public String getRecordVersion() {
        return this.recordVersion;
    }

    public long getSelectedSize() {
        return this.selectedSize;
    }

    public boolean hasAppData() {
        return this.hasAppData;
    }

    public boolean isBaseChecked() {
        return this.isBaseChecked;
    }

    public boolean isMainSwitchCheck() {
        return this.isMainSwitchCheck;
    }

    public boolean isMainSwitchEnable() {
        return this.isMainSwitchEnable;
    }

    public void setBaseChecked(boolean z10) {
        this.isBaseChecked = z10;
    }

    public void setBaseDataItem(CloudRestoreItem cloudRestoreItem) {
        this.baseDataItem = cloudRestoreItem;
    }

    public void setBmDataType(int i10) {
        this.bmDataType = i10;
    }

    public void setHasAppData(boolean z10) {
        this.hasAppData = z10;
    }

    public void setMainSwitchCheck(boolean z10) {
        this.isMainSwitchCheck = z10;
    }

    public void setMainSwitchEnable(boolean z10) {
        this.isMainSwitchEnable = z10;
    }

    public void setRecordBackupTime(String str) {
        this.recordBackupTime = str;
    }

    public void setRecordVersion(String str) {
        this.recordVersion = str;
    }

    public void setSelectedSize(long j10) {
        this.selectedSize = j10;
    }
}
