package com.huawei.hicloud.notification.manager;

import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.bean.PortraitAndGrade;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.bean.ExtraNoticeConfiguration;
import com.huawei.hicloud.notification.p106db.bean.ExtraNotificationBean;
import com.huawei.hicloud.notification.p106db.bean.ExtraNotifyConfig;
import com.huawei.hicloud.notification.p106db.bean.NoticeContent;
import com.huawei.hicloud.notification.p106db.languageoperator.ExtraNoticeLanguageOperator;
import com.huawei.hicloud.notification.util.NotifyUtil;
import gp.C10028c;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p616rk.AbstractRunnableC12516b;
import p709vj.C13452e;

/* loaded from: classes6.dex */
public class ExtraNoticeConfigManager extends NoticeCfgLanguageBaseManager {
    private static final ExtraNoticeConfigManager INSTANCE = new ExtraNoticeConfigManager();
    private static final String TAG = "ExtraNoticeConfigManager";

    private ExtraNotifyConfig getExtraNoticeConfig() {
        NotificationConfig config = new HNCloudConfig().getConfig();
        if (config != null) {
            return config.getHiCloudSpaceNoticeV2();
        }
        NotifyLogger.m29914e(TAG, "notice config is null");
        return null;
    }

    public static ExtraNoticeConfigManager getInstance() {
        return INSTANCE;
    }

    private List<ExtraNotificationBean> getNotificationBeanByUserTag(String str, List<ExtraNotificationBean> list, List<PortraitAndGrade.UserTag> list2) {
        ArrayList arrayList = new ArrayList();
        for (ExtraNotificationBean extraNotificationBean : list) {
            if (extraNotificationBean != null) {
                String noticeType = extraNotificationBean.getNoticeType();
                if (!TextUtils.isEmpty(noticeType) && noticeType.equals(str) && CloudSpaceNotifyUtil.checkUserTag(list2, extraNotificationBean)) {
                    arrayList.add(extraNotificationBean);
                }
            }
        }
        return arrayList;
    }

    public void checkLanguageDataBase(ExtraNotifyConfig extraNotifyConfig) throws Throwable {
        if (extraNotifyConfig == null) {
            NotifyLogger.m29914e(TAG, "No ExtraNotifyConfig");
            return;
        }
        if (extraNotifyConfig.getConfiguration() == null) {
            NotifyLogger.m29914e(TAG, "No ExtraNoticeConfiguration");
            return;
        }
        String languageFilePath = getLanguageFilePath();
        if (!new File(languageFilePath).exists() || databaseHasRecord()) {
            return;
        }
        NotifyLogger.m29915i(TAG, "checkLanguageDataBase, need parseLanguageXml");
        parseLanguageFile(languageFilePath);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearCurrentLanguageDownloadResult() {
        C10028c.m62182c0().m62353l(HNConstants.C4907SP.EXTRA_NOTIFICATION_LANGUAGE_DOWNLOAD_RESULT);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearLangVersionAndResult() {
        NotifyLogger.m29915i(TAG, "clear notice language");
        C10028c.m62182c0().m62353l(HNConstants.C4907SP.EXTRA_NOTIFICATION_LANGUAGE_VERSION);
        C10028c.m62182c0().m62353l(HNConstants.C4907SP.EXTRA_NOTIFICATION_LANGUAGE_DOWNLOAD_RESULT);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearLanguageDb() throws SQLException {
        new ExtraNoticeLanguageOperator().clear();
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public boolean databaseHasRecord() {
        try {
            return new ExtraNoticeLanguageOperator().hasRecord();
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "databaseHasRecord exceptions:" + e10.toString());
            return false;
        }
    }

    public void extractLanguage(ExtraNotifyConfig extraNotifyConfig) {
        NotifyLogger.m29915i(TAG, "begin extractLanguage");
        if (extraNotifyConfig == null) {
            NotifyLogger.m29914e(TAG, "extractLanguage notifyConfig is null");
            return;
        }
        ExtraNoticeConfiguration configuration = extraNotifyConfig.getConfiguration();
        if (configuration == null) {
            NotifyLogger.m29914e(TAG, "extractLanguage configuration is null");
        } else {
            extractCommonLanguage(configuration.getCommonLanguage());
        }
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public String getCurrentLanguageHash() {
        return C10028c.m62182c0().m62184A(HNConstants.C4907SP.EXTRA_NOTIFICATION_LANGUAGE_HASH);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public int getCurrentLanguageVersion() {
        return C10028c.m62182c0().m62189B(HNConstants.C4907SP.EXTRA_NOTIFICATION_LANGUAGE_VERSION);
    }

    public String getExtraNoticeLanguage(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return NotifyUtil.getStringFromConfig(str, true, new ExtraNoticeLanguageOperator().queryString(HNUtil.getCurrentLanguage(), HNUtil.getCurrentBaseLanguage(), HNConstants.Language.EN_STANDARD, str));
    }

    public List<ExtraNotificationBean> getExtraNotificationBean(String str, List<PortraitAndGrade.UserTag> list) {
        if (list == null) {
            NotifyLogger.m29914e(TAG, "UserTagList is null");
            return null;
        }
        ExtraNotifyConfig extraNoticeConfig = getExtraNoticeConfig();
        if (extraNoticeConfig == null) {
            NotifyLogger.m29914e(TAG, "extraNotifyConfig is null");
            return null;
        }
        ExtraNoticeConfiguration configuration = extraNoticeConfig.getConfiguration();
        if (configuration == null) {
            NotifyLogger.m29914e(TAG, "noticeConfiguration is null");
            return null;
        }
        List<ExtraNotificationBean> notification = configuration.getNotification();
        if (notification == null || notification.size() <= 0) {
            NotifyLogger.m29914e(TAG, "notificationBeans is null");
            return null;
        }
        Collections.sort(notification, new CloudSpaceNotifyUtil.ExtraNotificationBeanComparator());
        return getNotificationBeanByUserTag(str, notification, list);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public boolean getExtractResult() {
        return C10028c.m62182c0().m62324f0(HNConstants.C4907SP.EXTRA_NOTIFICATION_LANGUAGE_DOWNLOAD_RESULT);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public String getLanguageFilePath() {
        return C0213f.m1377a().getFilesDir() + File.separator + HNConstants.CloudConfig.LOCAL_EXTRA_NOTIFY_LANGUAGE_XML_NAME;
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public AbstractRunnableC12516b.a getLanguageTaskEnum() {
        return AbstractRunnableC12516b.a.SYNC_CONFIG;
    }

    public String getNoticeExtraMainText(ExtraNotificationBean extraNotificationBean) {
        if (extraNotificationBean == null) {
            NotifyLogger.m29914e(TAG, "getNoticeExtraMainText, extraNotificationBean is null");
            return "";
        }
        NoticeContent noticeContent2 = extraNotificationBean.getNoticeContent2();
        if (noticeContent2 == null) {
            NotifyLogger.m29914e(TAG, "getNoticeExtraMainText, content is null");
            return "";
        }
        String mainText = noticeContent2.getMainText();
        if (!TextUtils.isEmpty(mainText)) {
            return getInstance().getExtraNoticeLanguage(mainText);
        }
        NotifyLogger.m29914e(TAG, "getNoticeExtraMainText, mainTextId is null");
        return "";
    }

    public String getNoticeExtraTitleText(ExtraNotificationBean extraNotificationBean) {
        if (extraNotificationBean == null) {
            NotifyLogger.m29914e(TAG, "getNoticeExtraTitleText, extraNotificationBean is null");
            return "";
        }
        NoticeContent noticeContent2 = extraNotificationBean.getNoticeContent2();
        if (noticeContent2 == null) {
            NotifyLogger.m29914e(TAG, "getNoticeExtraTitleText, content is null");
            return "";
        }
        String title = noticeContent2.getTitle();
        if (!TextUtils.isEmpty(title)) {
            return getInstance().getExtraNoticeLanguage(title);
        }
        NotifyLogger.m29914e(TAG, "getNoticeExtraTitleText, titleId is null");
        return "";
    }

    public String getNoticeMainText(ExtraNotificationBean extraNotificationBean) {
        if (extraNotificationBean == null) {
            NotifyLogger.m29914e(TAG, "getNoticeMainText, extraNotificationBean is null");
            return "";
        }
        NoticeContent noticeContent = extraNotificationBean.getNoticeContent();
        if (noticeContent == null) {
            NotifyLogger.m29914e(TAG, "getNoticeMainText, content is null");
            return "";
        }
        String mainText = noticeContent.getMainText();
        if (!TextUtils.isEmpty(mainText)) {
            return getInstance().getExtraNoticeLanguage(mainText);
        }
        NotifyLogger.m29914e(TAG, "getNoticeMainText, mainTextId is null");
        return "";
    }

    public String getNoticeTitleText(ExtraNotificationBean extraNotificationBean) {
        if (extraNotificationBean == null) {
            NotifyLogger.m29914e(TAG, "getNoticeTitleText, extraNotificationBean is null");
            return "";
        }
        NoticeContent noticeContent = extraNotificationBean.getNoticeContent();
        if (noticeContent == null) {
            NotifyLogger.m29914e(TAG, "getNoticeTitleText, content is null");
            return "";
        }
        String title = noticeContent.getTitle();
        if (!TextUtils.isEmpty(title)) {
            return getInstance().getExtraNoticeLanguage(title);
        }
        NotifyLogger.m29914e(TAG, "getNoticeTitleText, titleId is null");
        return "";
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public C11060c getStat() {
        if (this.stat == null) {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07026"), "07026", C13452e.m80781L().m80971t0());
            this.stat = c11060cM66626a;
            c11060cM66626a.m66665u("0");
        }
        return this.stat;
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void insertLanguageToDB(ArrayList<CommonLanguageDbString> arrayList) {
        try {
            new ExtraNoticeLanguageOperator().batchInsert(arrayList);
        } catch (Exception e10) {
            String str = "insertDataToDB exceptions:" + e10.toString();
            NotifyLogger.m29914e(TAG, str);
            reportDownloadInfo("1", str, -1);
        }
    }

    public boolean isNoticeResourceComplete(ExtraNotificationBean extraNotificationBean) {
        String noticeTitleText = getNoticeTitleText(extraNotificationBean);
        String noticeMainText = getNoticeMainText(extraNotificationBean);
        if (!TextUtils.isEmpty(noticeTitleText) && !TextUtils.isEmpty(noticeMainText)) {
            return true;
        }
        NotifyLogger.m29914e(TAG, "isNoticeResourceComplete, resource not complete");
        return false;
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setCurrentLanguageHash(String str) {
        C10028c.m62182c0().m62381q2(HNConstants.C4907SP.EXTRA_NOTIFICATION_LANGUAGE_HASH, str);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setCurrentLanguageVersion(int i10) {
        C10028c.m62182c0().m62386r2(HNConstants.C4907SP.EXTRA_NOTIFICATION_LANGUAGE_VERSION, i10);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setExtractResult(boolean z10) {
        C10028c.m62182c0().m62281U2(HNConstants.C4907SP.EXTRA_NOTIFICATION_LANGUAGE_DOWNLOAD_RESULT, z10);
    }
}
