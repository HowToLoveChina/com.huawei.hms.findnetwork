package com.huawei.hicloud.notification.manager;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.hicloud.bean.SyncConfig;
import com.huawei.hicloud.bean.SyncConfigLanguage;
import com.huawei.hicloud.bean.SyncConfigService;
import com.huawei.hicloud.bean.SyncConfigServiceDataType;
import com.huawei.hicloud.download.C4896a;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.SyncConfigVo;
import com.huawei.hicloud.notification.p106db.operator.SyncConfigDataTypeOperator;
import com.huawei.hicloud.notification.p106db.operator.SyncConfigLanguageOperator;
import com.huawei.hicloud.notification.p106db.operator.SyncConfigOperator;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mk.C11476b;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p015ak.C0227m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p664u0.C13108a;

/* loaded from: classes6.dex */
public class SyncModuleConfigManager {
    private static final int DB_TASK_NUM = 1;
    private static final SyncModuleConfigManager INSTANCE = new SyncModuleConfigManager();
    private static final int MAX_FAIL_RETRY = 2;
    private static final long MAX_TASK_WAIT_TIME = 15000;
    private static final int RES_TASK_NUM = 2;
    private static final long RETRY_INTERVAL = 5000;
    private static final String TAG = "SyncModuleConfigManager";
    private CountDownLatch dbLatch;
    private boolean isFinished = true;
    private CountDownLatch mDevConfInitTaskLatch;
    private CountDownLatch resTaskLatch;

    public static class IconDownloadTask extends AbstractC12367d {
        private static final String TAG = "IconDownloadTask";
        private IServiceIconDownload mCallback;
        private CountDownLatch mLatch;
        private String mServiceName;
        private String mUrl;

        public IconDownloadTask(IServiceIconDownload iServiceIconDownload, CountDownLatch countDownLatch, String str, String str2) {
            this.mCallback = iServiceIconDownload;
            this.mLatch = countDownLatch;
            this.mServiceName = str;
            this.mUrl = str2;
        }

        private boolean renameTempFile(boolean z10, String str, String str2) throws Throwable {
            File file = new File(str);
            if (!file.exists() || !z10) {
                NotifyLogger.m29914e(TAG, "download picture to temp failed, delete file result: " + file.delete());
                return false;
            }
            File file2 = new File(str2);
            if (file2.exists()) {
                try {
                    String strM1591d = C0227m.m1591d(str2);
                    String strM1591d2 = C0227m.m1591d(str);
                    if (strM1591d != null && strM1591d.equals(strM1591d2)) {
                        NotifyLogger.m29915i(TAG, "verifyTempFile tmp file hash equals local file");
                        return true;
                    }
                } catch (C9721b e10) {
                    NotifyLogger.m29914e(TAG, "verifyTempFile get file hash exception: " + e10.toString());
                }
                NotifyLogger.m29913d(TAG, "verifyTempFile delete icon file, result: " + file2.delete());
            }
            return file.renameTo(file2);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws InterruptedException {
            NotifyLogger.m29915i(TAG, "IconDownloadTask call start:" + this.mServiceName);
            String str = C0213f.m1377a().getFilesDir() + "/syncConfig/icon/" + this.mServiceName;
            String str2 = str + "_tmp";
            C4896a c4896a = new C4896a(this.mUrl, str2, 0L);
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= 2) {
                    break;
                }
                try {
                    NotifyUtil.downloadFileToPath(str2, c4896a.getUrl(), c4896a);
                } catch (C9721b e10) {
                    NotifyLogger.m29914e(TAG, "download icon failed:" + e10.toString());
                    try {
                        Thread.sleep(5000L);
                    } catch (InterruptedException e11) {
                        NotifyLogger.m29914e(TAG, "download icon exception:" + e11.toString());
                    }
                }
                if (new File(str2).exists()) {
                    NotifyLogger.m29915i(TAG, "download icon success");
                    z10 = true;
                    break;
                } else {
                    continue;
                    i10++;
                }
            }
            if (renameTempFile(z10, str2, str)) {
                this.mCallback.downloadFinish(this.mServiceName, str);
                this.mCallback = null;
            } else {
                NotifyLogger.m29914e(TAG, "download picture to local failed");
            }
            CountDownLatch countDownLatch = this.mLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            NotifyLogger.m29915i(TAG, "IconDownloadTask call end:" + this.mServiceName);
        }

        public void clear() {
            this.mServiceName = null;
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.SYNC_CONFIG;
        }
    }

    public class IconTask extends AbstractC12367d implements IServiceIconDownload {
        private Map<String, String> iconMap = new HashMap();
        private boolean isSuccess = false;
        private CountDownLatch mIconLatch;
        private ResourceDownLoadHolder mResultHolder;
        private SyncConfigService[] mServices;

        public IconTask(SyncConfigService[] syncConfigServiceArr, ResourceDownLoadHolder resourceDownLoadHolder) {
            this.mServices = syncConfigServiceArr;
            this.mResultHolder = resourceDownLoadHolder;
        }

        /* JADX WARN: Removed duplicated region for block: B:72:0x008d A[Catch: Exception -> 0x007b, TryCatch #0 {Exception -> 0x007b, blocks: (B:54:0x0002, B:56:0x000b, B:58:0x000e, B:60:0x0024, B:62:0x0030, B:64:0x003e, B:66:0x006e, B:77:0x00bb, B:69:0x007e, B:70:0x0083, B:72:0x008d, B:73:0x0098, B:75:0x009e, B:76:0x00a9, B:78:0x00bf, B:80:0x00cb, B:81:0x00d0, B:83:0x00d8, B:85:0x00e3, B:87:0x00e6, B:88:0x00fa, B:89:0x00fd), top: B:94:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0098 A[Catch: Exception -> 0x007b, TryCatch #0 {Exception -> 0x007b, blocks: (B:54:0x0002, B:56:0x000b, B:58:0x000e, B:60:0x0024, B:62:0x0030, B:64:0x003e, B:66:0x006e, B:77:0x00bb, B:69:0x007e, B:70:0x0083, B:72:0x008d, B:73:0x0098, B:75:0x009e, B:76:0x00a9, B:78:0x00bf, B:80:0x00cb, B:81:0x00d0, B:83:0x00d8, B:85:0x00e3, B:87:0x00e6, B:88:0x00fa, B:89:0x00fd), top: B:94:0x0002 }] */
        @Override // p616rk.AbstractRunnableC12516b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void call() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 300
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.manager.SyncModuleConfigManager.IconTask.call():void");
        }

        @Override // com.huawei.hicloud.notification.syncconfig.IServiceIconDownload
        public void downloadFinish(String str, String str2) {
            synchronized (this) {
                NotifyLogger.m29915i(SyncModuleConfigManager.TAG, "downloadFinish: " + str);
                this.iconMap.put(str, str2);
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.SYNC_CONFIG;
        }
    }

    public class LanguageTask extends AbstractC12367d {
        private boolean mIsSuccess = false;
        private SyncConfigLanguage mLanguage;
        private ResourceDownLoadHolder mResultHolder;
        private String xmlPath;

        public LanguageTask(SyncConfigLanguage syncConfigLanguage, ResourceDownLoadHolder resourceDownLoadHolder) {
            this.mLanguage = syncConfigLanguage;
            this.mResultHolder = resourceDownLoadHolder;
        }

        private String generateFileHash() {
            try {
                File fileM63442h = C10278a.m63442h(this.xmlPath);
                return fileM63442h.exists() ? C11476b.m68622d(fileM63442h).getHash() : "";
            } catch (Exception e10) {
                NotifyLogger.m29914e(SyncModuleConfigManager.TAG, "generateFileHash exceptions:" + e10.toString());
                return "";
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object, java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v23 */
        /* JADX WARN: Type inference failed for: r2v24 */
        /* JADX WARN: Type inference failed for: r2v25 */
        /* JADX WARN: Type inference failed for: r2v26 */
        /* JADX WARN: Type inference failed for: r2v8, types: [com.huawei.hicloud.download.a] */
        /* JADX WARN: Type inference failed for: r2v9 */
        /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r4v17, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v10 */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v3, types: [int] */
        /* JADX WARN: Type inference failed for: r5v5 */
        /* JADX WARN: Type inference failed for: r5v6 */
        /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r5v8 */
        /* JADX WARN: Type inference failed for: r5v9 */
        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws Throwable {
            String url;
            C9721b e10;
            NotifyLogger.m29915i(SyncModuleConfigManager.TAG, "LanguageTask call start");
            if (this.mLanguage != null) {
                this.xmlPath = C0213f.m1377a().getFilesDir() + "/syncConfig/string/sync_config_strings.xml";
                File file = new File(this.xmlPath);
                String strGenerateFileHash = generateFileHash();
                NotifyLogger.m29913d(SyncModuleConfigManager.TAG, "xmlPath = " + this.xmlPath);
                NotifyLogger.m29913d(SyncModuleConfigManager.TAG, "local language hash：" + strGenerateFileHash);
                NotifyLogger.m29913d(SyncModuleConfigManager.TAG, "cloud language hash：" + this.mLanguage.getHash());
                boolean zIsEmpty = true;
                if (!TextUtils.isEmpty(this.mLanguage.getHash()) && this.mLanguage.getHash().equals(strGenerateFileHash)) {
                    try {
                        SyncModuleConfigManager.this.clearLanguageDb();
                        SyncModuleConfigManager.this.parseLanguageXml(this.xmlPath);
                    } catch (Exception e11) {
                        NotifyLogger.m29914e(SyncModuleConfigManager.TAG, "parseLanguageXml mLanguage.getHash().equals(generateFileHash()) exception:" + e11.toString());
                    }
                    this.mResultHolder.setDownloadResult(true);
                    SyncModuleConfigManager.this.resTaskLatch.countDown();
                    NotifyLogger.m29915i(SyncModuleConfigManager.TAG, "LanguageTask call mLanguage.getHash().equals(generateFileHash()) end");
                    return;
                }
                if (file.delete()) {
                    NotifyLogger.m29915i(SyncModuleConfigManager.TAG, "parseLanguageXml tmpFile delete true!");
                }
                C4896a c4896a = new C4896a(this.mLanguage.getUrl(), this.xmlPath, 0L);
                this.mIsSuccess = false;
                ?? r52 = 0;
                ?? GenerateFileHash = c4896a;
                while (true) {
                    if (r52 < 2) {
                        try {
                            url = GenerateFileHash.getUrl();
                        } catch (C9721b e12) {
                            e10 = e12;
                            GenerateFileHash = GenerateFileHash;
                            r52 = r52;
                        }
                        if (TextUtils.isEmpty(url)) {
                            NotifyLogger.m29916w(SyncModuleConfigManager.TAG, "LanguageTask langUrl null");
                        } else if (URLUtil.isHttpsUrl(url)) {
                            NotifyUtil.downloadFileToPath(this.xmlPath, url, GenerateFileHash);
                            File file2 = new File(this.xmlPath);
                            try {
                            } catch (C9721b e13) {
                                e10 = e13;
                                file = file2;
                                GenerateFileHash = GenerateFileHash;
                                r52 = r52;
                                NotifyLogger.m29914e(SyncModuleConfigManager.TAG, "LanguageTask download language failed:" + e10.toString());
                                try {
                                    Thread.sleep(5000L);
                                } catch (InterruptedException e14) {
                                    NotifyLogger.m29914e(SyncModuleConfigManager.TAG, "LanguageTask sleep exception:" + e14.toString());
                                }
                                GenerateFileHash = GenerateFileHash;
                                r52++;
                            }
                            if (file2.exists()) {
                                NotifyLogger.m29915i(SyncModuleConfigManager.TAG, "LanguageTask download language xml success");
                                this.mIsSuccess = zIsEmpty;
                                file = file2;
                            } else {
                                file = file2;
                                GenerateFileHash = GenerateFileHash;
                                r52++;
                            }
                        } else {
                            NotifyLogger.m29916w(SyncModuleConfigManager.TAG, "LanguageTask langUrl not https");
                        }
                    }
                    try {
                        GenerateFileHash = generateFileHash();
                        ?? sb2 = new StringBuilder();
                        r52 = "download local language hash：";
                        sb2.append("download local language hash：");
                        sb2.append(GenerateFileHash);
                        NotifyLogger.m29913d(SyncModuleConfigManager.TAG, sb2.toString());
                        zIsEmpty = TextUtils.isEmpty(this.mLanguage.getHash());
                        break;
                    } catch (Exception e15) {
                        NotifyLogger.m29914e(SyncModuleConfigManager.TAG, "parseLanguageXml exception:" + e15.toString());
                    }
                }
                if (zIsEmpty || this.mLanguage.getHash().equals(GenerateFileHash)) {
                    SyncModuleConfigManager.this.clearLanguageDb();
                    SyncModuleConfigManager.this.parseLanguageXml(this.xmlPath);
                    SyncModuleConfigManager.this.setCurrentLanguageVersion(this.mLanguage.getVersion());
                } else {
                    NotifyLogger.m29916w(SyncModuleConfigManager.TAG, "file hash error : server language hash is not equals to download file");
                    if (!file.delete()) {
                        NotifyLogger.m29916w(SyncModuleConfigManager.TAG, "tmp config file is delete failed");
                    }
                    this.mIsSuccess = false;
                }
            } else {
                NotifyLogger.m29914e(SyncModuleConfigManager.TAG, "LanguageTask language null");
            }
            this.mResultHolder.setDownloadResult(this.mIsSuccess);
            SyncModuleConfigManager.this.resTaskLatch.countDown();
            NotifyLogger.m29915i(SyncModuleConfigManager.TAG, "LanguageTask call end");
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.SYNC_CONFIG;
        }
    }

    public class WriteConfigToDbTask extends AbstractC12367d {
        private CountDownLatch mCountDown;
        private SyncConfig mSyncConfig;

        public WriteConfigToDbTask(CountDownLatch countDownLatch, SyncConfig syncConfig) {
            this.mCountDown = countDownLatch;
            this.mSyncConfig = syncConfig;
        }

        private String getApplicationStr(String[] strArr) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i10 = 0; i10 < strArr.length - 1; i10++) {
                stringBuffer.append(strArr[i10]);
                stringBuffer.append(",");
            }
            stringBuffer.append(strArr[strArr.length - 1]);
            return stringBuffer.toString();
        }

        private String getFingerPrintsStr(String[] strArr, String str) {
            if (strArr == null || strArr.length == 0) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (int i10 = 0; i10 < strArr.length - 1; i10++) {
                stringBuffer.append(strArr[i10]);
                stringBuffer.append(",");
            }
            stringBuffer.append(strArr[strArr.length - 1]);
            String string = stringBuffer.toString();
            NotifyLogger.m29913d(SyncModuleConfigManager.TAG, "id: " + str + ",fingerPintsStrEmpty: " + TextUtils.isEmpty(string));
            return string;
        }

        private List<SyncConfigVo> getSyncConfigVo() {
            SyncConfigService[] syncConfigService = this.mSyncConfig.getSyncConfigService();
            if (syncConfigService.length <= 0) {
                return null;
            }
            NotifyLogger.m29915i(SyncModuleConfigManager.TAG, "getSyncConfigVo");
            ArrayList arrayList = new ArrayList();
            for (SyncConfigService syncConfigService2 : syncConfigService) {
                SyncConfigVo syncConfigVo = new SyncConfigVo();
                syncConfigVo.setId(syncConfigService2.getId());
                syncConfigVo.setName(syncConfigService2.getName());
                syncConfigVo.setIcon(syncConfigService2.getIcon());
                syncConfigVo.setIconPath(syncConfigService2.getIconPath());
                if (syncConfigService2.isRecord()) {
                    syncConfigVo.setRecord(FaqConstants.DISABLE_HA_REPORT);
                } else {
                    syncConfigVo.setRecord("false");
                }
                syncConfigVo.setRecordIndex(syncConfigService2.getRecordIndex());
                syncConfigVo.setSupportServer(syncConfigService2.getSupportServer());
                syncConfigVo.setUnstructedPath(syncConfigService2.getUnstructedPath());
                syncConfigVo.setUnstructedPathObs(syncConfigService2.getUnstructedPathObs());
                syncConfigVo.setMinSyncVersion(syncConfigService2.getMinSyncVersion());
                syncConfigVo.setMinSyncVersionObs(syncConfigService2.getMinSyncVersionObs());
                if (syncConfigService2.isSubUser()) {
                    syncConfigVo.setSubUser(FaqConstants.DISABLE_HA_REPORT);
                } else {
                    syncConfigVo.setSubUser("false");
                }
                syncConfigVo.setApplications(getApplicationStr(syncConfigService2.getApplications()));
                syncConfigVo.setNotifyType(syncConfigService2.getNotifyType());
                if (syncConfigService2.isForceDelete()) {
                    syncConfigVo.setForceDelete(FaqConstants.DISABLE_HA_REPORT);
                } else {
                    syncConfigVo.setForceDelete("false");
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("id:");
                sb2.append(syncConfigService2.getId());
                sb2.append(",databaseId: ");
                sb2.append(syncConfigService2.getDatabaseId());
                sb2.append(",keyType:");
                sb2.append(syncConfigService2.getKeyType());
                sb2.append(",fingerPrintsEmpty: ");
                sb2.append(syncConfigService2.getFingerPrints() == null || syncConfigService2.getFingerPrints().length <= 0);
                NotifyLogger.m29913d(SyncModuleConfigManager.TAG, sb2.toString());
                syncConfigVo.setDatabaseId(syncConfigService2.getDatabaseId());
                syncConfigVo.setKeyType(syncConfigService2.getKeyType());
                syncConfigVo.setFingerPrints(getFingerPrintsStr(syncConfigService2.getFingerPrints(), syncConfigService2.getId()));
                syncConfigVo.setIconHash(syncConfigService2.getIconHash());
                arrayList.add(syncConfigVo);
                SyncConfigServiceDataType[] dataTypes = syncConfigService2.getDataTypes();
                if (dataTypes.length > 0) {
                    try {
                        new SyncConfigDataTypeOperator().batchInsert(syncConfigService2.getId(), dataTypes);
                    } catch (Exception e10) {
                        NotifyLogger.m29914e(SyncModuleConfigManager.TAG, "dataTypeOperator batchInsert exception:" + e10.toString());
                    }
                }
            }
            return arrayList;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            NotifyLogger.m29915i(SyncModuleConfigManager.TAG, "WriteConfigToDbTask call start");
            try {
                SyncConfigOperator syncConfigOperator = new SyncConfigOperator();
                List<SyncConfigVo> syncConfigVo = getSyncConfigVo();
                if (syncConfigVo != null && syncConfigVo.size() != 0) {
                    syncConfigOperator.batchInsert(syncConfigVo);
                }
            } catch (Exception e10) {
                NotifyLogger.m29914e(SyncModuleConfigManager.TAG, "configOperator batchInsert exception:" + e10.toString());
            }
            this.mCountDown.countDown();
            NotifyLogger.m29915i(SyncModuleConfigManager.TAG, "WriteConfigToDbTask call end");
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.SYNC_CONFIG;
        }
    }

    private SyncModuleConfigManager() {
    }

    private boolean checkDbFingerValid(Context context, SyncConfigService syncConfigService) {
        if (!NotifyUtil.isFingerPrintEmpty(syncConfigService)) {
            return true;
        }
        for (String str : syncConfigService.getApplications()) {
            if (!C0209d.m1230Z1(context, str)) {
                NotifyLogger.m29916w(TAG, "not system app, packageName: " + str);
                return false;
            }
        }
        return true;
    }

    private int getCurrentLanguageVersion() {
        int iM1357g = C0212e0.m1357g(C0213f.m1377a(), "syncConfig", "language_version", 0);
        NotifyLogger.m29915i(TAG, "currentVersion = " + iM1357g);
        return iM1357g;
    }

    public static SyncModuleConfigManager getInstance() {
        return INSTANCE;
    }

    private boolean isNeedDownLanguage(int i10, int i11) {
        if (i10 == 0 || i10 < i11) {
            NotifyLogger.m29916w(TAG, "local version not newest, downFile");
            return true;
        }
        try {
            if (!new File(C0213f.m1377a().getFilesDir() + "/syncConfig/string/sync_config_strings.xml").exists()) {
                NotifyLogger.m29916w(TAG, "local language file not exist, downFile");
                return true;
            }
            if (new SyncConfigLanguageOperator().hasRecord()) {
                return false;
            }
            NotifyLogger.m29916w(TAG, "local language db is empty, downFile");
            return true;
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "isNeedDownlanguage err " + e10.getMessage() + ", downFile");
            return true;
        }
    }

    private void notifySyncConfigParseFinish() {
        C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("action_parse_config_finish"));
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

    public void setCurrentLanguageVersion(int i10) {
        C0212e0.m1368r(C0213f.m1377a(), "syncConfig", "language_version", i10);
    }

    public void checkLanguageDataBase(SyncConfig syncConfig) throws Throwable {
        if (syncConfig == null) {
            NotifyLogger.m29916w(TAG, "checkSyncConfigDataBase, no syncConfig");
            return;
        }
        if (syncConfig.getSyncConfigLanguage() == null) {
            NotifyLogger.m29914e(TAG, "checkLanguageDataBase, language null");
            return;
        }
        String str = C0213f.m1377a().getFilesDir() + "/syncConfig/string/sync_config_strings.xml";
        if (!new File(str).exists() || new SyncConfigLanguageOperator().hasRecord()) {
            return;
        }
        NotifyLogger.m29915i(TAG, "checkLanguageDataBase, need parseLanguageXml");
        parseLanguageXml(str);
    }

    public boolean checkSyncConfigDBValid(Context context) throws Throwable {
        SyncConfigOperator syncConfigOperator = new SyncConfigOperator();
        List<String> allServicesId = syncConfigOperator.getAllServicesId();
        if (allServicesId == null || allServicesId.isEmpty()) {
            NotifyLogger.m29916w(TAG, "checkSyncConfigDB, configDb is empty");
            return false;
        }
        Iterator<String> it = allServicesId.iterator();
        while (it.hasNext()) {
            SyncConfigService serviceById = syncConfigOperator.getServiceById(it.next());
            if (serviceById == null) {
                NotifyLogger.m29916w(TAG, "checkSyncConfigDB, configService is empty");
                return false;
            }
            if (!checkDbFingerValid(context, serviceById)) {
                NotifyLogger.m29916w(TAG, "checkSyncConfigDB, configService fingerPrintes not valid, id = " + serviceById.getId());
                return false;
            }
        }
        return true;
    }

    public void clearDB() {
        synchronized (this) {
            clearSyncConfigAndDataDb();
            clearLanguageDb();
        }
    }

    public void clearLanguageDb() {
        new SyncConfigLanguageOperator().clear();
    }

    public void clearSyncConfigAndDataDb() {
        new SyncConfigOperator().clear();
        new SyncConfigDataTypeOperator().clear();
    }

    public SyncConfigService getSyncConfigServiceByUnStruncturePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SyncConfigOperator().getServiceByUntructurePath(str);
    }

    public List<SyncConfigService> getSyncServicesFromDb() {
        ArrayList arrayList;
        synchronized (this) {
            try {
                SyncConfigOperator syncConfigOperator = new SyncConfigOperator();
                arrayList = new ArrayList();
                List<SyncConfigService> allServices = syncConfigOperator.getAllServices();
                NotifyLogger.m29915i(TAG, "getSyncServicesFromDb, size=" + allServices.size());
                SyncConfigDataTypeOperator syncConfigDataTypeOperator = new SyncConfigDataTypeOperator();
                if (allServices.size() > 0) {
                    for (SyncConfigService syncConfigService : allServices) {
                        if (NotifyUtil.isSyncSerivceResourcOk(syncConfigService)) {
                            syncConfigService.setDataTypes(syncConfigDataTypeOperator.getDataTypesByServiceId(syncConfigService.getId()));
                            arrayList.add(syncConfigService);
                        }
                    }
                    NotifyLogger.m29915i(TAG, "getSyncServicesFromDb, size = " + allServices.size());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return arrayList;
    }

    public boolean isFinished() {
        return this.isFinished;
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
            java.lang.String r1 = "SyncModuleConfigManager"
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
            com.huawei.hicloud.notification.db.operator.SyncConfigLanguageOperator r3 = new com.huawei.hicloud.notification.db.operator.SyncConfigLanguageOperator     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
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
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.manager.SyncModuleConfigManager.parseLanguageXml(java.lang.String):void");
    }

    public void parseSyncConfig(SyncConfig syncConfig) {
        CountDownLatch countDownLatch;
        CountDownLatch countDownLatch2;
        SyncConfigLanguage syncConfigLanguage;
        TimeUnit timeUnit;
        if (syncConfig == null) {
            NotifyLogger.m29915i(TAG, "syncConfig null");
            return;
        }
        int i10 = 2;
        this.resTaskLatch = new CountDownLatch(2);
        NotifyLogger.m29915i(TAG, "parseSyncConfig start");
        try {
            try {
                this.isFinished = false;
                syncConfigLanguage = syncConfig.getSyncConfigLanguage();
            } catch (Exception e10) {
                NotifyLogger.m29914e(TAG, "parseSyncConfig exception:" + e10.toString());
                countDownLatch2 = this.mDevConfInitTaskLatch;
                if (countDownLatch2 != null) {
                }
            }
            if (syncConfigLanguage == null) {
                NotifyLogger.m29914e(TAG, "language null");
                if (countDownLatch != null) {
                    return;
                } else {
                    return;
                }
            }
            ResourceDownLoadHolder resourceDownLoadHolder = new ResourceDownLoadHolder();
            int currentLanguageVersion = getCurrentLanguageVersion();
            NotifyLogger.m29915i(TAG, "current language version is: " + currentLanguageVersion + ", OM file language version is: " + syncConfigLanguage.getVersion());
            if (isNeedDownLanguage(currentLanguageVersion, syncConfigLanguage.getVersion())) {
                C12515a.m75110o().m75172d(new LanguageTask(syncConfigLanguage, resourceDownLoadHolder));
            } else {
                resourceDownLoadHolder.setDownloadResult(true);
                this.resTaskLatch.countDown();
            }
            ResourceDownLoadHolder resourceDownLoadHolder2 = new ResourceDownLoadHolder();
            C12515a.m75110o().m75172d(new IconTask(syncConfig.getSyncConfigService(), resourceDownLoadHolder2));
            if (this.resTaskLatch.await(MAX_TASK_WAIT_TIME, TimeUnit.MILLISECONDS)) {
                NotifyLogger.m29915i(TAG, "all res task finished");
            }
            boolean result = resourceDownLoadHolder.getResult();
            boolean result2 = resourceDownLoadHolder2.getResult();
            NotifyLogger.m29915i(TAG, "resources download finished, isLanguageSuccess=" + result + ",isIconSuccess=" + result2);
            if (result && result2) {
                this.dbLatch = new CountDownLatch(1);
                do {
                    clearSyncConfigAndDataDb();
                    CountDownLatch countDownLatch3 = new CountDownLatch(1);
                    C12515a.m75110o().m75172d(new WriteConfigToDbTask(countDownLatch3, syncConfig));
                    timeUnit = TimeUnit.MILLISECONDS;
                    if (countDownLatch3.await(MAX_TASK_WAIT_TIME, timeUnit)) {
                        NotifyLogger.m29915i(TAG, "db task finished");
                    }
                    i10--;
                    if (i10 <= 0) {
                        break;
                    }
                } while (!checkSyncConfigDBValid(C0213f.m1377a()));
                this.dbLatch.countDown();
                if (this.dbLatch.await(MAX_TASK_WAIT_TIME, timeUnit)) {
                    NotifyLogger.m29915i(TAG, "all retry db task finished");
                }
                notifySyncConfigParseFinish();
            }
            this.isFinished = true;
            countDownLatch2 = this.mDevConfInitTaskLatch;
            if (countDownLatch2 != null) {
                countDownLatch2.countDown();
            }
            NotifyLogger.m29915i(TAG, "parseSyncConfig end");
        } finally {
            countDownLatch = this.mDevConfInitTaskLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
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

        public /* synthetic */ ResourceDownLoadHolder(C49441 c49441) {
            this();
        }
    }

    public void parseSyncConfig(SyncConfig syncConfig, CountDownLatch countDownLatch) {
        this.mDevConfInitTaskLatch = countDownLatch;
        parseSyncConfig(syncConfig);
    }
}
