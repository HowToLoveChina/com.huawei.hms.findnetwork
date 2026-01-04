package com.huawei.android.hicloud.commonlib.space;

/* loaded from: classes3.dex */
public class QuotaInfoRsp {
    private FullQuotaInfo retBody;
    private int retCode;
    private String retDesc;

    public FullQuotaInfo getRetBody() {
        return this.retBody;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public String getRetDesc() {
        return this.retDesc;
    }

    public void setRetBody(FullQuotaInfo fullQuotaInfo) {
        this.retBody = fullQuotaInfo;
    }

    public void setRetCode(int i10) {
        this.retCode = i10;
    }

    public void setRetDesc(String str) {
        this.retDesc = str;
    }
}
