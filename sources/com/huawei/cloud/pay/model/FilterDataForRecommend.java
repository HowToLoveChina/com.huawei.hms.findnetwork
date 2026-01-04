package com.huawei.cloud.pay.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class FilterDataForRecommend {
    ArrayList<FilterAvailabalGradePackage> filterAvailabalGradePackageList = new ArrayList<>();
    List<Voucher> voucherList = new ArrayList();

    public ArrayList<FilterAvailabalGradePackage> getFilterAvailabalGradePackageList() {
        return this.filterAvailabalGradePackageList;
    }

    public List<Voucher> getVoucherList() {
        return this.voucherList;
    }

    public void setFilterAvailabalGradePackageList(ArrayList<FilterAvailabalGradePackage> arrayList) {
        this.filterAvailabalGradePackageList = arrayList;
    }

    public void setVoucherList(List<Voucher> list) {
        this.voucherList = list;
    }
}
