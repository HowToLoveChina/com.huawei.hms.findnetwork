package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;

/* renamed from: com.huawei.openalliance.ad.utils.ch */
/* loaded from: classes2.dex */
public class C7788ch {
    /* renamed from: a */
    public static RSAPublicKey m48036a(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(AbstractC7740an.m47532a(str)));
        } catch (Throwable th2) {
            AbstractC7185ho.m43823c("RSAEncryptUtil", "load public key err:" + th2.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m48037a(Context context, String str, String str2, RSAPublicKey rSAPublicKey) {
        String str3;
        if (context != null && C7845x.m48576j(context)) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !m48039a(rSAPublicKey)) {
            str3 = "content or public key or sign value is null";
        } else {
            try {
                Signature signature = Signature.getInstance("SHA256withRSA/PSS");
                signature.initVerify(rSAPublicKey);
                signature.update(str.getBytes(Constants.UTF_8));
                return signature.verify(Base64.decode(str2, 0));
            } catch (Throwable th2) {
                str3 = "check sign exception: " + th2.getClass().getSimpleName();
            }
        }
        AbstractC7185ho.m43823c("RSAEncryptUtil", str3);
        return false;
    }

    /* renamed from: a */
    public static boolean m48038a(String str, String str2, RSAPublicKey rSAPublicKey) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !m48039a(rSAPublicKey)) {
            str3 = "content or public key or sign value is null";
        } else {
            try {
                Signature signature = Signature.getInstance("SHA256WithRSA");
                signature.initVerify(rSAPublicKey);
                signature.update(str.getBytes(Constants.UTF_8));
                return signature.verify(Base64.decode(str2, 0));
            } catch (Throwable th2) {
                str3 = "check sign exception: " + th2.getClass().getSimpleName();
            }
        }
        AbstractC7185ho.m43823c("RSAEncryptUtil", str3);
        return false;
    }

    /* renamed from: a */
    private static boolean m48039a(RSAPublicKey rSAPublicKey) {
        return rSAPublicKey != null && rSAPublicKey.getModulus().bitLength() >= 3072;
    }
}
