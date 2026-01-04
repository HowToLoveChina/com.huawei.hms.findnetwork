package com.huawei.hicloud.notification.spacelanguage.manager;

import android.content.Context;
import android.database.SQLException;
import android.text.TextUtils;
import android.util.Xml;
import com.huawei.hicloud.download.C4896a;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.spacelanguage.bean.SpaceMultLanguageString;
import com.huawei.hicloud.notification.spacelanguage.operator.SpaceMultLanguageOperator;
import com.huawei.hicloud.notification.util.NotifyUtil;
import fk.C9721b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import p015ak.C0227m;

/* loaded from: classes6.dex */
public class SpaceMultLanguageDownloader {
    private static final int MAX_RETRY = 2;
    private static final int RETRY_TIME_INTERVAL = 5000;
    private static final String TAG = "SpaceMultLanguageDownloader";
    private Context mContext;
    private String mHash;
    private String mUrl;
    private String mXmlName;

    public SpaceMultLanguageDownloader(Context context, String str, String str2, String str3) {
        this.mContext = context;
        this.mUrl = str;
        this.mXmlName = str2;
        this.mHash = str3;
    }

    private void clearDB() throws SQLException {
        if (this.mXmlName == null) {
            NotifyLogger.m29914e(TAG, "clearDB mXmlName is null.");
        } else {
            new SpaceMultLanguageOperator().clearDB();
        }
    }

    private static void closeXmlInputStream(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                NotifyLogger.m29914e(TAG, "safeClose exceptions:" + e10.toString());
            }
        }
    }

    private String generateFileHash(String str) {
        try {
            return C0227m.m1591d(str);
        } catch (Exception e10) {
            NotifyLogger.m29914e(TAG, "generateFileHash exceptions:" + e10.toString());
            return "";
        }
    }

    private String getStoragePath() {
        String str = this.mXmlName;
        if (str == null) {
            NotifyLogger.m29914e(TAG, "getStoragePath mXmlName is null.");
            return null;
        }
        String str2 = "";
        if (RecommendCardConstants.spaceLanguage.SPACE_MULT_LANGUAGE_XML_NAME.equals(str)) {
            str2 = "" + RecommendCardConstants.spaceLanguage.SPACE_MULT_LANGUAGE_XML_NAME_CLOUD;
        }
        return this.mContext.getFilesDir() + "/" + str2;
    }

    private static void insertDataToDB(ArrayList<SpaceMultLanguageString> arrayList, String str) {
        if (str == null) {
            NotifyLogger.m29914e(TAG, "clearDB mXmlName is null.");
        } else {
            new SpaceMultLanguageOperator().batchInsert(arrayList);
        }
    }

    public static void parseLanguageXml(Context context, String str, String str2) {
        parseLanguageXmlAndInsertDB(context, str, str2);
    }

    private static boolean parseLanguageXmlAndInsertDB(Context context, String str, String str2) throws Throwable {
        File file = new File(str);
        if (!file.exists()) {
            NotifyLogger.m29914e(TAG, "language xml not exist");
            return false;
        }
        FileInputStream fileInputStream = null;
        ArrayList arrayList = null;
        fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                    xmlPullParserNewPullParser.setInput(fileInputStream2, "utf-8");
                    String str3 = "";
                    for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                        String name = xmlPullParserNewPullParser.getName();
                        if (eventType != 2) {
                            if (eventType == 3 && !"resource".equals(name) && !"text".equals(name) && arrayList != null) {
                                insertDataToDB(arrayList, str2);
                                arrayList.clear();
                            }
                        } else if ("resource".equals(name)) {
                            arrayList = new ArrayList();
                        } else if ("text".equals(name)) {
                            SpaceMultLanguageString spaceMultLanguageString = new SpaceMultLanguageString();
                            spaceMultLanguageString.setName(xmlPullParserNewPullParser.getAttributeValue(xmlPullParserNewPullParser.getNamespace(), "name"));
                            spaceMultLanguageString.setValue(xmlPullParserNewPullParser.getAttributeValue(xmlPullParserNewPullParser.getNamespace(), "value"));
                            spaceMultLanguageString.setLanguage(str3);
                            if (arrayList != null) {
                                arrayList.add(spaceMultLanguageString);
                            }
                        } else {
                            str3 = name;
                        }
                    }
                    NotifyLogger.m29915i(TAG, "parseLanguageXmlAndInsertDB " + str2 + " end.");
                    closeXmlInputStream(fileInputStream2);
                    return true;
                } catch (Exception e10) {
                    e = e10;
                    fileInputStream = fileInputStream2;
                    NotifyLogger.m29914e(TAG, "parseLanguageXml exception: " + e.toString());
                    closeXmlInputStream(fileInputStream);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    closeXmlInputStream(fileInputStream);
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public boolean start() throws InterruptedException, SQLException {
        File file;
        NotifyLogger.m29915i(TAG, "start mXmlName = " + this.mXmlName);
        if (TextUtils.isEmpty(this.mUrl) || TextUtils.isEmpty(this.mXmlName) || this.mContext == null) {
            NotifyLogger.m29916w(TAG, "SpaceMultLanguageDownloader conditions is null.");
            return false;
        }
        String storagePath = getStoragePath();
        NotifyLogger.m29915i(TAG, "start download cloud language");
        NotifyLogger.m29913d(TAG, "mUrl = " + this.mUrl);
        NotifyLogger.m29913d(TAG, "xmlPath = " + storagePath);
        String strGenerateFileHash = generateFileHash(storagePath);
        NotifyLogger.m29913d(TAG, "local language hash：" + strGenerateFileHash);
        NotifyLogger.m29913d(TAG, "cloud language hash：" + this.mHash);
        if (TextUtils.isEmpty(this.mHash) || !TextUtils.equals(this.mHash, strGenerateFileHash)) {
            C4896a c4896a = new C4896a(storagePath, 0L);
            for (int i10 = 0; i10 < 2; i10++) {
                try {
                    NotifyUtil.downloadFileToPath(storagePath, this.mUrl, c4896a);
                    file = new File(storagePath);
                } catch (C9721b e10) {
                    NotifyLogger.m29914e(TAG, ("download language failed: " + e10.toString()) + " retryNum = " + i10);
                    try {
                        Thread.sleep(5000L);
                    } catch (InterruptedException unused) {
                        NotifyLogger.m29914e(TAG, "LanguageTask sleep exception: " + e10.toString());
                    }
                }
                if (file.exists()) {
                    NotifyLogger.m29915i(TAG, "download language xml success");
                    break;
                }
                String strGenerateFileHash2 = generateFileHash(storagePath);
                NotifyLogger.m29913d(TAG, "download local language hash：" + strGenerateFileHash2);
                if (!TextUtils.equals(this.mHash, strGenerateFileHash2)) {
                    NotifyLogger.m29916w(TAG, "file hash error : server language hash is not equals to download file");
                    if (!file.delete()) {
                        NotifyLogger.m29916w(TAG, "xmlFile is delete failed");
                    }
                }
            }
        }
        clearDB();
        return parseLanguageXmlAndInsertDB(this.mContext, storagePath, this.mXmlName);
    }
}
