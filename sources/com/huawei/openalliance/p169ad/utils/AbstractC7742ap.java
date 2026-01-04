package com.huawei.openalliance.p169ad.utils;

import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.huawei.openalliance.ad.utils.ap */
/* loaded from: classes2.dex */
public abstract class AbstractC7742ap {

    /* renamed from: a */
    private static final String f35830a = "ap";

    /* renamed from: a */
    public static String m47597a(String str, String str2) throws NoSuchAlgorithmException, InvalidKeyException {
        String str3;
        String str4;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(str.getBytes(Constants.UTF_8), "HmacSHA256"));
            return AbstractC7740an.m47531a(mac.doFinal(str2.getBytes(Constants.UTF_8)));
        } catch (UnsupportedEncodingException unused) {
            str3 = f35830a;
            str4 = "fail to cipher UnsupportedEncodingException";
            AbstractC7185ho.m43826d(str3, str4);
            return null;
        } catch (InvalidKeyException unused2) {
            str3 = f35830a;
            str4 = "fail to cipher InvalidKeyException";
            AbstractC7185ho.m43826d(str3, str4);
            return null;
        } catch (NoSuchAlgorithmException unused3) {
            str3 = f35830a;
            str4 = "fail to cipher NoSuchAlgorithmException";
            AbstractC7185ho.m43826d(str3, str4);
            return null;
        }
    }
}
