package az;

import p271ez.C9575a;

/* renamed from: az.b */
/* loaded from: classes9.dex */
public class C1078b {

    /* renamed from: a */
    public byte[] f5189a;

    /* renamed from: b */
    public int f5190b;

    public C1078b(byte[] bArr, int i10) {
        this.f5189a = C9575a.m59759b(bArr);
        this.f5190b = i10;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1078b)) {
            return false;
        }
        C1078b c1078b = (C1078b) obj;
        if (c1078b.f5190b != this.f5190b) {
            return false;
        }
        return C9575a.m59758a(this.f5189a, c1078b.f5189a);
    }

    public int hashCode() {
        return C9575a.m59763f(this.f5189a) ^ this.f5190b;
    }
}
