package com.huawei.openalliance.p169ad;

import com.iab.omid.library.huawei.adsession.FriendlyObstructionPurpose;

/* renamed from: com.huawei.openalliance.ad.mh */
/* loaded from: classes8.dex */
public enum EnumC7473mh {
    VIDEO_CONTROLS,
    CLOSE_AD,
    NOT_VISIBLE,
    OTHER;


    /* renamed from: e */
    private static boolean f34647e;

    /* renamed from: com.huawei.openalliance.ad.mh$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f34649a;

        static {
            int[] iArr = new int[EnumC7473mh.values().length];
            f34649a = iArr;
            try {
                iArr[EnumC7473mh.VIDEO_CONTROLS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34649a[EnumC7473mh.CLOSE_AD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34649a[EnumC7473mh.NOT_VISIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f34649a[EnumC7473mh.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        f34647e = false;
        f34647e = C7418ma.m45655a("com.iab.omid.library.huawei.adsession.FriendlyObstructionPurpose");
    }

    /* renamed from: a */
    public static FriendlyObstructionPurpose m45836a(EnumC7473mh enumC7473mh) {
        if (!f34647e) {
            return null;
        }
        int i10 = AnonymousClass1.f34649a[enumC7473mh.ordinal()];
        if (i10 == 1) {
            return FriendlyObstructionPurpose.VIDEO_CONTROLS;
        }
        if (i10 == 2) {
            return FriendlyObstructionPurpose.CLOSE_AD;
        }
        if (i10 == 3) {
            return FriendlyObstructionPurpose.NOT_VISIBLE;
        }
        if (i10 != 4) {
            return null;
        }
        return FriendlyObstructionPurpose.OTHER;
    }

    /* renamed from: a */
    public static boolean m45837a() {
        return f34647e;
    }
}
