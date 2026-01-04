package com.google.android.material.navigation;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.C0411h;
import androidx.appcompat.view.menu.InterfaceC0415l;
import androidx.appcompat.widget.C0531i0;
import androidx.core.content.ContextCompat;
import androidx.core.widget.C0669j;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$string;
import com.google.android.material.badge.C1652a;
import com.google.android.material.badge.C1653b;
import p215d3.C8997a;
import p273f0.C9598f0;
import p273f0.C9603h0;
import p276f3.C9649c;
import p304g0.C9832l;
import p666u2.C13110a;
import p757x.C13669a;

/* loaded from: classes.dex */
public abstract class NavigationBarItemView extends FrameLayout implements InterfaceC0415l.a {

    /* renamed from: C */
    public static final int[] f8419C = {R.attr.state_checked};

    /* renamed from: D */
    public static final C1792d f8420D;

    /* renamed from: E */
    public static final C1792d f8421E;

    /* renamed from: A */
    public int f8422A;

    /* renamed from: B */
    public C1652a f8423B;

    /* renamed from: a */
    public boolean f8424a;

    /* renamed from: b */
    public int f8425b;

    /* renamed from: c */
    public int f8426c;

    /* renamed from: d */
    public float f8427d;

    /* renamed from: e */
    public float f8428e;

    /* renamed from: f */
    public float f8429f;

    /* renamed from: g */
    public int f8430g;

    /* renamed from: h */
    public boolean f8431h;

    /* renamed from: i */
    public final FrameLayout f8432i;

    /* renamed from: j */
    public final View f8433j;

    /* renamed from: k */
    public final ImageView f8434k;

    /* renamed from: l */
    public final ViewGroup f8435l;

    /* renamed from: m */
    public final TextView f8436m;

    /* renamed from: n */
    public final TextView f8437n;

    /* renamed from: o */
    public int f8438o;

    /* renamed from: p */
    public C0411h f8439p;

    /* renamed from: q */
    public ColorStateList f8440q;

    /* renamed from: r */
    public Drawable f8441r;

    /* renamed from: s */
    public Drawable f8442s;

    /* renamed from: t */
    public ValueAnimator f8443t;

    /* renamed from: u */
    public C1792d f8444u;

    /* renamed from: v */
    public float f8445v;

    /* renamed from: w */
    public boolean f8446w;

    /* renamed from: x */
    public int f8447x;

    /* renamed from: y */
    public int f8448y;

    /* renamed from: z */
    public boolean f8449z;

    /* renamed from: com.google.android.material.navigation.NavigationBarItemView$a */
    public class ViewOnLayoutChangeListenerC1789a implements View.OnLayoutChangeListener {
        public ViewOnLayoutChangeListenerC1789a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            if (NavigationBarItemView.this.f8434k.getVisibility() == 0) {
                NavigationBarItemView navigationBarItemView = NavigationBarItemView.this;
                navigationBarItemView.m10812u(navigationBarItemView.f8434k);
            }
        }
    }

    /* renamed from: com.google.android.material.navigation.NavigationBarItemView$b */
    public class RunnableC1790b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ int f8451a;

        public RunnableC1790b(int i10) {
            this.f8451a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            NavigationBarItemView.this.m10813v(this.f8451a);
        }
    }

    /* renamed from: com.google.android.material.navigation.NavigationBarItemView$c */
    public class C1791c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public final /* synthetic */ float f8453a;

        public C1791c(float f10) {
            this.f8453a = f10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            NavigationBarItemView.this.m10809o(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f8453a);
        }
    }

    /* renamed from: com.google.android.material.navigation.NavigationBarItemView$d */
    public static class C1792d {
        public C1792d() {
        }

        /* renamed from: a */
        public float m10815a(float f10, float f11) {
            return C13110a.m78885b(0.0f, 1.0f, f11 == 0.0f ? 0.8f : 0.0f, f11 == 0.0f ? 1.0f : 0.2f, f10);
        }

        /* renamed from: b */
        public float m10816b(float f10, float f11) {
            return C13110a.m78884a(0.4f, 1.0f, f10);
        }

        /* renamed from: c */
        public float mo10817c(float f10, float f11) {
            return 1.0f;
        }

        /* renamed from: d */
        public void m10818d(float f10, float f11, View view) {
            view.setScaleX(m10816b(f10, f11));
            view.setScaleY(mo10817c(f10, f11));
            view.setAlpha(m10815a(f10, f11));
        }

        public /* synthetic */ C1792d(ViewOnLayoutChangeListenerC1789a viewOnLayoutChangeListenerC1789a) {
            this();
        }
    }

    /* renamed from: com.google.android.material.navigation.NavigationBarItemView$e */
    public static class C1793e extends C1792d {
        public C1793e() {
            super(null);
        }

        @Override // com.google.android.material.navigation.NavigationBarItemView.C1792d
        /* renamed from: c */
        public float mo10817c(float f10, float f11) {
            return m10816b(f10, f11);
        }

        public /* synthetic */ C1793e(ViewOnLayoutChangeListenerC1789a viewOnLayoutChangeListenerC1789a) {
            this();
        }
    }

    static {
        ViewOnLayoutChangeListenerC1789a viewOnLayoutChangeListenerC1789a = null;
        f8420D = new C1792d(viewOnLayoutChangeListenerC1789a);
        f8421E = new C1793e(viewOnLayoutChangeListenerC1789a);
    }

    public NavigationBarItemView(Context context) {
        super(context);
        this.f8424a = false;
        this.f8438o = -1;
        this.f8444u = f8420D;
        this.f8445v = 0.0f;
        this.f8446w = false;
        this.f8447x = 0;
        this.f8448y = 0;
        this.f8449z = false;
        this.f8422A = 0;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.f8432i = (FrameLayout) findViewById(R$id.navigation_bar_item_icon_container);
        this.f8433j = findViewById(R$id.navigation_bar_item_active_indicator_view);
        ImageView imageView = (ImageView) findViewById(R$id.navigation_bar_item_icon_view);
        this.f8434k = imageView;
        ViewGroup viewGroup = (ViewGroup) findViewById(R$id.navigation_bar_item_labels_group);
        this.f8435l = viewGroup;
        TextView textView = (TextView) findViewById(R$id.navigation_bar_item_small_label_view);
        this.f8436m = textView;
        TextView textView2 = (TextView) findViewById(R$id.navigation_bar_item_large_label_view);
        this.f8437n = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.f8425b = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.f8426c = viewGroup.getPaddingBottom();
        C9603h0.m59833A0(textView, 2);
        C9603h0.m59833A0(textView2, 2);
        setFocusable(true);
        m10801g(textView.getTextSize(), textView2.getTextSize());
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC1789a());
        }
    }

    private View getIconOrContainer() {
        FrameLayout frameLayout = this.f8432i;
        return frameLayout != null ? frameLayout : this.f8434k;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int i10 = 0;
        for (int i11 = 0; i11 < iIndexOfChild; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i10++;
            }
        }
        return i10;
    }

    private int getSuggestedIconHeight() {
        C1652a c1652a = this.f8423B;
        int minimumHeight = c1652a != null ? c1652a.getMinimumHeight() / 2 : 0;
        return Math.max(minimumHeight, ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin) + this.f8434k.getMeasuredWidth() + minimumHeight;
    }

    private int getSuggestedIconWidth() {
        C1652a c1652a = this.f8423B;
        int minimumWidth = c1652a == null ? 0 : c1652a.getMinimumWidth() - this.f8423B.m9683i();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        return Math.max(minimumWidth, layoutParams.leftMargin) + this.f8434k.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.rightMargin);
    }

    /* renamed from: p */
    public static void m10797p(TextView textView, int i10) throws Resources.NotFoundException {
        C0669j.m4080n(textView, i10);
        int iM60272h = C9649c.m60272h(textView.getContext(), i10, 0);
        if (iM60272h != 0) {
            textView.setTextSize(0, iM60272h);
        }
    }

    /* renamed from: q */
    public static void m10798q(View view, float f10, float f11, int i10) {
        view.setScaleX(f10);
        view.setScaleY(f11);
        view.setVisibility(i10);
    }

    /* renamed from: r */
    public static void m10799r(View view, int i10, int i11) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i10;
        layoutParams.bottomMargin = i10;
        layoutParams.gravity = i11;
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: x */
    public static void m10800x(View view, int i10) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i10);
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0415l.a
    /* renamed from: d */
    public boolean mo2319d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0415l.a
    /* renamed from: e */
    public void mo2320e(C0411h c0411h, int i10) {
        this.f8439p = c0411h;
        setCheckable(c0411h.isCheckable());
        setChecked(c0411h.isChecked());
        setEnabled(c0411h.isEnabled());
        setIcon(c0411h.getIcon());
        setTitle(c0411h.getTitle());
        setId(c0411h.getItemId());
        if (!TextUtils.isEmpty(c0411h.getContentDescription())) {
            setContentDescription(c0411h.getContentDescription());
        }
        C0531i0.m3033a(this, !TextUtils.isEmpty(c0411h.getTooltipText()) ? c0411h.getTooltipText() : c0411h.getTitle());
        setVisibility(c0411h.isVisible() ? 0 : 8);
        this.f8424a = true;
    }

    /* renamed from: g */
    public final void m10801g(float f10, float f11) {
        this.f8427d = f10 - f11;
        this.f8428e = (f11 * 1.0f) / f10;
        this.f8429f = (f10 * 1.0f) / f11;
    }

    public Drawable getActiveIndicatorDrawable() {
        View view = this.f8433j;
        if (view == null) {
            return null;
        }
        return view.getBackground();
    }

    public C1652a getBadge() {
        return this.f8423B;
    }

    public int getItemBackgroundResId() {
        return R$drawable.mtrl_navigation_bar_item_background;
    }

    @Override // androidx.appcompat.view.menu.InterfaceC0415l.a
    public C0411h getItemData() {
        return this.f8439p;
    }

    public int getItemDefaultMarginResId() {
        return R$dimen.mtrl_navigation_bar_item_default_margin;
    }

    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.f8438o;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f8435l.getLayoutParams();
        return getSuggestedIconHeight() + layoutParams.topMargin + this.f8435l.getMeasuredHeight() + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f8435l.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), layoutParams.leftMargin + this.f8435l.getMeasuredWidth() + layoutParams.rightMargin);
    }

    /* renamed from: h */
    public void m10802h() {
        m10808n();
        this.f8439p = null;
        this.f8445v = 0.0f;
        this.f8424a = false;
    }

    /* renamed from: i */
    public final FrameLayout m10803i(View view) {
        ImageView imageView = this.f8434k;
        if (view == imageView && C1653b.f7497a) {
            return (FrameLayout) imageView.getParent();
        }
        return null;
    }

    /* renamed from: j */
    public final boolean m10804j() {
        return this.f8423B != null;
    }

    /* renamed from: k */
    public final boolean m10805k() {
        return this.f8449z && this.f8430g == 2;
    }

    /* renamed from: l */
    public final void m10806l(float f10) {
        if (!this.f8446w || !this.f8424a || !C9603h0.m59863S(this)) {
            m10809o(f10, f10);
            return;
        }
        ValueAnimator valueAnimator = this.f8443t;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f8443t = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f8445v, f10);
        this.f8443t = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new C1791c(f10));
        this.f8443t.setInterpolator(C8997a.m56856e(getContext(), R$attr.motionEasingStandard, C13110a.f59598b));
        this.f8443t.setDuration(C8997a.m56855d(getContext(), R$attr.motionDurationLong1, getResources().getInteger(R$integer.material_motion_duration_long_1)));
        this.f8443t.start();
    }

    /* renamed from: m */
    public final void m10807m() {
        C0411h c0411h = this.f8439p;
        if (c0411h != null) {
            setChecked(c0411h.isChecked());
        }
    }

    /* renamed from: n */
    public void m10808n() {
        m10811t(this.f8434k);
    }

    /* renamed from: o */
    public final void m10809o(float f10, float f11) {
        View view = this.f8433j;
        if (view != null) {
            this.f8444u.m10818d(f10, f11, view);
        }
        this.f8445v = f10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        C0411h c0411h = this.f8439p;
        if (c0411h != null && c0411h.isCheckable() && this.f8439p.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f8419C);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        C1652a c1652a = this.f8423B;
        if (c1652a != null && c1652a.isVisible()) {
            CharSequence title = this.f8439p.getTitle();
            if (!TextUtils.isEmpty(this.f8439p.getContentDescription())) {
                title = this.f8439p.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.f8423B.m9681g()));
        }
        C9832l c9832lM61042A0 = C9832l.m61042A0(accessibilityNodeInfo);
        c9832lM61042A0.m61068X(C9832l.c.m61127a(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            c9832lM61042A0.m61066V(false);
            c9832lM61042A0.m61058N(C9832l.a.f48299i);
        }
        c9832lM61042A0.m61098o0(getResources().getString(R$string.item_view_role_description));
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        post(new RunnableC1790b(i10));
    }

    /* renamed from: s */
    public final void m10810s(View view) {
        if (m10804j() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            C1653b.m9699a(this.f8423B, view, m10803i(view));
        }
    }

    public void setActiveIndicatorDrawable(Drawable drawable) {
        View view = this.f8433j;
        if (view == null) {
            return;
        }
        view.setBackgroundDrawable(drawable);
    }

    public void setActiveIndicatorEnabled(boolean z10) {
        this.f8446w = z10;
        View view = this.f8433j;
        if (view != null) {
            view.setVisibility(z10 ? 0 : 8);
            requestLayout();
        }
    }

    public void setActiveIndicatorHeight(int i10) {
        this.f8448y = i10;
        m10813v(getWidth());
    }

    public void setActiveIndicatorMarginHorizontal(int i10) {
        this.f8422A = i10;
        m10813v(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z10) {
        this.f8449z = z10;
    }

    public void setActiveIndicatorWidth(int i10) {
        this.f8447x = i10;
        m10813v(getWidth());
    }

    public void setBadge(C1652a c1652a) {
        if (this.f8423B == c1652a) {
            return;
        }
        if (m10804j() && this.f8434k != null) {
            Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
            m10811t(this.f8434k);
        }
        this.f8423B = c1652a;
        ImageView imageView = this.f8434k;
        if (imageView != null) {
            m10810s(imageView);
        }
    }

    public void setCheckable(boolean z10) {
        refreshDrawableState();
    }

    public void setChecked(boolean z10) {
        this.f8437n.setPivotX(r0.getWidth() / 2);
        this.f8437n.setPivotY(r0.getBaseline());
        this.f8436m.setPivotX(r0.getWidth() / 2);
        this.f8436m.setPivotY(r0.getBaseline());
        m10806l(z10 ? 1.0f : 0.0f);
        int i10 = this.f8430g;
        if (i10 != -1) {
            if (i10 == 0) {
                if (z10) {
                    m10799r(getIconOrContainer(), this.f8425b, 49);
                    m10800x(this.f8435l, this.f8426c);
                    this.f8437n.setVisibility(0);
                } else {
                    m10799r(getIconOrContainer(), this.f8425b, 17);
                    m10800x(this.f8435l, 0);
                    this.f8437n.setVisibility(4);
                }
                this.f8436m.setVisibility(4);
            } else if (i10 == 1) {
                m10800x(this.f8435l, this.f8426c);
                if (z10) {
                    m10799r(getIconOrContainer(), (int) (this.f8425b + this.f8427d), 49);
                    m10798q(this.f8437n, 1.0f, 1.0f, 0);
                    TextView textView = this.f8436m;
                    float f10 = this.f8428e;
                    m10798q(textView, f10, f10, 4);
                } else {
                    m10799r(getIconOrContainer(), this.f8425b, 49);
                    TextView textView2 = this.f8437n;
                    float f11 = this.f8429f;
                    m10798q(textView2, f11, f11, 4);
                    m10798q(this.f8436m, 1.0f, 1.0f, 0);
                }
            } else if (i10 == 2) {
                m10799r(getIconOrContainer(), this.f8425b, 17);
                this.f8437n.setVisibility(8);
                this.f8436m.setVisibility(8);
            }
        } else if (this.f8431h) {
            if (z10) {
                m10799r(getIconOrContainer(), this.f8425b, 49);
                m10800x(this.f8435l, this.f8426c);
                this.f8437n.setVisibility(0);
            } else {
                m10799r(getIconOrContainer(), this.f8425b, 17);
                m10800x(this.f8435l, 0);
                this.f8437n.setVisibility(4);
            }
            this.f8436m.setVisibility(4);
        } else {
            m10800x(this.f8435l, this.f8426c);
            if (z10) {
                m10799r(getIconOrContainer(), (int) (this.f8425b + this.f8427d), 49);
                m10798q(this.f8437n, 1.0f, 1.0f, 0);
                TextView textView3 = this.f8436m;
                float f12 = this.f8428e;
                m10798q(textView3, f12, f12, 4);
            } else {
                m10799r(getIconOrContainer(), this.f8425b, 49);
                TextView textView4 = this.f8437n;
                float f13 = this.f8429f;
                m10798q(textView4, f13, f13, 4);
                m10798q(this.f8436m, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z10);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.f8436m.setEnabled(z10);
        this.f8437n.setEnabled(z10);
        this.f8434k.setEnabled(z10);
        if (z10) {
            C9603h0.m59841E0(this, C9598f0.m59824b(getContext(), 1002));
        } else {
            C9603h0.m59841E0(this, null);
        }
    }

    public void setIcon(Drawable drawable) {
        if (drawable == this.f8441r) {
            return;
        }
        this.f8441r = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = C13669a.m82231l(drawable).mutate();
            this.f8442s = drawable;
            ColorStateList colorStateList = this.f8440q;
            if (colorStateList != null) {
                C13669a.m82228i(drawable, colorStateList);
            }
        }
        this.f8434k.setImageDrawable(drawable);
    }

    public void setIconSize(int i10) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f8434k.getLayoutParams();
        layoutParams.width = i10;
        layoutParams.height = i10;
        this.f8434k.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.f8440q = colorStateList;
        if (this.f8439p == null || (drawable = this.f8442s) == null) {
            return;
        }
        C13669a.m82228i(drawable, colorStateList);
        this.f8442s.invalidateSelf();
    }

    public void setItemBackground(int i10) {
        setItemBackground(i10 == 0 ? null : ContextCompat.getDrawable(getContext(), i10));
    }

    public void setItemPaddingBottom(int i10) {
        if (this.f8426c != i10) {
            this.f8426c = i10;
            m10807m();
        }
    }

    public void setItemPaddingTop(int i10) {
        if (this.f8425b != i10) {
            this.f8425b = i10;
            m10807m();
        }
    }

    public void setItemPosition(int i10) {
        this.f8438o = i10;
    }

    public void setLabelVisibilityMode(int i10) {
        if (this.f8430g != i10) {
            this.f8430g = i10;
            m10814w();
            m10813v(getWidth());
            m10807m();
        }
    }

    public void setShifting(boolean z10) {
        if (this.f8431h != z10) {
            this.f8431h = z10;
            m10807m();
        }
    }

    public void setTextAppearanceActive(int i10) throws Resources.NotFoundException {
        m10797p(this.f8437n, i10);
        m10801g(this.f8436m.getTextSize(), this.f8437n.getTextSize());
    }

    public void setTextAppearanceInactive(int i10) throws Resources.NotFoundException {
        m10797p(this.f8436m, i10);
        m10801g(this.f8436m.getTextSize(), this.f8437n.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f8436m.setTextColor(colorStateList);
            this.f8437n.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f8436m.setText(charSequence);
        this.f8437n.setText(charSequence);
        C0411h c0411h = this.f8439p;
        if (c0411h == null || TextUtils.isEmpty(c0411h.getContentDescription())) {
            setContentDescription(charSequence);
        }
        C0411h c0411h2 = this.f8439p;
        if (c0411h2 != null && !TextUtils.isEmpty(c0411h2.getTooltipText())) {
            charSequence = this.f8439p.getTooltipText();
        }
        C0531i0.m3033a(this, charSequence);
    }

    /* renamed from: t */
    public final void m10811t(View view) {
        if (m10804j()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                C1653b.m9702d(this.f8423B, view);
            }
            this.f8423B = null;
        }
    }

    /* renamed from: u */
    public final void m10812u(View view) {
        if (m10804j()) {
            C1653b.m9703e(this.f8423B, view, m10803i(view));
        }
    }

    /* renamed from: v */
    public final void m10813v(int i10) {
        if (this.f8433j == null) {
            return;
        }
        int iMin = Math.min(this.f8447x, i10 - (this.f8422A * 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f8433j.getLayoutParams();
        layoutParams.height = m10805k() ? iMin : this.f8448y;
        layoutParams.width = iMin;
        this.f8433j.setLayoutParams(layoutParams);
    }

    /* renamed from: w */
    public final void m10814w() {
        if (m10805k()) {
            this.f8444u = f8421E;
        } else {
            this.f8444u = f8420D;
        }
    }

    public void setItemBackground(Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        C9603h0.m59910t0(this, drawable);
    }
}
