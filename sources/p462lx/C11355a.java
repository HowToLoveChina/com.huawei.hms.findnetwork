package p462lx;

import java.io.IOException;
import java.io.OutputStream;
import mx.C11557q;
import p300fx.C9779a;

/* renamed from: lx.a */
/* loaded from: classes9.dex */
public class C11355a extends AbstractC11356b<C9779a> {

    /* renamed from: c */
    public byte[] f53061c;

    /* renamed from: d */
    public int f53062d;

    public C11355a(C11364j c11364j, C11557q c11557q, char[] cArr, boolean z10) throws IOException {
        super(c11364j, c11557q, cArr, z10);
        this.f53061c = new byte[16];
        this.f53062d = 0;
    }

    @Override // p462lx.AbstractC11356b
    /* renamed from: s */
    public void mo68163s() throws IOException {
        int i10 = this.f53062d;
        if (i10 != 0) {
            super.write(this.f53061c, 0, i10);
            this.f53062d = 0;
        }
        m68169w(m68167t().m60842d());
        super.mo68163s();
    }

    @Override // p462lx.AbstractC11356b, java.io.OutputStream
    public void write(int i10) throws IOException {
        write(new byte[]{(byte) i10});
    }

    @Override // p462lx.AbstractC11356b
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public C9779a mo68164v(OutputStream outputStream, C11557q c11557q, char[] cArr, boolean z10) throws IOException {
        C9779a c9779a = new C9779a(cArr, c11557q.m68990a(), z10);
        m68166y(c9779a);
        return c9779a;
    }

    /* renamed from: y */
    public final void m68166y(C9779a c9779a) throws IOException {
        m68169w(c9779a.m60843e());
        m68169w(c9779a.m60841c());
    }

    @Override // p462lx.AbstractC11356b, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // p462lx.AbstractC11356b, java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        int i12;
        int i13 = this.f53062d;
        if (i11 >= 16 - i13) {
            System.arraycopy(bArr, i10, this.f53061c, i13, 16 - i13);
            byte[] bArr2 = this.f53061c;
            super.write(bArr2, 0, bArr2.length);
            int i14 = 16 - this.f53062d;
            int i15 = i11 - i14;
            this.f53062d = 0;
            if (i15 != 0 && (i12 = i15 % 16) != 0) {
                System.arraycopy(bArr, (i15 + i14) - i12, this.f53061c, 0, i12);
                this.f53062d = i12;
                i15 -= i12;
            }
            super.write(bArr, i14, i15);
            return;
        }
        System.arraycopy(bArr, i10, this.f53061c, i13, i11);
        this.f53062d += i11;
    }
}
