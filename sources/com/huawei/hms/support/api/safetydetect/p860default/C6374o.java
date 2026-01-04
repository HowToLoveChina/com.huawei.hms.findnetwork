package com.huawei.hms.support.api.safetydetect.p860default;

import android.util.Log;
import gu.C10048b;

/* renamed from: com.huawei.hms.support.api.safetydetect.default.o */
/* loaded from: classes8.dex */
public class C6374o {

    /* renamed from: a */
    private static final String f29893a = "o";

    /* renamed from: a */
    public static byte[] m36745a(int i10) {
        try {
            C10048b.m62475g(true);
            return C10048b.m62472d(i10);
        } catch (Exception e10) {
            Log.e(f29893a, "generateSecureRandom: exception : " + e10.getMessage());
            return new byte[0];
        }
    }
}
