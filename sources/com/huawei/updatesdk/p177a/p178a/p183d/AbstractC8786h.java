package com.huawei.updatesdk.p177a.p178a.p183d;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.updatesdk.p177a.p178a.p180c.p181a.p182a.C8777a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.IllegalFormatException;
import java.util.Locale;

/* renamed from: com.huawei.updatesdk.a.a.d.h */
/* loaded from: classes9.dex */
public abstract class AbstractC8786h {
    /* renamed from: a */
    public static String m56064a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, Constants.UTF_8).replace("+", "%20").replace("*", "%2A").replace("~", "%7E");
        } catch (UnsupportedEncodingException e10) {
            C8777a.m56027a("StringUtils", "encode2utf8 error", e10);
            return null;
        }
    }

    /* renamed from: b */
    public static String m56066b(String str) {
        String strM56069e = m56069e(str);
        if (strM56069e == null) {
            return null;
        }
        return strM56069e.toLowerCase(Locale.getDefault());
    }

    /* renamed from: c */
    public static byte[] m56067c(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            int iDigit = Character.digit(charArray[i11 + 1], 16) | (Character.digit(charArray[i11], 16) << 4);
            if (iDigit > 127) {
                iDigit -= 256;
            }
            bArr[i10] = Byte.parseByte(String.valueOf(iDigit));
        }
        return bArr;
    }

    /* renamed from: d */
    public static boolean m56068d(String str) {
        return str != null && str.trim().startsWith("{") && str.trim().endsWith("}");
    }

    /* renamed from: e */
    public static String m56069e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return m56065a(str.getBytes(Constants.UTF_8));
        } catch (UnsupportedEncodingException unused) {
            C8777a.m56028b("StringUtils", "can not getBytes");
            return null;
        }
    }

    /* renamed from: a */
    public static String m56065a(byte[] bArr) throws NoSuchAlgorithmException {
        String str;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            StringBuilder sb2 = new StringBuilder(256);
            for (byte b10 : messageDigest.digest()) {
                sb2.append(String.format(Locale.ENGLISH, "%02X", Byte.valueOf(b10)));
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException unused) {
            str = "sha256EncryptStr error:NoSuchAlgorithmException";
            C8777a.m56028b("StringUtils", str);
            return null;
        } catch (IllegalFormatException unused2) {
            str = "sha256EncryptStr error:IllegalFormatException";
            C8777a.m56028b("StringUtils", str);
            return null;
        } catch (Exception unused3) {
            str = "sha256EncryptStr error:Exception";
            C8777a.m56028b("StringUtils", str);
            return null;
        }
    }
}
