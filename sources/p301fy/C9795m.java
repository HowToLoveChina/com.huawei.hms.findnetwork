package p301fy;

import java.io.IOException;
import java.io.InputStream;
import ly.C11370d;
import p241dy.C9360a;
import p351hz.C10372k;
import p351hz.C10373l;

/* renamed from: fy.m */
/* loaded from: classes9.dex */
public final class C9795m extends AbstractC9786d {
    public C9795m() {
        super(C10372k.class, Number.class);
    }

    /* renamed from: f */
    private int m60876f(C9790h c9790h) throws IllegalArgumentException {
        return (int) C11370d.m68219b(c9790h.f48139d, 1, 4);
    }

    @Override // p301fy.AbstractC9786d
    /* renamed from: b */
    public InputStream mo60858b(String str, InputStream inputStream, long j10, C9790h c9790h, byte[] bArr, int i10) throws IOException, IllegalArgumentException {
        byte[] bArr2 = c9790h.f48139d;
        if (bArr2 == null) {
            throw new IOException("Missing LZMA properties");
        }
        if (bArr2.length < 1) {
            throw new IOException("LZMA properties too short");
        }
        byte b10 = bArr2[0];
        int iM60876f = m60876f(c9790h);
        if (iM60876f > 2147483632) {
            throw new IOException("Dictionary larger than 4GiB maximum size used in " + str);
        }
        int iM63809u = C10373l.m63809u(iM60876f, b10);
        if (iM63809u > i10) {
            throw new C9360a(iM63809u, i10);
        }
        C10373l c10373l = new C10373l(inputStream, j10, b10, iM60876f);
        c10373l.m63811s();
        return c10373l;
    }

    @Override // p301fy.AbstractC9786d
    /* renamed from: c */
    public Object mo60862c(C9790h c9790h, InputStream inputStream) throws IOException {
        byte[] bArr = c9790h.f48139d;
        if (bArr == null) {
            throw new IOException("Missing LZMA properties");
        }
        if (bArr.length < 1) {
            throw new IOException("LZMA properties too short");
        }
        int i10 = bArr[0] & 255;
        int i11 = i10 / 45;
        int i12 = i10 - (i11 * 45);
        int i13 = i12 / 9;
        C10372k c10372k = new C10372k();
        c10372k.m63806f(i11);
        c10372k.m63805d(i12 - (i13 * 9), i13);
        c10372k.m63804c(m60876f(c9790h));
        return c10372k;
    }
}
