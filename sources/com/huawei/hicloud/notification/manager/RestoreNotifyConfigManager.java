package com.huawei.hicloud.notification.manager;

import android.database.SQLException;
import android.util.Xml;
import com.huawei.hicloud.bean.SyncConfigLanguage;
import com.huawei.hicloud.notification.RestoreNotifyUtil;
import com.huawei.hicloud.notification.config.CBPushNotificationObject;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.RestoreNotifyConfig;
import com.huawei.hicloud.notification.p106db.bean.RestoreNotifyContent;
import com.huawei.hicloud.notification.p106db.operator.RestoreNotifyLanguageOperator;
import com.huawei.hicloud.notification.p106db.operator.RestoreNotifyOperator;
import com.huawei.hicloud.notification.p106db.operator.RestoreNotifydDevicesOperator;
import hk.C10278a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mk.C11476b;
import org.xmlpull.v1.XmlPullParser;
import p015ak.C0212e0;
import p015ak.C0213f;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;

/* loaded from: classes6.dex */
public class RestoreNotifyConfigManager {
    private static final long CONFIG_DOWNLOAD_WAITING_TIME = 5000;
    private static final String DESCRIPTION_TAG = "description";
    private static final int MAX_FAIL_RETRY = 2;
    private static final int RES_TASK_NUM = 1;
    private static final long RETRY_INTERVAL = 2000;
    private static final String SUB_TITLE_TAG = "sub_title";
    private static final String TAG = "RestoreNotifyConfigManager";
    private static final String TITLE_TAG = "title";
    private boolean isFinished = true;
    private String laguageFilePath;
    private CountDownLatch resTaskLatch;

    public class LanguageTask extends AbstractC12367d {
        private boolean isSuccess = false;
        private SyncConfigLanguage mLanguage;
        private ResourceDownLoadHolder mResultHolder;
        private RestoreNotifyConfig restoreNotifyConfig;
        private String xmlPath;

        public LanguageTask(SyncConfigLanguage syncConfigLanguage, ResourceDownLoadHolder resourceDownLoadHolder, RestoreNotifyConfig restoreNotifyConfig) {
            this.mLanguage = syncConfigLanguage;
            this.mResultHolder = resourceDownLoadHolder;
            this.restoreNotifyConfig = restoreNotifyConfig;
        }

        private String generateFileHash() {
            try {
                File fileM63442h = C10278a.m63442h(this.xmlPath);
                return fileM63442h.exists() ? C11476b.m68622d(fileM63442h).getHash() : "";
            } catch (Exception e10) {
                NotifyLogger.m29914e(RestoreNotifyConfigManager.TAG, "generateFileHash exceptions:" + e10.toString());
                return "";
            }
        }

        private void safeClose(InputStream inputStream) throws IOException {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e10) {
                    NotifyLogger.m29914e(RestoreNotifyConfigManager.TAG, "safeClose exceptions:" + e10.toString());
                }
            }
        }

        private void saveContent(RestoreNotifyContent restoreNotifyContent, String str, String str2, String str3) {
            if (restoreNotifyContent == null) {
                NotifyLogger.m29916w(RestoreNotifyConfigManager.TAG, "get resource: content is null");
                return;
            }
            if (str2.equals("title")) {
                restoreNotifyContent.setTitle(str3);
            } else if (str2.equals(RestoreNotifyConfigManager.SUB_TITLE_TAG)) {
                restoreNotifyContent.setSubTitle(str3);
            } else if (str2.equals("description")) {
                restoreNotifyContent.setDescription(str3);
            }
            restoreNotifyContent.setLanguage(str);
            restoreNotifyContent.setId(this.restoreNotifyConfig.getId());
            restoreNotifyContent.setLoginState(this.restoreNotifyConfig.getLoginState());
        }

        /* JADX WARN: Removed duplicated region for block: B:106:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:95:0x0156 A[Catch: Exception -> 0x0154, TRY_LEAVE, TryCatch #1 {Exception -> 0x0154, blocks: (B:88:0x0130, B:90:0x013c, B:92:0x014c, B:95:0x0156), top: B:104:0x0130 }] */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v17, types: [boolean] */
        /* JADX WARN: Type inference failed for: r0v26 */
        /* JADX WARN: Type inference failed for: r0v27 */
        /* JADX WARN: Type inference failed for: r0v9, types: [com.huawei.hicloud.download.a] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x00a6 -> B:73:0x00b7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x00a4 -> B:104:0x0130). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x00b0 -> B:104:0x0130). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x00bf -> B:104:0x0130). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x00d5 -> B:87:0x012c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x00d7 -> B:104:0x0130). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x015a -> B:103:0x0178). Please report as a decompilation issue!!! */
        @Override // p616rk.AbstractRunnableC12516b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void call() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 398
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.manager.RestoreNotifyConfigManager.LanguageTask.call():void");
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.SYNC_CONFIG;
        }

        public void parseLanguageXml() throws Throwable {
            File file = new File(this.xmlPath);
            if (!file.exists()) {
                NotifyLogger.m29914e(RestoreNotifyConfigManager.TAG, "language xml not exist");
                return;
            }
            InputStream inputStream = null;
            RestoreNotifyContent restoreNotifyContent = null;
            FileInputStream fileInputStream = null;
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                        xmlPullParserNewPullParser.setInput(fileInputStream2, "utf-8");
                        int eventType = xmlPullParserNewPullParser.getEventType();
                        ArrayList arrayList = new ArrayList();
                        String str = "";
                        while (eventType != 1) {
                            String name = xmlPullParserNewPullParser.getName();
                            if (eventType == 2) {
                                if ("resource".equals(name)) {
                                    NotifyLogger.m29913d(RestoreNotifyConfigManager.TAG, "get resource");
                                } else if ("text".equals(name)) {
                                    saveContent(restoreNotifyContent, str, xmlPullParserNewPullParser.getAttributeValue(xmlPullParserNewPullParser.getNamespace(), "name"), xmlPullParserNewPullParser.getAttributeValue(xmlPullParserNewPullParser.getNamespace(), "value"));
                                } else {
                                    if (restoreNotifyContent != null) {
                                        arrayList.add(restoreNotifyContent);
                                    }
                                    restoreNotifyContent = new RestoreNotifyContent();
                                    str = name;
                                }
                            }
                            eventType = xmlPullParserNewPullParser.next();
                            restoreNotifyContent = restoreNotifyContent;
                        }
                        arrayList.add(restoreNotifyContent);
                        new RestoreNotifyLanguageOperator().batchInsert(arrayList);
                        arrayList.clear();
                        safeClose(fileInputStream2);
                        inputStream = restoreNotifyContent;
                    } catch (Exception e10) {
                        e = e10;
                        fileInputStream = fileInputStream2;
                        NotifyLogger.m29914e(RestoreNotifyConfigManager.TAG, "parseLanguageXml exception:" + e.toString());
                        inputStream = fileInputStream;
                        if (fileInputStream != null) {
                            safeClose(fileInputStream);
                            inputStream = fileInputStream;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = fileInputStream2;
                        if (inputStream != null) {
                            safeClose(inputStream);
                        }
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public static void checkRestoreNotifyConfig() {
        String str = C0213f.m1377a().getFilesDir() + "/restore_notify/string/login.xml";
        String str2 = C0213f.m1377a().getFilesDir() + "/restore_notify/string/logout.xml";
        File file = new File(str);
        File file2 = new File(str2);
        if ((file.exists() || file2.exists()) && !isConfigOK()) {
            cleanConfig();
            reExtractConfig();
        }
    }

    private static void cleanConfig() throws SQLException {
        NotifyLogger.m29915i(TAG, "clean RestoreNotify DB");
        new RestoreNotifyOperator().clear();
        new RestoreNotifydDevicesOperator().clear();
        new RestoreNotifyLanguageOperator().clear();
    }

    public String getCurrentLanguageHash() {
        String strM1363m = C0212e0.m1363m(C0213f.m1377a(), RestoreNotifyUtil.RESTORE_NOTIFY_SP, "language_hash", "");
        NotifyLogger.m29915i(TAG, "currentHash = " + strM1363m);
        return strM1363m;
    }

    public int getCurrentLanguageVersion() {
        int iM1357g = C0212e0.m1357g(C0213f.m1377a(), RestoreNotifyUtil.RESTORE_NOTIFY_SP, "language_version", 0);
        NotifyLogger.m29915i(TAG, "currentVersion = " + iM1357g);
        return iM1357g;
    }

    private static boolean isConfigOK() {
        return new RestoreNotifyOperator().hasRecord() && new RestoreNotifydDevicesOperator().hasRecord() && new RestoreNotifyLanguageOperator().hasRecord();
    }

    private static void reExtractConfig() {
        NotifyLogger.m29915i(TAG, "reExtract RestoreNotify Config");
        HNCloudConfig hNCloudConfig = new HNCloudConfig();
        NotificationConfig configFromFile = hNCloudConfig.getConfigFromFile();
        if (configFromFile == null) {
            NotifyLogger.m29915i(TAG, "fullConfig null");
            return;
        }
        CBPushNotificationObject hiCloudPullNewNotice = configFromFile.getHiCloudPullNewNotice();
        if (hiCloudPullNewNotice != null) {
            hNCloudConfig.handleRestoreNotifyConfig(hiCloudPullNewNotice);
        }
    }

    public void setCurrentLanguageHash(String str) {
        C0212e0.m1372v(C0213f.m1377a(), RestoreNotifyUtil.RESTORE_NOTIFY_SP, "language_hash", str);
    }

    public void setCurrentLanguageVersion(int i10) {
        C0212e0.m1368r(C0213f.m1377a(), RestoreNotifyUtil.RESTORE_NOTIFY_SP, "language_version", i10);
    }

    public void awaitRequestConfigTaskFinish() throws InterruptedException {
        try {
            NotifyLogger.m29915i(TAG, "awaitlanguageTask start");
            NotifyLogger.m29915i(TAG, "awaitlanguageTask end, awaitResult = " + this.resTaskLatch.await(5000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e10) {
            NotifyLogger.m29914e(TAG, "awaitlanguageTask doInBackground exception:" + e10.toString());
        }
    }

    public boolean isFinished() {
        return this.isFinished;
    }

    public void parseRestoreNotifyConfig(RestoreNotifyConfig restoreNotifyConfig) {
        SyncConfigLanguage language;
        if (restoreNotifyConfig == null) {
            NotifyLogger.m29915i(TAG, "RestoreNotifyConfig null");
            return;
        }
        this.laguageFilePath = "/restore_notify/string/" + restoreNotifyConfig.getLoginState() + ".xml";
        this.resTaskLatch = new CountDownLatch(1);
        NotifyLogger.m29915i(TAG, "parseRestoreNotifyConfig start");
        try {
            this.isFinished = false;
            language = restoreNotifyConfig.getLanguage();
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "parseSyncConfig exception:" + e10.toString());
        }
        if (language == null) {
            NotifyLogger.m29914e(TAG, "language null");
            return;
        }
        ResourceDownLoadHolder resourceDownLoadHolder = new ResourceDownLoadHolder();
        NotifyLogger.m29915i(TAG, "current language version is: " + getCurrentLanguageVersion() + ", OM file language version is: " + language.getVersion());
        C12515a.m75110o().m75175e(new LanguageTask(language, resourceDownLoadHolder, restoreNotifyConfig), false);
        NotifyLogger.m29915i(TAG, "resources download finished, isLanguageSuccess=" + resourceDownLoadHolder.getResult());
        this.isFinished = true;
        NotifyLogger.m29915i(TAG, "parseSyncConfig end");
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

        public /* synthetic */ ResourceDownLoadHolder(C49391 c49391) {
            this();
        }
    }
}
