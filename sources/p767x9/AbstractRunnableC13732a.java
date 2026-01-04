package p767x9;

import java.util.concurrent.Future;

/* renamed from: x9.a */
/* loaded from: classes3.dex */
public abstract class AbstractRunnableC13732a implements Runnable {

    /* renamed from: c */
    public Future f61727c;

    /* renamed from: a */
    public boolean f61725a = false;

    /* renamed from: b */
    public boolean f61726b = false;

    /* renamed from: d */
    public final Object f61728d = new Object();

    /* renamed from: a */
    public abstract void mo82516a();

    /* renamed from: c */
    public void m82517c(boolean z10) {
        Future future = this.f61727c;
        if (future != null) {
            future.cancel(z10);
        }
        this.f61726b = true;
        synchronized (this.f61728d) {
            try {
                if (!this.f61725a) {
                    mo82518d();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: d */
    public abstract void mo82518d();

    /* renamed from: e */
    public void m82519e(Future future) {
        this.f61727c = future;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            synchronized (this.f61728d) {
                this.f61725a = true;
            }
            if (this.f61726b) {
                return;
            }
            mo82516a();
        } finally {
            mo82518d();
        }
    }
}
