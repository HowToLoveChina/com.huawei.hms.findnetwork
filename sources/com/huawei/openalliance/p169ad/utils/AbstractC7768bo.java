package com.huawei.openalliance.p169ad.utils;

/* renamed from: com.huawei.openalliance.ad.utils.bo */
/* loaded from: classes2.dex */
public abstract class AbstractC7768bo {

    /* renamed from: a */
    private static final C7738al f35952a;

    static {
        C7738al c7738al = new C7738al("pps-msg-queue");
        f35952a = c7738al;
        c7738al.m47517a();
    }

    /* renamed from: a */
    public static void m47807a(Runnable runnable) {
        f35952a.m47518a(runnable);
    }

    /* renamed from: a */
    public static void m47808a(Runnable runnable, long j10) {
        f35952a.m47519a(runnable, null, j10);
    }

    /* renamed from: a */
    public static void m47809a(Runnable runnable, String str, long j10) {
        f35952a.m47519a(runnable, str, j10);
    }

    /* renamed from: a */
    public static void m47810a(String str) {
        f35952a.m47520a(str);
    }
}
