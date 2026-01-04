package p651t8;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import ca.C1400c;
import com.huawei.android.hicloud.agd.ads.AdInfo;
import com.huawei.android.hicloud.agd.ads.AppDownloadInfo;
import com.huawei.android.hicloud.agd.ads.DownLoadState;
import com.huawei.android.hicloud.agd.ads.MaterialMeta;
import com.huawei.android.hicloud.cloudspace.campaign.bean.H5DownloadApp;
import com.huawei.cloud.pay.model.HiCloudNativeAd;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.sync.R$string;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
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
import p015ak.C0212e0;
import p015ak.C0213f;
import p329h7.C10120h;
import p329h7.EnumC10122j;
import p514o9.C11839m;
import p672u8.C13135e;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;

/* renamed from: t8.d */
/* loaded from: classes2.dex */
public class C12996d implements Consumer<DownLoadState> {

    /* renamed from: j */
    public static volatile C12996d f59154j;

    /* renamed from: k */
    public static final Object f59155k = new Object();

    /* renamed from: l */
    public static final Object f59156l = new Object();

    /* renamed from: a */
    public final Context f59157a = C0213f.m1377a();

    /* renamed from: b */
    public final HashMap<String, HashMap<String, INativeAd>> f59158b = new HashMap<>(10);

    /* renamed from: c */
    public final HashMap<String, HashMap<String, AdInfo>> f59159c = new HashMap<>(10);

    /* renamed from: d */
    public C10120h f59160d;

    /* renamed from: e */
    public String f59161e;

    /* renamed from: f */
    public String f59162f;

    /* renamed from: g */
    public String f59163g;

    /* renamed from: h */
    public Handler f59164h;

    /* renamed from: i */
    public String f59165i;

    /* renamed from: N */
    public static boolean m77967N(Object obj, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return false;
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            File file = new File(m77970j());
            if (!file.exists()) {
                C11839m.m70686d("CampaignAdsManager", "mkdirs:" + file.mkdirs());
            }
            File file2 = new File(file, str);
            if (!file2.exists()) {
                C11839m.m70686d("CampaignAdsManager", "createNewFile:" + file2.createNewFile());
            }
            fileOutputStream = new FileOutputStream(file2);
            try {
                try {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(fileOutputStream);
                    try {
                        objectOutputStream2.writeObject(obj);
                        objectOutputStream2.flush();
                        try {
                            objectOutputStream2.close();
                            fileOutputStream.close();
                            return true;
                        } catch (Exception e10) {
                            C11839m.m70687e("CampaignAdsManager", "writeObj2File exception:" + e10.getMessage());
                            return true;
                        }
                    } catch (Exception e11) {
                        e = e11;
                        objectOutputStream = objectOutputStream2;
                        C11839m.m70687e("CampaignAdsManager", "writeObj2File exception:" + e.getMessage());
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e12) {
                                C11839m.m70687e("CampaignAdsManager", "writeObj2File exception:" + e12.getMessage());
                                return false;
                            }
                        }
                        if (fileOutputStream == null) {
                            return false;
                        }
                        fileOutputStream.close();
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        objectOutputStream = objectOutputStream2;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e13) {
                                C11839m.m70687e("CampaignAdsManager", "writeObj2File exception:" + e13.getMessage());
                                throw th;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e14) {
                e = e14;
            }
        } catch (Exception e15) {
            e = e15;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    /* renamed from: j */
    public static String m77970j() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C0213f.m1377a().getFilesDir().getAbsolutePath());
        String str = File.separator;
        sb2.append(str);
        sb2.append("quests");
        sb2.append(str);
        return sb2.toString();
    }

    /* renamed from: n */
    public static C12996d m77971n() {
        if (f59154j == null) {
            synchronized (C12996d.class) {
                try {
                    if (f59154j == null) {
                        f59154j = new C12996d();
                    }
                } finally {
                }
            }
        }
        return f59154j;
    }

    /* renamed from: o */
    public static String m77972o(String str) {
        return '\"' + str + '\"';
    }

    /* renamed from: p */
    public static String m77973p(String str) {
        return '\'' + str + '\'';
    }

    /* renamed from: t */
    public static /* synthetic */ void m77974t(CountDownLatch countDownLatch, AtomicReference atomicReference, DownLoadState downLoadState) {
        countDownLatch.countDown();
        atomicReference.set(downLoadState.transAppStatus());
    }

    /* renamed from: u */
    public static /* synthetic */ void m77975u(CountDownLatch countDownLatch, AtomicInteger atomicInteger, DownLoadState downLoadState) {
        countDownLatch.countDown();
        atomicInteger.set(downLoadState.getProgress());
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a0 A[Catch: IOException -> 0x009c, TRY_LEAVE, TryCatch #8 {IOException -> 0x009c, blocks: (B:35:0x0098, B:39:0x00a0), top: B:51:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0098 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: x */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object m77976x(java.lang.String r7) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "readObjFromFile exception:"
            java.lang.String r1 = "CampaignAdsManager"
            java.lang.String r2 = android.os.Environment.getExternalStorageState()
            java.lang.String r3 = "mounted"
            boolean r2 = r2.equals(r3)
            r3 = 0
            if (r2 == 0) goto Lbb
            java.io.File r2 = new java.io.File
            java.lang.String r4 = m77970j()
            r2.<init>(r4, r7)
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L58
            r7.<init>(r2)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L58
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L50
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L50
            java.lang.Object r3 = r2.readObject()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            r2.close()     // Catch: java.io.IOException -> L2f
            r7.close()     // Catch: java.io.IOException -> L2f
            goto L46
        L2f:
            r7 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r7 = r7.getMessage()
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            p514o9.C11839m.m70687e(r1, r7)
        L46:
            return r3
        L47:
            r3 = move-exception
            goto L96
        L49:
            r4 = move-exception
            goto L5b
        L4b:
            r2 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
            goto L96
        L50:
            r4 = move-exception
            r2 = r3
            goto L5b
        L53:
            r7 = move-exception
            r2 = r3
            r3 = r7
            r7 = r2
            goto L96
        L58:
            r4 = move-exception
            r7 = r3
            r2 = r7
        L5b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L47
            r5.<init>()     // Catch: java.lang.Throwable -> L47
            r5.append(r0)     // Catch: java.lang.Throwable -> L47
            java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Throwable -> L47
            r5.append(r4)     // Catch: java.lang.Throwable -> L47
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> L47
            p514o9.C11839m.m70687e(r1, r4)     // Catch: java.lang.Throwable -> L47
            if (r2 == 0) goto L79
            r2.close()     // Catch: java.io.IOException -> L77
            goto L79
        L77:
            r7 = move-exception
            goto L7f
        L79:
            if (r7 == 0) goto Lbb
            r7.close()     // Catch: java.io.IOException -> L77
            goto Lbb
        L7f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r7 = r7.getMessage()
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            p514o9.C11839m.m70687e(r1, r7)
            goto Lbb
        L96:
            if (r2 == 0) goto L9e
            r2.close()     // Catch: java.io.IOException -> L9c
            goto L9e
        L9c:
            r7 = move-exception
            goto La4
        L9e:
            if (r7 == 0) goto Lba
            r7.close()     // Catch: java.io.IOException -> L9c
            goto Lba
        La4:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r7 = r7.getMessage()
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            p514o9.C11839m.m70687e(r1, r7)
        Lba:
            throw r3
        Lbb:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p651t8.C12996d.m77976x(java.lang.String):java.lang.Object");
    }

    /* renamed from: A */
    public final void m77977A(String str, String str2) {
        if ("INSTALLED".equals(str)) {
            Message message = new Message();
            message.what = 106;
            message.obj = str2;
            Handler handler = this.f59164h;
            if (handler != null) {
                handler.sendMessage(message);
            }
        }
    }

    /* renamed from: B */
    public void m77978B() {
        m77994g(String.format(Locale.ENGLISH, "%s(%s);", this.f59163g, m77972o(this.f59165i)));
        Message message = new Message();
        message.what = 107;
        message.obj = this.f59165i;
        Handler handler = this.f59164h;
        if (handler != null) {
            handler.sendMessage(message);
        }
    }

    /* renamed from: C */
    public int m77979C(String str, String str2) {
        if (m78000q(str)) {
            INativeAd iNativeAdM77999m = m77999m(str, str2);
            if (iNativeAdM77999m != null) {
                return C12997e.m78016i().resumeDownload(C0213f.m1377a(), iNativeAdM77999m);
            }
            C11839m.m70688i("CampaignAdsManager", "ad not found");
            return -100;
        }
        AdInfo adInfoM77995h = m77995h(str, str2);
        if (adInfoM77995h == null || adInfoM77995h.getMaterial() == null) {
            C11839m.m70687e("CampaignAdsManager", "resumeDownload:adInfo is null");
            return -100;
        }
        if (!C0209d.m1333z1(this.f59157a)) {
            m77988L(this.f59157a.getString(R$string.alert_net_disconnect_new));
            return -100;
        }
        C10120h c10120h = this.f59160d;
        if (c10120h != null) {
            return c10120h.m63018C(new AppDownloadInfo(str, adInfoM77995h.getMaterial().getAppInfo().getPackageName(), str2, HiCloudNativeAd.CHANNEL_AGD));
        }
        return -100;
    }

    /* renamed from: D */
    public void m77980D(Map<String, List<AdInfo>> map) {
        HashMap<String, AdInfo> map2;
        synchronized (f59156l) {
            try {
                for (Map.Entry<String, List<AdInfo>> entry : map.entrySet()) {
                    HashMap<String, AdInfo> map3 = new HashMap<>();
                    String key = entry.getKey();
                    if (this.f59159c.containsKey(key) && (map2 = this.f59159c.get(key)) != null) {
                        map3.putAll(map2);
                    }
                    for (AdInfo adInfo : entry.getValue()) {
                        map3.put(adInfo.getMaterial().getAppInfo().getAppId(), adInfo);
                    }
                    this.f59159c.put(key, map3);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: E */
    public synchronized void m77981E(String str, String str2, String str3) {
        H5DownloadApp h5DownloadApp;
        if (TextUtils.isEmpty(str3)) {
            C11839m.m70688i("CampaignAdsManager", "saveDownloadingApp: questId is empty");
            return;
        }
        C11839m.m70686d("CampaignAdsManager", "saveDownloadingApp questId: " + str3);
        if (m78000q(str)) {
            C11839m.m70688i("CampaignAdsManager", "saveDownloadingApp: pps");
            INativeAd iNativeAdM77999m = m77999m(str, str2);
            if (iNativeAdM77999m == null) {
                C11839m.m70688i("CampaignAdsManager", "saveDownloadingApp: ad null");
                return;
            }
            h5DownloadApp = new H5DownloadApp();
            h5DownloadApp.setAppSource(HiCloudNativeAd.CHANNEL_PPS);
            h5DownloadApp.setQuestId(str3);
            C11839m.m70688i("CampaignAdsManager", "saveDownloadingApp: obj2File " + m77967N(iNativeAdM77999m, str3));
        } else {
            C11839m.m70688i("CampaignAdsManager", "saveDownloadingApp: agd");
            AdInfo adInfoM77995h = m77995h(str, str2);
            if (adInfoM77995h == null) {
                C11839m.m70688i("CampaignAdsManager", "saveDownloadingApp: adInfo null");
                return;
            }
            h5DownloadApp = new H5DownloadApp();
            h5DownloadApp.setAppSource(HiCloudNativeAd.CHANNEL_AGD);
            h5DownloadApp.setQuestId(str3);
            h5DownloadApp.setAgd(adInfoM77995h);
        }
        String strM79009i = C13135e.m79009i(h5DownloadApp);
        C11839m.m70686d("CampaignAdsManager", "saveDownloadingApp toJson: " + strM79009i);
        C0212e0.m1373w(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "cache_" + str3, strM79009i);
    }

    /* renamed from: F */
    public void m77982F(Map<String, List<INativeAd>> map) {
        HashMap<String, INativeAd> map2;
        synchronized (f59155k) {
            try {
                for (Map.Entry<String, List<INativeAd>> entry : map.entrySet()) {
                    HashMap<String, INativeAd> map3 = new HashMap<>();
                    String key = entry.getKey();
                    if (this.f59158b.containsKey(key) && (map2 = this.f59158b.get(key)) != null) {
                        map3.putAll(map2);
                    }
                    for (INativeAd iNativeAd : entry.getValue()) {
                        C1400c.m8061h(iNativeAd, "");
                        map3.put(iNativeAd.getUniqueId(), iNativeAd);
                    }
                    this.f59158b.put(key, map3);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: G */
    public void m77983G(C10120h c10120h) {
        this.f59160d = c10120h;
        c10120h.m63019D(this);
    }

    /* renamed from: H */
    public void m77984H(Handler handler) {
        this.f59164h = handler;
    }

    /* renamed from: I */
    public void m77985I(String str) {
        this.f59163g = str;
    }

    /* renamed from: J */
    public void m77986J(String str) {
        this.f59162f = str;
    }

    /* renamed from: K */
    public void m77987K(String str) {
        this.f59161e = str;
    }

    /* renamed from: L */
    public void m77988L(String str) {
        Handler handler = this.f59164h;
        if (handler != null) {
            Message messageObtain = Message.obtain(handler);
            messageObtain.what = 105;
            Bundle bundle = new Bundle();
            bundle.putString("toast_content", str);
            messageObtain.setData(bundle);
            this.f59164h.sendMessage(messageObtain);
        }
    }

    /* renamed from: M */
    public int m77989M(String str, String str2) {
        int iStartDownload = -100;
        if (m78000q(str)) {
            INativeAd iNativeAdM77999m = m77999m(str, str2);
            if (iNativeAdM77999m == null) {
                C11839m.m70688i("CampaignAdsManager", "ad not found");
                return -100;
            }
            iStartDownload = C12997e.m78016i().startDownload(C0213f.m1377a(), iNativeAdM77999m);
        } else {
            AdInfo adInfoM77995h = m77995h(str, str2);
            if (adInfoM77995h == null || adInfoM77995h.getMaterial() == null) {
                C11839m.m70687e("CampaignAdsManager", "startDownload:adInfo is null");
                return -100;
            }
            if (!C0209d.m1333z1(this.f59157a)) {
                m77988L(this.f59157a.getString(R$string.alert_net_disconnect_new));
                return -100;
            }
            if (this.f59160d != null) {
                MaterialMeta material = adInfoM77995h.getMaterial();
                String packageName = material.getAppInfo().getPackageName();
                m78005y(packageName, "download_agd_ads_event", null);
                this.f59160d.m63021F(new AppDownloadInfo(str, packageName, str2, HiCloudNativeAd.CHANNEL_AGD), material.getAppInfo().getDownloadParam(), EnumC10122j.SILENT_INSTALL_TYPE);
            }
        }
        C11839m.m70688i("CampaignAdsManager", "startDownload result:" + iStartDownload);
        return iStartDownload;
    }

    @Override // java.util.function.Consumer
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void accept(DownLoadState downLoadState) {
        if (TextUtils.isEmpty(this.f59161e) || TextUtils.isEmpty(this.f59162f)) {
            C11839m.m70687e("CampaignAdsManager", "listener is empty");
            return;
        }
        AppDownloadInfo appDownloadInfo = downLoadState.getAppDownloadInfo();
        String packageName = appDownloadInfo.getPackageName();
        C11839m.m70686d("CampaignAdsManager", "agd accept: " + packageName + ", appStatus:" + downLoadState.transAppStatus());
        Locale locale = Locale.ENGLISH;
        m77994g(String.format(locale, "%s(%s,%s)", this.f59161e, m77972o(downLoadState.transAppStatus()), m77972o(packageName)));
        m77977A(downLoadState.transAppStatus(), packageName);
        if (downLoadState.isDownloadStatus()) {
            m77994g(String.format(locale, "%s(%d,%s)", this.f59162f, Integer.valueOf(downLoadState.getProgress()), m77972o(packageName)));
        }
        if (downLoadState.isTerminalType()) {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("terminal_agd_ads_reason_key", String.valueOf(downLoadState.getAppStatus()));
            m78005y(appDownloadInfo.getPackageName(), "terminal_agd_ads_event", linkedHashMap);
        }
        if (downLoadState.isDownloadedStatus()) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("task_type", "download_app");
            linkedHashMap2.put("download_type", HiCloudNativeAd.CHANNEL_AGD);
            linkedHashMap2.put(MapKeyNames.PACKAGE_NAME, appDownloadInfo.getPackageName());
            C12997e.m78025r("agd_download_finished_event", linkedHashMap2);
        }
    }

    /* renamed from: d */
    public void m77991d(String str, String str2) {
        if (m78000q(str)) {
            INativeAd iNativeAdM77999m = m77999m(str, str2);
            if (iNativeAdM77999m == null) {
                C11839m.m70688i("CampaignAdsManager", "ad not found");
                return;
            } else {
                C12997e.m78016i().cancelDownload(C0213f.m1377a(), iNativeAdM77999m);
                return;
            }
        }
        AdInfo adInfoM77995h = m77995h(str, str2);
        if (adInfoM77995h == null || adInfoM77995h.getMaterial() == null) {
            C11839m.m70687e("CampaignAdsManager", "cancelDownload:adInfo is null");
            return;
        }
        C10120h c10120h = this.f59160d;
        if (c10120h != null) {
            c10120h.m63024l(adInfoM77995h.getMaterial().getAppInfo().getPackageName());
        }
    }

    /* renamed from: e */
    public void m77992e() {
        Handler handler = this.f59164h;
        if (handler != null) {
            this.f59164h.sendMessage(Message.obtain(handler, 108));
        }
    }

    /* renamed from: f */
    public void m77993f() {
        this.f59158b.clear();
        this.f59159c.clear();
    }

    /* renamed from: g */
    public final void m77994g(String str) {
        Message message = new Message();
        message.what = 100;
        Bundle bundle = new Bundle();
        bundle.putString("javascript", str);
        message.setData(bundle);
        Handler handler = this.f59164h;
        if (handler != null) {
            handler.sendMessage(message);
        }
    }

    /* renamed from: h */
    public AdInfo m77995h(String str, String str2) {
        synchronized (f59156l) {
            try {
                HashMap<String, AdInfo> map = this.f59159c.get(str);
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
    public String m77996i(String str, String str2) throws InterruptedException {
        boolean zAwait;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference atomicReference = new AtomicReference();
        if (m78000q(str)) {
            INativeAd iNativeAdM77999m = m77999m(str, str2);
            if (iNativeAdM77999m != null) {
                return C12997e.m78016i().getAppStatus(C0213f.m1377a(), iNativeAdM77999m).toString();
            }
            C11839m.m70688i("CampaignAdsManager", "ad not found");
            return "0";
        }
        AdInfo adInfoM77995h = m77995h(str, str2);
        if (adInfoM77995h == null || adInfoM77995h.getMaterial() == null) {
            C11839m.m70687e("CampaignAdsManager", "getAppStatus:adInfo is null");
            return "DOWNLOADFAILED";
        }
        if (C0209d.m1184K0(this.f59157a, adInfoM77995h.getMaterial().getAppInfo().getPackageName())) {
            return "INSTALLED";
        }
        C10120h c10120h = this.f59160d;
        if (c10120h != null) {
            c10120h.m63032y(new AppDownloadInfo(str, adInfoM77995h.getMaterial().getAppInfo().getPackageName(), str2, HiCloudNativeAd.CHANNEL_AGD), new Consumer() { // from class: t8.c
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C12996d.m77974t(countDownLatch, atomicReference, (DownLoadState) obj);
                }
            });
        }
        try {
            zAwait = countDownLatch.await(15000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            C11839m.m70687e("CampaignAdsManager", "getAppStatus exception:" + e10.toString());
            zAwait = false;
        }
        C11839m.m70688i("CampaignAdsManager", "getAppStatus result:" + zAwait);
        return (String) atomicReference.get();
    }

    /* renamed from: k */
    public int m77997k(String str, String str2) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        boolean zAwait = false;
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        if (m78000q(str)) {
            INativeAd iNativeAdM77999m = m77999m(str, str2);
            if (iNativeAdM77999m != null) {
                return C12997e.m78016i().getDownloadProgress(C0213f.m1377a(), iNativeAdM77999m);
            }
            C11839m.m70688i("CampaignAdsManager", "ad not found");
            return 0;
        }
        AdInfo adInfoM77995h = m77995h(str, str2);
        if (adInfoM77995h == null || adInfoM77995h.getMaterial() == null) {
            C11839m.m70687e("CampaignAdsManager", "getDownloadProgress:adInfo is null");
            return 0;
        }
        C10120h c10120h = this.f59160d;
        if (c10120h != null) {
            c10120h.m63032y(new AppDownloadInfo(str, adInfoM77995h.getMaterial().getAppInfo().getPackageName(), str2, HiCloudNativeAd.CHANNEL_AGD), new Consumer() { // from class: t8.b
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    C12996d.m77975u(countDownLatch, atomicInteger, (DownLoadState) obj);
                }
            });
        }
        try {
            zAwait = countDownLatch.await(15000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            C11839m.m70687e("CampaignAdsManager", "getDownloadProgress exception:" + e10.toString());
        }
        C11839m.m70688i("CampaignAdsManager", "getDownloadProgress result:" + zAwait);
        return atomicInteger.get();
    }

    /* renamed from: l */
    public String m77998l(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i("CampaignAdsManager", "getDownloadingAppList: questId is empty");
            return null;
        }
        return C0212e0.m1364n(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "cache_" + str, "");
    }

    /* renamed from: m */
    public INativeAd m77999m(String str, String str2) {
        synchronized (f59155k) {
            try {
                HashMap<String, INativeAd> map = this.f59158b.get(str);
                if (map == null) {
                    return null;
                }
                return map.get(str2);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: q */
    public boolean m78000q(String str) {
        return this.f59158b.containsKey(str);
    }

    /* renamed from: r */
    public int m78001r(String str, String str2) {
        int i10 = 0;
        if (m78000q(str)) {
            C11839m.m70688i("CampaignAdsManager", "jump with pps");
            INativeAd iNativeAdM77999m = m77999m(str, str2);
            if (iNativeAdM77999m == null) {
                C11839m.m70689w("CampaignAdsManager", "jump ad not found");
                return -100;
            }
            iNativeAdM77999m.triggerClick(C0213f.m1377a(), null);
        } else {
            C11839m.m70688i("CampaignAdsManager", "jump with AgAd");
            AdInfo adInfoM77995h = m77995h(str, str2);
            if (adInfoM77995h == null || adInfoM77995h.getMaterial() == null) {
                C11839m.m70687e("CampaignAdsManager", "jump: adInfo is null");
                return -100;
            }
            if (!C0209d.m1333z1(this.f59157a)) {
                m77988L(this.f59157a.getString(R$string.alert_net_disconnect_new));
                return -100;
            }
            if (this.f59160d != null) {
                MaterialMeta material = adInfoM77995h.getMaterial();
                this.f59160d.m63021F(new AppDownloadInfo(str, material.getAppInfo().getPackageName(), str2, HiCloudNativeAd.CHANNEL_AGD), material.getAppInfo().getDownloadParam(), EnumC10122j.MANUAL_INSTALL_ON_FULL_SCREEN_DETAILS_PAGE);
            } else {
                i10 = -100;
            }
        }
        C11839m.m70688i("CampaignAdsManager", "jump result:" + i10);
        return i10;
    }

    /* renamed from: s */
    public int m78002s(String str, String str2) {
        int i10 = 0;
        if (m78000q(str)) {
            C11839m.m70688i("CampaignAdsManager", "jump with pps");
            INativeAd iNativeAdM77999m = m77999m(str, str2);
            if (iNativeAdM77999m == null) {
                C11839m.m70689w("CampaignAdsManager", "jump ad not found");
                return -100;
            }
            iNativeAdM77999m.showAppDetailPage(C0213f.m1377a());
        } else {
            C11839m.m70688i("CampaignAdsManager", "jump with AgAd");
            AdInfo adInfoM77995h = m77995h(str, str2);
            if (adInfoM77995h == null || adInfoM77995h.getMaterial() == null) {
                C11839m.m70687e("CampaignAdsManager", "jump: adInfo is null");
                return -100;
            }
            if (!C0209d.m1333z1(this.f59157a)) {
                m77988L(this.f59157a.getString(R$string.alert_net_disconnect_new));
                return -100;
            }
            if (this.f59160d != null) {
                MaterialMeta material = adInfoM77995h.getMaterial();
                this.f59160d.m63021F(new AppDownloadInfo(str, material.getAppInfo().getPackageName(), str2, HiCloudNativeAd.CHANNEL_AGD), material.getAppInfo().getDownloadParam(), EnumC10122j.MANUAL_INSTALL_ON_HALF_SCREEN_DETAILS_PAGE);
            } else {
                i10 = -100;
            }
        }
        C11839m.m70688i("CampaignAdsManager", "jump result:" + i10);
        return i10;
    }

    /* renamed from: v */
    public String m78003v(String str, String str2) {
        if (m78000q(str)) {
            return "";
        }
        AdInfo adInfoM77995h = m77995h(str, str2);
        if (adInfoM77995h == null || adInfoM77995h.getMaterial() == null) {
            C11839m.m70687e("CampaignAdsManager", "openAgdApp:adInfo is null");
            return "";
        }
        if (this.f59160d != null) {
            String packageName = adInfoM77995h.getMaterial().getAppInfo().getPackageName();
            this.f59165i = packageName;
            boolean zM63030w = this.f59160d.m63030w(packageName);
            C11839m.m70688i("CampaignAdsManager", "openAgdAppByPackageName result:" + zM63030w);
            if (zM63030w) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("task_type", "download_app");
                linkedHashMap.put("download_type", HiCloudNativeAd.CHANNEL_AGD);
                linkedHashMap.put(MapKeyNames.PACKAGE_NAME, packageName);
                C12997e.m78025r("agd_open_event", linkedHashMap);
                return packageName;
            }
        }
        return "";
    }

    /* renamed from: w */
    public void m78004w(String str, String str2) {
        if (m78000q(str)) {
            INativeAd iNativeAdM77999m = m77999m(str, str2);
            if (iNativeAdM77999m == null) {
                C11839m.m70688i("CampaignAdsManager", "ad not found");
                return;
            } else {
                C12997e.m78016i().pauseDownload(C0213f.m1377a(), iNativeAdM77999m);
                return;
            }
        }
        AdInfo adInfoM77995h = m77995h(str, str2);
        if (adInfoM77995h == null || adInfoM77995h.getMaterial() == null) {
            C11839m.m70687e("CampaignAdsManager", "pauseDownload:adInfo is null");
            return;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("terminal_agd_ads_reason_key", String.valueOf(6));
        m78005y(adInfoM77995h.getMaterial().getAppInfo().getPackageName(), "terminal_agd_ads_event", linkedHashMap);
        C10120h c10120h = this.f59160d;
        if (c10120h != null) {
            c10120h.m63031x(adInfoM77995h.getMaterial().getAppInfo().getPackageName());
        }
    }

    /* renamed from: y */
    public final void m78005y(String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put(C6148x2.DEVICE_ID, C13452e.m80781L().m80954p());
        linkedHashMapM79497A.put("download_agd_ads_package_key", str);
        if (linkedHashMap != null) {
            linkedHashMapM79497A.putAll(linkedHashMap);
        }
        C13227f.m79492i1().m79567R(str2, linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", str2, linkedHashMapM79497A);
    }

    /* renamed from: z */
    public synchronized void m78006z(String str) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70688i("CampaignAdsManager", "removeDownloadingApp: questId is empty");
            return;
        }
        C0212e0.m1375y(C0213f.m1377a(), "com.huawei.hidisk.campaign.config_quests", "cache_" + str);
    }
}
