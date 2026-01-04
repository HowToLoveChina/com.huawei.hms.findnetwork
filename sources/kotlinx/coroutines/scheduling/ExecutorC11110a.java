package kotlinx.coroutines.scheduling;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.internal.C11102s;
import kotlinx.coroutines.internal.C11104u;
import p040bx.C1299c;
import p040bx.C1354y;
import p408jw.C10951q;
import p692uw.C13264g;
import p692uw.C13267j;
import p720vw.AbstractC13499c;
import p790xw.C13885n;

/* renamed from: kotlinx.coroutines.scheduling.a */
/* loaded from: classes9.dex */
public final class ExecutorC11110a implements Executor, Closeable {
    private volatile /* synthetic */ int _isTerminated;

    /* renamed from: a */
    public final int f52347a;

    /* renamed from: b */
    public final int f52348b;

    /* renamed from: c */
    public final long f52349c;
    volatile /* synthetic */ long controlState;

    /* renamed from: d */
    public final String f52350d;

    /* renamed from: e */
    public final C11113d f52351e;

    /* renamed from: f */
    public final C11113d f52352f;

    /* renamed from: g */
    public final C11102s<c> f52353g;
    private volatile /* synthetic */ long parkedWorkersStack;

    /* renamed from: h */
    public static final a f52342h = new a(null);

    /* renamed from: l */
    public static final C11104u f52346l = new C11104u("NOT_IN_STACK");

    /* renamed from: i */
    public static final /* synthetic */ AtomicLongFieldUpdater f52343i = AtomicLongFieldUpdater.newUpdater(ExecutorC11110a.class, "parkedWorkersStack");

    /* renamed from: j */
    public static final /* synthetic */ AtomicLongFieldUpdater f52344j = AtomicLongFieldUpdater.newUpdater(ExecutorC11110a.class, "controlState");

    /* renamed from: k */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f52345k = AtomicIntegerFieldUpdater.newUpdater(ExecutorC11110a.class, "_isTerminated");

    /* renamed from: kotlinx.coroutines.scheduling.a$a */
    public static final class a {
        public /* synthetic */ a(C13264g c13264g) {
            this();
        }

        public a() {
        }
    }

    /* renamed from: kotlinx.coroutines.scheduling.a$b */
    public /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f52354a;

        static {
            int[] iArr = new int[d.values().length];
            iArr[d.PARKING.ordinal()] = 1;
            iArr[d.BLOCKING.ordinal()] = 2;
            iArr[d.CPU_ACQUIRED.ordinal()] = 3;
            iArr[d.DORMANT.ordinal()] = 4;
            iArr[d.TERMINATED.ordinal()] = 5;
            f52354a = iArr;
        }
    }

    /* renamed from: kotlinx.coroutines.scheduling.a$d */
    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public ExecutorC11110a(int i10, int i11, long j10, String str) {
        this.f52347a = i10;
        this.f52348b = i11;
        this.f52349c = j10;
        this.f52350d = str;
        if (i10 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i10 + " should be at least 1").toString());
        }
        if (i11 < i10) {
            throw new IllegalArgumentException(("Max pool size " + i11 + " should be greater than or equals to core pool size " + i10).toString());
        }
        if (i11 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i11 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j10 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j10 + " must be positive").toString());
        }
        this.f52351e = new C11113d();
        this.f52352f = new C11113d();
        this.parkedWorkersStack = 0L;
        this.f52353g = new C11102s<>(i10 + 1);
        this.controlState = i10 << 42;
        this._isTerminated = 0;
    }

    /* renamed from: H */
    public static /* synthetic */ boolean m66836H(ExecutorC11110a executorC11110a, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = executorC11110a.controlState;
        }
        return executorC11110a.m66844G(j10);
    }

    /* renamed from: w */
    public static /* synthetic */ void m66837w(ExecutorC11110a executorC11110a, Runnable runnable, InterfaceC11118i interfaceC11118i, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            interfaceC11118i = C11121l.f52387f;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        executorC11110a.m66850v(runnable, interfaceC11118i, z10);
    }

    /* renamed from: A */
    public final void m66838A(c cVar, int i10, int i11) {
        while (true) {
            long j10 = this.parkedWorkersStack;
            int iM66851x = (int) (2097151 & j10);
            long j11 = (2097152 + j10) & (-2097152);
            if (iM66851x == i10) {
                iM66851x = i11 == 0 ? m66851x(cVar) : i11;
            }
            if (iM66851x >= 0 && f52343i.compareAndSet(this, j10, j11 | iM66851x)) {
                return;
            }
        }
    }

    /* renamed from: B */
    public final void m66839B(AbstractRunnableC11117h abstractRunnableC11117h) {
        try {
            abstractRunnableC11117h.run();
        } finally {
            try {
            } finally {
            }
        }
    }

    /* renamed from: C */
    public final void m66840C(long j10) throws InterruptedException {
        int i10;
        if (f52345k.compareAndSet(this, 0, 1)) {
            c cVarM66849u = m66849u();
            synchronized (this.f52353g) {
                i10 = (int) (this.controlState & 2097151);
            }
            if (1 <= i10) {
                int i11 = 1;
                while (true) {
                    int i12 = i11 + 1;
                    c cVarM66801b = this.f52353g.m66801b(i11);
                    C13267j.m79674b(cVarM66801b);
                    c cVar = cVarM66801b;
                    if (cVar != cVarM66849u) {
                        while (cVar.isAlive()) {
                            LockSupport.unpark(cVar);
                            cVar.join(j10);
                        }
                        cVar.f52356a.m66888g(this.f52352f);
                    }
                    if (i11 == i10) {
                        break;
                    } else {
                        i11 = i12;
                    }
                }
            }
            this.f52352f.m66775b();
            this.f52351e.m66775b();
            while (true) {
                AbstractRunnableC11117h abstractRunnableC11117hM66859g = cVarM66849u == null ? null : cVarM66849u.m66859g(true);
                if (abstractRunnableC11117hM66859g == null && (abstractRunnableC11117hM66859g = this.f52351e.m66777d()) == null && (abstractRunnableC11117hM66859g = this.f52352f.m66777d()) == null) {
                    break;
                } else {
                    m66839B(abstractRunnableC11117hM66859g);
                }
            }
            if (cVarM66849u != null) {
                cVarM66849u.m66872t(d.TERMINATED);
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    /* renamed from: D */
    public final void m66841D(boolean z10) {
        long jAddAndGet = f52344j.addAndGet(this, 2097152L);
        if (z10 || m66845I() || m66844G(jAddAndGet)) {
            return;
        }
        m66845I();
    }

    /* renamed from: E */
    public final void m66842E() {
        if (m66845I() || m66836H(this, 0L, 1, null)) {
            return;
        }
        m66845I();
    }

    /* renamed from: F */
    public final AbstractRunnableC11117h m66843F(c cVar, AbstractRunnableC11117h abstractRunnableC11117h, boolean z10) {
        if (cVar == null || cVar.f52357b == d.TERMINATED) {
            return abstractRunnableC11117h;
        }
        if (abstractRunnableC11117h.f52379b.mo66880b() == 0 && cVar.f52357b == d.BLOCKING) {
            return abstractRunnableC11117h;
        }
        cVar.f52361f = true;
        return cVar.f52356a.m66883a(abstractRunnableC11117h, z10);
    }

    /* renamed from: G */
    public final boolean m66844G(long j10) {
        if (C13885n.m83236a(((int) (2097151 & j10)) - ((int) ((j10 & 4398044413952L) >> 21)), 0) < this.f52347a) {
            int iM66847s = m66847s();
            if (iM66847s == 1 && this.f52347a > 1) {
                m66847s();
            }
            if (iM66847s > 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: I */
    public final boolean m66845I() {
        c cVarM66852y;
        do {
            cVarM66852y = m66852y();
            if (cVarM66852y == null) {
                return false;
            }
        } while (!c.f52355h.compareAndSet(cVarM66852y, -1, 0));
        LockSupport.unpark(cVarM66852y);
        return true;
    }

    /* renamed from: b */
    public final boolean m66846b(AbstractRunnableC11117h abstractRunnableC11117h) {
        return abstractRunnableC11117h.f52379b.mo66880b() == 1 ? this.f52352f.m66774a(abstractRunnableC11117h) : this.f52351e.m66774a(abstractRunnableC11117h);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        m66840C(10000L);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        m66837w(this, runnable, null, false, 6, null);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    /* renamed from: s */
    public final int m66847s() {
        synchronized (this.f52353g) {
            if (isTerminated()) {
                return -1;
            }
            long j10 = this.controlState;
            int i10 = (int) (j10 & 2097151);
            int iM83236a = C13885n.m83236a(i10 - ((int) ((j10 & 4398044413952L) >> 21)), 0);
            if (iM83236a >= this.f52347a) {
                return 0;
            }
            if (i10 >= this.f52348b) {
                return 0;
            }
            int i11 = ((int) (this.controlState & 2097151)) + 1;
            if (i11 <= 0 || this.f52353g.m66801b(i11) != null) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            c cVar = new c(i11);
            this.f52353g.m66802c(i11, cVar);
            if (i11 != ((int) (2097151 & f52344j.incrementAndGet(this)))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            cVar.start();
            return iM83236a + 1;
        }
    }

    /* renamed from: t */
    public final AbstractRunnableC11117h m66848t(Runnable runnable, InterfaceC11118i interfaceC11118i) {
        long jMo66876a = C11121l.f52386e.mo66876a();
        if (!(runnable instanceof AbstractRunnableC11117h)) {
            return new C11120k(runnable, jMo66876a, interfaceC11118i);
        }
        AbstractRunnableC11117h abstractRunnableC11117h = (AbstractRunnableC11117h) runnable;
        abstractRunnableC11117h.f52378a = jMo66876a;
        abstractRunnableC11117h.f52379b = interfaceC11118i;
        return abstractRunnableC11117h;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int iM66800a = this.f52353g.m66800a();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 1;
        while (i15 < iM66800a) {
            int i16 = i15 + 1;
            c cVarM66801b = this.f52353g.m66801b(i15);
            if (cVarM66801b != null) {
                int iM66887f = cVarM66801b.f52356a.m66887f();
                int i17 = b.f52354a[cVarM66801b.f52357b.ordinal()];
                if (i17 == 1) {
                    i12++;
                } else if (i17 == 2) {
                    i11++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(iM66887f);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (i17 == 3) {
                    i10++;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(iM66887f);
                    sb3.append('c');
                    arrayList.add(sb3.toString());
                } else if (i17 == 4) {
                    i13++;
                    if (iM66887f > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(iM66887f);
                        sb4.append('d');
                        arrayList.add(sb4.toString());
                    }
                } else if (i17 == 5) {
                    i14++;
                }
            }
            i15 = i16;
        }
        long j10 = this.controlState;
        return this.f52350d + '@' + C1354y.m7845b(this) + "[Pool Size {core = " + this.f52347a + ", max = " + this.f52348b + "}, Worker States {CPU = " + i10 + ", blocking = " + i11 + ", parked = " + i12 + ", dormant = " + i13 + ", terminated = " + i14 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f52351e.m66776c() + ", global blocking queue size = " + this.f52352f.m66776c() + ", Control State {created workers= " + ((int) (2097151 & j10)) + ", blocking tasks = " + ((int) ((4398044413952L & j10) >> 21)) + ", CPUs acquired = " + (this.f52347a - ((int) ((9223367638808264704L & j10) >> 42))) + "}]";
    }

    /* renamed from: u */
    public final c m66849u() {
        Thread threadCurrentThread = Thread.currentThread();
        c cVar = threadCurrentThread instanceof c ? (c) threadCurrentThread : null;
        if (cVar != null && C13267j.m79673a(ExecutorC11110a.this, this)) {
            return cVar;
        }
        return null;
    }

    /* renamed from: v */
    public final void m66850v(Runnable runnable, InterfaceC11118i interfaceC11118i, boolean z10) {
        C1299c.m7736a();
        AbstractRunnableC11117h abstractRunnableC11117hM66848t = m66848t(runnable, interfaceC11118i);
        c cVarM66849u = m66849u();
        AbstractRunnableC11117h abstractRunnableC11117hM66843F = m66843F(cVarM66849u, abstractRunnableC11117hM66848t, z10);
        if (abstractRunnableC11117hM66843F != null && !m66846b(abstractRunnableC11117hM66843F)) {
            throw new RejectedExecutionException(C13267j.m79683k(this.f52350d, " was terminated"));
        }
        boolean z11 = z10 && cVarM66849u != null;
        if (abstractRunnableC11117hM66848t.f52379b.mo66880b() != 0) {
            m66841D(z11);
        } else {
            if (z11) {
                return;
            }
            m66842E();
        }
    }

    /* renamed from: x */
    public final int m66851x(c cVar) {
        Object objM66861i = cVar.m66861i();
        while (objM66861i != f52346l) {
            if (objM66861i == null) {
                return 0;
            }
            c cVar2 = (c) objM66861i;
            int iM66860h = cVar2.m66860h();
            if (iM66860h != 0) {
                return iM66860h;
            }
            objM66861i = cVar2.m66861i();
        }
        return -1;
    }

    /* renamed from: y */
    public final c m66852y() {
        while (true) {
            long j10 = this.parkedWorkersStack;
            c cVarM66801b = this.f52353g.m66801b((int) (2097151 & j10));
            if (cVarM66801b == null) {
                return null;
            }
            long j11 = (2097152 + j10) & (-2097152);
            int iM66851x = m66851x(cVarM66801b);
            if (iM66851x >= 0 && f52343i.compareAndSet(this, j10, iM66851x | j11)) {
                cVarM66801b.m66869q(f52346l);
                return cVarM66801b;
            }
        }
    }

    /* renamed from: z */
    public final boolean m66853z(c cVar) {
        long j10;
        int iM66860h;
        if (cVar.m66861i() != f52346l) {
            return false;
        }
        do {
            j10 = this.parkedWorkersStack;
            iM66860h = cVar.m66860h();
            cVar.m66869q(this.f52353g.m66801b((int) (2097151 & j10)));
        } while (!f52343i.compareAndSet(this, j10, ((2097152 + j10) & (-2097152)) | iM66860h));
        return true;
    }

    /* renamed from: kotlinx.coroutines.scheduling.a$c */
    public final class c extends Thread {

        /* renamed from: h */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f52355h = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* renamed from: a */
        public final C11124o f52356a;

        /* renamed from: b */
        public d f52357b;

        /* renamed from: c */
        public long f52358c;

        /* renamed from: d */
        public long f52359d;

        /* renamed from: e */
        public int f52360e;

        /* renamed from: f */
        public boolean f52361f;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        volatile /* synthetic */ int workerCtl;

        public c() {
            setDaemon(true);
            this.f52356a = new C11124o();
            this.f52357b = d.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = ExecutorC11110a.f52346l;
            this.f52360e = AbstractC13499c.f60737a.mo81189c();
        }

        /* renamed from: c */
        public final void m66855c(int i10) {
            if (i10 == 0) {
                return;
            }
            ExecutorC11110a.f52344j.addAndGet(ExecutorC11110a.this, -2097152L);
            if (this.f52357b != d.TERMINATED) {
                this.f52357b = d.DORMANT;
            }
        }

        /* renamed from: d */
        public final void m66856d(int i10) {
            if (i10 != 0 && m66872t(d.BLOCKING)) {
                ExecutorC11110a.this.m66842E();
            }
        }

        /* renamed from: e */
        public final void m66857e(AbstractRunnableC11117h abstractRunnableC11117h) {
            int iMo66880b = abstractRunnableC11117h.f52379b.mo66880b();
            m66862j(iMo66880b);
            m66856d(iMo66880b);
            ExecutorC11110a.this.m66839B(abstractRunnableC11117h);
            m66855c(iMo66880b);
        }

        /* renamed from: f */
        public final AbstractRunnableC11117h m66858f(boolean z10) {
            AbstractRunnableC11117h abstractRunnableC11117hM66866n;
            AbstractRunnableC11117h abstractRunnableC11117hM66866n2;
            if (z10) {
                boolean z11 = m66864l(ExecutorC11110a.this.f52347a * 2) == 0;
                if (z11 && (abstractRunnableC11117hM66866n2 = m66866n()) != null) {
                    return abstractRunnableC11117hM66866n2;
                }
                AbstractRunnableC11117h abstractRunnableC11117hM66889h = this.f52356a.m66889h();
                if (abstractRunnableC11117hM66889h != null) {
                    return abstractRunnableC11117hM66889h;
                }
                if (!z11 && (abstractRunnableC11117hM66866n = m66866n()) != null) {
                    return abstractRunnableC11117hM66866n;
                }
            } else {
                AbstractRunnableC11117h abstractRunnableC11117hM66866n3 = m66866n();
                if (abstractRunnableC11117hM66866n3 != null) {
                    return abstractRunnableC11117hM66866n3;
                }
            }
            return m66873u(false);
        }

        /* renamed from: g */
        public final AbstractRunnableC11117h m66859g(boolean z10) {
            AbstractRunnableC11117h abstractRunnableC11117hM66777d;
            if (m66870r()) {
                return m66858f(z10);
            }
            if (!z10 || (abstractRunnableC11117hM66777d = this.f52356a.m66889h()) == null) {
                abstractRunnableC11117hM66777d = ExecutorC11110a.this.f52352f.m66777d();
            }
            return abstractRunnableC11117hM66777d == null ? m66873u(true) : abstractRunnableC11117hM66777d;
        }

        /* renamed from: h */
        public final int m66860h() {
            return this.indexInArray;
        }

        /* renamed from: i */
        public final Object m66861i() {
            return this.nextParkedWorker;
        }

        /* renamed from: j */
        public final void m66862j(int i10) {
            this.f52358c = 0L;
            if (this.f52357b == d.PARKING) {
                this.f52357b = d.BLOCKING;
            }
        }

        /* renamed from: k */
        public final boolean m66863k() {
            return this.nextParkedWorker != ExecutorC11110a.f52346l;
        }

        /* renamed from: l */
        public final int m66864l(int i10) {
            int i11 = this.f52360e;
            int i12 = i11 ^ (i11 << 13);
            int i13 = i12 ^ (i12 >> 17);
            int i14 = i13 ^ (i13 << 5);
            this.f52360e = i14;
            int i15 = i10 - 1;
            return (i15 & i10) == 0 ? i15 & i14 : (Integer.MAX_VALUE & i14) % i10;
        }

        /* renamed from: m */
        public final void m66865m() {
            if (this.f52358c == 0) {
                this.f52358c = System.nanoTime() + ExecutorC11110a.this.f52349c;
            }
            LockSupport.parkNanos(ExecutorC11110a.this.f52349c);
            if (System.nanoTime() - this.f52358c >= 0) {
                this.f52358c = 0L;
                m66874v();
            }
        }

        /* renamed from: n */
        public final AbstractRunnableC11117h m66866n() {
            if (m66864l(2) == 0) {
                AbstractRunnableC11117h abstractRunnableC11117hM66777d = ExecutorC11110a.this.f52351e.m66777d();
                return abstractRunnableC11117hM66777d == null ? ExecutorC11110a.this.f52352f.m66777d() : abstractRunnableC11117hM66777d;
            }
            AbstractRunnableC11117h abstractRunnableC11117hM66777d2 = ExecutorC11110a.this.f52352f.m66777d();
            return abstractRunnableC11117hM66777d2 == null ? ExecutorC11110a.this.f52351e.m66777d() : abstractRunnableC11117hM66777d2;
        }

        /* renamed from: o */
        public final void m66867o() {
            loop0: while (true) {
                boolean z10 = false;
                while (!ExecutorC11110a.this.isTerminated() && this.f52357b != d.TERMINATED) {
                    AbstractRunnableC11117h abstractRunnableC11117hM66859g = m66859g(this.f52361f);
                    if (abstractRunnableC11117hM66859g != null) {
                        this.f52359d = 0L;
                        m66857e(abstractRunnableC11117hM66859g);
                    } else {
                        this.f52361f = false;
                        if (this.f52359d == 0) {
                            m66871s();
                        } else if (z10) {
                            m66872t(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f52359d);
                            this.f52359d = 0L;
                        } else {
                            z10 = true;
                        }
                    }
                }
                break loop0;
            }
            m66872t(d.TERMINATED);
        }

        /* renamed from: p */
        public final void m66868p(int i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ExecutorC11110a.this.f52350d);
            sb2.append("-worker-");
            sb2.append(i10 == 0 ? "TERMINATED" : String.valueOf(i10));
            setName(sb2.toString());
            this.indexInArray = i10;
        }

        /* renamed from: q */
        public final void m66869q(Object obj) {
            this.nextParkedWorker = obj;
        }

        /* renamed from: r */
        public final boolean m66870r() {
            long j10;
            if (this.f52357b == d.CPU_ACQUIRED) {
                return true;
            }
            ExecutorC11110a executorC11110a = ExecutorC11110a.this;
            do {
                j10 = executorC11110a.controlState;
                if (((int) ((9223367638808264704L & j10) >> 42)) == 0) {
                    return false;
                }
            } while (!ExecutorC11110a.f52344j.compareAndSet(executorC11110a, j10, j10 - 4398046511104L));
            this.f52357b = d.CPU_ACQUIRED;
            return true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            m66867o();
        }

        /* renamed from: s */
        public final void m66871s() {
            if (!m66863k()) {
                ExecutorC11110a.this.m66853z(this);
                return;
            }
            this.workerCtl = -1;
            while (m66863k() && this.workerCtl == -1 && !ExecutorC11110a.this.isTerminated() && this.f52357b != d.TERMINATED) {
                m66872t(d.PARKING);
                Thread.interrupted();
                m66865m();
            }
        }

        /* renamed from: t */
        public final boolean m66872t(d dVar) {
            d dVar2 = this.f52357b;
            boolean z10 = dVar2 == d.CPU_ACQUIRED;
            if (z10) {
                ExecutorC11110a.f52344j.addAndGet(ExecutorC11110a.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.f52357b = dVar;
            }
            return z10;
        }

        /* renamed from: u */
        public final AbstractRunnableC11117h m66873u(boolean z10) {
            int i10 = (int) (ExecutorC11110a.this.controlState & 2097151);
            if (i10 < 2) {
                return null;
            }
            int iM66864l = m66864l(i10);
            ExecutorC11110a executorC11110a = ExecutorC11110a.this;
            int i11 = 0;
            long jMin = Long.MAX_VALUE;
            while (i11 < i10) {
                i11++;
                iM66864l++;
                if (iM66864l > i10) {
                    iM66864l = 1;
                }
                c cVarM66801b = executorC11110a.f52353g.m66801b(iM66864l);
                if (cVarM66801b != null && cVarM66801b != this) {
                    long jM66892k = z10 ? this.f52356a.m66892k(cVarM66801b.f52356a) : this.f52356a.m66893l(cVarM66801b.f52356a);
                    if (jM66892k == -1) {
                        return this.f52356a.m66889h();
                    }
                    if (jM66892k > 0) {
                        jMin = Math.min(jMin, jM66892k);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.f52359d = jMin;
            return null;
        }

        /* renamed from: v */
        public final void m66874v() {
            ExecutorC11110a executorC11110a = ExecutorC11110a.this;
            synchronized (executorC11110a.f52353g) {
                try {
                    if (executorC11110a.isTerminated()) {
                        return;
                    }
                    if (((int) (executorC11110a.controlState & 2097151)) <= executorC11110a.f52347a) {
                        return;
                    }
                    if (f52355h.compareAndSet(this, -1, 1)) {
                        int iM66860h = m66860h();
                        m66868p(0);
                        executorC11110a.m66838A(this, iM66860h, 0);
                        int andDecrement = (int) (ExecutorC11110a.f52344j.getAndDecrement(executorC11110a) & 2097151);
                        if (andDecrement != iM66860h) {
                            c cVarM66801b = executorC11110a.f52353g.m66801b(andDecrement);
                            C13267j.m79674b(cVarM66801b);
                            c cVar = cVarM66801b;
                            executorC11110a.f52353g.m66802c(iM66860h, cVar);
                            cVar.m66868p(iM66860h);
                            executorC11110a.m66838A(cVar, andDecrement, iM66860h);
                        }
                        executorC11110a.f52353g.m66802c(andDecrement, null);
                        C10951q c10951q = C10951q.f51861a;
                        this.f52357b = d.TERMINATED;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public c(int i10) {
            this();
            m66868p(i10);
        }
    }
}
