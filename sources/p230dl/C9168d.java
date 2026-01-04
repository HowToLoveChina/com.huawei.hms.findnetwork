package p230dl;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cl.InterfaceC1446a;
import cl.InterfaceC1447b;
import cl.InterfaceC1454i;
import com.huawei.android.hicloud.cloudbackup.util.ICBUtil;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.network.embedded.C6148x2;
import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import com.huawei.openalliance.p169ad.constant.ParamConstants;
import com.huawei.openalliance.p169ad.constant.VastAttribute;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.IAppDownloadManager;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import fk.C9721b;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0217h;
import p015ak.C0226l0;
import p230dl.C9169e;
import p230dl.C9178n;
import p260ek.C9499a;
import p429kk.C11058a;
import p514o9.C11839m;
import p682ul.C13207a;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;

/* renamed from: dl.d */
/* loaded from: classes6.dex */
public class C9168d implements InterfaceC1446a {

    /* renamed from: f */
    public static int f45969f = 160;

    /* renamed from: g */
    public static int f45970g = 160;

    /* renamed from: h */
    public static int f45971h = 10;

    /* renamed from: i */
    public static String f45972i;

    /* renamed from: j */
    public static int f45973j;

    /* renamed from: a */
    public INativeAd f45974a;

    /* renamed from: c */
    public final boolean f45976c;

    /* renamed from: d */
    public C9169e.a f45977d;

    /* renamed from: e */
    public final AtomicBoolean f45978e = new AtomicBoolean(false);

    /* renamed from: b */
    public final Context f45975b = C0213f.m1377a();

    static {
        String strM57599c = C9169e.m57596e().m57599c();
        if (TextUtils.isEmpty(strM57599c)) {
            return;
        }
        f45969f = C9499a.m59435c(strM57599c, "ppsAdWidth", RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE);
        f45970g = C9499a.m59435c(strM57599c, "ppsAdHeight", RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE);
        f45971h = C9499a.m59435c(strM57599c, "ppsAdClickRange", 10);
        f45972i = C9499a.m59436d(strM57599c, "ppsSearchInfoAdId");
        f45973j = C9499a.m59435c(strM57599c, "ppsImpressionMode", 0);
    }

    public C9168d(boolean z10) {
        this.f45976c = z10;
    }

    /* renamed from: e */
    public static void m57589e(String str, INativeAd iNativeAd) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put(C6148x2.DEVICE_ID, C13452e.m80781L().m80954p());
        linkedHashMapM79497A.put(NotifyConstants.CloudStorageConstants.AD_NAME_KEY, f45972i);
        linkedHashMapM79497A.put("unique_id", iNativeAd.getUniqueId());
        linkedHashMapM79497A.put("reportType", str);
        C13622a.m81969o(C0213f.m1377a(), C11058a.m66626a(C11058a.m66627b("07060"), "07060", C13452e.m80781L().m80971t0()), linkedHashMapM79497A);
        C13225d.m79490f1().m79567R("action_code_restore_app_by_pps", linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", "action_code_restore_app_by_pps", linkedHashMapM79497A);
    }

    /* renamed from: g */
    public static int m57590g(int i10) {
        if (i10 < 0) {
            return 0;
        }
        return (int) (Math.random() * (i10 + 1));
    }

    /* renamed from: h */
    public static /* synthetic */ void m57591h(String str, AppInfo appInfo) {
        C11839m.m70688i("PPSAppProcessor", "set allowNonWifi app:" + str);
        appInfo.setAllowedNonWifiNetwork(true);
    }

    @Override // cl.InterfaceC1446a
    /* renamed from: a */
    public boolean mo7489a(final String str, InterfaceC1447b interfaceC1447b, InterfaceC1454i interfaceC1454i) {
        m57594j();
        boolean zRecordClickEvent = this.f45974a.recordClickEvent(this.f45975b, m57592f());
        this.f45977d.m57610e(zRecordClickEvent);
        m57589e("click", this.f45974a);
        if (ICBUtil.getVersionCode(this.f45975b.getPackageManager(), str) >= 0) {
            C11839m.m70688i("PPSAppProcessor", str + " app has existed");
            m57589e("localAppExistProcess", this.f45974a);
            return false;
        }
        C9169e.m57596e().m57603h(this.f45974a.getAppInfo().getPackageName(), this.f45977d);
        C11839m.m70688i("PPSAppProcessor", "clickEvent: " + zRecordClickEvent);
        C0217h<Boolean> c0217h = new C0217h<>();
        try {
            C9178n.b bVar = new C9178n.b();
            bVar.m57651k(interfaceC1447b);
            bVar.m57653m(interfaceC1454i);
            bVar.m57652l(c0217h);
            bVar.m57654n(this.f45974a);
            if (this.f45976c) {
                Optional.ofNullable(this.f45974a).map(new Function() { // from class: dl.a
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return ((INativeAd) obj).getAppInfo();
                    }
                }).ifPresent(new Consumer() { // from class: dl.b
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        C9168d.m57591h(str, (AppInfo) obj);
                    }
                });
            }
            C9178n.m57630g().m57639o(str, bVar);
            HiAd.getInstance(this.f45975b).setAppDownloadListener(C9178n.m57630g());
            final IAppDownloadManager appDownloadManager = HiAd.getInstance(this.f45975b).getAppDownloadManager();
            C0226l0.m1586f(new Runnable() { // from class: dl.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f45967a.m57593i(appDownloadManager);
                }
            });
            m57595k(c0217h, interfaceC1454i);
        } catch (Exception e10) {
            C11839m.m70687e("PPSAppProcessor", "process end appId: " + str + ", Exception:" + e10.getClass().getName());
        }
        C11839m.m70688i("PPSAppProcessor", "process end appId: " + str + " result:" + c0217h.m1451b());
        return Boolean.TRUE.equals(c0217h.m1451b());
    }

    @Override // cl.InterfaceC1446a
    /* renamed from: b */
    public boolean mo7490b(String str, long j10, boolean z10, boolean z11) {
        C11839m.m70688i("PPSAppProcessor", "enter isAllow " + str + ":" + j10);
        INativeAd iNativeAd = C9169e.m57596e().m57598b().get(str);
        this.f45974a = iNativeAd;
        if (iNativeAd == null) {
            C11839m.m70689w("PPSAppProcessor", "get nactivAd is null");
            return false;
        }
        try {
            if (!C13207a.m79404c().m79409d(this.f45975b, C13207a.b.PROTOCOL)) {
                m57589e("notAgreeAgdProtocol", this.f45974a);
                C11839m.m70689w("PPSAppProcessor", "not agree agd protocol");
                return false;
            }
            if (!this.f45976c && (!C0209d.m1333z1(this.f45975b) || C0209d.m1225Y(this.f45975b) != 1)) {
                C11839m.m70687e("PPSAppProcessor", "network status is not allowed");
                m57589e("networkNotSuppport", this.f45974a);
                return false;
            }
            if (this.f45974a.getAppInfo() == null) {
                C11839m.m70689w("PPSAppProcessor", "appInfo is null");
                m57589e("appInfoIsNull", this.f45974a);
                return false;
            }
            if (j10 < 0) {
                C11839m.m70688i("PPSAppProcessor", "application not exist on the local host");
                if (f45973j == 2) {
                    m57594j();
                }
                return true;
            }
            C11839m.m70688i("PPSAppProcessor", "application exist on the local host");
            if (f45973j == 1) {
                m57594j();
            }
            m57589e("localAppExistIsAllow", this.f45974a);
            return false;
        } catch (C9721b e10) {
            C11839m.m70687e("PPSAppProcessor", "query adg protocol exception:" + e10.getMessage());
            m57589e("queryAgdProtocolError", this.f45974a);
            return false;
        }
    }

    /* renamed from: f */
    public final Bundle m57592f() {
        int iM57590g = m57590g(f45969f - (f45971h * 2));
        int i10 = f45971h;
        int i11 = iM57590g + i10;
        int iM57590g2 = m57590g(f45970g - (i10 * 2)) + f45971h;
        Bundle bundle = new Bundle();
        bundle.putInt(MapKeyNames.CLICK_X, i11);
        bundle.putInt(MapKeyNames.CLICK_Y, iM57590g2);
        bundle.putString(MapKeyNames.CREATIVE_SIZE, f45969f + "*" + f45970g);
        return bundle;
    }

    @Override // cl.InterfaceC1446a
    public int getChannel() {
        return 1;
    }

    /* renamed from: i */
    public final /* synthetic */ void m57593i(IAppDownloadManager iAppDownloadManager) {
        int iResumeDownload = iAppDownloadManager.getAppStatus(this.f45975b, this.f45974a) == AppStatus.PAUSE ? iAppDownloadManager.resumeDownload(this.f45975b, this.f45974a) : iAppDownloadManager.startDownload(this.f45975b, this.f45974a);
        if (iResumeDownload != 0) {
            C11839m.m70689w("PPSAppProcessor", "download failed, result: " + iResumeDownload);
            C9178n.m57630g().m57640p(this.f45974a);
            this.f45978e.set(true);
        }
    }

    /* renamed from: j */
    public final void m57594j() {
        C9169e.a aVar = C9169e.m57596e().m57600d().get(this.f45974a.getAppInfo().getPackageName());
        this.f45977d = aVar;
        if (aVar == null) {
            C11839m.m70689w("PPSAppProcessor", "adBiInfo is null");
            C9169e.a aVar2 = new C9169e.a();
            this.f45977d = aVar2;
            aVar2.m57612g(this.f45974a);
        }
        if (this.f45977d.m57609d()) {
            C11839m.m70689w("PPSAppProcessor", "adBiInfo already has report show event");
        } else {
            boolean zRecordShowStartEvent = this.f45974a.recordShowStartEvent(this.f45975b, null);
            this.f45977d.m57614i(zRecordShowStartEvent);
            m57589e(ParamConstants.CallbackMethod.ON_SHOW, this.f45974a);
            C11839m.m70688i("PPSAppProcessor", "recordShowStartEvent: " + zRecordShowStartEvent);
            C9169e.m57596e().m57603h(this.f45974a.getAppInfo().getPackageName(), this.f45977d);
        }
        if (this.f45977d.m57608c()) {
            C11839m.m70689w("PPSAppProcessor", "adBiInfo already has report impression event");
            return;
        }
        boolean zRecordImpressionEvent = this.f45974a.recordImpressionEvent(this.f45975b, null);
        this.f45977d.m57613h(zRecordImpressionEvent);
        m57589e(VastAttribute.IMPRESSION, this.f45974a);
        C11839m.m70688i("PPSAppProcessor", "recordImpressionEvent: " + zRecordImpressionEvent);
        C9169e.m57596e().m57603h(this.f45974a.getAppInfo().getPackageName(), this.f45977d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
    
        r6.f45977d.m57611f(true);
     */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m57595k(java.util.concurrent.CountDownLatch r7, cl.InterfaceC1454i r8) throws fk.C9721b {
        /*
            r6 = this;
            java.lang.String r0 = "syncLock start lock"
            java.lang.String r1 = "PPSAppProcessor"
            p514o9.C11839m.m70688i(r1, r0)
        L7:
            long r2 = r7.getCount()     // Catch: fk.C9721b -> L30
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L7e
            r8.isAbort()     // Catch: fk.C9721b -> L30
            java.util.concurrent.atomic.AtomicBoolean r0 = r6.f45978e     // Catch: fk.C9721b -> L30
            boolean r0 = r0.get()     // Catch: fk.C9721b -> L30
            r2 = 1008(0x3f0, float:1.413E-42)
            r3 = 0
            if (r0 != 0) goto L54
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: fk.C9721b -> L30 java.lang.InterruptedException -> L32
            r4 = 400(0x190, double:1.976E-321)
            boolean r0 = r7.await(r4, r0)     // Catch: fk.C9721b -> L30 java.lang.InterruptedException -> L32
            if (r0 == 0) goto L7
            dl.e$a r7 = r6.f45977d     // Catch: fk.C9721b -> L30 java.lang.InterruptedException -> L32
            r8 = 1
            r7.m57611f(r8)     // Catch: fk.C9721b -> L30 java.lang.InterruptedException -> L32
            goto L7e
        L30:
            r7 = move-exception
            goto L61
        L32:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: fk.C9721b -> L30
            r8.<init>()     // Catch: fk.C9721b -> L30
            java.lang.String r0 = "lock wait error."
            r8.append(r0)     // Catch: fk.C9721b -> L30
            r8.append(r7)     // Catch: fk.C9721b -> L30
            java.lang.String r7 = r8.toString()     // Catch: fk.C9721b -> L30
            p514o9.C11839m.m70687e(r1, r7)     // Catch: fk.C9721b -> L30
            dl.e$a r7 = r6.f45977d     // Catch: fk.C9721b -> L30
            r7.m57611f(r3)     // Catch: fk.C9721b -> L30
            fk.b r7 = new fk.b     // Catch: fk.C9721b -> L30
            java.lang.String r8 = "PPSAppProcessor lock wait error."
            r7.<init>(r2, r8)     // Catch: fk.C9721b -> L30
            throw r7     // Catch: fk.C9721b -> L30
        L54:
            dl.e$a r7 = r6.f45977d     // Catch: fk.C9721b -> L30
            r7.m57611f(r3)     // Catch: fk.C9721b -> L30
            fk.b r7 = new fk.b     // Catch: fk.C9721b -> L30
            java.lang.String r8 = "PPSAppProcessor download has error."
            r7.<init>(r2, r8)     // Catch: fk.C9721b -> L30
            throw r7     // Catch: fk.C9721b -> L30
        L61:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "PPSAppProcessor syncLock error."
            r8.append(r0)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            p514o9.C11839m.m70687e(r1, r7)
            dl.n r7 = p230dl.C9178n.m57630g()
            com.huawei.openalliance.ad.inter.data.INativeAd r6 = r6.f45974a
            r7.m57640p(r6)
        L7e:
            java.lang.String r6 = "syncLock end lock"
            p514o9.C11839m.m70688i(r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p230dl.C9168d.m57595k(java.util.concurrent.CountDownLatch, cl.i):void");
    }
}
