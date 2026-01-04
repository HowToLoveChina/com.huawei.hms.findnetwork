package com.huawei.openalliance.p169ad.utils;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

/* renamed from: com.huawei.openalliance.ad.utils.an */
/* loaded from: classes2.dex */
public abstract class AbstractC7740an {
    /* renamed from: a */
    public static String m47531a(byte[] bArr) {
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
    public static byte[] m47533b(String str) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        byte[] bytes = upperCase.getBytes(Constants.UTF_8);
        for (int i10 = 0; i10 < length; i10++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("0x");
            int i11 = i10 * 2;
            sb2.append(new String(new byte[]{bytes[i11]}, Constants.UTF_8));
            bArr[i10] = (byte) (((byte) (Byte.decode(sb2.toString()).byteValue() << 4)) ^ Byte.decode("0x" + new String(new byte[]{bytes[i11 + 1]}, Constants.UTF_8)).byteValue());
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m47532a(String str) {
        StringBuilder sb2;
        byte[] bArr = new byte[0];
        try {
            return m47533b(str);
        } catch (NumberFormatException e10) {
            e = e10;
            sb2 = new StringBuilder();
            sb2.append("hex string 2 byte: ");
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43826d("HexUtil", sb2.toString());
            return bArr;
        } catch (Throwable th2) {
            e = th2;
            sb2 = new StringBuilder();
            sb2.append("hex string 2 byte: ");
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43826d("HexUtil", sb2.toString());
            return bArr;
        }
    }
}
