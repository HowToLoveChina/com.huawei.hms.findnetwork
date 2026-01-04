package com.huawei.openalliance.p169ad;

import com.iab.omid.library.huawei.adsession.ImpressionType;

/* renamed from: com.huawei.openalliance.ad.mj */
/* loaded from: classes8.dex */
public enum EnumC7475mj {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    UNSPECIFIED("unspecified"),
    LOADED("loaded"),
    BEGIN_TO_RENDER("beginToRender"),
    ONE_PIXEL("onePixel"),
    VIEWABLE("viewable"),
    AUDIBLE("audible"),
    OTHER("other");


    /* renamed from: i */
    private static boolean f34658i;

    /* renamed from: j */
    private final String f34660j;

    /* renamed from: com.huawei.openalliance.ad.mj$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f34661a;

        static {
            int[] iArr = new int[EnumC7475mj.values().length];
            f34661a = iArr;
            try {
                iArr[EnumC7475mj.DEFINED_BY_JAVASCRIPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34661a[EnumC7475mj.UNSPECIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34661a[EnumC7475mj.LOADED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34661a[EnumC7475mj.BEGIN_TO_RENDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f34661a[EnumC7475mj.ONE_PIXEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f34661a[EnumC7475mj.VIEWABLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f34661a[EnumC7475mj.AUDIBLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f34661a[EnumC7475mj.OTHER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    static {
        f34658i = false;
        f34658i = C7418ma.m45655a("com.iab.omid.library.huawei.adsession.ImpressionType");
    }

    EnumC7475mj(String str) {
        this.f34660j = str;
    }

    /* renamed from: a */
    public static ImpressionType m45838a(EnumC7475mj enumC7475mj) {
        if (!f34658i) {
            return null;
        }
        switch (AnonymousClass1.f34661a[enumC7475mj.ordinal()]) {
            case 1:
                return ImpressionType.DEFINED_BY_JAVASCRIPT;
            case 2:
                return ImpressionType.UNSPECIFIED;
            case 3:
                return ImpressionType.LOADED;
            case 4:
                return ImpressionType.BEGIN_TO_RENDER;
            case 5:
                return ImpressionType.ONE_PIXEL;
            case 6:
                return ImpressionType.VIEWABLE;
            case 7:
                return ImpressionType.AUDIBLE;
            case 8:
                return ImpressionType.OTHER;
            default:
                return null;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f34660j;
    }

    /* renamed from: a */
    public static boolean m45839a() {
        return f34658i;
    }
}
