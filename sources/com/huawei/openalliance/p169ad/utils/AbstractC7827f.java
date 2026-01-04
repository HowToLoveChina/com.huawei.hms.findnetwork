package com.huawei.openalliance.p169ad.utils;

import android.text.TextUtils;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.huawei.openalliance.ad.utils.f */
/* loaded from: classes2.dex */
public abstract class AbstractC7827f {
    /* renamed from: a */
    private static String m48393a(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 24) {
            return str.substring(0, 24);
        }
        AbstractC7185ho.m43820b("Aes128", "IV is invalid.");
        return "";
    }

    /* renamed from: b */
    private static String m48399b(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 24) ? "" : str.substring(24);
    }

    /* renamed from: c */
    private static String m48402c(String str, byte[] bArr) {
        byte[] bArrM48081a;
        byte[] bArrM48397a;
        if (TextUtils.isEmpty(str) || !m48401b(bArr) || !m48395a() || (bArrM48397a = m48397a(str, bArr, (bArrM48081a = AbstractC7796cp.m48081a(12)))) == null || bArrM48397a.length == 0) {
            return "";
        }
        return AbstractC7740an.m47531a(bArrM48081a) + AbstractC7740an.m47531a(bArrM48397a);
    }

    /* renamed from: d */
    private static String m48404d(String str, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (!TextUtils.isEmpty(str) && m48401b(bArr) && m48395a()) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                String strM48393a = m48393a(str);
                String strM48399b = m48399b(str);
                if (TextUtils.isEmpty(strM48393a) || TextUtils.isEmpty(strM48399b)) {
                    AbstractC7185ho.m43820b("Aes128", "ivParameter or encrypedWord is null");
                    return "";
                }
                cipher.init(2, secretKeySpec, m48403c(AbstractC7740an.m47532a(strM48393a)));
                return new String(cipher.doFinal(AbstractC7740an.m47532a(strM48399b)), Constants.UTF_8);
            } catch (UnsupportedEncodingException | GeneralSecurityException e10) {
                AbstractC7185ho.m43826d("Aes128", "GCM decrypt data exception: " + e10.getMessage());
            }
        }
        return "";
    }

    /* renamed from: a */
    public static String m48394a(String str, byte[] bArr) {
        StringBuilder sb2;
        if (!AbstractC7806cz.m48165b(str) && bArr != null && bArr.length != 0) {
            try {
                if (m48395a()) {
                    return m48402c(str, bArr);
                }
            } catch (Exception e10) {
                e = e10;
                sb2 = new StringBuilder();
                sb2.append("fail to cipher: ");
                sb2.append(e.getClass().getSimpleName());
                AbstractC7185ho.m43823c("Aes128", sb2.toString());
                AbstractC7185ho.m43815a(3, e);
                return "";
            } catch (Throwable th2) {
                e = th2;
                sb2 = new StringBuilder();
                sb2.append("fail to cipher: ");
                sb2.append(e.getClass().getSimpleName());
                AbstractC7185ho.m43823c("Aes128", sb2.toString());
                AbstractC7185ho.m43815a(3, e);
                return "";
            }
        }
        return "";
    }

    /* renamed from: b */
    public static String m48400b(String str, byte[] bArr) {
        if (!AbstractC7806cz.m48165b(str) && str.length() >= 32 && bArr != null && bArr.length != 0) {
            try {
                if (m48395a()) {
                    return m48404d(str, bArr);
                }
            } catch (Exception e10) {
                e = e10;
                AbstractC7185ho.m43823c("Aes128", "fail to decrypt: " + e.getClass().getSimpleName());
                AbstractC7185ho.m43818a("Aes128", "input: %s", AbstractC7819dl.m48375a(AbstractC7740an.m47531a(bArr)));
                AbstractC7185ho.m43815a(3, e);
                return "";
            } catch (Throwable th2) {
                e = th2;
                AbstractC7185ho.m43823c("Aes128", "fail to decrypt: " + e.getClass().getSimpleName());
                AbstractC7185ho.m43818a("Aes128", "input: %s", AbstractC7819dl.m48375a(AbstractC7740an.m47531a(bArr)));
                AbstractC7185ho.m43815a(3, e);
                return "";
            }
        }
        return "";
    }

    /* renamed from: c */
    private static AlgorithmParameterSpec m48403c(byte[] bArr) {
        return new GCMParameterSpec(128, bArr);
    }

    /* renamed from: a */
    private static boolean m48395a() {
        return true;
    }

    /* renamed from: b */
    private static boolean m48401b(byte[] bArr) {
        return bArr != null && bArr.length >= 16;
    }

    /* renamed from: a */
    private static boolean m48396a(byte[] bArr) {
        return bArr != null && bArr.length >= 12;
    }

    /* renamed from: a */
    private static byte[] m48397a(String str, byte[] bArr, byte[] bArr2) {
        if (!TextUtils.isEmpty(str) && m48401b(bArr) && m48396a(bArr2) && m48395a()) {
            try {
                return m48398a(str.getBytes(Constants.UTF_8), bArr, bArr2);
            } catch (UnsupportedEncodingException e10) {
                AbstractC7185ho.m43826d("Aes128", "GCM encrypt data error" + e10.getMessage());
            }
        } else {
            AbstractC7185ho.m43820b("Aes128", "gcm encrypt param is not right");
        }
        return new byte[0];
    }

    /* renamed from: a */
    public static byte[] m48398a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (AbstractC7760bg.m47768a(bArr)) {
            return new byte[0];
        }
        if (m48401b(bArr2) && m48396a(bArr3) && m48395a()) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                cipher.init(1, secretKeySpec, m48403c(bArr3));
                return cipher.doFinal(bArr);
            } catch (GeneralSecurityException e10) {
                AbstractC7185ho.m43826d("Aes128", "GCM encrypt data error" + e10.getMessage());
            }
        } else {
            AbstractC7185ho.m43820b("Aes128", "gcm encrypt param is not right");
        }
        return new byte[0];
    }
}
