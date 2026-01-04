package com.huawei.hianalytics;

import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.secure.android.common.util.SafeBase64;
import gu.C10049c;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* renamed from: com.huawei.hianalytics.h */
/* loaded from: classes5.dex */
public class C4779h {

    /* renamed from: a */
    public static final Charset f21824a = StandardCharsets.UTF_8;

    /* renamed from: a */
    public static String m28889a(String str, String str2, String str3) {
        if (str == null || str3 == null || str3.isEmpty()) {
            HiLog.m28808e("RsaCipher", "content or public key is null");
            return "";
        }
        if (!"2.0".equals(str2)) {
            HiLog.m28808e("RsaCipher", "unsupported pubKey version: " + str2);
            return "";
        }
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(SafeBase64.decode(str, 0)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(1, publicKeyGeneratePublic);
            return C10049c.m62476a(cipher.doFinal(str3.getBytes(f21824a)));
        } catch (Throwable th2) {
            HiLog.m28808e("RsaCipher", "rsaEncrypt failed: " + th2.getMessage());
            return "";
        }
    }
}
