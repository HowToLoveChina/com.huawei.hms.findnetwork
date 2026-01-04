package p483n3;

import java.util.Arrays;
import p468m3.C11396b;

/* renamed from: n3.j */
/* loaded from: classes.dex */
public final class C11619j {
    /* renamed from: a */
    public static Object m69457a(int i10) {
        if (i10 >= 2 && i10 <= 1073741824 && Integer.highestOneBit(i10) == i10) {
            return i10 <= 256 ? new byte[i10] : i10 <= 65536 ? new short[i10] : new int[i10];
        }
        StringBuilder sb2 = new StringBuilder(52);
        sb2.append("must be power of 2 between 2^1 and 2^30: ");
        sb2.append(i10);
        throw new IllegalArgumentException(sb2.toString());
    }

    /* renamed from: b */
    public static int m69458b(int i10, int i11) {
        return i10 & (~i11);
    }

    /* renamed from: c */
    public static int m69459c(int i10, int i11) {
        return i10 & i11;
    }

    /* renamed from: d */
    public static int m69460d(int i10, int i11, int i12) {
        return (i10 & (~i12)) | (i11 & i12);
    }

    /* renamed from: e */
    public static int m69461e(int i10) {
        return (i10 < 32 ? 4 : 2) * (i10 + 1);
    }

    /* renamed from: f */
    public static int m69462f(Object obj, Object obj2, int i10, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int i11;
        int i12;
        int iM69469c = C11620k.m69469c(obj);
        int i13 = iM69469c & i10;
        int iM69464h = m69464h(obj3, i13);
        if (iM69464h == 0) {
            return -1;
        }
        int iM69458b = m69458b(iM69469c, i10);
        int i14 = -1;
        while (true) {
            i11 = iM69464h - 1;
            i12 = iArr[i11];
            if (m69458b(i12, i10) == iM69458b && C11396b.m68302a(obj, objArr[i11]) && (objArr2 == null || C11396b.m68302a(obj2, objArr2[i11]))) {
                break;
            }
            int iM69459c = m69459c(i12, i10);
            if (iM69459c == 0) {
                return -1;
            }
            i14 = i11;
            iM69464h = iM69459c;
        }
        int iM69459c2 = m69459c(i12, i10);
        if (i14 == -1) {
            m69465i(obj3, i13, iM69459c2);
        } else {
            iArr[i14] = m69460d(iArr[i14], iM69459c2, i10);
        }
        return i11;
    }

    /* renamed from: g */
    public static void m69463g(Object obj) {
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
    }

    /* renamed from: h */
    public static int m69464h(Object obj, int i10) {
        return obj instanceof byte[] ? ((byte[]) obj)[i10] & 255 : obj instanceof short[] ? ((short[]) obj)[i10] & 65535 : ((int[]) obj)[i10];
    }

    /* renamed from: i */
    public static void m69465i(Object obj, int i10, int i11) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i10] = (byte) i11;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i10] = (short) i11;
        } else {
            ((int[]) obj)[i10] = i11;
        }
    }

    /* renamed from: j */
    public static int m69466j(int i10) {
        return Math.max(4, C11620k.m69467a(i10 + 1, 1.0d));
    }
}
