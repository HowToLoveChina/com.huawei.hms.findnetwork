package com.huawei.hms.support.hwid.common.p143c.p144a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.support.hwid.common.p143c.AbstractC6466a;
import com.huawei.hms.support.hwid.common.p146e.C6473c;
import com.huawei.hms.support.hwid.common.p146e.C6477g;
import com.huawei.hms.support.hwid.common.p146e.C6480j;
import com.huawei.hms.support.hwid.common.p146e.C6481k;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: com.huawei.hms.support.hwid.common.c.a.a */
/* loaded from: classes8.dex */
public class C6467a extends AbstractC6466a {

    /* renamed from: e */
    private String f30015e;

    /* renamed from: g */
    private String f30017g;

    /* renamed from: i */
    private String f30019i;

    /* renamed from: j */
    private String f30020j;

    /* renamed from: f */
    private int f30016f = -1;

    /* renamed from: h */
    private String f30018h = "siteDomain";

    /* renamed from: k */
    private int f30021k = 0;

    /* renamed from: l */
    private String f30022l = "/AccountServer/IUserInfoMng/getResource";

    public C6467a(Context context, String str) {
        this.f30019i = str;
        this.f30020j = mo36847a(context);
    }

    /* renamed from: a */
    public void m36852a(String str) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParserM36913a = C6481k.m36913a(str.getBytes(Constants.UTF_8));
        for (int eventType = xmlPullParserM36913a.getEventType(); 1 != eventType; eventType = xmlPullParserM36913a.next()) {
            String name = xmlPullParserM36913a.getName();
            if (eventType == 2) {
                if ("result".equals(name)) {
                    this.f30009b = C6480j.m36911a(xmlPullParserM36913a.getAttributeValue(null, MapKeyNames.RESULT_CODE));
                }
                if (this.f30009b == 0) {
                    if ("ResourceContent".equals(name)) {
                        this.f30015e = xmlPullParserM36913a.nextText();
                        C6477g.m36903a("GetResourceRequest", "resourceContent");
                    }
                } else if (AddressConstants.Extras.EXTRA_NAME_ERR_CODE.equals(name)) {
                    this.f30016f = C6480j.m36911a(xmlPullParserM36913a.nextText());
                } else if ("errorDesc".equals(name)) {
                    this.f30017g = xmlPullParserM36913a.nextText();
                }
            }
        }
    }

    /* renamed from: e */
    public String m36853e() throws IllegalStateException, IOException, IllegalArgumentException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            XmlSerializer xmlSerializerM36914a = C6481k.m36914a(byteArrayOutputStream);
            xmlSerializerM36914a.startDocument(Constants.UTF_8, Boolean.TRUE);
            xmlSerializerM36914a.startTag(null, "GetResourceReq");
            C6481k.m36915a(xmlSerializerM36914a, "version", "66300");
            if (TextUtils.isEmpty(this.f30019i)) {
                C6481k.m36915a(xmlSerializerM36914a, "resourceID", this.f30018h);
            } else {
                C6481k.m36915a(xmlSerializerM36914a, "resourceID", this.f30019i);
            }
            if (!TextUtils.isEmpty(this.f30020j)) {
                C6481k.m36915a(xmlSerializerM36914a, FaqConstants.FAQ_LANGUAGE, this.f30020j);
            }
            C6481k.m36915a(xmlSerializerM36914a, "reqClientType", String.valueOf(this.f30021k));
            C6481k.m36915a(xmlSerializerM36914a, "clientVersion", C6473c.m36870a());
            xmlSerializerM36914a.endTag(null, "GetResourceReq");
            xmlSerializerM36914a.endDocument();
            String string = byteArrayOutputStream.toString(Constants.UTF_8);
            try {
                byteArrayOutputStream.close();
            } catch (IOException e10) {
                C6477g.m36905b("GetResourceRequest", e10.getClass().getSimpleName());
            }
            return string;
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e11) {
                C6477g.m36905b("GetResourceRequest", e11.getClass().getSimpleName());
            }
            throw th2;
        }
    }

    /* renamed from: f */
    public String m36854f() {
        return this.f30015e;
    }

    /* renamed from: g */
    public int m36855g() {
        return this.f30016f;
    }

    /* renamed from: h */
    public String m36856h() {
        return this.f30017g;
    }

    @Override // com.huawei.hms.support.hwid.common.p143c.AbstractC6466a
    /* renamed from: a */
    public String mo36847a(Context context) {
        return C6473c.m36875d(context);
    }

    @Override // com.huawei.hms.support.hwid.common.p143c.AbstractC6466a
    /* renamed from: a */
    public String mo36846a() {
        return this.f30022l;
    }
}
