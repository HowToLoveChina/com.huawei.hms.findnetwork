package com.huawei.hms.feature.dynamic.p119f;

import android.util.Base64;
import com.huawei.hms.common.util.Logger;

/* renamed from: com.huawei.hms.feature.dynamic.f.a */
/* loaded from: classes8.dex */
public abstract class AbstractC5331a {

    /* renamed from: a */
    public static final String f24713a = "Base64";

    /* renamed from: a */
    public static String m31886a(byte[] bArr) {
        String strEncodeToString;
        if (bArr == null) {
            return "";
        }
        try {
            strEncodeToString = Base64.encodeToString(bArr, 2);
        } catch (AssertionError e10) {
            Logger.m30738e(f24713a, "An exception occurred while encoding with Base64,AssertionError:", e10);
        }
        return strEncodeToString != null ? strEncodeToString : "";
    }

    /* renamed from: a */
    public static byte[] m31887a(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 2);
            if (bArrDecode != null) {
                return bArrDecode;
            }
        } catch (IllegalArgumentException e10) {
            Logger.m30738e(f24713a, "Decoding with Base64 IllegalArgumentException:", e10);
        }
        return new byte[0];
    }
}
