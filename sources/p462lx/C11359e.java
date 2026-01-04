package p462lx;

import java.io.IOException;
import java.util.zip.Deflater;
import p502nx.EnumC11763c;

/* renamed from: lx.e */
/* loaded from: classes9.dex */
public class C11359e extends AbstractC11357c {

    /* renamed from: b */
    public byte[] f53068b;

    /* renamed from: c */
    public Deflater f53069c;

    public C11359e(AbstractC11356b<?> abstractC11356b, EnumC11763c enumC11763c, int i10) {
        super(abstractC11356b);
        this.f53069c = new Deflater(enumC11763c.m70092b(), true);
        this.f53068b = new byte[i10];
    }

    @Override // p462lx.AbstractC11357c
    /* renamed from: s */
    public void mo68170s() throws IOException {
        if (!this.f53069c.finished()) {
            this.f53069c.finish();
            while (!this.f53069c.finished()) {
                m68179u();
            }
        }
        this.f53069c.end();
        super.mo68170s();
    }

    /* renamed from: u */
    public final void m68179u() throws IOException {
        Deflater deflater = this.f53069c;
        byte[] bArr = this.f53068b;
        int iDeflate = deflater.deflate(bArr, 0, bArr.length);
        if (iDeflate > 0) {
            super.write(this.f53068b, 0, iDeflate);
        }
    }

    @Override // p462lx.AbstractC11357c, java.io.OutputStream
    public void write(int i10) throws IOException {
        write(new byte[]{(byte) i10}, 0, 1);
    }

    @Override // p462lx.AbstractC11357c, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // p462lx.AbstractC11357c, java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f53069c.setInput(bArr, i10, i11);
        while (!this.f53069c.needsInput()) {
            m68179u();
        }
    }
}
