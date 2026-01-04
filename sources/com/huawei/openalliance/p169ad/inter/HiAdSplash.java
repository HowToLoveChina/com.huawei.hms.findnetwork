package com.huawei.openalliance.p169ad.inter;

import android.content.Context;
import android.util.Pair;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.AbstractC7573pg;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.C7008cy;
import com.huawei.openalliance.p169ad.C7011da;
import com.huawei.openalliance.p169ad.C7084e;
import com.huawei.openalliance.p169ad.C7095ek;
import com.huawei.openalliance.p169ad.C7103es;
import com.huawei.openalliance.p169ad.C7120fd;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.C7484ms;
import com.huawei.openalliance.p169ad.C7544ol;
import com.huawei.openalliance.p169ad.C7579pm;
import com.huawei.openalliance.p169ad.InterfaceC7135fs;
import com.huawei.openalliance.p169ad.InterfaceC7146gc;
import com.huawei.openalliance.p169ad.InterfaceC7609qk;
import com.huawei.openalliance.p169ad.InterfaceC7621qw;
import com.huawei.openalliance.p169ad.annotations.OuterVisible;
import com.huawei.openalliance.p169ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.p169ad.beans.server.AdContentRsp;
import com.huawei.openalliance.p169ad.constant.AdLoadMode;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.RTCMethods;
import com.huawei.openalliance.p169ad.ipc.CallResult;
import com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.p169ad.opendeviceidentifier.OAIDServiceManager;
import com.huawei.openalliance.p169ad.p171db.bean.ContentRecord;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import com.huawei.openalliance.p169ad.utils.AbstractC7758be;
import com.huawei.openalliance.p169ad.utils.AbstractC7760bg;
import com.huawei.openalliance.p169ad.utils.AbstractC7768bo;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7807d;
import com.huawei.openalliance.p169ad.utils.AbstractC7810dc;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7762bi;
import com.huawei.openalliance.p169ad.utils.C7794cn;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

@OuterVisible
/* loaded from: classes2.dex */
public final class HiAdSplash implements IHiAdSplash {

    /* renamed from: a */
    private static HiAdSplash f33354a;

    /* renamed from: b */
    private static final byte[] f33355b = new byte[0];

    /* renamed from: c */
    private Context f33356c;

    /* renamed from: d */
    private InterfaceC7146gc f33357d;

    /* renamed from: e */
    private InterfaceC7135fs f33358e;

    /* renamed from: f */
    private AdSlotParam f33359f;

    /* renamed from: g */
    private long f33360g;

    /* renamed from: h */
    private Integer f33361h = null;

    /* renamed from: com.huawei.openalliance.ad.inter.HiAdSplash$a */
    public static class C7266a implements InterfaceC7621qw {

        /* renamed from: a */
        private int f33387a;

        public C7266a(int i10) {
            this.f33387a = i10;
        }

        @Override // com.huawei.openalliance.p169ad.InterfaceC7621qw
        /* renamed from: a */
        public List<ContentRecord> mo44094a(AdContentRsp adContentRsp) {
            return new ArrayList(0);
        }

        @Override // com.huawei.openalliance.p169ad.InterfaceC7621qw
        /* renamed from: b */
        public List<ContentRecord> mo44095b(AdContentRsp adContentRsp) {
            return AbstractC7573pg.m46757a(adContentRsp, this.f33387a);
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.HiAdSplash$b */
    public static class C7267b implements InterfaceC7621qw {

        /* renamed from: a */
        private int f33388a;

        public C7267b(int i10) {
            this.f33388a = i10;
        }

        @Override // com.huawei.openalliance.p169ad.InterfaceC7621qw
        /* renamed from: a */
        public List<ContentRecord> mo44094a(AdContentRsp adContentRsp) {
            return AbstractC7573pg.m46759b(adContentRsp, this.f33388a);
        }

        @Override // com.huawei.openalliance.p169ad.InterfaceC7621qw
        /* renamed from: b */
        public List<ContentRecord> mo44095b(AdContentRsp adContentRsp) {
            return AbstractC7573pg.m46757a(adContentRsp, this.f33388a);
        }
    }

    private HiAdSplash(Context context) {
        this.f33356c = context.getApplicationContext();
        this.f33357d = C7124fh.m43316b(context);
        this.f33358e = C7103es.m43094a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m44081b(AdSlotParam adSlotParam, int i10) {
        AbstractC7185ho.m43817a("HiAdSplash", "do preload from sdk");
        C7544ol c7544ol = new C7544ol(this.f33356c);
        c7544ol.mo46336a(c7544ol.mo46329a(this.f33356c, adSlotParam, i10), adSlotParam, new C7267b(i10), (InterfaceC7609qk) null, this.f33360g, 1);
    }

    @OuterVisible
    public static IHiAdSplash getInstance(Context context) {
        return m44072a(context);
    }

    /* renamed from: a */
    public long m44088a() {
        return this.f33360g;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAdSplash
    public void dismissExSplash() {
        if (C6982bz.m41152b(this.f33356c)) {
            AbstractC7185ho.m43820b("HiAdSplash", RTCMethods.DISMISS_EXSPLASH);
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAdSplash.10
                @Override // java.lang.Runnable
                public void run() {
                    C7484ms.m45854a(HiAdSplash.this.f33356c).m45855a(RTCMethods.DISMISS_EXSPLASH, null, null, null);
                }
            });
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAdSplash
    public void dismissExSplashSlogan() {
        if (C6982bz.m41152b(this.f33356c)) {
            AbstractC7185ho.m43820b("HiAdSplash", RTCMethods.DISMISS_EXSPLASH_SLOGAN);
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAdSplash.8
                @Override // java.lang.Runnable
                public void run() {
                    C7484ms.m45854a(HiAdSplash.this.f33356c).m45855a(RTCMethods.DISMISS_EXSPLASH_SLOGAN, null, null, null);
                }
            });
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAdSplash
    public void enableLinkedVideo(final boolean z10) {
        if (C6982bz.m41152b(this.f33356c)) {
            AbstractC7185ho.m43820b("HiAdSplash", RTCMethods.ENABLE_LINKED_VIDEO);
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAdSplash.7
                @Override // java.lang.Runnable
                public void run() {
                    C7484ms.m45854a(HiAdSplash.this.f33356c).m45855a(RTCMethods.ENABLE_LINKED_VIDEO, String.valueOf(z10), null, null);
                }
            });
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAdSplash
    public Integer getAllowMobileTraffic() {
        return this.f33361h;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAdSplash
    public boolean isAvailable(AdSlotParam adSlotParam) {
        adSlotParam.m40648d(1);
        return m44083b(adSlotParam);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAdSplash
    public boolean isExSplashEnable(Context context) {
        return AbstractC7807d.m48257t(context);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAdSplash
    public boolean isSmartSplashAvailable(AdSlotParam adSlotParam) {
        adSlotParam.m40648d(18);
        return m44083b(adSlotParam);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAdSplash
    public void preloadAd() {
        preloadAd(this.f33359f);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAdSplash
    public void preloadSmartScreenAd() {
        preloadSmartScreenAd(this.f33359f);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAdSplash
    public void setAllowMobileTraffic(int i10) {
        this.f33361h = (i10 == 0 || i10 == 1) ? Integer.valueOf(i10) : null;
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAdSplash
    public void setDefaultSplashMode(int i10) {
        if (1 == i10 || 2 == i10) {
            C7124fh.m43316b(this.f33356c).mo43469k(i10);
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAdSplash
    public void setExSplashShowTime(final int i10) {
        if (C6982bz.m41152b(this.f33356c)) {
            AbstractC7185ho.m43820b("HiAdSplash", "setExSplashShowTime");
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAdSplash.2
                @Override // java.lang.Runnable
                public void run() {
                    C7484ms.m45854a(HiAdSplash.this.f33356c).m45855a(RTCMethods.SET_SPLASH_TIME, String.valueOf(i10), null, null);
                }
            });
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAdSplash
    public void setSloganDefTime(int i10) {
        if (AbstractC7741ao.m47562b(this.f33356c)) {
            if (i10 < 0 || i10 > 5000) {
                AbstractC7185ho.m43826d("HiAdSplash", "time is out limit");
            } else {
                this.f33357d.mo43427c(i10);
            }
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAdSplash
    public void setSloganShowTimeWhenNoAd(final int i10) {
        if (C6982bz.m41152b(this.f33356c)) {
            AbstractC7185ho.m43820b("HiAdSplash", "setSloganShowTimeWhenNoAd");
            AbstractC7834m.m48486f(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAdSplash.9
                @Override // java.lang.Runnable
                public void run() {
                    C7484ms.m45854a(HiAdSplash.this.f33356c).m45855a(RTCMethods.SET_SLOGAN_TIME_NO_AD, String.valueOf(i10), null, null);
                }
            });
        }
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAdSplash
    public void setSmartScreenSloganTime(int i10) {
        if (!AbstractC7741ao.m47562b(this.f33356c) || i10 < 0 || i10 > 5000) {
            return;
        }
        this.f33357d.mo43445d(i10);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAdSplash
    public void setUsePostAtFront(boolean z10) {
        this.f33357d.mo43332a(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m44082b() {
        C7008cy c7008cy = new C7008cy(this.f33356c);
        c7008cy.m41238a(new C7011da(this.f33356c));
        return c7008cy.mo41237a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m44086c(AdSlotParam adSlotParam) {
        adSlotParam.m40638a(false);
        int iM40620D = adSlotParam.m40620D();
        long jCurrentTimeMillis = System.currentTimeMillis();
        C7544ol c7544ol = new C7544ol(this.f33356c);
        c7544ol.mo46336a(c7544ol.mo46329a(this.f33356c, adSlotParam, iM40620D), adSlotParam, new C7266a(iM40620D), (InterfaceC7609qk) null, jCurrentTimeMillis, 1);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAdSplash
    public void preloadAd(AdSlotParam adSlotParam) {
        m44073a(adSlotParam, 1);
    }

    @Override // com.huawei.openalliance.p169ad.inter.IHiAdSplash
    public void preloadSmartScreenAd(AdSlotParam adSlotParam) {
        m44073a(adSlotParam, 18);
    }

    /* renamed from: b */
    private boolean m44083b(final AdSlotParam adSlotParam) {
        if (adSlotParam == null || !AbstractC7741ao.m47562b(this.f33356c)) {
            return false;
        }
        C7095ek.m42934a(this.f33356c).m42944e();
        this.f33359f = adSlotParam.m40625I();
        int iM48203a = AbstractC7807d.m48203a(this.f33356c, adSlotParam.m40639b());
        int iM48216b = AbstractC7807d.m48216b(this.f33356c, adSlotParam.m40639b());
        adSlotParam.m40640b(iM48203a);
        adSlotParam.m40643c(iM48216b);
        boolean zBooleanValue = ((Boolean) AbstractC7810dc.m48269a(new Callable<Boolean>() { // from class: com.huawei.openalliance.ad.inter.HiAdSplash.1
            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() {
                AdLoadMode adLoadModeMo43367ay = HiAdSplash.this.f33357d.mo43367ay();
                long jMo43339aF = HiAdSplash.this.f33357d.mo43339aF();
                AbstractC7185ho.m43820b("HiAdSplash", "isAvailable mode: " + adLoadModeMo43367ay + " sloganShowTime: " + jMo43339aF);
                if (AdLoadMode.CACHE != adLoadModeMo43367ay || 0 != jMo43339aF || (!HiAdSplash.this.m44082b() && HiAdSplash.this.f33358e.mo43099a(adSlotParam.m40627a().get(0), adSlotParam.m40639b(), HiAdSplash.this.f33357d.mo43340aG(), adSlotParam.m40620D()) != null)) {
                    AbstractC7185ho.m43820b("HiAdSplash", "isAvailable call true");
                    return Boolean.TRUE;
                }
                AbstractC7185ho.m43820b("HiAdSplash", "isAvailable call false");
                AbstractC7834m.m48481b(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAdSplash.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Pair<String, Boolean> pairM48217b = AbstractC7807d.m48217b(HiAdSplash.this.f33356c, true);
                        if (pairM48217b == null && HiAdSplash.this.f33357d.mo43404be() && C6982bz.m41158h(HiAdSplash.this.f33356c)) {
                            CallableC72561 callableC72561 = CallableC72561.this;
                            HiAdSplash hiAdSplash = HiAdSplash.this;
                            hiAdSplash.m44074a(adSlotParam, hiAdSplash.f33356c);
                        } else {
                            if (pairM48217b != null) {
                                AbstractC7185ho.m43820b("HiAdSplash", "use cached oaid ");
                                adSlotParam.m40635a((String) pairM48217b.first);
                                adSlotParam.m40633a((Boolean) pairM48217b.second);
                            }
                            CallableC72561 callableC725612 = CallableC72561.this;
                            HiAdSplash.this.m44086c(adSlotParam);
                        }
                    }
                });
                return Boolean.FALSE;
            }
        }, Boolean.FALSE)).booleanValue();
        AbstractC7185ho.m43820b("HiAdSplash", "isAvailable " + zBooleanValue);
        return zBooleanValue;
    }

    /* renamed from: a */
    private static IHiAdSplash m44072a(Context context) {
        HiAdSplash hiAdSplash;
        synchronized (f33355b) {
            try {
                if (f33354a == null) {
                    f33354a = new HiAdSplash(context);
                }
                hiAdSplash = f33354a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return hiAdSplash;
    }

    /* renamed from: a */
    public void m44089a(AdSlotParam adSlotParam) {
        if (adSlotParam != null) {
            this.f33359f = adSlotParam.m40625I();
        }
    }

    /* renamed from: a */
    private void m44073a(final AdSlotParam adSlotParam, final int i10) {
        AbstractC7185ho.m43820b("HiAdSplash", "preloadAd request");
        if (adSlotParam != null) {
            AbstractC7185ho.m43820b("HiAdSplash", "request preload splash ad");
            C7095ek.m42934a(this.f33356c).m42944e();
            final List<String> listM40627a = adSlotParam.m40627a();
            if (AbstractC7760bg.m47767a(listM40627a)) {
                return;
            }
            AbstractC7834m.m48481b(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAdSplash.4
                @Override // java.lang.Runnable
                public void run() {
                    adSlotParam.m40648d(i10);
                    adSlotParam.m40638a(true);
                    HiAdSplash.this.f33360g = System.currentTimeMillis();
                    Pair<String, Boolean> pairM48217b = AbstractC7807d.m48217b(HiAdSplash.this.f33356c, true);
                    if (pairM48217b != null) {
                        adSlotParam.m40635a((String) pairM48217b.first);
                        adSlotParam.m40633a((Boolean) pairM48217b.second);
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    for (String str : listM40627a) {
                        int iMo43290a = C7120fd.m43288a(HiAdSplash.this.f33356c).mo43290a(str);
                        if (iMo43290a != 0) {
                            if (iMo43290a == 2) {
                                arrayList2.add(str);
                            } else if (iMo43290a != 3) {
                                arrayList.add(str);
                            } else {
                                arrayList3.add(str);
                            }
                        }
                    }
                    if (!AbstractC7807d.m48227c(HiAdSplash.this.f33356c, i10)) {
                        AdSlotParam adSlotParamM40625I = adSlotParam.m40625I();
                        arrayList.addAll(arrayList2);
                        arrayList.addAll(arrayList3);
                        if (AbstractC7760bg.m47767a(arrayList)) {
                            return;
                        }
                        adSlotParamM40625I.m40636a(arrayList);
                        HiAdSplash.this.m44081b(adSlotParamM40625I, i10);
                        return;
                    }
                    if (!AbstractC7760bg.m47767a(arrayList2) || !AbstractC7760bg.m47767a(arrayList3)) {
                        HiAdSplash.this.m44075a(adSlotParam.m40625I(), arrayList2, arrayList3);
                    }
                    if (AbstractC7760bg.m47767a(arrayList)) {
                        return;
                    }
                    AdSlotParam adSlotParamM40625I2 = adSlotParam.m40625I();
                    adSlotParamM40625I2.m40636a(arrayList);
                    HiAdSplash.this.m44081b(adSlotParamM40625I2, i10);
                }
            });
            C7762bi.m47788b(this.f33356c, adSlotParam.m40659l());
            m44080a(listM40627a.get(0), i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m44074a(final AdSlotParam adSlotParam, final Context context) {
        final int iM40620D = adSlotParam.m40620D();
        OAIDServiceManager.getInstance(context).requireOaid(new OAIDServiceManager.OaidResultCallback() { // from class: com.huawei.openalliance.ad.inter.HiAdSplash.3
            @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
            /* renamed from: a */
            public void mo44091a() {
                AbstractC7185ho.m43820b("HiAdSplash", "onOaidAcquireFailed " + System.currentTimeMillis());
                HiAdSplash.this.m44086c(adSlotParam);
            }

            @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
            /* renamed from: b */
            public int mo44093b() {
                return iM40620D;
            }

            @Override // com.huawei.openalliance.ad.opendeviceidentifier.OAIDServiceManager.OaidResultCallback
            /* renamed from: a */
            public void mo44092a(String str, boolean z10) {
                AbstractC7185ho.m43820b("HiAdSplash", "onOaidAcquired " + System.currentTimeMillis());
                adSlotParam.m40635a(str);
                adSlotParam.m40633a(Boolean.valueOf(z10));
                AbstractC7807d.m48211a(context, str, z10);
                HiAdSplash.this.m44086c(adSlotParam);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m44075a(AdSlotParam adSlotParam, List<String> list, List<String> list2) {
        AbstractC7185ho.m43817a("HiAdSplash", "do preload from kit");
        adSlotParam.m40634a(this.f33361h);
        String strM42836a = C7084e.m42836a();
        if (!AbstractC7806cz.m48165b(strM42836a)) {
            adSlotParam.m40645c(strM42836a);
        }
        adSlotParam.m40632a(C7794cn.m48075a(this.f33356c, adSlotParam.m40659l()));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MapKeyNames.AD_SLOT_PARAM, AbstractC7758be.m47742b(adSlotParam));
            jSONObject.put(MapKeyNames.KIT_RELOAD_ADIDS, AbstractC7758be.m47742b(list));
            jSONObject.put(MapKeyNames.SDK_KIT_RELOAD_ADIDS, AbstractC7758be.m47742b(list2));
            final AdSlotParam adSlotParamM40625I = adSlotParam.m40625I();
            C7484ms.m45854a(this.f33356c).m45855a(RTCMethods.PRELOAD_SPLASH_AD, jSONObject.toString(), new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.inter.HiAdSplash.6
                @Override // com.huawei.openalliance.p169ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                    if (callResult.getCode() != 200) {
                        AbstractC7185ho.m43820b("HiAdSplash", "call kit preload failed");
                        HiAdSplash.this.m44081b(adSlotParamM40625I, 1);
                    }
                }
            }, String.class);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("HiAdSplash", "do kit preload failed: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    private void m44080a(final String str, final int i10) {
        AbstractC7768bo.m47808a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAdSplash.5
            @Override // java.lang.Runnable
            public void run() {
                AbstractC7834m.m48480a(new Runnable() { // from class: com.huawei.openalliance.ad.inter.HiAdSplash.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int iMo43290a = C7120fd.m43288a(HiAdSplash.this.f33356c).mo43290a(str);
                        if (iMo43290a == 0 || (1 != iMo43290a && AbstractC7741ao.m47573d(HiAdSplash.this.f33356c))) {
                            new C7579pm(HiAdSplash.this.f33356c, true, i10).mo46792d();
                        }
                    }
                }, AbstractC7834m.a.DISK_CACHE, false);
            }
        }, 30000L);
    }
}
