package p790xw;

import p692uw.C13264g;

/* renamed from: xw.h */
/* loaded from: classes9.dex */
public final class C13879h extends C13877f {

    /* renamed from: e */
    public static final a f62178e = new a(null);

    /* renamed from: f */
    public static final C13879h f62179f = new C13879h(1, 0);

    /* renamed from: xw.h$a */
    public static final class a {
        public /* synthetic */ a(C13264g c13264g) {
            this();
        }

        /* renamed from: a */
        public final C13879h m83225a() {
            return C13879h.f62179f;
        }

        public a() {
        }
    }

    public C13879h(int i10, int i11) {
        super(i10, i11, 1);
    }

    @Override // p790xw.C13877f
    public boolean equals(Object obj) {
        if (obj instanceof C13879h) {
            if (!isEmpty() || !((C13879h) obj).isEmpty()) {
                C13879h c13879h = (C13879h) obj;
                if (m83216a() != c13879h.m83216a() || m83217b() != c13879h.m83217b()) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public boolean m83222f(int i10) {
        return m83216a() <= i10 && i10 <= m83217b();
    }

    /* renamed from: g */
    public Integer m83223g() {
        return Integer.valueOf(m83217b());
    }

    /* renamed from: h */
    public Integer m83224h() {
        return Integer.valueOf(m83216a());
    }

    @Override // p790xw.C13877f
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return m83217b() + (m83216a() * 31);
    }

    @Override // p790xw.C13877f
    public boolean isEmpty() {
        return m83216a() > m83217b();
    }

    @Override // p790xw.C13877f
    public String toString() {
        return m83216a() + ".." + m83217b();
    }
}
