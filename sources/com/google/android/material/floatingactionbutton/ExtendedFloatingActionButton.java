package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R$animator;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.C1773d;
import com.google.android.material.internal.C1784o;
import java.util.Iterator;
import java.util.List;
import p027b3.AbstractC1104b;
import p027b3.C1103a;
import p273f0.C9603h0;
import p356i3.C10432m;
import p416k3.C10981a;
import p666u2.C13117h;

/* loaded from: classes.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.InterfaceC0591b {

    /* renamed from: H */
    public static final int f8071H = R$style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;

    /* renamed from: I */
    public static final Property<View, Float> f8072I = new C1747d(Float.class, "width");

    /* renamed from: J */
    public static final Property<View, Float> f8073J = new C1748e(Float.class, "height");

    /* renamed from: K */
    public static final Property<View, Float> f8074K = new C1749f(Float.class, "paddingStart");

    /* renamed from: L */
    public static final Property<View, Float> f8075L = new C1750g(Float.class, "paddingEnd");

    /* renamed from: A */
    public int f8076A;

    /* renamed from: B */
    public int f8077B;

    /* renamed from: C */
    public final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> f8078C;

    /* renamed from: D */
    public boolean f8079D;

    /* renamed from: E */
    public boolean f8080E;

    /* renamed from: F */
    public boolean f8081F;

    /* renamed from: G */
    public ColorStateList f8082G;

    /* renamed from: t */
    public int f8083t;

    /* renamed from: u */
    public final C1103a f8084u;

    /* renamed from: v */
    public final InterfaceC1761b f8085v;

    /* renamed from: w */
    public final InterfaceC1761b f8086w;

    /* renamed from: x */
    public final InterfaceC1761b f8087x;

    /* renamed from: y */
    public final InterfaceC1761b f8088y;

    /* renamed from: z */
    public final int f8089z;

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$a */
    public class C1744a implements InterfaceC1755l {
        public C1744a() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.InterfaceC1755l
        /* renamed from: a */
        public ViewGroup.LayoutParams mo10442a() {
            return new ViewGroup.LayoutParams(-2, -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.InterfaceC1755l
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getMeasuredHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.InterfaceC1755l
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.this.f8077B;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.InterfaceC1755l
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.this.f8076A;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.InterfaceC1755l
        public int getWidth() {
            return (ExtendedFloatingActionButton.this.getMeasuredWidth() - (ExtendedFloatingActionButton.this.getCollapsedPadding() * 2)) + ExtendedFloatingActionButton.this.f8076A + ExtendedFloatingActionButton.this.f8077B;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$b */
    public class C1745b implements InterfaceC1755l {
        public C1745b() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.InterfaceC1755l
        /* renamed from: a */
        public ViewGroup.LayoutParams mo10442a() {
            return new ViewGroup.LayoutParams(getWidth(), getHeight());
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.InterfaceC1755l
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.InterfaceC1755l
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.InterfaceC1755l
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.InterfaceC1755l
        public int getWidth() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$c */
    public class C1746c extends AnimatorListenerAdapter {

        /* renamed from: a */
        public boolean f8095a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC1761b f8096b;

        public C1746c(InterfaceC1761b interfaceC1761b, AbstractC1753j abstractC1753j) {
            this.f8096b = interfaceC1761b;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f8095a = true;
            this.f8096b.mo6558a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f8096b.mo6560f();
            if (this.f8095a) {
                return;
            }
            this.f8096b.mo10454j(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f8096b.onAnimationStart(animator);
            this.f8095a = false;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$d */
    public class C1747d extends Property<View, Float> {
        public C1747d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f10) {
            view.getLayoutParams().width = f10.intValue();
            view.requestLayout();
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$e */
    public class C1748e extends Property<View, Float> {
        public C1748e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f10) {
            view.getLayoutParams().height = f10.intValue();
            view.requestLayout();
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$f */
    public class C1749f extends Property<View, Float> {
        public C1749f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(C9603h0.m59842F(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f10) {
            C9603h0.m59839D0(view, f10.intValue(), view.getPaddingTop(), C9603h0.m59840E(view), view.getPaddingBottom());
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$g */
    public class C1750g extends Property<View, Float> {
        public C1750g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(C9603h0.m59840E(view));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f10) {
            C9603h0.m59839D0(view, C9603h0.m59842F(view), view.getPaddingTop(), f10.intValue(), view.getPaddingBottom());
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$h */
    public class C1751h extends AbstractC1104b {

        /* renamed from: g */
        public final InterfaceC1755l f8098g;

        /* renamed from: h */
        public final boolean f8099h;

        public C1751h(C1103a c1103a, InterfaceC1755l interfaceC1755l, boolean z10) {
            super(ExtendedFloatingActionButton.this, c1103a);
            this.f8098g = interfaceC1755l;
            this.f8099h = z10;
        }

        @Override // com.google.android.material.floatingactionbutton.InterfaceC1761b
        /* renamed from: b */
        public int mo10451b() {
            return this.f8099h ? R$animator.mtrl_extended_fab_change_size_expand_motion_spec : R$animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.InterfaceC1761b
        /* renamed from: c */
        public void mo10452c() {
            ExtendedFloatingActionButton.this.f8079D = this.f8099h;
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f8098g.mo10442a().width;
            layoutParams.height = this.f8098g.mo10442a().height;
            C9603h0.m59839D0(ExtendedFloatingActionButton.this, this.f8098g.getPaddingStart(), ExtendedFloatingActionButton.this.getPaddingTop(), this.f8098g.getPaddingEnd(), ExtendedFloatingActionButton.this.getPaddingBottom());
            ExtendedFloatingActionButton.this.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.InterfaceC1761b
        /* renamed from: e */
        public boolean mo10453e() {
            return this.f8099h == ExtendedFloatingActionButton.this.f8079D || ExtendedFloatingActionButton.this.getIcon() == null || TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText());
        }

        @Override // p027b3.AbstractC1104b, com.google.android.material.floatingactionbutton.InterfaceC1761b
        /* renamed from: f */
        public void mo6560f() {
            super.mo6560f();
            ExtendedFloatingActionButton.this.f8080E = false;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f8098g.mo10442a().width;
            layoutParams.height = this.f8098g.mo10442a().height;
        }

        @Override // p027b3.AbstractC1104b, com.google.android.material.floatingactionbutton.InterfaceC1761b
        /* renamed from: h */
        public AnimatorSet mo6562h() {
            C13117h c13117hM6565m = m6565m();
            if (c13117hM6565m.m78905j("width")) {
                PropertyValuesHolder[] propertyValuesHolderArrM78902g = c13117hM6565m.m78902g("width");
                propertyValuesHolderArrM78902g[0].setFloatValues(ExtendedFloatingActionButton.this.getWidth(), this.f8098g.getWidth());
                c13117hM6565m.m78907l("width", propertyValuesHolderArrM78902g);
            }
            if (c13117hM6565m.m78905j("height")) {
                PropertyValuesHolder[] propertyValuesHolderArrM78902g2 = c13117hM6565m.m78902g("height");
                propertyValuesHolderArrM78902g2[0].setFloatValues(ExtendedFloatingActionButton.this.getHeight(), this.f8098g.getHeight());
                c13117hM6565m.m78907l("height", propertyValuesHolderArrM78902g2);
            }
            if (c13117hM6565m.m78905j("paddingStart")) {
                PropertyValuesHolder[] propertyValuesHolderArrM78902g3 = c13117hM6565m.m78902g("paddingStart");
                propertyValuesHolderArrM78902g3[0].setFloatValues(C9603h0.m59842F(ExtendedFloatingActionButton.this), this.f8098g.getPaddingStart());
                c13117hM6565m.m78907l("paddingStart", propertyValuesHolderArrM78902g3);
            }
            if (c13117hM6565m.m78905j("paddingEnd")) {
                PropertyValuesHolder[] propertyValuesHolderArrM78902g4 = c13117hM6565m.m78902g("paddingEnd");
                propertyValuesHolderArrM78902g4[0].setFloatValues(C9603h0.m59840E(ExtendedFloatingActionButton.this), this.f8098g.getPaddingEnd());
                c13117hM6565m.m78907l("paddingEnd", propertyValuesHolderArrM78902g4);
            }
            if (c13117hM6565m.m78905j("labelOpacity")) {
                PropertyValuesHolder[] propertyValuesHolderArrM78902g5 = c13117hM6565m.m78902g("labelOpacity");
                boolean z10 = this.f8099h;
                propertyValuesHolderArrM78902g5[0].setFloatValues(z10 ? 0.0f : 1.0f, z10 ? 1.0f : 0.0f);
                c13117hM6565m.m78907l("labelOpacity", propertyValuesHolderArrM78902g5);
            }
            return super.m6564l(c13117hM6565m);
        }

        @Override // com.google.android.material.floatingactionbutton.InterfaceC1761b
        /* renamed from: j */
        public void mo10454j(AbstractC1753j abstractC1753j) {
        }

        @Override // p027b3.AbstractC1104b, com.google.android.material.floatingactionbutton.InterfaceC1761b
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.f8079D = this.f8099h;
            ExtendedFloatingActionButton.this.f8080E = true;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$i */
    public class C1752i extends AbstractC1104b {

        /* renamed from: g */
        public boolean f8101g;

        public C1752i(C1103a c1103a) {
            super(ExtendedFloatingActionButton.this, c1103a);
        }

        @Override // p027b3.AbstractC1104b, com.google.android.material.floatingactionbutton.InterfaceC1761b
        /* renamed from: a */
        public void mo6558a() {
            super.mo6558a();
            this.f8101g = true;
        }

        @Override // com.google.android.material.floatingactionbutton.InterfaceC1761b
        /* renamed from: b */
        public int mo10451b() {
            return R$animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.InterfaceC1761b
        /* renamed from: c */
        public void mo10452c() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.InterfaceC1761b
        /* renamed from: e */
        public boolean mo10453e() {
            return ExtendedFloatingActionButton.this.m10427w();
        }

        @Override // p027b3.AbstractC1104b, com.google.android.material.floatingactionbutton.InterfaceC1761b
        /* renamed from: f */
        public void mo6560f() {
            super.mo6560f();
            ExtendedFloatingActionButton.this.f8083t = 0;
            if (this.f8101g) {
                return;
            }
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.InterfaceC1761b
        /* renamed from: j */
        public void mo10454j(AbstractC1753j abstractC1753j) {
        }

        @Override // p027b3.AbstractC1104b, com.google.android.material.floatingactionbutton.InterfaceC1761b
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f8101g = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.f8083t = 1;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$j */
    public static abstract class AbstractC1753j {
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$k */
    public class C1754k extends AbstractC1104b {
        public C1754k(C1103a c1103a) {
            super(ExtendedFloatingActionButton.this, c1103a);
        }

        @Override // com.google.android.material.floatingactionbutton.InterfaceC1761b
        /* renamed from: b */
        public int mo10451b() {
            return R$animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.InterfaceC1761b
        /* renamed from: c */
        public void mo10452c() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.InterfaceC1761b
        /* renamed from: e */
        public boolean mo10453e() {
            return ExtendedFloatingActionButton.this.m10428x();
        }

        @Override // p027b3.AbstractC1104b, com.google.android.material.floatingactionbutton.InterfaceC1761b
        /* renamed from: f */
        public void mo6560f() {
            super.mo6560f();
            ExtendedFloatingActionButton.this.f8083t = 0;
        }

        @Override // com.google.android.material.floatingactionbutton.InterfaceC1761b
        /* renamed from: j */
        public void mo10454j(AbstractC1753j abstractC1753j) {
        }

        @Override // p027b3.AbstractC1104b, com.google.android.material.floatingactionbutton.InterfaceC1761b
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.f8083t = 2;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$l */
    public interface InterfaceC1755l {
        /* renamed from: a */
        ViewGroup.LayoutParams mo10442a();

        int getHeight();

        int getPaddingEnd();

        int getPaddingStart();

        int getWidth();
    }

    public ExtendedFloatingActionButton(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public boolean m10427w() {
        return getVisibility() == 0 ? this.f8083t == 1 : this.f8083t != 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public boolean m10428x() {
        return getVisibility() != 0 ? this.f8083t == 2 : this.f8083t != 1;
    }

    /* renamed from: A */
    public final boolean m10429A() {
        return (C9603h0.m59864T(this) || (!m10428x() && this.f8081F)) && !isInEditMode();
    }

    /* renamed from: B */
    public void m10430B(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.InterfaceC0591b
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.f8078C;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    public int getCollapsedSize() {
        int i10 = this.f8089z;
        return i10 < 0 ? (Math.min(C9603h0.m59842F(this), C9603h0.m59840E(this)) * 2) + getIconSize() : i10;
    }

    public C13117h getExtendMotionSpec() {
        return this.f8086w.mo6559d();
    }

    public C13117h getHideMotionSpec() {
        return this.f8088y.mo6559d();
    }

    public C13117h getShowMotionSpec() {
        return this.f8087x.mo6559d();
    }

    public C13117h getShrinkMotionSpec() {
        return this.f8085v.mo6559d();
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f8079D && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.f8079D = false;
            this.f8085v.mo10452c();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z10) {
        this.f8081F = z10;
    }

    public void setExtendMotionSpec(C13117h c13117h) {
        this.f8086w.mo6561g(c13117h);
    }

    public void setExtendMotionSpecResource(int i10) {
        setExtendMotionSpec(C13117h.m78898d(getContext(), i10));
    }

    public void setExtended(boolean z10) {
        if (this.f8079D == z10) {
            return;
        }
        InterfaceC1761b interfaceC1761b = z10 ? this.f8086w : this.f8085v;
        if (interfaceC1761b.mo10453e()) {
            return;
        }
        interfaceC1761b.mo10452c();
    }

    public void setHideMotionSpec(C13117h c13117h) {
        this.f8088y.mo6561g(c13117h);
    }

    public void setHideMotionSpecResource(int i10) {
        setHideMotionSpec(C13117h.m78898d(getContext(), i10));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        super.setPadding(i10, i11, i12, i13);
        if (!this.f8079D || this.f8080E) {
            return;
        }
        this.f8076A = C9603h0.m59842F(this);
        this.f8077B = C9603h0.m59840E(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
        super.setPaddingRelative(i10, i11, i12, i13);
        if (!this.f8079D || this.f8080E) {
            return;
        }
        this.f8076A = i10;
        this.f8077B = i12;
    }

    public void setShowMotionSpec(C13117h c13117h) {
        this.f8087x.mo6561g(c13117h);
    }

    public void setShowMotionSpecResource(int i10) {
        setShowMotionSpec(C13117h.m78898d(getContext(), i10));
    }

    public void setShrinkMotionSpec(C13117h c13117h) {
        this.f8085v.mo6561g(c13117h);
    }

    public void setShrinkMotionSpecResource(int i10) {
        setShrinkMotionSpec(C13117h.m78898d(getContext(), i10));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i10) {
        super.setTextColor(i10);
        m10432z();
    }

    /* renamed from: y */
    public final void m10431y(InterfaceC1761b interfaceC1761b, AbstractC1753j abstractC1753j) {
        if (interfaceC1761b.mo10453e()) {
            return;
        }
        if (!m10429A()) {
            interfaceC1761b.mo10452c();
            interfaceC1761b.mo10454j(abstractC1753j);
            return;
        }
        measure(0, 0);
        AnimatorSet animatorSetMo6562h = interfaceC1761b.mo6562h();
        animatorSetMo6562h.addListener(new C1746c(interfaceC1761b, abstractC1753j));
        Iterator<Animator.AnimatorListener> it = interfaceC1761b.mo6563i().iterator();
        while (it.hasNext()) {
            animatorSetMo6562h.addListener(it.next());
        }
        animatorSetMo6562h.start();
    }

    /* renamed from: z */
    public final void m10432z() {
        this.f8082G = getTextColors();
    }

    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.extendedFloatingActionButtonStyle);
    }

    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: a */
        public Rect f8090a;

        /* renamed from: b */
        public boolean f8091b;

        /* renamed from: c */
        public boolean f8092c;

        public ExtendedFloatingActionButtonBehavior() {
            this.f8091b = false;
            this.f8092c = true;
        }

        /* renamed from: G */
        public static boolean m10433G(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.C0594e) {
                return ((CoordinatorLayout.C0594e) layoutParams).m3761f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        /* renamed from: E */
        public void m10434E(ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.m10431y(this.f8092c ? extendedFloatingActionButton.f8086w : extendedFloatingActionButton.f8087x, null);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public boolean mo3728b(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.mo3728b(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public boolean mo3734h(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                m10440L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!m10433G(view)) {
                return false;
            }
            m10441M(view, extendedFloatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        public boolean mo3738l(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i10) {
            List<View> listM3718v = coordinatorLayout.m3718v(extendedFloatingActionButton);
            int size = listM3718v.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = listM3718v.get(i11);
                if (!(view instanceof AppBarLayout)) {
                    if (m10433G(view) && m10441M(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (m10440L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.m3698M(extendedFloatingActionButton, i10);
            return true;
        }

        /* renamed from: J */
        public final boolean m10438J(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.f8091b || this.f8092c) && ((CoordinatorLayout.C0594e) extendedFloatingActionButton.getLayoutParams()).m3760e() == view.getId();
        }

        /* renamed from: K */
        public void m10439K(ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.m10431y(this.f8092c ? extendedFloatingActionButton.f8085v : extendedFloatingActionButton.f8088y, null);
        }

        /* renamed from: L */
        public final boolean m10440L(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!m10438J(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f8090a == null) {
                this.f8090a = new Rect();
            }
            Rect rect = this.f8090a;
            C1773d.m10677a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                m10439K(extendedFloatingActionButton);
                return true;
            }
            m10434E(extendedFloatingActionButton);
            return true;
        }

        /* renamed from: M */
        public final boolean m10441M(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!m10438J(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.C0594e) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                m10439K(extendedFloatingActionButton);
                return true;
            }
            m10434E(extendedFloatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: g */
        public void mo3733g(CoordinatorLayout.C0594e c0594e) {
            if (c0594e.f3281h == 0) {
                c0594e.f3281h = 80;
            }
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.f8091b = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.f8092c = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f8071H;
        super(C10981a.m66348c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f8083t = 0;
        C1103a c1103a = new C1103a();
        this.f8084u = c1103a;
        C1754k c1754k = new C1754k(c1103a);
        this.f8087x = c1754k;
        C1752i c1752i = new C1752i(c1103a);
        this.f8088y = c1752i;
        this.f8079D = true;
        this.f8080E = false;
        this.f8081F = false;
        Context context2 = getContext();
        this.f8078C = new ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        TypedArray typedArrayM10770h = C1784o.m10770h(context2, attributeSet, R$styleable.ExtendedFloatingActionButton, i10, i11, new int[0]);
        C13117h c13117hM78897c = C13117h.m78897c(context2, typedArrayM10770h, R$styleable.ExtendedFloatingActionButton_showMotionSpec);
        C13117h c13117hM78897c2 = C13117h.m78897c(context2, typedArrayM10770h, R$styleable.ExtendedFloatingActionButton_hideMotionSpec);
        C13117h c13117hM78897c3 = C13117h.m78897c(context2, typedArrayM10770h, R$styleable.ExtendedFloatingActionButton_extendMotionSpec);
        C13117h c13117hM78897c4 = C13117h.m78897c(context2, typedArrayM10770h, R$styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
        this.f8089z = typedArrayM10770h.getDimensionPixelSize(R$styleable.ExtendedFloatingActionButton_collapsedSize, -1);
        this.f8076A = C9603h0.m59842F(this);
        this.f8077B = C9603h0.m59840E(this);
        C1103a c1103a2 = new C1103a();
        C1751h c1751h = new C1751h(c1103a2, new C1744a(), true);
        this.f8086w = c1751h;
        C1751h c1751h2 = new C1751h(c1103a2, new C1745b(), false);
        this.f8085v = c1751h2;
        c1754k.mo6561g(c13117hM78897c);
        c1752i.mo6561g(c13117hM78897c2);
        c1751h.mo6561g(c13117hM78897c3);
        c1751h2.mo6561g(c13117hM78897c4);
        typedArrayM10770h.recycle();
        setShapeAppearanceModel(C10432m.m64051g(context2, attributeSet, i10, i11, C10432m.f50312m).m64093m());
        m10432z();
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        m10432z();
    }
}
