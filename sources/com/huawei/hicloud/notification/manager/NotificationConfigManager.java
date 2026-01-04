package com.huawei.hicloud.notification.manager;

import android.database.SQLException;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.ExtraNoticeConfiguration;
import com.huawei.hicloud.notification.p106db.bean.ExtraNotificationBean;
import com.huawei.hicloud.notification.p106db.bean.ExtraNotifyConfig;
import com.huawei.hicloud.notification.p106db.bean.HiCloudSpaceNoticeConfiguration;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotifyConfig;
import com.huawei.hicloud.notification.p106db.languageoperator.ExtraNoticeLanguageOperator;
import com.huawei.hicloud.notification.p106db.operator.CommonNotifyContentOperator;
import com.huawei.hicloud.notification.p106db.operator.NDCOperator;
import com.huawei.hicloud.notification.p106db.operator.NoticeContentLanguageOperator;
import com.huawei.hicloud.notification.p106db.operator.SNTimeOperator;
import com.huawei.hicloud.notification.p106db.operator.SpaceNotifyContentOperator;
import com.huawei.hicloud.notification.p106db.operator.SpaceNotifyDetailOperator;
import gp.C10028c;
import java.util.List;
import p742wj.C13612b;

/* loaded from: classes6.dex */
public class NotificationConfigManager {
    private static final String TAG = "NotificationConfigManager";
    private HNCloudConfig mCloudConfig = new HNCloudConfig();
    private HNLocalConfig mLocalConfig = new HNLocalConfig();

    public void checkLanguageDataBase() throws Throwable {
        NotifyLogger.m29915i(TAG, "checkLanguageDataBase");
        NotificationConfig configFromFile = getConfigFromFile();
        if (configFromFile == null) {
            return;
        }
        SyncModuleConfigManager.getInstance().checkLanguageDataBase(configFromFile.getSyncConfig());
        DriveModuleConfigManager.getInstance().checkLanguageDataBase(configFromFile.getDriveConfig());
        ExtraNoticeConfigManager.getInstance().checkLanguageDataBase(configFromFile.getHiCloudSpaceNoticeV2());
        new ForcedUpgradeNotificationManager().checkLanguageDataBase(configFromFile.getHiCloudUpgradeNotice());
    }

    public void clear() {
        this.mCloudConfig.clearCloudConfig();
    }

    public void clearConfigAndDB() throws SQLException {
        NotifyLogger.m29915i(TAG, "clearConfigAndDB");
        this.mCloudConfig.clearCloudConfig();
        this.mLocalConfig.clearLocalExtConfig();
        new SpaceNotifyContentOperator().clear();
        new SpaceNotifyDetailOperator().clear();
        new CommonNotifyContentOperator().clear();
        new NoticeContentLanguageOperator().clear();
        new ExtraNoticeLanguageOperator().clear();
    }

    public NotificationConfig getConfigFromFile() {
        NotificationConfig config;
        SpaceNoticeV3Bean spaceNoticeConfigV3;
        NotifyLogger.m29915i(TAG, "getConfigFromFile");
        if (this.mCloudConfig.isExist()) {
            config = this.mCloudConfig.getConfig();
        } else {
            NotifyLogger.m29915i(TAG, "cloud config not exist");
            if (C13612b.m81829B().isLogin() && C10028c.m62182c0().m62221H1()) {
                NotifyLogger.m29915i(TAG, "exeCmdGetConfig already login");
                HiCloudAllOMConfigManager.getInstance().queryConfigAsync("HiCloudNoticeConfigAllInOne");
            }
            config = this.mLocalConfig.getConfig();
        }
        if (config != null && (spaceNoticeConfigV3 = SpaceNoticeV3Manager.getInstance().getSpaceNoticeConfigV3()) != null) {
            config.setHiCloudSpaceNotice(spaceNoticeConfigV3.getmSpaceNotifyConfig());
        }
        return config;
    }

    public ExtraNotificationBean getExtraNotificationById(int i10) {
        NotificationConfig configFromFile = getConfigFromFile();
        if (configFromFile == null) {
            NotifyLogger.m29914e(TAG, "getExtraNotificationById, fullConfig is null");
            return null;
        }
        ExtraNotifyConfig hiCloudSpaceNoticeV2 = configFromFile.getHiCloudSpaceNoticeV2();
        if (hiCloudSpaceNoticeV2 == null) {
            NotifyLogger.m29914e(TAG, "getExtraNotificationById, extraNotifyConfig is null");
            return null;
        }
        ExtraNoticeConfiguration configuration = hiCloudSpaceNoticeV2.getConfiguration();
        if (configuration == null) {
            NotifyLogger.m29914e(TAG, "getExtraNotificationById, configuration is null");
            return null;
        }
        List<ExtraNotificationBean> notification = configuration.getNotification();
        if (notification == null || notification.isEmpty()) {
            NotifyLogger.m29914e(TAG, "getExtraNotificationById, extraNotificationBeans is null");
            return null;
        }
        for (ExtraNotificationBean extraNotificationBean : notification) {
            if (i10 == extraNotificationBean.getId()) {
                return extraNotificationBean;
            }
        }
        NotifyLogger.m29914e(TAG, "getExtraNotificationById, no fit notification");
        return null;
    }

    public void getNoticeConfig() throws SQLException {
        this.mCloudConfig.requestNoticeConfig();
    }

    public NotificationWithActivity getSpaceNotifyActivityById(int i10) {
        NotificationConfig configFromFile = getConfigFromFile();
        if (configFromFile == null) {
            NotifyLogger.m29914e(TAG, "getSpaceNotifyActivityById, fullConfig is null");
            return null;
        }
        SpaceNotifyConfig hiCloudSpaceNotice = configFromFile.getHiCloudSpaceNotice();
        if (hiCloudSpaceNotice == null) {
            NotifyLogger.m29914e(TAG, "getSpaceNotifyActivityById, spaceNotifyConfig is null");
            return null;
        }
        HiCloudSpaceNoticeConfiguration configuration = hiCloudSpaceNotice.getConfiguration();
        if (configuration == null) {
            NotifyLogger.m29914e(TAG, "getSpaceNotifyActivityById, configuration is null");
            return null;
        }
        List<NotificationWithActivity> notificationWithActivity = configuration.getNotificationWithActivity();
        if (notificationWithActivity == null || notificationWithActivity.isEmpty()) {
            NotifyLogger.m29914e(TAG, "getSpaceNotifyActivityById, notifications is null");
            return null;
        }
        for (NotificationWithActivity notificationWithActivity2 : notificationWithActivity) {
            if (i10 == notificationWithActivity2.getId()) {
                return notificationWithActivity2;
            }
        }
        NotifyLogger.m29914e(TAG, "getSpaceNotifyActivityById, no fit notification");
        return null;
    }

    public SpaceNotification getSpaceNotifyById(int i10) {
        NotificationConfig configFromFile = getConfigFromFile();
        if (configFromFile == null) {
            NotifyLogger.m29914e(TAG, "getSpaceNotifyById, fullConfig is null");
            return null;
        }
        SpaceNotifyConfig hiCloudSpaceNotice = configFromFile.getHiCloudSpaceNotice();
        if (hiCloudSpaceNotice == null) {
            NotifyLogger.m29914e(TAG, "getSpaceNotifyById, spaceNotifyConfig is null");
            return null;
        }
        HiCloudSpaceNoticeConfiguration configuration = hiCloudSpaceNotice.getConfiguration();
        if (configuration == null) {
            NotifyLogger.m29914e(TAG, "getSpaceNotifyById, configuration is null");
            return null;
        }
        List<SpaceNotification> notification = configuration.getNotification();
        if (notification == null || notification.isEmpty()) {
            NotifyLogger.m29914e(TAG, "getSpaceNotifyById, notifications is null");
            return null;
        }
        for (SpaceNotification spaceNotification : notification) {
            if (i10 == spaceNotification.getId()) {
                return spaceNotification;
            }
        }
        NotifyLogger.m29914e(TAG, "getSpaceNotifyById, no fit notification");
        return null;
    }

    public void processRiskCfg() {
        HiCloudAllOMConfigManager.getInstance().processRiskCfg();
    }

    public boolean queryConfigVersion() {
        return this.mCloudConfig.requestConfigVersion();
    }

    public void recordFullFrequency() throws SQLException {
        new SNTimeOperator().replace(HNUtil.getNowTime());
    }

    public void recordRuleFrequency(String str, String str2) throws SQLException {
        new NDCOperator().updateCount(str, str2);
    }
}
