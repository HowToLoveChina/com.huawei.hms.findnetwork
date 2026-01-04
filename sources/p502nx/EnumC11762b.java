package p502nx;

import p376ix.C10631a;

/* renamed from: nx.b */
/* loaded from: classes9.dex */
public enum EnumC11762b {
    ONE(1),
    TWO(2);


    /* renamed from: a */
    public int f54337a;

    EnumC11762b(int i10) {
        this.f54337a = i10;
    }

    /* renamed from: b */
    public static EnumC11762b m70090b(int i10) throws C10631a {
        for (EnumC11762b enumC11762b : values()) {
            if (enumC11762b.f54337a == i10) {
                return enumC11762b;
            }
        }
        throw new C10631a("Unsupported Aes version");
    }

    /* renamed from: e */
    public int m70091e() {
        return this.f54337a;
    }
}
