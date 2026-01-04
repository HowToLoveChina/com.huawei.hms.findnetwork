package az;

import java.math.BigInteger;
import uy.InterfaceC13288b;

/* renamed from: az.c */
/* loaded from: classes9.dex */
public class C1079c implements InterfaceC13288b {

    /* renamed from: a */
    public BigInteger f5191a;

    /* renamed from: b */
    public BigInteger f5192b;

    /* renamed from: c */
    public BigInteger f5193c;

    /* renamed from: d */
    public C1080d f5194d;

    public C1079c(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, C1080d c1080d) {
        this.f5191a = bigInteger3;
        this.f5193c = bigInteger;
        this.f5192b = bigInteger2;
        this.f5194d = c1080d;
    }

    /* renamed from: a */
    public BigInteger m6449a() {
        return this.f5191a;
    }

    /* renamed from: b */
    public BigInteger m6450b() {
        return this.f5193c;
    }

    /* renamed from: c */
    public BigInteger m6451c() {
        return this.f5192b;
    }

    /* renamed from: d */
    public C1080d m6452d() {
        return this.f5194d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1079c)) {
            return false;
        }
        C1079c c1079c = (C1079c) obj;
        return c1079c.m6450b().equals(this.f5193c) && c1079c.m6451c().equals(this.f5192b) && c1079c.m6449a().equals(this.f5191a);
    }

    public int hashCode() {
        return m6449a().hashCode() ^ (m6450b().hashCode() ^ m6451c().hashCode());
    }
}
