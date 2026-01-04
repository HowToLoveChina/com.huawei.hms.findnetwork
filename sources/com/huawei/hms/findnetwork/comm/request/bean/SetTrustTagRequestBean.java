package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class SetTrustTagRequestBean extends SnRequestBean {
    private boolean isTrust;

    public SetTrustTagRequestBean(String str, boolean z10) {
        this.connectTagSn = str;
        this.isTrust = z10;
    }

    public boolean isTrust() {
        return this.isTrust;
    }

    public void setTrust(boolean z10) {
        this.isTrust = z10;
    }
}
