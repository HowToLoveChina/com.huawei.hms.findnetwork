package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$styleable;
import p273f0.C9603h0;
import p757x.C13669a;

/* renamed from: androidx.appcompat.widget.m */
/* loaded from: classes.dex */
public class C0538m extends C0534k {

    /* renamed from: d */
    public final SeekBar f2370d;

    /* renamed from: e */
    public Drawable f2371e;

    /* renamed from: f */
    public ColorStateList f2372f;

    /* renamed from: g */
    public PorterDuff.Mode f2373g;

    /* renamed from: h */
    public boolean f2374h;

    /* renamed from: i */
    public boolean f2375i;

    public C0538m(SeekBar seekBar) {
        super(seekBar);
        this.f2372f = null;
        this.f2373g = null;
        this.f2374h = false;
        this.f2375i = false;
        this.f2370d = seekBar;
    }

    @Override // androidx.appcompat.widget.C0534k
    /* renamed from: c */
    public void mo3051c(AttributeSet attributeSet, int i10) {
        super.mo3051c(attributeSet, i10);
        Context context = this.f2370d.getContext();
        int[] iArr = R$styleable.AppCompatSeekBar;
        C0523e0 c0523e0M2946v = C0523e0.m2946v(context, attributeSet, iArr, i10, 0);
        SeekBar seekBar = this.f2370d;
        C9603h0.m59898n0(seekBar, seekBar.getContext(), iArr, attributeSet, c0523e0M2946v.m2964r(), i10, 0);
        Drawable drawableM2954h = c0523e0M2946v.m2954h(R$styleable.AppCompatSeekBar_android_thumb);
        if (drawableM2954h != null) {
            this.f2370d.setThumb(drawableM2954h);
        }
        m3068j(c0523e0M2946v.m2953g(R$styleable.AppCompatSeekBar_tickMark));
        int i11 = R$styleable.AppCompatSeekBar_tickMarkTintMode;
        if (c0523e0M2946v.m2965s(i11)) {
            this.f2373g = C0544s.m3144e(c0523e0M2946v.m2957k(i11, -1), this.f2373g);
            this.f2375i = true;
        }
        int i12 = R$styleable.AppCompatSeekBar_tickMarkTint;
        if (c0523e0M2946v.m2965s(i12)) {
            this.f2372f = c0523e0M2946v.m2949c(i12);
            this.f2374h = true;
        }
        c0523e0M2946v.m2966w();
        m3064f();
    }

    /* renamed from: f */
    public final void m3064f() {
        Drawable drawable = this.f2371e;
        if (drawable != null) {
            if (this.f2374h || this.f2375i) {
                Drawable drawableM82231l = C13669a.m82231l(drawable.mutate());
                this.f2371e = drawableM82231l;
                if (this.f2374h) {
                    C13669a.m82228i(drawableM82231l, this.f2372f);
                }
                if (this.f2375i) {
                    C13669a.m82229j(this.f2371e, this.f2373g);
                }
                if (this.f2371e.isStateful()) {
                    this.f2371e.setState(this.f2370d.getDrawableState());
                }
            }
        }
    }

    /* renamed from: g */
    public void m3065g(Canvas canvas) {
        if (this.f2371e != null) {
            int max = this.f2370d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f2371e.getIntrinsicWidth();
                int intrinsicHeight = this.f2371e.getIntrinsicHeight();
                int i10 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i11 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f2371e.setBounds(-i10, -i11, i10, i11);
                float width = ((this.f2370d.getWidth() - this.f2370d.getPaddingLeft()) - this.f2370d.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f2370d.getPaddingLeft(), this.f2370d.getHeight() / 2);
                for (int i12 = 0; i12 <= max; i12++) {
                    this.f2371e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    /* renamed from: h */
    public void m3066h() {
        Drawable drawable = this.f2371e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f2370d.getDrawableState())) {
            this.f2370d.invalidateDrawable(drawable);
        }
    }

    /* renamed from: i */
    public void m3067i() {
        Drawable drawable = this.f2371e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* renamed from: j */
    public void m3068j(Drawable drawable) {
        Drawable drawable2 = this.f2371e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2371e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f2370d);
            C13669a.m82226g(drawable, C9603h0.m59832A(this.f2370d));
            if (drawable.isStateful()) {
                drawable.setState(this.f2370d.getDrawableState());
            }
            m3064f();
        }
        this.f2370d.invalidate();
    }
}
