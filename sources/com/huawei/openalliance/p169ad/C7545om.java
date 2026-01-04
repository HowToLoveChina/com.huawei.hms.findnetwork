package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.C7564oy;
import com.huawei.openalliance.p169ad.C7571pe;
import com.huawei.openalliance.p169ad.C7581po;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.inter.AdParseConfig;
import com.huawei.openalliance.p169ad.inter.data.IAd;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.data.IPlacementAd;
import com.huawei.openalliance.p169ad.inter.data.IRewardAd;
import com.huawei.openalliance.p169ad.inter.data.InterfaceC7299b;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.om */
/* loaded from: classes8.dex */
public class C7545om implements InterfaceC7611qm {

    /* renamed from: a */
    private a f35079a;

    /* renamed from: b */
    private Context f35080b;

    /* renamed from: c */
    private boolean f35081c = false;

    /* renamed from: d */
    private boolean f35082d = false;

    /* renamed from: e */
    private boolean f35083e = false;

    /* renamed from: com.huawei.openalliance.ad.om$a */
    public interface a<T extends IAd> {
        /* renamed from: a */
        void mo43977a(int i10, int i11);

        /* renamed from: a */
        void mo43978a(int i10, Map<String, List<T>> map);

        /* renamed from: a */
        void mo43979a(Map<String, List<IPlacementAd>> map, Map<String, List<IPlacementAd>> map2);
    }

    public C7545om(Context context, a aVar) {
        this.f35080b = context;
        this.f35079a = aVar;
    }

    /* renamed from: b */
    private void m46341b(final int i10, AdContentRsp adContentRsp) {
        AbstractC7185ho.m43817a("ApiProcessor", "parseInterstitialAds");
        new C7564oy(this.f35080b, new C7564oy.a() { // from class: com.huawei.openalliance.ad.om.2
            @Override // com.huawei.openalliance.p169ad.C7564oy.a
            /* renamed from: a */
            public void mo45001a(int i11) {
                C7545om.this.f35079a.mo43977a(i10, i11);
            }

            @Override // com.huawei.openalliance.p169ad.C7564oy.a
            /* renamed from: a */
            public void mo45013a(Map<String, List<InterfaceC7299b>> map) {
                C7545om.this.f35079a.mo43978a(i10, map);
            }
        }).m46666a(adContentRsp);
    }

    /* renamed from: c */
    private void m46343c(final int i10, AdContentRsp adContentRsp) {
        AbstractC7185ho.m43817a("ApiProcessor", "parseRewardAds");
        new C7581po(this.f35080b, new C7581po.a() { // from class: com.huawei.openalliance.ad.om.3
            @Override // com.huawei.openalliance.p169ad.C7581po.a
            /* renamed from: a */
            public void mo44207a(int i11) {
                C7545om.this.f35079a.mo43977a(i10, i11);
            }

            @Override // com.huawei.openalliance.p169ad.C7581po.a
            /* renamed from: a */
            public void mo44209a(Map<String, List<IRewardAd>> map) {
                if (map == null || map.isEmpty()) {
                    C7545om.this.f35079a.mo43977a(i10, ErrorCode.ERROR_REWARD_AD_NO);
                } else {
                    C7545om.this.f35079a.mo43978a(i10, map);
                }
            }
        }).mo46807a(adContentRsp);
    }

    /* renamed from: a */
    private void m46339a(final int i10, AdContentRsp adContentRsp) {
        AbstractC7185ho.m43817a("ApiProcessor", "parsePlacementAds");
        AbstractC7548op.m46366a(this.f35080b, new InterfaceC7622qx() { // from class: com.huawei.openalliance.ad.om.1
            @Override // com.huawei.openalliance.p169ad.InterfaceC7622qx
            /* renamed from: a */
            public void mo44171a(int i11) {
                C7545om.this.f35079a.mo43977a(i10, i11);
            }

            @Override // com.huawei.openalliance.p169ad.InterfaceC7622qx
            /* renamed from: a */
            public void mo44172a(Map<String, List<IPlacementAd>> map, Map<String, List<IPlacementAd>> map2) {
                C7545om.this.f35079a.mo43979a(map, map2);
            }
        }, false).m46370a(adContentRsp);
    }

    /* renamed from: b */
    private void m46342b(final int i10, AdContentRsp adContentRsp, long j10, AdParseConfig adParseConfig) {
        AbstractC7185ho.m43817a("ApiProcessor", "parseNativeAds");
        C7571pe c7571pe = new C7571pe(this.f35080b, new C7571pe.a() { // from class: com.huawei.openalliance.ad.om.4
            @Override // com.huawei.openalliance.p169ad.C7571pe.a
            /* renamed from: a */
            public void mo44135a(int i11) {
                C7545om.this.f35079a.mo43977a(i10, i11);
            }

            @Override // com.huawei.openalliance.p169ad.C7571pe.a
            /* renamed from: a */
            public void mo44137a(Map<String, List<INativeAd>> map) {
                C7545om.this.f35079a.mo43978a(i10, map);
            }
        }, i10, adParseConfig.m43998a());
        c7571pe.mo46736a(this.f35081c);
        c7571pe.mo46738b(this.f35082d);
        c7571pe.mo46740c(this.f35083e);
        c7571pe.mo46733a(i10);
        c7571pe.mo46734a(adContentRsp, j10, adParseConfig);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7611qm
    /* renamed from: c */
    public void mo46347c(boolean z10) {
        this.f35083e = z10;
    }

    /* renamed from: a */
    private void m46340a(int i10, AdContentRsp adContentRsp, long j10, AdParseConfig adParseConfig) {
        if (i10 != 3) {
            if (i10 == 7) {
                m46343c(i10, adContentRsp);
                return;
            }
            if (i10 != 9) {
                if (i10 == 60) {
                    m46339a(i10, adContentRsp);
                    return;
                } else if (i10 == 12) {
                    m46341b(i10, adContentRsp);
                    return;
                } else if (i10 != 13) {
                    return;
                }
            }
        }
        m46342b(i10, adContentRsp, j10, adParseConfig);
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7611qm
    /* renamed from: b */
    public void mo46346b(boolean z10) {
        this.f35082d = z10;
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7611qm
    /* renamed from: a */
    public void mo46344a(Map<Integer, AdContentRsp> map, long j10, AdParseConfig adParseConfig) {
        AbstractC7185ho.m43820b("ApiProcessor", "api parser");
        if (map.isEmpty()) {
            return;
        }
        for (Map.Entry<Integer, AdContentRsp> entry : map.entrySet()) {
            Integer key = entry.getKey();
            int iIntValue = key.intValue();
            AbstractC7185ho.m43818a("ApiProcessor", "adType: %d", key);
            m46340a(iIntValue, entry.getValue(), j10, adParseConfig);
        }
    }

    @Override // com.huawei.openalliance.p169ad.InterfaceC7611qm
    /* renamed from: a */
    public void mo46345a(boolean z10) {
        this.f35081c = z10;
    }
}
