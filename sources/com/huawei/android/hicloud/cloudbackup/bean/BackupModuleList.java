package com.huawei.android.hicloud.cloudbackup.bean;

import java.util.List;
import p586qp.InterfaceC12382a;
import p714vp.AbstractC13477b;

@InterfaceC12382a(name = "BackupModuleList")
/* loaded from: classes2.dex */
public class BackupModuleList extends AbstractC13477b {
    private String backupId;
    List<BackupModuleInfo> mBackupModuleList;

    public String getBackupId() {
        return this.backupId;
    }

    public List<BackupModuleInfo> getBackupModuleList() {
        return this.mBackupModuleList;
    }

    public void setBackupId(String str) {
        this.backupId = str;
    }

    public void setBackupModuleList(List<BackupModuleInfo> list) {
        this.mBackupModuleList = list;
    }
}
