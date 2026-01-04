package p248e5;

import p699v4.C13342k;

/* renamed from: e5.d */
/* loaded from: classes.dex */
public class C9411d {
    /* renamed from: a */
    public static byte[] m59030a(String str) {
        if (str == null) {
            return new byte[0];
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) C13342k.m80056e(str.substring(i11, i11 + 2), 16);
        }
        return bArr;
    }

    /* renamed from: b */
    public static String m59031b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder(bArr.length);
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                sb2.append("0");
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }
}
