package p524oj;

import android.util.Log;

/* renamed from: oj.a */
/* loaded from: classes5.dex */
public class C11906a {

    /* renamed from: a */
    public float f55146a;

    /* renamed from: b */
    public float f55147b;

    /* renamed from: c */
    public float f55148c;

    public C11906a(float f10) {
        this(f10, 1.848f);
    }

    /* renamed from: a */
    public float m71440a(float f10) {
        if (Float.compare(f10, 0.0f) < 0) {
            throw new IllegalArgumentException("input can not less than zero!!");
        }
        float f11 = this.f55146a;
        if (f11 == 0.0f) {
            return 0.0f;
        }
        float f12 = f10 / f11;
        if (Float.compare(f12, 1.0f) > 0) {
            f12 = 1.0f;
        }
        float f13 = f12 * this.f55148c;
        float fExp = (float) Math.exp(-(this.f55147b * f13));
        Log.d("DynamicCurveRate", "getRate: x=" + f13 + ",rate=" + fExp + ",input=" + f10);
        return fExp;
    }

    public C11906a(float f10, float f11) {
        this.f55148c = 0.75f;
        this.f55146a = f10;
        this.f55147b = f11;
    }
}
