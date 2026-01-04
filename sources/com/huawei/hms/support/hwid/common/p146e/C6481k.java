package com.huawei.hms.support.hwid.common.p146e;

import android.util.Xml;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: com.huawei.hms.support.hwid.common.e.k */
/* loaded from: classes8.dex */
public class C6481k {
    /* renamed from: a */
    public static void m36915a(XmlSerializer xmlSerializer, String str, String str2) throws IllegalStateException, IOException, IllegalArgumentException {
        if (str2 == null || xmlSerializer == null || str == null) {
            return;
        }
        xmlSerializer.startTag(null, str).text(str2).endTag(null, str);
    }

    /* renamed from: a */
    public static XmlSerializer m36914a(OutputStream outputStream) throws IllegalStateException, IOException, IllegalArgumentException {
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        xmlSerializerNewSerializer.setOutput(outputStream, Constants.UTF_8);
        return xmlSerializerNewSerializer;
    }

    /* renamed from: a */
    public static XmlPullParser m36913a(byte[] bArr) throws XmlPullParserException {
        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr), Constants.UTF_8);
        return xmlPullParserNewPullParser;
    }
}
