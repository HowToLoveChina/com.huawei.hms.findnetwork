package p230dl;

import com.huawei.android.hicloud.agd.ads.RestoreAdAppInfo;
import com.huawei.cloud.pay.model.HiCloudNativeAd;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import p015ak.C0213f;
import p230dl.C9169e;
import p429kk.C11058a;
import p429kk.C11060c;
import p514o9.C11839m;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: dl.q */
/* loaded from: classes6.dex */
public class C9181q implements NativeAdListener {

    /* renamed from: a */
    public final List<RestoreAdAppInfo> f46030a;

    /* renamed from: c */
    public final C9169e f46032c;

    /* renamed from: d */
    public final CountDownLatch f46033d;

    /* renamed from: e */
    public int f46034e = 0;

    /* renamed from: b */
    public final C11060c f46031b = C11058a.m66626a(C11058a.m66627b("07060"), "07060", C13452e.m80781L().m80971t0());

    public C9181q(List<RestoreAdAppInfo> list, C9169e c9169e, CountDownLatch countDownLatch) {
        this.f46030a = list;
        this.f46032c = c9169e;
        this.f46033d = countDownLatch;
    }

    /* renamed from: c */
    public final void m57657c(boolean z10, int i10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put(C6148x2.DEVICE_ID, C13452e.m80781L().m80954p());
        linkedHashMapM79497A.put("load_request_ad_num", String.valueOf(this.f46030a.size()));
        linkedHashMapM79497A.put("load_ad_channel", HiCloudNativeAd.CHANNEL_PPS);
        if (z10) {
            linkedHashMapM79497A.put("load_ad_num", String.valueOf(i10));
        } else {
            linkedHashMapM79497A.put("load_ad_error_code", this.f46031b.m66647c());
            linkedHashMapM79497A.put("load_ad_error_msg", this.f46031b.m66652h());
        }
        C13622a.m81969o(C0213f.m1377a(), this.f46031b, linkedHashMapM79497A);
        C13225d.m79490f1().m79567R("action_code_restore_app_by_pps", linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", "action_code_restore_app_by_pps", linkedHashMapM79497A);
    }

    /* renamed from: d */
    public final void m57658d(Map<String, List<INativeAd>> map) {
        map.forEach(new BiConsumer() { // from class: dl.o
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.f46028a.m57660f((String) obj, (List) obj2);
            }
        });
    }

    /* renamed from: e */
    public final /* synthetic */ void m57659e(INativeAd iNativeAd) {
        if (iNativeAd == null) {
            C11839m.m70689w("PpsNativeAdListener", "nativeAd is null");
            return;
        }
        if (iNativeAd.getAppInfo() == null) {
            C11839m.m70689w("PpsNativeAdListener", "appInfo is null");
            return;
        }
        C11839m.m70688i("PpsNativeAdListener", "AppName: " + iNativeAd.getAppInfo().getAppName());
        String packageName = iNativeAd.getAppInfo().getPackageName();
        if (iNativeAd.isExpired() || !iNativeAd.isValid(C0213f.m1377a())) {
            C11839m.m70689w("PpsNativeAdListener", "nativeAd is expired");
            return;
        }
        if (this.f46034e == 0) {
            m57662h(iNativeAd);
        }
        this.f46032c.m57602g(packageName, iNativeAd);
    }

    /* renamed from: f */
    public final /* synthetic */ void m57660f(String str, List list) {
        C11839m.m70688i("PpsNativeAdListener", "key: " + str + ", " + Thread.currentThread().getName());
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = list.size();
        C11839m.m70688i("PpsNativeAdListener", "value size: " + size);
        m57657c(true, size);
        list.forEach(new Consumer() { // from class: dl.p
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f46029a.m57659e((INativeAd) obj);
            }
        });
    }

    /* renamed from: g */
    public void m57661g(int i10) {
        this.f46034e = i10;
    }

    /* renamed from: h */
    public final void m57662h(INativeAd iNativeAd) {
        C11839m.m70688i("PpsNativeAdListener", "enter showAndImpression");
        C9169e.a aVar = this.f46032c.m57600d().get(iNativeAd.getAppInfo().getPackageName());
        if (aVar == null) {
            C11839m.m70688i("PpsNativeAdListener", "adBiInfo is null");
            aVar = new C9169e.a();
            aVar.m57612g(iNativeAd);
        }
        if (aVar.m57609d()) {
            C11839m.m70689w("PpsNativeAdListener", "adBiInfo already has report show event");
        } else {
            boolean zRecordShowStartEvent = iNativeAd.recordShowStartEvent(C0213f.m1377a(), null);
            aVar.m57614i(zRecordShowStartEvent);
            C9168d.m57589e(ParamConstants.CallbackMethod.ON_SHOW, iNativeAd);
            C11839m.m70688i("PpsNativeAdListener", "recordShowStartEvent: " + zRecordShowStartEvent);
            C9169e.m57596e().m57603h(iNativeAd.getAppInfo().getPackageName(), aVar);
        }
        if (aVar.m57608c()) {
            C11839m.m70689w("PpsNativeAdListener", "adBiInfo already has report impression event");
            return;
        }
        boolean zRecordImpressionEvent = iNativeAd.recordImpressionEvent(C0213f.m1377a(), null);
        aVar.m57613h(zRecordImpressionEvent);
        C9168d.m57589e(VastAttribute.IMPRESSION, iNativeAd);
        C11839m.m70688i("PpsNativeAdListener", "recordImpressionEvent: " + zRecordImpressionEvent);
        C9169e.m57596e().m57603h(iNativeAd.getAppInfo().getPackageName(), aVar);
    }

    @Override // com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener
    public void onAdFailed(int i10) {
        C11839m.m70687e("PpsNativeAdListener", "onAdFailed errorCode: " + i10);
        C11060c c11060c = this.f46031b;
        if (c11060c != null) {
            c11060c.m66665u(String.valueOf(i10));
            this.f46031b.m66635A("");
            m57657c(false, 0);
        }
        this.f46033d.countDown();
    }

    @Override // com.huawei.openalliance.p169ad.inter.listeners.NativeAdListener
    public void onAdsLoaded(Map<String, List<INativeAd>> map) {
        C11839m.m70688i("PpsNativeAdListener", "onAdsLoaded");
        m57658d(map);
        C11060c c11060c = this.f46031b;
        if (c11060c != null) {
            c11060c.m66665u(String.valueOf(0));
            this.f46031b.m66635A("");
        }
        this.f46033d.countDown();
    }
}
