package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p040bx.C1354y;
import p464m.C11384b;
import p692uw.C13267j;
import p692uw.C13271n;

/* renamed from: kotlinx.coroutines.internal.j */
/* loaded from: classes9.dex */
public class C11093j {

    /* renamed from: a */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f52313a = AtomicReferenceFieldUpdater.newUpdater(C11093j.class, Object.class, "_next");

    /* renamed from: b */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f52314b = AtomicReferenceFieldUpdater.newUpdater(C11093j.class, Object.class, "_prev");

    /* renamed from: c */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f52315c = AtomicReferenceFieldUpdater.newUpdater(C11093j.class, Object.class, "_removedRef");
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    /* renamed from: kotlinx.coroutines.internal.j$a */
    public static abstract class a extends AbstractC11086c<C11093j> {

        /* renamed from: b */
        public final C11093j f52316b;

        /* renamed from: c */
        public C11093j f52317c;

        public a(C11093j c11093j) {
            this.f52316b = c11093j;
        }

        @Override // kotlinx.coroutines.internal.AbstractC11086c
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void mo66745d(C11093j c11093j, Object obj) {
            boolean z10 = obj == null;
            C11093j c11093j2 = z10 ? this.f52316b : this.f52317c;
            if (c11093j2 != null && C11384b.m68273a(C11093j.f52313a, c11093j, this, c11093j2) && z10) {
                C11093j c11093j3 = this.f52316b;
                C11093j c11093j4 = this.f52317c;
                C13267j.m79674b(c11093j4);
                c11093j3.m66765g(c11093j4);
            }
        }
    }

    /* renamed from: b */
    public final boolean m66762b(C11093j c11093j) {
        f52314b.lazySet(c11093j, this);
        f52313a.lazySet(c11093j, this);
        while (m66766h() == this) {
            if (C11384b.m68273a(f52313a, this, this, c11093j)) {
                c11093j.m66765g(this);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
    
        if (p464m.C11384b.m68273a(kotlinx.coroutines.internal.C11093j.f52313a, r3, r2, ((kotlinx.coroutines.internal.C11101r) r4).f52330a) != false) goto L30;
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlinx.coroutines.internal.C11093j m66763d(kotlinx.coroutines.internal.AbstractC11100q r8) {
        /*
            r7 = this;
        L0:
            java.lang.Object r0 = r7._prev
            kotlinx.coroutines.internal.j r0 = (kotlinx.coroutines.internal.C11093j) r0
            r1 = 0
            r2 = r0
        L6:
            r3 = r1
        L7:
            java.lang.Object r4 = r2._next
            if (r4 != r7) goto L18
            if (r0 != r2) goto Le
            return r2
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.C11093j.f52314b
            boolean r0 = p464m.C11384b.m68273a(r1, r7, r0, r2)
            if (r0 != 0) goto L17
            goto L0
        L17:
            return r2
        L18:
            boolean r5 = r7.mo66758l()
            if (r5 == 0) goto L1f
            return r1
        L1f:
            if (r4 != r8) goto L22
            return r2
        L22:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.AbstractC11100q
            if (r5 == 0) goto L38
            if (r8 == 0) goto L32
            r0 = r4
            kotlinx.coroutines.internal.q r0 = (kotlinx.coroutines.internal.AbstractC11100q) r0
            boolean r0 = r8.m66799b(r0)
            if (r0 == 0) goto L32
            return r1
        L32:
            kotlinx.coroutines.internal.q r4 = (kotlinx.coroutines.internal.AbstractC11100q) r4
            r4.mo66744c(r2)
            goto L0
        L38:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.C11101r
            if (r5 == 0) goto L52
            if (r3 == 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.C11093j.f52313a
            kotlinx.coroutines.internal.r r4 = (kotlinx.coroutines.internal.C11101r) r4
            kotlinx.coroutines.internal.j r4 = r4.f52330a
            boolean r2 = p464m.C11384b.m68273a(r5, r3, r2, r4)
            if (r2 != 0) goto L4b
            goto L0
        L4b:
            r2 = r3
            goto L6
        L4d:
            java.lang.Object r2 = r2._prev
            kotlinx.coroutines.internal.j r2 = (kotlinx.coroutines.internal.C11093j) r2
            goto L7
        L52:
            r3 = r4
            kotlinx.coroutines.internal.j r3 = (kotlinx.coroutines.internal.C11093j) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.C11093j.m66763d(kotlinx.coroutines.internal.q):kotlinx.coroutines.internal.j");
    }

    /* renamed from: f */
    public final C11093j m66764f(C11093j c11093j) {
        while (c11093j.mo66758l()) {
            c11093j = (C11093j) c11093j._prev;
        }
        return c11093j;
    }

    /* renamed from: g */
    public final void m66765g(C11093j c11093j) {
        C11093j c11093j2;
        do {
            c11093j2 = (C11093j) c11093j._prev;
            if (m66766h() != c11093j) {
                return;
            }
        } while (!C11384b.m68273a(f52314b, c11093j, c11093j2, this));
        if (mo66758l()) {
            c11093j.m66763d(null);
        }
    }

    /* renamed from: h */
    public final Object m66766h() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof AbstractC11100q)) {
                return obj;
            }
            ((AbstractC11100q) obj).mo66744c(this);
        }
    }

    /* renamed from: j */
    public final C11093j m66767j() {
        return C11092i.m66760b(m66766h());
    }

    /* renamed from: k */
    public final C11093j m66768k() {
        C11093j c11093jM66763d = m66763d(null);
        return c11093jM66763d == null ? m66764f((C11093j) this._prev) : c11093jM66763d;
    }

    /* renamed from: l */
    public boolean mo66758l() {
        return m66766h() instanceof C11101r;
    }

    /* renamed from: m */
    public boolean m66769m() {
        return m66770n() == null;
    }

    /* renamed from: n */
    public final C11093j m66770n() {
        Object objM66766h;
        C11093j c11093j;
        do {
            objM66766h = m66766h();
            if (objM66766h instanceof C11101r) {
                return ((C11101r) objM66766h).f52330a;
            }
            if (objM66766h == this) {
                return (C11093j) objM66766h;
            }
            c11093j = (C11093j) objM66766h;
        } while (!C11384b.m68273a(f52313a, this, objM66766h, c11093j.m66771o()));
        c11093j.m66763d(null);
        return null;
    }

    /* renamed from: o */
    public final C11101r m66771o() {
        C11101r c11101r = (C11101r) this._removedRef;
        if (c11101r != null) {
            return c11101r;
        }
        C11101r c11101r2 = new C11101r(this);
        f52315c.lazySet(this, c11101r2);
        return c11101r2;
    }

    /* renamed from: p */
    public final int m66772p(C11093j c11093j, C11093j c11093j2, a aVar) {
        f52314b.lazySet(c11093j, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f52313a;
        atomicReferenceFieldUpdater.lazySet(c11093j, c11093j2);
        aVar.f52317c = c11093j2;
        if (C11384b.m68273a(atomicReferenceFieldUpdater, this, c11093j2, aVar)) {
            return aVar.mo66744c(this) == null ? 1 : 2;
        }
        return 0;
    }

    public String toString() {
        return new C13271n(this) { // from class: kotlinx.coroutines.internal.j.b
            @Override // p824yw.InterfaceC14054f
            public Object get() {
                return C1354y.m7844a(this.f59961b);
            }
        } + '@' + C1354y.m7845b(this);
    }
}
