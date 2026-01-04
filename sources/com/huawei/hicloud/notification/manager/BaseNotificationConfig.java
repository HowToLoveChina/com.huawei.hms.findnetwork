package com.huawei.hicloud.notification.manager;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hicloud.notification.config.CBPushConfigObject;
import com.huawei.hicloud.notification.config.CBPushContent;
import com.huawei.hicloud.notification.config.CBPushNotificationObject;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.HiCloudRiskRule;
import com.huawei.hicloud.notification.p106db.bean.NoticeContent;
import com.huawei.hicloud.notification.p106db.bean.RestoreNotifyConfig;
import com.huawei.hicloud.notification.p106db.bean.RiskControlContent;
import com.huawei.hicloud.notification.p106db.bean.RiskNoticeContent;
import com.huawei.hicloud.notification.p106db.operator.CommonNotifyContentOperator;
import com.huawei.hicloud.notification.p106db.operator.RestoreNotifyOperator;
import com.huawei.hicloud.notification.p106db.operator.RestoreNotifydDevicesOperator;
import com.huawei.hicloud.notification.p106db.operator.SpaceNotifyContentOperator;
import com.huawei.hicloud.notification.p106db.operator.SpaceNotifyDetailOperator;
import com.huawei.hicloud.notification.util.ForcedUpgradeUtil;
import com.huawei.hicloud.notification.util.PowerKitApplyUtil;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;

/* loaded from: classes6.dex */
public abstract class BaseNotificationConfig {
    private static final String TAG = "BaseNotificationConfig";
    protected NotificationConfig config = null;

    private String[] getDefaultNoticeContentArgs(int i10, int i11, String str, String str2, NoticeContent noticeContent) {
        String[] noticeContentArgs = getNoticeContentArgs(i10, i11, str, str2, noticeContent);
        noticeContentArgs[12] = "0";
        return noticeContentArgs;
    }

    private String[] getNoticeContentArgs(int i10, int i11, String str, String str2, NoticeContent noticeContent) {
        String[] strArr = new String[13];
        strArr[0] = String.valueOf(i10);
        strArr[1] = String.valueOf(i11);
        if (str == null) {
            str = "";
        }
        strArr[2] = str;
        String title = noticeContent.getTitle();
        if (title == null) {
            title = "";
        }
        strArr[3] = title;
        String mainText = noticeContent.getMainText();
        if (mainText == null) {
            mainText = "";
        }
        strArr[4] = mainText;
        String subTitle = noticeContent.getSubTitle();
        if (subTitle == null) {
            subTitle = "";
        }
        strArr[5] = subTitle;
        strArr[6] = str2;
        String buttonFirst = noticeContent.getButtonFirst();
        if (buttonFirst == null) {
            buttonFirst = "";
        }
        strArr[7] = buttonFirst;
        String buttonSecond = noticeContent.getButtonSecond();
        if (buttonSecond == null) {
            buttonSecond = "";
        }
        strArr[8] = buttonSecond;
        String description = noticeContent.getDescription();
        if (description == null) {
            description = "";
        }
        strArr[9] = description;
        String descriptionSecond = noticeContent.getDescriptionSecond();
        if (descriptionSecond == null) {
            descriptionSecond = "";
        }
        strArr[10] = descriptionSecond;
        String mainTextSecond = noticeContent.getMainTextSecond();
        strArr[11] = mainTextSecond != null ? mainTextSecond : "";
        strArr[12] = noticeContent.getDetailLinkStr();
        return strArr;
    }

    private String[] getRiskNoticeContentArgs(RiskNoticeContent riskNoticeContent, int i10) {
        String[] strArr = new String[10];
        strArr[0] = String.valueOf(i10);
        strArr[1] = String.valueOf(118);
        strArr[2] = riskNoticeContent.getLanguage();
        String title = riskNoticeContent.getTitle();
        if (title == null) {
            title = "";
        }
        strArr[3] = title;
        String content = riskNoticeContent.getContent();
        if (content == null) {
            content = "";
        }
        strArr[4] = content;
        String subTitle = riskNoticeContent.getSubTitle();
        if (subTitle == null) {
            subTitle = "";
        }
        strArr[5] = subTitle;
        strArr[6] = "";
        String firstBtn = riskNoticeContent.getFirstBtn();
        if (firstBtn == null) {
            firstBtn = "";
        }
        strArr[7] = firstBtn;
        String secondBtn = riskNoticeContent.getSecondBtn();
        if (secondBtn == null) {
            secondBtn = "";
        }
        strArr[8] = secondBtn;
        strArr[9] = "";
        return strArr;
    }

    public void doWriteDefaultNoticeContentToDb(int i10, List<NoticeContent> list, int i11) {
        if (list == null || list.size() <= 0) {
            NotifyLogger.m29914e(TAG, "noticeContents empty");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (NoticeContent noticeContent : list) {
            String language = noticeContent.getLanguage();
            if (TextUtils.isEmpty(language)) {
                NotifyLogger.m29914e(TAG, "language isEmpty, id=" + i11);
            } else {
                String remindMode = noticeContent.getRemindMode();
                if (TextUtils.isEmpty(remindMode)) {
                    remindMode = "notification";
                }
                String str = remindMode;
                if (language.equals(HNConstants.Language.f22635CN)) {
                    language = HNConstants.Language.CN_STANDARD;
                } else if (language.equals(HNConstants.Language.f22636EN)) {
                    language = HNConstants.Language.EN_STANDARD;
                }
                arrayList.add(getDefaultNoticeContentArgs(i10, i11, language, str, noticeContent));
            }
        }
        new CommonNotifyContentOperator().insertContent(arrayList);
    }

    public void extractConfig() {
        NotificationConfig configFromFile = getConfigFromFile();
        if (configFromFile == null) {
            NotifyLogger.m29914e(TAG, "extractConfig failed, fullConfig is null");
            return;
        }
        SyncModuleConfigManager.getInstance().parseSyncConfig(configFromFile.getSyncConfig());
        ForcedUpgradeUtil.getInstance().parseUpgradeConfig(configFromFile.getHiCloudUpgradeNotice());
        PowerKitApplyUtil.getInstance().parseApplyConfig(configFromFile.getSystemParameter());
        SpaceNotifyContentOperator spaceNotifyContentOperator = new SpaceNotifyContentOperator();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ExtraNoticeConfigManager.getInstance().extractLanguage(configFromFile.getHiCloudSpaceNoticeV2());
        CBPushNotificationObject hiCloudPullNewNotice = configFromFile.getHiCloudPullNewNotice();
        if (hiCloudPullNewNotice != null) {
            for (CBPushConfigObject cBPushConfigObject : hiCloudPullNewNotice.getNotification()) {
                writePullNewNoticeContentToDb(cBPushConfigObject.getNoticeContent(), cBPushConfigObject.getId(), arrayList);
                cBPushConfigObject.setNoticeContent(null);
            }
            handleRestoreNotifyConfig(hiCloudPullNewNotice);
        } else {
            NotifyLogger.m29914e(TAG, "no pullnew config to extract");
        }
        parseRiskCfg(configFromFile.getHiCloudRiskRule(), arrayList);
        spaceNotifyContentOperator.insertContent(arrayList);
        new SpaceNotifyDetailOperator().insertDetail(arrayList2);
        mkExtConfigFile(new Gson().toJson(configFromFile));
    }

    public abstract NotificationConfig getConfig();

    public abstract NotificationConfig getConfigFromFile();

    public NotificationConfig getConfigRaw(String str) {
        Exception e10;
        NotificationConfig notificationConfig;
        FileInputStream fileInputStream;
        NotifyLogger.m29915i(TAG, "getConfigRaw");
        try {
            fileInputStream = new FileInputStream(new File(C0213f.m1377a().getFilesDir() + str));
        } catch (Exception e11) {
            e10 = e11;
            notificationConfig = null;
        }
        try {
            notificationConfig = (NotificationConfig) new Gson().fromJson(readConfigStr(fileInputStream), NotificationConfig.class);
            try {
                fileInputStream.close();
            } catch (Exception e12) {
                e10 = e12;
                NotifyLogger.m29914e(TAG, "cloud config file not exitst, msg:" + e10.getMessage());
                return notificationConfig;
            }
            return notificationConfig;
        } finally {
        }
    }

    public abstract String getExtFilePath();

    public void handleRestoreNotifyConfig(CBPushNotificationObject cBPushNotificationObject) {
        NotifyLogger.m29915i(TAG, "handleRestoreNotifyConfig");
        List<RestoreNotifyConfig> restoreNotifyConfig = cBPushNotificationObject.getRestoreNotifyConfig();
        if (restoreNotifyConfig == null) {
            NotifyLogger.m29914e(TAG, "restoreNotifyConfigs is null");
            return;
        }
        RestoreNotifyOperator restoreNotifyOperator = new RestoreNotifyOperator();
        RestoreNotifydDevicesOperator restoreNotifydDevicesOperator = new RestoreNotifydDevicesOperator();
        for (RestoreNotifyConfig restoreNotifyConfig2 : restoreNotifyConfig) {
            restoreNotifyConfig2.setStartTime(restoreNotifyConfig2.getvalidDuration().getStartTime());
            restoreNotifyConfig2.setEndTime(restoreNotifyConfig2.getvalidDuration().getEndTime());
            RestoreNotifyConfigManager restoreNotifyConfigManager = new RestoreNotifyConfigManager();
            restoreNotifyConfigManager.parseRestoreNotifyConfig(restoreNotifyConfig2);
            restoreNotifyConfigManager.awaitRequestConfigTaskFinish();
            restoreNotifydDevicesOperator.batchInsert(restoreNotifyConfig2);
        }
        restoreNotifyOperator.batchInsert(restoreNotifyConfig);
    }

    public abstract boolean isExist();

    public void mkExtConfigFile(String str) throws Throwable {
        StringBuilder sb2;
        boolean zCreateNewFile;
        byte[] bytes = new byte[0];
        try {
            bytes = str.getBytes(Constants.UTF_8);
        } catch (UnsupportedEncodingException e10) {
            NotifyLogger.m29913d(TAG, "UnsupportedEncodingException:" + e10);
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(C0213f.m1377a().getFilesDir() + getExtFilePath());
                if (!file.exists() && !(zCreateNewFile = file.createNewFile())) {
                    NotifyLogger.m29914e(TAG, "createResult is " + zCreateNewFile);
                    return;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bytes);
                    fileOutputStream2.close();
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e11) {
                        e = e11;
                        sb2 = new StringBuilder();
                        sb2.append("IOException exception:");
                        sb2.append(e.toString());
                        NotifyLogger.m29914e(TAG, sb2.toString());
                    }
                } catch (Exception e12) {
                    fileOutputStream = fileOutputStream2;
                    e = e12;
                    NotifyLogger.m29914e(TAG, "mkExtConfigFile exception:" + e.toString());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e13) {
                            e = e13;
                            sb2 = new StringBuilder();
                            sb2.append("IOException exception:");
                            sb2.append(e.toString());
                            NotifyLogger.m29914e(TAG, sb2.toString());
                        }
                    }
                } catch (Throwable th2) {
                    fileOutputStream = fileOutputStream2;
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e14) {
                            NotifyLogger.m29914e(TAG, "IOException exception:" + e14.toString());
                        }
                    }
                    throw th;
                }
            } catch (Exception e15) {
                e = e15;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void parseRiskCfg(HiCloudRiskRule hiCloudRiskRule, List<String[]> list) {
        if (hiCloudRiskRule == null) {
            NotifyLogger.m29916w(TAG, "no hiCloudRiskRule config to extract");
            return;
        }
        List<RiskControlContent> riskControlContents = hiCloudRiskRule.getRiskControlContents();
        if (riskControlContents == null) {
            NotifyLogger.m29916w(TAG, "no riskControlContent config to extract");
            return;
        }
        NotifyLogger.m29915i(TAG, "get HiCloudRiskRule ok, ready to insert DB.");
        for (RiskControlContent riskControlContent : riskControlContents) {
            if (riskControlContent == null) {
                NotifyLogger.m29916w(TAG, "get RiskControlContent null");
            } else {
                list.add(getRiskNoticeContentArgs(new RiskNoticeContent(riskControlContent.getLanguage(), riskControlContent.getNotificationTitle(), "", riskControlContent.getNotificationContent(), "", ""), 3));
                list.add(getRiskNoticeContentArgs(new RiskNoticeContent(riskControlContent.getLanguage(), riskControlContent.getConfirmTitle(), riskControlContent.getConfirmDes(), riskControlContent.getConfirmContent(), "", ""), 4));
                list.add(getRiskNoticeContentArgs(new RiskNoticeContent(riskControlContent.getLanguage(), riskControlContent.getExitTitle(), "", riskControlContent.getExitContent(), "", ""), 5));
                list.add(getRiskNoticeContentArgs(new RiskNoticeContent(riskControlContent.getLanguage(), "", "", riskControlContent.getReconfirmContent(), riskControlContent.getReconfirmButtonLeft(), riskControlContent.getReconfirmButtonRight()), 6));
            }
        }
        hiCloudRiskRule.setRiskControlContents(null);
    }

    public String readConfigStr(InputStream inputStream) {
        return C0209d.m1290o2(inputStream);
    }

    public abstract boolean requestConfig();

    public abstract boolean requestConfigVersion();

    public abstract void requestNoticeConfig();

    public void writeNoticeContentToDb(int i10, List<NoticeContent> list, int i11, List<String[]> list2) {
        if (list == null || list.size() <= 0) {
            NotifyLogger.m29914e(TAG, "noticeContents empty");
            return;
        }
        for (NoticeContent noticeContent : list) {
            String language = noticeContent.getLanguage();
            if (TextUtils.isEmpty(language)) {
                NotifyLogger.m29914e(TAG, "language isEmpty, id=" + i11);
            } else {
                String remindMode = noticeContent.getRemindMode();
                if (TextUtils.isEmpty(remindMode)) {
                    remindMode = "notification";
                }
                String str = remindMode;
                if (language.equals(HNConstants.Language.f22635CN)) {
                    language = HNConstants.Language.CN_STANDARD;
                } else if (language.equals(HNConstants.Language.f22636EN)) {
                    language = HNConstants.Language.EN_STANDARD;
                }
                list2.add(getNoticeContentArgs(i10, i11, language, str, noticeContent));
            }
        }
    }

    public void writePullNewNoticeContentToDb(CBPushContent[] cBPushContentArr, int i10, List<String[]> list) {
        if (cBPushContentArr == null || cBPushContentArr.length <= 0) {
            NotifyLogger.m29914e(TAG, "noticeContents empty");
            return;
        }
        for (CBPushContent cBPushContent : cBPushContentArr) {
            String language = cBPushContent.getLanguage();
            if (TextUtils.isEmpty(language)) {
                NotifyLogger.m29914e(TAG, "language isEmpty, id=" + i10);
            } else {
                if (language.equals(HNConstants.Language.f22635CN)) {
                    language = HNConstants.Language.CN_STANDARD;
                } else if (language.equals(HNConstants.Language.f22636EN)) {
                    language = HNConstants.Language.EN_STANDARD;
                }
                String str = language;
                NoticeContent noticeContent = new NoticeContent();
                noticeContent.setTitle(cBPushContent.getTitle());
                noticeContent.setSubTitle(cBPushContent.getSubTitle());
                list.add(getNoticeContentArgs(1, i10, str, "notification", noticeContent));
            }
        }
    }
}
