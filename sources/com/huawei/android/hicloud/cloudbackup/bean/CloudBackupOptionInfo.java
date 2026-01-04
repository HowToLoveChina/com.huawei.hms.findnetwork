package com.huawei.android.hicloud.cloudbackup.bean;

import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class CloudBackupOptionInfo {
    private BackupOptionItem appDataModule;
    private boolean isCacheData;
    private List<BackupOptionItem> systemItemList = new ArrayList();
    private List<BackupOptionItem> virtualItemList = new ArrayList();
    private List<BackupOptionItem> thirdAppItemList = new ArrayList();
    private List<String> virtuals = new ArrayList();

    public BackupOptionItem getAppDataModule() {
        return this.appDataModule;
    }

    public List<BackupOptionItem> getSystemItemList() {
        return this.systemItemList;
    }

    public List<BackupOptionItem> getThirdAppItemList() {
        return this.thirdAppItemList;
    }

    public List<BackupOptionItem> getVirtualItemList() {
        return this.virtualItemList;
    }

    public List<String> getVirtuals() {
        return this.virtuals;
    }

    public boolean isCacheData() {
        return this.isCacheData;
    }

    public void setAppDataModule(BackupOptionItem backupOptionItem) {
        this.appDataModule = backupOptionItem;
    }

    public void setCacheData(boolean z10) {
        this.isCacheData = z10;
    }

    public void setSystemItemList(List<BackupOptionItem> list) {
        this.systemItemList = list;
    }

    public void setThirdAppItemList(List<BackupOptionItem> list) {
        this.thirdAppItemList = list;
    }

    public void setVirtualItemList(List<BackupOptionItem> list) {
        this.virtualItemList = list;
    }

    public void setVirtuals(List<String> list) {
        this.virtuals = list;
    }
}
