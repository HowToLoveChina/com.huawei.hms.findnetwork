package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import p024b0.C1093i;
import p243e0.C9376k;
import p643t0.AbstractC12912a;

/* loaded from: classes.dex */
public abstract class AsyncTaskLoader<D> extends Loader<D> {

    /* renamed from: i */
    public final Executor f4222i;

    /* renamed from: j */
    public volatile AsyncTaskLoader<D>.RunnableC0811a f4223j;

    /* renamed from: k */
    public volatile AsyncTaskLoader<D>.RunnableC0811a f4224k;

    /* renamed from: l */
    public long f4225l;

    /* renamed from: m */
    public long f4226m;

    /* renamed from: n */
    public Handler f4227n;

    /* renamed from: androidx.loader.content.AsyncTaskLoader$a */
    public final class RunnableC0811a extends AbstractC12912a<Void, Void, D> implements Runnable {

        /* renamed from: k */
        public final CountDownLatch f4228k = new CountDownLatch(1);

        /* renamed from: l */
        public boolean f4229l;

        public RunnableC0811a() {
        }

        @Override // p643t0.AbstractC12912a
        /* renamed from: i */
        public void mo5021i(D d10) {
            try {
                AsyncTaskLoader.this.m5009A(this, d10);
            } finally {
                this.f4228k.countDown();
            }
        }

        @Override // p643t0.AbstractC12912a
        /* renamed from: j */
        public void mo5022j(D d10) {
            try {
                AsyncTaskLoader.this.m5010B(this, d10);
            } finally {
                this.f4228k.countDown();
            }
        }

        @Override // p643t0.AbstractC12912a
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public D mo5020c(Void... voidArr) {
            try {
                return (D) AsyncTaskLoader.this.m5015G();
            } catch (C1093i e10) {
                if (this.m77540g()) {
                    return null;
                }
                throw e10;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4229l = false;
            AsyncTaskLoader.this.m5011C();
        }
    }

    public AsyncTaskLoader(Context context) {
        this(context, AbstractC12912a.f58883h);
    }

    /* renamed from: A */
    public void m5009A(AsyncTaskLoader<D>.RunnableC0811a runnableC0811a, D d10) {
        mo5014F(d10);
        if (this.f4224k == runnableC0811a) {
            m5044u();
            this.f4226m = SystemClock.uptimeMillis();
            this.f4224k = null;
            m5035e();
            m5011C();
        }
    }

    /* renamed from: B */
    public void m5010B(AsyncTaskLoader<D>.RunnableC0811a runnableC0811a, D d10) {
        if (this.f4223j != runnableC0811a) {
            m5009A(runnableC0811a, d10);
            return;
        }
        if (m5038j()) {
            mo5014F(d10);
            return;
        }
        m5033c();
        this.f4226m = SystemClock.uptimeMillis();
        this.f4223j = null;
        mo5027f(d10);
    }

    /* renamed from: C */
    public void m5011C() {
        if (this.f4224k != null || this.f4223j == null) {
            return;
        }
        if (this.f4223j.f4229l) {
            this.f4223j.f4229l = false;
            this.f4227n.removeCallbacks(this.f4223j);
        }
        if (this.f4225l <= 0 || SystemClock.uptimeMillis() >= this.f4226m + this.f4225l) {
            this.f4223j.m77538d(this.f4222i, null);
        } else {
            this.f4223j.f4229l = true;
            this.f4227n.postAtTime(this.f4223j, this.f4226m + this.f4225l);
        }
    }

    /* renamed from: D */
    public boolean m5012D() {
        return this.f4224k != null;
    }

    /* renamed from: E */
    public abstract D mo5013E();

    /* renamed from: F */
    public void mo5014F(D d10) {
    }

    /* renamed from: G */
    public D m5015G() {
        return mo5013E();
    }

    @Override // androidx.loader.content.Loader
    @Deprecated
    /* renamed from: g */
    public void mo5016g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.mo5016g(str, fileDescriptor, printWriter, strArr);
        if (this.f4223j != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f4223j);
            printWriter.print(" waiting=");
            printWriter.println(this.f4223j.f4229l);
        }
        if (this.f4224k != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f4224k);
            printWriter.print(" waiting=");
            printWriter.println(this.f4224k.f4229l);
        }
        if (this.f4225l != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            C9376k.m58754c(this.f4225l, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            C9376k.m58753b(this.f4226m, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    @Override // androidx.loader.content.Loader
    /* renamed from: n */
    public boolean mo5017n() {
        if (this.f4223j == null) {
            return false;
        }
        if (!this.f4242d) {
            this.f4245g = true;
        }
        if (this.f4224k != null) {
            if (this.f4223j.f4229l) {
                this.f4223j.f4229l = false;
                this.f4227n.removeCallbacks(this.f4223j);
            }
            this.f4223j = null;
            return false;
        }
        if (this.f4223j.f4229l) {
            this.f4223j.f4229l = false;
            this.f4227n.removeCallbacks(this.f4223j);
            this.f4223j = null;
            return false;
        }
        boolean zM77537a = this.f4223j.m77537a(false);
        if (zM77537a) {
            this.f4224k = this.f4223j;
            mo5019z();
        }
        this.f4223j = null;
        return zM77537a;
    }

    @Override // androidx.loader.content.Loader
    /* renamed from: p */
    public void mo5018p() {
        super.mo5018p();
        m5032b();
        this.f4223j = new RunnableC0811a();
        m5011C();
    }

    /* renamed from: z */
    public void mo5019z() {
    }

    public AsyncTaskLoader(Context context, Executor executor) {
        super(context);
        this.f4226m = -10000L;
        this.f4222i = executor;
    }
}
