package com.huawei.hicloud.cloudbackup.p104v3.omconfig.model;

import android.text.TextUtils;

/* loaded from: classes6.dex */
public class SyncAppBackupPolicy {
    private String backupAppName;
    private int policy;
    private String syncAppName;

    public SyncAppBackupPolicy(String str, String str2, int i10) {
        this.syncAppName = str;
        this.backupAppName = str2;
        this.policy = i10;
    }

    public String getBackupAppName() {
        return TextUtils.isEmpty(this.backupAppName) ? "" : this.backupAppName;
    }

    public int getPolicy() {
        return this.policy;
    }

    public String getSyncAppName() {
        return TextUtils.isEmpty(this.syncAppName) ? "" : this.syncAppName;
    }

    public boolean isMutex() {
        return this.policy == 1;
    }

    public void setBackupAppName(String str) {
        this.backupAppName = str;
    }

    public void setPolicy(int i10) {
        this.policy = i10;
    }

    public void setSyncAppName(String str) {
        this.syncAppName = str;
    }

    public String toString() {
        return "[syncAppName: " + this.syncAppName + ", backupAppName: " + this.backupAppName + ", policy = " + this.policy + "]";
    }
}
