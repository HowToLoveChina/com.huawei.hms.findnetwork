package com.huawei.hms.hwid;

import android.os.Looper;

/* renamed from: com.huawei.hms.hwid.r */
/* loaded from: classes8.dex */
public class C5620r {
    /* renamed from: a */
    public static void m32955a() {
        m32956a("Must not be called on the main application thread");
    }

    /* renamed from: a */
    public static void m32956a(String str) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            throw new IllegalStateException(str);
        }
    }
}
