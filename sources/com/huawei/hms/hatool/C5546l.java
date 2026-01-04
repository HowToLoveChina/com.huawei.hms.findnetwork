package com.huawei.hms.hatool;

import com.huawei.openalliance.p169ad.constant.IntervalMethods;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hatool.l */
/* loaded from: classes8.dex */
public class C5546l extends AbstractC5567t {

    /* renamed from: b */
    private String f25238b = "";

    /* renamed from: c */
    private String f25239c = "";

    /* renamed from: d */
    private String f25240d = "";

    /* renamed from: e */
    private String f25241e = "";

    /* renamed from: f */
    protected String f25242f = "";

    /* renamed from: g */
    private String f25243g;

    @Override // com.huawei.hms.hatool.InterfaceC5557o1
    /* renamed from: a */
    public JSONObject mo32451a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("androidid", this.f25307a);
        jSONObject.put("oaid", this.f25243g);
        jSONObject.put("uuid", this.f25242f);
        jSONObject.put("upid", this.f25241e);
        jSONObject.put("imei", this.f25238b);
        jSONObject.put("sn", this.f25239c);
        jSONObject.put(IntervalMethods.REQ_UDID, this.f25240d);
        return jSONObject;
    }

    /* renamed from: b */
    public void m32614b(String str) {
        this.f25238b = str;
    }

    /* renamed from: c */
    public void m32615c(String str) {
        this.f25243g = str;
    }

    /* renamed from: d */
    public void m32616d(String str) {
        this.f25239c = str;
    }

    /* renamed from: e */
    public void m32617e(String str) {
        this.f25240d = str;
    }

    /* renamed from: f */
    public void m32618f(String str) {
        this.f25241e = str;
    }

    /* renamed from: g */
    public void m32619g(String str) {
        this.f25242f = str;
    }
}
