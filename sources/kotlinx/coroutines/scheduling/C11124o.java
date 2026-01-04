package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p464m.C11384b;

/* renamed from: kotlinx.coroutines.scheduling.o */
/* loaded from: classes9.dex */
public final class C11124o {

    /* renamed from: b */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f52390b = AtomicReferenceFieldUpdater.newUpdater(C11124o.class, Object.class, "lastScheduledTask");

    /* renamed from: c */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f52391c = AtomicIntegerFieldUpdater.newUpdater(C11124o.class, "producerIndex");

    /* renamed from: d */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f52392d = AtomicIntegerFieldUpdater.newUpdater(C11124o.class, "consumerIndex");

    /* renamed from: e */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f52393e = AtomicIntegerFieldUpdater.newUpdater(C11124o.class, "blockingTasksInBuffer");

    /* renamed from: a */
    public final AtomicReferenceArray<AbstractRunnableC11117h> f52394a = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    /* renamed from: b */
    public static /* synthetic */ AbstractRunnableC11117h m66882b(C11124o c11124o, AbstractRunnableC11117h abstractRunnableC11117h, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return c11124o.m66883a(abstractRunnableC11117h, z10);
    }

    /* renamed from: a */
    public final AbstractRunnableC11117h m66883a(AbstractRunnableC11117h abstractRunnableC11117h, boolean z10) {
        if (z10) {
            return m66884c(abstractRunnableC11117h);
        }
        AbstractRunnableC11117h abstractRunnableC11117h2 = (AbstractRunnableC11117h) f52390b.getAndSet(this, abstractRunnableC11117h);
        if (abstractRunnableC11117h2 == null) {
            return null;
        }
        return m66884c(abstractRunnableC11117h2);
    }

    /* renamed from: c */
    public final AbstractRunnableC11117h m66884c(AbstractRunnableC11117h abstractRunnableC11117h) {
        if (abstractRunnableC11117h.f52379b.mo66880b() == 1) {
            f52393e.incrementAndGet(this);
        }
        if (m66886e() == 127) {
            return abstractRunnableC11117h;
        }
        int i10 = this.producerIndex & 127;
        while (this.f52394a.get(i10) != null) {
            Thread.yield();
        }
        this.f52394a.lazySet(i10, abstractRunnableC11117h);
        f52391c.incrementAndGet(this);
        return null;
    }

    /* renamed from: d */
    public final void m66885d(AbstractRunnableC11117h abstractRunnableC11117h) {
        if (abstractRunnableC11117h == null || abstractRunnableC11117h.f52379b.mo66880b() != 1) {
            return;
        }
        f52393e.decrementAndGet(this);
    }

    /* renamed from: e */
    public final int m66886e() {
        return this.producerIndex - this.consumerIndex;
    }

    /* renamed from: f */
    public final int m66887f() {
        Object obj = this.lastScheduledTask;
        int iM66886e = m66886e();
        return obj != null ? iM66886e + 1 : iM66886e;
    }

    /* renamed from: g */
    public final void m66888g(C11113d c11113d) {
        AbstractRunnableC11117h abstractRunnableC11117h = (AbstractRunnableC11117h) f52390b.getAndSet(this, null);
        if (abstractRunnableC11117h != null) {
            c11113d.m66774a(abstractRunnableC11117h);
        }
        while (m66891j(c11113d)) {
        }
    }

    /* renamed from: h */
    public final AbstractRunnableC11117h m66889h() {
        AbstractRunnableC11117h abstractRunnableC11117h = (AbstractRunnableC11117h) f52390b.getAndSet(this, null);
        return abstractRunnableC11117h == null ? m66890i() : abstractRunnableC11117h;
    }

    /* renamed from: i */
    public final AbstractRunnableC11117h m66890i() {
        AbstractRunnableC11117h andSet;
        while (true) {
            int i10 = this.consumerIndex;
            if (i10 - this.producerIndex == 0) {
                return null;
            }
            int i11 = i10 & 127;
            if (f52392d.compareAndSet(this, i10, i10 + 1) && (andSet = this.f52394a.getAndSet(i11, null)) != null) {
                m66885d(andSet);
                return andSet;
            }
        }
    }

    /* renamed from: j */
    public final boolean m66891j(C11113d c11113d) {
        AbstractRunnableC11117h abstractRunnableC11117hM66890i = m66890i();
        if (abstractRunnableC11117hM66890i == null) {
            return false;
        }
        c11113d.m66774a(abstractRunnableC11117hM66890i);
        return true;
    }

    /* renamed from: k */
    public final long m66892k(C11124o c11124o) {
        int i10 = c11124o.producerIndex;
        AtomicReferenceArray<AbstractRunnableC11117h> atomicReferenceArray = c11124o.f52394a;
        for (int i11 = c11124o.consumerIndex; i11 != i10; i11++) {
            int i12 = i11 & 127;
            if (c11124o.blockingTasksInBuffer == 0) {
                break;
            }
            AbstractRunnableC11117h abstractRunnableC11117h = atomicReferenceArray.get(i12);
            if (abstractRunnableC11117h != null && abstractRunnableC11117h.f52379b.mo66880b() == 1 && C11123n.m66881a(atomicReferenceArray, i12, abstractRunnableC11117h, null)) {
                f52393e.decrementAndGet(c11124o);
                m66882b(this, abstractRunnableC11117h, false, 2, null);
                return -1L;
            }
        }
        return m66894m(c11124o, true);
    }

    /* renamed from: l */
    public final long m66893l(C11124o c11124o) {
        AbstractRunnableC11117h abstractRunnableC11117hM66890i = c11124o.m66890i();
        if (abstractRunnableC11117hM66890i == null) {
            return m66894m(c11124o, false);
        }
        m66882b(this, abstractRunnableC11117hM66890i, false, 2, null);
        return -1L;
    }

    /* renamed from: m */
    public final long m66894m(C11124o c11124o, boolean z10) {
        AbstractRunnableC11117h abstractRunnableC11117h;
        do {
            abstractRunnableC11117h = (AbstractRunnableC11117h) c11124o.lastScheduledTask;
            if (abstractRunnableC11117h == null) {
                return -2L;
            }
            if (z10 && abstractRunnableC11117h.f52379b.mo66880b() != 1) {
                return -2L;
            }
            long jMo66876a = C11121l.f52386e.mo66876a() - abstractRunnableC11117h.f52378a;
            long j10 = C11121l.f52382a;
            if (jMo66876a < j10) {
                return j10 - jMo66876a;
            }
        } while (!C11384b.m68273a(f52390b, c11124o, abstractRunnableC11117h, null));
        m66882b(this, abstractRunnableC11117h, false, 2, null);
        return -1L;
    }
}
