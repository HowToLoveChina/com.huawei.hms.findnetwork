package com.huawei.cloud.pay.model;

import java.util.List;

/* loaded from: classes5.dex */
public class PickWelfareResponse extends Response {
    private List<Welfare> welfareList;

    public List<Welfare> getWelfareList() {
        return this.welfareList;
    }

    public void setWelfareList(List<Welfare> list) {
        this.welfareList = list;
    }
}
