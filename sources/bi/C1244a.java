package bi;

import com.google.flatbuffers.reflection.BaseType;
import com.huawei.hms.network.okhttp.PublicSuffixDatabase;

/* renamed from: bi.a */
/* loaded from: classes4.dex */
public class C1244a {

    /* renamed from: a */
    public static final byte[] f5661a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, BaseType.Float, BaseType.Double, 13, BaseType.Vector, BaseType.Obj, BaseType.Union, BaseType.Array, BaseType.Vector64, BaseType.MaxBaseType, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, PublicSuffixDatabase.f29565i, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    /* renamed from: a */
    public static byte[] m7445a(String str) {
        int iM7446b = m7446b(str);
        int i10 = (iM7446b / 4) * 3;
        int i11 = iM7446b % 4;
        if (i11 == 3) {
            i10 += 2;
        }
        if (i11 == 2) {
            i10++;
        }
        byte[] bArr = new byte[i10];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < str.length(); i15++) {
            char cCharAt = str.charAt(i15);
            byte b10 = cCharAt > 255 ? (byte) -1 : f5661a[cCharAt];
            if (b10 >= 0) {
                int i16 = i14 + 6;
                i13 = (i13 << 6) | b10;
                if (i16 >= 8) {
                    i14 -= 2;
                    bArr[i12] = (byte) (255 & (i13 >> i14));
                    i12++;
                } else {
                    i14 = i16;
                }
            }
        }
        return i12 != i10 ? new byte[0] : bArr;
    }

    /* renamed from: b */
    public static int m7446b(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt > 255 || f5661a[cCharAt] < 0) {
                length--;
            }
        }
        return length;
    }
}
