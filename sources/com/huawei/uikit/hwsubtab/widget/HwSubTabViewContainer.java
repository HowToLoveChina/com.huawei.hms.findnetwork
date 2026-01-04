package com.huawei.uikit.hwsubtab.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.huawei.uikit.animations.interpolator.HwFastOutSlowInInterpolator;
import com.huawei.uikit.hwcommon.anim.HwFocusAnimatorUtil;
import com.huawei.uikit.hwhorizontalscrollview.widget.HwHorizontalScrollView;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;
import com.huawei.uikit.hwsubtab.C8735R;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class HwSubTabViewContainer extends HwHorizontalScrollView {

    /* renamed from: o */
    private static final String f44236o = "HwSubTabViewContainer";

    /* renamed from: p */
    private static final int f44237p = 200;

    /* renamed from: q */
    private static final int f44238q = 2;

    /* renamed from: r */
    private static final int f44239r = -1;

    /* renamed from: s */
    private static final float f44240s = 0.5f;

    /* renamed from: t */
    private static final int f44241t = 20;

    /* renamed from: a */
    private SlidingTabStrip f44242a;

    /* renamed from: b */
    private ValueAnimator f44243b;

    /* renamed from: c */
    private int f44244c;

    /* renamed from: d */
    private int f44245d;

    /* renamed from: e */
    private int f44246e;

    /* renamed from: f */
    private boolean f44247f;

    /* renamed from: g */
    private boolean f44248g;

    /* renamed from: h */
    private int f44249h;

    /* renamed from: i */
    private int f44250i;

    /* renamed from: j */
    private int f44251j;

    /* renamed from: k */
    private ChildPaddingClient f44252k;

    /* renamed from: l */
    private int f44253l;

    /* renamed from: m */
    private int f44254m;

    /* renamed from: n */
    private boolean f44255n;

    public class ChildPaddingClient {
        public ChildPaddingClient() {
        }

        public void setHeadlinePadding(View view) {
            view.setPadding(HwSubTabViewContainer.this.f44246e - HwSubTabViewContainer.this.f44244c, 0, HwSubTabViewContainer.this.f44245d - HwSubTabViewContainer.this.f44244c, 0);
        }

        public void setPadding(View view, boolean z10) {
            if (z10 && HwSubTabViewContainer.this.f44255n) {
                int i10 = HwSubTabViewContainer.this.f44245d - HwSubTabViewContainer.this.f44244c;
                view.setPadding(i10, 0, i10, 0);
            } else {
                int i11 = -HwSubTabViewContainer.this.f44244c;
                view.setPadding(i11, 0, i11, 0);
            }
        }
    }

    public static class SlidingTabStrip extends LinearLayout {

        /* renamed from: a */
        int f44257a;

        /* renamed from: b */
        float f44258b;

        /* renamed from: c */
        private Drawable f44259c;

        /* renamed from: d */
        private int f44260d;

        /* renamed from: e */
        private int f44261e;

        /* renamed from: f */
        private final Paint f44262f;

        /* renamed from: g */
        private int f44263g;

        /* renamed from: h */
        private int f44264h;

        /* renamed from: i */
        private int f44265i;

        /* renamed from: j */
        private ValueAnimator f44266j;

        /* renamed from: k */
        private SlidingTabStripClient f44267k;

        /* renamed from: l */
        private boolean f44268l;

        public class bzrwd extends AnimatorListenerAdapter {

            /* renamed from: a */
            final /* synthetic */ int f44269a;

            public bzrwd(int i10) {
                this.f44269a = i10;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SlidingTabStrip slidingTabStrip = SlidingTabStrip.this;
                slidingTabStrip.f44257a = this.f44269a;
                slidingTabStrip.f44258b = 0.0f;
            }
        }

        public SlidingTabStrip(Context context) {
            super(context);
            this.f44257a = -1;
            this.f44263g = -1;
            this.f44264h = -1;
            this.f44265i = -1;
            this.f44268l = true;
            setWillNotDraw(false);
            this.f44262f = new Paint();
            this.f44259c = ContextCompat.getDrawable(context, C8735R.drawable.hwsubtab_underline);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public boolean m55567b() {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                if (childAt != null && childAt.getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: c */
        private void m55568c() {
            int left;
            int right;
            if (this.f44267k == null) {
                Log.e(HwSubTabViewContainer.f44236o, "updateIndicatorPosition mSlidingTabStripClient is empty");
                return;
            }
            View childAt = getChildAt(this.f44257a);
            if (childAt == null || childAt.getWidth() <= 0) {
                left = -1;
                right = -1;
            } else {
                left = childAt.getLeft() + this.f44267k.getTextPaddingLeft(childAt);
                right = childAt.getRight() - this.f44267k.getTextPaddingRight(childAt);
                if (this.f44258b > 0.0f && this.f44257a < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f44257a + 1);
                    int left2 = childAt2.getLeft() + this.f44267k.getTextPaddingLeft(childAt2);
                    int right2 = childAt2.getRight() - this.f44267k.getTextPaddingRight(childAt2);
                    float f10 = this.f44258b;
                    float f11 = 1.0f - f10;
                    left = (int) ((left2 * f10) + (left * f11));
                    right = (int) ((f10 * right2) + (f11 * right));
                }
            }
            m55571b(left, right);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
            View childAt = getChildAt(this.f44257a);
            if (hasFocus() || childAt == null) {
                super.addFocusables(arrayList, i10, i11);
            } else if (!childAt.isFocusable()) {
                super.addFocusables(arrayList, i10, i11);
            } else if (arrayList != null) {
                arrayList.add(childAt);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
        @Override // android.view.View
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void draw(android.graphics.Canvas r6) {
            /*
                r5 = this;
                super.draw(r6)
                if (r6 != 0) goto Ld
                java.lang.String r5 = "HwSubTabViewContainer"
                java.lang.String r6 = "Parameter canvas of draw should not be null."
                android.util.Log.w(r5, r6)
                return
            Ld:
                int r0 = r5.f44257a
                r1 = -1
                r2 = 0
                if (r0 == r1) goto L2b
                android.view.View r0 = r5.getChildAt(r0)
                boolean r1 = r0 instanceof android.widget.TextView
                if (r1 == 0) goto L2b
                android.widget.TextView r0 = (android.widget.TextView) r0
                android.text.Layout r1 = r0.getLayout()
                if (r1 == 0) goto L2b
                int r0 = r0.getTotalPaddingBottom()
                int r1 = r5.f44261e
                int r0 = r0 - r1
                goto L2c
            L2b:
                r0 = r2
            L2c:
                int r1 = r5.f44264h
                if (r1 < 0) goto L56
                int r3 = r5.f44265i
                if (r3 <= r1) goto L56
                android.graphics.drawable.Drawable r4 = r5.f44259c
                int r3 = r3 - r1
                int r1 = r5.f44260d
                r4.setBounds(r2, r2, r3, r1)
                r6.save()
                int r1 = r5.f44264h
                float r1 = (float) r1
                int r2 = r5.getHeight()
                int r3 = r5.f44260d
                int r2 = r2 - r3
                int r2 = r2 - r0
                float r0 = (float) r2
                r6.translate(r1, r0)
                android.graphics.drawable.Drawable r5 = r5.f44259c
                r5.draw(r6)
                r6.restore()
            L56:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwsubtab.widget.HwSubTabViewContainer.SlidingTabStrip.draw(android.graphics.Canvas):void");
        }

        public int getSelectedIndicatorHeight() {
            return this.f44260d;
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            super.onLayout(z10, i10, i11, i12, i13);
            ValueAnimator valueAnimator = this.f44266j;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                m55568c();
                return;
            }
            this.f44266j.cancel();
            m55570a(this.f44257a, Math.round((1.0f - this.f44266j.getAnimatedFraction()) * this.f44266j.getDuration()));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i10) {
            super.onRtlPropertiesChanged(i10);
        }

        public void setSelectedIndicatorColor(int i10) {
            this.f44259c.setTint(i10);
            this.f44262f.setColor(i10);
            m55560a();
        }

        public void setSelectedIndicatorHeight(int i10) {
            if (this.f44260d != i10) {
                this.f44260d = i10;
                m55560a();
            }
        }

        public void setSelectedIndicatorMargin(int i10) {
            if (this.f44261e != i10) {
                this.f44261e = i10;
                m55560a();
            }
        }

        public void setSlidingTabStripClient(SlidingTabStripClient slidingTabStripClient) {
            this.f44267k = slidingTabStripClient;
        }

        /* renamed from: b */
        public void m55571b(int i10, int i11) {
            if (i10 == this.f44264h && i11 == this.f44265i) {
                return;
            }
            this.f44264h = i10;
            this.f44265i = i11;
            m55560a();
        }

        /* renamed from: a */
        private void m55560a() {
            if (!this.f44268l) {
                postInvalidate();
            } else {
                postInvalidateOnAnimation();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m55561a(int i10, float f10) {
            ValueAnimator valueAnimator = this.f44266j;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f44266j.cancel();
            }
            this.f44257a = i10;
            this.f44258b = f10;
            m55568c();
        }

        /* renamed from: a */
        public void m55570a(int i10, int i11) {
            ValueAnimator valueAnimator = this.f44266j;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f44266j.cancel();
                this.f44257a = i10;
            }
            View childAt = getChildAt(i10);
            if (childAt == null) {
                m55568c();
                return;
            }
            if (this.f44267k == null) {
                Log.e(HwSubTabViewContainer.f44236o, "animateIndicatorToPosition mSlidingTabStripClient is empty");
                return;
            }
            final int left = childAt.getLeft() + this.f44267k.getTextPaddingLeft(childAt);
            final int right = childAt.getRight() - this.f44267k.getTextPaddingRight(childAt);
            final int left2 = childAt.getLeft() + this.f44267k.getTextPaddingLeft(childAt);
            final int right2 = childAt.getRight() - this.f44267k.getTextPaddingRight(childAt);
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f44266j = valueAnimator2;
            valueAnimator2.setInterpolator(new HwFastOutSlowInInterpolator());
            this.f44266j.setDuration(i11);
            this.f44266j.setFloatValues(0.0f, 1.0f);
            this.f44266j.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huawei.uikit.hwsubtab.widget.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    this.f44343a.m55562a(left2, left, right2, right, valueAnimator3);
                }
            });
            this.f44266j.addListener(new bzrwd(i10));
            this.f44266j.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m55562a(int i10, int i11, int i12, int i13, ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.w(HwSubTabViewContainer.f44236o, "Object animator in animateIndicatorToPosition should not be null.");
            } else {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                m55571b(m55569a(i10, i11, animatedFraction), m55569a(i12, i13, animatedFraction));
            }
        }

        /* renamed from: a */
        public int m55569a(int i10, int i11, float f10) {
            return i10 + Math.round(f10 * (i11 - i10));
        }
    }

    public class SlidingTabStripClient {
        public SlidingTabStripClient() {
        }

        public int getTextPaddingLeft(View view) {
            return view.getPaddingLeft();
        }

        public int getTextPaddingRight(View view) {
            return view.getPaddingRight();
        }
    }

    public class bzrwd implements ValueAnimator.AnimatorUpdateListener {
        public bzrwd() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                Log.w(HwSubTabViewContainer.f44236o, "Object animator in method ensureScrollAnimator should not be null.");
            } else {
                HwSubTabViewContainer.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
            }
        }
    }

    public HwSubTabViewContainer(Context context) {
        this(context, null);
    }

    public void animateToTab(int i10) {
        if (i10 == -1) {
            return;
        }
        if (getWindowToken() == null || this.f44242a.m55567b()) {
            setScrollPosition(i10, 0.0f);
            return;
        }
        int scrollX = getScrollX();
        int iM55551a = m55551a(i10, 0.0f);
        if (!this.f44248g) {
            scrollTo(iM55551a, 0);
            setScrollPosition(i10, 0.0f);
            return;
        }
        if (scrollX != iM55551a) {
            m55553a();
            this.f44243b.setIntValues(scrollX, iM55551a);
            this.f44243b.start();
        }
        this.f44242a.m55570a(i10, 200);
    }

    @Override // android.widget.HorizontalScrollView
    public boolean arrowScroll(int i10) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        if (FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i10) == null) {
            return false;
        }
        return super.arrowScroll(i10);
    }

    public boolean canScroll() {
        View childAt = getChildAt(0);
        ViewParent parent = getParent();
        if (childAt == null || !(parent instanceof ViewGroup)) {
            return false;
        }
        return getMeasuredWidth() < (childAt.getMeasuredWidth() + getPaddingStart()) + getPaddingEnd() || getMeasuredWidth() > ((ViewGroup) parent).getMeasuredWidth();
    }

    public int getFadingMargin() {
        return this.f44245d;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public float getLeftFadingEdgeStrength() {
        int i10 = this.f44250i;
        return (i10 == 0 || i10 == 1) ? 1.0f : 0.0f;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public float getRightFadingEdgeStrength() {
        int i10 = this.f44250i;
        return (i10 == 0 || i10 == 1) ? 1.0f : 0.0f;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.f44251j;
    }

    public int getStartOriginPadding() {
        return this.f44246e;
    }

    public int getStartScrollPadding() {
        return this.f44249h;
    }

    public int getSubTabItemMargin() {
        return this.f44244c;
    }

    public SlidingTabStrip getTabStrip() {
        return this.f44242a;
    }

    public void initChildPaddingClient() {
        this.f44252k = new ChildPaddingClient();
    }

    public void initSlidingTabStripClient() {
        this.f44242a.setSlidingTabStripClient(new SlidingTabStripClient());
    }

    public boolean isOverScreen() {
        return this.f44255n;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f44247f) {
            HwFocusAnimatorUtil.disableViewClipChildren(getParent());
        }
    }

    @Override // com.huawei.uikit.hwhorizontalscrollview.widget.HwHorizontalScrollView, android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (getOverScroller() == null || (getOverScroller().isFinished() && !isSpringBack())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int iMax;
        super.onLayout(z10, i10, i11, i12, i13);
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        if (!isLaidOut() && m55556b() && (getScrollX() != (iMax = Math.max(0, childAt.getMeasuredWidth() - (((i12 - i10) - getPaddingLeft()) - getPaddingRight()))) || this.f44253l == 0)) {
            int i14 = this.f44253l;
            if (i14 != -1) {
                scrollTo(i14, getScrollY());
            } else {
                scrollTo(iMax, getScrollY());
            }
        }
        if (this.f44250i == 1) {
            this.f44252k.setHeadlinePadding(childAt);
            if (!canScroll()) {
                setHorizontalFadingEdgeEnabled(false);
                return;
            } else {
                setHorizontalFadingEdgeEnabled(true);
                setFadingEdgeLength(this.f44245d);
                return;
            }
        }
        if (!canScroll()) {
            setHorizontalFadingEdgeEnabled(false);
            this.f44252k.setPadding(childAt, false);
        } else {
            this.f44252k.setPadding(childAt, true);
            setHorizontalFadingEdgeEnabled(true);
            setFadingEdgeLength(this.f44245d);
        }
    }

    @Override // android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        this.f44253l = i10;
        super.onScrollChanged(i10, i11, i12, i13);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (m55556b()) {
            scrollTo(getScrollX() - (i10 - i12), getScrollY());
        }
    }

    @Override // com.huawei.uikit.hwhorizontalscrollview.widget.HwHorizontalScrollView, android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (canScroll()) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setAnimationEnabled(boolean z10) {
        this.f44248g = z10;
        SlidingTabStrip slidingTabStrip = this.f44242a;
        if (slidingTabStrip != null) {
            slidingTabStrip.f44268l = z10;
        }
    }

    public void setAppearance(int i10) {
        this.f44250i = i10;
    }

    public void setChildPaddingClient(ChildPaddingClient childPaddingClient) {
        this.f44252k = childPaddingClient;
    }

    public void setFadingMargin(int i10) {
        this.f44245d = i10;
    }

    public void setItemPadding(int i10, int i11) {
        this.f44246e = i10;
        this.f44254m = i11;
    }

    public void setMirrorScrollX(int i10) {
        this.f44253l = i10;
    }

    public void setOverScreen(boolean z10) {
        this.f44255n = z10;
    }

    public void setScrollPosition(int i10, float f10) {
        setScrollPosition(i10, f10, true);
    }

    public void setStartOriginPadding(int i10) {
        this.f44246e = i10;
    }

    public void setStartScrollPadding(int i10) {
        this.f44249h = i10;
    }

    public void setSubTabFaddingEdgeColor(int i10) {
        this.f44251j = i10;
    }

    public void setSubTabItemMargin(int i10) {
        this.f44244c = i10;
        View childAt = getChildAt(0);
        if (this.f44250i == 1) {
            int i11 = this.f44246e;
            int i12 = this.f44244c;
            childAt.setPadding(i11 - i12, 0, this.f44245d - i12, 0);
        } else if (canScroll()) {
            int i13 = this.f44245d - this.f44244c;
            childAt.setPadding(i13, 0, i13, 0);
        }
    }

    public HwSubTabViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f44247f = false;
        this.f44248g = true;
        this.f44249h = 20;
        this.f44250i = 0;
        this.f44253l = -1;
        this.f44254m = 0;
        this.f44255n = false;
        m55554a(context);
    }

    /* renamed from: a */
    private void m55554a(Context context) {
        setHorizontalScrollBarEnabled(false);
        setOverScrollMode(0);
        initChildPaddingClient();
        this.f44242a = new SlidingTabStrip(context);
        initSlidingTabStripClient();
        super.addView(this.f44242a, 0, new FrameLayout.LayoutParams(-2, -1));
        this.f44245d = getResources().getDimensionPixelSize(C8735R.dimen.hwsubtab_fading_margin);
        this.f44246e = getResources().getDimensionPixelSize(C8735R.dimen.hwsubtab_padding_start);
        if (HwWidgetInstantiator.getCurrnetType(context) == 2) {
            this.f44247f = true;
        }
    }

    /* renamed from: b */
    private boolean m55556b() {
        return getLayoutDirection() == 1;
    }

    public void setScrollPosition(int i10, float f10, boolean z10) {
        int iRound = Math.round(i10 + f10);
        if (iRound < 0 || iRound >= this.f44242a.getChildCount()) {
            return;
        }
        if (z10) {
            this.f44242a.m55561a(i10, f10);
        }
        ValueAnimator valueAnimator = this.f44243b;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f44243b.cancel();
        }
        scrollTo(m55551a(i10, f10), 0);
    }

    public HwSubTabViewContainer(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f44247f = false;
        this.f44248g = true;
        this.f44249h = 20;
        this.f44250i = 0;
        this.f44253l = -1;
        this.f44254m = 0;
        this.f44255n = false;
        m55554a(context);
    }

    /* renamed from: a */
    private void m55553a() {
        if (this.f44243b == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f44243b = valueAnimator;
            valueAnimator.setInterpolator(new HwFastOutSlowInInterpolator());
            this.f44243b.setDuration(200L);
            this.f44243b.addUpdateListener(new bzrwd());
        }
    }

    /* renamed from: a */
    private int m55551a(int i10, float f10) {
        int i11;
        float f11;
        int left;
        int width;
        View childAt = this.f44242a.getChildAt(i10);
        int i12 = i10 + 1;
        KeyEvent.Callback childAt2 = i12 < this.f44242a.getChildCount() ? this.f44242a.getChildAt(i12) : null;
        TextView textView = childAt instanceof TextView ? (TextView) childAt : null;
        TextView textView2 = childAt2 instanceof TextView ? (TextView) childAt2 : null;
        int left2 = 0;
        int width2 = textView != null ? textView.getWidth() : 0;
        int width3 = textView2 != null ? textView2.getWidth() : 0;
        if (textView != null) {
            if (this.f44250i == 1) {
                if (m55556b()) {
                    int right = textView.getRight() + m55559a(this.f44249h);
                    int i13 = this.f44244c;
                    left = right + i13 + i13;
                    width = getWidth();
                } else {
                    left = textView.getLeft() - m55559a(this.f44249h);
                    int i14 = this.f44244c;
                    width = i14 + i14;
                }
                left2 = left - width;
                int i15 = this.f44244c;
                f11 = width2 + i15 + i15;
            } else {
                left2 = (textView.getLeft() + (width2 / 2)) - (getWidth() / 2);
                float f12 = (width2 + width3) * f44240s;
                int i16 = this.f44244c;
                f11 = f12 + i16 + i16;
            }
            i11 = (int) (f11 * f10);
        } else {
            i11 = 0;
        }
        return getLayoutDirection() == 0 ? left2 + i11 : left2 - i11;
    }

    /* renamed from: a */
    public int m55559a(int i10) {
        return Math.round(getResources().getDisplayMetrics().density * i10);
    }
}
