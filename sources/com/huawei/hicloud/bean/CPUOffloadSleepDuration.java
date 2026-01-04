package com.huawei.hicloud.bean;

/* loaded from: classes6.dex */
public class CPUOffloadSleepDuration {
    public static final int DEFAULT_BACKUP_SLEEP_DURATION = 200;
    public static final int DEFAULT_COMMON_SLEEP_DURATION = 100;
    public static final int DEFAULT_PHOTO_SLEEP_DURATION = 200;
    private long drive;
    private long sync;
    private long photo = 200;
    private long common = 100;
    private long backup = 200;

    public long getBackup() {
        return this.backup;
    }

    public long getCommon() {
        return this.common;
    }

    public long getDrive() {
        return this.drive;
    }

    public long getPhoto() {
        return this.photo;
    }

    public long getSync() {
        return this.sync;
    }

    public String toString() {
        return "CPUOffloadSleepDuration:{photo:" + this.photo + ",sync:" + this.sync + ",backup:" + this.backup + ",drive:" + this.drive + "}";
    }
}
