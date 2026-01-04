package com.huawei.hicloud.notification.manager;

import com.google.gson.Gson;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import java.io.File;
import p015ak.C0213f;

/* loaded from: classes6.dex */
public class HNLocalConfig extends BaseNotificationConfig {
    private static final String TAG = "CBPushLocalConfig";

    public void clearLocalExtConfig() {
        boolean zDelete;
        try {
            File file = new File(C0213f.m1377a().getFilesDir() + File.separator + HNConstants.CloudConfig.LOCAL_CONFIG_FILE_EXT_NAME);
            if (!file.exists() || (zDelete = file.delete())) {
                return;
            }
            NotifyLogger.m29914e(TAG, "deleteResult is:" + zDelete);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "clearLocalExtConfig exception:" + e10.toString());
        }
    }

    @Override // com.huawei.hicloud.notification.manager.BaseNotificationConfig
    public NotificationConfig getConfig() {
        if (!isExist()) {
            extractConfig();
        }
        NotificationConfig configRaw = getConfigRaw(HNConstants.CloudConfig.LOCAL_CONFIG_EXT_FILE_PATH);
        this.config = configRaw;
        return configRaw;
    }

    @Override // com.huawei.hicloud.notification.manager.BaseNotificationConfig
    public NotificationConfig getConfigFromFile() {
        NotifyLogger.m29915i(TAG, "getConfigFromFile");
        try {
            this.config = (NotificationConfig) new Gson().fromJson(readConfigStr(C0213f.m1377a().getAssets().open(HNConstants.LocalConfig.DEFAUT_CONFIG_FILE)), NotificationConfig.class);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "open local config fail msg:" + e10.getMessage());
        }
        return this.config;
    }

    @Override // com.huawei.hicloud.notification.manager.BaseNotificationConfig
    public String getExtFilePath() {
        return HNConstants.CloudConfig.LOCAL_CONFIG_EXT_FILE_PATH;
    }

    @Override // com.huawei.hicloud.notification.manager.BaseNotificationConfig
    public boolean isExist() {
        boolean zExists = new File(C0213f.m1377a().getFilesDir() + File.separator + HNConstants.CloudConfig.LOCAL_CONFIG_FILE_EXT_NAME).exists();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isExist = ");
        sb2.append(zExists);
        NotifyLogger.m29915i(TAG, sb2.toString());
        return zExists;
    }

    @Override // com.huawei.hicloud.notification.manager.BaseNotificationConfig
    public boolean requestConfig() {
        return false;
    }

    @Override // com.huawei.hicloud.notification.manager.BaseNotificationConfig
    public boolean requestConfigVersion() {
        return false;
    }

    @Override // com.huawei.hicloud.notification.manager.BaseNotificationConfig
    public void requestNoticeConfig() {
    }
}
