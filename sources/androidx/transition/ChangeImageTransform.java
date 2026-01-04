package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.transition.C0958s;
import java.util.Map;

/* loaded from: classes.dex */
public class ChangeImageTransform extends Transition {

    /* renamed from: K */
    public static final String[] f4699K = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};

    /* renamed from: L */
    public static final TypeEvaluator<Matrix> f4700L = new C0897a();

    /* renamed from: M */
    public static final Property<ImageView, Matrix> f4701M = new C0898b(Matrix.class, "animatedTransform");

    /* renamed from: androidx.transition.ChangeImageTransform$a */
    public static class C0897a implements TypeEvaluator<Matrix> {
        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f10, Matrix matrix, Matrix matrix2) {
            return null;
        }
    }

    /* renamed from: androidx.transition.ChangeImageTransform$b */
    public static class C0898b extends Property<ImageView, Matrix> {
        public C0898b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix get(ImageView imageView) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(ImageView imageView, Matrix matrix) {
            C0943h.m5815a(imageView, matrix);
        }
    }

    /* renamed from: androidx.transition.ChangeImageTransform$c */
    public static /* synthetic */ class C0899c {

        /* renamed from: a */
        public static final /* synthetic */ int[] f4702a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f4702a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4702a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ChangeImageTransform() {
    }

    /* renamed from: j0 */
    private void m5644j0(C0959t c0959t) {
        View view = c0959t.f4889b;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() == null) {
                return;
            }
            Map<String, Object> map = c0959t.f4888a;
            map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            map.put("android:changeImageTransform:matrix", m5646l0(imageView));
        }
    }

    /* renamed from: k0 */
    public static Matrix m5645k0(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        float width = imageView.getWidth();
        float f10 = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float height = imageView.getHeight();
        float f11 = intrinsicHeight;
        float fMax = Math.max(width / f10, height / f11);
        int iRound = Math.round((width - (f10 * fMax)) / 2.0f);
        int iRound2 = Math.round((height - (f11 * fMax)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.postScale(fMax, fMax);
        matrix.postTranslate(iRound, iRound2);
        return matrix;
    }

    /* renamed from: l0 */
    public static Matrix m5646l0(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            int i10 = C0899c.f4702a[imageView.getScaleType().ordinal()];
            if (i10 == 1) {
                return m5647o0(imageView);
            }
            if (i10 == 2) {
                return m5645k0(imageView);
            }
        }
        return new Matrix(imageView.getImageMatrix());
    }

    /* renamed from: o0 */
    public static Matrix m5647o0(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale(imageView.getWidth() / drawable.getIntrinsicWidth(), imageView.getHeight() / drawable.getIntrinsicHeight());
        return matrix;
    }

    @Override // androidx.transition.Transition
    /* renamed from: G */
    public String[] mo5617G() {
        return f4699K;
    }

    @Override // androidx.transition.Transition
    /* renamed from: i */
    public void mo5618i(C0959t c0959t) {
        m5644j0(c0959t);
    }

    @Override // androidx.transition.Transition
    /* renamed from: l */
    public void mo5621l(C0959t c0959t) {
        m5644j0(c0959t);
    }

    /* renamed from: m0 */
    public final ObjectAnimator m5648m0(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) f4701M, (TypeEvaluator) new C0958s.a(), (Object[]) new Matrix[]{matrix, matrix2});
    }

    /* renamed from: n0 */
    public final ObjectAnimator m5649n0(ImageView imageView) {
        Property<ImageView, Matrix> property = f4701M;
        TypeEvaluator<Matrix> typeEvaluator = f4700L;
        Matrix matrix = C0945i.f4856a;
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) property, (TypeEvaluator) typeEvaluator, (Object[]) new Matrix[]{matrix, matrix});
    }

    @Override // androidx.transition.Transition
    /* renamed from: p */
    public Animator mo5623p(ViewGroup viewGroup, C0959t c0959t, C0959t c0959t2) {
        if (c0959t != null && c0959t2 != null) {
            Rect rect = (Rect) c0959t.f4888a.get("android:changeImageTransform:bounds");
            Rect rect2 = (Rect) c0959t2.f4888a.get("android:changeImageTransform:bounds");
            if (rect != null && rect2 != null) {
                Matrix matrix = (Matrix) c0959t.f4888a.get("android:changeImageTransform:matrix");
                Matrix matrix2 = (Matrix) c0959t2.f4888a.get("android:changeImageTransform:matrix");
                boolean z10 = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
                if (rect.equals(rect2) && z10) {
                    return null;
                }
                ImageView imageView = (ImageView) c0959t2.f4889b;
                Drawable drawable = imageView.getDrawable();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                    return m5649n0(imageView);
                }
                if (matrix == null) {
                    matrix = C0945i.f4856a;
                }
                if (matrix2 == null) {
                    matrix2 = C0945i.f4856a;
                }
                f4701M.set(imageView, matrix);
                return m5648m0(imageView, matrix, matrix2);
            }
        }
        return null;
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
