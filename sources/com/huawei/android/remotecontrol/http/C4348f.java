package com.huawei.android.remotecontrol.http;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import ck.C1443a;
import com.huawei.android.remotecontrol.config.RequestModeConfig;
import com.huawei.android.remotecontrol.util.account.bean.AccountInfo;
import com.huawei.hicloud.request.okhttp.request.AbstractC4994a;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.phoneservice.feedbackcommon.network.FeedbackWebConstants;
import eg.AbstractC9478g;
import fk.C9721b;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import mk.C11475a;
import okhttp3.AbstractC11920f0;
import okhttp3.C11910a0;
import okhttp3.C11918e0;
import p015ak.C0209d;
import p015ak.C0228m0;
import p015ak.C0234s;
import p514o9.C11842p;
import p521og.C11870c;
import p521og.C11877j;
import p575qe.C12347f;
import p616rk.C12515a;
import p681uj.C13195l;
import p709vj.C13452e;
import p809yg.C13981a;
import p846zj.C14306d;
import pg.AbstractC12139d;
import sg.C12796a;

/* renamed from: com.huawei.android.remotecontrol.http.f */
/* loaded from: classes4.dex */
public class C4348f extends AbstractC4994a {

    /* renamed from: a */
    public String f19832a;

    /* renamed from: b */
    public String f19833b;

    /* renamed from: c */
    public Context f19834c;

    /* renamed from: d */
    public int f19835d;

    /* renamed from: e */
    public String f19836e;

    /* renamed from: f */
    public String f19837f;

    /* renamed from: g */
    public String f19838g;

    /* renamed from: h */
    public boolean f19839h;

    /* renamed from: i */
    public String f19840i;

    /* renamed from: j */
    public boolean f19841j;

    /* renamed from: com.huawei.android.remotecontrol.http.f$a */
    public class a extends AbstractC9478g {

        /* renamed from: a */
        public final /* synthetic */ String f19842a;

        /* renamed from: b */
        public final /* synthetic */ String f19843b;

        public a(String str, String str2) {
            this.f19842a = str;
            this.f19843b = str2;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            new C12796a().m76773f(C12347f.m74285n().m74301m(), "001_3019", this.f19842a, "01074", "01074", null, this.f19843b, null);
        }
    }

    public C4348f(Context context, String str, String str2, String str3, int i10) {
        super(str, str2, "POST");
        this.f19837f = null;
        this.f19838g = null;
        this.f19839h = false;
        this.f19834c = context;
        this.f19832a = str2;
        this.f19833b = str3;
        this.f19835d = i10;
    }

    /* renamed from: a */
    public String m26241a() {
        return this.f19836e;
    }

    /* renamed from: b */
    public final String m26242b() {
        if (!C13452e.m80781L().m80842P0()) {
            C13981a.m83990w("HttpConnectionHelper", "not to get accessToken because hiDisk did not login");
            return "";
        }
        if (!m26245e(this.f19835d)) {
            C13981a.m83987d("HttpConnectionHelper", "current event needn't to get accessToken");
            return "";
        }
        try {
            this.f19836e = C13195l.m79272J().m79344y("PhoneFinder", "");
        } catch (Exception e10) {
            C13981a.m83988e("HttpConnectionHelper", "getAccessToken exception:" + e10.getMessage());
        }
        return this.f19836e;
    }

    /* renamed from: c */
    public String m26243c(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    @Override // com.huawei.hicloud.request.okhttp.callback.AbstractC4993b
    public AbstractC11920f0 create() {
        return AbstractC11920f0.create(C11910a0.m71445d("application/json; charset=utf-8"), this.f19833b.getBytes(StandardCharsets.UTF_8));
    }

    /* renamed from: d */
    public final String m26244d() {
        if (TextUtils.isEmpty(C11877j.m71275j(this.f19834c))) {
            return AbstractC12139d.m72766e(this.f19834c).getSiteID();
        }
        String strM71278k = C11877j.m71278k(this.f19834c);
        C13981a.m83989i("HttpConnectionHelper", "active lock domain is not empty, site:" + strM71278k);
        return strM71278k;
    }

    /* renamed from: e */
    public final boolean m26245e(int i10) {
        return i10 == 3003 || i10 == 3083 || i10 == 3081 || i10 == 3085 || i10 == 3086 || i10 == 3087 || i10 == 3088 || i10 == 3089 || i10 == 3090 || i10 == 3091 || i10 == 3093 || i10 == 3094 || i10 == 3092 || i10 == 3095 || i10 == 3096 || i10 == 3097 || i10 == 3098 || i10 == 3099 || i10 == 3104 || i10 == 3109;
    }

    /* renamed from: f */
    public final void m26246f(String str, String str2) {
        C12515a.m75110o().m75175e(new a(str, str2), false);
    }

    /* renamed from: g */
    public final void m26247g(C11918e0.a aVar, String str, String str2) {
        if (aVar == null || str == null) {
            return;
        }
        try {
            aVar.m71574a(str, str2);
        } catch (Exception e10) {
            String str3 = "http builder set head exception:" + e10.toString();
            C13981a.m83988e("HttpConnectionHelper", str3);
            m26246f(str3, "http header exception");
        }
    }

    /* renamed from: h */
    public String m26248h(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Charset charset = StandardCharsets.UTF_8;
            return URLEncoder.encode(new String(str.getBytes(charset), charset), Constants.UTF_8);
        } catch (Exception e10) {
            C13981a.m83988e("HttpConnectionHelper", "toUrlEncoded exception:" + e10.getMessage());
            return "";
        }
    }

    @Override // com.huawei.hicloud.request.okhttp.request.AbstractC4994a, com.huawei.hicloud.request.okhttp.callback.AbstractC4992a
    public void prepare(C11918e0.a aVar) {
        AccountInfo accountInfoM72766e = AbstractC12139d.m72766e(this.f19834c);
        String deviceID = TextUtils.isEmpty(this.f19837f) ? accountInfoM72766e.getDeviceID() : this.f19837f;
        if (TextUtils.isEmpty(deviceID) && C13452e.m80781L().m80842P0()) {
            deviceID = C13452e.m80781L().m80950o();
        }
        String str = "";
        if (!TextUtils.isEmpty(deviceID) && !C11870c.m71156d(deviceID)) {
            C13981a.m83988e("HttpConnectionHelper", "deviceId is not utf8");
            m26246f("deviceId is not utf8", "http deviceId unValid");
            deviceID = "";
        }
        String deviceType = TextUtils.isEmpty(this.f19838g) ? accountInfoM72766e.getDeviceType() : this.f19838g;
        String strM80958q = C13452e.m80781L().m80958q();
        if (!TextUtils.isEmpty(strM80958q)) {
            deviceType = "11";
            deviceID = strM80958q;
        }
        String str2 = m26243c(deviceType) + ":" + m26243c(deviceID) + ":com.huawei.hidisk:" + C11870c.m71155c(accountInfoM72766e.getServiceToken()) + ":" + m26248h(m26242b()) + ":" + C11870c.m71154b(accountInfoM72766e.getDeviceTicket(), this.f19835d);
        try {
            Charset charset = StandardCharsets.UTF_8;
            str = new String(C11475a.m68618a(str2.getBytes(charset)), charset);
        } catch (Exception unused) {
            C13981a.m83988e("HttpConnectionHelper", "utf-8 is not supported");
        }
        if (this.f19839h) {
            C13981a.m83990w("HttpConnectionHelper", "local data is empty,not report authorization");
        } else {
            m26247g(aVar, FeedbackWebConstants.AUTHORIZATION, str);
        }
        m26247g(aVar, JsbMapKeyNames.H5_USER_ID, m26243c(accountInfoM72766e.getUserID()));
        m26247g(aVar, "version", C1443a.f6213a);
        m26247g(aVar, "x-hw-terminal", Build.MODEL);
        m26247g(aVar, "x-hw-os", C4347e.m26236g());
        if (!TextUtils.isEmpty(this.f19832a)) {
            m26247g(aVar, "x-hw-trace-id", this.f19832a);
        }
        m26247g(aVar, "SiteId", TextUtils.isEmpty(this.f19840i) ? m26243c(m26244d()) : this.f19840i);
        m26247g(aVar, "x-hw-user-region", m26243c(accountInfoM72766e.getCountryCode()));
        m26247g(aVar, "Accept-Language", C0234s.m1627e());
        m26247g(aVar, "x-hw-auth-version", "2");
        m26247g(aVar, "x-hw-device-category", C11842p.m70762R0() ? "pad" : "phone");
        m26247g(aVar, "x-hw-device-type", m26243c(deviceType));
        m26247g(aVar, "x-hw-device-id", m26243c(deviceID));
        m26247g(aVar, "x-hw-deviceUUID", m26243c(C0228m0.m1597b().m1599c()));
        m26247g(aVar, "x-hw-os-brand", C0209d.m1276l0());
        m26247g(aVar, "x-hw-client-mode", RequestModeConfig.getInstance().getMode(Integer.valueOf(this.f19835d)));
        m26247g(aVar, "x-hw-framework-type", "0");
        if (this.f19841j) {
            m26247g(aVar, "x-hw-credentials-passively", String.valueOf(true));
        }
        C14306d.m85213n(aVar);
    }

    public C4348f(Context context, String str, String str2, String str3, int i10, String str4, String str5, boolean z10, String str6) {
        this(context, str, str2, str3, i10, str4, str5, z10, str6, false);
    }

    public C4348f(Context context, String str, String str2, String str3, int i10, String str4, String str5, boolean z10, String str6, boolean z11) {
        super(str, str2, "POST");
        this.f19834c = context;
        this.f19832a = str2;
        this.f19833b = str3;
        this.f19835d = i10;
        this.f19837f = str4;
        this.f19838g = str5;
        this.f19839h = z10;
        this.f19840i = str6;
        this.f19841j = z11;
    }
}
