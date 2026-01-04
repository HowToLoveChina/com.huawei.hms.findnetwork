package p230dl;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import cl.InterfaceC1447b;
import cl.InterfaceC1454i;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.openalliance.p169ad.download.app.AppStatus;
import com.huawei.openalliance.p169ad.inter.HiAd;
import com.huawei.openalliance.p169ad.inter.data.AppInfo;
import com.huawei.openalliance.p169ad.inter.data.INativeAd;
import com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener;
import com.huawei.phoneservice.feedbackcommon.utils.AsCache;
import fk.C9721b;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import p015ak.C0213f;
import p015ak.C0217h;
import p260ek.C9499a;
import p291fl.C9725c;
import p514o9.C11839m;

/* renamed from: dl.n */
/* loaded from: classes6.dex */
public class C9178n implements AppDownloadListener {

    /* renamed from: e */
    public static long f46012e = 3600;

    /* renamed from: f */
    public static final Map<AppStatus, Integer> f46013f;

    /* renamed from: g */
    public static volatile C9178n f46014g;

    /* renamed from: a */
    public volatile HandlerThread f46015a;

    /* renamed from: b */
    public volatile Handler f46016b;

    /* renamed from: c */
    public final ConcurrentHashMap<String, b> f46017c = new ConcurrentHashMap<>();

    /* renamed from: d */
    public final AtomicBoolean f46018d = new AtomicBoolean(false);

    /* renamed from: dl.n$a */
    public class a implements C9725c.a {

        /* renamed from: a */
        public final /* synthetic */ b f46019a;

        public a(b bVar) {
            this.f46019a = bVar;
        }

        @Override // p291fl.C9725c.a
        /* renamed from: a */
        public void mo7500a() {
            if (this.f46019a.f46024d.getCount() <= 0) {
                return;
            }
            int i10 = this.f46019a.f46026f < 100 ? 1 : 7;
            this.f46019a.f46021a.onStatusChange(1, i10, this.f46019a.f46026f);
            C9178n.this.m57638n(this.f46019a, i10);
        }

        @Override // p291fl.C9725c.a
        /* renamed from: b */
        public long mo7501b() {
            return TimeUnit.SECONDS.toMillis(C9178n.f46012e);
        }
    }

    /* renamed from: dl.n$b */
    public static class b {

        /* renamed from: a */
        public InterfaceC1447b f46021a;

        /* renamed from: b */
        public InterfaceC1454i f46022b;

        /* renamed from: c */
        public INativeAd f46023c;

        /* renamed from: d */
        public C0217h<Boolean> f46024d;

        /* renamed from: e */
        public int f46025e;

        /* renamed from: f */
        public int f46026f;

        /* renamed from: g */
        public C9725c.a f46027g;

        /* renamed from: k */
        public void m57651k(InterfaceC1447b interfaceC1447b) {
            this.f46021a = interfaceC1447b;
        }

        /* renamed from: l */
        public void m57652l(C0217h<Boolean> c0217h) {
            this.f46024d = c0217h;
        }

        /* renamed from: m */
        public void m57653m(InterfaceC1454i interfaceC1454i) {
            this.f46022b = interfaceC1454i;
        }

        /* renamed from: n */
        public void m57654n(INativeAd iNativeAd) {
            this.f46023c = iNativeAd;
        }
    }

    static {
        if (!TextUtils.isEmpty(C9169e.m57596e().m57599c())) {
            f46012e = C9499a.m59435c(r0, "agdPingTimeout", AsCache.TIME_HOUR);
        }
        HashMap map = new HashMap();
        f46013f = map;
        map.put(AppStatus.DOWNLOAD, -1);
        map.put(AppStatus.WAITING_FOR_WIFI, -1);
        map.put(AppStatus.WAITING, -1);
        map.put(AppStatus.DOWNLOADING, 2);
        map.put(AppStatus.PAUSE, 0);
        map.put(AppStatus.RESUME, 8);
        map.put(AppStatus.DOWNLOADED, 3);
        map.put(AppStatus.DOWNLOADFAILED, 1);
        map.put(AppStatus.INSTALLING, 5);
        map.put(AppStatus.INSTALL, 4);
        map.put(AppStatus.INSTALLED, 6);
    }

    /* renamed from: g */
    public static C9178n m57630g() {
        if (f46014g == null) {
            synchronized (C9178n.class) {
                try {
                    if (f46014g == null) {
                        f46014g = new C9178n();
                    }
                } finally {
                }
            }
        }
        return f46014g;
    }

    /* renamed from: f */
    public final synchronized Handler m57631f() {
        try {
            if (this.f46018d.compareAndSet(false, true)) {
                this.f46015a = new HandlerThread("status_callback_thread");
                this.f46015a.start();
                this.f46016b = new Handler(this.f46015a.getLooper());
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f46016b;
    }

    /* renamed from: h */
    public final boolean m57632h(b bVar) {
        try {
            bVar.f46022b.isAbort();
            return true;
        } catch (C9721b e10) {
            C11839m.m70687e("PpsAppDownloadListener", "pps abort exception " + e10.getMessage());
            bVar.f46021a.onStatusChange(1, 1, bVar.f46026f);
            m57638n(bVar, e10.m60659c());
            return false;
        }
    }

    /* renamed from: i */
    public final /* synthetic */ void m57633i(AppInfo appInfo, int i10) {
        try {
            b bVar = this.f46017c.get(appInfo.getPackageName());
            if (bVar == null) {
                C11839m.m70689w("PpsAppDownloadListener", "listenerBean is null");
                return;
            }
            bVar.f46026f = i10;
            C11839m.m70688i("PpsAppDownloadListener", "appName: " + appInfo.getAppName() + ", onDownloadProgress: " + i10);
            if (m57632h(bVar)) {
                if (i10 > 0) {
                    C9725c.m60672a().m60674c(bVar.f46025e, bVar.f46027g);
                }
                bVar.f46021a.onStatusChange(1, 2, i10);
            }
        } catch (Exception e10) {
            if (appInfo != null) {
                C11839m.m70687e("PpsAppDownloadListener", "process end appId: " + appInfo.getPackageName() + ", Exception:" + e10.getClass().getName());
                return;
            }
            C11839m.m70687e("PpsAppDownloadListener", "appInfo is null, thread name is " + this.f46015a.getName() + ", Exception:" + e10.getClass().getName());
        }
    }

    /* renamed from: j */
    public final /* synthetic */ void m57634j(AppInfo appInfo, AppStatus appStatus) {
        try {
            String packageName = appInfo.getPackageName();
            b bVar = this.f46017c.get(packageName);
            if (bVar == null) {
                C11839m.m70689w("PpsAppDownloadListener", "listenerBean is null");
                return;
            }
            C11839m.m70688i("PpsAppDownloadListener", "onStatusChanged: packageName: " + packageName + ", app status: " + appStatus.name());
            boolean z10 = (appStatus == AppStatus.WAITING || appStatus == AppStatus.WAITING_FOR_WIFI) ? false : true;
            if (m57632h(bVar) && z10) {
                C9725c.m60672a().m60674c(bVar.f46025e, bVar.f46027g);
            }
            int iIntValue = ((Integer) Optional.ofNullable(f46013f.get(appStatus)).orElse(3)).intValue();
            bVar.f46021a.onStatusChange(1, iIntValue, bVar.f46026f);
            if (iIntValue == 0) {
                this.f46017c.remove(packageName);
                bVar.f46024d.m1450a(Boolean.FALSE);
                C9725c.m60672a().m60675d(bVar.f46025e);
                HiAd.getInstance(C0213f.m1377a()).getAppDownloadManager().pauseDownload(C0213f.m1377a(), bVar.f46023c);
                return;
            }
            if (iIntValue == 1) {
                this.f46017c.remove(packageName);
                bVar.f46024d.m1450a(Boolean.FALSE);
                C9725c.m60672a().m60675d(bVar.f46025e);
                HiAd.getInstance(C0213f.m1377a()).getAppDownloadManager().cancelDownload(C0213f.m1377a(), bVar.f46023c);
                return;
            }
            if (iIntValue != 6) {
                return;
            }
            if (bVar.f46022b.checkAppVersion(1)) {
                C9725c.m60672a().m60675d(bVar.f46025e);
                bVar.f46024d.m1450a(Boolean.TRUE);
                this.f46017c.remove(packageName);
            } else {
                this.f46017c.remove(bVar.f46023c.getAppInfo().getPackageName());
                C9725c.m60672a().m60675d(bVar.f46025e);
                bVar.f46021a.onStatusChange(1, -3, bVar.f46026f);
                bVar.f46024d.m1450a(Boolean.FALSE);
            }
        } catch (Exception e10) {
            if (appInfo != null) {
                C11839m.m70687e("PpsAppDownloadListener", "process end appId: " + appInfo.getPackageName() + ", Exception:" + e10.getClass().getName());
                return;
            }
            C11839m.m70687e("PpsAppDownloadListener", "appInfo is null, thread name is " + this.f46015a.getName() + ", Exception:" + e10.getClass().getName());
        }
    }

    /* renamed from: k */
    public final /* synthetic */ void m57635k(String str) {
        b bVar = this.f46017c.get(str);
        if (bVar == null) {
            C11839m.m70689w("PpsAppDownloadListener", "can not find listenerBean");
        } else {
            m57638n(bVar, FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST);
        }
    }

    /* renamed from: l */
    public void m57636l() {
        this.f46017c.clear();
        HiAd.getInstance(C0213f.m1377a()).setAppDownloadListener(null);
        m57637m();
    }

    /* renamed from: m */
    public final synchronized void m57637m() {
        if (this.f46018d.compareAndSet(true, false)) {
            this.f46015a.quit();
            this.f46016b.removeCallbacks(null);
            this.f46015a = null;
            this.f46016b = null;
        }
    }

    /* renamed from: n */
    public final void m57638n(b bVar, int i10) {
        C11839m.m70688i("PpsAppDownloadListener", "restoreFail code: " + i10);
        this.f46017c.remove(bVar.f46023c.getAppInfo().getPackageName());
        C9725c.m60672a().m60675d(bVar.f46025e);
        if (bVar.f46022b.isPause() || i10 == 1002) {
            C11839m.m70688i("PpsAppDownloadListener", "task pause");
            HiAd.getInstance(C0213f.m1377a()).getAppDownloadManager().pauseDownload(C0213f.m1377a(), bVar.f46023c);
        } else {
            C11839m.m70688i("PpsAppDownloadListener", "task cancel");
            HiAd.getInstance(C0213f.m1377a()).getAppDownloadManager().cancelDownload(C0213f.m1377a(), bVar.f46023c);
        }
        bVar.f46024d.m1450a(Boolean.FALSE);
    }

    /* renamed from: o */
    public void m57639o(String str, b bVar) {
        this.f46017c.put(str, bVar);
        bVar.f46025e = (bVar.f46023c.getUniqueId() + 1).hashCode();
        bVar.f46027g = new a(bVar);
    }

    @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
    public void onAppOpen(AppInfo appInfo) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onAppOpen: ");
        sb2.append(appInfo != null ? appInfo.getAppName() : "unknown");
        C11839m.m70688i("PpsAppDownloadListener", sb2.toString());
    }

    @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
    public void onDownloadProgress(final AppInfo appInfo, final int i10) {
        m57631f().post(new Runnable() { // from class: dl.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f46007a.m57633i(appInfo, i10);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
    public void onStatusChanged(final AppStatus appStatus, final AppInfo appInfo) {
        m57631f().post(new Runnable() { // from class: dl.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f46004a.m57634j(appInfo, appStatus);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
    public void onUserCancel(AppInfo appInfo) {
        if (appInfo != null) {
            C11839m.m70688i("PpsAppDownloadListener", "onUserCancel: " + appInfo.getPackageName());
        }
    }

    /* renamed from: p */
    public void m57640p(INativeAd iNativeAd) {
        final String packageName = iNativeAd.getAppInfo().getPackageName();
        C11839m.m70688i("PpsAppDownloadListener", "enter stopAdDownload: " + packageName);
        m57631f().post(new Runnable() { // from class: dl.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f46010a.m57635k(packageName);
            }
        });
    }

    @Override // com.huawei.openalliance.p169ad.inter.listeners.AppDownloadListener
    public void onAppOpen(String str) {
        C11839m.m70688i("PpsAppDownloadListener", "onAppOpen: " + str);
    }
}
