package p301fy;

import java.io.IOException;
import java.io.InputStream;
import p351hz.C10368g;

/* renamed from: fy.j */
/* loaded from: classes9.dex */
public final class C9792j extends AbstractC9786d {
    public C9792j() {
        super(Number.class);
    }

    @Override // p301fy.AbstractC9786d
    /* renamed from: b */
    public InputStream mo60858b(String str, InputStream inputStream, long j10, C9790h c9790h, byte[] bArr, int i10) throws IOException {
        return new C10368g(m60869f(c9790h)).m63798a(inputStream);
    }

    @Override // p301fy.AbstractC9786d
    /* renamed from: c */
    public Object mo60862c(C9790h c9790h, InputStream inputStream) {
        return Integer.valueOf(m60869f(c9790h));
    }

    /* renamed from: f */
    public final int m60869f(C9790h c9790h) {
        byte[] bArr = c9790h.f48139d;
        if (bArr == null || bArr.length == 0) {
            return 1;
        }
        return (bArr[0] & 255) + 1;
    }
}
