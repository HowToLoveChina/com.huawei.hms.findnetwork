package p238dv;

/* renamed from: dv.f */
/* loaded from: classes9.dex */
public enum EnumC9316f {
    PURPOSE_CRYPTO(3),
    PURPOSE_SIGN(12),
    PURPOSE_ALL(15);


    /* renamed from: a */
    public final int f46694a;

    EnumC9316f(int i10) {
        this.f46694a = i10;
    }

    /* renamed from: b */
    public static boolean m58645b(EnumC9316f enumC9316f, EnumC9316f enumC9316f2) {
        int i10 = enumC9316f.f46694a;
        int i11 = enumC9316f2.f46694a;
        return (i10 & i11) == i11;
    }

    /* renamed from: e */
    public int m58646e() {
        return this.f46694a;
    }
}
