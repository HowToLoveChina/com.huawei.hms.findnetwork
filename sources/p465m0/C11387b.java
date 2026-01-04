package p465m0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: m0.b */
/* loaded from: classes.dex */
public final class C11387b extends C11388c {
    /* renamed from: h */
    public static C11387b m68284h(ByteBuffer byteBuffer) {
        return m68285i(byteBuffer, new C11387b());
    }

    /* renamed from: i */
    public static C11387b m68285i(ByteBuffer byteBuffer, C11387b c11387b) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return c11387b.m68286f(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    /* renamed from: f */
    public C11387b m68286f(int i10, ByteBuffer byteBuffer) {
        m68287g(i10, byteBuffer);
        return this;
    }

    /* renamed from: g */
    public void m68287g(int i10, ByteBuffer byteBuffer) {
        m68293c(i10, byteBuffer);
    }

    /* renamed from: j */
    public C11386a m68288j(C11386a c11386a, int i10) {
        int iM68292b = m68292b(6);
        if (iM68292b != 0) {
            return c11386a.m68275f(m68291a(m68294d(iM68292b) + (i10 * 4)), this.f53142b);
        }
        return null;
    }

    /* renamed from: k */
    public int m68289k() {
        int iM68292b = m68292b(6);
        if (iM68292b != 0) {
            return m68295e(iM68292b);
        }
        return 0;
    }

    /* renamed from: l */
    public int m68290l() {
        int iM68292b = m68292b(4);
        if (iM68292b != 0) {
            return this.f53142b.getInt(iM68292b + this.f53141a);
        }
        return 0;
    }
}
