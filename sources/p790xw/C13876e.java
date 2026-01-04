package p790xw;

/* renamed from: xw.e */
/* loaded from: classes9.dex */
public final class C13876e {

    /* renamed from: a */
    public final float f62168a;

    /* renamed from: b */
    public final float f62169b;

    /* renamed from: a */
    public boolean m83215a() {
        return this.f62168a > this.f62169b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C13876e) {
            if (!m83215a() || !((C13876e) obj).m83215a()) {
                C13876e c13876e = (C13876e) obj;
                if (this.f62168a != c13876e.f62168a || this.f62169b != c13876e.f62169b) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (m83215a()) {
            return -1;
        }
        return Float.hashCode(this.f62169b) + (Float.hashCode(this.f62168a) * 31);
    }

    public String toString() {
        return this.f62168a + ".." + this.f62169b;
    }
}
