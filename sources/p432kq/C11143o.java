package p432kq;

import android.util.Xml;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: kq.o */
/* loaded from: classes8.dex */
public class C11143o {
    /* renamed from: a */
    public static XmlPullParser m67047a(byte[] bArr) throws XmlPullParserException {
        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr), Constants.UTF_8);
        return xmlPullParserNewPullParser;
    }

    /* renamed from: b */
    public static XmlSerializer m67048b(OutputStream outputStream) throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        xmlSerializerNewSerializer.setOutput(outputStream, Constants.UTF_8);
        return xmlSerializerNewSerializer;
    }

    /* renamed from: c */
    public static void m67049c(XmlSerializer xmlSerializer, String str, String str2) throws IllegalStateException, IOException, IllegalArgumentException {
        if (str2 == null || xmlSerializer == null || str == null) {
            return;
        }
        xmlSerializer.startTag(null, str).text(str2).endTag(null, str);
    }
}
