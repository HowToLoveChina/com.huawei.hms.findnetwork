package com.huawei.hicloud.request.agreement.request;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* loaded from: classes6.dex */
public class ConsentRecord {

    @SerializedName("clientSignTime")
    private long clientSignTime;

    @SerializedName("clientVersion")
    private String clientVersion;

    @SerializedName("consentVersion")
    private long consentVersion;

    @SerializedName("isAgree")
    private boolean isAgree;

    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private String language;

    @SerializedName("region")
    private String region;

    @SerializedName("signTime")
    private long signTime;

    @SerializedName("subConsent")
    private String subConsent;

    public long getClientSignTime() {
        return this.clientSignTime;
    }

    public String getClientVersion() {
        return this.clientVersion;
    }

    public long getConsentVersion() {
        return this.consentVersion;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getRegion() {
        return this.region;
    }

    public long getSignTime() {
        return this.signTime;
    }

    public String getSubConsent() {
        return this.subConsent;
    }

    public boolean isAgree() {
        return this.isAgree;
    }

    public void setAgree(boolean z10) {
        this.isAgree = z10;
    }

    public void setClientSignTime(long j10) {
        this.clientSignTime = j10;
    }

    public void setClientVersion(String str) {
        this.clientVersion = str;
    }

    public void setConsentVersion(long j10) {
        this.consentVersion = j10;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setRegion(String str) {
        this.region = str;
    }

    public void setSignTime(long j10) {
        this.signTime = j10;
    }

    public void setSubConsent(String str) {
        this.subConsent = str;
    }
}
