package com.huawei.hms.support.hwid.bean;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class SignInByQrReq {
    public static final String KEY_QR_CODE = "qrCode";
    public static final String KEY_QR_SITE_ID = "qrSiteId";
    private String qrCode;
    private String qrSiteId;

    public SignInByQrReq() {
    }

    public String getQrCode() {
        return this.qrCode;
    }

    public String getQrSiteId() {
        return this.qrSiteId;
    }

    public void setQrCode(String str) {
        this.qrCode = str;
    }

    public void setQrSiteId(String str) {
        this.qrSiteId = str;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("qrCode", this.qrCode);
        jSONObject.put("qrSiteId", this.qrSiteId);
        return jSONObject;
    }

    public SignInByQrReq(String str, String str2) {
        this.qrCode = str;
        this.qrSiteId = str2;
    }
}
