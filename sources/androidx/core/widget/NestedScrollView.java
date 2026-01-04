package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.R$attr;
import com.huawei.hms.network.embedded.C6051p9;
import com.huawei.uikit.hwrecyclerview.widget.HwItemTouchHelperEx;
import com.tencent.p204mm.opensdk.modelmsg.WXMediaMessage;
import p273f0.C9582a;
import p273f0.C9583a0;
import p273f0.C9603h0;
import p273f0.C9630v;
import p273f0.C9634x;
import p273f0.InterfaceC9632w;
import p273f0.InterfaceC9638z;
import p304g0.C9832l;
import p304g0.C9834n;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements InterfaceC9638z, InterfaceC9632w {

    /* renamed from: B */
    public static final float f3454B = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* renamed from: C */
    public static final C0657a f3455C = new C0657a();

    /* renamed from: D */
    public static final int[] f3456D = {R.attr.fillViewport};

    /* renamed from: A */
    public InterfaceC0659c f3457A;

    /* renamed from: a */
    public final float f3458a;

    /* renamed from: b */
    public long f3459b;

    /* renamed from: c */
    public final Rect f3460c;

    /* renamed from: d */
    public OverScroller f3461d;

    /* renamed from: e */
    public EdgeEffect f3462e;

    /* renamed from: f */
    public EdgeEffect f3463f;

    /* renamed from: g */
    public int f3464g;

    /* renamed from: h */
    public boolean f3465h;

    /* renamed from: i */
    public boolean f3466i;

    /* renamed from: j */
    public View f3467j;

    /* renamed from: k */
    public boolean f3468k;

    /* renamed from: l */
    public VelocityTracker f3469l;

    /* renamed from: m */
    public boolean f3470m;

    /* renamed from: n */
    public boolean f3471n;

    /* renamed from: o */
    public int f3472o;

    /* renamed from: p */
    public int f3473p;

    /* renamed from: q */
    public int f3474q;

    /* renamed from: r */
    public int f3475r;

    /* renamed from: s */
    public final int[] f3476s;

    /* renamed from: t */
    public final int[] f3477t;

    /* renamed from: u */
    public int f3478u;

    /* renamed from: v */
    public int f3479v;

    /* renamed from: w */
    public SavedState f3480w;

    /* renamed from: x */
    public final C9583a0 f3481x;

    /* renamed from: y */
    public final C9634x f3482y;

    /* renamed from: z */
    public float f3483z;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0656a();

        /* renamed from: a */
        public int f3484a;

        /* renamed from: androidx.core.widget.NestedScrollView$SavedState$a */
        public class C0656a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f3484a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f3484a);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f3484a = parcel.readInt();
        }
    }

    /* renamed from: androidx.core.widget.NestedScrollView$a */
    public static class C0657a extends C9582a {
        @Override // p273f0.C9582a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            C9834n.m61135a(accessibilityEvent, nestedScrollView.getScrollX());
            C9834n.m61136b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // p273f0.C9582a
        public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, c9832l);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            c9832l.m61065U(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            c9832l.m61102q0(true);
            if (nestedScrollView.getScrollY() > 0) {
                c9832l.m61073b(C9832l.a.f48308r);
                c9832l.m61073b(C9832l.a.f48276C);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                c9832l.m61073b(C9832l.a.f48307q);
                c9832l.m61073b(C9832l.a.f48278E);
            }
        }

        @Override // p273f0.C9582a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (super.performAccessibilityAction(view, i10, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i10 != 4096) {
                if (i10 == 8192 || i10 == 16908344) {
                    int iMax = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (iMax == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m3972T(0, iMax, true);
                    return true;
                }
                if (i10 != 16908346) {
                    return false;
                }
            }
            int iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (iMin == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.m3972T(0, iMin, true);
            return true;
        }
    }

    /* renamed from: androidx.core.widget.NestedScrollView$b */
    public static class C0658b {
        /* renamed from: a */
        public static boolean m3997a(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    /* renamed from: androidx.core.widget.NestedScrollView$c */
    public interface InterfaceC0659c {
        /* renamed from: a */
        void mo3496a(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13);
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    /* renamed from: A */
    private void m3952A() {
        this.f3461d = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(C6051p9.f27764p);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f3472o = viewConfiguration.getScaledTouchSlop();
        this.f3473p = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3474q = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    /* renamed from: D */
    public static boolean m3953D(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && m3953D((View) parent, view2);
    }

    /* renamed from: e */
    public static int m3954e(int i10, int i11, int i12) {
        if (i11 >= i12 || i10 < 0) {
            return 0;
        }
        return i11 + i10 > i12 ? i12 - i11 : i10;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f3483z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f3483z = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f3483z;
    }

    /* renamed from: B */
    public final void m3955B() {
        if (this.f3469l == null) {
            this.f3469l = VelocityTracker.obtain();
        }
    }

    /* renamed from: C */
    public final boolean m3956C(View view) {
        return !m3957E(view, 0, getHeight());
    }

    /* renamed from: E */
    public final boolean m3957E(View view, int i10, int i11) {
        view.getDrawingRect(this.f3460c);
        offsetDescendantRectToMyCoords(view, this.f3460c);
        return this.f3460c.bottom + i10 >= getScrollY() && this.f3460c.top - i10 <= getScrollY() + i11;
    }

    /* renamed from: F */
    public final void m3958F(int i10, int i11, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i10);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f3482y.m60236e(0, scrollY2, 0, i10 - scrollY2, null, i11, iArr);
    }

    /* renamed from: G */
    public final void m3959G(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3475r) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.f3464g = (int) motionEvent.getY(i10);
            this.f3475r = motionEvent.getPointerId(i10);
            VelocityTracker velocityTracker = this.f3469l;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* renamed from: H */
    public boolean m3960H(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z10) {
        boolean z11;
        boolean z12;
        int overScrollMode = getOverScrollMode();
        boolean z13 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z14 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z15 = overScrollMode == 0 || (overScrollMode == 1 && z13);
        boolean z16 = overScrollMode == 0 || (overScrollMode == 1 && z14);
        int i18 = i12 + i10;
        int i19 = !z15 ? 0 : i16;
        int i20 = i13 + i11;
        int i21 = !z16 ? 0 : i17;
        int i22 = -i19;
        int i23 = i19 + i14;
        int i24 = -i21;
        int i25 = i21 + i15;
        if (i18 > i23) {
            i18 = i23;
            z11 = true;
        } else if (i18 < i22) {
            z11 = true;
            i18 = i22;
        } else {
            z11 = false;
        }
        if (i20 > i25) {
            i20 = i25;
            z12 = true;
        } else if (i20 < i24) {
            z12 = true;
            i20 = i24;
        } else {
            z12 = false;
        }
        if (z12 && !m3992x(1)) {
            this.f3461d.springBack(i18, i20, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i18, i20, z11, z12);
        return z11 || z12;
    }

    /* renamed from: I */
    public boolean m3961I(int i10) {
        boolean z10 = i10 == 130;
        int height = getHeight();
        if (z10) {
            this.f3460c.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f3460c;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f3460c.top = getScrollY() - height;
            Rect rect2 = this.f3460c;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f3460c;
        int i11 = rect3.top;
        int i12 = height + i11;
        rect3.bottom = i12;
        return m3965M(i10, i11, i12);
    }

    /* renamed from: J */
    public final void m3962J() {
        VelocityTracker velocityTracker = this.f3469l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f3469l = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0060  */
    /* renamed from: K */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m3963K(int r4, float r5) {
        /*
            r3 = this;
            int r0 = r3.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r4 = (float) r4
            int r0 = r3.getHeight()
            float r0 = (float) r0
            float r4 = r4 / r0
            android.widget.EdgeEffect r0 = r3.f3462e
            float r0 = androidx.core.widget.EdgeEffectCompat.m3945b(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L31
            android.widget.EdgeEffect r0 = r3.f3462e
            float r4 = -r4
            float r4 = androidx.core.widget.EdgeEffectCompat.m3947d(r0, r4, r5)
            float r4 = -r4
            android.widget.EdgeEffect r5 = r3.f3462e
            float r5 = androidx.core.widget.EdgeEffectCompat.m3945b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.f3462e
            r5.onRelease()
        L2f:
            r1 = r4
            goto L54
        L31:
            android.widget.EdgeEffect r0 = r3.f3463f
            float r0 = androidx.core.widget.EdgeEffectCompat.m3945b(r0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L54
            android.widget.EdgeEffect r0 = r3.f3463f
            r2 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 - r5
            float r4 = androidx.core.widget.EdgeEffectCompat.m3947d(r0, r4, r2)
            android.widget.EdgeEffect r5 = r3.f3463f
            float r5 = androidx.core.widget.EdgeEffectCompat.m3945b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.f3463f
            r5.onRelease()
            goto L2f
        L54:
            int r4 = r3.getHeight()
            float r4 = (float) r4
            float r1 = r1 * r4
            int r4 = java.lang.Math.round(r1)
            if (r4 == 0) goto L63
            r3.invalidate()
        L63:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.m3963K(int, float):int");
    }

    /* renamed from: L */
    public final void m3964L(boolean z10) {
        if (z10) {
            m3973U(2, 1);
        } else {
            m3975W(1);
        }
        this.f3479v = getScrollY();
        C9603h0.m59884g0(this);
    }

    /* renamed from: M */
    public final boolean m3965M(int i10, int i11, int i12) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i13 = height + scrollY;
        boolean z10 = false;
        boolean z11 = i10 == 33;
        View viewM3988t = m3988t(z11, i11, i12);
        if (viewM3988t == null) {
            viewM3988t = this;
        }
        if (i11 < scrollY || i12 > i13) {
            m3984p(z11 ? i11 - scrollY : i12 - i13);
            z10 = true;
        }
        if (viewM3988t != findFocus()) {
            viewM3988t.requestFocus(i10);
        }
        return z10;
    }

    /* renamed from: N */
    public final void m3966N(View view) {
        view.getDrawingRect(this.f3460c);
        offsetDescendantRectToMyCoords(view, this.f3460c);
        int iM3980f = m3980f(this.f3460c);
        if (iM3980f != 0) {
            scrollBy(0, iM3980f);
        }
    }

    /* renamed from: O */
    public final boolean m3967O(Rect rect, boolean z10) {
        int iM3980f = m3980f(rect);
        boolean z11 = iM3980f != 0;
        if (z11) {
            if (z10) {
                scrollBy(0, iM3980f);
            } else {
                m3969Q(0, iM3980f);
            }
        }
        return z11;
    }

    /* renamed from: P */
    public final boolean m3968P(EdgeEffect edgeEffect, int i10) {
        if (i10 > 0) {
            return true;
        }
        return m3991w(-i10) < EdgeEffectCompat.m3945b(edgeEffect) * ((float) getHeight());
    }

    /* renamed from: Q */
    public final void m3969Q(int i10, int i11) {
        m3970R(i10, i11, HwItemTouchHelperEx.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, false);
    }

    /* renamed from: R */
    public final void m3970R(int i10, int i11, int i12, boolean z10) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f3459b > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f3461d.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i11 + scrollY, Math.max(0, height - height2))) - scrollY, i12);
            m3964L(z10);
        } else {
            if (!this.f3461d.isFinished()) {
                m3976a();
            }
            scrollBy(i10, i11);
        }
        this.f3459b = AnimationUtils.currentAnimationTimeMillis();
    }

    /* renamed from: S */
    public void m3971S(int i10, int i11, int i12, boolean z10) {
        m3970R(i10 - getScrollX(), i11 - getScrollY(), i12, z10);
    }

    /* renamed from: T */
    public void m3972T(int i10, int i11, boolean z10) {
        m3971S(i10, i11, HwItemTouchHelperEx.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, z10);
    }

    /* renamed from: U */
    public boolean m3973U(int i10, int i11) {
        return this.f3482y.m60248q(i10, i11);
    }

    /* renamed from: V */
    public final boolean m3974V(MotionEvent motionEvent) {
        boolean z10;
        if (EdgeEffectCompat.m3945b(this.f3462e) != 0.0f) {
            EdgeEffectCompat.m3947d(this.f3462e, 0.0f, motionEvent.getX() / getWidth());
            z10 = true;
        } else {
            z10 = false;
        }
        if (EdgeEffectCompat.m3945b(this.f3463f) == 0.0f) {
            return z10;
        }
        EdgeEffectCompat.m3947d(this.f3463f, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    /* renamed from: W */
    public void m3975W(int i10) {
        this.f3482y.m60250s(i10);
    }

    /* renamed from: a */
    public final void m3976a() {
        this.f3461d.abortAnimation();
        m3975W(1);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    /* renamed from: b */
    public boolean m3977b(int i10) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i10);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !m3957E(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i10 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i10 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i10 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m3984p(maxScrollAmount);
        } else {
            viewFindNextFocus.getDrawingRect(this.f3460c);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.f3460c);
            m3984p(m3980f(this.f3460c));
            viewFindNextFocus.requestFocus(i10);
        }
        if (viewFindFocus == null || !viewFindFocus.isFocused() || !m3956C(viewFindFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    /* renamed from: c */
    public final boolean m3978c() {
        int overScrollMode = getOverScrollMode();
        if (overScrollMode != 0) {
            return overScrollMode == 1 && getScrollRange() > 0;
        }
        return true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f3461d.isFinished()) {
            return;
        }
        this.f3461d.computeScrollOffset();
        int currY = this.f3461d.getCurrY();
        int iM3981g = m3981g(currY - this.f3479v);
        this.f3479v = currY;
        int[] iArr = this.f3477t;
        iArr[1] = 0;
        m3982h(0, iM3981g, iArr, null, 1);
        int i10 = iM3981g - this.f3477t[1];
        int scrollRange = getScrollRange();
        if (i10 != 0) {
            int scrollY = getScrollY();
            m3960H(0, i10, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i11 = i10 - scrollY2;
            int[] iArr2 = this.f3477t;
            iArr2[1] = 0;
            m3983i(0, scrollY2, 0, i11, this.f3476s, 1, iArr2);
            i10 = i11 - this.f3477t[1];
        }
        if (i10 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                if (i10 < 0) {
                    if (this.f3462e.isFinished()) {
                        this.f3462e.onAbsorb((int) this.f3461d.getCurrVelocity());
                    }
                } else if (this.f3463f.isFinished()) {
                    this.f3463f.onAbsorb((int) this.f3461d.getCurrVelocity());
                }
            }
            m3976a();
        }
        if (this.f3461d.isFinished()) {
            m3975W(1);
        } else {
            C9603h0.m59884g0(this);
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    /* renamed from: d */
    public final boolean m3979d() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m3987s(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return this.f3482y.m60232a(f10, f11, z10);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.f3482y.m60233b(f10, f11);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return m3982h(i10, i11, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return this.f3482y.m60237f(i10, i11, i12, i13, iArr);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        int scrollY = getScrollY();
        int paddingLeft2 = 0;
        if (!this.f3462e.isFinished()) {
            int iSave = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int iMin = Math.min(0, scrollY);
            if (C0658b.m3997a(this)) {
                width -= getPaddingLeft() + getPaddingRight();
                paddingLeft = getPaddingLeft();
            } else {
                paddingLeft = 0;
            }
            if (C0658b.m3997a(this)) {
                height -= getPaddingTop() + getPaddingBottom();
                iMin += getPaddingTop();
            }
            canvas.translate(paddingLeft, iMin);
            this.f3462e.setSize(width, height);
            if (this.f3462e.draw(canvas)) {
                C9603h0.m59884g0(this);
            }
            canvas.restoreToCount(iSave);
        }
        if (this.f3463f.isFinished()) {
            return;
        }
        int iSave2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int iMax = Math.max(getScrollRange(), scrollY) + height2;
        if (C0658b.m3997a(this)) {
            width2 -= getPaddingLeft() + getPaddingRight();
            paddingLeft2 = getPaddingLeft();
        }
        if (C0658b.m3997a(this)) {
            height2 -= getPaddingTop() + getPaddingBottom();
            iMax -= getPaddingBottom();
        }
        canvas.translate(paddingLeft2 - width2, iMax);
        canvas.rotate(180.0f, width2, 0.0f);
        this.f3463f.setSize(width2, height2);
        if (this.f3463f.draw(canvas)) {
            C9603h0.m59884g0(this);
        }
        canvas.restoreToCount(iSave2);
    }

    /* renamed from: f */
    public int m3980f(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i10 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i11 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i10 - verticalFadingEdgeLength : i10;
        int i12 = rect.bottom;
        if (i12 > i11 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i11, (childAt.getBottom() + layoutParams.bottomMargin) - i10);
        }
        if (rect.top >= scrollY || i12 >= i11) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i11 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    /* renamed from: g */
    public int m3981g(int i10) {
        int height = getHeight();
        if (i10 > 0 && EdgeEffectCompat.m3945b(this.f3462e) != 0.0f) {
            int iRound = Math.round(((-height) / 4.0f) * EdgeEffectCompat.m3947d(this.f3462e, ((-i10) * 4.0f) / height, 0.5f));
            if (iRound != i10) {
                this.f3462e.finish();
            }
            return i10 - iRound;
        }
        if (i10 >= 0 || EdgeEffectCompat.m3945b(this.f3463f) == 0.0f) {
            return i10;
        }
        float f10 = height;
        int iRound2 = Math.round((f10 / 4.0f) * EdgeEffectCompat.m3947d(this.f3463f, (i10 * 4.0f) / f10, 0.5f));
        if (iRound2 != i10) {
            this.f3463f.finish();
        }
        return i10 - iRound2;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f3481x.m59783a();
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    /* renamed from: h */
    public boolean m3982h(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        return this.f3482y.m60235d(i10, i11, iArr, iArr2, i12);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return m3992x(0);
    }

    /* renamed from: i */
    public void m3983i(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        this.f3482y.m60236e(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f3482y.m60244m();
    }

    @Override // p273f0.InterfaceC9638z
    /* renamed from: j */
    public void mo2545j(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        m3958F(i13, i14, iArr);
    }

    @Override // p273f0.InterfaceC9636y
    /* renamed from: k */
    public void mo2546k(View view, int i10, int i11, int i12, int i13, int i14) {
        m3958F(i13, i14, null);
    }

    @Override // p273f0.InterfaceC9636y
    /* renamed from: l */
    public boolean mo2547l(View view, View view2, int i10, int i11) {
        return (i10 & 2) != 0;
    }

    @Override // p273f0.InterfaceC9636y
    /* renamed from: m */
    public void mo2548m(View view, View view2, int i10, int i11) {
        this.f3481x.m59785c(view, view2, i10, i11);
        m3973U(2, i11);
    }

    @Override // android.view.ViewGroup
    public void measureChild(View view, int i10, int i11) {
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // p273f0.InterfaceC9636y
    /* renamed from: n */
    public void mo2549n(View view, int i10) {
        this.f3481x.m59786d(view, i10);
        m3975W(i10);
    }

    @Override // p273f0.InterfaceC9636y
    /* renamed from: o */
    public void mo2550o(View view, int i10, int i11, int[] iArr, int i12) {
        m3982h(i10, i11, iArr, null, i12);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3466i = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        boolean z10;
        int i10 = 0;
        if (motionEvent.getAction() == 8 && !this.f3468k) {
            float axisValue = C9630v.m60229a(motionEvent, 2) ? motionEvent.getAxisValue(9) : C9630v.m60229a(motionEvent, 4194304) ? motionEvent.getAxisValue(26) : 0.0f;
            if (axisValue != 0.0f) {
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i11 = scrollY - verticalScrollFactorCompat;
                if (i11 < 0) {
                    if (!m3978c() || C9630v.m60229a(motionEvent, 8194)) {
                        z10 = 0;
                    } else {
                        EdgeEffectCompat.m3947d(this.f3462e, (-i11) / getHeight(), 0.5f);
                        this.f3462e.onRelease();
                        invalidate();
                        z10 = 1;
                    }
                } else if (i11 > scrollRange) {
                    if (m3978c() && !C9630v.m60229a(motionEvent, 8194)) {
                        EdgeEffectCompat.m3947d(this.f3463f, (i11 - scrollRange) / getHeight(), 0.5f);
                        this.f3463f.onRelease();
                        invalidate();
                        i10 = 1;
                    }
                    z10 = i10;
                    i10 = scrollRange;
                } else {
                    z10 = 0;
                    i10 = i11;
                }
                if (i10 == scrollY) {
                    return z10;
                }
                super.scrollTo(getScrollX(), i10);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x007e  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r12) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        int measuredHeight = 0;
        this.f3465h = false;
        View view = this.f3467j;
        if (view != null && m3953D(view, this)) {
            m3966N(this.f3467j);
        }
        this.f3467j = null;
        if (!this.f3466i) {
            if (this.f3480w != null) {
                scrollTo(getScrollX(), this.f3480w.f3484a);
                this.f3480w = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int iM3954e = m3954e(scrollY, paddingTop, measuredHeight);
            if (iM3954e != scrollY) {
                scrollTo(getScrollX(), iM3954e);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f3466i = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f3470m && View.MeasureSpec.getMode(i11) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        if (z10) {
            return false;
        }
        dispatchNestedFling(0.0f, f11, true);
        m3989u((int) f11);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return dispatchNestedPreFling(f10, f11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        mo2550o(view, i10, i11, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        m3958F(i13, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        mo2548m(view, view2, i10, 0);
    }

    @Override // android.view.View
    public void onOverScrolled(int i10, int i11, boolean z10, boolean z11) {
        super.scrollTo(i10, i11);
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        if (i10 == 2) {
            i10 = 130;
        } else if (i10 == 1) {
            i10 = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i10) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i10);
        if (viewFindNextFocus == null || m3956C(viewFindNextFocus)) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i10, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f3480w = savedState;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3484a = getScrollY();
        return savedState;
    }

    @Override // android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        InterfaceC0659c interfaceC0659c = this.f3457A;
        if (interfaceC0659c != null) {
            interfaceC0659c.mo3496a(this, i10, i11, i12, i13);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !m3957E(viewFindFocus, 0, i13)) {
            return;
        }
        viewFindFocus.getDrawingRect(this.f3460c);
        offsetDescendantRectToMyCoords(viewFindFocus, this.f3460c);
        m3984p(m3980f(this.f3460c));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return mo2547l(view, view2, i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        mo2549n(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:184:0x01d5  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r24) {
        /*
            Method dump skipped, instructions count: 617
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: p */
    public final void m3984p(int i10) {
        if (i10 != 0) {
            if (this.f3471n) {
                m3969Q(0, i10);
            } else {
                scrollBy(0, i10);
            }
        }
    }

    /* renamed from: q */
    public final boolean m3985q(int i10) {
        if (EdgeEffectCompat.m3945b(this.f3462e) != 0.0f) {
            if (m3968P(this.f3462e, i10)) {
                this.f3462e.onAbsorb(i10);
            } else {
                m3989u(-i10);
            }
        } else {
            if (EdgeEffectCompat.m3945b(this.f3463f) == 0.0f) {
                return false;
            }
            int i11 = -i10;
            if (m3968P(this.f3463f, i11)) {
                this.f3463f.onAbsorb(i11);
            } else {
                m3989u(i11);
            }
        }
        return true;
    }

    /* renamed from: r */
    public final void m3986r() {
        this.f3468k = false;
        m3962J();
        m3975W(0);
        this.f3462e.onRelease();
        this.f3463f.onRelease();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f3465h) {
            this.f3467j = view2;
        } else {
            m3966N(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m3967O(rect, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        if (z10) {
            m3962J();
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f3465h = true;
        super.requestLayout();
    }

    /* renamed from: s */
    public boolean m3987s(KeyEvent keyEvent) {
        this.f3460c.setEmpty();
        if (!m3979d()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View viewFindFocus = findFocus();
            if (viewFindFocus == this) {
                viewFindFocus = null;
            }
            View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
            return (viewFindNextFocus == null || viewFindNextFocus == this || !viewFindNextFocus.requestFocus(130)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19) {
            return !keyEvent.isAltPressed() ? m3977b(33) : m3990v(33);
        }
        if (keyCode == 20) {
            return !keyEvent.isAltPressed() ? m3977b(130) : m3990v(130);
        }
        if (keyCode != 62) {
            return false;
        }
        m3961I(keyEvent.isShiftPressed() ? 33 : 130);
        return false;
    }

    @Override // android.view.View
    public void scrollTo(int i10, int i11) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int iM3954e = m3954e(i10, width, width2);
            int iM3954e2 = m3954e(i11, height, height2);
            if (iM3954e == getScrollX() && iM3954e2 == getScrollY()) {
                return;
            }
            super.scrollTo(iM3954e, iM3954e2);
        }
    }

    public void setFillViewport(boolean z10) {
        if (z10 != this.f3470m) {
            this.f3470m = z10;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z10) {
        this.f3482y.m60245n(z10);
    }

    public void setOnScrollChangeListener(InterfaceC0659c interfaceC0659c) {
        this.f3457A = interfaceC0659c;
    }

    public void setSmoothScrollingEnabled(boolean z10) {
        this.f3471n = z10;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i10) {
        return m3973U(i10, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        m3975W(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x004f  */
    /* renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View m3988t(boolean r12, int r13, int r14) {
        /*
            r11 = this;
            r0 = 2
            java.util.ArrayList r11 = r11.getFocusables(r0)
            int r0 = r11.size()
            r1 = 0
            r2 = 0
            r3 = r2
            r4 = r3
        Ld:
            if (r3 >= r0) goto L53
            java.lang.Object r5 = r11.get(r3)
            android.view.View r5 = (android.view.View) r5
            int r6 = r5.getTop()
            int r7 = r5.getBottom()
            if (r13 >= r7) goto L50
            if (r6 >= r14) goto L50
            r8 = 1
            if (r13 >= r6) goto L28
            if (r7 >= r14) goto L28
            r9 = r8
            goto L29
        L28:
            r9 = r2
        L29:
            if (r1 != 0) goto L2e
            r1 = r5
            r4 = r9
            goto L50
        L2e:
            if (r12 == 0) goto L36
            int r10 = r1.getTop()
            if (r6 < r10) goto L3e
        L36:
            if (r12 != 0) goto L40
            int r6 = r1.getBottom()
            if (r7 <= r6) goto L40
        L3e:
            r6 = r8
            goto L41
        L40:
            r6 = r2
        L41:
            if (r4 == 0) goto L48
            if (r9 == 0) goto L50
            if (r6 == 0) goto L50
            goto L4f
        L48:
            if (r9 == 0) goto L4d
            r1 = r5
            r4 = r8
            goto L50
        L4d:
            if (r6 == 0) goto L50
        L4f:
            r1 = r5
        L50:
            int r3 = r3 + 1
            goto Ld
        L53:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.m3988t(boolean, int, int):android.view.View");
    }

    /* renamed from: u */
    public void m3989u(int i10) {
        if (getChildCount() > 0) {
            this.f3461d.fling(getScrollX(), getScrollY(), 0, i10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            m3964L(true);
        }
    }

    /* renamed from: v */
    public boolean m3990v(int i10) {
        int childCount;
        boolean z10 = i10 == 130;
        int height = getHeight();
        Rect rect = this.f3460c;
        rect.top = 0;
        rect.bottom = height;
        if (z10 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f3460c.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f3460c;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f3460c;
        return m3965M(i10, rect3.top, rect3.bottom);
    }

    /* renamed from: w */
    public final float m3991w(int i10) {
        double dLog = Math.log((Math.abs(i10) * 0.35f) / (this.f3458a * 0.015f));
        float f10 = f3454B;
        return (float) (this.f3458a * 0.015f * Math.exp((f10 / (f10 - 1.0d)) * dLog));
    }

    /* renamed from: x */
    public boolean m3992x(int i10) {
        return this.f3482y.m60243l(i10);
    }

    /* renamed from: y */
    public final boolean m3993y(int i10, int i11) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i11 >= childAt.getTop() - scrollY && i11 < childAt.getBottom() - scrollY && i10 >= childAt.getLeft() && i10 < childAt.getRight();
    }

    /* renamed from: z */
    public final void m3994z() {
        VelocityTracker velocityTracker = this.f3469l;
        if (velocityTracker == null) {
            this.f3469l = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.nestedScrollViewStyle);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3460c = new Rect();
        this.f3465h = true;
        this.f3466i = false;
        this.f3467j = null;
        this.f3468k = false;
        this.f3471n = true;
        this.f3475r = -1;
        this.f3476s = new int[2];
        this.f3477t = new int[2];
        this.f3462e = EdgeEffectCompat.m3944a(context, attributeSet);
        this.f3463f = EdgeEffectCompat.m3944a(context, attributeSet);
        this.f3458a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        m3952A();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3456D, i10, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f3481x = new C9583a0(this);
        this.f3482y = new C9634x(this);
        setNestedScrollingEnabled(true);
        C9603h0.m59902p0(this, f3455C);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10) {
        if (getChildCount() <= 0) {
            super.addView(view, i10);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i10, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
