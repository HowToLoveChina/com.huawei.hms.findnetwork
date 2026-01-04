package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class CloudBackupClears extends CommonCard {

    @SerializedName("backupClears")
    private BackupClears[] backupClears;

    public BackupClears[] getBackupClears() {
        return this.backupClears;
    }

    public CloudBackupClears setBackupClears(BackupClears[] backupClearsArr) {
        this.backupClears = backupClearsArr;
        return this;
    }
}
