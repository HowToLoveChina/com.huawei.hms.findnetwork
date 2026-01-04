package p790xw;

import p692uw.C13264g;

/* renamed from: xw.k */
/* loaded from: classes9.dex */
public final class C13882k extends C13880i {

    /* renamed from: e */
    public static final a f62188e = new a(null);

    /* renamed from: f */
    public static final C13882k f62189f = new C13882k(1, 0);

    /* renamed from: xw.k$a */
    public static final class a {
        public /* synthetic */ a(C13264g c13264g) {
            this();
        }

        public a() {
        }
    }

    public C13882k(long j10, long j11) {
        super(j10, j11, 1L);
    }

    public boolean equals(Object obj) {
        if (obj instanceof C13882k) {
            if (!isEmpty() || !((C13882k) obj).isEmpty()) {
                C13882k c13882k = (C13882k) obj;
                if (m83226a() != c13882k.m83226a() || m83227b() != c13882k.m83227b()) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (m83226a() ^ (m83226a() >>> 32))) + (m83227b() ^ (m83227b() >>> 32)));
    }

    public boolean isEmpty() {
        return m83226a() > m83227b();
    }

    public String toString() {
        return m83226a() + ".." + m83227b();
    }
}
