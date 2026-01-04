package p790xw;

import kw.AbstractC11199z;
import p692uw.C13264g;
import pw.C12241c;

/* renamed from: xw.f */
/* loaded from: classes9.dex */
public class C13877f implements Iterable<Integer> {

    /* renamed from: d */
    public static final a f62170d = new a(null);

    /* renamed from: a */
    public final int f62171a;

    /* renamed from: b */
    public final int f62172b;

    /* renamed from: c */
    public final int f62173c;

    /* renamed from: xw.f$a */
    public static final class a {
        public /* synthetic */ a(C13264g c13264g) {
            this();
        }

        /* renamed from: a */
        public final C13877f m83220a(int i10, int i11, int i12) {
            return new C13877f(i10, i11, i12);
        }

        public a() {
        }
    }

    public C13877f(int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i12 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f62171a = i10;
        this.f62172b = C12241c.m73443c(i10, i11, i12);
        this.f62173c = i12;
    }

    /* renamed from: a */
    public final int m83216a() {
        return this.f62171a;
    }

    /* renamed from: b */
    public final int m83217b() {
        return this.f62172b;
    }

    /* renamed from: c */
    public final int m83218c() {
        return this.f62173c;
    }

    @Override // java.lang.Iterable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public AbstractC11199z iterator() {
        return new C13878g(this.f62171a, this.f62172b, this.f62173c);
    }

    public boolean equals(Object obj) {
        if (obj instanceof C13877f) {
            if (!isEmpty() || !((C13877f) obj).isEmpty()) {
                C13877f c13877f = (C13877f) obj;
                if (this.f62171a != c13877f.f62171a || this.f62172b != c13877f.f62172b || this.f62173c != c13877f.f62173c) {
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
        return this.f62173c + (((this.f62171a * 31) + this.f62172b) * 31);
    }

    public boolean isEmpty() {
        if (this.f62173c > 0) {
            if (this.f62171a <= this.f62172b) {
                return false;
            }
        } else if (this.f62171a >= this.f62172b) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb2;
        int i10;
        if (this.f62173c > 0) {
            sb2 = new StringBuilder();
            sb2.append(this.f62171a);
            sb2.append("..");
            sb2.append(this.f62172b);
            sb2.append(" step ");
            i10 = this.f62173c;
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.f62171a);
            sb2.append(" downTo ");
            sb2.append(this.f62172b);
            sb2.append(" step ");
            i10 = -this.f62173c;
        }
        sb2.append(i10);
        return sb2.toString();
    }
}
