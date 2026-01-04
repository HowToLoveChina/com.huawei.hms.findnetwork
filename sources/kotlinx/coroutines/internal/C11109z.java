package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlinx.coroutines.internal.InterfaceC11083a0;
import p692uw.C13267j;

/* renamed from: kotlinx.coroutines.internal.z */
/* loaded from: classes9.dex */
public class C11109z<T extends InterfaceC11083a0 & Comparable<? super T>> {
    private volatile /* synthetic */ int _size = 0;

    /* renamed from: a */
    public T[] f52341a;

    /* renamed from: a */
    public final void m66823a(T t10) {
        t10.mo7803a(this);
        InterfaceC11083a0[] interfaceC11083a0ArrM66828f = m66828f();
        int iM66825c = m66825c();
        m66832j(iM66825c + 1);
        interfaceC11083a0ArrM66828f[iM66825c] = t10;
        t10.mo7805h(iM66825c);
        m66834l(iM66825c);
    }

    /* renamed from: b */
    public final T m66824b() {
        T[] tArr = this.f52341a;
        if (tArr == null) {
            return null;
        }
        return tArr[0];
    }

    /* renamed from: c */
    public final int m66825c() {
        return this._size;
    }

    /* renamed from: d */
    public final boolean m66826d() {
        return m66825c() == 0;
    }

    /* renamed from: e */
    public final T m66827e() {
        T t10;
        synchronized (this) {
            t10 = (T) m66824b();
        }
        return t10;
    }

    /* renamed from: f */
    public final T[] m66828f() {
        T[] tArr = this.f52341a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new InterfaceC11083a0[4];
            this.f52341a = tArr2;
            return tArr2;
        }
        if (m66825c() < tArr.length) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, m66825c() * 2);
        C13267j.m79676d(objArrCopyOf, "copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((InterfaceC11083a0[]) objArrCopyOf);
        this.f52341a = tArr3;
        return tArr3;
    }

    /* renamed from: g */
    public final boolean m66829g(T t10) {
        boolean z10;
        synchronized (this) {
            if (t10.mo7804f() == null) {
                z10 = false;
            } else {
                m66830h(t10.mo7806k());
                z10 = true;
            }
        }
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003a  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final T m66830h(int r6) {
        /*
            r5 = this;
            T extends kotlinx.coroutines.internal.a0 & java.lang.Comparable<? super T>[] r0 = r5.f52341a
            p692uw.C13267j.m79674b(r0)
            int r1 = r5.m66825c()
            r2 = -1
            int r1 = r1 + r2
            r5.m66832j(r1)
            int r1 = r5.m66825c()
            if (r6 >= r1) goto L3d
            int r1 = r5.m66825c()
            r5.m66835m(r6, r1)
            int r1 = r6 + (-1)
            int r1 = r1 / 2
            if (r6 <= 0) goto L3a
            r3 = r0[r6]
            p692uw.C13267j.m79674b(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r0[r1]
            p692uw.C13267j.m79674b(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L3a
            r5.m66835m(r6, r1)
            r5.m66834l(r1)
            goto L3d
        L3a:
            r5.m66833k(r6)
        L3d:
            int r6 = r5.m66825c()
            r6 = r0[r6]
            p692uw.C13267j.m79674b(r6)
            r1 = 0
            r6.mo7803a(r1)
            r6.mo7805h(r2)
            int r5 = r5.m66825c()
            r0[r5] = r1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.C11109z.m66830h(int):kotlinx.coroutines.internal.a0");
    }

    /* renamed from: i */
    public final T m66831i() {
        T t10;
        synchronized (this) {
            t10 = m66825c() > 0 ? (T) m66830h(0) : null;
        }
        return t10;
    }

    /* renamed from: j */
    public final void m66832j(int i10) {
        this._size = i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m66833k(int r6) {
        /*
            r5 = this;
        L0:
            int r0 = r6 * 2
            int r1 = r0 + 1
            int r2 = r5.m66825c()
            if (r1 < r2) goto Lb
            return
        Lb:
            T extends kotlinx.coroutines.internal.a0 & java.lang.Comparable<? super T>[] r2 = r5.f52341a
            p692uw.C13267j.m79674b(r2)
            int r0 = r0 + 2
            int r3 = r5.m66825c()
            if (r0 >= r3) goto L2b
            r3 = r2[r0]
            p692uw.C13267j.m79674b(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r2[r1]
            p692uw.C13267j.m79674b(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L2b
            goto L2c
        L2b:
            r0 = r1
        L2c:
            r1 = r2[r6]
            p692uw.C13267j.m79674b(r1)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            r2 = r2[r0]
            p692uw.C13267j.m79674b(r2)
            int r1 = r1.compareTo(r2)
            if (r1 > 0) goto L3f
            return
        L3f:
            r5.m66835m(r6, r0)
            r6 = r0
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.C11109z.m66833k(int):void");
    }

    /* renamed from: l */
    public final void m66834l(int i10) {
        while (i10 > 0) {
            T[] tArr = this.f52341a;
            C13267j.m79674b(tArr);
            int i11 = (i10 - 1) / 2;
            T t10 = tArr[i11];
            C13267j.m79674b(t10);
            T t11 = tArr[i10];
            C13267j.m79674b(t11);
            if (((Comparable) t10).compareTo(t11) <= 0) {
                return;
            }
            m66835m(i10, i11);
            i10 = i11;
        }
    }

    /* renamed from: m */
    public final void m66835m(int i10, int i11) {
        T[] tArr = this.f52341a;
        C13267j.m79674b(tArr);
        T t10 = tArr[i11];
        C13267j.m79674b(t10);
        T t11 = tArr[i10];
        C13267j.m79674b(t11);
        tArr[i10] = t10;
        tArr[i11] = t11;
        t10.mo7805h(i10);
        t11.mo7805h(i11);
    }
}
