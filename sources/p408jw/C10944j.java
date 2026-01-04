package p408jw;

import com.huawei.hms.network.embedded.C5929g4;
import java.io.Serializable;
import p692uw.C13267j;

/* renamed from: jw.j */
/* loaded from: classes9.dex */
public final class C10944j<A, B> implements Serializable {

    /* renamed from: a */
    public final A f51853a;

    /* renamed from: b */
    public final B f51854b;

    public C10944j(A a10, B b10) {
        this.f51853a = a10;
        this.f51854b = b10;
    }

    /* renamed from: b */
    public final A m66066b() {
        return this.f51853a;
    }

    /* renamed from: c */
    public final B m66067c() {
        return this.f51854b;
    }

    /* renamed from: d */
    public final A m66068d() {
        return this.f51853a;
    }

    /* renamed from: e */
    public final B m66069e() {
        return this.f51854b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C10944j)) {
            return false;
        }
        C10944j c10944j = (C10944j) obj;
        return C13267j.m79673a(this.f51853a, c10944j.f51853a) && C13267j.m79673a(this.f51854b, c10944j.f51854b);
    }

    public int hashCode() {
        A a10 = this.f51853a;
        int iHashCode = (a10 == null ? 0 : a10.hashCode()) * 31;
        B b10 = this.f51854b;
        return iHashCode + (b10 != null ? b10.hashCode() : 0);
    }

    public String toString() {
        return C5929g4.f26849k + this.f51853a + ", " + this.f51854b + C5929g4.f26850l;
    }
}
