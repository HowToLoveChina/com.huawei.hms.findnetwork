package bs;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: bs.i */
/* loaded from: classes8.dex */
public final class C1282i {

    /* renamed from: j */
    public static final Object f5734j = new Object();

    /* renamed from: k */
    public static C1282i f5735k = new C1282i();

    /* renamed from: a */
    public volatile String f5736a;

    /* renamed from: b */
    public int f5737b = -1;

    /* renamed from: c */
    public int f5738c = -1;

    /* renamed from: d */
    public int f5739d = -1;

    /* renamed from: e */
    public final BlockingQueue<C1274a> f5740e = new ArrayBlockingQueue(256);

    /* renamed from: f */
    public a f5741f = new a();

    /* renamed from: g */
    public boolean f5742g = false;

    /* renamed from: h */
    public boolean f5743h = false;

    /* renamed from: i */
    public C1279f f5744i;

    /* renamed from: bs.i$a */
    public class a extends Thread {
        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r7 = this;
                bs.i r0 = bs.C1282i.this
                java.lang.Object r1 = bs.C1282i.m7595a()
                monitor-enter(r1)
                bs.i r2 = bs.C1282i.this     // Catch: java.lang.Throwable -> L76
                bs.f r2 = bs.C1282i.m7600f(r2)     // Catch: java.lang.Throwable -> L76
                int r3 = bs.C1282i.m7596b(r0)     // Catch: java.lang.Throwable -> L76
                java.lang.String r4 = bs.C1282i.m7597c(r0)     // Catch: java.lang.Throwable -> L76
                int r5 = bs.C1282i.m7598d(r0)     // Catch: java.lang.Throwable -> L76
                int r6 = bs.C1282i.m7599e(r0)     // Catch: java.lang.Throwable -> L76
                r2.m7580o(r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L76
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L76
            L21:
                boolean r1 = bs.C1282i.m7601g(r0)
                if (r1 == 0) goto L3f
                bs.i r1 = bs.C1282i.this     // Catch: java.lang.Error -> L2d java.lang.Exception -> L35 java.lang.InterruptedException -> L3a
                bs.C1282i.m7603i(r1, r0)     // Catch: java.lang.Error -> L2d java.lang.Exception -> L35 java.lang.InterruptedException -> L3a
                goto L21
            L2d:
                java.lang.String r0 = "LogWriteManager"
                java.lang.String r1 = "PrintWoker Error"
            L31:
                android.util.Log.i(r0, r1)
                goto L3f
            L35:
                java.lang.String r0 = "LogWriteManager"
                java.lang.String r1 = "PrintWoker IllegalMonitorStateException"
                goto L31
            L3a:
                java.lang.String r0 = "LogWriteManager"
                java.lang.String r1 = "PrintWoker InterruptedException"
                goto L31
            L3f:
                java.lang.String r0 = "LogWriteManager"
                java.lang.String r1 = "PrintWoker end."
                android.util.Log.i(r0, r1)
                bs.i r0 = bs.C1282i.this
                bs.f r0 = bs.C1282i.m7600f(r0)
                if (r0 == 0) goto L6f
                bs.a r0 = new bs.a
                java.lang.String r2 = "I"
                java.lang.String r3 = "LogWriteManager"
                java.lang.String r4 = "PrintWoker end."
                java.lang.String r5 = "log"
                r6 = 0
                r1 = r0
                r1.<init>(r2, r3, r4, r5, r6)
                bs.i r1 = bs.C1282i.this
                bs.f r1 = bs.C1282i.m7600f(r1)
                r1.m7587z(r0)
                bs.i r0 = bs.C1282i.this
                bs.f r0 = bs.C1282i.m7600f(r0)
                r0.m7586y()
            L6f:
                bs.i r7 = bs.C1282i.this
                r0 = 0
                bs.C1282i.m7602h(r7, r0)
                return
            L76:
                r7 = move-exception
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L76
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: bs.C1282i.a.run():void");
        }
    }

    public C1282i() {
        Log.i("LogWriteManager", "LogWriteManager onCreate");
    }

    /* renamed from: k */
    public static C1282i m7604k() {
        return f5735k;
    }

    /* renamed from: j */
    public boolean m7605j(C1274a c1274a) {
        return this.f5740e.offer(c1274a);
    }

    /* renamed from: l */
    public void m7606l(C1283j c1283j) {
        synchronized (f5734j) {
            try {
                if (this.f5743h) {
                    Log.i("LogWriteManager", "already init");
                } else {
                    Log.i("LogWriteManager", "first init");
                    if (TextUtils.isEmpty(c1283j.m7612d())) {
                        Log.i("LogWriteManager", "logPath is empty");
                        return;
                    }
                    this.f5736a = c1283j.m7612d();
                    this.f5737b = c1283j.m7611c();
                    this.f5738c = c1283j.m7610b();
                    this.f5739d = c1283j.m7609a();
                    this.f5744i = new C1279f();
                    m7607m();
                    this.f5743h = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: m */
    public final void m7607m() {
        String str;
        try {
            if (this.f5742g) {
                return;
            }
            this.f5742g = true;
            this.f5741f.setName("LogWriteThread");
            this.f5741f.start();
        } catch (IllegalThreadStateException unused) {
            str = "worker IllegalThreadStateException";
            Log.i("LogWriteManager", str);
            this.f5742g = false;
            this.f5743h = false;
        } catch (Exception unused2) {
            str = "worker Exception";
            Log.i("LogWriteManager", str);
            this.f5742g = false;
            this.f5743h = false;
        }
    }

    /* renamed from: n */
    public final void m7608n(C1282i c1282i) throws InterruptedException {
        C1274a c1274aPoll = c1282i.f5740e.poll(60L, TimeUnit.SECONDS);
        C1279f c1279f = this.f5744i;
        if (c1279f != null) {
            if (c1274aPoll != null) {
                c1279f.m7587z(c1274aPoll);
                return;
            }
            c1279f.m7586y();
            this.f5744i.m7587z(c1282i.f5740e.take());
        }
    }
}
