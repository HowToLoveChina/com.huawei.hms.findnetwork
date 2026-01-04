package p790xw;

import p692uw.C13264g;
import p692uw.C13267j;

/* renamed from: xw.c */
/* loaded from: classes9.dex */
public final class C13874c extends C13872a {

    /* renamed from: e */
    public static final a f62164e = new a(null);

    /* renamed from: f */
    public static final C13874c f62165f = new C13874c(1, 0);

    /* renamed from: xw.c$a */
    public static final class a {
        public /* synthetic */ a(C13264g c13264g) {
            this();
        }

        public a() {
        }
    }

    public C13874c(char c10, char c11) {
        super(c10, c11, 1);
    }

    public boolean equals(Object obj) {
        if (obj instanceof C13874c) {
            if (!isEmpty() || !((C13874c) obj).isEmpty()) {
                C13874c c13874c = (C13874c) obj;
                if (m83211a() != c13874c.m83211a() || m83212b() != c13874c.m83212b()) {
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
        return m83212b() + (m83211a() * 31);
    }

    public boolean isEmpty() {
        return C13267j.m79678f(m83211a(), m83212b()) > 0;
    }

    public String toString() {
        return m83211a() + ".." + m83212b();
    }
}
