package gy;

import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ly.C11377k;
import my.C11562e;
import p350hy.AbstractC10361d;
import p350hy.InterfaceC10359b;

/* renamed from: gy.j */
/* loaded from: classes9.dex */
public class C10071j {

    /* renamed from: a */
    public static final InterfaceC10359b f49135a = AbstractC10361d.m63786c(Charset.defaultCharset());

    /* renamed from: b */
    public static final InterfaceC10359b f49136b = new a();

    /* renamed from: gy.j$a */
    public class a implements InterfaceC10359b {
        @Override // p350hy.InterfaceC10359b
        /* renamed from: a */
        public String mo62690a(byte[] bArr) {
            StringBuilder sb2 = new StringBuilder(bArr.length);
            for (byte b10 : bArr) {
                if (b10 == 0) {
                    break;
                }
                sb2.append((char) (b10 & 255));
            }
            return sb2.toString();
        }

        @Override // p350hy.InterfaceC10359b
        /* renamed from: b */
        public ByteBuffer mo62691b(String str) {
            int length = str.length();
            byte[] bArr = new byte[length];
            for (int i10 = 0; i10 < length; i10++) {
                bArr[i10] = (byte) str.charAt(i10);
            }
            return ByteBuffer.wrap(bArr);
        }

        @Override // p350hy.InterfaceC10359b
        /* renamed from: c */
        public boolean mo62692c(String str) {
            return true;
        }
    }

    /* renamed from: a */
    public static long m62666a(byte[] bArr) {
        long j10 = 0;
        for (byte b10 : bArr) {
            j10 += b10 & 255;
        }
        return j10;
    }

    /* renamed from: b */
    public static String m62667b(byte[] bArr, int i10, int i11, int i12, byte b10) {
        return "Invalid byte " + ((int) b10) + " at offset " + (i12 - i10) + " in '" + new String(bArr, i10, i11, Charset.defaultCharset()).replace("\u0000", "{NUL}") + "' len=" + i11;
    }

    /* renamed from: c */
    public static void m62668c(long j10, byte[] bArr, int i10, int i11, boolean z10) {
        byte[] byteArray = BigInteger.valueOf(j10).toByteArray();
        int length = byteArray.length;
        if (length > i11 - 1) {
            throw new IllegalArgumentException("Value " + j10 + " is too large for " + i11 + " byte field.");
        }
        int i12 = (i11 + i10) - length;
        System.arraycopy(byteArray, 0, bArr, i12, length);
        byte b10 = (byte) (z10 ? HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA : 0);
        while (true) {
            i10++;
            if (i10 >= i12) {
                return;
            } else {
                bArr[i10] = b10;
            }
        }
    }

    /* renamed from: d */
    public static int m62669d(long j10, byte[] bArr, int i10, int i11) {
        int i12 = i11 - 2;
        m62675j(j10, bArr, i10, i12);
        bArr[i12 + i10] = 0;
        bArr[(i11 - 1) + i10] = 32;
        return i10 + i11;
    }

    /* renamed from: e */
    public static void m62670e(long j10, byte[] bArr, int i10, int i11, boolean z10) {
        int i12 = (i11 - 1) * 8;
        long j11 = 1 << i12;
        long jAbs = Math.abs(j10);
        if (jAbs < 0 || jAbs >= j11) {
            throw new IllegalArgumentException("Value " + j10 + " is too large for " + i11 + " byte field.");
        }
        if (z10) {
            jAbs = ((jAbs ^ (j11 - 1)) + 1) | (255 << i12);
        }
        for (int i13 = (i11 + i10) - 1; i13 >= i10; i13--) {
            bArr[i13] = (byte) jAbs;
            jAbs >>= 8;
        }
    }

    /* renamed from: f */
    public static int m62671f(long j10, byte[] bArr, int i10, int i11) {
        int i12 = i11 - 1;
        m62675j(j10, bArr, i10, i12);
        bArr[i12 + i10] = 32;
        return i10 + i11;
    }

    /* renamed from: g */
    public static int m62672g(long j10, byte[] bArr, int i10, int i11) {
        long j11 = i11 == 8 ? 2097151L : 8589934591L;
        boolean z10 = j10 < 0;
        if (!z10 && j10 <= j11) {
            return m62671f(j10, bArr, i10, i11);
        }
        if (i11 < 9) {
            m62670e(j10, bArr, i10, i11, z10);
        } else {
            m62668c(j10, bArr, i10, i11, z10);
        }
        bArr[i10] = (byte) (z10 ? HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA : 128);
        return i10 + i11;
    }

    /* renamed from: h */
    public static int m62673h(String str, byte[] bArr, int i10, int i11) {
        try {
            try {
                return m62674i(str, bArr, i10, i11, f49135a);
            } catch (IOException e10) {
                throw new UncheckedIOException(e10);
            }
        } catch (IOException unused) {
            return m62674i(str, bArr, i10, i11, f49136b);
        }
    }

    /* renamed from: i */
    public static int m62674i(String str, byte[] bArr, int i10, int i11, InterfaceC10359b interfaceC10359b) throws IOException {
        int length = str.length();
        ByteBuffer byteBufferMo62691b = interfaceC10359b.mo62691b(str);
        while (byteBufferMo62691b.limit() > i11 && length > 0) {
            length--;
            byteBufferMo62691b = interfaceC10359b.mo62691b(str.substring(0, length));
        }
        int iLimit = byteBufferMo62691b.limit() - byteBufferMo62691b.position();
        System.arraycopy(byteBufferMo62691b.array(), byteBufferMo62691b.arrayOffset(), bArr, i10, iLimit);
        while (iLimit < i11) {
            bArr[i10 + iLimit] = 0;
            iLimit++;
        }
        return i10 + i11;
    }

    /* renamed from: j */
    public static void m62675j(long j10, byte[] bArr, int i10, int i11) {
        int i12;
        int i13 = i11 - 1;
        if (j10 == 0) {
            i12 = i11 - 2;
            bArr[i13 + i10] = 48;
        } else {
            long j11 = j10;
            while (i13 >= 0 && j11 != 0) {
                bArr[i10 + i13] = (byte) (((byte) (7 & j11)) + 48);
                j11 >>>= 3;
                i13--;
            }
            if (j11 != 0) {
                throw new IllegalArgumentException(j10 + "=" + Long.toOctalString(j10) + " will not fit in octal number buffer of length " + i11);
            }
            i12 = i13;
        }
        while (i12 >= 0) {
            bArr[i10 + i12] = 48;
            i12--;
        }
    }

    /* renamed from: k */
    public static long m62676k(byte[] bArr, int i10, int i11, boolean z10) {
        int i12 = i11 - 1;
        byte[] bArr2 = new byte[i12];
        System.arraycopy(bArr, i10 + 1, bArr2, 0, i12);
        BigInteger bigInteger = new BigInteger(bArr2);
        if (z10) {
            bigInteger = bigInteger.add(BigInteger.valueOf(-1L)).not();
        }
        if (bigInteger.bitLength() <= 63) {
            long jLongValue = bigInteger.longValue();
            return z10 ? -jLongValue : jLongValue;
        }
        throw new IllegalArgumentException("At offset " + i10 + ", " + i11 + " byte binary number exceeds maximum signed long value");
    }

    /* renamed from: l */
    public static long m62677l(byte[] bArr, int i10, int i11, boolean z10) {
        if (i11 >= 9) {
            throw new IllegalArgumentException("At offset " + i10 + ", " + i11 + " byte binary number exceeds maximum signed long value");
        }
        long jPow = 0;
        for (int i12 = 1; i12 < i11; i12++) {
            jPow = (jPow << 8) + (bArr[i10 + i12] & 255);
        }
        if (z10) {
            jPow = (jPow - 1) ^ (((long) Math.pow(2.0d, (i11 - 1) * 8.0d)) - 1);
        }
        return z10 ? -jPow : jPow;
    }

    /* renamed from: m */
    public static boolean m62678m(byte[] bArr, int i10) {
        return bArr[i10] == 1;
    }

    /* renamed from: n */
    public static List<C10070i> m62679n(String str) throws IOException {
        ArrayList arrayList = new ArrayList();
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length % 2 == 1) {
            throw new IOException("Corrupted TAR archive. Bad format in GNU.sparse.map PAX Header");
        }
        for (int i10 = 0; i10 < strArrSplit.length; i10 += 2) {
            long jM68235c = C11377k.m68235c(strArrSplit[i10]);
            if (jM68235c < 0) {
                throw new IOException("Corrupted TAR archive. Sparse struct offset contains negative value");
            }
            long jM68235c2 = C11377k.m68235c(strArrSplit[i10 + 1]);
            if (jM68235c2 < 0) {
                throw new IOException("Corrupted TAR archive. Sparse struct numbytes contains negative value");
            }
            arrayList.add(new C10070i(jM68235c, jM68235c2));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: o */
    public static String m62680o(byte[] bArr, int i10, int i11) {
        try {
            try {
                return m62681p(bArr, i10, i11, f49135a);
            } catch (IOException e10) {
                throw new UncheckedIOException(e10);
            }
        } catch (IOException unused) {
            return m62681p(bArr, i10, i11, f49136b);
        }
    }

    /* renamed from: p */
    public static String m62681p(byte[] bArr, int i10, int i11, InterfaceC10359b interfaceC10359b) throws IOException {
        int i12 = 0;
        for (int i13 = i10; i12 < i11 && bArr[i13] != 0; i13++) {
            i12++;
        }
        if (i12 <= 0) {
            return "";
        }
        byte[] bArr2 = new byte[i12];
        System.arraycopy(bArr, i10, bArr2, 0, i12);
        return interfaceC10359b.mo62690a(bArr2);
    }

    /* renamed from: q */
    public static long m62682q(byte[] bArr, int i10, int i11) {
        int i12 = i10 + i11;
        if (i11 < 2) {
            throw new IllegalArgumentException("Length " + i11 + " must be at least 2");
        }
        long j10 = 0;
        if (bArr[i10] == 0) {
            return 0L;
        }
        int i13 = i10;
        while (i13 < i12 && bArr[i13] == 32) {
            i13++;
        }
        byte b10 = bArr[i12 - 1];
        while (i13 < i12 && (b10 == 0 || b10 == 32)) {
            b10 = bArr[i12 - 2];
            i12--;
        }
        while (i13 < i12) {
            byte b11 = bArr[i13];
            if (b11 < 48 || b11 > 55) {
                throw new IllegalArgumentException(m62667b(bArr, i10, i11, i13, b11));
            }
            j10 = (j10 << 3) + (b11 - 48);
            i13++;
        }
        return j10;
    }

    /* renamed from: r */
    public static long m62683r(byte[] bArr, int i10, int i11) {
        byte b10 = bArr[i10];
        if ((b10 & 128) == 0) {
            return m62682q(bArr, i10, i11);
        }
        boolean z10 = b10 == -1;
        return i11 < 9 ? m62677l(bArr, i10, i11, z10) : m62676k(bArr, i10, i11, z10);
    }

    /* renamed from: s */
    public static List<C10070i> m62684s(InputStream inputStream, int i10) throws IOException {
        ArrayList arrayList = new ArrayList();
        long[] jArrM62687v = m62687v(inputStream);
        long j10 = jArrM62687v[0];
        if (j10 < 0) {
            throw new IOException("Corrupted TAR archive. Negative value in sparse headers block");
        }
        long j11 = jArrM62687v[1];
        while (true) {
            long j12 = j10 - 1;
            if (j10 <= 0) {
                long j13 = i10;
                C11562e.m69037r(inputStream, j13 - (j11 % j13));
                return arrayList;
            }
            long[] jArrM62687v2 = m62687v(inputStream);
            long j14 = jArrM62687v2[0];
            if (j14 < 0) {
                throw new IOException("Corrupted TAR archive. Sparse header block offset contains negative value");
            }
            long j15 = j11 + jArrM62687v2[1];
            long[] jArrM62687v3 = m62687v(inputStream);
            long j16 = jArrM62687v3[0];
            if (j16 < 0) {
                throw new IOException("Corrupted TAR archive. Sparse header block numbytes contains negative value");
            }
            j11 = j15 + jArrM62687v3[1];
            arrayList.add(new C10070i(j14, j16));
            j10 = j12;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x015b, code lost:
    
        throw new java.io.IOException("Failed to read Paxheader. Encountered a non-number while reading length");
     */
    /* renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.lang.String> m62685t(java.io.InputStream r16, java.util.List<gy.C10070i> r17, java.util.Map<java.lang.String, java.lang.String> r18, long r19) throws java.io.IOException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: gy.C10071j.m62685t(java.io.InputStream, java.util.List, java.util.Map, long):java.util.Map");
    }

    /* renamed from: u */
    public static C10070i m62686u(byte[] bArr, int i10) {
        return new C10070i(m62683r(bArr, i10, 12), m62683r(bArr, i10 + 12, 12));
    }

    /* renamed from: v */
    public static long[] m62687v(InputStream inputStream) throws IOException {
        long j10 = 0;
        long j11 = 0;
        while (true) {
            int i10 = inputStream.read();
            if (i10 == 10) {
                return new long[]{j11, j10 + 1};
            }
            j10++;
            if (i10 == -1) {
                throw new IOException("Unexpected EOF when reading parse information of 1.X PAX format");
            }
            if (i10 < 48 || i10 > 57) {
                break;
            }
            j11 = (j11 * 10) + (i10 - 48);
        }
        throw new IOException("Corrupted TAR archive. Non-numeric value in sparse headers block");
    }

    /* renamed from: w */
    public static List<C10070i> m62688w(byte[] bArr, int i10, int i11) throws IOException {
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < i11; i12++) {
            try {
                C10070i c10070iM62686u = m62686u(bArr, (i12 * 24) + i10);
                if (c10070iM62686u.m62665b() < 0) {
                    throw new IOException("Corrupted TAR archive, sparse entry with negative offset");
                }
                if (c10070iM62686u.m62664a() < 0) {
                    throw new IOException("Corrupted TAR archive, sparse entry with negative numbytes");
                }
                arrayList.add(c10070iM62686u);
            } catch (IllegalArgumentException e10) {
                throw new IOException("Corrupted TAR archive, sparse entry is invalid", e10);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: x */
    public static boolean m62689x(byte[] bArr) {
        long jM62682q = m62682q(bArr, 148, 8);
        long j10 = 0;
        long j11 = 0;
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b10 = bArr[i10];
            if (148 <= i10 && i10 < 156) {
                b10 = 32;
            }
            j10 += b10 & 255;
            j11 += b10;
        }
        return jM62682q == j10 || jM62682q == j11;
    }
}
