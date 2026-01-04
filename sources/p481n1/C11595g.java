package p481n1;

import com.baidu.location.BDLocation;
import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Properties;

/* renamed from: n1.g */
/* loaded from: classes.dex */
public class C11595g {

    /* renamed from: a */
    public static final Properties f53791a = new Properties();

    /* renamed from: b */
    public static final Charset f53792b = Charset.forName(Constants.UTF_8);

    /* renamed from: c */
    public static final char[] f53793c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: d */
    public static final boolean[] f53794d = new boolean[256];

    /* renamed from: e */
    public static final boolean[] f53795e = new boolean[256];

    /* renamed from: f */
    public static final byte[] f53796f;

    /* renamed from: g */
    public static final byte[] f53797g;

    /* renamed from: h */
    public static final boolean[] f53798h;

    /* renamed from: i */
    public static final boolean[] f53799i;

    /* renamed from: j */
    public static final char[] f53800j;

    /* renamed from: k */
    public static final char[] f53801k;

    /* renamed from: l */
    public static final char[] f53802l;

    /* renamed from: m */
    public static final char[] f53803m;

    /* renamed from: n */
    public static final char[] f53804n;

    /* renamed from: o */
    public static final int[] f53805o;

    /* renamed from: p */
    public static final char[] f53806p;

    /* renamed from: q */
    public static final int[] f53807q;

    /* renamed from: n1.g$a */
    public static class a implements PrivilegedAction<InputStream> {
        @Override // java.security.PrivilegedAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InputStream run() {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            return contextClassLoader != null ? contextClassLoader.getResourceAsStream("fastjson.properties") : ClassLoader.getSystemResourceAsStream("fastjson.properties");
        }
    }

    static {
        char c10 = 0;
        while (true) {
            boolean[] zArr = f53794d;
            if (c10 >= zArr.length) {
                break;
            }
            if (c10 >= 'A' && c10 <= 'Z') {
                zArr[c10] = true;
            } else if (c10 >= 'a' && c10 <= 'z') {
                zArr[c10] = true;
            } else if (c10 == '_' || c10 == '$') {
                zArr[c10] = true;
            }
            c10 = (char) (c10 + 1);
        }
        char c11 = 0;
        while (true) {
            boolean[] zArr2 = f53795e;
            if (c11 < zArr2.length) {
                if (c11 >= 'A' && c11 <= 'Z') {
                    zArr2[c11] = true;
                } else if (c11 >= 'a' && c11 <= 'z') {
                    zArr2[c11] = true;
                } else if (c11 == '_') {
                    zArr2[c11] = true;
                } else if (c11 >= '0' && c11 <= '9') {
                    zArr2[c11] = true;
                }
                c11 = (char) (c11 + 1);
            } else {
                try {
                    break;
                } catch (Throwable unused) {
                }
            }
        }
        m69215j();
        byte[] bArr = new byte[BDLocation.TypeNetWorkLocation];
        f53796f = bArr;
        byte[] bArr2 = new byte[BDLocation.TypeNetWorkLocation];
        f53797g = bArr2;
        f53798h = new boolean[BDLocation.TypeNetWorkLocation];
        f53799i = new boolean[BDLocation.TypeNetWorkLocation];
        f53800j = new char[93];
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i10 = 14; i10 <= 31; i10++) {
            f53796f[i10] = 4;
            f53797g[i10] = 4;
        }
        for (int i11 = 127; i11 < 160; i11++) {
            f53796f[i11] = 4;
            f53797g[i11] = 4;
        }
        for (int i12 = 0; i12 < 161; i12++) {
            f53798h[i12] = f53796f[i12] != 0;
            f53799i[i12] = f53797g[i12] != 0;
        }
        char[] cArr = f53800j;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = '\"';
        cArr[39] = '\'';
        cArr[47] = C5929g4.f26852n;
        cArr[92] = '\\';
        f53801k = new char[]{'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
        f53802l = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        f53803m = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
        f53804n = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        f53805o = new int[]{9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        f53806p = charArray;
        int[] iArr = new int[256];
        f53807q = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i13 = 0; i13 < length; i13++) {
            f53807q[f53806p[i13]] = i13;
        }
        f53807q[61] = 0;
    }

    /* renamed from: a */
    public static void m69206a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: b */
    public static byte[] m69207b(String str) {
        int i10;
        int length = str.length();
        if (length == 0) {
            return new byte[0];
        }
        int i11 = length - 1;
        int i12 = 0;
        while (i12 < i11 && f53807q[str.charAt(i12) & 255] < 0) {
            i12++;
        }
        while (i11 > 0 && f53807q[str.charAt(i11) & 255] < 0) {
            i11--;
        }
        int i13 = str.charAt(i11) == '=' ? str.charAt(i11 + (-1)) == '=' ? 2 : 1 : 0;
        int i14 = (i11 - i12) + 1;
        if (length > 76) {
            i10 = (str.charAt(76) == '\r' ? i14 / 78 : 0) << 1;
        } else {
            i10 = 0;
        }
        int i15 = (((i14 - i10) * 6) >> 3) - i13;
        byte[] bArr = new byte[i15];
        int i16 = (i15 / 3) * 3;
        int i17 = 0;
        int i18 = 0;
        while (i17 < i16) {
            int[] iArr = f53807q;
            int i19 = i12 + 4;
            int i20 = iArr[str.charAt(i12 + 3)] | (iArr[str.charAt(i12 + 1)] << 12) | (iArr[str.charAt(i12)] << 18) | (iArr[str.charAt(i12 + 2)] << 6);
            bArr[i17] = (byte) (i20 >> 16);
            int i21 = i17 + 2;
            bArr[i17 + 1] = (byte) (i20 >> 8);
            i17 += 3;
            bArr[i21] = (byte) i20;
            if (i10 <= 0 || (i18 = i18 + 1) != 19) {
                i12 = i19;
            } else {
                i12 += 6;
                i18 = 0;
            }
        }
        if (i17 < i15) {
            int i22 = 0;
            int i23 = 0;
            while (i12 <= i11 - i13) {
                i22 |= f53807q[str.charAt(i12)] << (18 - (i23 * 6));
                i23++;
                i12++;
            }
            int i24 = 16;
            while (i17 < i15) {
                bArr[i17] = (byte) (i22 >> i24);
                i24 -= 8;
                i17++;
            }
        }
        return bArr;
    }

    /* renamed from: c */
    public static byte[] m69208c(String str, int i10, int i11) {
        int i12;
        if (i11 == 0) {
            return new byte[0];
        }
        int i13 = (i10 + i11) - 1;
        int i14 = i10;
        while (i14 < i13 && f53807q[str.charAt(i14)] < 0) {
            i14++;
        }
        while (i13 > 0 && f53807q[str.charAt(i13)] < 0) {
            i13--;
        }
        int i15 = str.charAt(i13) == '=' ? str.charAt(i13 + (-1)) == '=' ? 2 : 1 : 0;
        int i16 = (i13 - i14) + 1;
        if (i11 > 76) {
            i12 = (str.charAt(76) == '\r' ? i16 / 78 : 0) << 1;
        } else {
            i12 = 0;
        }
        int i17 = (((i16 - i12) * 6) >> 3) - i15;
        byte[] bArr = new byte[i17];
        int i18 = (i17 / 3) * 3;
        int i19 = 0;
        int i20 = 0;
        while (i19 < i18) {
            int[] iArr = f53807q;
            int i21 = i14 + 4;
            int i22 = iArr[str.charAt(i14 + 3)] | (iArr[str.charAt(i14 + 1)] << 12) | (iArr[str.charAt(i14)] << 18) | (iArr[str.charAt(i14 + 2)] << 6);
            bArr[i19] = (byte) (i22 >> 16);
            int i23 = i19 + 2;
            bArr[i19 + 1] = (byte) (i22 >> 8);
            i19 += 3;
            bArr[i23] = (byte) i22;
            if (i12 <= 0 || (i20 = i20 + 1) != 19) {
                i14 = i21;
            } else {
                i14 += 6;
                i20 = 0;
            }
        }
        if (i19 < i17) {
            int i24 = 0;
            int i25 = 0;
            while (i14 <= i13 - i15) {
                i24 |= f53807q[str.charAt(i14)] << (18 - (i25 * 6));
                i25++;
                i14++;
            }
            int i26 = 16;
            while (i19 < i17) {
                bArr[i19] = (byte) (i24 >> i26);
                i26 -= 8;
                i19++;
            }
        }
        return bArr;
    }

    /* renamed from: d */
    public static byte[] m69209d(char[] cArr, int i10, int i11) {
        int i12;
        int i13 = 0;
        if (i11 == 0) {
            return new byte[0];
        }
        int i14 = (i10 + i11) - 1;
        int i15 = i10;
        while (i15 < i14 && f53807q[cArr[i15]] < 0) {
            i15++;
        }
        while (i14 > 0 && f53807q[cArr[i14]] < 0) {
            i14--;
        }
        int i16 = cArr[i14] == '=' ? cArr[i14 + (-1)] == '=' ? 2 : 1 : 0;
        int i17 = (i14 - i15) + 1;
        if (i11 > 76) {
            i12 = (cArr[76] == '\r' ? i17 / 78 : 0) << 1;
        } else {
            i12 = 0;
        }
        int i18 = (((i17 - i12) * 6) >> 3) - i16;
        byte[] bArr = new byte[i18];
        int i19 = (i18 / 3) * 3;
        int i20 = 0;
        int i21 = 0;
        while (i20 < i19) {
            int[] iArr = f53807q;
            int i22 = i15 + 4;
            int i23 = iArr[cArr[i15 + 3]] | (iArr[cArr[i15 + 1]] << 12) | (iArr[cArr[i15]] << 18) | (iArr[cArr[i15 + 2]] << 6);
            bArr[i20] = (byte) (i23 >> 16);
            int i24 = i20 + 2;
            bArr[i20 + 1] = (byte) (i23 >> 8);
            i20 += 3;
            bArr[i24] = (byte) i23;
            if (i12 <= 0 || (i21 = i21 + 1) != 19) {
                i15 = i22;
            } else {
                i15 += 6;
                i21 = 0;
            }
        }
        if (i20 < i18) {
            int i25 = 0;
            while (i15 <= i14 - i16) {
                i13 |= f53807q[cArr[i15]] << (18 - (i25 * 6));
                i25++;
                i15++;
            }
            int i26 = 16;
            while (i20 < i18) {
                bArr[i20] = (byte) (i13 >> i26);
                i26 -= 8;
                i20++;
            }
        }
        return bArr;
    }

    /* renamed from: e */
    public static boolean m69210e(char c10) {
        boolean[] zArr = f53794d;
        return c10 < zArr.length && zArr[c10];
    }

    /* renamed from: f */
    public static void m69211f(int i10, int i11, char[] cArr) {
        char c10;
        if (i10 < 0) {
            i10 = -i10;
            c10 = '-';
        } else {
            c10 = 0;
        }
        while (i10 >= 65536) {
            int i12 = i10 / 100;
            int i13 = i10 - (((i12 << 6) + (i12 << 5)) + (i12 << 2));
            cArr[i11 - 1] = f53804n[i13];
            i11 -= 2;
            cArr[i11] = f53803m[i13];
            i10 = i12;
        }
        while (true) {
            int i14 = (52429 * i10) >>> 19;
            int i15 = i11 - 1;
            cArr[i15] = f53802l[i10 - ((i14 << 3) + (i14 << 1))];
            if (i14 == 0) {
                break;
            }
            i10 = i14;
            i11 = i15;
        }
        if (c10 != 0) {
            cArr[i11 - 2] = c10;
        }
    }

    /* renamed from: g */
    public static void m69212g(long j10, int i10, char[] cArr) {
        char c10;
        if (j10 < 0) {
            j10 = -j10;
            c10 = '-';
        } else {
            c10 = 0;
        }
        while (j10 > 2147483647L) {
            long j11 = j10 / 100;
            int i11 = (int) (j10 - (((j11 << 6) + (j11 << 5)) + (j11 << 2)));
            cArr[i10 - 1] = f53804n[i11];
            i10 -= 2;
            cArr[i10] = f53803m[i11];
            j10 = j11;
        }
        int i12 = (int) j10;
        while (i12 >= 65536) {
            int i13 = i12 / 100;
            int i14 = i12 - (((i13 << 6) + (i13 << 5)) + (i13 << 2));
            cArr[i10 - 1] = f53804n[i14];
            i10 -= 2;
            cArr[i10] = f53803m[i14];
            i12 = i13;
        }
        while (true) {
            int i15 = (52429 * i12) >>> 19;
            int i16 = i10 - 1;
            cArr[i16] = f53802l[i12 - ((i15 << 3) + (i15 << 1))];
            if (i15 == 0) {
                break;
            }
            i12 = i15;
            i10 = i16;
        }
        if (c10 != 0) {
            cArr[i10 - 2] = c10;
        }
    }

    /* renamed from: h */
    public static String m69213h(String str) {
        String property;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        return property == null ? f53791a.getProperty(str) : property;
    }

    /* renamed from: i */
    public static boolean m69214i(char c10) {
        boolean[] zArr = f53795e;
        return c10 < zArr.length && zArr[c10];
    }

    /* renamed from: j */
    public static void m69215j() throws IOException {
        InputStream inputStream = (InputStream) AccessController.doPrivileged(new a());
        if (inputStream != null) {
            try {
                f53791a.load(inputStream);
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: k */
    public static int m69216k(int i10) {
        int i11 = 0;
        while (i10 > f53805o[i11]) {
            i11++;
        }
        return i11 + 1;
    }

    /* renamed from: l */
    public static int m69217l(long j10) {
        long j11 = 10;
        for (int i10 = 1; i10 < 19; i10++) {
            if (j10 < j11) {
                return i10;
            }
            j11 *= 10;
        }
        return 19;
    }
}
