package com.huawei.hicloud.notification.manager;

import android.content.Context;
import android.database.SQLException;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hicloud.notification.config.HNUtil;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.HicloudPushGuideConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.HiCloudPushGuideLanguage;
import com.huawei.hicloud.notification.p106db.bean.HicloudPushGuidPopConfig;
import com.huawei.hicloud.notification.p106db.bean.HicloudPushGuideConfig;
import com.huawei.hicloud.notification.p106db.bean.HicloudPushGuideConfigString;
import com.huawei.hicloud.notification.p106db.bean.HicloudPushGuideConfigurations;
import com.huawei.hicloud.notification.p106db.operator.HiCloudPushGuideLanguageOperator;
import com.huawei.openalliance.p169ad.constant.Constants;
import gp.C10028c;
import hk.C10280c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0241z;
import p459lp.C11327e;
import p846zj.C14306d;

/* loaded from: classes6.dex */
public class HicloudPushGuideManager {
    private static final String TAG = "HicloudPushGuideManager";

    public static class Holder {
        private static final HicloudPushGuideManager INSTANCE = new HicloudPushGuideManager();

        private Holder() {
        }
    }

    public static boolean checkSingleSubConsentStatus(char[] cArr, int i10) {
        if (cArr != null && cArr.length >= 4) {
            return cArr[i10] == '1';
        }
        NotifyLogger.m29914e(TAG, "subConsentStatus is null");
        return false;
    }

    public static boolean checkSubConsentStatus(char[] cArr) {
        boolean z10 = false;
        if (cArr == null) {
            NotifyLogger.m29914e(TAG, "subConsentStatus is null");
            return false;
        }
        int length = cArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length || i10 >= 4) {
                break;
            }
            if (cArr[i10] == '1') {
                z10 = true;
                break;
            }
            i10++;
        }
        NotifyLogger.m29913d(TAG, "subConsent：" + String.valueOf(cArr));
        return z10;
    }

    private void clearSp() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            return;
        }
        File file = new File(contextM1377a.getFilesDir() + HicloudPushGuideConstants.HICLOUD_PUSH_GUIDE_FILEPATH);
        if (!file.exists()) {
            NotifyLogger.m29914e(TAG, "hicoudpushguide file not exist");
        } else if (!file.delete()) {
            NotifyLogger.m29914e(TAG, "hicoudpushguide file del failed");
        }
        C11327e.m68059b("HiCloudPushGuide");
    }

    private void closeIn(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                NotifyLogger.m29914e(TAG, "safeClose exceptions:" + e10.toString());
            }
        }
    }

    public static HicloudPushGuideManager getInstance() {
        return Holder.INSTANCE;
    }

    private HicloudPushGuideConfig getPushGuideConfigFromLocalFile(Context context) throws Throwable {
        NotifyLogger.m29915i(TAG, "getPushGuideConfigFromLocalFile");
        if (context == null) {
            NotifyLogger.m29914e(TAG, "getPushGuideConfigFromLocalFile context is null.");
            return null;
        }
        String str = context.getFilesDir() + File.separator + HicloudPushGuideConstants.HICLOUD_PUSH_GUIDE_LOCAL_CONFIG_FILE;
        if (!new File(str).exists()) {
            NotifyLogger.m29915i(TAG, "getPushGuideConfigFromLocalFile file is not exist.");
            C10280c.m63455c(context, HicloudPushGuideConstants.HICLOUD_PUSH_GUIDE_LOCAL_CONFIG_FILE, str);
        }
        return getConfigRaw(str);
    }

    public void checkLanguageDataBase() {
        HicloudPushGuideConfig configFromFile = getConfigFromFile();
        if (configFromFile == null) {
            NotifyLogger.m29914e(TAG, "checkLanguageDataBase() hicloudpushguideconfig is null or mContext is null.");
            return;
        }
        HicloudPushGuideConfigurations configurations = configFromFile.getConfigurations();
        if (configurations == null) {
            NotifyLogger.m29914e(TAG, "No configConfigurations");
            return;
        }
        HiCloudPushGuideLanguage language = configurations.getLanguage();
        if (language == null) {
            NotifyLogger.m29914e(TAG, "No language");
            return;
        }
        HiCloudPushGuideLanguageOperator hiCloudPushGuideLanguageOperator = new HiCloudPushGuideLanguageOperator();
        String xmlPath = getXmlPath();
        if (!new File(xmlPath).exists() || hiCloudPushGuideLanguageOperator.hasRecord()) {
            return;
        }
        NotifyLogger.m29915i(TAG, "checkLanguageDataBase, need parseLanguageXmlAndInsertDB");
        getInstance().parseHicoudPushGuideLanguageXml(xmlPath, language);
    }

    public boolean checkPopTimes() {
        if (System.currentTimeMillis() - C10028c.m62182c0().m62225I0() < (C14306d.m85208i() ? 2592000000L : Constants.TWO_WEEK)) {
            NotifyLogger.m29916w(TAG, "within 48 hours not need show");
            return false;
        }
        int iM62230J0 = C10028c.m62182c0().m62230J0();
        HicloudPushGuidPopConfig popConfig = getPopConfig();
        return popConfig != null && C0241z.m1686d(popConfig.getMaxPopTimes(), 0) > iM62230J0;
    }

    public void clear() {
        clearSp();
        clearLanguageDb();
        clearLanguageXml();
    }

    public void clearLanguageDb() throws SQLException {
        new HiCloudPushGuideLanguageOperator().clear();
    }

    public void clearLanguageXml() {
        File file = new File(getXmlPath());
        if (!file.exists()) {
            NotifyLogger.m29914e(TAG, "hicloudpushguidelanguagexml file not exist");
        } else {
            if (file.delete()) {
                return;
            }
            NotifyLogger.m29914e(TAG, "hicloudpushguidelanguagexml file del failed");
        }
    }

    public HicloudPushGuideConfig getConfigFromFile() {
        NotifyLogger.m29915i(TAG, "getPushGuideConfigFromFile");
        Context contextM1377a = C0213f.m1377a();
        String str = contextM1377a.getFilesDir() + HicloudPushGuideConstants.HICLOUD_PUSH_GUIDE_FILEPATH;
        return !new File(str).exists() ? getPushGuideConfigFromLocalFile(contextM1377a) : getConfigRaw(str);
    }

    public HicloudPushGuideConfig getConfigRaw(String str) {
        NotifyLogger.m29915i(TAG, "getPushGuideConfigFromFile");
        try {
            return (HicloudPushGuideConfig) new Gson().fromJson(readConfigStr(new FileInputStream(new File(str))), HicloudPushGuideConfig.class);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "cloud config file not exitst, msg:" + e10.getMessage());
            return null;
        }
    }

    public String getContentString(String str) {
        String currentBaseLanguage = HNUtil.getCurrentBaseLanguage();
        String currentLanguage = HNUtil.getCurrentLanguage();
        List<HicloudPushGuideConfigString> listQueryString = new HiCloudPushGuideLanguageOperator().queryString(currentLanguage, currentBaseLanguage, HNConstants.Language.EN_STANDARD, str);
        if (listQueryString == null || listQueryString.size() <= 0) {
            NotifyLogger.m29914e(TAG, "getPushguideContentString no language configs,textName=" + str);
            return null;
        }
        HicloudPushGuideConfigString hicloudPushGuideConfigString = null;
        HicloudPushGuideConfigString hicloudPushGuideConfigString2 = null;
        for (HicloudPushGuideConfigString hicloudPushGuideConfigString3 : listQueryString) {
            String country = hicloudPushGuideConfigString3.getCountry();
            if (country == null) {
                NotifyLogger.m29914e(TAG, "tmpLanguageName null, stringId=" + str);
            } else if (country.equals(currentLanguage)) {
                hicloudPushGuideConfigString2 = hicloudPushGuideConfigString3;
            } else if (country.equals(HNConstants.Language.EN_STANDARD)) {
                hicloudPushGuideConfigString = hicloudPushGuideConfigString3;
            }
        }
        if (hicloudPushGuideConfigString != null) {
            listQueryString.remove(hicloudPushGuideConfigString);
        }
        if (hicloudPushGuideConfigString2 != null) {
            NotifyLogger.m29915i(TAG, "fullMatchString stringId=" + str);
            listQueryString.remove(hicloudPushGuideConfigString2);
            hicloudPushGuideConfigString = hicloudPushGuideConfigString2;
        } else if (listQueryString.size() > 0) {
            NotifyLogger.m29915i(TAG, "partMatch stringId=" + str);
            HicloudPushGuideConfigString hicloudPushGuideConfigString4 = listQueryString.get(0);
            hicloudPushGuideConfigString = hicloudPushGuideConfigString4 != null ? hicloudPushGuideConfigString4 : null;
        } else {
            NotifyLogger.m29915i(TAG, "no match, using default stringId=" + str);
        }
        if (hicloudPushGuideConfigString != null) {
            return hicloudPushGuideConfigString.getValue();
        }
        return null;
    }

    public String[] getCurrentContentString() {
        HicloudPushGuidPopConfig popConfig = getPopConfig();
        if (popConfig == null) {
            NotifyLogger.m29915i(TAG, "popConfig is null");
            return new String[0];
        }
        return new String[]{getInstance().getContentString(popConfig.getTitle()), getInstance().getContentString(popConfig.getMainText()), getInstance().getContentString(popConfig.getPackageDesc())};
    }

    public HicloudPushGuidPopConfig getPopConfig() {
        HicloudPushGuideConfig configFromFile = getInstance().getConfigFromFile();
        if (configFromFile == null) {
            NotifyLogger.m29915i(TAG, "hicloudpushguideconfig is null");
            return null;
        }
        HicloudPushGuideConfigurations configurations = configFromFile.getConfigurations();
        if (configurations == null) {
            NotifyLogger.m29915i(TAG, "configurations is null");
            return null;
        }
        HicloudPushGuidPopConfig popConfig = configurations.getPopConfig();
        if (popConfig != null) {
            return popConfig;
        }
        NotifyLogger.m29915i(TAG, "popConfig is null");
        return null;
    }

    public String getXmlPath() {
        return C0213f.m1377a().getFilesDir() + File.separator + HicloudPushGuideConstants.LANGUAGE_PACKAGE_NAME;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void parseHicoudPushGuideLanguageXml(java.lang.String r10, com.huawei.hicloud.notification.p106db.bean.HiCloudPushGuideLanguage r11) throws java.lang.Throwable {
        /*
            r9 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r10)
            boolean r10 = r0.exists()
            java.lang.String r1 = "HicloudPushGuideManager"
            if (r10 != 0) goto L13
            java.lang.String r9 = "hicloud push guide language xml not exist"
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
            com.huawei.hicloud.notification.db.operator.HiCloudPushGuideLanguageOperator r3 = new com.huawei.hicloud.notification.db.operator.HiCloudPushGuideLanguageOperator     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            r3.<init>()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            r3.batchInsert(r10)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            r10.clear()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            gp.c r3 = gp.C10028c.m62182c0()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            java.lang.String r5 = "push_guide_language_version"
            int r6 = r11.getVersion()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            r3.m62386r2(r5, r6)     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            gp.c r3 = gp.C10028c.m62182c0()     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
            java.lang.String r5 = "push_guide_language_hash"
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
            com.huawei.hicloud.notification.db.bean.HicloudPushGuideConfigString r3 = new com.huawei.hicloud.notification.db.bean.HicloudPushGuideConfigString     // Catch: java.lang.Throwable -> L6f java.lang.Exception -> L72
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
            r9.closeIn(r2)
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
            java.lang.String r0 = "pushguide,parseLanguageXml exception: "
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
            r9.closeIn(r2)
        Le1:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hicloud.notification.manager.HicloudPushGuideManager.parseHicoudPushGuideLanguageXml(java.lang.String, com.huawei.hicloud.notification.db.bean.HiCloudPushGuideLanguage):void");
    }

    public String readConfigStr(InputStream inputStream) {
        return C0209d.m1290o2(inputStream);
    }

    public void resetPopTimes() {
        HicloudPushGuidPopConfig popConfig = getPopConfig();
        if (popConfig == null) {
            NotifyLogger.m29915i(TAG, "popConfig is null");
            return;
        }
        String restable = popConfig.getRestable();
        String guid = popConfig.getGuid();
        if (TextUtils.equals(restable, "1")) {
            String strM62220H0 = C10028c.m62182c0().m62220H0();
            if (TextUtils.equals(guid, strM62220H0) || TextUtils.isEmpty(strM62220H0)) {
                NotifyLogger.m29915i(TAG, "guid no change");
            } else {
                NotifyLogger.m29915i(TAG, "restable");
                C10028c.m62182c0().m62188A3();
            }
        } else {
            NotifyLogger.m29915i(TAG, "restable is 0");
        }
        C10028c.m62182c0().m62417x3(guid);
    }

    private HicloudPushGuideManager() {
    }
}
