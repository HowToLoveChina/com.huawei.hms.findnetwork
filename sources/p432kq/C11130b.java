package p432kq;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.support.api.entity.common.CommonPickerConstant;
import com.huawei.hwidauth.datatype.DeviceInfo;
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
import p640sq.C12843v;

/* renamed from: kq.b */
/* loaded from: classes8.dex */
public class C11130b extends AbstractC11138j {

    /* renamed from: e */
    public Context f52405e;

    /* renamed from: f */
    public String f52406f;

    /* renamed from: g */
    public String f52407g;

    /* renamed from: h */
    public String f52408h;

    /* renamed from: i */
    public String f52409i = "/AccountServer/IUserDeviceMng/getDevAuthCode?";

    /* renamed from: j */
    public String f52410j;

    /* renamed from: k */
    public String f52411k;

    /* renamed from: l */
    public String f52412l;

    /* renamed from: m */
    public DeviceInfo f52413m;

    public C11130b(Context context, String str, String str2, String str3) {
        this.f52405e = context;
        this.f52406f = str;
        this.f52407g = str2;
        this.f52408h = TextUtils.isEmpty(str3) ? "" : str3;
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: a */
    public String mo37999a() throws IllegalStateException, IOException, IllegalArgumentException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            XmlSerializer xmlSerializerM67048b = C11143o.m67048b(byteArrayOutputStream);
            xmlSerializerM67048b.startDocument(Constants.UTF_8, Boolean.TRUE);
            xmlSerializerM67048b.startTag(null, "GetDevAuthCodeReq");
            C11143o.m67049c(xmlSerializerM67048b, "version", "66300");
            C11143o.m67049c(xmlSerializerM67048b, "uuid", C12843v.m77127d(this.f52405e));
            if (this.f52413m != null) {
                xmlSerializerM67048b.startTag(null, CommonPickerConstant.RequestParams.KEY_DEVICE_INFO);
                DeviceInfo.m38005g(xmlSerializerM67048b, this.f52413m);
                xmlSerializerM67048b.endTag(null, CommonPickerConstant.RequestParams.KEY_DEVICE_INFO);
            }
            C11143o.m67049c(xmlSerializerM67048b, "oprType", this.f52406f);
            C11143o.m67049c(xmlSerializerM67048b, "loginStatus", this.f52407g);
            C11143o.m67049c(xmlSerializerM67048b, "serviceToken", this.f52408h);
            C11143o.m67049c(xmlSerializerM67048b, FaqConstants.FAQ_LANGUAGE, C12824c.m77007j(this.f52405e));
            C11143o.m67049c(xmlSerializerM67048b, "appID", "com.huawei.hwid");
            xmlSerializerM67048b.endTag(null, "GetDevAuthCodeReq");
            xmlSerializerM67048b.endDocument();
            String string = byteArrayOutputStream.toString(Constants.UTF_8);
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
                C12836o.m77099d("GetDevAuthCodeRequest", "GetDevAuthCodeRequest IOException", true);
            }
            return string;
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused2) {
                C12836o.m77099d("GetDevAuthCodeRequest", "GetDevAuthCodeRequest IOException", true);
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
        return this.f52409i + "cVersion=HwID_6.12.0.302&Version=66300&ctrID=" + System.currentTimeMillis() + C12824c.m76996R();
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: e */
    public int mo66928e() {
        return this.f52461b;
    }

    @Override // p432kq.AbstractC11138j
    /* renamed from: f */
    public String mo66929f() {
        return this.f52462c;
    }

    /* renamed from: i */
    public void m66930i(DeviceInfo deviceInfo) {
        this.f52413m = deviceInfo;
    }

    /* renamed from: j */
    public void m66931j(String str) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParserM67047a = C11143o.m67047a(str.getBytes(Constants.UTF_8));
        for (int eventType = xmlPullParserM67047a.getEventType(); 1 != eventType; eventType = xmlPullParserM67047a.next()) {
            String name = xmlPullParserM67047a.getName();
            if (eventType == 2) {
                if ("result".equals(name)) {
                    this.f52460a = C12824c.m77006i(xmlPullParserM67047a.getAttributeValue(null, MapKeyNames.RESULT_CODE));
                }
                if (this.f52460a == 0) {
                    if ("devAuthCode".equals(name)) {
                        this.f52410j = xmlPullParserM67047a.nextText();
                    } else if ("encryptKey".equals(name)) {
                        this.f52411k = xmlPullParserM67047a.nextText();
                    } else if ("randomID".equals(name)) {
                        this.f52412l = xmlPullParserM67047a.nextText();
                    }
                } else if (AddressConstants.Extras.EXTRA_NAME_ERR_CODE.equals(name)) {
                    this.f52461b = C12824c.m77006i(xmlPullParserM67047a.nextText());
                } else if ("errorDesc".equals(name)) {
                    this.f52462c = xmlPullParserM67047a.nextText();
                }
            }
        }
    }

    /* renamed from: k */
    public String m66932k() {
        return this.f52410j;
    }

    /* renamed from: l */
    public String m66933l() {
        return this.f52411k;
    }

    /* renamed from: m */
    public String m66934m() {
        return this.f52412l;
    }
}
