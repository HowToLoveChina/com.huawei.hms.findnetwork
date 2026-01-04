package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.C1788s;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.C1837a;
import java.util.List;
import p273f0.C9603h0;
import p276f3.C9649c;
import p383j3.InterfaceC10701a;
import p416k3.C10981a;
import p666u2.C13110a;
import p757x.C13669a;
import p760x2.C13689a;

/* loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* renamed from: a */
    public final ViewGroup f8633a;

    /* renamed from: b */
    public final SnackbarBaseLayout f8634b;

    /* renamed from: c */
    public final InterfaceC10701a f8635c;

    /* renamed from: d */
    public boolean f8636d;

    /* renamed from: e */
    public final Runnable f8637e;

    /* renamed from: f */
    public int f8638f;

    /* renamed from: g */
    public int f8639g;

    /* renamed from: h */
    public int f8640h;

    /* renamed from: i */
    public int f8641i;

    /* renamed from: j */
    public int f8642j;

    /* renamed from: k */
    public boolean f8643k;

    /* renamed from: l */
    public List<AbstractC1835m<B>> f8644l;

    /* renamed from: m */
    public Behavior f8645m;

    /* renamed from: n */
    public final AccessibilityManager f8646n;

    /* renamed from: o */
    public C1837a.b f8647o;

    /* renamed from: q */
    public static final boolean f8630q = false;

    /* renamed from: r */
    public static final int[] f8631r = {R$attr.snackbarStyle};

    /* renamed from: s */
    public static final String f8632s = BaseTransientBottomBar.class.getSimpleName();

    /* renamed from: p */
    public static final Handler f8629p = new Handler(Looper.getMainLooper(), new C1830h());

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: k */
        public final C1836n f8648k = new C1836n(this);

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        /* renamed from: E */
        public boolean mo9717E(View view) {
            return this.f8648k.m11023a(view);
        }

        /* renamed from: P */
        public final void m11016P(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f8648k.m11025c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: k */
        public boolean mo3737k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f8648k.m11024b(coordinatorLayout, view, motionEvent);
            return super.mo3737k(coordinatorLayout, view, motionEvent);
        }
    }

    public static class SnackbarBaseLayout extends FrameLayout {

        /* renamed from: k */
        public static final View.OnTouchListener f8649k = new ViewOnTouchListenerC1822a();

        /* renamed from: a */
        public BaseTransientBottomBar<?> f8650a;

        /* renamed from: b */
        public int f8651b;

        /* renamed from: c */
        public final float f8652c;

        /* renamed from: d */
        public final float f8653d;

        /* renamed from: e */
        public final int f8654e;

        /* renamed from: f */
        public final int f8655f;

        /* renamed from: g */
        public ColorStateList f8656g;

        /* renamed from: h */
        public PorterDuff.Mode f8657h;

        /* renamed from: i */
        public Rect f8658i;

        /* renamed from: j */
        public boolean f8659j;

        /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout$a */
        public class ViewOnTouchListenerC1822a implements View.OnTouchListener {
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public SnackbarBaseLayout(Context context) {
            this(context, null);
        }

        private void setBaseTransientBottomBar(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f8650a = baseTransientBottomBar;
        }

        /* renamed from: b */
        public void m11018b(ViewGroup viewGroup) {
            this.f8659j = true;
            viewGroup.addView(this);
            this.f8659j = false;
        }

        /* renamed from: c */
        public final Drawable m11019c() throws Resources.NotFoundException {
            float dimension = getResources().getDimension(R$dimen.mtrl_snackbar_background_corner_radius);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(C13689a.m82295i(this, R$attr.colorSurface, R$attr.colorOnSurface, getBackgroundOverlayColorAlpha()));
            if (this.f8656g == null) {
                return C13669a.m82231l(gradientDrawable);
            }
            Drawable drawableM82231l = C13669a.m82231l(gradientDrawable);
            C13669a.m82228i(drawableM82231l, this.f8656g);
            return drawableM82231l;
        }

        /* renamed from: d */
        public final void m11020d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f8658i = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        public float getActionTextColorAlpha() {
            return this.f8653d;
        }

        public int getAnimationMode() {
            return this.f8651b;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.f8652c;
        }

        public int getMaxInlineActionWidth() {
            return this.f8655f;
        }

        public int getMaxWidth() {
            return this.f8654e;
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f8650a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.m11006r();
            }
            C9603h0.m59896m0(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f8650a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.m11007s();
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
            super.onLayout(z10, i10, i11, i12, i13);
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f8650a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.m11008t();
            }
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (this.f8654e > 0) {
                int measuredWidth = getMeasuredWidth();
                int i12 = this.f8654e;
                if (measuredWidth > i12) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
                }
            }
        }

        public void setAnimationMode(int i10) {
            this.f8651b = i10;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null && this.f8656g != null) {
                drawable = C13669a.m82231l(drawable.mutate());
                C13669a.m82228i(drawable, this.f8656g);
                C13669a.m82229j(drawable, this.f8657h);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f8656g = colorStateList;
            if (getBackground() != null) {
                Drawable drawableM82231l = C13669a.m82231l(getBackground().mutate());
                C13669a.m82228i(drawableM82231l, colorStateList);
                C13669a.m82229j(drawableM82231l, this.f8657h);
                if (drawableM82231l != getBackground()) {
                    super.setBackgroundDrawable(drawableM82231l);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f8657h = mode;
            if (getBackground() != null) {
                Drawable drawableM82231l = C13669a.m82231l(getBackground().mutate());
                C13669a.m82229j(drawableM82231l, mode);
                if (drawableM82231l != getBackground()) {
                    super.setBackgroundDrawable(drawableM82231l);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (this.f8659j || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            m11020d((ViewGroup.MarginLayoutParams) layoutParams);
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f8650a;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.m10993G();
            }
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f8649k);
            super.setOnClickListener(onClickListener);
        }

        public SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
            super(C10981a.m66348c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
            if (typedArrayObtainStyledAttributes.hasValue(R$styleable.SnackbarLayout_elevation)) {
                C9603h0.m59918x0(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(r1, 0));
            }
            this.f8651b = typedArrayObtainStyledAttributes.getInt(R$styleable.SnackbarLayout_animationMode, 0);
            this.f8652c = typedArrayObtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(C9649c.m60265a(context2, typedArrayObtainStyledAttributes, R$styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(C1788s.m10789j(typedArrayObtainStyledAttributes.getInt(R$styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.f8653d = typedArrayObtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            this.f8654e = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_android_maxWidth, -1);
            this.f8655f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_maxActionInlineWidth, -1);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(f8649k);
            setFocusable(true);
            if (getBackground() == null) {
                C9603h0.m59910t0(this, m11019c());
            }
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$a */
    public class C1823a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ int f8660a;

        public C1823a(int i10) {
            this.f8660a = i10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.m11009u(this.f8660a);
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$b */
    public class C1824b implements ValueAnimator.AnimatorUpdateListener {
        public C1824b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f8634b.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$c */
    public class C1825c implements ValueAnimator.AnimatorUpdateListener {
        public C1825c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.f8634b.setScaleX(fFloatValue);
            BaseTransientBottomBar.this.f8634b.setScaleY(fFloatValue);
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$d */
    public class C1826d extends AnimatorListenerAdapter {
        public C1826d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.m11010v();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f8635c.mo11027a(70, 180);
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$e */
    public class C1827e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public int f8665a;

        /* renamed from: b */
        public final /* synthetic */ int f8666b;

        public C1827e(int i10) {
            this.f8666b = i10;
            this.f8665a = i10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.f8630q) {
                C9603h0.m59872a0(BaseTransientBottomBar.this.f8634b, iIntValue - this.f8665a);
            } else {
                BaseTransientBottomBar.this.f8634b.setTranslationY(iIntValue);
            }
            this.f8665a = iIntValue;
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$f */
    public class C1828f extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ int f8668a;

        public C1828f(int i10) {
            this.f8668a = i10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.m11009u(this.f8668a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f8635c.mo11028b(0, 180);
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$g */
    public class C1829g implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public int f8670a = 0;

        public C1829g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.f8630q) {
                C9603h0.m59872a0(BaseTransientBottomBar.this.f8634b, iIntValue - this.f8670a);
            } else {
                BaseTransientBottomBar.this.f8634b.setTranslationY(iIntValue);
            }
            this.f8670a = iIntValue;
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$h */
    public class C1830h implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                ((BaseTransientBottomBar) message.obj).m10987A();
                return true;
            }
            if (i10 != 1) {
                return false;
            }
            ((BaseTransientBottomBar) message.obj).m11003o(message.arg1);
            return true;
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$i */
    public class RunnableC1831i implements Runnable {
        public RunnableC1831i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseTransientBottomBar.this.m11009u(3);
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$j */
    public class C1832j implements SwipeDismissBehavior.InterfaceC1657c {
        public C1832j() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.InterfaceC1657c
        /* renamed from: a */
        public void mo9725a(View view) {
            if (view.getParent() != null) {
                view.setVisibility(8);
            }
            BaseTransientBottomBar.this.m10997i(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.InterfaceC1657c
        /* renamed from: b */
        public void mo9726b(int i10) {
            if (i10 == 0) {
                C1837a.m11030c().m11040k(BaseTransientBottomBar.this.f8647o);
            } else if (i10 == 1 || i10 == 2) {
                C1837a.m11030c().m11039j(BaseTransientBottomBar.this.f8647o);
            }
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$k */
    public class RunnableC1833k implements Runnable {
        public RunnableC1833k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SnackbarBaseLayout snackbarBaseLayout = BaseTransientBottomBar.this.f8634b;
            if (snackbarBaseLayout == null) {
                return;
            }
            if (snackbarBaseLayout.getParent() != null) {
                BaseTransientBottomBar.this.f8634b.setVisibility(0);
            }
            if (BaseTransientBottomBar.this.f8634b.getAnimationMode() == 1) {
                BaseTransientBottomBar.this.m10989C();
            } else {
                BaseTransientBottomBar.this.m10991E();
            }
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$l */
    public class C1834l extends AnimatorListenerAdapter {
        public C1834l() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.m11010v();
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$m */
    public static abstract class AbstractC1835m<B> {
        /* renamed from: a */
        public void m11021a(B b10, int i10) {
        }

        /* renamed from: b */
        public void m11022b(B b10) {
        }
    }

    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$n */
    public static class C1836n {

        /* renamed from: a */
        public C1837a.b f8676a;

        public C1836n(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.m9721L(0.1f);
            swipeDismissBehavior.m9719J(0.6f);
            swipeDismissBehavior.m9722M(0);
        }

        /* renamed from: a */
        public boolean m11023a(View view) {
            return view instanceof SnackbarBaseLayout;
        }

        /* renamed from: b */
        public void m11024b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.m3691F(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    C1837a.m11030c().m11039j(this.f8676a);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                C1837a.m11030c().m11040k(this.f8676a);
            }
        }

        /* renamed from: c */
        public void m11025c(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f8676a = baseTransientBottomBar.f8647o;
        }
    }

    /* renamed from: A */
    public final void m10987A() {
        if (this.f8634b.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f8634b.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.C0594e) {
                m11012x((CoordinatorLayout.C0594e) layoutParams);
            }
            this.f8634b.m11018b(this.f8633a);
            m11011w();
            this.f8634b.setVisibility(4);
        }
        if (C9603h0.m59864T(this.f8634b)) {
            m10988B();
        } else {
            this.f8643k = true;
        }
    }

    /* renamed from: B */
    public final void m10988B() {
        if (m11013y()) {
            m10994f();
            return;
        }
        if (this.f8634b.getParent() != null) {
            this.f8634b.setVisibility(0);
        }
        m11010v();
    }

    /* renamed from: C */
    public final void m10989C() {
        ValueAnimator valueAnimatorM10998j = m10998j(0.0f, 1.0f);
        ValueAnimator valueAnimatorM11001m = m11001m(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorM10998j, valueAnimatorM11001m);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new C1834l());
        animatorSet.start();
    }

    /* renamed from: D */
    public final void m10990D(int i10) {
        ValueAnimator valueAnimatorM10998j = m10998j(1.0f, 0.0f);
        valueAnimatorM10998j.setDuration(75L);
        valueAnimatorM10998j.addListener(new C1823a(i10));
        valueAnimatorM10998j.start();
    }

    /* renamed from: E */
    public final void m10991E() {
        int iM11002n = m11002n();
        if (f8630q) {
            C9603h0.m59872a0(this.f8634b, iM11002n);
        } else {
            this.f8634b.setTranslationY(iM11002n);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iM11002n, 0);
        valueAnimator.setInterpolator(C13110a.f59598b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new C1826d());
        valueAnimator.addUpdateListener(new C1827e(iM11002n));
        valueAnimator.start();
    }

    /* renamed from: F */
    public final void m10992F(int i10) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, m11002n());
        valueAnimator.setInterpolator(C13110a.f59598b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new C1828f(i10));
        valueAnimator.addUpdateListener(new C1829g());
        valueAnimator.start();
    }

    /* renamed from: G */
    public final void m10993G() {
        ViewGroup.LayoutParams layoutParams = this.f8634b.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || this.f8634b.f8658i == null) {
            Log.w(f8632s, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        if (this.f8634b.getParent() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = this.f8634b.f8658i.bottom + (m10999k() != null ? this.f8642j : this.f8638f);
        marginLayoutParams.leftMargin = this.f8634b.f8658i.left + this.f8639g;
        marginLayoutParams.rightMargin = this.f8634b.f8658i.right + this.f8640h;
        marginLayoutParams.topMargin = this.f8634b.f8658i.top;
        this.f8634b.requestLayout();
        if (m11014z()) {
            this.f8634b.removeCallbacks(this.f8637e);
            this.f8634b.post(this.f8637e);
        }
    }

    /* renamed from: f */
    public void m10994f() {
        this.f8634b.post(new RunnableC1833k());
    }

    /* renamed from: g */
    public final void m10995g(int i10) {
        if (this.f8634b.getAnimationMode() == 1) {
            m10990D(i10);
        } else {
            m10992F(i10);
        }
    }

    /* renamed from: h */
    public final int m10996h() {
        if (m10999k() == null) {
            return 0;
        }
        int[] iArr = new int[2];
        m10999k().getLocationOnScreen(iArr);
        int i10 = iArr[1];
        int[] iArr2 = new int[2];
        this.f8633a.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f8633a.getHeight()) - i10;
    }

    /* renamed from: i */
    public void m10997i(int i10) {
        C1837a.m11030c().m11032b(this.f8647o, i10);
    }

    /* renamed from: j */
    public final ValueAnimator m10998j(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(C13110a.f59597a);
        valueAnimatorOfFloat.addUpdateListener(new C1824b());
        return valueAnimatorOfFloat;
    }

    /* renamed from: k */
    public View m10999k() {
        return null;
    }

    /* renamed from: l */
    public SwipeDismissBehavior<? extends View> m11000l() {
        return new Behavior();
    }

    /* renamed from: m */
    public final ValueAnimator m11001m(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(C13110a.f59600d);
        valueAnimatorOfFloat.addUpdateListener(new C1825c());
        return valueAnimatorOfFloat;
    }

    /* renamed from: n */
    public final int m11002n() {
        int height = this.f8634b.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f8634b.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* renamed from: o */
    public final void m11003o(int i10) {
        if (m11013y() && this.f8634b.getVisibility() == 0) {
            m10995g(i10);
        } else {
            m11009u(i10);
        }
    }

    /* renamed from: p */
    public boolean m11004p() {
        return C1837a.m11030c().m11034e(this.f8647o);
    }

    /* renamed from: q */
    public final boolean m11005q() {
        ViewGroup.LayoutParams layoutParams = this.f8634b.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.C0594e) && (((CoordinatorLayout.C0594e) layoutParams).m3761f() instanceof SwipeDismissBehavior);
    }

    /* renamed from: r */
    public void m11006r() {
        WindowInsets rootWindowInsets = this.f8634b.getRootWindowInsets();
        if (rootWindowInsets != null) {
            this.f8641i = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
            m10993G();
        }
    }

    /* renamed from: s */
    public void m11007s() {
        if (m11004p()) {
            f8629p.post(new RunnableC1831i());
        }
    }

    /* renamed from: t */
    public void m11008t() {
        if (this.f8643k) {
            m10988B();
            this.f8643k = false;
        }
    }

    /* renamed from: u */
    public void m11009u(int i10) {
        C1837a.m11030c().m11037h(this.f8647o);
        List<AbstractC1835m<B>> list = this.f8644l;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f8644l.get(size).m11021a(this, i10);
            }
        }
        ViewParent parent = this.f8634b.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f8634b);
        }
    }

    /* renamed from: v */
    public void m11010v() {
        C1837a.m11030c().m11038i(this.f8647o);
        List<AbstractC1835m<B>> list = this.f8644l;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f8644l.get(size).m11022b(this);
            }
        }
    }

    /* renamed from: w */
    public final void m11011w() {
        this.f8642j = m10996h();
        m10993G();
    }

    /* renamed from: x */
    public final void m11012x(CoordinatorLayout.C0594e c0594e) {
        SwipeDismissBehavior<? extends View> swipeDismissBehaviorM11000l = this.f8645m;
        if (swipeDismissBehaviorM11000l == null) {
            swipeDismissBehaviorM11000l = m11000l();
        }
        if (swipeDismissBehaviorM11000l instanceof Behavior) {
            ((Behavior) swipeDismissBehaviorM11000l).m11016P(this);
        }
        swipeDismissBehaviorM11000l.m9720K(new C1832j());
        c0594e.m3770o(swipeDismissBehaviorM11000l);
        if (m10999k() == null) {
            c0594e.f3280g = 80;
        }
    }

    /* renamed from: y */
    public boolean m11013y() {
        AccessibilityManager accessibilityManager = this.f8646n;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    /* renamed from: z */
    public final boolean m11014z() {
        return this.f8641i > 0 && !this.f8636d && m11005q();
    }
}
