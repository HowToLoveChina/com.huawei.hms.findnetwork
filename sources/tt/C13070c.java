package tt;

import p623rt.InterfaceC12626c;

/* renamed from: tt.c */
/* loaded from: classes5.dex */
public class C13070c implements InterfaceC12626c {
    @Override // p623rt.InterfaceC12626c
    /* renamed from: a */
    public double mo76146a(double[] dArr, double[] dArr2) throws C13069b {
        if (dArr == null || dArr2 == null || dArr.length != dArr2.length) {
            throw new C13069b("checkEqualLength error", new Object[0]);
        }
        double d10 = 0.0d;
        for (int i10 = 0; i10 < dArr.length; i10++) {
            double d11 = dArr[i10] - dArr2[i10];
            d10 += d11 * d11;
        }
        return Math.sqrt(d10);
    }
}
