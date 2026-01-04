package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.tss.base.BaseRequ;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class EnrollCertRequ extends BaseRequ {
    private static final String TAG = "EnrollCertRequ";

    @Packed
    private String accessToken;

    @Packed
    private String algorithm;

    @Packed
    private String alias;

    @Packed
    private String caUrl;

    @Packed
    private String cbgRootCert;

    @Packed
    private String certReqId;

    @Packed
    private String issuer;

    @Packed
    private int keyType;

    @Packed
    private String subject;

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getCaUrl() {
        return this.caUrl;
    }

    public String getCbgRootCert() {
        return this.cbgRootCert;
    }

    public String getCertReqId() {
        return this.certReqId;
    }

    public String getIssuer() {
        return this.issuer;
    }

    public int getKeyType() {
        return this.keyType;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setAlgorithm(String str) {
        this.algorithm = str;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setCaUrl(String str) {
        this.caUrl = str;
    }

    public void setCbgRootCert(String str) {
        this.cbgRootCert = str;
    }

    public void setCertReqId(String str) {
        this.certReqId = str;
    }

    public void setIssuer(String str) {
        this.issuer = str;
    }

    public void setKeyType(int i10) {
        this.keyType = i10;
    }

    public void setSubject(String str) {
        this.subject = str;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("keyType", this.keyType);
            jSONObject.put("alias", this.alias);
            jSONObject.put("algorithm", this.algorithm);
            jSONObject.put("certReqId", this.certReqId);
            jSONObject.put("accessToken", this.accessToken);
            jSONObject.put("issuer", this.issuer);
            jSONObject.put("subject", this.subject);
            jSONObject.put("caUrl", this.caUrl);
            jSONObject.put("cbgRootCert", this.cbgRootCert);
        } catch (JSONException unused) {
            HMSLog.m36986e(TAG, "toJson failed");
        }
        return jSONObject.toString();
    }
}
