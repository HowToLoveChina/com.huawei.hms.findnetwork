package com.huawei.hms.findnetwork.comm.request.bean;

import java.util.List;

/* loaded from: classes8.dex */
public class HeartBeatBean {
    public List<Integer> businessIdList;

    /* renamed from: sn */
    public String f24737sn;

    public HeartBeatBean(String str, List<Integer> list) {
        this.f24737sn = str;
        this.businessIdList = list;
    }

    public List<Integer> getBusinessIdList() {
        return this.businessIdList;
    }

    public String getSn() {
        return this.f24737sn;
    }

    public void setBusinessIdList(List<Integer> list) {
        this.businessIdList = list;
    }

    public void setSn(String str) {
        this.f24737sn = str;
    }
}
