package com.huawei.hms.iap.entity;

import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class ConsumeOwnedPurchaseReq extends BaseReq {

    @Packed
    private String developerChallenge;

    @Packed
    private String purchaseToken;

    @Packed
    private String signatureAlgorithm;

    public String getDeveloperChallenge() {
        return this.developerChallenge;
    }

    public String getPurchaseToken() {
        return this.purchaseToken;
    }

    public String getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public void setDeveloperChallenge(String str) {
        this.developerChallenge = str;
    }

    public void setPurchaseToken(String str) {
        this.purchaseToken = str;
    }

    public void setSignatureAlgorithm(String str) {
        this.signatureAlgorithm = str;
    }
}
