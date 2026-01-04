package com.google.crypto.tink.shaded.protobuf;

/* renamed from: com.google.crypto.tink.shaded.protobuf.f1 */
/* loaded from: classes.dex */
public final class C1913f1 implements InterfaceC1945q0 {

    /* renamed from: a */
    public final InterfaceC1951s0 f9137a;

    /* renamed from: b */
    public final String f9138b;

    /* renamed from: c */
    public final Object[] f9139c;

    /* renamed from: d */
    public final int f9140d;

    public C1913f1(InterfaceC1951s0 interfaceC1951s0, String str, Object[] objArr) {
        this.f9137a = interfaceC1951s0;
        this.f9138b = str;
        this.f9139c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f9140d = cCharAt;
            return;
        }
        int i10 = cCharAt & 8191;
        int i11 = 13;
        int i12 = 1;
        while (true) {
            int i13 = i12 + 1;
            char cCharAt2 = str.charAt(i12);
            if (cCharAt2 < 55296) {
                this.f9140d = i10 | (cCharAt2 << i11);
                return;
            } else {
                i10 |= (cCharAt2 & 8191) << i11;
                i11 += 13;
                i12 = i13;
            }
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1945q0
    /* renamed from: a */
    public boolean mo11639a() {
        return (this.f9140d & 2) == 2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1945q0
    /* renamed from: b */
    public InterfaceC1951s0 mo11640b() {
        return this.f9137a;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1945q0
    /* renamed from: c */
    public EnumC1904c1 mo11641c() {
        return (this.f9140d & 1) == 1 ? EnumC1904c1.PROTO2 : EnumC1904c1.PROTO3;
    }

    /* renamed from: d */
    public Object[] m11642d() {
        return this.f9139c;
    }

    /* renamed from: e */
    public String m11643e() {
        return this.f9138b;
    }
}
