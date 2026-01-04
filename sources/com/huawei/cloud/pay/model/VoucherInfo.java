package com.huawei.cloud.pay.model;

import java.math.BigDecimal;

/* loaded from: classes5.dex */
public class VoucherInfo {
    private BigDecimal discountAmt;
    private String feeMode;
    private String voucherCode;

    public BigDecimal getDiscountAmt() {
        return this.discountAmt;
    }

    public String getFeeMode() {
        return this.feeMode;
    }

    public String getVoucherCode() {
        return this.voucherCode;
    }

    public void setDiscountAmt(BigDecimal bigDecimal) {
        this.discountAmt = bigDecimal;
    }

    public void setFeeMode(String str) {
        this.feeMode = str;
    }

    public void setVoucherCode(String str) {
        this.voucherCode = str;
    }
}
