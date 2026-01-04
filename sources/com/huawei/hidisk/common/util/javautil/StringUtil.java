package com.huawei.hidisk.common.util.javautil;

import android.text.TextUtils;
import com.google.flatbuffers.reflection.BaseType;
import java.io.File;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.Normalizer;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.crypto.KeyGenerator;
import p399jk.AbstractC10896a;
import p525ok.C11908a;
import p783xp.C13843a;

/* loaded from: classes8.dex */
public class StringUtil {
    private static final String TAG = "StringUtil";

    public static String byte2hex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
                stringBuffer.append(hexString);
            } else {
                stringBuffer.append(hexString);
            }
        }
        return stringBuffer.toString();
    }

    public static String emptyIfBlank(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static boolean equals(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static String filterInvisibleStr(String str) {
        if (str != null) {
            return str.replaceAll("\\p{C}", "");
        }
        return null;
    }

    public static String getMD5(String str) throws NoSuchAlgorithmException {
        byte[] bArrDigest;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes(Charset.defaultCharset()));
            bArrDigest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e10) {
            AbstractC10896a.m65886e(TAG, "NoSuchAlgorithmException: " + e10.toString());
            bArrDigest = null;
        }
        return bArrDigest != null ? byte2hex(bArrDigest) : "";
    }

    private static byte[] getRawKey() throws Exception {
        SecureRandom secureRandomM71442a = C11908a.m71442a();
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128, secureRandomM71442a);
        return keyGenerator.generateKey().getEncoded();
    }

    public static String getValidFileName(String str) {
        if (str == null || str.trim().length() == 0) {
            return "";
        }
        try {
            String str2 = File.separator;
            return str.replaceAll("\\\\", str2).replaceAll("/", str2);
        } catch (PatternSyntaxException e10) {
            AbstractC10896a.m65886e(TAG, "getValidFileName: " + e10.toString());
            return str.replaceAll("/", File.separator);
        }
    }

    public static String globalizeNum(String str, Object obj) {
        return (str == null || obj == null) ? str : str.replace(String.valueOf(obj), C13843a.m83104z(obj));
    }

    public static boolean isBlank(String str) {
        if (str != null) {
            return str.trim().isEmpty();
        }
        return true;
    }

    public static String join(String str, List<String> list) {
        return join(str, (String[]) list.toArray(new String[list.size()]));
    }

    public static String normalizerString(String str) {
        if (str == null) {
            return null;
        }
        return Normalizer.normalize(str, Normalizer.Form.NFC);
    }

    public static String randomString() {
        try {
            return toHex(getRawKey());
        } catch (Exception e10) {
            AbstractC10896a.m65886e(TAG, "randomString Exception: " + e10.toString());
            return String.valueOf(System.currentTimeMillis());
        }
    }

    public static String removePrefix(String str, String str2) {
        if (str == null || str2 == null) {
            return str2;
        }
        String strNormalizerString = normalizerString(str2);
        String strNormalizerString2 = normalizerString(str);
        return strNormalizerString.startsWith(strNormalizerString2) ? strNormalizerString.substring(strNormalizerString2.length(), strNormalizerString.length()) : strNormalizerString;
    }

    public static String replace(String str, String str2, String str3) {
        if (str2 == null || str == null || str3 == null) {
            return str3;
        }
        String strNormalizerString = normalizerString(str3);
        String strNormalizerString2 = normalizerString(str);
        return strNormalizerString.startsWith(strNormalizerString2) ? strNormalizerString.replaceFirst(Pattern.quote(strNormalizerString2), normalizerString(str2)) : strNormalizerString;
    }

    public static String replaceFirst(String str, String str2, String str3) {
        if (str2 == null || str == null || str3 == null) {
            return str3;
        }
        String strNormalizerString = normalizerString(str3);
        String strNormalizerString2 = normalizerString(str);
        String strNormalizerString3 = normalizerString(str2);
        StringBuilder sb2 = new StringBuilder(strNormalizerString);
        if (strNormalizerString.startsWith(strNormalizerString2)) {
            int iIndexOf = strNormalizerString.indexOf(strNormalizerString2);
            sb2.replace(iIndexOf, strNormalizerString2.length() + iIndexOf, strNormalizerString3);
        }
        return sb2.toString();
    }

    public static String toHex(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (int i10 = 0; i10 < bArr.length; i10++) {
            sb2.append("0123456789ABCDEF".charAt((bArr[i10] >> 4) & 15));
            sb2.append("0123456789ABCDEF".charAt(bArr[i10] & BaseType.Obj));
        }
        return sb2.toString();
    }

    public static String join(String str, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(strArr[0]);
        for (int i10 = 1; i10 < strArr.length; i10++) {
            sb2.append(str);
            sb2.append(emptyIfBlank(strArr[i10]));
        }
        return sb2.toString();
    }
}
