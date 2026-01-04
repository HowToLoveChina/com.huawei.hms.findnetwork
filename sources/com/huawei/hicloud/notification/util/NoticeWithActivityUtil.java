package com.huawei.hicloud.notification.util;

import android.database.SQLException;
import android.text.TextUtils;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.HicloudH5ConfigManager;
import com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager;
import com.huawei.hicloud.notification.p106db.bean.BaseSpaceNotifyBean;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.bean.HiCloudSpaceNoticeConfiguration;
import com.huawei.hicloud.notification.p106db.bean.NoticeActivityPopUp;
import com.huawei.hicloud.notification.p106db.bean.NoticeContent;
import com.huawei.hicloud.notification.p106db.bean.NoticeContentRoot;
import com.huawei.hicloud.notification.p106db.bean.NoticeDetail;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotifyConfig;
import com.huawei.hicloud.notification.p106db.operator.NoticeContentLanguageOperator;
import com.huawei.openalliance.p169ad.constant.Constants;
import gp.C10028c;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p015ak.C0213f;
import p015ak.C0234s;
import p292fn.C9733f;
import p429kk.C11058a;
import p429kk.C11060c;
import p616rk.AbstractRunnableC12516b;
import p709vj.C13452e;

/* loaded from: classes6.dex */
public class NoticeWithActivityUtil extends NoticeCfgLanguageBaseManager {
    private static final NoticeWithActivityUtil INSTANCE = new NoticeWithActivityUtil();
    private static final String TAG = "NoticeWithActivityUtil";
    private C11060c stat;

    public static class NotificationWithActivityComparator implements Comparator<NotificationWithActivity>, Serializable {
        private static final long serialVersionUID = 8811130895337798436L;

        private NotificationWithActivityComparator() {
        }

        public /* synthetic */ NotificationWithActivityComparator(C49681 c49681) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(NotificationWithActivity notificationWithActivity, NotificationWithActivity notificationWithActivity2) {
            return notificationWithActivity.getPriority() - notificationWithActivity2.getPriority();
        }
    }

    public static String addLanguageType(String str) {
        if (str.contains(Constants.QUESTION_STR)) {
            return str + "&lang=" + C0234s.m1632j();
        }
        return str + "?lang=" + C0234s.m1632j();
    }

    public static List<Integer> checkRecommendActivityType() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(2);
        arrayList.add(3);
        return arrayList;
    }

    public static List<Integer> checkRecommendActivityTypeForPushGuide() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(4);
        return arrayList;
    }

    public static Map<String, List<NotificationWithActivity>> classifyNotiListByNotiType(List<NotificationWithActivity> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list == null || list.size() <= 0) {
            NotifyLogger.m29915i(TAG, "classifyNotiListByNotiType classifiedNotiList is null");
            return linkedHashMap;
        }
        for (NotificationWithActivity notificationWithActivity : list) {
            String noticeType = notificationWithActivity.getNoticeType();
            if (!NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT.equals(noticeType)) {
                if (linkedHashMap.get(noticeType) == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(notificationWithActivity);
                    linkedHashMap.put(noticeType, arrayList);
                } else {
                    ((List) linkedHashMap.get(noticeType)).add(notificationWithActivity);
                }
            }
        }
        NotifyLogger.m29915i(TAG, "classifyNotiListByNotiType list size = " + linkedHashMap.size());
        return linkedHashMap;
    }

    public static NoticeWithActivityUtil getInstance() {
        return INSTANCE;
    }

    public static String getPopUri(String str, String str2) {
        return Arrays.asList(NotifyConstants.POP_URI_ARRAY).contains(str) ? str : str2;
    }

    public static String getStrFromDBByResource(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            return HicloudH5ConfigManager.getInstance().getNoticeTextFromConfig(str, str2);
        }
        NotifyLogger.m29914e(TAG, "getStrFromDBByResource resourceId is null or empty.");
        return "";
    }

    public static NotificationWithActivity isContainCtypeNotiConfig(List<NotificationWithActivity> list, int i10) {
        if (list == null || list.size() <= 0) {
            NotifyLogger.m29915i(TAG, "isContainActivity activityList is null");
            return null;
        }
        for (NotificationWithActivity notificationWithActivity : list) {
            if (notificationWithActivity.getActivityType() == i10) {
                return notificationWithActivity;
            }
        }
        return null;
    }

    public static List<NotificationWithActivity> isContainCtypeNotiConfigList(List<NotificationWithActivity> list, int i10) {
        if (list == null || list.size() <= 0) {
            NotifyLogger.m29915i(TAG, "isContainActivity activityList is null");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NotificationWithActivity notificationWithActivity : list) {
            if (notificationWithActivity.getActivityType() == i10) {
                arrayList.add(notificationWithActivity);
            }
        }
        NotifyLogger.m29915i(TAG, "isContainCtypeNotiConfigList size = " + arrayList.size());
        return arrayList;
    }

    public static boolean isNewDeviceGiftMainPopOn() {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        return hiCloudSysParamMapM60757p != null && hiCloudSysParamMapM60757p.getNewDeviceGiftMainPop() == 1;
    }

    public static NoticeDetail queryBackupDetailNoticeContent(BaseSpaceNotifyBean baseSpaceNotifyBean, boolean z10, String str) {
        NoticeDetail noticeDetail = new NoticeDetail();
        if (baseSpaceNotifyBean == null) {
            NotifyLogger.m29914e(TAG, "queryNoticeContentByRemindMode notificaition is null");
            return noticeDetail;
        }
        NoticeContentRoot noticeContent = !z10 ? baseSpaceNotifyBean.getNoticeContent() : baseSpaceNotifyBean.getNoticeContentDefault();
        if (noticeContent != null) {
            return NotifyConstants.DETAIL2.equals(str) ? noticeContent.getNoticeDetail2() : noticeContent.getNoticeDetail();
        }
        NotifyLogger.m29914e(TAG, "contentRoot is null");
        return noticeDetail;
    }

    public static NoticeContent queryBackupNotifiCouponContent(NotificationWithActivity notificationWithActivity, boolean z10) {
        NoticeContent noticeContent = new NoticeContent();
        if (notificationWithActivity == null) {
            NotifyLogger.m29914e(TAG, "queryNoticeContentByRemindMode notificaition is null");
            return noticeContent;
        }
        NoticeContentRoot noticeContent2 = !z10 ? notificationWithActivity.getNoticeContent() : notificationWithActivity.getNoticeContentDefault();
        if (noticeContent2 != null) {
            return noticeContent2.getNoticeCoupon();
        }
        NotifyLogger.m29914e(TAG, "contentRoot is null");
        return noticeContent;
    }

    public static NoticeContent queryBackupNotificationContent(NotificationWithActivity notificationWithActivity, boolean z10) {
        NoticeContent noticeContent = new NoticeContent();
        if (notificationWithActivity == null) {
            NotifyLogger.m29914e(TAG, "queryNoticeContentByRemindMode notificaition is null");
            return noticeContent;
        }
        NoticeContentRoot noticeContent2 = !z10 ? notificationWithActivity.getNoticeContent() : notificationWithActivity.getNoticeContentDefault();
        if (noticeContent2 != null) {
            return noticeContent2.getNoticeNotification();
        }
        NotifyLogger.m29914e(TAG, "contentRoot is null");
        return noticeContent;
    }

    public static NoticeActivityPopUp queryNoticeActivityPopup(NotificationWithActivity notificationWithActivity) {
        NoticeActivityPopUp noticeActivityPopUp = new NoticeActivityPopUp();
        if (notificationWithActivity == null) {
            NotifyLogger.m29914e(TAG, "queryNoticeActivityPopup notificaition is null");
            return noticeActivityPopUp;
        }
        NoticeContentRoot noticeContent = notificationWithActivity.getNoticeContent();
        if (noticeContent == null) {
            NotifyLogger.m29914e(TAG, "queryNoticeActivityPopup contentRoot is null");
            return noticeActivityPopUp;
        }
        NoticeActivityPopUp noticeActivityPopup = noticeContent.getNoticeActivityPopup();
        if (noticeActivityPopup != null) {
            return noticeActivityPopup;
        }
        NotifyLogger.m29914e(TAG, "queryNoticeActivityPopup detailList is null");
        return noticeActivityPopUp;
    }

    public static NoticeContent queryNoticeContentForSpaceNotify(NotificationWithActivity notificationWithActivity) {
        NoticeContent noticeContent = new NoticeContent();
        if (notificationWithActivity == null) {
            NotifyLogger.m29914e(TAG, "queryNoticeContentForSpaceNotify notificaition is null");
            return noticeContent;
        }
        NoticeContentRoot noticeContent2 = notificationWithActivity.getNoticeContent();
        if (noticeContent2 != null) {
            return noticeContent2.getNoticeContent();
        }
        NotifyLogger.m29914e(TAG, "contentRoot is null");
        return noticeContent;
    }

    public static NoticeDetail queryNoticeDetailForSpaceNotify(NotificationWithActivity notificationWithActivity) {
        NoticeDetail noticeDetail = new NoticeDetail();
        if (notificationWithActivity == null) {
            NotifyLogger.m29914e(TAG, "queryNoticeDetailForSpaceNotify notificaition is null");
            return noticeDetail;
        }
        NoticeContentRoot noticeContent = notificationWithActivity.getNoticeContent();
        if (noticeContent != null) {
            return noticeContent.getNoticeDetail();
        }
        NotifyLogger.m29914e(TAG, "contentRoot is null");
        return noticeDetail;
    }

    public static NoticeContent queryPopupNotificationContent(NotificationWithActivity notificationWithActivity, boolean z10) {
        NoticeContent noticeContent = new NoticeContent();
        if (notificationWithActivity == null) {
            NotifyLogger.m29914e(TAG, "queryNoticeContentByRemindMode notificaition is null");
            return noticeContent;
        }
        NoticeContentRoot noticeContent2 = !z10 ? notificationWithActivity.getNoticeContent() : notificationWithActivity.getNoticeContentDefault();
        if (noticeContent2 != null) {
            return noticeContent2.getNoticePopup();
        }
        NotifyLogger.m29914e(TAG, "contentRoot is null");
        return noticeContent;
    }

    public static void sortNotifyConfigWithActivity(List<NotificationWithActivity> list) {
        if (list == null) {
            return;
        }
        Collections.sort(list, new NotificationWithActivityComparator());
    }

    public void checkLanguageDataBase(SpaceNotifyConfig spaceNotifyConfig) throws Throwable {
        if (spaceNotifyConfig == null) {
            NotifyLogger.m29914e(TAG, "No spaceNotifyConfig");
            return;
        }
        if (spaceNotifyConfig.getConfiguration() == null) {
            NotifyLogger.m29914e(TAG, "No HiCloudSpaceNoticeConfiguration");
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
        C10028c.m62182c0().m62353l(HNConstants.C4907SP.NOTIFICATION_LANGUAGE_DOWNLOAD_RESULT);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearLangVersionAndResult() {
        NotifyLogger.m29915i(TAG, "clear notice language");
        C10028c.m62182c0().m62353l(HNConstants.C4907SP.NOTIFICATION_LANGUAGE_VERSION);
        C10028c.m62182c0().m62353l(HNConstants.C4907SP.NOTIFICATION_LANGUAGE_DOWNLOAD_RESULT);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void clearLanguageDb() throws SQLException {
        new NoticeContentLanguageOperator().clear();
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public boolean databaseHasRecord() {
        try {
            return new NoticeContentLanguageOperator().hasRecord();
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "databaseHasRecord exceptions:" + e10.toString());
            return false;
        }
    }

    public void extractLanguage(SpaceNotifyConfig spaceNotifyConfig) {
        NotifyLogger.m29915i(TAG, "begin extractLanguage");
        HiCloudSpaceNoticeConfiguration configuration = spaceNotifyConfig.getConfiguration();
        if (configuration == null) {
            NotifyLogger.m29914e(TAG, "No configuration");
        } else {
            extractCommonLanguage(configuration.getCommonLanguage());
        }
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public String getCurrentLanguageHash() {
        return C10028c.m62182c0().m62184A(HNConstants.C4907SP.NOTIFICATION_LANGUAGE_HASH);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public int getCurrentLanguageVersion() {
        return C10028c.m62182c0().m62189B(HNConstants.C4907SP.NOTIFICATION_LANGUAGE_VERSION);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public boolean getExtractResult() {
        return C10028c.m62182c0().m62324f0(HNConstants.C4907SP.NOTIFICATION_LANGUAGE_DOWNLOAD_RESULT);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public String getLanguageFilePath() {
        return C0213f.m1377a().getFilesDir() + File.separator + HNConstants.CloudConfig.LOCAL_NOTIFY_LANGUAGE_XML_NAME;
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public AbstractRunnableC12516b.a getLanguageTaskEnum() {
        return AbstractRunnableC12516b.a.HICLOUD_NOTIFICATION_WITH_ACTIVITY;
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public C11060c getStat() {
        if (this.stat == null) {
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07024"), "07024", C13452e.m80781L().m80971t0());
            this.stat = c11060cM66626a;
            c11060cM66626a.m66665u("0");
        }
        return this.stat;
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void insertLanguageToDB(ArrayList<CommonLanguageDbString> arrayList) {
        try {
            new NoticeContentLanguageOperator().batchInsert(arrayList);
        } catch (Exception e10) {
            String str = "insertDataToDB exceptions:" + e10.toString();
            NotifyLogger.m29914e(TAG, str);
            reportDownloadInfo("1", str, -1);
        }
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setCurrentLanguageHash(String str) {
        C10028c.m62182c0().m62381q2(HNConstants.C4907SP.NOTIFICATION_LANGUAGE_HASH, str);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setCurrentLanguageVersion(int i10) {
        C10028c.m62182c0().m62386r2(HNConstants.C4907SP.NOTIFICATION_LANGUAGE_VERSION, i10);
    }

    @Override // com.huawei.hicloud.notification.manager.NoticeCfgLanguageBaseManager
    public void setExtractResult(boolean z10) {
        C10028c.m62182c0().m62281U2(HNConstants.C4907SP.NOTIFICATION_LANGUAGE_DOWNLOAD_RESULT, z10);
    }
}
