package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.List;

/* loaded from: classes8.dex */
public class PurchaseInfoResp extends AbstractMessageEntity {

    @Packed
    private long pageCount;

    @Packed
    private List<PurchaseInfo> purchaseInfoList;

    @Packed
    private String rtnCode;

    @Packed
    private String sign;

    public long getPageCount() {
        return this.pageCount;
    }

    public List<PurchaseInfo> getPurchaseInfoList() {
        return this.purchaseInfoList;
    }

    public String getRtnCode() {
        return this.rtnCode;
    }

    public String getSign() {
        return this.sign;
    }

    public void setPageCount(long j10) {
        this.pageCount = j10;
    }

    public void setPurchaseInfoList(List<PurchaseInfo> list) {
        this.purchaseInfoList = list;
    }

    public void setRtnCode(String str) {
        this.rtnCode = str;
    }

    public void setSign(String str) {
        this.sign = str;
    }
}
