package sx;

/* renamed from: sx.b */
/* loaded from: classes9.dex */
public abstract class AbstractRunnableC12872b implements Runnable {

    /* renamed from: a */
    public final String f58634a;

    public AbstractRunnableC12872b(String str, Object... objArr) {
        this.f58634a = C12875e.m77260q(str, objArr);
    }

    /* renamed from: l */
    public abstract void mo71536l();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f58634a);
        try {
            mo71536l();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
