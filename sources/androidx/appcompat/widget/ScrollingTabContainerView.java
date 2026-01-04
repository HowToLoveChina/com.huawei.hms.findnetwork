package androidx.appcompat.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.LinearLayoutCompat;
import p303g.C9813a;

/* loaded from: classes.dex */
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: l */
    public static final Interpolator f2050l = new DecelerateInterpolator();

    /* renamed from: a */
    public Runnable f2051a;

    /* renamed from: b */
    public ViewOnClickListenerC0481c f2052b;

    /* renamed from: c */
    public LinearLayoutCompat f2053c;

    /* renamed from: d */
    public Spinner f2054d;

    /* renamed from: e */
    public boolean f2055e;

    /* renamed from: f */
    public int f2056f;

    /* renamed from: g */
    public int f2057g;

    /* renamed from: h */
    public int f2058h;

    /* renamed from: i */
    public int f2059i;

    /* renamed from: j */
    public ViewPropertyAnimator f2060j;

    /* renamed from: k */
    public final C0482d f2061k;

    public class TabView extends LinearLayout {

        /* renamed from: a */
        public final int[] f2062a;

        /* renamed from: b */
        public ActionBar.AbstractC0346b f2063b;

        /* renamed from: c */
        public TextView f2064c;

        /* renamed from: d */
        public ImageView f2065d;

        /* renamed from: e */
        public View f2066e;

        /* JADX WARN: Illegal instructions before constructor call */
        public TabView(Context context, ActionBar.AbstractC0346b abstractC0346b, boolean z10) {
            int i10 = R$attr.actionBarTabStyle;
            super(context, null, i10);
            int[] iArr = {R.attr.background};
            this.f2062a = iArr;
            this.f2063b = abstractC0346b;
            C0523e0 c0523e0M2946v = C0523e0.m2946v(context, null, iArr, i10, 0);
            if (c0523e0M2946v.m2965s(0)) {
                setBackgroundDrawable(c0523e0M2946v.m2953g(0));
            }
            c0523e0M2946v.m2966w();
            if (z10) {
                setGravity(8388627);
            }
            m2767c();
        }

        /* renamed from: a */
        public void m2765a(ActionBar.AbstractC0346b abstractC0346b) {
            this.f2063b = abstractC0346b;
            m2767c();
        }

        /* renamed from: b */
        public ActionBar.AbstractC0346b m2766b() {
            return this.f2063b;
        }

        /* renamed from: c */
        public void m2767c() {
            ActionBar.AbstractC0346b abstractC0346b = this.f2063b;
            View viewM1991b = abstractC0346b.m1991b();
            if (viewM1991b != null) {
                ViewParent parent = viewM1991b.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewM1991b);
                    }
                    addView(viewM1991b);
                }
                this.f2066e = viewM1991b;
                TextView textView = this.f2064c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f2065d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f2065d.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f2066e;
            if (view != null) {
                removeView(view);
                this.f2066e = null;
            }
            Drawable drawableM1992c = abstractC0346b.m1992c();
            CharSequence charSequenceM1993d = abstractC0346b.m1993d();
            if (drawableM1992c != null) {
                if (this.f2065d == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f2065d = appCompatImageView;
                }
                this.f2065d.setImageDrawable(drawableM1992c);
                this.f2065d.setVisibility(0);
            } else {
                ImageView imageView2 = this.f2065d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f2065d.setImageDrawable(null);
                }
            }
            boolean z10 = !TextUtils.isEmpty(charSequenceM1993d);
            if (z10) {
                if (this.f2064c == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R$attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f2064c = appCompatTextView;
                }
                this.f2064c.setText(charSequenceM1993d);
                this.f2064c.setVisibility(0);
            } else {
                TextView textView2 = this.f2064c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f2064c.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f2065d;
            if (imageView3 != null) {
                imageView3.setContentDescription(abstractC0346b.m1990a());
            }
            C0531i0.m3033a(this, z10 ? null : abstractC0346b.m1990a());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (ScrollingTabContainerView.this.f2056f > 0) {
                int measuredWidth = getMeasuredWidth();
                int i12 = ScrollingTabContainerView.this.f2056f;
                if (measuredWidth > i12) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z10) {
            boolean z11 = isSelected() != z10;
            super.setSelected(z10);
            if (z11 && z10) {
                sendAccessibilityEvent(4);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ScrollingTabContainerView$a */
    public class RunnableC0479a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ View f2068a;

        public RunnableC0479a(View view) {
            this.f2068a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ScrollingTabContainerView.this.smoothScrollTo(this.f2068a.getLeft() - ((ScrollingTabContainerView.this.getWidth() - this.f2068a.getWidth()) / 2), 0);
            ScrollingTabContainerView.this.f2051a = null;
        }
    }

    /* renamed from: androidx.appcompat.widget.ScrollingTabContainerView$b */
    public class C0480b extends BaseAdapter {
        public C0480b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ScrollingTabContainerView.this.f2053c.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            return ((TabView) ScrollingTabContainerView.this.f2053c.getChildAt(i10)).m2766b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.m2761d((ActionBar.AbstractC0346b) getItem(i10), true);
            }
            ((TabView) view).m2765a((ActionBar.AbstractC0346b) getItem(i10));
            return view;
        }
    }

    /* renamed from: androidx.appcompat.widget.ScrollingTabContainerView$c */
    public class ViewOnClickListenerC0481c implements View.OnClickListener {
        public ViewOnClickListenerC0481c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((TabView) view).m2766b().m1994e();
            int childCount = ScrollingTabContainerView.this.f2053c.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = ScrollingTabContainerView.this.f2053c.getChildAt(i10);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ScrollingTabContainerView$d */
    public class C0482d extends AnimatorListenerAdapter {

        /* renamed from: a */
        public boolean f2072a = false;

        /* renamed from: b */
        public int f2073b;

        public C0482d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2072a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f2072a) {
                return;
            }
            ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
            scrollingTabContainerView.f2060j = null;
            scrollingTabContainerView.setVisibility(this.f2073b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.f2072a = false;
        }
    }

    public ScrollingTabContainerView(Context context) {
        super(context);
        this.f2061k = new C0482d();
        setHorizontalScrollBarEnabled(false);
        C9813a c9813aM60992b = C9813a.m60992b(context);
        setContentHeight(c9813aM60992b.m60997f());
        this.f2057g = c9813aM60992b.m60996e();
        LinearLayoutCompat linearLayoutCompatM2760c = m2760c();
        this.f2053c = linearLayoutCompatM2760c;
        addView(linearLayoutCompatM2760c, new ViewGroup.LayoutParams(-2, -1));
    }

    /* renamed from: a */
    public void m2758a(int i10) {
        View childAt = this.f2053c.getChildAt(i10);
        Runnable runnable = this.f2051a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        RunnableC0479a runnableC0479a = new RunnableC0479a(childAt);
        this.f2051a = runnableC0479a;
        post(runnableC0479a);
    }

    /* renamed from: b */
    public final Spinner m2759b() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R$attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    /* renamed from: c */
    public final LinearLayoutCompat m2760c() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), null, R$attr.actionBarTabBarStyle);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    /* renamed from: d */
    public TabView m2761d(ActionBar.AbstractC0346b abstractC0346b, boolean z10) {
        TabView tabView = new TabView(getContext(), abstractC0346b, z10);
        if (z10) {
            tabView.setBackgroundDrawable(null);
            tabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.f2058h));
        } else {
            tabView.setFocusable(true);
            if (this.f2052b == null) {
                this.f2052b = new ViewOnClickListenerC0481c();
            }
            tabView.setOnClickListener(this.f2052b);
        }
        return tabView;
    }

    /* renamed from: e */
    public final boolean m2762e() {
        Spinner spinner = this.f2054d;
        return spinner != null && spinner.getParent() == this;
    }

    /* renamed from: f */
    public final void m2763f() {
        if (m2762e()) {
            return;
        }
        if (this.f2054d == null) {
            this.f2054d = m2759b();
        }
        removeView(this.f2053c);
        addView(this.f2054d, new ViewGroup.LayoutParams(-2, -1));
        if (this.f2054d.getAdapter() == null) {
            this.f2054d.setAdapter((SpinnerAdapter) new C0480b());
        }
        Runnable runnable = this.f2051a;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f2051a = null;
        }
        this.f2054d.setSelection(this.f2059i);
    }

    /* renamed from: g */
    public final boolean m2764g() {
        if (!m2762e()) {
            return false;
        }
        removeView(this.f2054d);
        addView(this.f2053c, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f2054d.getSelectedItemPosition());
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f2051a;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C9813a c9813aM60992b = C9813a.m60992b(getContext());
        setContentHeight(c9813aM60992b.m60997f());
        this.f2057g = c9813aM60992b.m60996e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f2051a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
        ((TabView) view).m2766b().m1994e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        boolean z10 = mode == 1073741824;
        setFillViewport(z10);
        int childCount = this.f2053c.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f2056f = -1;
        } else {
            if (childCount > 2) {
                this.f2056f = (int) (View.MeasureSpec.getSize(i10) * 0.4f);
            } else {
                this.f2056f = View.MeasureSpec.getSize(i10) / 2;
            }
            this.f2056f = Math.min(this.f2056f, this.f2057g);
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f2058h, 1073741824);
        if (z10 || !this.f2055e) {
            m2764g();
        } else {
            this.f2053c.measure(0, iMakeMeasureSpec);
            if (this.f2053c.getMeasuredWidth() > View.MeasureSpec.getSize(i10)) {
                m2763f();
            } else {
                m2764g();
            }
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i10, iMakeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z10 || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.f2059i);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z10) {
        this.f2055e = z10;
    }

    public void setContentHeight(int i10) {
        this.f2058h = i10;
        requestLayout();
    }

    public void setTabSelected(int i10) {
        this.f2059i = i10;
        int childCount = this.f2053c.getChildCount();
        int i11 = 0;
        while (i11 < childCount) {
            View childAt = this.f2053c.getChildAt(i11);
            boolean z10 = i11 == i10;
            childAt.setSelected(z10);
            if (z10) {
                m2758a(i10);
            }
            i11++;
        }
        Spinner spinner = this.f2054d;
        if (spinner == null || i10 < 0) {
            return;
        }
        spinner.setSelection(i10);
    }
}
