package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import p666u2.C13110a;

/* renamed from: com.google.android.material.textfield.a */
/* loaded from: classes.dex */
public class C1862a extends AbstractC1866e {

    /* renamed from: e */
    public final TextWatcher f8894e;

    /* renamed from: f */
    public final View.OnFocusChangeListener f8895f;

    /* renamed from: g */
    public final TextInputLayout.InterfaceC1860f f8896g;

    /* renamed from: h */
    public final TextInputLayout.InterfaceC1861g f8897h;

    /* renamed from: i */
    public AnimatorSet f8898i;

    /* renamed from: j */
    public ValueAnimator f8899j;

    /* renamed from: com.google.android.material.textfield.a$a */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (C1862a.this.f8946a.getSuffixText() != null) {
                return;
            }
            C1862a c1862a = C1862a.this;
            c1862a.m11275i(c1862a.m11279m());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* renamed from: com.google.android.material.textfield.a$b */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z10) {
            C1862a c1862a = C1862a.this;
            c1862a.m11275i(c1862a.m11279m());
        }
    }

    /* renamed from: com.google.android.material.textfield.a$c */
    public class c implements TextInputLayout.InterfaceC1860f {
        public c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.InterfaceC1860f
        /* renamed from: a */
        public void mo11267a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(C1862a.this.m11279m());
            editText.setOnFocusChangeListener(C1862a.this.f8895f);
            C1862a c1862a = C1862a.this;
            c1862a.f8948c.setOnFocusChangeListener(c1862a.f8895f);
            editText.removeTextChangedListener(C1862a.this.f8894e);
            editText.addTextChangedListener(C1862a.this.f8894e);
        }
    }

    /* renamed from: com.google.android.material.textfield.a$d */
    public class d implements TextInputLayout.InterfaceC1861g {

        /* renamed from: com.google.android.material.textfield.a$d$a */
        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ EditText f8904a;

            public a(EditText editText) {
                this.f8904a = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f8904a.removeTextChangedListener(C1862a.this.f8894e);
                C1862a.this.m11275i(true);
            }
        }

        public d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.InterfaceC1861g
        /* renamed from: a */
        public void mo11268a(TextInputLayout textInputLayout, int i10) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i10 != 2) {
                return;
            }
            editText.post(new a(editText));
            if (editText.getOnFocusChangeListener() == C1862a.this.f8895f) {
                editText.setOnFocusChangeListener(null);
            }
            if (C1862a.this.f8948c.getOnFocusChangeListener() == C1862a.this.f8895f) {
                C1862a.this.f8948c.setOnFocusChangeListener(null);
            }
        }
    }

    /* renamed from: com.google.android.material.textfield.a$e */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Editable text = C1862a.this.f8946a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            C1862a.this.f8946a.m11216U();
        }
    }

    /* renamed from: com.google.android.material.textfield.a$f */
    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            C1862a.this.f8946a.setEndIconVisible(true);
        }
    }

    /* renamed from: com.google.android.material.textfield.a$g */
    public class g extends AnimatorListenerAdapter {
        public g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C1862a.this.f8946a.setEndIconVisible(false);
        }
    }

    /* renamed from: com.google.android.material.textfield.a$h */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        public h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            C1862a.this.f8948c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.google.android.material.textfield.a$i */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            C1862a.this.f8948c.setScaleX(fFloatValue);
            C1862a.this.f8948c.setScaleY(fFloatValue);
        }
    }

    public C1862a(TextInputLayout textInputLayout, int i10) {
        super(textInputLayout, i10);
        this.f8894e = new a();
        this.f8895f = new b();
        this.f8896g = new c();
        this.f8897h = new d();
    }

    @Override // com.google.android.material.textfield.AbstractC1866e
    /* renamed from: a */
    public void mo11273a() {
        TextInputLayout textInputLayout = this.f8946a;
        int i10 = this.f8949d;
        if (i10 == 0) {
            i10 = R$drawable.mtrl_ic_cancel;
        }
        textInputLayout.setEndIconDrawable(i10);
        TextInputLayout textInputLayout2 = this.f8946a;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(R$string.clear_text_end_icon_content_description));
        this.f8946a.setEndIconCheckable(false);
        this.f8946a.setEndIconOnClickListener(new e());
        this.f8946a.m11225g(this.f8896g);
        this.f8946a.m11227h(this.f8897h);
        m11278l();
    }

    @Override // com.google.android.material.textfield.AbstractC1866e
    /* renamed from: c */
    public void mo11274c(boolean z10) {
        if (this.f8946a.getSuffixText() == null) {
            return;
        }
        m11275i(z10);
    }

    /* renamed from: i */
    public final void m11275i(boolean z10) {
        boolean z11 = this.f8946a.m11207K() == z10;
        if (z10 && !this.f8898i.isRunning()) {
            this.f8899j.cancel();
            this.f8898i.start();
            if (z11) {
                this.f8898i.end();
                return;
            }
            return;
        }
        if (z10) {
            return;
        }
        this.f8898i.cancel();
        this.f8899j.start();
        if (z11) {
            this.f8899j.end();
        }
    }

    /* renamed from: j */
    public final ValueAnimator m11276j(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(C13110a.f59597a);
        valueAnimatorOfFloat.setDuration(100L);
        valueAnimatorOfFloat.addUpdateListener(new h());
        return valueAnimatorOfFloat;
    }

    /* renamed from: k */
    public final ValueAnimator m11277k() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(C13110a.f59600d);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new i());
        return valueAnimatorOfFloat;
    }

    /* renamed from: l */
    public final void m11278l() {
        ValueAnimator valueAnimatorM11277k = m11277k();
        ValueAnimator valueAnimatorM11276j = m11276j(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f8898i = animatorSet;
        animatorSet.playTogether(valueAnimatorM11277k, valueAnimatorM11276j);
        this.f8898i.addListener(new f());
        ValueAnimator valueAnimatorM11276j2 = m11276j(1.0f, 0.0f);
        this.f8899j = valueAnimatorM11276j2;
        valueAnimatorM11276j2.addListener(new g());
    }

    /* renamed from: m */
    public final boolean m11279m() {
        EditText editText = this.f8946a.getEditText();
        return editText != null && (editText.hasFocus() || this.f8948c.hasFocus()) && editText.getText().length() > 0;
    }
}
