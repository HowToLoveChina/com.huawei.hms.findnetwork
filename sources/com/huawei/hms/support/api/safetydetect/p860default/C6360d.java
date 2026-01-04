package com.huawei.hms.support.api.safetydetect.p860default;

import android.util.Base64;
import android.util.Log;

/* renamed from: com.huawei.hms.support.api.safetydetect.default.d */
/* loaded from: classes8.dex */
public class C6360d {
    /* renamed from: a */
    public static byte[] m36730a(String str) {
        byte[] bArr = new byte[0];
        if (str == null) {
            return new byte[0];
        }
        try {
            return Base64.decode(str, 2);
        } catch (Exception e10) {
            Log.e("Base64Util", "Base64 Decode failed, " + e10.getMessage());
            return bArr;
        }
    }
}
