package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class QuerySubOrderStatusReq extends Request {

    /* renamed from: id */
    private String f21414id;

    public QuerySubOrderStatusReq(String str) {
        super("querySubOrderStatus");
        this.f21414id = str;
    }

    public String getId() {
        return this.f21414id;
    }

    public void setId(String str) {
        this.f21414id = str;
    }
}
