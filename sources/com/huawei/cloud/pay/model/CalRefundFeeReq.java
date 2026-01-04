package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class CalRefundFeeReq extends Request {
    private int scene;

    public CalRefundFeeReq(String str, int i10) {
        super(str);
        this.scene = i10;
    }

    public int getScene() {
        return this.scene;
    }

    public void setScene(int i10) {
        this.scene = i10;
    }
}
