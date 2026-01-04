package com.baidu.location.p065a;

import android.annotation.SuppressLint;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

/* renamed from: com.baidu.location.a.b */
/* loaded from: classes.dex */
public class C1530b {

    /* renamed from: a */
    private static final String f6599a = "utf-8";

    /* renamed from: b */
    private static final String f6600b = "e7b8049d31a5c8bd948c0145";

    /* renamed from: c */
    private static final String f6601c = "20170601";

    /* renamed from: a */
    public static String m8686a(String str) throws Exception {
        return m8687a(f6600b, f6601c, str.getBytes("utf8"));
    }

    /* renamed from: b */
    public static String m8691b(String str) throws Exception {
        return new String(m8689a(f6600b, f6601c, str), "utf8");
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private static String m8687a(String str, String str2, byte[] bArr) {
        try {
            return Base64.encodeToString(m8690a(str.getBytes(f6599a), str2.getBytes(f6599a), bArr), 0);
        } catch (UnsupportedEncodingException e10) {
            throw new SecurityException(e10);
        }
    }

    /* renamed from: b */
    private static byte[] m8692b(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            cipher.init(2, SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(bArr)), new IvParameterSpec(bArr2));
            return cipher.doFinal(bArr3);
        } catch (Exception e10) {
            throw new SecurityException(e10);
        }
    }

    /* renamed from: a */
    public static String m8688a(byte[] bArr) throws Exception {
        return m8687a(f6600b, f6601c, bArr);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private static byte[] m8689a(String str, String str2, String str3) {
        try {
            return m8692b(str.getBytes(f6599a), str2.getBytes(f6599a), Base64.decode(new String(str3.getBytes(f6599a)), 0));
        } catch (UnsupportedEncodingException e10) {
            throw new SecurityException(e10);
        }
    }

    /* renamed from: a */
    private static byte[] m8690a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            cipher.init(1, SecretKeyFactory.getInstance("DESede").generateSecret(new DESedeKeySpec(bArr)), new IvParameterSpec(bArr2));
            return cipher.doFinal(bArr3);
        } catch (Exception e10) {
            throw new SecurityException(e10);
        }
    }
}
