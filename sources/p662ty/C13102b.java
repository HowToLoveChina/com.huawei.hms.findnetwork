package p662ty;

import java.math.BigInteger;
import sy.AbstractC12881e;
import sy.AbstractC12885i;
import sy.C12879c;
import sy.C12880d;
import sy.C12893q;

/* renamed from: ty.b */
/* loaded from: classes9.dex */
public class C13102b extends AbstractC12881e implements InterfaceC13105e {

    /* renamed from: d */
    public static final BigInteger f59505d = BigInteger.valueOf(1);

    /* renamed from: a */
    public BigInteger f59506a;

    /* renamed from: b */
    public BigInteger f59507b;

    /* renamed from: c */
    public byte[] f59508c;

    @Override // sy.AbstractC12881e, sy.InterfaceC12878b
    /* renamed from: a */
    public AbstractC12885i mo77274a() {
        C12879c c12879c = new C12879c(6);
        c12879c.m77276a(new C12880d(f59505d));
        c12879c.m77276a(null);
        c12879c.m77276a(new C13101a(null, this.f59508c));
        c12879c.m77276a(null);
        c12879c.m77276a(new C12880d(this.f59506a));
        if (this.f59507b != null) {
            c12879c.m77276a(new C12880d(this.f59507b));
        }
        return new C12893q(c12879c);
    }
}
