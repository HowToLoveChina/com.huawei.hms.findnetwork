package sy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import p271ez.C9575a;

/* renamed from: sy.f */
/* loaded from: classes9.dex */
public class C12882f extends AbstractC12885i {

    /* renamed from: c */
    public static final AbstractC12890n f58662c = new a(C12882f.class, 6);

    /* renamed from: d */
    public static final ConcurrentMap<Object, C12882f> f58663d = new ConcurrentHashMap();

    /* renamed from: a */
    public final byte[] f58664a;

    /* renamed from: b */
    public String f58665b;

    /* renamed from: sy.f$a */
    public static class a extends AbstractC12890n {
        public a(Class cls, int i10) {
            super(cls, i10);
        }
    }

    public C12882f(String str) {
        m77284k(str);
        byte[] bArrM77287o = m77287o(str);
        m77283j(bArrM77287o.length);
        this.f58664a = bArrM77287o;
        this.f58665b = str;
    }

    /* renamed from: j */
    public static void m77283j(int i10) {
        if (i10 > 4096) {
            throw new IllegalArgumentException("exceeded OID contents length limit");
        }
    }

    /* renamed from: k */
    public static void m77284k(String str) {
        if (str == null) {
            throw new NullPointerException("'identifier' cannot be null");
        }
        if (str.length() > 16385) {
            throw new IllegalArgumentException("exceeded OID contents length limit");
        }
        if (m77285m(str)) {
            return;
        }
        throw new IllegalArgumentException("string " + str + " not a valid OID");
    }

    /* renamed from: m */
    public static boolean m77285m(String str) {
        char cCharAt;
        if (str.length() < 3 || str.charAt(1) != '.' || (cCharAt = str.charAt(0)) < '0' || cCharAt > '2' || !C12886j.m77305k(str, 2)) {
            return false;
        }
        if (cCharAt == '2' || str.length() == 3 || str.charAt(3) == '.') {
            return true;
        }
        return (str.length() == 4 || str.charAt(4) == '.') && str.charAt(2) < '4';
    }

    /* renamed from: n */
    private static String m77286n(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = true;
        BigInteger bigIntegerShiftLeft = null;
        long j10 = 0;
        for (int i10 = 0; i10 != bArr.length; i10++) {
            byte b10 = bArr[i10];
            if (j10 <= 72057594037927808L) {
                long j11 = j10 + (b10 & 127);
                if ((b10 & 128) == 0) {
                    if (z10) {
                        if (j11 < 40) {
                            sb2.append('0');
                        } else if (j11 < 80) {
                            sb2.append('1');
                            j11 -= 40;
                        } else {
                            sb2.append('2');
                            j11 -= 80;
                        }
                        z10 = false;
                    }
                    sb2.append('.');
                    sb2.append(j11);
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
                        sb2.append('2');
                        bigIntegerOr = bigIntegerOr.subtract(BigInteger.valueOf(80L));
                        z10 = false;
                    }
                    sb2.append('.');
                    sb2.append(bigIntegerOr);
                    bigIntegerShiftLeft = null;
                    j10 = 0;
                } else {
                    bigIntegerShiftLeft = bigIntegerOr.shiftLeft(7);
                }
            }
        }
        return sb2.toString();
    }

    /* renamed from: o */
    private static byte[] m77287o(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C12895s c12895s = new C12895s(str);
        int i10 = Integer.parseInt(c12895s.m77314b()) * 40;
        String strM77314b = c12895s.m77314b();
        if (strM77314b.length() <= 18) {
            C12886j.m77308n(byteArrayOutputStream, i10 + Long.parseLong(strM77314b));
        } else {
            C12886j.m77309o(byteArrayOutputStream, new BigInteger(strM77314b).add(BigInteger.valueOf(i10)));
        }
        while (c12895s.m77313a()) {
            String strM77314b2 = c12895s.m77314b();
            if (strM77314b2.length() <= 18) {
                C12886j.m77308n(byteArrayOutputStream, Long.parseLong(strM77314b2));
            } else {
                C12886j.m77309o(byteArrayOutputStream, new BigInteger(strM77314b2));
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // sy.AbstractC12885i
    /* renamed from: c */
    public boolean mo77271c(AbstractC12885i abstractC12885i) {
        if (this == abstractC12885i) {
            return true;
        }
        if (abstractC12885i instanceof C12882f) {
            return C9575a.m59758a(this.f58664a, ((C12882f) abstractC12885i).f58664a);
        }
        return false;
    }

    @Override // sy.AbstractC12885i
    /* renamed from: d */
    public void mo77279d(C12883g c12883g, boolean z10) throws IOException {
        c12883g.m77298i(z10, 6, this.f58664a);
    }

    @Override // sy.AbstractC12885i
    /* renamed from: f */
    public int mo77280f(boolean z10) {
        return C12883g.m77292e(z10, this.f58664a.length);
    }

    @Override // sy.AbstractC12885i, sy.AbstractC12881e
    public int hashCode() {
        return C9575a.m59763f(this.f58664a);
    }

    /* renamed from: i */
    public C12882f m77288i(String str) {
        C12886j.m77304i(str);
        byte[] bArrM77307m = C12886j.m77307m(str);
        m77283j(this.f58664a.length + bArrM77307m.length);
        return new C12882f(C9575a.m59760c(this.f58664a, bArrM77307m), m77289l() + "." + str);
    }

    /* renamed from: l */
    public synchronized String m77289l() {
        try {
            if (this.f58665b == null) {
                this.f58665b = m77286n(this.f58664a);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f58665b;
    }

    public String toString() {
        return m77289l();
    }

    public C12882f(byte[] bArr, String str) {
        this.f58664a = bArr;
        this.f58665b = str;
    }
}
