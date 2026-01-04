package p045c3;

/* renamed from: c3.a */
/* loaded from: classes.dex */
public final class C1382a {
    /* renamed from: a */
    public static float m7929a(float f10, float f11, float f12, float f13) {
        return (float) Math.hypot(f12 - f10, f13 - f11);
    }

    /* renamed from: b */
    public static float m7930b(float f10, float f11, float f12, float f13, float f14, float f15) {
        return m7933e(m7929a(f10, f11, f12, f13), m7929a(f10, f11, f14, f13), m7929a(f10, f11, f14, f15), m7929a(f10, f11, f12, f15));
    }

    /* renamed from: c */
    public static boolean m7931c(float f10, float f11, float f12) {
        return f10 + f12 >= f11;
    }

    /* renamed from: d */
    public static float m7932d(float f10, float f11, float f12) {
        return ((1.0f - f12) * f10) + (f12 * f11);
    }

    /* renamed from: e */
    public static float m7933e(float f10, float f11, float f12, float f13) {
        return (f10 <= f11 || f10 <= f12 || f10 <= f13) ? (f11 <= f12 || f11 <= f13) ? f12 > f13 ? f12 : f13 : f11 : f10;
    }
}
