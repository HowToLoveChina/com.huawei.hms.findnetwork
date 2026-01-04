package com.huawei.hms.support.api.entity.account;

import android.text.TextUtils;
import com.huawei.hms.support.feature.result.CommonConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class GetAssistTokenRequest {

    /* renamed from: a */
    private String f29780a;

    /* renamed from: b */
    private String f29781b;

    /* renamed from: c */
    private String f29782c;

    public GetAssistTokenRequest(String str) {
        this.f29780a = str;
    }

    public String getSessionId() {
        return this.f29782c;
    }

    public String getUserIdentify() {
        return this.f29781b;
    }

    public void setSessionId(String str) {
        this.f29782c = str;
    }

    public void setUserIdentify(String str) {
        this.f29781b = str;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.f29780a)) {
            jSONObject.putOpt("accessToken", this.f29780a);
        }
        if (!TextUtils.isEmpty(this.f29781b)) {
            jSONObject.putOpt(CommonConstant.KEY_USER_IDENTIFY, this.f29781b);
        }
        if (!TextUtils.isEmpty(this.f29782c)) {
            jSONObject.putOpt("sessionId", this.f29782c);
        }
        return jSONObject.toString();
    }
}
