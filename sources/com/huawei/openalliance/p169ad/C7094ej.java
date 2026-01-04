package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.UrlConstant;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.ej */
/* loaded from: classes8.dex */
public class C7094ej {

    /* renamed from: a */
    private static C7094ej f32674a;

    /* renamed from: b */
    private static final byte[] f32675b = new byte[0];

    /* renamed from: c */
    private Map<String, String> f32676c = new HashMap();

    /* renamed from: d */
    private Map<String, String> f32677d = new HashMap();

    /* renamed from: e */
    private Context f32678e;

    private C7094ej(Context context) {
        this.f32678e = context.getApplicationContext();
        m42929a();
        m42930b();
    }

    /* renamed from: a */
    public static C7094ej m42928a(Context context) {
        C7094ej c7094ej;
        synchronized (f32675b) {
            try {
                if (f32674a == null) {
                    f32674a = new C7094ej(context);
                }
                c7094ej = f32674a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7094ej;
    }

    /* renamed from: b */
    public String m42932b(String str) {
        return TextUtils.isEmpty(this.f32677d.get(str)) ? "" : this.f32677d.get(str);
    }

    /* renamed from: b */
    private void m42930b() {
        this.f32677d.put("adxServer", Constants.ACD_REQ_URI);
        this.f32677d.put("analyticsServer", Constants.ANALYSIS_CONTENT_SERVER_REQ_URI);
        this.f32677d.put("eventServer", Constants.CONTENT_SERVER_REQ_URI);
        this.f32677d.put("configServer", Constants.SDK_SERVER_REQ_URI);
        this.f32677d.put("permissionServer", Constants.PERMISSION_SERVER_REQ_URI);
        this.f32677d.put("appDataServer", Constants.SDK_APP_DATA_REPORT_SERVER_URI);
        this.f32677d.put("consentConfigServer", Constants.KIT_CONSENT_CONFIG_URI);
        this.f32677d.put("appInsListConfigServer", Constants.APP_INS_LIST_CONFIG_SERVER_URI);
        this.f32677d.put(UrlConstant.BASE_COMPLAIN_H5_URL, "?lang=");
    }

    /* renamed from: a */
    public String m42931a(String str) {
        return this.f32676c.get(str) + AbstractC7806cz.m48149a(this.f32678e);
    }

    /* renamed from: a */
    private void m42929a() {
        this.f32676c.put("adxServer", UrlConstant.BASE_ADX_SERVER);
        this.f32676c.put("analyticsServer", UrlConstant.BASE_EVENT_SERVER);
        this.f32676c.put("eventServer", UrlConstant.BASE_EVENT_SERVER);
        this.f32676c.put("configServer", UrlConstant.BASE_SDK_SERVER);
        this.f32676c.put("permissionServer", UrlConstant.BASE_ADX_SERVER);
        this.f32676c.put("appDataServer", UrlConstant.BASE_EVENT_SERVER);
        this.f32676c.put("consentConfigServer", UrlConstant.BASE_SDK_SERVER);
        this.f32676c.put("appInsListConfigServer", UrlConstant.BASE_SDK_SERVER);
        this.f32676c.put(UrlConstant.BASE_COMPLAIN_H5_URL, "complainH5ServerBaseUrl");
    }
}
