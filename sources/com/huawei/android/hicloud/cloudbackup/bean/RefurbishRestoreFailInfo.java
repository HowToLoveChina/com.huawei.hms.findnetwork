package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.Arrays;

/* loaded from: classes2.dex */
public class RefurbishRestoreFailInfo {
    private String backupId;
    private String[] failList;

    public RefurbishRestoreFailInfo() {
    }

    public String getBackupId() {
        return this.backupId;
    }

    public String[] getFailList() {
        return this.failList;
    }

    public void setBackupId(String str) {
        this.backupId = str;
    }

    public void setFailList(String[] strArr) {
        this.failList = strArr;
    }

    public String toString() {
        return "RefurbishRestoreFailInfo{backupId='" + this.backupId + "', failList=" + Arrays.toString(this.failList) + '}';
    }

    public RefurbishRestoreFailInfo(String str, String[] strArr) {
        this.backupId = str;
        this.failList = strArr;
    }
}
