package p300fx;

import java.security.InvalidKeyException;
import p319gx.C10058a;
import p319gx.C10059b;
import p319gx.C10060c;
import p349hx.C10356a;
import p376ix.C10631a;
import p502nx.EnumC11761a;

/* renamed from: fx.b */
/* loaded from: classes9.dex */
public class C9780b {
    /* renamed from: a */
    public static byte[] m60845a(byte[] bArr, char[] cArr, EnumC11761a enumC11761a, boolean z10) throws C10631a {
        C10059b c10059b = new C10059b(new C10060c("HmacSHA1", "ISO-8859-1", bArr, 1000));
        int iM70086e = enumC11761a.m70086e();
        int iM70087f = enumC11761a.m70087f();
        int i10 = iM70086e + iM70087f + 2;
        byte[] bArrM62538f = c10059b.m62538f(cArr, i10, z10);
        if (bArrM62538f == null || bArrM62538f.length != i10) {
            throw new C10631a(String.format("Derived Key invalid for Key Length [%d] MAC Length [%d]", Integer.valueOf(iM70086e), Integer.valueOf(iM70087f)));
        }
        return bArrM62538f;
    }

    /* renamed from: b */
    public static byte[] m60846b(byte[] bArr, EnumC11761a enumC11761a) {
        byte[] bArr2 = new byte[2];
        System.arraycopy(bArr, enumC11761a.m70086e() + enumC11761a.m70087f(), bArr2, 0, 2);
        return bArr2;
    }

    /* renamed from: c */
    public static C10356a m60847c(byte[] bArr, EnumC11761a enumC11761a) throws C10631a {
        int iM70086e = enumC11761a.m70086e();
        byte[] bArr2 = new byte[iM70086e];
        System.arraycopy(bArr, 0, bArr2, 0, iM70086e);
        return new C10356a(bArr2);
    }

    /* renamed from: d */
    public static C10058a m60848d(byte[] bArr, EnumC11761a enumC11761a) throws InvalidKeyException {
        int iM70087f = enumC11761a.m70087f();
        byte[] bArr2 = new byte[iM70087f];
        System.arraycopy(bArr, enumC11761a.m70086e(), bArr2, 0, iM70087f);
        C10058a c10058a = new C10058a("HmacSHA1");
        c10058a.mo62528c(bArr2);
        return c10058a;
    }

    /* renamed from: e */
    public static void m60849e(byte[] bArr, int i10) {
        bArr[0] = (byte) i10;
        bArr[1] = (byte) (i10 >> 8);
        bArr[2] = (byte) (i10 >> 16);
        bArr[3] = (byte) (i10 >> 24);
        for (int i11 = 4; i11 <= 15; i11++) {
            bArr[i11] = 0;
        }
    }
}
