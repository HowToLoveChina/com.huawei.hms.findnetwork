package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.view.menu.InterfaceC0414k;
import p273f0.C9583a0;
import p273f0.C9603h0;
import p273f0.C9625s0;
import p273f0.InterfaceC9636y;
import p273f0.InterfaceC9638z;
import p723w.C13504c;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements InterfaceC0542q, InterfaceC9636y, InterfaceC9638z {

    /* renamed from: F */
    public static final int[] f1765F = {R$attr.actionBarSize, R.attr.windowContentOverlay};

    /* renamed from: A */
    public ViewPropertyAnimator f1766A;

    /* renamed from: B */
    public final AnimatorListenerAdapter f1767B;

    /* renamed from: C */
    public final Runnable f1768C;

    /* renamed from: D */
    public final Runnable f1769D;

    /* renamed from: E */
    public final C9583a0 f1770E;

    /* renamed from: a */
    public int f1771a;

    /* renamed from: b */
    public int f1772b;

    /* renamed from: c */
    public ContentFrameLayout f1773c;

    /* renamed from: d */
    public ActionBarContainer f1774d;

    /* renamed from: e */
    public InterfaceC0543r f1775e;

    /* renamed from: f */
    public Drawable f1776f;

    /* renamed from: g */
    public boolean f1777g;

    /* renamed from: h */
    public boolean f1778h;

    /* renamed from: i */
    public boolean f1779i;

    /* renamed from: j */
    public boolean f1780j;

    /* renamed from: k */
    public boolean f1781k;

    /* renamed from: l */
    public int f1782l;

    /* renamed from: m */
    public int f1783m;

    /* renamed from: n */
    public final Rect f1784n;

    /* renamed from: o */
    public final Rect f1785o;

    /* renamed from: p */
    public final Rect f1786p;

    /* renamed from: q */
    public final Rect f1787q;

    /* renamed from: r */
    public final Rect f1788r;

    /* renamed from: s */
    public final Rect f1789s;

    /* renamed from: t */
    public final Rect f1790t;

    /* renamed from: u */
    public C9625s0 f1791u;

    /* renamed from: v */
    public C9625s0 f1792v;

    /* renamed from: w */
    public C9625s0 f1793w;

    /* renamed from: x */
    public C9625s0 f1794x;

    /* renamed from: y */
    public InterfaceC0427d f1795y;

    /* renamed from: z */
    public OverScroller f1796z;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$a */
    public class C0424a extends AnimatorListenerAdapter {
        public C0424a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1766A = null;
            actionBarOverlayLayout.f1781k = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1766A = null;
            actionBarOverlayLayout.f1781k = false;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$b */
    public class RunnableC0425b implements Runnable {
        public RunnableC0425b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.m2556u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1766A = actionBarOverlayLayout.f1774d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f1767B);
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$c */
    public class RunnableC0426c implements Runnable {
        public RunnableC0426c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.m2556u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1766A = actionBarOverlayLayout.f1774d.animate().translationY(-ActionBarOverlayLayout.this.f1774d.getHeight()).setListener(ActionBarOverlayLayout.this.f1767B);
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionBarOverlayLayout$d */
    public interface InterfaceC0427d {
        /* renamed from: a */
        void mo2274a();

        /* renamed from: b */
        void mo2275b();

        /* renamed from: c */
        void mo2276c(boolean z10);

        /* renamed from: d */
        void mo2277d();

        /* renamed from: e */
        void mo2278e();

        /* renamed from: f */
        void mo2279f(int i10);
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    /* renamed from: v */
    private void m2533v(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1765F);
        this.f1771a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f1776f = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f1777g = context.getApplicationInfo().targetSdkVersion < 19;
        this.f1796z = new OverScroller(context);
    }

    /* renamed from: A */
    public final void m2534A() {
        m2556u();
        this.f1768C.run();
    }

    /* renamed from: B */
    public final boolean m2535B(float f10) {
        this.f1796z.fling(0, 0, 0, (int) f10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f1796z.getFinalY() > this.f1774d.getHeight();
    }

    @Override // androidx.appcompat.widget.InterfaceC0542q
    /* renamed from: a */
    public void mo2536a(Menu menu, InterfaceC0414k.a aVar) {
        m2560z();
        this.f1775e.mo3006a(menu, aVar);
    }

    @Override // androidx.appcompat.widget.InterfaceC0542q
    /* renamed from: b */
    public boolean mo2537b() {
        m2560z();
        return this.f1775e.mo3007b();
    }

    @Override // androidx.appcompat.widget.InterfaceC0542q
    /* renamed from: c */
    public void mo2538c() {
        m2560z();
        this.f1775e.mo3008c();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.appcompat.widget.InterfaceC0542q
    /* renamed from: d */
    public boolean mo2539d() {
        m2560z();
        return this.f1775e.mo3009d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1776f == null || this.f1777g) {
            return;
        }
        int bottom = this.f1774d.getVisibility() == 0 ? (int) (this.f1774d.getBottom() + this.f1774d.getTranslationY() + 0.5f) : 0;
        this.f1776f.setBounds(0, bottom, getWidth(), this.f1776f.getIntrinsicHeight() + bottom);
        this.f1776f.draw(canvas);
    }

    @Override // androidx.appcompat.widget.InterfaceC0542q
    /* renamed from: e */
    public boolean mo2540e() {
        m2560z();
        return this.f1775e.mo3010e();
    }

    @Override // androidx.appcompat.widget.InterfaceC0542q
    /* renamed from: f */
    public boolean mo2541f() {
        m2560z();
        return this.f1775e.mo3011f();
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.InterfaceC0542q
    /* renamed from: g */
    public boolean mo2542g() {
        m2560z();
        return this.f1775e.mo3012g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f1774d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f1770E.m59783a();
    }

    public CharSequence getTitle() {
        m2560z();
        return this.f1775e.getTitle();
    }

    @Override // androidx.appcompat.widget.InterfaceC0542q
    /* renamed from: h */
    public void mo2543h(int i10) {
        m2560z();
        if (i10 == 2) {
            this.f1775e.mo3022q();
        } else if (i10 == 5) {
            this.f1775e.mo3023r();
        } else {
            if (i10 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // androidx.appcompat.widget.InterfaceC0542q
    /* renamed from: i */
    public void mo2544i() {
        m2560z();
        this.f1775e.mo3013h();
    }

    @Override // p273f0.InterfaceC9638z
    /* renamed from: j */
    public void mo2545j(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        mo2546k(view, i10, i11, i12, i13, i14);
    }

    @Override // p273f0.InterfaceC9636y
    /* renamed from: k */
    public void mo2546k(View view, int i10, int i11, int i12, int i13, int i14) {
        if (i14 == 0) {
            onNestedScroll(view, i10, i11, i12, i13);
        }
    }

    @Override // p273f0.InterfaceC9636y
    /* renamed from: l */
    public boolean mo2547l(View view, View view2, int i10, int i11) {
        return i11 == 0 && onStartNestedScroll(view, view2, i10);
    }

    @Override // p273f0.InterfaceC9636y
    /* renamed from: m */
    public void mo2548m(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            onNestedScrollAccepted(view, view2, i10);
        }
    }

    @Override // p273f0.InterfaceC9636y
    /* renamed from: n */
    public void mo2549n(View view, int i10) {
        if (i10 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // p273f0.InterfaceC9636y
    /* renamed from: o */
    public void mo2550o(View view, int i10, int i11, int[] iArr, int i12) {
        if (i12 == 0) {
            onNestedPreScroll(view, i10, i11, iArr);
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        m2560z();
        C9625s0 c9625s0M60148w = C9625s0.m60148w(windowInsets, this);
        boolean zM2552q = m2552q(this.f1774d, new Rect(c9625s0M60148w.m60158j(), c9625s0M60148w.m60160l(), c9625s0M60148w.m60159k(), c9625s0M60148w.m60157i()), true, true, false, true);
        C9603h0.m59883g(this, c9625s0M60148w, this.f1784n);
        Rect rect = this.f1784n;
        C9625s0 c9625s0M60162n = c9625s0M60148w.m60162n(rect.left, rect.top, rect.right, rect.bottom);
        this.f1791u = c9625s0M60162n;
        if (!this.f1792v.equals(c9625s0M60162n)) {
            this.f1792v = this.f1791u;
            zM2552q = true;
        }
        if (this.f1785o.equals(this.f1784n)) {
            if (zM2552q) {
            }
            return c9625s0M60148w.m60149a().m60151c().m60150b().m60168u();
        }
        this.f1785o.set(this.f1784n);
        requestLayout();
        return c9625s0M60148w.m60149a().m60151c().m60150b().m60168u();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m2533v(getContext());
        C9603h0.m59896m0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m2556u();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i15 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                int i16 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                childAt.layout(i15, i16, measuredWidth + i15, measuredHeight + i16);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int measuredHeight;
        m2560z();
        measureChildWithMargins(this.f1774d, i10, 0, i11, 0);
        LayoutParams layoutParams = (LayoutParams) this.f1774d.getLayoutParams();
        int iMax = Math.max(0, this.f1774d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
        int iMax2 = Math.max(0, this.f1774d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f1774d.getMeasuredState());
        boolean z10 = (C9603h0.m59854L(this) & 256) != 0;
        if (z10) {
            measuredHeight = this.f1771a;
            if (this.f1779i && this.f1774d.getTabContainer() != null) {
                measuredHeight += this.f1771a;
            }
        } else {
            measuredHeight = this.f1774d.getVisibility() != 8 ? this.f1774d.getMeasuredHeight() : 0;
        }
        this.f1786p.set(this.f1784n);
        C9625s0 c9625s0 = this.f1791u;
        this.f1793w = c9625s0;
        if (this.f1778h || z10) {
            this.f1793w = new C9625s0.b(this.f1793w).m60172c(C13504c.m81228b(c9625s0.m60158j(), this.f1793w.m60160l() + measuredHeight, this.f1793w.m60159k(), this.f1793w.m60157i())).m60170a();
        } else {
            Rect rect = this.f1786p;
            rect.top += measuredHeight;
            rect.bottom = rect.bottom;
            this.f1793w = c9625s0.m60162n(0, measuredHeight, 0, 0);
        }
        m2552q(this.f1773c, this.f1786p, true, true, true, true);
        if (!this.f1794x.equals(this.f1793w)) {
            C9625s0 c9625s02 = this.f1793w;
            this.f1794x = c9625s02;
            C9603h0.m59885h(this.f1773c, c9625s02);
        }
        measureChildWithMargins(this.f1773c, i10, 0, i11, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.f1773c.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f1773c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f1773c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f1773c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i10, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i11, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        if (!this.f1780j || !z10) {
            return false;
        }
        if (m2535B(f11)) {
            m2551p();
        } else {
            m2534A();
        }
        this.f1781k = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        int i14 = this.f1782l + i11;
        this.f1782l = i14;
        setActionBarHideOffset(i14);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        this.f1770E.m59784b(view, view2, i10);
        this.f1782l = getActionBarHideOffset();
        m2556u();
        InterfaceC0427d interfaceC0427d = this.f1795y;
        if (interfaceC0427d != null) {
            interfaceC0427d.mo2278e();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        if ((i10 & 2) == 0 || this.f1774d.getVisibility() != 0) {
            return false;
        }
        return this.f1780j;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        if (this.f1780j && !this.f1781k) {
            if (this.f1782l <= this.f1774d.getHeight()) {
                m2559y();
            } else {
                m2558x();
            }
        }
        InterfaceC0427d interfaceC0427d = this.f1795y;
        if (interfaceC0427d != null) {
            interfaceC0427d.mo2275b();
        }
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i10) {
        super.onWindowSystemUiVisibilityChanged(i10);
        m2560z();
        int i11 = this.f1783m ^ i10;
        this.f1783m = i10;
        boolean z10 = (i10 & 4) == 0;
        boolean z11 = (i10 & 256) != 0;
        InterfaceC0427d interfaceC0427d = this.f1795y;
        if (interfaceC0427d != null) {
            interfaceC0427d.mo2276c(!z11);
            if (z10 || !z11) {
                this.f1795y.mo2274a();
            } else {
                this.f1795y.mo2277d();
            }
        }
        if ((i11 & 256) == 0 || this.f1795y == null) {
            return;
        }
        C9603h0.m59896m0(this);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f1772b = i10;
        InterfaceC0427d interfaceC0427d = this.f1795y;
        if (interfaceC0427d != null) {
            interfaceC0427d.mo2279f(i10);
        }
    }

    /* renamed from: p */
    public final void m2551p() {
        m2556u();
        this.f1769D.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m2552q(android.view.View r2, android.graphics.Rect r3, boolean r4, boolean r5, boolean r6, boolean r7) {
        /*
            r1 = this;
            android.view.ViewGroup$LayoutParams r1 = r2.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$LayoutParams r1 = (androidx.appcompat.widget.ActionBarOverlayLayout.LayoutParams) r1
            r2 = 1
            if (r4 == 0) goto L13
            int r4 = r1.leftMargin
            int r0 = r3.left
            if (r4 == r0) goto L13
            r1.leftMargin = r0
            r4 = r2
            goto L14
        L13:
            r4 = 0
        L14:
            if (r5 == 0) goto L1f
            int r5 = r1.topMargin
            int r0 = r3.top
            if (r5 == r0) goto L1f
            r1.topMargin = r0
            r4 = r2
        L1f:
            if (r7 == 0) goto L2a
            int r5 = r1.rightMargin
            int r7 = r3.right
            if (r5 == r7) goto L2a
            r1.rightMargin = r7
            r4 = r2
        L2a:
            if (r6 == 0) goto L35
            int r5 = r1.bottomMargin
            int r3 = r3.bottom
            if (r5 == r3) goto L35
            r1.bottomMargin = r3
            goto L36
        L35:
            r2 = r4
        L36:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.m2552q(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    @Override // android.view.ViewGroup
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setActionBarHideOffset(int i10) {
        m2556u();
        this.f1774d.setTranslationY(-Math.max(0, Math.min(i10, this.f1774d.getHeight())));
    }

    public void setActionBarVisibilityCallback(InterfaceC0427d interfaceC0427d) {
        this.f1795y = interfaceC0427d;
        if (getWindowToken() != null) {
            this.f1795y.mo2279f(this.f1772b);
            int i10 = this.f1783m;
            if (i10 != 0) {
                onWindowSystemUiVisibilityChanged(i10);
                C9603h0.m59896m0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z10) {
        this.f1779i = z10;
    }

    public void setHideOnContentScrollEnabled(boolean z10) {
        if (z10 != this.f1780j) {
            this.f1780j = z10;
            if (z10) {
                return;
            }
            m2556u();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i10) {
        m2560z();
        this.f1775e.setIcon(i10);
    }

    public void setLogo(int i10) {
        m2560z();
        this.f1775e.mo3017l(i10);
    }

    public void setOverlayMode(boolean z10) {
        this.f1778h = z10;
        this.f1777g = z10 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z10) {
    }

    public void setUiOptions(int i10) {
    }

    @Override // androidx.appcompat.widget.InterfaceC0542q
    public void setWindowCallback(Window.Callback callback) {
        m2560z();
        this.f1775e.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.InterfaceC0542q
    public void setWindowTitle(CharSequence charSequence) {
        m2560z();
        this.f1775e.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: t */
    public final InterfaceC0543r m2555t(View view) {
        if (view instanceof InterfaceC0543r) {
            return (InterfaceC0543r) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    /* renamed from: u */
    public void m2556u() {
        removeCallbacks(this.f1768C);
        removeCallbacks(this.f1769D);
        ViewPropertyAnimator viewPropertyAnimator = this.f1766A;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    /* renamed from: w */
    public boolean m2557w() {
        return this.f1778h;
    }

    /* renamed from: x */
    public final void m2558x() {
        m2556u();
        postDelayed(this.f1769D, 600L);
    }

    /* renamed from: y */
    public final void m2559y() {
        m2556u();
        postDelayed(this.f1768C, 600L);
    }

    /* renamed from: z */
    public void m2560z() {
        if (this.f1773c == null) {
            this.f1773c = (ContentFrameLayout) findViewById(R$id.action_bar_activity_content);
            this.f1774d = (ActionBarContainer) findViewById(R$id.action_bar_container);
            this.f1775e = m2555t(findViewById(R$id.action_bar));
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1772b = 0;
        this.f1784n = new Rect();
        this.f1785o = new Rect();
        this.f1786p = new Rect();
        this.f1787q = new Rect();
        this.f1788r = new Rect();
        this.f1789s = new Rect();
        this.f1790t = new Rect();
        C9625s0 c9625s0 = C9625s0.f47738b;
        this.f1791u = c9625s0;
        this.f1792v = c9625s0;
        this.f1793w = c9625s0;
        this.f1794x = c9625s0;
        this.f1767B = new C0424a();
        this.f1768C = new RunnableC0425b();
        this.f1769D = new RunnableC0426c();
        m2533v(context);
        this.f1770E = new C9583a0(this);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        m2560z();
        this.f1775e.setIcon(drawable);
    }
}
