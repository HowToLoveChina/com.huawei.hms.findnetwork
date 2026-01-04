package com.huawei.hms.support.hwid.common.p142b;

import java.util.Locale;

/* renamed from: com.huawei.hms.support.hwid.common.b.a */
/* loaded from: classes8.dex */
public abstract class AbstractC6464a {
    /* renamed from: a */
    public static String m36842a(byte[] bArr, int i10) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bArr == null) {
            return null;
        }
        if (i10 <= 0 || i10 > bArr.length) {
            i10 = bArr.length;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            String hexString = Integer.toHexString(bArr[i11] & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            stringBuffer.append(hexString.toUpperCase(Locale.ENGLISH));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m36841a(byte[] bArr) {
        return m36842a(bArr, 0);
    }

    /* renamed from: a */
    public static byte[] m36843a(String str) {
        if (str == null) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 != 0) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = upperCase.charAt(i10);
            if (('0' > cCharAt || cCharAt > '9') && ('A' > cCharAt || cCharAt > 'F')) {
                return new byte[0];
            }
        }
        int i11 = length / 2;
        byte[] bArr = new byte[i11];
        byte[] bArr2 = new byte[2];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            int i14 = i12 + 1;
            bArr2[0] = (byte) upperCase.charAt(i12);
            i12 += 2;
            bArr2[1] = (byte) upperCase.charAt(i14);
            for (int i15 = 0; i15 < 2; i15++) {
                byte b10 = bArr2[i15];
                if (65 <= b10 && b10 <= 70) {
                    bArr2[i15] = (byte) (b10 - 55);
                } else {
                    bArr2[i15] = (byte) (b10 - 48);
                }
            }
            bArr[i13] = (byte) ((bArr2[0] << 4) | bArr2[1]);
        }
        return bArr;
    }
}
