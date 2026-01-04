package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class MultiTerminalDeviceInfo {
    private String productId;

    /* renamed from: sn */
    private String f24739sn;
    private int synStatus;

    public MultiTerminalDeviceInfo(String str, int i10, String str2) {
        this.f24739sn = str;
        this.synStatus = i10;
        this.productId = str2;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getSn() {
        return this.f24739sn;
    }

    public int getSynStatus() {
        return this.synStatus;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setSn(String str) {
        this.f24739sn = str;
    }

    public void setSynStatus(int i10) {
        this.synStatus = i10;
    }
}
