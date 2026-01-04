package com.huawei.android.hicloud.cloudbackup.manager;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public abstract class CloudBackupFileTask extends CloudBackupBaseTask implements Comparable<CloudBackupFileTask> {
    private static final AtomicLong ATOMIC = new AtomicLong();
    protected static final Object SIZE_LOCK = new Object();
    protected String appId;
    protected int priority;
    private long lastPosition = 0;
    private long queueNum = ATOMIC.getAndIncrement();

    public CloudBackupFileTask(String str, int i10) {
        this.appId = str;
        this.priority = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CloudBackupFileTask cloudBackupFileTask = (CloudBackupFileTask) obj;
        return this.queueNum == cloudBackupFileTask.queueNum && this.priority == cloudBackupFileTask.priority;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.queueNum), Integer.valueOf(this.priority));
    }

    public long increaseSize(long j10) {
        long j11 = j10 - this.lastPosition;
        this.lastPosition = j10;
        if (j11 < 0) {
            return 0L;
        }
        return j11;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void release() {
        CloudBackupTaskManager.getInstance().removeFileTask(this.appId, this);
    }

    @Override // java.lang.Comparable
    public int compareTo(CloudBackupFileTask cloudBackupFileTask) {
        int i10 = this.priority;
        int i11 = cloudBackupFileTask.priority;
        return i10 == i11 ? Long.compare(this.queueNum, cloudBackupFileTask.queueNum) : i10 < i11 ? -1 : 1;
    }
}
