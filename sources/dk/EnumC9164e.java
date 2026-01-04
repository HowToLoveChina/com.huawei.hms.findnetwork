package dk;

/* renamed from: dk.e */
/* loaded from: classes6.dex */
public enum EnumC9164e {
    LEVEL_0,
    LEVEL_1,
    LEVEL_2,
    LEVEL_3,
    UNKNOWN;

    /* renamed from: b */
    public static EnumC9164e m57586b(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? UNKNOWN : LEVEL_3 : LEVEL_2 : LEVEL_1 : LEVEL_0;
    }
}
