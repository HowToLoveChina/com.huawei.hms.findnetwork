package com.huawei.hicloud.base.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes6.dex */
public class FamilyDetailInfoRetBody {

    @SerializedName("quota.summary")
    public QuotaInfo mQuotaInfo;

    @SerializedName("family.details")
    public List<FamilyDetailInfo> mUsedSpaceInfoList;

    public QuotaInfo getQuotaInfo() {
        return this.mQuotaInfo;
    }

    public List<FamilyDetailInfo> getUsedSpaceInfoList() {
        return this.mUsedSpaceInfoList;
    }

    public void setQuotaInfo(QuotaInfo quotaInfo) {
        this.mQuotaInfo = quotaInfo;
    }

    public void setUsedSpaceInfoList(List<FamilyDetailInfo> list) {
        this.mUsedSpaceInfoList = list;
    }
}
