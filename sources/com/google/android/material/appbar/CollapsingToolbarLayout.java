package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.C1771b;
import com.google.android.material.internal.C1773d;
import com.google.android.material.internal.C1784o;
import p243e0.C9368c;
import p273f0.C9603h0;
import p273f0.C9625s0;
import p273f0.InterfaceC9586b0;
import p276f3.C9649c;
import p416k3.C10981a;
import p666u2.C13110a;
import p757x.C13669a;
import p827z.C14059a;

/* loaded from: classes.dex */
public class CollapsingToolbarLayout extends FrameLayout {

    /* renamed from: D */
    public static final int f7389D = R$style.Widget_Design_CollapsingToolbar;

    /* renamed from: A */
    public boolean f7390A;

    /* renamed from: B */
    public int f7391B;

    /* renamed from: C */
    public boolean f7392C;

    /* renamed from: a */
    public boolean f7393a;

    /* renamed from: b */
    public int f7394b;

    /* renamed from: c */
    public ViewGroup f7395c;

    /* renamed from: d */
    public View f7396d;

    /* renamed from: e */
    public View f7397e;

    /* renamed from: f */
    public int f7398f;

    /* renamed from: g */
    public int f7399g;

    /* renamed from: h */
    public int f7400h;

    /* renamed from: i */
    public int f7401i;

    /* renamed from: j */
    public final Rect f7402j;

    /* renamed from: k */
    public final C1771b f7403k;

    /* renamed from: l */
    public final ElevationOverlayProvider f7404l;

    /* renamed from: m */
    public boolean f7405m;

    /* renamed from: n */
    public boolean f7406n;

    /* renamed from: o */
    public Drawable f7407o;

    /* renamed from: p */
    public Drawable f7408p;

    /* renamed from: q */
    public int f7409q;

    /* renamed from: r */
    public boolean f7410r;

    /* renamed from: s */
    public ValueAnimator f7411s;

    /* renamed from: t */
    public long f7412t;

    /* renamed from: u */
    public int f7413u;

    /* renamed from: v */
    public AppBarLayout.InterfaceC1644g f7414v;

    /* renamed from: w */
    public int f7415w;

    /* renamed from: x */
    public int f7416x;

    /* renamed from: y */
    public C9625s0 f7417y;

    /* renamed from: z */
    public int f7418z;

    /* renamed from: com.google.android.material.appbar.CollapsingToolbarLayout$a */
    public class C1645a implements InterfaceC9586b0 {
        public C1645a() {
        }

        @Override // p273f0.InterfaceC9586b0
        public C9625s0 onApplyWindowInsets(View view, C9625s0 c9625s0) {
            return CollapsingToolbarLayout.this.m9572n(c9625s0);
        }
    }

    /* renamed from: com.google.android.material.appbar.CollapsingToolbarLayout$b */
    public class C1646b implements ValueAnimator.AnimatorUpdateListener {
        public C1646b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* renamed from: com.google.android.material.appbar.CollapsingToolbarLayout$c */
    public class C1647c implements AppBarLayout.InterfaceC1644g {
        public C1647c() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.InterfaceC1640c
        /* renamed from: a */
        public void mo9555a(AppBarLayout appBarLayout, int i10) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.f7415w = i10;
            C9625s0 c9625s0 = collapsingToolbarLayout.f7417y;
            int iM60160l = c9625s0 != null ? c9625s0.m60160l() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i11);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                C1649a c1649aM9561j = CollapsingToolbarLayout.m9561j(childAt);
                int i12 = layoutParams.f7419a;
                if (i12 == 1) {
                    c1649aM9561j.m9605f(C14059a.m84263b(-i10, 0, CollapsingToolbarLayout.this.m9569h(childAt)));
                } else if (i12 == 2) {
                    c1649aM9561j.m9605f(Math.round((-i10) * layoutParams.f7420b));
                }
            }
            CollapsingToolbarLayout.this.m9579u();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.f7408p != null && iM60160l > 0) {
                C9603h0.m59884g0(collapsingToolbarLayout2);
            }
            int height = (CollapsingToolbarLayout.this.getHeight() - C9603h0.m59834B(CollapsingToolbarLayout.this)) - iM60160l;
            float f10 = height;
            CollapsingToolbarLayout.this.f7403k.m10668w0(Math.min(1.0f, (r0 - CollapsingToolbarLayout.this.getScrimVisibleHeightTrigger()) / f10));
            CollapsingToolbarLayout collapsingToolbarLayout3 = CollapsingToolbarLayout.this;
            collapsingToolbarLayout3.f7403k.m10642j0(collapsingToolbarLayout3.f7415w + height);
            CollapsingToolbarLayout.this.f7403k.m10664u0(Math.abs(i10) / f10);
        }
    }

    public CollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    /* renamed from: g */
    public static int m9559g(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getMeasuredHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    /* renamed from: i */
    public static CharSequence m9560i(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getTitle();
        }
        if (view instanceof android.widget.Toolbar) {
            return ((android.widget.Toolbar) view).getTitle();
        }
        return null;
    }

    /* renamed from: j */
    public static C1649a m9561j(View view) {
        int i10 = R$id.view_offset_helper;
        C1649a c1649a = (C1649a) view.getTag(i10);
        if (c1649a != null) {
            return c1649a;
        }
        C1649a c1649a2 = new C1649a(view);
        view.setTag(i10, c1649a2);
        return c1649a2;
    }

    /* renamed from: l */
    public static boolean m9562l(View view) {
        return (view instanceof Toolbar) || (view instanceof android.widget.Toolbar);
    }

    /* renamed from: a */
    public final void m9563a(int i10) {
        m9565c();
        ValueAnimator valueAnimator = this.f7411s;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f7411s = valueAnimator2;
            valueAnimator2.setInterpolator(i10 > this.f7409q ? C13110a.f59599c : C13110a.f59600d);
            this.f7411s.addUpdateListener(new C1646b());
        } else if (valueAnimator.isRunning()) {
            this.f7411s.cancel();
        }
        this.f7411s.setDuration(this.f7412t);
        this.f7411s.setIntValues(this.f7409q, i10);
        this.f7411s.start();
    }

    /* renamed from: b */
    public final void m9564b(AppBarLayout appBarLayout) {
        if (m9570k()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    /* renamed from: c */
    public final void m9565c() {
        if (this.f7393a) {
            ViewGroup viewGroup = null;
            this.f7395c = null;
            this.f7396d = null;
            int i10 = this.f7394b;
            if (i10 != -1) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById(i10);
                this.f7395c = viewGroup2;
                if (viewGroup2 != null) {
                    this.f7396d = m9566d(viewGroup2);
                }
            }
            if (this.f7395c == null) {
                int childCount = getChildCount();
                int i11 = 0;
                while (true) {
                    if (i11 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i11);
                    if (m9562l(childAt)) {
                        viewGroup = (ViewGroup) childAt;
                        break;
                    }
                    i11++;
                }
                this.f7395c = viewGroup;
            }
            m9578t();
            this.f7393a = false;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* renamed from: d */
    public final View m9566d(View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = parent;
            }
        }
        return view;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        m9565c();
        if (this.f7395c == null && (drawable = this.f7407o) != null && this.f7409q > 0) {
            drawable.mutate().setAlpha(this.f7409q);
            this.f7407o.draw(canvas);
        }
        if (this.f7405m && this.f7406n) {
            if (this.f7395c == null || this.f7407o == null || this.f7409q <= 0 || !m9570k() || this.f7403k.m10598D() >= this.f7403k.m10600E()) {
                this.f7403k.m10645l(canvas);
            } else {
                int iSave = canvas.save();
                canvas.clipRect(this.f7407o.getBounds(), Region.Op.DIFFERENCE);
                this.f7403k.m10645l(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        if (this.f7408p == null || this.f7409q <= 0) {
            return;
        }
        C9625s0 c9625s0 = this.f7417y;
        int iM60160l = c9625s0 != null ? c9625s0.m60160l() : 0;
        if (iM60160l > 0) {
            this.f7408p.setBounds(0, -this.f7415w, getWidth(), iM60160l - this.f7415w);
            this.f7408p.mutate().setAlpha(this.f7409q);
            this.f7408p.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        boolean z10;
        if (this.f7407o == null || this.f7409q <= 0 || !m9571m(view)) {
            z10 = false;
        } else {
            m9577s(this.f7407o, view, getWidth(), getHeight());
            this.f7407o.mutate().setAlpha(this.f7409q);
            this.f7407o.draw(canvas);
            z10 = true;
        }
        return super.drawChild(canvas, view, j10) || z10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f7408p;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f7407o;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        C1771b c1771b = this.f7403k;
        if (c1771b != null) {
            state |= c1771b.m10601E0(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getCollapsedTitleGravity() {
        return this.f7403k.m10655q();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.f7403k.m10663u();
    }

    public Drawable getContentScrim() {
        return this.f7407o;
    }

    public int getExpandedTitleGravity() {
        return this.f7403k.m10592A();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f7401i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f7400h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f7398f;
    }

    public int getExpandedTitleMarginTop() {
        return this.f7399g;
    }

    public Typeface getExpandedTitleTypeface() {
        return this.f7403k.m10596C();
    }

    public int getHyphenationFrequency() {
        return this.f7403k.m10602F();
    }

    public int getLineCount() {
        return this.f7403k.m10604G();
    }

    public float getLineSpacingAdd() {
        return this.f7403k.m10606H();
    }

    public float getLineSpacingMultiplier() {
        return this.f7403k.m10608I();
    }

    public int getMaxLines() {
        return this.f7403k.m10610J();
    }

    public int getScrimAlpha() {
        return this.f7409q;
    }

    public long getScrimAnimationDuration() {
        return this.f7412t;
    }

    public int getScrimVisibleHeightTrigger() {
        int i10 = this.f7413u;
        if (i10 >= 0) {
            return i10 + this.f7418z + this.f7391B;
        }
        C9625s0 c9625s0 = this.f7417y;
        int iM60160l = c9625s0 != null ? c9625s0.m60160l() : 0;
        int iM59834B = C9603h0.m59834B(this);
        return iM59834B > 0 ? Math.min((iM59834B * 2) + iM60160l, getHeight()) : getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.f7408p;
    }

    public CharSequence getTitle() {
        if (this.f7405m) {
            return this.f7403k.m10613M();
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.f7416x;
    }

    public TimeInterpolator getTitlePositionInterpolator() {
        return this.f7403k.m10612L();
    }

    /* renamed from: h */
    public final int m9569h(View view) {
        return ((getHeight() - m9561j(view).m9601b()) - view.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    /* renamed from: k */
    public final boolean m9570k() {
        return this.f7416x == 1;
    }

    /* renamed from: m */
    public final boolean m9571m(View view) {
        View view2 = this.f7396d;
        if (view2 == null || view2 == this) {
            if (view != this.f7395c) {
                return false;
            }
        } else if (view != view2) {
            return false;
        }
        return true;
    }

    /* renamed from: n */
    public C9625s0 m9572n(C9625s0 c9625s0) {
        C9625s0 c9625s02 = C9603h0.m59917x(this) ? c9625s0 : null;
        if (!C9368c.m58729a(this.f7417y, c9625s02)) {
            this.f7417y = c9625s02;
            requestLayout();
        }
        return c9625s0.m60151c();
    }

    /* renamed from: o */
    public void m9573o(boolean z10, boolean z11) {
        if (this.f7410r != z10) {
            if (z11) {
                m9563a(z10 ? 255 : 0);
            } else {
                setScrimAlpha(z10 ? 255 : 0);
            }
            this.f7410r = z10;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            m9564b(appBarLayout);
            C9603h0.m59920y0(this, C9603h0.m59917x(appBarLayout));
            if (this.f7414v == null) {
                this.f7414v = new C1647c();
            }
            appBarLayout.m9474d(this.f7414v);
            C9603h0.m59896m0(this);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f7403k.m10620V(configuration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.InterfaceC1644g interfaceC1644g = this.f7414v;
        if (interfaceC1644g != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).m9488r(interfaceC1644g);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        C9625s0 c9625s0 = this.f7417y;
        if (c9625s0 != null) {
            int iM60160l = c9625s0.m60160l();
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                if (!C9603h0.m59917x(childAt) && childAt.getTop() < iM60160l) {
                    C9603h0.m59872a0(childAt, iM60160l);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i15 = 0; i15 < childCount2; i15++) {
            m9561j(getChildAt(i15)).m9603d();
        }
        m9580v(i10, i11, i12, i13, false);
        m9581w();
        m9579u();
        int childCount3 = getChildCount();
        for (int i16 = 0; i16 < childCount3; i16++) {
            m9561j(getChildAt(i16)).m9600a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        m9565c();
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        C9625s0 c9625s0 = this.f7417y;
        int iM60160l = c9625s0 != null ? c9625s0.m60160l() : 0;
        if ((mode == 0 || this.f7390A) && iM60160l > 0) {
            this.f7418z = iM60160l;
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + iM60160l, 1073741824));
        }
        if (this.f7392C && this.f7403k.m10610J() > 1) {
            m9581w();
            m9580v(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
            int iM10671y = this.f7403k.m10671y();
            if (iM10671y > 1) {
                this.f7391B = Math.round(this.f7403k.m10673z()) * (iM10671y - 1);
                super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.f7391B, 1073741824));
            }
        }
        ViewGroup viewGroup = this.f7395c;
        if (viewGroup != null) {
            View view = this.f7396d;
            if (view == null || view == this) {
                setMinimumHeight(m9559g(viewGroup));
            } else {
                setMinimumHeight(m9559g(view));
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        Drawable drawable = this.f7407o;
        if (drawable != null) {
            m9576r(drawable, i10, i11);
        }
    }

    /* renamed from: p */
    public final void m9574p(boolean z10) {
        int titleMarginStart;
        int titleMarginBottom;
        int titleMarginEnd;
        int titleMarginTop;
        View view = this.f7396d;
        if (view == null) {
            view = this.f7395c;
        }
        int iM9569h = m9569h(view);
        C1773d.m10677a(this, this.f7397e, this.f7402j);
        ViewGroup viewGroup = this.f7395c;
        if (viewGroup instanceof Toolbar) {
            Toolbar toolbar = (Toolbar) viewGroup;
            titleMarginStart = toolbar.getTitleMarginStart();
            titleMarginEnd = toolbar.getTitleMarginEnd();
            titleMarginTop = toolbar.getTitleMarginTop();
            titleMarginBottom = toolbar.getTitleMarginBottom();
        } else if (viewGroup instanceof android.widget.Toolbar) {
            android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
            titleMarginStart = toolbar2.getTitleMarginStart();
            titleMarginEnd = toolbar2.getTitleMarginEnd();
            titleMarginTop = toolbar2.getTitleMarginTop();
            titleMarginBottom = toolbar2.getTitleMarginBottom();
        } else {
            titleMarginStart = 0;
            titleMarginBottom = 0;
            titleMarginEnd = 0;
            titleMarginTop = 0;
        }
        C1771b c1771b = this.f7403k;
        Rect rect = this.f7402j;
        int i10 = rect.left + (z10 ? titleMarginEnd : titleMarginStart);
        int i11 = rect.top + iM9569h + titleMarginTop;
        int i12 = rect.right;
        if (!z10) {
            titleMarginStart = titleMarginEnd;
        }
        c1771b.m10626b0(i10, i11, i12 - titleMarginStart, (rect.bottom + iM9569h) - titleMarginBottom);
    }

    /* renamed from: q */
    public final void m9575q() {
        setContentDescription(getTitle());
    }

    /* renamed from: r */
    public final void m9576r(Drawable drawable, int i10, int i11) {
        m9577s(drawable, this.f7395c, i10, i11);
    }

    /* renamed from: s */
    public final void m9577s(Drawable drawable, View view, int i10, int i11) {
        if (m9570k() && view != null && this.f7405m) {
            i11 = view.getBottom();
        }
        drawable.setBounds(0, 0, i10, i11);
    }

    public void setCollapsedTitleGravity(int i10) {
        this.f7403k.m10636g0(i10);
    }

    public void setCollapsedTitleTextAppearance(int i10) {
        this.f7403k.m10630d0(i10);
    }

    public void setCollapsedTitleTextColor(int i10) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.f7403k.m10638h0(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.f7407o;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f7407o = drawableMutate;
            if (drawableMutate != null) {
                m9576r(drawableMutate, getWidth(), getHeight());
                this.f7407o.setCallback(this);
                this.f7407o.setAlpha(this.f7409q);
            }
            C9603h0.m59884g0(this);
        }
    }

    public void setContentScrimColor(int i10) {
        setContentScrim(new ColorDrawable(i10));
    }

    public void setContentScrimResource(int i10) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i10));
    }

    public void setExpandedTitleColor(int i10) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setExpandedTitleGravity(int i10) {
        this.f7403k.m10656q0(i10);
    }

    public void setExpandedTitleMarginBottom(int i10) {
        this.f7401i = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i10) {
        this.f7400h = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i10) {
        this.f7398f = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i10) {
        this.f7399g = i10;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i10) {
        this.f7403k.m10650n0(i10);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.f7403k.m10654p0(colorStateList);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.f7403k.m10660s0(typeface);
    }

    public void setExtraMultilineHeightEnabled(boolean z10) {
        this.f7392C = z10;
    }

    public void setForceApplySystemWindowInsetTop(boolean z10) {
        this.f7390A = z10;
    }

    public void setHyphenationFrequency(int i10) {
        this.f7403k.m10670x0(i10);
    }

    public void setLineSpacingAdd(float f10) {
        this.f7403k.m10674z0(f10);
    }

    public void setLineSpacingMultiplier(float f10) {
        this.f7403k.m10593A0(f10);
    }

    public void setMaxLines(int i10) {
        this.f7403k.m10595B0(i10);
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z10) {
        this.f7403k.m10599D0(z10);
    }

    public void setScrimAlpha(int i10) {
        ViewGroup viewGroup;
        if (i10 != this.f7409q) {
            if (this.f7407o != null && (viewGroup = this.f7395c) != null) {
                C9603h0.m59884g0(viewGroup);
            }
            this.f7409q = i10;
            C9603h0.m59884g0(this);
        }
    }

    public void setScrimAnimationDuration(long j10) {
        this.f7412t = j10;
    }

    public void setScrimVisibleHeightTrigger(int i10) {
        if (this.f7413u != i10) {
            this.f7413u = i10;
            m9579u();
        }
    }

    public void setScrimsShown(boolean z10) {
        m9573o(z10, C9603h0.m59864T(this) && !isInEditMode());
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.f7408p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f7408p = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f7408p.setState(getDrawableState());
                }
                C13669a.m82226g(this.f7408p, C9603h0.m59832A(this));
                this.f7408p.setVisible(getVisibility() == 0, false);
                this.f7408p.setCallback(this);
                this.f7408p.setAlpha(this.f7409q);
            }
            C9603h0.m59884g0(this);
        }
    }

    public void setStatusBarScrimColor(int i10) {
        setStatusBarScrim(new ColorDrawable(i10));
    }

    public void setStatusBarScrimResource(int i10) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i10));
    }

    public void setTitle(CharSequence charSequence) {
        this.f7403k.m10603F0(charSequence);
        m9575q();
    }

    public void setTitleCollapseMode(int i10) throws Resources.NotFoundException {
        this.f7416x = i10;
        boolean zM9570k = m9570k();
        this.f7403k.m10666v0(zM9570k);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            m9564b((AppBarLayout) parent);
        }
        if (zM9570k && this.f7407o == null) {
            setContentScrimColor(this.f7404l.m10411d(getResources().getDimension(R$dimen.design_appbar_elevation)));
        }
    }

    public void setTitleEnabled(boolean z10) {
        if (z10 != this.f7405m) {
            this.f7405m = z10;
            m9575q();
            m9578t();
            requestLayout();
        }
    }

    public void setTitlePositionInterpolator(TimeInterpolator timeInterpolator) {
        this.f7403k.m10597C0(timeInterpolator);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f7408p;
        if (drawable != null && drawable.isVisible() != z10) {
            this.f7408p.setVisible(z10, false);
        }
        Drawable drawable2 = this.f7407o;
        if (drawable2 == null || drawable2.isVisible() == z10) {
            return;
        }
        this.f7407o.setVisible(z10, false);
    }

    /* renamed from: t */
    public final void m9578t() {
        View view;
        if (!this.f7405m && (view = this.f7397e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f7397e);
            }
        }
        if (!this.f7405m || this.f7395c == null) {
            return;
        }
        if (this.f7397e == null) {
            this.f7397e = new View(getContext());
        }
        if (this.f7397e.getParent() == null) {
            this.f7395c.addView(this.f7397e, -1, -1);
        }
    }

    /* renamed from: u */
    public final void m9579u() {
        if (this.f7407o == null && this.f7408p == null) {
            return;
        }
        setScrimsShown(getHeight() + this.f7415w < getScrimVisibleHeightTrigger());
    }

    /* renamed from: v */
    public final void m9580v(int i10, int i11, int i12, int i13, boolean z10) {
        View view;
        if (!this.f7405m || (view = this.f7397e) == null) {
            return;
        }
        boolean z11 = C9603h0.m59863S(view) && this.f7397e.getVisibility() == 0;
        this.f7406n = z11;
        if (z11 || z10) {
            boolean z12 = C9603h0.m59832A(this) == 1;
            m9574p(z12);
            this.f7403k.m10644k0(z12 ? this.f7400h : this.f7398f, this.f7402j.top + this.f7399g, (i12 - i10) - (z12 ? this.f7398f : this.f7400h), (i13 - i11) - this.f7401i);
            this.f7403k.m10624Z(z10);
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f7407o || drawable == this.f7408p;
    }

    /* renamed from: w */
    public final void m9581w() {
        if (this.f7395c != null && this.f7405m && TextUtils.isEmpty(this.f7403k.m10613M())) {
            setTitle(m9560i(this.f7395c));
        }
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.collapsingToolbarLayoutStyle);
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.f7403k.m10634f0(colorStateList);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        int i11 = f7389D;
        super(C10981a.m66348c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f7393a = true;
        this.f7402j = new Rect();
        this.f7413u = -1;
        this.f7418z = 0;
        this.f7391B = 0;
        Context context2 = getContext();
        C1771b c1771b = new C1771b(this);
        this.f7403k = c1771b;
        c1771b.m10605G0(C13110a.f59601e);
        c1771b.m10599D0(false);
        this.f7404l = new ElevationOverlayProvider(context2);
        TypedArray typedArrayM10770h = C1784o.m10770h(context2, attributeSet, R$styleable.CollapsingToolbarLayout, i10, i11, new int[0]);
        c1771b.m10656q0(typedArrayM10770h.getInt(R$styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        c1771b.m10636g0(typedArrayM10770h.getInt(R$styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = typedArrayM10770h.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.f7401i = dimensionPixelSize;
        this.f7400h = dimensionPixelSize;
        this.f7399g = dimensionPixelSize;
        this.f7398f = dimensionPixelSize;
        int i12 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginStart;
        if (typedArrayM10770h.hasValue(i12)) {
            this.f7398f = typedArrayM10770h.getDimensionPixelSize(i12, 0);
        }
        int i13 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginEnd;
        if (typedArrayM10770h.hasValue(i13)) {
            this.f7400h = typedArrayM10770h.getDimensionPixelSize(i13, 0);
        }
        int i14 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginTop;
        if (typedArrayM10770h.hasValue(i14)) {
            this.f7399g = typedArrayM10770h.getDimensionPixelSize(i14, 0);
        }
        int i15 = R$styleable.CollapsingToolbarLayout_expandedTitleMarginBottom;
        if (typedArrayM10770h.hasValue(i15)) {
            this.f7401i = typedArrayM10770h.getDimensionPixelSize(i15, 0);
        }
        this.f7405m = typedArrayM10770h.getBoolean(R$styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(typedArrayM10770h.getText(R$styleable.CollapsingToolbarLayout_title));
        c1771b.m10650n0(R$style.TextAppearance_Design_CollapsingToolbar_Expanded);
        c1771b.m10630d0(androidx.appcompat.R$style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        int i16 = R$styleable.CollapsingToolbarLayout_expandedTitleTextAppearance;
        if (typedArrayM10770h.hasValue(i16)) {
            c1771b.m10650n0(typedArrayM10770h.getResourceId(i16, 0));
        }
        int i17 = R$styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance;
        if (typedArrayM10770h.hasValue(i17)) {
            c1771b.m10630d0(typedArrayM10770h.getResourceId(i17, 0));
        }
        int i18 = R$styleable.CollapsingToolbarLayout_expandedTitleTextColor;
        if (typedArrayM10770h.hasValue(i18)) {
            c1771b.m10654p0(C9649c.m60265a(context2, typedArrayM10770h, i18));
        }
        int i19 = R$styleable.CollapsingToolbarLayout_collapsedTitleTextColor;
        if (typedArrayM10770h.hasValue(i19)) {
            c1771b.m10634f0(C9649c.m60265a(context2, typedArrayM10770h, i19));
        }
        this.f7413u = typedArrayM10770h.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        int i20 = R$styleable.CollapsingToolbarLayout_maxLines;
        if (typedArrayM10770h.hasValue(i20)) {
            c1771b.m10595B0(typedArrayM10770h.getInt(i20, 1));
        }
        int i21 = R$styleable.CollapsingToolbarLayout_titlePositionInterpolator;
        if (typedArrayM10770h.hasValue(i21)) {
            c1771b.m10597C0(AnimationUtils.loadInterpolator(context2, typedArrayM10770h.getResourceId(i21, 0)));
        }
        this.f7412t = typedArrayM10770h.getInt(R$styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(typedArrayM10770h.getDrawable(R$styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(typedArrayM10770h.getDrawable(R$styleable.CollapsingToolbarLayout_statusBarScrim));
        setTitleCollapseMode(typedArrayM10770h.getInt(R$styleable.CollapsingToolbarLayout_titleCollapseMode, 0));
        this.f7394b = typedArrayM10770h.getResourceId(R$styleable.CollapsingToolbarLayout_toolbarId, -1);
        this.f7390A = typedArrayM10770h.getBoolean(R$styleable.CollapsingToolbarLayout_forceApplySystemWindowInsetTop, false);
        this.f7392C = typedArrayM10770h.getBoolean(R$styleable.CollapsingToolbarLayout_extraMultilineHeightEnabled, false);
        typedArrayM10770h.recycle();
        setWillNotDraw(false);
        C9603h0.m59837C0(this, new C1645a());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* renamed from: a */
        public int f7419a;

        /* renamed from: b */
        public float f7420b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f7419a = 0;
            this.f7420b = 0.5f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CollapsingToolbarLayout_Layout);
            this.f7419a = typedArrayObtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            m9582a(typedArrayObtainStyledAttributes.getFloat(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            typedArrayObtainStyledAttributes.recycle();
        }

        /* renamed from: a */
        public void m9582a(float f10) {
            this.f7420b = f10;
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
            this.f7419a = 0;
            this.f7420b = 0.5f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f7419a = 0;
            this.f7420b = 0.5f;
        }
    }
}
