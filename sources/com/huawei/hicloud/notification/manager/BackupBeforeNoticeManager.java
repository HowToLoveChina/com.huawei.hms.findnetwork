package com.huawei.hicloud.notification.manager;

import android.database.SQLException;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.BackupBeforeNotice;
import com.huawei.hicloud.notification.p106db.bean.BackupBeforeNoticeConfig;
import com.huawei.hicloud.notification.p106db.languageoperator.BackupBeforeNoticeLanguageOperator;
import com.huawei.hicloud.notification.task.BackupBeforeClearTask;
import com.huawei.hicloud.notification.util.NotifyUtil;
import fk.C9721b;
import gp.C10028c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p616rk.C12515a;

/* loaded from: classes6.dex */
public class BackupBeforeNoticeManager {
    private static final String TAG = "BackupBeforeNoticeManager";
    private BackupBeforeNoticeServiceV3 mBackupBeforeNoticeService;

    public static class Holder {
        private static BackupBeforeNoticeManager instance = new BackupBeforeNoticeManager();

        private Holder() {
        }
    }

    private void clearLanguageVersion() {
        NotifyLogger.m29915i(TAG, "clear backup before  notice language");
        C10028c.m62182c0().m62353l("backup_before_notice_language_version");
        C10028c.m62182c0().m62353l("backup_before_notice_language_download_result");
    }

    private void executeRequestConfig() {
        NotifyLogger.m29915i(TAG, "requestSpaceUsageNoticeConfig");
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
            } catch (C9721b e10) {
                NotifyLogger.m29914e(TAG, "request notice config exception: " + e10.toString());
                if (e10.m60659c() == 304) {
                    NotifyLogger.m29914e(TAG, "HTTP_NOT_MODIFY extract sync module config");
                    extractLanguage();
                    return;
                } else {
                    if (!this.mBackupBeforeNoticeService.isExceptionNeedRetry(e10) || i10 >= 2) {
                        return;
                    }
                    NotifyLogger.m29915i(TAG, "getLatestConfig exception retry, retry num: " + i10);
                }
            }
            if (this.mBackupBeforeNoticeService.getLatestConfig()) {
                NotifyLogger.m29915i(TAG, "request notice config success");
                clearLanguageVersion();
                extractLanguage();
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
        NotifyLogger.m29915i(TAG, "begin extractLanguage");
        BackupBeforeNoticeConfig backupBeforeNoticeConfigLocal = getBackupBeforeNoticeConfigLocal();
        if (backupBeforeNoticeConfigLocal != null) {
            new BackupBeforeNoticeLangDownloader().extractCommonLanguage(backupBeforeNoticeConfigLocal.getCommonLanguage());
        }
    }

    public static BackupBeforeNoticeManager getInstance() {
        return Holder.instance;
    }

    public void clearAllConfig() throws SQLException {
        new BackupBeforeNoticeLanguageOperator().clear();
        clearLanguageVersion();
        clearConfigFile();
    }

    public void clearAllConfigInTask() {
        C12515a.m75110o().m75172d(new BackupBeforeClearTask());
    }

    public void clearConfigFile() {
        try {
            if (C0213f.m1377a() == null) {
                NotifyLogger.m29914e(TAG, "clearConfigFile context null");
                return;
            }
            if (this.mBackupBeforeNoticeService == null) {
                this.mBackupBeforeNoticeService = new BackupBeforeNoticeServiceV3(null);
            }
            File file = new File(this.mBackupBeforeNoticeService.getConfigFilePath());
            if (file.exists() && !file.delete()) {
                NotifyLogger.m29914e(TAG, "delete config file fail.");
            }
            File file2 = new File(BackupBeforeNoticeLangDownloader.getInstance().getLanguageFilePath());
            if (!file2.exists() || file2.delete()) {
                return;
            }
            NotifyLogger.m29914e(TAG, "delete language config file fail.");
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "clearConfigFile exception:" + e10.toString());
        }
    }

    public BackupBeforeNotice getBackupBeforeNotice(int i10) {
        BackupBeforeNoticeConfig backupBeforeNoticeConfigLocal = getBackupBeforeNoticeConfigLocal();
        if (backupBeforeNoticeConfigLocal == null) {
            NotifyLogger.m29916w(TAG, "The notifyConfig is null.");
            return null;
        }
        List<BackupBeforeNotice> configuration = backupBeforeNoticeConfigLocal.getConfiguration();
        if (configuration == null) {
            NotifyLogger.m29916w(TAG, "The backup before notice data is null.");
            return null;
        }
        for (BackupBeforeNotice backupBeforeNotice : configuration) {
            if (backupBeforeNotice == null) {
                NotifyLogger.m29916w(TAG, "The beforeNotice is null.");
            } else if (backupBeforeNotice.getNoticeGoto() == null) {
                NotifyLogger.m29916w(TAG, "The noticeGoto is null.");
            } else if (TextUtils.isEmpty(backupBeforeNotice.getId())) {
                NotifyLogger.m29916w(TAG, "The beforeNotice.getId() is null.");
            } else if (backupBeforeNotice.getId().equals(String.valueOf(i10))) {
                return backupBeforeNotice;
            }
        }
        return null;
    }

    public BackupBeforeNoticeConfig getBackupBeforeNoticeConfigLocal() {
        return getConfigRaw("/HiCloudBackupBeforeNotice.json");
    }

    public BackupBeforeNoticeConfig getConfigRaw(String str) throws IOException {
        BackupBeforeNoticeConfig backupBeforeNoticeConfig;
        Exception e10;
        FileInputStream fileInputStream;
        NotifyLogger.m29915i(TAG, "getConfigFromFile");
        try {
            fileInputStream = new FileInputStream(new File(C0213f.m1377a().getFilesDir() + str));
        } catch (Exception e11) {
            backupBeforeNoticeConfig = null;
            e10 = e11;
        }
        try {
            backupBeforeNoticeConfig = (BackupBeforeNoticeConfig) new Gson().fromJson(C0209d.m1290o2(fileInputStream), BackupBeforeNoticeConfig.class);
            try {
                fileInputStream.close();
            } catch (Exception e12) {
                e10 = e12;
                NotifyLogger.m29914e(TAG, "cloud config file not exist, msg:" + e10.getMessage());
                return backupBeforeNoticeConfig;
            }
            return backupBeforeNoticeConfig;
        } finally {
        }
    }

    public String getExtraNoticeLanguage(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return NotifyUtil.getStringFromConfig(str, true, new BackupBeforeNoticeLanguageOperator().queryString(HNUtil.getCurrentLanguage(), HNUtil.getCurrentBaseLanguage(), HNConstants.Language.EN_STANDARD, str));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
    
        if (p459lp.C11327e.m68063f(com.huawei.hicloud.notification.constants.NotifyConstants.CLOUD_BACKUP_BEFORE_NOTICE) >= r2) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005a, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i(com.huawei.hicloud.notification.manager.BackupBeforeNoticeManager.TAG, "version updated, query config");
        executeRequestConfig();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0063, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        com.huawei.hicloud.notification.log.NotifyLogger.m29915i(com.huawei.hicloud.notification.manager.BackupBeforeNoticeManager.TAG, "version not updated, extract sync module config");
        extractLanguage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006c, code lost:
    
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
            java.lang.String r1 = "BackupBeforeNoticeManager"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            r0 = 0
            r2 = r0
        L9:
            r3 = 2
            if (r2 > r3) goto L4e
            com.huawei.hicloud.notification.manager.BackupBeforeNoticeServiceV3 r4 = r7.mBackupBeforeNoticeService     // Catch: fk.C9721b -> L13
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
            com.huawei.hicloud.notification.manager.BackupBeforeNoticeServiceV3 r5 = r7.mBackupBeforeNoticeService
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
            java.lang.String r4 = "HiCloudBackupBeforeNotice"
            long r4 = p459lp.C11327e.m68063f(r4)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L64
            java.lang.String r0 = "version updated, query config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r0)
            r7.executeRequestConfig()
            r7 = 1
            return r7
        L64:
            java.lang.String r2 = "version not updated, extract sync module config"
            com.huawei.hicloud.notification.log.NotifyLogger.m29915i(r1, r2)
            r7.extractLanguage()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.manager.BackupBeforeNoticeManager.requestConfig():boolean");
    }

    private BackupBeforeNoticeManager() {
        this.mBackupBeforeNoticeService = new BackupBeforeNoticeServiceV3(null);
    }
}
