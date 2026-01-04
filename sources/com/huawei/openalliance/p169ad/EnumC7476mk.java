package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.constant.Constants;
import com.iab.omid.library.huawei.adsession.Owner;

/* renamed from: com.huawei.openalliance.ad.mk */
/* loaded from: classes8.dex */
public enum EnumC7476mk {
    NATIVE(Constants.NATIVE_CACHE),
    JAVASCRIPT("javascript"),
    NONE("none");


    /* renamed from: d */
    private static boolean f34665d;

    /* renamed from: e */
    private final String f34667e;

    /* renamed from: com.huawei.openalliance.ad.mk$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f34668a;

        static {
            int[] iArr = new int[EnumC7476mk.values().length];
            f34668a = iArr;
            try {
                iArr[EnumC7476mk.NATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34668a[EnumC7476mk.JAVASCRIPT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34668a[EnumC7476mk.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        f34665d = false;
        f34665d = C7418ma.m45655a("com.iab.omid.library.huawei.adsession.Owner");
    }

    EnumC7476mk(String str) {
        this.f34667e = str;
    }

    /* renamed from: a */
    public static Owner m45840a(EnumC7476mk enumC7476mk) {
        if (!f34665d) {
            return null;
        }
        int i10 = AnonymousClass1.f34668a[enumC7476mk.ordinal()];
        if (i10 == 1) {
            return Owner.NATIVE;
        }
        if (i10 == 2) {
            return Owner.JAVASCRIPT;
        }
        if (i10 != 3) {
            return null;
        }
        return Owner.NONE;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f34667e;
    }

    /* renamed from: a */
    public static boolean m45841a() {
        return f34665d;
    }
}
