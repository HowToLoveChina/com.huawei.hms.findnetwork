package com.huawei.hms.locationSdk;

/* renamed from: com.huawei.hms.locationSdk.d1 */
/* loaded from: classes8.dex */
public class C5706d1 extends C5766w1 {

    /* renamed from: b */
    private static volatile C5706d1 f25506b;

    /* renamed from: c */
    private static final byte[] f25507c = new byte[0];

    /* renamed from: b */
    public static C5706d1 m33063b() {
        if (f25506b == null) {
            synchronized (f25507c) {
                try {
                    if (f25506b == null) {
                        f25506b = new C5706d1();
                    }
                } finally {
                }
            }
        }
        return f25506b;
    }
}
