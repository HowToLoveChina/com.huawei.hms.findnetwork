package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class GetSignReq extends Request {

    /* renamed from: id */
    private String f21407id;

    public GetSignReq(String str) {
        super("getSignInfo");
        this.f21407id = str;
    }

    public String getId() {
        return this.f21407id;
    }

    public void setId(String str) {
        this.f21407id = str;
    }
}
