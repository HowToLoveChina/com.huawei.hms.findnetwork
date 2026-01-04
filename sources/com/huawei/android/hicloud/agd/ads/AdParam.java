package com.huawei.android.hicloud.agd.ads;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class AdParam implements Serializable {
    private static final long serialVersionUID = 4654787121237557484L;
    private String adId;
    private int adType;
    private int order;

    public String getAdId() {
        return this.adId;
    }

    public int getAdType() {
        return this.adType;
    }

    public int getOrder() {
        return this.order;
    }

    public void setAdId(String str) {
        this.adId = str;
    }

    public void setAdType(int i10) {
        this.adType = i10;
    }

    public void setOrder(int i10) {
        this.order = i10;
    }
}
