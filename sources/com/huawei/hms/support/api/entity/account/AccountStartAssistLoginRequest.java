package com.huawei.hms.support.api.entity.account;

import com.huawei.hms.support.feature.result.CommonConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class AccountStartAssistLoginRequest {

    /* renamed from: a */
    private String f29779a;

    public AccountStartAssistLoginRequest() {
    }

    public static AccountStartAssistLoginRequest fromJson(String str) throws JSONException {
        if (str == null) {
            return null;
        }
        return new AccountStartAssistLoginRequest().objectFromJson(new JSONObject(str));
    }

    public AccountStartAssistLoginRequest objectFromJson(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            this.f29779a = jSONObject.getString(CommonConstant.KEY_ASSIST_TOKEN);
        }
        return this;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String str = this.f29779a;
        if (str != null) {
            jSONObject.put(CommonConstant.KEY_ASSIST_TOKEN, str);
        }
        return jSONObject.toString();
    }

    public AccountStartAssistLoginRequest(String str) {
        this.f29779a = str;
    }
}
