package com.huawei.hwidauth.p167ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.common.internal.constant.AuthInternalPickerConstant;
import com.huawei.hms.iap.entity.OrderStatusCode;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.api.entity.common.CommonPickerConstant;
import com.huawei.hwidauth.datatype.DeviceInfo;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.constants.TrackConstants$Events;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.secure.android.common.util.SafeBase64;
import com.huawei.secure.android.common.webview.SafeWebView;
import gu.C10048b;
import hu.C10343b;
import iq.C10599m;
import iq.C10600n;
import iq.C10601o;
import iq.InterfaceC10595i;
import iq.InterfaceC10596j;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import lu.C11342a;
import org.json.JSONException;
import org.json.JSONObject;
import p237du.C9310c;
import p297fu.AbstractC9773a;
import p345hq.C10334a;
import p402jq.C10909b;
import p432kq.C11130b;
import p432kq.C11131c;
import p460lq.C11335b;
import p530oq.C11990c;
import p587qq.AbstractC12388f;
import p587qq.C12386d;
import p587qq.C12387e;
import p621rq.AbstractC12615a;
import p621rq.C12617c;
import p640sq.C12824c;
import p640sq.C12825d;
import p640sq.C12826e;
import p640sq.C12829h;
import p640sq.C12836o;
import p640sq.C12837p;
import p640sq.C12842u;
import p640sq.C12843v;
import p640sq.C12844w;
import p658tq.C13056a;

/* renamed from: com.huawei.hwidauth.ui.h */
/* loaded from: classes8.dex */
public class C6723h extends AbstractC6721f {

    /* renamed from: B */
    public String f31125B;

    /* renamed from: C */
    public String f31126C;

    /* renamed from: D */
    public String f31127D;

    /* renamed from: a */
    public InterfaceC6722g f31128a;

    /* renamed from: e */
    public String f31132e;

    /* renamed from: g */
    public DeviceInfo f31134g;

    /* renamed from: h */
    public String f31135h;

    /* renamed from: i */
    public String f31136i;

    /* renamed from: j */
    public String f31137j;

    /* renamed from: k */
    public String f31138k;

    /* renamed from: l */
    public String f31139l;

    /* renamed from: m */
    public int f31140m;

    /* renamed from: n */
    public String f31141n;

    /* renamed from: o */
    public Context f31142o;

    /* renamed from: q */
    public String f31144q;

    /* renamed from: r */
    public String f31145r;

    /* renamed from: s */
    public String f31146s;

    /* renamed from: t */
    public String f31147t;

    /* renamed from: u */
    public String f31148u;

    /* renamed from: v */
    public String f31149v;

    /* renamed from: w */
    public String f31150w;

    /* renamed from: x */
    public String f31151x;

    /* renamed from: y */
    public boolean f31152y;

    /* renamed from: z */
    public String f31153z;

    /* renamed from: b */
    public String f31129b = "";

    /* renamed from: c */
    public String f31130c = "";

    /* renamed from: d */
    public String f31131d = "";

    /* renamed from: f */
    public String f31133f = "";

    /* renamed from: p */
    public String f31143p = "0";

    /* renamed from: A */
    public boolean f31124A = false;

    /* renamed from: com.huawei.hwidauth.ui.h$a */
    public class a implements AbstractC12388f.d {
        public a() {
        }

        @Override // p587qq.AbstractC12388f.d
        /* renamed from: a */
        public void mo38164a(C10343b c10343b) {
            C6723h.this.m38186G(c10343b);
        }

        @Override // p587qq.AbstractC12388f.d
        /* renamed from: a */
        public void mo38163a(int i10, String str) {
            C6723h.this.f31128a.mo38103a(i10, str);
        }
    }

    /* renamed from: com.huawei.hwidauth.ui.h$b */
    public class b implements AbstractC12388f.d {
        public b() {
        }

        @Override // p587qq.AbstractC12388f.d
        /* renamed from: a */
        public void mo38164a(C10343b c10343b) throws JSONException {
            C6723h.this.m38231o(c10343b);
        }

        @Override // p587qq.AbstractC12388f.d
        /* renamed from: a */
        public void mo38163a(int i10, String str) {
            C6723h.this.f31128a.mo38104a(C6723h.this.m38190K("1", "9999"));
        }
    }

    /* renamed from: com.huawei.hwidauth.ui.h$c */
    public class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ boolean f31156a;

        public c(boolean z10) {
            this.f31156a = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            C6723h.this.f31128a.mo38105a(this.f31156a);
        }
    }

    /* renamed from: com.huawei.hwidauth.ui.h$d */
    public class d implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ int f31158a;

        /* renamed from: b */
        public final /* synthetic */ String f31159b;

        public d(int i10, String str) {
            this.f31158a = i10;
            this.f31159b = str;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            if (200 == this.f31158a) {
                C6723h.this.f31128a.mo38102a(-1, C6723h.this.m38206a0(this.f31159b, "0"));
                return;
            }
            C6723h.this.f31128a.mo38102a(0, C6723h.this.m38206a0(this.f31159b, this.f31158a + ""));
        }
    }

    public C6723h(InterfaceC6722g interfaceC6722g, Context context) {
        this.f31128a = interfaceC6722g;
        this.f31142o = context;
    }

    /* renamed from: A */
    public final byte[] m38176A(byte[] bArr) throws IOException {
        if (bArr != null && bArr.length >= 447) {
            C12836o.m77097b("WebViewPresenter", "the message is too long, need to compress data", true);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(bArr);
                    gZIPOutputStream.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream.close();
                    return byteArray;
                } finally {
                }
            } catch (IOException unused) {
                C12836o.m77099d("WebViewPresenter", "failed to compress data", true);
            }
        }
        return bArr;
    }

    /* renamed from: A0 */
    public final String m38177A0(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("CUID", str);
        } catch (JSONException unused) {
            C12836o.m77097b("WebViewPresenter", "childUserIdToJson JSONException", true);
        }
        C12836o.m77097b("WebViewPresenter", "childUserIdToJson = " + jSONObject.toString(), false);
        return m38240s0(jSONObject.toString());
    }

    /* renamed from: B */
    public String m38178B(Context context) {
        String strM77007j = C12824c.m77007j(context);
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("ext_clientInfo=");
            sb2.append(m38179B0());
            sb2.append("&reqClientType=");
            sb2.append(TextUtils.isEmpty(this.f31148u) ? 7 : this.f31148u);
            sb2.append("&lang=");
            sb2.append(URLEncoder.encode(strM77007j.toLowerCase(Locale.getDefault()), Constants.UTF_8));
            sb2.append(C12844w.m77139k(this.f31142o));
            sb2.append("&serviceType=");
            sb2.append(2);
            sb2.append("&service=");
            StringBuilder sb3 = new StringBuilder();
            sb3.append(AbstractC12615a.m76116a().mo76128l());
            sb3.append("?lang=");
            sb3.append(strM77007j.toLowerCase(Locale.getDefault()));
            sb3.append("&loginChannel=7000000&reqClientType=");
            sb3.append(TextUtils.isEmpty(this.f31148u) ? 7 : this.f31148u);
            sb3.append("&isFromLiteSDK=true");
            sb3.append(C12844w.m77139k(this.f31142o));
            sb2.append(URLEncoder.encode(sb3.toString(), Constants.UTF_8));
            sb2.append("&loginChannel=");
            sb2.append(7000000);
            sb2.append("&clientNonce=");
            sb2.append(C12824c.m76995Q());
        } catch (UnsupportedEncodingException unused) {
            sb2 = new StringBuilder();
        } catch (Exception unused2) {
            sb2 = new StringBuilder();
        }
        C12836o.m77097b("WebViewPresenter", "realNameInfo：" + ((Object) sb2), false);
        return sb2.toString();
    }

    /* renamed from: B0 */
    public final String m38179B0() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("AT", this.f31131d);
            jSONObject.put("AD", this.f31129b);
            JSONObject jSONObject2 = new JSONObject();
            String strM38203X = m38203X(this.f31134g.m38007e(), this.f31134g.m38011m());
            jSONObject2.put("terminalType", this.f31134g.m38009j());
            jSONObject2.put("deviceAliasName", this.f31134g.m38013o());
            jSONObject2.put(JsbMapKeyNames.H5_DEVICE_TYPE, this.f31134g.m38011m());
            jSONObject2.put("deviceID", this.f31134g.m38007e());
            if (!TextUtils.isEmpty(strM38203X)) {
                jSONObject2.put("deviceID2", this.f31134g.m38007e());
            }
            jSONObject2.put("uuid", this.f31134g.m38015q());
            jSONObject.put("ED", jSONObject2.toString());
            jSONObject.put("TY", 1);
            jSONObject.put("TS", System.currentTimeMillis());
        } catch (JSONException unused) {
            C12836o.m77097b("WebViewPresenter", "JSONException", true);
        }
        C12836o.m77097b("WebViewPresenter", "getExtClientInfo:" + jSONObject.toString(), false);
        return m38240s0(jSONObject.toString());
    }

    /* renamed from: C */
    public String m38180C(String str) {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("loginUrl=");
            sb2.append(URLEncoder.encode(AbstractC12615a.m76116a().mo76119c() + "?reqClientType=7&loginChannel=7000000&displayType=2&clientID=" + this.f31129b + "&lang=" + str.toLowerCase(Locale.getDefault()) + C12844w.m77139k(this.f31142o), Constants.UTF_8));
            sb2.append("&service=");
            sb2.append(URLEncoder.encode(AbstractC12615a.m76116a().mo76121e() + "?reqClientType=7&loginChannel=7000000&service=" + URLEncoder.encode(C11335b.m68098g().m68113q(this.f31142o), Constants.UTF_8) + "&displayType=2&lang=" + str.toLowerCase(Locale.getDefault()) + C12844w.m77139k(this.f31142o), Constants.UTF_8));
            sb2.append("&loginChannel=");
            sb2.append(7000000);
            sb2.append("&reqClientType=");
            sb2.append(7);
            sb2.append("&accessToken=");
            sb2.append(URLEncoder.encode(this.f31131d, Constants.UTF_8));
            sb2.append("&lang=");
            sb2.append(URLEncoder.encode(str.toLowerCase(Locale.getDefault()), Constants.UTF_8));
            sb2.append("&appID=");
            sb2.append(this.f31129b);
            sb2.append(C12844w.m77139k(this.f31142o));
        } catch (UnsupportedEncodingException unused) {
            sb2 = new StringBuilder();
        } catch (Exception unused2) {
            sb2 = new StringBuilder();
        }
        C12836o.m77097b("WebViewPresenter", "authAppListUrlData：" + ((Object) sb2), false);
        return sb2.toString();
    }

    /* renamed from: C0 */
    public final void m38181C0(String str) {
        C12836o.m77097b("WebViewPresenter", "saveGetAuthorizationCodeFlag mIsIndependentAuthorization = " + this.f31152y, true);
        if (TextUtils.isEmpty(str) || this.f31152y) {
            return;
        }
        C11990c.m72144k(this.f31142o).m72143j("getSignInCode", true);
        C11990c.m72144k(this.f31142o).m72141h("getSignInCodeTime", System.currentTimeMillis());
    }

    /* renamed from: D */
    public String m38182D(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("code=");
            sb2.append(URLEncoder.encode(str, Constants.UTF_8));
            sb2.append("&state=");
            sb2.append(URLEncoder.encode(str2, Constants.UTF_8));
        } catch (UnsupportedEncodingException unused) {
            sb2 = new StringBuilder();
        } catch (Exception unused2) {
            sb2 = new StringBuilder();
        }
        C12836o.m77097b("WebViewPresenter", "centerUrlData：" + ((Object) sb2), false);
        return sb2.toString();
    }

    /* renamed from: D0 */
    public final String m38183D0(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (C12826e.m77028c(str)) {
                String strM38203X = m38203X(this.f31134g.m38007e(), this.f31134g.m38011m());
                jSONObject.put("AD", this.f31129b);
                jSONObject2.put(JsbMapKeyNames.H5_DEVICE_TYPE, this.f31134g.m38011m());
                jSONObject2.put("deviceID", this.f31134g.m38007e());
                jSONObject2.put("uuid", this.f31134g.m38015q());
                if (!TextUtils.isEmpty(strM38203X)) {
                    jSONObject2.put("deviceID2", strM38203X);
                }
            }
            jSONObject2.put("terminalType", this.f31134g.m38009j());
            jSONObject2.put("deviceAliasName", this.f31134g.m38013o());
            jSONObject.put("ED", jSONObject2.toString());
            jSONObject.put("TY", 5);
            jSONObject.put("TS", System.currentTimeMillis());
        } catch (JSONException unused) {
            C12836o.m77097b("WebViewPresenter", "JSONException", true);
        }
        C12836o.m77097b("WebViewPresenter", "getSignInExtClientInfo:" + jSONObject.toString(), false);
        return m38240s0(jSONObject.toString());
    }

    /* renamed from: E */
    public final JSONObject m38184E(int i10, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stateCode", i10);
            jSONObject.put("stateMessage", str);
        } catch (JSONException unused) {
            C12836o.m77099d("WebViewPresenter", "getFailJsonObject JSONException", true);
        } catch (Exception unused2) {
            C12836o.m77099d("WebViewPresenter", "getFailJsonObject Exception", true);
        }
        return jSONObject;
    }

    /* renamed from: F */
    public void m38185F() {
        try {
            C12836o.m77097b("WebViewPresenter", "get urlMap from grs Cluster", true);
            Map<String, String> mapM63643b = C10334a.m63642a().m63643b(this.f31142o, this.f31127D, "com.huawei.cloud.hwid");
            if (mapM63643b != null) {
                m38243u(mapM63643b);
            } else {
                C12836o.m77099d("WebViewPresenter", "urlMap null", true);
                m38226l(6, "User cancel", "");
            }
        } catch (NoClassDefFoundError unused) {
            C12836o.m77099d("WebViewPresenter", "NoClassDefFoundError", true);
            m38226l(6, "User cancel", "");
        }
    }

    /* renamed from: G */
    public final void m38186G(C10343b c10343b) {
        C12836o.m77097b("WebViewPresenter", "handleRequestNet ==", true);
        ArrayList<String> arrayListM63696r = c10343b.m63696r("domainAllowList");
        C12824c.m77023z(c10343b.m63694p("publicKey"));
        C12824c.m77003f(arrayListM63696r);
        if (TextUtils.isEmpty(this.f31133f) || !"from_qr_authorize".equals(this.f31133f)) {
            m38242t0();
        }
        m38247w(false);
    }

    /* renamed from: H */
    public boolean m38187H(int i10) {
        if (m38251y((Activity) this.f31142o, new String[]{C12824c.m76999b()}, i10)) {
            C12836o.m77097b("WebViewPresenter", "checkSDPermission return true", true);
            return true;
        }
        C12836o.m77097b("WebViewPresenter", "checkSDPermission return false", true);
        return false;
    }

    /* renamed from: I */
    public String m38188I(Context context) {
        String strM77007j = C12824c.m77007j(context);
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("ext_clientInfo=");
            sb2.append(m38179B0());
            sb2.append("&reqClientType=");
            sb2.append(TextUtils.isEmpty(this.f31148u) ? 7 : this.f31148u);
            sb2.append("&lang=");
            sb2.append(URLEncoder.encode(strM77007j.toLowerCase(Locale.getDefault()), Constants.UTF_8));
            sb2.append(C12844w.m77139k(this.f31142o));
            sb2.append("&serviceType=");
            sb2.append(6);
            sb2.append("&service=");
            StringBuilder sb3 = new StringBuilder();
            sb3.append(AbstractC12615a.m76116a().mo76129m());
            sb3.append("?childInfo=");
            sb3.append(m38177A0(this.f31149v));
            sb3.append("&lang=");
            sb3.append(strM77007j.toLowerCase(Locale.getDefault()));
            sb3.append("&loginChannel=7000000&reqClientType=");
            sb3.append(TextUtils.isEmpty(this.f31148u) ? 7 : this.f31148u);
            sb3.append("&isFromLiteSDK=true");
            sb3.append(C12844w.m77139k(this.f31142o));
            sb2.append(URLEncoder.encode(sb3.toString(), Constants.UTF_8));
            sb2.append("&loginChannel=");
            sb2.append(7000000);
            sb2.append("&clientNonce=");
            sb2.append(C12824c.m76995Q());
        } catch (UnsupportedEncodingException unused) {
            sb2 = new StringBuilder();
        } catch (Exception unused2) {
            sb2 = new StringBuilder();
        }
        C12836o.m77097b("WebViewPresenter", "getCloudChildInfo：" + sb2.toString(), false);
        return sb2.toString();
    }

    /* renamed from: J */
    public String m38189J(String str) {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("ext_clientInfo=");
            sb2.append(m38179B0());
            sb2.append("&chkType=");
            sb2.append(this.f31143p);
            sb2.append("&reqClientType=7");
            sb2.append("&lang=");
            sb2.append(URLEncoder.encode(str.toLowerCase(Locale.getDefault()), Constants.UTF_8));
            sb2.append(C12844w.m77139k(this.f31142o));
        } catch (UnsupportedEncodingException unused) {
            sb2 = new StringBuilder();
        }
        C12836o.m77097b("WebViewPresenter", "verifyPasswordData：" + ((Object) sb2), false);
        return sb2.toString();
    }

    /* renamed from: K */
    public String m38190K(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("factors", "");
            jSONObject.put("randomID", "");
            jSONObject.put("phonestateperm", str);
            jSONObject.put(VastAttribute.ERROR, str2);
        } catch (JSONException unused) {
            C12836o.m77097b("WebViewPresenter", "buildDefaultJson JSONException", true);
        }
        return jSONObject.toString();
    }

    /* renamed from: L */
    public HashMap<String, String> m38191L() {
        C12836o.m77097b("WebViewPresenter", "getVerifyPasswordHeaders start.", true);
        HashMap<String, String> map = new HashMap<>();
        map.put("srcAppVersion", "");
        map.put("srcAppName", this.f31142o.getPackageName());
        return map;
    }

    /* renamed from: M */
    public final void m38192M(C10343b c10343b) throws NumberFormatException {
        int i10;
        C12836o.m77097b("WebViewPresenter", "parseCode", true);
        String strM63694p = c10343b.m63694p("code");
        String strM63694p2 = c10343b.m63694p(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
        if (!TextUtils.isEmpty(strM63694p)) {
            C12836o.m77097b("WebViewPresenter", "get authorization_code success", true);
            m38226l(200, strM63694p2, strM63694p);
            return;
        }
        C12836o.m77097b("WebViewPresenter", "get authorization_code error", true);
        String strM63694p3 = c10343b.m63694p(VastAttribute.ERROR);
        String strM63694p4 = c10343b.m63694p("sub_error");
        try {
            i10 = Integer.parseInt(strM63694p3);
        } catch (NumberFormatException unused) {
            C12836o.m77099d("WebViewPresenter", "NumberFormatException", true);
            i10 = 404;
        }
        String strM63694p5 = c10343b.m63694p("error_description");
        C12836o.m77097b("WebViewPresenter", "get authorization_code errorCode " + i10, true);
        C12836o.m77097b("WebViewPresenter", "get authorization_code subError " + strM63694p4, false);
        C12836o.m77097b("WebViewPresenter", "get authorization_code errorMessage " + strM63694p5, false);
        m38226l(i10, "sub_error " + strM63694p4 + " " + strM63694p5, "");
    }

    /* renamed from: N */
    public String m38193N() {
        return this.f31135h;
    }

    /* renamed from: O */
    public String m38194O(Context context) {
        return this.f31126C + "?user_code=" + this.f31125B + "&cVersion=HwID_6.12.0.302" + C12844w.m77139k(context);
    }

    /* renamed from: P */
    public String m38195P(String str) {
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("loginUrl=");
            sb2.append(URLEncoder.encode(AbstractC12615a.m76116a().mo76119c() + "?reqClientType=7&loginChannel=7000000&displayType=2&clientID=" + this.f31129b + "&lang=" + str.toLowerCase(Locale.getDefault()) + C12844w.m77139k(this.f31142o), Constants.UTF_8));
            sb2.append("&service=");
            sb2.append(C11335b.m68098g().m68116t(this.f31142o));
            sb2.append("&loginChannel=");
            sb2.append(7000000);
            sb2.append("&reqClientType=");
            sb2.append(7);
            sb2.append("&lang=");
            sb2.append(URLEncoder.encode(str.toLowerCase(Locale.getDefault()), Constants.UTF_8));
            sb2.append("&appID=");
            sb2.append(this.f31129b);
            sb2.append("&qrSiteID=");
            sb2.append(this.f31140m);
            sb2.append("&qrCode=");
            sb2.append(this.f31138k);
            sb2.append(C12844w.m77139k(this.f31142o));
            if (!TextUtils.isEmpty(this.f31139l)) {
                sb2.append("&qrCodeSource=");
                sb2.append(this.f31139l);
            }
        } catch (UnsupportedEncodingException unused) {
            sb2 = new StringBuilder();
        } catch (Exception unused2) {
            sb2 = new StringBuilder();
        }
        C12836o.m77097b("WebViewPresenter", "qrLoginUrlData：" + ((Object) sb2), false);
        return sb2.toString();
    }

    /* renamed from: Q */
    public final String m38196Q(String str, String str2) throws UnsupportedEncodingException {
        return "LOGIN_MODE_HUAWEI_UNITE_ID".equals(this.f31136i) ? AbstractC12615a.m76116a().m76117a() : AbstractC12615a.m76116a().mo76119c() + "?reqClientType=" + this.f31148u + C12844w.m77139k(this.f31142o) + "&loginChannel=7000000&displayType=2&clientID=" + this.f31129b + "&lang=" + str.toLowerCase(Locale.getDefault()) + "&service=" + URLEncoder.encode(str2 + "?reqClientType=" + this.f31148u + C12844w.m77139k(this.f31142o), Constants.UTF_8);
    }

    /* renamed from: R */
    public final String m38197R(String str, String str2) {
        return m38220i(new StringBuilder(AbstractC12615a.m76116a().mo76123g()), str2, str).toString();
    }

    /* renamed from: S */
    public void m38198S() {
        if (TextUtils.isEmpty(this.f31146s)) {
            return;
        }
        String strM38252y0 = m38252y0(this.f31146s);
        C12836o.m77097b("WebViewPresenter", "fillAccountJs = " + strM38252y0, false);
        this.f31128a.mo38107b(strM38252y0);
    }

    /* renamed from: T */
    public void m38199T(String str) {
        C11130b c11130b = new C11130b(this.f31142o, str, "0", "");
        String strM76133q = C12617c.m76132p().m76133q();
        if (TextUtils.isEmpty(strM76133q)) {
            C12836o.m77099d("WebViewPresenter", "getResourceUrl is null.", true);
            this.f31128a.mo38104a(m38190K("1", "9999"));
            return;
        }
        String str2 = strM76133q + c11130b.mo38002d();
        m38245v(c11130b);
        C12836o.m77097b("WebViewPresenter", "getDeviceAuthCode:" + str2, false);
        new C12386d(c11130b, this.f31142o, str2, new b()).m74452a();
    }

    /* renamed from: U */
    public String m38200U() {
        return this.f31137j;
    }

    /* renamed from: V */
    public final String m38201V(String str, String str2) {
        try {
            return C10909b.m65951b(C12826e.m77027b(str2), C12826e.m77027b(str));
        } catch (InvalidAlgorithmParameterException unused) {
            C12836o.m77099d("WebViewPresenter", "NoSuchPaddingException ", true);
            return "";
        } catch (InvalidKeyException unused2) {
            C12836o.m77099d("WebViewPresenter", "InvalidKeyException ", true);
            return "";
        } catch (NoSuchAlgorithmException unused3) {
            C12836o.m77099d("WebViewPresenter", "NoSuchAlgorithmException ", true);
            return "";
        } catch (BadPaddingException unused4) {
            C12836o.m77099d("WebViewPresenter", "BadPaddingException ", true);
            return "";
        } catch (IllegalBlockSizeException unused5) {
            C12836o.m77099d("WebViewPresenter", "IllegalBlockSizeException ", true);
            return "";
        } catch (NoSuchPaddingException unused6) {
            C12836o.m77099d("WebViewPresenter", "NoSuchPaddingException ", true);
            return "";
        }
    }

    /* renamed from: W */
    public HashMap<String, String> m38202W(String str) {
        C12836o.m77097b("WebViewPresenter", "getHeaders start.", true);
        HashMap<String, String> map = new HashMap<>();
        map.put("X-Huawei-Client-Info", m38232o0(str));
        return map;
    }

    /* renamed from: X */
    public final String m38203X(String str, String str2) {
        return str2.equals("8") ? C9310c.m58618b(str) : "";
    }

    /* renamed from: Y */
    public HashMap<String, String> m38204Y(String str) {
        C12836o.m77097b("WebViewPresenter", "getQrCodeHeaders start.", true);
        HashMap<String, String> map = new HashMap<>();
        map.put("X-Huawei-Client-Info", m38232o0(str));
        map.put(FeedbackWebConstants.AUTHORIZATION, "Bearer " + this.f31131d);
        return map;
    }

    /* renamed from: Z */
    public boolean m38205Z() {
        return "from_other_app_signin".equalsIgnoreCase(this.f31133f);
    }

    /* renamed from: a0 */
    public final Intent m38206a0(String str, String str2) throws JSONException {
        C12836o.m77097b("WebViewPresenter", "getResultIntent", true);
        C12836o.m77097b("WebViewPresenter", "pickerSdk signIn return code", true);
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("statusCode", str2);
            jSONObject.put("status", jSONObject2);
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("serverAuthCode", str);
                jSONObject.put(CommonPickerConstant.RequestParams.KEY_SIGN_IN_HUAWEI_ID, jSONObject3);
            }
        } catch (JSONException unused) {
            C12836o.m77099d("WebViewPresenter", TrackConstants$Events.EXCEPTION, true);
        }
        Intent intent = new Intent();
        intent.putExtra("HUAWEIID_SIGNIN_RESULT", jSONObject.toString());
        return intent;
    }

    /* renamed from: b0 */
    public HashMap<String, String> m38207b0(String str) {
        C12836o.m77097b("WebViewPresenter", "getSignInHeaders start.", true);
        HashMap<String, String> map = new HashMap<>();
        map.put("X-Huawei-Client-Info", m38232o0(str));
        if (TextUtils.isEmpty(this.f31131d)) {
            return map;
        }
        map.put(FeedbackWebConstants.AUTHORIZATION, "Bearer " + this.f31131d);
        return map;
    }

    /* renamed from: c */
    public String m38208c() {
        return this.f31133f;
    }

    /* renamed from: c0 */
    public boolean m38209c0() {
        return "from_v3_signin".equalsIgnoreCase(this.f31133f);
    }

    /* renamed from: d */
    public final String m38210d(int i10, Map<String, String> map) {
        C12836o.m77097b("WebViewPresenter", "dealScanRequestUrl start.", true);
        String strM68102b = i10 > 0 ? C11335b.m68098g().m68102b(this.f31142o, i10) : "";
        return (TextUtils.isEmpty(strM68102b) || "https://".equals(strM68102b)) ? map.get("CASDomainUrl") : strM68102b;
    }

    /* renamed from: d0 */
    public String m38211d0() {
        return this.f31132e;
    }

    /* renamed from: e */
    public String m38212e(Context context) {
        String strM77007j = C12824c.m77007j(context);
        StringBuilder sb2 = new StringBuilder();
        try {
            sb2.append("ext_clientInfo=");
            sb2.append(m38179B0());
            sb2.append("&reqClientType=");
            sb2.append(7);
            sb2.append("&lang=");
            sb2.append(URLEncoder.encode(strM77007j.toLowerCase(Locale.getDefault()), Constants.UTF_8));
            sb2.append(C12844w.m77139k(this.f31142o));
            sb2.append("&service=");
            sb2.append(URLEncoder.encode(AbstractC12615a.m76116a().mo76130n() + Constants.QUESTION_STR + C12844w.m77139k(this.f31142o), Constants.UTF_8));
            sb2.append("&loginUrl=");
            sb2.append(URLEncoder.encode(AbstractC12615a.m76116a().mo76119c() + "?reqClientType=7&loginChannel=7000000&displayType=2&clientID=" + this.f31129b + "&lang=" + strM77007j.toLowerCase(Locale.getDefault()) + C12844w.m77139k(this.f31142o), Constants.UTF_8));
            sb2.append("&loginChannel=");
            sb2.append(7000000);
            sb2.append("&clientNonce=");
            sb2.append(C12824c.m76995Q());
        } catch (UnsupportedEncodingException unused) {
            sb2 = new StringBuilder();
        } catch (Exception unused2) {
            sb2 = new StringBuilder();
        }
        C12836o.m77097b("WebViewPresenter", "personalInfo：" + ((Object) sb2), false);
        return sb2.toString();
    }

    /* renamed from: e0 */
    public String m38213e0(String str) {
        StringBuilder sb2;
        String strM38238r0 = m38238r0();
        String strM38197R = m38197R(str, strM38238r0);
        if (this.f31152y || !TextUtils.isEmpty(this.f31131d)) {
            return strM38197R;
        }
        boolean zM72139f = C11990c.m72144k(this.f31142o).m72139f("getSignInCode", false);
        C12836o.m77097b("WebViewPresenter", "getSignInUrl  hasGetCode= " + zM72139f, true);
        if (zM72139f) {
            long jCurrentTimeMillis = System.currentTimeMillis() - C11990c.m72144k(this.f31142o).m72135b("getSignInCodeTime", 0L);
            C12836o.m77097b("WebViewPresenter", "getSignInUrl  midTime= " + jCurrentTimeMillis, true);
            if (jCurrentTimeMillis > 0 && jCurrentTimeMillis < 216000) {
                return strM38197R;
            }
        }
        try {
            sb2 = new StringBuilder(AbstractC12615a.m76116a().mo76119c());
            sb2.append("?service");
            sb2.append('=');
            sb2.append(URLEncoder.encode(strM38197R, Constants.UTF_8));
            sb2.append("&lang=");
            sb2.append(str);
            sb2.append("&loginChannel=");
            sb2.append(TextUtils.isEmpty(this.f31147t) ? Integer.valueOf(OrderStatusCode.NOT_SUPPORT) : this.f31147t);
            sb2.append("&reqClientType=");
            sb2.append(TextUtils.isEmpty(this.f31148u) ? 7 : this.f31148u);
            sb2.append("&clientID=");
            sb2.append(URLEncoder.encode(this.f31129b, Constants.UTF_8));
            sb2.append(C12844w.m77139k(this.f31142o));
            if (!TextUtils.isEmpty(strM38238r0)) {
                sb2.append("&countryCode=");
                sb2.append(strM38238r0);
            }
        } catch (Exception e10) {
            C12836o.m77099d("WebViewPresenter", "Exception:" + e10.getClass().getSimpleName(), true);
            sb2 = new StringBuilder();
        }
        return sb2.toString();
    }

    /* renamed from: f */
    public String m38214f(SafeWebView safeWebView, String str) throws JSONException {
        C12836o.m77097b("WebViewPresenter", "buildAuthInfo", true);
        if (!safeWebView.m53594c(AbstractC12615a.m76116a().mo76122f())) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            DeviceInfo deviceInfo = this.f31134g;
            if (deviceInfo != null) {
                jSONObject.put(JsbMapKeyNames.H5_DEVICE_TYPE, deviceInfo.m38011m());
                jSONObject.put("deviceId", this.f31134g.m38007e());
                jSONObject.put("uuid", this.f31134g.m38015q());
            }
            jSONObject.put("packageName", str);
            jSONObject.put("reqClientType", "");
            jSONObject.put("loginChannel", "90000100");
            if (!TextUtils.isEmpty(this.f31131d)) {
                jSONObject.put("accessToken", this.f31131d);
            }
            jSONObject.put("tokenType", 1);
            C12836o.m77097b("WebViewPresenter", "mAuthInfoString", true);
            String string = jSONObject.toString();
            C12836o.m77097b("WebViewPresenter", "buildAuthInfo: json string = " + string, false);
            return string;
        } catch (JSONException unused) {
            C12836o.m77099d("WebViewPresenter", "JSONException", true);
            return null;
        }
    }

    /* renamed from: f0 */
    public String m38215f0() {
        return this.f31150w;
    }

    /* renamed from: g */
    public String m38216g(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        if (TextUtils.isEmpty(this.f31148u)) {
            this.f31148u = "7";
        }
        try {
            sb2.append("ext_clientInfo=");
            sb2.append(m38179B0());
            sb2.append("&loginUrl=");
            sb2.append(URLEncoder.encode(m38196Q(str, str2), Constants.UTF_8));
            sb2.append("&service=");
            sb2.append(URLEncoder.encode(str2 + "?reqClientType=" + this.f31148u + C12844w.m77139k(this.f31142o) + "&loginChannel=7000000&service=" + URLEncoder.encode(C11335b.m68098g().m68113q(this.f31142o), Constants.UTF_8) + "&displayType=2&lang=" + str.toLowerCase(Locale.getDefault()), Constants.UTF_8));
            sb2.append("&loginChannel=");
            sb2.append(7000000);
            sb2.append("&reqClientType=");
            sb2.append(Integer.parseInt(this.f31148u));
            sb2.append("&lang=");
            sb2.append(URLEncoder.encode(str.toLowerCase(Locale.getDefault()), Constants.UTF_8));
        } catch (UnsupportedEncodingException unused) {
            sb2 = new StringBuilder();
        } catch (RuntimeException unused2) {
            sb2 = new StringBuilder();
        } catch (Exception unused3) {
            sb2 = new StringBuilder();
        }
        C12836o.m77097b("WebViewPresenter", "centerUrlData：" + ((Object) sb2), false);
        return sb2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0034  */
    /* renamed from: g0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m38217g0(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwidauth.p167ui.C6723h.m38217g0(java.lang.String):boolean");
    }

    /* renamed from: h */
    public final String m38218h(JSONObject jSONObject, boolean z10) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(CommonPickerConstant.RequestParams.KEY_SIGN_IN_HUAWEI_ID, jSONObject);
            jSONObject2.put("result", z10);
        } catch (JSONException unused) {
            C12836o.m77099d("WebViewPresenter", "getSignInResult JSONException", true);
        } catch (Exception unused2) {
            C12836o.m77099d("WebViewPresenter", "getSignInResult Exception", true);
        }
        return jSONObject2.toString();
    }

    /* renamed from: h0 */
    public boolean m38219h0() {
        try {
            return ((Boolean) Class.forName("android.app.Activity").getMethod("isInMultiWindowMode", new Class[0]).invoke(this, new Object[0])).booleanValue();
        } catch (ClassNotFoundException unused) {
            C12836o.m77097b("WebViewPresenter", "ClassNotFoundException", true);
            return false;
        } catch (IllegalAccessException unused2) {
            C12836o.m77097b("WebViewPresenter", "IllegalAccessException", true);
            return false;
        } catch (IllegalArgumentException unused3) {
            C12836o.m77097b("WebViewPresenter", "IllegalArgumentException", true);
            return false;
        } catch (NoSuchMethodException unused4) {
            C12836o.m77097b("WebViewPresenter", "NoSuchMethodException", true);
            return false;
        } catch (RuntimeException unused5) {
            C12836o.m77097b("WebViewPresenter", "RuntimeException", true);
            return false;
        } catch (InvocationTargetException unused6) {
            C12836o.m77097b("WebViewPresenter", "InvocationTargetException", true);
            return false;
        } catch (Exception unused7) {
            C12836o.m77097b("WebViewPresenter", "Exception", true);
            return false;
        }
    }

    /* renamed from: i */
    public final StringBuilder m38220i(StringBuilder sb2, String str, String str2) {
        try {
            sb2.append("access_type=offline");
            sb2.append('&');
            sb2.append(CommonConstant.ReqAccessTokenParam.RESPONSE_TYPE);
            sb2.append('=');
            sb2.append("code");
            sb2.append('&');
            sb2.append(CommonConstant.ReqAccessTokenParam.CLIENT_ID);
            sb2.append('=');
            sb2.append(URLEncoder.encode(this.f31129b, Constants.UTF_8));
            sb2.append('&');
            sb2.append("ui_locales");
            sb2.append('=');
            sb2.append(URLEncoder.encode(str2.toLowerCase(Locale.getDefault()), Constants.UTF_8));
            sb2.append('&');
            sb2.append(CommonConstant.ReqAccessTokenParam.REDIRECT_URI);
            sb2.append('=');
            sb2.append(URLEncoder.encode(this.f31132e, Constants.UTF_8));
            sb2.append('&');
            sb2.append(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
            sb2.append('=');
            sb2.append(URLEncoder.encode(C12843v.m77126c(), Constants.UTF_8));
            String str3 = this.f31130c;
            if (this.f31152y) {
                sb2.append("&independent_authorization=");
                sb2.append(FaqConstants.DISABLE_HA_REPORT);
            } else if (!str3.contains("openid")) {
                str3 = "openid " + str3;
            }
            if (!TextUtils.isEmpty(str3)) {
                sb2.append('&');
                sb2.append("scope");
                sb2.append('=');
                sb2.append(URLEncoder.encode(str3, Constants.UTF_8));
            }
            sb2.append('&');
            sb2.append("display");
            sb2.append('=');
            sb2.append("touch");
            sb2.append('&');
            sb2.append("nonce");
            sb2.append('=');
            sb2.append(URLEncoder.encode(C12842u.m77123b(), Constants.UTF_8));
            sb2.append('&');
            sb2.append("include_granted_scopes");
            sb2.append('=');
            sb2.append(FaqConstants.DISABLE_HA_REPORT);
            sb2.append('&');
            sb2.append("uuid");
            sb2.append('=');
            sb2.append(this.f31134g.m38015q());
            sb2.append(C12844w.m77139k(this.f31142o));
            if (!TextUtils.isEmpty(this.f31147t)) {
                sb2.append("&loginChannel=");
                sb2.append(this.f31147t);
            }
            if (!TextUtils.isEmpty(this.f31148u)) {
                sb2.append("&reqClientType=");
                sb2.append(this.f31148u);
            }
            if (!TextUtils.isEmpty(str)) {
                sb2.append("&countryCode=");
                sb2.append(str);
            }
            sb2.append("&cVersion=");
            sb2.append("HwID_6.12.0.302");
            if (!this.f31124A) {
                return sb2;
            }
            String strEncodeToString = SafeBase64.encodeToString(MessageDigest.getInstance("SHA-256").digest(this.f31153z.getBytes("ISO_8859_1")), 11);
            sb2.append("&code_challenge=");
            sb2.append(strEncodeToString);
            sb2.append("&code_challenge_method=");
            sb2.append("S256");
            if (!TextUtils.isEmpty(this.f31131d)) {
                sb2.append("&auth_type=");
                sb2.append("1");
            }
            String strM77124a = C12843v.m77124a();
            if (TextUtils.isEmpty(strM77124a)) {
                strM77124a = "unkown";
            }
            sb2.append("&terminal-type=");
            sb2.append(strM77124a);
            return sb2;
        } catch (UnsupportedEncodingException e10) {
            C12836o.m77099d("WebViewPresenter", "UnsupportedEncodingException:" + e10.getClass().getSimpleName(), true);
            return new StringBuilder();
        } catch (RuntimeException e11) {
            C12836o.m77099d("WebViewPresenter", "RuntimeException:" + e11.getClass().getSimpleName(), true);
            return new StringBuilder();
        } catch (NoSuchAlgorithmException e12) {
            C12836o.m77099d("WebViewPresenter", "NoSuchAlgorithmException:" + e12.getClass().getSimpleName(), true);
            return new StringBuilder();
        } catch (Exception e13) {
            C12836o.m77099d("WebViewPresenter", "Exception:" + e13.getClass().getSimpleName(), true);
            return new StringBuilder();
        }
    }

    /* renamed from: i0 */
    public boolean m38221i0(String str) {
        C12836o.m77097b("WebViewPresenter", "checkOverLoadRedirectUrlStart: url = " + str, false);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f31132e)) {
            return false;
        }
        if (!str.startsWith(this.f31132e + Constants.QUESTION_STR)) {
            if (!str.startsWith(this.f31132e + "&")) {
                return false;
            }
        }
        return true;
    }

    @Override // com.huawei.hwidauth.p167ui.AbstractC6717b
    public void init(SafeIntent safeIntent) {
        C12836o.m77097b("WebViewPresenter", "init", true);
        Bundle extras = safeIntent.getExtras();
        if (extras == null) {
            C12836o.m77099d("WebViewPresenter", "Excepton：bundle null", true);
            m38226l(404, "parse intent exception", "");
        } else {
            m38233p(new C10343b(extras), safeIntent);
            C12836o.m77097b("WebViewPresenter", "init end", true);
        }
    }

    /* renamed from: j */
    public final JSONObject m38222j(String str, String str2, String str3, String str4) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("code", str);
                jSONObject.put(CommonConstant.ReqAccessTokenParam.STATE_LABEL, str2);
                jSONObject.put("risks", str3);
            } else if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("ticket", str4);
            }
        } catch (JSONException unused) {
            C12836o.m77099d("WebViewPresenter", "getSucJsonObject JSONException", true);
        } catch (Exception unused2) {
            C12836o.m77099d("WebViewPresenter", "getSucJsonObject Exception", true);
        }
        return jSONObject;
    }

    /* renamed from: j0 */
    public final void m38223j0() {
        C12836o.m77097b("WebViewPresenter", "parsingExtendsParam mExtendsParam =" + this.f31144q, false);
        if (TextUtils.isEmpty(this.f31144q)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.f31144q);
            if (jSONObject.has("countryCode")) {
                this.f31145r = jSONObject.getString("countryCode");
            }
            if (jSONObject.has("phoneNumber")) {
                this.f31146s = jSONObject.getString("phoneNumber");
            }
            if (jSONObject.has("reqClientType")) {
                this.f31148u = jSONObject.getString("reqClientType");
            }
            if (jSONObject.has("loginChannel")) {
                this.f31147t = jSONObject.getString("loginChannel");
            }
        } catch (JSONException unused) {
            C12836o.m77099d("WebViewPresenter", "parsingExtendsParam Exception", true);
            m38226l(404, "parse intent exception", "");
        }
    }

    /* renamed from: k */
    public final void m38224k(int i10, String str) {
        C12836o.m77097b("WebViewPresenter", "handleFromPickerResult", true);
        ((WebViewActivity) this.f31142o).runOnUiThread(new d(i10, str));
    }

    /* renamed from: k0 */
    public boolean m38225k0(String str) throws NumberFormatException {
        Bundle bundleM77016s;
        C12836o.m77097b("WebViewPresenter", "redirectUrl url:" + this.f31132e + Constants.QUESTION_STR, false);
        if (m38221i0(str) && (bundleM77016s = C12824c.m77016s(str)) != null) {
            C10343b c10343b = new C10343b(bundleM77016s);
            if (C12824c.m77004g(bundleM77016s)) {
                C12836o.m77097b("WebViewPresenter", "get code success", true);
                m38192M(c10343b);
                return true;
            }
            if (!TextUtils.isEmpty(bundleM77016s.getString(VastAttribute.ERROR, ""))) {
                C12836o.m77097b("WebViewPresenter", "get code error", true);
                m38192M(c10343b);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m38226l(int r13, java.lang.String r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwidauth.p167ui.C6723h.m38226l(int, java.lang.String, java.lang.String):void");
    }

    /* renamed from: l0 */
    public final String m38227l0() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ED", this.f31141n);
        } catch (JSONException unused) {
            C12836o.m77099d("WebViewPresenter", "JSONException_ed", true);
        }
        return jSONObject.toString();
    }

    /* renamed from: m */
    public final void m38228m(int i10, String str, String str2, String str3) {
        C12836o.m77097b("WebViewPresenter", "packingResult stateCode = " + i10 + "--statusMessage = " + str + "--authorizationCode =" + str2, false);
        Intent intent = new Intent();
        if (i10 != 200) {
            intent.putExtra("HUAWEIID_SIGNIN_RESULT", m38218h(m38184E(i10, str), false));
            this.f31128a.mo38110c(0, intent);
            C13056a.m78783c(this.f31142o, 907115001, 404, str, this.f31137j, str3, "api_ret");
        } else {
            if (m38209c0()) {
                m38181C0(str2);
            }
            intent.putExtra("HUAWEIID_SIGNIN_RESULT", m38218h(m38222j(str2, null, null, null), true));
            this.f31128a.mo38110c(-1, intent);
            C13056a.m78783c(this.f31142o, 907115001, 200, str, this.f31137j, str3, "api_ret");
        }
    }

    /* renamed from: m0 */
    public boolean m38229m0(String str) {
        C12836o.m77097b("WebViewPresenter", "enter checkSignInService", true);
        Bundle bundleM77016s = C12824c.m77016s(str);
        if (bundleM77016s == null) {
            return false;
        }
        C10343b c10343b = new C10343b(bundleM77016s);
        if ("pickerSignIn".equals(this.f31150w)) {
            m38226l(200, c10343b.m63694p(CommonConstant.ReqAccessTokenParam.STATE_LABEL), c10343b.m63694p("code"));
            return true;
        }
        if (c10343b.m63679a("isNotHuaweiId") && "1".equals(c10343b.m63695q("isNotHuaweiId", "0"))) {
            String strM63695q = c10343b.m63695q("ticket", "");
            if (TextUtils.isEmpty(strM63695q)) {
                return false;
            }
            Intent intent = new Intent();
            intent.putExtra("HUAWEIID_SIGNIN_RESULT", m38218h(m38222j(null, null, null, strM63695q), true));
            this.f31128a.mo38110c(-1, intent);
            C12836o.m77097b("WebViewPresenter", "checkSignInService get ticket exit", true);
            return true;
        }
        String strM63695q2 = c10343b.m63695q("code", "");
        String strM63695q3 = c10343b.m63695q(CommonConstant.ReqAccessTokenParam.STATE_LABEL, "");
        String strM63695q4 = c10343b.m63695q("risks", "");
        if (TextUtils.isEmpty(strM63695q2)) {
            return false;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("HUAWEIID_SIGNIN_RESULT", m38218h(m38222j(strM63695q2, strM63695q3, strM63695q4, null), true));
        this.f31128a.mo38110c(-1, intent2);
        C12836o.m77097b("WebViewPresenter", "checkSignInService get code exit", true);
        return true;
    }

    /* renamed from: n0 */
    public final String m38230n0() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("D", m38250x0());
        } catch (JSONException unused) {
            C12836o.m77099d("WebViewPresenter", "JSONException_d", true);
        }
        return jSONObject.toString();
    }

    /* renamed from: o */
    public void m38231o(C10343b c10343b) throws JSONException {
        C12836o.m77097b("WebViewPresenter", "handleRequestGetDevAuthCode ==", true);
        try {
            String strM63694p = c10343b.m63694p("devAuthCode");
            String strM63694p2 = c10343b.m63694p("devSecretKey");
            String strM63694p3 = c10343b.m63694p("randomID");
            Context context = this.f31142o;
            String strM77100a = context instanceof Activity ? C12837p.m77100a((Activity) context) : "NONE";
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("uuid", this.f31134g.m38015q());
            jSONObject.put("terminalType", this.f31134g.m38009j());
            jSONObject.put("deviceName", this.f31134g.m38013o());
            jSONObject.put(JsbMapKeyNames.H5_DEVICE_TYPE, this.f31134g.m38011m());
            jSONObject.put("deviceID", this.f31134g.m38007e());
            jSONObject.put("deviceAuthCode", strM63694p);
            jSONObject.put("loginStatus", "0");
            jSONObject.put("netType", strM77100a);
            C12836o.m77097b("WebViewPresenter", "GetDevAuthCode ==" + jSONObject.toString(), false);
            jSONObject2.put("factors", TextUtils.isEmpty(strM63694p2) ? "" : m38201V(strM63694p2, jSONObject.toString()));
            jSONObject2.put("randomID", strM63694p3);
            this.f31128a.mo38104a(jSONObject2.toString());
        } catch (Exception unused) {
            C12836o.m77097b("WebViewPresenter", "JSONException", true);
            this.f31128a.mo38104a(m38190K("1", "9999"));
        }
    }

    /* renamed from: o0 */
    public String m38232o0(String str) {
        C12836o.m77097b("WebViewPresenter", "getDeviceInfo", true);
        if (C12826e.m77028c(str)) {
            C12836o.m77097b("WebViewPresenter", "getEdJsonStr", true);
            return m38227l0();
        }
        C12836o.m77097b("WebViewPresenter", "getDJsonStr", true);
        return m38230n0();
    }

    /* renamed from: p */
    public final void m38233p(C10343b c10343b, SafeIntent safeIntent) {
        try {
            this.f31129b = c10343b.m63694p("key_app_id");
            this.f31130c = c10343b.m63694p("key_scopes");
            this.f31131d = c10343b.m63694p("key_access_token");
            this.f31132e = c10343b.m63695q("key_redirecturi", "");
            this.f31133f = c10343b.m63695q("key_oper", "");
            this.f31150w = safeIntent.getStringExtra("key_pickerSignIn");
            this.f31134g = (DeviceInfo) c10343b.m63691m("key_device_info", DeviceInfo.class);
            this.f31138k = c10343b.m63694p("key_qr_code");
            this.f31140m = c10343b.m63686h("key_qr_siteid");
            this.f31139l = c10343b.m63695q("key_qr_code_source", "");
            this.f31143p = c10343b.m63694p("key_check_password_type");
            this.f31144q = c10343b.m63694p("key_extends_param");
            this.f31135h = c10343b.m63694p("key_cp_login_url");
            this.f31136i = c10343b.m63694p("key_login_mode");
            this.f31148u = c10343b.m63694p("reqClientType");
            this.f31149v = c10343b.m63694p("key_uid");
            this.f31137j = c10343b.m63694p("key_transId");
            this.f31153z = c10343b.m63694p("key_code_verifier");
            this.f31124A = c10343b.m63681c("key_mcp_signIn");
            this.f31152y = c10343b.m63682d("independentAuthorization", false);
            this.f31125B = c10343b.m63694p("user_code");
            this.f31126C = c10343b.m63694p("verification_url");
            this.f31127D = c10343b.m63694p("grs_app_name");
            m38223j0();
            if (TextUtils.isEmpty(this.f31133f) || !"from_qr_authorize".equals(this.f31133f)) {
                m38242t0();
            }
        } catch (RuntimeException unused) {
            C12836o.m77099d("WebViewPresenter", "RuntimeException：parse intent", true);
            m38226l(404, "parse intent exception", "");
        } catch (Exception unused2) {
            C12836o.m77099d("WebViewPresenter", "Exception：parse intent", true);
            m38226l(404, "parse intent exception", "");
        }
    }

    /* renamed from: p0 */
    public String m38234p0(String str) {
        C12836o.m77097b("WebViewPresenter", "the loginUrl is:" + str, false);
        if (TextUtils.isEmpty(str) || !str.contains(AuthInternalPickerConstant.EXT_CLIENTINFO_STUB)) {
            C12836o.m77097b("WebViewPresenter", "the loginUrl is empty or loginUrl not contains ext_clientInfo", true);
            return str;
        }
        String strM38183D0 = m38183D0(str);
        C12836o.m77097b("WebViewPresenter", "the deviceInfo is:" + strM38183D0, false);
        return str.replace(AuthInternalPickerConstant.EXT_CLIENTINFO_STUB, "ext_clientInfo=" + strM38183D0);
    }

    /* renamed from: q */
    public final void m38235q(InterfaceC10596j interfaceC10596j, InterfaceC10595i interfaceC10595i, int i10, int i11, String str, String str2) {
        if (interfaceC10596j != null) {
            interfaceC10596j.onResult(interfaceC10595i);
            C13056a.m78783c(this.f31142o, i10, i11, str, this.f31137j, str2, "api_ret");
        } else {
            C13056a.m78783c(this.f31142o, i10, 404, "callBack is null", this.f31137j, str2, "api_ret");
        }
        this.f31128a.mo38106b();
    }

    /* renamed from: q0 */
    public final void m38236q0() {
        C12836o.m77097b("WebViewPresenter", "executeGetResourceRequest==", true);
        String strM76133q = C12617c.m76132p().m76133q();
        if (TextUtils.isEmpty(strM76133q)) {
            C12836o.m77099d("WebViewPresenter", "getResourceUrl is null.", true);
            m38226l(6, "User cancel", "");
            return;
        }
        C11131c c11131c = new C11131c(this.f31142o, "casLogin");
        String str = strM76133q + c11131c.mo38002d();
        C12836o.m77097b("WebViewPresenter", "executeGetResourceRequest:" + str, false);
        new C12387e(c11131c, this.f31142o, str, new a()).m74452a();
    }

    /* renamed from: r */
    public final void m38237r(C10600n c10600n, int i10, String str) {
        String str2 = this.f31133f;
        str2.hashCode();
        switch (str2) {
            case "from_open_realNameInfo":
                m38235q(C12824c.m76987I(), new C10601o(c10600n), 907115010, i10, str, "accountPickerH5.openRealNameInfo");
                C12836o.m77097b("WebViewPresenter", "CONST_OPEN_REAL_NAME", true);
                break;
            case "from_open_childInfo":
                InterfaceC10596j interfaceC10596jM76988J = C12824c.m76988J();
                if (c10600n.m64995a() == 10001401) {
                    c10600n = new C10600n(2008, "AccessToken is invalid.");
                }
                m38235q(interfaceC10596jM76988J, new C10601o(c10600n), 907115012, i10, str, "accountPickerH5.openChildAccountDetailInfo");
                C12836o.m77097b("WebViewPresenter", "CallBack CONST_OPEN_CHILD_INFO", true);
                break;
            case "from_qr_authorize":
                m38235q(C12824c.m76989K(), new C10601o(c10600n), 907115011, i10, str, "accountPickerH5.qrCodeAuthorize");
                C12836o.m77097b("WebViewPresenter", "CONST_QR_AUTHORIZE", true);
                break;
            case "open_personal_info":
                m38235q(C12824c.m76985G(), new C10601o(c10600n), 907115006, i10, str, "accountPickerH5.openPersonalInfo");
                C12836o.m77097b("WebViewPresenter", "CONST_OPEN_PERSONAL_INFO", true);
                break;
            default:
                C12836o.m77097b("WebViewPresenter", "dealOtherOper not match", true);
                this.f31128a.mo38106b();
                break;
        }
    }

    /* renamed from: r0 */
    public final String m38238r0() {
        if (!TextUtils.isEmpty(this.f31145r)) {
            return this.f31145r;
        }
        String strM68117u = C11335b.m68098g().m68117u(this.f31142o.getApplicationContext());
        C12836o.m77097b("WebViewPresenter", "countryIsoCoce:" + strM68117u, false);
        return !TextUtils.isEmpty(strM68117u) ? strM68117u : "";
    }

    /* renamed from: s */
    public void m38239s(String str) {
        this.f31151x = str;
    }

    /* renamed from: s0 */
    public final String m38240s0(String str) {
        String strM76993O = C12824c.m76993O();
        if (!TextUtils.isEmpty(strM76993O)) {
            try {
                byte[] bArrM60809b = AbstractC9773a.m60809b(m38244u0(str), C10048b.m62474f(strM76993O));
                if (bArrM60809b == null) {
                    C12836o.m77099d("WebViewPresenter", "rsaJsonBytes null", false);
                    return "";
                }
                this.f31141n = SafeBase64.encodeToString(bArrM60809b, 2);
                C12836o.m77097b("WebViewPresenter", "getJsonHeader  mRSAJsonStr " + this.f31141n, false);
                return this.f31141n;
            } catch (Exception e10) {
                C12836o.m77099d("WebViewPresenter", "Exception:" + e10.getClass().getSimpleName(), true);
            }
        }
        return "";
    }

    /* renamed from: t */
    public final void m38241t(String str, String str2, String str3, String str4, String str5, String str6) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("get domain url from grs mainDomainUrl size:");
        sb2.append(str == null ? 0 : str.length());
        C12836o.m77097b("WebViewPresenter", sb2.toString(), true);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("get domain url from grs cASDomainUrl size:");
        sb3.append(str2 == null ? 0 : str2.length());
        C12836o.m77097b("WebViewPresenter", sb3.toString(), true);
        StringBuilder sb4 = new StringBuilder();
        sb4.append("get domain url from grs authorizeUrl size:");
        sb4.append(str4 == null ? 0 : str4.length());
        C12836o.m77097b("WebViewPresenter", sb4.toString(), true);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("get domain url from grs getResourceUrl size:");
        sb5.append(str3 == null ? 0 : str3.length());
        C12836o.m77097b("WebViewPresenter", sb5.toString(), true);
        StringBuilder sb6 = new StringBuilder();
        sb6.append("get domain url from grs gwSilentCodeUrl size:");
        sb6.append(str5 == null ? 0 : str5.length());
        C12836o.m77097b("WebViewPresenter", sb6.toString(), true);
        StringBuilder sb7 = new StringBuilder();
        sb7.append("get domain url from grs root ");
        sb7.append(str6 != null ? str6.length() : 0);
        C12836o.m77097b("WebViewPresenter", sb7.toString(), true);
    }

    /* renamed from: t0 */
    public final void m38242t0() {
        m38240s0(m38246v0());
    }

    /* renamed from: u */
    public final void m38243u(Map<String, String> map) {
        C12836o.m77097b("WebViewPresenter", "handleGrsUrlMap start.", true);
        C12836o.m77097b("WebViewPresenter", "get hw domain.", true);
        String strM38210d = "scan_code_login".equalsIgnoreCase(this.f31133f) ? m38210d(this.f31140m, map) : map.get("CASDomainUrl");
        String str = map.get("CASDomainUrl");
        String str2 = map.get("CASGetResourceUrl");
        String str3 = map.get("CASAuthorizeUrl");
        String str4 = map.get("GwSilentCodeUrl");
        String str5 = map.get("Root");
        if (TextUtils.isEmpty(strM38210d) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            C12836o.m77099d("WebViewPresenter", "url is empty exit", true);
            m38226l(6, "User cancel", "");
            return;
        }
        m38241t(strM38210d, str, str2, str3, str4, str5);
        AbstractC12615a.m76116a().mo76118b(strM38210d, str2, str3);
        C12836o.m77097b("WebViewPresenter", "initDomainUrlAndLoadUrl", true);
        if (!TextUtils.isEmpty(C12824c.m76993O()) && !C12825d.m77024a(C12824c.m76994P()).booleanValue()) {
            m38247w(false);
        } else {
            m38247w(true);
            m38236q0();
        }
    }

    /* renamed from: u0 */
    public final byte[] m38244u0(String str) {
        byte[] bArr = new byte[0];
        if (TextUtils.isEmpty(str)) {
            C12836o.m77099d("WebViewPresenter", "data is empty", true);
            return bArr;
        }
        try {
            return C12829h.m77061f() ? m38176A(str.getBytes(Constants.UTF_8)) : str.getBytes(Constants.UTF_8);
        } catch (UnsupportedEncodingException e10) {
            C12836o.m77099d("WebViewPresenter", "getBytes error" + e10.getClass().getSimpleName(), true);
            return bArr;
        }
    }

    /* renamed from: v */
    public void m38245v(C11130b c11130b) {
        c11130b.m66930i(this.f31134g);
    }

    /* renamed from: v0 */
    public final String m38246v0() throws JSONException {
        if (this.f31134g == null) {
            m38226l(404, "parameter error DeviceInfo is null", "");
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        String strM38203X = m38203X(this.f31134g.m38007e(), this.f31134g.m38011m());
        try {
            jSONObject.put("terminalType", this.f31134g.m38009j());
            jSONObject.put("deviceAliasName", this.f31134g.m38013o());
            jSONObject.put(JsbMapKeyNames.H5_DEVICE_TYPE, this.f31134g.m38011m());
            jSONObject.put("deviceID", this.f31134g.m38007e());
            if (!TextUtils.isEmpty(strM38203X)) {
                jSONObject.put("deviceID2", strM38203X);
            }
            jSONObject.put("uuid", this.f31134g.m38015q());
            Context context = this.f31142o;
            jSONObject.put("netType", context instanceof Activity ? C12837p.m77100a((Activity) context) : "NONE");
        } catch (JSONException unused) {
            C12836o.m77097b("WebViewPresenter", "JSONException", true);
            m38226l(404, "parameter error DeviceInfo is error", "");
        }
        C12836o.m77097b("WebViewPresenter", "getEDjson" + jSONObject.toString(), false);
        return jSONObject.toString();
    }

    /* renamed from: w */
    public final void m38247w(boolean z10) {
        C12836o.m77097b("WebViewPresenter", "setLoading", true);
        Context context = this.f31142o;
        if (context instanceof WebViewActivity) {
            ((WebViewActivity) context).runOnUiThread(new c(z10));
        }
    }

    /* renamed from: w0 */
    public final boolean m38248w0(String str) {
        if ("from_open_center_mng_new".equalsIgnoreCase(m38208c()) && str.startsWith(AbstractC12615a.m76116a().m76117a())) {
            InterfaceC10596j interfaceC10596jM76990L = C12824c.m76990L();
            C10600n c10600n = new C10600n(2008, "invalid at");
            c10600n.m64999e(false);
            C10599m c10599m = new C10599m(c10600n);
            if (interfaceC10596jM76990L != null) {
                C13056a.m78783c(this.f31142o, 907115004, 404, "access token is invalid", this.f31137j, "accountPickerH5.openAccountManager_v3", "api_ret");
                interfaceC10596jM76990L.onResult(c10599m);
                this.f31128a.mo38106b();
                return true;
            }
        }
        return false;
    }

    /* renamed from: x */
    public boolean m38249x(int i10) {
        if (m38251y((Activity) this.f31142o, new String[]{"android.permission.CAMERA"}, i10)) {
            C12836o.m77097b("WebViewPresenter", "checkCameraPermission return true", true);
            return true;
        }
        C12836o.m77097b("WebViewPresenter", "checkCameraPermission return false", true);
        return false;
    }

    /* renamed from: x0 */
    public final String m38250x0() throws JSONException {
        if ("from_qr_authorize".equals(this.f31133f)) {
            C12836o.m77097b("WebViewPresenter", "mFrom is from_qr_authorize and deviceinfo is null", true);
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("terminalType", this.f31134g.m38009j());
            jSONObject.put("deviceAliasName", this.f31134g.m38013o());
        } catch (JSONException unused) {
            C12836o.m77097b("WebViewPresenter", "JSONException", true);
        }
        C12836o.m77097b("WebViewPresenter", "getDjson:" + jSONObject.toString(), false);
        return jSONObject.toString();
    }

    @TargetApi(23)
    /* renamed from: y */
    public final boolean m38251y(Activity activity, String[] strArr, int i10) {
        if (activity != null && strArr != null && strArr.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if (activity.checkSelfPermission(str) != 0) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() > 0) {
                activity.requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), i10);
                return false;
            }
        }
        return true;
    }

    /* renamed from: y0 */
    public final String m38252y0(String str) {
        return "javascript:fillAccount('1','" + C11342a.m68144f(str) + "')";
    }

    /* renamed from: z */
    public boolean m38253z(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return false;
        }
        for (int i10 : iArr) {
            if (i10 != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: z0 */
    public final String m38254z0() {
        if (!this.f31152y) {
            return "accountPickerH5.signIn_v2";
        }
        C12836o.m77097b("WebViewPresenter", "IndependentAuthorization", true);
        return "independent_authorization";
    }
}
