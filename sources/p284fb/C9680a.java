package p284fb;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.text.TextUtils;
import android.util.Xml;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.router.data.FamilyShareLanguageString;
import fk.C9721b;
import gb.C9902a;
import gb.C9903b;
import hk.C10280c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import no.C11739b;
import org.xmlpull.v1.XmlPullParser;
import p015ak.C0227m;
import p364ib.C10464a;
import p364ib.C10465b;
import p514o9.C11829c;
import p514o9.C11839m;
import p664u0.C13108a;

/* renamed from: fb.a */
/* loaded from: classes3.dex */
public class C9680a {

    /* renamed from: a */
    public Context f47890a;

    /* renamed from: b */
    public String f47891b;

    /* renamed from: c */
    public String f47892c;

    /* renamed from: d */
    public boolean f47893d;

    /* renamed from: e */
    public String f47894e;

    public C9680a(Context context, String str, String str2, boolean z10, String str3) {
        this.f47890a = context;
        this.f47891b = str;
        this.f47892c = str2;
        this.f47893d = z10;
        this.f47894e = str3;
    }

    /* renamed from: b */
    public static void m60460b(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                String str = "safeClose exceptions:" + e10.toString();
                C11839m.m70687e("FamilyShareLanguageDownloader", str);
                C10465b.m64306p(str);
            }
        }
    }

    /* renamed from: f */
    public static void m60461f(ArrayList<FamilyShareLanguageString> arrayList, String str) {
        if (str == null) {
            C11839m.m70687e("FamilyShareLanguageDownloader", "clearDB mXmlName is null.");
            C10465b.m64306p("clearDB mXmlName is null.");
        } else if (FamilyShareConstants.FamilyShareConfig.FAMILY_SHARE_PAGE_LANGUAGE_XML_NAME.equals(str)) {
            new C9903b().batchInsert(arrayList);
        } else if (FamilyShareConstants.FamilyShareConfig.CLOUD_SPACE_USAGE_LANGUAGE_XML_NAME.equals(str)) {
            new C9902a().batchInsert(arrayList);
        }
    }

    /* renamed from: g */
    public static void m60462g(Context context, String str, String str2) {
        m60463h(context, str, str2);
    }

    /* renamed from: h */
    public static boolean m60463h(Context context, String str, String str2) throws Throwable {
        File file = new File(str);
        if (!file.exists()) {
            C11839m.m70687e("FamilyShareLanguageDownloader", "language xml not exist");
            C10465b.m64306p("language xml not exist");
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
                                m60461f(arrayList, str2);
                                arrayList.clear();
                            }
                        } else if ("resource".equals(name)) {
                            arrayList = new ArrayList();
                        } else if ("text".equals(name)) {
                            FamilyShareLanguageString familyShareLanguageString = new FamilyShareLanguageString();
                            familyShareLanguageString.setName(xmlPullParserNewPullParser.getAttributeValue(xmlPullParserNewPullParser.getNamespace(), "name"));
                            familyShareLanguageString.setValue(xmlPullParserNewPullParser.getAttributeValue(xmlPullParserNewPullParser.getNamespace(), "value"));
                            familyShareLanguageString.setLanguage(str3);
                            if (arrayList != null) {
                                arrayList.add(familyShareLanguageString);
                            }
                        } else {
                            str3 = name;
                        }
                    }
                    C11839m.m70688i("FamilyShareLanguageDownloader", "parseLanguageXmlAndInsertDB " + str2 + " end.");
                    m60464i(context, str2);
                    HashMap map = new HashMap();
                    map.put("result", "0");
                    map.put("success_scription", "parseLanguageXmlAndInsertDB " + str2 + " end.");
                    C10464a.m64288a().m64290c(map);
                    m60460b(fileInputStream2);
                    return true;
                } catch (Exception e10) {
                    e = e10;
                    fileInputStream = fileInputStream2;
                    String str4 = "parseLanguageXml exception: " + e.toString();
                    C11839m.m70687e("FamilyShareLanguageDownloader", str4);
                    C10465b.m64306p(str4);
                    m60460b(fileInputStream);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    m60460b(fileInputStream);
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: i */
    public static void m60464i(Context context, String str) {
        if (FamilyShareConstants.FamilyShareConfig.CLOUD_SPACE_USAGE_LANGUAGE_XML_NAME.equals(str)) {
            if (new C9902a().hasRecord()) {
                C10465b.m64304n();
                return;
            } else {
                C11839m.m70688i("FamilyShareLanguageDownloader", "no language in db");
                return;
            }
        }
        if (FamilyShareConstants.FamilyShareConfig.FAMILY_SHARE_PAGE_LANGUAGE_XML_NAME.equals(str)) {
            Intent intent = new Intent();
            intent.setAction(FamilyShareConstants.BroadCast.FAMILY_SHARE_OM_CONFIG_DOWNLOAD_FINISHED_ACTION);
            C13108a.m78878b(context).m78881d(intent);
        }
    }

    /* renamed from: a */
    public final void m60465a() throws SQLException {
        String str = this.f47892c;
        if (str == null) {
            C11839m.m70687e("FamilyShareLanguageDownloader", "clearDB mXmlName is null.");
            C10465b.m64306p("clearDB mXmlName is null.");
        } else if (FamilyShareConstants.FamilyShareConfig.FAMILY_SHARE_PAGE_LANGUAGE_XML_NAME.equals(str)) {
            new C9903b().clearDB();
        } else if (FamilyShareConstants.FamilyShareConfig.CLOUD_SPACE_USAGE_LANGUAGE_XML_NAME.equals(this.f47892c)) {
            new C9902a().clearDB();
        }
    }

    /* renamed from: c */
    public final void m60466c(Context context) {
        boolean zDelete;
        String str = this.f47892c;
        if (str == null) {
            C11839m.m70687e("FamilyShareLanguageDownloader", "deleteLocalFile mXmlName is null.");
            C10465b.m64306p("deleteLocalFile mXmlName is null.");
            return;
        }
        String str2 = "";
        if (FamilyShareConstants.FamilyShareConfig.FAMILY_SHARE_PAGE_LANGUAGE_XML_NAME.equals(str)) {
            str2 = "" + FamilyShareConstants.FamilyShareConfig.FAMILY_SHARE_PAGE_LANGUAGE_XML_NAME_LOCAL;
        } else if (FamilyShareConstants.FamilyShareConfig.CLOUD_SPACE_USAGE_LANGUAGE_XML_NAME.equals(this.f47892c)) {
            str2 = "" + FamilyShareConstants.FamilyShareConfig.CLOUD_SPACE_USAGE_LANGUAGE_XML_NAME_LOCAL;
        }
        try {
            File file = new File(context.getFilesDir() + File.separator + str2);
            if (!file.exists() || (zDelete = file.delete())) {
                return;
            }
            C11839m.m70687e("FamilyShareLanguageDownloader", "deleteLocalFile is:" + zDelete);
        } catch (Exception e10) {
            String str3 = "deleteLocalFile exception:" + e10.toString();
            C11839m.m70687e("FamilyShareLanguageDownloader", str3);
            C10465b.m64306p(str3);
        }
    }

    /* renamed from: d */
    public final String m60467d(String str) {
        try {
            return C0227m.m1591d(str);
        } catch (Exception e10) {
            C11839m.m70687e("FamilyShareLanguageDownloader", "generateFileHash exceptions:" + e10.toString());
            return "";
        }
    }

    /* renamed from: e */
    public final String m60468e() {
        String str = this.f47892c;
        if (str == null) {
            C11839m.m70687e("FamilyShareLanguageDownloader", "getStoragePath mXmlName is null.");
            C10465b.m64306p("getStoragePath mXmlName is null.");
            return null;
        }
        String str2 = "";
        if (FamilyShareConstants.FamilyShareConfig.FAMILY_SHARE_PAGE_LANGUAGE_XML_NAME.equals(str)) {
            if (this.f47893d) {
                str2 = "" + FamilyShareConstants.FamilyShareConfig.FAMILY_SHARE_PAGE_LANGUAGE_XML_NAME_CLOUD;
            } else {
                str2 = "" + FamilyShareConstants.FamilyShareConfig.FAMILY_SHARE_PAGE_LANGUAGE_XML_NAME_LOCAL;
            }
        } else if (FamilyShareConstants.FamilyShareConfig.CLOUD_SPACE_USAGE_LANGUAGE_XML_NAME.equals(this.f47892c)) {
            if (this.f47893d) {
                str2 = "" + FamilyShareConstants.FamilyShareConfig.CLOUD_SPACE_USAGE_LANGUAGE_XML_NAME_CLOUD;
            } else {
                str2 = "" + FamilyShareConstants.FamilyShareConfig.CLOUD_SPACE_USAGE_LANGUAGE_XML_NAME_LOCAL;
            }
        }
        return this.f47890a.getFilesDir() + "/" + str2;
    }

    /* renamed from: j */
    public boolean m60469j() {
        File file;
        C11839m.m70688i("FamilyShareLanguageDownloader", "start mXmlName = " + this.f47892c);
        if (TextUtils.isEmpty(this.f47891b) || TextUtils.isEmpty(this.f47892c) || this.f47890a == null) {
            C11839m.m70689w("FamilyShareLanguageDownloader", "FamilyShareLanguageDownloader conditions is null.");
            C10465b.m64306p("FamilyShareLanguageDownloader conditions is null.");
            return false;
        }
        String strM60468e = m60468e();
        if (this.f47893d) {
            C11839m.m70688i("FamilyShareLanguageDownloader", "start download cloud language");
            C11839m.m70686d("FamilyShareLanguageDownloader", "mUrl = " + this.f47891b);
            C11839m.m70686d("FamilyShareLanguageDownloader", "xmlPath = " + strM60468e);
            String strM60467d = m60467d(strM60468e);
            C11839m.m70686d("FamilyShareLanguageDownloader", "local language hash：" + strM60467d);
            C11839m.m70686d("FamilyShareLanguageDownloader", "cloud language hash：" + this.f47894e);
            if (TextUtils.isEmpty(this.f47894e) || !TextUtils.equals(this.f47894e, strM60467d)) {
                m60466c(this.f47890a);
                C11739b c11739b = new C11739b(this.f47891b, strM60468e, 0L);
                for (int i10 = 0; i10 < 2; i10++) {
                    try {
                        C11829c.m70595m(strM60468e, c11739b.m70044b(), c11739b);
                        file = new File(strM60468e);
                    } catch (C9721b e10) {
                        String str = "download language failed: " + e10.toString();
                        C11839m.m70687e("FamilyShareLanguageDownloader", str + " retryNum = " + i10);
                        C10465b.m64307q(str, i10);
                        try {
                            Thread.sleep(5000L);
                        } catch (InterruptedException unused) {
                            String str2 = "LanguageTask sleep exception: " + e10.toString();
                            C11839m.m70687e("FamilyShareLanguageDownloader", str2);
                            C10465b.m64306p(str2);
                        }
                    }
                    if (file.exists()) {
                        C11839m.m70688i("FamilyShareLanguageDownloader", "download language xml success");
                        break;
                    }
                    String strM60467d2 = m60467d(strM60468e);
                    C11839m.m70686d("FamilyShareLanguageDownloader", "download local language hash：" + strM60467d2);
                    if (!TextUtils.equals(this.f47894e, strM60467d2)) {
                        C11839m.m70689w("FamilyShareLanguageDownloader", "file hash error : server language hash is not equals to download file");
                        if (!file.delete()) {
                            C11839m.m70689w("FamilyShareLanguageDownloader", "xmlFile is delete failed");
                        }
                    }
                }
            }
        } else {
            C11839m.m70688i("FamilyShareLanguageDownloader", "start download local language");
            C10280c.m63455c(this.f47890a, this.f47892c, strM60468e);
        }
        m60465a();
        return m60463h(this.f47890a, strM60468e, this.f47892c);
    }
}
