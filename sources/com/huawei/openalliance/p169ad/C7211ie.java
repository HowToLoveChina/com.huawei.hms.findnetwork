package com.huawei.openalliance.p169ad;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.openalliance.ad.ie */
/* loaded from: classes8.dex */
public class C7211ie {

    /* renamed from: b */
    private static C7211ie f33188b;

    /* renamed from: a */
    private static final byte[] f33187a = new byte[0];

    /* renamed from: c */
    private static final byte[] f33189c = new byte[0];

    /* renamed from: d */
    private static Map<String, Long> f33190d = new HashMap();

    /* renamed from: e */
    private static boolean f33191e = false;

    private C7211ie() {
    }

    /* renamed from: c */
    private static C7211ie m43921c() {
        C7211ie c7211ie;
        synchronized (f33187a) {
            try {
                if (f33188b == null) {
                    f33188b = new C7211ie();
                }
                c7211ie = f33188b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7211ie;
    }

    /* renamed from: a */
    public long m43922a(String str) {
        synchronized (f33189c) {
            try {
                if (f33190d.containsKey(str)) {
                    return f33190d.get(str).longValue();
                }
                f33190d.put(str, 0L);
                return 0L;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    public void m43924b() {
        synchronized (f33189c) {
            f33190d.clear();
            m43920a(false);
        }
    }

    /* renamed from: a */
    public static C7211ie m43919a() {
        return m43921c();
    }

    /* renamed from: b */
    public void m43925b(boolean z10) {
        synchronized (f33189c) {
            m43920a(z10);
        }
    }

    /* renamed from: a */
    public void m43923a(String str, long j10) {
        synchronized (f33189c) {
            try {
                if (f33190d.containsKey(str)) {
                    f33190d.put(str, Long.valueOf(f33190d.get(str).longValue() + j10));
                } else {
                    f33190d.put(str, Long.valueOf(j10));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static void m43920a(boolean z10) {
        f33191e = z10;
    }
}
