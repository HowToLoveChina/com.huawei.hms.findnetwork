package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;
import androidx.core.widget.C0665f;
import p211d.C8968a;
import p273f0.C9603h0;

/* renamed from: androidx.appcompat.widget.j */
/* loaded from: classes.dex */
public class C0532j {

    /* renamed from: a */
    public final ImageView f2358a;

    /* renamed from: b */
    public C0519c0 f2359b;

    /* renamed from: c */
    public C0519c0 f2360c;

    /* renamed from: d */
    public C0519c0 f2361d;

    /* renamed from: e */
    public int f2362e = 0;

    public C0532j(ImageView imageView) {
        this.f2358a = imageView;
    }

    /* renamed from: a */
    public final boolean m3035a(Drawable drawable) {
        if (this.f2361d == null) {
            this.f2361d = new C0519c0();
        }
        C0519c0 c0519c0 = this.f2361d;
        c0519c0.m2928a();
        ColorStateList colorStateListM4048a = C0665f.m4048a(this.f2358a);
        if (colorStateListM4048a != null) {
            c0519c0.f2304d = true;
            c0519c0.f2301a = colorStateListM4048a;
        }
        PorterDuff.Mode modeM4049b = C0665f.m4049b(this.f2358a);
        if (modeM4049b != null) {
            c0519c0.f2303c = true;
            c0519c0.f2302b = modeM4049b;
        }
        if (!c0519c0.f2304d && !c0519c0.f2303c) {
            return false;
        }
        C0524f.m2971i(drawable, c0519c0, this.f2358a.getDrawableState());
        return true;
    }

    /* renamed from: b */
    public void m3036b() {
        if (this.f2358a.getDrawable() != null) {
            this.f2358a.getDrawable().setLevel(this.f2362e);
        }
    }

    /* renamed from: c */
    public void m3037c() {
        Drawable drawable = this.f2358a.getDrawable();
        if (drawable != null) {
            C0544s.m3141b(drawable);
        }
        if (drawable != null) {
            if (m3046l() && m3035a(drawable)) {
                return;
            }
            C0519c0 c0519c0 = this.f2360c;
            if (c0519c0 != null) {
                C0524f.m2971i(drawable, c0519c0, this.f2358a.getDrawableState());
                return;
            }
            C0519c0 c0519c02 = this.f2359b;
            if (c0519c02 != null) {
                C0524f.m2971i(drawable, c0519c02, this.f2358a.getDrawableState());
            }
        }
    }

    /* renamed from: d */
    public ColorStateList m3038d() {
        C0519c0 c0519c0 = this.f2360c;
        if (c0519c0 != null) {
            return c0519c0.f2301a;
        }
        return null;
    }

    /* renamed from: e */
    public PorterDuff.Mode m3039e() {
        C0519c0 c0519c0 = this.f2360c;
        if (c0519c0 != null) {
            return c0519c0.f2302b;
        }
        return null;
    }

    /* renamed from: f */
    public boolean m3040f() {
        return !(this.f2358a.getBackground() instanceof RippleDrawable);
    }

    /* renamed from: g */
    public void m3041g(AttributeSet attributeSet, int i10) {
        int iM2960n;
        Context context = this.f2358a.getContext();
        int[] iArr = R$styleable.AppCompatImageView;
        C0523e0 c0523e0M2946v = C0523e0.m2946v(context, attributeSet, iArr, i10, 0);
        ImageView imageView = this.f2358a;
        C9603h0.m59898n0(imageView, imageView.getContext(), iArr, attributeSet, c0523e0M2946v.m2964r(), i10, 0);
        try {
            Drawable drawable = this.f2358a.getDrawable();
            if (drawable == null && (iM2960n = c0523e0M2946v.m2960n(R$styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = C8968a.m56743b(this.f2358a.getContext(), iM2960n)) != null) {
                this.f2358a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                C0544s.m3141b(drawable);
            }
            int i11 = R$styleable.AppCompatImageView_tint;
            if (c0523e0M2946v.m2965s(i11)) {
                C0665f.m4050c(this.f2358a, c0523e0M2946v.m2949c(i11));
            }
            int i12 = R$styleable.AppCompatImageView_tintMode;
            if (c0523e0M2946v.m2965s(i12)) {
                C0665f.m4051d(this.f2358a, C0544s.m3144e(c0523e0M2946v.m2957k(i12, -1), null));
            }
            c0523e0M2946v.m2966w();
        } catch (Throwable th2) {
            c0523e0M2946v.m2966w();
            throw th2;
        }
    }

    /* renamed from: h */
    public void m3042h(Drawable drawable) {
        this.f2362e = drawable.getLevel();
    }

    /* renamed from: i */
    public void m3043i(int i10) {
        if (i10 != 0) {
            Drawable drawableM56743b = C8968a.m56743b(this.f2358a.getContext(), i10);
            if (drawableM56743b != null) {
                C0544s.m3141b(drawableM56743b);
            }
            this.f2358a.setImageDrawable(drawableM56743b);
        } else {
            this.f2358a.setImageDrawable(null);
        }
        m3037c();
    }

    /* renamed from: j */
    public void m3044j(ColorStateList colorStateList) {
        if (this.f2360c == null) {
            this.f2360c = new C0519c0();
        }
        C0519c0 c0519c0 = this.f2360c;
        c0519c0.f2301a = colorStateList;
        c0519c0.f2304d = true;
        m3037c();
    }

    /* renamed from: k */
    public void m3045k(PorterDuff.Mode mode) {
        if (this.f2360c == null) {
            this.f2360c = new C0519c0();
        }
        C0519c0 c0519c0 = this.f2360c;
        c0519c0.f2302b = mode;
        c0519c0.f2303c = true;
        m3037c();
    }

    /* renamed from: l */
    public final boolean m3046l() {
        return this.f2359b != null;
    }
}
