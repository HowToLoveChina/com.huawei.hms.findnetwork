package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: androidx.emoji2.text.b */
/* loaded from: classes.dex */
public class C0685b {

    /* renamed from: androidx.emoji2.text.b$a */
    public static class a {
        /* renamed from: a */
        public static Handler m4205a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    /* renamed from: b */
    public static ThreadPoolExecutor m4202b(final String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactory() { // from class: androidx.emoji2.text.a
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return C0685b.m4203c(str, runnable);
            }
        });
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* renamed from: c */
    public static /* synthetic */ Thread m4203c(String str, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setPriority(10);
        return thread;
    }

    /* renamed from: d */
    public static Handler m4204d() {
        return a.m4205a(Looper.getMainLooper());
    }
}
