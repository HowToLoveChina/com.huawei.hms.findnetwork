package com.huawei.openalliance.p169ad;

import com.iab.omid.library.huawei.adsession.media.Position;

/* renamed from: com.huawei.openalliance.ad.mp */
/* loaded from: classes8.dex */
public enum EnumC7481mp {
    PREROLL("preroll"),
    MIDROLL("midroll"),
    POSTROLL("postroll"),
    STANDALONE("standalone");


    /* renamed from: e */
    private static boolean f34681e;

    /* renamed from: f */
    private final String f34683f;

    /* renamed from: com.huawei.openalliance.ad.mp$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f34684a;

        static {
            int[] iArr = new int[EnumC7481mp.values().length];
            f34684a = iArr;
            try {
                iArr[EnumC7481mp.PREROLL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34684a[EnumC7481mp.MIDROLL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34684a[EnumC7481mp.POSTROLL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34684a[EnumC7481mp.STANDALONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        f34681e = false;
        f34681e = C7418ma.m45655a("com.iab.omid.library.huawei.adsession.media.Position");
    }

    EnumC7481mp(String str) {
        this.f34683f = str;
    }

    /* renamed from: a */
    public static Position m45848a(EnumC7481mp enumC7481mp) {
        if (!f34681e) {
            return null;
        }
        int i10 = AnonymousClass1.f34684a[enumC7481mp.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return Position.PREROLL;
        }
        if (i10 == 3) {
            return Position.POSTROLL;
        }
        if (i10 != 4) {
            return null;
        }
        return Position.STANDALONE;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f34683f;
    }
}
