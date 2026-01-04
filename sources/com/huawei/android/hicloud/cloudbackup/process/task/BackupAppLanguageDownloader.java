package com.huawei.android.hicloud.cloudbackup.process.task;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import com.huawei.android.hicloud.cloudbackup.bean.BackupAppLanguageDbString;
import com.huawei.android.hicloud.cloudbackup.bean.BlackModuleItem;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import fk.C9721b;
import hk.C10279b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import nl.C11719a;
import no.C11739b;
import org.xmlpull.v1.XmlPullParser;
import p015ak.C0227m;
import p514o9.C11829c;
import p514o9.C11839m;
import p526ol.C11960a;
import p618rm.C12590s0;

/* loaded from: classes2.dex */
public class BackupAppLanguageDownloader {
    private static final int MAX_RETRY = 2;
    private static final String TAG = "BackupAppLanguageDownloader";
    private Context mContext;
    private String mHash;
    private String mUrl;
    private String xmlPath;

    public BackupAppLanguageDownloader(Context context, String str, String str2) {
        this.mContext = context;
        this.mUrl = str;
        this.mHash = str2;
    }

    private boolean checkBlackPropertyHash(String str) {
        if (TextUtils.isEmpty(this.mHash) || this.mHash.equals(generateFileHash(str))) {
            return true;
        }
        C11839m.m70687e(TAG, "black property file hash not equals");
        return false;
    }

    private void clearBlackModulesDB() {
        new C11719a().clear();
    }

    private void closeXmlInputStream(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                C11839m.m70687e(TAG, "safeClose exceptions:" + e10.toString());
            }
        }
    }

    private String generateFileHash(String str) {
        try {
            return C0227m.m1591d(str);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "generateFileHash exceptions:" + e10.toString());
            return "";
        }
    }

    private String getBlackPropertiesPath() {
        return this.mContext.getFilesDir() + "/hicloud_backup_black.properties";
    }

    private String getStoragePath() {
        return this.mContext.getFilesDir() + "/" + ("hicloud_backup_app_language.xml");
    }

    private String getTmpBlackModulePath() {
        return getBlackModulePath() + ".tmp";
    }

    private String getTmpStoragePath() {
        return getStoragePath() + ".tmp";
    }

    private boolean hashCheck(String str) {
        if (TextUtils.isEmpty(this.mHash) || this.mHash.equals(generateFileHash(str))) {
            return true;
        }
        C11839m.m70687e(TAG, "language hash not equals");
        return false;
    }

    private boolean insertBlackModuleDB(ArrayList<BlackModuleItem> arrayList) {
        C11719a c11719a = new C11719a();
        try {
            clearBlackModulesDB();
            c11719a.m69916a(arrayList);
            return true;
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "insertDataToDB exceptions:" + e10.toString());
            return false;
        }
    }

    private void insertDataToDB(ArrayList<BackupAppLanguageDbString> arrayList) {
        try {
            new C11960a().m71936a(arrayList);
        } catch (Exception e10) {
            C11839m.m70687e(TAG, "insertDataToDB exceptions:" + e10.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0090 A[Catch: IOException -> 0x0094, TRY_LEAVE, TryCatch #3 {IOException -> 0x0094, blocks: (B:103:0x008b, B:105:0x0090), top: B:110:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean parsePropertiesFile(java.io.InputStream r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.String r0 = "close input failed."
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            java.lang.String r3 = "BackupAppLanguageDownloader"
            if (r11 != 0) goto L12
            java.lang.String r10 = "input stream is null."
            p514o9.C11839m.m70688i(r3, r10)
            return r2
        L12:
            r4 = 0
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6e
            java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6e
            r5.<init>(r11, r6)     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6e
            java.io.BufferedReader r11 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
            r11.<init>(r5)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L69
        L1f:
            java.lang.String r4 = r11.readLine()     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            if (r4 == 0) goto L56
            java.lang.String r6 = ":"
            java.lang.String[] r4 = r4.split(r6)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            com.huawei.android.hicloud.cloudbackup.bean.BlackModuleItem r6 = new com.huawei.android.hicloud.cloudbackup.bean.BlackModuleItem     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            r6.<init>()     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            int r7 = r4.length     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            r8 = 3
            if (r7 < r8) goto L1f
            r7 = r4[r2]     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            r8 = 1
            r8 = r4[r8]     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            int r8 = p015ak.C0241z.m1685c(r8)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            r9 = 2
            r4 = r4[r9]     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            int r4 = p015ak.C0241z.m1685c(r4)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            r6.setAppId(r7)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            r6.setType(r8)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            r6.setFlag(r4)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            r1.add(r6)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            goto L1f
        L51:
            r10 = move-exception
        L52:
            r4 = r5
            goto L89
        L54:
            r4 = r5
            goto L6f
        L56:
            java.lang.String r4 = "read local black modules success."
            p399jk.AbstractC10896a.m65887i(r3, r4)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            r5.close()     // Catch: java.io.IOException -> L62
        L5e:
            r11.close()     // Catch: java.io.IOException -> L62
            goto L7c
        L62:
            p399jk.AbstractC10896a.m65886e(r3, r0)
            goto L7c
        L66:
            r10 = move-exception
            r11 = r4
            goto L52
        L69:
            r11 = r4
            goto L54
        L6b:
            r10 = move-exception
            r11 = r4
            goto L89
        L6e:
            r11 = r4
        L6f:
            java.lang.String r5 = "read local black modules failed."
            p399jk.AbstractC10896a.m65886e(r3, r5)     // Catch: java.lang.Throwable -> L88
            if (r4 == 0) goto L79
            r4.close()     // Catch: java.io.IOException -> L62
        L79:
            if (r11 == 0) goto L7c
            goto L5e
        L7c:
            int r11 = r1.size()
            if (r11 <= 0) goto L87
            boolean r10 = r10.insertBlackModuleDB(r1)
            return r10
        L87:
            return r2
        L88:
            r10 = move-exception
        L89:
            if (r4 == 0) goto L8e
            r4.close()     // Catch: java.io.IOException -> L94
        L8e:
            if (r11 == 0) goto L97
            r11.close()     // Catch: java.io.IOException -> L94
            goto L97
        L94:
            p399jk.AbstractC10896a.m65886e(r3, r0)
        L97:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.cloudbackup.process.task.BackupAppLanguageDownloader.parsePropertiesFile(java.io.InputStream):boolean");
    }

    public void clearDB() {
        new C11960a().clear();
    }

    public String getBlackModulePath() {
        return this.mContext.getFilesDir() + "/hicloud_backup_black.zip";
    }

    public boolean parseBlackModuleAndInsertDB(File file) {
        if (parseOmPropertiesFile(file)) {
            return true;
        }
        boolean zM69919d = new C11719a().m69919d();
        C11839m.m70688i(TAG, "parseBlackModuleAndInsertDB hasBlackModules, do not read local");
        if (zM69919d) {
            return true;
        }
        return parseLocalPropertiesFile();
    }

    public boolean parseLanguageXmlAndInsertDB(String str) throws Throwable {
        Throwable th2;
        FileInputStream fileInputStream;
        Exception e10;
        File file = new File(str);
        if (!file.exists()) {
            C11839m.m70687e(TAG, "language xml not exist");
            return false;
        }
        ArrayList<BackupAppLanguageDbString> arrayList = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception e11) {
                fileInputStream = null;
                e10 = e11;
            } catch (Throwable th3) {
                th2 = th3;
                closeXmlInputStream(null);
                throw th2;
            }
            try {
                XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                xmlPullParserNewPullParser.setInput(fileInputStream, "utf-8");
                String str2 = "";
                for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType != 2) {
                        if (eventType == 3 && !"resource".equals(name) && !"text".equals(name) && arrayList != null) {
                            insertDataToDB(arrayList);
                            arrayList.clear();
                        }
                    } else if ("resource".equals(name)) {
                        arrayList = new ArrayList<>();
                    } else if ("text".equals(name)) {
                        BackupAppLanguageDbString backupAppLanguageDbString = new BackupAppLanguageDbString();
                        backupAppLanguageDbString.setTextName(xmlPullParserNewPullParser.getAttributeValue(xmlPullParserNewPullParser.getNamespace(), "name"));
                        backupAppLanguageDbString.setTextValue(xmlPullParserNewPullParser.getAttributeValue(xmlPullParserNewPullParser.getNamespace(), "value"));
                        backupAppLanguageDbString.setLanguageName(str2);
                        if (arrayList != null) {
                            arrayList.add(backupAppLanguageDbString);
                        }
                    } else {
                        str2 = name;
                    }
                }
                closeXmlInputStream(fileInputStream);
                return true;
            } catch (Exception e12) {
                e10 = e12;
                String str3 = "parseLanguageXml exception: " + e10.toString();
                C11839m.m70687e(TAG, str3);
                CloudBackupReport.reportOmError(str3);
                closeXmlInputStream(fileInputStream);
                return false;
            }
        } catch (Throwable th4) {
            th2 = th4;
            closeXmlInputStream(null);
            throw th2;
        }
    }

    public boolean parseLocalPropertiesFile() {
        C11839m.m70688i(TAG, "parse local properties file start.");
        try {
            return parsePropertiesFile(this.mContext.getAssets().open("hicloud_backup_black.properties"));
        } catch (IOException unused) {
            C11839m.m70687e(TAG, "open local black modules file error.");
            return false;
        }
    }

    public boolean parseOmPropertiesFile(File file) throws Throwable {
        String strM63452a = C10279b.m63452a(file);
        if (!C12590s0.m75805U2(C10279b.m63452a(file), this.mContext.getFilesDir() + "/")) {
            C11839m.m70688i(TAG, "unzip file fail: " + strM63452a);
            return false;
        }
        String blackPropertiesPath = getBlackPropertiesPath();
        C11839m.m70688i(TAG, "parse om properties file start, file path: " + blackPropertiesPath);
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(new File(blackPropertiesPath));
                try {
                    boolean propertiesFile = parsePropertiesFile(fileInputStream2);
                    try {
                        fileInputStream2.close();
                    } catch (IOException e10) {
                        C11839m.m70687e(TAG, "parse om properties file error: " + e10.getMessage());
                    }
                    return propertiesFile;
                } catch (FileNotFoundException e11) {
                    e = e11;
                    fileInputStream = fileInputStream2;
                    C11839m.m70687e(TAG, "parse om properties file error: " + e.toString());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e12) {
                            C11839m.m70687e(TAG, "parse om properties file error: " + e12.getMessage());
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e13) {
                            C11839m.m70687e(TAG, "parse om properties file error: " + e13.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e14) {
                e = e14;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public boolean start() throws C9721b {
        if (TextUtils.isEmpty(this.mUrl) || this.mContext == null) {
            C11839m.m70687e(TAG, "BackupAppLanguageDownloader conditions is null.");
            return false;
        }
        this.xmlPath = getStoragePath();
        File file = new File(this.xmlPath);
        C11839m.m70688i(TAG, "start download backup app language");
        C11839m.m70686d(TAG, "mUrl = " + this.mUrl);
        String tmpStoragePath = getTmpStoragePath();
        C11739b c11739b = new C11739b(this.mUrl, tmpStoragePath, 0L);
        for (int i10 = 0; i10 < 2; i10++) {
            C11829c.m70595m(tmpStoragePath, c11739b.m70044b(), c11739b);
            File file2 = new File(tmpStoragePath);
            if (!file2.exists()) {
                C11839m.m70688i(TAG, "download language xml failed");
            } else if (hashCheck(tmpStoragePath)) {
                C11839m.m70688i(TAG, "xml file hash equals");
                if (file2.renameTo(file)) {
                    clearDB();
                    return parseLanguageXmlAndInsertDB(this.xmlPath);
                }
                C11839m.m70686d(TAG, "tempXmlFile rename failed");
                return false;
            }
        }
        return false;
    }

    public boolean startDownloadBlackModule() throws C9721b {
        if (TextUtils.isEmpty(this.mUrl) || this.mContext == null) {
            C11839m.m70687e(TAG, "BackupAppLanguageDownloader conditions is null.");
            return false;
        }
        File file = new File(getBlackModulePath());
        C11839m.m70688i(TAG, "start download backup black property file.");
        C11839m.m70686d(TAG, "mUrl = " + this.mUrl);
        String tmpBlackModulePath = getTmpBlackModulePath();
        C11739b c11739b = new C11739b(this.mUrl, tmpBlackModulePath, 0L);
        for (int i10 = 0; i10 < 2; i10++) {
            C11829c.m70595m(tmpBlackModulePath, c11739b.m70044b(), c11739b);
            File file2 = new File(tmpBlackModulePath);
            if (!file2.exists()) {
                C11839m.m70688i(TAG, "download black property file failed.");
            } else if (checkBlackPropertyHash(tmpBlackModulePath)) {
                C11839m.m70688i(TAG, "black property file hash equals, delete origin file: " + file.delete());
                if (file2.renameTo(file)) {
                    return parseBlackModuleAndInsertDB(file);
                }
                C11839m.m70686d(TAG, "black file rename failed");
                return false;
            }
        }
        return false;
    }
}
