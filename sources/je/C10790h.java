package je;

import android.text.TextUtils;
import ao.C1005a;
import com.huawei.android.hicloud.agd.ads.DownloadParam;
import com.huawei.android.hicloud.agd.ads.RestoreAdAppInfo;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreAdsInfo;
import com.huawei.android.hicloud.cloudbackup.bean.RestoreModuleReportInfo;
import com.huawei.android.hicloud.task.simple.C3059m1;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import fk.C9721b;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import p015ak.C0213f;
import p230dl.C9169e;
import p292fn.C9733f;
import p429kk.C11058a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p682ul.C13207a;
import p709vj.C13452e;

/* renamed from: je.h */
/* loaded from: classes3.dex */
public class C10790h {

    /* renamed from: a */
    public static long f51538a;

    /* renamed from: b */
    public static final Map<String, RestoreAdsInfo> f51539b = new ConcurrentHashMap();

    /* renamed from: je.h$a */
    public static class a extends AbstractC12367d {

        /* renamed from: a */
        public final RestoreAdsInfo f51540a;

        /* renamed from: b */
        public final CountDownLatch f51541b;

        public a(RestoreAdsInfo restoreAdsInfo, CountDownLatch countDownLatch) {
            this.f51540a = restoreAdsInfo;
            this.f51541b = countDownLatch;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C10790h.m65665m(this.f51540a);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public void release() {
            super.release();
            this.f51541b.countDown();
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public boolean syncLock() {
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m65656d(boolean z10, boolean z11) {
        if (!C9733f.m60705z().m60720O(z10 ? "cloudBackupRefurbishAGDCapbility" : z11 ? "cloudBackupTempAGDCapbility" : "cloudBackupAGDCapbility")) {
            C11839m.m70689w("CloudRestoreAgdHelper", "feature switch close");
            return false;
        }
        if (C13207a.m79404c().m79410e()) {
            return true;
        }
        C11839m.m70689w("CloudRestoreAgdHelper", "not agree agd protocol");
        return false;
    }

    /* renamed from: e */
    public static DownloadParam m65657e(String str) {
        RestoreAdsInfo restoreAdsInfo = f51539b.get(str);
        if (restoreAdsInfo == null) {
            return null;
        }
        return restoreAdsInfo.getDownloadParam();
    }

    /* renamed from: f */
    public static boolean m65658f(boolean z10, boolean z11, String str) {
        return m65656d(z10, z11) && f51539b.get(str) != null;
    }

    /* renamed from: g */
    public static boolean m65659g(String str, long j10) throws NumberFormatException {
        long j11;
        RestoreAdsInfo restoreAdsInfo = f51539b.get(str);
        if (restoreAdsInfo == null) {
            return false;
        }
        C11839m.m70686d("CloudRestoreAgdHelper", "isSameAsAgdVersion: " + j10 + " , " + restoreAdsInfo.getVersionCode());
        try {
            j11 = Long.parseLong(restoreAdsInfo.getVersionCode());
        } catch (NumberFormatException unused) {
            C11839m.m70687e("CloudRestoreAgdHelper", "isCanUpdateFromAgdVersion NumberFormatException");
            j11 = 0;
        }
        return j11 > j10;
    }

    /* renamed from: h */
    public static /* synthetic */ boolean m65660h(RestoreAdsInfo restoreAdsInfo) {
        return !restoreAdsInfo.isShow();
    }

    /* renamed from: i */
    public static /* synthetic */ void m65661i(CountDownLatch countDownLatch, RestoreAdsInfo restoreAdsInfo) {
        C12515a.m75110o().m75172d(new a(restoreAdsInfo, countDownLatch));
    }

    /* renamed from: j */
    public static void m65662j(LinkedHashMap<String, String> linkedHashMap, RestoreModuleReportInfo restoreModuleReportInfo) {
        String appId = restoreModuleReportInfo.getAppId();
        C9169e.a aVar = C9169e.m57596e().m57600d().get(appId);
        String str = NotifyConstants.CommonReportConstants.FAILED;
        if (aVar != null) {
            C11839m.m70688i("CloudRestoreAgdHelper", appId + " ppsBiInfo is not null");
            linkedHashMap.put("pps_search_time", String.valueOf(C9169e.m57596e().m57601f()));
            linkedHashMap.put("pps_is_show", aVar.m57609d() ? "success" : NotifyConstants.CommonReportConstants.FAILED);
            linkedHashMap.put("pps_is_impress", aVar.m57608c() ? "success" : NotifyConstants.CommonReportConstants.FAILED);
            linkedHashMap.put("pps_is_click", aVar.m57607b() ? "success" : NotifyConstants.CommonReportConstants.FAILED);
            linkedHashMap.put("pps_download_detail_id", aVar.m57606a().getUniqueId());
            linkedHashMap.put("ppsDownloadSource", aVar.m57606a().getAppInfo().getDownloadUrl());
            linkedHashMap.put("ppsDownloadVersion", restoreModuleReportInfo.getPpsDownloadVersion());
            boolean zEquals = Boolean.TRUE.equals(restoreModuleReportInfo.isPpsDownloadSuccess());
            linkedHashMap.put("ppsDownloadSuccess", String.valueOf(zEquals));
            C11839m.m70688i("CloudRestoreAgdHelper", appId + " ppsDownloadSuccess: " + zEquals);
            if (zEquals) {
                linkedHashMap.put("appSourceType", String.valueOf(1));
            }
        }
        String apkDownloadSource = restoreModuleReportInfo.getApkDownloadSource();
        String agdDownloadVersion = restoreModuleReportInfo.getAgdDownloadVersion();
        Boolean boolIsAgdDownloadSuccess = restoreModuleReportInfo.isAgdDownloadSuccess();
        if (!TextUtils.isEmpty(apkDownloadSource)) {
            linkedHashMap.put("apkDownloadSource", apkDownloadSource);
        }
        if (!TextUtils.isEmpty(agdDownloadVersion)) {
            linkedHashMap.put("agdDownloadVersion", agdDownloadVersion);
        }
        if (boolIsAgdDownloadSuccess != null) {
            linkedHashMap.put("agdDownloadSuccess", String.valueOf(boolIsAgdDownloadSuccess));
            if (boolIsAgdDownloadSuccess.booleanValue()) {
                linkedHashMap.put("appSourceType", String.valueOf(0));
            }
        }
        RestoreAdsInfo restoreAdsInfo = f51539b.get(appId);
        if (restoreAdsInfo != null) {
            C11839m.m70688i("CloudRestoreAgdHelper", appId + " AGBiInfo is not null");
            linkedHashMap.put("agd_search_time", String.valueOf(f51538a));
            linkedHashMap.put("agd_is_show", restoreAdsInfo.isShow() ? "success" : NotifyConstants.CommonReportConstants.FAILED);
            if (restoreAdsInfo.isClick()) {
                str = "success";
            }
            linkedHashMap.put("agd_is_click", str);
            linkedHashMap.put("agd_download_detail_id", restoreAdsInfo.getDownloadParam() == null ? "" : restoreAdsInfo.getDownloadParam().getDetailId());
        }
    }

    /* renamed from: k */
    public static void m65663k(List<RestoreAdAppInfo> list, String str, boolean z10) throws InterruptedException {
        m65666n(new HashMap());
        if (list == null || list.size() <= 0) {
            return;
        }
        String str2 = z10 ? "cloudBackupRefurbishAGDCapbility" : "cloudBackupAGDCapbility";
        if (!C9733f.m60705z().m60720O(str2)) {
            C11839m.m70689w("CloudRestoreAgdHelper", str2 + " switch close");
            return;
        }
        try {
            C13207a.m79404c().m79409d(C0213f.m1377a(), C13207a.b.PROTOCOL);
        } catch (C9721b e10) {
            C11839m.m70687e("CloudRestoreAgdHelper", "isAgreeAgdProtocol error: " + e10.getMessage());
        }
        try {
            C13207a.m79404c().m79408b(C13207a.a.WHITE_LIST);
        } catch (C9721b e11) {
            C11839m.m70687e("CloudRestoreAgdHelper", "getAgreeAgd error: " + e11.getMessage());
        }
        if (!C13207a.m79404c().m79410e()) {
            C11839m.m70689w("CloudRestoreAgdHelper", "is not allow agdDownload");
            return;
        }
        try {
            f51538a = System.currentTimeMillis();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            C12515a.m75110o().m75172d(new C3059m1(list, countDownLatch, str));
            C11839m.m70686d("CloudRestoreAgdHelper", "queryAppAdsFromAgd: " + countDownLatch.await(60L, TimeUnit.SECONDS));
        } catch (Exception e12) {
            C11839m.m70687e("CloudRestoreAgdHelper", "queryAppAdsFromAgd error: " + e12.getMessage());
        }
    }

    /* renamed from: l */
    public static boolean m65664l(String str) {
        RestoreAdsInfo restoreAdsInfo = f51539b.get(str);
        if (restoreAdsInfo == null || !m65665m(restoreAdsInfo)) {
            C11839m.m70687e("CloudRestoreAgdHelper", "reportClickEvent reportShowEvent fail");
            return false;
        }
        if (restoreAdsInfo.isClick()) {
            return true;
        }
        String clickUrl = restoreAdsInfo.getClickUrl();
        if (TextUtils.isEmpty(clickUrl)) {
            C11839m.m70687e("CloudRestoreAgdHelper", restoreAdsInfo.getPackageName() + ": reportClickEvent clickUrl is null");
            return false;
        }
        if (C1005a.m5932b().m5935d(restoreAdsInfo.getAdId(), null, clickUrl.replace("__CLICKTYPE__", JsbMapKeyNames.H5_TEXT_DOWNLOAD_INSTALL), "click", C11058a.m66626a(C11058a.m66627b("07052"), "07052", C13452e.m80781L().m80971t0())) == null) {
            C11839m.m70687e("CloudRestoreAgdHelper", restoreAdsInfo.getPackageName() + ": reportClickEvent fail");
            return false;
        }
        C11839m.m70688i("CloudRestoreAgdHelper", restoreAdsInfo.getPackageName() + ": reportClickEvent success");
        restoreAdsInfo.setClick(true);
        return true;
    }

    /* renamed from: m */
    public static boolean m65665m(RestoreAdsInfo restoreAdsInfo) {
        if (restoreAdsInfo == null) {
            C11839m.m70687e("CloudRestoreAgdHelper", "restoreAdsInfo is null");
            return false;
        }
        if (restoreAdsInfo.isShow()) {
            return true;
        }
        String showUrl = restoreAdsInfo.getShowUrl();
        if (TextUtils.isEmpty(showUrl)) {
            C11839m.m70687e("CloudRestoreAgdHelper", restoreAdsInfo.getPackageName() + ": reportShowEvent showUrl is null");
            return false;
        }
        if (C1005a.m5932b().m5935d(restoreAdsInfo.getAdId(), null, showUrl.replace("__TIME__", String.valueOf(2000)), ParamConstants.CallbackMethod.ON_SHOW, C11058a.m66626a(C11058a.m66627b("07052"), "07052", C13452e.m80781L().m80971t0())) == null) {
            C11839m.m70687e("CloudRestoreAgdHelper", restoreAdsInfo.getPackageName() + ": reportShowEvent fail");
            return false;
        }
        C11839m.m70688i("CloudRestoreAgdHelper", restoreAdsInfo.getPackageName() + ": reportShowEvent success");
        restoreAdsInfo.setShow(true);
        return true;
    }

    /* renamed from: n */
    public static void m65666n(Map<String, RestoreAdsInfo> map) {
        Map<String, RestoreAdsInfo> map2 = f51539b;
        map2.clear();
        map2.putAll(map);
    }

    /* renamed from: o */
    public static void m65667o() throws InterruptedException {
        Map<String, RestoreAdsInfo> map = f51539b;
        Map map2 = (Map) map.values().stream().filter(new Predicate() { // from class: je.e
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return C10790h.m65660h((RestoreAdsInfo) obj);
            }
        }).collect(Collectors.toMap(new Function() { // from class: je.f
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((RestoreAdsInfo) obj).getPackageName();
            }
        }, Function.identity()));
        if (map2 == null || map2.size() == 0) {
            C11839m.m70688i("CloudRestoreAgdHelper", "Agd ads event supplementary data is null. The adsAppMap size is:" + map.size());
            return;
        }
        C11839m.m70688i("CloudRestoreAgdHelper", "Agd ads event supplementary data size is:" + map2.size());
        final CountDownLatch countDownLatch = new CountDownLatch(map2.size());
        map2.values().forEach(new Consumer() { // from class: je.g
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                C10790h.m65661i(countDownLatch, (RestoreAdsInfo) obj);
            }
        });
        try {
            countDownLatch.await(60L, TimeUnit.SECONDS);
            if (countDownLatch.getCount() > 0) {
                C12515a.m75110o().m75166b(a.class.getName());
            }
            C11839m.m70688i("CloudRestoreAgdHelper", "Agd ads event supplementary end.");
        } catch (InterruptedException unused) {
            C11839m.m70687e("CloudRestoreAgdHelper", "supplementaryReportShowEvent error.");
        }
    }
}
