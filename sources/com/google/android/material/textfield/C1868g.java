package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.C0669j;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import java.util.ArrayList;
import java.util.List;
import p273f0.C9603h0;
import p276f3.C9649c;
import p666u2.C13110a;
import p666u2.C13111b;

/* renamed from: com.google.android.material.textfield.g */
/* loaded from: classes.dex */
public final class C1868g {

    /* renamed from: a */
    public final Context f8950a;

    /* renamed from: b */
    public final TextInputLayout f8951b;

    /* renamed from: c */
    public LinearLayout f8952c;

    /* renamed from: d */
    public int f8953d;

    /* renamed from: e */
    public FrameLayout f8954e;

    /* renamed from: f */
    public Animator f8955f;

    /* renamed from: g */
    public final float f8956g;

    /* renamed from: h */
    public int f8957h;

    /* renamed from: i */
    public int f8958i;

    /* renamed from: j */
    public CharSequence f8959j;

    /* renamed from: k */
    public boolean f8960k;

    /* renamed from: l */
    public TextView f8961l;

    /* renamed from: m */
    public CharSequence f8962m;

    /* renamed from: n */
    public int f8963n;

    /* renamed from: o */
    public ColorStateList f8964o;

    /* renamed from: p */
    public CharSequence f8965p;

    /* renamed from: q */
    public boolean f8966q;

    /* renamed from: r */
    public TextView f8967r;

    /* renamed from: s */
    public int f8968s;

    /* renamed from: t */
    public ColorStateList f8969t;

    /* renamed from: u */
    public Typeface f8970u;

    /* renamed from: com.google.android.material.textfield.g$a */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ int f8971a;

        /* renamed from: b */
        public final /* synthetic */ TextView f8972b;

        /* renamed from: c */
        public final /* synthetic */ int f8973c;

        /* renamed from: d */
        public final /* synthetic */ TextView f8974d;

        public a(int i10, TextView textView, int i11, TextView textView2) {
            this.f8971a = i10;
            this.f8972b = textView;
            this.f8973c = i11;
            this.f8974d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1868g.this.f8957h = this.f8971a;
            C1868g.this.f8955f = null;
            TextView textView = this.f8972b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f8973c == 1 && C1868g.this.f8961l != null) {
                    C1868g.this.f8961l.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f8974d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f8974d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f8974d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    /* renamed from: com.google.android.material.textfield.g$b */
    public class b extends View.AccessibilityDelegate {
        public b() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            EditText editText = C1868g.this.f8951b.getEditText();
            if (editText != null) {
                accessibilityNodeInfo.setLabeledBy(editText);
            }
        }
    }

    public C1868g(TextInputLayout textInputLayout) {
        this.f8950a = textInputLayout.getContext();
        this.f8951b = textInputLayout;
        this.f8956g = r0.getResources().getDimensionPixelSize(R$dimen.design_textinput_caption_translate_y);
    }

    /* renamed from: A */
    public boolean m11335A() {
        return this.f8966q;
    }

    /* renamed from: B */
    public void m11336B(TextView textView, int i10) {
        FrameLayout frameLayout;
        if (this.f8952c == null) {
            return;
        }
        if (!m11372y(i10) || (frameLayout = this.f8954e) == null) {
            this.f8952c.removeView(textView);
        } else {
            frameLayout.removeView(textView);
        }
        int i11 = this.f8953d - 1;
        this.f8953d = i11;
        m11347M(this.f8952c, i11);
    }

    /* renamed from: C */
    public final void m11337C(int i10, int i11) {
        TextView textViewM11360m;
        TextView textViewM11360m2;
        if (i10 == i11) {
            return;
        }
        if (i11 != 0 && (textViewM11360m2 = m11360m(i11)) != null) {
            textViewM11360m2.setVisibility(0);
            textViewM11360m2.setAlpha(1.0f);
        }
        if (i10 != 0 && (textViewM11360m = m11360m(i10)) != null) {
            textViewM11360m.setVisibility(4);
            if (i10 == 1) {
                textViewM11360m.setText((CharSequence) null);
            }
        }
        this.f8957h = i11;
    }

    /* renamed from: D */
    public void m11338D(CharSequence charSequence) {
        this.f8962m = charSequence;
        TextView textView = this.f8961l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    /* renamed from: E */
    public void m11339E(boolean z10) {
        if (this.f8960k == z10) {
            return;
        }
        m11355h();
        if (z10) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f8950a);
            this.f8961l = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_error);
            this.f8961l.setTextAlignment(5);
            Typeface typeface = this.f8970u;
            if (typeface != null) {
                this.f8961l.setTypeface(typeface);
            }
            m11340F(this.f8963n);
            m11341G(this.f8964o);
            m11338D(this.f8962m);
            this.f8961l.setVisibility(4);
            C9603h0.m59906r0(this.f8961l, 1);
            m11352e(this.f8961l, 0);
        } else {
            m11369v();
            m11336B(this.f8961l, 0);
            this.f8961l = null;
            this.f8951b.m11247r0();
            this.f8951b.m11201E0();
        }
        this.f8960k = z10;
    }

    /* renamed from: F */
    public void m11340F(int i10) {
        this.f8963n = i10;
        TextView textView = this.f8961l;
        if (textView != null) {
            this.f8951b.m11222d0(textView, i10);
        }
    }

    /* renamed from: G */
    public void m11341G(ColorStateList colorStateList) {
        this.f8964o = colorStateList;
        TextView textView = this.f8961l;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    /* renamed from: H */
    public void m11342H(int i10) {
        this.f8968s = i10;
        TextView textView = this.f8967r;
        if (textView != null) {
            C0669j.m4080n(textView, i10);
        }
    }

    /* renamed from: I */
    public void m11343I(boolean z10) {
        if (this.f8966q == z10) {
            return;
        }
        m11355h();
        if (z10) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f8950a);
            this.f8967r = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_helper_text);
            this.f8967r.setTextAlignment(5);
            Typeface typeface = this.f8970u;
            if (typeface != null) {
                this.f8967r.setTypeface(typeface);
            }
            this.f8967r.setVisibility(4);
            C9603h0.m59906r0(this.f8967r, 1);
            m11342H(this.f8968s);
            m11344J(this.f8969t);
            m11352e(this.f8967r, 1);
            this.f8967r.setAccessibilityDelegate(new b());
        } else {
            m11370w();
            m11336B(this.f8967r, 1);
            this.f8967r = null;
            this.f8951b.m11247r0();
            this.f8951b.m11201E0();
        }
        this.f8966q = z10;
    }

    /* renamed from: J */
    public void m11344J(ColorStateList colorStateList) {
        this.f8969t = colorStateList;
        TextView textView = this.f8967r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    /* renamed from: K */
    public final void m11345K(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    /* renamed from: L */
    public void m11346L(Typeface typeface) {
        if (typeface != this.f8970u) {
            this.f8970u = typeface;
            m11345K(this.f8961l, typeface);
            m11345K(this.f8967r, typeface);
        }
    }

    /* renamed from: M */
    public final void m11347M(ViewGroup viewGroup, int i10) {
        if (i10 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    /* renamed from: N */
    public final boolean m11348N(TextView textView, CharSequence charSequence) {
        return C9603h0.m59864T(this.f8951b) && this.f8951b.isEnabled() && !(this.f8958i == this.f8957h && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    /* renamed from: O */
    public void m11349O(CharSequence charSequence) {
        m11355h();
        this.f8959j = charSequence;
        this.f8961l.setText(charSequence);
        int i10 = this.f8957h;
        if (i10 != 1) {
            this.f8958i = 1;
        }
        m11351Q(i10, this.f8958i, m11348N(this.f8961l, charSequence));
    }

    /* renamed from: P */
    public void m11350P(CharSequence charSequence) {
        m11355h();
        this.f8965p = charSequence;
        this.f8967r.setText(charSequence);
        int i10 = this.f8957h;
        if (i10 != 2) {
            this.f8958i = 2;
        }
        m11351Q(i10, this.f8958i, m11348N(this.f8967r, charSequence));
    }

    /* renamed from: Q */
    public final void m11351Q(int i10, int i11, boolean z10) {
        if (i10 == i11) {
            return;
        }
        if (z10) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f8955f = animatorSet;
            ArrayList arrayList = new ArrayList();
            m11356i(arrayList, this.f8966q, this.f8967r, 2, i10, i11);
            m11356i(arrayList, this.f8960k, this.f8961l, 1, i10, i11);
            C13111b.m78887a(animatorSet, arrayList);
            animatorSet.addListener(new a(i11, m11360m(i10), i10, m11360m(i11)));
            animatorSet.start();
        } else {
            m11337C(i10, i11);
        }
        this.f8951b.m11247r0();
        this.f8951b.m11257w0(z10);
        this.f8951b.m11201E0();
    }

    /* renamed from: e */
    public void m11352e(TextView textView, int i10) {
        if (this.f8952c == null && this.f8954e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f8950a);
            this.f8952c = linearLayout;
            linearLayout.setOrientation(0);
            this.f8951b.addView(this.f8952c, -1, -2);
            this.f8954e = new FrameLayout(this.f8950a);
            this.f8952c.addView(this.f8954e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f8951b.getEditText() != null) {
                m11353f();
            }
        }
        if (m11372y(i10)) {
            this.f8954e.setVisibility(0);
            this.f8954e.addView(textView);
        } else {
            this.f8952c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f8952c.setVisibility(0);
        this.f8953d++;
    }

    /* renamed from: f */
    public void m11353f() {
        if (m11354g()) {
            EditText editText = this.f8951b.getEditText();
            boolean zM60273i = C9649c.m60273i(this.f8950a);
            LinearLayout linearLayout = this.f8952c;
            int i10 = R$dimen.material_helper_text_font_1_3_padding_horizontal;
            C9603h0.m59839D0(linearLayout, m11368u(zM60273i, i10, C9603h0.m59842F(editText)), m11368u(zM60273i, R$dimen.material_helper_text_font_1_3_padding_top, this.f8950a.getResources().getDimensionPixelSize(R$dimen.material_helper_text_default_padding_top)), m11368u(zM60273i, i10, C9603h0.m59840E(editText)), 0);
        }
    }

    /* renamed from: g */
    public final boolean m11354g() {
        return (this.f8952c == null || this.f8951b.getEditText() == null) ? false : true;
    }

    /* renamed from: h */
    public void m11355h() {
        Animator animator = this.f8955f;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* renamed from: i */
    public final void m11356i(List<Animator> list, boolean z10, TextView textView, int i10, int i11, int i12) {
        if (textView == null || !z10) {
            return;
        }
        if (i10 == i12 || i10 == i11) {
            list.add(m11357j(textView, i12 == i10));
            if (i12 == i10) {
                list.add(m11358k(textView));
            }
        }
    }

    /* renamed from: j */
    public final ObjectAnimator m11357j(TextView textView, boolean z10) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z10 ? 1.0f : 0.0f);
        objectAnimatorOfFloat.setDuration(167L);
        objectAnimatorOfFloat.setInterpolator(C13110a.f59597a);
        return objectAnimatorOfFloat;
    }

    /* renamed from: k */
    public final ObjectAnimator m11358k(TextView textView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f8956g, 0.0f);
        objectAnimatorOfFloat.setDuration(217L);
        objectAnimatorOfFloat.setInterpolator(C13110a.f59600d);
        return objectAnimatorOfFloat;
    }

    /* renamed from: l */
    public boolean m11359l() {
        return m11371x(this.f8958i);
    }

    /* renamed from: m */
    public final TextView m11360m(int i10) {
        if (i10 == 1) {
            return this.f8961l;
        }
        if (i10 != 2) {
            return null;
        }
        return this.f8967r;
    }

    /* renamed from: n */
    public CharSequence m11361n() {
        return this.f8962m;
    }

    /* renamed from: o */
    public CharSequence m11362o() {
        return this.f8959j;
    }

    /* renamed from: p */
    public int m11363p() {
        TextView textView = this.f8961l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* renamed from: q */
    public ColorStateList m11364q() {
        TextView textView = this.f8961l;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* renamed from: r */
    public CharSequence m11365r() {
        return this.f8965p;
    }

    /* renamed from: s */
    public View m11366s() {
        return this.f8967r;
    }

    /* renamed from: t */
    public int m11367t() {
        TextView textView = this.f8967r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* renamed from: u */
    public final int m11368u(boolean z10, int i10, int i11) {
        return z10 ? this.f8950a.getResources().getDimensionPixelSize(i10) : i11;
    }

    /* renamed from: v */
    public void m11369v() {
        this.f8959j = null;
        m11355h();
        if (this.f8957h == 1) {
            if (!this.f8966q || TextUtils.isEmpty(this.f8965p)) {
                this.f8958i = 0;
            } else {
                this.f8958i = 2;
            }
        }
        m11351Q(this.f8957h, this.f8958i, m11348N(this.f8961l, ""));
    }

    /* renamed from: w */
    public void m11370w() {
        m11355h();
        int i10 = this.f8957h;
        if (i10 == 2) {
            this.f8958i = 0;
        }
        m11351Q(i10, this.f8958i, m11348N(this.f8967r, ""));
    }

    /* renamed from: x */
    public final boolean m11371x(int i10) {
        return (i10 != 1 || this.f8961l == null || TextUtils.isEmpty(this.f8959j)) ? false : true;
    }

    /* renamed from: y */
    public boolean m11372y(int i10) {
        return i10 == 0 || i10 == 1;
    }

    /* renamed from: z */
    public boolean m11373z() {
        return this.f8960k;
    }
}
