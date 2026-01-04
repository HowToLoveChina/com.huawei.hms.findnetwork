package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.magazine.inter.MagLockAd;
import com.huawei.openalliance.p169ad.magazine.inter.MagLockAdContent;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.hx */
/* loaded from: classes8.dex */
public class C7203hx implements MagLockAd {

    /* renamed from: a */
    private int f33157a;

    /* renamed from: b */
    private String f33158b;

    /* renamed from: c */
    private List<MagLockAdContent> f33159c;

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAd
    public List<MagLockAdContent> getAdList() {
        return this.f33159c;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAd
    public int getRetCode() {
        return this.f33157a;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAd
    public String getSlotId() {
        return this.f33158b;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAd
    public void setAdList(List<MagLockAdContent> list) {
        this.f33159c = list;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAd
    public void setRetCode(int i10) {
        this.f33157a = i10;
    }

    @Override // com.huawei.openalliance.p169ad.magazine.inter.MagLockAd
    public void setSlotId(String str) {
        this.f33158b = str;
    }

    public String toString() {
        return "MagLockAdImpl [slotId=" + this.f33158b + ", contentList=" + this.f33159c + ", code=" + this.f33157a + "]";
    }
}
