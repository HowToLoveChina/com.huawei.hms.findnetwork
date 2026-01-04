package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class CardPackageReq extends Request {
    private String cardNo;
    private String version;

    public CardPackageReq(String str, String str2) {
        super("getCardPackages");
        this.cardNo = str;
        this.version = str2;
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCardNo(String str) {
        this.cardNo = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
