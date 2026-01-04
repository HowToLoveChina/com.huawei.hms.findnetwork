package com.huawei.hicloud.notification.bean;

import com.google.gson.JsonObject;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;

/* loaded from: classes6.dex */
public class MsgUserData {
    private NotifyAgdParameters agdParameters;
    private BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData;
    private long currentPackageSpace;
    private int days;
    private String h5ActivityUrl;
    private boolean isActivityNotify;
    private boolean isContainActivity;
    private int notifyConfigId;
    private String notifyType;
    private long packageEndTime;
    private JsonObject params;
    private String resourceId;
    private boolean showLocal;
    private long totalNeedSpace;

    public NotifyAgdParameters getAgdParameters() {
        return this.agdParameters;
    }

    public BackupSpaceNotEnoughNeedData getBackupSpaceNotEnoughNeedData() {
        return this.backupSpaceNotEnoughNeedData;
    }

    public long getCurrentPackageSpace() {
        return this.currentPackageSpace;
    }

    public int getDays() {
        return this.days;
    }

    public String getH5ActivityUrl() {
        return this.h5ActivityUrl;
    }

    public int getNotifyConfigId() {
        return this.notifyConfigId;
    }

    public String getNotifyType() {
        return this.notifyType;
    }

    public long getPackageEndTime() {
        return this.packageEndTime;
    }

    public JsonObject getParams() {
        return this.params;
    }

    public String getResourceId() {
        return this.resourceId;
    }

    public long getTotalNeedSpace() {
        return this.totalNeedSpace;
    }

    public boolean isActivityNotify() {
        return this.isActivityNotify;
    }

    public boolean isContainActivity() {
        return this.isContainActivity;
    }

    public boolean isShowLocal() {
        return this.showLocal;
    }

    public void setActivityNotify(boolean z10) {
        this.isActivityNotify = z10;
    }

    public void setAgdParameters(NotifyAgdParameters notifyAgdParameters) {
        this.agdParameters = notifyAgdParameters;
    }

    public void setBackupSpaceNotEnoughNeedData(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData) {
        this.backupSpaceNotEnoughNeedData = backupSpaceNotEnoughNeedData;
    }

    public void setContainActivity(boolean z10) {
        this.isContainActivity = z10;
    }

    public void setCurrentPackageSpace(long j10) {
        this.currentPackageSpace = j10;
    }

    public void setDays(int i10) {
        this.days = i10;
    }

    public void setH5ActivityUrl(String str) {
        this.h5ActivityUrl = str;
    }

    public void setNotifyConfigId(int i10) {
        this.notifyConfigId = i10;
    }

    public void setNotifyType(String str) {
        this.notifyType = str;
    }

    public void setPackageEndTime(long j10) {
        this.packageEndTime = j10;
    }

    public void setParams(JsonObject jsonObject) {
        this.params = jsonObject;
    }

    public void setResourceId(String str) {
        this.resourceId = str;
    }

    public void setShowLocal(boolean z10) {
        this.showLocal = z10;
    }

    public void setTotalNeedSpace(long j10) {
        this.totalNeedSpace = j10;
    }
}
