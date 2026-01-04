package com.huawei.hicloud.notification.manager;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import com.google.gson.Gson;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.AblumSyncConfig;
import com.huawei.hicloud.notification.p106db.bean.ClearLocalSpace;
import com.huawei.hicloud.notification.p106db.bean.ClearOverMonths;
import com.huawei.hicloud.notification.p106db.bean.CloudBackupClears;
import com.huawei.hicloud.notification.p106db.bean.CommonCard;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguage;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.bean.CommonPicture;
import com.huawei.hicloud.notification.p106db.bean.GalleryReleaseSpace;
import com.huawei.hicloud.notification.p106db.bean.HiCloudSpaceSceneNotices;
import com.huawei.hicloud.notification.p106db.bean.SceneNotices;
import com.huawei.hicloud.notification.p106db.operator.HiCloudSceneBuyBannerOperator;
import com.huawei.hicloud.notification.p106db.operator.HiCloudSceneHomePageBannerOperator;
import com.huawei.hicloud.notification.task.QueryHiCloudBannerPicturesTask;
import com.huawei.hicloud.notification.task.QueryHiCloudSceneBuyBannerTask;
import com.huawei.hicloud.notification.task.QueryHiCloudSceneHomePageBannerTask;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import gp.C10028c;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import org.xmlpull.v1.XmlPullParser;
import p015ak.C0209d;
import p015ak.C0213f;
import p459lp.C11327e;
import p616rk.C12515a;

/* loaded from: classes6.dex */
public class HiCloudSceneBannerManager {
    private static final String TAG = "HiCloudSceneBannerManager";

    public static class Holder {
        private static HiCloudSceneBannerManager instance = new HiCloudSceneBannerManager();

        private Holder() {
        }
    }

    private void clearConfigFile(String str) {
        if (RecommendCardManager.getInstance().checkEntrance(str)) {
            Context contextM1378b = C0213f.m1378b();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(contextM1378b.getFilesDir());
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append("recommend_card_config");
            sb2.append(str2);
            String string = sb2.toString();
            if (str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
                string = string + "HiCloudSceneHomePageBanner.json";
            } else if (str.equals(RecommendCardConstants.Entrance.BUY)) {
                string = string + "HiCloudSceneBuyBanner.json";
            }
            RecommendCardManager.getInstance().clearFile(string);
        }
    }

    private void downloadSceneNoticesPicturesSplit(SceneNotices sceneNotices, String str) {
        CommonCard[] twoHundredGuids = sceneNotices.getTwoHundredGuids();
        if (twoHundredGuids != null) {
            for (CommonCard commonCard : twoHundredGuids) {
                if (commonCard == null) {
                    NotifyLogger.m29914e(TAG, "twoHundredGuid is null");
                } else {
                    CommonPicture[] picturesSecond = commonCard.getPicturesSecond();
                    if (picturesSecond != null) {
                        C12515a.m75110o().m75175e(new QueryHiCloudBannerPicturesTask(picturesSecond), false);
                    }
                    CommonPicture[] pictures = commonCard.getPictures();
                    if (pictures != null) {
                        C12515a.m75110o().m75175e(new QueryHiCloudBannerPicturesTask(pictures), false);
                    }
                }
            }
        }
        ClearOverMonths[] clearOverMonths = sceneNotices.getClearOverMonths();
        if (clearOverMonths != null) {
            for (ClearOverMonths clearOverMonths2 : clearOverMonths) {
                if (clearOverMonths2 == null) {
                    NotifyLogger.m29914e(TAG, "clearOverMonth is null");
                } else {
                    CommonPicture[] picturesSecond2 = clearOverMonths2.getPicturesSecond();
                    if (picturesSecond2 != null) {
                        C12515a.m75110o().m75175e(new QueryHiCloudBannerPicturesTask(picturesSecond2), false);
                    }
                    CommonPicture[] pictures2 = clearOverMonths2.getPictures();
                    if (pictures2 != null) {
                        C12515a.m75110o().m75175e(new QueryHiCloudBannerPicturesTask(pictures2), false);
                    }
                }
            }
        }
        CloudBackupClears[] cloudBackupClears = sceneNotices.getCloudBackupClears();
        if (cloudBackupClears != null) {
            for (CloudBackupClears cloudBackupClears2 : cloudBackupClears) {
                if (cloudBackupClears2 == null) {
                    NotifyLogger.m29914e(TAG, "clearOverMonth is null");
                } else {
                    CommonPicture[] picturesSecond3 = cloudBackupClears2.getPicturesSecond();
                    if (picturesSecond3 != null) {
                        C12515a.m75110o().m75175e(new QueryHiCloudBannerPicturesTask(picturesSecond3), false);
                    }
                    CommonPicture[] pictures3 = cloudBackupClears2.getPictures();
                    if (pictures3 != null) {
                        C12515a.m75110o().m75175e(new QueryHiCloudBannerPicturesTask(pictures3), false);
                    }
                }
            }
        }
        ClearLocalSpace[] clearLocalSpaces = sceneNotices.getClearLocalSpaces();
        if (clearLocalSpaces != null) {
            for (ClearLocalSpace clearLocalSpace : clearLocalSpaces) {
                if (clearLocalSpace == null) {
                    NotifyLogger.m29914e(TAG, "clearLocalSpace is null");
                } else {
                    CommonPicture[] picturesSecond4 = clearLocalSpace.getPicturesSecond();
                    if (picturesSecond4 != null) {
                        C12515a.m75110o().m75175e(new QueryHiCloudBannerPicturesTask(picturesSecond4), false);
                    }
                    CommonPicture[] pictures4 = clearLocalSpace.getPictures();
                    if (pictures4 != null) {
                        C12515a.m75110o().m75175e(new QueryHiCloudBannerPicturesTask(pictures4), false);
                    }
                }
            }
        }
        CommonCard[] cloudSpaceFulls = sceneNotices.getCloudSpaceFulls();
        if (cloudSpaceFulls != null) {
            Arrays.stream(cloudSpaceFulls).forEach(new Consumer() { // from class: com.huawei.hicloud.notification.manager.g
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    HiCloudSceneBannerManager.lambda$downloadSceneNoticesPicturesSplit$2((CommonCard) obj);
                }
            });
        }
    }

    public static HiCloudSceneBannerManager getInstance() {
        return Holder.instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$downloadSceneNoticesPicturesSplit$1(CommonPicture[] commonPictureArr) {
        C12515a.m75110o().m75175e(new QueryHiCloudBannerPicturesTask(commonPictureArr), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$downloadSceneNoticesPicturesSplit$2(CommonCard commonCard) {
        Optional.ofNullable(commonCard).map(new Function() { // from class: com.huawei.hicloud.notification.manager.h
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((CommonCard) obj).getPicturesSecond();
            }
        }).ifPresent(new Consumer() { // from class: com.huawei.hicloud.notification.manager.i
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                HiCloudSceneBannerManager.lambda$downloadSceneNoticesPicturesSplit$1((CommonPicture[]) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getCloudSpaceFullObjectByActivityId$3(String str, CommonCard commonCard) {
        return str.equals(commonCard.getActivityId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getTwoHundredGuidObjectByActivityId$0(String str, CommonCard commonCard) {
        return commonCard != null && StringUtil.equals(str, commonCard.getActivityId());
    }

    private void parseLanguageXMLSplit(String str, File file, CommonLanguage commonLanguage) throws Throwable {
        Throwable th2;
        FileInputStream fileInputStream;
        Exception e10;
        ArrayList<CommonLanguageDbString> arrayList = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception e11) {
                fileInputStream = null;
                e10 = e11;
            } catch (Throwable th3) {
                th2 = th3;
                RecommendCardManager.getInstance().closeIn(null);
                throw th2;
            }
            try {
                XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                xmlPullParserNewPullParser.setInput(fileInputStream, "utf-8");
                String str2 = "";
                for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType != 2) {
                        if (eventType == 3 && !"resource".equals(name) && !"text".equals(name) && arrayList != null) {
                            if (str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
                                new HiCloudSceneHomePageBannerOperator().batchInsert(arrayList);
                                arrayList.clear();
                                C10028c.m62182c0().m62386r2(RecommendCardConstants.LanguageVersion.HICLOUD_SCENE_HOMEPAGE_BANNER, commonLanguage.getVersion());
                                C10028c.m62182c0().m62381q2(RecommendCardConstants.LanguageHash.HICLOUD_SCENE_HOMEPAGE_BANNER, commonLanguage.getHash());
                            } else if (str.equals(RecommendCardConstants.Entrance.BUY)) {
                                new HiCloudSceneBuyBannerOperator().batchInsert(arrayList);
                                arrayList.clear();
                                C10028c.m62182c0().m62386r2(RecommendCardConstants.LanguageVersion.HICLOUD_SCENE_BUY_BANNER, commonLanguage.getVersion());
                                C10028c.m62182c0().m62381q2(RecommendCardConstants.LanguageHash.HICLOUD_SCENE_BUY_BANNER, commonLanguage.getHash());
                            }
                        }
                    } else if ("resource".equals(name)) {
                        arrayList = new ArrayList<>();
                    } else if ("text".equals(name)) {
                        CommonLanguageDbString commonLanguageDbString = new CommonLanguageDbString();
                        commonLanguageDbString.setName(xmlPullParserNewPullParser.getAttributeValue(xmlPullParserNewPullParser.getNamespace(), "name"));
                        commonLanguageDbString.setValue(xmlPullParserNewPullParser.getAttributeValue(xmlPullParserNewPullParser.getNamespace(), "value"));
                        commonLanguageDbString.setLanguage(str2);
                        if (arrayList != null) {
                            arrayList.add(commonLanguageDbString);
                        }
                    } else {
                        str2 = name;
                    }
                }
            } catch (Exception e12) {
                e10 = e12;
                NotifyLogger.m29914e(TAG, "parseLanguageXML exception: " + e10.toString());
                RecommendCardManager.getInstance().closeIn(fileInputStream);
            }
            RecommendCardManager.getInstance().closeIn(fileInputStream);
        } catch (Throwable th4) {
            th2 = th4;
            RecommendCardManager.getInstance().closeIn(null);
            throw th2;
        }
    }

    public void checkLanguageDataBase(String str) {
        if (str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
            if (new HiCloudSceneHomePageBannerOperator().hasRecord()) {
                NotifyLogger.m29915i(TAG, "operator has record");
                return;
            }
        } else if (str.equals(RecommendCardConstants.Entrance.BUY) && new HiCloudSceneBuyBannerOperator().hasRecord()) {
            NotifyLogger.m29915i(TAG, "operator has record");
            return;
        }
        SceneNotices sceneNotices = getSceneNotices(str);
        if (sceneNotices == null) {
            NotifyLogger.m29914e(TAG, "sceneNotices is null");
            return;
        }
        CommonLanguage language = sceneNotices.getLanguage();
        if (language == null) {
            NotifyLogger.m29914e(TAG, "language is null");
            return;
        }
        String languageXMLPath = getLanguageXMLPath(str);
        if (TextUtils.isEmpty(languageXMLPath)) {
            NotifyLogger.m29914e(TAG, "languageXMLPath is empty");
        } else if (new File(languageXMLPath).exists()) {
            NotifyLogger.m29915i(TAG, "checkLanguageDataBase, need parseLanguageXmlAndInsertDB");
            parseLanguageXML(str, languageXMLPath, language);
        }
    }

    public void clearConfigFileAndDb() {
        clearLanguageXml(RecommendCardConstants.Entrance.HOMEPAGE);
        clearLanguageXml(RecommendCardConstants.Entrance.BUY);
        clearLanguageDb(RecommendCardConstants.Entrance.HOMEPAGE);
        clearLanguageDb(RecommendCardConstants.Entrance.BUY);
        clearConfigFile(RecommendCardConstants.Entrance.HOMEPAGE);
        clearConfigFile(RecommendCardConstants.Entrance.BUY);
        C11327e.m68059b("HiCloudSceneHomePageBanner");
        C11327e.m68059b("HiCloudSceneBuyBanner");
    }

    public void clearLanguageDb(String str) {
        if (RecommendCardManager.getInstance().checkEntrance(str)) {
            if (str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
                new HiCloudSceneHomePageBannerOperator().clear();
            } else if (str.equals(RecommendCardConstants.Entrance.BUY)) {
                new HiCloudSceneBuyBannerOperator().clear();
            }
        }
    }

    public void clearLanguageXml(String str) {
        if (RecommendCardManager.getInstance().checkEntrance(str)) {
            String languageXMLPath = getLanguageXMLPath(str);
            if (TextUtils.isEmpty(languageXMLPath)) {
                NotifyLogger.m29914e(TAG, "languageXMLPath is empty");
            } else {
                RecommendCardManager.getInstance().clearFile(languageXMLPath);
            }
        }
    }

    public void downloadSceneNoticesPictures(SceneNotices sceneNotices, String str) {
        if (RecommendCardManager.getInstance().checkEntrance(str)) {
            GalleryReleaseSpace[] galleryReleaseSpaces = sceneNotices.getGalleryReleaseSpaces();
            if (galleryReleaseSpaces != null) {
                for (GalleryReleaseSpace galleryReleaseSpace : galleryReleaseSpaces) {
                    if (galleryReleaseSpace == null) {
                        NotifyLogger.m29914e(TAG, "galleryReleaseSpace is null");
                    } else {
                        AblumSyncConfig ablumSyncConfig = galleryReleaseSpace.getAblumSyncConfig();
                        if (ablumSyncConfig != null) {
                            CommonPicture[] syncPicturesSecond = ablumSyncConfig.getSyncPicturesSecond();
                            if (syncPicturesSecond != null) {
                                C12515a.m75110o().m75175e(new QueryHiCloudBannerPicturesTask(syncPicturesSecond), false);
                            }
                            CommonPicture[] unSyncPicturesSecond = ablumSyncConfig.getUnSyncPicturesSecond();
                            if (unSyncPicturesSecond != null) {
                                C12515a.m75110o().m75175e(new QueryHiCloudBannerPicturesTask(unSyncPicturesSecond), false);
                            }
                            CommonPicture[] syncPictures = ablumSyncConfig.getSyncPictures();
                            if (syncPictures != null) {
                                C12515a.m75110o().m75175e(new QueryHiCloudBannerPicturesTask(syncPictures), false);
                            }
                            CommonPicture[] unSyncPictures = ablumSyncConfig.getUnSyncPictures();
                            if (unSyncPictures != null) {
                                C12515a.m75110o().m75175e(new QueryHiCloudBannerPicturesTask(unSyncPictures), false);
                            }
                        }
                    }
                }
            }
            downloadSceneNoticesPicturesSplit(sceneNotices, str);
        }
    }

    public ClearLocalSpace getClearLocalSpaceObjectByActivityId(String str, String str2) {
        SceneNotices sceneNotices = getSceneNotices(str);
        if (sceneNotices == null) {
            NotifyLogger.m29914e(TAG, "sceneNotices is null");
            return null;
        }
        ClearLocalSpace[] clearLocalSpaces = sceneNotices.getClearLocalSpaces();
        if (clearLocalSpaces == null) {
            NotifyLogger.m29914e(TAG, "clearLocalSpaces is null");
            return null;
        }
        for (ClearLocalSpace clearLocalSpace : clearLocalSpaces) {
            if (clearLocalSpace == null) {
                NotifyLogger.m29914e(TAG, "clearLocalSpace is null");
            } else {
                String activityId = clearLocalSpace.getActivityId();
                if (!TextUtils.isEmpty(activityId) && activityId.equals(str2)) {
                    NotifyLogger.m29915i(TAG, "match activityId: " + str2);
                    return clearLocalSpace;
                }
            }
        }
        NotifyLogger.m29916w(TAG, "not match activityId: " + str2);
        return null;
    }

    public ClearOverMonths getClearOverMonthsObjectByActivityId(String str, String str2) {
        SceneNotices sceneNotices = getSceneNotices(str);
        if (sceneNotices == null) {
            NotifyLogger.m29914e(TAG, "sceneNotices is null");
            return null;
        }
        ClearOverMonths[] clearOverMonths = sceneNotices.getClearOverMonths();
        if (clearOverMonths == null) {
            NotifyLogger.m29914e(TAG, "clearOverMonths is null");
            return null;
        }
        for (ClearOverMonths clearOverMonths2 : clearOverMonths) {
            if (clearOverMonths2 == null) {
                NotifyLogger.m29914e(TAG, "clearOverMonth is null");
            } else {
                String activityId = clearOverMonths2.getActivityId();
                if (!TextUtils.isEmpty(activityId) && activityId.equals(str2)) {
                    NotifyLogger.m29915i(TAG, "match activityId: " + str2);
                    return clearOverMonths2;
                }
            }
        }
        NotifyLogger.m29916w(TAG, "not match activityId: " + str2);
        return null;
    }

    public CloudBackupClears getCloudBackupClearByActivityId(String str, String str2) {
        SceneNotices sceneNotices = getSceneNotices(str);
        if (sceneNotices == null) {
            NotifyLogger.m29914e(TAG, "sceneNotices is null");
            return null;
        }
        CloudBackupClears[] cloudBackupClears = sceneNotices.getCloudBackupClears();
        if (cloudBackupClears == null) {
            NotifyLogger.m29914e(TAG, "cloudBackupClears is null");
            return null;
        }
        for (CloudBackupClears cloudBackupClears2 : cloudBackupClears) {
            if (cloudBackupClears2 == null) {
                NotifyLogger.m29914e(TAG, "cloudBackupClear is null");
            } else {
                String activityId = cloudBackupClears2.getActivityId();
                if (!TextUtils.isEmpty(activityId) && activityId.equals(str2)) {
                    NotifyLogger.m29915i(TAG, "match activityId: " + str2);
                    return cloudBackupClears2;
                }
            }
        }
        NotifyLogger.m29916w(TAG, "not match activityId: " + str2);
        return null;
    }

    public CommonCard getCloudSpaceFullObjectByActivityId(final String str) {
        if (C4633d0.m28404a(str)) {
            NotifyLogger.m29914e(TAG, "activityId is null or empty");
            return null;
        }
        SceneNotices sceneNotices = getSceneNotices(RecommendCardConstants.Entrance.HOMEPAGE);
        if (sceneNotices == null) {
            NotifyLogger.m29914e(TAG, "sceneNotices is null");
            return null;
        }
        CommonCard[] cloudSpaceFulls = sceneNotices.getCloudSpaceFulls();
        if (cloudSpaceFulls != null && cloudSpaceFulls.length != 0) {
            return (CommonCard) Arrays.stream(cloudSpaceFulls).filter(new Predicate() { // from class: com.huawei.hicloud.notification.manager.f
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return HiCloudSceneBannerManager.lambda$getCloudSpaceFullObjectByActivityId$3(str, (CommonCard) obj);
                }
            }).findFirst().orElse(null);
        }
        NotifyLogger.m29914e(TAG, "cloudSpaceFulls is null");
        return null;
    }

    public HiCloudSpaceSceneNotices getConfigFromFile(String str) {
        if (!RecommendCardManager.getInstance().checkEntrance(str)) {
            return null;
        }
        Context contextM1378b = C0213f.m1378b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(contextM1378b.getFilesDir());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("recommend_card_config");
        sb2.append(str2);
        String string = sb2.toString();
        if (str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
            string = string + "HiCloudSceneHomePageBanner.json";
        } else if (str.equals(RecommendCardConstants.Entrance.BUY)) {
            string = string + "HiCloudSceneBuyBanner.json";
        }
        File file = new File(string);
        if (!file.exists()) {
            NotifyLogger.m29915i(TAG, "config file not existed");
            getConfigFromOM(str);
            return null;
        }
        try {
            return (HiCloudSpaceSceneNotices) new Gson().fromJson(C0209d.m1290o2(new FileInputStream(file)), HiCloudSpaceSceneNotices.class);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "getConfigFromFile exception: " + e10.toString());
            return null;
        }
    }

    public void getConfigFromOM(String str) {
        if (RecommendCardManager.getInstance().checkGetConfigParam(str)) {
            NotifyLogger.m29915i(TAG, "getConfigFromOM entrance: " + str);
            if (str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
                C12515a.m75110o().m75172d(new QueryHiCloudSceneHomePageBannerTask());
            } else if (str.equals(RecommendCardConstants.Entrance.BUY)) {
                C12515a.m75110o().m75172d(new QueryHiCloudSceneBuyBannerTask());
            }
        }
    }

    public GalleryReleaseSpace getGalleryReleaseSpaceObjectByActivityId(String str, String str2) {
        SceneNotices sceneNotices = getSceneNotices(str);
        if (sceneNotices == null) {
            NotifyLogger.m29914e(TAG, "sceneNotices is null");
            return null;
        }
        GalleryReleaseSpace[] galleryReleaseSpaces = sceneNotices.getGalleryReleaseSpaces();
        if (galleryReleaseSpaces == null) {
            NotifyLogger.m29914e(TAG, "galleryReleaseSpaces is null");
            return null;
        }
        for (GalleryReleaseSpace galleryReleaseSpace : galleryReleaseSpaces) {
            if (galleryReleaseSpace == null) {
                NotifyLogger.m29914e(TAG, "galleryReleaseSpace is null");
            } else {
                String activityId = galleryReleaseSpace.getActivityId();
                if (!TextUtils.isEmpty(activityId) && activityId.equals(str2)) {
                    NotifyLogger.m29915i(TAG, "match activityId: " + str2);
                    return galleryReleaseSpace;
                }
            }
        }
        NotifyLogger.m29916w(TAG, "not match activityId: " + str2);
        return null;
    }

    public String getLanguageXMLPath(String str) {
        if (!RecommendCardManager.getInstance().checkEntrance(str)) {
            return "";
        }
        Context contextM1378b = C0213f.m1378b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(contextM1378b.getFilesDir());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append(RecommendCardConstants.LanguageFileName.FOLDER);
        sb2.append(str2);
        String string = sb2.toString();
        if (str.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
            return string + RecommendCardConstants.LanguageFileName.HICLOUD_SCENE_HOMEPAGE_BANNER;
        }
        if (!str.equals(RecommendCardConstants.Entrance.BUY)) {
            return string;
        }
        return string + RecommendCardConstants.LanguageFileName.HICLOUD_SCENE_BUY_BANNER;
    }

    public SceneNotices getSceneNotices(String str) {
        if (!RecommendCardManager.getInstance().checkEntrance(str)) {
            return null;
        }
        HiCloudSpaceSceneNotices configFromFile = getConfigFromFile(str);
        if (configFromFile != null) {
            return configFromFile.getSceneNotices();
        }
        NotifyLogger.m29914e(TAG, "hiCloudSpaceSceneNotices is null");
        return null;
    }

    public String getStringFromDB(String str, String str2) {
        String currentBaseLanguage = HNUtil.getCurrentBaseLanguage();
        String currentLanguage = HNUtil.getCurrentLanguage();
        return NotifyUtil.getStringFromConfig(str2, true, str.equals(RecommendCardConstants.Entrance.HOMEPAGE) ? new HiCloudSceneHomePageBannerOperator().queryString(currentLanguage, currentBaseLanguage, HNConstants.Language.EN_STANDARD, str2) : str.equals(RecommendCardConstants.Entrance.BUY) ? new HiCloudSceneBuyBannerOperator().queryString(currentLanguage, currentBaseLanguage, HNConstants.Language.EN_STANDARD, str2) : null);
    }

    public CommonCard getTwoHundredGuidObjectByActivityId(String str, final String str2) {
        SceneNotices sceneNotices = getSceneNotices(str);
        if (sceneNotices == null) {
            NotifyLogger.m29914e(TAG, "sceneNotices is null");
            return null;
        }
        CommonCard[] twoHundredGuids = sceneNotices.getTwoHundredGuids();
        if (twoHundredGuids == null) {
            NotifyLogger.m29914e(TAG, "twoHundredGuids is null");
            return null;
        }
        CommonCard commonCard = (CommonCard) Arrays.stream(twoHundredGuids).filter(new Predicate() { // from class: com.huawei.hicloud.notification.manager.j
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return HiCloudSceneBannerManager.lambda$getTwoHundredGuidObjectByActivityId$0(str2, (CommonCard) obj);
            }
        }).findFirst().orElse(null);
        if (commonCard != null) {
            NotifyLogger.m29915i(TAG, "match activityId: " + str2);
            return commonCard;
        }
        NotifyLogger.m29916w(TAG, "not match activityId: " + str2);
        return null;
    }

    public void parseLanguageXML(String str, String str2, CommonLanguage commonLanguage) throws Throwable {
        NotifyLogger.m29915i(TAG, "parseLanguageXML");
        if (RecommendCardManager.getInstance().checkEntrance(str)) {
            if (commonLanguage == null) {
                NotifyLogger.m29914e(TAG, "commonLanguage is null");
                return;
            }
            File file = new File(str2);
            if (file.exists()) {
                parseLanguageXMLSplit(str, file, commonLanguage);
            } else {
                NotifyLogger.m29914e(TAG, "language xml not exist");
            }
        }
    }

    private HiCloudSceneBannerManager() {
    }
}
