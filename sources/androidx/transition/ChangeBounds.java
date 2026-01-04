package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import java.util.Map;
import p273f0.C9603h0;

/* loaded from: classes.dex */
public class ChangeBounds extends Transition {

    /* renamed from: N */
    public static final String[] f4659N = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: O */
    public static final Property<Drawable, PointF> f4660O = new C0886b(PointF.class, "boundsOrigin");

    /* renamed from: P */
    public static final Property<C0895k, PointF> f4661P = new C0887c(PointF.class, "topLeft");

    /* renamed from: Q */
    public static final Property<C0895k, PointF> f4662Q = new C0888d(PointF.class, "bottomRight");

    /* renamed from: R */
    public static final Property<View, PointF> f4663R = new C0889e(PointF.class, "bottomRight");

    /* renamed from: S */
    public static final Property<View, PointF> f4664S = new C0890f(PointF.class, "topLeft");

    /* renamed from: T */
    public static final Property<View, PointF> f4665T = new C0891g(PointF.class, "position");

    /* renamed from: U */
    public static C0951l f4666U = new C0951l();

    /* renamed from: K */
    public int[] f4667K;

    /* renamed from: L */
    public boolean f4668L;

    /* renamed from: M */
    public boolean f4669M;

    /* renamed from: androidx.transition.ChangeBounds$a */
    public class C0885a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ ViewGroup f4670a;

        /* renamed from: b */
        public final /* synthetic */ BitmapDrawable f4671b;

        /* renamed from: c */
        public final /* synthetic */ View f4672c;

        /* renamed from: d */
        public final /* synthetic */ float f4673d;

        public C0885a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f10) {
            this.f4670a = viewGroup;
            this.f4671b = bitmapDrawable;
            this.f4672c = view;
            this.f4673d = f10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C0932b0.m5785b(this.f4670a).mo5782b(this.f4671b);
            C0932b0.m5791h(this.f4672c, this.f4673d);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$b */
    public static class C0886b extends Property<Drawable, PointF> {

        /* renamed from: a */
        public Rect f4675a;

        public C0886b(Class cls, String str) {
            super(cls, str);
            this.f4675a = new Rect();
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f4675a);
            Rect rect = this.f4675a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f4675a);
            this.f4675a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f4675a);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$c */
    public static class C0887c extends Property<C0895k, PointF> {
        public C0887c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(C0895k c0895k) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(C0895k c0895k, PointF pointF) {
            c0895k.m5642c(pointF);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$d */
    public static class C0888d extends Property<C0895k, PointF> {
        public C0888d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(C0895k c0895k) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(C0895k c0895k, PointF pointF) {
            c0895k.m5640a(pointF);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$e */
    public static class C0889e extends Property<View, PointF> {
        public C0889e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            C0932b0.m5790g(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$f */
    public static class C0890f extends Property<View, PointF> {
        public C0890f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            C0932b0.m5790g(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$g */
    public static class C0891g extends Property<View, PointF> {
        public C0891g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int iRound = Math.round(pointF.x);
            int iRound2 = Math.round(pointF.y);
            C0932b0.m5790g(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$h */
    public class C0892h extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ C0895k f4676a;
        private C0895k mViewBounds;

        public C0892h(C0895k c0895k) {
            this.f4676a = c0895k;
            this.mViewBounds = c0895k;
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$i */
    public class C0893i extends AnimatorListenerAdapter {

        /* renamed from: a */
        public boolean f4678a;

        /* renamed from: b */
        public final /* synthetic */ View f4679b;

        /* renamed from: c */
        public final /* synthetic */ Rect f4680c;

        /* renamed from: d */
        public final /* synthetic */ int f4681d;

        /* renamed from: e */
        public final /* synthetic */ int f4682e;

        /* renamed from: f */
        public final /* synthetic */ int f4683f;

        /* renamed from: g */
        public final /* synthetic */ int f4684g;

        public C0893i(View view, Rect rect, int i10, int i11, int i12, int i13) {
            this.f4679b = view;
            this.f4680c = rect;
            this.f4681d = i10;
            this.f4682e = i11;
            this.f4683f = i12;
            this.f4684g = i13;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f4678a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f4678a) {
                return;
            }
            C9603h0.m59916w0(this.f4679b, this.f4680c);
            C0932b0.m5790g(this.f4679b, this.f4681d, this.f4682e, this.f4683f, this.f4684g);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$j */
    public class C0894j extends C0955p {

        /* renamed from: a */
        public boolean f4686a = false;

        /* renamed from: b */
        public final /* synthetic */ ViewGroup f4687b;

        public C0894j(ViewGroup viewGroup) {
            this.f4687b = viewGroup;
        }

        @Override // androidx.transition.C0955p, androidx.transition.Transition.InterfaceC0923f
        /* renamed from: b */
        public void mo5636b(Transition transition) {
            C0964y.m5846c(this.f4687b, false);
        }

        @Override // androidx.transition.Transition.InterfaceC0923f
        /* renamed from: c */
        public void mo5637c(Transition transition) {
            if (!this.f4686a) {
                C0964y.m5846c(this.f4687b, false);
            }
            transition.mo5721V(this);
        }

        @Override // androidx.transition.C0955p, androidx.transition.Transition.InterfaceC0923f
        /* renamed from: d */
        public void mo5638d(Transition transition) {
            C0964y.m5846c(this.f4687b, false);
            this.f4686a = true;
        }

        @Override // androidx.transition.C0955p, androidx.transition.Transition.InterfaceC0923f
        /* renamed from: e */
        public void mo5639e(Transition transition) {
            C0964y.m5846c(this.f4687b, true);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$k */
    public static class C0895k {

        /* renamed from: a */
        public int f4689a;

        /* renamed from: b */
        public int f4690b;

        /* renamed from: c */
        public int f4691c;

        /* renamed from: d */
        public int f4692d;

        /* renamed from: e */
        public View f4693e;

        /* renamed from: f */
        public int f4694f;

        /* renamed from: g */
        public int f4695g;

        public C0895k(View view) {
            this.f4693e = view;
        }

        /* renamed from: a */
        public void m5640a(PointF pointF) {
            this.f4691c = Math.round(pointF.x);
            this.f4692d = Math.round(pointF.y);
            int i10 = this.f4695g + 1;
            this.f4695g = i10;
            if (this.f4694f == i10) {
                m5641b();
            }
        }

        /* renamed from: b */
        public final void m5641b() {
            C0932b0.m5790g(this.f4693e, this.f4689a, this.f4690b, this.f4691c, this.f4692d);
            this.f4694f = 0;
            this.f4695g = 0;
        }

        /* renamed from: c */
        public void m5642c(PointF pointF) {
            this.f4689a = Math.round(pointF.x);
            this.f4690b = Math.round(pointF.y);
            int i10 = this.f4694f + 1;
            this.f4694f = i10;
            if (i10 == this.f4695g) {
                m5641b();
            }
        }
    }

    public ChangeBounds() {
        this.f4667K = new int[2];
        this.f4668L = false;
        this.f4669M = false;
    }

    @Override // androidx.transition.Transition
    /* renamed from: G */
    public String[] mo5617G() {
        return f4659N;
    }

    @Override // androidx.transition.Transition
    /* renamed from: i */
    public void mo5618i(C0959t c0959t) {
        m5619j0(c0959t);
    }

    /* renamed from: j0 */
    public final void m5619j0(C0959t c0959t) {
        View view = c0959t.f4889b;
        if (!C9603h0.m59864T(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        c0959t.f4888a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        c0959t.f4888a.put("android:changeBounds:parent", c0959t.f4889b.getParent());
        if (this.f4669M) {
            c0959t.f4889b.getLocationInWindow(this.f4667K);
            c0959t.f4888a.put("android:changeBounds:windowX", Integer.valueOf(this.f4667K[0]));
            c0959t.f4888a.put("android:changeBounds:windowY", Integer.valueOf(this.f4667K[1]));
        }
        if (this.f4668L) {
            c0959t.f4888a.put("android:changeBounds:clip", C9603h0.m59909t(view));
        }
    }

    /* renamed from: k0 */
    public final boolean m5620k0(View view, View view2) {
        if (!this.f4669M) {
            return true;
        }
        C0959t c0959tM5750w = m5750w(view, true);
        if (c0959tM5750w == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == c0959tM5750w.f4889b) {
            return true;
        }
        return false;
    }

    @Override // androidx.transition.Transition
    /* renamed from: l */
    public void mo5621l(C0959t c0959t) {
        m5619j0(c0959t);
    }

    /* renamed from: l0 */
    public void m5622l0(boolean z10) {
        this.f4668L = z10;
    }

    @Override // androidx.transition.Transition
    /* renamed from: p */
    public Animator mo5623p(ViewGroup viewGroup, C0959t c0959t, C0959t c0959t2) {
        int i10;
        View view;
        int i11;
        ObjectAnimator objectAnimator;
        Animator animatorM5839c;
        if (c0959t == null || c0959t2 == null) {
            return null;
        }
        Map<String, Object> map = c0959t.f4888a;
        Map<String, Object> map2 = c0959t2.f4888a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = c0959t2.f4889b;
        if (!m5620k0(viewGroup2, viewGroup3)) {
            int iIntValue = ((Integer) c0959t.f4888a.get("android:changeBounds:windowX")).intValue();
            int iIntValue2 = ((Integer) c0959t.f4888a.get("android:changeBounds:windowY")).intValue();
            int iIntValue3 = ((Integer) c0959t2.f4888a.get("android:changeBounds:windowX")).intValue();
            int iIntValue4 = ((Integer) c0959t2.f4888a.get("android:changeBounds:windowY")).intValue();
            if (iIntValue == iIntValue3 && iIntValue2 == iIntValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.f4667K);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(bitmapCreateBitmap));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            float fM5786c = C0932b0.m5786c(view2);
            C0932b0.m5791h(view2, 0.0f);
            C0932b0.m5785b(viewGroup).mo5781a(bitmapDrawable);
            PathMotion pathMotionM5752y = m5752y();
            int[] iArr = this.f4667K;
            int i12 = iArr[0];
            int i13 = iArr[1];
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, C0949k.m5824a(f4660O, pathMotionM5752y.mo5612a(iIntValue - i12, iIntValue2 - i13, iIntValue3 - i12, iIntValue4 - i13)));
            objectAnimatorOfPropertyValuesHolder.addListener(new C0885a(viewGroup, bitmapDrawable, view2, fM5786c));
            return objectAnimatorOfPropertyValuesHolder;
        }
        Rect rect = (Rect) c0959t.f4888a.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) c0959t2.f4888a.get("android:changeBounds:bounds");
        int i14 = rect.left;
        int i15 = rect2.left;
        int i16 = rect.top;
        int i17 = rect2.top;
        int i18 = rect.right;
        int i19 = rect2.right;
        int i20 = rect.bottom;
        int i21 = rect2.bottom;
        int i22 = i18 - i14;
        int i23 = i20 - i16;
        int i24 = i19 - i15;
        int i25 = i21 - i17;
        Rect rect3 = (Rect) c0959t.f4888a.get("android:changeBounds:clip");
        Rect rect4 = (Rect) c0959t2.f4888a.get("android:changeBounds:clip");
        if ((i22 == 0 || i23 == 0) && (i24 == 0 || i25 == 0)) {
            i10 = 0;
        } else {
            i10 = (i14 == i15 && i16 == i17) ? 0 : 1;
            if (i18 != i19 || i20 != i21) {
                i10++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i10++;
        }
        if (i10 <= 0) {
            return null;
        }
        if (this.f4668L) {
            view = view2;
            C0932b0.m5790g(view, i14, i16, Math.max(i22, i24) + i14, Math.max(i23, i25) + i16);
            ObjectAnimator objectAnimatorM5823a = (i14 == i15 && i16 == i17) ? null : C0947j.m5823a(view, f4665T, m5752y().mo5612a(i14, i16, i15, i17));
            if (rect3 == null) {
                i11 = 0;
                rect3 = new Rect(0, 0, i22, i23);
            } else {
                i11 = 0;
            }
            Rect rect5 = rect4 == null ? new Rect(i11, i11, i24, i25) : rect4;
            if (rect3.equals(rect5)) {
                objectAnimator = null;
            } else {
                C9603h0.m59916w0(view, rect3);
                ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", f4666U, rect3, rect5);
                objectAnimatorOfObject.addListener(new C0893i(view, rect4, i15, i17, i19, i21));
                objectAnimator = objectAnimatorOfObject;
            }
            animatorM5839c = C0958s.m5839c(objectAnimatorM5823a, objectAnimator);
        } else {
            view = view2;
            C0932b0.m5790g(view, i14, i16, i18, i20);
            if (i10 != 2) {
                animatorM5839c = (i14 == i15 && i16 == i17) ? C0947j.m5823a(view, f4663R, m5752y().mo5612a(i18, i20, i19, i21)) : C0947j.m5823a(view, f4664S, m5752y().mo5612a(i14, i16, i15, i17));
            } else if (i22 == i24 && i23 == i25) {
                animatorM5839c = C0947j.m5823a(view, f4665T, m5752y().mo5612a(i14, i16, i15, i17));
            } else {
                C0895k c0895k = new C0895k(view);
                ObjectAnimator objectAnimatorM5823a2 = C0947j.m5823a(c0895k, f4661P, m5752y().mo5612a(i14, i16, i15, i17));
                ObjectAnimator objectAnimatorM5823a3 = C0947j.m5823a(c0895k, f4662Q, m5752y().mo5612a(i18, i20, i19, i21));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimatorM5823a2, objectAnimatorM5823a3);
                animatorSet.addListener(new C0892h(c0895k));
                animatorM5839c = animatorSet;
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            C0964y.m5846c(viewGroup4, true);
            mo5726a(new C0894j(viewGroup4));
        }
        return animatorM5839c;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4667K = new int[2];
        this.f4668L = false;
        this.f4669M = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0954o.f4867d);
        boolean namedBoolean = TypedArrayUtils.getNamedBoolean(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        typedArrayObtainStyledAttributes.recycle();
        m5622l0(namedBoolean);
    }
}
