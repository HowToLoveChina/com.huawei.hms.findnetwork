package az;

import java.math.BigInteger;
import p271ez.C9579e;
import uy.InterfaceC13288b;

/* renamed from: az.a */
/* loaded from: classes9.dex */
public class C1077a implements InterfaceC13288b {

    /* renamed from: a */
    public BigInteger f5182a;

    /* renamed from: b */
    public BigInteger f5183b;

    /* renamed from: c */
    public BigInteger f5184c;

    /* renamed from: d */
    public BigInteger f5185d;

    /* renamed from: e */
    public int f5186e;

    /* renamed from: f */
    public int f5187f;

    /* renamed from: g */
    public C1078b f5188g;

    public C1077a(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i10, int i11, BigInteger bigInteger4, C1078b c1078b) {
        if (i11 != 0) {
            if (i11 > bigInteger.bitLength()) {
                throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
            }
            if (i11 < i10) {
                throw new IllegalArgumentException("when l value specified, it may not be less than m value");
            }
        }
        if (i10 > bigInteger.bitLength() && !C9579e.m59775b("org.bouncycastle.dh.allow_unsafe_p_value")) {
            throw new IllegalArgumentException("unsafe p value so small specific l required");
        }
        this.f5182a = bigInteger2;
        this.f5183b = bigInteger;
        this.f5184c = bigInteger3;
        this.f5186e = i10;
        this.f5187f = i11;
        this.f5185d = bigInteger4;
        this.f5188g = c1078b;
    }

    /* renamed from: a */
    public BigInteger m6446a() {
        return this.f5182a;
    }

    /* renamed from: b */
    public BigInteger m6447b() {
        return this.f5183b;
    }

    /* renamed from: c */
    public BigInteger m6448c() {
        return this.f5184c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1077a)) {
            return false;
        }
        C1077a c1077a = (C1077a) obj;
        if (m6448c() != null) {
            if (!m6448c().equals(c1077a.m6448c())) {
                return false;
            }
        } else if (c1077a.m6448c() != null) {
            return false;
        }
        return c1077a.m6447b().equals(this.f5183b) && c1077a.m6446a().equals(this.f5182a);
    }

    public int hashCode() {
        return (m6448c() != null ? m6448c().hashCode() : 0) ^ (m6447b().hashCode() ^ m6446a().hashCode());
    }
}
