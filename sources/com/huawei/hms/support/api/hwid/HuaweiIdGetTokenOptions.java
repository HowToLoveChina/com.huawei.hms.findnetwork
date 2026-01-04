package com.huawei.hms.support.api.hwid;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class HuaweiIdGetTokenOptions {

    /* renamed from: a */
    private String f29804a;

    /* renamed from: b */
    private boolean f29805b;

    public HuaweiIdGetTokenOptions(String str, boolean z10) {
        this.f29804a = str;
        this.f29805b = z10;
    }

    public static HuaweiIdGetTokenOptions fromJsonObject(JSONObject jSONObject) throws JSONException {
        return new HuaweiIdGetTokenOptions(jSONObject.optString("accountName"), jSONObject.optBoolean("fromGetToken", false));
    }

    public String getAccountName() {
        return this.f29804a;
    }

    public boolean isFromGetToken() {
        return this.f29805b;
    }

    public void setAccountName(String str) {
        this.f29804a = str;
    }

    public void setFromGetToken(boolean z10) {
        this.f29805b = z10;
    }

    public JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.f29804a)) {
            jSONObject.put("accountName", this.f29804a);
        }
        jSONObject.put("fromGetToken", this.f29805b);
        return jSONObject;
    }
}
