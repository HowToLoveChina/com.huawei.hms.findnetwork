package com.huawei.hiar;

import java.lang.reflect.Array;
import java.util.Locale;

/* loaded from: classes5.dex */
class ARQuaternion {
    private static final int ARRAY_LENGTH = 4;
    private static final float FROM_MATRIX_VALUE = 0.5f;
    public static final ARQuaternion IDENTITY = new ARQuaternion();
    private static final int INDEX_W = 3;
    private static final int INDEX_X = 0;
    private static final int INDEX_Y = 1;
    private static final int INDEX_Z = 2;
    private static final int OFFSET_0 = 0;
    private static final int OFFSET_1 = 1;
    private static final int OFFSET_2 = 2;
    private static final double THETA_PRECISION = 0.001d;
    private static final float TO_MATRIX_VALUE = 2.0f;
    private static final int VECTOR_SIZE = 3;
    private float axisX = 0.0f;
    private float axisY = 0.0f;
    private float axisZ = 0.0f;
    private float axisW = 1.0f;

    public ARQuaternion() {
        setValues(0.0f, 0.0f, 0.0f, 1.0f);
    }

    private static ARQuaternion doQuaternionWeightedSum(ARQuaternion aRQuaternion, float f10, ARQuaternion aRQuaternion2, float f11) {
        ARQuaternion aRQuaternion3 = new ARQuaternion();
        aRQuaternion3.axisX = (aRQuaternion.axisX * f10) + (aRQuaternion2.axisX * f11);
        aRQuaternion3.axisY = (aRQuaternion.axisY * f10) + (aRQuaternion2.axisY * f11);
        aRQuaternion3.axisZ = (aRQuaternion.axisZ * f10) + (aRQuaternion2.axisZ * f11);
        aRQuaternion3.axisW = (f10 * aRQuaternion.axisW) + (f11 * aRQuaternion2.axisW);
        aRQuaternion3.normalizeInPlace();
        return aRQuaternion3;
    }

    public static ARQuaternion fromMatrix(float[] fArr, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        if (fArr == null || fArr.length - 1 < (i14 = (i12 = i10 + 2) + (i13 = i11 * 2))) {
            throw new IllegalArgumentException();
        }
        float[][] fArr2 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 3, 3);
        float[] fArr3 = fArr2[0];
        fArr3[0] = fArr[i10];
        fArr3[1] = fArr[i10 + i11];
        fArr3[2] = fArr[i10 + i13];
        float[] fArr4 = fArr2[1];
        int i15 = i10 + 1;
        fArr4[0] = fArr[i15];
        fArr4[1] = fArr[i15 + i11];
        fArr4[2] = fArr[i15 + i13];
        float[] fArr5 = fArr2[2];
        fArr5[0] = fArr[i12];
        fArr5[1] = fArr[i12 + i11];
        fArr5[2] = fArr[i14];
        return new ARQuaternion(Math.copySign(((float) Math.sqrt(Math.max(0.0f, ((fArr3[0] + 1.0f) - fArr4[1]) - r10))) * FROM_MATRIX_VALUE, fArr2[2][1] - fArr2[1][2]), Math.copySign(((float) Math.sqrt(Math.max(0.0f, ((1.0f - fArr2[0][0]) + fArr2[1][1]) - fArr2[2][2]))) * FROM_MATRIX_VALUE, fArr2[0][2] - fArr2[2][0]), Math.copySign(((float) Math.sqrt(Math.max(0.0f, ((1.0f - fArr2[0][0]) - fArr2[1][1]) + fArr2[2][2]))) * FROM_MATRIX_VALUE, fArr2[1][0] - fArr2[0][1]), ((float) Math.sqrt(Math.max(0.0f, fArr2[0][0] + 1.0f + fArr2[1][1] + fArr2[2][2]))) * FROM_MATRIX_VALUE);
    }

    public static ARQuaternion makeInterpolated(ARQuaternion aRQuaternion, ARQuaternion aRQuaternion2, float f10) {
        if (aRQuaternion == null || aRQuaternion2 == null || f10 < 0.0f || f10 > 1.0f) {
            throw new IllegalArgumentException();
        }
        ARQuaternion aRQuaternion3 = new ARQuaternion(aRQuaternion2);
        float f11 = aRQuaternion.axisX;
        float f12 = aRQuaternion2.axisX;
        float f13 = aRQuaternion.axisY;
        float f14 = aRQuaternion2.axisY;
        float f15 = (f11 * f12) + (f13 * f14);
        float f16 = aRQuaternion.axisZ;
        float f17 = aRQuaternion2.axisZ;
        float f18 = f15 + (f16 * f17);
        float f19 = aRQuaternion.axisW;
        float f20 = aRQuaternion2.axisW;
        float f21 = f18 + (f19 * f20);
        if (f21 < 0.0f) {
            f21 = -f21;
            aRQuaternion3.axisX = -f12;
            aRQuaternion3.axisY = -f14;
            aRQuaternion3.axisZ = -f17;
            aRQuaternion3.axisW = -f20;
        }
        float fAcos = (float) Math.acos(f21);
        float fSqrt = (float) Math.sqrt(1.0f - (f21 * f21));
        float fSin = 1.0f - f10;
        if (Math.abs(fSqrt) > THETA_PRECISION) {
            fSin = ((float) Math.sin(fSin * fAcos)) / fSqrt;
            f10 = ((float) Math.sin(f10 * fAcos)) / fSqrt;
        }
        return doQuaternionWeightedSum(aRQuaternion, fSin, aRQuaternion3, f10);
    }

    private static void multiplyQuaternions(ARQuaternion aRQuaternion, ARQuaternion aRQuaternion2, ARQuaternion aRQuaternion3) {
        float f10 = aRQuaternion.axisX;
        float f11 = aRQuaternion2.axisW;
        float f12 = aRQuaternion.axisY;
        float f13 = aRQuaternion2.axisZ;
        float f14 = aRQuaternion.axisZ;
        float f15 = aRQuaternion2.axisY;
        float f16 = aRQuaternion.axisW;
        aRQuaternion3.axisX = (((f10 * f11) + (f12 * f13)) - (f14 * f15)) + (aRQuaternion2.axisX * f16);
        float f17 = aRQuaternion.axisX;
        float f18 = -f17;
        float f19 = (f18 * f13) + (f12 * f11);
        float f20 = aRQuaternion2.axisX;
        aRQuaternion3.axisY = f19 + (f14 * f20) + (f15 * f16);
        float f21 = aRQuaternion2.axisY;
        float f22 = aRQuaternion.axisY;
        aRQuaternion3.axisZ = ((f17 * f21) - (f22 * f20)) + (f14 * f11) + (f13 * f16);
        aRQuaternion3.axisW = (((f18 * f20) - (f22 * f21)) - (aRQuaternion.axisZ * aRQuaternion2.axisZ)) + (f16 * f11);
    }

    private void normalizeInPlace() {
        float f10 = this.axisX;
        float f11 = this.axisY;
        float f12 = (f10 * f10) + (f11 * f11);
        float f13 = this.axisZ;
        float f14 = f12 + (f13 * f13);
        float f15 = this.axisW;
        float fSqrt = (float) (1.0d / Math.sqrt(f14 + (f15 * f15)));
        this.axisX *= fSqrt;
        this.axisY *= fSqrt;
        this.axisZ *= fSqrt;
        this.axisW *= fSqrt;
    }

    public static void rotateVector(ARQuaternion aRQuaternion, float[] fArr, int i10, float[] fArr2, int i11) {
        int i12;
        int i13;
        if (aRQuaternion == null || fArr == null || i10 < 0) {
            throw new IllegalArgumentException();
        }
        if (i11 < 0 || fArr.length <= (i12 = i10 + 2) || fArr2.length <= (i13 = i11 + 2)) {
            throw new IllegalArgumentException();
        }
        float f10 = fArr[i10];
        float f11 = fArr[i10 + 1];
        float f12 = fArr[i12];
        float x10 = aRQuaternion.getX();
        float y10 = aRQuaternion.getY();
        float z10 = aRQuaternion.getZ();
        float w10 = aRQuaternion.getW();
        float f13 = ((w10 * f10) + (y10 * f12)) - (z10 * f11);
        float f14 = ((w10 * f11) + (z10 * f10)) - (x10 * f12);
        float f15 = ((w10 * f12) + (x10 * f11)) - (y10 * f10);
        float f16 = -x10;
        float f17 = ((f10 * f16) - (f11 * y10)) - (f12 * z10);
        float f18 = -z10;
        float f19 = -y10;
        fArr2[i11] = (((f13 * w10) + (f17 * f16)) + (f14 * f18)) - (f15 * f19);
        fArr2[i11 + 1] = (((f14 * w10) + (f17 * f19)) + (f15 * f16)) - (f13 * f18);
        fArr2[i13] = (((f15 * w10) + (f17 * f18)) + (f13 * f19)) - (f14 * f16);
    }

    public ARQuaternion compose(ARQuaternion aRQuaternion) {
        if (aRQuaternion == null) {
            throw new IllegalArgumentException();
        }
        ARQuaternion aRQuaternion2 = new ARQuaternion();
        multiplyQuaternions(this, aRQuaternion, aRQuaternion2);
        return aRQuaternion2;
    }

    public void getTransformedAxis(int i10, float f10, float[] fArr, int i11) {
        if (i10 < 0 || i10 > 2 || fArr == null) {
            throw new IllegalArgumentException();
        }
        if (i11 < 0 || fArr.length <= 2 + i11) {
            throw new IllegalArgumentException();
        }
        float[] fArr2 = {0.0f, 0.0f, 0.0f};
        fArr2[i10] = f10;
        rotateVector(this, fArr2, 0, fArr, i11);
    }

    public void getValues(float[] fArr, int i10) {
        if (fArr == null || i10 < 0 || fArr.length < i10 + 4) {
            throw new IllegalArgumentException();
        }
        fArr[i10] = this.axisX;
        fArr[i10 + 1] = this.axisY;
        fArr[i10 + 2] = this.axisZ;
        fArr[i10 + 3] = this.axisW;
    }

    public float getW() {
        return this.axisW;
    }

    public float getX() {
        return this.axisX;
    }

    public float getY() {
        return this.axisY;
    }

    public float getZ() {
        return this.axisZ;
    }

    public ARQuaternion inverse() {
        return new ARQuaternion(-this.axisX, -this.axisY, -this.axisZ, this.axisW);
    }

    public final void setValues(float f10, float f11, float f12, float f13) {
        this.axisX = f10;
        this.axisY = f11;
        this.axisZ = f12;
        this.axisW = f13;
    }

    public void toMatrix(float[] fArr, int i10, int i11) {
        if (fArr == null || i10 < 0 || fArr.length < i10 + 16) {
            throw new IllegalArgumentException();
        }
        float f10 = this.axisX;
        float f11 = this.axisY;
        float f12 = this.axisZ;
        float f13 = this.axisW;
        float f14 = (f10 * f10) + (f11 * f11) + (f12 * f12) + (f13 * f13);
        float f15 = f14 > 0.0f ? 2.0f / f14 : 0.0f;
        float f16 = f11 * f15;
        float f17 = f12 * f15;
        float f18 = f13 * f16;
        float f19 = f13 * f17;
        float f20 = f10 * f16;
        float f21 = f10 * f17;
        float f22 = f16 * f11;
        float f23 = f12 * f17;
        fArr[i10] = 1.0f - (f22 + f23);
        fArr[i10 + i11] = f20 - f19;
        int i12 = i11 * 2;
        fArr[i10 + i12] = f21 + f18;
        int i13 = i10 + 1;
        fArr[i13] = f20 + f19;
        float f24 = f15 * f10;
        float f25 = f10 * f24;
        fArr[i13 + i11] = 1.0f - (f23 + f25);
        float f26 = f13 * f24;
        float f27 = f11 * f17;
        fArr[i13 + i12] = f27 - f26;
        int i14 = i10 + 2;
        fArr[i14] = f21 - f18;
        fArr[i14 + i11] = f27 + f26;
        fArr[i14 + i12] = 1.0f - (f25 + f22);
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "[x:%.3f, y:%.3f, z:%.3f, w:%.3f]", Float.valueOf(this.axisX), Float.valueOf(this.axisY), Float.valueOf(this.axisZ), Float.valueOf(this.axisW));
    }

    public float[] transformedAxis(int i10, float f10) {
        float[] fArr = new float[3];
        getTransformedAxis(i10, f10, fArr, 0);
        return fArr;
    }

    @Deprecated
    /* renamed from: w */
    public float m29073w() {
        return this.axisW;
    }

    @Deprecated
    /* renamed from: x */
    public float m29074x() {
        return this.axisX;
    }

    public float[] xAxis() {
        return transformedAxis(0, 1.0f);
    }

    @Deprecated
    /* renamed from: y */
    public float m29075y() {
        return this.axisY;
    }

    public float[] yAxis() {
        return transformedAxis(1, 1.0f);
    }

    @Deprecated
    /* renamed from: z */
    public float m29076z() {
        return this.axisZ;
    }

    public float[] zAxis() {
        return transformedAxis(2, 1.0f);
    }

    public ARQuaternion(float f10, float f11, float f12, float f13) {
        setValues(f10, f11, f12, f13);
    }

    public void setValues(float[] fArr) {
        if (fArr == null || fArr.length < 4) {
            throw new IllegalArgumentException();
        }
        setValues(fArr[0], fArr[1], fArr[2], fArr[3]);
    }

    public ARQuaternion(ARQuaternion aRQuaternion) {
        if (aRQuaternion == null) {
            throw new IllegalArgumentException();
        }
        setValues(aRQuaternion.axisX, aRQuaternion.axisY, aRQuaternion.axisZ, aRQuaternion.axisW);
    }

    public ARQuaternion(float[] fArr) {
        if (fArr == null || fArr.length < 4) {
            throw new IllegalArgumentException();
        }
        setValues(fArr[0], fArr[1], fArr[2], fArr[3]);
    }
}
