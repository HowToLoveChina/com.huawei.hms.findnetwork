package com.huawei.hms.support.hwid.common.p142b;

import android.text.TextUtils;
import com.huawei.hms.support.hwid.common.p146e.C6477g;
import com.huawei.secure.android.common.util.SafeBase64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import p297fu.AbstractC9773a;

/* renamed from: com.huawei.hms.support.hwid.common.b.b */
/* loaded from: classes8.dex */
public class C6465b {
    /* renamed from: a */
    public static PublicKey m36845a(String str) throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(AbstractC6464a.m36843a(str)));
    }

    /* renamed from: a */
    public static String m36844a(String str, String str2) {
        byte[] bArrDecode;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String strM60808a = AbstractC9773a.m60808a(str, m36845a(str2));
            return (TextUtils.isEmpty(strM60808a) || (bArrDecode = SafeBase64.decode(strM60808a, 0)) == null) ? "" : AbstractC6464a.m36841a(bArrDecode);
        } catch (Exception unused) {
            C6477g.m36905b("HwIdEncrypter", "rsaEncrpter Exception");
            return "";
        }
    }
}
