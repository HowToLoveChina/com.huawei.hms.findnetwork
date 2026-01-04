package com.huawei.hicloud.notification;

import android.content.Context;
import com.huawei.hicloud.notification.config.SyncLimitConfig;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.NotificationConfig;
import com.huawei.hicloud.notification.util.NotifyUtil;

/* loaded from: classes6.dex */
public class SyncLimitConfigRunnable implements Runnable {
    private static final String TAG = "SyncLimitConfigRunnable";
    private NotificationConfig notificationConfig;
    private SyncLimitConfig syncLimitConfig;

    public SyncLimitConfigRunnable(Context context, NotificationConfig notificationConfig) {
        this.notificationConfig = notificationConfig;
    }

    @Override // java.lang.Runnable
    public void run() {
        NotificationConfig notificationConfig = this.notificationConfig;
        if (notificationConfig == null || notificationConfig.getCloudphotoFirstSync() == null) {
            NotifyLogger.m29915i(TAG, "no need to set config");
            return;
        }
        SyncLimitConfig cloudphotoFirstSync = this.notificationConfig.getCloudphotoFirstSync();
        this.syncLimitConfig = cloudphotoFirstSync;
        int uploadLimitNum = cloudphotoFirstSync.getUploadLimitNum();
        int uploadLimitSize = this.syncLimitConfig.getUploadLimitSize();
        int downloadLimitNum = this.syncLimitConfig.getDownloadLimitNum();
        int downloadNum = this.syncLimitConfig.getDownloadNum();
        NotifyLogger.m29915i(TAG, "setSyncLimitConfig uploadMaxNum=" + uploadLimitNum + ", uploadMaxSize=" + uploadLimitSize + ", downloadMaxNum=" + downloadLimitNum + ", downloadNum=" + downloadNum);
        NotifyUtil.sendSyncLimitConfigBroadcast(uploadLimitNum, uploadLimitSize, downloadLimitNum, downloadNum);
    }
}
