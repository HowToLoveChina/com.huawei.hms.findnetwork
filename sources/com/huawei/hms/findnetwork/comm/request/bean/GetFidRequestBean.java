package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class GetFidRequestBean extends BaseRequestBean {
    private String macAddress;

    public GetFidRequestBean(String str) {
        this.macAddress = str;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public void setMacAddress(String str) {
        this.macAddress = str;
    }
}
