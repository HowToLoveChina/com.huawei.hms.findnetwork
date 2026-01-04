package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class GetDegradePackageReq extends Request {
    private String clientVer;

    public GetDegradePackageReq(String str) {
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
