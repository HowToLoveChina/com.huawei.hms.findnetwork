package com.huawei.fastengine.fastview.download.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.fastengine.fastview.download.utils.log.FastViewLogUtils;
import com.huawei.hms.feature.dynamic.p119f.C5335e;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/* loaded from: classes5.dex */
public class CheckUtils {
    private static final String FASTAPP_ENGINE_HONOR_SIGN = "44e4b7869b67dae2acc278efbc86a922a4873be15bd58b4c5de0f224452c0815";
    private static final String FASTAPP_ENGINE_NEW_SIGN = "5fde302efa73b9033f5839d95f6d89848382eeb33194d1282080b31876492e28";
    private static final String FASTAPP_ENGINE_SIGN = "388dec495f1e93fffc91436e285a0d89b1499269b071d33ebbc7332ca7a2d426";
    private static final String TAG = "Utils";

    private static String bytesToHexString(byte[] bArr) {
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

    private static String handleSHA256(String str) throws NoSuchAlgorithmException {
        String str2;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA256");
            messageDigest.update(str.getBytes(Constants.UTF_8));
            return bytesToHexString(messageDigest.digest());
        } catch (UnsupportedEncodingException unused) {
            str2 = "UnsupportedEncodingException!";
            FastViewLogUtils.m28728w("Utils", str2);
            return "";
        } catch (NoSuchAlgorithmException unused2) {
            str2 = "NoSuchAlgorithmException!";
            FastViewLogUtils.m28728w("Utils", str2);
            return "";
        }
    }

    public static boolean isCorrectSign(Context context, String str) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException, CertificateException {
        String str2;
        String strHandleSHA256;
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            str2 = "isCorrectSign PackageManager null!";
        } else {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
                if (packageInfo == null) {
                    FastViewLogUtils.m28724e("Utils", "isCorrectSign PackageInfo null!");
                    return false;
                }
                Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr == null) {
                    FastViewLogUtils.m28724e("Utils", "isCorrectSign signs null!");
                    return false;
                }
                if (signatureArr[0] != null) {
                    Certificate certificateGenerateCertificate = CertificateFactory.getInstance(C5335e.f24726b).generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()));
                    if (!(certificateGenerateCertificate instanceof X509Certificate)) {
                        FastViewLogUtils.m28724e("Utils", "get X509Certificate failed!");
                        return false;
                    }
                    strHandleSHA256 = handleSHA256(Base64.encodeToString(((X509Certificate) certificateGenerateCertificate).getPublicKey().getEncoded(), 0));
                } else {
                    strHandleSHA256 = "";
                }
                return FASTAPP_ENGINE_SIGN.equals(strHandleSHA256) || FASTAPP_ENGINE_NEW_SIGN.equals(strHandleSHA256) || FASTAPP_ENGINE_HONOR_SIGN.equals(strHandleSHA256);
            } catch (PackageManager.NameNotFoundException unused) {
                str2 = "isCorrectSign PackageManager.NameNotFoundException!";
            } catch (CertificateException unused2) {
                str2 = "isCorrectSign CertificateException!";
            }
        }
        FastViewLogUtils.m28724e("Utils", str2);
        return false;
    }
}
