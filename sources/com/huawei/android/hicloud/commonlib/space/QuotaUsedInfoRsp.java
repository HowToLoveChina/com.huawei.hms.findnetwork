package com.huawei.android.hicloud.commonlib.space;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes3.dex */
public class QuotaUsedInfoRsp {

    @SerializedName("quotaDetails")
    private QuotaDetail[] quotaDetails;
    private int retCode;
    private String retDesc;
    private long used;

    public QuotaDetail[] getQuotaDetails() {
        QuotaDetail[] quotaDetailArr = this.quotaDetails;
        return quotaDetailArr != null ? (QuotaDetail[]) quotaDetailArr.clone() : new QuotaDetail[0];
    }

    public int getRetCode() {
        return this.retCode;
    }

    public String getRetDesc() {
        return this.retDesc;
    }

    public long getUsed() {
        return this.used;
    }

    public void setQuotaDetails(QuotaDetail[] quotaDetailArr) {
        if (quotaDetailArr != null) {
            this.quotaDetails = (QuotaDetail[]) quotaDetailArr.clone();
        } else {
            this.quotaDetails = null;
        }
    }

    public void setRetCode(int i10) {
        this.retCode = i10;
    }

    public void setRetDesc(String str) {
        this.retDesc = str;
    }

    public void setUsed(long j10) {
        this.used = j10;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
