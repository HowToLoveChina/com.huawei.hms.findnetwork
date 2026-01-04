package com.huawei.android.hicloud.task.simple;

import com.google.gson.annotations.SerializedName;
import com.huawei.android.hicloud.agd.ads.AdInfo;
import com.huawei.android.hicloud.agd.ads.AdSlot;
import com.huawei.android.hicloud.agd.ads.RestoreAdAppInfo;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreAdsInfo;
import com.huawei.cloud.pay.model.QueryAdListRsp;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.embedded.C6148x2;
import fk.C9721b;
import gl.C9968i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import je.C10790h;
import p261el.C9500a;
import p315gj.C9948a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p617rl.C12527k;
import p618rm.C12540b1;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;

/* renamed from: com.huawei.android.hicloud.task.simple.m1 */
/* loaded from: classes3.dex */
public class C3059m1 extends AbstractC12367d {

    /* renamed from: a */
    public final List<RestoreAdAppInfo> f13330a;

    /* renamed from: b */
    public final CountDownLatch f13331b;

    /* renamed from: c */
    public final String f13332c;

    /* renamed from: com.huawei.android.hicloud.task.simple.m1$a */
    public class a {

        /* renamed from: a */
        @SerializedName("adSlotId")
        private String f13333a;

        /* renamed from: b */
        @SerializedName("adCount")
        private int f13334b;

        /* renamed from: a */
        public int m18363a() {
            return this.f13334b;
        }

        /* renamed from: b */
        public String m18364b() {
            return this.f13333a;
        }
    }

    public C3059m1(List<RestoreAdAppInfo> list, CountDownLatch countDownLatch, String str) {
        this.f13330a = list;
        this.f13331b = countDownLatch;
        this.f13332c = str;
    }

    /* renamed from: d */
    public static /* synthetic */ void m18360d(Map map, AdInfo adInfo) {
        String packageName = adInfo.getMaterial().getAppInfo().getPackageName();
        RestoreAdsInfo restoreAdsInfo = new RestoreAdsInfo();
        restoreAdsInfo.setAdId(adInfo.getAdId());
        restoreAdsInfo.setPackageName(packageName);
        restoreAdsInfo.setClickUrl(adInfo.getMaterial().getClickUrl());
        restoreAdsInfo.setShowUrl(adInfo.getMaterial().getShowUrl());
        restoreAdsInfo.setDownloadParam(adInfo.getMaterial().getAppInfo().getDownloadParam());
        restoreAdsInfo.setVersionCode(adInfo.getMaterial().getAppInfo().getVersionCode());
        map.put(packageName, restoreAdsInfo);
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() throws C9721b {
        List<RestoreAdAppInfo> list = this.f13330a;
        if (list == null || list.size() <= 0) {
            return;
        }
        C11839m.m70688i("LoadRestoreAdsTask", "LoadRestoreAdsTask request size:" + this.f13330a.size());
        C12527k c12527kM59438b = C9500a.m59438b();
        if (c12527kM59438b == null) {
            C11839m.m70687e("LoadRestoreAdsTask", "AgdConfig get null");
            return;
        }
        a aVar = (a) C12540b1.m75483a(c12527kM59438b.m75434b(), a.class);
        if (aVar == null) {
            C11839m.m70687e("LoadRestoreAdsTask", "AdSlot get null");
            return;
        }
        String strM18364b = aVar.m18364b();
        C9968i.e.m61847C(strM18364b);
        int iM18363a = aVar.m18363a();
        ArrayList arrayList = new ArrayList();
        AdSlot adSlot = new AdSlot(Integer.valueOf(iM18363a), 1, strM18364b);
        int i10 = 0;
        while (true) {
            long j10 = i10 * 100;
            if (j10 >= this.f13330a.size()) {
                try {
                    C11839m.m70688i("LoadRestoreAdsTask", "queryAdList size:" + arrayList.size());
                    final HashMap map = new HashMap();
                    arrayList.forEach(new Consumer() { // from class: com.huawei.android.hicloud.task.simple.l1
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            C3059m1.m18360d(map, (AdInfo) obj);
                        }
                    });
                    C10790h.m65666n(map);
                    m18361e(iM18363a, arrayList.size());
                    return;
                } catch (Exception e10) {
                    C11839m.m70687e("LoadRestoreAdsTask", "queryAGDList failed: " + e10.getMessage());
                    return;
                }
            }
            try {
                QueryAdListRsp queryAdListRspM61656Y = C9948a.m61631C().m61656Y(adSlot, (List) this.f13330a.stream().skip(j10).limit(100L).collect(Collectors.toList()));
                C11839m.m70688i("LoadRestoreAdsTask", "LoadRestoreAdsTask rsp desc:" + queryAdListRspM61656Y.getResultDesc());
                if (queryAdListRspM61656Y.getResultCode() == 0 && queryAdListRspM61656Y.getAdRetCode().intValue() == 0) {
                    arrayList.addAll(queryAdListRspM61656Y.getAdlist());
                }
            } catch (C9721b e11) {
                C11839m.m70687e("LoadRestoreAdsTask", "queryAGDList failed: " + e11.getMessage());
                m18362f(e11.toString());
            }
            i10++;
        }
    }

    /* renamed from: e */
    public final void m18361e(int i10, int i11) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put(C6148x2.DEVICE_ID, C13452e.m80781L().m80954p());
        linkedHashMapM79497A.put("load_ad_num", String.valueOf(i11));
        linkedHashMapM79497A.put("request_agd_ads_count_key", String.valueOf(i10));
        linkedHashMapM79497A.put("sce_request_agd_ads_key", "sce_request_agd_ads_show");
        linkedHashMapM79497A.put("traceID", this.f13332c);
        C13227f.m79492i1().m79567R("load_agd_ads_event", linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", "load_agd_ads_event", linkedHashMapM79497A);
    }

    /* renamed from: f */
    public final void m18362f(String str) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("load_ad_error_code", str);
        linkedHashMapM79497A.put("traceID", this.f13332c);
        C13227f.m79492i1().m79573U("load_agd_ads_event", linkedHashMapM79497A);
        C13227f.m79492i1().m79567R("load_agd_ads_event", linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", "load_agd_ads_event", linkedHashMapM79497A);
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.LOAD_AD;
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public void release() {
        super.release();
        this.f13331b.countDown();
    }
}
