package com.huawei.android.hicloud.task.simple;

import ca.C1400c;
import ca.C1403f;
import com.google.gson.Gson;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import je.C10776a;
import p015ak.C0213f;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p709vj.C13452e;

/* renamed from: com.huawei.android.hicloud.task.simple.k1 */
/* loaded from: classes3.dex */
public class C3051k1 extends AbstractC12367d implements Consumer<Map<String, List<HiCloudNativeAd>>> {

    /* renamed from: a */
    public INativeAdLoader f13314a;

    /* renamed from: b */
    public String f13315b = "";

    /* renamed from: c */
    public CountDownLatch f13316c = new CountDownLatch(1);

    /* renamed from: d */
    public int f13317d;

    /* renamed from: e */
    public boolean f13318e;

    /* renamed from: f */
    public C11060c f13319f;

    /* renamed from: com.huawei.android.hicloud.task.simple.k1$b */
    public class b implements NativeAdListener {
        public b() {
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener
        public void onAdFailed(int i10) {
            C11839m.m70687e("LoadPpsAdsTask", "loadAdsBySrc onAdFailed errorCode: " + i10);
            C3051k1.this.f13315b = String.valueOf(i10);
            HicloudAdRespone hicloudAdRespone = new HicloudAdRespone();
            hicloudAdRespone.setResultCode(i10);
            C3051k1.this.f13315b = new Gson().toJson(hicloudAdRespone);
            if (C3051k1.this.f13319f != null) {
                C3051k1.this.f13319f.m66665u(String.valueOf(i10));
                C3051k1.this.f13319f.m66635A("");
                C10776a.m65612h(C3051k1.this.f13319f, C3051k1.this.f13317d, HiCloudNativeAd.CHANNEL_PPS);
            }
            C3051k1.this.m18355m();
        }

        @Override // com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener
        public void onAdsLoaded(Map<String, List<INativeAd>> map) {
            C11839m.m70688i("LoadPpsAdsTask", "loadAdsBySrc onAdsLoaded");
            C1403f.m8066n().m8077K(map);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, List<INativeAd>> entry : map.entrySet()) {
                String key = entry.getKey();
                List<INativeAd> listM18354l = C3051k1.this.m18354l(entry.getValue());
                ArrayList arrayList = new ArrayList();
                for (INativeAd iNativeAd : listM18354l) {
                    if (arrayList.size() >= C3051k1.this.f13317d) {
                        break;
                    }
                    HiCloudNativeAd hiCloudNativeAdM65607c = C10776a.m65607c(iNativeAd, HiCloudNativeAd.CHANNEL_PPS);
                    if (hiCloudNativeAdM65607c != null) {
                        arrayList.add(hiCloudNativeAdM65607c);
                    }
                }
                linkedHashMap.put(key, arrayList);
                C11839m.m70688i("LoadPpsAdsTask", "loadAdsBySrc ads PPS size: " + arrayList.size());
                if (C3051k1.this.f13319f != null) {
                    C3051k1.this.f13319f.m66665u(String.valueOf(0));
                    C3051k1.this.f13319f.m66635A("");
                    C10776a.m65613i(C3051k1.this.f13319f, C3051k1.this.f13317d, listM18354l.size(), HiCloudNativeAd.CHANNEL_PPS);
                }
            }
            C3051k1.this.accept(linkedHashMap);
        }
    }

    public C3051k1(int i10, String[] strArr, int i11) {
        C11839m.m70688i("LoadPpsAdsTask", "loadAdsBySrc loadPpsAdsTask begin");
        NativeAdLoader nativeAdLoader = new NativeAdLoader(C0213f.m1377a(), strArr, i11, null);
        this.f13314a = nativeAdLoader;
        nativeAdLoader.setRequestOptions(AdSwitchManager.getInstance().getPpsRequestOptionsBuilder().build());
        this.f13314a.setExtraInfo(null);
        this.f13317d = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public List<INativeAd> m18354l(List<INativeAd> list) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m18355m() {
        C11839m.m70688i("LoadPpsAdsTask", "loadAdsBySrc LoadPpsAdsTask finish.");
        this.f13316c.countDown();
        this.f13318e = true;
    }

    @Override // java.util.function.Consumer
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void accept(Map<String, List<HiCloudNativeAd>> map) {
        C11839m.m70688i("LoadPpsAdsTask", "loadAdsBySrc pps accept");
        HicloudAdRespone hicloudAdRespone = new HicloudAdRespone();
        hicloudAdRespone.setResultCode(0);
        hicloudAdRespone.setResponseMessage(new Gson().toJson(map));
        this.f13315b = new Gson().toJson(hicloudAdRespone);
        m18355m();
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws InterruptedException, C9721b {
        this.f13319f = C11058a.m66626a(C11058a.m66627b("07054"), "07054", C13452e.m80781L().m80971t0());
        if (!C13452e.m80781L().m80803F0().booleanValue()) {
            C11839m.m70689w("LoadPpsAdsTask", "loadAdsBySrc not support pps.");
            m18355m();
            return;
        }
        HiAd.getInstance(C0213f.m1377a()).initLog(true, 4);
        boolean zAwait = false;
        if (this.f13314a != null) {
            C11839m.m70688i("LoadPpsAdsTask", "loadAdsBySrc setListener");
            this.f13314a.setListener(new b());
            this.f13314a.loadAds(C1400c.m8056b(), false);
        }
        try {
            zAwait = this.f13316c.await(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            C11839m.m70687e("LoadPpsAdsTask", "loadAdsBySrc loadPpsAdsTask exception:" + e10.toString());
        }
        C11839m.m70688i("LoadPpsAdsTask", "loadAdsBySrc loadPpsAdsTask awaitResult:" + zAwait);
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.LOAD_AD;
    }

    /* renamed from: j */
    public CountDownLatch m18357j() {
        return this.f13316c;
    }

    /* renamed from: k */
    public String m18358k() {
        return this.f13315b;
    }
}
