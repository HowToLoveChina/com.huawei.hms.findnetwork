package com.huawei.cloud.pay.model;

import java.math.BigDecimal;
import java.util.List;

/* loaded from: classes5.dex */
public class RecommendVouchers {
    private BigDecimal discountAmount;
    private BigDecimal totalDiscount;
    private List<Voucher> voucherList;
    private String voucherType;

    public BigDecimal getDiscountAmount() {
        return this.discountAmount;
    }

    public BigDecimal getTotalDiscount() {
        return this.totalDiscount;
    }

    public List<Voucher> getVoucherList() {
        return this.voucherList;
    }

    public String getVoucherType() {
        return this.voucherType;
    }

    public void setDiscountAmount(BigDecimal bigDecimal) {
        this.discountAmount = bigDecimal;
    }

    public void setTotalDiscount(BigDecimal bigDecimal) {
        this.totalDiscount = bigDecimal;
    }

    public void setVoucherList(List<Voucher> list) {
        this.voucherList = list;
    }

    public void setVoucherType(String str) {
        this.voucherType = str;
    }
}
