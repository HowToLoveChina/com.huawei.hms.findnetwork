package com.huawei.openalliance.p169ad.utils;

import java.security.SecureRandom;
import java.util.Random;

/* renamed from: com.huawei.openalliance.ad.utils.ci */
/* loaded from: classes2.dex */
public class C7789ci {
    /* renamed from: a */
    public static int m48040a(int i10, int i11) {
        if (i10 == i11) {
            return i11;
        }
        if (i11 > i10) {
            i11 = i10;
            i10 = i11;
        }
        return new SecureRandom().nextInt((i10 - i11) + 1) + i11;
    }

    /* renamed from: a */
    public static String m48041a(int i10) {
        Random random = new Random();
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append(random.nextInt(10));
        }
        return sb2.toString();
    }
}
