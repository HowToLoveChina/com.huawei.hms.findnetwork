package com.huawei.hms.locationSdk;

/* renamed from: com.huawei.hms.locationSdk.g1 */
/* loaded from: classes8.dex */
public class C5718g1 extends C5766w1 {

    /* renamed from: b */
    private static volatile C5718g1 f25516b;

    /* renamed from: c */
    private static final byte[] f25517c = new byte[0];

    /* renamed from: b */
    public static C5718g1 m33086b() {
        if (f25516b == null) {
            synchronized (f25517c) {
                try {
                    if (f25516b == null) {
                        f25516b = new C5718g1();
                    }
                } finally {
                }
            }
        }
        return f25516b;
    }
}
