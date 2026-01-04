package com.google.android.material.circularreveal.coordinatorlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.circularreveal.C1710b;
import com.google.android.material.circularreveal.InterfaceC1711c;

/* loaded from: classes.dex */
public class CircularRevealCoordinatorLayout extends CoordinatorLayout implements InterfaceC1711c {

    /* renamed from: z */
    public final C1710b f7872z;

    public CircularRevealCoordinatorLayout(Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.circularreveal.InterfaceC1711c
    /* renamed from: a */
    public void mo10174a() {
        this.f7872z.m10180a();
    }

    @Override // com.google.android.material.circularreveal.InterfaceC1711c
    /* renamed from: b */
    public void mo10175b() {
        this.f7872z.m10181b();
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
    public void draw(Canvas canvas) {
        C1710b c1710b = this.f7872z;
        if (c1710b != null) {
            c1710b.m10182c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f7872z.m10184e();
    }

    @Override // com.google.android.material.circularreveal.InterfaceC1711c
    public int getCircularRevealScrimColor() {
        return this.f7872z.m10185f();
    }

    @Override // com.google.android.material.circularreveal.InterfaceC1711c
    public InterfaceC1711c.e getRevealInfo() {
        return this.f7872z.m10187h();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        C1710b c1710b = this.f7872z;
        return c1710b != null ? c1710b.m10189j() : super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.InterfaceC1711c
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f7872z.m10190k(drawable);
    }

    @Override // com.google.android.material.circularreveal.InterfaceC1711c
    public void setCircularRevealScrimColor(int i10) {
        this.f7872z.m10191l(i10);
    }

    @Override // com.google.android.material.circularreveal.InterfaceC1711c
    public void setRevealInfo(InterfaceC1711c.e eVar) {
        this.f7872z.m10192m(eVar);
    }

    public CircularRevealCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7872z = new C1710b(this);
    }
}
