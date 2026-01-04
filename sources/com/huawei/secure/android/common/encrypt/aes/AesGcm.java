package com.huawei.secure.android.common.encrypt.aes;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.constant.Constants;
import cu.C8952a;
import gu.C10048b;
import gu.C10049c;
import gu.C10053g;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes5.dex */
public final class AesGcm {
    /* renamed from: a */
    public static int m53572a(byte[] bArr) {
        return bArr[12] == 58 ? 12 : -1;
    }

    /* renamed from: b */
    public static String m53573b(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 24) ? "" : str.substring(24);
    }

    /* renamed from: c */
    public static byte[] m53574c(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            C10053g.m62491c("GCM", "encrypt 5 content is null");
            return new byte[0];
        }
        if (bArr == null) {
            C10053g.m62491c("GCM", "encrypt 5 key is null");
            return new byte[0];
        }
        if (bArr.length < 16) {
            C10053g.m62491c("GCM", "encrypt 5 key error: 5 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr2 == null) {
            C10053g.m62491c("GCM", "encrypt 5 iv is null");
            return new byte[0];
        }
        if (bArr2.length < 12) {
            C10053g.m62491c("GCM", "encrypt 5 iv error: 5 iv length less than 16 bytes.");
            return new byte[0];
        }
        if (!isBuildVersionHigherThan19()) {
            C10053g.m62491c("GCM", "encrypt 5 build version not higher than 19");
            return new byte[0];
        }
        try {
            return encrypt(str.getBytes(Constants.UTF_8), bArr, bArr2);
        } catch (UnsupportedEncodingException e10) {
            C10053g.m62491c("GCM", "GCM encrypt data error" + e10.getMessage());
            return new byte[0];
        }
    }

    /* renamed from: d */
    public static byte[] m53575d(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static String decrypt(String str, String str2) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str)) {
            C10053g.m62491c("GCM", "decrypt 1 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            C10053g.m62491c("GCM", "decrypt 1 key is null");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C10053g.m62491c("GCM", "decrypt 1 build version not higher than 19");
            return "";
        }
        byte[] bArrM62477b = C10049c.m62477b(str2);
        if (bArrM62477b.length >= 16) {
            return decrypt(str, bArrM62477b);
        }
        C10053g.m62491c("GCM", "decrypt 1 key error: 1 key length less than 16 bytes.");
        return "";
    }

    public static String decryptWithCryptHead(String str, byte[] bArr) throws UnsupportedEncodingException {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            String strM56684f = C8952a.m56684f(str);
            if ("".equals(strM56684f)) {
                return "";
            }
            int iIndexOf = strM56684f.indexOf(58);
            if (iIndexOf >= 0) {
                return decrypt(C10049c.m62476a(C10049c.m62477b(strM56684f.substring(iIndexOf + 1))), bArr, C10049c.m62477b(strM56684f.substring(0, iIndexOf)));
            }
            C10053g.m62491c("GCM", " gcm cipherText data missing colon");
        }
        return "";
    }

    public static byte[] decryptWithCryptHeadReturnByte(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length < 16) {
            return new byte[0];
        }
        byte[] bArrM56685g = C8952a.m56685g(bArr);
        if (bArrM56685g.length == 0) {
            return new byte[0];
        }
        int iM53572a = m53572a(bArrM56685g);
        if (iM53572a < 0) {
            C10053g.m62491c("GCM", " gcm cipherText data missing colon");
            return new byte[0];
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArrM56685g, iM53572a);
        int length = (bArrM56685g.length - bArrCopyOf.length) - 1;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArrM56685g, iM53572a + 1, bArr3, 0, length);
        return decrypt(bArr3, bArr2, bArrCopyOf);
    }

    /* renamed from: e */
    public static String m53576e(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 24) {
            return str.substring(0, 24);
        }
        C10053g.m62491c("GCM", "IV is invalid.");
        return "";
    }

    public static String encrypt(String str, String str2) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str)) {
            C10053g.m62491c("GCM", "encrypt 1 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            C10053g.m62491c("GCM", "encrypt 1 key is null");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C10053g.m62491c("GCM", "encrypt 1 build version not higher than 19");
            return "";
        }
        byte[] bArrM62477b = C10049c.m62477b(str2);
        if (bArrM62477b.length >= 16) {
            return encrypt(str, bArrM62477b);
        }
        C10053g.m62491c("GCM", "encrypt key error: key length less than 16 bytes.");
        return "";
    }

    /* renamed from: f */
    public static byte[] m53577f(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length - 12];
        System.arraycopy(bArr, 12, bArr2, 0, bArr.length - 12);
        return bArr2;
    }

    /* renamed from: g */
    public static byte[] m53578g(byte[] bArr) {
        if (bArr == null || bArr.length < 12) {
            C10053g.m62491c("GCM", "getIV error: bt length less than 12 bytes.");
            return new byte[0];
        }
        byte[] bArr2 = new byte[12];
        System.arraycopy(bArr, 0, bArr2, 0, 12);
        return bArr2;
    }

    public static AlgorithmParameterSpec getGcmAlgorithmParams(byte[] bArr) {
        return new GCMParameterSpec(128, bArr);
    }

    public static boolean isBuildVersionHigherThan19() {
        return true;
    }

    public static String decryptWithCryptHead(byte[] bArr, byte[] bArr2) {
        try {
            return new String(decryptWithCryptHeadReturnByte(bArr, bArr2), Constants.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            C10053g.m62491c("GCM", "UnsupportedEncodingException");
            return "";
        }
    }

    public static String decrypt(String str, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (TextUtils.isEmpty(str)) {
            C10053g.m62491c("GCM", "decrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            C10053g.m62491c("GCM", "decrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            C10053g.m62491c("GCM", "decrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C10053g.m62491c("GCM", "decrypt 2 build version not higher than 19");
            return "";
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            String strM53576e = m53576e(str);
            String strM53573b = m53573b(str);
            if (TextUtils.isEmpty(strM53576e)) {
                C10053g.m62491c("GCM", "decrypt 2 iv is null");
                return "";
            }
            if (TextUtils.isEmpty(strM53573b)) {
                C10053g.m62491c("GCM", "decrypt 2 encrypt content is null");
                return "";
            }
            cipher.init(2, secretKeySpec, getGcmAlgorithmParams(C10049c.m62477b(strM53576e)));
            return new String(cipher.doFinal(C10049c.m62477b(strM53573b)), Constants.UTF_8);
        } catch (UnsupportedEncodingException | NullPointerException | GeneralSecurityException e10) {
            C10053g.m62491c("GCM", "GCM decrypt data exception: " + e10.getMessage());
            return "";
        }
    }

    public static String encrypt(String str, byte[] bArr) throws NoSuchAlgorithmException {
        if (TextUtils.isEmpty(str)) {
            C10053g.m62491c("GCM", "encrypt 2 content is null");
            return "";
        }
        if (bArr == null) {
            C10053g.m62491c("GCM", "encrypt 2 key is null");
            return "";
        }
        if (bArr.length < 16) {
            C10053g.m62491c("GCM", "encrypt 2 key error: 2 key length less than 16 bytes.");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C10053g.m62491c("GCM", "encrypt 2 build version not higher than 19");
            return "";
        }
        byte[] bArrM62472d = C10048b.m62472d(12);
        byte[] bArrM53574c = m53574c(str, bArr, bArrM62472d);
        if (bArrM53574c == null || bArrM53574c.length == 0) {
            return "";
        }
        return C10049c.m62476a(bArrM62472d) + C10049c.m62476a(bArrM53574c);
    }

    public static String encrypt(String str, String str2, String str3) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str)) {
            C10053g.m62491c("GCM", "encrypt 3 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            C10053g.m62491c("GCM", "encrypt 3 key is null");
            return "";
        }
        if (TextUtils.isEmpty(str3)) {
            C10053g.m62491c("GCM", "encrypt 3 iv is null");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C10053g.m62491c("GCM", "encrypt 3 build version not higher than 19");
            return "";
        }
        byte[] bArrM62477b = C10049c.m62477b(str2);
        byte[] bArrM62477b2 = C10049c.m62477b(str3);
        if (bArrM62477b.length < 16) {
            C10053g.m62491c("GCM", "encrypt 3 key error: 3 key length less than 16 bytes.");
            return "";
        }
        if (bArrM62477b2.length < 12) {
            C10053g.m62491c("GCM", "encrypt 3 iv error: 3 iv length less than 16 bytes.");
            return "";
        }
        return encrypt(str, bArrM62477b, bArrM62477b2);
    }

    public static String decrypt(String str, String str2, String str3) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str)) {
            C10053g.m62491c("GCM", "decrypt 3 content is null");
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            C10053g.m62491c("GCM", "decrypt 3 key is null");
            return "";
        }
        if (TextUtils.isEmpty(str3)) {
            C10053g.m62491c("GCM", "decrypt 3 iv is null");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C10053g.m62491c("GCM", "decrypt 3 build version not higher than 19");
            return "";
        }
        byte[] bArrM62477b = C10049c.m62477b(str2);
        byte[] bArrM62477b2 = C10049c.m62477b(str3);
        if (bArrM62477b.length < 16) {
            C10053g.m62491c("GCM", "decrypt 3 key error: 3 key length less than 16 bytes.");
            return "";
        }
        if (bArrM62477b2.length < 12) {
            C10053g.m62491c("GCM", "decrypt 3 iv error: 3 iv length less than 16 bytes.");
            return "";
        }
        return decrypt(str, bArrM62477b, bArrM62477b2);
    }

    public static String encrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            C10053g.m62491c("GCM", "encrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            C10053g.m62491c("GCM", "encrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            C10053g.m62491c("GCM", "encrypt 4 key error: 3 key length less than 16 bytes.");
            return "";
        }
        if (bArr2 == null) {
            C10053g.m62491c("GCM", "encrypt 4 iv is null");
            return "";
        }
        if (bArr2.length < 12) {
            C10053g.m62491c("GCM", "encrypt 3 iv error: 3 iv length less than 16 bytes.");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C10053g.m62491c("GCM", "encrypt 4 build version not higher than 19");
            return "";
        }
        return C10049c.m62476a(m53574c(str, bArr, bArr2));
    }

    public static String decrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            C10053g.m62491c("GCM", "decrypt 4 content is null");
            return "";
        }
        if (bArr == null) {
            C10053g.m62491c("GCM", "decrypt 4 key is null");
            return "";
        }
        if (bArr.length < 16) {
            C10053g.m62491c("GCM", "decrypt 4 key error: 4 key length less than 16 bytes.");
            return "";
        }
        if (bArr2 == null) {
            C10053g.m62491c("GCM", "decrypt 4 iv is null");
            return "";
        }
        if (bArr2.length < 12) {
            C10053g.m62491c("GCM", "decrypt 4 iv error: 4 iv length less than 16 bytes.");
            return "";
        }
        if (!isBuildVersionHigherThan19()) {
            C10053g.m62491c("GCM", "decrypt 4 build version not higher than 19");
            return "";
        }
        try {
            return new String(decrypt(C10049c.m62477b(str), bArr, bArr2), Constants.UTF_8);
        } catch (UnsupportedEncodingException e10) {
            C10053g.m62491c("GCM", "GCM decrypt data exception: " + e10.getMessage());
            return "";
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (bArr == null) {
            C10053g.m62491c("GCM", "encrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            C10053g.m62491c("GCM", "encrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            C10053g.m62491c("GCM", "encrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            C10053g.m62491c("GCM", "encrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            C10053g.m62491c("GCM", "encrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 12) {
            C10053g.m62491c("GCM", "encrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        if (!isBuildVersionHigherThan19()) {
            C10053g.m62491c("GCM", "encrypt 6 build version not higher than 19");
            return new byte[0];
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, secretKeySpec, getGcmAlgorithmParams(bArr3));
            return cipher.doFinal(bArr);
        } catch (NullPointerException e10) {
            C10053g.m62491c("GCM", "GCM encrypt data error" + e10.getMessage());
            return new byte[0];
        } catch (GeneralSecurityException e11) {
            C10053g.m62491c("GCM", "GCM encrypt data error" + e11.getMessage());
            return new byte[0];
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (bArr == null) {
            C10053g.m62491c("GCM", "decrypt 6 content is null");
            return new byte[0];
        }
        if (bArr.length == 0) {
            C10053g.m62491c("GCM", "decrypt 6 content length is 0");
            return new byte[0];
        }
        if (bArr2 == null) {
            C10053g.m62491c("GCM", "decrypt 6 key is null");
            return new byte[0];
        }
        if (bArr2.length < 16) {
            C10053g.m62491c("GCM", "decrypt 6 key error: 6 key length less than 16 bytes.");
            return new byte[0];
        }
        if (bArr3 == null) {
            C10053g.m62491c("GCM", "decrypt 6 iv is null");
            return new byte[0];
        }
        if (bArr3.length < 12) {
            C10053g.m62491c("GCM", "decrypt 6 iv error: 6 iv length less than 16 bytes.");
            return new byte[0];
        }
        if (!isBuildVersionHigherThan19()) {
            C10053g.m62491c("GCM", "decrypt 6 build version not higher than 19");
            return new byte[0];
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, secretKeySpec, getGcmAlgorithmParams(bArr3));
            return cipher.doFinal(bArr);
        } catch (GeneralSecurityException e10) {
            C10053g.m62491c("GCM", "GCM decrypt data exception: " + e10.getMessage());
            return new byte[0];
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException {
        byte[] bArrM62472d = C10048b.m62472d(12);
        return m53575d(bArrM62472d, encrypt(bArr, bArr2, bArrM62472d));
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        byte[] bArrM53578g = m53578g(bArr);
        if (bArrM53578g.length < 12) {
            C10053g.m62491c("GCM", "get iv from content error.");
            return new byte[0];
        }
        return decrypt(m53577f(bArr), bArr2, bArrM53578g);
    }
}
