package com.huawei.phoneservice.feedbackcommon.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.huawei.phoneservice.feedbackcommon.utils.g */
/* loaded from: classes5.dex */
public final class C8667g {
    /* renamed from: a */
    public static String m53436a(String str, String str2) {
        byte[] bArrEncode = !TextUtils.isEmpty(str2) ? Base64.encode(m53437b(str, str2), 2) : null;
        if (bArrEncode == null) {
            return null;
        }
        return new String(bArrEncode, Charset.forName(Constants.UTF_8));
    }

    /* renamed from: b */
    public static byte[] m53437b(String str, String str2) throws Throwable {
        StringBuilder sb2;
        String str3;
        byte[] bytes = str.getBytes(Charset.forName(Constants.UTF_8));
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(Charset.forName(Constants.UTF_8)), "HmacSHA256");
        try {
            Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
            mac.init(secretKeySpec);
            return mac.doFinal(bytes);
        } catch (InvalidKeyException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str3 = "digest2Byte failed because of InvalidKeyException. ";
            sb2.append(str3);
            sb2.append(e.getMessage());
            FaqLogger.m51840e("HMAC256Utils", sb2.toString());
            return new byte[0];
        } catch (NoSuchAlgorithmException e11) {
            e = e11;
            sb2 = new StringBuilder();
            str3 = "digest2Byte failed because of NoSuchAlgorithmException. ";
            sb2.append(str3);
            sb2.append(e.getMessage());
            FaqLogger.m51840e("HMAC256Utils", sb2.toString());
            return new byte[0];
        }
    }
}
