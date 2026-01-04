package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class CardGiftReq extends Request {
    private String imei;

    public CardGiftReq(String str, String str2) {
        super(str);
        this.imei = str2;
    }

    public String getImei() {
        return this.imei;
    }

    public void setImei(String str) {
        this.imei = str;
    }
}
