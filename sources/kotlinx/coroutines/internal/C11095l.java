package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p464m.C11384b;
import p692uw.C13264g;

/* renamed from: kotlinx.coroutines.internal.l */
/* loaded from: classes9.dex */
public final class C11095l<E> {
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ long _state = 0;

    /* renamed from: a */
    public final int f52323a;

    /* renamed from: b */
    public final boolean f52324b;

    /* renamed from: c */
    public final int f52325c;

    /* renamed from: d */
    public /* synthetic */ AtomicReferenceArray f52326d;

    /* renamed from: e */
    public static final a f52319e = new a(null);

    /* renamed from: h */
    public static final C11104u f52322h = new C11104u("REMOVE_FROZEN");

    /* renamed from: f */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f52320f = AtomicReferenceFieldUpdater.newUpdater(C11095l.class, Object.class, "_next");

    /* renamed from: g */
    public static final /* synthetic */ AtomicLongFieldUpdater f52321g = AtomicLongFieldUpdater.newUpdater(C11095l.class, "_state");

    /* renamed from: kotlinx.coroutines.internal.l$a */
    public static final class a {
        public /* synthetic */ a(C13264g c13264g) {
            this();
        }

        /* renamed from: a */
        public final int m66789a(long j10) {
            return (j10 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        /* renamed from: b */
        public final long m66790b(long j10, int i10) {
            return m66792d(j10, 1073741823L) | i10;
        }

        /* renamed from: c */
        public final long m66791c(long j10, int i10) {
            return m66792d(j10, 1152921503533105152L) | (i10 << 30);
        }

        /* renamed from: d */
        public final long m66792d(long j10, long j11) {
            return j10 & (~j11);
        }

        public a() {
        }
    }

    /* renamed from: kotlinx.coroutines.internal.l$b */
    public static final class b {

        /* renamed from: a */
        public final int f52327a;

        public b(int i10) {
            this.f52327a = i10;
        }
    }

    public C11095l(int i10, boolean z10) {
        this.f52323a = i10;
        this.f52324b = z10;
        int i11 = i10 - 1;
        this.f52325c = i11;
        this.f52326d = new AtomicReferenceArray(i10);
        if (i11 > 1073741823) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if ((i10 & i11) != 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
    
        return 1;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m66778a(E r12) {
        /*
            r11 = this;
        L0:
            long r2 = r11._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 == 0) goto L12
            kotlinx.coroutines.internal.l$a r11 = kotlinx.coroutines.internal.C11095l.f52319e
            int r11 = r11.m66789a(r2)
            return r11
        L12:
            r0 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r0 = r0 & r2
            int r0 = (int) r0
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r1 = 30
            long r4 = r4 >> r1
            int r8 = (int) r4
            int r9 = r11.f52325c
            int r1 = r8 + 2
            r1 = r1 & r9
            r4 = r0 & r9
            r5 = 1
            if (r1 != r4) goto L2c
            return r5
        L2c:
            boolean r1 = r11.f52324b
            r4 = 1073741823(0x3fffffff, float:1.9999999)
            if (r1 != 0) goto L4b
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r11.f52326d
            r10 = r8 & r9
            java.lang.Object r1 = r1.get(r10)
            if (r1 == 0) goto L4b
            int r1 = r11.f52323a
            r2 = 1024(0x400, float:1.435E-42)
            if (r1 < r2) goto L4a
            int r8 = r8 - r0
            r0 = r8 & r4
            int r1 = r1 >> 1
            if (r0 <= r1) goto L0
        L4a:
            return r5
        L4b:
            int r0 = r8 + 1
            r0 = r0 & r4
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kotlinx.coroutines.internal.C11095l.f52321g
            kotlinx.coroutines.internal.l$a r4 = kotlinx.coroutines.internal.C11095l.f52319e
            long r4 = r4.m66791c(r2, r0)
            r0 = r1
            r1 = r11
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r11.f52326d
            r1 = r8 & r9
            r0.set(r1, r12)
        L65:
            long r0 = r11._state
            r2 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r0 = r0 & r2
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 != 0) goto L6f
            goto L79
        L6f:
            kotlinx.coroutines.internal.l r11 = r11.m66786i()
            kotlinx.coroutines.internal.l r11 = r11.m66782e(r8, r12)
            if (r11 != 0) goto L65
        L79:
            r11 = 0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.C11095l.m66778a(java.lang.Object):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public final C11095l<E> m66779b(long j10) {
        C11095l<E> c11095l = new C11095l<>(this.f52323a * 2, this.f52324b);
        int i10 = (int) (1073741823 & j10);
        int i11 = (int) ((1152921503533105152L & j10) >> 30);
        while (true) {
            int i12 = this.f52325c;
            if ((i10 & i12) == (i11 & i12)) {
                c11095l._state = f52319e.m66792d(j10, 1152921504606846976L);
                return c11095l;
            }
            Object bVar = this.f52326d.get(i12 & i10);
            if (bVar == null) {
                bVar = new b(i10);
            }
            c11095l.f52326d.set(c11095l.f52325c & i10, bVar);
            i10++;
        }
    }

    /* renamed from: c */
    public final C11095l<E> m66780c(long j10) {
        while (true) {
            C11095l<E> c11095l = (C11095l) this._next;
            if (c11095l != null) {
                return c11095l;
            }
            C11384b.m68273a(f52320f, this, null, m66779b(j10));
        }
    }

    /* renamed from: d */
    public final boolean m66781d() {
        long j10;
        do {
            j10 = this._state;
            if ((j10 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j10) != 0) {
                return false;
            }
        } while (!f52321g.compareAndSet(this, j10, j10 | 2305843009213693952L));
        return true;
    }

    /* renamed from: e */
    public final C11095l<E> m66782e(int i10, E e10) {
        Object obj = this.f52326d.get(this.f52325c & i10);
        if (!(obj instanceof b) || ((b) obj).f52327a != i10) {
            return null;
        }
        this.f52326d.set(i10 & this.f52325c, e10);
        return this;
    }

    /* renamed from: f */
    public final int m66783f() {
        long j10 = this._state;
        return 1073741823 & (((int) ((j10 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j10)));
    }

    /* renamed from: g */
    public final boolean m66784g() {
        long j10 = this._state;
        return ((int) (1073741823 & j10)) == ((int) ((j10 & 1152921503533105152L) >> 30));
    }

    /* renamed from: h */
    public final long m66785h() {
        long j10;
        long j11;
        do {
            j10 = this._state;
            if ((j10 & 1152921504606846976L) != 0) {
                return j10;
            }
            j11 = j10 | 1152921504606846976L;
        } while (!f52321g.compareAndSet(this, j10, j11));
        return j11;
    }

    /* renamed from: i */
    public final C11095l<E> m66786i() {
        return m66780c(m66785h());
    }

    /* renamed from: j */
    public final Object m66787j() {
        while (true) {
            long j10 = this._state;
            if ((1152921504606846976L & j10) != 0) {
                return f52322h;
            }
            int i10 = (int) (1073741823 & j10);
            int i11 = this.f52325c;
            if ((((int) ((1152921503533105152L & j10) >> 30)) & i11) == (i10 & i11)) {
                return null;
            }
            Object obj = this.f52326d.get(i11 & i10);
            if (obj == null) {
                if (this.f52324b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i12 = (i10 + 1) & 1073741823;
                if (f52321g.compareAndSet(this, j10, f52319e.m66790b(j10, i12))) {
                    this.f52326d.set(this.f52325c & i10, null);
                    return obj;
                }
                if (this.f52324b) {
                    do {
                        this = this.m66788k(i10, i12);
                    } while (this != null);
                    return obj;
                }
            }
        }
    }

    /* renamed from: k */
    public final C11095l<E> m66788k(int i10, int i11) {
        long j10;
        int i12;
        do {
            j10 = this._state;
            i12 = (int) (1073741823 & j10);
            if ((1152921504606846976L & j10) != 0) {
                return m66786i();
            }
        } while (!f52321g.compareAndSet(this, j10, f52319e.m66790b(j10, i11)));
        this.f52326d.set(this.f52325c & i12, null);
        return null;
    }
}
