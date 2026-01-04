package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.gn */
/* loaded from: classes8.dex */
public class C7157gn implements InterfaceC7155gl {

    /* renamed from: a */
    private NativeAdListener f32938a;

    public C7157gn(NativeAdListener nativeAdListener) {
        this.f32938a = nativeAdListener;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7155gl
    /* renamed from: a */
    public void mo43590a(int i10) {
        AbstractC7185ho.m43820b("NativeAd", "onAdFailed, errorCode:" + i10);
        NativeAdListener nativeAdListener = this.f32938a;
        if (nativeAdListener != null) {
            nativeAdListener.onAdFailed(i10);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7155gl
    /* renamed from: a */
    public void mo43591a(Map map) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onAdsLoaded, size:");
        sb2.append(map != null ? Integer.valueOf(map.size()) : null);
        sb2.append(", listener:");
        sb2.append(this.f32938a);
        AbstractC7185ho.m43820b("NativeAd", sb2.toString());
        NativeAdListener nativeAdListener = this.f32938a;
        if (nativeAdListener != null) {
            nativeAdListener.onAdsLoaded(map);
        }
    }
}
