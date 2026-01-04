package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class PresentAuthReq extends Request {
    private String packageId;
    private String receiverAccount;

    public PresentAuthReq(String str, String str2, String str3) {
        super(str);
        this.receiverAccount = str2;
        this.packageId = str3;
    }

    public String getPackageId() {
        return this.packageId;
    }

    public String getReceiverAccount() {
        return this.receiverAccount;
    }

    public void setPackageId(String str) {
        this.packageId = str;
    }

    public void setReceiverAccount(String str) {
        this.receiverAccount = str;
    }
}
