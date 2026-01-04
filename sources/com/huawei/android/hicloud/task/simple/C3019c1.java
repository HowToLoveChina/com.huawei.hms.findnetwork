package com.huawei.android.hicloud.task.simple;

import ca.C1400c;
import ca.C1403f;
import com.google.gson.Gson;
import com.huawei.android.hicloud.agd.ads.AdParametersExt;
import com.huawei.cloud.pay.model.HiCloudNativeAd;
import com.huawei.cloud.pay.model.HicloudAdRespone;
import com.huawei.hicloud.notification.manager.AdSwitchManager;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.INativeAdLoader;
import com.huawei.openalliance.p169ad.inter.NativeAdLoader;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener;
import fk.C9721b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import je.C10776a;
import p015ak.C0213f;
import p329h7.C10121i;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p651t8.C12996d;
import p709vj.C13452e;

/* renamed from: com.huawei.android.hicloud.task.simple.c1 */
/* loaded from: classes3.dex */
public class C3019c1 extends AbstractC12367d implements Consumer<Map<String, List<HiCloudNativeAd>>> {

    /* renamed from: a */
    public INativeAdLoader f13161a;

    /* renamed from: b */
    public String f13162b;

    /* renamed from: c */
    public Map<String, List<HiCloudNativeAd>> f13163c;

    /* renamed from: d */
    public CountDownLatch f13164d;

    /* renamed from: e */
    public boolean f13165e;

    /* renamed from: f */
    public boolean f13166f;

    /* renamed from: g */
    public boolean f13167g;

    /* renamed from: h */
    public boolean f13168h;

    /* renamed from: i */
    public final AdParametersExt f13169i;

    /* renamed from: j */
    public int f13170j;

    /* renamed from: com.huawei.android.hicloud.task.simple.c1$b */
    public class b implements NativeAdListener {
        public b() {
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener
        public void onAdFailed(int i10) {
            C3019c1.this.m18224v(i10);
            if (C3019c1.this.f13167g) {
                C11839m.m70688i("LoadAdsTask", "onAdFailed isPPSOnly true");
            } else if (C3019c1.this.f13169i.getEnabled().intValue() == 1 && C3019c1.this.f13169i.getThreshold().intValue() >= 0) {
                String agdAdid = C3019c1.this.f13169i.getAgdAdid();
                C3019c1 c3019c1 = C3019c1.this;
                C12515a.m75110o().m75175e(new C3047j1(null, agdAdid, c3019c1, c3019c1.f13170j), false);
                return;
            }
            C3019c1.this.f13162b = String.valueOf(i10);
            HicloudAdRespone hicloudAdRespone = new HicloudAdRespone();
            hicloudAdRespone.setResultCode(i10);
            C3019c1.this.f13162b = new Gson().toJson(hicloudAdRespone);
            C11839m.m70688i("LoadAdsTask", "onAdFailed:" + C3019c1.this.f13162b);
            C3019c1.this.f13166f = true;
            C3019c1.this.f13164d.countDown();
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener
        public void onAdsLoaded(Map<String, List<INativeAd>> map) {
            C11839m.m70688i("LoadAdsTask", "fromCampaign=" + C3019c1.this.f13168h);
            if (C3019c1.this.f13168h) {
                C12996d.m77971n().m77982F(map);
            } else {
                C1403f.m8066n().m8077K(map);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i10 = 0;
            for (Map.Entry<String, List<INativeAd>> entry : map.entrySet()) {
                String key = entry.getKey();
                List<INativeAd> value = entry.getValue();
                List listM18230t = C3019c1.this.m18230t(value);
                ArrayList arrayList = new ArrayList();
                Iterator it = listM18230t.iterator();
                while (it.hasNext()) {
                    HiCloudNativeAd hiCloudNativeAdM65607c = C10776a.m65607c((INativeAd) it.next(), HiCloudNativeAd.CHANNEL_PPS);
                    if (hiCloudNativeAdM65607c != null) {
                        arrayList.add(hiCloudNativeAdM65607c);
                    }
                }
                int size = listM18230t.size();
                linkedHashMap.put(key, arrayList);
                C11839m.m70688i("LoadAdsTask", "onAdsLoaded, adId:" + key + "ad list size =" + value.size() + ", valid ad list size = " + size);
                C3019c1.this.m18225y(listM18230t.size());
                i10 = size;
            }
            if (C3019c1.this.f13167g) {
                C11839m.m70688i("LoadAdsTask", "onAdsLoaded isPPSOnly true");
                C3019c1.this.accept(linkedHashMap);
            } else {
                if (!C3019c1.this.m18231u(map, i10)) {
                    C3019c1.this.accept(linkedHashMap);
                    return;
                }
                String agdAdid = C3019c1.this.f13169i.getAgdAdid();
                C3019c1 c3019c1 = C3019c1.this;
                C12515a.m75110o().m75175e(new C3047j1(linkedHashMap, agdAdid, c3019c1, c3019c1.f13170j), false);
            }
        }
    }

    public C3019c1(boolean z10, String str, String[] strArr, int i10, List<String> list, int i11) {
        this(z10, str, strArr, i10, list, false, i11, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void m18224v(int i10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("load_ad_error_code", String.valueOf(i10));
        C1400c.m8060g("JS_LOAD_APP_NUM_FAIL", linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public void m18225y(int i10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("load_ad_num", String.valueOf(i10));
        C1400c.m8060g("JS_LOAD_APP_NUM_SUCCESS", linkedHashMap);
    }

    @Override // java.util.function.Consumer
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void accept(Map<String, List<HiCloudNativeAd>> map) {
        C11839m.m70688i("LoadAdsTask", "accept:" + map.size());
        HicloudAdRespone hicloudAdRespone = new HicloudAdRespone();
        hicloudAdRespone.setResultCode(0);
        hicloudAdRespone.setResponseMessage(new Gson().toJson(map));
        this.f13162b = new Gson().toJson(hicloudAdRespone);
        this.f13163c = map;
        C11839m.m70686d("LoadAdsTask", "onAdsLoaded:" + this.f13162b);
        this.f13164d.countDown();
        this.f13166f = true;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws InterruptedException, C9721b {
        boolean zAwait = false;
        if (!C13452e.m80781L().m80803F0().booleanValue()) {
            if (this.f13167g) {
                accept(new HashMap());
                return;
            } else {
                if (this.f13169i.getEnabled().intValue() != 1 || this.f13169i.getThreshold().intValue() < 0) {
                    return;
                }
                C12515a.m75110o().m75175e(new C3047j1(null, this.f13169i.getAgdAdid(), this, this.f13170j), false);
                return;
            }
        }
        HiAd.getInstance(C0213f.m1377a()).initLog(true, 4);
        C11839m.m70688i("LoadAdsTask", "loadAds call");
        if (this.f13161a != null) {
            C11839m.m70688i("LoadAdsTask", "setListener");
            this.f13161a.setListener(new b());
            this.f13161a.loadAds(C1400c.m8056b(), this.f13165e);
        }
        try {
            zAwait = this.f13164d.await(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            C11839m.m70687e("LoadAdsTask", "loadAdsTask exception:" + e10.toString());
        }
        C11839m.m70688i("LoadAdsTask", "loadAdsTask awaitResult:" + zAwait);
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.LOAD_AD;
    }

    /* renamed from: q */
    public CountDownLatch m18227q() {
        return this.f13164d;
    }

    /* renamed from: r */
    public String m18228r() {
        return this.f13162b;
    }

    /* renamed from: s */
    public Map<String, List<HiCloudNativeAd>> m18229s() {
        return this.f13163c;
    }

    /* renamed from: t */
    public final List<INativeAd> m18230t(List<INativeAd> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                INativeAd iNativeAd = list.get(i10);
                if (iNativeAd != null && !iNativeAd.isExpired()) {
                    arrayList.add(iNativeAd);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: u */
    public final boolean m18231u(Map<String, List<INativeAd>> map, int i10) {
        C11839m.m70688i("LoadAdsTask", "isRequestGameResource:" + this.f13169i);
        if (this.f13169i.getEnabled().intValue() == 0) {
            C11839m.m70689w("LoadAdsTask", "not request agd");
            return false;
        }
        if (i10 > this.f13169i.getThreshold().intValue()) {
            C11839m.m70689w("LoadAdsTask", "pps size bigger than agd threshold");
            return false;
        }
        Iterator<Map.Entry<String, List<INativeAd>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (this.f13169i.getAgdAdid().equals(it.next().getKey())) {
                return false;
            }
        }
        return true;
    }

    public C3019c1(boolean z10, String str, String[] strArr, int i10, List<String> list, boolean z11, boolean z12) {
        this(z10, str, strArr, i10, list, z11, 10, z12);
    }

    public C3019c1(boolean z10, String str, String[] strArr, int i10, List<String> list, boolean z11, int i11, boolean z12) {
        this.f13162b = "";
        this.f13164d = new CountDownLatch(1);
        this.f13165e = false;
        this.f13170j = 10;
        C11839m.m70688i("LoadAdsTask", "adIds:" + new Gson().toJson(strArr));
        NativeAdLoader nativeAdLoader = new NativeAdLoader(C0213f.m1377a(), strArr, i10, list);
        this.f13161a = nativeAdLoader;
        nativeAdLoader.setRequestOptions(AdSwitchManager.getInstance().getPpsRequestOptionsBuilder().build());
        this.f13161a.setExtraInfo(str);
        this.f13165e = z10;
        this.f13167g = z11;
        this.f13169i = C10121i.m63035a();
        this.f13170j = i11;
        this.f13168h = z12;
    }
}
