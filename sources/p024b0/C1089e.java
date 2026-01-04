package p024b0;

import android.os.CancellationSignal;

/* renamed from: b0.e */
/* loaded from: classes.dex */
public final class C1089e {

    /* renamed from: a */
    public boolean f5205a;

    /* renamed from: b */
    public b f5206b;

    /* renamed from: c */
    public Object f5207c;

    /* renamed from: d */
    public boolean f5208d;

    /* renamed from: b0.e$a */
    public static class a {
        /* renamed from: a */
        public static void m6472a(Object obj) {
            ((CancellationSignal) obj).cancel();
        }

        /* renamed from: b */
        public static CancellationSignal m6473b() {
            return new CancellationSignal();
        }
    }

    /* renamed from: b0.e$b */
    public interface b {
        void onCancel();
    }

    /* renamed from: a */
    public void m6468a() {
        synchronized (this) {
            try {
                if (this.f5205a) {
                    return;
                }
                this.f5205a = true;
                this.f5208d = true;
                b bVar = this.f5206b;
                Object obj = this.f5207c;
                if (bVar != null) {
                    try {
                        bVar.onCancel();
                    } catch (Throwable th2) {
                        synchronized (this) {
                            this.f5208d = false;
                            notifyAll();
                            throw th2;
                        }
                    }
                }
                if (obj != null) {
                    a.m6472a(obj);
                }
                synchronized (this) {
                    this.f5208d = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }

    /* renamed from: b */
    public Object m6469b() {
        Object obj;
        synchronized (this) {
            try {
                if (this.f5207c == null) {
                    CancellationSignal cancellationSignalM6473b = a.m6473b();
                    this.f5207c = cancellationSignalM6473b;
                    if (this.f5205a) {
                        a.m6472a(cancellationSignalM6473b);
                    }
                }
                obj = this.f5207c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return obj;
    }

    /* renamed from: c */
    public void m6470c(b bVar) {
        synchronized (this) {
            try {
                m6471d();
                if (this.f5206b == bVar) {
                    return;
                }
                this.f5206b = bVar;
                if (this.f5205a && bVar != null) {
                    bVar.onCancel();
                }
            } finally {
            }
        }
    }

    /* renamed from: d */
    public final void m6471d() throws InterruptedException {
        while (this.f5208d) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }
}
