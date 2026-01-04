package com.huawei.openalliance.p169ad.utils;

import java.lang.reflect.Array;

/* renamed from: com.huawei.openalliance.ad.utils.l */
/* loaded from: classes2.dex */
public class C7833l {
    /* renamed from: a */
    public static int m48471a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return Array.getLength(obj);
    }

    /* renamed from: b */
    public static int m48475b(int[] iArr, int i10) {
        return m48472a(iArr, i10, 0);
    }

    /* renamed from: a */
    public static int m48472a(int[] iArr, int i10, int i11) {
        if (m48473a(iArr)) {
            return -1;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        while (i11 < iArr.length) {
            if (i10 == iArr[i11]) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    /* renamed from: a */
    public static boolean m48473a(int[] iArr) {
        return m48471a((Object) iArr) == 0;
    }

    /* renamed from: a */
    public static boolean m48474a(int[] iArr, int i10) {
        return m48475b(iArr, i10) != -1;
    }
}
