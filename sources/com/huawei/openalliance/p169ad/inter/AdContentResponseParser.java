package com.huawei.openalliance.p169ad.inter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7156gm;
import com.huawei.openalliance.p169ad.C7157gn;
import com.huawei.openalliance.p169ad.C7158go;
import com.huawei.openalliance.p169ad.C7159gp;
import com.huawei.openalliance.p169ad.C7544ol;
import com.huawei.openalliance.p169ad.C7545om;
import com.huawei.openalliance.p169ad.C7564oy;
import com.huawei.openalliance.p169ad.C7591pt;
import com.huawei.openalliance.p169ad.InterfaceC7155gl;
import com.huawei.openalliance.p169ad.InterfaceC7611qm;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.constant.AnalyticsEventType;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.openalliance.p169ad.inter.AdParseConfig;
import com.huawei.openalliance.p169ad.inter.data.IPlacementAd;
import com.huawei.openalliance.p169ad.inter.data.IPreCheckInfo;
import com.huawei.openalliance.p169ad.inter.listeners.InterstitialAdCallback;
import com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener;
import com.huawei.openalliance.p169ad.inter.listeners.NativePreCheckInfoListener;
import com.huawei.openalliance.p169ad.inter.listeners.PlacementAdListener;
import com.huawei.openalliance.p169ad.inter.listeners.RewardAdListener;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7768bo;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7728ab;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import com.huawei.openalliance.p169ad.utils.C7800ct;
import com.huawei.openalliance.p169ad.utils.C7829h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@OuterVisible
/* loaded from: classes2.dex */
public class AdContentResponseParser implements IAdContentResponseParser, C7545om.a {

    /* renamed from: a */
    private HashMap<Integer, InterfaceC7155gl> f33222a;

    /* renamed from: b */
    private InterfaceC7611qm f33223b;

    /* renamed from: c */
    private Context f33224c;

    /* renamed from: d */
    private String f33225d;

    /* renamed from: e */
    private long f33226e;

    /* renamed from: f */
    private long f33227f;

    /* renamed from: g */
    private C7544ol f33228g;

    /* renamed from: h */
    private boolean f33229h;

    /* renamed from: i */
    private NativePreCheckInfoListener f33230i;

    /* renamed from: j */
    private String f33231j;

    @OuterVisible
    public static final class Builder {

        /* renamed from: a */
        private Context f33247a;

        /* renamed from: b */
        private boolean f33248b;

        /* renamed from: c */
        private boolean f33249c;

        /* renamed from: d */
        private boolean f33250d;

        /* renamed from: e */
        private boolean f33251e;

        /* renamed from: f */
        private boolean f33252f = false;

        /* renamed from: g */
        private RewardAdListener f33253g;

        /* renamed from: h */
        private NativeAdListener f33254h;

        /* renamed from: i */
        private PlacementAdListener f33255i;

        /* renamed from: j */
        private InterstitialAdCallback f33256j;

        /* renamed from: k */
        private C7564oy.a f33257k;

        /* renamed from: l */
        private NativeAdListener f33258l;

        /* renamed from: m */
        private NativeAdListener f33259m;

        /* renamed from: n */
        private NativePreCheckInfoListener f33260n;

        @OuterVisible
        public Builder(Context context) {
            this.f33247a = context;
        }

        @OuterVisible
        public AdContentResponseParser build() {
            return new AdContentResponseParser(this);
        }

        @OuterVisible
        public Builder enableDirectCacheVideo(boolean z10) {
            this.f33251e = z10;
            return this;
        }

        @OuterVisible
        public Builder enableDirectReturnVideoAd(boolean z10) {
            this.f33249c = z10;
            return this;
        }

        @OuterVisible
        public Builder enableVideoDownloadInMobileNetwork(boolean z10) {
            this.f33250d = z10;
            return this;
        }

        @OuterVisible
        public Builder setAdsReturnedFromThread(boolean z10) {
            this.f33252f = z10;
            return this;
        }

        @OuterVisible
        public Builder setAutoCache(boolean z10) {
            this.f33248b = z10;
            return this;
        }

        @OuterVisible
        public Builder setIconAdListener(NativeAdListener nativeAdListener) {
            this.f33258l = nativeAdListener;
            return this;
        }

        @OuterVisible
        public Builder setInterstitialAdCallback(InterstitialAdCallback interstitialAdCallback) {
            this.f33256j = interstitialAdCallback;
            return this;
        }

        @OuterVisible
        public Builder setNativeAdListener(NativeAdListener nativeAdListener) {
            this.f33254h = nativeAdListener;
            return this;
        }

        @OuterVisible
        public Builder setNativePreCheckInfoListener(NativePreCheckInfoListener nativePreCheckInfoListener) {
            this.f33260n = nativePreCheckInfoListener;
            return this;
        }

        @OuterVisible
        public Builder setPlacementAdListener(PlacementAdListener placementAdListener) {
            this.f33255i = placementAdListener;
            return this;
        }

        @OuterVisible
        public Builder setRewardAdListener(RewardAdListener rewardAdListener) {
            this.f33253g = rewardAdListener;
            return this;
        }

        @OuterVisible
        public Builder setSearchAdListener(NativeAdListener nativeAdListener) {
            this.f33259m = nativeAdListener;
            return this;
        }

        /* renamed from: a */
        public Builder m43994a(C7564oy.a aVar) {
            this.f33257k = aVar;
            return this;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.AdContentResponseParser$a */
    public static class RunnableC7228a implements Runnable {

        /* renamed from: a */
        private Map f33261a;

        /* renamed from: b */
        private Context f33262b;

        public RunnableC7228a(Map map, Context context) {
            this.f33261a = map;
            this.f33262b = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m43997b(Set<String> set) {
            if (set == null || set.size() == 0) {
                AbstractC7185ho.m43826d("AdContentResponseParser", "slotIds is empty");
                return;
            }
            String packageName = this.f33262b.getPackageName();
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                C7829h.m48407a(this.f33262b, packageName, AnalyticsEventType.AD_REQ, String.valueOf(1), it.next(), "");
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!C7765bl.m47802a(this.f33261a)) {
                m43996a(this.f33261a.keySet());
            }
            AbstractC7185ho.m43816a(null);
        }

        /* renamed from: a */
        private void m43996a(final Set<String> set) {
            AbstractC7834m.m48488h(new Runnable() { // from class: com.huawei.openalliance.ad.inter.AdContentResponseParser.a.1
                @Override // java.lang.Runnable
                public void run() {
                    RunnableC7228a.this.m43997b(set);
                }
            });
        }
    }

    private AdContentResponseParser(Builder builder) {
        this.f33226e = System.currentTimeMillis();
        this.f33229h = false;
        this.f33230i = null;
        this.f33231j = "delay_options_timeout_task_id" + hashCode();
        if (builder == null || builder.f33247a == null || !AbstractC7741ao.m47562b(builder.f33247a)) {
            return;
        }
        this.f33224c = builder.f33247a;
        m43961a(builder);
        if (this.f33222a.isEmpty()) {
            return;
        }
        C7545om c7545om = new C7545om(this.f33224c, this);
        this.f33223b = c7545om;
        c7545om.mo46345a(builder.f33249c);
        this.f33223b.mo46346b(builder.f33250d);
        this.f33223b.mo46347c(builder.f33251e);
        this.f33228g = new C7544ol(this.f33224c);
        this.f33229h = builder.f33252f;
        this.f33230i = builder.f33260n;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAdContentResponseParser
    public void processAdResponse(String str) {
        AdParseConfig.Builder builder = new AdParseConfig.Builder();
        builder.setUpdateConfig(false).setAccelerate(false);
        m43967a(str, builder.build());
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAdContentResponseParser
    public void startCache(int i10) {
        InterfaceC7155gl interfaceC7155gl = this.f33222a.get(60);
        if (interfaceC7155gl instanceof C7158go) {
            ((C7158go) interfaceC7155gl).m43606b(i10);
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAdContentResponseParser
    public void stopCache() {
        InterfaceC7155gl interfaceC7155gl = this.f33222a.get(60);
        if (interfaceC7155gl instanceof C7158go) {
            ((C7158go) interfaceC7155gl).m43601a();
        }
    }

    /* renamed from: b */
    private void m43971b(final int i10, final int i11) {
        HashMap<Integer, InterfaceC7155gl> map = this.f33222a;
        if (map == null || !map.containsKey(Integer.valueOf(i10))) {
            return;
        }
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.AdContentResponseParser.6
            @Override // java.lang.Runnable
            public void run() {
                InterfaceC7155gl interfaceC7155gl = (InterfaceC7155gl) AdContentResponseParser.this.f33222a.get(Integer.valueOf(i10));
                int iM47430a = C7728ab.m47430a(i10, i11);
                AdContentResponseParser.this.f33227f = System.currentTimeMillis();
                interfaceC7155gl.mo43590a(iM47430a);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAdContentResponseParser
    public void processAdResponse(String str, AdParseConfig adParseConfig) {
        if (!m43969a(adParseConfig)) {
            AbstractC7185ho.m43816a(5);
        }
        if (adParseConfig == null) {
            m43967a(str, new AdParseConfig.Builder().build());
        } else if (!adParseConfig.m43999b() || !TextUtils.isEmpty(C7800ct.m48114a().m48121c())) {
            m43967a(str, adParseConfig);
        } else {
            AbstractC7185ho.m43823c("AdContentResponseParser", "must set media router country code first");
            mo43977a(-1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m43972b(int i10, Map map) {
        this.f33222a.get(Integer.valueOf(i10)).mo43591a(map);
        AbstractC7768bo.m47810a(this.f33231j);
        AbstractC7768bo.m47809a(new RunnableC7228a(map, this.f33224c.getApplicationContext()), this.f33231j, 500L);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IAdContentResponseParser
    public void processAdResponse(String str, boolean z10) {
        AdParseConfig.Builder builder = new AdParseConfig.Builder();
        builder.setAccelerate(false);
        if (!z10) {
            builder.setUpdateConfig(false);
        } else {
            if (TextUtils.isEmpty(C7800ct.m48114a().m48121c())) {
                AbstractC7185ho.m43823c("AdContentResponseParser", "must set media router country code first");
                mo43977a(-1, -1);
                return;
            }
            builder.setUpdateConfig(true);
        }
        m43967a(str, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Map<Integer, AdContentRsp> m43958a(Map<Integer, AdContentRsp> map) {
        Set<Integer> setKeySet = this.f33222a.keySet();
        Iterator<Map.Entry<Integer, AdContentRsp>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Integer key = it.next().getKey();
            key.intValue();
            if (!setKeySet.contains(key)) {
                it.remove();
            }
        }
        for (Integer num : setKeySet) {
            int iIntValue = num.intValue();
            if (!map.containsKey(num)) {
                m43971b(iIntValue, ErrorCode.ERROR_CODE_OTHER);
            }
        }
        return map;
    }

    /* renamed from: a */
    private void m43959a(final int i10) {
        HashMap<Integer, InterfaceC7155gl> map = this.f33222a;
        if (map == null || map.isEmpty()) {
            return;
        }
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.AdContentResponseParser.5
            @Override // java.lang.Runnable
            public void run() {
                for (Map.Entry entry : AdContentResponseParser.this.f33222a.entrySet()) {
                    ((InterfaceC7155gl) entry.getValue()).mo43590a(C7728ab.m47430a(((Integer) entry.getKey()).intValue(), i10));
                }
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.C7545om.a
    /* renamed from: a */
    public void mo43977a(int i10, int i11) {
        if (i10 == -1) {
            m43959a(i11);
        } else {
            m43971b(i10, i11);
        }
    }

    @Override // com.huawei.openalliance.p169ad.C7545om.a
    /* renamed from: a */
    public void mo43978a(final int i10, final Map map) {
        HashMap<Integer, InterfaceC7155gl> map2 = this.f33222a;
        if (map2 == null || !map2.containsKey(Integer.valueOf(i10))) {
            return;
        }
        if (map == null || map.isEmpty()) {
            mo43977a(i10, 204);
        } else if (!this.f33229h) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.AdContentResponseParser.4
                @Override // java.lang.Runnable
                public void run() {
                    AdContentResponseParser.this.m43972b(i10, map);
                }
            });
        } else {
            AbstractC7185ho.m43820b("AdContentResponseParser", "onAdLoaded in Thread");
            m43972b(i10, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m43960a(Pair<String, Map<Integer, AdContentRsp>> pair, AdParseConfig adParseConfig) {
        Object obj;
        if (!adParseConfig.m44001d() || (obj = pair.second) == null || this.f33230i == null) {
            return;
        }
        final AdContentRsp adContentRsp = (AdContentRsp) ((Map) obj).get(3);
        AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.inter.AdContentResponseParser.2
            @Override // java.lang.Runnable
            public void run() {
                AdContentResponseParser.this.m43968a(C7591pt.m46957a(AdContentResponseParser.this.f33224c, adContentRsp));
            }
        });
    }

    /* renamed from: a */
    private void m43961a(Builder builder) {
        this.f33222a = new HashMap<>(4);
        if (builder.f33254h != null) {
            this.f33222a.put(3, new C7157gn(builder.f33254h));
        }
        if (builder.f33258l != null) {
            this.f33222a.put(9, new C7157gn(builder.f33258l));
        }
        if (builder.f33259m != null) {
            this.f33222a.put(13, new C7157gn(builder.f33259m));
        }
        if (builder.f33253g != null) {
            this.f33222a.put(7, new C7159gp(this.f33224c, builder.f33253g));
        }
        if (builder.f33256j != null || builder.f33257k != null) {
            this.f33222a.put(12, new C7156gm(this.f33224c, builder.f33256j, builder.f33257k));
        }
        if (builder.f33255i != null) {
            this.f33222a.put(60, new C7158go(this.f33224c, builder.f33255i, builder.f33248b));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m43966a(String str) {
        this.f33225d = str;
    }

    /* renamed from: a */
    private void m43967a(final String str, final AdParseConfig adParseConfig) {
        AbstractC7185ho.m43820b("AdContentResponseParser", "processAdResponse");
        if (C7765bl.m47802a(this.f33222a)) {
            AbstractC7185ho.m43823c("AdContentResponseParser", "ad callbacks has't been set");
            return;
        }
        if (!AbstractC7741ao.m47562b(this.f33224c)) {
            AbstractC7185ho.m43823c("AdContentResponseParser", "api level too low");
            mo43977a(-1, 1001);
        } else if (!TextUtils.isEmpty(str)) {
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.inter.AdContentResponseParser.1
                @Override // java.lang.Runnable
                public void run() {
                    Pair<String, Map<Integer, AdContentRsp>> pairM46327a = AdContentResponseParser.this.f33228g.m46327a(str, AdContentResponseParser.this.f33226e, AdContentResponseParser.this.f33222a.keySet(), adParseConfig.m43999b());
                    AdContentResponseParser.this.m43966a((String) pairM46327a.first);
                    AdContentResponseParser.this.m43960a(pairM46327a, adParseConfig);
                    AdContentResponseParser.this.f33223b.mo46344a(AdContentResponseParser.this.m43958a((Map<Integer, AdContentRsp>) pairM46327a.second), AdContentResponseParser.this.f33226e, adParseConfig);
                }
            });
        } else {
            AbstractC7185ho.m43820b("AdContentResponseParser", "request ad fail");
            mo43977a(-1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m43968a(final List<IPreCheckInfo> list) {
        if (!this.f33229h) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.AdContentResponseParser.3
                @Override // java.lang.Runnable
                public void run() {
                    AdContentResponseParser.this.f33230i.onPreCheck(list);
                }
            });
            return;
        }
        try {
            this.f33230i.onPreCheck(list);
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("AdContentResponseParser", "native preCheck notify err!");
        }
    }

    @Override // com.huawei.openalliance.p169ad.C7545om.a
    /* renamed from: a */
    public void mo43979a(Map map, Map map2) {
        InterfaceC7155gl interfaceC7155gl = this.f33222a.get(60);
        if (interfaceC7155gl instanceof C7158go) {
            C7158go c7158go = (C7158go) interfaceC7155gl;
            c7158go.m43603a(this.f33225d);
            c7158go.m43602a(this.f33226e);
            c7158go.m43604a((Map<String, List<IPlacementAd>>) map, (Map<String, List<IPlacementAd>>) map2);
            c7158go.m43605b();
        }
    }

    /* renamed from: a */
    private boolean m43969a(AdParseConfig adParseConfig) {
        Context context = this.f33224c;
        if (context == null || adParseConfig == null || Constants.HW_BROWSER_PACKAGE.equalsIgnoreCase(context.getPackageName())) {
            return false;
        }
        return adParseConfig.m44002e();
    }
}
