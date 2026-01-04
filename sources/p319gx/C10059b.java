package p319gx;

import p594qx.C12427f;

/* renamed from: gx.b */
/* loaded from: classes9.dex */
public class C10059b {

    /* renamed from: a */
    public C10060c f49062a;

    /* renamed from: b */
    public InterfaceC10061d f49063b;

    public C10059b(C10060c c10060c) {
        this(c10060c, null);
    }

    /* renamed from: a */
    public void m62533a(byte[] bArr, int i10, int i11) {
        bArr[i10] = (byte) (i11 / 16777216);
        bArr[i10 + 1] = (byte) (i11 / 65536);
        bArr[i10 + 2] = (byte) (i11 / 256);
        bArr[i10 + 3] = (byte) i11;
    }

    /* renamed from: b */
    public final byte[] m62534b(InterfaceC10061d interfaceC10061d, byte[] bArr, int i10, int i11) {
        byte[] bArr2 = bArr == null ? new byte[0] : bArr;
        int iMo62527b = interfaceC10061d.mo62527b();
        int iM62537e = m62537e(i11, iMo62527b);
        int i12 = i11 - ((iM62537e - 1) * iMo62527b);
        byte[] bArr3 = new byte[iM62537e * iMo62527b];
        int i13 = 0;
        for (int i14 = 1; i14 <= iM62537e; i14++) {
            m62535c(bArr3, i13, interfaceC10061d, bArr2, i10, i14);
            i13 += iMo62527b;
        }
        if (i12 >= iMo62527b) {
            return bArr3;
        }
        byte[] bArr4 = new byte[i11];
        System.arraycopy(bArr3, 0, bArr4, 0, i11);
        return bArr4;
    }

    /* renamed from: c */
    public final void m62535c(byte[] bArr, int i10, InterfaceC10061d interfaceC10061d, byte[] bArr2, int i11, int i12) {
        int iMo62527b = interfaceC10061d.mo62527b();
        byte[] bArr3 = new byte[iMo62527b];
        byte[] bArrMo62526a = new byte[bArr2.length + 4];
        System.arraycopy(bArr2, 0, bArrMo62526a, 0, bArr2.length);
        m62533a(bArrMo62526a, bArr2.length, i12);
        for (int i13 = 0; i13 < i11; i13++) {
            bArrMo62526a = interfaceC10061d.mo62526a(bArrMo62526a);
            m62539g(bArr3, bArrMo62526a);
        }
        System.arraycopy(bArr3, 0, bArr, i10, iMo62527b);
    }

    /* renamed from: d */
    public final void m62536d(byte[] bArr) {
        if (this.f49063b == null) {
            this.f49063b = new C10058a(this.f49062a.m62540a());
        }
        this.f49063b.mo62528c(bArr);
    }

    /* renamed from: e */
    public final int m62537e(int i10, int i11) {
        return (i10 / i11) + (i10 % i11 > 0 ? 1 : 0);
    }

    /* renamed from: f */
    public byte[] m62538f(char[] cArr, int i10, boolean z10) {
        cArr.getClass();
        m62536d(C12427f.m74611a(cArr, z10));
        if (i10 == 0) {
            i10 = this.f49063b.mo62527b();
        }
        return m62534b(this.f49063b, this.f49062a.m62542c(), this.f49062a.m62541b(), i10);
    }

    /* renamed from: g */
    public final void m62539g(byte[] bArr, byte[] bArr2) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
        }
    }

    public C10059b(C10060c c10060c, InterfaceC10061d interfaceC10061d) {
        this.f49062a = c10060c;
        this.f49063b = interfaceC10061d;
    }
}
