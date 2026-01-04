package com.huawei.hms.iap.entity;

import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.List;

/* loaded from: classes8.dex */
public class ProductInfoReq extends BaseReq {

    @Packed
    private int priceType;

    @Packed
    private List<String> skuIds;

    public int getPriceType() {
        return this.priceType;
    }

    public List<String> getProductIds() {
        return this.skuIds;
    }

    public void setPriceType(int i10) {
        this.priceType = i10;
    }

    public void setProductIds(List<String> list) {
        this.skuIds = list;
    }
}
