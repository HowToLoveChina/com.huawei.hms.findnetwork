package com.huawei.hms.videokit.player;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.videokit.player.bean.Proxy;
import com.huawei.hms.videokit.player.internal.InterfaceC6572g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

/* renamed from: com.huawei.hms.videokit.player.i */
/* loaded from: classes8.dex */
class C6562i implements Preloader {

    /* renamed from: f */
    private static final int f30472f;

    /* renamed from: g */
    private static final int f30473g;

    /* renamed from: h */
    private static volatile C6562i f30474h;

    /* renamed from: i */
    private static volatile int f30475i;

    /* renamed from: a */
    private InterfaceC6572g f30476a;

    /* renamed from: b */
    private Context f30477b;

    /* renamed from: d */
    private Proxy f30479d;

    /* renamed from: c */
    private int f30478c = -1;

    /* renamed from: e */
    private ExecutorService f30480e = Executors.newFixedThreadPool(f30473g);

    /* renamed from: com.huawei.hms.videokit.player.i$a */
    public class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ CacheInfo f30481a;

        /* renamed from: b */
        final /* synthetic */ int f30482b;

        public a(CacheInfo cacheInfo, int i10) {
            this.f30481a = cacheInfo;
            this.f30482b = i10;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            C6560h c6560hM37211b = C6543b.m37207b().m37211b(this.f30481a.getPlayParam() + this.f30481a.getVideoFormat());
            if (!c6560hM37211b.m37378d()) {
                C6555e0 c6555e0 = new C6555e0(C6562i.this.f30477b);
                c6555e0.m37353d(C6600t0.m37688f());
                C6599t c6599t = new C6599t();
                C6560h c6560hM37652a = c6599t.m37652a(C6562i.this.f30477b, this.f30481a.getPlayParam(), this.f30481a.getAppId(), 0, this.f30481a.getVideoFormat());
                c6555e0.m37356f(c6599t.m37663l());
                c6555e0.m37350b(c6599t.m37653b());
                String strM37660i = c6599t.m37660i();
                String strM37656e = c6599t.m37656e();
                int iM37662k = c6599t.m37662k();
                int iM37651a = c6599t.m37651a();
                c6555e0.m37355e("/playserver/vod/getPlayInfo");
                c6555e0.m37354d(strM37660i);
                c6555e0.m37352c(strM37656e);
                c6555e0.m37346a(iM37662k);
                c6555e0.m37349b(c6599t.m37658g());
                c6555e0.m37351c(c6599t.m37659h());
                if (iM37651a != 0) {
                    c6555e0.m37348a(String.valueOf(iM37651a));
                }
                c6555e0.m37347a(C6600t0.m37688f());
                c6555e0.m37357h();
                C6543b.m37207b().m37210a(this.f30481a.getPlayParam() + this.f30481a.getVideoFormat(), c6560hM37652a);
                c6560hM37211b = c6560hM37652a;
            }
            if (!c6560hM37211b.m37378d()) {
                C6550c1.m37262b("PreloaderImp", "requestURL playUrl is empty");
                return;
            }
            C6550c1.m37256a("PreloaderImp", "requestURL playUrl[0]:" + c6560hM37211b.m37376b()[0]);
            CacheInfo cacheInfo = new CacheInfo();
            cacheInfo.setPlayParam(this.f30481a.getPlayParam());
            cacheInfo.setAppId(this.f30481a.getAppId());
            cacheInfo.setUrl(c6560hM37211b.m37376b()[0]);
            cacheInfo.setWidth(this.f30481a.getWidth());
            cacheInfo.setHeight(this.f30481a.getHeight());
            cacheInfo.setCacheSize(this.f30481a.getCacheSize());
            cacheInfo.setVideoFormat(this.f30481a.getVideoFormat());
            try {
                C6562i.this.f30476a.mo37414a(cacheInfo, this.f30482b);
            } catch (RemoteException e10) {
                C6550c1.m37258a("PreloaderImp", "addCachePriority", e10);
            }
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f30472f = iAvailableProcessors;
        f30473g = iAvailableProcessors * 2;
        f30475i = 0;
    }

    private C6562i(Context context) {
        this.f30477b = context;
        IBinder iBinderM37341a = C6554e.m37335a(context).m37341a("com.huawei.hms.videokit.player.PlayerPreloader");
        if (iBinderM37341a != null) {
            this.f30476a = InterfaceC6572g.a.m37416a(iBinderM37341a);
        }
    }

    /* renamed from: a */
    private int m37392a(CacheInfo cacheInfo, int i10) {
        if (this.f30478c != 0 || cacheInfo == null) {
            return -1;
        }
        if (TextUtils.isEmpty(cacheInfo.getUrl())) {
            this.f30480e.execute(new a(cacheInfo, i10));
        } else {
            try {
                this.f30476a.mo37414a(cacheInfo, i10);
            } catch (Exception e10) {
                C6550c1.m37258a("PreloaderImp", "addCache", e10);
            }
        }
        m37395a();
        return f30475i;
    }

    @Override // com.huawei.hms.videokit.player.Preloader
    public int addCache(CacheInfo cacheInfo) {
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("PreloaderImp", "addCache");
        if (this.f30478c != 0) {
            C6550c1.m37265d("PreloaderImp", "invoke initCache first");
            return -1;
        }
        int iM37392a = m37392a(cacheInfo, 0);
        C6556f.m37359a().m37361a(jM37688f, 0);
        return iM37392a;
    }

    @Override // com.huawei.hms.videokit.player.Preloader
    public int initCache(String str, int i10) {
        int i11;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("PreloaderImp", "initCache");
        try {
            this.f30478c = this.f30476a.mo37413a(ObjectWrapper.wrap(this.f30477b), str, i10);
            i11 = 0;
        } catch (Exception e10) {
            C6550c1.m37258a("PreloaderImp", "initCache:", e10);
            i11 = -1;
        }
        C6556f.m37359a().m37361a(jM37688f, i11);
        return this.f30478c;
    }

    @Override // com.huawei.hms.videokit.player.Preloader
    public int pauseAllTasks() {
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("PreloaderImp", "pauseAllTasks");
        int iPauseAllTasks = -1;
        if (this.f30478c != 0) {
            C6550c1.m37265d("PreloaderImp", "invoke initCache first");
            return -1;
        }
        try {
            iPauseAllTasks = this.f30476a.pauseAllTasks();
            i10 = 0;
        } catch (Exception e10) {
            C6550c1.m37258a("PreloaderImp", "pauseAllTasks:", e10);
            i10 = -1;
        }
        C6556f.m37359a().m37361a(jM37688f, i10);
        return iPauseAllTasks;
    }

    @Override // com.huawei.hms.videokit.player.Preloader
    public int removeAllCache() {
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("PreloaderImp", "removeAllCache");
        int iRemoveAllCache = -1;
        if (this.f30478c != 0) {
            C6550c1.m37265d("PreloaderImp", "invoke initCache first");
            return -1;
        }
        try {
            iRemoveAllCache = this.f30476a.removeAllCache();
            i10 = 0;
        } catch (Exception e10) {
            C6550c1.m37258a("PreloaderImp", "removeAllCache:", e10);
            i10 = -1;
        }
        C6556f.m37359a().m37361a(jM37688f, i10);
        return iRemoveAllCache;
    }

    @Override // com.huawei.hms.videokit.player.Preloader
    public int removeAllTasks() {
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("PreloaderImp", "removeAllTasks");
        int iRemoveAllTasks = -1;
        if (this.f30478c != 0) {
            C6550c1.m37265d("PreloaderImp", "invoke initCache first");
            return -1;
        }
        try {
            iRemoveAllTasks = this.f30476a.removeAllTasks();
            i10 = 0;
        } catch (Exception e10) {
            C6550c1.m37258a("PreloaderImp", "removeAllTasks:", e10);
            i10 = -1;
        }
        C6556f.m37359a().m37361a(jM37688f, i10);
        return iRemoveAllTasks;
    }

    @Override // com.huawei.hms.videokit.player.Preloader
    public int resumeAllTasks() {
        int i10;
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("PreloaderImp", "resumeAllTasks");
        int iResumeAllTasks = -1;
        if (this.f30478c != 0) {
            C6550c1.m37265d("PreloaderImp", "invoke initCache first");
            return -1;
        }
        try {
            iResumeAllTasks = this.f30476a.resumeAllTasks();
            i10 = 0;
        } catch (Exception e10) {
            C6550c1.m37258a("PreloaderImp", "resumeAllTasks:", e10);
            i10 = -1;
        }
        C6556f.m37359a().m37361a(jM37688f, i10);
        return iResumeAllTasks;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0052 A[Catch: RemoteException -> 0x0050, TryCatch #0 {RemoteException -> 0x0050, blocks: (B:4:0x0011, B:6:0x0019, B:8:0x0025, B:11:0x0032, B:15:0x0055, B:14:0x0052, B:16:0x005b), top: B:21:0x0011 }] */
    @Override // com.huawei.hms.videokit.player.Preloader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setProxy(com.huawei.hms.videokit.player.bean.Proxy r7) {
        /*
            r6 = this;
            java.lang.String r0 = ""
            long r1 = com.huawei.hms.videokit.player.C6600t0.m37688f()
            java.lang.String r3 = "setProxy"
            java.lang.String r4 = "PreloaderImp"
            com.huawei.hms.videokit.player.C6550c1.m37264c(r4, r3)
            r6.f30479d = r7
            if (r7 == 0) goto L52
            com.huawei.hms.videokit.player.bean.Proxy$Type r7 = r7.getType()     // Catch: android.os.RemoteException -> L50
            com.huawei.hms.videokit.player.bean.Proxy$Type r3 = com.huawei.hms.videokit.player.bean.Proxy.Type.SOCKS     // Catch: android.os.RemoteException -> L50
            if (r7 != r3) goto L55
            com.huawei.hms.videokit.player.bean.Proxy r7 = r6.f30479d     // Catch: android.os.RemoteException -> L50
            java.lang.String r7 = r7.getHost()     // Catch: android.os.RemoteException -> L50
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch: android.os.RemoteException -> L50
            if (r7 != 0) goto L52
            com.huawei.hms.videokit.player.bean.Proxy r7 = r6.f30479d     // Catch: android.os.RemoteException -> L50
            java.lang.String r7 = r7.getPort()     // Catch: android.os.RemoteException -> L50
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch: android.os.RemoteException -> L50
            if (r7 == 0) goto L32
            goto L52
        L32:
            com.huawei.hms.videokit.player.internal.g r7 = r6.f30476a     // Catch: android.os.RemoteException -> L50
            com.huawei.hms.videokit.player.bean.Proxy r0 = r6.f30479d     // Catch: android.os.RemoteException -> L50
            java.lang.String r0 = r0.getHost()     // Catch: android.os.RemoteException -> L50
            com.huawei.hms.videokit.player.bean.Proxy r3 = r6.f30479d     // Catch: android.os.RemoteException -> L50
            java.lang.String r3 = r3.getPort()     // Catch: android.os.RemoteException -> L50
            com.huawei.hms.videokit.player.bean.Proxy r5 = r6.f30479d     // Catch: android.os.RemoteException -> L50
            java.lang.String r5 = r5.getUser()     // Catch: android.os.RemoteException -> L50
            com.huawei.hms.videokit.player.bean.Proxy r6 = r6.f30479d     // Catch: android.os.RemoteException -> L50
            java.lang.String r6 = r6.getPasswd()     // Catch: android.os.RemoteException -> L50
            r7.mo37415a(r0, r3, r5, r6)     // Catch: android.os.RemoteException -> L50
            goto L5e
        L50:
            r6 = move-exception
            goto L60
        L52:
            com.huawei.hms.videokit.player.internal.g r6 = r6.f30476a     // Catch: android.os.RemoteException -> L50
            goto L5b
        L55:
            java.lang.String r6 = "not socks Proxy"
            com.huawei.hms.videokit.player.C6550c1.m37265d(r4, r6)     // Catch: android.os.RemoteException -> L50
            goto L5e
        L5b:
            r6.mo37415a(r0, r0, r0, r0)     // Catch: android.os.RemoteException -> L50
        L5e:
            r6 = 0
            goto L66
        L60:
            java.lang.String r7 = "setProxy:"
            com.huawei.hms.videokit.player.C6550c1.m37258a(r4, r7, r6)
            r6 = 1
        L66:
            com.huawei.hms.videokit.player.f r7 = com.huawei.hms.videokit.player.C6556f.m37359a()
            r7.m37361a(r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.videokit.player.C6562i.setProxy(com.huawei.hms.videokit.player.bean.Proxy):void");
    }

    @Override // com.huawei.hms.videokit.player.Preloader
    public int addCache(CacheInfo cacheInfo, int i10) {
        long jM37688f = C6600t0.m37688f();
        C6550c1.m37264c("PreloaderImp", "addCache priority:" + i10);
        if (this.f30478c != 0) {
            C6550c1.m37265d("PreloaderImp", "invoke initCache first");
            return -1;
        }
        int iM37392a = m37392a(cacheInfo, i10);
        C6556f.m37359a().m37361a(jM37688f, 0);
        return iM37392a;
    }

    /* renamed from: a */
    public static C6562i m37394a(Context context) {
        if (f30474h == null) {
            synchronized (C6562i.class) {
                try {
                    if (f30474h == null) {
                        f30474h = new C6562i(context);
                    }
                } finally {
                }
            }
        }
        return f30474h;
    }

    /* renamed from: a */
    private static void m37395a() {
        f30475i++;
    }
}
