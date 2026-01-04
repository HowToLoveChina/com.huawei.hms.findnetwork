package com.huawei.openalliance.p169ad.views.viewpager;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import com.huawei.hms.network.embedded.C6051p9;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.huawei.openalliance.ad.views.viewpager.e */
/* loaded from: classes2.dex */
public class C8160e extends ViewGroup {

    /* renamed from: A */
    private float f38198A;

    /* renamed from: B */
    private float f38199B;

    /* renamed from: C */
    private int f38200C;

    /* renamed from: D */
    private boolean f38201D;

    /* renamed from: E */
    private boolean f38202E;

    /* renamed from: F */
    private int f38203F;

    /* renamed from: G */
    private int f38204G;

    /* renamed from: H */
    private int f38205H;

    /* renamed from: I */
    private VelocityTracker f38206I;

    /* renamed from: J */
    private int f38207J;

    /* renamed from: K */
    private int f38208K;

    /* renamed from: L */
    private int f38209L;

    /* renamed from: M */
    private boolean f38210M;

    /* renamed from: N */
    private boolean f38211N;

    /* renamed from: O */
    private boolean f38212O;

    /* renamed from: P */
    private int f38213P;

    /* renamed from: Q */
    private int f38214Q;

    /* renamed from: R */
    private List<InterfaceC8159d> f38215R;

    /* renamed from: S */
    private InterfaceC8163h f38216S;

    /* renamed from: T */
    private int f38217T;

    /* renamed from: U */
    private int f38218U;

    /* renamed from: V */
    private EdgeEffect f38219V;

    /* renamed from: W */
    private EdgeEffect f38220W;

    /* renamed from: a */
    int f38221a;

    /* renamed from: aa */
    private int f38222aa;

    /* renamed from: ab */
    private ArrayList<View> f38223ab;

    /* renamed from: ad */
    private final Runnable f38224ad;

    /* renamed from: ae */
    private int f38225ae;

    /* renamed from: b */
    AbstractC8161f f38226b;

    /* renamed from: e */
    private int f38227e;

    /* renamed from: f */
    private int f38228f;

    /* renamed from: g */
    private int f38229g;

    /* renamed from: h */
    private int f38230h;

    /* renamed from: i */
    private boolean f38231i;

    /* renamed from: j */
    private int f38232j;

    /* renamed from: k */
    private int f38233k;

    /* renamed from: l */
    private Scroller f38234l;

    /* renamed from: m */
    private final ArrayList<C8156a> f38235m;

    /* renamed from: n */
    private final C8156a f38236n;

    /* renamed from: o */
    private ClassLoader f38237o;

    /* renamed from: p */
    private final Rect f38238p;

    /* renamed from: q */
    private Drawable f38239q;

    /* renamed from: r */
    private Parcelable f38240r;

    /* renamed from: s */
    private float f38241s;

    /* renamed from: t */
    private float f38242t;

    /* renamed from: u */
    private C8162g f38243u;

    /* renamed from: v */
    private int f38244v;

    /* renamed from: w */
    private boolean f38245w;

    /* renamed from: x */
    private boolean f38246x;

    /* renamed from: y */
    private float f38247y;

    /* renamed from: z */
    private float f38248z;

    /* renamed from: c */
    private static final Comparator<C8156a> f38196c = new Comparator<C8156a>() { // from class: com.huawei.openalliance.ad.views.viewpager.e.1
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C8156a c8156a, C8156a c8156a2) {
            return c8156a.f38188b - c8156a2.f38188b;
        }
    };

    /* renamed from: d */
    private static final Interpolator f38197d = new Interpolator() { // from class: com.huawei.openalliance.ad.views.viewpager.e.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    };

    /* renamed from: ac */
    private static final C8165j f38195ac = new C8165j();

    public C8160e(Context context) {
        super(context);
        this.f38230h = -1;
        this.f38235m = new ArrayList<>();
        this.f38236n = new C8156a();
        this.f38237o = null;
        this.f38238p = new Rect();
        this.f38240r = null;
        this.f38241s = -3.4028235E38f;
        this.f38242t = Float.MAX_VALUE;
        this.f38200C = 1;
        this.f38205H = -1;
        this.f38210M = true;
        this.f38224ad = new Runnable() { // from class: com.huawei.openalliance.ad.views.viewpager.e.3
            @Override // java.lang.Runnable
            public void run() {
                C8160e.this.setScrollState(0);
                C8160e.this.m50593b();
            }
        };
        this.f38225ae = 0;
        m50570h();
    }

    /* renamed from: c */
    private View m50557c(View view) {
        for (ViewParent parent = view.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            if (parent == this) {
                return view;
            }
        }
        for (ViewParent parent2 = view.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
            parent2.getClass();
        }
        return null;
    }

    /* renamed from: d */
    private void m50560d(int i10) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            C8164i c8164i = (C8164i) getChildAt(i11).getLayoutParams();
            if (!c8164i.f38254b) {
                c8164i.f38256d = 0.0f;
            }
        }
        m50586a(i10, false, true);
        requestLayout();
    }

    /* renamed from: e */
    private void m50563e() {
        setWillNotDraw(false);
        setDescendantFocusability(C6051p9.f27764p);
        setFocusable(true);
    }

    /* renamed from: f */
    private void m50566f() {
        setOnApplyWindowInsetsListener(new ViewOnApplyWindowInsetsListenerC8158c(this));
    }

    /* renamed from: g */
    private void m50568g() {
        Context context = getContext();
        this.f38234l = new Scroller(context, f38197d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f38204G = viewConfiguration.getScaledPagingTouchSlop();
        this.f38207J = (int) (400.0f * f10);
        this.f38208K = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f38219V = new EdgeEffect(context);
        this.f38220W = new EdgeEffect(context);
        this.f38209L = (int) (25.0f * f10);
        this.f38218U = (int) (2.0f * f10);
        this.f38213P = (int) (f10 * 16.0f);
        setAccessibilityDelegate(new C8157b(this));
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    private int getClientViewWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    /* renamed from: h */
    private void m50570h() {
        m50563e();
        m50568g();
        m50566f();
    }

    /* renamed from: i */
    private void m50572i() {
        int i10 = 0;
        while (i10 < getChildCount()) {
            if (!((C8164i) getChildAt(i10).getLayoutParams()).f38254b) {
                removeViewAt(i10);
                i10--;
            }
            i10++;
        }
    }

    /* renamed from: j */
    private void m50573j() {
        C8156a c8156aM50580a;
        this.f38226b.m50604b(this);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            C8164i c8164i = (C8164i) childAt.getLayoutParams();
            c8164i.f38259g = i10;
            if (!c8164i.f38254b && c8164i.f38256d == 0.0f && (c8156aM50580a = m50580a(childAt)) != null) {
                c8164i.f38256d = c8156aM50580a.f38190d;
                c8164i.f38258f = c8156aM50580a.f38188b;
            }
        }
        m50574k();
        if (hasFocus()) {
            View viewFindFocus = findFocus();
            C8156a c8156aM50592b = viewFindFocus != null ? m50592b(viewFindFocus) : null;
            if (c8156aM50592b == null || c8156aM50592b.f38188b != this.f38221a) {
                for (int i11 = 0; i11 < getChildCount(); i11++) {
                    View childAt2 = getChildAt(i11);
                    C8156a c8156aM50580a2 = m50580a(childAt2);
                    if (c8156aM50580a2 != null && c8156aM50580a2.f38188b == this.f38221a && childAt2.requestFocus(2)) {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: k */
    private void m50574k() {
        if (this.f38222aa != 0) {
            ArrayList<View> arrayList = this.f38223ab;
            if (arrayList == null) {
                this.f38223ab = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                this.f38223ab.add(getChildAt(i10));
            }
            Collections.sort(this.f38223ab, f38195ac);
        }
    }

    /* renamed from: l */
    private boolean m50575l() {
        this.f38205H = -1;
        m50577n();
        this.f38219V.onRelease();
        this.f38220W.onRelease();
        return this.f38219V.isFinished() || this.f38220W.isFinished();
    }

    /* renamed from: m */
    private C8156a m50576m() {
        int i10;
        int clientViewWidth = getClientViewWidth();
        float f10 = 0.0f;
        float scrollX = clientViewWidth > 0 ? getScrollX() / clientViewWidth : 0.0f;
        float f11 = clientViewWidth > 0 ? this.f38244v / clientViewWidth : 0.0f;
        int i11 = 0;
        boolean z10 = true;
        C8156a c8156a = null;
        int i12 = -1;
        float f12 = 0.0f;
        while (i11 < this.f38235m.size()) {
            C8156a c8156a2 = this.f38235m.get(i11);
            if (!z10 && c8156a2.f38188b != (i10 = i12 + 1)) {
                c8156a2 = this.f38236n;
                c8156a2.f38191e = f10 + f12 + f11;
                c8156a2.f38188b = i10;
                c8156a2.f38190d = this.f38226b.m50598a(i10);
                i11--;
            }
            C8156a c8156a3 = c8156a2;
            f10 = c8156a3.f38191e;
            float f13 = c8156a3.f38190d + f10 + f11;
            if (!z10 && scrollX < f10) {
                return c8156a;
            }
            if (scrollX < f13 || i11 == this.f38235m.size() - 1) {
                return c8156a3;
            }
            int i13 = c8156a3.f38188b;
            float f14 = c8156a3.f38190d;
            i11++;
            z10 = false;
            i12 = i13;
            f12 = f14;
            c8156a = c8156a3;
        }
        return c8156a;
    }

    /* renamed from: n */
    private void m50577n() {
        this.f38201D = false;
        this.f38212O = false;
        VelocityTracker velocityTracker = this.f38206I;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f38206I = null;
        }
    }

    private void setScrollingCacheEnabledStatus(boolean z10) {
        if (this.f38202E != z10) {
            this.f38202E = z10;
        }
    }

    /* renamed from: a */
    public float m50578a(float f10) {
        return (float) Math.sin((f10 - 0.5f) * 0.47123894f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        C8156a c8156aM50580a;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i12 = 0; i12 < getChildCount(); i12++) {
                View childAt = getChildAt(i12);
                if (childAt.getVisibility() == 0 && (c8156aM50580a = m50580a(childAt)) != null && c8156aM50580a.f38188b == this.f38221a) {
                    childAt.addFocusables(arrayList, i10, i11);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i11 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        C8156a c8156aM50580a;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (c8156aM50580a = m50580a(childAt)) != null && c8156aM50580a.f38188b == this.f38221a) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        C8164i c8164i = (C8164i) layoutParams;
        if (!this.f38245w) {
            super.addView(view, i10, layoutParams);
        } else {
            if (c8164i != null && c8164i.f38254b) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            c8164i.f38257e = true;
            addViewInLayout(view, i10, layoutParams);
        }
    }

    /* renamed from: b */
    public C8156a m50591b(int i10) {
        for (int i11 = 0; i11 < this.f38235m.size(); i11++) {
            C8156a c8156a = this.f38235m.get(i11);
            if (c8156a.f38188b == i10) {
                return c8156a;
            }
        }
        return null;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        if (this.f38226b == null) {
            return false;
        }
        int clientViewWidth = getClientViewWidth();
        int scrollX = getScrollX();
        return i10 < 0 ? scrollX > ((int) (((float) clientViewWidth) * this.f38241s)) : i10 > 0 && scrollX < ((int) (((float) clientViewWidth) * this.f38242t));
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C8164i) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f38231i = true;
        if (this.f38234l.isFinished() || !this.f38234l.computeScrollOffset()) {
            m50546a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f38234l.getCurrX();
        int currY = this.f38234l.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!m50567f(currX)) {
                this.f38234l.abortAnimation();
                scrollTo(0, currY);
            }
        }
        postInvalidateOnAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m50589a(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        C8156a c8156aM50580a;
        if (4096 == accessibilityEvent.getEventType()) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (c8156aM50580a = m50580a(childAt)) != null && c8156aM50580a.f38188b == this.f38221a && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean zDraw;
        AbstractC8161f abstractC8161f;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        if (overScrollMode != 0 && (overScrollMode != 1 || (abstractC8161f = this.f38226b) == null || abstractC8161f.mo42547a() <= 1)) {
            this.f38219V.finish();
            this.f38220W.finish();
            return;
        }
        if (this.f38219V.isFinished()) {
            zDraw = false;
        } else {
            int iSave = canvas.save();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int width = getWidth();
            canvas.rotate(270.0f);
            canvas.translate((-height) + getPaddingTop(), this.f38241s * width);
            this.f38219V.setSize(height, width);
            zDraw = this.f38219V.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        if (!this.f38220W.isFinished()) {
            int iSave2 = canvas.save();
            int width2 = getWidth();
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(90.0f);
            canvas.translate(-getPaddingTop(), (-(this.f38242t + 1.0f)) * width2);
            this.f38220W.setSize(height2, width2);
            zDraw |= this.f38220W.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        if (zDraw) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f38239q;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C8164i();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C8164i(getContext(), attributeSet);
    }

    public AbstractC8161f getAdapter() {
        return this.f38226b;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        if (this.f38222aa == 2) {
            i11 = (i10 - 1) - i11;
        }
        return ((C8164i) this.f38223ab.get(i11).getLayoutParams()).f38259g;
    }

    public int getCurrentItem() {
        return this.f38221a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f38210M = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f38224ad);
        Scroller scroller = this.f38234l;
        if (scroller != null && !scroller.isFinished()) {
            this.f38234l.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i10;
        float f10;
        float f11;
        super.onDraw(canvas);
        if (this.f38244v <= 0 || this.f38239q == null || this.f38235m.size() <= 0 || this.f38226b == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f12 = this.f38244v / width;
        int i11 = 0;
        C8156a c8156a = this.f38235m.get(0);
        float f13 = c8156a.f38191e;
        int size = this.f38235m.size();
        int i12 = c8156a.f38188b;
        int i13 = this.f38235m.get(size - 1).f38188b;
        while (i12 < i13) {
            while (true) {
                i10 = c8156a.f38188b;
                if (i12 <= i10 || i11 >= size) {
                    break;
                }
                i11++;
                c8156a = this.f38235m.get(i11);
            }
            if (i12 == i10) {
                float f14 = c8156a.f38191e;
                float f15 = c8156a.f38190d;
                f10 = (f14 + f15) * width;
                f13 = f14 + f15 + f12;
            } else {
                float fM50598a = this.f38226b.m50598a(i12);
                f10 = (f13 + fM50598a) * width;
                f13 += fM50598a + f12;
            }
            if (this.f38244v + f10 > scrollX) {
                f11 = f12;
                this.f38239q.setBounds(Math.round(f10), this.f38232j, Math.round(this.f38244v + f10), this.f38233k);
                this.f38239q.draw(canvas);
            } else {
                f11 = f12;
            }
            if (f10 > scrollX + r2) {
                return;
            }
            i12++;
            f12 = f11;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
        if (action == 3 || action == 1) {
            m50575l();
            return false;
        }
        if (action != 0) {
            if (this.f38201D) {
                return true;
            }
            if (this.f38212O) {
                return false;
            }
        }
        if (action == 0) {
            m50543a(motionEvent);
        } else if (action == 2) {
            int i10 = this.f38205H;
            if (i10 != -1 && m50550a(motionEvent, i10)) {
                return false;
            }
        } else if (action == 6) {
            m50565e(motionEvent);
        }
        if (this.f38206I == null) {
            this.f38206I = VelocityTracker.obtain();
        }
        this.f38206I.addMovement(motionEvent);
        return this.f38201D;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean z11;
        int measuredWidth;
        int measuredHeight;
        int iMax;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        int i16 = paddingTop;
        int measuredHeight2 = paddingBottom;
        int i17 = 0;
        int measuredWidth2 = paddingLeft;
        int measuredWidth3 = paddingRight;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                C8164i c8164i = (C8164i) childAt.getLayoutParams();
                if (c8164i.f38254b) {
                    int i19 = c8164i.f38255c;
                    int i20 = i19 & 7;
                    int i21 = i19 & 112;
                    if (i20 == 1) {
                        measuredWidth = Math.max((i14 - childAt.getMeasuredWidth()) / 2, measuredWidth2);
                    } else if (i20 == 5) {
                        measuredWidth = (i14 - measuredWidth3) - childAt.getMeasuredWidth();
                        measuredWidth3 += childAt.getMeasuredWidth();
                    } else if (i20 == 3) {
                        measuredWidth = measuredWidth2;
                        measuredWidth2 = childAt.getMeasuredWidth() + measuredWidth2;
                    } else {
                        measuredWidth = measuredWidth2;
                    }
                    if (i21 == 80) {
                        iMax = (i15 - measuredHeight2) - childAt.getMeasuredHeight();
                        measuredHeight2 += childAt.getMeasuredHeight();
                    } else {
                        if (i21 == 48) {
                            measuredHeight = childAt.getMeasuredHeight() + i16;
                        } else if (i21 == 16) {
                            iMax = Math.max((i15 - childAt.getMeasuredHeight()) / 2, i16);
                        } else {
                            measuredHeight = i16;
                        }
                        int i22 = measuredWidth + scrollX;
                        childAt.layout(i22, i16, childAt.getMeasuredWidth() + i22, i16 + childAt.getMeasuredHeight());
                        i17++;
                        i16 = measuredHeight;
                    }
                    int i23 = i16;
                    i16 = iMax;
                    measuredHeight = i23;
                    int i222 = measuredWidth + scrollX;
                    childAt.layout(i222, i16, childAt.getMeasuredWidth() + i222, i16 + childAt.getMeasuredHeight());
                    i17++;
                    i16 = measuredHeight;
                }
            }
        }
        m50541a(childCount, measuredWidth2, i16, measuredWidth3, measuredHeight2, i14, i15);
        this.f38232j = i16;
        this.f38233k = i15 - measuredHeight2;
        this.f38214Q = i17;
        if (this.f38210M) {
            z11 = false;
            m50542a(this.f38221a, false, 0, false);
        } else {
            z11 = false;
        }
        this.f38210M = z11;
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        C8164i c8164i;
        int i12;
        setMeasuredDimension(View.getDefaultSize(0, i10), View.getDefaultSize(0, i11));
        int measuredWidth = getMeasuredWidth();
        this.f38203F = Math.min(measuredWidth / 10, this.f38213P);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i13 = 0;
        while (true) {
            int i14 = 1073741824;
            if (i13 >= childCount) {
                this.f38227e = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
                this.f38228f = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
                m50564e(paddingLeft);
                return;
            }
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8 && (c8164i = (C8164i) childAt.getLayoutParams()) != null && c8164i.f38254b) {
                int i15 = c8164i.f38255c;
                int i16 = i15 & 7;
                int i17 = i15 & 112;
                boolean z10 = true;
                boolean z11 = i17 == 48 || i17 == 80;
                if (i16 != 3 && i16 != 5) {
                    z10 = false;
                }
                int i18 = Integer.MIN_VALUE;
                if (z11) {
                    i12 = Integer.MIN_VALUE;
                    i18 = 1073741824;
                } else {
                    i12 = z10 ? 1073741824 : Integer.MIN_VALUE;
                }
                int i19 = ((ViewGroup.LayoutParams) c8164i).width;
                if (i19 != -2) {
                    if (i19 == -1) {
                        i19 = paddingLeft;
                    }
                    i18 = 1073741824;
                } else {
                    i19 = paddingLeft;
                }
                int i20 = ((ViewGroup.LayoutParams) c8164i).height;
                if (i20 == -2) {
                    i20 = measuredHeight;
                    i14 = i12;
                } else if (i20 == -1) {
                    i20 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i19, i18), View.MeasureSpec.makeMeasureSpec(i20, i14));
                if (z11) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z10) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i13++;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        int i11;
        int i12;
        int i13;
        C8156a c8156aM50580a;
        int childCount = getChildCount();
        if ((i10 & 2) != 0) {
            i12 = childCount;
            i11 = 0;
            i13 = 1;
        } else {
            i11 = childCount - 1;
            i12 = -1;
            i13 = -1;
        }
        while (i11 != i12) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 0 && (c8156aM50580a = m50580a(childAt)) != null && c8156aM50580a.f38188b == this.f38221a && childAt.requestFocus(i10, rect)) {
                return true;
            }
            i11 += i13;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedStatePPS)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedStatePPS savedStatePPS = (SavedStatePPS) parcelable;
        super.onRestoreInstanceState(savedStatePPS.m50527a());
        AbstractC8161f abstractC8161f = this.f38226b;
        if (abstractC8161f != null) {
            abstractC8161f.m50601a(savedStatePPS.f38185c, savedStatePPS.f38186d);
            m50586a(savedStatePPS.f38184b, false, true);
        } else {
            this.f38230h = savedStatePPS.f38184b;
            this.f38240r = savedStatePPS.f38185c;
            this.f38237o = savedStatePPS.f38186d;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedStatePPS savedStatePPS = new SavedStatePPS(super.onSaveInstanceState());
        savedStatePPS.f38184b = this.f38221a;
        AbstractC8161f abstractC8161f = this.f38226b;
        if (abstractC8161f != null) {
            savedStatePPS.f38185c = abstractC8161f.m50603b();
        }
        return savedStatePPS;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12) {
            int i14 = this.f38244v;
            m50538a(i10, i12, i14, i14);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AbstractC8161f abstractC8161f;
        boolean zM50551a;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (abstractC8161f = this.f38226b) == null || abstractC8161f.mo42547a() == 0) {
            return false;
        }
        if (this.f38206I == null) {
            this.f38206I = VelocityTracker.obtain();
        }
        this.f38206I.addMovement(motionEvent);
        int action = motionEvent.getAction() & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
        if (action != 0) {
            if (action == 1) {
                zM50551a = m50551a(motionEvent, false);
            } else if (action == 2) {
                zM50551a = m50556b(motionEvent, false);
            } else if (action == 3) {
                zM50551a = m50559c(false);
            } else if (action == 5) {
                m50558c(motionEvent);
            } else if (action == 6) {
                m50553b(motionEvent);
            }
            if (zM50551a) {
                postInvalidateOnAnimation();
            }
        } else {
            m50561d(motionEvent);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f38245w) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(AbstractC8161f abstractC8161f) {
        AbstractC8161f abstractC8161f2 = this.f38226b;
        if (abstractC8161f2 != null) {
            abstractC8161f2.m50600a((DataSetObserver) null);
            this.f38226b.m50602a((ViewGroup) this);
            for (int i10 = 0; i10 < this.f38235m.size(); i10++) {
                C8156a c8156a = this.f38235m.get(i10);
                this.f38226b.mo42549a(this, c8156a.f38188b, c8156a.f38187a);
            }
            this.f38226b.m50604b(this);
            this.f38235m.clear();
            m50572i();
            this.f38221a = 0;
            scrollTo(0, 0);
        }
        this.f38226b = abstractC8161f;
        this.f38229g = 0;
        if (abstractC8161f != null) {
            if (this.f38243u == null) {
                this.f38243u = new C8162g(this);
            }
            this.f38226b.m50600a((DataSetObserver) this.f38243u);
            this.f38246x = false;
            boolean z10 = this.f38210M;
            this.f38210M = true;
            this.f38229g = this.f38226b.mo42547a();
            if (this.f38230h < 0) {
                if (z10) {
                    requestLayout();
                    return;
                } else {
                    m50593b();
                    return;
                }
            }
            this.f38226b.m50601a(this.f38240r, this.f38237o);
            m50586a(this.f38230h, false, true);
            this.f38230h = -1;
            this.f38240r = null;
            this.f38237o = null;
        }
    }

    public void setCurrentItem(int i10) {
        this.f38246x = false;
        m50586a(i10, !this.f38210M, false);
    }

    public void setScrollState(int i10) {
        if (this.f38225ae == i10) {
            return;
        }
        this.f38225ae = i10;
        if (this.f38216S != null) {
            m50554b(i10 != 0);
        }
        m50569g(i10);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f38239q;
    }

    public C8160e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38230h = -1;
        this.f38235m = new ArrayList<>();
        this.f38236n = new C8156a();
        this.f38237o = null;
        this.f38238p = new Rect();
        this.f38240r = null;
        this.f38241s = -3.4028235E38f;
        this.f38242t = Float.MAX_VALUE;
        this.f38200C = 1;
        this.f38205H = -1;
        this.f38210M = true;
        this.f38224ad = new Runnable() { // from class: com.huawei.openalliance.ad.views.viewpager.e.3
            @Override // java.lang.Runnable
            public void run() {
                C8160e.this.setScrollState(0);
                C8160e.this.m50593b();
            }
        };
        this.f38225ae = 0;
        m50570h();
    }

    /* renamed from: a */
    private int m50535a(int i10, float f10, int i11, int i12) {
        if (Math.abs(i12) <= this.f38209L || Math.abs(i11) <= this.f38207J) {
            i10 += (int) (f10 + (i10 >= this.f38221a ? 0.4f : 0.6f));
        } else if (i11 <= 0) {
            i10++;
        }
        if (this.f38235m.size() <= 0) {
            return i10;
        }
        return Math.max(this.f38235m.get(0).f38188b, Math.min(i10, this.f38235m.get(r1.size() - 1).f38188b));
    }

    /* renamed from: c */
    private void m50558c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        this.f38247y = motionEvent.getX(actionIndex);
        this.f38205H = motionEvent.getPointerId(actionIndex);
    }

    /* renamed from: d */
    private void m50561d(MotionEvent motionEvent) {
        this.f38234l.abortAnimation();
        this.f38246x = false;
        m50593b();
        float x10 = motionEvent.getX();
        this.f38198A = x10;
        this.f38247y = x10;
        float y10 = motionEvent.getY();
        this.f38199B = y10;
        this.f38248z = y10;
        this.f38205H = motionEvent.getPointerId(0);
    }

    /* renamed from: e */
    private void m50564e(int i10) {
        int iMakeMeasureSpec;
        this.f38245w = true;
        m50593b();
        this.f38245w = false;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                C8164i c8164i = (C8164i) childAt.getLayoutParams();
                if (c8164i == null) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
                } else if (!c8164i.f38254b) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (i10 * c8164i.f38256d), 1073741824);
                }
                childAt.measure(iMakeMeasureSpec, this.f38228f);
            }
        }
    }

    /* renamed from: f */
    private boolean m50567f(int i10) {
        if (this.f38235m.size() == 0) {
            if (this.f38210M) {
                return false;
            }
            this.f38211N = false;
            m50583a(0, 0.0f, 0);
            if (this.f38211N) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        C8156a c8156aM50576m = m50576m();
        if (c8156aM50576m == null) {
            return false;
        }
        int clientViewWidth = getClientViewWidth();
        int i11 = this.f38244v;
        int i12 = clientViewWidth + i11;
        float f10 = clientViewWidth;
        int i13 = c8156aM50576m.f38188b;
        float f11 = ((i10 / f10) - c8156aM50576m.f38191e) / (c8156aM50576m.f38190d + (i11 / f10));
        this.f38211N = false;
        m50583a(i13, f11, (int) (i12 * f11));
        if (this.f38211N) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* renamed from: g */
    private void m50569g(int i10) {
        List<InterfaceC8159d> list = this.f38215R;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                InterfaceC8159d interfaceC8159d = this.f38215R.get(i11);
                if (interfaceC8159d != null) {
                    interfaceC8159d.mo38723b(i10);
                }
            }
        }
    }

    /* renamed from: h */
    private void m50571h(int i10) {
        List<InterfaceC8159d> list = this.f38215R;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                InterfaceC8159d interfaceC8159d = this.f38215R.get(i11);
                if (interfaceC8159d != null) {
                    interfaceC8159d.mo38721a(i10);
                }
            }
        }
    }

    /* renamed from: b */
    public C8156a m50592b(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return m50580a(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a A[PHI: r5 r6 r7
  0x002a: PHI (r5v5 int) = (r5v2 int), (r5v1 int), (r5v6 int) binds: [B:24:0x004e, B:21:0x0040, B:14:0x0028] A[DONT_GENERATE, DONT_INLINE]
  0x002a: PHI (r6v6 float) = (r6v2 float), (r6v3 float), (r6v1 float) binds: [B:24:0x004e, B:21:0x0040, B:14:0x0028] A[DONT_GENERATE, DONT_INLINE]
  0x002a: PHI (r7v5 int) = (r7v1 int), (r7v2 int), (r7v6 int) binds: [B:24:0x004e, B:21:0x0040, B:14:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int m50536a(int r4, int r5, float r6, int r7, com.huawei.openalliance.p169ad.views.viewpager.C8156a r8, float r9) {
        /*
            r3 = this;
            int r0 = r3.f38221a
            int r0 = r0 + (-1)
        L4:
            if (r0 < 0) goto L54
            int r1 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            r2 = 0
            if (r1 < 0) goto L35
            if (r0 >= r4) goto L35
            if (r8 != 0) goto L10
            goto L54
        L10:
            int r1 = r8.f38188b
            if (r0 != r1) goto L51
            boolean r1 = r8.f38189c
            if (r1 != 0) goto L51
            java.util.ArrayList<com.huawei.openalliance.ad.views.viewpager.a> r1 = r3.f38235m
            r1.remove(r7)
            com.huawei.openalliance.ad.views.viewpager.f r1 = r3.f38226b
            java.lang.Object r8 = r8.f38187a
            r1.mo42549a(r3, r0, r8)
            int r7 = r7 + (-1)
            int r5 = r5 + (-1)
            if (r7 < 0) goto L33
        L2a:
            java.util.ArrayList<com.huawei.openalliance.ad.views.viewpager.a> r8 = r3.f38235m
            java.lang.Object r8 = r8.get(r7)
            r2 = r8
            com.huawei.openalliance.ad.views.viewpager.a r2 = (com.huawei.openalliance.p169ad.views.viewpager.C8156a) r2
        L33:
            r8 = r2
            goto L51
        L35:
            if (r8 == 0) goto L43
            int r1 = r8.f38188b
            if (r0 != r1) goto L43
            float r8 = r8.f38190d
            float r6 = r6 + r8
            int r7 = r7 + (-1)
            if (r7 < 0) goto L33
            goto L2a
        L43:
            int r8 = r7 + 1
            com.huawei.openalliance.ad.views.viewpager.a r8 = r3.m50579a(r0, r8)
            float r8 = r8.f38190d
            float r6 = r6 + r8
            int r5 = r5 + 1
            if (r7 < 0) goto L33
            goto L2a
        L51:
            int r0 = r0 + (-1)
            goto L4
        L54:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.views.viewpager.C8160e.m50536a(int, int, float, int, com.huawei.openalliance.ad.views.viewpager.a, float):int");
    }

    /* renamed from: d */
    private void m50562d(boolean z10) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z10);
        }
    }

    /* renamed from: e */
    private void m50565e(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f38205H) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.f38247y = motionEvent.getX(i10);
            this.f38205H = motionEvent.getPointerId(i10);
            VelocityTracker velocityTracker = this.f38206I;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* renamed from: b */
    public void m50593b() {
        m50582a(this.f38221a);
    }

    /* renamed from: c */
    public boolean m50594c() {
        AbstractC8161f abstractC8161f = this.f38226b;
        if (abstractC8161f == null || this.f38221a >= abstractC8161f.mo42547a() - 1) {
            return false;
        }
        m50585a(this.f38221a + 1, true);
        return true;
    }

    /* renamed from: a */
    private Rect m50537a(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        rect.left = view.getLeft();
        int right = view.getRight();
        while (true) {
            rect.right = right;
            ViewParent parent = view.getParent();
            if (!(parent instanceof ViewGroup) || parent == this) {
                break;
            }
            view = (ViewGroup) parent;
            rect.top += view.getTop();
            rect.bottom += view.getBottom();
            rect.left += view.getLeft();
            right = rect.right + view.getRight();
        }
        return rect;
    }

    /* renamed from: b */
    private void m50552b(int i10, float f10, int i11) {
        List<InterfaceC8159d> list = this.f38215R;
        if (list != null) {
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                InterfaceC8159d interfaceC8159d = this.f38215R.get(i12);
                if (interfaceC8159d != null) {
                    interfaceC8159d.mo38722a(i10, f10, i11);
                }
            }
        }
    }

    /* renamed from: c */
    public boolean m50595c(int i10) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        } else if (viewFindFocus != null) {
            viewFindFocus = m50557c(viewFindFocus);
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i10);
        boolean zM50596d = false;
        if (viewFindNextFocus != null && viewFindNextFocus != viewFindFocus) {
            zM50596d = m50549a(i10, viewFindFocus, false, viewFindNextFocus);
        } else if (i10 == 17 || i10 == 1) {
            zM50596d = m50596d();
        } else if (i10 == 66 || i10 == 2) {
            zM50596d = m50594c();
        }
        if (zM50596d) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i10));
        }
        return zM50596d;
    }

    /* renamed from: d */
    public boolean m50596d() {
        int i10 = this.f38221a;
        if (i10 <= 0) {
            return false;
        }
        m50585a(i10 - 1, true);
        return true;
    }

    /* renamed from: b */
    private void m50553b(MotionEvent motionEvent) {
        m50565e(motionEvent);
        this.f38247y = motionEvent.getX(motionEvent.findPointerIndex(this.f38205H));
    }

    /* renamed from: c */
    private boolean m50559c(boolean z10) {
        if (!this.f38201D) {
            return z10;
        }
        m50542a(this.f38221a, true, 0, false);
        return m50575l();
    }

    /* renamed from: a */
    public C8156a m50579a(int i10, int i11) {
        C8156a c8156a = new C8156a();
        c8156a.f38188b = i10;
        c8156a.f38187a = this.f38226b.mo42548a(this, i10);
        c8156a.f38190d = this.f38226b.m50598a(i10);
        if (i11 < 0 || i11 >= this.f38235m.size()) {
            this.f38235m.add(c8156a);
        } else {
            this.f38235m.add(i11, c8156a);
        }
        return c8156a;
    }

    /* renamed from: b */
    private void m50554b(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            getChildAt(i10).setLayerType(z10 ? this.f38217T : 0, null);
        }
    }

    /* renamed from: a */
    public C8156a m50580a(View view) {
        for (int i10 = 0; i10 < this.f38235m.size(); i10++) {
            C8156a c8156a = this.f38235m.get(i10);
            if (this.f38226b.mo42550a(view, c8156a.f38187a)) {
                return c8156a;
            }
        }
        return null;
    }

    /* renamed from: b */
    private boolean m50555b(float f10) {
        boolean z10;
        boolean z11;
        float f11 = this.f38247y - f10;
        this.f38247y = f10;
        float scrollX = getScrollX() + f11;
        float clientViewWidth = getClientViewWidth();
        float f12 = this.f38241s * clientViewWidth;
        float f13 = this.f38242t * clientViewWidth;
        boolean z12 = false;
        C8156a c8156a = this.f38235m.get(0);
        ArrayList<C8156a> arrayList = this.f38235m;
        C8156a c8156a2 = arrayList.get(arrayList.size() - 1);
        if (c8156a.f38188b != 0) {
            f12 = c8156a.f38191e * clientViewWidth;
            z10 = false;
        } else {
            z10 = true;
        }
        if (c8156a2.f38188b != this.f38226b.mo42547a() - 1) {
            f13 = c8156a2.f38191e * clientViewWidth;
            z11 = false;
        } else {
            z11 = true;
        }
        if (scrollX < f12) {
            if (z10) {
                this.f38219V.onPull(Math.abs(f12 - scrollX) / clientViewWidth);
                z12 = true;
            }
            scrollX = f12;
        } else if (scrollX > f13) {
            if (z11) {
                this.f38220W.onPull(Math.abs(scrollX - f13) / clientViewWidth);
                z12 = true;
            }
            scrollX = f13;
        }
        int i10 = (int) scrollX;
        this.f38247y += scrollX - i10;
        scrollTo(i10, getScrollY());
        m50567f(i10);
        return z12;
    }

    /* renamed from: a */
    public void m50581a() {
        int iMo42547a = this.f38226b.mo42547a();
        this.f38229g = iMo42547a;
        boolean z10 = this.f38235m.size() < (this.f38200C * 2) + 1 && this.f38235m.size() < iMo42547a;
        int iMax = this.f38221a;
        int i10 = 0;
        boolean z11 = false;
        while (i10 < this.f38235m.size()) {
            C8156a c8156a = this.f38235m.get(i10);
            int iM50599a = this.f38226b.m50599a(c8156a.f38187a);
            if (iM50599a != -1) {
                if (iM50599a == -2) {
                    this.f38235m.remove(i10);
                    i10--;
                    if (!z11) {
                        this.f38226b.m50602a((ViewGroup) this);
                        z11 = true;
                    }
                    this.f38226b.mo42549a(this, c8156a.f38188b, c8156a.f38187a);
                    int i11 = this.f38221a;
                    if (i11 == c8156a.f38188b) {
                        iMax = Math.max(0, Math.min(i11, iMo42547a - 1));
                    }
                } else {
                    int i12 = c8156a.f38188b;
                    if (i12 != iM50599a) {
                        if (i12 == this.f38221a) {
                            iMax = iM50599a;
                        }
                        c8156a.f38188b = iM50599a;
                    }
                }
                z10 = true;
            }
            i10++;
        }
        if (z11) {
            this.f38226b.m50604b(this);
        }
        Collections.sort(this.f38235m, f38196c);
        if (z10) {
            m50560d(iMax);
        }
    }

    /* renamed from: b */
    private boolean m50556b(MotionEvent motionEvent, boolean z10) {
        if (!this.f38201D) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f38205H);
            if (iFindPointerIndex == -1) {
                return m50575l();
            }
            float x10 = motionEvent.getX(iFindPointerIndex);
            float fAbs = Math.abs(x10 - this.f38247y);
            float y10 = motionEvent.getY(iFindPointerIndex);
            float fAbs2 = Math.abs(y10 - this.f38248z);
            if (fAbs > this.f38204G && fAbs > fAbs2) {
                this.f38201D = true;
                m50562d(true);
                float f10 = this.f38198A;
                this.f38247y = x10 - f10 > 0.0f ? f10 + this.f38204G : f10 - this.f38204G;
                this.f38248z = y10;
                setScrollState(1);
                setScrollingCacheEnabledStatus(true);
                ViewParent parent = getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
        return this.f38201D ? z10 | m50555b(motionEvent.getX(motionEvent.findPointerIndex(this.f38205H))) : z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0063, code lost:
    
        r3 = null;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m50582a(int r13) {
        /*
            r12 = this;
            int r0 = r12.f38221a
            r1 = 0
            if (r0 == r13) goto Lc
            com.huawei.openalliance.ad.views.viewpager.a r0 = r12.m50591b(r0)
            r12.f38221a = r13
            goto Ld
        Lc:
            r0 = r1
        Ld:
            com.huawei.openalliance.ad.views.viewpager.f r13 = r12.f38226b
            if (r13 != 0) goto L15
            r12.m50574k()
            return
        L15:
            boolean r13 = r12.f38246x
            if (r13 == 0) goto L1d
            r12.m50574k()
            return
        L1d:
            android.os.IBinder r13 = r12.getWindowToken()
            if (r13 != 0) goto L24
            return
        L24:
            com.huawei.openalliance.ad.views.viewpager.f r13 = r12.f38226b
            r13.m50602a(r12)
            int r13 = r12.f38200C
            int r2 = r12.f38221a
            int r2 = r2 - r13
            r3 = 0
            int r5 = java.lang.Math.max(r3, r2)
            com.huawei.openalliance.ad.views.viewpager.f r2 = r12.f38226b
            int r2 = r2.mo42547a()
            int r4 = r2 + (-1)
            int r6 = r12.f38221a
            int r6 = r6 + r13
            int r13 = java.lang.Math.min(r4, r6)
            int r4 = r12.f38229g
            if (r2 != r4) goto Lbb
            r6 = r3
        L47:
            java.util.ArrayList<com.huawei.openalliance.ad.views.viewpager.a> r3 = r12.f38235m
            int r3 = r3.size()
            if (r6 >= r3) goto L63
            java.util.ArrayList<com.huawei.openalliance.ad.views.viewpager.a> r3 = r12.f38235m
            java.lang.Object r3 = r3.get(r6)
            com.huawei.openalliance.ad.views.viewpager.a r3 = (com.huawei.openalliance.p169ad.views.viewpager.C8156a) r3
            int r4 = r3.f38188b
            int r7 = r12.f38221a
            if (r4 < r7) goto L60
            if (r4 != r7) goto L63
            goto L64
        L60:
            int r6 = r6 + 1
            goto L47
        L63:
            r3 = r1
        L64:
            if (r3 != 0) goto L6e
            if (r2 <= 0) goto L6e
            int r3 = r12.f38221a
            com.huawei.openalliance.ad.views.viewpager.a r3 = r12.m50579a(r3, r6)
        L6e:
            if (r3 == 0) goto Lb7
            int r8 = r6 + (-1)
            if (r8 < 0) goto L7c
            java.util.ArrayList<com.huawei.openalliance.ad.views.viewpager.a> r1 = r12.f38235m
            java.lang.Object r1 = r1.get(r8)
            com.huawei.openalliance.ad.views.viewpager.a r1 = (com.huawei.openalliance.p169ad.views.viewpager.C8156a) r1
        L7c:
            r9 = r1
            int r1 = r12.getClientViewWidth()
            r11 = 1073741824(0x40000000, float:2.0)
            if (r1 > 0) goto L88
            r4 = 0
        L86:
            r10 = r4
            goto L95
        L88:
            float r4 = r3.f38190d
            float r4 = r11 - r4
            int r7 = r12.getPaddingLeft()
            float r7 = (float) r7
            float r10 = (float) r1
            float r7 = r7 / r10
            float r4 = r4 + r7
            goto L86
        L95:
            r7 = 0
            r4 = r12
            int r4 = r4.m50536a(r5, r6, r7, r8, r9, r10)
            float r5 = r3.f38190d
            int r9 = r4 + 1
            int r6 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r6 >= 0) goto Lab
            r6 = r12
            r7 = r2
            r8 = r13
            r10 = r1
            r11 = r5
            r6.m50539a(r7, r8, r9, r10, r11)
        Lab:
            r12.m50545a(r3, r4, r0)
            com.huawei.openalliance.ad.views.viewpager.f r13 = r12.f38226b
            int r0 = r12.f38221a
            java.lang.Object r1 = r3.f38187a
            r13.m50605b(r12, r0, r1)
        Lb7:
            r12.m50573j()
            return
        Lbb:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "populate exception"
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.views.viewpager.C8160e.m50582a(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m50583a(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.f38214Q
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6c
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r1
        L1b:
            if (r7 >= r6) goto L6c
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            com.huawei.openalliance.ad.views.viewpager.i r9 = (com.huawei.openalliance.p169ad.views.viewpager.C8164i) r9
            boolean r10 = r9.f38254b
            if (r10 != 0) goto L2c
            goto L69
        L2c:
            int r9 = r9.f38255c
            r9 = r9 & 7
            if (r9 == r2) goto L50
            r10 = 3
            if (r9 == r10) goto L4a
            r10 = 5
            if (r9 == r10) goto L3a
            r9 = r3
            goto L5d
        L3a:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
        L46:
            r11 = r9
            r9 = r3
            r3 = r11
            goto L5d
        L4a:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L5d
        L50:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
            goto L46
        L5d:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L68
            r8.offsetLeftAndRight(r3)
        L68:
            r3 = r9
        L69:
            int r7 = r7 + 1
            goto L1b
        L6c:
            r12.m50552b(r13, r14, r15)
            com.huawei.openalliance.ad.views.viewpager.h r13 = r12.f38216S
            if (r13 == 0) goto La0
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L7b:
            if (r1 >= r14) goto La0
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            com.huawei.openalliance.ad.views.viewpager.i r0 = (com.huawei.openalliance.p169ad.views.viewpager.C8164i) r0
            boolean r0 = r0.f38254b
            if (r0 == 0) goto L8c
            goto L9d
        L8c:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientViewWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            com.huawei.openalliance.ad.views.viewpager.h r3 = r12.f38216S
            r3.m50606a(r15, r0)
        L9d:
            int r1 = r1 + 1
            goto L7b
        La0:
            r12.f38211N = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.views.viewpager.C8160e.m50583a(int, float, int):void");
    }

    /* renamed from: a */
    public void m50584a(int i10, int i11, int i12) {
        int scrollX;
        if (getChildCount() == 0) {
            setScrollingCacheEnabledStatus(false);
            return;
        }
        Scroller scroller = this.f38234l;
        if (scroller == null || scroller.isFinished()) {
            scrollX = getScrollX();
        } else {
            scrollX = this.f38231i ? this.f38234l.getCurrX() : this.f38234l.getStartX();
            this.f38234l.abortAnimation();
            setScrollingCacheEnabledStatus(false);
        }
        int i13 = scrollX;
        int scrollY = getScrollY();
        int i14 = i10 - i13;
        int i15 = i11 - scrollY;
        if (i14 == 0 && i15 == 0) {
            m50546a(false);
            m50593b();
            setScrollState(0);
        } else {
            setScrollingCacheEnabledStatus(true);
            setScrollState(2);
            m50540a(i12, i13, scrollY, i14, i15);
        }
    }

    /* renamed from: a */
    private void m50538a(int i10, int i11, int i12, int i13) {
        int iMin;
        if (i11 <= 0 || this.f38235m.isEmpty()) {
            C8156a c8156aM50591b = m50591b(this.f38221a);
            iMin = (int) ((c8156aM50591b != null ? Math.min(c8156aM50591b.f38191e, this.f38242t) : 0.0f) * ((i10 - getPaddingLeft()) - getPaddingRight()));
            if (iMin == getScrollX()) {
                return;
            } else {
                m50546a(false);
            }
        } else if (!this.f38234l.isFinished()) {
            this.f38234l.setFinalX(getCurrentItem() * getClientViewWidth());
            return;
        } else {
            iMin = (int) ((getScrollX() / (((i11 - getPaddingLeft()) - getPaddingRight()) + i13)) * (((i10 - getPaddingLeft()) - getPaddingRight()) + i12));
        }
        scrollTo(iMin, getScrollY());
    }

    /* renamed from: a */
    private void m50539a(int i10, int i11, int i12, int i13, float f10) {
        C8156a c8156a = i12 < this.f38235m.size() ? this.f38235m.get(i12) : null;
        float paddingRight = i13 <= 0 ? 0.0f : 2.0f + (getPaddingRight() / i13);
        int i14 = this.f38221a;
        while (true) {
            i14++;
            if (i14 >= i10) {
                return;
            }
            if (f10 < paddingRight || i14 <= i11) {
                if (c8156a == null || i14 != c8156a.f38188b) {
                    C8156a c8156aM50579a = m50579a(i14, i12);
                    i12++;
                    f10 += c8156aM50579a.f38190d;
                    c8156a = i12 < this.f38235m.size() ? this.f38235m.get(i12) : null;
                } else {
                    f10 += c8156a.f38190d;
                    i12++;
                    if (i12 < this.f38235m.size()) {
                    }
                }
            } else {
                if (c8156a == null) {
                    return;
                }
                if (i14 == c8156a.f38188b && !c8156a.f38189c) {
                    this.f38235m.remove(i12);
                    this.f38226b.mo42549a(this, i14, c8156a.f38187a);
                    if (i12 < this.f38235m.size()) {
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m50540a(int i10, int i11, int i12, int i13, int i14) {
        int iAbs;
        int clientViewWidth = getClientViewWidth();
        int i15 = clientViewWidth / 2;
        float f10 = clientViewWidth;
        float f11 = i15;
        float fM50578a = f11 + (m50578a(Math.min(1.0f, (Math.abs(i13) * 1.0f) / f10)) * f11);
        int iAbs2 = Math.abs(i10);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fM50578a / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i13) / ((f10 * this.f38226b.m50598a(this.f38221a)) + this.f38244v)) + 1.0f) * 100.0f);
        }
        int iMin = Math.min(iAbs, 600);
        this.f38231i = false;
        this.f38234l.startScroll(i11, i12, i13, i14, iMin);
        postInvalidateOnAnimation();
    }

    /* renamed from: a */
    private void m50541a(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        C8156a c8156aM50580a;
        int i17 = (i15 - i11) - i13;
        for (int i18 = 0; i18 < i10; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                C8164i c8164i = (C8164i) childAt.getLayoutParams();
                if (!c8164i.f38254b && (c8156aM50580a = m50580a(childAt)) != null) {
                    float f10 = i17;
                    int i19 = ((int) (c8156aM50580a.f38191e * f10)) + i11;
                    if (c8164i.f38257e) {
                        c8164i.f38257e = false;
                        childAt.measure(View.MeasureSpec.makeMeasureSpec((int) (f10 * c8164i.f38256d), 1073741824), View.MeasureSpec.makeMeasureSpec((i16 - i12) - i14, 1073741824));
                    }
                    childAt.layout(i19, i12, childAt.getMeasuredWidth() + i19, childAt.getMeasuredHeight() + i12);
                }
            }
        }
    }

    /* renamed from: a */
    public void m50585a(int i10, boolean z10) {
        this.f38246x = false;
        m50586a(i10, z10, false);
    }

    /* renamed from: a */
    private void m50542a(int i10, boolean z10, int i11, boolean z11) {
        C8156a c8156aM50591b = m50591b(i10);
        int clientViewWidth = c8156aM50591b != null ? (int) (getClientViewWidth() * Math.max(this.f38241s, Math.min(c8156aM50591b.f38191e, this.f38242t))) : 0;
        if (z10) {
            m50584a(clientViewWidth, 0, i11);
            if (z11) {
                m50571h(i10);
                return;
            }
            return;
        }
        if (z11) {
            m50571h(i10);
        }
        m50546a(false);
        scrollTo(clientViewWidth, 0);
        m50567f(clientViewWidth);
    }

    /* renamed from: a */
    public void m50586a(int i10, boolean z10, boolean z11) {
        m50587a(i10, z10, z11, 0);
    }

    /* renamed from: a */
    public void m50587a(int i10, boolean z10, boolean z11, int i11) {
        AbstractC8161f abstractC8161f = this.f38226b;
        if (abstractC8161f == null || abstractC8161f.mo42547a() <= 0) {
            setScrollingCacheEnabledStatus(false);
            return;
        }
        if (!z11 && this.f38221a == i10 && this.f38235m.size() != 0) {
            setScrollingCacheEnabledStatus(false);
            return;
        }
        if (i10 < 0) {
            i10 = 0;
        } else if (i10 >= this.f38226b.mo42547a()) {
            i10 = this.f38226b.mo42547a() - 1;
        }
        int i12 = this.f38200C;
        int i13 = this.f38221a;
        if (i10 > i13 + i12 || i10 < i13 - i12) {
            for (int i14 = 0; i14 < this.f38235m.size(); i14++) {
                this.f38235m.get(i14).f38189c = true;
            }
        }
        boolean z12 = this.f38221a != i10;
        if (!this.f38210M) {
            m50582a(i10);
            m50542a(i10, z10, i11, z12);
        } else {
            this.f38221a = i10;
            if (z12) {
                m50571h(i10);
            }
            requestLayout();
        }
    }

    /* renamed from: a */
    private void m50543a(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        this.f38198A = x10;
        this.f38247y = x10;
        float y10 = motionEvent.getY();
        this.f38199B = y10;
        this.f38248z = y10;
        this.f38205H = motionEvent.getPointerId(0);
        this.f38212O = false;
        this.f38231i = true;
        this.f38234l.computeScrollOffset();
        if (this.f38225ae != 2 || Math.abs(this.f38234l.getFinalX() - this.f38234l.getCurrX()) <= this.f38218U) {
            m50546a(false);
            this.f38201D = false;
            return;
        }
        this.f38234l.abortAnimation();
        this.f38246x = false;
        m50593b();
        this.f38201D = true;
        m50562d(true);
        setScrollState(1);
    }

    /* renamed from: a */
    private void m50544a(C8156a c8156a, int i10, int i11, float f10) {
        int i12;
        int i13;
        int size = this.f38235m.size();
        float fM50598a = c8156a.f38191e;
        int i14 = c8156a.f38188b;
        int i15 = i14 - 1;
        this.f38241s = i14 == 0 ? fM50598a : -3.4028235E38f;
        int i16 = i11 - 1;
        this.f38242t = i14 == i16 ? (c8156a.f38190d + fM50598a) - 1.0f : Float.MAX_VALUE;
        int i17 = i10 - 1;
        while (i17 >= 0) {
            C8156a c8156a2 = this.f38235m.get(i17);
            while (true) {
                i13 = c8156a2.f38188b;
                if (i15 <= i13) {
                    break;
                }
                fM50598a -= this.f38226b.m50598a(i15) + f10;
                i15--;
            }
            fM50598a -= c8156a2.f38190d + f10;
            c8156a2.f38191e = fM50598a;
            if (i13 == 0) {
                this.f38241s = fM50598a;
            }
            i17--;
            i15--;
        }
        float fM50598a2 = c8156a.f38191e + c8156a.f38190d + f10;
        int i18 = c8156a.f38188b + 1;
        int i19 = i10 + 1;
        while (i19 < size) {
            C8156a c8156a3 = this.f38235m.get(i19);
            while (true) {
                i12 = c8156a3.f38188b;
                if (i18 >= i12) {
                    break;
                }
                fM50598a2 += this.f38226b.m50598a(i18) + f10;
                i18++;
            }
            if (i12 == i16) {
                this.f38242t = (c8156a3.f38190d + fM50598a2) - 1.0f;
            }
            c8156a3.f38191e = fM50598a2;
            fM50598a2 += c8156a3.f38190d + f10;
            i19++;
            i18++;
        }
    }

    /* renamed from: a */
    private void m50545a(C8156a c8156a, int i10, C8156a c8156a2) {
        C8156a c8156a3;
        C8156a c8156a4;
        int iMo42547a = this.f38226b.mo42547a();
        int clientViewWidth = getClientViewWidth();
        float f10 = clientViewWidth > 0 ? this.f38244v / clientViewWidth : 0.0f;
        if (c8156a2 != null) {
            int i11 = c8156a2.f38188b;
            int i12 = c8156a.f38188b;
            if (i11 < i12) {
                float fM50598a = c8156a2.f38191e + c8156a2.f38190d + f10;
                int i13 = i11 + 1;
                int i14 = 0;
                while (i13 <= c8156a.f38188b && i14 < this.f38235m.size()) {
                    while (true) {
                        c8156a4 = this.f38235m.get(i14);
                        if (i13 <= c8156a4.f38188b || i14 >= this.f38235m.size() - 1) {
                            break;
                        } else {
                            i14++;
                        }
                    }
                    while (i13 < c8156a4.f38188b) {
                        fM50598a += this.f38226b.m50598a(i13) + f10;
                        i13++;
                    }
                    c8156a4.f38191e = fM50598a;
                    fM50598a += c8156a4.f38190d + f10;
                    i13++;
                }
            } else if (i11 > i12) {
                int size = this.f38235m.size() - 1;
                float fM50598a2 = c8156a2.f38191e;
                while (true) {
                    i11--;
                    if (i11 < c8156a.f38188b || size < 0) {
                        break;
                    }
                    while (true) {
                        c8156a3 = this.f38235m.get(size);
                        if (i11 >= c8156a3.f38188b || size <= 0) {
                            break;
                        } else {
                            size--;
                        }
                    }
                    while (i11 > c8156a3.f38188b) {
                        fM50598a2 -= this.f38226b.m50598a(i11) + f10;
                        i11--;
                    }
                    fM50598a2 -= c8156a3.f38190d + f10;
                    c8156a3.f38191e = fM50598a2;
                }
            }
        }
        m50544a(c8156a, i10, iMo42547a, f10);
    }

    /* renamed from: a */
    public void m50588a(InterfaceC8159d interfaceC8159d) {
        if (this.f38215R == null) {
            this.f38215R = new ArrayList();
        }
        this.f38215R.add(interfaceC8159d);
    }

    /* renamed from: a */
    private void m50546a(boolean z10) {
        boolean z11 = this.f38225ae == 2;
        if (z11) {
            setScrollingCacheEnabledStatus(false);
            if (!this.f38234l.isFinished()) {
                this.f38234l.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f38234l.getCurrX();
                int currY = this.f38234l.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        m50567f(currX);
                    }
                }
            }
        }
        this.f38246x = false;
        for (int i10 = 0; i10 < this.f38235m.size(); i10++) {
            C8156a c8156a = this.f38235m.get(i10);
            if (c8156a.f38189c) {
                c8156a.f38189c = false;
                z11 = true;
            }
        }
        if (z11) {
            if (z10) {
                postOnAnimation(this.f38224ad);
            } else {
                this.f38224ad.run();
            }
        }
    }

    /* renamed from: a */
    private boolean m50547a(float f10, float f11) {
        return (f10 < ((float) this.f38203F) && f11 > 0.0f) || (f10 > ((float) (getWidth() - this.f38203F)) && f11 < 0.0f);
    }

    /* renamed from: a */
    private boolean m50548a(int i10, int i11, int i12, int i13, View view) {
        int i14;
        int i15 = i10 + i12;
        return i15 >= view.getLeft() && i15 < view.getRight() && (i14 = i11 + i13) >= view.getTop() && i14 < view.getBottom();
    }

    /* renamed from: a */
    private boolean m50549a(int i10, View view, boolean z10, View view2) {
        if (i10 == 17) {
            return (view == null || m50537a(this.f38238p, view2).left < m50537a(this.f38238p, view).left) ? view2.requestFocus() : m50596d();
        }
        if (i10 == 66) {
            return (view == null || m50537a(this.f38238p, view2).left > m50537a(this.f38238p, view).left) ? view2.requestFocus() : m50594c();
        }
        return z10;
    }

    /* renamed from: a */
    public boolean m50589a(KeyEvent keyEvent) {
        int i10;
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return m50595c(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return m50595c(1);
                        }
                    }
                } else {
                    if (keyEvent.hasModifiers(2)) {
                        return m50594c();
                    }
                    i10 = 66;
                }
            } else {
                if (keyEvent.hasModifiers(2)) {
                    return m50596d();
                }
                i10 = 17;
            }
            return m50595c(i10);
        }
        return false;
    }

    /* renamed from: a */
    private boolean m50550a(MotionEvent motionEvent, int i10) {
        int iFindPointerIndex = motionEvent.findPointerIndex(i10);
        float x10 = motionEvent.getX(iFindPointerIndex);
        float f10 = x10 - this.f38247y;
        float fAbs = Math.abs(f10);
        float y10 = motionEvent.getY(iFindPointerIndex);
        float fAbs2 = Math.abs(y10 - this.f38199B);
        if (f10 != 0.0f && !m50547a(this.f38247y, f10) && m50590a((View) this, false, (int) f10, (int) x10, (int) y10)) {
            this.f38247y = x10;
            this.f38248z = y10;
            this.f38212O = true;
            return true;
        }
        int i11 = this.f38204G;
        if (fAbs > i11 && fAbs * 0.5f > fAbs2) {
            this.f38201D = true;
            m50562d(true);
            setScrollState(1);
            float f11 = this.f38198A;
            float f12 = this.f38204G;
            this.f38247y = f10 > 0.0f ? f11 + f12 : f11 - f12;
            this.f38248z = y10;
            setScrollingCacheEnabledStatus(true);
        } else if (fAbs2 > i11) {
            this.f38212O = true;
        }
        if (!this.f38201D || !m50555b(x10)) {
            return false;
        }
        postInvalidateOnAnimation();
        return false;
    }

    /* renamed from: a */
    private boolean m50551a(MotionEvent motionEvent, boolean z10) {
        if (!this.f38201D) {
            return z10;
        }
        VelocityTracker velocityTracker = this.f38206I;
        velocityTracker.computeCurrentVelocity(1000, this.f38208K);
        int xVelocity = (int) velocityTracker.getXVelocity(this.f38205H);
        this.f38246x = true;
        int clientViewWidth = getClientViewWidth();
        int scrollX = getScrollX();
        C8156a c8156aM50576m = m50576m();
        if (c8156aM50576m == null) {
            return m50575l();
        }
        float f10 = clientViewWidth;
        m50587a(m50535a(c8156aM50576m.f38188b, ((scrollX / f10) - c8156aM50576m.f38191e) / (c8156aM50576m.f38190d + (this.f38244v / f10)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.f38205H)) - this.f38198A)), true, true, xVelocity);
        return m50575l();
    }

    /* renamed from: a */
    public boolean m50590a(View view, boolean z10, int i10, int i11, int i12) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (m50548a(i11, i12, scrollX, scrollY, childAt) && m50590a(childAt, true, i10, (i11 + scrollX) - childAt.getLeft(), (i12 + scrollY) - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z10 && view.canScrollHorizontally(-i10);
    }
}
