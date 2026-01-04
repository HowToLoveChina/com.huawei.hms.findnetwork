package bi;

import com.google.flatbuffers.reflection.BaseType;

/* renamed from: bi.b */
/* loaded from: classes4.dex */
public final class C1245b {

    /* renamed from: a */
    public static final char[] f5662a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    public static final char[] f5663b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public static char[] m7447a(byte[] bArr, boolean z10) {
        return m7448b(bArr, z10 ? f5663b : f5662a);
    }

    /* renamed from: b */
    public static char[] m7448b(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[bArr.length << 1];
        int i10 = 0;
        for (byte b10 : bArr) {
            int i11 = i10 + 1;
            cArr2[i10] = cArr[(b10 & 240) >>> 4];
            i10 += 2;
            cArr2[i11] = cArr[b10 & BaseType.Obj];
        }
        return cArr2;
    }

    /* renamed from: c */
    public static String m7449c(byte[] bArr, boolean z10) {
        return new String(m7447a(bArr, z10));
    }
}
