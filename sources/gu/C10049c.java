package gu;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

/* renamed from: gu.c */
/* loaded from: classes5.dex */
public final class C10049c {
    /* renamed from: a */
    public static String m62476a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                sb2.append('0');
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    /* renamed from: b */
    public static byte[] m62477b(String str) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            int length = upperCase.length() / 2;
            byte[] bArr = new byte[length];
            try {
                byte[] bytes = upperCase.getBytes(Constants.UTF_8);
                for (int i10 = 0; i10 < length; i10++) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("0x");
                    int i11 = i10 * 2;
                    sb2.append(new String(new byte[]{bytes[i11]}, Constants.UTF_8));
                    bArr[i10] = (byte) (((byte) (Byte.decode(sb2.toString()).byteValue() << 4)) ^ Byte.decode("0x" + new String(new byte[]{bytes[i11 + 1]}, Constants.UTF_8)).byteValue());
                }
                return bArr;
            } catch (UnsupportedEncodingException | NumberFormatException e10) {
                C10053g.m62491c("HexUtil", "hex string 2 byte array exception : " + e10.getMessage());
                return new byte[0];
            }
        } catch (Throwable th2) {
            C10053g.m62491c("HexUtil", "hex string toUpperCase exception : " + th2.getMessage());
            return new byte[0];
        }
    }
}
