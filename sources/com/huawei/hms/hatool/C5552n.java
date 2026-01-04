package com.huawei.hms.hatool;

import android.util.Pair;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.encrypt.aes.AesGcm;
import cu.C8952a;
import gu.C10049c;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* renamed from: com.huawei.hms.hatool.n */
/* loaded from: classes8.dex */
public class C5552n {

    /* renamed from: a */
    public static final Charset f25264a = Charset.forName(Constants.UTF_8);

    /* renamed from: a */
    public static Pair<byte[], String> m32651a(String str, int i10) {
        if (str == null || str.length() < i10) {
            return new Pair<>(new byte[0], str);
        }
        String strSubstring = str.substring(0, i10);
        return new Pair<>(C10049c.m62477b(strSubstring), str.substring(i10));
    }

    /* renamed from: b */
    public static String m32654b(String str, String str2) {
        return C10049c.m62476a(C8952a.m56692n(str.getBytes(f25264a), C10049c.m62477b(str2)));
    }

    /* renamed from: a */
    public static String m32652a(String str, String str2) {
        Pair<byte[], String> pairM32651a = m32651a(str, 32);
        return new String(C8952a.m56689k(C10049c.m62477b((String) pairM32651a.second), C10049c.m62477b(str2), (byte[]) pairM32651a.first), f25264a);
    }

    /* renamed from: a */
    public static String m32653a(byte[] bArr, String str) throws UnsupportedEncodingException {
        String str2;
        if (bArr == null || bArr.length == 0 || str == null) {
            str2 = "cbc encrypt(byte) param is not right";
        } else {
            byte[] bArrM62477b = C10049c.m62477b(str);
            if (bArrM62477b.length >= 16) {
                return C10049c.m62476a(AesGcm.encrypt(bArr, bArrM62477b));
            }
            str2 = "key length is not right";
        }
        C5571v.m32789b("AesCipher", str2);
        return "";
    }
}
