package com.huawei.hicloud.notification.manager;

import android.content.Intent;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.hicloud.bean.DriveConfig;
import com.huawei.hicloud.bean.DriveConfigLanguage;
import com.huawei.hicloud.bean.DriveConfigService;
import com.huawei.hicloud.download.C4896a;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.DriveConfigVo;
import com.huawei.hicloud.notification.p106db.operator.DriveConfigLanguageOperator;
import com.huawei.hicloud.notification.p106db.operator.DriveConfigOperator;
import com.huawei.hicloud.notification.syncconfig.IServiceIconDownload;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mk.C11476b;
import p015ak.C0212e0;
import p015ak.C0213f;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p664u0.C13108a;

/* loaded from: classes6.dex */
public class DriveModuleConfigManager {
    private static final int DB_TASK_NUM = 1;
    private static final int GALLERY_ICON_TASK_NUM = 1;
    private static final DriveModuleConfigManager INSTANCE = new DriveModuleConfigManager();
    private static final int MAX_FAIL_RETRY = 2;
    private static final long MAX_TASK_WAIT_TIME = 15000;
    private static final int RES_TASK_NUM = 2;
    private static final long RETRY_INTERVAL = 5000;
    private static final String TAG = "DriveModuleConfigManager";
    private CountDownLatch dbLatch;
    private CountDownLatch mDevConfInitTaskLatch;
    private CountDownLatch mResTaskLatch;

    public static class IconDownloadTask extends AbstractC12367d {
        private static final String TAG = "IconDownloadTask";
        private boolean isSubPageIcon;
        private IServiceIconDownload mCallback;
        private CountDownLatch mLatch;
        private String mServiceName;
        private String mUrl;

        public IconDownloadTask(IServiceIconDownload iServiceIconDownload, CountDownLatch countDownLatch, String str, String str2, boolean z10) {
            this.mCallback = iServiceIconDownload;
            this.mLatch = countDownLatch;
            this.mServiceName = str;
            this.mUrl = str2;
            this.isSubPageIcon = z10;
        }

        private void latchCountDown() {
            CountDownLatch countDownLatch = this.mLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws InterruptedException {
            String str;
            NotifyLogger.m29915i(TAG, "IconDownloadTask call start:" + this.mServiceName);
            if (this.isSubPageIcon) {
                str = C0213f.m1377a().getFilesDir() + "/driveConfig/subPageIcon/" + this.mServiceName;
            } else {
                str = C0213f.m1377a().getFilesDir() + "/driveConfig/icon/" + this.mServiceName;
            }
            C4896a c4896a = new C4896a(this.mUrl, str, 0L);
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= 2) {
                    break;
                }
                try {
                    NotifyUtil.downloadFileToPath(str, c4896a.getUrl(), c4896a);
                } catch (C9721b e10) {
                    NotifyLogger.m29914e(TAG, "IconDownloadTask download icon failed:" + e10.toString());
                    try {
                        Thread.sleep(5000L);
                    } catch (InterruptedException e11) {
                        NotifyLogger.m29914e(TAG, "IconDownloadTask download icon exception:" + e11.toString());
                    }
                }
                if (new File(str).exists()) {
                    NotifyLogger.m29915i(TAG, "IconDownloadTask download icon success");
                    z10 = true;
                    break;
                } else {
                    continue;
                    i10++;
                }
            }
            if (new File(str).exists() && z10) {
                this.mCallback.downloadFinish(this.mServiceName, str);
                this.mCallback = null;
            } else {
                NotifyLogger.m29914e(TAG, "IconDownloadTask download picture to local failed");
            }
            latchCountDown();
            NotifyLogger.m29915i(TAG, "IconDownloadTask call end:" + this.mServiceName);
        }

        public void clear() {
            this.mServiceName = null;
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.DRIVE_CONFIG;
        }
    }

    public class IconTask extends AbstractC12367d implements IServiceIconDownload {
        private boolean isSubPageIcon;
        private DriveConfigService[] mDriveConfigServices;
        private CountDownLatch mIconLatch;
        private ResourceDownLoadHolder mResultHolder;
        private Map<String, String> iconMap = new HashMap();
        private boolean isSuccess = false;

        public IconTask(DriveConfigService[] driveConfigServiceArr, ResourceDownLoadHolder resourceDownLoadHolder, boolean z10) {
            this.mDriveConfigServices = driveConfigServiceArr;
            this.mResultHolder = resourceDownLoadHolder;
            this.isSubPageIcon = z10;
        }

        private void latchAwait() throws InterruptedException {
            if (this.mIconLatch.await(DriveModuleConfigManager.MAX_TASK_WAIT_TIME, TimeUnit.MILLISECONDS)) {
                NotifyLogger.m29915i(DriveModuleConfigManager.TAG, "IconTask finished");
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                NotifyLogger.m29915i(DriveModuleConfigManager.TAG, "IconTask call start");
                DriveConfigService[] driveConfigServiceArr = this.mDriveConfigServices;
                if (driveConfigServiceArr != null && driveConfigServiceArr.length > 0) {
                    this.mIconLatch = new CountDownLatch(this.mDriveConfigServices.length);
                    for (DriveConfigService driveConfigService : this.mDriveConfigServices) {
                        String icon = "";
                        if (!this.isSubPageIcon) {
                            icon = driveConfigService.getIcon();
                        } else if (driveConfigService.getDriveConfigServiceResource() != null) {
                            icon = driveConfigService.getDriveConfigServiceResource().getSubPageIcon();
                        }
                        String str = icon;
                        if (TextUtils.isEmpty(str)) {
                            NotifyLogger.m29915i(DriveModuleConfigManager.TAG, "iconUrl is null");
                            this.mIconLatch.countDown();
                        } else if (URLUtil.isHttpsUrl(str)) {
                            C12515a.m75110o().m75175e(new IconDownloadTask(this, this.mIconLatch, driveConfigService.getId(), str, this.isSubPageIcon), false);
                        } else {
                            NotifyLogger.m29915i(DriveModuleConfigManager.TAG, "iconUrl not https");
                            this.mIconLatch.countDown();
                        }
                    }
                    latchAwait();
                    if (this.iconMap.size() != 0) {
                        for (DriveConfigService driveConfigService2 : this.mDriveConfigServices) {
                            String str2 = this.iconMap.get(driveConfigService2.getId());
                            if (this.isSubPageIcon) {
                                driveConfigService2.setSubPageIconPath(str2);
                            } else {
                                driveConfigService2.setIconPath(str2);
                            }
                        }
                        this.isSuccess = true;
                    }
                }
                NotifyLogger.m29915i(DriveModuleConfigManager.TAG, "IconTask call end");
            } catch (Exception e10) {
                NotifyLogger.m29914e(DriveModuleConfigManager.TAG, "IconTask exception:" + e10.toString());
            }
            this.mResultHolder.setDownloadResult(this.isSuccess);
            DriveModuleConfigManager.this.mResTaskLatch.countDown();
        }

        @Override // com.huawei.hicloud.notification.syncconfig.IServiceIconDownload
        public void downloadFinish(String str, String str2) {
            synchronized (this) {
                NotifyLogger.m29915i(DriveModuleConfigManager.TAG, "downloadFinish: " + str + " isSubPageIcon:" + this.isSubPageIcon);
                this.iconMap.put(str, str2);
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.DRIVE_CONFIG;
        }
    }

    public class LanguageTask extends AbstractC12367d {
        private boolean isSuccess = false;
        private DriveConfigLanguage mLanguage;
        private ResourceDownLoadHolder mResultHolder;
        private String xmlPath;

        public LanguageTask(DriveConfigLanguage driveConfigLanguage, ResourceDownLoadHolder resourceDownLoadHolder) {
            this.mLanguage = driveConfigLanguage;
            this.mResultHolder = resourceDownLoadHolder;
        }

        private String generateFileHash() {
            try {
                File fileM63442h = C10278a.m63442h(this.xmlPath);
                return fileM63442h.exists() ? C11476b.m68622d(fileM63442h).getHash() : "";
            } catch (Exception e10) {
                NotifyLogger.m29914e(DriveModuleConfigManager.TAG, "generateFileHash exceptions:" + e10.toString());
                return "";
            }
        }

        private void sleepSeconds() throws InterruptedException {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e10) {
                NotifyLogger.m29914e(DriveModuleConfigManager.TAG, "LanguageTask sleep exception:" + e10.toString());
            }
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws Throwable {
            String url;
            NotifyLogger.m29915i(DriveModuleConfigManager.TAG, "LanguageTask call start");
            if (this.mLanguage != null) {
                this.xmlPath = C0213f.m1377a().getFilesDir() + "/driveConfig/string/drive_config_strings.xml";
                File file = new File(this.xmlPath);
                if (file.delete()) {
                    NotifyLogger.m29915i(DriveModuleConfigManager.TAG, "parseLanguageXml tmpFile delete true!");
                }
                String strGenerateFileHash = generateFileHash();
                NotifyLogger.m29913d(DriveModuleConfigManager.TAG, "xmlPath = " + this.xmlPath);
                NotifyLogger.m29913d(DriveModuleConfigManager.TAG, "local language hash：" + strGenerateFileHash);
                NotifyLogger.m29913d(DriveModuleConfigManager.TAG, "cloud language hash：" + this.mLanguage.getHash());
                C4896a c4896a = new C4896a(this.mLanguage.getUrl(), this.xmlPath, 0L);
                this.isSuccess = false;
                for (int i10 = 0; i10 < 2; i10++) {
                    try {
                        url = c4896a.getUrl();
                    } catch (C9721b e10) {
                        e = e10;
                    }
                    if (TextUtils.isEmpty(url)) {
                        NotifyLogger.m29916w(DriveModuleConfigManager.TAG, "langUrl null");
                    } else if (URLUtil.isHttpsUrl(url)) {
                        NotifyUtil.downloadFileToPath(this.xmlPath, url, c4896a);
                        File file2 = new File(this.xmlPath);
                        try {
                        } catch (C9721b e11) {
                            e = e11;
                            file = file2;
                            NotifyLogger.m29914e(DriveModuleConfigManager.TAG, "download language failed:" + e.toString());
                            sleepSeconds();
                        }
                        if (file2.exists()) {
                            NotifyLogger.m29915i(DriveModuleConfigManager.TAG, "download language xml success");
                            file = file2;
                        } else {
                            file = file2;
                        }
                    } else {
                        NotifyLogger.m29916w(DriveModuleConfigManager.TAG, "langUrl not https");
                    }
                }
                try {
                    String strGenerateFileHash2 = generateFileHash();
                    NotifyLogger.m29913d(DriveModuleConfigManager.TAG, "download local language file hash ：" + strGenerateFileHash2);
                    if (TextUtils.isEmpty(this.mLanguage.getHash()) || this.mLanguage.getHash().equals(strGenerateFileHash2)) {
                        DriveModuleConfigManager.this.clearLanguageDb();
                        DriveModuleConfigManager.this.parseLanguageXml(this.xmlPath);
                        DriveModuleConfigManager.this.setCurrentLanguageVersion(this.mLanguage.getVersion());
                        DriveModuleConfigManager.this.setCurrentLanguageHash(this.mLanguage.getHash());
                        this.isSuccess = true;
                    } else {
                        NotifyLogger.m29916w(DriveModuleConfigManager.TAG, "file hash error : server language hash is not equals to download file");
                        if (!file.delete()) {
                            NotifyLogger.m29916w(DriveModuleConfigManager.TAG, "tmp config file is delete failed");
                        }
                        this.isSuccess = false;
                    }
                } catch (Exception e12) {
                    NotifyLogger.m29914e(DriveModuleConfigManager.TAG, "parseLanguageXml exception:" + e12.toString());
                }
            } else {
                NotifyLogger.m29916w(DriveModuleConfigManager.TAG, "LanguageTask language null");
            }
            this.mResultHolder.setDownloadResult(this.isSuccess);
            DriveModuleConfigManager.this.mResTaskLatch.countDown();
            NotifyLogger.m29915i(DriveModuleConfigManager.TAG, "LanguageTask call end");
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.DRIVE_CONFIG;
        }
    }

    public class WriteConfigToDbTask extends AbstractC12367d {
        private DriveConfig mDriveConfig;

        public WriteConfigToDbTask(DriveConfig driveConfig) {
            this.mDriveConfig = driveConfig;
        }

        private List<DriveConfigVo> getDriveConfigVo() {
            DriveConfigService[] driveConfigService = this.mDriveConfig.getDriveConfigService();
            if (driveConfigService.length <= 0) {
                return null;
            }
            NotifyLogger.m29915i(DriveModuleConfigManager.TAG, "getDriveConfigVo");
            ArrayList arrayList = new ArrayList();
            for (DriveConfigService driveConfigService2 : driveConfigService) {
                DriveConfigVo driveConfigVo = new DriveConfigVo();
                driveConfigVo.setId(driveConfigService2.getId());
                driveConfigVo.setAppId(NotifyUtil.getSpiltStr(driveConfigService2.getAppId()));
                driveConfigVo.setPkgNames(NotifyUtil.getSpiltStr(driveConfigService2.getPkgNames()));
                driveConfigVo.setSignHash(NotifyUtil.getSpiltStr(driveConfigService2.getSignHash()));
                driveConfigVo.setIcon(driveConfigService2.getIcon());
                driveConfigVo.setStyle(driveConfigService2.getStyle());
                driveConfigVo.setName(driveConfigService2.getName());
                if (driveConfigService2.getDriveConfigServiceResource() != null) {
                    driveConfigVo.setSubPageIcon(driveConfigService2.getDriveConfigServiceResource().getSubPageIcon());
                    driveConfigVo.setSubDesc(driveConfigService2.getDriveConfigServiceResource().getSubDesc());
                    driveConfigVo.setSubSwitchDesc(driveConfigService2.getDriveConfigServiceResource().getSubSwitchDesc());
                }
                driveConfigVo.setMinSyncVersion(driveConfigService2.getMinSyncVersion());
                if (driveConfigService2.isRecord()) {
                    driveConfigVo.setRecord(FaqConstants.DISABLE_HA_REPORT);
                } else {
                    driveConfigVo.setRecord("false");
                }
                driveConfigVo.setRecordIndex(driveConfigService2.getRecordIndex());
                driveConfigVo.setVersion(driveConfigService2.getVersion());
                driveConfigVo.setIconPath(driveConfigService2.getIconPath());
                driveConfigVo.setSubPageIconPath(driveConfigService2.getSubPageIconPath());
                if (driveConfigService2.isSubUser()) {
                    driveConfigVo.setSubUser(FaqConstants.DISABLE_HA_REPORT);
                } else {
                    driveConfigVo.setSubUser("false");
                }
                arrayList.add(driveConfigVo);
            }
            return arrayList;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            NotifyLogger.m29915i(DriveModuleConfigManager.TAG, "WriteConfigToDbTask call start");
            try {
                DriveConfigOperator driveConfigOperator = new DriveConfigOperator();
                List<DriveConfigVo> driveConfigVo = getDriveConfigVo();
                if (driveConfigVo != null && driveConfigVo.size() != 0) {
                    driveConfigOperator.batchInsert(driveConfigVo);
                }
            } catch (Exception e10) {
                NotifyLogger.m29914e(DriveModuleConfigManager.TAG, "configOperator batchInsert exception:" + e10.toString());
            }
            DriveModuleConfigManager.this.dbLatch.countDown();
            NotifyLogger.m29915i(DriveModuleConfigManager.TAG, "WriteConfigToDbTask call end");
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.DRIVE_CONFIG;
        }
    }

    private String getCurrentLanguageHash() {
        String strM1363m = C0212e0.m1363m(C0213f.m1377a(), "driveConfig", "driveConfig_language_hash", "");
        NotifyLogger.m29915i(TAG, "currentHash = " + strM1363m);
        return strM1363m;
    }

    private int getCurrentLanguageVersion() {
        int iM1357g = C0212e0.m1357g(C0213f.m1377a(), "driveConfig", "driveConfig_language_version", 0);
        NotifyLogger.m29915i(TAG, "currentVersion = " + iM1357g);
        return iM1357g;
    }

    public static DriveModuleConfigManager getInstance() {
        return INSTANCE;
    }

    private void notifyDriveConfigParseFinish() {
        C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("action_drive_parse_config_finish"));
    }

    private void safeClose(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                NotifyLogger.m29914e(TAG, "safeClose exceptions:" + e10.toString());
            }
        }
    }

    public void setCurrentLanguageHash(String str) {
        C0212e0.m1372v(C0213f.m1377a(), "driveConfig", "driveConfig_language_hash", str);
    }

    public void setCurrentLanguageVersion(int i10) {
        C0212e0.m1368r(C0213f.m1377a(), "driveConfig", "driveConfig_language_version", i10);
    }

    public void checkLanguageDataBase(DriveConfig driveConfig) throws Throwable {
        if (driveConfig == null) {
            NotifyLogger.m29916w(TAG, "checkDriveConfigDataBase, no driveConfig");
            return;
        }
        if (driveConfig.getDriveConfigLanguage() == null) {
            NotifyLogger.m29914e(TAG, "checkDriveLanguageDataBase, language null");
            return;
        }
        String str = C0213f.m1377a().getFilesDir() + "/driveConfig/string/drive_config_strings.xml";
        if (!new File(str).exists() || new DriveConfigLanguageOperator().hasRecord()) {
            return;
        }
        NotifyLogger.m29915i(TAG, "checkDriveLanguageDataBase, need parseLanguageXml");
        parseLanguageXml(str);
    }

    public void clearDB() {
        synchronized (this) {
            clearDriveConfigAndDataDb();
            clearLanguageDb();
        }
    }

    public void clearDriveConfigAndDataDb() {
        new DriveConfigOperator().clear();
    }

    public void clearLanguageDb() {
        new DriveConfigLanguageOperator().clear();
    }

    public List<DriveConfigService> getDriveServicesFromDb() {
        ArrayList arrayList;
        synchronized (this) {
            try {
                List<DriveConfigService> allServices = new DriveConfigOperator().getAllServices();
                arrayList = new ArrayList();
                for (DriveConfigService driveConfigService : allServices) {
                    if (NotifyUtil.isDriveSerivceResourcOk(driveConfigService)) {
                        arrayList.add(driveConfigService);
                    }
                }
                NotifyLogger.m29915i(TAG, "getDriveServicesFromDb, size = " + allServices.size());
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return arrayList;
    }

    public void parseDriveConfig(DriveConfig driveConfig) {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        DriveConfigLanguage driveConfigLanguage;
        if (driveConfig == null) {
            NotifyLogger.m29915i(TAG, "driveConfig null");
            return;
        }
        this.mResTaskLatch = new CountDownLatch(2);
        NotifyLogger.m29915i(TAG, "parseDriveConfig start");
        try {
            try {
                driveConfigLanguage = driveConfig.getDriveConfigLanguage();
            } catch (Exception e10) {
                NotifyLogger.m29914e(TAG, "exception:" + e10.toString());
                countDownLatch2 = this.mDevConfInitTaskLatch;
                if (countDownLatch2 != null) {
                }
            }
            if (driveConfigLanguage == null) {
                NotifyLogger.m29916w(TAG, "language null");
                if (countDownLatch != null) {
                    return;
                } else {
                    return;
                }
            }
            ResourceDownLoadHolder resourceDownLoadHolder = new ResourceDownLoadHolder();
            int currentLanguageVersion = getCurrentLanguageVersion();
            String currentLanguageHash = getCurrentLanguageHash();
            NotifyLogger.m29915i(TAG, "current language version is: " + currentLanguageVersion + ", OM file language version is: " + driveConfigLanguage.getVersion() + "current language hash is: " + currentLanguageHash + ", OM file language hash is: " + driveConfigLanguage.getHash());
            if (currentLanguageVersion == 0 || TextUtils.isEmpty(currentLanguageHash) || (currentLanguageVersion < driveConfigLanguage.getVersion() && !TextUtils.equals(currentLanguageHash, driveConfigLanguage.getHash()))) {
                C12515a.m75110o().m75172d(new LanguageTask(driveConfigLanguage, resourceDownLoadHolder));
            } else {
                resourceDownLoadHolder.setDownloadResult(true);
                this.mResTaskLatch.countDown();
            }
            ResourceDownLoadHolder resourceDownLoadHolder2 = new ResourceDownLoadHolder();
            C12515a.m75110o().m75172d(new IconTask(driveConfig.getDriveConfigService(), resourceDownLoadHolder2, false));
            CountDownLatch countDownLatch3 = this.mResTaskLatch;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            if (countDownLatch3.await(MAX_TASK_WAIT_TIME, timeUnit)) {
                NotifyLogger.m29915i(TAG, "all res task finished");
            }
            boolean result = resourceDownLoadHolder.getResult();
            boolean result2 = resourceDownLoadHolder2.getResult();
            NotifyLogger.m29915i(TAG, "resources download finished, isLanguageSuccess=" + result + ",isIconSuccess=" + result2);
            if (result && result2) {
                this.mResTaskLatch = new CountDownLatch(1);
                ResourceDownLoadHolder resourceDownLoadHolder3 = new ResourceDownLoadHolder();
                C12515a.m75110o().m75172d(new IconTask(driveConfig.getDriveConfigService(), resourceDownLoadHolder3, true));
                if (this.mResTaskLatch.await(MAX_TASK_WAIT_TIME, timeUnit)) {
                    NotifyLogger.m29915i(TAG, "subPageIconTask finished");
                }
                NotifyLogger.m29915i(TAG, "isSubPageIconResultSuccess " + resourceDownLoadHolder3.getResult());
                clearDriveConfigAndDataDb();
                this.dbLatch = new CountDownLatch(1);
                C12515a.m75110o().m75172d(new WriteConfigToDbTask(driveConfig));
                if (this.dbLatch.await(MAX_TASK_WAIT_TIME, timeUnit)) {
                    NotifyLogger.m29915i(TAG, "db task finished");
                }
                notifyDriveConfigParseFinish();
            }
            countDownLatch2 = this.mDevConfInitTaskLatch;
            if (countDownLatch2 != null) {
                countDownLatch2.countDown();
            }
            NotifyLogger.m29915i(TAG, "parseDriveConfig end");
        } finally {
            countDownLatch = this.mDevConfInitTaskLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void parseLanguageXml(java.lang.String r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r10)
            boolean r10 = r0.exists()
            java.lang.String r1 = "DriveModuleConfigManager"
            if (r10 != 0) goto L13
            java.lang.String r9 = "language xml not exist"
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r1, r9)
            return
        L13:
            r10 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> La1
            org.xmlpull.v1.XmlPullParser r0 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            java.lang.String r3 = "utf-8"
            r0.setInput(r2, r3)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            int r3 = r0.getEventType()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            java.lang.String r4 = ""
        L28:
            r5 = 1
            if (r3 == r5) goto L99
            java.lang.String r5 = r0.getName()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            r6 = 2
            java.lang.String r7 = "text"
            java.lang.String r8 = "resource"
            if (r3 == r6) goto L59
            r6 = 3
            if (r3 == r6) goto L3a
            goto L94
        L3a:
            boolean r3 = r8.equals(r5)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            if (r3 != 0) goto L94
            boolean r3 = r7.equals(r5)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            if (r3 != 0) goto L94
            if (r10 == 0) goto L94
            com.huawei.hicloud.notification.db.operator.DriveConfigLanguageOperator r3 = new com.huawei.hicloud.notification.db.operator.DriveConfigLanguageOperator     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            r3.<init>()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            r3.batchInsert(r10)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            r10.clear()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            goto L94
        L54:
            r10 = move-exception
            goto Lc0
        L57:
            r10 = move-exception
            goto La4
        L59:
            boolean r3 = r8.equals(r5)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            if (r3 == 0) goto L65
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            r10.<init>()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            goto L94
        L65:
            boolean r3 = r7.equals(r5)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            if (r3 == 0) goto L93
            com.huawei.hicloud.notification.db.bean.SyncConfigString r3 = new com.huawei.hicloud.notification.db.bean.SyncConfigString     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            r3.<init>()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            java.lang.String r5 = r0.getNamespace()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            java.lang.String r6 = "name"
            java.lang.String r5 = r0.getAttributeValue(r5, r6)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            r3.setName(r5)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            java.lang.String r5 = r0.getNamespace()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            java.lang.String r6 = "value"
            java.lang.String r5 = r0.getAttributeValue(r5, r6)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            r3.setValue(r5)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            r3.setCountry(r4)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            if (r10 == 0) goto L94
            r10.add(r3)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            goto L94
        L93:
            r4 = r5
        L94:
            int r3 = r0.next()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            goto L28
        L99:
            r9.safeClose(r2)
            goto Lbf
        L9d:
            r0 = move-exception
            r2 = r10
            r10 = r0
            goto Lc0
        La1:
            r0 = move-exception
            r2 = r10
            r10 = r0
        La4:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54
            r0.<init>()     // Catch: java.lang.Throwable -> L54
            java.lang.String r3 = "parseLanguageXml exception:"
            r0.append(r3)     // Catch: java.lang.Throwable -> L54
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L54
            r0.append(r10)     // Catch: java.lang.Throwable -> L54
            java.lang.String r10 = r0.toString()     // Catch: java.lang.Throwable -> L54
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r1, r10)     // Catch: java.lang.Throwable -> L54
            if (r2 == 0) goto Lbf
            goto L99
        Lbf:
            return
        Lc0:
            if (r2 == 0) goto Lc5
            r9.safeClose(r2)
        Lc5:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.manager.DriveModuleConfigManager.parseLanguageXml(java.lang.String):void");
    }

    public static class ResourceDownLoadHolder {
        private boolean mResult;

        private ResourceDownLoadHolder() {
            this.mResult = false;
        }

        public boolean getResult() {
            return this.mResult;
        }

        public void setDownloadResult(boolean z10) {
            this.mResult = z10;
        }

        public /* synthetic */ ResourceDownLoadHolder(C49181 c49181) {
            this();
        }
    }

    public DriveConfigService getDriveServicesFromDb(String str) {
        synchronized (this) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                List<DriveConfigService> allServices = new DriveConfigOperator().getAllServices();
                if (allServices.size() > 0) {
                    DriveConfigService serviceById = new DriveConfigOperator().getServiceById(str);
                    for (DriveConfigService driveConfigService : allServices) {
                        if (str.equals(driveConfigService.getId()) && NotifyUtil.isDriveSerivceResourcOk(driveConfigService)) {
                            return serviceById;
                        }
                    }
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void parseDriveConfig(DriveConfig driveConfig, CountDownLatch countDownLatch) {
        this.mDevConfInitTaskLatch = countDownLatch;
        parseDriveConfig(driveConfig);
    }
}
