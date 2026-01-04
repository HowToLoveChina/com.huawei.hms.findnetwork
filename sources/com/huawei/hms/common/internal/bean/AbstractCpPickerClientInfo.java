package com.huawei.hms.common.internal.bean;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public abstract class AbstractCpPickerClientInfo {

    /* renamed from: a */
    protected String f23520a;

    /* renamed from: b */
    protected String f23521b;

    /* renamed from: c */
    protected long f23522c;

    /* renamed from: d */
    protected String f23523d;

    /* renamed from: a */
    private JSONObject m30700a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("appId", this.f23520a);
        jSONObject.putOpt("packageName", this.f23521b);
        jSONObject.put("hmsSdkVersion", this.f23522c);
        jSONObject.putOpt("subAppId", this.f23523d);
        return jSONObject;
    }

    public String getAppId() {
        return this.f23520a;
    }

    public long getHmsSdkVersion() {
        return this.f23522c;
    }

    public String getPackageName() {
        return this.f23521b;
    }

    public String getSubAppId() {
        return this.f23523d;
    }

    public void setAppId(String str) {
        this.f23520a = str;
    }

    public void setHmsSdkVersion(long j10) {
        this.f23522c = j10;
    }

    public void setPackageName(String str) {
        this.f23521b = str;
    }

    public void setSubAppId(String str) {
        this.f23523d = str;
    }

    public String toJson() throws JSONException {
        return m30700a().toString();
    }

    public String toString() {
        return "CpClientInfo{appId='" + this.f23520a + "', packageName='" + this.f23521b + "', hmsSdkVersion=" + this.f23522c + "', subAppId=" + this.f23523d + '}';
    }
}
