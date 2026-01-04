package com.huawei.openalliance.p169ad;

/* renamed from: com.huawei.openalliance.ad.ha */
/* loaded from: classes8.dex */
public class C7171ha {

    /* renamed from: a */
    private static C7169gz f33010a;

    /* renamed from: b */
    private static final byte[] f33011b = new byte[0];

    /* renamed from: a */
    public static C7169gz m43672a() {
        C7169gz c7169gz;
        synchronized (f33011b) {
            AbstractC7185ho.m43817a("LinkedAdConfigurationDataShare", "get linked ad from linked");
            c7169gz = f33010a;
        }
        return c7169gz;
    }

    /* renamed from: a */
    public static void m43673a(C7169gz c7169gz) {
        synchronized (f33011b) {
            try {
                if (c7169gz == null) {
                    AbstractC7185ho.m43817a("LinkedAdConfigurationDataShare", "set linked ad from linked");
                    f33010a = null;
                } else {
                    f33010a = c7169gz;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public static void m43674a(String str) {
        synchronized (f33011b) {
            try {
                AbstractC7185ho.m43817a("LinkedAdConfigurationDataShare", "set soundSwitch for linked");
                C7169gz c7169gz = f33010a;
                if (c7169gz == null) {
                    return;
                }
                c7169gz.m43657a(str);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
