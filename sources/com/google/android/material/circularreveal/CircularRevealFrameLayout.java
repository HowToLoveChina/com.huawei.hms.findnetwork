package com.google.android.material.circularreveal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.material.circularreveal.InterfaceC1711c;

/* loaded from: classes.dex */
public class CircularRevealFrameLayout extends FrameLayout implements InterfaceC1711c {

    /* renamed from: a */
    public final C1710b f7849a;

    public CircularRevealFrameLayout(Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.circularreveal.InterfaceC1711c
    /* renamed from: a */
    public void mo10174a() {
        this.f7849a.m10180a();
    }

    @Override // com.google.android.material.circularreveal.InterfaceC1711c
    /* renamed from: b */
    public void mo10175b() {
        this.f7849a.m10181b();
    }

    @Override // com.google.android.material.circularreveal.C1710b.a
    /* renamed from: c */
    public void mo10176c(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // com.google.android.material.circularreveal.C1710b.a
    /* renamed from: d */
    public boolean mo10177d() {
        return super.isOpaque();
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        C1710b c1710b = this.f7849a;
        if (c1710b != null) {
            c1710b.m10182c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f7849a.m10184e();
    }

    @Override // com.google.android.material.circularreveal.InterfaceC1711c
    public int getCircularRevealScrimColor() {
        return this.f7849a.m10185f();
    }

    @Override // com.google.android.material.circularreveal.InterfaceC1711c
    public InterfaceC1711c.e getRevealInfo() {
        return this.f7849a.m10187h();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        C1710b c1710b = this.f7849a;
        return c1710b != null ? c1710b.m10189j() : super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.InterfaceC1711c
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f7849a.m10190k(drawable);
    }

    @Override // com.google.android.material.circularreveal.InterfaceC1711c
    public void setCircularRevealScrimColor(int i10) {
        this.f7849a.m10191l(i10);
    }

    @Override // com.google.android.material.circularreveal.InterfaceC1711c
    public void setRevealInfo(InterfaceC1711c.e eVar) {
        this.f7849a.m10192m(eVar);
    }

    public CircularRevealFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7849a = new C1710b(this);
    }
}
