package p508o3;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import p468m3.C11397c;

/* renamed from: o3.c */
/* loaded from: classes.dex */
public abstract class AbstractC11798c extends AbstractC11797b {

    /* renamed from: a */
    public final ByteBuffer f54668a;

    /* renamed from: b */
    public final int f54669b;

    /* renamed from: c */
    public final int f54670c;

    public AbstractC11798c(int i10) {
        this(i10, i10);
    }

    @Override // p508o3.InterfaceC11805j
    /* renamed from: c */
    public final AbstractC11803h mo70315c() {
        m70317h();
        C11807l.m70354a(this.f54668a);
        if (this.f54668a.remaining() > 0) {
            mo70320k(this.f54668a);
            ByteBuffer byteBuffer = this.f54668a;
            C11807l.m70355b(byteBuffer, byteBuffer.limit());
        }
        return mo70316g();
    }

    @Override // p508o3.AbstractC11797b
    /* renamed from: e */
    public final InterfaceC11805j mo70313e(byte[] bArr, int i10, int i11) {
        return m70321l(ByteBuffer.wrap(bArr, i10, i11).order(ByteOrder.LITTLE_ENDIAN));
    }

    /* renamed from: g */
    public abstract AbstractC11803h mo70316g();

    /* renamed from: h */
    public final void m70317h() {
        C11807l.m70354a(this.f54668a);
        while (this.f54668a.remaining() >= this.f54670c) {
            mo70319j(this.f54668a);
        }
        this.f54668a.compact();
    }

    /* renamed from: i */
    public final void m70318i() {
        if (this.f54668a.remaining() < 8) {
            m70317h();
        }
    }

    /* renamed from: j */
    public abstract void mo70319j(ByteBuffer byteBuffer);

    /* renamed from: k */
    public abstract void mo70320k(ByteBuffer byteBuffer);

    /* renamed from: l */
    public final InterfaceC11805j m70321l(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= this.f54668a.remaining()) {
            this.f54668a.put(byteBuffer);
            m70318i();
            return this;
        }
        int iPosition = this.f54669b - this.f54668a.position();
        for (int i10 = 0; i10 < iPosition; i10++) {
            this.f54668a.put(byteBuffer.get());
        }
        m70317h();
        while (byteBuffer.remaining() >= this.f54670c) {
            mo70319j(byteBuffer);
        }
        this.f54668a.put(byteBuffer);
        return this;
    }

    public AbstractC11798c(int i10, int i11) {
        C11397c.m68304a(i11 % i10 == 0);
        this.f54668a = ByteBuffer.allocate(i11 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f54669b = i11;
        this.f54670c = i10;
    }
}
