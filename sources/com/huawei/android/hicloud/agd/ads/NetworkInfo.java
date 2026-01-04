package com.huawei.android.hicloud.agd.ads;

import p015ak.C0209d;
import p015ak.C0213f;

/* loaded from: classes2.dex */
public class NetworkInfo {
    private Integer carrier = 0;
    private Integer connectType = Integer.valueOf(C0209d.m1225Y(C0213f.m1377a()));
    private String plmn;

    public Integer getCarrier() {
        return this.carrier;
    }

    public Integer getConnectType() {
        return this.connectType;
    }

    public String getPlmn() {
        return this.plmn;
    }

    public void setCarrier(Integer num) {
        this.carrier = num;
    }

    public void setConnectType(Integer num) {
        this.connectType = num;
    }

    public void setPlmn(String str) {
        this.plmn = str;
    }
}
