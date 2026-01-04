package com.huawei.android.hicloud.task.simple;

import ca.C1403f;
import com.google.gson.Gson;
import com.huawei.android.hicloud.agd.ads.AdAppInfo;
import com.huawei.android.hicloud.agd.ads.AdInfo;
import com.huawei.android.hicloud.agd.ads.AdSlot;
import com.huawei.android.hicloud.agd.ads.MaterialMeta;
import com.huawei.cloud.pay.model.AdImageInfo;
import com.huawei.cloud.pay.model.HiCloudNativeAd;
import com.huawei.cloud.pay.model.HicloudAdRespone;
import com.huawei.cloud.pay.model.QueryAdListRsp;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.embedded.C6148x2;
import fk.C9721b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p015ak.C0209d;
import p015ak.C0225l;
import p015ak.C0226l0;
import p315gj.C9948a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p651t8.C12996d;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;

/* renamed from: com.huawei.android.hicloud.task.simple.j1 */
/* loaded from: classes3.dex */
public class C3047j1 extends AbstractC12367d {

    /* renamed from: a */
    public final Map<String, List<HiCloudNativeAd>> f13293a;

    /* renamed from: b */
    public final String f13294b;

    /* renamed from: c */
    public final Consumer<Map<String, List<HiCloudNativeAd>>> f13295c;

    /* renamed from: d */
    public int f13296d;

    /* renamed from: e */
    public boolean f13297e;

    /* renamed from: com.huawei.android.hicloud.task.simple.j1$a */
    public static class a implements Consumer<Map<String, List<HiCloudNativeAd>>> {

        /* renamed from: a */
        public final CountDownLatch f13298a = new CountDownLatch(1);

        /* renamed from: b */
        public String f13299b = "";

        /* renamed from: c */
        public Map<String, List<HiCloudNativeAd>> f13300c;

        /* renamed from: d */
        public boolean f13301d;

        @Override // java.util.function.Consumer
        /* renamed from: a */
        public void accept(Map<String, List<HiCloudNativeAd>> map) {
            C11839m.m70688i("LoadGameAdsTask", "accept:" + map.size());
            HicloudAdRespone hicloudAdRespone = new HicloudAdRespone();
            hicloudAdRespone.setResultCode(0);
            hicloudAdRespone.setResponseMessage(new Gson().toJson(map));
            this.f13299b = new Gson().toJson(hicloudAdRespone);
            this.f13300c = map;
            C11839m.m70686d("LoadGameAdsTask", "onAdsLoaded:" + this.f13299b);
            this.f13298a.countDown();
            this.f13301d = true;
        }

        /* renamed from: b */
        public CountDownLatch m18347b() {
            return this.f13298a;
        }

        /* renamed from: c */
        public Map<String, List<HiCloudNativeAd>> m18348c() {
            return this.f13300c;
        }
    }

    public C3047j1(Map<String, List<HiCloudNativeAd>> map, String str, Consumer<Map<String, List<HiCloudNativeAd>>> consumer, int i10) {
        this(map, str, consumer, i10, false);
    }

    /* renamed from: e */
    public static HiCloudNativeAd m18340e(AdInfo adInfo) {
        HiCloudNativeAd hiCloudNativeAd = new HiCloudNativeAd();
        AdAppInfo appInfo = adInfo.getMaterial().getAppInfo();
        com.huawei.cloud.pay.model.AdAppInfo adAppInfo = new com.huawei.cloud.pay.model.AdAppInfo();
        adAppInfo.setAppName(appInfo.getAppName());
        adAppInfo.setAppDesc(appInfo.getDescription());
        adAppInfo.setUniqueId(appInfo.getAppId());
        adAppInfo.setPackageName(appInfo.getPackageName());
        adAppInfo.setFileSize(appInfo.getSize());
        adAppInfo.setIconUrl(appInfo.getIcon());
        adAppInfo.setDeveloperName(appInfo.getDeveloperName());
        adAppInfo.setVersionName(appInfo.getVersionName());
        adAppInfo.setChannel(HiCloudNativeAd.CHANNEL_AGD);
        hiCloudNativeAd.setAppInfo(adAppInfo);
        hiCloudNativeAd.setUniqueId(appInfo.getAppId());
        hiCloudNativeAd.setDescription(appInfo.getDescription());
        ArrayList arrayList = new ArrayList();
        AdImageInfo adImageInfo = new AdImageInfo();
        adImageInfo.setUrl(appInfo.getIcon());
        arrayList.add(adImageInfo);
        hiCloudNativeAd.setImageInfos(arrayList);
        return hiCloudNativeAd;
    }

    /* renamed from: j */
    public /* synthetic */ void m18341j() {
        this.f13295c.accept(this.f13293a);
    }

    public /* synthetic */ void lambda$call$0() {
        this.f13295c.accept(this.f13293a);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        int iM18343g = this.f13296d - m18343g();
        C11839m.m70688i("LoadGameAdsTask", "LoadGameAdsTask request size:" + iM18343g);
        if (iM18343g <= 0) {
            this.f13295c.accept(this.f13293a);
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            Integer hasNextPage = 1;
            int i10 = 0;
            while (hasNextPage != null && hasNextPage.intValue() == 1 && arrayList.size() < iM18343g && i10 < 5) {
                i10++;
                QueryAdListRsp queryAdListRspM61659a0 = C9948a.m61631C().m61659a0(new AdSlot(Integer.valueOf(iM18343g), Integer.valueOf(i10), this.f13294b));
                C11839m.m70688i("LoadGameAdsTask", "LoadGameAdsTask rsp desc:" + queryAdListRspM61659a0.getResultDesc());
                if (queryAdListRspM61659a0.getResultCode() == 0 && queryAdListRspM61659a0.getAdRetCode() != null && queryAdListRspM61659a0.getAdRetCode().intValue() == 0) {
                    C11839m.m70688i("LoadGameAdsTask", "LoadGameAdsTask rsp size:" + queryAdListRspM61659a0.getAdlist().size());
                    arrayList.addAll(queryAdListRspM61659a0.getAdlist());
                    hasNextPage = queryAdListRspM61659a0.getHasNextPage();
                }
                m18345k(iM18343g, 0, 0);
                break;
            }
            C11839m.m70688i("LoadGameAdsTask", "queryAdList size:" + arrayList.size());
            if (C0209d.m1205R0(arrayList)) {
                m18345k(iM18343g, 0, 0);
            } else {
                m18342f(arrayList, iM18343g);
            }
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.task.simple.f1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13268a.lambda$call$0();
                }
            });
        } catch (C9721b e10) {
            C11839m.m70687e("LoadGameAdsTask", "queryAdList failed:" + e10.getMessage());
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.task.simple.g1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13275a.m18341j();
                }
            });
        }
    }

    /* renamed from: f */
    public final void m18342f(List<AdInfo> list, int i10) {
        if (list.size() > i10) {
            list = list.subList(0, i10);
        }
        List arrayList = new ArrayList();
        if (this.f13293a.size() <= 0) {
            arrayList = (List) list.stream().filter(new Predicate() { // from class: com.huawei.android.hicloud.task.simple.h1
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return Objects.nonNull((AdInfo) obj);
                }
            }).collect(Collectors.toList());
        } else {
            for (AdInfo adInfo : list) {
                Iterator<Map.Entry<String, List<HiCloudNativeAd>>> it = this.f13293a.entrySet().iterator();
                while (it.hasNext()) {
                    if (!m18344h(adInfo, it.next().getValue())) {
                        arrayList.add(adInfo);
                    }
                }
            }
        }
        HashMap map = new HashMap();
        map.put(this.f13294b, arrayList);
        if (this.f13297e) {
            C12996d.m77971n().m77980D(map);
        } else {
            C1403f.m8066n().m8075I(map);
        }
        List<HiCloudNativeAd> listM1579c = C0225l.m1579c(arrayList, new Function() { // from class: com.huawei.android.hicloud.task.simple.i1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return C3047j1.m18340e((AdInfo) obj);
            }
        });
        C3027e1.m18300k(listM1579c);
        m18345k(i10, list.size(), listM1579c.size());
        this.f13293a.put(this.f13294b, listM1579c);
    }

    /* renamed from: g */
    public final int m18343g() {
        int size = 0;
        for (Map.Entry<String, List<HiCloudNativeAd>> entry : this.f13293a.entrySet()) {
            if (entry != null && entry.getValue() != null) {
                size += entry.getValue().size();
            }
        }
        return size;
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.LOAD_AD;
    }

    /* renamed from: h */
    public final boolean m18344h(AdInfo adInfo, List<HiCloudNativeAd> list) {
        if (adInfo == null || adInfo.getMaterial() == null) {
            C11839m.m70687e("LoadGameAdsTask", "agd is empty");
            return true;
        }
        MaterialMeta material = adInfo.getMaterial();
        if (material == null) {
            C11839m.m70687e("LoadGameAdsTask", "materialMeta is empty");
            return true;
        }
        AdAppInfo appInfo = material.getAppInfo();
        if (appInfo == null) {
            C11839m.m70687e("LoadGameAdsTask", "adAppInfo is empty");
            return true;
        }
        for (HiCloudNativeAd hiCloudNativeAd : list) {
            if (Objects.equals(appInfo.getAppId(), hiCloudNativeAd.getAppInfo().getUniqueId()) || Objects.equals(appInfo.getPackageName(), hiCloudNativeAd.getAppInfo().getPackageName())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: k */
    public final void m18345k(int i10, int i11, int i12) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put(C6148x2.DEVICE_ID, C13452e.m80781L().m80954p());
        linkedHashMapM79497A.put("load_ad_num", String.valueOf(i11));
        linkedHashMapM79497A.put("request_agd_ads_count_key", String.valueOf(i10));
        linkedHashMapM79497A.put("filter_agd_ads_count_key", String.valueOf(i12));
        linkedHashMapM79497A.put("sce_request_agd_ads_key", "sce_request_agd_ads_show");
        C13227f.m79492i1().m79567R("load_agd_ads_event", linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", "load_agd_ads_event", linkedHashMapM79497A);
    }

    public C3047j1(Map<String, List<HiCloudNativeAd>> map, String str, Consumer<Map<String, List<HiCloudNativeAd>>> consumer, int i10, boolean z10) {
        this.f13296d = 10;
        this.f13293a = map == null ? new HashMap<>() : map;
        this.f13294b = str;
        this.f13295c = consumer;
        this.f13296d = i10;
        this.f13297e = z10;
    }
}
