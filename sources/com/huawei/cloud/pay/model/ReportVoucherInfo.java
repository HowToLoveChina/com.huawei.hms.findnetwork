package com.huawei.cloud.pay.model;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class ReportVoucherInfo implements Serializable {
    private static final long serialVersionUID = 8567646604673917980L;
    boolean isRecommendVouchers;
    String packageVoucherList;
    String selectVoucherList;

    public String getPackageVoucherList() {
        return this.packageVoucherList;
    }

    public String getSelectVoucherList() {
        return this.selectVoucherList;
    }

    public boolean isRecommendVouchers() {
        return this.isRecommendVouchers;
    }

    public void setPackageVoucherList(String str) {
        this.packageVoucherList = str;
    }

    public void setRecommendVouchers(boolean z10) {
        this.isRecommendVouchers = z10;
    }

    public void setSelectVoucherList(String str) {
        this.selectVoucherList = str;
    }
}
