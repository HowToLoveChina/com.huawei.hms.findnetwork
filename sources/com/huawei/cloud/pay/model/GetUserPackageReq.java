package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class GetUserPackageReq extends Request {
    private String clientVer;
    private String fields;

    public GetUserPackageReq(String str) {
        super(str);
        this.clientVer = "7";
        this.fields = "lastMemberInfo";
    }

    public String getClientVer() {
        return this.clientVer;
    }

    public String getFields() {
        return this.fields;
    }

    public void setClientVer(String str) {
        this.clientVer = str;
    }

    public void setFields(String str) {
        this.fields = str;
    }

    public GetUserPackageReq(String str, String str2) {
        super(str);
        this.clientVer = "7";
        this.fields = str2;
    }
}
