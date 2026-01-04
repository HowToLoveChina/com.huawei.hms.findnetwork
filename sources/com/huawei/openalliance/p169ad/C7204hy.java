package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.magazine.inter.MagLockAd;
import com.huawei.openalliance.p169ad.magazine.inter.MagLockAdInfo;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.hy */
/* loaded from: classes8.dex */
public class C7204hy implements MagLockAdInfo {

    /* renamed from: a */
    private int f33160a;

    /* renamed from: b */
    private List<MagLockAd> f33161b;

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdInfo
    public List<MagLockAd> getMultiAds() {
        return this.f33161b;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdInfo
    public int getRetCode() {
        return this.f33160a;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdInfo
    public void setMultiAds(List<MagLockAd> list) {
        this.f33161b = list;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAdInfo
    public void setRetCode(int i10) {
        this.f33160a = i10;
    }

    public String toString() {
        return "MagLockAdInfoImpl [multiAds=" + this.f33161b + ", code=" + this.f33160a + "]";
    }
}
