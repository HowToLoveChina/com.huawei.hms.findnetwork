package com.huawei.hms.support.hwid.result;

import com.huawei.hms.support.hwid.common.constants.CommonConstant;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class SignInQrInfo {
    private String qrCode;
    private String qrContent;
    private String qrSessionId;
    private String qrSiteId;

    public static SignInQrInfo fromJson(JSONObject jSONObject) {
        SignInQrInfo signInQrInfo = new SignInQrInfo();
        signInQrInfo.setQrCode(jSONObject.optString("qrCode"));
        signInQrInfo.setQrSiteId(jSONObject.optString("qrSiteId"));
        signInQrInfo.setQrContent(jSONObject.optString(CommonConstant.KEY_QR_CONTENT));
        signInQrInfo.setQrSessionId(jSONObject.optString(CommonConstant.KEY_QR_SESSION_ID));
        return signInQrInfo;
    }

    public String getQrCode() {
        return this.qrCode;
    }

    public String getQrContent() {
        return this.qrContent;
    }

    public String getQrSessionId() {
        return this.qrSessionId;
    }

    public String getQrSiteId() {
        return this.qrSiteId;
    }

    public void setQrCode(String str) {
        this.qrCode = str;
    }

    public void setQrContent(String str) {
        this.qrContent = str;
    }

    public void setQrSessionId(String str) {
        this.qrSessionId = str;
    }

    public void setQrSiteId(String str) {
        this.qrSiteId = str;
    }
}
