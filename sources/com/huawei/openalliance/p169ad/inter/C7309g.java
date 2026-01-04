package com.huawei.openalliance.p169ad.inter;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7095ek;
import com.huawei.openalliance.p169ad.C7544ol;
import com.huawei.openalliance.p169ad.C7564oy;
import com.huawei.openalliance.p169ad.analysis.C6923d;
import com.huawei.openalliance.p169ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.constant.ApiNames;
import com.huawei.openalliance.p169ad.inter.data.BiddingInfo;
import com.huawei.openalliance.p169ad.inter.data.InterfaceC7299b;
import com.huawei.openalliance.p169ad.inter.data.RewardVerifyConfig;
import com.huawei.openalliance.p169ad.inter.listeners.IRewardAdStatusListener;
import com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a;
import com.huawei.openalliance.p169ad.inter.listeners.InterstitialAdListener;
import com.huawei.openalliance.p169ad.opendeviceidentifier.OAIDServiceManager;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7727aa;
import com.huawei.openalliance.p169ad.utils.C7762bi;
import com.huawei.openalliance.p169ad.utils.C7845x;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.inter.g */
/* loaded from: classes2.dex */
public class C7309g implements C7564oy.a {

    /* renamed from: b */
    private Context f33933b;

    /* renamed from: c */
    private InterstitialAdListener f33934c;

    /* renamed from: d */
    private String f33935d;

    /* renamed from: e */
    private String f33936e;

    /* renamed from: f */
    private Location f33937f;

    /* renamed from: g */
    private IRewardAdStatusListener f33938g;

    /* renamed from: h */
    private String f33939h;

    /* renamed from: i */
    private Boolean f33940i;

    /* renamed from: j */
    private Bundle f33941j;

    /* renamed from: k */
    private String f33942k;

    /* renamed from: m */
    private C7564oy f33944m;

    /* renamed from: n */
    private RequestOptions f33945n;

    /* renamed from: o */
    private C7564oy.a f33946o;

    /* renamed from: q */
    private RewardVerifyConfig f33948q;

    /* renamed from: r */
    private Integer f33949r;

    /* renamed from: s */
    private VideoConfiguration f33950s;

    /* renamed from: t */
    private BiddingInfo f33951t;

    /* renamed from: a */
    private c f33932a = c.IDLE;

    /* renamed from: l */
    private DelayInfo f33943l = new DelayInfo();

    /* renamed from: p */
    private List<InterfaceC7299b> f33947p = new ArrayList();

    /* renamed from: u */
    private InterfaceC7311a f33952u = new d(this);

    /* renamed from: com.huawei.openalliance.ad.inter.g$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f33953a;

        public AnonymousClass1(int i10) {
            i = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7309g.this.f33943l.m40035b(System.currentTimeMillis());
            if (C7309g.this.f33934c != null) {
                C7309g.this.f33934c.onAdFailed(i);
            }
            if (C7309g.this.f33946o != null) {
                C7309g.this.f33946o.mo45001a(i);
            }
            C6923d.m39129a(C7309g.this.f33933b, i, C7309g.this.f33942k, 12, (Map) null, C7309g.this.f33943l);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.g$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Map f33955a;

        public AnonymousClass2(Map map) {
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7309g.this.f33943l.m40035b(System.currentTimeMillis());
            if (C7309g.this.f33934c != null) {
                C7309g.this.f33934c.onAdLoaded();
            }
            if (C7309g.this.f33946o != null) {
                C7309g.this.f33946o.mo45013a(map);
            }
            C6923d.m39129a(C7309g.this.f33933b, 200, C7309g.this.f33942k, 12, map, C7309g.this.f33943l);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.g$3 */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f33957a;

        public AnonymousClass3(long j10) {
            j = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            System.currentTimeMillis();
            C7309g.this.f33943l.m40045d(System.currentTimeMillis() - j);
            AdSlotParam.Builder builder = new AdSlotParam.Builder();
            C7309g.this.m44984a(builder);
            C7544ol c7544ol = new C7544ol(C7309g.this.f33933b);
            c7544ol.mo46335a(C7309g.this.f33943l);
            AdContentRsp adContentRspM46337b = c7544ol.m46337b(builder.build());
            if (adContentRspM46337b != null) {
                C7309g.this.f33942k = adContentRspM46337b.m40851k();
            }
            C7309g.this.f33943l.m40070u().m39572h(System.currentTimeMillis());
            C7309g.this.f33944m.m46666a(adContentRspM46337b);
            C7309g.this.f33932a = c.IDLE;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.g$a */
    public static class a implements Serializable, Comparator<InterfaceC7299b> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(InterfaceC7299b interfaceC7299b, InterfaceC7299b interfaceC7299b2) {
            if (m45021a(interfaceC7299b.getBiddingInfo()) && !m45021a(interfaceC7299b2.getBiddingInfo())) {
                return -1;
            }
            if (m45021a(interfaceC7299b.getBiddingInfo()) && m45021a(interfaceC7299b2.getBiddingInfo())) {
                return (interfaceC7299b.getBiddingInfo().getPrice().floatValue() <= 0.0f || Float.compare(interfaceC7299b.getBiddingInfo().getPrice().floatValue(), interfaceC7299b2.getBiddingInfo().getPrice().floatValue()) >= 0) ? -1 : 1;
            }
            return 1;
        }

        /* renamed from: a */
        private boolean m45021a(BiddingInfo biddingInfo) {
            return (biddingInfo == null || biddingInfo.getPrice() == null) ? false : true;
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.g$b */
    public class b extends OAIDServiceManager.OaidResultCallback {
        public b() {
        }

        @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
        /* renamed from: a */
        public void mo44091a() {
            AbstractC7185ho.m43820b("InterstitialAdManager", "onOaidAcquireFailed " + System.currentTimeMillis());
            C7309g.this.m44999i();
        }

        @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
        /* renamed from: b */
        public int mo44093b() {
            return 12;
        }

        @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
        /* renamed from: a */
        public void mo44092a(String str, boolean z10) {
            AbstractC7185ho.m43820b("InterstitialAdManager", "onOaidAcquired " + System.currentTimeMillis());
            C7309g.this.m44992c(str);
            C7309g.this.m44987a(z10);
            C7309g.this.m44999i();
            AbstractC7807d.m48211a(C7309g.this.f33933b, str, z10);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.g$c */
    public enum c {
        IDLE,
        LOADING
    }

    /* renamed from: com.huawei.openalliance.ad.inter.g$d */
    public static class d implements InterfaceC7311a {

        /* renamed from: a */
        private WeakReference<C7309g> f33963a;

        public d(C7309g c7309g) {
            this.f33963a = new WeakReference<>(c7309g);
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a
        /* renamed from: a */
        public void mo38577a() {
            C7309g c7309g = this.f33963a.get();
            if (c7309g != null) {
                if (c7309g.f33934c != null) {
                    c7309g.f33934c.onAdOpened();
                }
                if (c7309g.f33938g != null) {
                    c7309g.f33938g.onAdShown();
                }
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a
        /* renamed from: b */
        public void mo38579b() {
            C7309g c7309g = this.f33963a.get();
            if (c7309g != null) {
                if (c7309g.f33934c != null) {
                    c7309g.f33934c.onAdClicked();
                }
                if (c7309g.f33938g != null) {
                    c7309g.f33938g.onAdClicked();
                }
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a
        /* renamed from: c */
        public void mo38580c() {
            C7309g c7309g = this.f33963a.get();
            if (c7309g == null || c7309g.f33938g == null) {
                return;
            }
            c7309g.f33938g.onAdCompleted();
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a
        /* renamed from: d */
        public void mo38581d() {
            C7309g c7309g = this.f33963a.get();
            if (c7309g != null) {
                if (c7309g.f33934c != null) {
                    c7309g.f33934c.onAdClosed();
                }
                if (c7309g.f33938g != null) {
                    c7309g.f33938g.onAdClosed();
                }
            }
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a
        /* renamed from: e */
        public void mo38582e() {
            C7309g c7309g = this.f33963a.get();
            if (c7309g == null || c7309g.f33934c == null) {
                return;
            }
            c7309g.f33934c.onAdLeave();
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a
        /* renamed from: f */
        public void mo38583f() {
            C7309g c7309g = this.f33963a.get();
            if (c7309g == null || c7309g.f33934c == null) {
                return;
            }
            c7309g.f33934c.onVideoStarted();
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.InterfaceC7311a
        /* renamed from: a */
        public void mo38578a(int i10, int i11) {
            C7309g c7309g = this.f33963a.get();
            if (c7309g != null) {
                if (c7309g.f33934c != null) {
                    c7309g.f33934c.onAdFailed(i10);
                }
                if (c7309g.f33938g != null) {
                    c7309g.f33938g.onAdError(i10, i11);
                }
            }
        }
    }

    public C7309g(Context context) {
        this.f33933b = context;
        this.f33944m = new C7564oy(context, this);
    }

    /* renamed from: i */
    public void m44999i() {
        AbstractC7834m.m48480a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.g.3

            /* renamed from: a */
            final /* synthetic */ long f33957a;

            public AnonymousClass3(long j10) {
                j = j10;
            }

            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                C7309g.this.f33943l.m40045d(System.currentTimeMillis() - j);
                AdSlotParam.Builder builder = new AdSlotParam.Builder();
                C7309g.this.m44984a(builder);
                C7544ol c7544ol = new C7544ol(C7309g.this.f33933b);
                c7544ol.mo46335a(C7309g.this.f33943l);
                AdContentRsp adContentRspM46337b = c7544ol.m46337b(builder.build());
                if (adContentRspM46337b != null) {
                    C7309g.this.f33942k = adContentRspM46337b.m40851k();
                }
                C7309g.this.f33943l.m40070u().m39572h(System.currentTimeMillis());
                C7309g.this.f33944m.m46666a(adContentRspM46337b);
                C7309g.this.f33932a = c.IDLE;
            }
        }, AbstractC7834m.a.NETWORK, false);
    }

    /* renamed from: g */
    public BiddingInfo m45020g() {
        BiddingInfo biddingInfo = this.f33951t;
        return biddingInfo == null ? new BiddingInfo() : biddingInfo;
    }

    /* renamed from: c */
    public void m44992c(String str) {
        this.f33939h = str;
    }

    /* renamed from: h */
    private boolean m44998h() {
        if (!AbstractC7741ao.m47562b(this.f33933b)) {
            InterstitialAdListener interstitialAdListener = this.f33934c;
            if (interstitialAdListener != null) {
                interstitialAdListener.onAdFailed(1001);
            }
            return false;
        }
        if (this.f33932a == c.LOADING) {
            AbstractC7185ho.m43820b("InterstitialAdManager", "waiting for request finish");
            InterstitialAdListener interstitialAdListener2 = this.f33934c;
            if (interstitialAdListener2 != null) {
                interstitialAdListener2.onAdFailed(1101);
            }
            return false;
        }
        if (!TextUtils.isEmpty(this.f33935d)) {
            return true;
        }
        AbstractC7185ho.m43823c("InterstitialAdManager", "empty ad ids");
        InterstitialAdListener interstitialAdListener3 = this.f33934c;
        if (interstitialAdListener3 != null) {
            interstitialAdListener3.onAdFailed(-4);
        }
        return false;
    }

    /* renamed from: a */
    public final InterstitialAdListener m45000a() {
        return this.f33934c;
    }

    /* renamed from: b */
    public final String m45014b() {
        return this.f33935d;
    }

    /* renamed from: d */
    public final boolean m45017d() {
        return this.f33932a == c.LOADING;
    }

    /* renamed from: e */
    public final Bundle m45018e() {
        Bundle bundle = this.f33941j;
        return bundle == null ? new Bundle() : bundle;
    }

    /* renamed from: f */
    public final void m45019f() {
        AbstractC7185ho.m43821b("InterstitialAdManager", "show, adlist= %s", Boolean.valueOf(this.f33947p.isEmpty()));
        for (InterfaceC7299b interfaceC7299b : this.f33947p) {
            if (interfaceC7299b != null && !interfaceC7299b.mo44678b_()) {
                VideoConfiguration videoConfiguration = this.f33950s;
                if (videoConfiguration != null) {
                    interfaceC7299b.mo44677a(videoConfiguration);
                }
                interfaceC7299b.setRewardVerifyConfig(this.f33948q);
                interfaceC7299b.mo44676a(this.f33933b, this.f33952u);
                return;
            }
        }
    }

    /* renamed from: c */
    public final boolean m45016c() {
        if (AbstractC7760bg.m47767a(this.f33947p)) {
            return false;
        }
        for (InterfaceC7299b interfaceC7299b : this.f33947p) {
            if (interfaceC7299b != null && !interfaceC7299b.mo44678b_()) {
                m45005a(interfaceC7299b.getBiddingInfo());
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public void m45015b(String str) {
        this.f33936e = str;
    }

    /* renamed from: b */
    private void m44990b(Map<String, List<InterfaceC7299b>> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (List<InterfaceC7299b> list : map.values()) {
            if (!AbstractC7760bg.m47767a(list)) {
                for (InterfaceC7299b interfaceC7299b : list) {
                    if (interfaceC7299b.isExpired() || !interfaceC7299b.mo44679c_()) {
                        AbstractC7185ho.m43820b("InterstitialAdManager", "ad is invalid, content id:" + interfaceC7299b.getContentId());
                    } else {
                        this.f33947p.add(interfaceC7299b);
                    }
                }
                Collections.sort(this.f33947p, new a());
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.C7564oy.a
    /* renamed from: a */
    public void mo45001a(int i10) {
        AbstractC7185ho.m43821b("InterstitialAdManager", "onAdFailed: %s", Integer.valueOf(i10));
        this.f33943l.m40070u().m39574i(System.currentTimeMillis());
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.g.1

            /* renamed from: a */
            final /* synthetic */ int f33953a;

            public AnonymousClass1(int i102) {
                i = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7309g.this.f33943l.m40035b(System.currentTimeMillis());
                if (C7309g.this.f33934c != null) {
                    C7309g.this.f33934c.onAdFailed(i);
                }
                if (C7309g.this.f33946o != null) {
                    C7309g.this.f33946o.mo45001a(i);
                }
                C6923d.m39129a(C7309g.this.f33933b, i, C7309g.this.f33942k, 12, (Map) null, C7309g.this.f33943l);
            }
        });
    }

    /* renamed from: a */
    public void m45002a(Location location) {
        this.f33937f = location;
    }

    /* renamed from: a */
    public void m45003a(VideoConfiguration videoConfiguration) {
        this.f33950s = videoConfiguration;
    }

    /* renamed from: a */
    public void m44984a(AdSlotParam.Builder builder) {
        ArrayList arrayList = new ArrayList(1);
        int iM48577k = C7845x.m48577k(this.f33933b);
        arrayList.add(this.f33935d);
        builder.setAdIds(arrayList).setDeviceType(iM48577k).setTest(false).setOrientation(this.f33933b.getResources().getConfiguration().orientation != 1 ? 0 : 1).setWidth(AbstractC7807d.m48229d(this.f33933b)).setHeight(AbstractC7807d.m48233e(this.f33933b)).setOaid(this.f33939h).setTrackLimited(this.f33940i).setRequestOptions(this.f33945n).setContentBundle(this.f33936e).setLocation(this.f33937f);
        Integer num = this.f33949r;
        if (num != null) {
            builder.m40710c(num);
        }
    }

    /* renamed from: a */
    public final void m45004a(RequestOptions requestOptions) {
        this.f33943l.m40028a(System.currentTimeMillis());
        AbstractC7185ho.m43820b("InterstitialAdManager", ApiNames.LOAD_AD);
        if (!AbstractC7741ao.m47562b(this.f33933b)) {
            mo45001a(1001);
            return;
        }
        if (requestOptions != null && m44998h()) {
            this.f33945n = requestOptions;
            C7762bi.m47788b(this.f33933b.getApplicationContext(), requestOptions);
            C7095ek.m42934a(this.f33933b).m42944e();
            this.f33932a = c.LOADING;
            this.f33947p.clear();
            Pair<String, Boolean> pairM48217b = AbstractC7807d.m48217b(this.f33933b, true);
            if (pairM48217b == null && C6982bz.m41158h(this.f33933b)) {
                AbstractC7185ho.m43820b("InterstitialAdManager", "start to request oaid " + System.currentTimeMillis());
                OAIDServiceManager.getInstance(this.f33933b).requireOaid(new b());
                return;
            }
            if (pairM48217b != null) {
                AbstractC7185ho.m43820b("InterstitialAdManager", "use cached oaid " + System.currentTimeMillis());
                m44992c((String) pairM48217b.first);
                m44987a(((Boolean) pairM48217b.second).booleanValue());
            }
            m44999i();
        }
    }

    /* renamed from: a */
    public void m45005a(BiddingInfo biddingInfo) {
        this.f33951t = biddingInfo;
    }

    /* renamed from: a */
    public void m45006a(RewardVerifyConfig rewardVerifyConfig) {
        this.f33948q = rewardVerifyConfig;
    }

    /* renamed from: a */
    public final void m45007a(IRewardAdStatusListener iRewardAdStatusListener) {
        if (this.f33938g != null) {
            AbstractC7185ho.m43820b("InterstitialAdManager", "Update rewarded video listener.");
        }
        this.f33938g = iRewardAdStatusListener;
    }

    /* renamed from: a */
    public final void m45008a(InterstitialAdListener interstitialAdListener) {
        this.f33934c = interstitialAdListener;
    }

    /* renamed from: a */
    public void m45009a(C7564oy.a aVar) {
        this.f33946o = aVar;
    }

    /* renamed from: a */
    public void m45010a(Integer num) {
        this.f33949r = num;
    }

    /* renamed from: a */
    public final void m45011a(String str) {
        this.f33935d = str;
    }

    /* renamed from: a */
    public void m45012a(List<InterfaceC7299b> list) {
        this.f33947p = list;
    }

    @Override // com.huawei.openalliance.p169ad.C7564oy.a
    /* renamed from: a */
    public void mo45013a(Map<String, List<InterfaceC7299b>> map) {
        m44990b(map);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onAdsLoaded, size:");
        sb2.append(map != null ? Integer.valueOf(map.size()) : null);
        AbstractC7185ho.m43820b("InterstitialAdManager", sb2.toString());
        this.f33943l.m40070u().m39574i(System.currentTimeMillis());
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.g.2

            /* renamed from: a */
            final /* synthetic */ Map f33955a;

            public AnonymousClass2(Map map2) {
                map = map2;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7309g.this.f33943l.m40035b(System.currentTimeMillis());
                if (C7309g.this.f33934c != null) {
                    C7309g.this.f33934c.onAdLoaded();
                }
                if (C7309g.this.f33946o != null) {
                    C7309g.this.f33946o.mo45013a(map);
                }
                C6923d.m39129a(C7309g.this.f33933b, 200, C7309g.this.f33942k, 12, map, C7309g.this.f33943l);
            }
        });
        C7727aa.m47424b(this.f33933b, map2);
    }

    /* renamed from: a */
    public void m44987a(boolean z10) {
        this.f33940i = Boolean.valueOf(z10);
    }
}
