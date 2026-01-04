package com.huawei.hms.support.api.account;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class AccountGetTokenOptions {

    /* renamed from: a */
    private String f29773a;

    /* renamed from: b */
    private boolean f29774b;

    public AccountGetTokenOptions(String str, boolean z10) {
        this.f29773a = str;
        this.f29774b = z10;
    }

    public static AccountGetTokenOptions fromJsonObject(JSONObject jSONObject) throws JSONException {
        return new AccountGetTokenOptions(jSONObject.optString("accountName"), jSONObject.optBoolean("fromGetToken", false));
    }

    public String getAccountName() {
        return this.f29773a;
    }

    public boolean isFromGetToken() {
        return this.f29774b;
    }

    public void setAccountName(String str) {
        this.f29773a = str;
    }

    public void setFromGetToken(boolean z10) {
        this.f29774b = z10;
    }

    public JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.f29773a)) {
            jSONObject.put("accountName", this.f29773a);
        }
        jSONObject.put("fromGetToken", this.f29774b);
        return jSONObject;
    }
}
