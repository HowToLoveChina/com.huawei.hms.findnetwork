package p005a4;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: a4.q */
/* loaded from: classes.dex */
public class C0037q {
    /* renamed from: a */
    public static byte[] m145a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("The key length in bytes must be 32.");
        }
        int i10 = 0;
        long jM147c = m147c(bArr, 0, 0) & 67108863;
        int i11 = 3;
        long jM147c2 = m147c(bArr, 3, 2) & 67108611;
        long jM147c3 = m147c(bArr, 6, 4) & 67092735;
        long jM147c4 = m147c(bArr, 9, 6) & 66076671;
        long jM147c5 = m147c(bArr, 12, 8) & 1048575;
        long j10 = jM147c2 * 5;
        long j11 = jM147c3 * 5;
        long j12 = jM147c4 * 5;
        long j13 = jM147c5 * 5;
        byte[] bArr3 = new byte[17];
        long j14 = 0;
        int i12 = 0;
        long j15 = 0;
        long j16 = 0;
        long j17 = 0;
        long j18 = 0;
        while (i12 < bArr2.length) {
            m146b(bArr3, bArr2, i12);
            long jM147c6 = j18 + m147c(bArr3, i10, i10);
            long jM147c7 = j14 + m147c(bArr3, i11, 2);
            long jM147c8 = j15 + m147c(bArr3, 6, 4);
            long jM147c9 = j16 + m147c(bArr3, 9, 6);
            long jM147c10 = j17 + (m147c(bArr3, 12, 8) | (bArr3[16] << 24));
            long j19 = (jM147c6 * jM147c) + (jM147c7 * j13) + (jM147c8 * j12) + (jM147c9 * j11) + (jM147c10 * j10);
            long j20 = (jM147c6 * jM147c2) + (jM147c7 * jM147c) + (jM147c8 * j13) + (jM147c9 * j12) + (jM147c10 * j11);
            long j21 = (jM147c6 * jM147c3) + (jM147c7 * jM147c2) + (jM147c8 * jM147c) + (jM147c9 * j13) + (jM147c10 * j12);
            long j22 = (jM147c6 * jM147c4) + (jM147c7 * jM147c3) + (jM147c8 * jM147c2) + (jM147c9 * jM147c) + (jM147c10 * j13);
            long j23 = j20 + (j19 >> 26);
            long j24 = j21 + (j23 >> 26);
            long j25 = j22 + (j24 >> 26);
            long j26 = (jM147c6 * jM147c5) + (jM147c7 * jM147c4) + (jM147c8 * jM147c3) + (jM147c9 * jM147c2) + (jM147c10 * jM147c) + (j25 >> 26);
            long j27 = (j19 & 67108863) + ((j26 >> 26) * 5);
            j14 = (j23 & 67108863) + (j27 >> 26);
            i12 += 16;
            j15 = j24 & 67108863;
            j16 = j25 & 67108863;
            j17 = j26 & 67108863;
            i11 = 3;
            j18 = j27 & 67108863;
            i10 = 0;
        }
        long j28 = j15 + (j14 >> 26);
        long j29 = j28 & 67108863;
        long j30 = j16 + (j28 >> 26);
        long j31 = j30 & 67108863;
        long j32 = j17 + (j30 >> 26);
        long j33 = j32 & 67108863;
        long j34 = j18 + ((j32 >> 26) * 5);
        long j35 = j34 & 67108863;
        long j36 = (j14 & 67108863) + (j34 >> 26);
        long j37 = j35 + 5;
        long j38 = j37 & 67108863;
        long j39 = (j37 >> 26) + j36;
        long j40 = j29 + (j39 >> 26);
        long j41 = j31 + (j40 >> 26);
        long j42 = (j33 + (j41 >> 26)) - 67108864;
        long j43 = j42 >> 63;
        long j44 = j35 & j43;
        long j45 = j36 & j43;
        long j46 = j29 & j43;
        long j47 = j31 & j43;
        long j48 = j33 & j43;
        long j49 = ~j43;
        long j50 = (j39 & 67108863 & j49) | j45;
        long j51 = (j40 & 67108863 & j49) | j46;
        long j52 = (j41 & 67108863 & j49) | j47;
        long j53 = (j42 & j49) | j48;
        long j54 = (j44 | (j38 & j49) | (j50 << 26)) & 4294967295L;
        long j55 = ((j50 >> 6) | (j51 << 20)) & 4294967295L;
        long j56 = ((j51 >> 12) | (j52 << 14)) & 4294967295L;
        long j57 = ((j52 >> 18) | (j53 << 8)) & 4294967295L;
        long jM148d = j54 + m148d(bArr, 16);
        long j58 = jM148d & 4294967295L;
        long jM148d2 = j55 + m148d(bArr, 20) + (jM148d >> 32);
        long j59 = jM148d2 & 4294967295L;
        long jM148d3 = j56 + m148d(bArr, 24) + (jM148d2 >> 32);
        long j60 = jM148d3 & 4294967295L;
        long jM148d4 = (j57 + m148d(bArr, 28) + (jM148d3 >> 32)) & 4294967295L;
        byte[] bArr4 = new byte[16];
        m149e(bArr4, j58, 0);
        m149e(bArr4, j59, 4);
        m149e(bArr4, j60, 8);
        m149e(bArr4, jM148d4, 12);
        return bArr4;
    }

    /* renamed from: b */
    public static void m146b(byte[] bArr, byte[] bArr2, int i10) {
        int iMin = Math.min(16, bArr2.length - i10);
        System.arraycopy(bArr2, i10, bArr, 0, iMin);
        bArr[iMin] = 1;
        if (iMin != 16) {
            Arrays.fill(bArr, iMin + 1, bArr.length, (byte) 0);
        }
    }

    /* renamed from: c */
    public static long m147c(byte[] bArr, int i10, int i11) {
        return (m148d(bArr, i10) >> i11) & 67108863;
    }

    /* renamed from: d */
    public static long m148d(byte[] bArr, int i10) {
        return (((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16)) & 4294967295L;
    }

    /* renamed from: e */
    public static void m149e(byte[] bArr, long j10, int i10) {
        int i11 = 0;
        while (i11 < 4) {
            bArr[i10 + i11] = (byte) (255 & j10);
            i11++;
            j10 >>= 8;
        }
    }

    /* renamed from: f */
    public static void m150f(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (!C0027g.m112b(m145a(bArr, bArr2), bArr3)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }
}
