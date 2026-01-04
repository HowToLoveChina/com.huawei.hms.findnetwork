package p562q0;

import android.view.animation.Interpolator;

/* renamed from: q0.d */
/* loaded from: classes.dex */
public abstract class AbstractInterpolatorC12271d implements Interpolator {

    /* renamed from: a */
    public final float[] f56908a;

    /* renamed from: b */
    public final float f56909b;

    public AbstractInterpolatorC12271d(float[] fArr) {
        this.f56908a = fArr;
        this.f56909b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        if (f10 >= 1.0f) {
            return 1.0f;
        }
        if (f10 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f56908a;
        int iMin = Math.min((int) ((fArr.length - 1) * f10), fArr.length - 2);
        float f11 = this.f56909b;
        float f12 = (f10 - (iMin * f11)) / f11;
        float[] fArr2 = this.f56908a;
        float f13 = fArr2[iMin];
        return f13 + (f12 * (fArr2[iMin + 1] - f13));
    }
}
