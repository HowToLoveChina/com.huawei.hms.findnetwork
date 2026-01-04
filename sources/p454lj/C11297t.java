package p454lj;

import java.util.List;

/* renamed from: lj.t */
/* loaded from: classes5.dex */
public class C11297t extends AbstractC11299v {
    public C11297t(List<C11279b> list) {
        super(list);
    }

    /* renamed from: c */
    public static C11279b m67845c(C11279b[] c11279bArr, float f10) {
        int length = c11279bArr.length;
        int i10 = 1;
        while (true) {
            int i11 = 0;
            if (i10 > length) {
                return c11279bArr[0];
            }
            while (i11 < length - i10) {
                C11279b c11279b = c11279bArr[i11];
                float f11 = 1.0f - f10;
                float f12 = c11279b.f52917a * f11;
                i11++;
                C11279b c11279b2 = c11279bArr[i11];
                c11279b.f52917a = f12 + (c11279b2.f52917a * f10);
                c11279b.f52918b = (f11 * c11279b.f52918b) + (c11279b2.f52918b * f10);
            }
            i10++;
        }
    }

    @Override // p454lj.AbstractC11299v
    /* renamed from: a */
    public C11279b mo67846a(float f10) {
        int length = this.f52950a.length;
        if (length < 2) {
            return new C11279b(0.0f, 0.0f);
        }
        for (int i10 = 0; i10 < length; i10++) {
            C11279b[] c11279bArr = this.f52951b;
            if (c11279bArr[i10] == null) {
                c11279bArr[i10] = new C11279b();
            }
            this.f52951b[i10].m67693a(this.f52950a[i10]);
        }
        return m67845c(this.f52951b, f10);
    }
}
