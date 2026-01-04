package lu;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

/* renamed from: lu.b */
/* loaded from: classes5.dex */
public final class C11343b {
    /* renamed from: a */
    public static String m68146a(byte[] bArr) {
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
    public static byte[] m68147b(String str) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
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
        } catch (UnsupportedEncodingException | NumberFormatException e10) {
            Log.e("HexUtil", "hex string 2 byte UnsupportedEncodingException or NumberFormatException : " + e10.getMessage());
        } catch (Exception e11) {
            Log.e("HexUtil", "byte array 2 hex string exception : " + e11.getMessage());
        }
        return bArr;
    }
}
