package com.huawei.hicloud.request.basic.bean;

/* loaded from: classes6.dex */
public class BasicModuleConfigReq extends BasicBaseReq {
    private String clientCap;
    private String country;
    private String newUser;

    public BasicModuleConfigReq(String str) {
        super(str);
        this.newUser = "1";
    }

    public String getClientCap() {
        return this.clientCap;
    }

    public String getCountry() {
        return this.country;
    }

    public void setClientCap(String str) {
        this.clientCap = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }
}
