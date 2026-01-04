package com.huawei.hms.videokit.player;

import android.content.Context;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.videokit.player.t */
/* loaded from: classes8.dex */
public final class C6599t {

    /* renamed from: a */
    private String f30673a = "";

    /* renamed from: b */
    private String f30674b = null;

    /* renamed from: c */
    private long f30675c = 0;

    /* renamed from: d */
    private long f30676d = 0;

    /* renamed from: e */
    private C6591o0 f30677e = new C6591o0();

    /* renamed from: a */
    public int m37651a() {
        return this.f30677e.m37579a();
    }

    /* renamed from: b */
    public String m37653b() {
        return this.f30673a;
    }

    /* renamed from: c */
    public int m37654c() {
        return this.f30677e.m37582b();
    }

    /* renamed from: d */
    public String m37655d() {
        return this.f30677e.m37583c();
    }

    /* renamed from: e */
    public String m37656e() {
        return this.f30677e.m37584d();
    }

    /* renamed from: f */
    public long m37657f() {
        return this.f30677e.m37585e();
    }

    /* renamed from: g */
    public long m37658g() {
        return this.f30676d;
    }

    /* renamed from: h */
    public long m37659h() {
        return this.f30675c;
    }

    /* renamed from: i */
    public String m37660i() {
        return this.f30677e.m37586f();
    }

    /* renamed from: j */
    public long m37661j() {
        return this.f30677e.m37588i();
    }

    /* renamed from: k */
    public int m37662k() {
        return this.f30677e.m37589j();
    }

    /* renamed from: l */
    public String m37663l() {
        return this.f30674b;
    }

    /* renamed from: b */
    private Map<String, String> m37650b(String str) {
        String strM37648a = m37648a(str);
        HashMap map = new HashMap();
        map.put("deviceId", C6580j.m37442b());
        map.put("terminalType", C6600t0.m37692i());
        map.put("packageName", "com.huawei.hms.videokit.player");
        map.put("ts", System.currentTimeMillis() + "");
        map.put("data", strM37648a);
        return map;
    }

    /* renamed from: a */
    public C6560h m37652a(Context context, String str, String str2, int i10, int i11) throws JSONException {
        String str3;
        C6550c1.m37256a("HttpControl", "urlString:" + str);
        try {
            this.f30675c = C6600t0.m37688f();
            this.f30673a = C6597s.m37641a("videoepg");
            this.f30676d = C6600t0.m37688f();
        } catch (JSONException e10) {
            C6550c1.m37258a("HttpControl", "getGrsServiceUrl fail ", e10);
        }
        if (C6600t0.m37683c(this.f30673a)) {
            return new C6560h();
        }
        String strM37640a = C6597s.m37640a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f30673a);
        sb2.append("/playserver/vod/getPlayInfo");
        sb2.append("?appId=");
        sb2.append(str2);
        sb2.append("&ver=");
        sb2.append(String.valueOf(10016300));
        if (C6600t0.m37680b(strM37640a)) {
            str3 = "";
        } else {
            str3 = "&country=" + strM37640a;
        }
        sb2.append(str3);
        String string = sb2.toString();
        C6550c1.m37256a("HttpControl", "country:" + strM37640a);
        JSONObject jSONObjectM37649a = m37649a(str, str2, i10, i11);
        C6550c1.m37256a("HttpControl", "data:" + jSONObjectM37649a.toString());
        this.f30674b = C6598s0.m37645b(context);
        C6550c1.m37256a("HttpControl", "traceId:" + this.f30674b);
        return m37647a(context, m37650b(jSONObjectM37649a.toString()), this.f30673a, string);
    }

    /* renamed from: a */
    private C6560h m37647a(Context context, Map<String, String> map, String str, String str2) {
        return this.f30677e.m37580a(context, map, str, str2, this.f30674b);
    }

    /* renamed from: a */
    public static String m37648a(String str) {
        try {
            return URLEncoder.encode(str, Constants.UTF_8);
        } catch (UnsupportedEncodingException e10) {
            C6550c1.m37265d("HttpControl", " encoder data error " + e10);
            return str;
        }
    }

    /* renamed from: a */
    private JSONObject m37649a(String str, String str2, int i10, int i11) throws JSONException {
        String str3;
        JSONObject jSONObject = new JSONObject();
        String str4 = i11 == 1 ? "2040,2,4040,4,5040" : i11 == 2 ? "2050,4050,5050" : "2040,2,2050,4040,4,4050,5040,5050";
        try {
            jSONObject.put("playParam", str);
            jSONObject.put("protocolType", "1");
            jSONObject.put("scenario", i10 + "");
            jSONObject.put("formatPriority", str4);
        } catch (UnsupportedOperationException e10) {
            e = e10;
            str3 = "UnsupportedOperationException:";
            C6550c1.m37258a("HttpControl", str3, e);
            return jSONObject;
        } catch (JSONException e11) {
            e = e11;
            str3 = "JSONException:";
            C6550c1.m37258a("HttpControl", str3, e);
            return jSONObject;
        }
        return jSONObject;
    }
}
