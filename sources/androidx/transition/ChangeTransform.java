package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;
import p273f0.C9603h0;

/* loaded from: classes.dex */
public class ChangeTransform extends Transition {

    /* renamed from: N */
    public static final String[] f4704N = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};

    /* renamed from: O */
    public static final Property<C0904e, float[]> f4705O = new C0900a(float[].class, "nonTranslations");

    /* renamed from: P */
    public static final Property<C0904e, PointF> f4706P = new C0901b(PointF.class, "translations");

    /* renamed from: Q */
    public static final boolean f4707Q = true;

    /* renamed from: K */
    public boolean f4708K;

    /* renamed from: L */
    public boolean f4709L;

    /* renamed from: M */
    public Matrix f4710M;

    /* renamed from: androidx.transition.ChangeTransform$a */
    public static class C0900a extends Property<C0904e, float[]> {
        public C0900a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float[] get(C0904e c0904e) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(C0904e c0904e, float[] fArr) {
            c0904e.m5669d(fArr);
        }
    }

    /* renamed from: androidx.transition.ChangeTransform$b */
    public static class C0901b extends Property<C0904e, PointF> {
        public C0901b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(C0904e c0904e) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(C0904e c0904e, PointF pointF) {
            c0904e.m5668c(pointF);
        }
    }

    /* renamed from: androidx.transition.ChangeTransform$c */
    public class C0902c extends AnimatorListenerAdapter {

        /* renamed from: a */
        public boolean f4711a;

        /* renamed from: b */
        public Matrix f4712b = new Matrix();

        /* renamed from: c */
        public final /* synthetic */ boolean f4713c;

        /* renamed from: d */
        public final /* synthetic */ Matrix f4714d;

        /* renamed from: e */
        public final /* synthetic */ View f4715e;

        /* renamed from: f */
        public final /* synthetic */ C0905f f4716f;

        /* renamed from: g */
        public final /* synthetic */ C0904e f4717g;

        public C0902c(boolean z10, Matrix matrix, View view, C0905f c0905f, C0904e c0904e) {
            this.f4713c = z10;
            this.f4714d = matrix;
            this.f4715e = view;
            this.f4716f = c0905f;
            this.f4717g = c0904e;
        }

        /* renamed from: a */
        public final void m5665a(Matrix matrix) {
            this.f4712b.set(matrix);
            this.f4715e.setTag(R$id.transition_transform, this.f4712b);
            this.f4716f.m5670a(this.f4715e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f4711a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f4711a) {
                if (this.f4713c && ChangeTransform.this.f4708K) {
                    m5665a(this.f4714d);
                } else {
                    this.f4715e.setTag(R$id.transition_transform, null);
                    this.f4715e.setTag(R$id.parent_matrix, null);
                }
            }
            C0932b0.m5789f(this.f4715e, null);
            this.f4716f.m5670a(this.f4715e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            m5665a(this.f4717g.m5666a());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            ChangeTransform.m5655n0(this.f4715e);
        }
    }

    /* renamed from: androidx.transition.ChangeTransform$d */
    public static class C0903d extends C0955p {

        /* renamed from: a */
        public View f4719a;

        /* renamed from: b */
        public InterfaceC0939f f4720b;

        public C0903d(View view, InterfaceC0939f interfaceC0939f) {
            this.f4719a = view;
            this.f4720b = interfaceC0939f;
        }

        @Override // androidx.transition.C0955p, androidx.transition.Transition.InterfaceC0923f
        /* renamed from: b */
        public void mo5636b(Transition transition) {
            this.f4720b.setVisibility(4);
        }

        @Override // androidx.transition.Transition.InterfaceC0923f
        /* renamed from: c */
        public void mo5637c(Transition transition) {
            transition.mo5721V(this);
            C0941g.m5807b(this.f4719a);
            this.f4719a.setTag(R$id.transition_transform, null);
            this.f4719a.setTag(R$id.parent_matrix, null);
        }

        @Override // androidx.transition.C0955p, androidx.transition.Transition.InterfaceC0923f
        /* renamed from: e */
        public void mo5639e(Transition transition) {
            this.f4720b.setVisibility(0);
        }
    }

    /* renamed from: androidx.transition.ChangeTransform$e */
    public static class C0904e {

        /* renamed from: a */
        public final Matrix f4721a = new Matrix();

        /* renamed from: b */
        public final View f4722b;

        /* renamed from: c */
        public final float[] f4723c;

        /* renamed from: d */
        public float f4724d;

        /* renamed from: e */
        public float f4725e;

        public C0904e(View view, float[] fArr) {
            this.f4722b = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.f4723c = fArr2;
            this.f4724d = fArr2[2];
            this.f4725e = fArr2[5];
            m5667b();
        }

        /* renamed from: a */
        public Matrix m5666a() {
            return this.f4721a;
        }

        /* renamed from: b */
        public final void m5667b() {
            float[] fArr = this.f4723c;
            fArr[2] = this.f4724d;
            fArr[5] = this.f4725e;
            this.f4721a.setValues(fArr);
            C0932b0.m5789f(this.f4722b, this.f4721a);
        }

        /* renamed from: c */
        public void m5668c(PointF pointF) {
            this.f4724d = pointF.x;
            this.f4725e = pointF.y;
            m5667b();
        }

        /* renamed from: d */
        public void m5669d(float[] fArr) {
            System.arraycopy(fArr, 0, this.f4723c, 0, fArr.length);
            m5667b();
        }
    }

    /* renamed from: androidx.transition.ChangeTransform$f */
    public static class C0905f {

        /* renamed from: a */
        public final float f4726a;

        /* renamed from: b */
        public final float f4727b;

        /* renamed from: c */
        public final float f4728c;

        /* renamed from: d */
        public final float f4729d;

        /* renamed from: e */
        public final float f4730e;

        /* renamed from: f */
        public final float f4731f;

        /* renamed from: g */
        public final float f4732g;

        /* renamed from: h */
        public final float f4733h;

        public C0905f(View view) {
            this.f4726a = view.getTranslationX();
            this.f4727b = view.getTranslationY();
            this.f4728c = C9603h0.m59852K(view);
            this.f4729d = view.getScaleX();
            this.f4730e = view.getScaleY();
            this.f4731f = view.getRotationX();
            this.f4732g = view.getRotationY();
            this.f4733h = view.getRotation();
        }

        /* renamed from: a */
        public void m5670a(View view) {
            ChangeTransform.m5656p0(view, this.f4726a, this.f4727b, this.f4728c, this.f4729d, this.f4730e, this.f4731f, this.f4732g, this.f4733h);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0905f)) {
                return false;
            }
            C0905f c0905f = (C0905f) obj;
            return c0905f.f4726a == this.f4726a && c0905f.f4727b == this.f4727b && c0905f.f4728c == this.f4728c && c0905f.f4729d == this.f4729d && c0905f.f4730e == this.f4730e && c0905f.f4731f == this.f4731f && c0905f.f4732g == this.f4732g && c0905f.f4733h == this.f4733h;
        }

        public int hashCode() {
            float f10 = this.f4726a;
            int iFloatToIntBits = (f10 != 0.0f ? Float.floatToIntBits(f10) : 0) * 31;
            float f11 = this.f4727b;
            int iFloatToIntBits2 = (iFloatToIntBits + (f11 != 0.0f ? Float.floatToIntBits(f11) : 0)) * 31;
            float f12 = this.f4728c;
            int iFloatToIntBits3 = (iFloatToIntBits2 + (f12 != 0.0f ? Float.floatToIntBits(f12) : 0)) * 31;
            float f13 = this.f4729d;
            int iFloatToIntBits4 = (iFloatToIntBits3 + (f13 != 0.0f ? Float.floatToIntBits(f13) : 0)) * 31;
            float f14 = this.f4730e;
            int iFloatToIntBits5 = (iFloatToIntBits4 + (f14 != 0.0f ? Float.floatToIntBits(f14) : 0)) * 31;
            float f15 = this.f4731f;
            int iFloatToIntBits6 = (iFloatToIntBits5 + (f15 != 0.0f ? Float.floatToIntBits(f15) : 0)) * 31;
            float f16 = this.f4732g;
            int iFloatToIntBits7 = (iFloatToIntBits6 + (f16 != 0.0f ? Float.floatToIntBits(f16) : 0)) * 31;
            float f17 = this.f4733h;
            return iFloatToIntBits7 + (f17 != 0.0f ? Float.floatToIntBits(f17) : 0);
        }
    }

    public ChangeTransform() {
        this.f4708K = true;
        this.f4709L = true;
        this.f4710M = new Matrix();
    }

    /* renamed from: j0 */
    private void m5654j0(C0959t c0959t) {
        View view = c0959t.f4889b;
        if (view.getVisibility() == 8) {
            return;
        }
        c0959t.f4888a.put("android:changeTransform:parent", view.getParent());
        c0959t.f4888a.put("android:changeTransform:transforms", new C0905f(view));
        Matrix matrix = view.getMatrix();
        c0959t.f4888a.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
        if (this.f4709L) {
            Matrix matrix2 = new Matrix();
            C0932b0.m5793j((ViewGroup) view.getParent(), matrix2);
            matrix2.preTranslate(-r1.getScrollX(), -r1.getScrollY());
            c0959t.f4888a.put("android:changeTransform:parentMatrix", matrix2);
            c0959t.f4888a.put("android:changeTransform:intermediateMatrix", view.getTag(R$id.transition_transform));
            c0959t.f4888a.put("android:changeTransform:intermediateParentMatrix", view.getTag(R$id.parent_matrix));
        }
    }

    /* renamed from: n0 */
    public static void m5655n0(View view) {
        m5656p0(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    /* renamed from: p0 */
    public static void m5656p0(View view, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        view.setTranslationX(f10);
        view.setTranslationY(f11);
        C9603h0.m59849I0(view, f12);
        view.setScaleX(f13);
        view.setScaleY(f14);
        view.setRotationX(f15);
        view.setRotationY(f16);
        view.setRotation(f17);
    }

    @Override // androidx.transition.Transition
    /* renamed from: G */
    public String[] mo5617G() {
        return f4704N;
    }

    @Override // androidx.transition.Transition
    /* renamed from: i */
    public void mo5618i(C0959t c0959t) {
        m5654j0(c0959t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [androidx.transition.TransitionSet] */
    /* renamed from: k0 */
    public final void m5657k0(ViewGroup viewGroup, C0959t c0959t, C0959t c0959t2) {
        View view = c0959t2.f4889b;
        Matrix matrix = new Matrix((Matrix) c0959t2.f4888a.get("android:changeTransform:parentMatrix"));
        C0932b0.m5794k(viewGroup, matrix);
        InterfaceC0939f interfaceC0939fM5806a = C0941g.m5806a(view, viewGroup, matrix);
        if (interfaceC0939fM5806a == null) {
            return;
        }
        interfaceC0939fM5806a.mo5692a((ViewGroup) c0959t.f4888a.get("android:changeTransform:parent"), c0959t.f4889b);
        while (true) {
            ?? r12 = this.f4790r;
            if (r12 == 0) {
                break;
            } else {
                this = r12;
            }
        }
        this.mo5726a(new C0903d(view, interfaceC0939fM5806a));
        if (f4707Q) {
            View view2 = c0959t.f4889b;
            if (view2 != c0959t2.f4889b) {
                C0932b0.m5791h(view2, 0.0f);
            }
            C0932b0.m5791h(view, 1.0f);
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: l */
    public void mo5621l(C0959t c0959t) {
        m5654j0(c0959t);
        if (f4707Q) {
            return;
        }
        ((ViewGroup) c0959t.f4889b.getParent()).startViewTransition(c0959t.f4889b);
    }

    /* renamed from: l0 */
    public final ObjectAnimator m5658l0(C0959t c0959t, C0959t c0959t2, boolean z10) {
        Matrix matrix = (Matrix) c0959t.f4888a.get("android:changeTransform:matrix");
        Matrix matrix2 = (Matrix) c0959t2.f4888a.get("android:changeTransform:matrix");
        if (matrix == null) {
            matrix = C0945i.f4856a;
        }
        if (matrix2 == null) {
            matrix2 = C0945i.f4856a;
        }
        Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        C0905f c0905f = (C0905f) c0959t2.f4888a.get("android:changeTransform:transforms");
        View view = c0959t2.f4889b;
        m5655n0(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        C0904e c0904e = new C0904e(view, fArr);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(c0904e, PropertyValuesHolder.ofObject(f4705O, new C0935d(new float[9]), fArr, fArr2), C0949k.m5824a(f4706P, m5752y().mo5612a(fArr[2], fArr[5], fArr2[2], fArr2[5])));
        C0902c c0902c = new C0902c(z10, matrix3, view, c0905f, c0904e);
        objectAnimatorOfPropertyValuesHolder.addListener(c0902c);
        C0929a.m5778a(objectAnimatorOfPropertyValuesHolder, c0902c);
        return objectAnimatorOfPropertyValuesHolder;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001a  */
    /* renamed from: m0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m5659m0(android.view.ViewGroup r4, android.view.ViewGroup r5) {
        /*
            r3 = this;
            boolean r0 = r3.m5713L(r4)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L1d
            boolean r0 = r3.m5713L(r5)
            if (r0 != 0) goto Lf
            goto L1d
        Lf:
            androidx.transition.t r3 = r3.m5750w(r4, r1)
            if (r3 == 0) goto L20
            android.view.View r3 = r3.f4889b
            if (r5 != r3) goto L1a
            goto L1b
        L1a:
            r1 = r2
        L1b:
            r2 = r1
            goto L20
        L1d:
            if (r4 != r5) goto L1a
            goto L1b
        L20:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeTransform.m5659m0(android.view.ViewGroup, android.view.ViewGroup):boolean");
    }

    /* renamed from: o0 */
    public final void m5660o0(C0959t c0959t, C0959t c0959t2) {
        Matrix matrix = (Matrix) c0959t2.f4888a.get("android:changeTransform:parentMatrix");
        c0959t2.f4889b.setTag(R$id.parent_matrix, matrix);
        Matrix matrix2 = this.f4710M;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) c0959t.f4888a.get("android:changeTransform:matrix");
        if (matrix3 == null) {
            matrix3 = new Matrix();
            c0959t.f4888a.put("android:changeTransform:matrix", matrix3);
        }
        matrix3.postConcat((Matrix) c0959t.f4888a.get("android:changeTransform:parentMatrix"));
        matrix3.postConcat(matrix2);
    }

    @Override // androidx.transition.Transition
    /* renamed from: p */
    public Animator mo5623p(ViewGroup viewGroup, C0959t c0959t, C0959t c0959t2) {
        if (c0959t == null || c0959t2 == null || !c0959t.f4888a.containsKey("android:changeTransform:parent") || !c0959t2.f4888a.containsKey("android:changeTransform:parent")) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) c0959t.f4888a.get("android:changeTransform:parent");
        boolean z10 = this.f4709L && !m5659m0(viewGroup2, (ViewGroup) c0959t2.f4888a.get("android:changeTransform:parent"));
        Matrix matrix = (Matrix) c0959t.f4888a.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
            c0959t.f4888a.put("android:changeTransform:matrix", matrix);
        }
        Matrix matrix2 = (Matrix) c0959t.f4888a.get("android:changeTransform:intermediateParentMatrix");
        if (matrix2 != null) {
            c0959t.f4888a.put("android:changeTransform:parentMatrix", matrix2);
        }
        if (z10) {
            m5660o0(c0959t, c0959t2);
        }
        ObjectAnimator objectAnimatorM5658l0 = m5658l0(c0959t, c0959t2, z10);
        if (z10 && objectAnimatorM5658l0 != null && this.f4708K) {
            m5657k0(viewGroup, c0959t, c0959t2);
        } else if (!f4707Q) {
            viewGroup2.endViewTransition(c0959t.f4889b);
        }
        return objectAnimatorM5658l0;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4708K = true;
        this.f4709L = true;
        this.f4710M = new Matrix();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0954o.f4870g);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.f4708K = TypedArrayUtils.getNamedBoolean(typedArrayObtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.f4709L = TypedArrayUtils.getNamedBoolean(typedArrayObtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        typedArrayObtainStyledAttributes.recycle();
    }
}
