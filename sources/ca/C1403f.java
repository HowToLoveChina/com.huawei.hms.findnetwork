package ca;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.agd.ads.AdInfo;
import com.huawei.android.hicloud.agd.ads.AppDownloadInfo;
import com.huawei.android.hicloud.agd.ads.DownLoadState;
import com.huawei.android.hicloud.agd.ads.MaterialMeta;
import com.huawei.cloud.pay.model.HiCloudNativeAd;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.sync.R$string;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import p015ak.C0209d;
import p015ak.C0213f;
import p292fn.C9733f;
import p329h7.C10120h;
import p329h7.EnumC10122j;
import p514o9.C11839m;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;

/* renamed from: ca.f */
/* loaded from: classes3.dex */
public class C1403f implements Consumer<DownLoadState> {

    /* renamed from: m */
    public static volatile C1403f f6008m;

    /* renamed from: n */
    public static final Object f6009n = new Object();

    /* renamed from: o */
    public static final Object f6010o = new Object();

    /* renamed from: p */
    public static final Object f6011p = new Object();

    /* renamed from: q */
    public static final Object f6012q = new Object();

    /* renamed from: a */
    public final Context f6013a = C0213f.m1377a();

    /* renamed from: b */
    public final HashMap<String, HashMap<String, INativeAd>> f6014b = new HashMap<>(10);

    /* renamed from: c */
    public final HashMap<String, HashMap<String, INativeAd>> f6015c = new HashMap<>(10);

    /* renamed from: d */
    public final HashMap<String, HashMap<String, AdInfo>> f6016d = new HashMap<>(10);

    /* renamed from: e */
    public final HashMap<String, HashMap<String, AdInfo>> f6017e = new HashMap<>(10);

    /* renamed from: f */
    public C10120h f6018f;

    /* renamed from: g */
    public String f6019g;

    /* renamed from: h */
    public String f6020h;

    /* renamed from: i */
    public String f6021i;

    /* renamed from: j */
    public Handler f6022j;

    /* renamed from: k */
    public String f6023k;

    /* renamed from: l */
    public String f6024l;

    /* renamed from: A */
    public static /* synthetic */ void m8063A(CountDownLatch countDownLatch, AtomicInteger atomicInteger, DownLoadState downLoadState) {
        countDownLatch.countDown();
        atomicInteger.set(downLoadState.getProgress());
    }

    /* renamed from: n */
    public static C1403f m8066n() {
        if (f6008m == null) {
            synchronized (C1403f.class) {
                try {
                    if (f6008m == null) {
                        f6008m = new C1403f();
                    }
                } finally {
                }
            }
        }
        return f6008m;
    }

    /* renamed from: z */
    public static /* synthetic */ void m8067z(CountDownLatch countDownLatch, AtomicReference atomicReference, DownLoadState downLoadState) {
        countDownLatch.countDown();
        atomicReference.set(downLoadState.transAppStatus());
    }

    /* renamed from: B */
    public void m8068B(String str, String str2) {
        if (m8103u(str, str2) || m8104v(str, str2)) {
            C11839m.m70688i("WapAdsManager", "openAgdApp is pps ad.");
            return;
        }
        AdInfo adInfoM8090g = m8090g(str, str2);
        if (adInfoM8090g == null || adInfoM8090g.getMaterial() == null) {
            C11839m.m70687e("WapAdsManager", "openAgdApp:adInfo is null");
            return;
        }
        if (this.f6018f != null) {
            this.f6023k = adInfoM8090g.getMaterial().getAppInfo().getPackageName();
            this.f6024l = m8094k(str, str2);
            this.f6018f.m63030w(this.f6023k);
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put(NotifyConstants.CloudStorageConstants.AD_NAME_KEY, str);
            m8070D(this.f6023k, "exp_agd_ads_event", linkedHashMap);
        }
    }

    /* renamed from: C */
    public void m8069C(String str, String str2) {
        if (m8103u(str, str2) || m8104v(str, str2)) {
            INativeAd iNativeAdM8098p = m8098p(str, str2);
            if (iNativeAdM8098p == null) {
                C11839m.m70688i("WapAdsManager", "ad not found");
                return;
            } else {
                C1398a.m8017j().pauseDownload(C0213f.m1377a(), iNativeAdM8098p);
                return;
            }
        }
        AdInfo adInfoM8090g = m8090g(str, str2);
        if (adInfoM8090g == null || adInfoM8090g.getMaterial() == null) {
            C11839m.m70687e("WapAdsManager", "pauseDownload:adInfo is null");
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("terminal_agd_ads_reason_key", String.valueOf(6));
        m8070D(adInfoM8090g.getMaterial().getAppInfo().getPackageName(), "terminal_agd_ads_event", linkedHashMap);
        C10120h c10120h = this.f6018f;
        if (c10120h != null) {
            c10120h.m63031x(adInfoM8090g.getMaterial().getAppInfo().getPackageName());
        }
    }

    /* renamed from: D */
    public final void m8070D(String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put(C6148x2.DEVICE_ID, C13452e.m80781L().m80954p());
        linkedHashMapM79497A.put("download_agd_ads_package_key", str);
        if (linkedHashMap != null) {
            linkedHashMapM79497A.putAll(linkedHashMap);
        }
        C13227f.m79492i1().m79567R(str2, linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", str2, linkedHashMapM79497A);
    }

    /* renamed from: E */
    public void m8071E(String str, String str2, String str3, String str4) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put(C6148x2.DEVICE_ID, C13452e.m80781L().m80954p());
        linkedHashMapM79497A.put(NotifyConstants.CloudStorageConstants.AD_NAME_KEY, str);
        linkedHashMapM79497A.put("unique_id", str2);
        linkedHashMapM79497A.put("is_support_agd_ads_event", str4);
        C13227f.m79492i1().m79567R(str3, linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", str3, linkedHashMapM79497A);
    }

    /* renamed from: F */
    public final void m8072F(String str, String str2, String str3) {
        if ("INSTALLED".equals(str)) {
            Message message = new Message();
            message.what = 106;
            message.obj = str2;
            Bundle bundle = new Bundle();
            bundle.putString(FaqConstants.FAQ_CHANNEL, str3);
            message.setData(bundle);
            this.f6022j.sendMessage(message);
        }
    }

    /* renamed from: G */
    public void m8073G() {
        m8089f(String.format(Locale.ENGLISH, "%s(%s);", this.f6021i, m8097o(this.f6023k)));
        Message message = new Message();
        message.what = 107;
        message.obj = this.f6023k;
        Bundle bundle = new Bundle();
        bundle.putString(FaqConstants.FAQ_CHANNEL, this.f6024l);
        message.setData(bundle);
        this.f6022j.sendMessage(message);
    }

    /* renamed from: H */
    public int m8074H(String str, String str2) {
        if (m8103u(str, str2) || m8104v(str, str2)) {
            INativeAd iNativeAdM8098p = m8098p(str, str2);
            if (iNativeAdM8098p != null) {
                return C1398a.m8017j().resumeDownload(C0213f.m1377a(), iNativeAdM8098p);
            }
            C11839m.m70688i("WapAdsManager", "ad not found");
            return -100;
        }
        AdInfo adInfoM8090g = m8090g(str, str2);
        if (adInfoM8090g == null || adInfoM8090g.getMaterial() == null) {
            C11839m.m70687e("WapAdsManager", "resumeDownload:adInfo is null");
            return -100;
        }
        if (!C0209d.m1333z1(this.f6013a)) {
            m8084R(this.f6013a.getString(R$string.alert_net_disconnect_new));
            return -100;
        }
        if (this.f6018f == null) {
            return -100;
        }
        return this.f6018f.m63018C(new AppDownloadInfo(str, adInfoM8090g.getMaterial().getAppInfo().getPackageName(), str2, m8094k(str, str2)));
    }

    /* renamed from: I */
    public void m8075I(Map<String, List<AdInfo>> map) {
        synchronized (f6011p) {
            try {
                for (Map.Entry<String, List<AdInfo>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (this.f6016d.containsKey(key)) {
                        this.f6016d.remove(key);
                    }
                    List<AdInfo> value = entry.getValue();
                    HashMap<String, AdInfo> map2 = new HashMap<>();
                    for (AdInfo adInfo : value) {
                        map2.put(adInfo.getMaterial().getAppInfo().getAppId(), adInfo);
                    }
                    this.f6016d.put(key, map2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: J */
    public void m8076J(Map<String, List<AdInfo>> map) {
        synchronized (f6012q) {
            try {
                for (Map.Entry<String, List<AdInfo>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (this.f6017e.containsKey(key)) {
                        this.f6017e.remove(key);
                    }
                    List<AdInfo> value = entry.getValue();
                    HashMap<String, AdInfo> map2 = new HashMap<>();
                    for (AdInfo adInfo : value) {
                        map2.put(adInfo.getMaterial().getAppInfo().getAppId(), adInfo);
                    }
                    this.f6017e.put(key, map2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: K */
    public void m8077K(Map<String, List<INativeAd>> map) {
        synchronized (f6009n) {
            try {
                String strM8024q = C1398a.m8024q();
                C11839m.m70686d("WapAdsManager", "getReportCid:" + strM8024q);
                for (Map.Entry<String, List<INativeAd>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (this.f6014b.keySet().contains(key)) {
                        this.f6014b.remove(key);
                    }
                    List<INativeAd> value = entry.getValue();
                    HashMap<String, INativeAd> map2 = new HashMap<>();
                    for (INativeAd iNativeAd : value) {
                        C1400c.m8061h(iNativeAd, strM8024q);
                        map2.put(iNativeAd.getUniqueId(), iNativeAd);
                    }
                    this.f6014b.put(key, map2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: L */
    public void m8078L(Map<String, List<INativeAd>> map) {
        synchronized (f6010o) {
            try {
                for (Map.Entry<String, List<INativeAd>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (this.f6015c.keySet().contains(key)) {
                        this.f6015c.remove(key);
                    }
                    List<INativeAd> value = entry.getValue();
                    HashMap<String, INativeAd> map2 = new HashMap<>();
                    for (INativeAd iNativeAd : value) {
                        map2.put(iNativeAd.getUniqueId(), iNativeAd);
                    }
                    this.f6015c.put(key, map2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: M */
    public void m8079M(C10120h c10120h) {
        this.f6018f = c10120h;
        c10120h.m63019D(this);
    }

    /* renamed from: N */
    public void m8080N(Handler handler) {
        this.f6022j = handler;
    }

    /* renamed from: O */
    public void m8081O(String str) {
        this.f6021i = str;
    }

    /* renamed from: P */
    public void m8082P(String str) {
        this.f6020h = str;
    }

    /* renamed from: Q */
    public void m8083Q(String str) {
        this.f6019g = str;
    }

    /* renamed from: R */
    public void m8084R(String str) {
        Message message = new Message();
        message.what = 105;
        Bundle bundle = new Bundle();
        bundle.putString("toast_content", str);
        message.setData(bundle);
        this.f6022j.sendMessage(message);
    }

    /* renamed from: S */
    public int m8085S(String str, String str2) {
        int iStartDownload = -100;
        if (m8103u(str, str2) || m8104v(str, str2)) {
            C11839m.m70688i("WapAdsManager", "download with pps");
            INativeAd iNativeAdM8098p = m8098p(str, str2);
            if (iNativeAdM8098p == null) {
                C11839m.m70689w("WapAdsManager", "ad not found");
                return -100;
            }
            iStartDownload = C1398a.m8017j().startDownload(C0213f.m1377a(), iNativeAdM8098p);
        } else {
            C11839m.m70688i("WapAdsManager", "download with AgAd");
            AdInfo adInfoM8090g = m8090g(str, str2);
            if (adInfoM8090g == null || adInfoM8090g.getMaterial() == null) {
                C11839m.m70687e("WapAdsManager", "startDownload:adInfo is null");
                return -100;
            }
            if (!C0209d.m1333z1(this.f6013a)) {
                m8084R(this.f6013a.getString(R$string.alert_net_disconnect_new));
                return -100;
            }
            if (this.f6018f != null) {
                MaterialMeta material = adInfoM8090g.getMaterial();
                String packageName = material.getAppInfo().getPackageName();
                m8070D(packageName, "download_agd_ads_event", null);
                this.f6018f.m63021F(new AppDownloadInfo(str, packageName, str2, m8094k(str, str2)), material.getAppInfo().getDownloadParam(), EnumC10122j.SILENT_INSTALL_TYPE);
                iStartDownload = 0;
            }
        }
        C11839m.m70688i("WapAdsManager", "startDownload result:" + iStartDownload);
        return iStartDownload;
    }

    @Override // java.util.function.Consumer
    /* renamed from: c */
    public void accept(DownLoadState downLoadState) {
        if (TextUtils.isEmpty(this.f6019g) || TextUtils.isEmpty(this.f6020h)) {
            C11839m.m70687e("WapAdsManager", "listener is empty");
            return;
        }
        AppDownloadInfo appDownloadInfo = downLoadState.getAppDownloadInfo();
        String packageName = appDownloadInfo.getPackageName();
        Locale locale = Locale.ENGLISH;
        m8089f(String.format(locale, "%s(%s,%s)", this.f6019g, m8097o(downLoadState.transAppStatus()), m8097o(packageName)));
        m8072F(downLoadState.transAppStatus(), packageName, appDownloadInfo.getChannelName());
        if (downLoadState.isDownloadStatus()) {
            m8089f(String.format(locale, "%s(%d,%s)", this.f6020h, Integer.valueOf(downLoadState.getProgress()), m8097o(packageName)));
        }
        if (downLoadState.isTerminalType()) {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("terminal_agd_ads_reason_key", String.valueOf(downLoadState.getAppStatus()));
            m8070D(appDownloadInfo.getPackageName(), "terminal_agd_ads_event", linkedHashMap);
        }
    }

    /* renamed from: d */
    public void m8087d(String str, String str2) {
        if (m8103u(str, str2) || m8104v(str, str2)) {
            INativeAd iNativeAdM8098p = m8098p(str, str2);
            if (iNativeAdM8098p == null) {
                C11839m.m70688i("WapAdsManager", "ad not found");
                return;
            } else {
                C1398a.m8017j().cancelDownload(C0213f.m1377a(), iNativeAdM8098p);
                return;
            }
        }
        AdInfo adInfoM8090g = m8090g(str, str2);
        if (adInfoM8090g == null || adInfoM8090g.getMaterial() == null) {
            C11839m.m70687e("WapAdsManager", "cancelDownload:adInfo is null");
            return;
        }
        C10120h c10120h = this.f6018f;
        if (c10120h != null) {
            c10120h.m63024l(adInfoM8090g.getMaterial().getAppInfo().getPackageName());
        }
    }

    /* renamed from: e */
    public void m8088e() {
        this.f6014b.clear();
        this.f6015c.clear();
        this.f6016d.clear();
        this.f6017e.clear();
    }

    /* renamed from: f */
    public final void m8089f(String str) {
        Message message = new Message();
        message.what = 100;
        Bundle bundle = new Bundle();
        bundle.putString("javascript", str);
        message.setData(bundle);
        this.f6022j.sendMessage(message);
    }

    /* renamed from: g */
    public AdInfo m8090g(String str, String str2) {
        if (m8101s(str, str2)) {
            return m8091h(str, str2);
        }
        if (m8102t(str, str2)) {
            return m8092i(str, str2);
        }
        return null;
    }

    /* renamed from: h */
    public AdInfo m8091h(String str, String str2) {
        synchronized (f6011p) {
            try {
                HashMap<String, AdInfo> map = this.f6016d.get(str);
                if (map == null) {
                    return null;
                }
                return map.get(str2);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: i */
    public AdInfo m8092i(String str, String str2) {
        synchronized (f6012q) {
            try {
                HashMap<String, AdInfo> map = this.f6017e.get(str);
                if (map == null) {
                    return null;
                }
                return map.get(str2);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: j */
    public String m8093j(String str, String str2) throws InterruptedException {
        boolean zAwait;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference atomicReference = new AtomicReference();
        if (m8103u(str, str2) || m8104v(str, str2)) {
            C11839m.m70688i("WapAdsManager", "getAppStatus isPpsAds");
            INativeAd iNativeAdM8098p = m8098p(str, str2);
            if (iNativeAdM8098p != null) {
                return C1398a.m8017j().getAppStatus(C0213f.m1377a(), iNativeAdM8098p).toString();
            }
            C11839m.m70688i("WapAdsManager", "ad not found adId: " + str + " uniqueId: " + str2);
            return "0";
        }
        AdInfo adInfoM8090g = m8090g(str, str2);
        if (adInfoM8090g == null || adInfoM8090g.getMaterial() == null) {
            C11839m.m70687e("WapAdsManager", "getAppStatus:adInfo is null");
            return "DOWNLOADFAILED";
        }
        if (C0209d.m1184K0(this.f6013a, adInfoM8090g.getMaterial().getAppInfo().getPackageName())) {
            return "INSTALLED";
        }
        if (this.f6018f != null) {
            this.f6018f.m63032y(new AppDownloadInfo(str, adInfoM8090g.getMaterial().getAppInfo().getPackageName(), str2, m8094k(str, str2)), new Consumer() { // from class: ca.e
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C1403f.m8067z(countDownLatch, atomicReference, (DownLoadState) obj);
                }
            });
        }
        try {
            zAwait = countDownLatch.await(15000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            C11839m.m70687e("WapAdsManager", "getAppStatus exception:" + e10.toString());
            zAwait = false;
        }
        C11839m.m70688i("WapAdsManager", "getAppStatus result:" + zAwait);
        return (String) atomicReference.get();
    }

    /* renamed from: k */
    public final String m8094k(String str, String str2) {
        return m8101s(str, str2) ? HiCloudNativeAd.CHANNEL_AGD : m8102t(str, str2) ? HiCloudNativeAd.CHANNEL_AGG : HiCloudNativeAd.CHANNEL_UNKONWN;
    }

    /* renamed from: l */
    public int m8095l(String str, String str2) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        boolean zAwait = false;
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        if (m8103u(str, str2) || m8104v(str, str2)) {
            INativeAd iNativeAdM8098p = m8098p(str, str2);
            if (iNativeAdM8098p != null) {
                return C1398a.m8017j().getDownloadProgress(C0213f.m1377a(), iNativeAdM8098p);
            }
            C11839m.m70688i("WapAdsManager", "ad not found");
            return 0;
        }
        AdInfo adInfoM8090g = m8090g(str, str2);
        if (adInfoM8090g == null || adInfoM8090g.getMaterial() == null) {
            C11839m.m70687e("WapAdsManager", "getDownloadProgress:adInfo is null");
            return 0;
        }
        if (this.f6018f != null) {
            this.f6018f.m63032y(new AppDownloadInfo(str, adInfoM8090g.getMaterial().getAppInfo().getPackageName(), str2, m8094k(str, str2)), new Consumer() { // from class: ca.d
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C1403f.m8063A(countDownLatch, atomicInteger, (DownLoadState) obj);
                }
            });
        }
        try {
            zAwait = countDownLatch.await(15000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            C11839m.m70687e("WapAdsManager", "getDownloadProgress exception:" + e10.toString());
        }
        C11839m.m70688i("WapAdsManager", "getDownloadProgress result:" + zAwait);
        return atomicInteger.get();
    }

    /* renamed from: m */
    public INativeAd m8096m(String str, String str2) {
        synchronized (f6009n) {
            try {
                HashMap<String, INativeAd> map = this.f6014b.get(str);
                if (map == null) {
                    return null;
                }
                return map.get(str2);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: o */
    public final String m8097o(String str) {
        return '\"' + str + '\"';
    }

    /* renamed from: p */
    public INativeAd m8098p(String str, String str2) {
        if (m8104v(str, str2)) {
            return m8099q(str, str2);
        }
        if (m8103u(str, str2)) {
            return m8096m(str, str2);
        }
        return null;
    }

    /* renamed from: q */
    public INativeAd m8099q(String str, String str2) {
        synchronized (f6010o) {
            try {
                HashMap<String, INativeAd> map = this.f6015c.get(str);
                if (map == null) {
                    return null;
                }
                return map.get(str2);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: r */
    public boolean m8100r(String str) {
        return this.f6016d.containsKey(str) || this.f6017e.containsKey(str);
    }

    /* renamed from: s */
    public boolean m8101s(String str, String str2) {
        HashMap<String, AdInfo> map;
        if (!this.f6016d.containsKey(str) || (map = this.f6016d.get(str)) == null) {
            return false;
        }
        return map.containsKey(str2);
    }

    /* renamed from: t */
    public boolean m8102t(String str, String str2) {
        HashMap<String, AdInfo> map;
        if (!this.f6017e.containsKey(str) || (map = this.f6017e.get(str)) == null) {
            return false;
        }
        return map.containsKey(str2);
    }

    /* renamed from: u */
    public boolean m8103u(String str, String str2) {
        HashMap<String, INativeAd> map;
        if (!this.f6014b.containsKey(str) || (map = this.f6014b.get(str)) == null) {
            return false;
        }
        return map.containsKey(str2);
    }

    /* renamed from: v */
    public boolean m8104v(String str, String str2) {
        HashMap<String, INativeAd> map;
        if (!this.f6015c.containsKey(str) || (map = this.f6015c.get(str)) == null) {
            return false;
        }
        return map.containsKey(str2);
    }

    /* renamed from: w */
    public boolean m8105w() {
        if (C0213f.m1377a() == null) {
            C11839m.m70688i("WapAdsManager", "reportAGEvent context is null.");
            return false;
        }
        HiCloudSysParamMap hiCloudSysParamMapM60759r = C9733f.m60705z().m60759r(C0213f.m1377a());
        if (hiCloudSysParamMapM60759r == null) {
            C11839m.m70688i("WapAdsManager", "reportAGEvent HiCloudSysParamMap is null.");
            return false;
        }
        int agReportSwitch = hiCloudSysParamMapM60759r.getAgReportSwitch();
        if (agReportSwitch == 1) {
            return true;
        }
        C11839m.m70688i("WapAdsManager", "reportAGEvent agReportSwitch: " + agReportSwitch);
        return false;
    }

    /* renamed from: x */
    public int m8106x(String str, String str2) {
        int i10 = 0;
        if (m8103u(str, str2) || m8104v(str, str2)) {
            C11839m.m70688i("WapAdsManager", "jump with pps");
            INativeAd iNativeAdM8098p = m8098p(str, str2);
            if (iNativeAdM8098p == null) {
                C11839m.m70689w("WapAdsManager", "jump ad not found");
                return -100;
            }
            iNativeAdM8098p.triggerClick(C0213f.m1377a(), null);
        } else {
            C11839m.m70688i("WapAdsManager", "jump with AgAd");
            AdInfo adInfoM8090g = m8090g(str, str2);
            if (adInfoM8090g == null || adInfoM8090g.getMaterial() == null) {
                C11839m.m70687e("WapAdsManager", "jump: adInfo is null");
                return -100;
            }
            if (!C0209d.m1333z1(this.f6013a)) {
                m8084R(this.f6013a.getString(R$string.alert_net_disconnect_new));
                return -100;
            }
            if (this.f6018f != null) {
                MaterialMeta material = adInfoM8090g.getMaterial();
                this.f6018f.m63021F(new AppDownloadInfo(str, material.getAppInfo().getPackageName(), str2, m8094k(str, str2)), material.getAppInfo().getDownloadParam(), EnumC10122j.MANUAL_INSTALL_ON_FULL_SCREEN_DETAILS_PAGE);
            } else {
                i10 = -100;
            }
        }
        C11839m.m70688i("WapAdsManager", "jump result:" + i10);
        return i10;
    }

    /* renamed from: y */
    public int m8107y(String str, String str2) {
        int i10 = 0;
        if (m8103u(str, str2)) {
            C11839m.m70688i("WapAdsManager", "jump with pps");
            INativeAd iNativeAdM8096m = m8096m(str, str2);
            if (iNativeAdM8096m == null) {
                C11839m.m70689w("WapAdsManager", "jump ad not found");
                return -100;
            }
            iNativeAdM8096m.showAppDetailPage(C0213f.m1377a());
        } else {
            C11839m.m70688i("WapAdsManager", "jump with AgAd");
            AdInfo adInfoM8090g = m8090g(str, str2);
            if (adInfoM8090g == null || adInfoM8090g.getMaterial() == null) {
                C11839m.m70687e("WapAdsManager", "jump: adInfo is null");
                return -100;
            }
            if (!C0209d.m1333z1(this.f6013a)) {
                m8084R(this.f6013a.getString(R$string.alert_net_disconnect_new));
                return -100;
            }
            if (this.f6018f != null) {
                MaterialMeta material = adInfoM8090g.getMaterial();
                this.f6018f.m63021F(new AppDownloadInfo(str, material.getAppInfo().getPackageName(), str2, HiCloudNativeAd.CHANNEL_AGD), material.getAppInfo().getDownloadParam(), EnumC10122j.MANUAL_INSTALL_ON_HALF_SCREEN_DETAILS_PAGE);
            } else {
                i10 = -100;
            }
        }
        C11839m.m70688i("WapAdsManager", "jump result:" + i10);
        return i10;
    }
}
