package p040bx;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.AbstractC11100q;
import kotlinx.coroutines.internal.C11092i;
import kotlinx.coroutines.internal.C11093j;
import mw.InterfaceC11539f;
import p040bx.InterfaceC1347u0;
import p408jw.C10936b;
import p408jw.C10951q;
import p464m.C11384b;
import p692uw.C13267j;
import tw.InterfaceC13086l;
import tw.InterfaceC13090p;

/* renamed from: bx.a1 */
/* loaded from: classes9.dex */
public class C1295a1 implements InterfaceC1347u0, InterfaceC1326l, InterfaceC1313g1 {

    /* renamed from: a */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5775a = AtomicReferenceFieldUpdater.newUpdater(C1295a1.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    /* renamed from: bx.a1$a */
    public static final class a extends AbstractC1357z0 {

        /* renamed from: e */
        public final C1295a1 f5776e;

        /* renamed from: f */
        public final b f5777f;

        /* renamed from: g */
        public final C1323k f5778g;

        /* renamed from: h */
        public final Object f5779h;

        public a(C1295a1 c1295a1, b bVar, C1323k c1323k, Object obj) {
            this.f5776e = c1295a1;
            this.f5777f = bVar;
            this.f5778g = c1323k;
            this.f5779h = obj;
        }

        @Override // tw.InterfaceC13086l
        /* renamed from: c */
        public /* bridge */ /* synthetic */ C10951q mo5000c(Throwable th2) {
            mo7714q(th2);
            return C10951q.f51861a;
        }

        @Override // p040bx.AbstractC1336p
        /* renamed from: q */
        public void mo7714q(Throwable th2) {
            this.f5776e.m7711x(this.f5777f, this.f5778g, this.f5779h);
        }
    }

    /* renamed from: bx.a1$b */
    public static final class b implements InterfaceC1339q0 {
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;

        /* renamed from: a */
        public final C1304d1 f5780a;

        public b(C1304d1 c1304d1, boolean z10, Throwable th2) {
            this.f5780a = c1304d1;
            this._isCompleting = z10 ? 1 : 0;
            this._rootCause = th2;
        }

        /* renamed from: a */
        public final void m7715a(Throwable th2) {
            Throwable thM7718d = m7718d();
            if (thM7718d == null) {
                m7725k(th2);
                return;
            }
            if (th2 == thM7718d) {
                return;
            }
            Object objM7717c = m7717c();
            if (objM7717c == null) {
                m7724j(th2);
                return;
            }
            if (!(objM7717c instanceof Throwable)) {
                if (!(objM7717c instanceof ArrayList)) {
                    throw new IllegalStateException(C13267j.m79683k("State is ", objM7717c).toString());
                }
                ((ArrayList) objM7717c).add(th2);
            } else {
                if (th2 == objM7717c) {
                    return;
                }
                ArrayList<Throwable> arrayListM7716b = m7716b();
                arrayListM7716b.add(objM7717c);
                arrayListM7716b.add(th2);
                m7724j(arrayListM7716b);
            }
        }

        /* renamed from: b */
        public final ArrayList<Throwable> m7716b() {
            return new ArrayList<>(4);
        }

        /* renamed from: c */
        public final Object m7717c() {
            return this._exceptionsHolder;
        }

        /* renamed from: d */
        public final Throwable m7718d() {
            return (Throwable) this._rootCause;
        }

        /* renamed from: e */
        public final boolean m7719e() {
            return m7718d() != null;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
        /* renamed from: f */
        public final boolean m7720f() {
            return this._isCompleting;
        }

        /* renamed from: g */
        public final boolean m7721g() {
            return m7717c() == C1298b1.f5788e;
        }

        /* renamed from: h */
        public final List<Throwable> m7722h(Throwable th2) {
            ArrayList<Throwable> arrayListM7716b;
            Object objM7717c = m7717c();
            if (objM7717c == null) {
                arrayListM7716b = m7716b();
            } else if (objM7717c instanceof Throwable) {
                ArrayList<Throwable> arrayListM7716b2 = m7716b();
                arrayListM7716b2.add(objM7717c);
                arrayListM7716b = arrayListM7716b2;
            } else {
                if (!(objM7717c instanceof ArrayList)) {
                    throw new IllegalStateException(C13267j.m79683k("State is ", objM7717c).toString());
                }
                arrayListM7716b = (ArrayList) objM7717c;
            }
            Throwable thM7718d = m7718d();
            if (thM7718d != null) {
                arrayListM7716b.add(0, thM7718d);
            }
            if (th2 != null && !C13267j.m79673a(th2, thM7718d)) {
                arrayListM7716b.add(th2);
            }
            m7724j(C1298b1.f5788e);
            return arrayListM7716b;
        }

        /* renamed from: i */
        public final void m7723i(boolean z10) {
            this._isCompleting = z10 ? 1 : 0;
        }

        /* renamed from: j */
        public final void m7724j(Object obj) {
            this._exceptionsHolder = obj;
        }

        /* renamed from: k */
        public final void m7725k(Throwable th2) {
            this._rootCause = th2;
        }

        @Override // p040bx.InterfaceC1339q0
        /* renamed from: s */
        public boolean mo7726s() {
            return m7718d() == null;
        }

        @Override // p040bx.InterfaceC1339q0
        /* renamed from: t */
        public C1304d1 mo7727t() {
            return this.f5780a;
        }

        public String toString() {
            return "Finishing[cancelling=" + m7719e() + ", completing=" + m7720f() + ", rootCause=" + m7718d() + ", exceptions=" + m7717c() + ", list=" + mo7727t() + ']';
        }
    }

    /* renamed from: bx.a1$c */
    public static final class c extends C11093j.a {

        /* renamed from: d */
        public final /* synthetic */ C11093j f5781d;

        /* renamed from: e */
        public final /* synthetic */ C1295a1 f5782e;

        /* renamed from: f */
        public final /* synthetic */ Object f5783f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(C11093j c11093j, C1295a1 c1295a1, Object obj) {
            super(c11093j);
            this.f5781d = c11093j;
            this.f5782e = c1295a1;
            this.f5783f = obj;
        }

        @Override // kotlinx.coroutines.internal.AbstractC11086c
        /* renamed from: i */
        public Object mo7728g(C11093j c11093j) {
            if (this.f5782e.m7676I() == this.f5783f) {
                return null;
            }
            return C11092i.m66759a();
        }
    }

    /* renamed from: b0 */
    public static /* synthetic */ CancellationException m7667b0(C1295a1 c1295a1, Throwable th2, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        return c1295a1.m7691a0(th2, str);
    }

    /* renamed from: A */
    public final Object m7668A(b bVar, Object obj) throws Throwable {
        boolean zM7719e;
        Throwable thM7671D;
        C1332n c1332n = obj instanceof C1332n ? (C1332n) obj : null;
        Throwable th2 = c1332n == null ? null : c1332n.f5830a;
        synchronized (bVar) {
            zM7719e = bVar.m7719e();
            List<Throwable> listM7722h = bVar.m7722h(th2);
            thM7671D = m7671D(bVar, listM7722h);
            if (thM7671D != null) {
                m7700k(thM7671D, listM7722h);
            }
        }
        if (thM7671D != null && thM7671D != th2) {
            obj = new C1332n(thM7671D, false, 2, null);
        }
        if (thM7671D != null && (m7705p(thM7671D) || m7677J(thM7671D))) {
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            }
            ((C1332n) obj).m7820b();
        }
        if (!zM7719e) {
            m7685T(thM7671D);
        }
        mo7656U(obj);
        C11384b.m68273a(f5775a, this, bVar, C1298b1.m7735f(obj));
        m7710w(bVar, obj);
        return obj;
    }

    /* renamed from: B */
    public final C1323k m7669B(InterfaceC1339q0 interfaceC1339q0) {
        C1323k c1323k = interfaceC1339q0 instanceof C1323k ? (C1323k) interfaceC1339q0 : null;
        if (c1323k != null) {
            return c1323k;
        }
        C1304d1 c1304d1Mo7727t = interfaceC1339q0.mo7727t();
        if (c1304d1Mo7727t == null) {
            return null;
        }
        return m7682Q(c1304d1Mo7727t);
    }

    /* renamed from: C */
    public final Throwable m7670C(Object obj) {
        C1332n c1332n = obj instanceof C1332n ? (C1332n) obj : null;
        if (c1332n == null) {
            return null;
        }
        return c1332n.f5830a;
    }

    /* renamed from: D */
    public final Throwable m7671D(b bVar, List<? extends Throwable> list) {
        Object obj = null;
        if (list.isEmpty()) {
            if (bVar.m7719e()) {
                return new C1349v0(mo7661q(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                obj = next;
                break;
            }
        }
        Throwable th2 = (Throwable) obj;
        return th2 != null ? th2 : list.get(0);
    }

    /* renamed from: E */
    public boolean m7672E() {
        return true;
    }

    /* renamed from: F */
    public boolean m7673F() {
        return false;
    }

    /* renamed from: G */
    public final C1304d1 m7674G(InterfaceC1339q0 interfaceC1339q0) {
        C1304d1 c1304d1Mo7727t = interfaceC1339q0.mo7727t();
        if (c1304d1Mo7727t != null) {
            return c1304d1Mo7727t;
        }
        if (interfaceC1339q0 instanceof C1318i0) {
            return new C1304d1();
        }
        if (!(interfaceC1339q0 instanceof AbstractC1357z0)) {
            throw new IllegalStateException(C13267j.m79683k("State should have list: ", interfaceC1339q0).toString());
        }
        m7687W((AbstractC1357z0) interfaceC1339q0);
        return null;
    }

    /* renamed from: H */
    public final InterfaceC1320j m7675H() {
        return (InterfaceC1320j) this._parentHandle;
    }

    /* renamed from: I */
    public final Object m7676I() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof AbstractC11100q)) {
                return obj;
            }
            ((AbstractC11100q) obj).mo66744c(this);
        }
    }

    /* renamed from: J */
    public boolean m7677J(Throwable th2) {
        return false;
    }

    /* renamed from: K */
    public void mo7654K(Throwable th2) throws Throwable {
        throw th2;
    }

    /* renamed from: L */
    public boolean mo7678L() {
        return false;
    }

    /* renamed from: M */
    public final Object m7679M(Object obj) throws Throwable {
        Throwable thM7713z = null;
        while (true) {
            Object objM7676I = m7676I();
            if (objM7676I instanceof b) {
                synchronized (objM7676I) {
                    if (((b) objM7676I).m7721g()) {
                        return C1298b1.f5787d;
                    }
                    boolean zM7719e = ((b) objM7676I).m7719e();
                    if (obj != null || !zM7719e) {
                        if (thM7713z == null) {
                            thM7713z = m7713z(obj);
                        }
                        ((b) objM7676I).m7715a(thM7713z);
                    }
                    Throwable thM7718d = zM7719e ^ true ? ((b) objM7676I).m7718d() : null;
                    if (thM7718d != null) {
                        m7683R(((b) objM7676I).mo7727t(), thM7718d);
                    }
                    return C1298b1.f5784a;
                }
            }
            if (!(objM7676I instanceof InterfaceC1339q0)) {
                return C1298b1.f5787d;
            }
            if (thM7713z == null) {
                thM7713z = m7713z(obj);
            }
            InterfaceC1339q0 interfaceC1339q0 = (InterfaceC1339q0) objM7676I;
            if (!interfaceC1339q0.mo7726s()) {
                Object objM7696f0 = m7696f0(objM7676I, new C1332n(thM7713z, false, 2, null));
                if (objM7696f0 == C1298b1.f5784a) {
                    throw new IllegalStateException(C13267j.m79683k("Cannot happen in ", objM7676I).toString());
                }
                if (objM7696f0 != C1298b1.f5786c) {
                    return objM7696f0;
                }
            } else if (m7694e0(interfaceC1339q0, thM7713z)) {
                return C1298b1.f5784a;
            }
        }
    }

    /* renamed from: N */
    public final Object m7680N(Object obj) {
        Object objM7696f0;
        do {
            objM7696f0 = m7696f0(m7676I(), obj);
            if (objM7696f0 == C1298b1.f5784a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, m7670C(obj));
            }
        } while (objM7696f0 == C1298b1.f5786c);
        return objM7696f0;
    }

    /* renamed from: O */
    public final AbstractC1357z0 m7681O(InterfaceC13086l<? super Throwable, C10951q> interfaceC13086l, boolean z10) {
        AbstractC1357z0 c1345t0;
        if (z10) {
            c1345t0 = interfaceC13086l instanceof AbstractC1351w0 ? (AbstractC1351w0) interfaceC13086l : null;
            if (c1345t0 == null) {
                c1345t0 = new C1343s0(interfaceC13086l);
            }
        } else {
            AbstractC1357z0 abstractC1357z0 = interfaceC13086l instanceof AbstractC1357z0 ? (AbstractC1357z0) interfaceC13086l : null;
            c1345t0 = abstractC1357z0 != null ? abstractC1357z0 : null;
            if (c1345t0 == null) {
                c1345t0 = new C1345t0(interfaceC13086l);
            }
        }
        c1345t0.m7855u(this);
        return c1345t0;
    }

    /* renamed from: P */
    public String mo7655P() {
        return C1354y.m7844a(this);
    }

    /* renamed from: Q */
    public final C1323k m7682Q(C11093j c11093j) {
        while (c11093j.mo66758l()) {
            c11093j = c11093j.m66768k();
        }
        while (true) {
            c11093j = c11093j.m66767j();
            if (!c11093j.mo66758l()) {
                if (c11093j instanceof C1323k) {
                    return (C1323k) c11093j;
                }
                if (c11093j instanceof C1304d1) {
                    return null;
                }
            }
        }
    }

    /* renamed from: R */
    public final void m7683R(C1304d1 c1304d1, Throwable th2) throws Throwable {
        C1338q c1338q;
        m7685T(th2);
        C1338q c1338q2 = null;
        for (C11093j c11093jM66767j = (C11093j) c1304d1.m66766h(); !C13267j.m79673a(c11093jM66767j, c1304d1); c11093jM66767j = c11093jM66767j.m66767j()) {
            if (c11093jM66767j instanceof AbstractC1351w0) {
                AbstractC1357z0 abstractC1357z0 = (AbstractC1357z0) c11093jM66767j;
                try {
                    abstractC1357z0.mo7714q(th2);
                } catch (Throwable th3) {
                    if (c1338q2 == null) {
                        c1338q = null;
                    } else {
                        C10936b.m66063a(c1338q2, th3);
                        c1338q = c1338q2;
                    }
                    if (c1338q == null) {
                        c1338q2 = new C1338q("Exception in completion handler " + abstractC1357z0 + " for " + this, th3);
                    }
                }
            }
        }
        if (c1338q2 != null) {
            mo7654K(c1338q2);
        }
        m7705p(th2);
    }

    /* renamed from: S */
    public final void m7684S(C1304d1 c1304d1, Throwable th2) throws Throwable {
        C1338q c1338q;
        C1338q c1338q2 = null;
        for (C11093j c11093jM66767j = (C11093j) c1304d1.m66766h(); !C13267j.m79673a(c11093jM66767j, c1304d1); c11093jM66767j = c11093jM66767j.m66767j()) {
            if (c11093jM66767j instanceof AbstractC1357z0) {
                AbstractC1357z0 abstractC1357z0 = (AbstractC1357z0) c11093jM66767j;
                try {
                    abstractC1357z0.mo7714q(th2);
                } catch (Throwable th3) {
                    if (c1338q2 == null) {
                        c1338q = null;
                    } else {
                        C10936b.m66063a(c1338q2, th3);
                        c1338q = c1338q2;
                    }
                    if (c1338q == null) {
                        c1338q2 = new C1338q("Exception in completion handler " + abstractC1357z0 + " for " + this, th3);
                    }
                }
            }
        }
        if (c1338q2 == null) {
            return;
        }
        mo7654K(c1338q2);
    }

    /* renamed from: T */
    public void m7685T(Throwable th2) {
    }

    /* renamed from: U */
    public void mo7656U(Object obj) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [bx.p0] */
    /* renamed from: V */
    public final void m7686V(C1318i0 c1318i0) {
        C1304d1 c1304d1 = new C1304d1();
        if (!c1318i0.mo7726s()) {
            c1304d1 = new C1337p0(c1304d1);
        }
        C11384b.m68273a(f5775a, this, c1318i0, c1304d1);
    }

    /* renamed from: W */
    public final void m7687W(AbstractC1357z0 abstractC1357z0) {
        abstractC1357z0.m66762b(new C1304d1());
        C11384b.m68273a(f5775a, this, abstractC1357z0, abstractC1357z0.m66767j());
    }

    /* renamed from: X */
    public final void m7688X(AbstractC1357z0 abstractC1357z0) {
        Object objM7676I;
        do {
            objM7676I = m7676I();
            if (!(objM7676I instanceof AbstractC1357z0)) {
                if (!(objM7676I instanceof InterfaceC1339q0) || ((InterfaceC1339q0) objM7676I).mo7727t() == null) {
                    return;
                }
                abstractC1357z0.m66769m();
                return;
            }
            if (objM7676I != abstractC1357z0) {
                return;
            }
        } while (!C11384b.m68273a(f5775a, this, objM7676I, C1298b1.f5790g));
    }

    /* renamed from: Y */
    public final void m7689Y(InterfaceC1320j interfaceC1320j) {
        this._parentHandle = interfaceC1320j;
    }

    /* renamed from: Z */
    public final String m7690Z(Object obj) {
        if (!(obj instanceof b)) {
            return obj instanceof InterfaceC1339q0 ? ((InterfaceC1339q0) obj).mo7726s() ? "Active" : "New" : obj instanceof C1332n ? "Cancelled" : "Completed";
        }
        b bVar = (b) obj;
        return bVar.m7719e() ? "Cancelling" : bVar.m7720f() ? "Completing" : "Active";
    }

    /* renamed from: a0 */
    public final CancellationException m7691a0(Throwable th2, String str) {
        CancellationException c1349v0 = th2 instanceof CancellationException ? (CancellationException) th2 : null;
        if (c1349v0 == null) {
            if (str == null) {
                str = mo7661q();
            }
            c1349v0 = new C1349v0(str, th2, this);
        }
        return c1349v0;
    }

    /* renamed from: c0 */
    public final String m7692c0() {
        return mo7655P() + '{' + m7690Z(m7676I()) + '}';
    }

    /* renamed from: d0 */
    public final boolean m7693d0(InterfaceC1339q0 interfaceC1339q0, Object obj) throws Throwable {
        if (!C11384b.m68273a(f5775a, this, interfaceC1339q0, C1298b1.m7735f(obj))) {
            return false;
        }
        m7685T(null);
        mo7656U(obj);
        m7710w(interfaceC1339q0, obj);
        return true;
    }

    /* renamed from: e0 */
    public final boolean m7694e0(InterfaceC1339q0 interfaceC1339q0, Throwable th2) throws Throwable {
        C1304d1 c1304d1M7674G = m7674G(interfaceC1339q0);
        if (c1304d1M7674G == null) {
            return false;
        }
        if (!C11384b.m68273a(f5775a, this, interfaceC1339q0, new b(c1304d1M7674G, false, th2))) {
            return false;
        }
        m7683R(c1304d1M7674G, th2);
        return true;
    }

    @Override // p040bx.InterfaceC1326l
    /* renamed from: f */
    public final void mo7695f(InterfaceC1313g1 interfaceC1313g1) throws Throwable {
        m7702m(interfaceC1313g1);
    }

    /* renamed from: f0 */
    public final Object m7696f0(Object obj, Object obj2) {
        return !(obj instanceof InterfaceC1339q0) ? C1298b1.f5784a : ((!(obj instanceof C1318i0) && !(obj instanceof AbstractC1357z0)) || (obj instanceof C1323k) || (obj2 instanceof C1332n)) ? m7697g0((InterfaceC1339q0) obj, obj2) : m7693d0((InterfaceC1339q0) obj, obj2) ? obj2 : C1298b1.f5786c;
    }

    @Override // mw.InterfaceC11539f
    public <R> R fold(R r10, InterfaceC13090p<? super R, ? super InterfaceC11539f.b, ? extends R> interfaceC13090p) {
        return (R) InterfaceC1347u0.a.m7835a(this, r10, interfaceC13090p);
    }

    /* renamed from: g0 */
    public final Object m7697g0(InterfaceC1339q0 interfaceC1339q0, Object obj) throws Throwable {
        C1304d1 c1304d1M7674G = m7674G(interfaceC1339q0);
        if (c1304d1M7674G == null) {
            return C1298b1.f5786c;
        }
        b bVar = interfaceC1339q0 instanceof b ? (b) interfaceC1339q0 : null;
        if (bVar == null) {
            bVar = new b(c1304d1M7674G, false, null);
        }
        synchronized (bVar) {
            if (bVar.m7720f()) {
                return C1298b1.f5784a;
            }
            bVar.m7723i(true);
            if (bVar != interfaceC1339q0 && !C11384b.m68273a(f5775a, this, interfaceC1339q0, bVar)) {
                return C1298b1.f5786c;
            }
            boolean zM7719e = bVar.m7719e();
            C1332n c1332n = obj instanceof C1332n ? (C1332n) obj : null;
            if (c1332n != null) {
                bVar.m7715a(c1332n.f5830a);
            }
            Throwable thM7718d = true ^ zM7719e ? bVar.m7718d() : null;
            C10951q c10951q = C10951q.f51861a;
            if (thM7718d != null) {
                m7683R(c1304d1M7674G, thM7718d);
            }
            C1323k c1323kM7669B = m7669B(interfaceC1339q0);
            return (c1323kM7669B == null || !m7698h0(bVar, c1323kM7669B, obj)) ? m7668A(bVar, obj) : C1298b1.f5785b;
        }
    }

    @Override // mw.InterfaceC11539f.b, mw.InterfaceC11539f
    public <E extends InterfaceC11539f.b> E get(InterfaceC11539f.c<E> cVar) {
        return (E) InterfaceC1347u0.a.m7836b(this, cVar);
    }

    @Override // mw.InterfaceC11539f.b
    public final InterfaceC11539f.c<?> getKey() {
        return InterfaceC1347u0.f5846g2;
    }

    /* renamed from: h0 */
    public final boolean m7698h0(b bVar, C1323k c1323k, Object obj) {
        while (InterfaceC1347u0.a.m7837c(c1323k.f5813e, false, false, new a(this, bVar, c1323k, obj), 1, null) == C1307e1.f5795a) {
            c1323k = m7682Q(c1323k);
            if (c1323k == null) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: i */
    public final boolean m7699i(Object obj, C1304d1 c1304d1, AbstractC1357z0 abstractC1357z0) {
        int iM66772p;
        c cVar = new c(abstractC1357z0, this, obj);
        do {
            iM66772p = c1304d1.m66768k().m66772p(abstractC1357z0, c1304d1, cVar);
            if (iM66772p == 1) {
                return true;
            }
        } while (iM66772p != 2);
        return false;
    }

    /* renamed from: k */
    public final void m7700k(Throwable th2, List<? extends Throwable> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (list.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        for (Throwable th3 : list) {
            if (th3 != th2 && th3 != th2 && !(th3 instanceof CancellationException) && setNewSetFromMap.add(th3)) {
                C10936b.m66063a(th2, th3);
            }
        }
    }

    /* renamed from: l */
    public void mo7701l(Object obj) {
    }

    /* renamed from: m */
    public final boolean m7702m(Object obj) throws Throwable {
        Object objM7679M = C1298b1.f5784a;
        if (m7673F() && (objM7679M = m7704o(obj)) == C1298b1.f5785b) {
            return true;
        }
        if (objM7679M == C1298b1.f5784a) {
            objM7679M = m7679M(obj);
        }
        if (objM7679M == C1298b1.f5784a || objM7679M == C1298b1.f5785b) {
            return true;
        }
        if (objM7679M == C1298b1.f5787d) {
            return false;
        }
        mo7701l(objM7679M);
        return true;
    }

    @Override // mw.InterfaceC11539f
    public InterfaceC11539f minusKey(InterfaceC11539f.c<?> cVar) {
        return InterfaceC1347u0.a.m7838d(this, cVar);
    }

    /* renamed from: n */
    public void m7703n(Throwable th2) throws Throwable {
        m7702m(th2);
    }

    /* renamed from: o */
    public final Object m7704o(Object obj) {
        Object objM7696f0;
        do {
            Object objM7676I = m7676I();
            if (!(objM7676I instanceof InterfaceC1339q0) || ((objM7676I instanceof b) && ((b) objM7676I).m7720f())) {
                return C1298b1.f5784a;
            }
            objM7696f0 = m7696f0(objM7676I, new C1332n(m7713z(obj), false, 2, null));
        } while (objM7696f0 == C1298b1.f5786c);
        return objM7696f0;
    }

    /* renamed from: p */
    public final boolean m7705p(Throwable th2) {
        if (mo7678L()) {
            return true;
        }
        boolean z10 = th2 instanceof CancellationException;
        InterfaceC1320j interfaceC1320jM7675H = m7675H();
        return (interfaceC1320jM7675H == null || interfaceC1320jM7675H == C1307e1.f5795a) ? z10 : interfaceC1320jM7675H.mo7747e(th2) || z10;
    }

    @Override // mw.InterfaceC11539f
    public InterfaceC11539f plus(InterfaceC11539f interfaceC11539f) {
        return InterfaceC1347u0.a.m7839e(this, interfaceC11539f);
    }

    /* renamed from: q */
    public String mo7661q() {
        return "Job was cancelled";
    }

    /* renamed from: r */
    public boolean m7706r(Throwable th2) {
        if (th2 instanceof CancellationException) {
            return true;
        }
        return m7702m(th2) && m7672E();
    }

    @Override // p040bx.InterfaceC1347u0
    /* renamed from: s */
    public boolean mo7662s() {
        Object objM7676I = m7676I();
        return (objM7676I instanceof InterfaceC1339q0) && ((InterfaceC1339q0) objM7676I).mo7726s();
    }

    @Override // p040bx.InterfaceC1347u0
    /* renamed from: t */
    public final CancellationException mo7707t() {
        Object objM7676I = m7676I();
        if (!(objM7676I instanceof b)) {
            if (objM7676I instanceof InterfaceC1339q0) {
                throw new IllegalStateException(C13267j.m79683k("Job is still new or active: ", this).toString());
            }
            return objM7676I instanceof C1332n ? m7667b0(this, ((C1332n) objM7676I).f5830a, null, 1, null) : new C1349v0(C13267j.m79683k(C1354y.m7844a(this), " has completed normally"), null, this);
        }
        Throwable thM7718d = ((b) objM7676I).m7718d();
        CancellationException cancellationExceptionM7691a0 = thM7718d != null ? m7691a0(thM7718d, C13267j.m79683k(C1354y.m7844a(this), " is cancelling")) : null;
        if (cancellationExceptionM7691a0 != null) {
            return cancellationExceptionM7691a0;
        }
        throw new IllegalStateException(C13267j.m79683k("Job is still new or active: ", this).toString());
    }

    public String toString() {
        return m7692c0() + '@' + C1354y.m7845b(this);
    }

    @Override // p040bx.InterfaceC1347u0
    /* renamed from: u */
    public final InterfaceC1315h0 mo7708u(boolean z10, boolean z11, InterfaceC13086l<? super Throwable, C10951q> interfaceC13086l) {
        AbstractC1357z0 abstractC1357z0M7681O = m7681O(interfaceC13086l, z10);
        while (true) {
            Object objM7676I = m7676I();
            if (objM7676I instanceof C1318i0) {
                C1318i0 c1318i0 = (C1318i0) objM7676I;
                if (!c1318i0.mo7726s()) {
                    m7686V(c1318i0);
                } else if (C11384b.m68273a(f5775a, this, objM7676I, abstractC1357z0M7681O)) {
                    return abstractC1357z0M7681O;
                }
            } else {
                if (!(objM7676I instanceof InterfaceC1339q0)) {
                    if (z11) {
                        C1332n c1332n = objM7676I instanceof C1332n ? (C1332n) objM7676I : null;
                        interfaceC13086l.mo5000c(c1332n != null ? c1332n.f5830a : null);
                    }
                    return C1307e1.f5795a;
                }
                C1304d1 c1304d1Mo7727t = ((InterfaceC1339q0) objM7676I).mo7727t();
                if (c1304d1Mo7727t != null) {
                    InterfaceC1315h0 interfaceC1315h0 = C1307e1.f5795a;
                    if (z10 && (objM7676I instanceof b)) {
                        synchronized (objM7676I) {
                            try {
                                thM7718d = ((b) objM7676I).m7718d();
                                if (thM7718d == null || ((interfaceC13086l instanceof C1323k) && !((b) objM7676I).m7720f())) {
                                    if (m7699i(objM7676I, c1304d1Mo7727t, abstractC1357z0M7681O)) {
                                        if (thM7718d == null) {
                                            return abstractC1357z0M7681O;
                                        }
                                        interfaceC1315h0 = abstractC1357z0M7681O;
                                    }
                                }
                                C10951q c10951q = C10951q.f51861a;
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    }
                    if (thM7718d != null) {
                        if (z11) {
                            interfaceC13086l.mo5000c(thM7718d);
                        }
                        return interfaceC1315h0;
                    }
                    if (m7699i(objM7676I, c1304d1Mo7727t, abstractC1357z0M7681O)) {
                        return abstractC1357z0M7681O;
                    }
                } else {
                    if (objM7676I == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    }
                    m7687W((AbstractC1357z0) objM7676I);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override // p040bx.InterfaceC1313g1
    /* renamed from: v */
    public CancellationException mo7709v() {
        CancellationException cancellationExceptionM7718d;
        Object objM7676I = m7676I();
        if (objM7676I instanceof b) {
            cancellationExceptionM7718d = ((b) objM7676I).m7718d();
        } else if (objM7676I instanceof C1332n) {
            cancellationExceptionM7718d = ((C1332n) objM7676I).f5830a;
        } else {
            if (objM7676I instanceof InterfaceC1339q0) {
                throw new IllegalStateException(C13267j.m79683k("Cannot be cancelling child in this state: ", objM7676I).toString());
            }
            cancellationExceptionM7718d = null;
        }
        CancellationException cancellationException = cancellationExceptionM7718d instanceof CancellationException ? cancellationExceptionM7718d : null;
        return cancellationException == null ? new C1349v0(C13267j.m79683k("Parent job is ", m7690Z(objM7676I)), cancellationExceptionM7718d, this) : cancellationException;
    }

    /* renamed from: w */
    public final void m7710w(InterfaceC1339q0 interfaceC1339q0, Object obj) throws Throwable {
        InterfaceC1320j interfaceC1320jM7675H = m7675H();
        if (interfaceC1320jM7675H != null) {
            interfaceC1320jM7675H.mo7748i();
            m7689Y(C1307e1.f5795a);
        }
        C1332n c1332n = obj instanceof C1332n ? (C1332n) obj : null;
        Throwable th2 = c1332n != null ? c1332n.f5830a : null;
        if (!(interfaceC1339q0 instanceof AbstractC1357z0)) {
            C1304d1 c1304d1Mo7727t = interfaceC1339q0.mo7727t();
            if (c1304d1Mo7727t == null) {
                return;
            }
            m7684S(c1304d1Mo7727t, th2);
            return;
        }
        try {
            ((AbstractC1357z0) interfaceC1339q0).mo7714q(th2);
        } catch (Throwable th3) {
            mo7654K(new C1338q("Exception in completion handler " + interfaceC1339q0 + " for " + this, th3));
        }
    }

    /* renamed from: x */
    public final void m7711x(b bVar, C1323k c1323k, Object obj) {
        C1323k c1323kM7682Q = m7682Q(c1323k);
        if (c1323kM7682Q == null || !m7698h0(bVar, c1323kM7682Q, obj)) {
            mo7701l(m7668A(bVar, obj));
        }
    }

    @Override // p040bx.InterfaceC1347u0
    /* renamed from: y */
    public void mo7712y(CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new C1349v0(mo7661q(), null, this);
        }
        m7703n(cancellationException);
    }

    /* renamed from: z */
    public final Throwable m7713z(Object obj) {
        if (obj == null || (obj instanceof Throwable)) {
            Throwable th2 = (Throwable) obj;
            return th2 == null ? new C1349v0(mo7661q(), null, this) : th2;
        }
        if (obj != null) {
            return ((InterfaceC1313g1) obj).mo7709v();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
    }
}
