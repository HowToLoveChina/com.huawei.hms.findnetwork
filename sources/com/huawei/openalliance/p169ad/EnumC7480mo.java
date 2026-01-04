package com.huawei.openalliance.p169ad;

import com.iab.omid.library.huawei.adsession.media.InteractionType;

/* renamed from: com.huawei.openalliance.ad.mo */
/* loaded from: classes8.dex */
public enum EnumC7480mo {
    CLICK("click"),
    INVITATION_ACCEPTED("invitationAccept");


    /* renamed from: d */
    private static boolean f34673d;

    /* renamed from: c */
    String f34675c;

    /* renamed from: com.huawei.openalliance.ad.mo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f34676a;

        static {
            int[] iArr = new int[EnumC7480mo.values().length];
            f34676a = iArr;
            try {
                iArr[EnumC7480mo.CLICK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34676a[EnumC7480mo.INVITATION_ACCEPTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        f34673d = false;
        f34673d = C7418ma.m45655a("com.iab.omid.library.huawei.adsession.media.InteractionType");
    }

    EnumC7480mo(String str) {
        this.f34675c = str;
    }

    /* renamed from: a */
    public static InteractionType m45846a(EnumC7480mo enumC7480mo) {
        if (!f34673d) {
            return null;
        }
        int i10 = AnonymousClass1.f34676a[enumC7480mo.ordinal()];
        if (i10 == 1) {
            return InteractionType.CLICK;
        }
        if (i10 != 2) {
            return null;
        }
        return InteractionType.INVITATION_ACCEPTED;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f34675c;
    }

    /* renamed from: a */
    public static boolean m45847a() {
        return f34673d;
    }
}
