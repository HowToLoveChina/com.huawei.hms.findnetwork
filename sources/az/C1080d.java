package az;

import p271ez.C9575a;

/* renamed from: az.d */
/* loaded from: classes9.dex */
public class C1080d {

    /* renamed from: a */
    public int f5195a;

    /* renamed from: b */
    public byte[] f5196b;

    /* renamed from: c */
    public int f5197c;

    public C1080d(byte[] bArr, int i10) {
        this(bArr, i10, -1);
    }

    /* renamed from: a */
    public int m6453a() {
        return this.f5197c;
    }

    /* renamed from: b */
    public byte[] m6454b() {
        return C9575a.m59759b(this.f5196b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1080d)) {
            return false;
        }
        C1080d c1080d = (C1080d) obj;
        if (c1080d.f5197c != this.f5197c) {
            return false;
        }
        return C9575a.m59758a(this.f5196b, c1080d.f5196b);
    }

    public int hashCode() {
        return C9575a.m59763f(this.f5196b) ^ this.f5197c;
    }

    public C1080d(byte[] bArr, int i10, int i11) {
        this.f5196b = C9575a.m59759b(bArr);
        this.f5197c = i10;
        this.f5195a = i11;
    }
}
