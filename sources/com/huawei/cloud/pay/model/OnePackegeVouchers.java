package com.huawei.cloud.pay.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class OnePackegeVouchers {
    private List<Voucher> commonVoucherList = new ArrayList();
    private List<Voucher> singleChoiceVoucherList = new ArrayList();

    public List<Voucher> getCommonVoucherList() {
        return this.commonVoucherList;
    }

    public List<Voucher> getSingleChoiceVoucherList() {
        return this.singleChoiceVoucherList;
    }

    public void setCommonVoucherList(List<Voucher> list) {
        this.commonVoucherList = list;
    }

    public void setSingleChoiceVoucherList(List<Voucher> list) {
        this.singleChoiceVoucherList = list;
    }
}
