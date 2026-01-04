package p432kq;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.network.inner.api.NetworkService;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
import p640sq.C12827f;
import p640sq.C12836o;

/* renamed from: kq.a */
/* loaded from: classes8.dex */
public class C11129a extends AbstractC11138j {

    /* renamed from: f */
    public String f52400f;

    /* renamed from: g */
    public String f52401g;

    /* renamed from: h */
    public String f52402h;

    /* renamed from: j */
    public Context f52404j;

    /* renamed from: e */
    public String f52399e = "/AccountServer/IDM/getClientConfiguration?";

    /* renamed from: i */
    public String f52403i = "";

    public C11129a(String str, String str2, String str3, Context context) {
        this.f52400f = str;
        this.f52401g = str2;
        this.f52402h = str3;
        this.f52404j = context;
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: a */
    public String mo37999a() throws IllegalStateException, IOException, IllegalArgumentException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            XmlSerializer xmlSerializerM67048b = C11143o.m67048b(byteArrayOutputStream);
            xmlSerializerM67048b.startDocument(Constants.UTF_8, Boolean.TRUE);
            xmlSerializerM67048b.startTag(null, "GetClientConfigurationReq");
            C11143o.m67049c(xmlSerializerM67048b, "version", "66300");
            if (TextUtils.isEmpty(this.f52400f)) {
                C11143o.m67049c(xmlSerializerM67048b, "country", "");
            } else {
                C11143o.m67049c(xmlSerializerM67048b, "country", this.f52400f);
            }
            if (TextUtils.isEmpty(this.f52401g)) {
                C11143o.m67049c(xmlSerializerM67048b, NetworkService.Constants.CONFIG_SERVICE, "");
            } else {
                C11143o.m67049c(xmlSerializerM67048b, NetworkService.Constants.CONFIG_SERVICE, this.f52401g);
            }
            C12836o.m77097b("GetClientConfigurationRequest", "Request dataVer = " + this.f52402h, true);
            if (TextUtils.isEmpty(this.f52402h)) {
                C11143o.m67049c(xmlSerializerM67048b, "dataVer", "");
            } else {
                C11143o.m67049c(xmlSerializerM67048b, "dataVer", this.f52402h);
            }
            xmlSerializerM67048b.endTag(null, "GetClientConfigurationReq");
            xmlSerializerM67048b.endDocument();
            String string = byteArrayOutputStream.toString(Constants.UTF_8);
            C12836o.m77097b("GetClientConfigurationRequest", "Config request info:" + string, false);
            try {
                byteArrayOutputStream.close();
            } catch (IOException e10) {
                C12836o.m77099d("GetClientConfigurationRequest", e10.getClass().getSimpleName(), true);
            }
            return string;
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e11) {
                C12836o.m77099d("GetClientConfigurationRequest", e11.getClass().getSimpleName(), true);
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
        return this.f52399e + "cVersion=HwID_6.12.0.302&Version=66300";
    }

    /* renamed from: i */
    public void m66926i(String str) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParserM67047a = C11143o.m67047a(str.getBytes(Constants.UTF_8));
        C12827f.m77030c(this.f52404j).m77046r();
        for (int eventType = xmlPullParserM67047a.getEventType(); 1 != eventType; eventType = xmlPullParserM67047a.next()) {
            String name = xmlPullParserM67047a.getName();
            if (eventType == 2) {
                if ("result".equals(name)) {
                    this.f52460a = C11142n.m67046a(xmlPullParserM67047a.getAttributeValue(null, MapKeyNames.RESULT_CODE));
                } else if (this.f52460a == 0 && "CountryList".equalsIgnoreCase(name)) {
                    C12836o.m77097b("GetClientConfigurationRequest", "mResultCode is success.", true);
                    this.f52403i = str;
                    C12827f.m77030c(this.f52404j).m77038e(xmlPullParserM67047a, str);
                } else if (AddressConstants.Extras.EXTRA_NAME_ERR_CODE.equals(name)) {
                    this.f52461b = C11142n.m67046a(xmlPullParserM67047a.nextText());
                } else if ("errorDesc".equals(name)) {
                    this.f52462c = xmlPullParserM67047a.nextText();
                }
            }
        }
    }

    /* renamed from: j */
    public String m66927j() {
        return this.f52403i;
    }
}
