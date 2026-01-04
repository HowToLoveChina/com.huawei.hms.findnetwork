package p029b5;

import android.content.Context;
import android.text.TextUtils;
import android.util.Xml;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p601r4.C12463c;
import p699v4.C13339h;

/* renamed from: b5.b */
/* loaded from: classes.dex */
public abstract class AbstractC1109b implements InterfaceC1118k {

    /* renamed from: a */
    public InputStream f5281a;

    @Override // p029b5.InterfaceC1118k
    /* renamed from: f */
    public boolean mo6615f(Context context, String str) throws XmlPullParserException, IOException {
        m6621k(context, str);
        boolean zM6623m = m6623m();
        m6620j();
        return zM6623m;
    }

    @Override // p029b5.InterfaceC1118k
    /* renamed from: i */
    public boolean mo6617i(File file) throws XmlPullParserException, IOException {
        m6622l(file);
        boolean zM6623m = m6623m();
        m6620j();
        return zM6623m;
    }

    /* renamed from: j */
    public final void m6620j() throws IOException {
        C13339h.m80014a(this.f5281a);
    }

    /* renamed from: k */
    public final void m6621k(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            C2111d.m12648d("AbstractXmlParser", "input param is invalid.");
            return;
        }
        try {
            this.f5281a = context.getAssets().open(str);
        } catch (IOException unused) {
            C2111d.m12648d("AbstractXmlParser", "open assets source failed.");
        }
    }

    /* renamed from: l */
    public final void m6622l(File file) {
        if (file == null || !file.exists()) {
            C2111d.m12653i("AbstractXmlParser", "xml file do not exist.");
            return;
        }
        try {
            this.f5281a = C12463c.m74719a(file);
        } catch (FileNotFoundException unused) {
            C2111d.m12648d("AbstractXmlParser", "xml file open failed.");
        }
    }

    /* renamed from: m */
    public final boolean m6623m() throws XmlPullParserException, IOException {
        C2111d.m12653i("AbstractXmlParser", "doParse: begin to parse xml");
        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
        try {
            xmlPullParserNewPullParser.setInput(this.f5281a, Constants.UTF_8);
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                if (eventType == 0) {
                    mo6629e();
                } else if (eventType == 2) {
                    mo6627c(xmlPullParserNewPullParser.getName());
                    m6624n(xmlPullParserNewPullParser);
                } else if (eventType == 3) {
                    mo6628d(xmlPullParserNewPullParser.getName());
                } else if (eventType == 4 && !xmlPullParserNewPullParser.isWhitespace()) {
                    mo6626b(xmlPullParserNewPullParser.getText());
                }
            }
            mo6625a();
            return true;
        } catch (IOException unused) {
            C2111d.m12648d("AbstractXmlParser", "doParse :IOException happen.");
            return false;
        } catch (XmlPullParserException unused2) {
            C2111d.m12648d("AbstractXmlParser", "doParse :XmlPullParserException happen.");
            return false;
        } catch (Exception unused3) {
            C2111d.m12648d("AbstractXmlParser", "doParse :Exception happen.");
            return false;
        }
    }

    /* renamed from: n */
    public final void m6624n(XmlPullParser xmlPullParser) {
        int attributeCount = xmlPullParser.getAttributeCount();
        if (attributeCount > 0) {
            HashMap map = new HashMap(attributeCount);
            for (int i10 = 0; i10 < attributeCount; i10++) {
                map.put(xmlPullParser.getAttributeName(i10), xmlPullParser.getAttributeValue(i10));
            }
            mo6630g(map);
        }
    }
}
