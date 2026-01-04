package com.huawei.hicloud.notification.manager;

import android.content.Context;
import android.database.SQLException;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.ExtraNotifyConfig;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotifyConfig;
import com.huawei.hicloud.notification.p106db.operator.CommonNotifyContentOperator;
import com.huawei.hicloud.notification.p106db.operator.NDCOperator;
import com.huawei.hicloud.notification.p106db.operator.RestoreNotifyLanguageOperator;
import com.huawei.hicloud.notification.p106db.operator.RestoreNotifyOperator;
import com.huawei.hicloud.notification.p106db.operator.RestoreNotifydDevicesOperator;
import com.huawei.hicloud.notification.p106db.operator.SpaceNotifyContentOperator;
import com.huawei.hicloud.notification.p106db.operator.SpaceNotifyDetailOperator;
import com.huawei.hicloud.notification.task.SpaceNoticeV3ClearTask;
import com.huawei.hicloud.notification.util.NoticeWithActivityUtil;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.service.C5007d0;
import fk.C9721b;
import java.io.File;
import p015ak.C0213f;
import p292fn.C9734g;
import p616rk.C12515a;

/* loaded from: classes6.dex */
public class HNCloudConfig extends BaseNotificationConfig {
    private static final String TAG = "HNCloudConfig";
    private C5007d0 noticeConfigService;

    private void extractExtraNoticeLanguage() {
        NotificationConfig configFromFile = getConfigFromFile();
        if (configFromFile == null) {
            NotifyLogger.m29914e(TAG, "extractConfig failed, fullConfig is null");
            return;
        }
        ExtraNotifyConfig hiCloudSpaceNoticeV2 = configFromFile.getHiCloudSpaceNoticeV2();
        if (hiCloudSpaceNoticeV2 == null) {
            NotifyLogger.m29914e(TAG, "no space notify config to extract");
        } else {
            ExtraNoticeConfigManager.getInstance().extractLanguage(hiCloudSpaceNoticeV2);
        }
    }

    private void extractNoticeLanguage() {
        NotificationConfig configFromFile = getConfigFromFile();
        if (configFromFile == null) {
            NotifyLogger.m29914e(TAG, "extractConfig failed, fullConfig is null");
            return;
        }
        SpaceNotifyConfig hiCloudSpaceNotice = configFromFile.getHiCloudSpaceNotice();
        if (hiCloudSpaceNotice == null) {
            NotifyLogger.m29914e(TAG, "no space notify config to extract");
        } else {
            NoticeWithActivityUtil.getInstance().extractLanguage(hiCloudSpaceNotice);
        }
    }

    private void extractSyncModuleConfig() {
        NotificationConfig configFromFile = getConfigFromFile();
        if (configFromFile == null) {
            NotifyLogger.m29914e(TAG, "extractConfig failed, fullConfig is null");
            return;
        }
        SyncModuleConfigManager.getInstance().parseSyncConfig(configFromFile.getSyncConfig());
        NotifyLogger.m29915i(TAG, "extractConfig is not support drive function");
    }

    public void clearCloudConfig() {
        boolean zDelete;
        boolean zDelete2;
        try {
            Context contextM1377a = C0213f.m1377a();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(contextM1377a.getFilesDir());
            String str = File.separator;
            sb2.append(str);
            sb2.append(HNConstants.CloudConfig.CLOUD_CONFIG_FILE_NAME);
            File file = new File(sb2.toString());
            if (file.exists() && !(zDelete2 = file.delete())) {
                NotifyLogger.m29914e(TAG, "deleteResult is:" + zDelete2);
            }
            File file2 = new File(contextM1377a.getFilesDir() + str + HNConstants.CloudConfig.CLOUD_CONFIG_FILE_EXT_NAME);
            if (file2.exists() && !(zDelete = file2.delete())) {
                NotifyLogger.m29914e(TAG, "deleteResult is:" + zDelete);
            }
            NoticeWithActivityUtil.getInstance().deleteLanguageFile();
            ExtraNoticeConfigManager.getInstance().deleteLanguageFile();
            C12515a.m75110o().m75175e(new SpaceNoticeV3ClearTask(), true);
            NotificationReportUtil.reportSpaceNotifyClear(NotifyConstants.ClearSpaceFrequencyDBFrom.FROM_CLEAR_CLOUD_CONFIG);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "clearCloudConfig exception:" + e10.toString());
        }
    }

    public void clearSpaceNotifyDb() throws SQLException {
        new NDCOperator().clear();
        new SpaceNotifyContentOperator().clear();
        new SpaceNotifyDetailOperator().clear();
        new CommonNotifyContentOperator().clear();
        new RestoreNotifyOperator().clear();
        new RestoreNotifydDevicesOperator().clear();
        new RestoreNotifyLanguageOperator().clear();
    }

    @Override // com.huawei.hicloud.notification.manager.BaseNotificationConfig
    public NotificationConfig getConfig() {
        return getConfigRaw(HNConstants.CloudConfig.CLOUD_CONFIG_EXT_FILE_PATH);
    }

    @Override // com.huawei.hicloud.notification.manager.BaseNotificationConfig
    public NotificationConfig getConfigFromFile() {
        NotifyLogger.m29915i(TAG, "getConfigFromFile");
        NotificationConfig configRaw = getConfigRaw(HNConstants.CloudConfig.CLOUD_CONFIG_FILE_PATH);
        this.config = configRaw;
        return configRaw;
    }

    @Override // com.huawei.hicloud.notification.manager.BaseNotificationConfig
    public String getExtFilePath() {
        return HNConstants.CloudConfig.CLOUD_CONFIG_EXT_FILE_PATH;
    }

    @Override // com.huawei.hicloud.notification.manager.BaseNotificationConfig
    public boolean isExist() {
        NotifyLogger.m29915i(TAG, "isExist");
        return new File(C0213f.m1377a().getFilesDir() + HNConstants.CloudConfig.CLOUD_CONFIG_EXT_FILE_PATH).exists();
    }

    @Override // com.huawei.hicloud.notification.manager.BaseNotificationConfig
    public boolean requestConfig() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0064, code lost:
    
        if (p459lp.C11327e.m68063f("HiCloudNoticeConfigAllInOne") >= r2) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0066, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i(com.huawei.hicloud.notification.manager.HNCloudConfig.TAG, "version updated, query config");
        requestNoticeConfig();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x006f, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0070, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i(com.huawei.hicloud.notification.manager.HNCloudConfig.TAG, "version not updated, extract sync module config");
        extractSyncModuleConfig();
        extractNoticeLanguage();
        extractExtraNoticeLanguage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x007e, code lost:
    
        return false;
     */
    @Override // com.huawei.hicloud.notification.manager.BaseNotificationConfig
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean requestConfigVersion() throws android.database.SQLException {
        /*
            r7 = this;
            java.lang.String r0 = "request notice config version"
            java.lang.String r1 = "HNCloudConfig"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            com.huawei.hicloud.service.d0 r0 = r7.noticeConfigService
            if (r0 != 0) goto L13
            com.huawei.hicloud.service.d0 r0 = new com.huawei.hicloud.service.d0
            r2 = 0
            r0.<init>(r2)
            r7.noticeConfigService = r0
        L13:
            r0 = 0
            r2 = r0
        L15:
            r3 = 2
            if (r2 > r3) goto L5a
            com.huawei.hicloud.service.d0 r4 = r7.noticeConfigService     // Catch: fk.C9721b -> L1f
            long r2 = r4.getConfigVersion()     // Catch: fk.C9721b -> L1f
            goto L5c
        L1f:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "request notice config version exception: "
            r5.append(r6)
            java.lang.String r6 = r4.toString()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r1, r5)
            com.huawei.hicloud.service.d0 r5 = r7.noticeConfigService
            boolean r4 = r5.isExceptionNeedRetry(r4)
            if (r4 == 0) goto L59
            if (r2 >= r3) goto L59
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "requestConfigVersion exception retry, retry num: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r3)
            int r2 = r2 + 1
            goto L15
        L59:
            return r0
        L5a:
            r2 = 0
        L5c:
            java.lang.String r4 = "HiCloudNoticeConfigAllInOne"
            long r4 = p459lp.C11327e.m68063f(r4)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L70
            java.lang.String r0 = "version updated, query config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            r7.requestNoticeConfig()
            r7 = 1
            return r7
        L70:
            java.lang.String r2 = "version not updated, extract sync module config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r2)
            r7.extractSyncModuleConfig()
            r7.extractNoticeLanguage()
            r7.extractExtraNoticeLanguage()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.manager.HNCloudConfig.requestConfigVersion():boolean");
    }

    @Override // com.huawei.hicloud.notification.manager.BaseNotificationConfig
    public void requestNoticeConfig() throws SQLException {
        NotifyLogger.m29915i(TAG, "requestNoticeConfig");
        if (this.noticeConfigService == null) {
            this.noticeConfigService = new C5007d0(null);
        }
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "request notice config exception: " + e10.toString());
                if (NotifyUtil.procFlowControlException(e10, "HiCloudNoticeConfigAllInOne")) {
                    return;
                }
                if (e10.m60659c() == 304) {
                    NotifyLogger.m29914e(TAG, "HTTP_NOT_MODIFY extract sync module config");
                    extractSyncModuleConfig();
                    extractNoticeLanguage();
                    extractExtraNoticeLanguage();
                    return;
                }
                if (!this.noticeConfigService.isExceptionNeedRetry(e10) || i10 >= 2) {
                    return;
                }
                NotifyLogger.m29915i(TAG, "getLatestConfig exception retry, retry num: " + i10);
            }
            if (this.noticeConfigService.getLatestConfig()) {
                NotifyLogger.m29915i(TAG, "request notice config success");
                C9734g.m60767a().m60769c("HiCloudNoticeConfigAllInOne");
                new HNLocalConfig().clearLocalExtConfig();
                clearSpaceNotifyDb();
                NotificationReportUtil.reportSpaceNotifyClear(NotifyConstants.ClearSpaceFrequencyDBFrom.FROM_GET_LATEST_CONFIG);
                NoticeWithActivityUtil.getInstance().clearLangVersionAndResult();
                ExtraNoticeConfigManager.getInstance().clearLangVersionAndResult();
                extractConfig();
                return;
            }
            NotifyLogger.m29914e(TAG, "query cloud notify config failed");
            if (i10 >= 2) {
                return;
            }
            NotifyLogger.m29915i(TAG, "getLatestConfig failed retry, retry num: " + i10);
        }
    }
}
