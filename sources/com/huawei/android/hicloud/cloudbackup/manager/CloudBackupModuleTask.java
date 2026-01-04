package com.huawei.android.hicloud.cloudbackup.manager;

import p495nm.C11728i;

/* loaded from: classes2.dex */
public abstract class CloudBackupModuleTask extends CloudBackupBaseTask {
    protected String appId;
    protected C11728i mCompressParams;

    public CloudBackupModuleTask(String str) {
        this.appId = str;
    }

    @Override // com.huawei.android.hicloud.cloudbackup.manager.CloudBackupBaseTask
    public void release() {
        CloudBackupTaskManager.getInstance().removeModuleTask(this.appId, this);
    }
}
