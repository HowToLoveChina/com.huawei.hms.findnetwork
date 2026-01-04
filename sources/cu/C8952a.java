package cu;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import gu.C10048b;
import gu.C10049c;
import gu.C10053g;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: cu.a */
/* loaded from: classes5.dex */
public final class C8952a {
    /* renamed from: a */
    public static String m56679a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(0, 6) + str.substring(12, 16) + str.substring(26, 32) + str.substring(48);
        } catch (Exception e10) {
            C10053g.m62491c("CBC", "get encryptword exception : " + e10.getMessage());
            return "";
        }
    }

    /* renamed from: b */
    public static String m56680b(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return str2.substring(0, 6) + str.substring(0, 6) + str2.substring(6, 10) + str.substring(6, 16) + str2.substring(10, 16) + str.substring(16) + str2.substring(16);
            } catch (Exception e10) {
                C10053g.m62491c("CBC", "mix exception: " + e10.getMessage());
            }
        }
        return "";
    }

    /* renamed from: c */
    public static byte[] m56681c(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            C10053g.m62491c("CBC", "encrypt 5 content is null");
            return new byte[0];
        }
        if (bArr == null) {
            C10053g.m62491c("CBC", "encrypt 5 key is null");
            return new byte[0];
        }
        if (bArr.length < 16) {
            C10053g.m62491c("CBC", "encrypt 5 key error: 5 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr2 == null) {
            C10053g.m62491c("CBC", "encrypt 5 iv is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            C10053g.m62491c("CBC", "encrypt 5 iv error: 5 iv length less than 16 bytes.");
            return new byte[0];
        }
        try {
            return m56693o(str.getBytes(Constants.UTF_8), bArr, bArr2);
        } catch (UnsupportedEncodingException e10) {
            C10053g.m62491c("CBC", " cbc encrypt data error" + e10.getMessage());
            return new byte[0];
        }
    }

    /* renamed from: d */
    public static byte[] m56682d(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    /* renamed from: e */
    public static String m56683e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(6, 12) + str.substring(16, 26) + str.substring(32, 48);
        } catch (Exception e10) {
            C10053g.m62491c("CBC", "getIv exception : " + e10.getMessage());
            return "";
        }
    }

    /* renamed from: f */
    public static String m56684f(String str) {
        return (TextUtils.isEmpty(str) || str.indexOf("security:") == -1) ? "" : str.substring(9);
    }

    /* renamed from: g */
    public static byte[] m56685g(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, Constants.UTF_8);
        } catch (UnsupportedEncodingException e10) {
            C10053g.m62491c("CBC", "stripCryptHead: exception : " + e10.getMessage());
            str = "";
        }
        if (!str.startsWith("security:")) {
            return new byte[0];
        }
        if (bArr.length <= 9) {
            return new byte[0];
        }
        int length = bArr.length - 9;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 9, bArr2, 0, length);
        return bArr2;
    }

    /* renamed from: h */
    public static String m56686h(String str, String str2) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str)) {
            C10053g.m62491c("CBC", "decrypt 1 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            C10053g.m62491c("CBC", "decrypt 1 key is null");
            return "";
        }
        byte[] bArrM62477b = C10049c.m62477b(str2);
        if (bArrM62477b.length >= 16) {
            return m56687i(str, bArrM62477b);
        }
        C10053g.m62491c("CBC", "decrypt 1 key error: 1 key length less than 16 bytes.");
        return "";
    }

    /* renamed from: i */
    public static String m56687i(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            C10053g.m62491c("CBC", "decrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            C10053g.m62491c("CBC", "decrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            C10053g.m62491c("CBC", "decrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        }
        String strM56683e = m56683e(str);
        String strM56679a = m56679a(str);
        if (TextUtils.isEmpty(strM56683e)) {
            C10053g.m62491c("CBC", "decrypt 2 iv is null");
            return "";
        }
        if (!TextUtils.isEmpty(strM56679a)) {
            return m56688j(strM56679a, bArr, C10049c.m62477b(strM56683e));
        }
        C10053g.m62491c("CBC", "decrypt 2 encrypt content is null");
        return "";
    }

    /* renamed from: j */
    public static String m56688j(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            C10053g.m62491c("CBC", "decrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            C10053g.m62491c("CBC", "decrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            C10053g.m62491c("CBC", "decrypt 4 key error: 4 key length less than 16 bytes.");
            return "";
        }
        if (bArr2 == null) {
            C10053g.m62491c("CBC", "decrypt 4 iv is null");
            return "";
        }
        if (bArr2.length < 16) {
            C10053g.m62491c("CBC", "decrypt 4 iv error: 4 iv length less than 16 bytes.");
            return "";
        }
        try {
            return new String(m56689k(C10049c.m62477b(str), bArr, bArr2), Constants.UTF_8);
        } catch (UnsupportedEncodingException e10) {
            C10053g.m62491c("CBC", " cbc decrypt data error" + e10.getMessage());
            return "";
        }
    }

    /* renamed from: k */
    public static byte[] m56689k(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (bArr == null) {
            C10053g.m62491c("CBC", "decrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            C10053g.m62491c("CBC", "decrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            C10053g.m62491c("CBC", "decrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            C10053g.m62491c("CBC", "decrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            C10053g.m62491c("CBC", "decrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 16) {
            C10053g.m62491c("CBC", "decrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (NullPointerException e10) {
            C10053g.m62491c("CBC", "NullPointerException: " + e10.getMessage());
            return new byte[0];
        } catch (InvalidAlgorithmParameterException e11) {
            C10053g.m62491c("CBC", "InvalidAlgorithmParameterException: " + e11.getMessage());
            return new byte[0];
        } catch (InvalidKeyException e12) {
            C10053g.m62491c("CBC", "InvalidKeyException: " + e12.getMessage());
            return new byte[0];
        } catch (NoSuchAlgorithmException e13) {
            C10053g.m62491c("CBC", "NoSuchAlgorithmException: " + e13.getMessage());
            return new byte[0];
        } catch (BadPaddingException e14) {
            C10053g.m62491c("CBC", "BadPaddingException: " + e14.getMessage());
            C10053g.m62491c("CBC", "key is not right");
            return new byte[0];
        } catch (IllegalBlockSizeException e15) {
            C10053g.m62491c("CBC", "IllegalBlockSizeException: " + e15.getMessage());
            return new byte[0];
        } catch (NoSuchPaddingException e16) {
            C10053g.m62491c("CBC", "NoSuchPaddingException: " + e16.getMessage());
            return new byte[0];
        }
    }

    /* renamed from: l */
    public static String m56690l(String str, String str2) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str)) {
            C10053g.m62491c("CBC", "encrypt 1 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            C10053g.m62491c("CBC", "encrypt 1 key is null");
            return "";
        }
        byte[] bArrM62477b = C10049c.m62477b(str2);
        if (bArrM62477b.length >= 16) {
            return m56691m(str, bArrM62477b);
        }
        C10053g.m62491c("CBC", "encrypt 1 key error: 1 key length less than 16 bytes.");
        return "";
    }

    /* renamed from: m */
    public static String m56691m(String str, byte[] bArr) throws NoSuchAlgorithmException {
        if (TextUtils.isEmpty(str)) {
            C10053g.m62491c("CBC", "encrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            C10053g.m62491c("CBC", "encrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            C10053g.m62491c("CBC", "encrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        }
        byte[] bArrM62472d = C10048b.m62472d(16);
        byte[] bArrM56681c = m56681c(str, bArr, bArrM62472d);
        return (bArrM56681c == null || bArrM56681c.length == 0) ? "" : m56680b(C10049c.m62476a(bArrM62472d), C10049c.m62476a(bArrM56681c));
    }

    /* renamed from: n */
    public static byte[] m56692n(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArrM62472d = C10048b.m62472d(16);
        byte[] bArrM56693o = m56693o(bArr, bArr2, bArrM62472d);
        if (!Arrays.equals(bArrM56693o, new byte[0])) {
            return m56682d(bArrM62472d, bArrM56693o);
        }
        C10053g.m62491c("CBC", "encrypt encryptContent is null");
        return new byte[0];
    }

    /* renamed from: o */
    public static byte[] m56693o(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (bArr == null) {
            C10053g.m62491c("CBC", "encrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            C10053g.m62491c("CBC", "encrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            C10053g.m62491c("CBC", "encrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            C10053g.m62491c("CBC", "encrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            C10053g.m62491c("CBC", "encrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 16) {
            C10053g.m62491c("CBC", "encrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (NullPointerException e10) {
            C10053g.m62491c("CBC", "NullPointerException: " + e10.getMessage());
            return new byte[0];
        } catch (InvalidAlgorithmParameterException e11) {
            C10053g.m62491c("CBC", "InvalidAlgorithmParameterException: " + e11.getMessage());
            return new byte[0];
        } catch (InvalidKeyException e12) {
            C10053g.m62491c("CBC", "InvalidKeyException: " + e12.getMessage());
            return new byte[0];
        } catch (NoSuchAlgorithmException e13) {
            C10053g.m62491c("CBC", "NoSuchAlgorithmException: " + e13.getMessage());
            return new byte[0];
        } catch (BadPaddingException e14) {
            C10053g.m62491c("CBC", "BadPaddingException: " + e14.getMessage());
            return new byte[0];
        } catch (IllegalBlockSizeException e15) {
            C10053g.m62491c("CBC", "IllegalBlockSizeException: " + e15.getMessage());
            return new byte[0];
        } catch (NoSuchPaddingException e16) {
            C10053g.m62491c("CBC", "NoSuchPaddingException: " + e16.getMessage());
            return new byte[0];
        }
    }
}
