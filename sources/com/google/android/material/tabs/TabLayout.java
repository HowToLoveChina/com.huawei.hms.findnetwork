package com.google.android.material.tabs;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.C0531i0;
import androidx.core.widget.C0669j;
import androidx.viewpager.widget.AbstractC0984a;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.badge.C1652a;
import com.google.android.material.badge.C1653b;
import com.google.android.material.internal.C1784o;
import com.google.android.material.internal.C1788s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import p211d.C8968a;
import p243e0.C9371f;
import p243e0.C9372g;
import p243e0.InterfaceC9370e;
import p273f0.C9598f0;
import p273f0.C9603h0;
import p273f0.C9620q;
import p276f3.C9649c;
import p304g0.C9832l;
import p307g3.C9876b;
import p356i3.C10427h;
import p356i3.C10428i;
import p416k3.C10981a;
import p666u2.C13110a;
import p757x.C13669a;

@ViewPager.InterfaceC0976e
/* loaded from: classes.dex */
public class TabLayout extends HorizontalScrollView {

    /* renamed from: R */
    public static final int f8699R = R$style.Widget_Design_TabLayout;

    /* renamed from: S */
    public static final InterfaceC9370e<C1847f> f8700S = new C9372g(16);

    /* renamed from: A */
    public boolean f8701A;

    /* renamed from: B */
    public boolean f8702B;

    /* renamed from: C */
    public int f8703C;

    /* renamed from: D */
    public int f8704D;

    /* renamed from: E */
    public boolean f8705E;

    /* renamed from: F */
    public C1852c f8706F;

    /* renamed from: G */
    public InterfaceC1844c f8707G;

    /* renamed from: H */
    public final ArrayList<InterfaceC1844c> f8708H;

    /* renamed from: I */
    public InterfaceC1844c f8709I;

    /* renamed from: J */
    public ValueAnimator f8710J;

    /* renamed from: K */
    public ViewPager f8711K;

    /* renamed from: L */
    public AbstractC0984a f8712L;

    /* renamed from: M */
    public DataSetObserver f8713M;

    /* renamed from: N */
    public C1848g f8714N;

    /* renamed from: O */
    public C1843b f8715O;

    /* renamed from: P */
    public boolean f8716P;

    /* renamed from: Q */
    public final InterfaceC9370e<TabView> f8717Q;

    /* renamed from: a */
    public final ArrayList<C1847f> f8718a;

    /* renamed from: b */
    public C1847f f8719b;

    /* renamed from: c */
    public final SlidingTabIndicator f8720c;

    /* renamed from: d */
    public int f8721d;

    /* renamed from: e */
    public int f8722e;

    /* renamed from: f */
    public int f8723f;

    /* renamed from: g */
    public int f8724g;

    /* renamed from: h */
    public int f8725h;

    /* renamed from: i */
    public ColorStateList f8726i;

    /* renamed from: j */
    public ColorStateList f8727j;

    /* renamed from: k */
    public ColorStateList f8728k;

    /* renamed from: l */
    public Drawable f8729l;

    /* renamed from: m */
    public int f8730m;

    /* renamed from: n */
    public PorterDuff.Mode f8731n;

    /* renamed from: o */
    public float f8732o;

    /* renamed from: p */
    public float f8733p;

    /* renamed from: q */
    public final int f8734q;

    /* renamed from: r */
    public int f8735r;

    /* renamed from: s */
    public final int f8736s;

    /* renamed from: t */
    public final int f8737t;

    /* renamed from: u */
    public final int f8738u;

    /* renamed from: v */
    public int f8739v;

    /* renamed from: w */
    public int f8740w;

    /* renamed from: x */
    public int f8741x;

    /* renamed from: y */
    public int f8742y;

    /* renamed from: z */
    public int f8743z;

    public class SlidingTabIndicator extends LinearLayout {

        /* renamed from: a */
        public ValueAnimator f8744a;

        /* renamed from: b */
        public int f8745b;

        /* renamed from: c */
        public float f8746c;

        /* renamed from: d */
        public int f8747d;

        /* renamed from: com.google.android.material.tabs.TabLayout$SlidingTabIndicator$a */
        public class C1839a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a */
            public final /* synthetic */ View f8749a;

            /* renamed from: b */
            public final /* synthetic */ View f8750b;

            public C1839a(View view, View view2) {
                this.f8749a = view;
                this.f8750b = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SlidingTabIndicator.this.m11096h(this.f8749a, this.f8750b, valueAnimator.getAnimatedFraction());
            }
        }

        /* renamed from: com.google.android.material.tabs.TabLayout$SlidingTabIndicator$b */
        public class C1840b extends AnimatorListenerAdapter {

            /* renamed from: a */
            public final /* synthetic */ int f8752a;

            public C1840b(int i10) {
                this.f8752a = i10;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SlidingTabIndicator.this.f8745b = this.f8752a;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SlidingTabIndicator.this.f8745b = this.f8752a;
            }
        }

        public SlidingTabIndicator(Context context) {
            super(context);
            this.f8745b = -1;
            this.f8747d = -1;
            setWillNotDraw(false);
        }

        /* renamed from: c */
        public void m11091c(int i10, int i11) {
            ValueAnimator valueAnimator = this.f8744a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f8744a.cancel();
            }
            m11097i(true, i10, i11);
        }

        /* renamed from: d */
        public boolean m11092d() {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (getChildAt(i10).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int height;
            int iHeight = TabLayout.this.f8729l.getBounds().height();
            if (iHeight < 0) {
                iHeight = TabLayout.this.f8729l.getIntrinsicHeight();
            }
            int i10 = TabLayout.this.f8742y;
            if (i10 == 0) {
                height = getHeight() - iHeight;
                iHeight = getHeight();
            } else if (i10 != 1) {
                height = 0;
                if (i10 != 2) {
                    iHeight = i10 != 3 ? 0 : getHeight();
                }
            } else {
                height = (getHeight() - iHeight) / 2;
                iHeight = (getHeight() + iHeight) / 2;
            }
            if (TabLayout.this.f8729l.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.f8729l.getBounds();
                TabLayout.this.f8729l.setBounds(bounds.left, height, bounds.right, iHeight);
                TabLayout tabLayout = TabLayout.this;
                Drawable drawableM82231l = tabLayout.f8729l;
                if (tabLayout.f8730m != 0) {
                    drawableM82231l = C13669a.m82231l(drawableM82231l);
                    C13669a.m82227h(drawableM82231l, TabLayout.this.f8730m);
                } else {
                    C13669a.m82228i(drawableM82231l, null);
                }
                drawableM82231l.draw(canvas);
            }
            super.draw(canvas);
        }

        /* renamed from: e */
        public final void m11093e() {
            View childAt = getChildAt(this.f8745b);
            C1852c c1852c = TabLayout.this.f8706F;
            TabLayout tabLayout = TabLayout.this;
            c1852c.m11150c(tabLayout, childAt, tabLayout.f8729l);
        }

        /* renamed from: f */
        public void m11094f(int i10, float f10) {
            ValueAnimator valueAnimator = this.f8744a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f8744a.cancel();
            }
            this.f8745b = i10;
            this.f8746c = f10;
            m11096h(getChildAt(i10), getChildAt(this.f8745b + 1), this.f8746c);
        }

        /* renamed from: g */
        public void m11095g(int i10) {
            Rect bounds = TabLayout.this.f8729l.getBounds();
            TabLayout.this.f8729l.setBounds(bounds.left, 0, bounds.right, i10);
            requestLayout();
        }

        /* renamed from: h */
        public final void m11096h(View view, View view2, float f10) {
            if (view == null || view.getWidth() <= 0) {
                Drawable drawable = TabLayout.this.f8729l;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.f8729l.getBounds().bottom);
            } else {
                C1852c c1852c = TabLayout.this.f8706F;
                TabLayout tabLayout = TabLayout.this;
                c1852c.mo11147d(tabLayout, view, view2, f10, tabLayout.f8729l);
            }
            C9603h0.m59884g0(this);
        }

        /* renamed from: i */
        public final void m11097i(boolean z10, int i10, int i11) {
            View childAt = getChildAt(this.f8745b);
            View childAt2 = getChildAt(i10);
            if (childAt2 == null) {
                m11093e();
                return;
            }
            C1839a c1839a = new C1839a(childAt, childAt2);
            if (!z10) {
                this.f8744a.removeAllUpdateListeners();
                this.f8744a.addUpdateListener(c1839a);
                return;
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f8744a = valueAnimator;
            valueAnimator.setInterpolator(C13110a.f59598b);
            valueAnimator.setDuration(i11);
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(c1839a);
            valueAnimator.addListener(new C1840b(i10));
            valueAnimator.start();
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            super.onLayout(z10, i10, i11, i12, i13);
            ValueAnimator valueAnimator = this.f8744a;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                m11093e();
            } else {
                m11097i(false, this.f8745b, -1);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (View.MeasureSpec.getMode(i10) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f8740w == 1 || tabLayout.f8743z == 2) {
                int childCount = getChildCount();
                int iMax = 0;
                for (int i12 = 0; i12 < childCount; i12++) {
                    View childAt = getChildAt(i12);
                    if (childAt.getVisibility() == 0) {
                        iMax = Math.max(iMax, childAt.getMeasuredWidth());
                    }
                }
                if (iMax <= 0) {
                    return;
                }
                if (iMax * childCount <= getMeasuredWidth() - (((int) C1788s.m10782c(getContext(), 16)) * 2)) {
                    boolean z10 = false;
                    for (int i13 = 0; i13 < childCount; i13++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i13).getLayoutParams();
                        if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                            layoutParams.width = iMax;
                            layoutParams.weight = 0.0f;
                            z10 = true;
                        }
                    }
                    if (!z10) {
                        return;
                    }
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.f8740w = 0;
                    tabLayout2.m11065O(false);
                }
                super.onMeasure(i10, i11);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i10) {
            super.onRtlPropertiesChanged(i10);
        }
    }

    public final class TabView extends LinearLayout {

        /* renamed from: a */
        public C1847f f8754a;

        /* renamed from: b */
        public TextView f8755b;

        /* renamed from: c */
        public ImageView f8756c;

        /* renamed from: d */
        public View f8757d;

        /* renamed from: e */
        public C1652a f8758e;

        /* renamed from: f */
        public View f8759f;

        /* renamed from: g */
        public TextView f8760g;

        /* renamed from: h */
        public ImageView f8761h;

        /* renamed from: i */
        public Drawable f8762i;

        /* renamed from: j */
        public int f8763j;

        /* renamed from: com.google.android.material.tabs.TabLayout$TabView$a */
        public class ViewOnLayoutChangeListenerC1841a implements View.OnLayoutChangeListener {

            /* renamed from: a */
            public final /* synthetic */ View f8765a;

            public ViewOnLayoutChangeListenerC1841a(View view) {
                this.f8765a = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                if (this.f8765a.getVisibility() == 0) {
                    TabView.this.m11116s(this.f8765a);
                }
            }
        }

        public TabView(Context context) {
            super(context);
            this.f8763j = 2;
            m11118u(context);
            C9603h0.m59839D0(this, TabLayout.this.f8721d, TabLayout.this.f8722e, TabLayout.this.f8723f, TabLayout.this.f8724g);
            setGravity(17);
            setOrientation(!TabLayout.this.f8701A ? 1 : 0);
            setClickable(true);
            C9603h0.m59841E0(this, C9598f0.m59824b(getContext(), 1002));
        }

        private C1652a getBadge() {
            return this.f8758e;
        }

        private C1652a getOrCreateBadge() {
            if (this.f8758e == null) {
                this.f8758e = C1652a.m9670c(getContext());
            }
            m11115r();
            C1652a c1652a = this.f8758e;
            if (c1652a != null) {
                return c1652a;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        @Override // android.view.ViewGroup, android.view.View
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f8762i;
            if (drawable != null && drawable.isStateful() && this.f8762i.setState(drawableState)) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        /* renamed from: f */
        public final void m11103f(View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC1841a(view));
        }

        /* renamed from: g */
        public final float m11104g(Layout layout, int i10, float f10) {
            return layout.getLineWidth(i10) * (f10 / layout.getPaint().getTextSize());
        }

        public int getContentHeight() {
            View[] viewArr = {this.f8755b, this.f8756c, this.f8759f};
            int iMax = 0;
            int iMin = 0;
            boolean z10 = false;
            for (int i10 = 0; i10 < 3; i10++) {
                View view = viewArr[i10];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z10 ? Math.min(iMin, view.getTop()) : view.getTop();
                    iMax = z10 ? Math.max(iMax, view.getBottom()) : view.getBottom();
                    z10 = true;
                }
            }
            return iMax - iMin;
        }

        public int getContentWidth() {
            View[] viewArr = {this.f8755b, this.f8756c, this.f8759f};
            int iMax = 0;
            int iMin = 0;
            boolean z10 = false;
            for (int i10 = 0; i10 < 3; i10++) {
                View view = viewArr[i10];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z10 ? Math.min(iMin, view.getLeft()) : view.getLeft();
                    iMax = z10 ? Math.max(iMax, view.getRight()) : view.getRight();
                    z10 = true;
                }
            }
            return iMax - iMin;
        }

        public C1847f getTab() {
            return this.f8754a;
        }

        /* renamed from: h */
        public final void m11105h(boolean z10) {
            setClipChildren(z10);
            setClipToPadding(z10);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z10);
                viewGroup.setClipToPadding(z10);
            }
        }

        /* renamed from: i */
        public final FrameLayout m11106i() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* renamed from: j */
        public final void m11107j(Canvas canvas) {
            Drawable drawable = this.f8762i;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f8762i.draw(canvas);
            }
        }

        /* renamed from: k */
        public final FrameLayout m11108k(View view) {
            if ((view == this.f8756c || view == this.f8755b) && C1653b.f7497a) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        /* renamed from: l */
        public final boolean m11109l() {
            return this.f8758e != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: m */
        public final void m11110m() {
            FrameLayout frameLayoutM11106i;
            if (C1653b.f7497a) {
                frameLayoutM11106i = m11106i();
                addView(frameLayoutM11106i, 0);
            } else {
                frameLayoutM11106i = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_icon, (ViewGroup) frameLayoutM11106i, false);
            this.f8756c = imageView;
            frameLayoutM11106i.addView(imageView, 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: n */
        public final void m11111n() {
            FrameLayout frameLayoutM11106i;
            if (C1653b.f7497a) {
                frameLayoutM11106i = m11106i();
                addView(frameLayoutM11106i);
            } else {
                frameLayoutM11106i = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_text, (ViewGroup) frameLayoutM11106i, false);
            this.f8755b = textView;
            frameLayoutM11106i.addView(textView);
        }

        /* renamed from: o */
        public void m11112o() {
            setTab(null);
            setSelected(false);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            C1652a c1652a = this.f8758e;
            if (c1652a != null && c1652a.isVisible()) {
                accessibilityNodeInfo.setContentDescription(((Object) getContentDescription()) + ", " + ((Object) this.f8758e.m9681g()));
            }
            C9832l c9832lM61042A0 = C9832l.m61042A0(accessibilityNodeInfo);
            c9832lM61042A0.m61068X(C9832l.c.m61127a(0, 1, this.f8754a.m11131g(), 1, false, isSelected()));
            if (isSelected()) {
                c9832lM61042A0.m61066V(false);
                c9832lM61042A0.m61058N(C9832l.a.f48299i);
            }
            c9832lM61042A0.m61098o0(getResources().getString(R$string.item_view_role_description));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i10);
            int mode = View.MeasureSpec.getMode(i10);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i10 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.f8735r, Integer.MIN_VALUE);
            }
            super.onMeasure(i10, i11);
            if (this.f8755b != null) {
                float f10 = TabLayout.this.f8732o;
                int i12 = this.f8763j;
                ImageView imageView = this.f8756c;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f8755b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f10 = TabLayout.this.f8733p;
                    }
                } else {
                    i12 = 1;
                }
                float textSize = this.f8755b.getTextSize();
                int lineCount = this.f8755b.getLineCount();
                int iM4070d = C0669j.m4070d(this.f8755b);
                if (f10 != textSize || (iM4070d >= 0 && i12 != iM4070d)) {
                    if (TabLayout.this.f8743z != 1 || f10 <= textSize || lineCount != 1 || ((layout = this.f8755b.getLayout()) != null && m11104g(layout, 0, f10) <= (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        this.f8755b.setTextSize(0, f10);
                        this.f8755b.setMaxLines(i12);
                        super.onMeasure(i10, i11);
                    }
                }
            }
        }

        /* renamed from: p */
        public final void m11113p(View view) {
            if (m11109l() && view != null) {
                m11105h(false);
                C1653b.m9699a(this.f8758e, view, m11108k(view));
                this.f8757d = view;
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.f8754a == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            this.f8754a.m11136l();
            return true;
        }

        /* renamed from: q */
        public final void m11114q() {
            if (m11109l()) {
                m11105h(true);
                View view = this.f8757d;
                if (view != null) {
                    C1653b.m9702d(this.f8758e, view);
                    this.f8757d = null;
                }
            }
        }

        /* renamed from: r */
        public final void m11115r() {
            C1847f c1847f;
            C1847f c1847f2;
            if (m11109l()) {
                if (this.f8759f != null) {
                    m11114q();
                    return;
                }
                if (this.f8756c != null && (c1847f2 = this.f8754a) != null && c1847f2.m11130f() != null) {
                    View view = this.f8757d;
                    ImageView imageView = this.f8756c;
                    if (view == imageView) {
                        m11116s(imageView);
                        return;
                    } else {
                        m11114q();
                        m11113p(this.f8756c);
                        return;
                    }
                }
                if (this.f8755b == null || (c1847f = this.f8754a) == null || c1847f.m11132h() != 1) {
                    m11114q();
                    return;
                }
                View view2 = this.f8757d;
                TextView textView = this.f8755b;
                if (view2 == textView) {
                    m11116s(textView);
                } else {
                    m11114q();
                    m11113p(this.f8755b);
                }
            }
        }

        /* renamed from: s */
        public final void m11116s(View view) {
            if (m11109l() && view == this.f8757d) {
                C1653b.m9703e(this.f8758e, view, m11108k(view));
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z10) {
            isSelected();
            super.setSelected(z10);
            TextView textView = this.f8755b;
            if (textView != null) {
                textView.setSelected(z10);
            }
            ImageView imageView = this.f8756c;
            if (imageView != null) {
                imageView.setSelected(z10);
            }
            View view = this.f8759f;
            if (view != null) {
                view.setSelected(z10);
            }
        }

        public void setTab(C1847f c1847f) {
            if (c1847f != this.f8754a) {
                this.f8754a = c1847f;
                m11117t();
            }
        }

        /* renamed from: t */
        public final void m11117t() {
            C1847f c1847f = this.f8754a;
            View viewM11129e = c1847f != null ? c1847f.m11129e() : null;
            if (viewM11129e != null) {
                ViewParent parent = viewM11129e.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewM11129e);
                    }
                    addView(viewM11129e);
                }
                this.f8759f = viewM11129e;
                TextView textView = this.f8755b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f8756c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f8756c.setImageDrawable(null);
                }
                TextView textView2 = (TextView) viewM11129e.findViewById(R.id.text1);
                this.f8760g = textView2;
                if (textView2 != null) {
                    this.f8763j = C0669j.m4070d(textView2);
                }
                this.f8761h = (ImageView) viewM11129e.findViewById(R.id.icon);
            } else {
                View view = this.f8759f;
                if (view != null) {
                    removeView(view);
                    this.f8759f = null;
                }
                this.f8760g = null;
                this.f8761h = null;
            }
            if (this.f8759f == null) {
                if (this.f8756c == null) {
                    m11110m();
                }
                if (this.f8755b == null) {
                    m11111n();
                    this.f8763j = C0669j.m4070d(this.f8755b);
                }
                C0669j.m4080n(this.f8755b, TabLayout.this.f8725h);
                ColorStateList colorStateList = TabLayout.this.f8726i;
                if (colorStateList != null) {
                    this.f8755b.setTextColor(colorStateList);
                }
                m11120w(this.f8755b, this.f8756c);
                m11115r();
                m11103f(this.f8756c);
                m11103f(this.f8755b);
            } else {
                TextView textView3 = this.f8760g;
                if (textView3 != null || this.f8761h != null) {
                    m11120w(textView3, this.f8761h);
                }
            }
            if (c1847f != null && !TextUtils.isEmpty(c1847f.f8774d)) {
                setContentDescription(c1847f.f8774d);
            }
            setSelected(c1847f != null && c1847f.m11134j());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [android.graphics.drawable.RippleDrawable] */
        /* renamed from: u */
        public final void m11118u(Context context) {
            int i10 = TabLayout.this.f8734q;
            if (i10 != 0) {
                Drawable drawableM56743b = C8968a.m56743b(context, i10);
                this.f8762i = drawableM56743b;
                if (drawableM56743b != null && drawableM56743b.isStateful()) {
                    this.f8762i.setState(getDrawableState());
                }
            } else {
                this.f8762i = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            if (TabLayout.this.f8728k != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList colorStateListM61322a = C9876b.m61322a(TabLayout.this.f8728k);
                boolean z10 = TabLayout.this.f8705E;
                if (z10) {
                    gradientDrawable = null;
                }
                gradientDrawable = new RippleDrawable(colorStateListM61322a, gradientDrawable, z10 ? null : gradientDrawable2);
            }
            C9603h0.m59910t0(this, gradientDrawable);
            TabLayout.this.invalidate();
        }

        /* renamed from: v */
        public final void m11119v() {
            setOrientation(!TabLayout.this.f8701A ? 1 : 0);
            TextView textView = this.f8760g;
            if (textView == null && this.f8761h == null) {
                m11120w(this.f8755b, this.f8756c);
            } else {
                m11120w(textView, this.f8761h);
            }
        }

        /* renamed from: w */
        public final void m11120w(TextView textView, ImageView imageView) {
            C1847f c1847f = this.f8754a;
            Drawable drawableMutate = (c1847f == null || c1847f.m11130f() == null) ? null : C13669a.m82231l(this.f8754a.m11130f()).mutate();
            if (drawableMutate != null) {
                C13669a.m82228i(drawableMutate, TabLayout.this.f8727j);
                PorterDuff.Mode mode = TabLayout.this.f8731n;
                if (mode != null) {
                    C13669a.m82229j(drawableMutate, mode);
                }
            }
            C1847f c1847f2 = this.f8754a;
            CharSequence charSequenceM11133i = c1847f2 != null ? c1847f2.m11133i() : null;
            if (imageView != null) {
                if (drawableMutate != null) {
                    imageView.setImageDrawable(drawableMutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z10 = !TextUtils.isEmpty(charSequenceM11133i);
            if (textView != null) {
                if (z10) {
                    textView.setText(charSequenceM11133i);
                    if (this.f8754a.f8777g == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int iM10782c = (z10 && imageView.getVisibility() == 0) ? (int) C1788s.m10782c(getContext(), 8) : 0;
                if (TabLayout.this.f8701A) {
                    if (iM10782c != C9620q.m60123a(marginLayoutParams)) {
                        C9620q.m60125c(marginLayoutParams, iM10782c);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (iM10782c != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = iM10782c;
                    C9620q.m60125c(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            C1847f c1847f3 = this.f8754a;
            CharSequence charSequence = c1847f3 != null ? c1847f3.f8774d : null;
            if (!z10) {
                charSequenceM11133i = charSequence;
            }
            C0531i0.m3033a(this, charSequenceM11133i);
        }
    }

    /* renamed from: com.google.android.material.tabs.TabLayout$a */
    public class C1842a implements ValueAnimator.AnimatorUpdateListener {
        public C1842a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* renamed from: com.google.android.material.tabs.TabLayout$b */
    public class C1843b implements ViewPager.InterfaceC0979h {

        /* renamed from: a */
        public boolean f8768a;

        public C1843b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0979h
        /* renamed from: a */
        public void mo5853a(ViewPager viewPager, AbstractC0984a abstractC0984a, AbstractC0984a abstractC0984a2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f8711K == viewPager) {
                tabLayout.m11058H(abstractC0984a2, this.f8768a);
            }
        }

        /* renamed from: b */
        public void m11121b(boolean z10) {
            this.f8768a = z10;
        }
    }

    @Deprecated
    /* renamed from: com.google.android.material.tabs.TabLayout$c */
    public interface InterfaceC1844c<T extends C1847f> {
        /* renamed from: a */
        void mo11122a(T t10);

        /* renamed from: b */
        void mo11123b(T t10);

        /* renamed from: c */
        void mo11124c(T t10);
    }

    /* renamed from: com.google.android.material.tabs.TabLayout$d */
    public interface InterfaceC1845d extends InterfaceC1844c<C1847f> {
    }

    /* renamed from: com.google.android.material.tabs.TabLayout$e */
    public class C1846e extends DataSetObserver {
        public C1846e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.m11051A();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.m11051A();
        }
    }

    /* renamed from: com.google.android.material.tabs.TabLayout$f */
    public static class C1847f {

        /* renamed from: a */
        public Object f8771a;

        /* renamed from: b */
        public Drawable f8772b;

        /* renamed from: c */
        public CharSequence f8773c;

        /* renamed from: d */
        public CharSequence f8774d;

        /* renamed from: f */
        public View f8776f;

        /* renamed from: h */
        public TabLayout f8778h;

        /* renamed from: i */
        public TabView f8779i;

        /* renamed from: e */
        public int f8775e = -1;

        /* renamed from: g */
        public int f8777g = 1;

        /* renamed from: j */
        public int f8780j = -1;

        /* renamed from: e */
        public View m11129e() {
            return this.f8776f;
        }

        /* renamed from: f */
        public Drawable m11130f() {
            return this.f8772b;
        }

        /* renamed from: g */
        public int m11131g() {
            return this.f8775e;
        }

        /* renamed from: h */
        public int m11132h() {
            return this.f8777g;
        }

        /* renamed from: i */
        public CharSequence m11133i() {
            return this.f8773c;
        }

        /* renamed from: j */
        public boolean m11134j() {
            TabLayout tabLayout = this.f8778h;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            int selectedTabPosition = tabLayout.getSelectedTabPosition();
            return selectedTabPosition != -1 && selectedTabPosition == this.f8775e;
        }

        /* renamed from: k */
        public void m11135k() {
            this.f8778h = null;
            this.f8779i = null;
            this.f8771a = null;
            this.f8772b = null;
            this.f8780j = -1;
            this.f8773c = null;
            this.f8774d = null;
            this.f8775e = -1;
            this.f8776f = null;
        }

        /* renamed from: l */
        public void m11136l() {
            TabLayout tabLayout = this.f8778h;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.m11056F(this);
        }

        /* renamed from: m */
        public C1847f m11137m(CharSequence charSequence) {
            this.f8774d = charSequence;
            m11143s();
            return this;
        }

        /* renamed from: n */
        public C1847f m11138n(int i10) {
            return m11139o(LayoutInflater.from(this.f8779i.getContext()).inflate(i10, (ViewGroup) this.f8779i, false));
        }

        /* renamed from: o */
        public C1847f m11139o(View view) {
            this.f8776f = view;
            m11143s();
            return this;
        }

        /* renamed from: p */
        public C1847f m11140p(Drawable drawable) {
            this.f8772b = drawable;
            TabLayout tabLayout = this.f8778h;
            if (tabLayout.f8740w == 1 || tabLayout.f8743z == 2) {
                tabLayout.m11065O(true);
            }
            m11143s();
            if (C1653b.f7497a && this.f8779i.m11109l() && this.f8779i.f8758e.isVisible()) {
                this.f8779i.invalidate();
            }
            return this;
        }

        /* renamed from: q */
        public void m11141q(int i10) {
            this.f8775e = i10;
        }

        /* renamed from: r */
        public C1847f m11142r(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f8774d) && !TextUtils.isEmpty(charSequence)) {
                this.f8779i.setContentDescription(charSequence);
            }
            this.f8773c = charSequence;
            m11143s();
            return this;
        }

        /* renamed from: s */
        public void m11143s() {
            TabView tabView = this.f8779i;
            if (tabView != null) {
                tabView.m11117t();
            }
        }
    }

    /* renamed from: com.google.android.material.tabs.TabLayout$g */
    public static class C1848g implements ViewPager.InterfaceC0980i {

        /* renamed from: a */
        public final WeakReference<TabLayout> f8781a;

        /* renamed from: b */
        public int f8782b;

        /* renamed from: c */
        public int f8783c;

        public C1848g(TabLayout tabLayout) {
            this.f8781a = new WeakReference<>(tabLayout);
        }

        /* renamed from: a */
        public void m11144a() {
            this.f8783c = 0;
            this.f8782b = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageScrollStateChanged(int i10) {
            this.f8782b = this.f8783c;
            this.f8783c = i10;
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageScrolled(int i10, float f10, int i11) {
            TabLayout tabLayout = this.f8781a.get();
            if (tabLayout != null) {
                int i12 = this.f8783c;
                tabLayout.m11060J(i10, f10, i12 != 2 || this.f8782b == 1, (i12 == 2 && this.f8782b == 0) ? false : true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageSelected(int i10) {
            TabLayout tabLayout = this.f8781a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i10 || i10 >= tabLayout.getTabCount()) {
                return;
            }
            int i11 = this.f8783c;
            tabLayout.m11057G(tabLayout.m11085w(i10), i11 == 0 || (i11 == 2 && this.f8782b == 0));
        }
    }

    /* renamed from: com.google.android.material.tabs.TabLayout$h */
    public static class C1849h implements InterfaceC1845d {

        /* renamed from: a */
        public final ViewPager f8784a;

        public C1849h(ViewPager viewPager) {
            this.f8784a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.InterfaceC1844c
        /* renamed from: a */
        public void mo11122a(C1847f c1847f) {
        }

        @Override // com.google.android.material.tabs.TabLayout.InterfaceC1844c
        /* renamed from: b */
        public void mo11123b(C1847f c1847f) throws Resources.NotFoundException {
            this.f8784a.setCurrentItem(c1847f.m11131g());
        }

        @Override // com.google.android.material.tabs.TabLayout.InterfaceC1844c
        /* renamed from: c */
        public void mo11124c(C1847f c1847f) {
        }
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    private int getDefaultHeight() {
        int size = this.f8718a.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            }
            C1847f c1847f = this.f8718a.get(i10);
            if (c1847f == null || c1847f.m11130f() == null || TextUtils.isEmpty(c1847f.m11133i())) {
                i10++;
            } else if (!this.f8701A) {
                return 72;
            }
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i10 = this.f8736s;
        if (i10 != -1) {
            return i10;
        }
        int i11 = this.f8743z;
        if (i11 == 0 || i11 == 2) {
            return this.f8738u;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f8720c.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    /* renamed from: o */
    public static ColorStateList m11050o(int i10, int i11) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i11, i10});
    }

    private void setSelectedTabView(int i10) {
        int childCount = this.f8720c.getChildCount();
        if (i10 < childCount) {
            int i11 = 0;
            while (i11 < childCount) {
                View childAt = this.f8720c.getChildAt(i11);
                boolean z10 = true;
                childAt.setSelected(i11 == i10);
                if (i11 != i10) {
                    z10 = false;
                }
                childAt.setActivated(z10);
                i11++;
            }
        }
    }

    /* renamed from: A */
    public void m11051A() {
        int currentItem;
        m11053C();
        AbstractC0984a abstractC0984a = this.f8712L;
        if (abstractC0984a != null) {
            int count = abstractC0984a.getCount();
            for (int i10 = 0; i10 < count; i10++) {
                m11069f(m11088z().m11142r(this.f8712L.getPageTitle(i10)), false);
            }
            ViewPager viewPager = this.f8711K;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            m11056F(m11085w(currentItem));
        }
    }

    /* renamed from: B */
    public boolean m11052B(C1847f c1847f) {
        return f8700S.mo58737a(c1847f);
    }

    /* renamed from: C */
    public void m11053C() {
        for (int childCount = this.f8720c.getChildCount() - 1; childCount >= 0; childCount--) {
            m11055E(childCount);
        }
        Iterator<C1847f> it = this.f8718a.iterator();
        while (it.hasNext()) {
            C1847f next = it.next();
            it.remove();
            next.m11135k();
            m11052B(next);
        }
        this.f8719b = null;
    }

    @Deprecated
    /* renamed from: D */
    public void m11054D(InterfaceC1844c interfaceC1844c) {
        this.f8708H.remove(interfaceC1844c);
    }

    /* renamed from: E */
    public final void m11055E(int i10) {
        TabView tabView = (TabView) this.f8720c.getChildAt(i10);
        this.f8720c.removeViewAt(i10);
        if (tabView != null) {
            tabView.m11112o();
            this.f8717Q.mo58737a(tabView);
        }
        requestLayout();
    }

    /* renamed from: F */
    public void m11056F(C1847f c1847f) {
        m11057G(c1847f, true);
    }

    /* renamed from: G */
    public void m11057G(C1847f c1847f, boolean z10) {
        C1847f c1847f2 = this.f8719b;
        if (c1847f2 == c1847f) {
            if (c1847f2 != null) {
                m11081s(c1847f);
                m11073j(c1847f.m11131g());
                return;
            }
            return;
        }
        int iM11131g = c1847f != null ? c1847f.m11131g() : -1;
        if (z10) {
            if ((c1847f2 == null || c1847f2.m11131g() == -1) && iM11131g != -1) {
                m11059I(iM11131g, 0.0f, true);
            } else {
                m11073j(iM11131g);
            }
            if (iM11131g != -1) {
                setSelectedTabView(iM11131g);
            }
        }
        this.f8719b = c1847f;
        if (c1847f2 != null) {
            m11083u(c1847f2);
        }
        if (c1847f != null) {
            m11082t(c1847f);
        }
    }

    /* renamed from: H */
    public void m11058H(AbstractC0984a abstractC0984a, boolean z10) {
        DataSetObserver dataSetObserver;
        AbstractC0984a abstractC0984a2 = this.f8712L;
        if (abstractC0984a2 != null && (dataSetObserver = this.f8713M) != null) {
            abstractC0984a2.unregisterDataSetObserver(dataSetObserver);
        }
        this.f8712L = abstractC0984a;
        if (z10 && abstractC0984a != null) {
            if (this.f8713M == null) {
                this.f8713M = new C1846e();
            }
            abstractC0984a.registerDataSetObserver(this.f8713M);
        }
        m11051A();
    }

    /* renamed from: I */
    public void m11059I(int i10, float f10, boolean z10) {
        m11060J(i10, f10, z10, true);
    }

    /* renamed from: J */
    public void m11060J(int i10, float f10, boolean z10, boolean z11) {
        int iRound = Math.round(i10 + f10);
        if (iRound < 0 || iRound >= this.f8720c.getChildCount()) {
            return;
        }
        if (z11) {
            this.f8720c.m11094f(i10, f10);
        }
        ValueAnimator valueAnimator = this.f8710J;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f8710J.cancel();
        }
        scrollTo(i10 < 0 ? 0 : m11076m(i10, f10), 0);
        if (z10) {
            setSelectedTabView(iRound);
        }
    }

    /* renamed from: K */
    public void m11061K(ViewPager viewPager, boolean z10) {
        m11062L(viewPager, z10, false);
    }

    /* renamed from: L */
    public final void m11062L(ViewPager viewPager, boolean z10, boolean z11) {
        ViewPager viewPager2 = this.f8711K;
        if (viewPager2 != null) {
            C1848g c1848g = this.f8714N;
            if (c1848g != null) {
                viewPager2.removeOnPageChangeListener(c1848g);
            }
            C1843b c1843b = this.f8715O;
            if (c1843b != null) {
                this.f8711K.removeOnAdapterChangeListener(c1843b);
            }
        }
        InterfaceC1844c interfaceC1844c = this.f8709I;
        if (interfaceC1844c != null) {
            m11054D(interfaceC1844c);
            this.f8709I = null;
        }
        if (viewPager != null) {
            this.f8711K = viewPager;
            if (this.f8714N == null) {
                this.f8714N = new C1848g(this);
            }
            this.f8714N.m11144a();
            viewPager.addOnPageChangeListener(this.f8714N);
            C1849h c1849h = new C1849h(viewPager);
            this.f8709I = c1849h;
            m11066c(c1849h);
            AbstractC0984a adapter = viewPager.getAdapter();
            if (adapter != null) {
                m11058H(adapter, z10);
            }
            if (this.f8715O == null) {
                this.f8715O = new C1843b();
            }
            this.f8715O.m11121b(z10);
            viewPager.addOnAdapterChangeListener(this.f8715O);
            m11059I(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.f8711K = null;
            m11058H(null, false);
        }
        this.f8716P = z11;
    }

    /* renamed from: M */
    public final void m11063M() {
        int size = this.f8718a.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f8718a.get(i10).m11143s();
        }
    }

    /* renamed from: N */
    public final void m11064N(LinearLayout.LayoutParams layoutParams) {
        if (this.f8743z == 1 && this.f8740w == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    /* renamed from: O */
    public void m11065O(boolean z10) {
        for (int i10 = 0; i10 < this.f8720c.getChildCount(); i10++) {
            View childAt = this.f8720c.getChildAt(i10);
            childAt.setMinimumWidth(getTabMinWidth());
            m11064N((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z10) {
                childAt.requestLayout();
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        m11072i(view);
    }

    @Deprecated
    /* renamed from: c */
    public void m11066c(InterfaceC1844c interfaceC1844c) {
        if (this.f8708H.contains(interfaceC1844c)) {
            return;
        }
        this.f8708H.add(interfaceC1844c);
    }

    /* renamed from: d */
    public void m11067d(C1847f c1847f) {
        m11069f(c1847f, this.f8718a.isEmpty());
    }

    /* renamed from: e */
    public void m11068e(C1847f c1847f, int i10, boolean z10) {
        if (c1847f.f8778h != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        m11077n(c1847f, i10);
        m11071h(c1847f);
        if (z10) {
            c1847f.m11136l();
        }
    }

    /* renamed from: f */
    public void m11069f(C1847f c1847f, boolean z10) {
        m11068e(c1847f, this.f8718a.size(), z10);
    }

    /* renamed from: g */
    public final void m11070g(TabItem tabItem) {
        C1847f c1847fM11088z = m11088z();
        CharSequence charSequence = tabItem.f8696a;
        if (charSequence != null) {
            c1847fM11088z.m11142r(charSequence);
        }
        Drawable drawable = tabItem.f8697b;
        if (drawable != null) {
            c1847fM11088z.m11140p(drawable);
        }
        int i10 = tabItem.f8698c;
        if (i10 != 0) {
            c1847fM11088z.m11138n(i10);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            c1847fM11088z.m11137m(tabItem.getContentDescription());
        }
        m11067d(c1847fM11088z);
    }

    public int getSelectedTabPosition() {
        C1847f c1847f = this.f8719b;
        if (c1847f != null) {
            return c1847f.m11131g();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f8718a.size();
    }

    public int getTabGravity() {
        return this.f8740w;
    }

    public ColorStateList getTabIconTint() {
        return this.f8727j;
    }

    public int getTabIndicatorAnimationMode() {
        return this.f8704D;
    }

    public int getTabIndicatorGravity() {
        return this.f8742y;
    }

    public int getTabMaxWidth() {
        return this.f8735r;
    }

    public int getTabMode() {
        return this.f8743z;
    }

    public ColorStateList getTabRippleColor() {
        return this.f8728k;
    }

    public Drawable getTabSelectedIndicator() {
        return this.f8729l;
    }

    public ColorStateList getTabTextColors() {
        return this.f8726i;
    }

    /* renamed from: h */
    public final void m11071h(C1847f c1847f) {
        TabView tabView = c1847f.f8779i;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.f8720c.addView(tabView, c1847f.m11131g(), m11078p());
    }

    /* renamed from: i */
    public final void m11072i(View view) {
        if (!(view instanceof TabItem)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        m11070g((TabItem) view);
    }

    /* renamed from: j */
    public final void m11073j(int i10) {
        if (i10 == -1) {
            return;
        }
        if (getWindowToken() == null || !C9603h0.m59864T(this) || this.f8720c.m11092d()) {
            m11059I(i10, 0.0f, true);
            return;
        }
        int scrollX = getScrollX();
        int iM11076m = m11076m(i10, 0.0f);
        if (scrollX != iM11076m) {
            m11084v();
            this.f8710J.setIntValues(scrollX, iM11076m);
            this.f8710J.start();
        }
        this.f8720c.m11091c(i10, this.f8741x);
    }

    /* renamed from: k */
    public final void m11074k(int i10) {
        if (i10 == 0) {
            Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        } else if (i10 == 1) {
            this.f8720c.setGravity(1);
            return;
        } else if (i10 != 2) {
            return;
        }
        this.f8720c.setGravity(8388611);
    }

    /* renamed from: l */
    public final void m11075l() {
        int i10 = this.f8743z;
        C9603h0.m59839D0(this.f8720c, (i10 == 0 || i10 == 2) ? Math.max(0, this.f8739v - this.f8721d) : 0, 0, 0, 0);
        int i11 = this.f8743z;
        if (i11 == 0) {
            m11074k(this.f8740w);
        } else if (i11 == 1 || i11 == 2) {
            if (this.f8740w == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.f8720c.setGravity(1);
        }
        m11065O(true);
    }

    /* renamed from: m */
    public final int m11076m(int i10, float f10) {
        View childAt;
        int i11 = this.f8743z;
        if ((i11 != 0 && i11 != 2) || (childAt = this.f8720c.getChildAt(i10)) == null) {
            return 0;
        }
        int i12 = i10 + 1;
        View childAt2 = i12 < this.f8720c.getChildCount() ? this.f8720c.getChildAt(i12) : null;
        int width = childAt.getWidth();
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i13 = (int) ((width + width2) * 0.5f * f10);
        return C9603h0.m59832A(this) == 0 ? left + i13 : left - i13;
    }

    /* renamed from: n */
    public final void m11077n(C1847f c1847f, int i10) {
        c1847f.m11141q(i10);
        this.f8718a.add(i10, c1847f);
        int size = this.f8718a.size();
        while (true) {
            i10++;
            if (i10 >= size) {
                return;
            } else {
                this.f8718a.get(i10).m11141q(i10);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C10428i.m64043e(this);
        if (this.f8711K == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                m11062L((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f8716P) {
            setupWithViewPager(null);
            this.f8716P = false;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        for (int i10 = 0; i10 < this.f8720c.getChildCount(); i10++) {
            View childAt = this.f8720c.getChildAt(i10);
            if (childAt instanceof TabView) {
                ((TabView) childAt).m11107j(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        C9832l.m61042A0(accessibilityNodeInfo).m61067W(C9832l.b.m61126b(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return m11086x() && super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = com.google.android.material.internal.C1788s.m10782c(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 0
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r0 = r0 + r8
            int r8 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r3)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.f8737t
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = com.google.android.material.internal.C1788s.m10782c(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.f8735r = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto La9
            android.view.View r7 = r6.getChildAt(r3)
            int r0 = r6.f8743z
            if (r0 == 0) goto L81
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L81
            goto La9
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto La9
            goto L8b
        L81:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto La9
        L8b:
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r0 = r0 + r1
            android.view.ViewGroup$LayoutParams r1 = r7.getLayoutParams()
            int r1 = r1.height
            int r8 = android.view.ViewGroup.getChildMeasureSpec(r8, r0, r1)
            int r6 = r6.getMeasuredWidth()
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r4)
            r7.measure(r6, r8)
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || m11086x()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    /* renamed from: p */
    public final LinearLayout.LayoutParams m11078p() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        m11064N(layoutParams);
        return layoutParams;
    }

    /* renamed from: q */
    public C1847f m11079q() {
        C1847f c1847fMo58738b = f8700S.mo58738b();
        return c1847fMo58738b == null ? new C1847f() : c1847fMo58738b;
    }

    /* renamed from: r */
    public final TabView m11080r(C1847f c1847f) {
        InterfaceC9370e<TabView> interfaceC9370e = this.f8717Q;
        TabView tabViewMo58738b = interfaceC9370e != null ? interfaceC9370e.mo58738b() : null;
        if (tabViewMo58738b == null) {
            tabViewMo58738b = new TabView(getContext());
        }
        tabViewMo58738b.setTab(c1847f);
        tabViewMo58738b.setFocusable(true);
        tabViewMo58738b.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(c1847f.f8774d)) {
            tabViewMo58738b.setContentDescription(c1847f.f8773c);
        } else {
            tabViewMo58738b.setContentDescription(c1847f.f8774d);
        }
        return tabViewMo58738b;
    }

    /* renamed from: s */
    public final void m11081s(C1847f c1847f) {
        for (int size = this.f8708H.size() - 1; size >= 0; size--) {
            this.f8708H.get(size).mo11122a(c1847f);
        }
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        C10428i.m64042d(this, f10);
    }

    public void setInlineLabel(boolean z10) {
        if (this.f8701A != z10) {
            this.f8701A = z10;
            for (int i10 = 0; i10 < this.f8720c.getChildCount(); i10++) {
                View childAt = this.f8720c.getChildAt(i10);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).m11119v();
                }
            }
            m11075l();
        }
    }

    public void setInlineLabelResource(int i10) {
        setInlineLabel(getResources().getBoolean(i10));
    }

    @Deprecated
    public void setOnTabSelectedListener(InterfaceC1845d interfaceC1845d) {
        setOnTabSelectedListener((InterfaceC1844c) interfaceC1845d);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        m11084v();
        this.f8710J.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.f8729l != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.f8729l = drawable;
            int intrinsicHeight = this.f8703C;
            if (intrinsicHeight == -1) {
                intrinsicHeight = drawable.getIntrinsicHeight();
            }
            this.f8720c.m11095g(intrinsicHeight);
        }
    }

    public void setSelectedTabIndicatorColor(int i10) {
        this.f8730m = i10;
        m11065O(false);
    }

    public void setSelectedTabIndicatorGravity(int i10) {
        if (this.f8742y != i10) {
            this.f8742y = i10;
            C9603h0.m59884g0(this.f8720c);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i10) {
        this.f8703C = i10;
        this.f8720c.m11095g(i10);
    }

    public void setTabGravity(int i10) {
        if (this.f8740w != i10) {
            this.f8740w = i10;
            m11075l();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.f8727j != colorStateList) {
            this.f8727j = colorStateList;
            m11063M();
        }
    }

    public void setTabIconTintResource(int i10) {
        setTabIconTint(C8968a.m56742a(getContext(), i10));
    }

    public void setTabIndicatorAnimationMode(int i10) {
        this.f8704D = i10;
        if (i10 == 0) {
            this.f8706F = new C1852c();
            return;
        }
        if (i10 == 1) {
            this.f8706F = new C1850a();
        } else {
            if (i10 == 2) {
                this.f8706F = new C1851b();
                return;
            }
            throw new IllegalArgumentException(i10 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z10) {
        this.f8702B = z10;
        this.f8720c.m11093e();
        C9603h0.m59884g0(this.f8720c);
    }

    public void setTabMode(int i10) {
        if (i10 != this.f8743z) {
            this.f8743z = i10;
            m11075l();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.f8728k != colorStateList) {
            this.f8728k = colorStateList;
            for (int i10 = 0; i10 < this.f8720c.getChildCount(); i10++) {
                View childAt = this.f8720c.getChildAt(i10);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).m11118u(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i10) {
        setTabRippleColor(C8968a.m56742a(getContext(), i10));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f8726i != colorStateList) {
            this.f8726i = colorStateList;
            m11063M();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(AbstractC0984a abstractC0984a) {
        m11058H(abstractC0984a, false);
    }

    public void setUnboundedRipple(boolean z10) {
        if (this.f8705E != z10) {
            this.f8705E = z10;
            for (int i10 = 0; i10 < this.f8720c.getChildCount(); i10++) {
                View childAt = this.f8720c.getChildAt(i10);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).m11118u(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i10) {
        setUnboundedRipple(getResources().getBoolean(i10));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        m11061K(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    /* renamed from: t */
    public final void m11082t(C1847f c1847f) {
        for (int size = this.f8708H.size() - 1; size >= 0; size--) {
            this.f8708H.get(size).mo11123b(c1847f);
        }
    }

    /* renamed from: u */
    public final void m11083u(C1847f c1847f) {
        for (int size = this.f8708H.size() - 1; size >= 0; size--) {
            this.f8708H.get(size).mo11124c(c1847f);
        }
    }

    /* renamed from: v */
    public final void m11084v() {
        if (this.f8710J == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f8710J = valueAnimator;
            valueAnimator.setInterpolator(C13110a.f59598b);
            this.f8710J.setDuration(this.f8741x);
            this.f8710J.addUpdateListener(new C1842a());
        }
    }

    /* renamed from: w */
    public C1847f m11085w(int i10) {
        if (i10 < 0 || i10 >= getTabCount()) {
            return null;
        }
        return this.f8718a.get(i10);
    }

    /* renamed from: x */
    public final boolean m11086x() {
        return getTabMode() == 0 || getTabMode() == 2;
    }

    /* renamed from: y */
    public boolean m11087y() {
        return this.f8702B;
    }

    /* renamed from: z */
    public C1847f m11088z() {
        C1847f c1847fM11079q = m11079q();
        c1847fM11079q.f8778h = this;
        c1847fM11079q.f8779i = m11080r(c1847fM11079q);
        if (c1847fM11079q.f8780j != -1) {
            c1847fM11079q.f8779i.setId(c1847fM11079q.f8780j);
        }
        return c1847fM11079q;
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.tabStyle);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i10) {
        m11072i(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(InterfaceC1844c interfaceC1844c) {
        InterfaceC1844c interfaceC1844c2 = this.f8707G;
        if (interfaceC1844c2 != null) {
            m11054D(interfaceC1844c2);
        }
        this.f8707G = interfaceC1844c;
        if (interfaceC1844c != null) {
            m11066c(interfaceC1844c);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TabLayout(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        int i11 = f8699R;
        super(C10981a.m66348c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f8718a = new ArrayList<>();
        this.f8729l = new GradientDrawable();
        this.f8730m = 0;
        this.f8735r = Integer.MAX_VALUE;
        this.f8703C = -1;
        this.f8708H = new ArrayList<>();
        this.f8717Q = new C9371f(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        SlidingTabIndicator slidingTabIndicator = new SlidingTabIndicator(context2);
        this.f8720c = slidingTabIndicator;
        super.addView(slidingTabIndicator, 0, new FrameLayout.LayoutParams(-2, -1));
        int[] iArr = R$styleable.TabLayout;
        int i12 = R$styleable.TabLayout_tabTextAppearance;
        TypedArray typedArrayM10770h = C1784o.m10770h(context2, attributeSet, iArr, i10, i11, i12);
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            C10427h c10427h = new C10427h();
            c10427h.m64002b0(ColorStateList.valueOf(colorDrawable.getColor()));
            c10427h.m63992Q(context2);
            c10427h.m64001a0(C9603h0.m59913v(this));
            C9603h0.m59910t0(this, c10427h);
        }
        setSelectedTabIndicator(C9649c.m60269e(context2, typedArrayM10770h, R$styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorColor(typedArrayM10770h.getColor(R$styleable.TabLayout_tabIndicatorColor, 0));
        slidingTabIndicator.m11095g(typedArrayM10770h.getDimensionPixelSize(R$styleable.TabLayout_tabIndicatorHeight, -1));
        setSelectedTabIndicatorGravity(typedArrayM10770h.getInt(R$styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorAnimationMode(typedArrayM10770h.getInt(R$styleable.TabLayout_tabIndicatorAnimationMode, 0));
        setTabIndicatorFullWidth(typedArrayM10770h.getBoolean(R$styleable.TabLayout_tabIndicatorFullWidth, true));
        int dimensionPixelSize = typedArrayM10770h.getDimensionPixelSize(R$styleable.TabLayout_tabPadding, 0);
        this.f8724g = dimensionPixelSize;
        this.f8723f = dimensionPixelSize;
        this.f8722e = dimensionPixelSize;
        this.f8721d = dimensionPixelSize;
        this.f8721d = typedArrayM10770h.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.f8722e = typedArrayM10770h.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingTop, this.f8722e);
        this.f8723f = typedArrayM10770h.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingEnd, this.f8723f);
        this.f8724g = typedArrayM10770h.getDimensionPixelSize(R$styleable.TabLayout_tabPaddingBottom, this.f8724g);
        int resourceId = typedArrayM10770h.getResourceId(i12, R$style.TextAppearance_Design_Tab);
        this.f8725h = resourceId;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId, androidx.appcompat.R$styleable.TextAppearance);
        try {
            this.f8732o = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R$styleable.TextAppearance_android_textSize, 0);
            this.f8726i = C9649c.m60265a(context2, typedArrayObtainStyledAttributes, androidx.appcompat.R$styleable.TextAppearance_android_textColor);
            typedArrayObtainStyledAttributes.recycle();
            int i13 = R$styleable.TabLayout_tabTextColor;
            if (typedArrayM10770h.hasValue(i13)) {
                this.f8726i = C9649c.m60265a(context2, typedArrayM10770h, i13);
            }
            int i14 = R$styleable.TabLayout_tabSelectedTextColor;
            if (typedArrayM10770h.hasValue(i14)) {
                this.f8726i = m11050o(this.f8726i.getDefaultColor(), typedArrayM10770h.getColor(i14, 0));
            }
            this.f8727j = C9649c.m60265a(context2, typedArrayM10770h, R$styleable.TabLayout_tabIconTint);
            this.f8731n = C1788s.m10789j(typedArrayM10770h.getInt(R$styleable.TabLayout_tabIconTintMode, -1), null);
            this.f8728k = C9649c.m60265a(context2, typedArrayM10770h, R$styleable.TabLayout_tabRippleColor);
            this.f8741x = typedArrayM10770h.getInt(R$styleable.TabLayout_tabIndicatorAnimationDuration, 300);
            this.f8736s = typedArrayM10770h.getDimensionPixelSize(R$styleable.TabLayout_tabMinWidth, -1);
            this.f8737t = typedArrayM10770h.getDimensionPixelSize(R$styleable.TabLayout_tabMaxWidth, -1);
            this.f8734q = typedArrayM10770h.getResourceId(R$styleable.TabLayout_tabBackground, 0);
            this.f8739v = typedArrayM10770h.getDimensionPixelSize(R$styleable.TabLayout_tabContentStart, 0);
            this.f8743z = typedArrayM10770h.getInt(R$styleable.TabLayout_tabMode, 1);
            this.f8740w = typedArrayM10770h.getInt(R$styleable.TabLayout_tabGravity, 0);
            this.f8701A = typedArrayM10770h.getBoolean(R$styleable.TabLayout_tabInlineLabel, false);
            this.f8705E = typedArrayM10770h.getBoolean(R$styleable.TabLayout_tabUnboundedRipple, false);
            typedArrayM10770h.recycle();
            Resources resources = getResources();
            this.f8733p = resources.getDimensionPixelSize(R$dimen.design_tab_text_size_2line);
            this.f8738u = resources.getDimensionPixelSize(R$dimen.design_tab_scrollable_min_width);
            m11075l();
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        m11072i(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        m11072i(view);
    }

    public void setSelectedTabIndicator(int i10) {
        if (i10 != 0) {
            setSelectedTabIndicator(C8968a.m56743b(getContext(), i10));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
