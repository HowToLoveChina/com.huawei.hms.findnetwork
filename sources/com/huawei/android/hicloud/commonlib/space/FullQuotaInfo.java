package com.huawei.android.hicloud.commonlib.space;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.base.bean.QuotaInfo;
import java.util.List;

/* loaded from: classes3.dex */
public class FullQuotaInfo {

    @SerializedName("package.total.limit")
    private long maxPackageSize;

    @SerializedName("package.limit")
    private long oldMaxPackageSize;

    @SerializedName("quota.summary")
    private QuotaInfo quotaInfo;

    @SerializedName("quota.detailtype")
    private String retType;

    @SerializedName("quota.detaillist")
    private List<UsedSpaceInfo> usedInfos;

    public long getMaxPackageSize() {
        return this.maxPackageSize;
    }

    public long getOldMaxPackageSize() {
        return this.oldMaxPackageSize;
    }

    public QuotaInfo getQuotaInfo() {
        return this.quotaInfo;
    }

    public String getRetType() {
        return this.retType;
    }

    public List<UsedSpaceInfo> getUsedInfos() {
        return this.usedInfos;
    }

    public void setMaxPackageSize(long j10) {
        this.maxPackageSize = j10;
    }

    public void setOldMaxPackageSize(long j10) {
        this.oldMaxPackageSize = j10;
    }

    public void setQuotaInfo(QuotaInfo quotaInfo) {
        this.quotaInfo = quotaInfo;
    }

    public void setRetType(String str) {
        this.retType = str;
    }

    public void setUsedInfos(List<UsedSpaceInfo> list) {
        this.usedInfos = list;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
