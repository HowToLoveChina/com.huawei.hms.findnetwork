package com.huawei.hms.hatool;

import android.util.Log;

/* renamed from: com.huawei.hms.hatool.m0 */
/* loaded from: classes8.dex */
public class C5550m0 {

    /* renamed from: a */
    private boolean f25256a = false;

    /* renamed from: b */
    private int f25257b = 4;

    /* renamed from: a */
    private static String m32637a() {
        return "FormalHASDK_2.2.0.315" + C5558p.m32683a();
    }

    /* renamed from: b */
    public void m32640b(int i10, String str, String str2) {
        m32639a(i10, "FormalHASDK", str + "=> " + str2);
    }

    /* renamed from: a */
    public void m32638a(int i10) {
        Log.i("FormalHASDK", System.lineSeparator() + "======================================= " + System.lineSeparator() + m32637a() + "" + System.lineSeparator() + "=======================================");
        this.f25257b = i10;
        this.f25256a = true;
    }

    /* renamed from: b */
    public boolean m32641b(int i10) {
        return this.f25256a && i10 >= this.f25257b;
    }

    /* renamed from: a */
    public void m32639a(int i10, String str, String str2) {
        if (i10 == 3) {
            Log.d(str, str2);
            return;
        }
        if (i10 == 5) {
            Log.w(str, str2);
        } else if (i10 != 6) {
            Log.i(str, str2);
        } else {
            Log.e(str, str2);
        }
    }
}
