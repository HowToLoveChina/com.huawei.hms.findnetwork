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
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.p106db.bean.NotifyActivityEntry;
import com.huawei.hicloud.notification.p106db.bean.SpaceInsufficientNoticeConfiguration;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.notification.p106db.languageoperator.SpaceNoticeV4LanguageOperator;
import com.huawei.hicloud.notification.p106db.languageoperator.SpaceNoticeV4LocalLanguageOperator;
import com.huawei.hicloud.notification.task.ActivityEntryPictureTask;
import com.huawei.hicloud.notification.task.SpaceNoticeV4ClearTask;
import com.huawei.hicloud.notification.task.SpaceNoticeV4ConfigDownloadTask;
import com.huawei.hicloud.notification.task.SpaceNoticeV4LocalLangTask;
import com.huawei.hicloud.notification.util.NotifyUtil;
import fk.C9721b;
import gp.C10028c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0227m;
import p015ak.C0234s;
import p616rk.C12515a;
import p709vj.C13452e;
import p742wj.C13612b;
import p783xp.C13843a;

/* loaded from: classes6.dex */
public class SpaceInsuffNoticeV4Manager extends SpaceNoticeBaseManager {
    private static final String DIALOG_MARK_ICON_PATH = "/appiconpath/";
    private static final int PICTURE_NAME_RANDOM_RANGE = 10000;
    private static final String TAG = "SpaceInsuffNoticeV4Manager";
    private static List<Integer> instanceIds = new ArrayList();
    private boolean isExtractingV4Language;
    private SpaceNoticeConfigServiceV4 mSpaceConfigService;

    public static class Holder {
        private static SpaceInsuffNoticeV4Manager instance = new SpaceInsuffNoticeV4Manager();

        private Holder() {
        }
    }

    private void addPictureTaskToList(SpaceInsufficientNoticeConfiguration spaceInsufficientNoticeConfiguration, ArrayList<ActivityEntryPictureTask> arrayList) {
        NotifyActivityEntry activityEntry;
        NotifyActivityEntry activityEntry2;
        NotifyActivityEntry activityEntry3;
        List<SpaceNotification> notification = spaceInsufficientNoticeConfiguration.getNotification();
        if (notification != null && notification.size() > 0) {
            for (SpaceNotification spaceNotification : notification) {
                if (spaceNotification != null && 1 == spaceNotification.getEnableActivityEntry() && (activityEntry3 = spaceNotification.getActivityEntry()) != null) {
                    NotifyActivityEntry.EntryPicture picture = activityEntry3.getPicture();
                    NotifyActivityEntry.EntryPicture picturePad = activityEntry3.getPicturePad();
                    doAddPictureTask(arrayList, picture);
                    doAddPictureTask(arrayList, picturePad);
                }
            }
        }
        List<NotificationWithActivity> notificationWithActivity = spaceInsufficientNoticeConfiguration.getNotificationWithActivity();
        if (notificationWithActivity != null && notificationWithActivity.size() > 0) {
            for (NotificationWithActivity notificationWithActivity2 : notificationWithActivity) {
                if (notificationWithActivity2 != null && 1 == notificationWithActivity2.getEnableActivityEntry() && (activityEntry2 = notificationWithActivity2.getActivityEntry()) != null) {
                    NotifyActivityEntry.EntryPicture picture2 = activityEntry2.getPicture();
                    NotifyActivityEntry.EntryPicture picturePad2 = activityEntry2.getPicturePad();
                    doAddPictureTask(arrayList, picture2);
                    doAddPictureTask(arrayList, picturePad2);
                }
            }
        }
        List<NotificationWithActivity> notificationWithTaskCenter = spaceInsufficientNoticeConfiguration.getNotificationWithTaskCenter();
        if (notificationWithTaskCenter == null || notificationWithTaskCenter.size() <= 0) {
            return;
        }
        for (NotificationWithActivity notificationWithActivity3 : notificationWithTaskCenter) {
            if (notificationWithActivity3 != null && 1 == notificationWithActivity3.getEnableActivityEntry() && (activityEntry = notificationWithActivity3.getActivityEntry()) != null) {
                NotifyActivityEntry.EntryPicture picture3 = activityEntry.getPicture();
                NotifyActivityEntry.EntryPicture picturePad3 = activityEntry.getPicturePad();
                doAddPictureTask(arrayList, picture3);
                doAddPictureTask(arrayList, picturePad3);
            }
        }
    }

    private void cacheActivityEntryImg() throws Throwable {
        NotifyLogger.m29915i(TAG, "begin cacheActivityEntryImg");
        SpaceNoticeV4Bean spaceNoticeConfigV4Local = getSpaceNoticeConfigV4Local();
        if (spaceNoticeConfigV4Local == null) {
            NotifyLogger.m29916w(TAG, "noticeRoot is null");
            return;
        }
        SpaceInsufficientNoticeConfiguration configuration = spaceNoticeConfigV4Local.getConfiguration();
        if (configuration == null) {
            NotifyLogger.m29916w(TAG, "notifyConfig is null");
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
        NotifyLogger.m29915i(TAG, "clear HiCloudBackupSpaceInsufficientNotice language");
        for (Integer num : instanceIds) {
            C10028c.m62182c0().m62353l(num + "_space_notice_v4_version");
            C10028c.m62182c0().m62353l(num + "_space_notice_v4_download_result");
        }
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
            arrayList.add(new ActivityEntryPictureTask(contextM1377a.getFilesDir() + NotifyConstants.ACTIVITY_ENTRY_PICTURE_PATH + File.separator + (C0227m.m1593f(url) + new SecureRandom().nextInt(10000) + System.currentTimeMillis()), url, hash));
        }
    }

    private void downloadLanguageForNotification(List<SpaceNotification> list) {
        if (list == null || list.isEmpty()) {
            NotifyLogger.m29916w(TAG, "notificationList is null or empty");
            return;
        }
        for (SpaceNotification spaceNotification : list) {
            int id2 = spaceNotification.getId();
            instanceIds.add(Integer.valueOf(id2));
            new SpaceNoticeV4LangDownloader(id2).extractCommonLanguage(spaceNotification.getLanguage());
        }
    }

    private void downloadLanguageForNotificationWithActivity(List<NotificationWithActivity> list) {
        if (list == null || list.isEmpty()) {
            NotifyLogger.m29916w(TAG, "notificationWithActivityList is null or empty");
            return;
        }
        for (NotificationWithActivity notificationWithActivity : list) {
            int id2 = notificationWithActivity.getId();
            instanceIds.add(Integer.valueOf(id2));
            new SpaceNoticeV4LangDownloader(id2).extractCommonLanguage(notificationWithActivity.getLanguage());
        }
    }

    private void downloadLanguageForNotificationWithTaskCenter(List<NotificationWithActivity> list) {
        if (list == null || list.isEmpty()) {
            NotifyLogger.m29916w(TAG, "notificationWithTaskCenterList is null or empty");
            return;
        }
        for (NotificationWithActivity notificationWithActivity : list) {
            int id2 = notificationWithActivity.getId();
            instanceIds.add(Integer.valueOf(id2));
            new SpaceNoticeV4LangDownloader(id2).extractCommonLanguage(notificationWithActivity.getLanguage());
        }
    }

    private void executeRequestSpaceConfig() throws Throwable {
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

    private void extractLanguage() throws Throwable {
        SpaceInsufficientNoticeConfiguration configuration;
        SpaceNoticeV4Bean spaceNoticeConfigV4Local = getSpaceNoticeConfigV4Local();
        if (spaceNoticeConfigV4Local == null || (configuration = spaceNoticeConfigV4Local.getConfiguration()) == null) {
            return;
        }
        downloadLanguageForNotification(configuration.getNotification());
        downloadLanguageForNotificationWithActivity(configuration.getNotificationWithActivity());
        downloadLanguageForNotificationWithTaskCenter(configuration.getNotificationWithTaskCenter());
    }

    public static String getDialogMarkIconPath() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return "";
        }
        return contextM1377a.getFilesDir() + DIALOG_MARK_ICON_PATH;
    }

    public static SpaceInsuffNoticeV4Manager getInstance() {
        return Holder.instance;
    }

    private List<CommonLanguageDbString> getLanguageStringFromDb(String str, String str2, String str3) {
        if (isCloudConfigExist() && isCloudDbContainsData()) {
            NotifyLogger.m29915i(TAG, "get string from cloud db");
            return new SpaceNoticeV4LanguageOperator().queryString(str, str2, HNConstants.Language.EN_STANDARD, str3);
        }
        NotifyLogger.m29915i(TAG, "get string from local db");
        return new SpaceNoticeV4LocalLanguageOperator().queryString(str, str2, HNConstants.Language.EN_STANDARD, str3);
    }

    private void parseLocalLanguageForNotification(List<SpaceNotification> list) throws Throwable {
        if (list == null || list.isEmpty()) {
            NotifyLogger.m29916w(TAG, "notificationList is null or empty");
            return;
        }
        Iterator<SpaceNotification> it = list.iterator();
        while (it.hasNext()) {
            SpaceNoticeV4LocalLangExecutor.getInstance().execute(it.next().getLanguage());
        }
    }

    private void parseLocalLanguageForNotificationWithActivity(List<NotificationWithActivity> list) throws Throwable {
        if (list == null || list.isEmpty()) {
            NotifyLogger.m29916w(TAG, "notificationWithActivityList is null or empty");
            return;
        }
        Iterator<NotificationWithActivity> it = list.iterator();
        while (it.hasNext()) {
            SpaceNoticeV4LocalLangExecutor.getInstance().execute(it.next().getLanguage());
        }
    }

    private void parseLocalLanguageForNotificationWithTaskCenter(List<NotificationWithActivity> list) throws Throwable {
        if (list == null || list.isEmpty()) {
            NotifyLogger.m29916w(TAG, "notificationWithTaskCenterList is null or empty");
            return;
        }
        Iterator<NotificationWithActivity> it = list.iterator();
        while (it.hasNext()) {
            SpaceNoticeV4LocalLangExecutor.getInstance().execute(it.next().getLanguage());
        }
    }

    public boolean checkMultiLanguage(int i10, String... strArr) {
        boolean z10 = true;
        if (!C13452e.m80781L().m80803F0().booleanValue()) {
            return true;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(getStringFromConfig(str, i10, false))) {
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
        new SpaceNoticeV4LanguageOperator().clear();
        clearLanguageVersion();
        clearConfigFile();
        clearActiviyEntryPictureAndSp();
    }

    public void clearAllConfigInTask() {
        C12515a.m75110o().m75175e(new SpaceNoticeV4ClearTask(), true);
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
            File file = new File(contextM1377a.getFilesDir() + File.separator + "HiCloudSpaceNoticeConfigV4.json");
            if (file.exists() && !(zDelete2 = file.delete())) {
                NotifyLogger.m29914e(TAG, "deleteResult is:" + zDelete2);
            }
            Iterator<Integer> it = instanceIds.iterator();
            while (it.hasNext()) {
                File file2 = new File(contextM1377a.getFilesDir() + File.separator + it.next().intValue() + "_space_usage_notice_v4_language.xml");
                if (file2.exists() && !(zDelete = file2.delete())) {
                    NotifyLogger.m29914e(TAG, "deleteResult is:" + zDelete);
                }
            }
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "clearConfigFile exception:" + e10.toString());
        }
    }

    public void executeLocalLanguageTask() {
        C12515a.m75110o().m75175e(new SpaceNoticeV4LocalLangTask(), true);
    }

    public void extractLocalLanguage() throws Throwable {
        if (isCloudDbContainsData() || isLocalDbContainsData()) {
            NotifyLogger.m29915i(TAG, "has data in db, exit extractLocalLanguage");
            return;
        }
        SpaceNoticeV4Bean configFromAssets = getConfigFromAssets();
        if (configFromAssets == null) {
            NotifyLogger.m29914e(TAG, "extractLocalLanguage noticeRoot null");
            return;
        }
        SpaceInsufficientNoticeConfiguration configuration = configFromAssets.getConfiguration();
        if (configuration == null) {
            NotifyLogger.m29914e(TAG, "No configuration");
            return;
        }
        parseLocalLanguageForNotification(configuration.getNotification());
        parseLocalLanguageForNotificationWithActivity(configuration.getNotificationWithActivity());
        parseLocalLanguageForNotificationWithTaskCenter(configuration.getNotificationWithTaskCenter());
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

    public SpaceNoticeV4Bean getConfigFromAssets() throws IOException {
        try {
            return (SpaceNoticeV4Bean) new Gson().fromJson(C0209d.m1290o2(C0213f.m1377a().getAssets().open("HiCloudSpaceNoticeConfigV4.json")), SpaceNoticeV4Bean.class);
        } catch (JsonSyntaxException | IOException e10) {
            NotifyLogger.m29914e(TAG, "open local config fail msg:" + e10.getMessage());
            return null;
        }
    }

    public SpaceNoticeV4Bean getConfigRaw(String str) throws Throwable {
        NotifyLogger.m29915i(TAG, "getConfigFromFile");
        try {
            return (SpaceNoticeV4Bean) new Gson().fromJson(C0209d.m1290o2(new FileInputStream(new File(C0213f.m1377a().getFilesDir() + File.separator + str))), SpaceNoticeV4Bean.class);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "cloud config file not exitst, msg:" + e10.getMessage());
            return null;
        }
    }

    public SpaceNoticeV4Bean getSpaceNoticeConfigV4() {
        SpaceNoticeV4Bean configRaw = getConfigRaw("HiCloudSpaceNoticeConfigV4.json");
        if (!isCloudConfigExist() || !isCloudDbContainsData()) {
            configRaw = getConfigFromAssets();
            if (C13612b.m81829B().isLogin() && C10028c.m62182c0().m62221H1()) {
                C12515a.m75110o().m75172d(new SpaceNoticeV4ConfigDownloadTask());
            }
        }
        return configRaw;
    }

    public SpaceNoticeV4Bean getSpaceNoticeConfigV4Local() throws Throwable {
        return getConfigRaw("HiCloudSpaceNoticeConfigV4.json");
    }

    public String getStringFromConfig(String str, int i10, boolean z10) {
        return NotifyUtil.getStringFromConfig(str, new SpaceNoticeV4LangDownloader(i10).getExtractResult(), z10, getLanguageStringFromDb(C0234s.m1631i(), HNUtil.getCurrentBaseLanguage(), str));
    }

    public String getStringUseLock(String str, int i10) {
        String stringFromConfig;
        synchronized (SpaceNoticeV4LangDownloader.getInstance().getLockObj()) {
            stringFromConfig = getStringFromConfig(str, i10, true);
        }
        return stringFromConfig;
    }

    public String getStringWithDefault(String str, int i10) {
        return getStringFromConfig(str, i10, true);
    }

    public boolean isCloudConfigExist() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return false;
        }
        return new File(contextM1377a.getFilesDir() + File.separator + "HiCloudSpaceNoticeConfigV4.json").exists();
    }

    public boolean isCloudDbContainsData() {
        return new SpaceNoticeV4LanguageOperator().hasRecord();
    }

    public boolean isExtractingV4Language() {
        return this.isExtractingV4Language;
    }

    public boolean isLocalDbContainsData() {
        return new SpaceNoticeV4LocalLanguageOperator().hasRecord();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
    
        if (p459lp.C11327e.m68063f("HiCloudBackupSpaceInsuffNotice") >= r2) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005a, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i(com.huawei.hicloud.notification.manager.SpaceInsuffNoticeV4Manager.TAG, "version updated, query config");
        executeRequestSpaceConfig();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i(com.huawei.hicloud.notification.manager.SpaceInsuffNoticeV4Manager.TAG, "version not updated, extract sync module config");
        extractLanguage();
        cacheActivityEntryImg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean requestConfig() throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.String r0 = "request notice config version"
            java.lang.String r1 = "SpaceInsuffNoticeV4Manager"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            r0 = 0
            r2 = r0
        L9:
            r3 = 2
            if (r2 > r3) goto L4e
            com.huawei.hicloud.notification.manager.SpaceNoticeConfigServiceV4 r4 = r7.mSpaceConfigService     // Catch: fk.C9721b -> L13
            long r2 = r4.getConfigVersion()     // Catch: fk.C9721b -> L13
            goto L50
        L13:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "request notice config version exception: "
            r5.append(r6)
            java.lang.String r6 = r4.toString()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r1, r5)
            com.huawei.hicloud.notification.manager.SpaceNoticeConfigServiceV4 r5 = r7.mSpaceConfigService
            boolean r4 = r5.isExceptionNeedRetry(r4)
            if (r4 == 0) goto L4d
            if (r2 >= r3) goto L4d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "requestConfigVersion exception retry, retry num: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r3)
            int r2 = r2 + 1
            goto L9
        L4d:
            return r0
        L4e:
            r2 = 0
        L50:
            java.lang.String r4 = "HiCloudBackupSpaceInsuffNotice"
            long r4 = p459lp.C11327e.m68063f(r4)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L64
            java.lang.String r0 = "version updated, query config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            r7.executeRequestSpaceConfig()
            r7 = 1
            return r7
        L64:
            java.lang.String r2 = "version not updated, extract sync module config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r2)
            r7.extractLanguage()
            r7.cacheActivityEntryImg()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.manager.SpaceInsuffNoticeV4Manager.requestConfig():boolean");
    }

    public void setExtractingV4Language(boolean z10) {
        this.isExtractingV4Language = z10;
    }

    private SpaceInsuffNoticeV4Manager() {
        this.mSpaceConfigService = new SpaceNoticeConfigServiceV4(null);
        this.isExtractingV4Language = false;
    }
}
