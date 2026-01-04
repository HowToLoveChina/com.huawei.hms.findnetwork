package p015ak;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p399jk.AbstractC10896a;
import p616rk.C12515a;

/* renamed from: ak.l0 */
/* loaded from: classes6.dex */
public class C0226l0 {

    /* renamed from: a */
    public static final Object f846a = new Object();

    /* renamed from: b */
    public static volatile Handler f847b;

    /* renamed from: a */
    public static boolean m1581a(long j10) throws InterruptedException {
        if (j10 <= 0) {
            return false;
        }
        try {
            Thread.sleep(j10);
            return true;
        } catch (InterruptedException e10) {
            AbstractC10896a.m65886e("ThreadUtils", "delay exception:" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: b */
    public static <T> T m1582b(Callable<T> callable, long j10, T t10) {
        AbstractC10896a.m65887i("ThreadUtils", "executeWithTimeout enter");
        Future<T> futureSubmit = C12515a.m75110o().m75178f().submit(callable);
        try {
            return futureSubmit.get(j10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            futureSubmit.cancel(true);
            AbstractC10896a.m65886e("ThreadUtils", "executeWithTimeout failed, " + e10.getMessage());
            return t10;
        }
    }

    /* renamed from: c */
    public static Handler m1583c() {
        Handler handler;
        if (f847b != null) {
            return f847b;
        }
        synchronized (f846a) {
            try {
                if (f847b == null) {
                    f847b = new Handler(Looper.getMainLooper());
                }
                handler = f847b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return handler;
    }

    /* renamed from: d */
    public static void m1584d(Runnable runnable) {
        m1583c().post(runnable);
    }

    /* renamed from: e */
    public static void m1585e(Runnable runnable, long j10) {
        m1583c().postDelayed(runnable, j10);
    }

    /* renamed from: f */
    public static void m1586f(Runnable runnable) {
        if (m1587g()) {
            runnable.run();
        } else {
            m1583c().post(runnable);
        }
    }

    /* renamed from: g */
    public static boolean m1587g() {
        return m1583c().getLooper() == Looper.myLooper();
    }
}
