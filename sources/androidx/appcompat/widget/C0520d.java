package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import androidx.appcompat.R$styleable;
import androidx.core.widget.C0661b;
import p211d.C8968a;
import p273f0.C9603h0;
import p757x.C13669a;

/* renamed from: androidx.appcompat.widget.d */
/* loaded from: classes.dex */
public class C0520d {

    /* renamed from: a */
    public final CheckedTextView f2305a;

    /* renamed from: b */
    public ColorStateList f2306b = null;

    /* renamed from: c */
    public PorterDuff.Mode f2307c = null;

    /* renamed from: d */
    public boolean f2308d = false;

    /* renamed from: e */
    public boolean f2309e = false;

    /* renamed from: f */
    public boolean f2310f;

    public C0520d(CheckedTextView checkedTextView) {
        this.f2305a = checkedTextView;
    }

    /* renamed from: a */
    public void m2929a() {
        Drawable drawableM4033a = C0661b.m4033a(this.f2305a);
        if (drawableM4033a != null) {
            if (this.f2308d || this.f2309e) {
                Drawable drawableMutate = C13669a.m82231l(drawableM4033a).mutate();
                if (this.f2308d) {
                    C13669a.m82228i(drawableMutate, this.f2306b);
                }
                if (this.f2309e) {
                    C13669a.m82229j(drawableMutate, this.f2307c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f2305a.getDrawableState());
                }
                this.f2305a.setCheckMarkDrawable(drawableMutate);
            }
        }
    }

    /* renamed from: b */
    public ColorStateList m2930b() {
        return this.f2306b;
    }

    /* renamed from: c */
    public PorterDuff.Mode m2931c() {
        return this.f2307c;
    }

    /* renamed from: d */
    public void m2932d(AttributeSet attributeSet, int i10) {
        int iM2960n;
        int iM2960n2;
        Context context = this.f2305a.getContext();
        int[] iArr = R$styleable.CheckedTextView;
        C0523e0 c0523e0M2946v = C0523e0.m2946v(context, attributeSet, iArr, i10, 0);
        CheckedTextView checkedTextView = this.f2305a;
        C9603h0.m59898n0(checkedTextView, checkedTextView.getContext(), iArr, attributeSet, c0523e0M2946v.m2964r(), i10, 0);
        try {
            int i11 = R$styleable.CheckedTextView_checkMarkCompat;
            if (!c0523e0M2946v.m2965s(i11) || (iM2960n2 = c0523e0M2946v.m2960n(i11, 0)) == 0) {
                int i12 = R$styleable.CheckedTextView_android_checkMark;
                if (c0523e0M2946v.m2965s(i12) && (iM2960n = c0523e0M2946v.m2960n(i12, 0)) != 0) {
                    CheckedTextView checkedTextView2 = this.f2305a;
                    checkedTextView2.setCheckMarkDrawable(C8968a.m56743b(checkedTextView2.getContext(), iM2960n));
                }
            } else {
                try {
                    CheckedTextView checkedTextView3 = this.f2305a;
                    checkedTextView3.setCheckMarkDrawable(C8968a.m56743b(checkedTextView3.getContext(), iM2960n2));
                } catch (Resources.NotFoundException unused) {
                }
            }
            int i13 = R$styleable.CheckedTextView_checkMarkTint;
            if (c0523e0M2946v.m2965s(i13)) {
                C0661b.m4034b(this.f2305a, c0523e0M2946v.m2949c(i13));
            }
            int i14 = R$styleable.CheckedTextView_checkMarkTintMode;
            if (c0523e0M2946v.m2965s(i14)) {
                C0661b.m4035c(this.f2305a, C0544s.m3144e(c0523e0M2946v.m2957k(i14, -1), null));
            }
        } finally {
            c0523e0M2946v.m2966w();
        }
    }

    /* renamed from: e */
    public void m2933e() {
        if (this.f2310f) {
            this.f2310f = false;
        } else {
            this.f2310f = true;
            m2929a();
        }
    }

    /* renamed from: f */
    public void m2934f(ColorStateList colorStateList) {
        this.f2306b = colorStateList;
        this.f2308d = true;
        m2929a();
    }

    /* renamed from: g */
    public void m2935g(PorterDuff.Mode mode) {
        this.f2307c = mode;
        this.f2309e = true;
        m2929a();
    }
}
