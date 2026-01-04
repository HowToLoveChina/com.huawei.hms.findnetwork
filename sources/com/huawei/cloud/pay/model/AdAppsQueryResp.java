package com.huawei.cloud.pay.model;

import java.util.List;

/* loaded from: classes5.dex */
public class AdAppsQueryResp extends Response {
    private List<String> packageNameList;

    public List<String> getPackageNameList() {
        return this.packageNameList;
    }

    public void setPackageNameList(List<String> list) {
        this.packageNameList = list;
    }
}
