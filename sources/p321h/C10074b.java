package p321h;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: h.b */
/* loaded from: classes.dex */
public class C10074b extends AbstractC10075c {

    /* renamed from: a */
    public final Object f49142a = new Object();

    /* renamed from: b */
    public final ExecutorService f49143b = Executors.newFixedThreadPool(4, new a());

    /* renamed from: c */
    public volatile Handler f49144c;

    /* renamed from: h.b$a */
    public class a implements ThreadFactory {

        /* renamed from: a */
        public final AtomicInteger f49145a = new AtomicInteger(0);

        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.f49145a.getAndIncrement())));
            return thread;
        }
    }

    /* renamed from: d */
    public static Handler m62700d(Looper looper) {
        return Handler.createAsync(looper);
    }

    @Override // p321h.AbstractC10075c
    /* renamed from: a */
    public void mo62697a(Runnable runnable) {
        this.f49143b.execute(runnable);
    }

    @Override // p321h.AbstractC10075c
    /* renamed from: b */
    public boolean mo62698b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // p321h.AbstractC10075c
    /* renamed from: c */
    public void mo62699c(Runnable runnable) {
        if (this.f49144c == null) {
            synchronized (this.f49142a) {
                try {
                    if (this.f49144c == null) {
                        this.f49144c = m62700d(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        this.f49144c.post(runnable);
    }
}
