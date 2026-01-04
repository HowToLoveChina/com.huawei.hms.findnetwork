package com.huawei.hms.support.api.entity.tss;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.tss.base.BaseRequ;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.openalliance.p169ad.constant.IntervalMethods;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class SysIntegrityRequ extends BaseRequ {
    private static final String TAG = "SysIntegrityRequ";

    @Packed
    private String advice;

    @Packed
    private String alg;

    @Packed
    private String[] apkCertificateDigestSha256;

    @Packed
    private String apkDigestSha256;

    @Packed
    private String checkResult;

    @Packed
    private String nonce;

    @Packed
    private String packageName;

    @Packed
    private String reason;

    @Packed
    private int securityDiagnose = -1;

    @Packed
    private String udid;

    public String getAdvice() {
        return this.advice;
    }

    public String getAlg() {
        return this.alg;
    }

    public String[] getApkCertificateDigestSha256() {
        String[] strArr = this.apkCertificateDigestSha256;
        return strArr != null ? (String[]) strArr.clone() : new String[0];
    }

    public String getApkDigestSha256() {
        return this.apkDigestSha256;
    }

    public String getCheckResult() {
        return this.checkResult;
    }

    public String getNonce() {
        return this.nonce;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getReason() {
        return this.reason;
    }

    public int getSecurityDiagnose() {
        return this.securityDiagnose;
    }

    public String getUdid() {
        return this.udid;
    }

    public void setAdvice(String str) {
        this.advice = str;
    }

    public void setAlg(String str) {
        this.alg = str;
    }

    public void setApkCertificateDigestSha256(String[] strArr) {
        if (strArr != null) {
            this.apkCertificateDigestSha256 = (String[]) strArr.clone();
        } else {
            this.apkCertificateDigestSha256 = new String[0];
        }
    }

    public void setApkDigestSha256(String str) {
        this.apkDigestSha256 = str;
    }

    public void setCheckResult(String str) {
        this.checkResult = str;
    }

    public void setNonce(String str) {
        this.nonce = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setSecurityDiagnose(int i10) {
        this.securityDiagnose = i10;
    }

    public void setUdid(String str) {
        this.udid = str;
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("nonce", this.nonce);
            jSONObject.put("packageName", this.packageName);
            jSONObject.put("apkDigestSha256", this.apkDigestSha256);
            JSONArray jSONArray = new JSONArray();
            if (this.apkCertificateDigestSha256 != null) {
                int i10 = 0;
                while (true) {
                    String[] strArr = this.apkCertificateDigestSha256;
                    if (i10 >= strArr.length) {
                        break;
                    }
                    jSONArray.put(strArr[i10]);
                    i10++;
                }
            }
            jSONObject.put("apkCertificateDigestSha256", jSONArray);
            jSONObject.put("securityDiagnose", this.securityDiagnose);
            jSONObject.put("advice", this.advice);
            jSONObject.put("reason", this.reason);
            jSONObject.put("checkResult", this.checkResult);
            jSONObject.put(IntervalMethods.REQ_UDID, this.udid);
            jSONObject.put("alg", this.alg);
        } catch (JSONException unused) {
            HMSLog.m36986e(TAG, "toJson failed");
        }
        return jSONObject.toString();
    }
}
