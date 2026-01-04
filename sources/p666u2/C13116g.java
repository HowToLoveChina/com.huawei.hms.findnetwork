package p666u2;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* renamed from: u2.g */
/* loaded from: classes.dex */
public class C13116g implements TypeEvaluator<Matrix> {

    /* renamed from: a */
    public final float[] f59607a = new float[9];

    /* renamed from: b */
    public final float[] f59608b = new float[9];

    /* renamed from: c */
    public final Matrix f59609c = new Matrix();

    /* renamed from: a */
    public Matrix mo10536a(float f10, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f59607a);
        matrix2.getValues(this.f59608b);
        for (int i10 = 0; i10 < 9; i10++) {
            float[] fArr = this.f59608b;
            float f11 = fArr[i10];
            float f12 = this.f59607a[i10];
            fArr[i10] = f12 + ((f11 - f12) * f10);
        }
        this.f59609c.setValues(this.f59608b);
        return this.f59609c;
    }
}
