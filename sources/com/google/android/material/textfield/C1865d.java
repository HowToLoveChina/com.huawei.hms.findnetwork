package com.google.android.material.textfield;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.internal.C1783n;
import com.google.android.material.textfield.TextInputLayout;
import p273f0.C9603h0;
import p304g0.C9823c;
import p304g0.C9832l;
import p356i3.C10427h;
import p356i3.C10432m;
import p666u2.C13110a;
import p760x2.C13689a;

/* renamed from: com.google.android.material.textfield.d */
/* loaded from: classes.dex */
public class C1865d extends AbstractC1866e {

    /* renamed from: t */
    public static final boolean f8913t = true;

    /* renamed from: e */
    public final TextWatcher f8914e;

    /* renamed from: f */
    public final View.OnFocusChangeListener f8915f;

    /* renamed from: g */
    public final TextInputLayout.C1859e f8916g;

    /* renamed from: h */
    public final TextInputLayout.InterfaceC1860f f8917h;

    /* renamed from: i */
    @SuppressLint({"ClickableViewAccessibility"})
    public final TextInputLayout.InterfaceC1861g f8918i;

    /* renamed from: j */
    public final View.OnAttachStateChangeListener f8919j;

    /* renamed from: k */
    public final C9823c.b f8920k;

    /* renamed from: l */
    public boolean f8921l;

    /* renamed from: m */
    public boolean f8922m;

    /* renamed from: n */
    public long f8923n;

    /* renamed from: o */
    public StateListDrawable f8924o;

    /* renamed from: p */
    public C10427h f8925p;

    /* renamed from: q */
    public AccessibilityManager f8926q;

    /* renamed from: r */
    public ValueAnimator f8927r;

    /* renamed from: s */
    public ValueAnimator f8928s;

    /* renamed from: com.google.android.material.textfield.d$a */
    public class a extends C1783n {

        /* renamed from: com.google.android.material.textfield.d$a$a, reason: collision with other inner class name */
        public class RunnableC14419a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ AutoCompleteTextView f8930a;

            public RunnableC14419a(AutoCompleteTextView autoCompleteTextView) {
                this.f8930a = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean zIsPopupShowing = this.f8930a.isPopupShowing();
                C1865d.this.m11315J(zIsPopupShowing);
                C1865d.this.f8921l = zIsPopupShowing;
            }
        }

        public a() {
        }

        @Override // com.google.android.material.internal.C1783n, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView autoCompleteTextViewM11286C = C1865d.m11286C(C1865d.this.f8946a.getEditText());
            if (C1865d.this.f8926q.isTouchExplorationEnabled() && C1865d.m11288H(autoCompleteTextViewM11286C) && !C1865d.this.f8948c.hasFocus()) {
                autoCompleteTextViewM11286C.dismissDropDown();
            }
            autoCompleteTextViewM11286C.post(new RunnableC14419a(autoCompleteTextViewM11286C));
        }
    }

    /* renamed from: com.google.android.material.textfield.d$b */
    public class b implements AutoCompleteTextView.OnDismissListener {
        public b() {
        }

        @Override // android.widget.AutoCompleteTextView.OnDismissListener
        public void onDismiss() {
            C1865d.this.m11319N();
            C1865d.this.m11315J(false);
        }
    }

    /* renamed from: com.google.android.material.textfield.d$c */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1865d c1865d = C1865d.this;
            c1865d.f8948c.setChecked(c1865d.f8922m);
            C1865d.this.f8928s.start();
        }
    }

    /* renamed from: com.google.android.material.textfield.d$d */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            C1865d.this.f8948c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.google.android.material.textfield.d$e */
    public class e implements View.OnFocusChangeListener {
        public e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            C1865d.this.f8946a.setEndIconActivated(z10);
            if (z10) {
                return;
            }
            C1865d.this.m11315J(false);
            C1865d.this.f8921l = false;
        }
    }

    /* renamed from: com.google.android.material.textfield.d$f */
    public class f extends TextInputLayout.C1859e {
        public f(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.C1859e, p273f0.C9582a
        public void onInitializeAccessibilityNodeInfo(View view, C9832l c9832l) {
            super.onInitializeAccessibilityNodeInfo(view, c9832l);
            if (!C1865d.m11288H(C1865d.this.f8946a.getEditText())) {
                c9832l.m61065U(Spinner.class.getName());
            }
            if (c9832l.m61054G()) {
                c9832l.m61084g0(null);
            }
        }

        @Override // p273f0.C9582a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            AutoCompleteTextView autoCompleteTextViewM11286C = C1865d.m11286C(C1865d.this.f8946a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && C1865d.this.f8926q.isEnabled() && !C1865d.m11288H(C1865d.this.f8946a.getEditText())) {
                C1865d.this.m11318M(autoCompleteTextViewM11286C);
                C1865d.this.m11319N();
            }
        }
    }

    /* renamed from: com.google.android.material.textfield.d$g */
    public class g implements TextInputLayout.InterfaceC1860f {
        public g() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.InterfaceC1860f
        /* renamed from: a */
        public void mo11267a(TextInputLayout textInputLayout) {
            AutoCompleteTextView autoCompleteTextViewM11286C = C1865d.m11286C(textInputLayout.getEditText());
            C1865d.this.m11316K(autoCompleteTextViewM11286C);
            C1865d.this.m11323y(autoCompleteTextViewM11286C);
            C1865d.this.m11317L(autoCompleteTextViewM11286C);
            autoCompleteTextViewM11286C.setThreshold(0);
            autoCompleteTextViewM11286C.removeTextChangedListener(C1865d.this.f8914e);
            autoCompleteTextViewM11286C.addTextChangedListener(C1865d.this.f8914e);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!C1865d.m11288H(autoCompleteTextViewM11286C) && C1865d.this.f8926q.isTouchExplorationEnabled()) {
                C9603h0.m59833A0(C1865d.this.f8948c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(C1865d.this.f8916g);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* renamed from: com.google.android.material.textfield.d$h */
    public class h implements TextInputLayout.InterfaceC1861g {

        /* renamed from: com.google.android.material.textfield.d$h$a */
        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ AutoCompleteTextView f8939a;

            public a(AutoCompleteTextView autoCompleteTextView) {
                this.f8939a = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f8939a.removeTextChangedListener(C1865d.this.f8914e);
            }
        }

        public h() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.InterfaceC1861g
        /* renamed from: a */
        public void mo11268a(TextInputLayout textInputLayout, int i10) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView != null && i10 == 3) {
                autoCompleteTextView.post(new a(autoCompleteTextView));
                if (autoCompleteTextView.getOnFocusChangeListener() == C1865d.this.f8915f) {
                    autoCompleteTextView.setOnFocusChangeListener(null);
                }
                autoCompleteTextView.setOnTouchListener(null);
                if (C1865d.f8913t) {
                    autoCompleteTextView.setOnDismissListener(null);
                }
            }
            if (i10 == 3) {
                textInputLayout.removeOnAttachStateChangeListener(C1865d.this.f8919j);
                C1865d.this.m11314I();
            }
        }
    }

    /* renamed from: com.google.android.material.textfield.d$i */
    public class i implements View.OnAttachStateChangeListener {
        public i() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            C1865d.this.m11310B();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            C1865d.this.m11314I();
        }
    }

    /* renamed from: com.google.android.material.textfield.d$j */
    public class j implements C9823c.b {
        public j() {
        }

        @Override // p304g0.C9823c.b
        public void onTouchExplorationStateChanged(boolean z10) {
            AutoCompleteTextView autoCompleteTextView;
            TextInputLayout textInputLayout = C1865d.this.f8946a;
            if (textInputLayout == null || (autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText()) == null || C1865d.m11288H(autoCompleteTextView)) {
                return;
            }
            C9603h0.m59833A0(C1865d.this.f8948c, z10 ? 2 : 1);
        }
    }

    /* renamed from: com.google.android.material.textfield.d$k */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1865d.this.m11318M((AutoCompleteTextView) C1865d.this.f8946a.getEditText());
        }
    }

    /* renamed from: com.google.android.material.textfield.d$l */
    public class l implements View.OnTouchListener {

        /* renamed from: a */
        public final /* synthetic */ AutoCompleteTextView f8944a;

        public l(AutoCompleteTextView autoCompleteTextView) {
            this.f8944a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (C1865d.this.m11313G()) {
                    C1865d.this.f8921l = false;
                }
                C1865d.this.m11318M(this.f8944a);
                C1865d.this.m11319N();
            }
            return false;
        }
    }

    public C1865d(TextInputLayout textInputLayout, int i10) {
        super(textInputLayout, i10);
        this.f8914e = new a();
        this.f8915f = new e();
        this.f8916g = new f(this.f8946a);
        this.f8917h = new g();
        this.f8918i = new h();
        this.f8919j = new i();
        this.f8920k = new j();
        this.f8921l = false;
        this.f8922m = false;
        this.f8923n = Long.MAX_VALUE;
    }

    /* renamed from: C */
    public static AutoCompleteTextView m11286C(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    /* renamed from: F */
    private void m11287F() {
        this.f8928s = m11311D(67, 0.0f, 1.0f);
        ValueAnimator valueAnimatorM11311D = m11311D(50, 1.0f, 0.0f);
        this.f8927r = valueAnimatorM11311D;
        valueAnimatorM11311D.addListener(new c());
    }

    /* renamed from: H */
    public static boolean m11288H(EditText editText) {
        return editText.getKeyListener() != null;
    }

    /* renamed from: A */
    public final void m11309A(AutoCompleteTextView autoCompleteTextView, int i10, int[][] iArr, C10427h c10427h) {
        LayerDrawable layerDrawable;
        int iM82290d = C13689a.m82290d(autoCompleteTextView, R$attr.colorSurface);
        C10427h c10427h2 = new C10427h(c10427h.m63980E());
        int iM82294h = C13689a.m82294h(i10, iM82290d, 0.1f);
        c10427h2.m64002b0(new ColorStateList(iArr, new int[]{iM82294h, 0}));
        if (f8913t) {
            c10427h2.setTint(iM82290d);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iM82294h, iM82290d});
            C10427h c10427h3 = new C10427h(c10427h.m63980E());
            c10427h3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, c10427h2, c10427h3), c10427h});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{c10427h2, c10427h});
        }
        C9603h0.m59910t0(autoCompleteTextView, layerDrawable);
    }

    /* renamed from: B */
    public final void m11310B() {
        TextInputLayout textInputLayout;
        if (this.f8926q == null || (textInputLayout = this.f8946a) == null || !C9603h0.m59863S(textInputLayout)) {
            return;
        }
        C9823c.m61030a(this.f8926q, this.f8920k);
    }

    /* renamed from: D */
    public final ValueAnimator m11311D(int i10, float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(C13110a.f59597a);
        valueAnimatorOfFloat.setDuration(i10);
        valueAnimatorOfFloat.addUpdateListener(new d());
        return valueAnimatorOfFloat;
    }

    /* renamed from: E */
    public final C10427h m11312E(float f10, float f11, float f12, int i10) {
        C10432m c10432mM64093m = C10432m.m64045a().m64087E(f10).m64091I(f10).m64101v(f11).m64105z(f11).m64093m();
        C10427h c10427hM63975m = C10427h.m63975m(this.f8947b, f12);
        c10427hM63975m.setShapeAppearanceModel(c10432mM64093m);
        c10427hM63975m.m64004d0(0, i10, 0, i10);
        return c10427hM63975m;
    }

    /* renamed from: G */
    public final boolean m11313G() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f8923n;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300;
    }

    /* renamed from: I */
    public final void m11314I() {
        AccessibilityManager accessibilityManager = this.f8926q;
        if (accessibilityManager != null) {
            C9823c.m61031b(accessibilityManager, this.f8920k);
        }
    }

    /* renamed from: J */
    public final void m11315J(boolean z10) {
        if (this.f8922m != z10) {
            this.f8922m = z10;
            this.f8928s.cancel();
            this.f8927r.start();
        }
    }

    /* renamed from: K */
    public final void m11316K(AutoCompleteTextView autoCompleteTextView) {
        if (f8913t) {
            int boxBackgroundMode = this.f8946a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.f8925p);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.f8924o);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: L */
    public final void m11317L(AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new l(autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(this.f8915f);
        if (f8913t) {
            autoCompleteTextView.setOnDismissListener(new b());
        }
    }

    /* renamed from: M */
    public final void m11318M(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (m11313G()) {
            this.f8921l = false;
        }
        if (this.f8921l) {
            this.f8921l = false;
            return;
        }
        if (f8913t) {
            m11315J(!this.f8922m);
        } else {
            this.f8922m = !this.f8922m;
            this.f8948c.toggle();
        }
        if (!this.f8922m) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    /* renamed from: N */
    public final void m11319N() {
        this.f8921l = true;
        this.f8923n = System.currentTimeMillis();
    }

    /* renamed from: O */
    public void m11320O(AutoCompleteTextView autoCompleteTextView) {
        if (!m11288H(autoCompleteTextView) && this.f8946a.getBoxBackgroundMode() == 2 && (autoCompleteTextView.getBackground() instanceof LayerDrawable)) {
            m11323y(autoCompleteTextView);
        }
    }

    @Override // com.google.android.material.textfield.AbstractC1866e
    /* renamed from: a */
    public void mo11273a() throws Resources.NotFoundException {
        float dimensionPixelOffset = this.f8947b.getResources().getDimensionPixelOffset(R$dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.f8947b.getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f8947b.getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        C10427h c10427hM11312E = m11312E(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        C10427h c10427hM11312E2 = m11312E(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.f8925p = c10427hM11312E;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f8924o = stateListDrawable;
        stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, c10427hM11312E);
        this.f8924o.addState(new int[0], c10427hM11312E2);
        int i10 = this.f8949d;
        if (i10 == 0) {
            i10 = f8913t ? R$drawable.mtrl_dropdown_arrow : R$drawable.mtrl_ic_arrow_drop_down;
        }
        this.f8946a.setEndIconDrawable(i10);
        TextInputLayout textInputLayout = this.f8946a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.exposed_dropdown_menu_content_description));
        this.f8946a.setEndIconOnClickListener(new k());
        this.f8946a.m11225g(this.f8917h);
        this.f8946a.m11227h(this.f8918i);
        m11287F();
        this.f8926q = (AccessibilityManager) this.f8947b.getSystemService("accessibility");
        this.f8946a.addOnAttachStateChangeListener(this.f8919j);
        m11310B();
    }

    @Override // com.google.android.material.textfield.AbstractC1866e
    /* renamed from: b */
    public boolean mo11321b(int i10) {
        return i10 != 0;
    }

    @Override // com.google.android.material.textfield.AbstractC1866e
    /* renamed from: d */
    public boolean mo11322d() {
        return true;
    }

    /* renamed from: y */
    public final void m11323y(AutoCompleteTextView autoCompleteTextView) {
        if (m11288H(autoCompleteTextView)) {
            return;
        }
        int boxBackgroundMode = this.f8946a.getBoxBackgroundMode();
        C10427h boxBackground = this.f8946a.getBoxBackground();
        int iM82290d = C13689a.m82290d(autoCompleteTextView, R$attr.colorControlHighlight);
        int[][] iArr = {new int[]{R.attr.state_pressed}, new int[0]};
        if (boxBackgroundMode == 2) {
            m11309A(autoCompleteTextView, iM82290d, iArr, boxBackground);
        } else if (boxBackgroundMode == 1) {
            m11324z(autoCompleteTextView, iM82290d, iArr, boxBackground);
        }
    }

    /* renamed from: z */
    public final void m11324z(AutoCompleteTextView autoCompleteTextView, int i10, int[][] iArr, C10427h c10427h) {
        int boxBackgroundColor = this.f8946a.getBoxBackgroundColor();
        int[] iArr2 = {C13689a.m82294h(i10, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (f8913t) {
            C9603h0.m59910t0(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), c10427h, c10427h));
            return;
        }
        C10427h c10427h2 = new C10427h(c10427h.m63980E());
        c10427h2.m64002b0(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{c10427h, c10427h2});
        int iM59842F = C9603h0.m59842F(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int iM59840E = C9603h0.m59840E(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        C9603h0.m59910t0(autoCompleteTextView, layerDrawable);
        C9603h0.m59839D0(autoCompleteTextView, iM59842F, paddingTop, iM59840E, paddingBottom);
    }
}
