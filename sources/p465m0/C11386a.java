package p465m0;

import java.nio.ByteBuffer;

/* renamed from: m0.a */
/* loaded from: classes.dex */
public final class C11386a extends C11388c {
    /* renamed from: f */
    public C11386a m68275f(int i10, ByteBuffer byteBuffer) {
        m68276g(i10, byteBuffer);
        return this;
    }

    /* renamed from: g */
    public void m68276g(int i10, ByteBuffer byteBuffer) {
        m68293c(i10, byteBuffer);
    }

    /* renamed from: h */
    public int m68277h(int i10) {
        int iM68292b = m68292b(16);
        if (iM68292b != 0) {
            return this.f53142b.getInt(m68294d(iM68292b) + (i10 * 4));
        }
        return 0;
    }

    /* renamed from: i */
    public int m68278i() {
        int iM68292b = m68292b(16);
        if (iM68292b != 0) {
            return m68295e(iM68292b);
        }
        return 0;
    }

    /* renamed from: j */
    public boolean m68279j() {
        int iM68292b = m68292b(6);
        return (iM68292b == 0 || this.f53142b.get(iM68292b + this.f53141a) == 0) ? false : true;
    }

    /* renamed from: k */
    public short m68280k() {
        int iM68292b = m68292b(14);
        if (iM68292b != 0) {
            return this.f53142b.getShort(iM68292b + this.f53141a);
        }
        return (short) 0;
    }

    /* renamed from: l */
    public int m68281l() {
        int iM68292b = m68292b(4);
        if (iM68292b != 0) {
            return this.f53142b.getInt(iM68292b + this.f53141a);
        }
        return 0;
    }

    /* renamed from: m */
    public short m68282m() {
        int iM68292b = m68292b(8);
        if (iM68292b != 0) {
            return this.f53142b.getShort(iM68292b + this.f53141a);
        }
        return (short) 0;
    }

    /* renamed from: n */
    public short m68283n() {
        int iM68292b = m68292b(12);
        if (iM68292b != 0) {
            return this.f53142b.getShort(iM68292b + this.f53141a);
        }
        return (short) 0;
    }
}
