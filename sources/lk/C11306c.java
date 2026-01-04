package lk;

import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.Locale;

/* renamed from: lk.c */
/* loaded from: classes6.dex */
public class C11306c {

    /* renamed from: a */
    public static Locale f52959a = new Locale(FaqConstants.DEFAULT_ISO_LANGUAGE);

    /* renamed from: a */
    public static byte[] m67869a(String str) {
        if (str == null) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 != 0) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(f52959a);
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
                if (65 > b10 || b10 > 70) {
                    bArr2[i15] = (byte) (b10 - 48);
                } else {
                    bArr2[i15] = (byte) (b10 - 55);
                }
            }
            bArr[i13] = (byte) ((bArr2[0] << 4) | bArr2[1]);
        }
        return bArr;
    }

    /* renamed from: b */
    public static String m67870b(byte[] bArr) {
        return m67871c(bArr, bArr.length);
    }

    /* renamed from: c */
    public static String m67871c(byte[] bArr, int i10) {
        StringBuilder sb2 = new StringBuilder();
        if (bArr == null) {
            return null;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            String hexString = Integer.toHexString(bArr[i11] & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb2.append(hexString.toUpperCase(f52959a));
        }
        return sb2.toString();
    }
}
