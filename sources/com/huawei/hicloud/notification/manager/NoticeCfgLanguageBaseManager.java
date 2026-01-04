package com.huawei.hicloud.notification.manager;

import android.text.TextUtils;
import android.util.Xml;
import android.webkit.URLUtil;
import com.huawei.hicloud.bean.CPUOffloadSleepDuration;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.download.C4896a;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguage;
import com.huawei.hicloud.notification.p106db.bean.CommonLanguageDbString;
import com.huawei.hicloud.notification.util.NotifyUtil;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import mk.C11476b;
import org.xmlpull.v1.XmlPullParser;
import p015ak.C0209d;
import p015ak.C0213f;
import p292fn.C9733f;
import p371ik.C10527a;
import p429kk.C11060c;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p746wn.C13622a;

/* loaded from: classes6.dex */
public abstract class NoticeCfgLanguageBaseManager {
    protected static final int DEFAULT_VALUE = -1;
    private static final int DOWNLOAD_AND_PARSE_LANGUAGE = 1;
    private static final int MAX_FAIL_RETRY = 2;
    private static final int PARSE_LANGUAGE = 2;
    private static final long RETRY_INTERVAL = 5000;
    private static final String TAG = "NoticeCfgLanguageBaseManager";
    protected C11060c stat;

    public void downloadLanguage(String str, CommonLanguage commonLanguage) throws InterruptedException {
        String url;
        if (commonLanguage == null) {
            return;
        }
        C4896a c4896a = new C4896a(commonLanguage.getUrl(), str, 0L);
        for (int i10 = 0; i10 < 2; i10++) {
            try {
                url = c4896a.getUrl();
            } catch (C9721b e10) {
                String str2 = "retryNum:" + i10 + " error: " + e10.toString();
                NotifyLogger.m29914e(TAG, str2);
                reportDownloadInfo("1", str2, i10);
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e11) {
                    NotifyLogger.m29914e(TAG, "LanguageTask sleep exception:" + e11.toString());
                }
            }
            if (TextUtils.isEmpty(url)) {
                NotifyLogger.m29915i(TAG, "languageUrl null");
            } else if (URLUtil.isHttpsUrl(url)) {
                NotifyUtil.downloadFileToPath(str, url, c4896a);
                if (new File(str).exists()) {
                    setCurrentLanguageVersion(commonLanguage.getVersion());
                    setCurrentLanguageHash(commonLanguage.getHash());
                    reportDownloadInfo("0", "download", -1);
                    NotifyLogger.m29915i(TAG, "download language file success");
                } else {
                    continue;
                }
            } else {
                NotifyLogger.m29915i(TAG, "languageUrl not https");
            }
            return;
        }
    }

    public void parseDownloadConfig(String str, CommonLanguage commonLanguage) throws Throwable {
        try {
            NotifyLogger.m29915i(TAG, "parseDownloadConfig");
            if (TextUtils.isEmpty(commonLanguage.getHash()) || commonLanguage.getHash().equals(generateFileHash(str))) {
                onHashCheckSuccess(str);
            } else {
                NotifyLogger.m29914e(TAG, "notice language hash not equals");
            }
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "parse notice language xml exception:" + e10.toString());
        }
    }

    public abstract void clearCurrentLanguageDownloadResult();

    public abstract void clearLangVersionAndResult();

    public abstract void clearLanguageDb();

    public abstract boolean databaseHasRecord();

    public void deleteLanguageFile() {
        File file = new File(getLanguageFilePath());
        if (!file.exists() || file.delete()) {
            return;
        }
        NotifyLogger.m29914e(TAG, "delete language file failed.");
    }

    public void downloadAndParseLanguage(CommonLanguage commonLanguage, int i10) {
        C12515a.m75110o().m75175e(new LanguageTask(commonLanguage, i10, getLanguageFilePath()), false);
    }

    public void extractCommonLanguage(CommonLanguage commonLanguage) {
        if (commonLanguage == null) {
            NotifyLogger.m29914e(TAG, "extractLanguage commonLanguage is null");
            return;
        }
        if (TextUtils.isEmpty(commonLanguage.getUrl())) {
            NotifyLogger.m29914e(TAG, "extractLanguage languageUrl is null");
            return;
        }
        if (TextUtils.isEmpty(commonLanguage.getHash())) {
            NotifyLogger.m29914e(TAG, "extractLanguage languageHash is null");
            return;
        }
        if (needUpdateLanguageFile(commonLanguage)) {
            NotifyLogger.m29915i(TAG, "begin downloadAndParse notice language");
            downloadAndParseLanguage(commonLanguage, 1);
        } else {
            if (getExtractResult()) {
                return;
            }
            NotifyLogger.m29915i(TAG, "begin parse notice language");
            downloadAndParseLanguage(commonLanguage, 2);
        }
    }

    public String generateFileHash(String str) {
        try {
            File fileM63442h = C10278a.m63442h(str);
            return fileM63442h.exists() ? C11476b.m68622d(fileM63442h).getHash() : "";
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "generateFileHash exception:" + e10.toString());
            return "";
        }
    }

    public long getConfigSleepTime() {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            NotifyLogger.m29915i(TAG, "hiCloudSysParamMap is null,return default sleep duration:100ms");
            return 100L;
        }
        String cpuOffloadSleepDuration = hiCloudSysParamMapM60757p.getCpuOffloadSleepDuration();
        CPUOffloadSleepDuration cPUOffloadSleepDuration = (CPUOffloadSleepDuration) C10527a.m64629g(cpuOffloadSleepDuration, CPUOffloadSleepDuration.class);
        long common = cPUOffloadSleepDuration != null ? cPUOffloadSleepDuration.getCommon() : 100L;
        NotifyLogger.m29915i(TAG, "cpuOffloadSleepDuration config is:" + cpuOffloadSleepDuration + ",common sleepDuration is:" + common + "ms");
        return common;
    }

    public abstract String getCurrentLanguageHash();

    public abstract int getCurrentLanguageVersion();

    public abstract boolean getExtractResult();

    public abstract String getLanguageFilePath();

    public abstract AbstractRunnableC12516b.a getLanguageTaskEnum();

    public abstract C11060c getStat();

    public abstract void insertLanguageToDB(ArrayList<CommonLanguageDbString> arrayList);

    public boolean isCpuReductionOpen() {
        return C9733f.m60705z().m60720O("enableCPULoadReduction") || (C9733f.m60705z().m60720O("enableCPULoadReductionForBeta") && C0209d.m1193N0());
    }

    public boolean needUpdateLanguageFile(CommonLanguage commonLanguage) {
        int currentLanguageVersion = getCurrentLanguageVersion();
        String currentLanguageHash = getCurrentLanguageHash();
        NotifyLogger.m29915i(TAG, "current language version is: " + currentLanguageVersion + ", OM file language version is: " + commonLanguage.getVersion() + "currentHash is: " + currentLanguageHash + ", OM file language hash is: " + commonLanguage.getHash());
        return currentLanguageVersion < commonLanguage.getVersion() && !TextUtils.equals(currentLanguageHash, commonLanguage.getHash());
    }

    public void onHashCheckSuccess(String str) throws Throwable {
        clearCurrentLanguageDownloadResult();
        clearLanguageDb();
        parseLanguageFile(str);
    }

    public void parseLanguageEnd(String str, ArrayList<CommonLanguageDbString> arrayList) {
        if ("resource".equals(str) || "text".equals(str) || arrayList == null) {
            return;
        }
        printLog("parse Language end tag, insert to db, language name is: " + str);
        insertLanguageToDB(arrayList);
        arrayList.clear();
        tryToSleep();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.String] */
    public void parseLanguageFile(String str) throws Throwable {
        File file = new File(str);
        if (!file.exists()) {
            NotifyLogger.m29914e(TAG, "notice language xml not exist");
            return;
        }
        FileInputStream fileInputStream = null;
        ArrayList<CommonLanguageDbString> arrayList = null;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                registerListener();
                FileInputStream fileInputStream3 = new FileInputStream(file);
                try {
                    XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                    xmlPullParserNewPullParser.setInput(fileInputStream3, "utf-8");
                    String str2 = "";
                    for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                        String name = xmlPullParserNewPullParser.getName();
                        if (eventType != 2) {
                            if (eventType == 3) {
                                parseLanguageEnd(name, arrayList);
                            }
                        } else if ("resource".equals(name)) {
                            arrayList = new ArrayList<>();
                        } else if ("text".equals(name)) {
                            CommonLanguageDbString commonLanguageDbString = new CommonLanguageDbString();
                            String attributeValue = xmlPullParserNewPullParser.getAttributeValue(xmlPullParserNewPullParser.getNamespace(), "name");
                            String attributeValue2 = xmlPullParserNewPullParser.getAttributeValue(xmlPullParserNewPullParser.getNamespace(), "value");
                            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(attributeValue) && !TextUtils.isEmpty(attributeValue2)) {
                                commonLanguageDbString.setLanguage(str2);
                                commonLanguageDbString.setName(attributeValue);
                                commonLanguageDbString.setValue(attributeValue2);
                                if (arrayList != null) {
                                    arrayList.add(commonLanguageDbString);
                                }
                            }
                        } else {
                            str2 = name;
                        }
                    }
                    setExtractResult(true);
                    ?? r22 = "parse";
                    reportDownloadInfo("0", "parse", -1);
                    NotifyLogger.m29915i(TAG, "parse notice language xml success");
                    unregisterListener();
                    safeClose(fileInputStream3);
                    fileInputStream = r22;
                } catch (Exception e10) {
                    e = e10;
                    fileInputStream2 = fileInputStream3;
                    String str3 = "parse notice language xml error:" + e.toString();
                    NotifyLogger.m29914e(TAG, str3);
                    reportDownloadInfo("1", str3, -1);
                    unregisterListener();
                    fileInputStream = fileInputStream2;
                    if (fileInputStream2 != null) {
                        safeClose(fileInputStream2);
                        fileInputStream = fileInputStream2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream3;
                    unregisterListener();
                    if (fileInputStream != null) {
                        safeClose(fileInputStream);
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

    public void printLog(String str) {
    }

    public void registerListener() {
    }

    public void reportDownloadInfo(String str, String str2, int i10) {
        HashMap map = new HashMap();
        map.put("result", str);
        if (str2 != null) {
            map.put("err_reason", str2);
        }
        try {
            C13622a.m81969o(C0213f.m1377a(), getStat(), map);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "report exception:" + e10.toString());
        }
    }

    public void safeClose(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                NotifyLogger.m29914e(TAG, "safeClose exceptions:" + e10.toString());
            }
        }
    }

    public abstract void setCurrentLanguageHash(String str);

    public abstract void setCurrentLanguageVersion(int i10);

    public abstract void setExtractResult(boolean z10);

    public void tryToSleep() {
    }

    public void unregisterListener() {
    }

    public class LanguageTask extends AbstractC12367d {
        private String languageFilePath;
        private CountDownLatch mCountDownLatch;
        private CommonLanguage mLanguage;
        private int type;

        public LanguageTask(CommonLanguage commonLanguage, int i10, String str) {
            this.mLanguage = commonLanguage;
            this.type = i10;
            this.languageFilePath = str;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            CountDownLatch countDownLatch;
            CountDownLatch countDownLatch2;
            NotifyLogger.m29915i(NoticeCfgLanguageBaseManager.TAG, "LanguageTask call start, type = " + this.type);
            try {
                try {
                } catch (Exception e10) {
                    NotifyLogger.m29914e(NoticeCfgLanguageBaseManager.TAG, "LanguageTask exception, e: " + e10.toString());
                    countDownLatch2 = this.mCountDownLatch;
                    if (countDownLatch2 != null) {
                    }
                }
                if (TextUtils.isEmpty(this.languageFilePath)) {
                    NotifyLogger.m29914e(NoticeCfgLanguageBaseManager.TAG, "LanguageTask fail, xmlPath is empty");
                    if (countDownLatch != null) {
                        return;
                    } else {
                        return;
                    }
                }
                File file = new File(this.languageFilePath);
                if (this.type == 2 && !file.exists()) {
                    this.type = 1;
                }
                if (this.type == 1) {
                    if (file.exists() && file.delete()) {
                        NotifyLogger.m29915i(NoticeCfgLanguageBaseManager.TAG, "delete notice language success");
                    }
                    NoticeCfgLanguageBaseManager.this.downloadLanguage(this.languageFilePath, this.mLanguage);
                    NoticeCfgLanguageBaseManager.this.parseDownloadConfig(this.languageFilePath, this.mLanguage);
                } else {
                    NoticeCfgLanguageBaseManager.this.parseDownloadConfig(this.languageFilePath, this.mLanguage);
                }
                countDownLatch2 = this.mCountDownLatch;
                if (countDownLatch2 != null) {
                    countDownLatch2.countDown();
                }
                NotifyLogger.m29915i(NoticeCfgLanguageBaseManager.TAG, "LanguageTask call end");
            } finally {
                countDownLatch = this.mCountDownLatch;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return NoticeCfgLanguageBaseManager.this.getLanguageTaskEnum();
        }

        public LanguageTask(CommonLanguage commonLanguage, int i10, String str, CountDownLatch countDownLatch) {
            this.mLanguage = commonLanguage;
            this.type = i10;
            this.languageFilePath = str;
            this.mCountDownLatch = countDownLatch;
        }
    }
}
