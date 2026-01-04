package com.huawei.hms.network.embedded;

/* renamed from: com.huawei.hms.network.embedded.wb */
/* loaded from: classes8.dex */
public final class C6144wb {

    /* renamed from: a */
    public static final long f28903a = 65536;

    /* renamed from: b */
    public static C6131vb f28904b;

    /* renamed from: c */
    public static long f28905c;

    /* renamed from: a */
    public static C6131vb m35760a() {
        synchronized (C6144wb.class) {
            try {
                C6131vb c6131vb = f28904b;
                if (c6131vb == null) {
                    return new C6131vb();
                }
                f28904b = c6131vb.f28803f;
                c6131vb.f28803f = null;
                f28905c -= 8192;
                return c6131vb;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static void m35761a(C6131vb c6131vb) {
        if (c6131vb.f28803f != null || c6131vb.f28804g != null) {
            throw new IllegalArgumentException();
        }
        if (c6131vb.f28801d) {
            return;
        }
        synchronized (C6144wb.class) {
            try {
                long j10 = f28905c;
                if (j10 + 8192 > f28903a) {
                    return;
                }
                f28905c = j10 + 8192;
                c6131vb.f28803f = f28904b;
                c6131vb.f28800c = 0;
                c6131vb.f28799b = 0;
                f28904b = c6131vb;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
