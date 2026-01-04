package com.huawei.hicloud.notification.manager;

import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.ForcedUpgradeNotifications;
import com.huawei.hicloud.notification.p106db.bean.ForcedUpgradeNotifyConfig;
import com.huawei.hicloud.notification.p106db.bean.UpgradeConfigLanguage;
import com.huawei.hicloud.notification.p106db.operator.UpgradeConfigLanguageOperator;
import gp.C10028c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import p015ak.C0213f;

/* loaded from: classes6.dex */
public class ForcedUpgradeNotificationManager {
    private static final String TAG = "ForcedUpgradeNotificationManager";
    private HNCloudConfig mCloudConfig = new HNCloudConfig();
    private HNLocalConfig mLocalConfig = new HNLocalConfig();

    private boolean databaseHasRecord() {
        try {
            return new UpgradeConfigLanguageOperator().hasRecord();
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "databaseHasRecord exceptions: " + e10.getMessage());
            return false;
        }
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

    public void checkLanguageDataBase(ForcedUpgradeNotifyConfig forcedUpgradeNotifyConfig) {
        if (forcedUpgradeNotifyConfig == null) {
            NotifyLogger.m29914e(TAG, "no forcedUpgradeNotifyConfig");
            return;
        }
        UpgradeConfigLanguage upgradeConfigLanguage = forcedUpgradeNotifyConfig.getUpgradeConfigLanguage();
        if (upgradeConfigLanguage == null) {
            NotifyLogger.m29914e(TAG, "no upgrade config language");
            return;
        }
        String xmlPath = getXmlPath();
        if (!new File(xmlPath).exists() || databaseHasRecord()) {
            return;
        }
        NotifyLogger.m29915i(TAG, "checkLanguageDataBase, need parseLanguageXml");
        parseLanguageXml(xmlPath, upgradeConfigLanguage);
    }

    public ForcedUpgradeNotifyConfig getForcedUpgradeNoticeConfig() {
        NotifyLogger.m29915i(TAG, "getForcedUpgradeNoticeConfig");
        NotificationConfig notificationConfig = getNotificationConfig();
        if (notificationConfig == null) {
            return null;
        }
        NotifyLogger.m29915i(TAG, "getNotificationConfig success");
        return notificationConfig.getHiCloudUpgradeNotice();
    }

    public NotificationConfig getNotificationConfig() {
        NotifyLogger.m29915i(TAG, "getConfigFromFile");
        if (this.mCloudConfig.isExist()) {
            return this.mCloudConfig.getConfig();
        }
        NotifyLogger.m29915i(TAG, "cloud config not exist");
        return this.mLocalConfig.getConfig();
    }

    public ForcedUpgradeNotifications[] getNotifications() {
        NotifyLogger.m29915i(TAG, "getUpgradeNotifications");
        ForcedUpgradeNotifyConfig forcedUpgradeNoticeConfig = getForcedUpgradeNoticeConfig();
        if (forcedUpgradeNoticeConfig != null) {
            NotifyLogger.m29915i(TAG, "getUpgradeNotifyConfig success");
            return forcedUpgradeNoticeConfig.getNotification();
        }
        C10028c.m62182c0().m62254O1();
        NotifyLogger.m29915i(TAG, "getUpgradeNotifications failed");
        return null;
    }

    public String getXmlPath() {
        return C0213f.m1377a().getFilesDir() + "/upgrade_config_strings.xml";
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void parseLanguageXml(java.lang.String r10, com.huawei.hicloud.notification.p106db.bean.UpgradeConfigLanguage r11) {
        /*
            r9 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r10)
            boolean r10 = r0.exists()
            java.lang.String r1 = "ForcedUpgradeNotificationManager"
            if (r10 != 0) goto L13
            java.lang.String r9 = "language xml not exist"
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r1, r9)
            return
        L13:
            r10 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbd
            r2.<init>(r0)     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbd
            org.xmlpull.v1.XmlPullParser r0 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            java.lang.String r3 = "utf-8"
            r0.setInput(r2, r3)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            int r3 = r0.getEventType()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            java.lang.String r4 = ""
        L28:
            r5 = 1
            if (r3 == r5) goto Lb5
            java.lang.String r5 = r0.getName()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            r6 = 2
            java.lang.String r7 = "text"
            java.lang.String r8 = "resource"
            if (r3 == r6) goto L74
            r6 = 3
            if (r3 == r6) goto L3b
            goto Laf
        L3b:
            boolean r3 = r8.equals(r5)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            if (r3 != 0) goto Laf
            boolean r3 = r7.equals(r5)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            if (r3 != 0) goto Laf
            if (r10 == 0) goto Laf
            com.huawei.hicloud.notification.db.operator.UpgradeConfigLanguageOperator r3 = new com.huawei.hicloud.notification.db.operator.UpgradeConfigLanguageOperator     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            r3.<init>()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            r3.batchInsert(r10)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            r10.clear()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            gp.c r3 = gp.C10028c.m62182c0()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            java.lang.String r5 = "language_version"
            int r6 = r11.getVersion()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            r3.m62386r2(r5, r6)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            gp.c r3 = gp.C10028c.m62182c0()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            java.lang.String r5 = "language_hash"
            java.lang.String r6 = r11.getHash()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            r3.m62381q2(r5, r6)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            goto Laf
        L6f:
            r10 = move-exception
            goto Ldc
        L72:
            r10 = move-exception
            goto Lc0
        L74:
            boolean r3 = r8.equals(r5)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            if (r3 == 0) goto L80
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            r10.<init>()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            goto Laf
        L80:
            boolean r3 = r7.equals(r5)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            if (r3 == 0) goto Lae
            com.huawei.hicloud.notification.db.bean.UpgradeConfigString r3 = new com.huawei.hicloud.notification.db.bean.UpgradeConfigString     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            r3.<init>()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            java.lang.String r5 = r0.getNamespace()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            java.lang.String r6 = "name"
            java.lang.String r5 = r0.getAttributeValue(r5, r6)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            r3.setName(r5)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            java.lang.String r5 = r0.getNamespace()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            java.lang.String r6 = "value"
            java.lang.String r5 = r0.getAttributeValue(r5, r6)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            r3.setValue(r5)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            r3.setCountry(r4)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            if (r10 == 0) goto Laf
            r10.add(r3)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            goto Laf
        Lae:
            r4 = r5
        Laf:
            int r3 = r0.next()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            goto L28
        Lb5:
            r9.safeClose(r2)
            goto Ldb
        Lb9:
            r11 = move-exception
            r2 = r10
            r10 = r11
            goto Ldc
        Lbd:
            r11 = move-exception
            r2 = r10
            r10 = r11
        Lc0:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6f
            r11.<init>()     // Catch: java.lang.Throwable -> L6f
            java.lang.String r0 = "parseLanguageXml exception: "
            r11.append(r0)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L6f
            r11.append(r10)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r10 = r11.toString()     // Catch: java.lang.Throwable -> L6f
            com.huawei.hicloud.notification.log.NotifyLogger.m29914e(r1, r10)     // Catch: java.lang.Throwable -> L6f
            if (r2 == 0) goto Ldb
            goto Lb5
        Ldb:
            return
        Ldc:
            if (r2 == 0) goto Le1
            r9.safeClose(r2)
        Le1:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.manager.ForcedUpgradeNotificationManager.parseLanguageXml(java.lang.String, com.huawei.hicloud.notification.db.bean.UpgradeConfigLanguage):void");
    }
}
