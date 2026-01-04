package com.huawei.cloud.pay.model;

import java.util.List;

/* loaded from: classes5.dex */
public class GetAvaVouchersReq extends Request {
    private List<String> packageIdList;
    private List<String> voucherCodeList;

    public GetAvaVouchersReq(String str, List<String> list, List<String> list2) {
        super(str);
        this.packageIdList = list;
        this.voucherCodeList = list2;
    }

    public List<String> getPackageIdList() {
        return this.packageIdList;
    }

    public List<String> getVoucherCodeList() {
        return this.voucherCodeList;
    }

    public void setPackageIdList(List<String> list) {
        this.packageIdList = list;
    }

    public void setVoucherCodeList(List<String> list) {
        this.voucherCodeList = list;
    }
}
