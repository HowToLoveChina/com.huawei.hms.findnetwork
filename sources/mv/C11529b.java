package mv;

import com.google.flatbuffers.reflection.BaseType;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import p374iv.C10622a;

/* renamed from: mv.b */
/* loaded from: classes9.dex */
public final class C11529b {

    /* renamed from: a */
    public static final char[] f53481a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    public static final char[] f53482b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public static byte[] m68813a(char[] cArr) throws C10622a {
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new C10622a("Odd number of characters.");
        }
        byte[] bArr = new byte[length >> 1];
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int iDigit = Character.digit(cArr[i10], 16);
            if (iDigit == -1) {
                throw new C10622a("Illegal hexadecimal character at index " + i10);
            }
            int i12 = i10 + 1;
            int iDigit2 = Character.digit(cArr[i12], 16);
            if (iDigit2 == -1) {
                throw new C10622a("Illegal hexadecimal character at index " + i12);
            }
            i10 += 2;
            bArr[i11] = (byte) (((iDigit << 4) | iDigit2) & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA);
            i11++;
        }
        return bArr;
    }

    /* renamed from: b */
    public static byte[] m68814b(String str) throws C10622a {
        return m68813a(str.toCharArray());
    }

    /* renamed from: c */
    public static char[] m68815c(byte[] bArr, boolean z10) {
        return m68816d(bArr, z10 ? f53482b : f53481a);
    }

    /* renamed from: d */
    public static char[] m68816d(byte[] bArr, char[] cArr) {
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

    /* renamed from: e */
    public static String m68817e(byte[] bArr, boolean z10) {
        return new String(m68815c(bArr, z10));
    }
}
