package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.C0523e0;
import androidx.core.widget.C0669j;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1788s;
import com.google.android.material.internal.CheckableImageButton;
import p273f0.C9603h0;
import p273f0.C9620q;
import p276f3.C9649c;
import p304g0.C9832l;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class StartCompoundLayout extends LinearLayout {

    /* renamed from: a */
    public final TextInputLayout f8790a;

    /* renamed from: b */
    public final TextView f8791b;

    /* renamed from: c */
    public CharSequence f8792c;

    /* renamed from: d */
    public final CheckableImageButton f8793d;

    /* renamed from: e */
    public ColorStateList f8794e;

    /* renamed from: f */
    public PorterDuff.Mode f8795f;

    /* renamed from: g */
    public View.OnLongClickListener f8796g;

    /* renamed from: h */
    public boolean f8797h;

    public StartCompoundLayout(TextInputLayout textInputLayout, C0523e0 c0523e0) {
        super(textInputLayout.getContext());
        this.f8790a = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.f8793d = checkableImageButton;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.f8791b = appCompatTextView;
        m11162g(c0523e0);
        m11161f(c0523e0);
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    /* renamed from: a */
    public CharSequence m11156a() {
        return this.f8792c;
    }

    /* renamed from: b */
    public ColorStateList m11157b() {
        return this.f8791b.getTextColors();
    }

    /* renamed from: c */
    public TextView m11158c() {
        return this.f8791b;
    }

    /* renamed from: d */
    public CharSequence m11159d() {
        return this.f8793d.getContentDescription();
    }

    /* renamed from: e */
    public Drawable m11160e() {
        return this.f8793d.getDrawable();
    }

    /* renamed from: f */
    public final void m11161f(C0523e0 c0523e0) {
        this.f8791b.setVisibility(8);
        this.f8791b.setId(R$id.textinput_prefix_text);
        this.f8791b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        C9603h0.m59906r0(this.f8791b, 1);
        m11167l(c0523e0.m2960n(R$styleable.TextInputLayout_prefixTextAppearance, 0));
        int i10 = R$styleable.TextInputLayout_prefixTextColor;
        if (c0523e0.m2965s(i10)) {
            m11168m(c0523e0.m2949c(i10));
        }
        m11166k(c0523e0.m2962p(R$styleable.TextInputLayout_prefixText));
    }

    /* renamed from: g */
    public final void m11162g(C0523e0 c0523e0) {
        if (C9649c.m60273i(getContext())) {
            C9620q.m60125c((ViewGroup.MarginLayoutParams) this.f8793d.getLayoutParams(), 0);
        }
        m11172q(null);
        m11173r(null);
        int i10 = R$styleable.TextInputLayout_startIconTint;
        if (c0523e0.m2965s(i10)) {
            this.f8794e = C9649c.m60266b(getContext(), c0523e0, i10);
        }
        int i11 = R$styleable.TextInputLayout_startIconTintMode;
        if (c0523e0.m2965s(i11)) {
            this.f8795f = C1788s.m10789j(c0523e0.m2957k(i11, -1), null);
        }
        int i12 = R$styleable.TextInputLayout_startIconDrawable;
        if (c0523e0.m2965s(i12)) {
            m11171p(c0523e0.m2953g(i12));
            int i13 = R$styleable.TextInputLayout_startIconContentDescription;
            if (c0523e0.m2965s(i13)) {
                m11170o(c0523e0.m2962p(i13));
            }
            m11169n(c0523e0.m2947a(R$styleable.TextInputLayout_startIconCheckable, true));
        }
    }

    /* renamed from: h */
    public boolean m11163h() {
        return this.f8793d.getVisibility() == 0;
    }

    /* renamed from: i */
    public void m11164i(boolean z10) {
        this.f8797h = z10;
        m11179x();
    }

    /* renamed from: j */
    public void m11165j() {
        C1867f.m11327c(this.f8790a, this.f8793d, this.f8794e);
    }

    /* renamed from: k */
    public void m11166k(CharSequence charSequence) {
        this.f8792c = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f8791b.setText(charSequence);
        m11179x();
    }

    /* renamed from: l */
    public void m11167l(int i10) {
        C0669j.m4080n(this.f8791b, i10);
    }

    /* renamed from: m */
    public void m11168m(ColorStateList colorStateList) {
        this.f8791b.setTextColor(colorStateList);
    }

    /* renamed from: n */
    public void m11169n(boolean z10) {
        this.f8793d.setCheckable(z10);
    }

    /* renamed from: o */
    public void m11170o(CharSequence charSequence) {
        if (m11159d() != charSequence) {
            this.f8793d.setContentDescription(charSequence);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        m11178w();
    }

    /* renamed from: p */
    public void m11171p(Drawable drawable) {
        this.f8793d.setImageDrawable(drawable);
        if (drawable != null) {
            C1867f.m11325a(this.f8790a, this.f8793d, this.f8794e, this.f8795f);
            m11176u(true);
            m11165j();
        } else {
            m11176u(false);
            m11172q(null);
            m11173r(null);
            m11170o(null);
        }
    }

    /* renamed from: q */
    public void m11172q(View.OnClickListener onClickListener) {
        C1867f.m11329e(this.f8793d, onClickListener, this.f8796g);
    }

    /* renamed from: r */
    public void m11173r(View.OnLongClickListener onLongClickListener) {
        this.f8796g = onLongClickListener;
        C1867f.m11330f(this.f8793d, onLongClickListener);
    }

    /* renamed from: s */
    public void m11174s(ColorStateList colorStateList) {
        if (this.f8794e != colorStateList) {
            this.f8794e = colorStateList;
            C1867f.m11325a(this.f8790a, this.f8793d, colorStateList, this.f8795f);
        }
    }

    /* renamed from: t */
    public void m11175t(PorterDuff.Mode mode) {
        if (this.f8795f != mode) {
            this.f8795f = mode;
            C1867f.m11325a(this.f8790a, this.f8793d, this.f8794e, mode);
        }
    }

    /* renamed from: u */
    public void m11176u(boolean z10) {
        if (m11163h() != z10) {
            this.f8793d.setVisibility(z10 ? 0 : 8);
            m11178w();
            m11179x();
        }
    }

    /* renamed from: v */
    public void m11177v(C9832l c9832l) {
        if (this.f8791b.getVisibility() != 0) {
            c9832l.m61116x0(this.f8793d);
        } else {
            c9832l.m61085h0(this.f8791b);
            c9832l.m61116x0(this.f8791b);
        }
    }

    /* renamed from: w */
    public void m11178w() {
        EditText editText = this.f8790a.f8840e;
        if (editText == null) {
            return;
        }
        C9603h0.m59839D0(this.f8791b, m11163h() ? 0 : C9603h0.m59842F(editText), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
    }

    /* renamed from: x */
    public final void m11179x() {
        int i10 = (this.f8792c == null || this.f8797h) ? 8 : 0;
        setVisibility((this.f8793d.getVisibility() == 0 || i10 == 0) ? 0 : 8);
        this.f8791b.setVisibility(i10);
        this.f8790a.m11245q0();
    }
}
