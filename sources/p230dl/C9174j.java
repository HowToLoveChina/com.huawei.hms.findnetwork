package p230dl;

import android.content.pm.PackageManager;
import android.text.TextUtils;
import ca.C1400c;
import cl.EnumC1453h;
import cl.InterfaceC1452g;
import com.huawei.android.hicloud.agd.ads.RestoreAdAppInfo;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.cloud.pay.model.FileterAdInfoRsp;
import com.huawei.hicloud.notification.manager.AdSwitchManager;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.ads.data.Keyword;
import com.huawei.hms.ads.data.SearchInfo;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.openalliance.p169ad.beans.parameter.RequestOptions;
import com.huawei.openalliance.p169ad.inter.NativeAdLoader;
import fk.C9721b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p015ak.C0213f;
import p260ek.C9499a;
import p261el.C9500a;
import p292fn.C9733f;
import p315gj.C9948a;
import p514o9.C11839m;
import p617rl.C12526j;
import p682ul.C13207a;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;

/* renamed from: dl.j */
/* loaded from: classes6.dex */
public class C9174j implements InterfaceC1452g {

    /* renamed from: a */
    public final C9169e f45992a;

    /* renamed from: b */
    public long f45993b;

    /* renamed from: c */
    public long f45994c;

    /* renamed from: d */
    public String f45995d;

    /* renamed from: e */
    public int f45996e;

    /* renamed from: dl.j$b */
    public static class b {

        /* renamed from: a */
        public int f45997a;

        /* renamed from: b */
        public int f45998b;

        /* renamed from: c */
        public int f45999c;

        /* renamed from: d */
        public int f46000d;

        /* renamed from: e */
        public int f46001e;

        /* renamed from: f */
        public boolean f46002f;

        /* renamed from: g */
        public String f46003g;

        public b() {
            this.f46002f = true;
            this.f46003g = "";
        }

        public String toString() {
            return "AdBiBean{restoreAppsNum=" + this.f45997a + ", installedRestoreAppsNum=" + this.f45998b + ", afterFilterByBusinessNum=" + this.f45999c + ", validAppAdNum=" + this.f46000d + ", matchAdNum=" + this.f46001e + " isAllowPPS: " + this.f46002f + " isAgState: " + this.f46003g + '}';
        }
    }

    public C9174j() {
        this.f45993b = 50L;
        this.f45994c = 100L;
        C9169e c9169eM57596e = C9169e.m57596e();
        this.f45992a = c9169eM57596e;
        c9169eM57596e.m57597a();
        String strM75351N0 = new C12526j().m75351N0("appBackupAGDConfig");
        c9169eM57596e.m57604i(strM75351N0);
        if (TextUtils.isEmpty(strM75351N0)) {
            return;
        }
        this.f45993b = C9499a.m59435c(strM75351N0, "ppsAdCount", 50);
        this.f45994c = C9499a.m59435c(strM75351N0, "ppsAllowListCount", 100);
        this.f45995d = C9499a.m59436d(strM75351N0, "ppsSearchInfoAdId");
        this.f45996e = C9499a.m59435c(strM75351N0, "ppsImpressionMode", 0);
    }

    /* renamed from: k */
    public static /* synthetic */ boolean m57618k(PackageManager packageManager, RestoreAdAppInfo restoreAdAppInfo) {
        return restoreAdAppInfo != null && ICBUtil.getVersionCode(packageManager, restoreAdAppInfo.getPackageName()) > 0;
    }

    /* renamed from: q */
    public static /* synthetic */ Keyword m57619q(RestoreAdAppInfo restoreAdAppInfo) {
        C11839m.m70686d("PPSRestorePrepareProcessor", restoreAdAppInfo.getAppName());
        return new Keyword(1, restoreAdAppInfo.getAppName());
    }

    /* renamed from: f */
    public final void m57620f(b bVar) {
        C11839m.m70688i("PPSRestorePrepareProcessor", "enter biReport: " + bVar.toString());
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put(C6148x2.DEVICE_ID, C13452e.m80781L().m80954p());
        linkedHashMapM79497A.put("restoreAppsNum", String.valueOf(bVar.f45997a));
        linkedHashMapM79497A.put("installedRestoreAppsNum", String.valueOf(bVar.f45998b));
        linkedHashMapM79497A.put("afterFilterByBusinessNum", String.valueOf(bVar.f45999c));
        linkedHashMapM79497A.put("validAppAdNum", String.valueOf(bVar.f46000d));
        linkedHashMapM79497A.put("matchAdNum", String.valueOf(bVar.f46001e));
        linkedHashMapM79497A.put("ppsAllow", String.valueOf(bVar.f46002f));
        linkedHashMapM79497A.put("ppsSwitchState", String.valueOf(bVar.f46003g));
        C13225d.m79490f1().m79567R("action_code_restore_app_by_pps", linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", "action_code_restore_app_by_pps", linkedHashMapM79497A);
    }

    /* renamed from: h */
    public final List<RestoreAdAppInfo> m57621h(List<RestoreAdAppInfo> list) {
        C11839m.m70688i("PPSRestorePrepareProcessor", "enter getFilterPpsAppInfoList");
        if (list.isEmpty()) {
            C11839m.m70688i("PPSRestorePrepareProcessor", "filterPpsAppInfoList is Empty");
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        try {
            int size = list.size();
            int i10 = 0;
            while (true) {
                long j10 = i10;
                if (this.f45994c * j10 >= size) {
                    return arrayList;
                }
                FileterAdInfoRsp fileterAdInfoRspM61682m = C9948a.m61631C().m61682m((List) list.stream().skip(j10 * this.f45994c).limit(this.f45994c).collect(Collectors.toList()));
                if (fileterAdInfoRspM61682m == null) {
                    C11839m.m70689w("PPSRestorePrepareProcessor", "fileterSeverAppInfoRsp is null");
                } else if (fileterAdInfoRspM61682m.getResultCode() == 0) {
                    arrayList.addAll(fileterAdInfoRspM61682m.getAppInfoList());
                    C11839m.m70688i("PPSRestorePrepareProcessor", "request business server succeed");
                } else {
                    C11839m.m70689w("PPSRestorePrepareProcessor", "request business server failed, result code: " + fileterAdInfoRspM61682m.getResultCode() + ", desc: " + fileterAdInfoRspM61682m.getResultDesc());
                }
                i10++;
            }
        } catch (C9721b unused) {
            C11839m.m70687e("PPSRestorePrepareProcessor", "request business server error");
            if (arrayList.isEmpty()) {
                return new ArrayList();
            }
            C11839m.m70689w("PPSRestorePrepareProcessor", "result is not empty");
            return arrayList;
        }
    }

    /* renamed from: i */
    public final boolean m57622i(boolean z10, boolean z11) {
        if (TextUtils.isEmpty(this.f45995d)) {
            C11839m.m70688i("PPSRestorePrepareProcessor", "ppsAdId is empty");
            return false;
        }
        String str = z10 ? "cloudBackupRefurbishPPSCapbility" : z11 ? "cloudBackupTempPPSCapbility" : "cloudBackupPPSCapbility";
        if (!C9733f.m60705z().m60720O(str)) {
            C11839m.m70689w("PPSRestorePrepareProcessor", str + " switch close");
            return false;
        }
        try {
            C13207a.m79404c().m79409d(C0213f.m1377a(), C13207a.b.PROTOCOL);
        } catch (C9721b e10) {
            C11839m.m70687e("PPSRestorePrepareProcessor", "isAgreeAgdProtocol error: " + e10.getMessage());
        }
        try {
            C13207a.m79404c().m79408b(C13207a.a.WHITE_LIST);
        } catch (C9721b e11) {
            C11839m.m70687e("PPSRestorePrepareProcessor", "getAgreeAgd error: " + e11.getMessage());
        }
        if (C13207a.m79404c().m79410e()) {
            return true;
        }
        C11839m.m70689w("PPSRestorePrepareProcessor", "is not allow agdDownload");
        return false;
    }

    @Override // cl.InterfaceC1452g
    public EnumC1453h identity() {
        return EnumC1453h.PPS;
    }

    @Override // cl.InterfaceC1452g
    /* renamed from: l */
    public void mo7504l(String str, boolean z10, boolean z11, int i10) throws InterruptedException {
        C11839m.m70688i("PPSRestorePrepareProcessor", "enter prepare");
        b bVar = new b();
        if (!m57622i(z10, z11)) {
            bVar.f46002f = false;
            bVar.f46003g = C13207a.m79404c().m79407a();
            m57620f(bVar);
            return;
        }
        C1400c.m8059f(C0213f.m1377a());
        List<RestoreAdAppInfo> listM59440d = i10 == 1 ? C9500a.m59440d() : C9500a.m59439c();
        C11839m.m70688i("PPSRestorePrepareProcessor", "restoreAdApps size: " + listM59440d.size());
        List<RestoreAdAppInfo> listM57621h = m57621h(listM59440d);
        m57624r(listM57621h);
        final PackageManager packageManager = C0213f.m1377a().getPackageManager();
        bVar.f45998b = (int) listM57621h.stream().filter(new Predicate() { // from class: dl.g
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C9174j.m57618k(packageManager, (RestoreAdAppInfo) obj);
            }
        }).count();
        bVar.f45997a = listM59440d.size();
        bVar.f45999c = listM57621h.size();
        bVar.f46000d = this.f45992a.m57598b().size();
        bVar.f46001e = (int) listM57621h.stream().filter(new Predicate() { // from class: dl.h
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f45990a.m57623p(packageManager, (RestoreAdAppInfo) obj);
            }
        }).count();
        bVar.f46003g = C13207a.m79404c().m79407a();
        m57620f(bVar);
    }

    /* renamed from: p */
    public final /* synthetic */ boolean m57623p(PackageManager packageManager, RestoreAdAppInfo restoreAdAppInfo) {
        return restoreAdAppInfo != null && this.f45992a.m57598b().containsKey(restoreAdAppInfo.getPackageName()) && ICBUtil.getVersionCode(packageManager, restoreAdAppInfo.getPackageName()) <= 0;
    }

    /* renamed from: r */
    public final void m57624r(List<RestoreAdAppInfo> list) throws InterruptedException {
        int size = list.size();
        C11839m.m70688i("PPSRestorePrepareProcessor", "enter requestAdList, ppsAdAppInfoList size: " + size);
        C9169e.m57596e().m57605j(System.currentTimeMillis());
        String[] strArr = {this.f45995d};
        CountDownLatch countDownLatch = new CountDownLatch((int) Math.ceil(((double) size) / ((double) this.f45993b)));
        int i10 = 0;
        while (true) {
            long j10 = i10;
            if (this.f45993b * j10 >= size) {
                try {
                    countDownLatch.await(60L, TimeUnit.SECONDS);
                    return;
                } catch (InterruptedException unused) {
                    C11839m.m70687e("PPSRestorePrepareProcessor", "countDownLatch.await timeout");
                    return;
                }
            }
            List list2 = (List) list.stream().skip(j10 * this.f45993b).limit(this.f45993b).collect(Collectors.toList());
            List<Keyword> list3 = (List) list2.stream().map(new Function() { // from class: dl.i
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return C9174j.m57619q((RestoreAdAppInfo) obj);
                }
            }).collect(Collectors.toList());
            SearchInfo searchInfo = new SearchInfo();
            searchInfo.setKeywords(list3);
            searchInfo.setChannel(String.valueOf(1));
            RequestOptions.Builder ppsRequestOptionsBuilder = AdSwitchManager.getInstance().getPpsRequestOptionsBuilder();
            ppsRequestOptionsBuilder.setSearchInfo(searchInfo);
            NativeAdLoader nativeAdLoader = new NativeAdLoader(C0213f.m1377a(), strArr, 9, null);
            nativeAdLoader.setRequestOptions(ppsRequestOptionsBuilder.build());
            C9181q c9181q = new C9181q(list2, this.f45992a, countDownLatch);
            c9181q.m57661g(this.f45996e);
            nativeAdLoader.setListener(c9181q);
            nativeAdLoader.loadAds(C1400c.m8056b(), false);
            i10++;
        }
    }
}
