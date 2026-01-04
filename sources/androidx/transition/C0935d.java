package androidx.transition;

import android.animation.TypeEvaluator;

/* renamed from: androidx.transition.d */
/* loaded from: classes.dex */
public class C0935d implements TypeEvaluator<float[]> {

    /* renamed from: a */
    public float[] f4841a;

    public C0935d(float[] fArr) {
        this.f4841a = fArr;
    }

    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public float[] evaluate(float f10, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.f4841a;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i10 = 0; i10 < fArr3.length; i10++) {
            float f11 = fArr[i10];
            fArr3[i10] = f11 + ((fArr2[i10] - f11) * f10);
        }
        return fArr3;
    }
}
