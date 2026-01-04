package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;
import p273f0.C9603h0;

/* renamed from: androidx.appcompat.widget.c */
/* loaded from: classes.dex */
public class C0518c {

    /* renamed from: a */
    public final View f2295a;

    /* renamed from: d */
    public C0519c0 f2298d;

    /* renamed from: e */
    public C0519c0 f2299e;

    /* renamed from: f */
    public C0519c0 f2300f;

    /* renamed from: c */
    public int f2297c = -1;

    /* renamed from: b */
    public final C0524f f2296b = C0524f.m2968b();

    public C0518c(View view) {
        this.f2295a = view;
    }

    /* renamed from: a */
    public final boolean m2917a(Drawable drawable) {
        if (this.f2300f == null) {
            this.f2300f = new C0519c0();
        }
        C0519c0 c0519c0 = this.f2300f;
        c0519c0.m2928a();
        ColorStateList colorStateListM59905r = C9603h0.m59905r(this.f2295a);
        if (colorStateListM59905r != null) {
            c0519c0.f2304d = true;
            c0519c0.f2301a = colorStateListM59905r;
        }
        PorterDuff.Mode modeM59907s = C9603h0.m59907s(this.f2295a);
        if (modeM59907s != null) {
            c0519c0.f2303c = true;
            c0519c0.f2302b = modeM59907s;
        }
        if (!c0519c0.f2304d && !c0519c0.f2303c) {
            return false;
        }
        C0524f.m2971i(drawable, c0519c0, this.f2295a.getDrawableState());
        return true;
    }

    /* renamed from: b */
    public void m2918b() {
        Drawable background = this.f2295a.getBackground();
        if (background != null) {
            if (m2927k() && m2917a(background)) {
                return;
            }
            C0519c0 c0519c0 = this.f2299e;
            if (c0519c0 != null) {
                C0524f.m2971i(background, c0519c0, this.f2295a.getDrawableState());
                return;
            }
            C0519c0 c0519c02 = this.f2298d;
            if (c0519c02 != null) {
                C0524f.m2971i(background, c0519c02, this.f2295a.getDrawableState());
            }
        }
    }

    /* renamed from: c */
    public ColorStateList m2919c() {
        C0519c0 c0519c0 = this.f2299e;
        if (c0519c0 != null) {
            return c0519c0.f2301a;
        }
        return null;
    }

    /* renamed from: d */
    public PorterDuff.Mode m2920d() {
        C0519c0 c0519c0 = this.f2299e;
        if (c0519c0 != null) {
            return c0519c0.f2302b;
        }
        return null;
    }

    /* renamed from: e */
    public void m2921e(AttributeSet attributeSet, int i10) {
        Context context = this.f2295a.getContext();
        int[] iArr = R$styleable.ViewBackgroundHelper;
        C0523e0 c0523e0M2946v = C0523e0.m2946v(context, attributeSet, iArr, i10, 0);
        View view = this.f2295a;
        C9603h0.m59898n0(view, view.getContext(), iArr, attributeSet, c0523e0M2946v.m2964r(), i10, 0);
        try {
            int i11 = R$styleable.ViewBackgroundHelper_android_background;
            if (c0523e0M2946v.m2965s(i11)) {
                this.f2297c = c0523e0M2946v.m2960n(i11, -1);
                ColorStateList colorStateListM2974f = this.f2296b.m2974f(this.f2295a.getContext(), this.f2297c);
                if (colorStateListM2974f != null) {
                    m2924h(colorStateListM2974f);
                }
            }
            int i12 = R$styleable.ViewBackgroundHelper_backgroundTint;
            if (c0523e0M2946v.m2965s(i12)) {
                C9603h0.m59912u0(this.f2295a, c0523e0M2946v.m2949c(i12));
            }
            int i13 = R$styleable.ViewBackgroundHelper_backgroundTintMode;
            if (c0523e0M2946v.m2965s(i13)) {
                C9603h0.m59914v0(this.f2295a, C0544s.m3144e(c0523e0M2946v.m2957k(i13, -1), null));
            }
            c0523e0M2946v.m2966w();
        } catch (Throwable th2) {
            c0523e0M2946v.m2966w();
            throw th2;
        }
    }

    /* renamed from: f */
    public void m2922f(Drawable drawable) {
        this.f2297c = -1;
        m2924h(null);
        m2918b();
    }

    /* renamed from: g */
    public void m2923g(int i10) {
        this.f2297c = i10;
        C0524f c0524f = this.f2296b;
        m2924h(c0524f != null ? c0524f.m2974f(this.f2295a.getContext(), i10) : null);
        m2918b();
    }

    /* renamed from: h */
    public void m2924h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f2298d == null) {
                this.f2298d = new C0519c0();
            }
            C0519c0 c0519c0 = this.f2298d;
            c0519c0.f2301a = colorStateList;
            c0519c0.f2304d = true;
        } else {
            this.f2298d = null;
        }
        m2918b();
    }

    /* renamed from: i */
    public void m2925i(ColorStateList colorStateList) {
        if (this.f2299e == null) {
            this.f2299e = new C0519c0();
        }
        C0519c0 c0519c0 = this.f2299e;
        c0519c0.f2301a = colorStateList;
        c0519c0.f2304d = true;
        m2918b();
    }

    /* renamed from: j */
    public void m2926j(PorterDuff.Mode mode) {
        if (this.f2299e == null) {
            this.f2299e = new C0519c0();
        }
        C0519c0 c0519c0 = this.f2299e;
        c0519c0.f2302b = mode;
        c0519c0.f2303c = true;
        m2918b();
    }

    /* renamed from: k */
    public final boolean m2927k() {
        return this.f2298d != null;
    }
}
