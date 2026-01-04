package com.huawei.android.hicloud.cloudbackup.bean;

import android.graphics.drawable.Drawable;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import java.util.List;

/* loaded from: classes2.dex */
public class BackupOptionHeaderDataBean {
    private long alreadyBackupSize;
    private List<BackupOptionItem> baseDataList;
    private Drawable deviceIcon;
    private boolean isShowLoading = false;
    private long lastBackupTime;
    private String waitBackupSize;

    public long getAlreadyBackupSize() {
        return this.alreadyBackupSize;
    }

    public List<BackupOptionItem> getBaseDataList() {
        return this.baseDataList;
    }

    public Drawable getDeviceIcon() {
        return this.deviceIcon;
    }

    public long getLastBackupTime() {
        return this.lastBackupTime;
    }

    public String getWaitBackupSize() {
        return this.waitBackupSize;
    }

    public boolean isShowLoading() {
        return this.isShowLoading;
    }

    public void setAlreadyBackupSize(long j10) {
        this.alreadyBackupSize = j10;
    }

    public void setBaseDataList(List<BackupOptionItem> list) {
        this.baseDataList = list;
    }

    public void setDeviceIcon(Drawable drawable) {
        this.deviceIcon = drawable;
    }

    public void setLastBackupTime(long j10) {
        this.lastBackupTime = j10;
    }

    public void setShowLoading(boolean z10) {
        this.isShowLoading = z10;
    }

    public void setWaitBackupSize(String str) {
        this.waitBackupSize = str;
    }
}
