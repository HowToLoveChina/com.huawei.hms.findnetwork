package p432kq;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
import p640sq.C12824c;
import p640sq.C12836o;

/* renamed from: kq.c */
/* loaded from: classes8.dex */
public class C11131c extends AbstractC11138j {

    /* renamed from: e */
    public String f52414e;

    /* renamed from: g */
    public String f52416g;

    /* renamed from: h */
    public String f52417h;

    /* renamed from: i */
    public String f52418i;

    /* renamed from: k */
    public String f52420k;

    /* renamed from: f */
    public int f52415f = -1;

    /* renamed from: j */
    public String f52419j = "";

    /* renamed from: l */
    public int f52421l = 0;

    /* renamed from: m */
    public String f52422m = "/AccountServer/IUserInfoMng/getResource?";

    public C11131c(Context context, String str) {
        this.f52418i = str;
        this.f52420k = C12824c.m77007j(context);
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: a */
    public String mo37999a() throws IllegalStateException, IOException, IllegalArgumentException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            XmlSerializer xmlSerializerM67048b = C11143o.m67048b(byteArrayOutputStream);
            xmlSerializerM67048b.startDocument(Constants.UTF_8, Boolean.TRUE);
            xmlSerializerM67048b.startTag(null, "GetResourceReq");
            C11143o.m67049c(xmlSerializerM67048b, "version", "66300");
            if (TextUtils.isEmpty(this.f52418i)) {
                C11143o.m67049c(xmlSerializerM67048b, "resourceID", this.f52417h);
            } else {
                C11143o.m67049c(xmlSerializerM67048b, "resourceID", this.f52418i);
            }
            if (!TextUtils.isEmpty(this.f52419j)) {
                C11143o.m67049c(xmlSerializerM67048b, "ResourceOldVer", this.f52419j);
            }
            if (!TextUtils.isEmpty(this.f52420k)) {
                C11143o.m67049c(xmlSerializerM67048b, FaqConstants.FAQ_LANGUAGE, this.f52420k);
            }
            C11143o.m67049c(xmlSerializerM67048b, "reqClientType", String.valueOf(this.f52421l));
            C11143o.m67049c(xmlSerializerM67048b, "clientVersion", "HwID_6.12.0.302");
            xmlSerializerM67048b.endTag(null, "GetResourceReq");
            xmlSerializerM67048b.endDocument();
            String string = byteArrayOutputStream.toString(Constants.UTF_8);
            try {
                byteArrayOutputStream.close();
            } catch (IOException e10) {
                C12836o.m77099d("GetResourceRequest", e10.getClass().getSimpleName(), true);
            }
            return string;
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e11) {
                C12836o.m77099d("GetResourceRequest", e11.getClass().getSimpleName(), true);
            }
            throw th2;
        }
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: c */
    public String mo38001c() {
        return "";
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: d */
    public String mo38002d() {
        return this.f52422m + "cVersion=HwID_6.12.0.302&Version=66300";
    }

    /* renamed from: i */
    public void m66935i(String str) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParserM67047a = C11143o.m67047a(str.getBytes(Constants.UTF_8));
        for (int eventType = xmlPullParserM67047a.getEventType(); 1 != eventType; eventType = xmlPullParserM67047a.next()) {
            String name = xmlPullParserM67047a.getName();
            if (eventType == 2) {
                if ("result".equals(name)) {
                    this.f52460a = C11142n.m67046a(xmlPullParserM67047a.getAttributeValue(null, MapKeyNames.RESULT_CODE));
                }
                if (this.f52460a == 0) {
                    if ("ResourceContent".equals(name)) {
                        this.f52463d = xmlPullParserM67047a.nextText();
                        C12836o.m77097b("GetResourceRequest", "resourceContent", true);
                    } else if ("ResourceVer".equals(name)) {
                        this.f52414e = xmlPullParserM67047a.nextText();
                    }
                } else if (AddressConstants.Extras.EXTRA_NAME_ERR_CODE.equals(name)) {
                    this.f52415f = C11142n.m67046a(xmlPullParserM67047a.nextText());
                } else if ("errorDesc".equals(name)) {
                    this.f52416g = xmlPullParserM67047a.nextText();
                }
            }
        }
    }
}
