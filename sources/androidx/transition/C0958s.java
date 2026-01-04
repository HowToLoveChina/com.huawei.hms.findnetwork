package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/* renamed from: androidx.transition.s */
/* loaded from: classes.dex */
public class C0958s {

    /* renamed from: a */
    public static final boolean f4882a = true;

    /* renamed from: b */
    public static final boolean f4883b = true;

    /* renamed from: c */
    public static final boolean f4884c = true;

    /* renamed from: androidx.transition.s$a */
    public static class a implements TypeEvaluator<Matrix> {

        /* renamed from: a */
        public final float[] f4885a = new float[9];

        /* renamed from: b */
        public final float[] f4886b = new float[9];

        /* renamed from: c */
        public final Matrix f4887c = new Matrix();

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f10, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.f4885a);
            matrix2.getValues(this.f4886b);
            for (int i10 = 0; i10 < 9; i10++) {
                float[] fArr = this.f4886b;
                float f11 = fArr[i10];
                float f12 = this.f4885a[i10];
                fArr[i10] = f12 + ((f11 - f12) * f10);
            }
            this.f4887c.setValues(this.f4886b);
            return this.f4887c;
        }
    }

    /* renamed from: a */
    public static View m5837a(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(-view2.getScrollX(), -view2.getScrollY());
        C0932b0.m5793j(view, matrix);
        C0932b0.m5794k(viewGroup, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        matrix.mapRect(rectF);
        int iRound = Math.round(rectF.left);
        int iRound2 = Math.round(rectF.top);
        int iRound3 = Math.round(rectF.right);
        int iRound4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap bitmapM5838b = m5838b(view, matrix, rectF, viewGroup);
        if (bitmapM5838b != null) {
            imageView.setImageBitmap(bitmapM5838b);
        }
        imageView.measure(View.MeasureSpec.makeMeasureSpec(iRound3 - iRound, 1073741824), View.MeasureSpec.makeMeasureSpec(iRound4 - iRound2, 1073741824));
        imageView.layout(iRound, iRound2, iRound3, iRound4);
        return imageView;
    }

    /* renamed from: b */
    public static Bitmap m5838b(View view, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        boolean z10;
        boolean zIsAttachedToWindow;
        int iIndexOfChild;
        ViewGroup viewGroup2;
        if (f4882a) {
            z10 = !view.isAttachedToWindow();
            zIsAttachedToWindow = viewGroup == null ? false : viewGroup.isAttachedToWindow();
        } else {
            z10 = false;
            zIsAttachedToWindow = false;
        }
        boolean z11 = f4883b;
        Bitmap bitmapCreateBitmap = null;
        if (!z11 || !z10) {
            iIndexOfChild = 0;
            viewGroup2 = null;
        } else {
            if (!zIsAttachedToWindow) {
                return null;
            }
            viewGroup2 = (ViewGroup) view.getParent();
            iIndexOfChild = viewGroup2.indexOfChild(view);
            viewGroup.getOverlay().add(view);
        }
        int iRound = Math.round(rectF.width());
        int iRound2 = Math.round(rectF.height());
        if (iRound > 0 && iRound2 > 0) {
            float fMin = Math.min(1.0f, 1048576.0f / (iRound * iRound2));
            int iRound3 = Math.round(iRound * fMin);
            int iRound4 = Math.round(iRound2 * fMin);
            matrix.postTranslate(-rectF.left, -rectF.top);
            matrix.postScale(fMin, fMin);
            if (f4884c) {
                Picture picture = new Picture();
                Canvas canvasBeginRecording = picture.beginRecording(iRound3, iRound4);
                canvasBeginRecording.concat(matrix);
                view.draw(canvasBeginRecording);
                picture.endRecording();
                bitmapCreateBitmap = Bitmap.createBitmap(picture);
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(iRound3, iRound4, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.concat(matrix);
                view.draw(canvas);
            }
        }
        if (z11 && z10) {
            viewGroup.getOverlay().remove(view);
            viewGroup2.addView(view, iIndexOfChild);
        }
        return bitmapCreateBitmap;
    }

    /* renamed from: c */
    public static Animator m5839c(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }
}
