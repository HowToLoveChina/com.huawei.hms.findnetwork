package com.huawei.cloud.pay.model;

import java.util.List;

/* loaded from: classes5.dex */
public class GetAvaVouchersResp extends Response {
    private List<Voucher> vouchers;

    public List<Voucher> getVouchers() {
        return this.vouchers;
    }

    public void setVouchers(List<Voucher> list) {
        this.vouchers = list;
    }
}
