package com.huawei.android.hicloud.cloudbackup.bean;

/* loaded from: classes2.dex */
public class AppBackupDuration {
    AppBackupDurationInfo auto;
    AppBackupDurationInfo manual;

    public AppBackupDurationInfo getAuto() {
        AppBackupDurationInfo appBackupDurationInfo = this.auto;
        return appBackupDurationInfo == null ? new AppBackupDurationInfo() : appBackupDurationInfo;
    }

    public AppBackupDurationInfo getManual() {
        AppBackupDurationInfo appBackupDurationInfo = this.manual;
        return appBackupDurationInfo == null ? new AppBackupDurationInfo() : appBackupDurationInfo;
    }

    public void setAuto(AppBackupDurationInfo appBackupDurationInfo) {
        this.auto = appBackupDurationInfo;
    }

    public void setManual(AppBackupDurationInfo appBackupDurationInfo) {
        this.manual = appBackupDurationInfo;
    }

    public String toString() {
        return "AppBackupDuration{manual=" + this.manual + ", auto=" + this.auto + '}';
    }
}
