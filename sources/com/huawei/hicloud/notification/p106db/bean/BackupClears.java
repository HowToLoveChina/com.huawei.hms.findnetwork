package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class BackupClears {

    @SerializedName("clearableSpace")
    private long clearableSpace;

    @SerializedName("enableBackup")
    private int enableBackup;

    @SerializedName("overMonths")
    private int overMonths;

    @SerializedName("residualSpace")
    private long residualSpace;

    public long getClearableSpace() {
        return this.clearableSpace;
    }

    public int getEnableBackup() {
        return this.enableBackup;
    }

    public int getOverMonths() {
        return this.overMonths;
    }

    public long getResidualSpace() {
        return this.residualSpace;
    }

    public BackupClears setClearableSpace(long j10) {
        this.clearableSpace = j10;
        return this;
    }

    public BackupClears setEnableBackup(int i10) {
        this.enableBackup = i10;
        return this;
    }

    public BackupClears setOverMonths(int i10) {
        this.overMonths = i10;
        return this;
    }

    public BackupClears setResidualSpace(long j10) {
        this.residualSpace = j10;
        return this;
    }

    public String toString() {
        return "BackupClears{clearableSpace=" + this.clearableSpace + ", enableBackup=" + this.enableBackup + ", overMonths=" + this.overMonths + ", residualSpace=" + this.residualSpace + '}';
    }
}
