package com.huawei.hicloud.notification.manager;

import android.content.Context;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.bean.HiCloudSpaceNoticeConfiguration;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.p106db.bean.NotifyActivityEntry;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotifyConfig;
import com.huawei.hicloud.notification.p106db.languageoperator.SpaceNoticeV3LanguageOperator;
import com.huawei.hicloud.notification.p106db.languageoperator.SpaceNoticeV3LocalLanguageOperator;
import com.huawei.hicloud.notification.task.ActivityEntryPictureTask;
import com.huawei.hicloud.notification.task.SpaceNoticeV3ClearTask;
import com.huawei.hicloud.notification.task.SpaceNoticeV3ConfigDownloadTask;
import com.huawei.hicloud.notification.task.SpaceNoticeV3LocalLangTask;
import com.huawei.hicloud.notification.util.NotifyUtil;
import fk.C9721b;
import gp.C10028c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0227m;
import p015ak.C0234s;
import p459lp.C11327e;
import p616rk.C12515a;
import p709vj.C13452e;
import p742wj.C13612b;
import p783xp.C13843a;

/* loaded from: classes6.dex */
public class SpaceNoticeV3Manager extends SpaceNoticeBaseManager {
    private static final String DIALOG_MARK_ICON_PATH = "/appiconpath/";
    private static final int PICTURE_NAME_RANDOM_RANGE = 10000;
    private static final String TAG = "SpaceNoticeV3Manager";
    private boolean isExtractingV3Language;
    private Random mPictureNameRand;
    private SpaceNoticeConfigServiceV3 mSpaceConfigService;

    public static class Holder {
        private static SpaceNoticeV3Manager instance = new SpaceNoticeV3Manager();

        private Holder() {
        }
    }

    public /* synthetic */ SpaceNoticeV3Manager(C49421 c49421) {
        this();
    }

    private void addPictureTaskToList(HiCloudSpaceNoticeConfiguration hiCloudSpaceNoticeConfiguration, ArrayList<ActivityEntryPictureTask> arrayList) {
        NotifyActivityEntry activityEntry;
        NotifyActivityEntry activityEntry2;
        List<SpaceNotification> notification = hiCloudSpaceNoticeConfiguration.getNotification();
        if (notification != null && notification.size() > 0) {
            for (SpaceNotification spaceNotification : notification) {
                if (spaceNotification != null && 1 == spaceNotification.getEnableActivityEntry() && (activityEntry2 = spaceNotification.getActivityEntry()) != null) {
                    NotifyActivityEntry.EntryPicture picture = activityEntry2.getPicture();
                    NotifyActivityEntry.EntryPicture picturePad = activityEntry2.getPicturePad();
                    doAddPictureTask(arrayList, picture);
                    doAddPictureTask(arrayList, picturePad);
                }
            }
        }
        List<NotificationWithActivity> notificationWithActivity = hiCloudSpaceNoticeConfiguration.getNotificationWithActivity();
        if (notificationWithActivity == null || notificationWithActivity.size() <= 0) {
            return;
        }
        for (NotificationWithActivity notificationWithActivity2 : notificationWithActivity) {
            if (notificationWithActivity2 != null && 1 == notificationWithActivity2.getEnableActivityEntry() && (activityEntry = notificationWithActivity2.getActivityEntry()) != null) {
                NotifyActivityEntry.EntryPicture picture2 = activityEntry.getPicture();
                NotifyActivityEntry.EntryPicture picturePad2 = activityEntry.getPicturePad();
                doAddPictureTask(arrayList, picture2);
                doAddPictureTask(arrayList, picturePad2);
            }
        }
    }

    private void cacheActivityEntryImg() {
        NotifyLogger.m29915i(TAG, "begin cacheActivityEntryImg");
        SpaceNoticeV3Bean spaceNoticeConfigV3Local = getSpaceNoticeConfigV3Local();
        if (spaceNoticeConfigV3Local == null) {
            NotifyLogger.m29915i(TAG, "noticeRoot is null");
            return;
        }
        SpaceNotifyConfig spaceNotifyConfig = spaceNoticeConfigV3Local.getmSpaceNotifyConfig();
        if (spaceNotifyConfig == null) {
            NotifyLogger.m29915i(TAG, "notifyConfig is null");
            return;
        }
        HiCloudSpaceNoticeConfiguration configuration = spaceNotifyConfig.getConfiguration();
        if (configuration == null) {
            NotifyLogger.m29914e(TAG, "configuration is null");
            return;
        }
        ArrayList<ActivityEntryPictureTask> arrayList = new ArrayList<>();
        addPictureTaskToList(configuration, arrayList);
        if (arrayList.size() == 0) {
            NotifyLogger.m29915i(TAG, "no task needs to be execute");
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(arrayList.size());
        Iterator<ActivityEntryPictureTask> it = arrayList.iterator();
        while (it.hasNext()) {
            ActivityEntryPictureTask next = it.next();
            next.setCount(countDownLatch);
            C12515a.m75110o().m75175e(next, false);
        }
        try {
            if (!countDownLatch.await(30000L, TimeUnit.MILLISECONDS)) {
                NotifyLogger.m29914e(TAG, "banner picture download threads time out, total: " + arrayList.size() + " tasks. " + countDownLatch.getCount() + " task(s) time out");
            }
        } catch (InterruptedException e10) {
            NotifyLogger.m29914e(TAG, e10.toString());
        }
        storeLocalPathInSpFile(arrayList);
    }

    private void clearActiviyEntryPictureAndSp() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e(TAG, "clearActiviyEntryPictureAndSp context is null");
            return;
        }
        C0212e0.m1352b(contextM1377a, NotifyConstants.ACTIVITY_ENTRY_PICTURE_URL_SP_PATH);
        C13843a.m83085g(contextM1377a.getFilesDir() + NotifyConstants.ACTIVITY_ENTRY_PICTURE_PATH);
    }

    private void clearLanguageVersion() {
        NotifyLogger.m29915i(TAG, "clear notice v2 language");
        C10028c.m62182c0().m62353l("space_notice_v3_version");
        C10028c.m62182c0().m62353l("space_notice_v3_download_result");
    }

    private void doAddPictureTask(ArrayList<ActivityEntryPictureTask> arrayList, NotifyActivityEntry.EntryPicture entryPicture) {
        if (entryPicture != null) {
            String url = entryPicture.getUrl();
            String hash = entryPicture.getHash();
            if (TextUtils.isEmpty(url)) {
                NotifyLogger.m29914e(TAG, "pictureUrl null");
                return;
            }
            if (!URLUtil.isHttpsUrl(url)) {
                NotifyLogger.m29914e(TAG, "pictureUrl not https: " + url);
                return;
            }
            if (TextUtils.isEmpty(hash)) {
                NotifyLogger.m29914e(TAG, "pictureHash null");
                return;
            }
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a == null) {
                NotifyLogger.m29914e(TAG, "doAddPictureTask mContext is null");
                return;
            }
            if (isLocalFileExist(url)) {
                return;
            }
            arrayList.add(new ActivityEntryPictureTask(contextM1377a.getFilesDir() + NotifyConstants.ACTIVITY_ENTRY_PICTURE_PATH + "/" + (C0227m.m1593f(url) + "" + this.mPictureNameRand.nextInt(10000) + "" + System.currentTimeMillis()), url, hash));
        }
    }

    private void executeRequestSpaceConfig() {
        NotifyLogger.m29915i(TAG, "requestSpaceUsageNoticeConfig");
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "request notice config exception: " + e10.toString());
                if (e10.m60659c() == 304) {
                    NotifyLogger.m29914e(TAG, "HTTP_NOT_MODIFY extract sync module config");
                    extractLanguage();
                    cacheActivityEntryImg();
                    return;
                } else {
                    if (!this.mSpaceConfigService.isExceptionNeedRetry(e10) || i10 >= 2) {
                        return;
                    }
                    NotifyLogger.m29915i(TAG, "getLatestConfig exception retry, retry num: " + i10);
                }
            }
            if (this.mSpaceConfigService.getLatestConfig()) {
                NotifyLogger.m29915i(TAG, "request notice config success");
                clearActiviyEntryPictureAndSp();
                clearLanguageVersion();
                extractLanguage();
                cacheActivityEntryImg();
                return;
            }
            NotifyLogger.m29914e(TAG, "query cloud notify config failed");
            if (i10 >= 2) {
                return;
            }
            NotifyLogger.m29915i(TAG, "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    private void extractLanguage() {
        SpaceNotifyConfig spaceNotifyConfig;
        NotifyLogger.m29915i(TAG, "begin extractLanguage");
        SpaceNoticeV3Bean spaceNoticeConfigV3Local = getSpaceNoticeConfigV3Local();
        if (spaceNoticeConfigV3Local == null || (spaceNotifyConfig = spaceNoticeConfigV3Local.getmSpaceNotifyConfig()) == null) {
            return;
        }
        HiCloudSpaceNoticeConfiguration configuration = spaceNotifyConfig.getConfiguration();
        if (configuration == null) {
            NotifyLogger.m29914e(TAG, "No configuration");
        } else {
            new SpaceNoticeV3LangDownloader().extractCommonLanguage(configuration.getCommonLanguage());
        }
    }

    public static String getDialogMarkIconPath() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return "";
        }
        return contextM1377a.getFilesDir() + DIALOG_MARK_ICON_PATH;
    }

    public static SpaceNoticeV3Manager getInstance() {
        return Holder.instance;
    }

    private List<CommonLanguageDbString> getLanguageStringFromDb(String str, String str2, String str3) {
        if (isCloudConfigExist() && isCloudDbContainsData()) {
            NotifyLogger.m29915i(TAG, "get string from cloud db");
            return new SpaceNoticeV3LanguageOperator().queryString(str, str2, HNConstants.Language.EN_STANDARD, str3);
        }
        NotifyLogger.m29915i(TAG, "get string from local db");
        return new SpaceNoticeV3LocalLanguageOperator().queryString(str, str2, HNConstants.Language.EN_STANDARD, str3);
    }

    public boolean checkMultiLanguage(String... strArr) {
        boolean z10 = true;
        if (!C13452e.m80781L().m80803F0().booleanValue()) {
            return true;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(getStringFromConfig(str, false))) {
                    C10028c.m62182c0().m62401u2(false);
                }
            }
            z10 = false;
            break;
        }
        NotifyLogger.m29915i(TAG, "checkMultiLanguage result: " + z10);
        return z10;
    }

    public void clearAllConfig() throws SQLException {
        new SpaceNoticeV3LanguageOperator().clear();
        clearLanguageVersion();
        clearConfigFile();
        clearActiviyEntryPictureAndSp();
    }

    public void clearAllConfigInTask() {
        C12515a.m75110o().m75175e(new SpaceNoticeV3ClearTask(), true);
        NotificationReportUtil.reportSpaceNotifyClear(NotifyConstants.ClearSpaceFrequencyDBFrom.FROM_EXIT_ACCOUNT);
    }

    public void clearConfigFile() {
        boolean zDelete;
        boolean zDelete2;
        try {
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a == null) {
                NotifyLogger.m29914e(TAG, "clearConfigFile context null");
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(contextM1377a.getFilesDir());
            String str = File.separator;
            sb2.append(str);
            sb2.append("HiCloudSpaceNoticeConfigV3.json");
            File file = new File(sb2.toString());
            if (file.exists() && !(zDelete2 = file.delete())) {
                NotifyLogger.m29914e(TAG, "deleteResult is:" + zDelete2);
            }
            File file2 = new File(contextM1377a.getFilesDir() + str + "space_usage_notice_v3_language.xml");
            if (!file2.exists() || (zDelete = file2.delete())) {
                return;
            }
            NotifyLogger.m29914e(TAG, "deleteResult is:" + zDelete);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "clearConfigFile exception:" + e10.toString());
        }
    }

    public void executeLocalLanguageTask() {
        NotifyLogger.m29913d(TAG, "start SpaceNoticeV3LocalLangTask");
        C12515a.m75110o().m75175e(new SpaceNoticeV3LocalLangTask(), true);
    }

    public void extractLocalLanguage() {
        NotifyLogger.m29913d(TAG, "extractLocalLanguage");
        SpaceNoticeV3Bean configFromAssets = getConfigFromAssets();
        if (configFromAssets == null) {
            NotifyLogger.m29914e(TAG, "extractLocalLanguage noticeRoot null");
            return;
        }
        SpaceNotifyConfig spaceNotifyConfig = configFromAssets.getmSpaceNotifyConfig();
        if (spaceNotifyConfig != null) {
            HiCloudSpaceNoticeConfiguration configuration = spaceNotifyConfig.getConfiguration();
            if (configuration == null) {
                NotifyLogger.m29914e(TAG, "No configuration");
            } else {
                SpaceNoticeV3LocalLangExecutor.getInstance().execute(configuration.getCommonLanguage());
            }
        }
    }

    public Bitmap getActivityEntryBitmapByUrl(String str) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e(TAG, "getActivityEntryBitmapByUrl  context is null");
            return null;
        }
        String strM1363m = C0212e0.m1363m(contextM1377a, NotifyConstants.ACTIVITY_ENTRY_PICTURE_URL_SP_PATH, C0227m.m1593f(str), null);
        if (!TextUtils.isEmpty(strM1363m)) {
            return C0209d.m1311u(strM1363m);
        }
        NotifyLogger.m29914e(TAG, "path is empty");
        return null;
    }

    public SpaceNoticeV3Bean getConfigFromAssets() {
        NotifyLogger.m29915i(TAG, "getConfigFromFile");
        try {
            return (SpaceNoticeV3Bean) new Gson().fromJson(C0209d.m1290o2(C0213f.m1377a().getAssets().open("HiCloudSpaceNoticeConfigV3.json")), SpaceNoticeV3Bean.class);
        } catch (JsonSyntaxException | IOException e10) {
            NotifyLogger.m29914e(TAG, "open local config fail msg:" + e10.getMessage());
            return null;
        }
    }

    public List<SpaceNotification> getConfigNotificationByNoticeType(String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            NotifyLogger.m29914e(TAG, "noticeType is empty");
            return null;
        }
        NotifyLogger.m29913d(TAG, "getConfigNotificationByNoticeType: " + str);
        ArrayList arrayList = new ArrayList();
        SpaceNoticeV3Bean spaceNoticeConfigV3 = getSpaceNoticeConfigV3();
        if (spaceNoticeConfigV3 == null) {
            NotifyLogger.m29914e(TAG, "spaceNoticeV3Bean is null");
            return null;
        }
        SpaceNotifyConfig spaceNotifyConfig = spaceNoticeConfigV3.getmSpaceNotifyConfig();
        if (spaceNotifyConfig == null) {
            NotifyLogger.m29914e(TAG, "root config is null");
            return null;
        }
        HiCloudSpaceNoticeConfiguration configuration = spaceNotifyConfig.getConfiguration();
        if (configuration == null) {
            NotifyLogger.m29914e(TAG, "configuration is null");
            return null;
        }
        List<SpaceNotification> notification = configuration.getNotification();
        if (notification == null) {
            NotifyLogger.m29914e(TAG, "notifications is null");
            return null;
        }
        for (SpaceNotification spaceNotification : notification) {
            if (spaceNotification == null) {
                NotifyLogger.m29914e(TAG, "notification in config is null");
            } else {
                String noticeType = spaceNotification.getNoticeType();
                if (TextUtils.isEmpty(noticeType)) {
                    NotifyLogger.m29914e(TAG, "noticeType in config is empty");
                } else if (str.equals(noticeType)) {
                    NotifyLogger.m29915i(TAG, "match noticeType");
                    arrayList.add(spaceNotification);
                }
            }
        }
        NotifyLogger.m29915i(TAG, "matched num: " + arrayList.size());
        return arrayList;
    }

    public SpaceNoticeV3Bean getConfigRaw(String str) throws IOException {
        SpaceNoticeV3Bean spaceNoticeV3Bean;
        Exception e10;
        NotifyLogger.m29915i(TAG, "getConfigFromFile");
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(C0213f.m1377a().getFilesDir() + File.separator + str));
            try {
                spaceNoticeV3Bean = (SpaceNoticeV3Bean) new Gson().fromJson(C0209d.m1290o2(fileInputStream), SpaceNoticeV3Bean.class);
                try {
                    fileInputStream.close();
                } catch (Exception e11) {
                    e10 = e11;
                    NotifyLogger.m29914e(TAG, "cloud config file not exitst, msg:" + e10.getMessage());
                    return spaceNoticeV3Bean;
                }
            } finally {
            }
        } catch (Exception e12) {
            spaceNoticeV3Bean = null;
            e10 = e12;
        }
        return spaceNoticeV3Bean;
    }

    public SpaceNoticeV3Bean getSpaceNoticeConfigV3() throws IOException {
        SpaceNoticeV3Bean configRaw = getConfigRaw("HiCloudSpaceNoticeConfigV3.json");
        if (!isCloudConfigExist() || !isCloudDbContainsData()) {
            configRaw = getConfigFromAssets();
            if (C13612b.m81829B().isLogin() && C10028c.m62182c0().m62221H1()) {
                C12515a.m75110o().m75172d(new SpaceNoticeV3ConfigDownloadTask());
            }
        }
        return configRaw;
    }

    public SpaceNoticeV3Bean getSpaceNoticeConfigV3Local() {
        return getConfigRaw("HiCloudSpaceNoticeConfigV3.json");
    }

    public String getStringFromConfig(String str, boolean z10) {
        return NotifyUtil.getStringFromConfig(str, new SpaceNoticeV3LangDownloader().getExtractResult(), z10, getLanguageStringFromDb(C0234s.m1631i(), HNUtil.getCurrentBaseLanguage(), str));
    }

    public String getStringUseLock(String str) {
        String stringFromConfig;
        synchronized (SpaceNoticeV3LangDownloader.getInstance().getLockObj()) {
            stringFromConfig = getStringFromConfig(str, true);
        }
        return stringFromConfig;
    }

    public String getStringWithDefault(String str) {
        return getStringFromConfig(str, true);
    }

    public boolean isCloudConfigExist() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return false;
        }
        return new File(contextM1377a.getFilesDir() + File.separator + "HiCloudSpaceNoticeConfigV3.json").exists();
    }

    public boolean isCloudDbContainsData() {
        return new SpaceNoticeV3LanguageOperator().hasRecord();
    }

    public boolean isExtractingV3Language() {
        return this.isExtractingV3Language;
    }

    public boolean requestConfig() {
        long configVersion;
        NotifyLogger.m29915i(TAG, "request notice config version");
        int i10 = 0;
        while (true) {
            if (i10 > 2) {
                configVersion = 0;
                break;
            }
            try {
                configVersion = this.mSpaceConfigService.getConfigVersion();
                break;
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "request notice config version exception: " + e10.toString());
                if (!this.mSpaceConfigService.isExceptionNeedRetry(e10) || i10 >= 2) {
                    return false;
                }
                NotifyLogger.m29915i(TAG, "requestConfigVersion exception retry, retry num: " + i10);
                i10++;
            }
        }
        if (C11327e.m68063f("HiCloudSpaceNoticeConfigV3") < configVersion) {
            NotifyLogger.m29915i(TAG, "version updated, query config");
            executeRequestSpaceConfig();
            return true;
        }
        NotifyLogger.m29915i(TAG, "version not updated, extract sync module config");
        extractLanguage();
        cacheActivityEntryImg();
        return false;
    }

    public void setExtractingV3Language(boolean z10) {
        this.isExtractingV3Language = z10;
    }

    private SpaceNoticeV3Manager() {
        this.mPictureNameRand = new Random();
        this.mSpaceConfigService = new SpaceNoticeConfigServiceV3(null);
        this.isExtractingV3Language = false;
    }
}
