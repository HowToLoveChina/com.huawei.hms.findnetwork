package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.R$styleable;
import androidx.core.widget.C0662c;
import p211d.C8968a;
import p273f0.C9603h0;
import p757x.C13669a;

/* renamed from: androidx.appcompat.widget.e */
/* loaded from: classes.dex */
public class C0522e {

    /* renamed from: a */
    public final CompoundButton f2312a;

    /* renamed from: b */
    public ColorStateList f2313b = null;

    /* renamed from: c */
    public PorterDuff.Mode f2314c = null;

    /* renamed from: d */
    public boolean f2315d = false;

    /* renamed from: e */
    public boolean f2316e = false;

    /* renamed from: f */
    public boolean f2317f;

    public C0522e(CompoundButton compoundButton) {
        this.f2312a = compoundButton;
    }

    /* renamed from: a */
    public void m2936a() {
        Drawable drawableM4039a = C0662c.m4039a(this.f2312a);
        if (drawableM4039a != null) {
            if (this.f2315d || this.f2316e) {
                Drawable drawableMutate = C13669a.m82231l(drawableM4039a).mutate();
                if (this.f2315d) {
                    C13669a.m82228i(drawableMutate, this.f2313b);
                }
                if (this.f2316e) {
                    C13669a.m82229j(drawableMutate, this.f2314c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f2312a.getDrawableState());
                }
                this.f2312a.setButtonDrawable(drawableMutate);
            }
        }
    }

    /* renamed from: b */
    public int m2937b(int i10) {
        return i10;
    }

    /* renamed from: c */
    public ColorStateList m2938c() {
        return this.f2313b;
    }

    /* renamed from: d */
    public PorterDuff.Mode m2939d() {
        return this.f2314c;
    }

    /* renamed from: e */
    public void m2940e(AttributeSet attributeSet, int i10) {
        int iM2960n;
        int iM2960n2;
        Context context = this.f2312a.getContext();
        int[] iArr = R$styleable.CompoundButton;
        C0523e0 c0523e0M2946v = C0523e0.m2946v(context, attributeSet, iArr, i10, 0);
        CompoundButton compoundButton = this.f2312a;
        C9603h0.m59898n0(compoundButton, compoundButton.getContext(), iArr, attributeSet, c0523e0M2946v.m2964r(), i10, 0);
        try {
            int i11 = R$styleable.CompoundButton_buttonCompat;
            if (!c0523e0M2946v.m2965s(i11) || (iM2960n2 = c0523e0M2946v.m2960n(i11, 0)) == 0) {
                int i12 = R$styleable.CompoundButton_android_button;
                if (c0523e0M2946v.m2965s(i12) && (iM2960n = c0523e0M2946v.m2960n(i12, 0)) != 0) {
                    CompoundButton compoundButton2 = this.f2312a;
                    compoundButton2.setButtonDrawable(C8968a.m56743b(compoundButton2.getContext(), iM2960n));
                }
            } else {
                try {
                    CompoundButton compoundButton3 = this.f2312a;
                    compoundButton3.setButtonDrawable(C8968a.m56743b(compoundButton3.getContext(), iM2960n2));
                } catch (Resources.NotFoundException unused) {
                }
            }
            int i13 = R$styleable.CompoundButton_buttonTint;
            if (c0523e0M2946v.m2965s(i13)) {
                C0662c.m4041c(this.f2312a, c0523e0M2946v.m2949c(i13));
            }
            int i14 = R$styleable.CompoundButton_buttonTintMode;
            if (c0523e0M2946v.m2965s(i14)) {
                C0662c.m4042d(this.f2312a, C0544s.m3144e(c0523e0M2946v.m2957k(i14, -1), null));
            }
        } finally {
            c0523e0M2946v.m2966w();
        }
    }

    /* renamed from: f */
    public void m2941f() {
        if (this.f2317f) {
            this.f2317f = false;
        } else {
            this.f2317f = true;
            m2936a();
        }
    }

    /* renamed from: g */
    public void m2942g(ColorStateList colorStateList) {
        this.f2313b = colorStateList;
        this.f2315d = true;
        m2936a();
    }

    /* renamed from: h */
    public void m2943h(PorterDuff.Mode mode) {
        this.f2314c = mode;
        this.f2316e = true;
        m2936a();
    }
}
