package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.List;

/* loaded from: classes2.dex */
public class BackupStateProviderReqPara {
    private List<Integer> backupVersion;
    private List<Integer> category;
    private Integer timeOut;

    public List<Integer> getBackupVersion() {
        return this.backupVersion;
    }

    public List<Integer> getCategory() {
        return this.category;
    }

    public Integer getTimeOut() {
        return this.timeOut;
    }

    public void setBackupVersion(List<Integer> list) {
        this.backupVersion = list;
    }

    public void setCategory(List<Integer> list) {
        this.category = list;
    }

    public void setTimeOut(Integer num) {
        this.timeOut = num;
    }

    public String toString() {
        return "BackupStateProviderReqPara{category=" + this.category + ", backupVersion=" + this.backupVersion + ", timeOut=" + this.timeOut + '}';
    }
}
