package p052cb;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.huawei.android.hicloud.album.service.C2415b;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import p015ak.C0225l;
import p015ak.C0226l0;
import p514o9.C11839m;

/* renamed from: cb.e */
/* loaded from: classes3.dex */
public class C1408e {

    /* renamed from: g */
    public static C1408e f6035g = new C1408e();

    /* renamed from: e */
    public Future<?> f6040e;

    /* renamed from: a */
    public final AtomicBoolean f6036a = new AtomicBoolean(false);

    /* renamed from: b */
    public ExecutorService f6037b = Executors.newSingleThreadExecutor();

    /* renamed from: c */
    public final C1407d f6038c = new C1407d();

    /* renamed from: d */
    public Consumer<String> f6039d = null;

    /* renamed from: f */
    public b f6041f = new b();

    /* renamed from: cb.e$b */
    public class b implements Runnable {

        /* renamed from: a */
        public boolean f6042a;

        public b() {
        }

        /* renamed from: d */
        public final void m8141d() throws InterruptedException {
            Looper mainLooper = Looper.getMainLooper();
            Handler handler = new Handler(mainLooper);
            final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            long j10 = 960000;
            while (this.f6042a) {
                C11839m.m70686d("AnrWatcher", "AnrWatcher is running");
                if (atomicBoolean.compareAndSet(true, false)) {
                    C1408e.this.f6038c.m8120d();
                    handler.postAtFrontOfQueue(new Runnable() { // from class: cb.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            atomicBoolean.set(true);
                        }
                    });
                }
                C1408e.this.m8137q(4000L);
                C1408e.this.f6038c.m8117a(atomicBoolean.get());
                j10 -= 4000;
                if (j10 <= 0) {
                    C1408e.this.m8132l();
                    C1408e.this.f6038c.m8118b();
                    j10 = 960000;
                }
                if (!atomicBoolean.get()) {
                    C1408e.this.m8127f(mainLooper.getThread());
                    C1408e.this.m8137q(60000L);
                }
            }
        }

        /* renamed from: f */
        public void m8142f(boolean z10) {
            this.f6042a = z10;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            for (int i10 = 0; i10 < 5; i10++) {
                C1408e.this.m8133m(new Runnable() { // from class: cb.f
                    @Override // java.lang.Runnable
                    public final void run() throws InterruptedException {
                        this.f6044a.m8141d();
                    }
                });
                C0226l0.m1581a(5000L);
            }
            if (this.f6042a) {
                C11839m.m70687e("AnrWatcher", "failed to start too many times, abort");
            }
        }

        public /* synthetic */ b(C1408e c1408e, a aVar) {
            this();
        }
    }

    /* renamed from: i */
    public static C1408e m8126i() {
        return f6035g;
    }

    /* renamed from: f */
    public final void m8127f(Thread thread) {
        String strM8129h = m8129h(thread);
        m8131k(strM8129h);
        m8130j(strM8129h);
    }

    /* renamed from: g */
    public final String m8128g() {
        return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date());
    }

    /* renamed from: h */
    public final String m8129h(Thread thread) {
        try {
            StackTraceElement[] stackTrace = thread.getStackTrace();
            ArrayList arrayList = new ArrayList(stackTrace.length);
            Collections.addAll(arrayList, stackTrace);
            return StringUtil.join(System.lineSeparator(), (List<String>) C0225l.m1579c(arrayList, new C2415b()));
        } catch (SecurityException unused) {
            C11839m.m70689w("AnrWatcher", "getStackTrace SecurityException just happened");
            return "";
        }
    }

    /* renamed from: j */
    public final void m8130j(String str) {
        synchronized (this) {
            try {
                Consumer<String> consumer = this.f6039d;
                if (consumer != null) {
                    consumer.accept(str);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: k */
    public final void m8131k(String str) {
        C11839m.m70688i("AnrWatcher", "occur anr question time: " + m8128g() + " statistic: " + this.f6038c.toString());
    }

    /* renamed from: l */
    public final void m8132l() {
        C11839m.m70689w("AnrWatcher", this.f6038c.toString());
    }

    /* renamed from: m */
    public final void m8133m(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception e10) {
            C11839m.m70687e("AnrWatcher", "exception in watcher thread: " + e10.getMessage());
        }
    }

    /* renamed from: n */
    public void m8134n(Consumer<String> consumer) {
        synchronized (this) {
            this.f6039d = consumer;
        }
    }

    /* renamed from: o */
    public void m8135o() {
        C11839m.m70688i("AnrWatcher", "start()");
        if (!this.f6036a.compareAndSet(false, true)) {
            C11839m.m70687e("AnrWatcher", "already started");
            return;
        }
        this.f6038c.m8119c();
        this.f6041f.m8142f(true);
        Future<?> futureSubmit = this.f6037b.submit(this.f6041f);
        this.f6040e = futureSubmit;
        if (futureSubmit != null) {
            C11839m.m70686d("AnrWatcher", "start success");
        }
    }

    /* renamed from: p */
    public void m8136p() {
        C11839m.m70688i("AnrWatcher", "stop()");
        if (!this.f6036a.compareAndSet(true, false)) {
            C11839m.m70687e("AnrWatcher", "already stop");
        }
        this.f6041f.m8142f(false);
        Future<?> future = this.f6040e;
        if (future != null) {
            future.cancel(true);
            C11839m.m70686d("AnrWatcher", "stop result:" + this.f6040e.isCancelled());
        }
    }

    /* renamed from: q */
    public final void m8137q(long j10) throws InterruptedException {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j11 = j10;
        while (true) {
            C0226l0.m1581a(j11);
            long jUptimeMillis2 = SystemClock.uptimeMillis() - jUptimeMillis;
            if (jUptimeMillis2 >= j10 - 10) {
                return;
            } else {
                j11 = j10 - jUptimeMillis2;
            }
        }
    }
}
