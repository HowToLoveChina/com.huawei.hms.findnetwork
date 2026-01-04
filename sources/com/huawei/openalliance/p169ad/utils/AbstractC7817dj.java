package com.huawei.openalliance.p169ad.utils;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.huawei.openalliance.ad.utils.dj */
/* loaded from: classes2.dex */
public abstract class AbstractC7817dj {

    /* renamed from: a */
    protected static final C7737ak f36093a = new C7737ak(new Handler(Looper.getMainLooper()));

    /* renamed from: a */
    public static void m48363a(Runnable runnable) {
        f36093a.m47501a(runnable);
    }

    /* renamed from: a */
    public static void m48364a(Runnable runnable, long j10) {
        f36093a.m47503a(runnable, null, j10);
    }

    /* renamed from: a */
    public static void m48365a(Runnable runnable, String str, long j10) {
        f36093a.m47503a(runnable, str, j10);
    }

    /* renamed from: a */
    public static void m48366a(String str) {
        f36093a.m47504a(str);
    }
}
