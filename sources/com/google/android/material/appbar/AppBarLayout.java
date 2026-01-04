package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$integer;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1784o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p211d.C8968a;
import p243e0.C9368c;
import p273f0.C9582a;
import p273f0.C9603h0;
import p273f0.C9625s0;
import p273f0.InterfaceC9586b0;
import p273f0.InterfaceC9632w;
import p304g0.C9832l;
import p304g0.InterfaceC9835o;
import p356i3.C10427h;
import p356i3.C10428i;
import p416k3.C10981a;
import p666u2.C13110a;
import p757x.C13669a;
import p827z.C14059a;

/* loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.InterfaceC0591b {

    /* renamed from: t */
    public static final int f7338t = R$style.Widget_Design_AppBarLayout;

    /* renamed from: a */
    public int f7339a;

    /* renamed from: b */
    public int f7340b;

    /* renamed from: c */
    public int f7341c;

    /* renamed from: d */
    public int f7342d;

    /* renamed from: e */
    public boolean f7343e;

    /* renamed from: f */
    public int f7344f;

    /* renamed from: g */
    public C9625s0 f7345g;

    /* renamed from: h */
    public List<InterfaceC1640c> f7346h;

    /* renamed from: i */
    public boolean f7347i;

    /* renamed from: j */
    public boolean f7348j;

    /* renamed from: k */
    public boolean f7349k;

    /* renamed from: l */
    public boolean f7350l;

    /* renamed from: m */
    public int f7351m;

    /* renamed from: n */
    public WeakReference<View> f7352n;

    /* renamed from: o */
    public ValueAnimator f7353o;

    /* renamed from: p */
    public final List<InterfaceC1643f> f7354p;

    /* renamed from: q */
    public int[] f7355q;

    /* renamed from: r */
    public Drawable f7356r;

    /* renamed from: s */
    public Behavior f7357s;

    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {

        /* renamed from: k */
        public int f7358k;

        /* renamed from: l */
        public int f7359l;

        /* renamed from: m */
        public ValueAnimator f7360m;

        /* renamed from: n */
        public SavedState f7361n;

        /* renamed from: o */
        public WeakReference<View> f7362o;

        /* renamed from: p */
        public boolean f7363p;

        /* renamed from: com.google.android.material.appbar.AppBarLayout$BaseBehavior$a */
        public class C1634a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a */
            public final /* synthetic */ CoordinatorLayout f7369a;

            /* renamed from: b */
            public final /* synthetic */ AppBarLayout f7370b;

            public C1634a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f7369a = coordinatorLayout;
                this.f7370b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseBehavior.this.m9586P(this.f7369a, this.f7370b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* renamed from: com.google.android.material.appbar.AppBarLayout$BaseBehavior$b */
        public class C1635b extends C9582a {
            public C1635b() {
            }

            @Override // p273f0.C9582a
            public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
                super.onInitializeAccessibilityNodeInfo(view, c9832l);
                c9832l.m61102q0(BaseBehavior.this.f7363p);
                c9832l.m61065U(ScrollView.class.getName());
            }
        }

        /* renamed from: com.google.android.material.appbar.AppBarLayout$BaseBehavior$c */
        public class C1636c implements InterfaceC9835o {

            /* renamed from: a */
            public final /* synthetic */ CoordinatorLayout f7373a;

            /* renamed from: b */
            public final /* synthetic */ AppBarLayout f7374b;

            /* renamed from: c */
            public final /* synthetic */ View f7375c;

            /* renamed from: d */
            public final /* synthetic */ int f7376d;

            public C1636c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10) {
                this.f7373a = coordinatorLayout;
                this.f7374b = appBarLayout;
                this.f7375c = view;
                this.f7376d = i10;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // p304g0.InterfaceC9835o
            /* renamed from: a */
            public boolean mo4167a(View view, InterfaceC9835o.a aVar) {
                BaseBehavior.this.mo3743q(this.f7373a, this.f7374b, this.f7375c, 0, this.f7376d, new int[]{0, 0}, 1);
                return true;
            }
        }

        /* renamed from: com.google.android.material.appbar.AppBarLayout$BaseBehavior$d */
        public class C1637d implements InterfaceC9835o {

            /* renamed from: a */
            public final /* synthetic */ AppBarLayout f7378a;

            /* renamed from: b */
            public final /* synthetic */ boolean f7379b;

            public C1637d(AppBarLayout appBarLayout, boolean z10) {
                this.f7378a = appBarLayout;
                this.f7379b = z10;
            }

            @Override // p304g0.InterfaceC9835o
            /* renamed from: a */
            public boolean mo4167a(View view, InterfaceC9835o.a aVar) {
                this.f7378a.setExpanded(this.f7379b);
                return true;
            }
        }

        public BaseBehavior() {
        }

        /* renamed from: a0 */
        public static boolean m9499a0(int i10, int i11) {
            return (i10 & i11) == i11;
        }

        /* renamed from: d0 */
        public static View m9500d0(AppBarLayout appBarLayout, int i10) {
            int iAbs = Math.abs(i10);
            int childCount = appBarLayout.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = appBarLayout.getChildAt(i11);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: M */
        public int mo9504M() {
            return mo9540E() + this.f7358k;
        }

        /* renamed from: T */
        public final boolean m9507T(CoordinatorLayout coordinatorLayout, T t10, View view) {
            boolean z10 = false;
            if (mo9504M() != (-t10.getTotalScrollRange())) {
                m9508U(coordinatorLayout, t10, C9832l.a.f48307q, false);
                z10 = true;
            }
            if (mo9504M() != 0) {
                if (!view.canScrollVertically(-1)) {
                    m9508U(coordinatorLayout, t10, C9832l.a.f48308r, true);
                    return true;
                }
                int i10 = -t10.getDownNestedPreScrollRange();
                if (i10 != 0) {
                    C9603h0.m59894l0(coordinatorLayout, C9832l.a.f48308r, null, new C1636c(coordinatorLayout, t10, view, i10));
                    return true;
                }
            }
            return z10;
        }

        /* renamed from: U */
        public final void m9508U(CoordinatorLayout coordinatorLayout, T t10, C9832l.a aVar, boolean z10) {
            C9603h0.m59894l0(coordinatorLayout, aVar, null, new C1637d(t10, z10));
        }

        /* renamed from: V */
        public final void m9509V(CoordinatorLayout coordinatorLayout, T t10, int i10, float f10) {
            int iAbs = Math.abs(mo9504M() - i10);
            float fAbs = Math.abs(f10);
            m9510W(coordinatorLayout, t10, i10, fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / t10.getHeight()) + 1.0f) * 150.0f));
        }

        /* renamed from: W */
        public final void m9510W(CoordinatorLayout coordinatorLayout, T t10, int i10, int i11) {
            int iMo9504M = mo9504M();
            if (iMo9504M == i10) {
                ValueAnimator valueAnimator = this.f7360m;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f7360m.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f7360m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f7360m = valueAnimator3;
                valueAnimator3.setInterpolator(C13110a.f59601e);
                this.f7360m.addUpdateListener(new C1634a(coordinatorLayout, t10));
            } else {
                valueAnimator2.cancel();
            }
            this.f7360m.setDuration(Math.min(i11, 600));
            this.f7360m.setIntValues(iMo9504M, i10);
            this.f7360m.start();
        }

        /* renamed from: X */
        public final int m9511X(int i10, int i11, int i12) {
            return i10 < (i11 + i12) / 2 ? i11 : i12;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: Y */
        public boolean mo9501H(T t10) {
            WeakReference<View> weakReference = this.f7362o;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        /* renamed from: Z */
        public final boolean m9513Z(CoordinatorLayout coordinatorLayout, T t10, View view) {
            return t10.m9482l() && coordinatorLayout.getHeight() - view.getHeight() <= t10.getHeight();
        }

        /* renamed from: b0 */
        public final boolean m9514b0(AppBarLayout appBarLayout) {
            int childCount = appBarLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (((LayoutParams) appBarLayout.getChildAt(i10).getLayoutParams()).f7381a != 0) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: c0 */
        public final View m9515c0(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if ((childAt instanceof InterfaceC9632w) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        /* renamed from: e0 */
        public final int m9516e0(T t10, int i10) {
            int childCount = t10.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = t10.getChildAt(i11);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (m9499a0(layoutParams.m9544c(), 32)) {
                    top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                int i12 = -i10;
                if (top <= i12 && bottom >= i12) {
                    return i11;
                }
            }
            return -1;
        }

        /* renamed from: f0 */
        public final View m9517f0(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if (((CoordinatorLayout.C0594e) childAt.getLayoutParams()).m3761f() instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: g0 */
        public int mo9502K(T t10) {
            return -t10.getDownNestedScrollRange();
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: h0 */
        public int mo9503L(T t10) {
            return t10.getTotalScrollRange();
        }

        /* renamed from: i0 */
        public final int m9520i0(T t10, int i10) {
            int iAbs = Math.abs(i10);
            int childCount = t10.getChildCount();
            int topInset = 0;
            int i11 = 0;
            while (true) {
                if (i11 >= childCount) {
                    break;
                }
                View childAt = t10.getChildAt(i11);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator interpolatorM9545d = layoutParams.m9545d();
                if (iAbs < childAt.getTop() || iAbs > childAt.getBottom()) {
                    i11++;
                } else if (interpolatorM9545d != null) {
                    int iM9544c = layoutParams.m9544c();
                    if ((iM9544c & 1) != 0) {
                        topInset = childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        if ((iM9544c & 2) != 0) {
                            topInset -= C9603h0.m59834B(childAt);
                        }
                    }
                    if (C9603h0.m59917x(childAt)) {
                        topInset -= t10.getTopInset();
                    }
                    if (topInset > 0) {
                        float f10 = topInset;
                        return Integer.signum(i10) * (childAt.getTop() + Math.round(f10 * interpolatorM9545d.getInterpolation((iAbs - childAt.getTop()) / f10)));
                    }
                }
            }
            return i10;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: j0 */
        public void mo9505N(CoordinatorLayout coordinatorLayout, T t10) {
            m9534w0(coordinatorLayout, t10);
            if (t10.m9484n()) {
                t10.m9493w(t10.m9496z(m9515c0(coordinatorLayout)));
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: k0 */
        public boolean mo3738l(CoordinatorLayout coordinatorLayout, T t10, int i10) {
            boolean zMo3738l = super.mo3738l(coordinatorLayout, t10, i10);
            int pendingAction = t10.getPendingAction();
            SavedState savedState = this.f7361n;
            if (savedState == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z10 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i11 = -t10.getUpNestedPreScrollRange();
                        if (z10) {
                            m9509V(coordinatorLayout, t10, i11, 0.0f);
                        } else {
                            m9586P(coordinatorLayout, t10, i11);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z10) {
                            m9509V(coordinatorLayout, t10, 0, 0.0f);
                        } else {
                            m9586P(coordinatorLayout, t10, 0);
                        }
                    }
                }
            } else if (savedState.f7364d) {
                m9586P(coordinatorLayout, t10, -t10.getTotalScrollRange());
            } else if (savedState.f7365e) {
                m9586P(coordinatorLayout, t10, 0);
            } else {
                View childAt = t10.getChildAt(savedState.f7366f);
                m9586P(coordinatorLayout, t10, (-childAt.getBottom()) + (this.f7361n.f7368h ? C9603h0.m59834B(childAt) + t10.getTopInset() : Math.round(childAt.getHeight() * this.f7361n.f7367g)));
            }
            t10.m9489s();
            this.f7361n = null;
            mo9541G(C14059a.m84263b(mo9540E(), -t10.getTotalScrollRange(), 0));
            m9536y0(coordinatorLayout, t10, mo9540E(), 0, true);
            t10.m9485o(mo9540E());
            m9535x0(coordinatorLayout, t10);
            return zMo3738l;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: l0 */
        public boolean mo3739m(CoordinatorLayout coordinatorLayout, T t10, int i10, int i11, int i12, int i13) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.C0594e) t10.getLayoutParams())).height != -2) {
                return super.mo3739m(coordinatorLayout, t10, i10, i11, i12, i13);
            }
            coordinatorLayout.m3699N(t10, i10, i11, View.MeasureSpec.makeMeasureSpec(0, 0), i13);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: m0 */
        public void mo3743q(CoordinatorLayout coordinatorLayout, T t10, View view, int i10, int i11, int[] iArr, int i12) {
            int i13;
            int downNestedPreScrollRange;
            if (i11 != 0) {
                if (i11 < 0) {
                    i13 = -t10.getTotalScrollRange();
                    downNestedPreScrollRange = t10.getDownNestedPreScrollRange() + i13;
                } else {
                    i13 = -t10.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                int i14 = i13;
                int i15 = downNestedPreScrollRange;
                if (i14 != i15) {
                    iArr[1] = m9585O(coordinatorLayout, t10, i11, i14, i15);
                }
            }
            if (t10.m9484n()) {
                t10.m9493w(t10.m9496z(view));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: n0 */
        public void mo3746t(CoordinatorLayout coordinatorLayout, T t10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            if (i13 < 0) {
                iArr[1] = m9585O(coordinatorLayout, t10, i13, -t10.getDownNestedScrollRange(), 0);
            }
            if (i13 == 0) {
                m9535x0(coordinatorLayout, t10);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: o0 */
        public void mo3750x(CoordinatorLayout coordinatorLayout, T t10, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                m9530s0((SavedState) parcelable, true);
                super.mo3750x(coordinatorLayout, t10, this.f7361n.getSuperState());
            } else {
                super.mo3750x(coordinatorLayout, t10, parcelable);
                this.f7361n = null;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: p0 */
        public Parcelable mo3751y(CoordinatorLayout coordinatorLayout, T t10) {
            Parcelable parcelableMo3751y = super.mo3751y(coordinatorLayout, t10);
            SavedState savedStateM9531t0 = m9531t0(parcelableMo3751y, t10);
            return savedStateM9531t0 == null ? parcelableMo3751y : savedStateM9531t0;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: q0 */
        public boolean mo3723A(CoordinatorLayout coordinatorLayout, T t10, View view, View view2, int i10, int i11) {
            ValueAnimator valueAnimator;
            boolean z10 = (i10 & 2) != 0 && (t10.m9484n() || m9513Z(coordinatorLayout, t10, view));
            if (z10 && (valueAnimator = this.f7360m) != null) {
                valueAnimator.cancel();
            }
            this.f7362o = null;
            this.f7359l = i11;
            return z10;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: r0 */
        public void mo3725C(CoordinatorLayout coordinatorLayout, T t10, View view, int i10) {
            if (this.f7359l == 0 || i10 == 1) {
                m9534w0(coordinatorLayout, t10);
                if (t10.m9484n()) {
                    t10.m9493w(t10.m9496z(view));
                }
            }
            this.f7362o = new WeakReference<>(view);
        }

        /* renamed from: s0 */
        public void m9530s0(SavedState savedState, boolean z10) {
            if (this.f7361n == null || z10) {
                this.f7361n = savedState;
            }
        }

        /* renamed from: t0 */
        public SavedState m9531t0(Parcelable parcelable, T t10) {
            int iMo9540E = mo9540E();
            int childCount = t10.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = t10.getChildAt(i10);
                int bottom = childAt.getBottom() + iMo9540E;
                if (childAt.getTop() + iMo9540E <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.EMPTY_STATE;
                    }
                    SavedState savedState = new SavedState(parcelable);
                    boolean z10 = iMo9540E == 0;
                    savedState.f7365e = z10;
                    savedState.f7364d = !z10 && (-iMo9540E) >= t10.getTotalScrollRange();
                    savedState.f7366f = i10;
                    savedState.f7368h = bottom == C9603h0.m59834B(childAt) + t10.getTopInset();
                    savedState.f7367g = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return null;
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        /* renamed from: u0 */
        public int mo9506Q(CoordinatorLayout coordinatorLayout, T t10, int i10, int i11, int i12) {
            int iMo9504M = mo9504M();
            int i13 = 0;
            if (i11 == 0 || iMo9504M < i11 || iMo9504M > i12) {
                this.f7358k = 0;
            } else {
                int iM84263b = C14059a.m84263b(i10, i11, i12);
                if (iMo9504M != iM84263b) {
                    int iM9520i0 = t10.m9480j() ? m9520i0(t10, iM84263b) : iM84263b;
                    boolean zMo9541G = mo9541G(iM9520i0);
                    int i14 = iMo9504M - iM84263b;
                    this.f7358k = iM84263b - iM9520i0;
                    if (zMo9541G) {
                        while (i13 < t10.getChildCount()) {
                            LayoutParams layoutParams = (LayoutParams) t10.getChildAt(i13).getLayoutParams();
                            AbstractC1641d abstractC1641dM9543b = layoutParams.m9543b();
                            if (abstractC1641dM9543b != null && (layoutParams.m9544c() & 1) != 0) {
                                abstractC1641dM9543b.mo9556a(t10, t10.getChildAt(i13), mo9540E());
                            }
                            i13++;
                        }
                    }
                    if (!zMo9541G && t10.m9480j()) {
                        coordinatorLayout.m3712p(t10);
                    }
                    t10.m9485o(mo9540E());
                    m9536y0(coordinatorLayout, t10, iM84263b, iM84263b < iMo9504M ? -1 : 1, false);
                    i13 = i14;
                }
            }
            m9535x0(coordinatorLayout, t10);
            return i13;
        }

        /* renamed from: v0 */
        public final boolean m9533v0(CoordinatorLayout coordinatorLayout, T t10) {
            List<View> listM3719w = coordinatorLayout.m3719w(t10);
            int size = listM3719w.size();
            for (int i10 = 0; i10 < size; i10++) {
                CoordinatorLayout.Behavior behaviorM3761f = ((CoordinatorLayout.C0594e) listM3719w.get(i10).getLayoutParams()).m3761f();
                if (behaviorM3761f instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) behaviorM3761f).m9590K() != 0;
                }
            }
            return false;
        }

        /* renamed from: w0 */
        public final void m9534w0(CoordinatorLayout coordinatorLayout, T t10) {
            int topInset = t10.getTopInset() + t10.getPaddingTop();
            int iMo9504M = mo9504M() - topInset;
            int iM9516e0 = m9516e0(t10, iMo9504M);
            if (iM9516e0 >= 0) {
                View childAt = t10.getChildAt(iM9516e0);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int iM9544c = layoutParams.m9544c();
                if ((iM9544c & 17) == 17) {
                    int topInset2 = -childAt.getTop();
                    int iM59834B = -childAt.getBottom();
                    if (iM9516e0 == 0 && C9603h0.m59917x(t10) && C9603h0.m59917x(childAt)) {
                        topInset2 -= t10.getTopInset();
                    }
                    if (m9499a0(iM9544c, 2)) {
                        iM59834B += C9603h0.m59834B(childAt);
                    } else if (m9499a0(iM9544c, 5)) {
                        int iM59834B2 = C9603h0.m59834B(childAt) + iM59834B;
                        if (iMo9504M < iM59834B2) {
                            topInset2 = iM59834B2;
                        } else {
                            iM59834B = iM59834B2;
                        }
                    }
                    if (m9499a0(iM9544c, 32)) {
                        topInset2 += ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        iM59834B -= ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    m9509V(coordinatorLayout, t10, C14059a.m84263b(m9511X(iMo9504M, iM59834B, topInset2) + topInset, -t10.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        /* renamed from: x0 */
        public final void m9535x0(CoordinatorLayout coordinatorLayout, T t10) {
            View viewM9517f0;
            C9603h0.m59890j0(coordinatorLayout, C9832l.a.f48307q.m61122b());
            C9603h0.m59890j0(coordinatorLayout, C9832l.a.f48308r.m61122b());
            if (t10.getTotalScrollRange() == 0 || (viewM9517f0 = m9517f0(coordinatorLayout)) == null || !m9514b0(t10)) {
                return;
            }
            if (!C9603h0.m59858N(coordinatorLayout)) {
                C9603h0.m59902p0(coordinatorLayout, new C1635b());
            }
            this.f7363p = m9507T(coordinatorLayout, t10, viewM9517f0);
        }

        /* renamed from: y0 */
        public final void m9536y0(CoordinatorLayout coordinatorLayout, T t10, int i10, int i11, boolean z10) {
            View viewM9500d0 = m9500d0(t10, i10);
            boolean zM9496z = false;
            if (viewM9500d0 != null) {
                int iM9544c = ((LayoutParams) viewM9500d0.getLayoutParams()).m9544c();
                if ((iM9544c & 1) != 0) {
                    int iM59834B = C9603h0.m59834B(viewM9500d0);
                    if (i11 <= 0 || (iM9544c & 12) == 0 ? !((iM9544c & 2) == 0 || (-i10) < (viewM9500d0.getBottom() - iM59834B) - t10.getTopInset()) : (-i10) >= (viewM9500d0.getBottom() - iM59834B) - t10.getTopInset()) {
                        zM9496z = true;
                    }
                }
            }
            if (t10.m9484n()) {
                zM9496z = t10.m9496z(m9515c0(coordinatorLayout));
            }
            boolean zM9493w = t10.m9493w(zM9496z);
            if (z10 || (zM9493w && m9533v0(coordinatorLayout, t10))) {
                t10.jumpDrawablesToCurrentState();
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new C1633a();

            /* renamed from: d */
            public boolean f7364d;

            /* renamed from: e */
            public boolean f7365e;

            /* renamed from: f */
            public int f7366f;

            /* renamed from: g */
            public float f7367g;

            /* renamed from: h */
            public boolean f7368h;

            /* renamed from: com.google.android.material.appbar.AppBarLayout$BaseBehavior$SavedState$a */
            public class C1633a implements Parcelable.ClassLoaderCreator<SavedState> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel) {
                    return new SavedState(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* renamed from: b */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: c */
                public SavedState[] newArray(int i10) {
                    return new SavedState[i10];
                }
            }

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f7364d = parcel.readByte() != 0;
                this.f7365e = parcel.readByte() != 0;
                this.f7366f = parcel.readInt();
                this.f7367g = parcel.readFloat();
                this.f7368h = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                super.writeToParcel(parcel, i10);
                parcel.writeByte(this.f7364d ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.f7365e ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.f7366f);
                parcel.writeFloat(this.f7367g);
                parcel.writeByte(this.f7368h ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: D */
        public /* bridge */ /* synthetic */ boolean mo3726D(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.mo3726D(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        /* renamed from: E */
        public /* bridge */ /* synthetic */ int mo9540E() {
            return super.mo9540E();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        /* renamed from: G */
        public /* bridge */ /* synthetic */ boolean mo9541G(int i10) {
            return super.mo9541G(i10);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: k */
        public /* bridge */ /* synthetic */ boolean mo3737k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.mo3737k(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: k0 */
        public /* bridge */ /* synthetic */ boolean mo3738l(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i10) {
            return super.mo3738l(coordinatorLayout, appBarLayout, i10);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: l0 */
        public /* bridge */ /* synthetic */ boolean mo3739m(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i10, int i11, int i12, int i13) {
            return super.mo3739m(coordinatorLayout, appBarLayout, i10, i11, i12, i13);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: m0 */
        public /* bridge */ /* synthetic */ void mo3743q(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10, int i11, int[] iArr, int i12) {
            super.mo3743q(coordinatorLayout, appBarLayout, view, i10, i11, iArr, i12);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: n0 */
        public /* bridge */ /* synthetic */ void mo3746t(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            super.mo3746t(coordinatorLayout, appBarLayout, view, i10, i11, i12, i13, i14, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: o0 */
        public /* bridge */ /* synthetic */ void mo3750x(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.mo3750x(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: p0 */
        public /* bridge */ /* synthetic */ Parcelable mo3751y(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.mo3751y(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: q0 */
        public /* bridge */ /* synthetic */ boolean mo3723A(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i10, int i11) {
            return super.mo3723A(coordinatorLayout, appBarLayout, view, view2, i10, i11);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* renamed from: r0 */
        public /* bridge */ /* synthetic */ void mo3725C(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10) {
            super.mo3725C(coordinatorLayout, appBarLayout, view, i10);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        /* renamed from: R */
        public static int m9548R(AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior behaviorM3761f = ((CoordinatorLayout.C0594e) appBarLayout.getLayoutParams()).m3761f();
            if (behaviorM3761f instanceof BaseBehavior) {
                return ((BaseBehavior) behaviorM3761f).mo9504M();
            }
            return 0;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        /* renamed from: J */
        public float mo9550J(View view) {
            int i10;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int iM9548R = m9548R(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + iM9548R > downNestedPreScrollRange) && (i10 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (iM9548R / i10) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        /* renamed from: L */
        public int mo9551L(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.mo9551L(view);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        /* renamed from: Q */
        public AppBarLayout mo9549H(List<View> list) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = list.get(i10);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        /* renamed from: S */
        public final void m9553S(View view, View view2) {
            CoordinatorLayout.Behavior behaviorM3761f = ((CoordinatorLayout.C0594e) view2.getLayoutParams()).m3761f();
            if (behaviorM3761f instanceof BaseBehavior) {
                C9603h0.m59872a0(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behaviorM3761f).f7358k) + m9591M()) - m9589I(view2));
            }
        }

        /* renamed from: T */
        public final void m9554T(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.m9484n()) {
                    appBarLayout.m9493w(appBarLayout.m9496z(view));
                }
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: e */
        public boolean mo3731e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: h */
        public boolean mo3734h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            m9553S(view, view2);
            m9554T(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: i */
        public void mo3735i(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                C9603h0.m59890j0(coordinatorLayout, C9832l.a.f48307q.m61122b());
                C9603h0.m59890j0(coordinatorLayout, C9832l.a.f48308r.m61122b());
                C9603h0.m59902p0(coordinatorLayout, null);
            }
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: l */
        public /* bridge */ /* synthetic */ boolean mo3738l(CoordinatorLayout coordinatorLayout, View view, int i10) {
            return super.mo3738l(coordinatorLayout, view, i10);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: m */
        public /* bridge */ /* synthetic */ boolean mo3739m(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int i13) {
            return super.mo3739m(coordinatorLayout, view, i10, i11, i12, i13);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: w */
        public boolean mo3749w(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z10) {
            AppBarLayout appBarLayoutMo9549H = mo9549H(coordinatorLayout.m3718v(view));
            if (appBarLayoutMo9549H != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f7434d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    appBarLayoutMo9549H.m9490t(false, !z10);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ScrollingViewBehavior_Layout);
            m9592O(typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* renamed from: com.google.android.material.appbar.AppBarLayout$a */
    public class C1638a implements InterfaceC9586b0 {
        public C1638a() {
        }

        @Override // p273f0.InterfaceC9586b0
        public C9625s0 onApplyWindowInsets(View view, C9625s0 c9625s0) {
            return AppBarLayout.this.m9486p(c9625s0);
        }
    }

    /* renamed from: com.google.android.material.appbar.AppBarLayout$b */
    public class C1639b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public final /* synthetic */ C10427h f7385a;

        public C1639b(C10427h c10427h) {
            this.f7385a = c10427h;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f7385a.m64001a0(fFloatValue);
            if (AppBarLayout.this.f7356r instanceof C10427h) {
                ((C10427h) AppBarLayout.this.f7356r).m64001a0(fFloatValue);
            }
            Iterator it = AppBarLayout.this.f7354p.iterator();
            while (it.hasNext()) {
                ((InterfaceC1643f) it.next()).m9558a(fFloatValue, this.f7385a.m63976A());
            }
        }
    }

    /* renamed from: com.google.android.material.appbar.AppBarLayout$c */
    public interface InterfaceC1640c<T extends AppBarLayout> {
        /* renamed from: a */
        void mo9555a(T t10, int i10);
    }

    /* renamed from: com.google.android.material.appbar.AppBarLayout$d */
    public static abstract class AbstractC1641d {
        /* renamed from: a */
        public abstract void mo9556a(AppBarLayout appBarLayout, View view, float f10);
    }

    /* renamed from: com.google.android.material.appbar.AppBarLayout$e */
    public static class C1642e extends AbstractC1641d {

        /* renamed from: a */
        public final Rect f7387a = new Rect();

        /* renamed from: b */
        public final Rect f7388b = new Rect();

        /* renamed from: b */
        public static void m9557b(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.AbstractC1641d
        /* renamed from: a */
        public void mo9556a(AppBarLayout appBarLayout, View view, float f10) {
            m9557b(this.f7387a, appBarLayout, view);
            float fAbs = this.f7387a.top - Math.abs(f10);
            if (fAbs > 0.0f) {
                C9603h0.m59916w0(view, null);
                view.setTranslationY(0.0f);
                return;
            }
            float fM84262a = 1.0f - C14059a.m84262a(Math.abs(fAbs / this.f7387a.height()), 0.0f, 1.0f);
            float fHeight = (-fAbs) - ((this.f7387a.height() * 0.3f) * (1.0f - (fM84262a * fM84262a)));
            view.setTranslationY(fHeight);
            view.getDrawingRect(this.f7388b);
            this.f7388b.offset(0, (int) (-fHeight));
            C9603h0.m59916w0(view, this.f7388b);
        }
    }

    /* renamed from: com.google.android.material.appbar.AppBarLayout$f */
    public interface InterfaceC1643f {
        /* renamed from: a */
        void m9558a(float f10, int i10);
    }

    /* renamed from: com.google.android.material.appbar.AppBarLayout$g */
    public interface InterfaceC1644g extends InterfaceC1640c<AppBarLayout> {
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    /* renamed from: A */
    public final boolean m9470A() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return (childAt.getVisibility() == 8 || C9603h0.m59917x(childAt)) ? false : true;
    }

    /* renamed from: B */
    public final void m9471B(C10427h c10427h, boolean z10) throws Resources.NotFoundException {
        float dimension = getResources().getDimension(R$dimen.design_appbar_elevation);
        float f10 = z10 ? 0.0f : dimension;
        if (!z10) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.f7353o;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f10, dimension);
        this.f7353o = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(getResources().getInteger(R$integer.app_bar_elevation_anim_duration));
        this.f7353o.setInterpolator(C13110a.f59597a);
        this.f7353o.addUpdateListener(new C1639b(c10427h));
        this.f7353o.start();
    }

    /* renamed from: C */
    public final void m9472C() {
        setWillNotDraw(!m9495y());
    }

    /* renamed from: c */
    public void m9473c(InterfaceC1640c interfaceC1640c) {
        if (this.f7346h == null) {
            this.f7346h = new ArrayList();
        }
        if (interfaceC1640c == null || this.f7346h.contains(interfaceC1640c)) {
            return;
        }
        this.f7346h.add(interfaceC1640c);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* renamed from: d */
    public void m9474d(InterfaceC1644g interfaceC1644g) {
        m9473c(interfaceC1644g);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (m9495y()) {
            int iSave = canvas.save();
            canvas.translate(0.0f, -this.f7339a);
            this.f7356r.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f7356r;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    /* renamed from: e */
    public final void m9475e() {
        WeakReference<View> weakReference = this.f7352n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f7352n = null;
    }

    /* renamed from: f */
    public final View m9476f(View view) {
        int i10;
        if (this.f7352n == null && (i10 = this.f7351m) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i10) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.f7351m);
            }
            if (viewFindViewById != null) {
                this.f7352n = new WeakReference<>(viewFindViewById);
            }
        }
        WeakReference<View> weakReference = this.f7352n;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: g */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.InterfaceC0591b
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.f7357s = behavior;
        return behavior;
    }

    public int getDownNestedPreScrollRange() {
        int iMin;
        int iM59834B;
        int i10 = this.f7341c;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i12 = layoutParams.f7381a;
            if ((i12 & 5) != 5) {
                if (i11 > 0) {
                    break;
                }
            } else {
                int i13 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if ((i12 & 8) != 0) {
                    iM59834B = C9603h0.m59834B(childAt);
                } else if ((i12 & 2) != 0) {
                    iM59834B = measuredHeight - C9603h0.m59834B(childAt);
                } else {
                    iMin = i13 + measuredHeight;
                    if (childCount == 0 && C9603h0.m59917x(childAt)) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i11 += iMin;
                }
                iMin = i13 + iM59834B;
                if (childCount == 0) {
                    iMin = Math.min(iMin, measuredHeight - getTopInset());
                }
                i11 += iMin;
            }
        }
        int iMax = Math.max(0, i11);
        this.f7341c = iMax;
        return iMax;
    }

    public int getDownNestedScrollRange() {
        int i10 = this.f7342d;
        if (i10 != -1) {
            return i10;
        }
        int childCount = getChildCount();
        int i11 = 0;
        int iM59834B = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            int i12 = layoutParams.f7381a;
            if ((i12 & 1) == 0) {
                break;
            }
            iM59834B += measuredHeight;
            if ((i12 & 2) != 0) {
                iM59834B -= C9603h0.m59834B(childAt);
                break;
            }
            i11++;
        }
        int iMax = Math.max(0, iM59834B);
        this.f7342d = iMax;
        return iMax;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f7351m;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int iM59834B = C9603h0.m59834B(this);
        if (iM59834B == 0) {
            int childCount = getChildCount();
            iM59834B = childCount >= 1 ? C9603h0.m59834B(getChildAt(childCount - 1)) : 0;
            if (iM59834B == 0) {
                return getHeight() / 3;
            }
        }
        return (iM59834B * 2) + topInset;
    }

    public int getPendingAction() {
        return this.f7344f;
    }

    public Drawable getStatusBarForeground() {
        return this.f7356r;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        C9625s0 c9625s0 = this.f7345g;
        if (c9625s0 != null) {
            return c9625s0.m60160l();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i10 = this.f7340b;
        if (i10 != -1) {
            return i10;
        }
        int childCount = getChildCount();
        int i11 = 0;
        int iM59834B = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i12 = layoutParams.f7381a;
            if ((i12 & 1) == 0) {
                break;
            }
            iM59834B += measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            if (i11 == 0 && C9603h0.m59917x(childAt)) {
                iM59834B -= getTopInset();
            }
            if ((i12 & 2) != 0) {
                iM59834B -= C9603h0.m59834B(childAt);
                break;
            }
            i11++;
        }
        int iMax = Math.max(0, iM59834B);
        this.f7340b = iMax;
        return iMax;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: h */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: i */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LinearLayout.LayoutParams ? new LayoutParams((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* renamed from: j */
    public boolean m9480j() {
        return this.f7343e;
    }

    /* renamed from: k */
    public final boolean m9481k() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (((LayoutParams) getChildAt(i10).getLayoutParams()).m9546e()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: l */
    public boolean m9482l() {
        return getTotalScrollRange() != 0;
    }

    /* renamed from: m */
    public final void m9483m() {
        Behavior behavior = this.f7357s;
        BaseBehavior.SavedState savedStateM9531t0 = (behavior == null || this.f7340b == -1 || this.f7344f != 0) ? null : behavior.m9531t0(AbsSavedState.EMPTY_STATE, this);
        this.f7340b = -1;
        this.f7341c = -1;
        this.f7342d = -1;
        if (savedStateM9531t0 != null) {
            this.f7357s.m9530s0(savedStateM9531t0, false);
        }
    }

    /* renamed from: n */
    public boolean m9484n() {
        return this.f7350l;
    }

    /* renamed from: o */
    public void m9485o(int i10) {
        this.f7339a = i10;
        if (!willNotDraw()) {
            C9603h0.m59884g0(this);
        }
        List<InterfaceC1640c> list = this.f7346h;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                InterfaceC1640c interfaceC1640c = this.f7346h.get(i11);
                if (interfaceC1640c != null) {
                    interfaceC1640c.mo9555a(this, i10);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C10428i.m64043e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i10) {
        if (this.f7355q == null) {
            this.f7355q = new int[4];
        }
        int[] iArr = this.f7355q;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + iArr.length);
        boolean z10 = this.f7348j;
        int i11 = R$attr.state_liftable;
        if (!z10) {
            i11 = -i11;
        }
        iArr[0] = i11;
        iArr[1] = (z10 && this.f7349k) ? R$attr.state_lifted : -R$attr.state_lifted;
        int i12 = R$attr.state_collapsible;
        if (!z10) {
            i12 = -i12;
        }
        iArr[2] = i12;
        iArr[3] = (z10 && this.f7349k) ? R$attr.state_collapsed : -R$attr.state_collapsed;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m9475e();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        boolean z11 = true;
        if (C9603h0.m59917x(this) && m9470A()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                C9603h0.m59872a0(getChildAt(childCount), topInset);
            }
        }
        m9483m();
        this.f7343e = false;
        int childCount2 = getChildCount();
        int i14 = 0;
        while (true) {
            if (i14 >= childCount2) {
                break;
            }
            if (((LayoutParams) getChildAt(i14).getLayoutParams()).m9545d() != null) {
                this.f7343e = true;
                break;
            }
            i14++;
        }
        Drawable drawable = this.f7356r;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.f7347i) {
            return;
        }
        if (!this.f7350l && !m9481k()) {
            z11 = false;
        }
        m9492v(z11);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        if (mode != 1073741824 && C9603h0.m59917x(this) && m9470A()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = C14059a.m84263b(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i11));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        m9483m();
    }

    /* renamed from: p */
    public C9625s0 m9486p(C9625s0 c9625s0) {
        C9625s0 c9625s02 = C9603h0.m59917x(this) ? c9625s0 : null;
        if (!C9368c.m58729a(this.f7345g, c9625s02)) {
            this.f7345g = c9625s02;
            m9472C();
            requestLayout();
        }
        return c9625s0;
    }

    /* renamed from: q */
    public void m9487q(InterfaceC1640c interfaceC1640c) {
        List<InterfaceC1640c> list = this.f7346h;
        if (list == null || interfaceC1640c == null) {
            return;
        }
        list.remove(interfaceC1640c);
    }

    /* renamed from: r */
    public void m9488r(InterfaceC1644g interfaceC1644g) {
        m9487q(interfaceC1644g);
    }

    /* renamed from: s */
    public void m9489s() {
        this.f7344f = 0;
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        C10428i.m64042d(this, f10);
    }

    public void setExpanded(boolean z10) {
        m9490t(z10, C9603h0.m59864T(this));
    }

    public void setLiftOnScroll(boolean z10) {
        this.f7350l = z10;
    }

    public void setLiftOnScrollTargetViewId(int i10) {
        this.f7351m = i10;
        m9475e();
    }

    public void setLiftableOverrideEnabled(boolean z10) {
        this.f7347i = z10;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i10) {
        if (i10 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i10);
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.f7356r;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f7356r = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f7356r.setState(getDrawableState());
                }
                C13669a.m82226g(this.f7356r, C9603h0.m59832A(this));
                this.f7356r.setVisible(getVisibility() == 0, false);
                this.f7356r.setCallback(this);
            }
            m9472C();
            C9603h0.m59884g0(this);
        }
    }

    public void setStatusBarForegroundColor(int i10) {
        setStatusBarForeground(new ColorDrawable(i10));
    }

    public void setStatusBarForegroundResource(int i10) {
        setStatusBarForeground(C8968a.m56743b(getContext(), i10));
    }

    @Deprecated
    public void setTargetElevation(float f10) throws Resources.NotFoundException {
        C1650b.m9607b(this, f10);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f7356r;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
    }

    /* renamed from: t */
    public void m9490t(boolean z10, boolean z11) {
        m9491u(z10, z11, true);
    }

    /* renamed from: u */
    public final void m9491u(boolean z10, boolean z11, boolean z12) {
        this.f7344f = (z10 ? 1 : 2) | (z11 ? 4 : 0) | (z12 ? 8 : 0);
        requestLayout();
    }

    /* renamed from: v */
    public final boolean m9492v(boolean z10) {
        if (this.f7348j == z10) {
            return false;
        }
        this.f7348j = z10;
        refreshDrawableState();
        return true;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f7356r;
    }

    /* renamed from: w */
    public boolean m9493w(boolean z10) {
        return m9494x(z10, !this.f7347i);
    }

    /* renamed from: x */
    public boolean m9494x(boolean z10, boolean z11) throws Resources.NotFoundException {
        if (!z11 || this.f7349k == z10) {
            return false;
        }
        this.f7349k = z10;
        refreshDrawableState();
        if (!this.f7350l || !(getBackground() instanceof C10427h)) {
            return true;
        }
        m9471B((C10427h) getBackground(), z10);
        return true;
    }

    /* renamed from: y */
    public final boolean m9495y() {
        return this.f7356r != null && getTopInset() > 0;
    }

    /* renamed from: z */
    public boolean m9496z(View view) {
        View viewM9476f = m9476f(view);
        if (viewM9476f != null) {
            view = viewM9476f;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.appBarLayoutStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AppBarLayout(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        int i11 = f7338t;
        super(C10981a.m66348c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f7340b = -1;
        this.f7341c = -1;
        this.f7342d = -1;
        this.f7344f = 0;
        this.f7354p = new ArrayList();
        Context context2 = getContext();
        setOrientation(1);
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            C1650b.m9606a(this);
        }
        C1650b.m9608c(this, attributeSet, i10, i11);
        TypedArray typedArrayM10770h = C1784o.m10770h(context2, attributeSet, R$styleable.AppBarLayout, i10, i11, new int[0]);
        C9603h0.m59910t0(this, typedArrayM10770h.getDrawable(R$styleable.AppBarLayout_android_background));
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            C10427h c10427h = new C10427h();
            c10427h.m64002b0(ColorStateList.valueOf(colorDrawable.getColor()));
            c10427h.m63992Q(context2);
            C9603h0.m59910t0(this, c10427h);
        }
        int i12 = R$styleable.AppBarLayout_expanded;
        if (typedArrayM10770h.hasValue(i12)) {
            m9491u(typedArrayM10770h.getBoolean(i12, false), false, false);
        }
        if (typedArrayM10770h.hasValue(R$styleable.AppBarLayout_elevation)) {
            C1650b.m9607b(this, typedArrayM10770h.getDimensionPixelSize(r11, 0));
        }
        int i13 = R$styleable.AppBarLayout_android_keyboardNavigationCluster;
        if (typedArrayM10770h.hasValue(i13)) {
            setKeyboardNavigationCluster(typedArrayM10770h.getBoolean(i13, false));
        }
        int i14 = R$styleable.AppBarLayout_android_touchscreenBlocksFocus;
        if (typedArrayM10770h.hasValue(i14)) {
            setTouchscreenBlocksFocus(typedArrayM10770h.getBoolean(i14, false));
        }
        this.f7350l = typedArrayM10770h.getBoolean(R$styleable.AppBarLayout_liftOnScroll, false);
        this.f7351m = typedArrayM10770h.getResourceId(R$styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
        setStatusBarForeground(typedArrayM10770h.getDrawable(R$styleable.AppBarLayout_statusBarForeground));
        typedArrayM10770h.recycle();
        C9603h0.m59837C0(this, new C1638a());
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* renamed from: a */
        public int f7381a;

        /* renamed from: b */
        public AbstractC1641d f7382b;

        /* renamed from: c */
        public Interpolator f7383c;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f7381a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AppBarLayout_Layout);
            this.f7381a = typedArrayObtainStyledAttributes.getInt(R$styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            m9547f(m9542a(typedArrayObtainStyledAttributes.getInt(R$styleable.AppBarLayout_Layout_layout_scrollEffect, 0)));
            int i10 = R$styleable.AppBarLayout_Layout_layout_scrollInterpolator;
            if (typedArrayObtainStyledAttributes.hasValue(i10)) {
                this.f7383c = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(i10, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        /* renamed from: a */
        public final AbstractC1641d m9542a(int i10) {
            if (i10 != 1) {
                return null;
            }
            return new C1642e();
        }

        /* renamed from: b */
        public AbstractC1641d m9543b() {
            return this.f7382b;
        }

        /* renamed from: c */
        public int m9544c() {
            return this.f7381a;
        }

        /* renamed from: d */
        public Interpolator m9545d() {
            return this.f7383c;
        }

        /* renamed from: e */
        public boolean m9546e() {
            int i10 = this.f7381a;
            return (i10 & 1) == 1 && (i10 & 10) != 0;
        }

        /* renamed from: f */
        public void m9547f(AbstractC1641d abstractC1641d) {
            this.f7382b = abstractC1641d;
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.f7381a = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f7381a = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f7381a = 1;
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f7381a = 1;
        }
    }
}
