package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class QueryPresentReq extends Request {
    private String requestId;

    public QueryPresentReq(String str, String str2) {
        super(str);
        this.requestId = str2;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }
}
