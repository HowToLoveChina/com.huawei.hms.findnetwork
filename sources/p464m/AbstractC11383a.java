package p464m;

import com.huawei.openalliance.p169ad.constant.VideoPlayFlag;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import p600r3.InterfaceFutureC12460a;

/* renamed from: m.a */
/* loaded from: classes.dex */
public abstract class AbstractC11383a<V> implements InterfaceFutureC12460a<V> {

    /* renamed from: d */
    public static final boolean f53114d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: e */
    public static final Logger f53115e = Logger.getLogger(AbstractC11383a.class.getName());

    /* renamed from: f */
    public static final b f53116f;

    /* renamed from: g */
    public static final Object f53117g;

    /* renamed from: a */
    public volatile Object f53118a;

    /* renamed from: b */
    public volatile e f53119b;

    /* renamed from: c */
    public volatile i f53120c;

    /* renamed from: m.a$b */
    public static abstract class b {
        public b() {
        }

        /* renamed from: a */
        public abstract boolean mo68266a(AbstractC11383a<?> abstractC11383a, e eVar, e eVar2);

        /* renamed from: b */
        public abstract boolean mo68267b(AbstractC11383a<?> abstractC11383a, Object obj, Object obj2);

        /* renamed from: c */
        public abstract boolean mo68268c(AbstractC11383a<?> abstractC11383a, i iVar, i iVar2);

        /* renamed from: d */
        public abstract void mo68269d(i iVar, i iVar2);

        /* renamed from: e */
        public abstract void mo68270e(i iVar, Thread thread);

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* renamed from: m.a$c */
    public static final class c {

        /* renamed from: c */
        public static final c f53121c;

        /* renamed from: d */
        public static final c f53122d;

        /* renamed from: a */
        public final boolean f53123a;

        /* renamed from: b */
        public final Throwable f53124b;

        static {
            if (AbstractC11383a.f53114d) {
                f53122d = null;
                f53121c = null;
            } else {
                f53122d = new c(false, null);
                f53121c = new c(true, null);
            }
        }

        public c(boolean z10, Throwable th2) {
            this.f53123a = z10;
            this.f53124b = th2;
        }
    }

    /* renamed from: m.a$d */
    public static final class d {

        /* renamed from: b */
        public static final d f53125b = new d(new a("Failure occurred while trying to finish a future."));

        /* renamed from: a */
        public final Throwable f53126a;

        /* renamed from: m.a$d$a */
        public class a extends Throwable {
            public a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable th2) {
            this.f53126a = (Throwable) AbstractC11383a.m68250e(th2);
        }
    }

    /* renamed from: m.a$e */
    public static final class e {

        /* renamed from: d */
        public static final e f53127d = new e(null, null);

        /* renamed from: a */
        public final Runnable f53128a;

        /* renamed from: b */
        public final Executor f53129b;

        /* renamed from: c */
        public e f53130c;

        public e(Runnable runnable, Executor executor) {
            this.f53128a = runnable;
            this.f53129b = executor;
        }
    }

    /* renamed from: m.a$f */
    public static final class f extends b {

        /* renamed from: a */
        public final AtomicReferenceFieldUpdater<i, Thread> f53131a;

        /* renamed from: b */
        public final AtomicReferenceFieldUpdater<i, i> f53132b;

        /* renamed from: c */
        public final AtomicReferenceFieldUpdater<AbstractC11383a, i> f53133c;

        /* renamed from: d */
        public final AtomicReferenceFieldUpdater<AbstractC11383a, e> f53134d;

        /* renamed from: e */
        public final AtomicReferenceFieldUpdater<AbstractC11383a, Object> f53135e;

        public f(AtomicReferenceFieldUpdater<i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<i, i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractC11383a, i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractC11383a, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractC11383a, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f53131a = atomicReferenceFieldUpdater;
            this.f53132b = atomicReferenceFieldUpdater2;
            this.f53133c = atomicReferenceFieldUpdater3;
            this.f53134d = atomicReferenceFieldUpdater4;
            this.f53135e = atomicReferenceFieldUpdater5;
        }

        @Override // p464m.AbstractC11383a.b
        /* renamed from: a */
        public boolean mo68266a(AbstractC11383a<?> abstractC11383a, e eVar, e eVar2) {
            return C11384b.m68273a(this.f53134d, abstractC11383a, eVar, eVar2);
        }

        @Override // p464m.AbstractC11383a.b
        /* renamed from: b */
        public boolean mo68267b(AbstractC11383a<?> abstractC11383a, Object obj, Object obj2) {
            return C11384b.m68273a(this.f53135e, abstractC11383a, obj, obj2);
        }

        @Override // p464m.AbstractC11383a.b
        /* renamed from: c */
        public boolean mo68268c(AbstractC11383a<?> abstractC11383a, i iVar, i iVar2) {
            return C11384b.m68273a(this.f53133c, abstractC11383a, iVar, iVar2);
        }

        @Override // p464m.AbstractC11383a.b
        /* renamed from: d */
        public void mo68269d(i iVar, i iVar2) {
            this.f53132b.lazySet(iVar, iVar2);
        }

        @Override // p464m.AbstractC11383a.b
        /* renamed from: e */
        public void mo68270e(i iVar, Thread thread) {
            this.f53131a.lazySet(iVar, thread);
        }
    }

    /* renamed from: m.a$g */
    public static final class g<V> implements Runnable {

        /* renamed from: a */
        public final AbstractC11383a<V> f53136a;

        /* renamed from: b */
        public final InterfaceFutureC12460a<? extends V> f53137b;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f53136a.f53118a != this) {
                return;
            }
            if (AbstractC11383a.f53116f.mo68267b(this.f53136a, this, AbstractC11383a.m68253j(this.f53137b))) {
                AbstractC11383a.m68251g(this.f53136a);
            }
        }
    }

    /* renamed from: m.a$h */
    public static final class h extends b {
        public h() {
            super();
        }

        @Override // p464m.AbstractC11383a.b
        /* renamed from: a */
        public boolean mo68266a(AbstractC11383a<?> abstractC11383a, e eVar, e eVar2) {
            synchronized (abstractC11383a) {
                try {
                    if (abstractC11383a.f53119b != eVar) {
                        return false;
                    }
                    abstractC11383a.f53119b = eVar2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // p464m.AbstractC11383a.b
        /* renamed from: b */
        public boolean mo68267b(AbstractC11383a<?> abstractC11383a, Object obj, Object obj2) {
            synchronized (abstractC11383a) {
                try {
                    if (abstractC11383a.f53118a != obj) {
                        return false;
                    }
                    abstractC11383a.f53118a = obj2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // p464m.AbstractC11383a.b
        /* renamed from: c */
        public boolean mo68268c(AbstractC11383a<?> abstractC11383a, i iVar, i iVar2) {
            synchronized (abstractC11383a) {
                try {
                    if (abstractC11383a.f53120c != iVar) {
                        return false;
                    }
                    abstractC11383a.f53120c = iVar2;
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // p464m.AbstractC11383a.b
        /* renamed from: d */
        public void mo68269d(i iVar, i iVar2) {
            iVar.f53140b = iVar2;
        }

        @Override // p464m.AbstractC11383a.b
        /* renamed from: e */
        public void mo68270e(i iVar, Thread thread) {
            iVar.f53139a = thread;
        }
    }

    /* renamed from: m.a$i */
    public static final class i {

        /* renamed from: c */
        public static final i f53138c = new i(false);

        /* renamed from: a */
        public volatile Thread f53139a;

        /* renamed from: b */
        public volatile i f53140b;

        public i(boolean z10) {
        }

        /* renamed from: a */
        public void m68271a(i iVar) {
            AbstractC11383a.f53116f.mo68269d(this, iVar);
        }

        /* renamed from: b */
        public void m68272b() {
            Thread thread = this.f53139a;
            if (thread != null) {
                this.f53139a = null;
                LockSupport.unpark(thread);
            }
        }

        public i() {
            AbstractC11383a.f53116f.mo68270e(this, Thread.currentThread());
        }
    }

    static {
        b hVar;
        try {
            hVar = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, VideoPlayFlag.PLAY_IN_ALL), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractC11383a.class, i.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractC11383a.class, e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractC11383a.class, Object.class, VideoPlayFlag.PLAY_IN_ALL));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            hVar = new h();
        }
        f53116f = hVar;
        if (th != null) {
            f53115e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f53117g = new Object();
    }

    /* renamed from: d */
    public static CancellationException m68249d(String str, Throwable th2) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th2);
        return cancellationException;
    }

    /* renamed from: e */
    public static <T> T m68250e(T t10) {
        t10.getClass();
        return t10;
    }

    /* renamed from: g */
    public static void m68251g(AbstractC11383a<?> abstractC11383a) {
        e eVar = null;
        while (true) {
            abstractC11383a.m68262n();
            abstractC11383a.m68257c();
            e eVarM68258f = abstractC11383a.m68258f(eVar);
            while (eVarM68258f != null) {
                eVar = eVarM68258f.f53130c;
                Runnable runnable = eVarM68258f.f53128a;
                if (runnable instanceof g) {
                    g gVar = (g) runnable;
                    abstractC11383a = gVar.f53136a;
                    if (abstractC11383a.f53118a == gVar) {
                        if (f53116f.mo68267b(abstractC11383a, gVar, m68253j(gVar.f53137b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    m68252h(runnable, eVarM68258f.f53129b);
                }
                eVarM68258f = eVar;
            }
            return;
        }
    }

    /* renamed from: h */
    public static void m68252h(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            f53115e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    /* renamed from: j */
    public static Object m68253j(InterfaceFutureC12460a<?> interfaceFutureC12460a) {
        if (interfaceFutureC12460a instanceof AbstractC11383a) {
            Object obj = ((AbstractC11383a) interfaceFutureC12460a).f53118a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            return cVar.f53123a ? cVar.f53124b != null ? new c(false, cVar.f53124b) : c.f53122d : obj;
        }
        boolean zIsCancelled = interfaceFutureC12460a.isCancelled();
        if ((!f53114d) && zIsCancelled) {
            return c.f53122d;
        }
        try {
            Object objM68254k = m68254k(interfaceFutureC12460a);
            return objM68254k == null ? f53117g : objM68254k;
        } catch (CancellationException e10) {
            if (zIsCancelled) {
                return new c(false, e10);
            }
            return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + interfaceFutureC12460a, e10));
        } catch (ExecutionException e11) {
            return new d(e11.getCause());
        } catch (Throwable th2) {
            return new d(th2);
        }
    }

    /* renamed from: k */
    public static <V> V m68254k(Future<V> future) throws ExecutionException {
        V v10;
        boolean z10 = false;
        while (true) {
            try {
                v10 = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th2) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return v10;
    }

    /* renamed from: a */
    public final void m68255a(StringBuilder sb2) {
        try {
            Object objM68254k = m68254k(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(m68265q(objM68254k));
            sb2.append("]");
        } catch (CancellationException unused) {
            sb2.append("CANCELLED");
        } catch (RuntimeException e10) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append(e10.getClass());
            sb2.append(" thrown from get()]");
        } catch (ExecutionException e11) {
            sb2.append("FAILURE, cause=[");
            sb2.append(e11.getCause());
            sb2.append("]");
        }
    }

    /* renamed from: b */
    public final void m68256b(Runnable runnable, Executor executor) {
        m68250e(runnable);
        m68250e(executor);
        e eVar = this.f53119b;
        if (eVar != e.f53127d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f53130c = eVar;
                if (f53116f.mo68266a(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.f53119b;
                }
            } while (eVar != e.f53127d);
        }
        m68252h(runnable, executor);
    }

    /* renamed from: c */
    public void m68257c() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        Object obj = this.f53118a;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        c cVar = f53114d ? new c(z10, new CancellationException("Future.cancel() was called.")) : z10 ? c.f53121c : c.f53122d;
        boolean z11 = false;
        while (true) {
            if (f53116f.mo68267b(this, obj, cVar)) {
                if (z10) {
                    this.m68260l();
                }
                m68251g(this);
                if (!(obj instanceof g)) {
                    return true;
                }
                InterfaceFutureC12460a<? extends V> interfaceFutureC12460a = ((g) obj).f53137b;
                if (!(interfaceFutureC12460a instanceof AbstractC11383a)) {
                    interfaceFutureC12460a.cancel(z10);
                    return true;
                }
                this = (AbstractC11383a) interfaceFutureC12460a;
                obj = this.f53118a;
                if (!(obj == null) && !(obj instanceof g)) {
                    return true;
                }
                z11 = true;
            } else {
                obj = this.f53118a;
                if (!(obj instanceof g)) {
                    return z11;
                }
            }
        }
    }

    /* renamed from: f */
    public final e m68258f(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f53119b;
        } while (!f53116f.mo68266a(this, eVar2, e.f53127d));
        while (true) {
            e eVar3 = eVar;
            eVar = eVar2;
            if (eVar == null) {
                return eVar3;
            }
            eVar2 = eVar.f53130c;
            eVar.f53130c = eVar3;
        }
    }

    @Override // java.util.concurrent.Future
    public final V get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j10);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f53118a;
        if ((obj != null) && (!(obj instanceof g))) {
            return m68259i(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            i iVar = this.f53120c;
            if (iVar != i.f53138c) {
                i iVar2 = new i();
                do {
                    iVar2.m68271a(iVar);
                    if (f53116f.mo68268c(this, iVar, iVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                m68263o(iVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f53118a;
                            if ((obj2 != null) && (!(obj2 instanceof g))) {
                                return m68259i(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        m68263o(iVar2);
                    } else {
                        iVar = this.f53120c;
                    }
                } while (iVar != i.f53138c);
            }
            return m68259i(this.f53118a);
        }
        while (nanos > 0) {
            Object obj3 = this.f53118a;
            if ((obj3 != null) && (!(obj3 instanceof g))) {
                return m68259i(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String str = "Waited " + j10 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j11 = -nanos;
            long jConvert = timeUnit.convert(j11, TimeUnit.NANOSECONDS);
            long nanos2 = j11 - timeUnit.toNanos(jConvert);
            boolean z10 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z10) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z10) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: i */
    public final V m68259i(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw m68249d("Task was cancelled.", ((c) obj).f53124b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f53126a);
        }
        if (obj == f53117g) {
            return null;
        }
        return obj;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f53118a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r2 instanceof g)) & (this.f53118a != null);
    }

    /* renamed from: l */
    public void m68260l() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: m */
    public String m68261m() {
        Object obj = this.f53118a;
        if (obj instanceof g) {
            return "setFuture=[" + m68265q(((g) obj).f53137b) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    /* renamed from: n */
    public final void m68262n() {
        i iVar;
        do {
            iVar = this.f53120c;
        } while (!f53116f.mo68268c(this, iVar, i.f53138c));
        while (iVar != null) {
            iVar.m68272b();
            iVar = iVar.f53140b;
        }
    }

    /* renamed from: o */
    public final void m68263o(i iVar) {
        iVar.f53139a = null;
        while (true) {
            i iVar2 = this.f53120c;
            if (iVar2 == i.f53138c) {
                return;
            }
            i iVar3 = null;
            while (iVar2 != null) {
                i iVar4 = iVar2.f53140b;
                if (iVar2.f53139a != null) {
                    iVar3 = iVar2;
                } else if (iVar3 != null) {
                    iVar3.f53140b = iVar4;
                    if (iVar3.f53139a == null) {
                        break;
                    }
                } else if (!f53116f.mo68268c(this, iVar2, iVar4)) {
                    break;
                }
                iVar2 = iVar4;
            }
            return;
        }
    }

    /* renamed from: p */
    public boolean mo68264p(V v10) {
        if (v10 == null) {
            v10 = (V) f53117g;
        }
        if (!f53116f.mo68267b(this, null, v10)) {
            return false;
        }
        m68251g(this);
        return true;
    }

    /* renamed from: q */
    public final String m68265q(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public String toString() {
        String strM68261m;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            m68255a(sb2);
        } else {
            try {
                strM68261m = m68261m();
            } catch (RuntimeException e10) {
                strM68261m = "Exception thrown from implementation: " + e10.getClass();
            }
            if (strM68261m != null && !strM68261m.isEmpty()) {
                sb2.append("PENDING, info=[");
                sb2.append(strM68261m);
                sb2.append("]");
            } else if (isDone()) {
                m68255a(sb2);
            } else {
                sb2.append("PENDING");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    @Override // java.util.concurrent.Future
    public final V get() throws ExecutionException, InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f53118a;
            if ((obj2 != null) & (!(obj2 instanceof g))) {
                return m68259i(obj2);
            }
            i iVar = this.f53120c;
            if (iVar != i.f53138c) {
                i iVar2 = new i();
                do {
                    iVar2.m68271a(iVar);
                    if (f53116f.mo68268c(this, iVar, iVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f53118a;
                            } else {
                                m68263o(iVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return m68259i(obj);
                    }
                    iVar = this.f53120c;
                } while (iVar != i.f53138c);
            }
            return m68259i(this.f53118a);
        }
        throw new InterruptedException();
    }
}
