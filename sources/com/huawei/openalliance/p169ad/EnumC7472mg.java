package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.constant.Constants;
import com.iab.omid.library.huawei.adsession.CreativeType;

/* renamed from: com.huawei.openalliance.ad.mg */
/* loaded from: classes8.dex */
public enum EnumC7472mg {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    VIDEO(Constants.VIDEO_SUB_DIR),
    AUDIO("audio");


    /* renamed from: f */
    private static boolean f34639f;

    /* renamed from: g */
    private final String f34641g;

    /* renamed from: com.huawei.openalliance.ad.mg$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f34642a;

        static {
            int[] iArr = new int[EnumC7472mg.values().length];
            f34642a = iArr;
            try {
                iArr[EnumC7472mg.DEFINED_BY_JAVASCRIPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34642a[EnumC7472mg.HTML_DISPLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34642a[EnumC7472mg.NATIVE_DISPLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34642a[EnumC7472mg.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f34642a[EnumC7472mg.AUDIO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        f34639f = false;
        f34639f = C7418ma.m45655a("com.iab.omid.library.huawei.adsession.CreativeType");
    }

    EnumC7472mg(String str) {
        this.f34641g = str;
    }

    /* renamed from: a */
    public static CreativeType m45834a(EnumC7472mg enumC7472mg) {
        if (!f34639f) {
            return null;
        }
        int i10 = AnonymousClass1.f34642a[enumC7472mg.ordinal()];
        if (i10 == 1) {
            return CreativeType.DEFINED_BY_JAVASCRIPT;
        }
        if (i10 == 2) {
            return CreativeType.HTML_DISPLAY;
        }
        if (i10 == 3) {
            return CreativeType.NATIVE_DISPLAY;
        }
        if (i10 == 4) {
            return CreativeType.VIDEO;
        }
        if (i10 != 5) {
            return null;
        }
        return CreativeType.AUDIO;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f34641g;
    }

    /* renamed from: a */
    public static boolean m45835a() {
        return f34639f;
    }
}
