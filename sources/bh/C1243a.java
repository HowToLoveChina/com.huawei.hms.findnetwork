package bh;

/* renamed from: bh.a */
/* loaded from: classes4.dex */
public class C1243a {

    /* renamed from: a */
    public float f5658a;

    /* renamed from: b */
    public float f5659b;

    /* renamed from: c */
    public float f5660c = 0.75f;

    public C1243a(float f10, float f11) {
        this.f5658a = f10;
        this.f5659b = f11;
    }

    /* renamed from: a */
    public float m7443a(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("input can not less than zero!!");
        }
        float f11 = this.f5658a;
        if (f11 == 0.0f) {
            return 0.0f;
        }
        float f12 = f10 / f11;
        if (Float.compare(f12, 1.0f) > 0) {
            f12 = 1.0f;
        }
        return (float) Math.exp(-(this.f5659b * f12 * this.f5660c));
    }

    /* renamed from: b */
    public C1243a m7444b(float f10) {
        this.f5659b = f10;
        return this;
    }
}
