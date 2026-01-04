package com.huawei.hiar;

import com.huawei.hiar.annotations.UsedByNative;
import java.util.Locale;

/* loaded from: classes5.dex */
public class ARPose {
    public static final ARPose IDENTITY = new ARPose(new float[]{0.0f, 0.0f, 0.0f}, ARQuaternion.IDENTITY);
    private static final int INDEX_W = 3;
    private static final int INDEX_X = 0;
    private static final int INDEX_Y = 1;
    private static final int INDEX_Z = 2;
    private static final int MATRIX_OFFSET_THREE = 3;
    private static final int MATRIX_OFFSET_TWO = 2;
    private static final int MATRIX_SIZE = 4;
    private static final float PRECISION_LIMIT = 0.001f;
    private static final int ROTATION_SIZE = 4;
    private static final int TRANSLATION_SIZE = 3;
    private final ARQuaternion quaternion;
    private final float[] translation;

    @UsedByNative("hiar_helper.cpp")
    private ARPose(float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        this.quaternion = new ARQuaternion(f13, f14, f15, f16);
        this.translation = new float[]{f10, f11, f12};
    }

    public static ARPose makeInterpolated(ARPose aRPose, ARPose aRPose2, float f10) {
        if (f10 > 1.0f || f10 < 0.0f) {
            throw new IllegalArgumentException();
        }
        if (f10 - 0.0f < PRECISION_LIMIT) {
            return aRPose;
        }
        float f11 = 1.0f - f10;
        if (f11 < PRECISION_LIMIT) {
            return aRPose2;
        }
        float[] fArr = new float[3];
        for (int i10 = 0; i10 < 3; i10++) {
            fArr[i10] = (aRPose.translation[i10] * f11) + (aRPose2.translation[i10] * f10);
        }
        return new ARPose(fArr, ARQuaternion.makeInterpolated(aRPose.quaternion, aRPose2.quaternion, f10));
    }

    public static ARPose makeRotation(float f10, float f11, float f12, float f13) {
        return new ARPose(IDENTITY.translation, new ARQuaternion(f10, f11, f12, f13));
    }

    public static ARPose makeTranslation(float f10, float f11, float f12) {
        return new ARPose(new float[]{f10, f11, f12}, IDENTITY.quaternion);
    }

    public ARPose compose(ARPose aRPose) {
        float[] fArr = new float[3];
        ARQuaternion.rotateVector(this.quaternion, aRPose.translation, 0, fArr, 0);
        float f10 = fArr[0];
        float[] fArr2 = this.translation;
        fArr[0] = f10 + fArr2[0];
        fArr[1] = fArr[1] + fArr2[1];
        fArr[2] = fArr[2] + fArr2[2];
        return new ARPose(fArr, this.quaternion.compose(aRPose.quaternion));
    }

    public ARPose extractRotation() {
        return new ARPose(IDENTITY.translation, this.quaternion);
    }

    public ARPose extractTranslation() {
        return new ARPose(this.translation, IDENTITY.quaternion);
    }

    public ARQuaternion getQuaternion() {
        return this.quaternion;
    }

    public void getRotationQuaternion(float[] fArr, int i10) {
        if (fArr == null || i10 < 0 || fArr.length < i10 + 4) {
            throw new IllegalArgumentException();
        }
        this.quaternion.getValues(fArr, i10);
    }

    public void getTransformedAxis(int i10, float f10, float[] fArr, int i11) {
        if (i10 < 0 || i10 > 2 || fArr == null || i11 < 0) {
            throw new IllegalArgumentException();
        }
        if (fArr.length < i11 + 3) {
            throw new IllegalArgumentException();
        }
        this.quaternion.getTransformedAxis(i10, f10, fArr, i11);
    }

    public void getTranslation(float[] fArr, int i10) {
        if (fArr == null || i10 < 0 || fArr.length < i10 + 3) {
            throw new IllegalArgumentException();
        }
        System.arraycopy(this.translation, 0, fArr, i10, 3);
    }

    public float[] getXAxis() {
        return getTransformedAxis(0, 1.0f);
    }

    public float[] getYAxis() {
        return getTransformedAxis(1, 1.0f);
    }

    public float[] getZAxis() {
        return getTransformedAxis(2, 1.0f);
    }

    public ARPose inverse() {
        float[] fArr = new float[3];
        ARQuaternion aRQuaternionInverse = this.quaternion.inverse();
        ARQuaternion.rotateVector(aRQuaternionInverse, this.translation, 0, fArr, 0);
        fArr[0] = -fArr[0];
        fArr[1] = -fArr[1];
        fArr[2] = -fArr[2];
        return new ARPose(fArr, aRQuaternionInverse);
    }

    /* renamed from: qw */
    public float m29066qw() {
        return this.quaternion.getW();
    }

    /* renamed from: qx */
    public float m29067qx() {
        return this.quaternion.getX();
    }

    /* renamed from: qy */
    public float m29068qy() {
        return this.quaternion.getY();
    }

    /* renamed from: qz */
    public float m29069qz() {
        return this.quaternion.getZ();
    }

    public void rotateVector(float[] fArr, int i10, float[] fArr2, int i11) {
        if (fArr == null || fArr2 == null || i10 < 0) {
            throw new IllegalArgumentException();
        }
        if (fArr.length < i10 + 3 || i11 < 0 || fArr2.length < i11 + 3) {
            throw new IllegalArgumentException();
        }
        ARQuaternion.rotateVector(this.quaternion, fArr, i10, fArr2, i11);
    }

    public void toMatrix(float[] fArr, int i10) {
        if (fArr == null || i10 < 0 || fArr.length < i10 + 16) {
            throw new IllegalArgumentException();
        }
        this.quaternion.toMatrix(fArr, i10, 4);
        float[] fArr2 = this.translation;
        fArr[i10 + 12] = fArr2[0];
        fArr[i10 + 13] = fArr2[1];
        fArr[i10 + 14] = fArr2[2];
        fArr[i10 + 3] = 0.0f;
        fArr[i10 + 7] = 0.0f;
        fArr[i10 + 11] = 0.0f;
        fArr[i10 + 15] = 1.0f;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "ARPose t:[x:%.3f, y:%.3f, z:%.3f], ARPose q:[x:%.2f, y:%.2f, z:%.2f, w:%.2f]", Float.valueOf(this.translation[0]), Float.valueOf(this.translation[1]), Float.valueOf(this.translation[2]), Float.valueOf(this.quaternion.getX()), Float.valueOf(this.quaternion.getY()), Float.valueOf(this.quaternion.getZ()), Float.valueOf(this.quaternion.getW()));
    }

    public void transformPoint(float[] fArr, int i10, float[] fArr2, int i11) {
        rotateVector(fArr, i10, fArr2, i11);
        for (int i12 = 0; i12 < 3; i12++) {
            int i13 = i12 + i11;
            fArr2[i13] = fArr2[i13] + this.translation[i12];
        }
    }

    /* renamed from: tx */
    public float m29070tx() {
        return this.translation[0];
    }

    /* renamed from: ty */
    public float m29071ty() {
        return this.translation[1];
    }

    /* renamed from: tz */
    public float m29072tz() {
        return this.translation[2];
    }

    private ARPose(float[] fArr, ARQuaternion aRQuaternion) {
        this.translation = fArr;
        this.quaternion = aRQuaternion;
    }

    public static ARPose makeRotation(float[] fArr) {
        if (fArr == null || fArr.length < 4) {
            throw new IllegalArgumentException();
        }
        return makeRotation(fArr[0], fArr[1], fArr[2], fArr[3]);
    }

    public static ARPose makeTranslation(float[] fArr) {
        if (fArr == null || fArr.length < 3) {
            throw new IllegalArgumentException();
        }
        return makeTranslation(fArr[0], fArr[1], fArr[2]);
    }

    public float[] getTransformedAxis(int i10, float f10) {
        float[] fArr = new float[3];
        getTransformedAxis(i10, f10, fArr, 0);
        return fArr;
    }

    public float[] transformPoint(float[] fArr) {
        float[] fArr2 = new float[3];
        transformPoint(fArr, 0, fArr2, 0);
        return fArr2;
    }

    public ARPose(float[] fArr, float[] fArr2) {
        if (fArr == null || fArr.length < 3 || fArr2 == null || fArr2.length < 4) {
            throw new IllegalArgumentException();
        }
        this.quaternion = new ARQuaternion(fArr2[0], fArr2[1], fArr2[2], fArr2[3]);
        this.translation = new float[]{fArr[0], fArr[1], fArr[2]};
    }
}
