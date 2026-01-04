package sy;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: sy.g */
/* loaded from: classes9.dex */
public class C12883g {

    /* renamed from: a */
    public OutputStream f58666a;

    public C12883g(OutputStream outputStream) {
        this.f58666a = outputStream;
    }

    /* renamed from: a */
    public static C12883g m77290a(OutputStream outputStream) {
        return new C12883g(outputStream);
    }

    /* renamed from: d */
    public static int m77291d(int i10) {
        if (i10 < 128) {
            return 1;
        }
        int i11 = 2;
        while (true) {
            i10 >>>= 8;
            if (i10 == 0) {
                return i11;
            }
            i11++;
        }
    }

    /* renamed from: e */
    public static int m77292e(boolean z10, int i10) {
        return (z10 ? 1 : 0) + m77291d(i10) + i10;
    }

    /* renamed from: b */
    public void m77293b() throws IOException {
    }

    /* renamed from: c */
    public C12892p mo77294c() {
        return new C12892p(this.f58666a);
    }

    /* renamed from: f */
    public final void m77295f(int i10) throws IOException {
        this.f58666a.write(i10);
    }

    /* renamed from: g */
    public final void m77296g(byte[] bArr, int i10, int i11) throws IOException {
        this.f58666a.write(bArr, i10, i11);
    }

    /* renamed from: h */
    public final void m77297h(int i10) throws IOException {
        if (i10 < 128) {
            m77295f(i10);
            return;
        }
        int i11 = 5;
        byte[] bArr = new byte[5];
        while (true) {
            int i12 = i11 - 1;
            bArr[i12] = (byte) i10;
            i10 >>>= 8;
            if (i10 == 0) {
                int i13 = i11 - 2;
                bArr[i13] = (byte) ((5 - i12) | 128);
                m77296g(bArr, i13, 6 - i12);
                return;
            }
            i11 = i12;
        }
    }

    /* renamed from: i */
    public final void m77298i(boolean z10, int i10, byte[] bArr) throws IOException {
        m77300k(z10, i10);
        m77297h(bArr.length);
        m77296g(bArr, 0, bArr.length);
    }

    /* renamed from: j */
    public final void m77299j(boolean z10, int i10, byte[] bArr, int i11, int i12, byte b10) throws IOException {
        m77300k(z10, i10);
        m77297h(i12 + 1);
        m77296g(bArr, i11, i12);
        m77295f(b10);
    }

    /* renamed from: k */
    public final void m77300k(boolean z10, int i10) throws IOException {
        if (z10) {
            m77295f(i10);
        }
    }

    /* renamed from: l */
    public void mo77301l(AbstractC12885i abstractC12885i, boolean z10) throws IOException {
        abstractC12885i.mo77279d(this, z10);
    }
}
