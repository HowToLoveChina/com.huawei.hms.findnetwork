package com.huawei.openalliance.p169ad;

/* renamed from: com.huawei.openalliance.ad.mb */
/* loaded from: classes8.dex */
public class C7420mb {
    /* renamed from: a */
    public static int m45672a(float f10, float f11) {
        if (f11 >= 75.0f && f10 < 75.0f) {
            return 75;
        }
        if (f11 < 50.0f || f10 >= 50.0f) {
            return (f11 < 25.0f || f10 >= 25.0f) ? 0 : 25;
        }
        return 50;
    }
}
