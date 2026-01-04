package p502nx;

/* renamed from: nx.a */
/* loaded from: classes9.dex */
public enum EnumC11761a {
    KEY_STRENGTH_128(1, 8, 16, 16),
    KEY_STRENGTH_192(2, 12, 24, 24),
    KEY_STRENGTH_256(3, 16, 32, 32);


    /* renamed from: a */
    public int f54330a;

    /* renamed from: b */
    public int f54331b;

    /* renamed from: c */
    public int f54332c;

    /* renamed from: d */
    public int f54333d;

    EnumC11761a(int i10, int i11, int i12, int i13) {
        this.f54330a = i10;
        this.f54331b = i11;
        this.f54332c = i12;
        this.f54333d = i13;
    }

    /* renamed from: b */
    public static EnumC11761a m70085b(int i10) {
        for (EnumC11761a enumC11761a : values()) {
            if (enumC11761a.m70088h() == i10) {
                return enumC11761a;
            }
        }
        return null;
    }

    /* renamed from: e */
    public int m70086e() {
        return this.f54333d;
    }

    /* renamed from: f */
    public int m70087f() {
        return this.f54332c;
    }

    /* renamed from: h */
    public int m70088h() {
        return this.f54330a;
    }

    /* renamed from: k */
    public int m70089k() {
        return this.f54331b;
    }
}
