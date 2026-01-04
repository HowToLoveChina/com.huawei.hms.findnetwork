package com.huawei.hms.videokit.player;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.gson.Gson;
import com.huawei.hiar.ARImageMetadata;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.videokit.player.C6550c1;
import com.huawei.hms.videokit.player.WisePlayerFactoryOptionsExt;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import com.huawei.hms.videokit.player.internal.InterfaceC6578m;
import com.huawei.hms.videokit.player.internal.InterfaceC6579n;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

/* loaded from: classes8.dex */
public abstract class WisePlayerFactory {

    /* renamed from: a */
    private static Context f30257a = null;

    /* renamed from: b */
    private static WisePlayerFactoryOptionsExt f30258b = null;

    /* renamed from: c */
    private static InitFactoryCallback f30259c = null;

    /* renamed from: d */
    protected static volatile boolean f30260d = false;

    /* renamed from: e */
    private static volatile boolean f30261e = false;

    /* renamed from: f */
    private static C6582k f30262f = null;

    /* renamed from: g */
    private static volatile C6558g f30263g = null;

    /* renamed from: h */
    private static long f30264h = 0;

    /* renamed from: i */
    private static volatile boolean f30265i = false;

    /* renamed from: j */
    private static volatile boolean f30266j = false;

    /* renamed from: k */
    private static boolean f30267k = false;

    /* renamed from: l */
    private static boolean f30268l = false;

    /* renamed from: m */
    private static boolean f30269m = false;

    /* renamed from: n */
    private static final Object f30270n = new Object();

    /* renamed from: o */
    private static ExecutorService f30271o;

    /* renamed from: com.huawei.hms.videokit.player.WisePlayerFactory$a */
    public class RunnableC6537a implements Runnable {

        /* renamed from: com.huawei.hms.videokit.player.WisePlayerFactory$a$a */
        public class a extends InterfaceC6579n.a {

            /* renamed from: a */
            final /* synthetic */ InterfaceC6578m f30272a;

            public a(RunnableC6537a runnableC6537a, InterfaceC6578m interfaceC6578m) {
                this.f30272a = interfaceC6578m;
            }

            @Override // com.huawei.hms.videokit.player.internal.InterfaceC6579n
            /* renamed from: a */
            public void mo37131a(int i10, String str) throws RemoteException {
                C6550c1.m37264c("WisePlayerFactory", "notifyStartupResult status:" + i10 + " reason:" + str);
                boolean unused = WisePlayerFactory.f30261e = false;
                if (i10 == 0) {
                    WisePlayerFactory.m37114c(true);
                    WisePlayerFactory.m37111b(this.f30272a);
                } else {
                    WisePlayerFactory.m37114c(false);
                    C6550c1.m37264c("WisePlayerFactory", "init dynamicLoad fail, error code :9904, reason is :" + str);
                    C6580j.m37440a(this.f30272a.mo37433f(), WisePlayerFactory.f30257a);
                }
                WisePlayerFactory.m37123k();
                WisePlayerFactory.m37110b(0);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean unused = WisePlayerFactory.f30261e = true;
            C6554e c6554eM37335a = C6554e.m37335a(WisePlayerFactory.f30257a);
            C6550c1.m37264c("WisePlayerFactory", "dynamicLoader:" + c6554eM37335a);
            try {
                IBinder iBinderM37341a = c6554eM37335a.m37341a("com.huawei.hms.videokit.player.VideoInit");
                if (iBinderM37341a != null) {
                    InterfaceC6578m interfaceC6578mM37434a = InterfaceC6578m.a.m37434a(iBinderM37341a);
                    if (WisePlayerFactory.f30258b == null || WisePlayerFactory.f30258b.getLogConfigInfo() == null) {
                        interfaceC6578mM37434a.mo37428a(ObjectWrapper.wrap(WisePlayerFactory.f30257a), C6550c1.a.INFO.m37267a(), C6550c1.m37251a(WisePlayerFactory.f30257a), 20, ARImageMetadata.SHADING_MODE);
                    } else {
                        LogConfigInfo logConfigInfo = WisePlayerFactory.f30258b.getLogConfigInfo();
                        interfaceC6578mM37434a.mo37428a(ObjectWrapper.wrap(WisePlayerFactory.f30257a), logConfigInfo.getLogLevel(), C6550c1.m37252a(WisePlayerFactory.f30257a, logConfigInfo.getLogFilePath()), logConfigInfo.getLogFileNum(), logConfigInfo.getLogFileSize());
                    }
                    interfaceC6578mM37434a.mo37431d(false);
                    C6580j.m37444b(interfaceC6578mM37434a.mo37432e());
                    interfaceC6578mM37434a.mo37426a(ObjectWrapper.wrap(WisePlayerFactory.f30257a), ObjectWrapper.wrap(c6554eM37335a.m37343c()), WisePlayerFactory.m37124l(), "1.0.16.300", new a(this, interfaceC6578mM37434a));
                } else {
                    boolean unused2 = WisePlayerFactory.f30261e = false;
                    WisePlayerFactory.m37114c(false);
                    C6550c1.m37264c("WisePlayerFactory", "init dynamicLoad fail, error code :" + C6554e.m37333a() + ", reason is :" + C6554e.m37338b());
                    if (c6554eM37335a.m37344d()) {
                        C6550c1.m37264c("WisePlayerFactory", "Dynamic loading failed, return directly.");
                        WisePlayerFactory.m37123k();
                    }
                    WisePlayerFactory.m37110b(C6554e.m37333a());
                }
                if (C6600t0.m37685d(WisePlayerFactory.f30257a).endsWith(":player")) {
                    return;
                }
                BinderC6607x binderC6607x = new BinderC6607x();
                binderC6607x.mo37409b(ObjectWrapper.wrap(WisePlayerFactory.f30257a));
                C6556f.m37359a().m37363a(binderC6607x);
                C6556f.m37359a().m37364a("initFactory", WisePlayerFactory.f30264h, 0, "");
            } catch (Exception e10) {
                boolean unused3 = WisePlayerFactory.f30261e = false;
                WisePlayerFactory.m37114c(false);
                WisePlayerFactory.m37123k();
                WisePlayerFactory.m37110b(C6554e.m37333a());
                C6550c1.m37258a("WisePlayerFactory", "initFactory error:", e10);
            }
        }
    }

    /* renamed from: e */
    public static InitFactoryCallback m37117e() {
        return f30259c;
    }

    /* renamed from: f */
    public static Context m37118f() {
        return f30257a;
    }

    /* renamed from: g */
    public static C6582k m37119g() {
        return f30262f;
    }

    /* renamed from: h */
    public static WisePlayerFactoryOptionsExt m37120h() {
        return f30258b;
    }

    /* renamed from: i */
    private static void m37121i() {
        if (!m37129q()) {
            C6550c1.m37264c("WisePlayerFactory", "update is not supported in the current country");
            m37123k();
        } else if (f30261e) {
            C6550c1.m37264c("WisePlayerFactory", "sdk Initing");
        } else {
            f30271o.execute(new RunnableC6537a());
        }
    }

    @Deprecated
    public static void initFactory(Context context, WisePlayerFactoryOptions wisePlayerFactoryOptions, InitFactoryCallback initFactoryCallback) {
        WisePlayerFactoryOptionsExt.Builder builder = new WisePlayerFactoryOptionsExt.Builder();
        if (wisePlayerFactoryOptions != null) {
            builder.setDeviceId(wisePlayerFactoryOptions.getDeviceId());
            builder.setServeInForeground(false);
        }
        initFactory(context, builder.build(), initFactoryCallback);
    }

    /* renamed from: j */
    private static void m37122j() throws JSONException {
        if (C6580j.m37447d().m37453g()) {
            C6550c1.m37264c("WisePlayerFactory", "GRS and HA initialization completed");
        } else {
            C6580j.m37447d().m37451a(f30257a, f30258b, "1.0.16.300");
        }
    }

    /* renamed from: k */
    public static void m37123k() {
        if (f30268l) {
            release(f30257a);
            m37125m();
        } else {
            m37126n();
        }
        m37130r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static String m37124l() {
        try {
            return new Gson().toJson(f30258b);
        } catch (Exception e10) {
            C6550c1.m37258a("WisePlayerFactory", "init factory options error:", e10);
            return "";
        }
    }

    /* renamed from: m */
    private static void m37125m() {
        InitFactoryCallback initFactoryCallback = f30259c;
        if (initFactoryCallback != null) {
            initFactoryCallback.onFailure(PlayerConstants.InitErrorCode.INIT_ERROR_DMP_OPEN_FAILED, "Player release process started, initialization failed");
        }
    }

    /* renamed from: n */
    private static void m37126n() {
        if (f30265i || f30259c == null) {
            C6550c1.m37264c("WisePlayerFactory", "It has been reported successfully, or callBack is null.");
            return;
        }
        f30265i = true;
        C6582k c6582k = new C6582k(f30257a);
        f30262f = c6582k;
        f30259c.onSuccess(c6582k);
    }

    /* renamed from: o */
    private static void m37127o() {
        f30260d = false;
        f30262f = null;
        f30265i = false;
        f30261e = false;
        m37128p();
    }

    /* renamed from: p */
    public static void m37128p() {
        if (m37129q()) {
            C6554e.m37335a(f30257a).m37342a(true);
        } else {
            C6550c1.m37265d("WisePlayerFactory", "setCallBackEnable is not supported in the current country");
        }
    }

    /* renamed from: q */
    private static boolean m37129q() {
        return !C6600t0.m37685d(f30257a).endsWith(":player") && C6580j.m37447d().m37454h();
    }

    /* renamed from: r */
    private static void m37130r() {
        try {
            if (f30263g != null) {
                f30263g.m37367b();
                f30263g = null;
            }
        } catch (Exception e10) {
            C6550c1.m37258a("WisePlayerFactory", "unRegisterReceiver error:", e10);
        }
    }

    public static void release(Context context) {
        String str;
        String str2;
        if (context == null) {
            C6550c1.m37264c("WisePlayerFactory", "release context is null");
            return;
        }
        synchronized (f30270n) {
            try {
                if (f30267k) {
                    C6550c1.m37264c("WisePlayerFactory", "the wisePlayerFactory has been released");
                    return;
                }
                m37130r();
                if (!f30265i) {
                    f30268l = true;
                    C6550c1.m37264c("WisePlayerFactory", "Initialization is not finished and needs to wait");
                    return;
                }
                f30267k = true;
                f30268l = false;
                f30269m = false;
                C6550c1.m37264c("WisePlayerFactory", "release " + context.getPackageName());
                try {
                    try {
                    } catch (Throwable th2) {
                        f30267k = false;
                        m37127o();
                        throw th2;
                    }
                } catch (Exception e10) {
                    C6550c1.m37258a("WisePlayerFactory", "release error:", e10);
                }
                if (m37129q()) {
                    C6554e c6554eM37335a = C6554e.m37335a(f30257a);
                    C6550c1.m37256a("WisePlayerFactory", "dynamicLoader:" + c6554eM37335a);
                    IBinder iBinderM37341a = c6554eM37335a.m37341a("com.huawei.hms.videokit.player.VideoInit");
                    if (iBinderM37341a != null) {
                        InterfaceC6578m interfaceC6578mM37434a = InterfaceC6578m.a.m37434a(iBinderM37341a);
                        C6550c1.m37264c("WisePlayerFactory", "start calling VideoInit release interface");
                        interfaceC6578mM37434a.mo37427a(ObjectWrapper.wrap(context));
                        f30267k = false;
                        m37127o();
                    }
                    str = "WisePlayerFactory";
                    str2 = "failed to get VideoInit binder through dynamic";
                } else {
                    str = "WisePlayerFactory";
                    str2 = "dynamicloader is not supported in the current country";
                }
                C6550c1.m37264c(str, str2);
                f30267k = false;
                m37127o();
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public static void reportException(Thread thread, Throwable th2) {
        if (thread == null || th2 == null || !f30269m || !f30260d) {
            return;
        }
        C6554e c6554eM37335a = C6554e.m37335a(f30257a);
        C6550c1.m37264c("WisePlayerFactory", "reportException dynamicLoader:" + c6554eM37335a);
        try {
            IBinder iBinderM37341a = c6554eM37335a.m37341a("com.huawei.hms.videokit.player.VideoInit");
            if (iBinderM37341a != null) {
                InterfaceC6578m.a.m37434a(iBinderM37341a).mo37430b(C6600t0.m37676a(thread, th2));
            } else {
                C6550c1.m37264c("WisePlayerFactory", "failed to get VideoInit binder through dynamic");
            }
        } catch (Exception e10) {
            C6550c1.m37258a("WisePlayerFactory", "reportException error:", e10);
        }
    }

    public static void updateServeCountry(String str) {
        long jM37688f = C6600t0.m37688f();
        C6580j.m37447d().m37452e(str);
        C6556f.m37359a().m37364a("updateServeCountry", jM37688f, 0, "");
    }

    public abstract Preloader createPreloader() throws CreateComponentException;

    public abstract WisePlayer createWisePlayer() throws CreateComponentException;

    public boolean isDynamicLoadSuccess() {
        return f30260d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m37110b(int i10) {
        if (f30266j) {
            new C6557f0(f30257a).m37365a(i10);
            f30266j = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m37114c(boolean z10) {
        f30260d = z10;
    }

    /* renamed from: d */
    public static void m37116d(boolean z10) {
        f30266j = z10;
    }

    public static void initFactory(Context context, WisePlayerFactoryOptionsExt wisePlayerFactoryOptionsExt, InitFactoryCallback initFactoryCallback) {
        C6582k c6582k;
        f30264h = C6600t0.m37688f();
        C6550c1.m37264c("WisePlayerFactory", "VideoKit SDK version:10016300");
        if (context == null || initFactoryCallback == null) {
            if (initFactoryCallback != null) {
                initFactoryCallback.onFailure(PlayerConstants.InitErrorCode.INIT_ERROR_PARAM_ILLEGAL, "context is null");
            }
            C6550c1.m37262b("WisePlayerFactory", "init fail context or callback is null");
            return;
        }
        if (f30265i && (c6582k = f30262f) != null) {
            initFactoryCallback.onSuccess(c6582k);
            C6550c1.m37264c("WisePlayerFactory", "already init");
            C6556f.m37359a().m37364a("initFactory", f30264h, 0, "");
            return;
        }
        synchronized (f30270n) {
            try {
                if (f30271o == null) {
                    f30271o = Executors.newSingleThreadExecutor();
                }
                f30267k = false;
                f30268l = false;
                if (wisePlayerFactoryOptionsExt != null) {
                    f30269m = wisePlayerFactoryOptionsExt.isServeInForeground();
                }
                m37106a(context, wisePlayerFactoryOptionsExt);
                f30257a = context.getApplicationContext();
                f30258b = wisePlayerFactoryOptionsExt;
                f30259c = initFactoryCallback;
                if (f30263g == null) {
                    f30263g = new C6558g(context);
                    f30263g.m37366a();
                }
                m37122j();
                m37121i();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    private static void m37106a(Context context, WisePlayerFactoryOptionsExt wisePlayerFactoryOptionsExt) {
        if (wisePlayerFactoryOptionsExt == null || wisePlayerFactoryOptionsExt.getLogConfigInfo() == null) {
            C6550c1.m37259a(context.getApplicationContext(), "HmsVKP_", C6550c1.m37251a(context), C6550c1.a.INFO);
        } else {
            LogConfigInfo logConfigInfo = wisePlayerFactoryOptionsExt.getLogConfigInfo();
            C6550c1.m37260a(context.getApplicationContext(), "HmsVKP_", C6550c1.m37252a(context, logConfigInfo.getLogFilePath()), C6550c1.a.m37266a(C6550c1.m37263c(logConfigInfo.getLogLevel())), C6550c1.m37250a(logConfigInfo.getLogFileNum()) / 4, C6550c1.m37261b(logConfigInfo.getLogFileSize()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m37111b(InterfaceC6578m interfaceC6578m) {
        try {
            interfaceC6578m.mo37429a(ObjectWrapper.wrap(f30257a), f30258b.isEnableIPv6());
        } catch (Exception e10) {
            C6550c1.m37258a("WisePlayerFactory", "enableIpV6 error:", e10);
        }
    }
}
