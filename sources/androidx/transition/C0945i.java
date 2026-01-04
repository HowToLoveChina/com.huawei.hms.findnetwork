package androidx.transition;

import android.graphics.Matrix;
import android.graphics.RectF;

/* renamed from: androidx.transition.i */
/* loaded from: classes.dex */
public class C0945i {

    /* renamed from: a */
    public static final Matrix f4856a = new a();

    /* renamed from: androidx.transition.i$a */
    public static class a extends Matrix {
        /* renamed from: a */
        public void m5816a() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        @Override // android.graphics.Matrix
        public boolean postConcat(Matrix matrix) {
            m5816a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f10, float f11, float f12) {
            m5816a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f10, float f11, float f12, float f13) {
            m5816a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f10, float f11, float f12, float f13) {
            m5816a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postTranslate(float f10, float f11) {
            m5816a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preConcat(Matrix matrix) {
            m5816a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f10, float f11, float f12) {
            m5816a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f10, float f11, float f12, float f13) {
            m5816a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f10, float f11, float f12, float f13) {
            m5816a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preTranslate(float f10, float f11) {
            m5816a();
            return false;
        }

        @Override // android.graphics.Matrix
        public void reset() {
            m5816a();
        }

        @Override // android.graphics.Matrix
        public void set(Matrix matrix) {
            m5816a();
        }

        @Override // android.graphics.Matrix
        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            m5816a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setPolyToPoly(float[] fArr, int i10, float[] fArr2, int i11, int i12) {
            m5816a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
            m5816a();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f10, float f11, float f12) {
            m5816a();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f10, float f11, float f12, float f13) {
            m5816a();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f10, float f11, float f12, float f13) {
            m5816a();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f10, float f11, float f12, float f13) {
            m5816a();
        }

        @Override // android.graphics.Matrix
        public void setTranslate(float f10, float f11) {
            m5816a();
        }

        @Override // android.graphics.Matrix
        public void setValues(float[] fArr) {
            m5816a();
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f10) {
            m5816a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f10, float f11) {
            m5816a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f10, float f11) {
            m5816a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f10) {
            m5816a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f10, float f11) {
            m5816a();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f10, float f11) {
            m5816a();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f10) {
            m5816a();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f10, float f11) {
            m5816a();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f10, float f11) {
            m5816a();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f10, float f11) {
            m5816a();
        }
    }
}
