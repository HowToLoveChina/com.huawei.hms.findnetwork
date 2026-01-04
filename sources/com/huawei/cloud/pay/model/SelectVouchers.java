package com.huawei.cloud.pay.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes5.dex */
public class SelectVouchers implements Serializable {
    private static final long serialVersionUID = 4127829183334393901L;
    private List<Voucher> selectVoucherList;

    public List<Voucher> getSelectVoucherList() {
        return this.selectVoucherList;
    }

    public void setSelectVoucherList(List<Voucher> list) {
        this.selectVoucherList = list;
    }
}
