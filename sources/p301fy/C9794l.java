package p301fy;

import java.io.IOException;
import java.io.InputStream;
import p241dy.C9360a;
import p351hz.C10371j;
import p351hz.C10372k;

/* renamed from: fy.l */
/* loaded from: classes9.dex */
public final class C9794l extends AbstractC9786d {
    public C9794l() {
        super(C10372k.class, Number.class);
    }

    @Override // p301fy.AbstractC9786d
    /* renamed from: b */
    public InputStream mo60858b(String str, InputStream inputStream, long j10, C9790h c9790h, byte[] bArr, int i10) throws IOException {
        try {
            int iM60875f = m60875f(c9790h);
            int iM63800v = C10371j.m63800v(iM60875f);
            if (iM63800v <= i10) {
                return new C10371j(inputStream, iM60875f);
            }
            throw new C9360a(iM63800v, i10);
        } catch (IllegalArgumentException e10) {
            throw new IOException(e10);
        }
    }

    @Override // p301fy.AbstractC9786d
    /* renamed from: c */
    public Object mo60862c(C9790h c9790h, InputStream inputStream) throws IOException {
        return Integer.valueOf(m60875f(c9790h));
    }

    /* renamed from: f */
    public final int m60875f(C9790h c9790h) throws IOException {
        byte[] bArr = c9790h.f48139d;
        if (bArr == null) {
            throw new IOException("Missing LZMA2 properties");
        }
        if (bArr.length < 1) {
            throw new IOException("LZMA2 properties too short");
        }
        byte b10 = bArr[0];
        int i10 = b10 & 255;
        if ((b10 & 192) != 0) {
            throw new IOException("Unsupported LZMA2 property bits");
        }
        if (i10 > 40) {
            throw new IOException("Dictionary larger than 4GiB maximum size");
        }
        if (i10 == 40) {
            return -1;
        }
        return ((b10 & 1) | 2) << ((i10 / 2) + 11);
    }
}
