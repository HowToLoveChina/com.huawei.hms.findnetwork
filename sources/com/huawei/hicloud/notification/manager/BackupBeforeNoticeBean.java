package com.huawei.hicloud.notification.manager;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.p106db.bean.BackupBeforeNoticeConfig;

/* loaded from: classes6.dex */
public class BackupBeforeNoticeBean {

    @SerializedName(NotifyConstants.CLOUD_BACKUP_BEFORE_NOTICE)
    private BackupBeforeNoticeConfig mBackupBeforeNoticeConfig;

    public BackupBeforeNoticeConfig getBackupBeforeNoticeConfig() {
        return this.mBackupBeforeNoticeConfig;
    }

    public void setBackupBeforeNoticeConfig(BackupBeforeNoticeConfig backupBeforeNoticeConfig) {
        this.mBackupBeforeNoticeConfig = backupBeforeNoticeConfig;
    }
}
