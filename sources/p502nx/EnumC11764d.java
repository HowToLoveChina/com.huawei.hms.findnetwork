package p502nx;

import p376ix.C10631a;

/* renamed from: nx.d */
/* loaded from: classes9.dex */
public enum EnumC11764d {
    STORE(0),
    DEFLATE(8),
    AES_INTERNAL_ONLY(99);


    /* renamed from: a */
    public int f54354a;

    EnumC11764d(int i10) {
        this.f54354a = i10;
    }

    /* renamed from: e */
    public static EnumC11764d m70093e(int i10) throws C10631a {
        for (EnumC11764d enumC11764d : values()) {
            if (enumC11764d.m70094b() == i10) {
                return enumC11764d;
            }
        }
        throw new C10631a("Unknown compression method", C10631a.a.UNKNOWN_COMPRESSION_METHOD);
    }

    /* renamed from: b */
    public int m70094b() {
        return this.f54354a;
    }
}
