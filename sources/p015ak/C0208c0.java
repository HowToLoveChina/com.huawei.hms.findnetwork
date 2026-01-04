package p015ak;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;

/* renamed from: ak.c0 */
/* loaded from: classes6.dex */
public class C0208c0 {

    /* renamed from: a */
    public static final BitSet f775a = new BitSet(256);

    static {
        for (int i10 = 33; i10 <= 60; i10++) {
            f775a.set(i10);
        }
        for (int i11 = 62; i11 <= 126; i11++) {
            f775a.set(i11);
        }
        BitSet bitSet = f775a;
        bitSet.set(9);
        bitSet.set(32);
    }

    /* renamed from: a */
    public static String m1139a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return m1140b(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static String m1140b(String str, String str2) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return new String(m1141c(str.getBytes("US-ASCII")), str2);
    }

    /* renamed from: c */
    public static byte[] m1141c(byte[] bArr) {
        return m1142d(bArr);
    }

    /* renamed from: d */
    public static final byte[] m1142d(byte[] bArr) {
        int i10 = 0;
        if (bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (i10 < bArr.length) {
            byte b10 = bArr[i10];
            if (b10 == 61) {
                int iDigit = Character.digit((char) bArr[i10 + 1], 16);
                i10 += 2;
                byteArrayOutputStream.write((char) ((iDigit << 4) + Character.digit((char) bArr[i10], 16)));
            } else {
                byteArrayOutputStream.write(b10);
            }
            i10++;
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: e */
    public static String m1143e(String str) {
        if (str == null) {
            return null;
        }
        try {
            return m1144f(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    /* renamed from: f */
    public static String m1144f(String str, String str2) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return new String(m1145g(str.getBytes(str2)), "US-ASCII");
    }

    /* renamed from: g */
    public static byte[] m1145g(byte[] bArr) {
        return m1147i(f775a, bArr);
    }

    /* renamed from: h */
    public static final void m1146h(int i10, ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.write(61);
        char upperCase = Character.toUpperCase(Character.forDigit((i10 >> 4) & 15, 16));
        char upperCase2 = Character.toUpperCase(Character.forDigit(i10 & 15, 16));
        byteArrayOutputStream.write(upperCase);
        byteArrayOutputStream.write(upperCase2);
    }

    /* renamed from: i */
    public static final byte[] m1147i(BitSet bitSet, byte[] bArr) {
        if (bArr == null) {
            return new byte[0];
        }
        if (bitSet == null) {
            bitSet = f775a;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i10 = 0; i10 < bArr.length; i10++) {
            int i11 = bArr[i10];
            if (i11 < 0) {
                i11 += 256;
            }
            if (bitSet.get(i11)) {
                byteArrayOutputStream.write(i11);
            } else {
                m1146h(i11, byteArrayOutputStream);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }
}
