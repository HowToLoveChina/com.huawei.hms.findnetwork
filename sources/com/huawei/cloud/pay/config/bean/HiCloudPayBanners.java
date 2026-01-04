package com.huawei.cloud.pay.config.bean;

import java.util.ArrayList;

/* loaded from: classes5.dex */
public class HiCloudPayBanners {
    private ArrayList<BannerAfterPayItem> bannerAfterPay;
    private String date;

    /* renamed from: id */
    private String f21392id;
    private long version;

    public ArrayList<BannerAfterPayItem> getBannerAfterPay() {
        return this.bannerAfterPay;
    }

    public String getDate() {
        return this.date;
    }

    public String getId() {
        return this.f21392id;
    }

    public long getVersion() {
        return this.version;
    }

    public void setBannerAfterPay(ArrayList<BannerAfterPayItem> arrayList) {
        this.bannerAfterPay = arrayList;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(String str) {
        this.f21392id = str;
    }

    public void setVersion(long j10) {
        this.version = j10;
    }
}
