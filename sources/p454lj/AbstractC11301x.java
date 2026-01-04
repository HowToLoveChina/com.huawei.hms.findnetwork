package p454lj;

/* renamed from: lj.x */
/* loaded from: classes5.dex */
public abstract class AbstractC11301x {

    /* renamed from: a */
    public AbstractC11299v f52955a;

    /* renamed from: b */
    public float[] f52956b;

    /* renamed from: d */
    public static float m67853d(float[] fArr, float f10) {
        int length = fArr.length - 1;
        float f11 = length;
        float f12 = 1.0f / f11;
        int i10 = (int) (f11 * f10);
        int iMin = Math.min(i10 + 1, length);
        if (i10 == iMin) {
            return fArr[length];
        }
        float f13 = i10 * f12;
        return m67854e(f10, f13, fArr[i10], f12 + f13, fArr[iMin]);
    }

    /* renamed from: e */
    public static float m67854e(float f10, float f11, float f12, float f13, float f14) {
        return f12 + (((f10 - f11) / (f13 - f11)) * (f14 - f12));
    }

    /* renamed from: f */
    public static int m67855f(C11279b[] c11279bArr, int i10, float f10) {
        int length = c11279bArr.length - 1;
        int i11 = i10;
        while (i10 <= length && c11279bArr[i10].f52917a <= f10) {
            i11 = (i10 + length) >>> 1;
            float f11 = c11279bArr[i11].f52917a;
            if (f11 >= f10) {
                if (f11 <= f10) {
                    break;
                }
                length = i11 - 1;
            } else {
                i10 = i11 + 1;
            }
        }
        return i11;
    }

    /* renamed from: a */
    public void m67856a(AbstractC11299v abstractC11299v) {
        this.f52955a = abstractC11299v;
        this.f52956b = mo67857b(abstractC11299v, 100);
    }

    /* renamed from: b */
    public abstract float[] mo67857b(AbstractC11299v abstractC11299v, int i10);

    /* renamed from: c */
    public abstract float mo67858c(float f10);
}
