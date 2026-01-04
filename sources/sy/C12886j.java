package sy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import p271ez.C9575a;

/* renamed from: sy.j */
/* loaded from: classes9.dex */
public class C12886j extends AbstractC12885i {

    /* renamed from: c */
    public static final AbstractC12890n f58668c = new a(C12886j.class, 13);

    /* renamed from: d */
    public static final ConcurrentMap<Object, C12886j> f58669d = new ConcurrentHashMap();

    /* renamed from: a */
    public final byte[] f58670a;

    /* renamed from: b */
    public String f58671b;

    /* renamed from: sy.j$a */
    public static class a extends AbstractC12890n {
        public a(Class cls, int i10) {
            super(cls, i10);
        }
    }

    /* renamed from: i */
    public static void m77304i(String str) {
        if (str == null) {
            throw new NullPointerException("'identifier' cannot be null");
        }
        if (str.length() > 16383) {
            throw new IllegalArgumentException("exceeded relative OID contents length limit");
        }
        if (m77305k(str, 0)) {
            return;
        }
        throw new IllegalArgumentException("string " + str + " not a valid relative OID");
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0022, code lost:
    
        return false;
     */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m77305k(java.lang.String r8, int r9) {
        /*
            int r0 = r8.length()
            r1 = 0
            r2 = r1
        L6:
            int r3 = r0 + (-1)
            r4 = 48
            r5 = 1
            if (r3 < r9) goto L2e
            char r6 = r8.charAt(r3)
            r7 = 46
            if (r6 != r7) goto L23
            if (r2 == 0) goto L22
            if (r2 <= r5) goto L20
            char r0 = r8.charAt(r0)
            if (r0 != r4) goto L20
            goto L22
        L20:
            r2 = r1
            goto L2b
        L22:
            return r1
        L23:
            if (r4 > r6) goto L2d
            r0 = 57
            if (r6 > r0) goto L2d
            int r2 = r2 + 1
        L2b:
            r0 = r3
            goto L6
        L2d:
            return r1
        L2e:
            if (r2 == 0) goto L3a
            if (r2 <= r5) goto L39
            char r8 = r8.charAt(r0)
            if (r8 != r4) goto L39
            goto L3a
        L39:
            return r5
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sy.C12886j.m77305k(java.lang.String, int):boolean");
    }

    /* renamed from: l */
    public static String m77306l(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z10 = true;
        BigInteger bigIntegerShiftLeft = null;
        long j10 = 0;
        for (int i10 = 0; i10 != bArr.length; i10++) {
            byte b10 = bArr[i10];
            if (j10 <= 72057594037927808L) {
                long j11 = j10 + (b10 & 127);
                if ((b10 & 128) == 0) {
                    if (z10) {
                        z10 = false;
                    } else {
                        stringBuffer.append('.');
                    }
                    stringBuffer.append(j11);
                    j10 = 0;
                } else {
                    j10 = j11 << 7;
                }
            } else {
                if (bigIntegerShiftLeft == null) {
                    bigIntegerShiftLeft = BigInteger.valueOf(j10);
                }
                BigInteger bigIntegerOr = bigIntegerShiftLeft.or(BigInteger.valueOf(b10 & 127));
                if ((b10 & 128) == 0) {
                    if (z10) {
                        z10 = false;
                    } else {
                        stringBuffer.append('.');
                    }
                    stringBuffer.append(bigIntegerOr);
                    bigIntegerShiftLeft = null;
                    j10 = 0;
                } else {
                    bigIntegerShiftLeft = bigIntegerOr.shiftLeft(7);
                }
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: m */
    public static byte[] m77307m(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C12895s c12895s = new C12895s(str);
        while (c12895s.m77313a()) {
            String strM77314b = c12895s.m77314b();
            if (strM77314b.length() <= 18) {
                m77308n(byteArrayOutputStream, Long.parseLong(strM77314b));
            } else {
                m77309o(byteArrayOutputStream, new BigInteger(strM77314b));
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: n */
    public static void m77308n(ByteArrayOutputStream byteArrayOutputStream, long j10) {
        byte[] bArr = new byte[9];
        int i10 = 8;
        bArr[8] = (byte) (((int) j10) & 127);
        while (j10 >= 128) {
            j10 >>= 7;
            i10--;
            bArr[i10] = (byte) (((int) j10) | 128);
        }
        byteArrayOutputStream.write(bArr, i10, 9 - i10);
    }

    /* renamed from: o */
    public static void m77309o(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int iBitLength = (bigInteger.bitLength() + 6) / 7;
        if (iBitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] bArr = new byte[iBitLength];
        int i10 = iBitLength - 1;
        for (int i11 = i10; i11 >= 0; i11--) {
            bArr[i11] = (byte) (bigInteger.intValue() | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        bArr[i10] = (byte) (bArr[i10] & 127);
        byteArrayOutputStream.write(bArr, 0, iBitLength);
    }

    @Override // sy.AbstractC12885i
    /* renamed from: c */
    public boolean mo77271c(AbstractC12885i abstractC12885i) {
        if (this == abstractC12885i) {
            return true;
        }
        if (abstractC12885i instanceof C12886j) {
            return C9575a.m59758a(this.f58670a, ((C12886j) abstractC12885i).f58670a);
        }
        return false;
    }

    @Override // sy.AbstractC12885i
    /* renamed from: d */
    public void mo77279d(C12883g c12883g, boolean z10) throws IOException {
        c12883g.m77298i(z10, 13, this.f58670a);
    }

    @Override // sy.AbstractC12885i
    /* renamed from: f */
    public int mo77280f(boolean z10) {
        return C12883g.m77292e(z10, this.f58670a.length);
    }

    @Override // sy.AbstractC12885i, sy.AbstractC12881e
    public int hashCode() {
        return C9575a.m59763f(this.f58670a);
    }

    /* renamed from: j */
    public synchronized String m77310j() {
        try {
            if (this.f58671b == null) {
                this.f58671b = m77306l(this.f58670a);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f58671b;
    }

    public String toString() {
        return m77310j();
    }
}
