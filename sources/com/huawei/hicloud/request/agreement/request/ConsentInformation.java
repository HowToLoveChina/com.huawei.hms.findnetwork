package com.huawei.hicloud.request.agreement.request;

/* loaded from: classes6.dex */
public class ConsentInformation {
    private long clientSignTime;
    private int consentType;
    private boolean inheritSub;
    private boolean isAgree;
    private String language;
    private String region;
    private String subConsent;

    public ConsentInformation(int i10, String str, String str2, boolean z10, String str3, long j10, boolean z11) {
        this.consentType = i10;
        this.region = str;
        this.language = str2;
        this.isAgree = z10;
        this.subConsent = str3;
        this.clientSignTime = j10;
        this.inheritSub = z11;
    }

    public long getClientSignTime() {
        return this.clientSignTime;
    }

    public int getConsentType() {
        return this.consentType;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getRegion() {
        return this.region;
    }

    public String getSubConsent() {
        return this.subConsent;
    }

    public boolean isAgree() {
        return this.isAgree;
    }

    public boolean isInheritSub() {
        return this.inheritSub;
    }

    public void setAgree(boolean z10) {
        this.isAgree = z10;
    }

    public void setClientSignTime(long j10) {
        this.clientSignTime = j10;
    }

    public void setConsentType(int i10) {
        this.consentType = i10;
    }

    public void setInheritSub(boolean z10) {
        this.inheritSub = z10;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setRegion(String str) {
        this.region = str;
    }

    public void setSubConsent(String str) {
        this.subConsent = str;
    }
}
