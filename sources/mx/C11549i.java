package mx;

import java.util.Objects;
import p409jx.EnumC10954c;

/* renamed from: mx.i */
/* loaded from: classes9.dex */
public class C11549i extends AbstractC11542b {

    /* renamed from: t */
    public int f53536t;

    /* renamed from: u */
    public int f53537u = 0;

    /* renamed from: v */
    public int f53538v;

    /* renamed from: w */
    public byte[] f53539w;

    /* renamed from: x */
    public byte[] f53540x;

    /* renamed from: y */
    public long f53541y;

    /* renamed from: z */
    public String f53542z;

    public C11549i() {
        m68966b(EnumC10954c.CENTRAL_DIRECTORY);
    }

    /* renamed from: L */
    public final long m68914L(C11549i c11549i) {
        return c11549i.m68877p() != null ? c11549i.m68877p().m68959e() : c11549i.m68918P();
    }

    /* renamed from: M */
    public int m68915M() {
        return this.f53538v;
    }

    /* renamed from: N */
    public byte[] m68916N() {
        return this.f53540x;
    }

    /* renamed from: O */
    public String m68917O() {
        return this.f53542z;
    }

    /* renamed from: P */
    public long m68918P() {
        return this.f53541y;
    }

    /* renamed from: Q */
    public int m68919Q() {
        return this.f53536t;
    }

    /* renamed from: R */
    public void m68920R(int i10) {
        this.f53538v = i10;
    }

    /* renamed from: S */
    public void m68921S(byte[] bArr) {
        this.f53540x = bArr;
    }

    /* renamed from: T */
    public void m68922T(String str) {
        this.f53542z = str;
    }

    /* renamed from: U */
    public void m68923U(int i10) {
        this.f53537u = i10;
    }

    /* renamed from: V */
    public void m68924V(byte[] bArr) {
        this.f53539w = bArr;
    }

    /* renamed from: W */
    public void m68925W(long j10) {
        this.f53541y = j10;
    }

    /* renamed from: X */
    public void m68926X(int i10) {
        this.f53536t = i10;
    }

    @Override // mx.AbstractC11542b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && super.equals(obj) && m68914L(this) == m68914L((C11549i) obj);
    }

    public int hashCode() {
        return Objects.hash(m68871j(), Long.valueOf(m68914L(this)));
    }

    public String toString() {
        return m68871j();
    }
}
