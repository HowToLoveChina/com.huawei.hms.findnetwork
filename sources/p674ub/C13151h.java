package p674ub;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import android.webkit.URLUtil;
import com.huawei.hicloud.notification.p106db.bean.UrgencyLanguage;
import com.huawei.hicloud.notification.p106db.bean.UrgencyString;
import com.huawei.hicloud.notification.p106db.operator.UrgencyLanguageOperator;
import com.huawei.hms.push.constant.RemoteMessageConst;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import mk.C11476b;
import no.C11739b;
import org.xmlpull.v1.XmlPullParser;
import p015ak.C0213f;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;

/* renamed from: ub.h */
/* loaded from: classes3.dex */
public class C13151h extends AbstractC12367d {

    /* renamed from: a */
    public UrgencyLanguage f59646a;

    /* renamed from: b */
    public String f59647b;

    public C13151h(UrgencyLanguage urgencyLanguage) {
        this.f59646a = urgencyLanguage;
    }

    /* renamed from: c */
    public final void m79067c() {
        new UrgencyLanguageOperator().clear();
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws Throwable {
        String strM70044b;
        C11839m.m70688i("QueryUrgencyNoticeConfigTask", "UrgencyLanguageTask call start");
        if (this.f59646a != null) {
            Context contextM1378b = C0213f.m1378b();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(contextM1378b.getFilesDir());
            String str = File.separator;
            sb2.append(str);
            sb2.append(RemoteMessageConst.URGENCY);
            sb2.append(str);
            sb2.append("language.xml");
            this.f59647b = sb2.toString();
            File file = new File(this.f59647b);
            String strGenerateFileHash = generateFileHash();
            C11839m.m70686d("QueryUrgencyNoticeConfigTask", "xmlPath = " + this.f59647b);
            C11839m.m70686d("QueryUrgencyNoticeConfigTask", "local language hash：" + strGenerateFileHash);
            C11839m.m70686d("QueryUrgencyNoticeConfigTask", "cloud language hash：" + this.f59646a.getHash());
            if (!TextUtils.isEmpty(this.f59646a.getHash()) && this.f59646a.getHash().equals(strGenerateFileHash)) {
                try {
                    m79067c();
                    parseLanguageXml();
                } catch (Exception e10) {
                    C11839m.m70687e("QueryUrgencyNoticeConfigTask", "parseLanguageXml exception:" + e10.toString());
                }
                C11839m.m70688i("QueryUrgencyNoticeConfigTask", "UrgencyLanguageTask !TextUtils.isEmpty(mLanguage.getHash()) && mLanguage.getHash().equals(generateFileHash())");
                return;
            }
            if (file.delete()) {
                C11839m.m70687e("QueryUrgencyNoticeConfigTask", "parseLanguageXml tmpFile delete true!");
            }
            C11739b c11739b = new C11739b(this.f59646a.getUrl(), this.f59647b, 0L);
            for (int i10 = 0; i10 < 2; i10++) {
                try {
                    strM70044b = c11739b.m70044b();
                } catch (C9721b e11) {
                    e = e11;
                }
                if (TextUtils.isEmpty(strM70044b)) {
                    C11839m.m70688i("QueryUrgencyNoticeConfigTask", "langUrl null");
                } else if (URLUtil.isHttpsUrl(strM70044b)) {
                    C11829c.m70595m(this.f59647b, strM70044b, c11739b);
                    File file2 = new File(this.f59647b);
                    try {
                    } catch (C9721b e12) {
                        e = e12;
                        file = file2;
                        C11839m.m70687e("QueryUrgencyNoticeConfigTask", "download language failed:" + e.toString());
                        try {
                            Thread.sleep(5000L);
                        } catch (InterruptedException e13) {
                            C11839m.m70687e("QueryUrgencyNoticeConfigTask", "LanguageTask sleep exception:" + e13.toString());
                        }
                    }
                    if (file2.exists()) {
                        C11839m.m70688i("QueryUrgencyNoticeConfigTask", "download language xml success");
                        file = file2;
                    } else {
                        file = file2;
                    }
                } else {
                    C11839m.m70688i("QueryUrgencyNoticeConfigTask", "langUrl not https");
                }
            }
            try {
                String strGenerateFileHash2 = generateFileHash();
                C11839m.m70686d("QueryUrgencyNoticeConfigTask", "download local language file hash ：" + strGenerateFileHash2);
                if (TextUtils.isEmpty(this.f59646a.getHash()) || this.f59646a.getHash().equals(strGenerateFileHash2)) {
                    m79067c();
                    parseLanguageXml();
                } else {
                    C11839m.m70687e("QueryUrgencyNoticeConfigTask", "file hash error : server language hash is not equals to download file");
                    if (!file.delete()) {
                        C11839m.m70688i("QueryUrgencyNoticeConfigTask", "tmp config file is delete failed");
                    }
                }
                C11839m.m70686d("QueryUrgencyNoticeConfigTask", "local language：" + generateFileHash());
            } catch (Exception e14) {
                C11839m.m70687e("QueryUrgencyNoticeConfigTask", "parseLanguageXml exception:" + e14.toString());
            }
        } else {
            C11839m.m70687e("QueryUrgencyNoticeConfigTask", "LanguageTask language null");
        }
        C11839m.m70688i("QueryUrgencyNoticeConfigTask", "LanguageTask call end");
    }

    public final String generateFileHash() {
        try {
            File fileM63442h = C10278a.m63442h(this.f59647b);
            return fileM63442h.exists() ? C11476b.m68622d(fileM63442h).getHash() : "";
        } catch (Exception e10) {
            C11839m.m70687e("QueryUrgencyNoticeConfigTask", "generateFileHash exceptions:" + e10.toString());
            return "";
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.SYNC_CONFIG;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11 */
    public void parseLanguageXml() throws Throwable {
        File file = new File(this.f59647b);
        if (!file.exists()) {
            C11839m.m70687e("QueryUrgencyNoticeConfigTask", "language xml not exist");
            return;
        }
        FileInputStream fileInputStream = null;
        ArrayList arrayList = 0;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                FileInputStream fileInputStream3 = new FileInputStream(file);
                try {
                    XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                    xmlPullParserNewPullParser.setInput(fileInputStream3, "utf-8");
                    int eventType = xmlPullParserNewPullParser.getEventType();
                    String str = "";
                    while (eventType != 1) {
                        String name = xmlPullParserNewPullParser.getName();
                        if (eventType != 2) {
                            if (eventType == 3 && !"resource".equals(name) && !"text".equals(name) && arrayList != 0) {
                                new UrgencyLanguageOperator().batchInsert(arrayList);
                                arrayList.clear();
                            }
                        } else if ("resource".equals(name)) {
                            arrayList = new ArrayList();
                        } else if ("text".equals(name)) {
                            UrgencyString urgencyString = new UrgencyString();
                            urgencyString.setVersion(String.valueOf(this.f59646a.getVersion()));
                            urgencyString.setName(xmlPullParserNewPullParser.getAttributeValue(xmlPullParserNewPullParser.getNamespace(), "name"));
                            urgencyString.setValue(xmlPullParserNewPullParser.getAttributeValue(xmlPullParserNewPullParser.getNamespace(), "value"));
                            urgencyString.setCountry(str);
                            if (arrayList != 0) {
                                arrayList.add(urgencyString);
                            }
                        } else {
                            str = name;
                        }
                        eventType = xmlPullParserNewPullParser.next();
                        arrayList = arrayList;
                    }
                    safeClose(fileInputStream3);
                    fileInputStream = arrayList;
                } catch (Exception e10) {
                    e = e10;
                    fileInputStream2 = fileInputStream3;
                    C11839m.m70687e("QueryUrgencyNoticeConfigTask", "parseLanguageXml exception:" + e.toString());
                    fileInputStream = fileInputStream2;
                    if (fileInputStream2 != null) {
                        safeClose(fileInputStream2);
                        fileInputStream = fileInputStream2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream3;
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

    public final void safeClose(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                C11839m.m70687e("QueryUrgencyNoticeConfigTask", "safeClose exceptions:" + e10.toString());
            }
        }
    }
}
