package com.huawei.hicloud.request.agreement.request;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class ConsentRecordWithStatus {

    @SerializedName("consentType")
    private int consentType;

    @SerializedName("consentVersionMatched")
    private long consentVersionMatched;

    @SerializedName("latestSignRecord")
    private ConsentRecord latestSignRecord;

    @SerializedName("needSign")
    private boolean needSign;

    @SerializedName("region")
    private String region;

    @SerializedName("regionGroup")
    private String regionGroup;

    public int getConsentType() {
        return this.consentType;
    }

    public long getConsentVersionMatched() {
        return this.consentVersionMatched;
    }

    public ConsentRecord getLatestSignRecord() {
        return this.latestSignRecord;
    }

    public String getRegion() {
        return this.region;
    }

    public String getRegionGroup() {
        return this.regionGroup;
    }

    public boolean isNeedSign() {
        return this.needSign;
    }

    public void setConsentType(int i10) {
        this.consentType = i10;
    }

    public void setConsentVersionMatched(long j10) {
        this.consentVersionMatched = j10;
    }

    public void setLatestSignRecord(ConsentRecord consentRecord) {
        this.latestSignRecord = consentRecord;
    }

    public void setNeedSign(boolean z10) {
        this.needSign = z10;
    }

    public void setRegion(String str) {
        this.region = str;
    }

    public void setRegionGroup(String str) {
        this.regionGroup = str;
    }
}
