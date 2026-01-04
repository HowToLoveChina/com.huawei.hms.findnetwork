package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class OrderReq extends Request {
    private Long timestamp;

    public OrderReq() {
        super("queryOrderPage");
    }

    public long getTimestamp() {
        return this.timestamp.longValue();
    }

    public void setTimestamp(long j10) {
        this.timestamp = Long.valueOf(j10);
    }

    public OrderReq(long j10) {
        super("queryOrderPage");
        this.timestamp = Long.valueOf(j10);
    }
}
