package com.huawei.hms.support.api.pay;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.entity.pay.ProductDetail;
import com.huawei.hms.support.api.entity.pay.ProductFailObject;
import java.util.List;

/* loaded from: classes8.dex */
public class ProductDetailResult extends Result {
    private List<ProductFailObject> failList;
    private List<ProductDetail> productList;
    private String requestId;

    public List<ProductFailObject> getFailList() {
        return this.failList;
    }

    public List<ProductDetail> getProductList() {
        return this.productList;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setFailList(List<ProductFailObject> list) {
        this.failList = list;
    }

    public void setProductList(List<ProductDetail> list) {
        this.productList = list;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }
}
