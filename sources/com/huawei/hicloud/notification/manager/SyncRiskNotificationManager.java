package com.huawei.hicloud.notification.manager;

import com.huawei.hicloud.notification.log.NotifyLogger;

/* loaded from: classes6.dex */
public class SyncRiskNotificationManager {
    private static final String TAG = "SyncRiskNotificationManager";
    private HNCloudConfig mCloudConfig = new HNCloudConfig();
    private HNLocalConfig mLocalConfig = new HNLocalConfig();

    public NotificationConfig getSyncRiskNoticeConfig() {
        NotifyLogger.m29915i(TAG, "getConfigFromFile");
        if (this.mCloudConfig.isExist()) {
            return this.mCloudConfig.getConfig();
        }
        NotifyLogger.m29915i(TAG, "cloud config not exist");
        return this.mLocalConfig.getConfig();
    }
}
