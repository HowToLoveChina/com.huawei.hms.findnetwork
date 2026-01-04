package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import p273f0.C9603h0;
import p273f0.C9625s0;
import p273f0.InterfaceC9586b0;

/* loaded from: classes.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {

    /* renamed from: a */
    public Drawable f8241a;

    /* renamed from: b */
    public Rect f8242b;

    /* renamed from: c */
    public Rect f8243c;

    /* renamed from: d */
    public boolean f8244d;

    /* renamed from: e */
    public boolean f8245e;

    /* renamed from: com.google.android.material.internal.ScrimInsetsFrameLayout$a */
    public class C1769a implements InterfaceC9586b0 {
        public C1769a() {
        }

        @Override // p273f0.InterfaceC9586b0
        public C9625s0 onApplyWindowInsets(View view, C9625s0 c9625s0) {
            ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
            if (scrimInsetsFrameLayout.f8242b == null) {
                scrimInsetsFrameLayout.f8242b = new Rect();
            }
            ScrimInsetsFrameLayout.this.f8242b.set(c9625s0.m60158j(), c9625s0.m60160l(), c9625s0.m60159k(), c9625s0.m60157i());
            ScrimInsetsFrameLayout.this.mo10565a(c9625s0);
            ScrimInsetsFrameLayout.this.setWillNotDraw(!c9625s0.m60161m() || ScrimInsetsFrameLayout.this.f8241a == null);
            C9603h0.m59884g0(ScrimInsetsFrameLayout.this);
            return c9625s0.m60151c();
        }
    }

    public ScrimInsetsFrameLayout(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public void mo10565a(C9625s0 c9625s0) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f8242b == null || this.f8241a == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.f8244d) {
            this.f8243c.set(0, 0, width, this.f8242b.top);
            this.f8241a.setBounds(this.f8243c);
            this.f8241a.draw(canvas);
        }
        if (this.f8245e) {
            this.f8243c.set(0, height - this.f8242b.bottom, width, height);
            this.f8241a.setBounds(this.f8243c);
            this.f8241a.draw(canvas);
        }
        Rect rect = this.f8243c;
        Rect rect2 = this.f8242b;
        rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
        this.f8241a.setBounds(this.f8243c);
        this.f8241a.draw(canvas);
        Rect rect3 = this.f8243c;
        Rect rect4 = this.f8242b;
        rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
        this.f8241a.setBounds(this.f8243c);
        this.f8241a.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f8241a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f8241a;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z10) {
        this.f8245e = z10;
    }

    public void setDrawTopInsetForeground(boolean z10) {
        this.f8244d = z10;
    }

    public void setScrimInsetForeground(Drawable drawable) {
        this.f8241a = drawable;
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f8243c = new Rect();
        this.f8244d = true;
        this.f8245e = true;
        TypedArray typedArrayM10770h = C1784o.m10770h(context, attributeSet, R$styleable.ScrimInsetsFrameLayout, i10, R$style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f8241a = typedArrayM10770h.getDrawable(R$styleable.ScrimInsetsFrameLayout_insetForeground);
        typedArrayM10770h.recycle();
        setWillNotDraw(true);
        C9603h0.m59837C0(this, new C1769a());
    }
}
