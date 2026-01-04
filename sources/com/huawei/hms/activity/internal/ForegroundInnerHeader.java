package com.huawei.hms.activity.internal;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.openalliance.p169ad.constant.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class ForegroundInnerHeader {

    /* renamed from: a */
    private int f23072a;

    /* renamed from: b */
    private String f23073b;

    /* renamed from: c */
    private String f23074c;

    public void fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f23072a = JsonUtil.getIntValue(jSONObject, "apkVersion");
            this.f23073b = JsonUtil.getStringValue(jSONObject, Constants.CONTENT_SERVER_REALM);
            this.f23074c = JsonUtil.getStringValue(jSONObject, "responseCallbackKey");
        } catch (JSONException e10) {
            HMSLog.m36986e("ForegroundInnerHeader", "fromJson failed: " + e10.getMessage());
        }
    }

    public String getAction() {
        return this.f23073b;
    }

    public int getApkVersion() {
        return this.f23072a;
    }

    public String getResponseCallbackKey() {
        return this.f23074c;
    }

    public void setAction(String str) {
        this.f23073b = str;
    }

    public void setApkVersion(int i10) {
        this.f23072a = i10;
    }

    public void setResponseCallbackKey(String str) {
        this.f23074c = str;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apkVersion", this.f23072a);
            jSONObject.put(Constants.CONTENT_SERVER_REALM, this.f23073b);
            jSONObject.put("responseCallbackKey", this.f23074c);
        } catch (JSONException e10) {
            HMSLog.m36986e("ForegroundInnerHeader", "ForegroundInnerHeader toJson failed: " + e10.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "apkVersion:" + this.f23072a + ", action:" + this.f23073b + ", responseCallbackKey:" + this.f23074c;
    }
}
