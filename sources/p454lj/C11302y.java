package p454lj;

/* renamed from: lj.y */
/* loaded from: classes5.dex */
public class C11302y extends AbstractC11301x {
    @Override // p454lj.AbstractC11301x
    /* renamed from: b */
    public float[] mo67857b(AbstractC11299v abstractC11299v, int i10) {
        float[] fArr = new float[i10];
        int i11 = i10 * 4;
        C11279b[] c11279bArr = new C11279b[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            C11279b c11279bMo67846a = abstractC11299v.mo67846a(i12 / (i11 - 1));
            c11279bArr[i12] = new C11279b(c11279bMo67846a.f52917a, c11279bMo67846a.f52918b);
        }
        int iM67855f = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            float f10 = i13 / (i10 - 1);
            iM67855f = AbstractC11301x.m67855f(c11279bArr, iM67855f, f10);
            int iMin = Math.min(iM67855f + 1, i11 - 1);
            C11279b c11279b = c11279bArr[iM67855f];
            float f11 = c11279b.f52917a;
            C11279b c11279b2 = c11279bArr[iMin];
            float f12 = c11279b2.f52917a;
            float f13 = c11279b.f52918b;
            float f14 = c11279b2.f52918b;
            if (iM67855f == iMin || Math.abs(f11 - f12) == 0.0f) {
                fArr[i13] = f13;
            } else {
                fArr[i13] = AbstractC11301x.m67854e(f10, f11, f13, f12, f14);
            }
        }
        return fArr;
    }

    @Override // p454lj.AbstractC11301x
    /* renamed from: c */
    public float mo67858c(float f10) {
        if ((f10 >= 0.0f ? f10 : 0.0f) > 1.0f) {
            f10 = 1.0f;
        }
        return AbstractC11301x.m67853d(this.f52956b, f10);
    }
}
