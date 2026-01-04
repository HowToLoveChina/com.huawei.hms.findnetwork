package com.huawei.hicloud.request.basic.bean;

/* loaded from: classes6.dex */
public class AgrInfo {
    int agrType;
    String country;

    public AgrInfo(int i10, String str) {
        this.agrType = i10;
        this.country = str;
    }

    public int getAgrType() {
        return this.agrType;
    }

    public String getCountry() {
        return this.country;
    }

    public void setAgrType(int i10) {
        this.agrType = i10;
    }

    public void setCountry(String str) {
        this.country = str;
    }
}
