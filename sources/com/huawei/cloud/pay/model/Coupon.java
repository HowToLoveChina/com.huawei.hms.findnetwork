package com.huawei.cloud.pay.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class Coupon {
    private static final String VOUCHER_TYPE = "1";
    private List<String> list = new ArrayList();
    private String override;

    public void add(Voucher voucher) {
        this.list.add(voucher.getVoucherCode() + "|" + voucher.getDiscount() + "|1");
    }

    public List<String> getList() {
        return this.list;
    }

    public String getOverride() {
        return this.override;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setOverride(String str) {
        this.override = str;
    }
}
