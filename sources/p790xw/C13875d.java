package p790xw;

/* renamed from: xw.d */
/* loaded from: classes9.dex */
public final class C13875d {

    /* renamed from: a */
    public final double f62166a;

    /* renamed from: b */
    public final double f62167b;

    /* renamed from: a */
    public boolean m83214a() {
        return this.f62166a > this.f62167b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C13875d) {
            if (!m83214a() || !((C13875d) obj).m83214a()) {
                C13875d c13875d = (C13875d) obj;
                if (this.f62166a != c13875d.f62166a || this.f62167b != c13875d.f62167b) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (m83214a()) {
            return -1;
        }
        return Double.hashCode(this.f62167b) + (Double.hashCode(this.f62166a) * 31);
    }

    public String toString() {
        return this.f62166a + ".." + this.f62167b;
    }
}
