package com.huawei.openalliance.p169ad.beans.vast;

/* loaded from: classes8.dex */
public class Creative {
    private final String adId;

    /* renamed from: id */
    private final String f32018id;
    private LinearCreative linearAd;
    private NonLinearAds nonLinearAd;
    private final Integer sequence;

    public Creative(String str, Integer num, String str2) {
        this.f32018id = str;
        this.sequence = num;
        this.adId = str2;
    }

    /* renamed from: a */
    public LinearCreative m40973a() {
        return this.linearAd;
    }

    /* renamed from: b */
    public NonLinearAds m40976b() {
        return this.nonLinearAd;
    }

    /* renamed from: a */
    public void m40974a(LinearCreative linearCreative) {
        this.linearAd = linearCreative;
    }

    /* renamed from: a */
    public void m40975a(NonLinearAds nonLinearAds) {
        this.nonLinearAd = nonLinearAds;
    }
}
