package com.huawei.hicloud.notification.manager;

import android.content.Context;
import android.database.SQLException;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguage;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.p106db.bean.CommonPicture;
import com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig.BackupSpaceInsuffNoticeV5Configuration;
import com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig.DataItems;
import com.huawei.hicloud.notification.p106db.languageoperator.BackupSpaceInsuffWindowNoticeLanguageOperator;
import com.huawei.hicloud.notification.task.BaseDownLoadFileTask;
import com.huawei.hicloud.notification.task.SpaceNoticeV5ClearTask;
import com.huawei.hicloud.notification.task.SpaceNoticeV5ConfigDownloadTask;
import com.huawei.hicloud.notification.util.NotifyUtil;
import fk.C9721b;
import gp.C10028c;
import hk.C10280c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0227m;
import p015ak.C0234s;
import p459lp.C11327e;
import p616rk.C12515a;
import p742wj.C13612b;
import p783xp.C13843a;

/* loaded from: classes6.dex */
public class BackupSpaceInsuffNoticeV5Manager {
    private static final String CENTER_WINDOW_SUFFIX = "_centerWindow";
    private static final String PICTURE_CACHE_FOLDER = "om_pictures";
    private static final String PICTURE_ICON_CACHE_FOLDER = "om_icon_pictures";
    private static final String TAG = "BackupSpaceInsuffNoticeV5Manager";
    private static final List<String> instanceIds = new ArrayList();
    private final BackupSpaceInsuffNoticeV5Service backupSpaceInsuffNoticeV5Service;
    private boolean isExtractingV4Language;

    public static class Holder {
        private static final BackupSpaceInsuffNoticeV5Manager INSTANCE = new BackupSpaceInsuffNoticeV5Manager();

        private Holder() {
        }
    }

    private boolean checkPicture(CommonPicture commonPicture) throws Throwable {
        String strM1591d;
        if (commonPicture == null) {
            return false;
        }
        String url = commonPicture.getUrl();
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        String hash = commonPicture.getHash();
        if (TextUtils.isEmpty(hash)) {
            return false;
        }
        try {
            strM1591d = C0227m.m1591d(getPicturePath(url));
        } catch (C9721b e10) {
            NotifyLogger.m29916w(TAG, "getFileSha256 exception: " + e10.toString());
            strM1591d = null;
        }
        return TextUtils.isEmpty(strM1591d) || !hash.equals(strM1591d);
    }

    private void clearCachedPictures() {
        NotifyLogger.m29915i(TAG, "delete cached pictures");
        C13843a.m83085g(getPictureCacheFolder());
    }

    private void clearLanguage() throws SQLException {
        NotifyLogger.m29915i(TAG, "notificationList is null or empty");
        clearLanguageVersion();
        new BackupSpaceInsuffWindowNoticeLanguageOperator().clear();
    }

    private void clearLanguageVersion() {
        NotifyLogger.m29915i(TAG, "clear HiCloudBackupSpaceInsufficientNotice language");
        List<BackupSpaceInsuffNoticeV5Configuration> configList = getConfigList();
        if (configList == null) {
            NotifyLogger.m29916w(TAG, "configurations is null");
            return;
        }
        for (BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration : configList) {
            if (backupSpaceInsuffNoticeV5Configuration == null) {
                NotifyLogger.m29916w(TAG, "config is null");
            } else {
                C10028c.m62182c0().m62353l(backupSpaceInsuffNoticeV5Configuration.getId() + "_backup_space_Insuff_window_notice_version");
                C10028c.m62182c0().m62353l(backupSpaceInsuffNoticeV5Configuration.getId() + "_backup_space_Insuff_window_notice_download_result");
                C10028c.m62182c0().m62353l(backupSpaceInsuffNoticeV5Configuration.getId() + CENTER_WINDOW_SUFFIX + "_backup_space_Insuff_window_notice_version");
                C10028c.m62182c0().m62353l(backupSpaceInsuffNoticeV5Configuration.getId() + CENTER_WINDOW_SUFFIX + "_backup_space_Insuff_window_notice_download_result");
                C10028c.m62182c0().m62353l(backupSpaceInsuffNoticeV5Configuration.getId() + "_backup_space_Insuff_window_notice_hash");
                C10028c.m62182c0().m62353l(backupSpaceInsuffNoticeV5Configuration.getId() + CENTER_WINDOW_SUFFIX + "_backup_space_Insuff_window_notice_hash");
            }
        }
    }

    private void downloadLanguage(String str, CommonLanguage commonLanguage) {
        if (commonLanguage == null) {
            NotifyLogger.m29916w(TAG, "configurationLanguage is nully");
        } else {
            instanceIds.add(str);
            new BackupSpaceV5WindowNoticeLangDownloader(str).extractCommonLanguage(commonLanguage);
        }
    }

    private void downloadLanguageForNotification(List<BackupSpaceInsuffNoticeV5Configuration> list) {
        for (BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration : list) {
            String strValueOf = String.valueOf(backupSpaceInsuffNoticeV5Configuration.getId());
            downloadLanguage(strValueOf, backupSpaceInsuffNoticeV5Configuration.getLanguage());
            if (backupSpaceInsuffNoticeV5Configuration.getTaskCenterWindow() != null) {
                downloadLanguage(strValueOf + CENTER_WINDOW_SUFFIX, backupSpaceInsuffNoticeV5Configuration.getTaskCenterWindow().getLanguage());
            }
        }
    }

    private void executeRequestSpaceConfig() {
        NotifyLogger.m29915i(TAG, "requestSpaceUsageNoticeConfig");
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "request notice config exception: " + e10);
                if (e10.m60659c() == 304) {
                    NotifyLogger.m29914e(TAG, "HTTP_NOT_MODIFY extract sync module config");
                    extractLanguage();
                    cachePictures();
                    return;
                } else if (this.backupSpaceInsuffNoticeV5Service.isExceptionNeedRetry(e10) && i10 < 2) {
                    NotifyLogger.m29915i(TAG, "getLatestConfig exception retry, retry num: " + i10);
                } else {
                    if (e10.m60659c() != 400) {
                        return;
                    }
                    NotifyLogger.m29914e(TAG, "clear all v5 config");
                    clearAllConfig();
                }
            }
            if (this.backupSpaceInsuffNoticeV5Service.getLatestConfig()) {
                NotifyLogger.m29915i(TAG, "request notice config success");
                extractLanguage();
                cachePictures();
                return;
            }
            NotifyLogger.m29914e(TAG, "query cloud notify config failed");
            if (i10 >= 2) {
                return;
            }
            NotifyLogger.m29915i(TAG, "getLatestConfig failed retry, retry num: " + i10);
        }
    }

    private List<BackupSpaceInsuffNoticeV5Configuration> getConfigList() {
        BackupSpaceInsuffWindowNoticeBean backupSpaceInsufficientLocal = getBackupSpaceInsufficientLocal();
        if (backupSpaceInsufficientLocal == null) {
            NotifyLogger.m29916w(TAG, "noticeRoot is null");
            return null;
        }
        List<BackupSpaceInsuffNoticeV5Configuration> configuration = backupSpaceInsufficientLocal.getConfiguration();
        if (configuration != null && !configuration.isEmpty()) {
            return configuration;
        }
        NotifyLogger.m29916w(TAG, "notificationList is null or empty");
        return null;
    }

    public static BackupSpaceInsuffNoticeV5Manager getInstance() {
        return Holder.INSTANCE;
    }

    private List<CommonLanguageDbString> getLanguageStringFromDb(String str, String str2, String str3) {
        if (!isCloudConfigExist() || !isCloudDbContainsData()) {
            return null;
        }
        NotifyLogger.m29915i(TAG, "get string from cloud db");
        return new BackupSpaceInsuffWindowNoticeLanguageOperator().queryString(str, str2, HNConstants.Language.EN_STANDARD, str3);
    }

    public void cachePictures() {
        List<BackupSpaceInsuffNoticeV5Configuration> configList = getConfigList();
        if (configList != null) {
            Iterator<BackupSpaceInsuffNoticeV5Configuration> it = configList.iterator();
            while (it.hasNext()) {
                List<DataItems> dataItems = it.next().getDataItems();
                if (dataItems != null && !dataItems.isEmpty()) {
                    Iterator<DataItems> it2 = dataItems.iterator();
                    while (it2.hasNext()) {
                        CommonPicture icon = it2.next().getIcon();
                        if (icon != null && checkPicture(icon)) {
                            String url = icon.getUrl();
                            C12515a.m75110o().m75175e(new BaseDownLoadFileTask(url, getPicturePath(url), icon.getHash(), null), false);
                        }
                    }
                }
            }
        }
    }

    public void clearAllConfig() {
        NotifyLogger.m29915i(TAG, "clearAllConfig");
        C11327e.m68059b("HiCloudBackupSpaceInsuffNoticeV5");
        clearLanguage();
        clearConfigFile();
        clearCachedPictures();
    }

    public void clearAllConfigInTask() {
        C12515a.m75110o().m75175e(new SpaceNoticeV5ClearTask(), true);
        NotificationReportUtil.reportSpaceNotifyClear(NotifyConstants.ClearSpaceFrequencyDBFrom.FROM_EXIT_ACCOUNT);
    }

    public void clearConfigFile() {
        boolean zDelete;
        try {
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a == null) {
                NotifyLogger.m29914e(TAG, "clearConfigFile context null");
                return;
            }
            File file = new File(contextM1377a.getFilesDir() + File.separator + "HiCloudBackupSpaceInsuffNoticeV5.json");
            if (file.exists() && !(zDelete = file.delete())) {
                NotifyLogger.m29914e(TAG, "deleteResult is:" + zDelete);
            }
            NotifyLogger.m29915i(TAG, "delete language result is:" + C10280c.m63454b(new File(BackupSpaceV5WindowNoticeLangDownloader.getV5LanguageDir())));
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "clearConfigFile exception:" + e10);
        }
    }

    public void extractLanguage() {
        List<BackupSpaceInsuffNoticeV5Configuration> configList = getConfigList();
        if (configList != null) {
            downloadLanguageForNotification(configList);
        }
    }

    public String geIconCacheFolder() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C0213f.m1378b().getFilesDir());
        String str = File.separator;
        sb2.append(str);
        sb2.append(PICTURE_ICON_CACHE_FOLDER);
        sb2.append(str);
        return sb2.toString();
    }

    public BackupSpaceInsuffWindowNoticeBean getBackupSpaceInsufficient() throws IOException {
        BackupSpaceInsuffWindowNoticeBean configRaw = getConfigRaw("HiCloudBackupSpaceInsuffNoticeV5.json");
        if ((!isCloudConfigExist() || !isCloudDbContainsData()) && C13612b.m81829B().isLogin() && C10028c.m62182c0().m62221H1()) {
            C12515a.m75110o().m75172d(new SpaceNoticeV5ConfigDownloadTask());
        }
        return configRaw;
    }

    public BackupSpaceInsuffWindowNoticeBean getBackupSpaceInsufficientLocal() {
        return getConfigRaw("HiCloudBackupSpaceInsuffNoticeV5.json");
    }

    public BackupSpaceInsuffWindowNoticeBean getConfigRaw(String str) throws IOException {
        BackupSpaceInsuffWindowNoticeBean backupSpaceInsuffWindowNoticeBean;
        Exception e10;
        NotifyLogger.m29915i(TAG, "getConfigFromFile");
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(C0213f.m1377a().getFilesDir() + File.separator + str));
            try {
                backupSpaceInsuffWindowNoticeBean = (BackupSpaceInsuffWindowNoticeBean) new Gson().fromJson(C0209d.m1290o2(fileInputStream), BackupSpaceInsuffWindowNoticeBean.class);
                try {
                    fileInputStream.close();
                } catch (Exception e11) {
                    e10 = e11;
                    NotifyLogger.m29914e(TAG, "cloud config file not exitst, msg:" + e10.getMessage());
                    return backupSpaceInsuffWindowNoticeBean;
                }
            } finally {
            }
        } catch (Exception e12) {
            backupSpaceInsuffWindowNoticeBean = null;
            e10 = e12;
        }
        return backupSpaceInsuffWindowNoticeBean;
    }

    public String getIconPath(String str) {
        return geIconCacheFolder() + C0227m.m1593f(str);
    }

    public String getPictureCacheFolder() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C0213f.m1378b().getFilesDir());
        String str = File.separator;
        sb2.append(str);
        sb2.append(PICTURE_CACHE_FOLDER);
        sb2.append(str);
        return sb2.toString();
    }

    public String getPicturePath(String str) {
        return getPictureCacheFolder() + C0227m.m1593f(str);
    }

    public String getStringFromDB(String str) {
        return NotifyUtil.getStringFromConfig(str, true, true, getLanguageStringFromDb(C0234s.m1631i(), HNUtil.getCurrentBaseLanguage(), str));
    }

    public boolean isCloudConfigExist() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return false;
        }
        return new File(contextM1377a.getFilesDir() + File.separator + "HiCloudBackupSpaceInsuffNoticeV5.json").exists();
    }

    public boolean isCloudDbContainsData() {
        return new BackupSpaceInsuffWindowNoticeLanguageOperator().hasRecord();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0054, code lost:
    
        if (p459lp.C11327e.m68063f("HiCloudBackupSpaceInsuffNoticeV5") >= r2) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0056, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i(com.huawei.hicloud.notification.manager.BackupSpaceInsuffNoticeV5Manager.TAG, "version updated, query config");
        executeRequestSpaceConfig();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0060, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i(com.huawei.hicloud.notification.manager.BackupSpaceInsuffNoticeV5Manager.TAG, "version not updated, extract sync module config");
        extractLanguage();
        cachePictures();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006b, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean requestConfig() {
        /*
            r7 = this;
            java.lang.String r0 = "request notice config version"
            java.lang.String r1 = "BackupSpaceInsuffNoticeV5Manager"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            r0 = 0
            r2 = r0
        L9:
            r3 = 2
            if (r2 > r3) goto L4a
            com.huawei.hicloud.notification.manager.BackupSpaceInsuffNoticeV5Service r4 = r7.backupSpaceInsuffNoticeV5Service     // Catch: fk.C9721b -> L13
            long r2 = r4.getConfigVersion()     // Catch: fk.C9721b -> L13
            goto L4c
        L13:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "request notice config version exception: "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r1, r5)
            com.huawei.hicloud.notification.manager.BackupSpaceInsuffNoticeV5Service r5 = r7.backupSpaceInsuffNoticeV5Service
            boolean r4 = r5.isExceptionNeedRetry(r4)
            if (r4 == 0) goto L49
            if (r2 >= r3) goto L49
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "requestConfigVersion exception retry, retry num: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r3)
            int r2 = r2 + 1
            goto L9
        L49:
            return r0
        L4a:
            r2 = 0
        L4c:
            java.lang.String r4 = "HiCloudBackupSpaceInsuffNoticeV5"
            long r4 = p459lp.C11327e.m68063f(r4)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L60
            java.lang.String r0 = "version updated, query config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            r7.executeRequestSpaceConfig()
            r7 = 1
            return r7
        L60:
            java.lang.String r2 = "version not updated, extract sync module config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r2)
            r7.extractLanguage()
            r7.cachePictures()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.manager.BackupSpaceInsuffNoticeV5Manager.requestConfig():boolean");
    }

    private BackupSpaceInsuffNoticeV5Manager() {
        this.backupSpaceInsuffNoticeV5Service = new BackupSpaceInsuffNoticeV5Service(null);
        this.isExtractingV4Language = false;
    }
}
