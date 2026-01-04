package com.huawei.hicloud.request.agreement.request;

/* loaded from: classes6.dex */
public class ConsentQueryInformation {
    private int consentType;
    private String region;

    public ConsentQueryInformation(int i10, String str) {
        this.consentType = i10;
        this.region = str;
    }

    public int getConsentType() {
        return this.consentType;
    }

    public String getRegion() {
        return this.region;
    }

    public void setConsentType(int i10) {
        this.consentType = i10;
    }

    public void setRegion(String str) {
        this.region = str;
    }
}
