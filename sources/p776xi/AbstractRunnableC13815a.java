package p776xi;

import com.huawei.cloud.base.util.C4650r;
import java.util.concurrent.Future;

/* renamed from: xi.a */
/* loaded from: classes.dex */
public abstract class AbstractRunnableC13815a implements Runnable {

    /* renamed from: c */
    public static final C4650r f62013c = C4650r.m28485f("Task");

    /* renamed from: a */
    public Future<?> f62014a;

    /* renamed from: b */
    public boolean f62015b;

    /* renamed from: a */
    public abstract void mo72848a();

    /* renamed from: c */
    public boolean mo72849c() {
        Future<?> future = this.f62014a;
        if (future == null) {
            return false;
        }
        this.f62015b = true;
        return future.cancel(true);
    }

    /* renamed from: d */
    public boolean m82854d() {
        return this.f62015b;
    }

    /* renamed from: e */
    public void m82855e(Future<?> future) {
        this.f62014a = future;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            mo72848a();
        } catch (Exception e10) {
            f62013c.m28492j("task error: " + e10.toString());
        }
    }
}
