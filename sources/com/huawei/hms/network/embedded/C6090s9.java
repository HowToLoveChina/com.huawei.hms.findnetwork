package com.huawei.hms.network.embedded;

/* renamed from: com.huawei.hms.network.embedded.s9 */
/* loaded from: classes8.dex */
public final class C6090s9 {

    /* renamed from: a */
    public final C5910eb f28243a;

    /* renamed from: b */
    public final C5910eb f28244b;

    /* renamed from: c */
    public final int f28245c;

    /* renamed from: d */
    public static final C5910eb f28232d = C5910eb.m34157d(":");

    /* renamed from: e */
    public static final String f28233e = ":status";

    /* renamed from: j */
    public static final C5910eb f28238j = C5910eb.m34157d(f28233e);

    /* renamed from: f */
    public static final String f28234f = ":method";

    /* renamed from: k */
    public static final C5910eb f28239k = C5910eb.m34157d(f28234f);

    /* renamed from: g */
    public static final String f28235g = ":path";

    /* renamed from: l */
    public static final C5910eb f28240l = C5910eb.m34157d(f28235g);

    /* renamed from: h */
    public static final String f28236h = ":scheme";

    /* renamed from: m */
    public static final C5910eb f28241m = C5910eb.m34157d(f28236h);

    /* renamed from: i */
    public static final String f28237i = ":authority";

    /* renamed from: n */
    public static final C5910eb f28242n = C5910eb.m34157d(f28237i);

    public C6090s9(C5910eb c5910eb, C5910eb c5910eb2) {
        this.f28243a = c5910eb;
        this.f28244b = c5910eb2;
        this.f28245c = c5910eb.mo34192j() + 32 + c5910eb2.mo34192j();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C6090s9)) {
            return false;
        }
        C6090s9 c6090s9 = (C6090s9) obj;
        return this.f28243a.equals(c6090s9.f28243a) && this.f28244b.equals(c6090s9.f28244b);
    }

    public int hashCode() {
        return ((this.f28243a.hashCode() + 527) * 31) + this.f28244b.hashCode();
    }

    public String toString() {
        return C5920f8.m34236a("%s: %s", this.f28243a.mo34196n(), this.f28244b.mo34196n());
    }

    public C6090s9(C5910eb c5910eb, String str) {
        this(c5910eb, C5910eb.m34157d(str));
    }

    public C6090s9(String str, String str2) {
        this(C5910eb.m34157d(str), C5910eb.m34157d(str2));
    }
}
