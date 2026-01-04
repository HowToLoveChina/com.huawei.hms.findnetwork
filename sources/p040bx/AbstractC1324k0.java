package p040bx;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.C11095l;
import kotlinx.coroutines.internal.C11109z;
import kotlinx.coroutines.internal.InterfaceC11083a0;
import mw.InterfaceC11539f;
import p464m.C11384b;
import p692uw.C13267j;
import p790xw.C13885n;

/* renamed from: bx.k0 */
/* loaded from: classes9.dex */
public abstract class AbstractC1324k0 extends AbstractC1327l0 implements InterfaceC1297b0 {

    /* renamed from: e */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5814e = AtomicReferenceFieldUpdater.newUpdater(AbstractC1324k0.class, Object.class, "_queue");

    /* renamed from: f */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5815f = AtomicReferenceFieldUpdater.newUpdater(AbstractC1324k0.class, Object.class, "_delayed");
    private volatile /* synthetic */ Object _queue = null;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;

    /* renamed from: bx.k0$a */
    public static abstract class a implements Runnable, Comparable<a>, InterfaceC1315h0, InterfaceC11083a0 {

        /* renamed from: a */
        public long f5816a;

        /* renamed from: b */
        public Object f5817b;

        /* renamed from: c */
        public int f5818c;

        @Override // kotlinx.coroutines.internal.InterfaceC11083a0
        /* renamed from: a */
        public void mo7803a(C11109z<?> c11109z) {
            if (this.f5817b == C1333n0.f5831a) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.f5817b = c11109z;
        }

        @Override // kotlinx.coroutines.internal.InterfaceC11083a0
        /* renamed from: f */
        public C11109z<?> mo7804f() {
            Object obj = this.f5817b;
            if (obj instanceof C11109z) {
                return (C11109z) obj;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.InterfaceC11083a0
        /* renamed from: h */
        public void mo7805h(int i10) {
            this.f5818c = i10;
        }

        @Override // p040bx.InterfaceC1315h0
        /* renamed from: i */
        public final synchronized void mo7748i() {
            try {
                Object obj = this.f5817b;
                if (obj == C1333n0.f5831a) {
                    return;
                }
                b bVar = obj instanceof b ? (b) obj : null;
                if (bVar != null) {
                    bVar.m66829g(this);
                }
                this.f5817b = C1333n0.f5831a;
            } catch (Throwable th2) {
                throw th2;
            }
        }

        @Override // kotlinx.coroutines.internal.InterfaceC11083a0
        /* renamed from: k */
        public int mo7806k() {
            return this.f5818c;
        }

        @Override // java.lang.Comparable
        /* renamed from: p */
        public int compareTo(a aVar) {
            long j10 = this.f5816a - aVar.f5816a;
            if (j10 > 0) {
                return 1;
            }
            return j10 < 0 ? -1 : 0;
        }

        /* renamed from: q */
        public final synchronized int m7808q(long j10, b bVar, AbstractC1324k0 abstractC1324k0) {
            if (this.f5817b == C1333n0.f5831a) {
                return 2;
            }
            synchronized (bVar) {
                try {
                    a aVarM66824b = bVar.m66824b();
                    if (abstractC1324k0.m7794Z()) {
                        return 1;
                    }
                    if (aVarM66824b == null) {
                        bVar.f5819b = j10;
                    } else {
                        long j11 = aVarM66824b.f5816a;
                        if (j11 - j10 < 0) {
                            j10 = j11;
                        }
                        if (j10 - bVar.f5819b > 0) {
                            bVar.f5819b = j10;
                        }
                    }
                    long j12 = this.f5816a;
                    long j13 = bVar.f5819b;
                    if (j12 - j13 < 0) {
                        this.f5816a = j13;
                    }
                    bVar.m66823a(this);
                    return 0;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        /* renamed from: r */
        public final boolean m7809r(long j10) {
            return j10 - this.f5816a >= 0;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f5816a + ']';
        }
    }

    /* renamed from: bx.k0$b */
    public static final class b extends C11109z<a> {

        /* renamed from: b */
        public long f5819b;

        public b(long j10) {
            this.f5819b = j10;
        }
    }

    /* renamed from: J */
    public final void m7790J() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (C11384b.m68273a(f5814e, this, null, C1333n0.f5832b)) {
                    return;
                }
            } else if (obj instanceof C11095l) {
                ((C11095l) obj).m66781d();
                return;
            } else {
                if (obj == C1333n0.f5832b) {
                    return;
                }
                C11095l c11095l = new C11095l(8, true);
                c11095l.m66778a((Runnable) obj);
                if (C11384b.m68273a(f5814e, this, obj, c11095l)) {
                    return;
                }
            }
        }
    }

    /* renamed from: V */
    public final Runnable m7791V() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof C11095l) {
                C11095l c11095l = (C11095l) obj;
                Object objM66787j = c11095l.m66787j();
                if (objM66787j != C11095l.f52322h) {
                    return (Runnable) objM66787j;
                }
                C11384b.m68273a(f5814e, this, obj, c11095l.m66786i());
            } else {
                if (obj == C1333n0.f5832b) {
                    return null;
                }
                if (C11384b.m68273a(f5814e, this, obj, null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    /* renamed from: X */
    public void mo7792X(Runnable runnable) {
        if (m7793Y(runnable)) {
            m7813H();
        } else {
            RunnableC1356z.f5850g.mo7792X(runnable);
        }
    }

    /* renamed from: Y */
    public final boolean m7793Y(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (m7794Z()) {
                return false;
            }
            if (obj == null) {
                if (C11384b.m68273a(f5814e, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof C11095l) {
                C11095l c11095l = (C11095l) obj;
                int iM66778a = c11095l.m66778a(runnable);
                if (iM66778a == 0) {
                    return true;
                }
                if (iM66778a == 1) {
                    C11384b.m68273a(f5814e, this, obj, c11095l.m66786i());
                } else if (iM66778a == 2) {
                    return false;
                }
            } else {
                if (obj == C1333n0.f5832b) {
                    return false;
                }
                C11095l c11095l2 = new C11095l(8, true);
                c11095l2.m66778a((Runnable) obj);
                c11095l2.m66778a(runnable);
                if (C11384b.m68273a(f5814e, this, obj, c11095l2)) {
                    return true;
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    /* renamed from: Z */
    public final boolean m7794Z() {
        return this._isCompleted;
    }

    /* renamed from: a0 */
    public boolean m7795a0() {
        if (!m7781D()) {
            return false;
        }
        b bVar = (b) this._delayed;
        if (bVar != null && !bVar.m66826d()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof C11095l) {
                return ((C11095l) obj).m66784g();
            }
            if (obj != C1333n0.f5832b) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b0 */
    public long m7796b0() {
        a aVarM66830h;
        if (m7782E()) {
            return 0L;
        }
        b bVar = (b) this._delayed;
        if (bVar != null && !bVar.m66826d()) {
            C1299c.m7736a();
            long jNanoTime = System.nanoTime();
            do {
                synchronized (bVar) {
                    a aVarM66824b = bVar.m66824b();
                    aVarM66830h = null;
                    if (aVarM66824b != null) {
                        a aVar = aVarM66824b;
                        if (aVar.m7809r(jNanoTime) && m7793Y(aVar)) {
                            aVarM66830h = bVar.m66830h(0);
                        }
                    }
                }
            } while (aVarM66830h != null);
        }
        Runnable runnableM7791V = m7791V();
        if (runnableM7791V == null) {
            return mo7786z();
        }
        runnableM7791V.run();
        return 0L;
    }

    @Override // p040bx.AbstractC1344t
    /* renamed from: c */
    public final void mo7787c(InterfaceC11539f interfaceC11539f, Runnable runnable) {
        mo7792X(runnable);
    }

    /* renamed from: c0 */
    public final void m7797c0() {
        C1299c.m7736a();
        long jNanoTime = System.nanoTime();
        while (true) {
            b bVar = (b) this._delayed;
            a aVarM66831i = bVar == null ? null : bVar.m66831i();
            if (aVarM66831i == null) {
                return;
            } else {
                mo7812G(jNanoTime, aVarM66831i);
            }
        }
    }

    /* renamed from: g0 */
    public final void m7798g0() {
        this._queue = null;
        this._delayed = null;
    }

    /* renamed from: i0 */
    public final void m7799i0(long j10, a aVar) {
        int iM7800j0 = m7800j0(j10, aVar);
        if (iM7800j0 == 0) {
            if (m7802n0(aVar)) {
                m7813H();
            }
        } else if (iM7800j0 == 1) {
            mo7812G(j10, aVar);
        } else if (iM7800j0 != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    /* renamed from: j0 */
    public final int m7800j0(long j10, a aVar) {
        if (m7794Z()) {
            return 1;
        }
        b bVar = (b) this._delayed;
        if (bVar == null) {
            C11384b.m68273a(f5815f, this, null, new b(j10));
            Object obj = this._delayed;
            C13267j.m79674b(obj);
            bVar = (b) obj;
        }
        return aVar.m7808q(j10, bVar, this);
    }

    /* renamed from: m0 */
    public final void m7801m0(boolean z10) {
        this._isCompleted = z10 ? 1 : 0;
    }

    /* renamed from: n0 */
    public final boolean m7802n0(a aVar) {
        b bVar = (b) this._delayed;
        return (bVar == null ? null : bVar.m66827e()) == aVar;
    }

    @Override // p040bx.AbstractC1321j0
    public void shutdown() {
        C1319i1.f5807a.m7776b();
        m7801m0(true);
        m7790J();
        while (m7796b0() <= 0) {
        }
        m7797c0();
    }

    @Override // p040bx.AbstractC1321j0
    /* renamed from: z */
    public long mo7786z() {
        if (super.mo7786z() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof C11095l)) {
                return obj == C1333n0.f5832b ? Long.MAX_VALUE : 0L;
            }
            if (!((C11095l) obj).m66784g()) {
                return 0L;
            }
        }
        b bVar = (b) this._delayed;
        a aVarM66827e = bVar == null ? null : bVar.m66827e();
        if (aVarM66827e == null) {
            return Long.MAX_VALUE;
        }
        long j10 = aVarM66827e.f5816a;
        C1299c.m7736a();
        return C13885n.m83237b(j10 - System.nanoTime(), 0L);
    }
}
