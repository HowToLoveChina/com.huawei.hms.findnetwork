package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class GetAvailablePackagesReq extends Request {
    private String clientVer;

    public GetAvailablePackagesReq(String str) {
        super(str);
        this.clientVer = "3";
    }

    public String getClientVer() {
        return this.clientVer;
    }

    public void setClientVer(String str) {
        this.clientVer = str;
    }
}
