package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.C7564oy;
import com.huawei.openalliance.p169ad.inter.data.BiddingInfo;
import com.huawei.openalliance.p169ad.inter.data.InterfaceC7299b;
import com.huawei.openalliance.p169ad.inter.data.InterstitialAd;
import com.huawei.openalliance.p169ad.inter.listeners.InterstitialAdCallback;
import com.huawei.openalliance.p169ad.inter.listeners.InterstitialAdListener;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.C7727aa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.gm */
/* loaded from: classes8.dex */
public class C7156gm implements InterfaceC7155gl {

    /* renamed from: a */
    private InterstitialAdListener f32932a;

    /* renamed from: b */
    private InterstitialAdCallback f32933b;

    /* renamed from: c */
    private InterstitialAd f32934c;

    /* renamed from: d */
    private Context f32935d;

    /* renamed from: e */
    private List<InterfaceC7299b> f32936e = new ArrayList();

    /* renamed from: f */
    private C7564oy.a f32937f;

    /* renamed from: com.huawei.openalliance.ad.gm$a */
    public static class a implements Serializable, Comparator<InterfaceC7299b> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(InterfaceC7299b interfaceC7299b, InterfaceC7299b interfaceC7299b2) {
            if (m43593a(interfaceC7299b.getBiddingInfo()) && !m43593a(interfaceC7299b2.getBiddingInfo())) {
                return -1;
            }
            if (m43593a(interfaceC7299b.getBiddingInfo()) && m43593a(interfaceC7299b2.getBiddingInfo())) {
                return (interfaceC7299b.getBiddingInfo().getPrice().floatValue() <= 0.0f || Float.compare(interfaceC7299b.getBiddingInfo().getPrice().floatValue(), interfaceC7299b2.getBiddingInfo().getPrice().floatValue()) >= 0) ? -1 : 1;
            }
            return 1;
        }

        /* renamed from: a */
        private boolean m43593a(BiddingInfo biddingInfo) {
            return (biddingInfo == null || biddingInfo.getPrice() == null) ? false : true;
        }
    }

    public C7156gm(Context context, InterstitialAdCallback interstitialAdCallback, C7564oy.a aVar) {
        this.f32935d = context;
        this.f32933b = interstitialAdCallback;
        this.f32937f = aVar;
        if (interstitialAdCallback != null) {
            this.f32932a = interstitialAdCallback.getInterstitialAdListener();
        }
        if (this.f32934c == null) {
            InterstitialAd interstitialAd = new InterstitialAd(context);
            this.f32934c = interstitialAd;
            interstitialAd.setAdListener(this.f32932a);
        }
        this.f32936e.clear();
    }

    /* renamed from: b */
    private void m43592b(Map<String, List<InterfaceC7299b>> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (List<InterfaceC7299b> list : map.values()) {
            if (!AbstractC7760bg.m47767a(list)) {
                for (InterfaceC7299b interfaceC7299b : list) {
                    if (interfaceC7299b.isExpired() || !interfaceC7299b.mo44679c_()) {
                        AbstractC7185ho.m43820b("InterstitialAd", "expired is true, content id:" + interfaceC7299b.getContentId());
                    } else {
                        this.f32936e.add(interfaceC7299b);
                    }
                }
                Collections.sort(this.f32936e, new a());
                this.f32934c.m44481a(this.f32936e);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7155gl
    /* renamed from: a */
    public void mo43590a(int i10) {
        AbstractC7185ho.m43820b("InterstitialAd", "onAdFailed, errorCode:" + i10);
        InterstitialAdListener interstitialAdListener = this.f32932a;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdFailed(i10);
        }
        C7564oy.a aVar = this.f32937f;
        if (aVar != null) {
            aVar.mo45001a(i10);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7155gl
    /* renamed from: a */
    public void mo43591a(Map map) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onAdsLoaded, size:");
        sb2.append(map != null ? Integer.valueOf(map.size()) : null);
        AbstractC7185ho.m43820b("InterstitialAd", sb2.toString());
        m43592b(map);
        InterstitialAdListener interstitialAdListener = this.f32932a;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdLoaded();
        }
        InterstitialAdCallback interstitialAdCallback = this.f32933b;
        if (interstitialAdCallback != null) {
            interstitialAdCallback.onAdsLoaded(this.f32934c);
        }
        C7564oy.a aVar = this.f32937f;
        if (aVar != null) {
            aVar.mo45013a((Map<String, List<InterfaceC7299b>>) map);
        }
        C7727aa.m47424b(this.f32935d, map);
    }
}
