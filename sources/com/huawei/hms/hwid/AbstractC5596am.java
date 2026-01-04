package com.huawei.hms.hwid;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.hwid.am */
/* loaded from: classes8.dex */
public abstract class AbstractC5596am {

    /* renamed from: a */
    protected String f25344a;

    /* renamed from: b */
    protected String f25345b;

    /* renamed from: c */
    protected long f25346c;

    /* renamed from: d */
    protected String f25347d;

    /* renamed from: a */
    public String m32880a() {
        return this.f25344a;
    }

    /* renamed from: b */
    public void m32883b(String str) {
        this.f25344a = str;
    }

    /* renamed from: c */
    public void m32885c(String str) {
        this.f25345b = str;
    }

    /* renamed from: d */
    public void m32887d(String str) {
        this.f25347d = str;
    }

    /* renamed from: e */
    public JSONObject m32888e() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("appId", this.f25344a);
        jSONObject.putOpt("packageName", this.f25345b);
        jSONObject.put("hmsSdkVersion", this.f25346c);
        jSONObject.putOpt("subAppId", this.f25347d);
        return jSONObject;
    }

    public String toString() {
        return "HuaweiIdCpClientInfo{appId='" + this.f25344a + "', packageName='" + this.f25345b + "', hmsSdkVersion=" + this.f25346c + "', subAppId=" + this.f25347d + '}';
    }

    /* renamed from: a */
    public void m32881a(long j10) {
        this.f25346c = j10;
    }

    /* renamed from: b */
    public long m32882b() {
        return this.f25346c;
    }

    /* renamed from: c */
    public String m32884c() {
        return this.f25347d;
    }

    /* renamed from: d */
    public String m32886d() throws JSONException {
        return m32888e().toString();
    }
}
