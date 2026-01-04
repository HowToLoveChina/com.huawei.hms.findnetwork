package com.huawei.openalliance.p169ad.inter;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7084e;
import com.huawei.openalliance.p169ad.C7095ek;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7544ol;
import com.huawei.openalliance.p169ad.C7571pe;
import com.huawei.openalliance.p169ad.InterfaceC7617qs;
import com.huawei.openalliance.p169ad.analysis.C6923d;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.inner.AdContentData;
import com.huawei.openalliance.p169ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.inter.AdParseConfig;
import com.huawei.openalliance.p169ad.inter.data.C7302e;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.listeners.ContentIdListener;
import com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener;
import com.huawei.openalliance.p169ad.opendeviceidentifier.OAIDServiceManager;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7762bi;
import com.huawei.openalliance.p169ad.utils.C7765bl;
import com.huawei.openalliance.p169ad.utils.C7780c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@OuterVisible
/* loaded from: classes2.dex */
public class NativeAdLoader implements INativeAdLoader, C7571pe.a {

    /* renamed from: b */
    private static final String f33389b = "NativeAdLoader";

    /* renamed from: A */
    private String f33390A;

    /* renamed from: a */
    boolean f33391a;

    /* renamed from: c */
    private EnumC7273a f33392c;

    /* renamed from: d */
    private Context f33393d;

    /* renamed from: e */
    private final String[] f33394e;

    /* renamed from: f */
    private String f33395f;

    /* renamed from: g */
    private Boolean f33396g;

    /* renamed from: h */
    private NativeAdListener f33397h;

    /* renamed from: i */
    private InterfaceC7617qs f33398i;

    /* renamed from: j */
    private String f33399j;

    /* renamed from: k */
    private int f33400k;

    /* renamed from: l */
    private List<String> f33401l;

    /* renamed from: m */
    private RequestOptions f33402m;

    /* renamed from: n */
    private String f33403n;

    /* renamed from: o */
    private Location f33404o;

    /* renamed from: p */
    private String f33405p;

    /* renamed from: q */
    private DelayInfo f33406q;

    /* renamed from: r */
    private Integer f33407r;

    /* renamed from: s */
    private List<Integer> f33408s;

    /* renamed from: t */
    private boolean f33409t;

    /* renamed from: u */
    private Integer f33410u;

    /* renamed from: v */
    private Integer f33411v;

    /* renamed from: w */
    private Integer f33412w;

    /* renamed from: x */
    private Integer f33413x;

    /* renamed from: y */
    private Integer f33414y;

    /* renamed from: z */
    private int f33415z;

    /* renamed from: com.huawei.openalliance.ad.inter.NativeAdLoader$1 */
    public class C72681 extends OAIDServiceManager.OaidResultCallback {

        /* renamed from: a */
        final /* synthetic */ int f33416a;

        /* renamed from: b */
        final /* synthetic */ String f33417b;

        /* renamed from: c */
        final /* synthetic */ boolean f33418c;

        public C72681(int i10, String str, boolean z10) {
            i = i10;
            str = str;
            z = z10;
        }

        @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
        /* renamed from: a */
        public void mo44091a() {
            AbstractC7185ho.m43820b(NativeAdLoader.f33389b, "onOaidAcquireFailed " + System.currentTimeMillis());
            NativeAdLoader.this.m44099a(i, str, z);
        }

        @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
        /* renamed from: b */
        public int mo44093b() {
            return NativeAdLoader.this.f33400k;
        }

        @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
        /* renamed from: a */
        public void mo44092a(String str, boolean z10) {
            AbstractC7185ho.m43820b(NativeAdLoader.f33389b, "onOaidAcquired " + System.currentTimeMillis());
            NativeAdLoader.this.m44104a(str);
            NativeAdLoader.this.m44103a(Boolean.valueOf(z10));
            NativeAdLoader.this.m44099a(i, str, z);
            AbstractC7807d.m48211a(NativeAdLoader.this.f33393d, str, z10);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.NativeAdLoader$2 */
    public class RunnableC72692 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f33420a;

        /* renamed from: b */
        final /* synthetic */ int f33421b;

        /* renamed from: c */
        final /* synthetic */ String f33422c;

        /* renamed from: d */
        final /* synthetic */ boolean f33423d;

        public RunnableC72692(long j10, int i10, String str, boolean z10) {
            j = j10;
            i = i10;
            str = str;
            z = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            NativeAdLoader.this.f33406q.m40045d(jCurrentTimeMillis - j);
            AbstractC7185ho.m43820b(NativeAdLoader.f33389b, "doRequestAd " + jCurrentTimeMillis);
            AdSlotParam.Builder builder = new AdSlotParam.Builder();
            builder.setAdIds(Arrays.asList(NativeAdLoader.this.f33394e)).setDeviceType(i).setRequestSequence(str).setOrientation(1).setWidth(AbstractC7807d.m48229d(NativeAdLoader.this.f33393d)).setHeight(AbstractC7807d.m48233e(NativeAdLoader.this.f33393d)).setOaid(NativeAdLoader.this.f33395f).setTrackLimited(NativeAdLoader.this.f33396g).setTest(z).setRequestOptions(NativeAdLoader.this.f33402m).setLocation(NativeAdLoader.this.f33404o).m40705a(NativeAdLoader.this.f33407r).m40709b(NativeAdLoader.this.f33410u).setDetailedCreativeTypeList(NativeAdLoader.this.f33408s).setContentBundle(NativeAdLoader.this.f33403n).setMaxCount(NativeAdLoader.this.f33415z).m40707a(NativeAdLoader.this.f33409t);
            if (NativeAdLoader.this.f33411v != null && NativeAdLoader.this.f33412w != null) {
                builder.setAdWidth(NativeAdLoader.this.f33411v);
                builder.setAdHeight(NativeAdLoader.this.f33412w);
            }
            if (NativeAdLoader.this.f33413x != null) {
                builder.m40710c(NativeAdLoader.this.f33413x);
            }
            if (NativeAdLoader.this.f33414y != null) {
                builder.setTotalDuration(NativeAdLoader.this.f33414y.intValue());
            }
            if (NativeAdLoader.this.f33390A != null) {
                builder.m40706a(NativeAdLoader.this.f33390A);
            }
            C7544ol c7544ol = new C7544ol(NativeAdLoader.this.f33393d);
            c7544ol.mo46335a(NativeAdLoader.this.f33406q);
            AdContentRsp adContentRspM46330a = c7544ol.m46330a(NativeAdLoader.this.f33393d, builder.build(), NativeAdLoader.this.f33399j, NativeAdLoader.this.f33400k, NativeAdLoader.this.f33401l);
            if (adContentRspM46330a != null) {
                NativeAdLoader.this.f33405p = adContentRspM46330a.m40851k();
            }
            AbstractC7185ho.m43820b(NativeAdLoader.f33389b, "doRequestAd, ad loaded,adType is " + NativeAdLoader.this.f33400k + ",cacheContentIds is " + NativeAdLoader.this.f33401l);
            NativeAdLoader.this.f33406q.m40070u().m39572h(System.currentTimeMillis());
            NativeAdLoader.this.f33398i.mo46734a(adContentRspM46330a, jCurrentTimeMillis, new AdParseConfig.Builder().build());
            NativeAdLoader.this.f33392c = EnumC7273a.IDLE;
            NativeAdLoader.this.m44108b();
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.NativeAdLoader$3 */
    public class RunnableC72703 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f33425a;

        /* renamed from: b */
        final /* synthetic */ Map f33426b;

        public RunnableC72703(long j10, Map map) {
            j = j10;
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeAdListener nativeAdListener = NativeAdLoader.this.f33397h;
            long jCurrentTimeMillis = System.currentTimeMillis();
            NativeAdLoader.this.f33406q.m40035b(jCurrentTimeMillis);
            long j10 = jCurrentTimeMillis - j;
            NativeAdLoader.this.f33406q.m40054g(j10);
            AbstractC7185ho.m43821b(NativeAdLoader.f33389b, "onAdsLoaded main thread switch: %s ms", Long.valueOf(j10));
            if (nativeAdListener != null) {
                nativeAdListener.onAdsLoaded(map);
            }
            C6923d.m39129a(NativeAdLoader.this.f33393d, 200, NativeAdLoader.this.f33405p, NativeAdLoader.this.f33400k, map, NativeAdLoader.this.f33406q);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.NativeAdLoader$4 */
    public class RunnableC72714 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Map f33428a;

        public RunnableC72714(Map map) {
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeAdLoader.this.m44111c((Map<String, List<INativeAd>>) map);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.NativeAdLoader$5 */
    public class RunnableC72725 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f33430a;

        /* renamed from: b */
        final /* synthetic */ int f33431b;

        public RunnableC72725(long j10, int i10) {
            j = j10;
            i = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            NativeAdListener nativeAdListener = NativeAdLoader.this.f33397h;
            long jCurrentTimeMillis = System.currentTimeMillis();
            NativeAdLoader.this.f33406q.m40035b(jCurrentTimeMillis);
            long j10 = jCurrentTimeMillis - j;
            NativeAdLoader.this.f33406q.m40054g(j10);
            AbstractC7185ho.m43821b(NativeAdLoader.f33389b, "onAdFailed main thread switch: %s ms", Long.valueOf(j10));
            if (nativeAdListener != null) {
                nativeAdListener.onAdFailed(i);
            }
            C6923d.m39129a(NativeAdLoader.this.f33393d, i, NativeAdLoader.this.f33405p, NativeAdLoader.this.f33400k, (Map) null, NativeAdLoader.this.f33406q);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.NativeAdLoader$a */
    public enum EnumC7273a {
        IDLE,
        LOADING
    }

    @OuterVisible
    public NativeAdLoader(Context context, String[] strArr) {
        this(context, strArr, false);
    }

    /* renamed from: d */
    private List<AdContentData> m44112d(Map<String, List<INativeAd>> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<INativeAd>> entry : map.entrySet()) {
            if (entry != null && !AbstractC7760bg.m47767a(entry.getValue())) {
                for (INativeAd iNativeAd : entry.getValue()) {
                    if (iNativeAd instanceof C7302e) {
                        C7302e c7302e = (C7302e) iNativeAd;
                        if (99 == c7302e.getCreativeType()) {
                            arrayList.add(c7302e.m44669v());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.huawei.openalliance.p169ad.inter.INativeAdLoader
    @OuterVisible
    public void enableDirectCacheVideo(boolean z10) {
        InterfaceC7617qs interfaceC7617qs = this.f33398i;
        if (interfaceC7617qs != null) {
            interfaceC7617qs.mo46740c(z10);
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.INativeAdLoader
    @OuterVisible
    public void enableDirectReturnVideoAd(boolean z10) {
        InterfaceC7617qs interfaceC7617qs = this.f33398i;
        if (interfaceC7617qs != null) {
            interfaceC7617qs.mo46736a(z10);
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.INativeAdLoader
    public void loadAds(int i10, String str, boolean z10) {
        int i11;
        RequestOptions requestOptions;
        this.f33406q.m40028a(System.currentTimeMillis());
        String str2 = f33389b;
        AbstractC7185ho.m43820b(str2, "loadAds");
        if (AbstractC7741ao.m47562b(this.f33393d)) {
            EnumC7273a enumC7273a = EnumC7273a.LOADING;
            if (enumC7273a == this.f33392c) {
                AbstractC7185ho.m43820b(str2, "waiting for request finish");
                i11 = 701;
            } else {
                String[] strArr = this.f33394e;
                if (strArr == null || strArr.length == 0) {
                    AbstractC7185ho.m43823c(str2, "empty ad ids");
                    i11 = 702;
                } else {
                    if (this.f33400k != 13 || ((requestOptions = this.f33402m) != null && !TextUtils.isEmpty(requestOptions.getSearchTerm()))) {
                        C7762bi.m47788b(this.f33393d, this.f33402m);
                        C7095ek.m42934a(this.f33393d).m42944e();
                        this.f33392c = enumC7273a;
                        Pair<String, Boolean> pairM48217b = AbstractC7807d.m48217b(this.f33393d, true);
                        if (pairM48217b == null && C7124fh.m43316b(this.f33393d).mo43405bf() && C6982bz.m41158h(this.f33393d)) {
                            AbstractC7185ho.m43820b(str2, "start to request oaid " + System.currentTimeMillis());
                            OAIDServiceManager.getInstance(this.f33393d).requireOaid(new OAIDServiceManager.OaidResultCallback() { // from class: com.huawei.openalliance.ad.inter.NativeAdLoader.1

                                /* renamed from: a */
                                final /* synthetic */ int f33416a;

                                /* renamed from: b */
                                final /* synthetic */ String f33417b;

                                /* renamed from: c */
                                final /* synthetic */ boolean f33418c;

                                public C72681(int i102, String str3, boolean z102) {
                                    i = i102;
                                    str = str3;
                                    z = z102;
                                }

                                @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
                                /* renamed from: a */
                                public void mo44091a() {
                                    AbstractC7185ho.m43820b(NativeAdLoader.f33389b, "onOaidAcquireFailed " + System.currentTimeMillis());
                                    NativeAdLoader.this.m44099a(i, str, z);
                                }

                                @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
                                /* renamed from: b */
                                public int mo44093b() {
                                    return NativeAdLoader.this.f33400k;
                                }

                                @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
                                /* renamed from: a */
                                public void mo44092a(String str3, boolean z102) {
                                    AbstractC7185ho.m43820b(NativeAdLoader.f33389b, "onOaidAcquired " + System.currentTimeMillis());
                                    NativeAdLoader.this.m44104a(str3);
                                    NativeAdLoader.this.m44103a(Boolean.valueOf(z102));
                                    NativeAdLoader.this.m44099a(i, str, z);
                                    AbstractC7807d.m48211a(NativeAdLoader.this.f33393d, str3, z102);
                                }
                            });
                            return;
                        }
                        if (pairM48217b != null) {
                            AbstractC7185ho.m43820b(str2, "use cached oaid " + System.currentTimeMillis());
                            m44104a((String) pairM48217b.first);
                            m44103a((Boolean) pairM48217b.second);
                        }
                        m44099a(i102, str3, z102);
                        return;
                    }
                    AbstractC7185ho.m43823c(str2, "search ad's searchTerm is empty");
                    i11 = 1000;
                }
            }
        } else {
            i11 = 1001;
        }
        mo44135a(i11);
    }

    @Override // com.huawei.openalliance.p169ad.inter.INativeAdLoader
    public void setAdHeight(Integer num) {
        this.f33412w = num;
    }

    @Override // com.huawei.openalliance.p169ad.inter.INativeAdLoader
    public void setAdWidth(Integer num) {
        this.f33411v = num;
    }

    @Override // com.huawei.openalliance.p169ad.inter.INativeAdLoader
    public void setAdsReturnedFromThread(boolean z10) {
        this.f33391a = z10;
    }

    @Override // com.huawei.openalliance.p169ad.inter.INativeAdLoader
    public void setAudioTotalDuration(Integer num) {
        this.f33414y = num;
    }

    @Override // com.huawei.openalliance.p169ad.inter.INativeAdLoader
    public void setContentBundle(String str) {
        this.f33403n = str;
    }

    @Override // com.huawei.openalliance.p169ad.inter.INativeAdLoader
    public void setContentIdListener(ContentIdListener contentIdListener) {
        InterfaceC7617qs interfaceC7617qs = this.f33398i;
        if (interfaceC7617qs != null) {
            interfaceC7617qs.mo46735a(contentIdListener);
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.INativeAdLoader
    @OuterVisible
    public void setDetailedCreativeType(List<Integer> list) {
        this.f33408s = list;
    }

    @Override // com.huawei.openalliance.p169ad.inter.INativeAdLoader
    public void setExtraInfo(String str) {
        this.f33399j = str;
    }

    @Override // com.huawei.openalliance.p169ad.inter.INativeAdLoader
    public void setIsSmart(Integer num) {
        this.f33410u = num;
    }

    @Override // com.huawei.openalliance.p169ad.inter.INativeAdLoader
    @OuterVisible
    public void setJssdkVersion(String str) {
        AbstractC7185ho.m43821b(f33389b, "setJssdkVersion: %s", str);
        this.f33390A = str;
    }

    @Override // com.huawei.openalliance.p169ad.inter.INativeAdLoader
    public void setListener(NativeAdListener nativeAdListener) {
        this.f33397h = nativeAdListener;
    }

    @Override // com.huawei.openalliance.p169ad.inter.INativeAdLoader
    public void setLocation(Location location) {
        this.f33404o = location;
    }

    @Override // com.huawei.openalliance.p169ad.inter.INativeAdLoader
    public void setMaxAdNumbers(int i10) {
        this.f33415z = i10;
    }

    @Override // com.huawei.openalliance.p169ad.inter.INativeAdLoader
    public void setRequestOptions(RequestOptions requestOptions) {
        this.f33402m = requestOptions;
    }

    @Override // com.huawei.openalliance.p169ad.inter.INativeAdLoader
    @OuterVisible
    public void setSupportTptAd(boolean z10) {
        AbstractC7185ho.m43821b(f33389b, "setSupportTptAd: %s", Boolean.valueOf(z10));
        this.f33409t = z10;
    }

    @OuterVisible
    public NativeAdLoader(Context context, String[] strArr, int i10, List<String> list) {
        this(context, strArr, false);
        this.f33400k = i10;
        this.f33401l = list;
        InterfaceC7617qs interfaceC7617qs = this.f33398i;
        if (interfaceC7617qs != null) {
            interfaceC7617qs.mo46733a(i10);
        }
    }

    /* renamed from: c */
    public boolean m44111c(Map<String, List<INativeAd>> map) {
        if (C7765bl.m47802a(map)) {
            AbstractC7185ho.m43817a(f33389b, "nativeAdsMap is empty");
            return false;
        }
        List<AdContentData> listM44112d = m44112d(map);
        if (AbstractC7760bg.m47767a(listM44112d)) {
            AbstractC7185ho.m43817a(f33389b, "tpt ads is empty");
            return false;
        }
        if (C7780c.m47861a() && C7084e.m42838b() != null) {
            try {
                String strM47742b = AbstractC7758be.m47742b(listM44112d);
                AbstractC7185ho.m43818a(f33389b, "contentJson : %s", strM47742b);
                if (this.f33398i == null) {
                    C7084e.m42838b().mo30524a(strM47742b, (Bundle) null);
                    return true;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean(ParamConstants.Param.DOWNLOAD_IN_DATA, this.f33398i.mo46737a());
                bundle.putBoolean("directCacheVideo", this.f33398i.mo46739b());
                C7084e.m42838b().mo30524a(strM47742b, bundle);
                return true;
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c(f33389b, "down err: %s", th2.getClass().getSimpleName());
            }
        }
        return false;
    }

    @Override // com.huawei.openalliance.p169ad.inter.INativeAdLoader
    public void loadAds(int i10, boolean z10) {
        loadAds(i10, null, z10);
    }

    @OuterVisible
    public NativeAdLoader(Context context, String[] strArr, boolean z10) {
        this.f33392c = EnumC7273a.IDLE;
        this.f33400k = 3;
        this.f33401l = null;
        this.f33406q = new DelayInfo();
        this.f33409t = false;
        if (!AbstractC7741ao.m47562b(context)) {
            this.f33394e = new String[0];
            return;
        }
        this.f33393d = context.getApplicationContext();
        if (strArr == null || strArr.length <= 0) {
            this.f33394e = new String[0];
        } else {
            String[] strArr2 = new String[strArr.length];
            this.f33394e = strArr2;
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        }
        C7571pe c7571pe = new C7571pe(this.f33393d, this, this.f33400k, false);
        this.f33398i = c7571pe;
        c7571pe.mo46738b(z10);
    }

    /* renamed from: b */
    public void m44108b() {
        IHiAdSplash hiAdSplash = HiAdSplash.getInstance(this.f33393d);
        if (hiAdSplash instanceof HiAdSplash) {
            HiAdSplash hiAdSplash2 = (HiAdSplash) hiAdSplash;
            long jMo43414bo = C7124fh.m43316b(this.f33393d).mo43414bo();
            long jM44088a = hiAdSplash2.m44088a();
            if (System.currentTimeMillis() - jM44088a >= jMo43414bo) {
                hiAdSplash2.preloadAd();
                return;
            }
            AbstractC7185ho.m43820b(f33389b, "request time limit, timeInter=" + jMo43414bo + ", lastTime=" + jM44088a);
        }
    }

    @Override // com.huawei.openalliance.p169ad.C7571pe.a
    /* renamed from: a */
    public void mo44135a(int i10) {
        String str = f33389b;
        AbstractC7185ho.m43820b(str, "onAdFailed, errorCode:" + i10);
        if (this.f33397h == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f33406q.m40070u().m39574i(jCurrentTimeMillis);
        if (!this.f33391a) {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.NativeAdLoader.5

                /* renamed from: a */
                final /* synthetic */ long f33430a;

                /* renamed from: b */
                final /* synthetic */ int f33431b;

                public RunnableC72725(long jCurrentTimeMillis2, int i102) {
                    j = jCurrentTimeMillis2;
                    i = i102;
                }

                @Override // java.lang.Runnable
                public void run() {
                    NativeAdListener nativeAdListener = NativeAdLoader.this.f33397h;
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    NativeAdLoader.this.f33406q.m40035b(jCurrentTimeMillis2);
                    long j10 = jCurrentTimeMillis2 - j;
                    NativeAdLoader.this.f33406q.m40054g(j10);
                    AbstractC7185ho.m43821b(NativeAdLoader.f33389b, "onAdFailed main thread switch: %s ms", Long.valueOf(j10));
                    if (nativeAdListener != null) {
                        nativeAdListener.onAdFailed(i);
                    }
                    C6923d.m39129a(NativeAdLoader.this.f33393d, i, NativeAdLoader.this.f33405p, NativeAdLoader.this.f33400k, (Map) null, NativeAdLoader.this.f33406q);
                }
            });
            return;
        }
        this.f33406q.m40035b(jCurrentTimeMillis2);
        AbstractC7185ho.m43820b(str, "onAdFailed thread");
        this.f33397h.onAdFailed(i102);
        C6923d.m39129a(this.f33393d, i102, this.f33405p, this.f33400k, (Map) null, this.f33406q);
    }

    /* renamed from: b */
    public void m44138b(Integer num) {
        this.f33413x = num;
        this.f33406q.m40042c(num);
    }

    /* renamed from: a */
    public void m44099a(int i10, String str, boolean z10) {
        AbstractC7834m.m48480a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.NativeAdLoader.2

            /* renamed from: a */
            final /* synthetic */ long f33420a;

            /* renamed from: b */
            final /* synthetic */ int f33421b;

            /* renamed from: c */
            final /* synthetic */ String f33422c;

            /* renamed from: d */
            final /* synthetic */ boolean f33423d;

            public RunnableC72692(long j10, int i102, String str2, boolean z102) {
                j = j10;
                i = i102;
                str = str2;
                z = z102;
            }

            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis = System.currentTimeMillis();
                NativeAdLoader.this.f33406q.m40045d(jCurrentTimeMillis - j);
                AbstractC7185ho.m43820b(NativeAdLoader.f33389b, "doRequestAd " + jCurrentTimeMillis);
                AdSlotParam.Builder builder = new AdSlotParam.Builder();
                builder.setAdIds(Arrays.asList(NativeAdLoader.this.f33394e)).setDeviceType(i).setRequestSequence(str).setOrientation(1).setWidth(AbstractC7807d.m48229d(NativeAdLoader.this.f33393d)).setHeight(AbstractC7807d.m48233e(NativeAdLoader.this.f33393d)).setOaid(NativeAdLoader.this.f33395f).setTrackLimited(NativeAdLoader.this.f33396g).setTest(z).setRequestOptions(NativeAdLoader.this.f33402m).setLocation(NativeAdLoader.this.f33404o).m40705a(NativeAdLoader.this.f33407r).m40709b(NativeAdLoader.this.f33410u).setDetailedCreativeTypeList(NativeAdLoader.this.f33408s).setContentBundle(NativeAdLoader.this.f33403n).setMaxCount(NativeAdLoader.this.f33415z).m40707a(NativeAdLoader.this.f33409t);
                if (NativeAdLoader.this.f33411v != null && NativeAdLoader.this.f33412w != null) {
                    builder.setAdWidth(NativeAdLoader.this.f33411v);
                    builder.setAdHeight(NativeAdLoader.this.f33412w);
                }
                if (NativeAdLoader.this.f33413x != null) {
                    builder.m40710c(NativeAdLoader.this.f33413x);
                }
                if (NativeAdLoader.this.f33414y != null) {
                    builder.setTotalDuration(NativeAdLoader.this.f33414y.intValue());
                }
                if (NativeAdLoader.this.f33390A != null) {
                    builder.m40706a(NativeAdLoader.this.f33390A);
                }
                C7544ol c7544ol = new C7544ol(NativeAdLoader.this.f33393d);
                c7544ol.mo46335a(NativeAdLoader.this.f33406q);
                AdContentRsp adContentRspM46330a = c7544ol.m46330a(NativeAdLoader.this.f33393d, builder.build(), NativeAdLoader.this.f33399j, NativeAdLoader.this.f33400k, NativeAdLoader.this.f33401l);
                if (adContentRspM46330a != null) {
                    NativeAdLoader.this.f33405p = adContentRspM46330a.m40851k();
                }
                AbstractC7185ho.m43820b(NativeAdLoader.f33389b, "doRequestAd, ad loaded,adType is " + NativeAdLoader.this.f33400k + ",cacheContentIds is " + NativeAdLoader.this.f33401l);
                NativeAdLoader.this.f33406q.m40070u().m39572h(System.currentTimeMillis());
                NativeAdLoader.this.f33398i.mo46734a(adContentRspM46330a, jCurrentTimeMillis, new AdParseConfig.Builder().build());
                NativeAdLoader.this.f33392c = EnumC7273a.IDLE;
                NativeAdLoader.this.m44108b();
            }
        }, AbstractC7834m.a.NETWORK, false);
    }

    /* renamed from: b */
    private void m44109b(Map<String, List<INativeAd>> map) {
        AbstractC7834m.m48484d(new Runnable() { // from class: com.huawei.openalliance.ad.inter.NativeAdLoader.4

            /* renamed from: a */
            final /* synthetic */ Map f33428a;

            public RunnableC72714(Map map2) {
                map = map2;
            }

            @Override // java.lang.Runnable
            public void run() {
                NativeAdLoader.this.m44111c((Map<String, List<INativeAd>>) map);
            }
        });
    }

    /* renamed from: a */
    public void m44103a(Boolean bool) {
        this.f33396g = bool;
    }

    /* renamed from: a */
    public void m44136a(Integer num) {
        this.f33407r = num;
    }

    /* renamed from: a */
    public void m44104a(String str) {
        this.f33395f = str;
    }

    @Override // com.huawei.openalliance.p169ad.C7571pe.a
    /* renamed from: a */
    public void mo44137a(Map<String, List<INativeAd>> map) {
        String str = f33389b;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onAdsLoaded, size:");
        sb2.append(map != null ? Integer.valueOf(map.size()) : null);
        sb2.append(", listener:");
        sb2.append(this.f33397h);
        AbstractC7185ho.m43820b(str, sb2.toString());
        if (this.f33397h == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f33406q.m40070u().m39574i(jCurrentTimeMillis);
        if (this.f33391a) {
            this.f33406q.m40035b(jCurrentTimeMillis);
            AbstractC7185ho.m43820b(str, "onAdsLoaded thread");
            this.f33397h.onAdsLoaded(map);
            C6923d.m39129a(this.f33393d, 200, this.f33405p, this.f33400k, map, this.f33406q);
        } else {
            AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.NativeAdLoader.3

                /* renamed from: a */
                final /* synthetic */ long f33425a;

                /* renamed from: b */
                final /* synthetic */ Map f33426b;

                public RunnableC72703(long jCurrentTimeMillis2, Map map2) {
                    j = jCurrentTimeMillis2;
                    map = map2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    NativeAdListener nativeAdListener = NativeAdLoader.this.f33397h;
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    NativeAdLoader.this.f33406q.m40035b(jCurrentTimeMillis2);
                    long j10 = jCurrentTimeMillis2 - j;
                    NativeAdLoader.this.f33406q.m40054g(j10);
                    AbstractC7185ho.m43821b(NativeAdLoader.f33389b, "onAdsLoaded main thread switch: %s ms", Long.valueOf(j10));
                    if (nativeAdListener != null) {
                        nativeAdListener.onAdsLoaded(map);
                    }
                    C6923d.m39129a(NativeAdLoader.this.f33393d, 200, NativeAdLoader.this.f33405p, NativeAdLoader.this.f33400k, map, NativeAdLoader.this.f33406q);
                }
            });
        }
        m44109b(map2);
    }
}
