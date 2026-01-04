package com.huawei.hms.support.hwid.common.p143c.p144a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hms.support.api.entity.common.CommonPickerConstant;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.huawei.hms.support.hwid.bean.CheckPasswordByUserIdReq;
import com.huawei.hms.support.hwid.common.p141a.C6463a;
import com.huawei.hms.support.hwid.common.p142b.C6465b;
import com.huawei.hms.support.hwid.common.p143c.AbstractC6466a;
import com.huawei.hms.support.hwid.common.p146e.C6473c;
import com.huawei.hms.support.hwid.common.p146e.C6477g;
import com.huawei.hms.support.hwid.common.p146e.C6480j;
import com.huawei.hms.support.hwid.common.p146e.C6481k;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: com.huawei.hms.support.hwid.common.c.a.b */
/* loaded from: classes8.dex */
public class C6468b extends AbstractC6466a {

    /* renamed from: e */
    private String f30029e;

    /* renamed from: f */
    private String f30030f;

    /* renamed from: g */
    private String f30031g;

    /* renamed from: h */
    private String f30032h;

    /* renamed from: i */
    private String f30033i = "/IUserPwdMng/uidVerifyPasswordV3";

    /* renamed from: j */
    private String f30034j = "7";

    /* renamed from: k */
    private String f30035k;

    /* renamed from: l */
    private String f30036l;

    /* renamed from: m */
    private String f30037m;

    /* renamed from: n */
    private String f30038n;

    /* renamed from: o */
    private String f30039o;

    /* renamed from: p */
    private String f30040p;

    /* renamed from: q */
    private String f30041q;

    /* renamed from: r */
    private String f30042r;

    public C6468b(Context context, CheckPasswordByUserIdReq checkPasswordByUserIdReq, String str, String str2, String str3) {
        this.f30029e = checkPasswordByUserIdReq.getUserId();
        this.f30036l = str3;
        this.f30031g = checkPasswordByUserIdReq.getAppId();
        String guardianUserID = checkPasswordByUserIdReq.getGuardianUserID();
        this.f30037m = guardianUserID;
        this.f30030f = TextUtils.isEmpty(guardianUserID) ? "0" : "1";
        this.f30032h = C6465b.m36844a(checkPasswordByUserIdReq.getPassword(), str2);
        this.f30038n = mo36847a(context);
        this.f30042r = C6463a.m36839a(context);
        this.f30039o = checkPasswordByUserIdReq.getDeviceId();
        this.f30040p = checkPasswordByUserIdReq.getDeviceId2();
        this.f30041q = checkPasswordByUserIdReq.getDeviceType();
        m36848a(str, checkPasswordByUserIdReq.getSiteId());
    }

    /* renamed from: a */
    public void m36858a(String str) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParserM36913a = C6481k.m36913a(str.getBytes(Constants.UTF_8));
        for (int eventType = xmlPullParserM36913a.getEventType(); 1 != eventType; eventType = xmlPullParserM36913a.next()) {
            String name = xmlPullParserM36913a.getName();
            if (eventType == 2) {
                if ("result".equals(name)) {
                    this.f30009b = C6480j.m36911a(xmlPullParserM36913a.getAttributeValue(null, MapKeyNames.RESULT_CODE));
                }
                if (this.f30009b == 0) {
                    m36857a(xmlPullParserM36913a, name);
                } else if (AddressConstants.Extras.EXTRA_NAME_ERR_CODE.equals(name)) {
                    this.f30010c = C6480j.m36911a(xmlPullParserM36913a.nextText());
                } else if ("errorDesc".equals(name)) {
                    this.f30011d = xmlPullParserM36913a.nextText();
                }
            }
        }
    }

    @Override // com.huawei.hms.support.hwid.common.p143c.AbstractC6466a
    /* renamed from: b */
    public Bundle mo36849b() {
        Bundle bundleMo36849b = super.mo36849b();
        bundleMo36849b.putString(CommonConstant.KEY_ID_TOKEN, this.f30035k);
        return bundleMo36849b;
    }

    /* renamed from: e */
    public String m36859e() throws IllegalStateException, IOException, IllegalArgumentException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            XmlSerializer xmlSerializerM36914a = C6481k.m36914a(byteArrayOutputStream);
            xmlSerializerM36914a.startDocument(Constants.UTF_8, Boolean.TRUE);
            xmlSerializerM36914a.startTag(null, "UidVerifyPasswordV3Req");
            C6481k.m36915a(xmlSerializerM36914a, "version", "66300");
            C6481k.m36915a(xmlSerializerM36914a, HwPayConstant.KEY_USER_ID, this.f30029e);
            C6481k.m36915a(xmlSerializerM36914a, "sceneID", this.f30030f);
            C6481k.m36915a(xmlSerializerM36914a, "password", this.f30032h);
            C6481k.m36915a(xmlSerializerM36914a, "appID", this.f30031g);
            C6481k.m36915a(xmlSerializerM36914a, "supportAlg", "PS256");
            C6481k.m36915a(xmlSerializerM36914a, "reqClientType", "7");
            C6481k.m36915a(xmlSerializerM36914a, "guardianUserID", this.f30037m);
            if (!TextUtils.isEmpty(this.f30038n)) {
                C6481k.m36915a(xmlSerializerM36914a, FaqConstants.FAQ_LANGUAGE, this.f30038n);
            }
            xmlSerializerM36914a.startTag(null, CommonPickerConstant.RequestParams.KEY_DEVICE_INFO);
            C6481k.m36915a(xmlSerializerM36914a, "deviceID", this.f30039o);
            if (!TextUtils.isEmpty(this.f30040p)) {
                C6481k.m36915a(xmlSerializerM36914a, "deviceID2", this.f30040p);
            }
            C6481k.m36915a(xmlSerializerM36914a, JsbMapKeyNames.H5_DEVICE_TYPE, this.f30041q);
            C6481k.m36915a(xmlSerializerM36914a, "uuid", this.f30042r);
            C6481k.m36915a(xmlSerializerM36914a, "terminalType", C6463a.m36838a());
            xmlSerializerM36914a.endTag(null, CommonPickerConstant.RequestParams.KEY_DEVICE_INFO);
            xmlSerializerM36914a.endTag(null, "UidVerifyPasswordV3Req");
            xmlSerializerM36914a.endDocument();
            String string = byteArrayOutputStream.toString(Constants.UTF_8);
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
                C6477g.m36907c("UIDVerifyPasswordV3Request", "GetAuthCodeSendListRequest pack error", true);
            }
            return string;
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused2) {
                C6477g.m36907c("UIDVerifyPasswordV3Request", "GetAuthCodeSendListRequest pack error", true);
            }
            throw th2;
        }
    }

    /* renamed from: a */
    private void m36857a(XmlPullParser xmlPullParser, String str) {
        try {
            if (CommonConstant.KEY_ID_TOKEN.equals(str)) {
                this.f30035k = xmlPullParser.nextText();
            } else {
                C6477g.m36904a("UIDVerifyPasswordV3Request", "do nothing for node: " + str, false);
            }
        } catch (Throwable th2) {
            C6477g.m36904a("UIDVerifyPasswordV3Request", "getSendListReqResult error " + th2.getClass().getSimpleName(), true);
        }
    }

    @Override // com.huawei.hms.support.hwid.common.p143c.AbstractC6466a
    /* renamed from: a */
    public String mo36846a() {
        return this.f30033i;
    }

    @Override // com.huawei.hms.support.hwid.common.p143c.AbstractC6466a
    /* renamed from: a */
    public String mo36847a(Context context) {
        return C6473c.m36875d(context);
    }
}
