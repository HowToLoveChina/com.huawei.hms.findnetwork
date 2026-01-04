package p767x9;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/* renamed from: x9.c */
/* loaded from: classes3.dex */
public abstract class AbstractC13734c extends AbstractRunnableC13732a {

    /* renamed from: e */
    public Semaphore f61736e;

    /* renamed from: f */
    public CountDownLatch f61737f;

    public AbstractC13734c(CountDownLatch countDownLatch) {
        this.f61737f = countDownLatch;
    }

    @Override // p767x9.AbstractRunnableC13732a
    /* renamed from: a */
    public void mo82516a() {
        try {
            mo61468f(this.f61736e == null ? this.f61737f : new CountDownLatch(1));
            if (this.f61736e != null) {
                this.f61737f.countDown();
            }
        } catch (Throwable th2) {
            if (this.f61736e != null) {
                this.f61737f.countDown();
            }
            throw th2;
        }
    }

    @Override // p767x9.AbstractRunnableC13732a
    /* renamed from: d */
    public void mo82518d() {
        Semaphore semaphore = this.f61736e;
        if (semaphore != null) {
            semaphore.release();
        }
        C13733b.m82520a().m82521b(this);
    }

    /* renamed from: f */
    public abstract void mo61468f(CountDownLatch countDownLatch);

    /* renamed from: g */
    public void m82524g(Semaphore semaphore) {
        this.f61736e = semaphore;
    }
}
