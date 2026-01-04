package kotlinx.coroutines.scheduling;

import p040bx.C1354y;

/* renamed from: kotlinx.coroutines.scheduling.k */
/* loaded from: classes9.dex */
public final class C11120k extends AbstractRunnableC11117h {

    /* renamed from: c */
    public final Runnable f52381c;

    public C11120k(Runnable runnable, long j10, InterfaceC11118i interfaceC11118i) {
        super(j10, interfaceC11118i);
        this.f52381c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f52381c.run();
        } finally {
            this.f52379b.mo66879a();
        }
    }

    public String toString() {
        return "Task[" + C1354y.m7844a(this.f52381c) + '@' + C1354y.m7845b(this.f52381c) + ", " + this.f52378a + ", " + this.f52379b + ']';
    }
}
