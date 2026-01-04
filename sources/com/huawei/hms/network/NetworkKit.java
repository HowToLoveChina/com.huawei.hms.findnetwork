package com.huawei.hms.network;

import android.annotation.SuppressLint;
import android.content.Context;
import com.huawei.hms.framework.common.ActivityUtil;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.network.api.C5827a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes8.dex */
public abstract class NetworkKit {

    /* renamed from: a */
    private static final String f25621a = "NetworkKit";

    /* renamed from: b */
    private static final int f25622b = 1000;

    /* renamed from: c */
    private static String f25623c;

    /* renamed from: d */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile NetworkKit f25624d;

    /* renamed from: e */
    @SuppressLint({"StaticFieldLeak"})
    private static RemoteInitializer f25625e;

    /* renamed from: f */
    @SuppressLint({"StaticFieldLeak"})
    private static Context f25626f;

    /* renamed from: g */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile Future f25627g;

    /* renamed from: h */
    @SuppressLint({"StaticFieldLeak"})
    private static final Lock f25628h = new ReentrantLock();

    /* renamed from: i */
    @SuppressLint({"StaticFieldLeak"})
    private static ExecutorService f25629i = ExecutorsUtils.newSingleThreadExecutor("NK");

    /* renamed from: j */
    public static final /* synthetic */ int f25630j = 0;

    public static abstract class Callback {
        public abstract void onResult(boolean z10);
    }

    /* renamed from: com.huawei.hms.network.NetworkKit$a */
    public class RunnableC5779a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Callback f25631a;

        public RunnableC5779a(Callback callback) {
            this.f25631a = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            NetworkKit.getInstance();
            NetworkKit.m33222a(this.f25631a);
        }
    }

    /* renamed from: com.huawei.hms.network.NetworkKit$b */
    public class RunnableC5780b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Callback f25632a;

        public RunnableC5780b(Callback callback) {
            this.f25632a = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            NetworkKit.m33222a(this.f25632a);
        }
    }

    /* renamed from: a */
    private static Future m33221a(Callback callback, String str) {
        try {
            if (f25627g == null) {
                f25623c = str;
                f25627g = f25629i.submit(new RunnableC5779a(callback));
            } else {
                f25629i.execute(new RunnableC5780b(callback));
            }
        } catch (RejectedExecutionException unused) {
            Logger.m32138e("NetworkKit", "init networkkit error, please try later");
        }
        return f25627g;
    }

    public static Context getContext() {
        Context context = f25626f;
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("you must call init(final Context context, final Callback callback) or init(final Context context, final Callback callback, final String options) before all Method");
    }

    public static synchronized NetworkKit getInstance() {
        NetworkKit networkKitCreateNetworkKit;
        if (f25624d != null) {
            return f25624d;
        }
        if (m33223a()) {
            Logger.m32141i("NetworkKit", "dynamic load");
            if (f25625e == null) {
                f25625e = new RemoteInitializer();
            }
            Future futureInit = getRemoteInitializer().init(getContext());
            if (futureInit != null) {
                try {
                    futureInit.get(1000L, TimeUnit.MILLISECONDS);
                } catch (InterruptedException | ExecutionException | TimeoutException e10) {
                    Logger.m32138e("NetworkKit", "create exception = " + e10.getClass().getSimpleName());
                }
            }
            networkKitCreateNetworkKit = NetworkKitProvider.getEnableProvider(true).createNetworkKit();
        } else {
            Logger.m32141i("NetworkKit", "not dynamic load");
            networkKitCreateNetworkKit = NetworkKitProvider.loadLocalProvider().createNetworkKit();
        }
        f25624d = networkKitCreateNetworkKit;
        f25624d.initKit(f25626f, f25623c);
        return f25624d;
    }

    public static RemoteInitializer getRemoteInitializer() {
        return f25625e;
    }

    public static Future init(Context context, Callback callback) {
        return init(context, callback, "");
    }

    public abstract void addQuicHint(boolean z10, String... strArr);

    public abstract void evictAllConnections();

    public abstract String getOption(String str);

    public abstract void initConnectionPool(int i10, long j10, TimeUnit timeUnit);

    public abstract void initKit(Context context, String str);

    public abstract void setOptions(String str);

    /* renamed from: a */
    public static void m33222a(Callback callback) {
        boolean z10 = f25624d != null;
        if (z10) {
            Logger.m32141i("NetworkKit", "init success");
        } else {
            Logger.m32138e("NetworkKit", "you must implementation network-embedded sdk, and ensure the context is kitself or appself");
        }
        if (callback != null) {
            callback.onResult(z10);
        }
    }

    public static Future init(Context context, Callback callback, String str) {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        Logger.m32141i("NetworkKit", "init  Version:" + Version.getVersion() + "  BuildTime:" + Version.getBuildTime() + " cp:" + context.getPackageName());
        Lock lock = f25628h;
        lock.lock();
        try {
            ContextHolder.setAppContext(context.getApplicationContext());
            f25626f = ContextHolder.getAppContext();
            ActivityUtil.getInstance().register();
            Future futureM33221a = m33221a(callback, str);
            lock.unlock();
            return futureM33221a;
        } catch (Throwable th2) {
            f25628h.unlock();
            throw th2;
        }
    }

    /* renamed from: a */
    private static boolean m33223a() {
        return C5827a.m33630a(f25626f);
    }
}
