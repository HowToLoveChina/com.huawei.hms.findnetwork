package com.huawei.cloud.pay.model;

import com.google.gson.Gson;

/* loaded from: classes5.dex */
public class Filter {
    private String packageId;
    private String productId;
    private String promType;
    private int showPlace;

    public String getPackageId() {
        return this.packageId;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getPromType() {
        return this.promType;
    }

    public int getShowPlace() {
        return this.showPlace;
    }

    public void setPackageId(String str) {
        this.packageId = str;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setPromType(String str) {
        this.promType = str;
    }

    public void setShowPlace(int i10) {
        this.showPlace = i10;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
