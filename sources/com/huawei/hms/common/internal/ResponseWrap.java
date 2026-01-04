package com.huawei.hms.common.internal;

import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class ResponseWrap {

    /* renamed from: a */
    private String f23510a;

    /* renamed from: b */
    private ResponseHeader f23511b;

    public ResponseWrap(ResponseHeader responseHeader) {
        this.f23511b = responseHeader;
    }

    public boolean fromJson(String str) {
        if (this.f23511b == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f23511b.setStatusCode(JsonUtil.getIntValue(jSONObject, "status_code"));
            this.f23511b.setErrorCode(JsonUtil.getIntValue(jSONObject, "error_code"));
            this.f23511b.setErrorReason(JsonUtil.getStringValue(jSONObject, "error_reason"));
            this.f23511b.setSrvName(JsonUtil.getStringValue(jSONObject, "srv_name"));
            this.f23511b.setApiName(JsonUtil.getStringValue(jSONObject, "api_name"));
            this.f23511b.setAppID(JsonUtil.getStringValue(jSONObject, "app_id"));
            this.f23511b.setPkgName(JsonUtil.getStringValue(jSONObject, "pkg_name"));
            this.f23511b.setSessionId(JsonUtil.getStringValue(jSONObject, "session_id"));
            this.f23511b.setTransactionId(JsonUtil.getStringValue(jSONObject, "transaction_id"));
            this.f23511b.setResolution(JsonUtil.getStringValue(jSONObject, "resolution"));
            this.f23510a = JsonUtil.getStringValue(jSONObject, "body");
            return true;
        } catch (JSONException e10) {
            HMSLog.m36986e("ResponseWrap", "fromJson failed: " + e10.getMessage());
            return false;
        }
    }

    public String getBody() {
        if (TextUtils.isEmpty(this.f23510a)) {
            this.f23510a = new JSONObject().toString();
        }
        return this.f23510a;
    }

    public ResponseHeader getResponseHeader() {
        return this.f23511b;
    }

    public void setBody(String str) {
        this.f23510a = str;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.f23511b = responseHeader;
    }

    public String toJson() throws JSONException {
        if (this.f23511b == null) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status_code", this.f23511b.getStatusCode());
            jSONObject.put("error_code", this.f23511b.getErrorCode());
            jSONObject.put("error_reason", this.f23511b.getErrorReason());
            jSONObject.put("srv_name", this.f23511b.getSrvName());
            jSONObject.put("api_name", this.f23511b.getApiName());
            jSONObject.put("app_id", this.f23511b.getAppID());
            jSONObject.put("pkg_name", this.f23511b.getPkgName());
            jSONObject.put("transaction_id", this.f23511b.getTransactionId());
            jSONObject.put("resolution", this.f23511b.getResolution());
            String sessionId = this.f23511b.getSessionId();
            if (!TextUtils.isEmpty(sessionId)) {
                jSONObject.put("session_id", sessionId);
            }
            if (!TextUtils.isEmpty(this.f23510a)) {
                jSONObject.put("body", this.f23510a);
            }
        } catch (JSONException e10) {
            HMSLog.m36986e("ResponseWrap", "toJson failed: " + e10.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "ResponseWrap{body='" + this.f23510a + "', responseHeader=" + this.f23511b + '}';
    }
}
