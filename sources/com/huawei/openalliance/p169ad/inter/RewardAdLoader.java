package com.huawei.openalliance.p169ad.inter;

import android.content.Context;
import android.location.Location;
import android.util.Pair;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7095ek;
import com.huawei.openalliance.p169ad.C7544ol;
import com.huawei.openalliance.p169ad.C7581po;
import com.huawei.openalliance.p169ad.InterfaceC7619qu;
import com.huawei.openalliance.p169ad.analysis.C6923d;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.inter.data.IRewardAd;
import com.huawei.openalliance.p169ad.inter.listeners.RewardAdListener;
import com.huawei.openalliance.p169ad.opendeviceidentifier.OAIDServiceManager;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7727aa;
import com.huawei.openalliance.p169ad.utils.C7762bi;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@OuterVisible
/* loaded from: classes2.dex */
public class RewardAdLoader implements IRewardAdLoader, C7581po.a {

    /* renamed from: a */
    private Context f33493a;

    /* renamed from: b */
    private final String[] f33494b;

    /* renamed from: c */
    private InterfaceC7619qu f33495c;

    /* renamed from: e */
    private String f33497e;

    /* renamed from: f */
    private Boolean f33498f;

    /* renamed from: g */
    private RewardAdListener f33499g;

    /* renamed from: h */
    private RequestOptions f33500h;

    /* renamed from: i */
    private String f33501i;

    /* renamed from: j */
    private Location f33502j;

    /* renamed from: k */
    private String f33503k;

    /* renamed from: m */
    private Integer f33505m;

    /* renamed from: d */
    private EnumC7285b f33496d = EnumC7285b.IDLE;

    /* renamed from: l */
    private DelayInfo f33504l = new DelayInfo();

    /* renamed from: com.huawei.openalliance.ad.inter.RewardAdLoader$a */
    public class C7284a extends OAIDServiceManager.OaidResultCallback {

        /* renamed from: b */
        private int f33515b;

        /* renamed from: c */
        private boolean f33516c;

        public C7284a(int i10, boolean z10) {
            this.f33515b = i10;
            this.f33516c = z10;
        }

        @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
        /* renamed from: a */
        public void mo44091a() {
            AbstractC7185ho.m43820b("RewardAdLoader", "onOaidAcquireFailed " + System.currentTimeMillis());
            RewardAdLoader.this.m44190a(this.f33515b, this.f33516c);
        }

        @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
        /* renamed from: b */
        public int mo44093b() {
            return 7;
        }

        @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
        /* renamed from: a */
        public void mo44092a(String str, boolean z10) {
            AbstractC7185ho.m43820b("RewardAdLoader", "onOaidAcquired " + System.currentTimeMillis());
            RewardAdLoader.this.m44193a(str);
            RewardAdLoader.this.m44194a(z10);
            RewardAdLoader.this.m44190a(this.f33515b, this.f33516c);
            AbstractC7807d.m48211a(RewardAdLoader.this.f33493a, str, z10);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.RewardAdLoader$b */
    public enum EnumC7285b {
        IDLE,
        LOADING
    }

    @OuterVisible
    public RewardAdLoader(Context context, String[] strArr) {
        if (!AbstractC7741ao.m47562b(context)) {
            this.f33494b = new String[0];
            return;
        }
        this.f33493a = context.getApplicationContext();
        if (strArr == null || strArr.length <= 0) {
            this.f33494b = new String[0];
        } else {
            String[] strArr2 = new String[strArr.length];
            this.f33494b = strArr2;
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        }
        this.f33495c = new C7581po(context, this);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IRewardAdLoader
    @OuterVisible
    public void loadAds(int i10, boolean z10) {
        int i11;
        this.f33504l.m40028a(System.currentTimeMillis());
        AbstractC7185ho.m43820b("RewardAdLoader", "loadAds");
        if (AbstractC7741ao.m47562b(this.f33493a)) {
            EnumC7285b enumC7285b = EnumC7285b.LOADING;
            if (enumC7285b == this.f33496d) {
                AbstractC7185ho.m43820b("RewardAdLoader", "waiting for request finish");
                i11 = 901;
            } else {
                String[] strArr = this.f33494b;
                if (strArr != null && strArr.length != 0) {
                    C7095ek.m42934a(this.f33493a).m42944e();
                    C7762bi.m47788b(this.f33493a, this.f33500h);
                    this.f33496d = enumC7285b;
                    Pair<String, Boolean> pairM48217b = AbstractC7807d.m48217b(this.f33493a, true);
                    if (pairM48217b == null && C6982bz.m41158h(this.f33493a)) {
                        AbstractC7185ho.m43820b("RewardAdLoader", "start to request oaid " + System.currentTimeMillis());
                        OAIDServiceManager.getInstance(this.f33493a).requireOaid(new C7284a(i10, z10));
                        return;
                    }
                    if (pairM48217b != null) {
                        AbstractC7185ho.m43820b("RewardAdLoader", "use cached oaid " + System.currentTimeMillis());
                        m44193a((String) pairM48217b.first);
                        m44194a(((Boolean) pairM48217b.second).booleanValue());
                    }
                    m44190a(i10, z10);
                    return;
                }
                AbstractC7185ho.m43823c("RewardAdLoader", "empty ad ids");
                i11 = 902;
            }
        } else {
            i11 = 1001;
        }
        mo44207a(i11);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IRewardAdLoader
    @OuterVisible
    public void setContentBundle(String str) {
        this.f33501i = str;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IRewardAdLoader
    @OuterVisible
    public void setListener(RewardAdListener rewardAdListener) {
        this.f33499g = rewardAdListener;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IRewardAdLoader
    @OuterVisible
    public void setLocation(Location location) {
        this.f33502j = location;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IRewardAdLoader
    public void setRequestOptions(RequestOptions requestOptions) {
        this.f33500h = requestOptions;
    }

    @Override // com.huawei.openalliance.p169ad.C7581po.a
    /* renamed from: a */
    public void mo44207a(final int i10) {
        AbstractC7185ho.m43820b("RewardAdLoader", "onAdFailed, errorCode:" + i10);
        if (this.f33499g == null) {
            return;
        }
        this.f33504l.m40070u().m39574i(System.currentTimeMillis());
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.RewardAdLoader.3
            @Override // java.lang.Runnable
            public void run() {
                RewardAdListener rewardAdListener = RewardAdLoader.this.f33499g;
                RewardAdLoader.this.f33504l.m40035b(System.currentTimeMillis());
                if (rewardAdListener != null) {
                    rewardAdListener.onAdFailed(i10);
                }
                C6923d.m39129a(RewardAdLoader.this.f33493a, i10, RewardAdLoader.this.f33503k, 7, (Map) null, RewardAdLoader.this.f33504l);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m44190a(final int i10, final boolean z10) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        AbstractC7834m.m48480a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.RewardAdLoader.1
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7185ho.m43820b("RewardAdLoader", "doRequestAd " + System.currentTimeMillis());
                RewardAdLoader.this.f33504l.m40045d(System.currentTimeMillis() - jCurrentTimeMillis);
                AdSlotParam.Builder builder = new AdSlotParam.Builder();
                builder.setAdIds(Arrays.asList(RewardAdLoader.this.f33494b)).setDeviceType(i10).setOrientation(1).setWidth(AbstractC7807d.m48229d(RewardAdLoader.this.f33493a)).setHeight(AbstractC7807d.m48233e(RewardAdLoader.this.f33493a)).setOaid(RewardAdLoader.this.f33497e).setTrackLimited(RewardAdLoader.this.f33498f).setLocation(RewardAdLoader.this.f33502j).setRequestOptions(RewardAdLoader.this.f33500h).setTest(z10).setContentBundle(RewardAdLoader.this.f33501i);
                if (RewardAdLoader.this.f33505m != null) {
                    builder.m40710c(RewardAdLoader.this.f33505m);
                }
                C7544ol c7544ol = new C7544ol(RewardAdLoader.this.f33493a);
                c7544ol.mo46335a(RewardAdLoader.this.f33504l);
                AdContentRsp adContentRspM46331a = c7544ol.m46331a(builder.build());
                if (adContentRspM46331a != null) {
                    RewardAdLoader.this.f33503k = adContentRspM46331a.m40851k();
                }
                RewardAdLoader.this.f33504l.m40070u().m39572h(System.currentTimeMillis());
                RewardAdLoader.this.f33495c.mo46807a(adContentRspM46331a);
                RewardAdLoader.this.f33496d = EnumC7285b.IDLE;
            }
        }, AbstractC7834m.a.NETWORK, false);
    }

    /* renamed from: a */
    public void m44208a(Integer num) {
        this.f33505m = num;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m44193a(String str) {
        this.f33497e = str;
    }

    @Override // com.huawei.openalliance.p169ad.C7581po.a
    /* renamed from: a */
    public void mo44209a(final Map<String, List<IRewardAd>> map) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onAdsLoaded, size:");
        sb2.append(map != null ? Integer.valueOf(map.size()) : null);
        sb2.append(", listener:");
        sb2.append(this.f33499g);
        AbstractC7185ho.m43820b("RewardAdLoader", sb2.toString());
        if (this.f33499g == null) {
            return;
        }
        this.f33504l.m40070u().m39574i(System.currentTimeMillis());
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.RewardAdLoader.2
            @Override // java.lang.Runnable
            public void run() {
                RewardAdListener rewardAdListener = RewardAdLoader.this.f33499g;
                RewardAdLoader.this.f33504l.m40035b(System.currentTimeMillis());
                if (rewardAdListener != null) {
                    rewardAdListener.onAdsLoaded(map);
                }
                C6923d.m39129a(RewardAdLoader.this.f33493a, 200, RewardAdLoader.this.f33503k, 7, map, RewardAdLoader.this.f33504l);
            }
        });
        C7727aa.m47422a(this.f33493a, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m44194a(boolean z10) {
        this.f33498f = Boolean.valueOf(z10);
    }
}
