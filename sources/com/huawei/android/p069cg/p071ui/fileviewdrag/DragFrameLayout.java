package com.huawei.android.p069cg.p071ui.fileviewdrag;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import p008a7.C0056c;
import p008a7.InterfaceC0058e;

/* loaded from: classes2.dex */
public class DragFrameLayout extends FrameLayout {

    /* renamed from: c */
    public static final Float f11337c = Float.valueOf(0.12f);

    /* renamed from: a */
    public C0056c f11338a;

    /* renamed from: b */
    public boolean f11339b;

    public DragFrameLayout(Context context) {
        super(context);
        this.f11339b = false;
        m14863a();
    }

    /* renamed from: a */
    public final void m14863a() {
        this.f11338a = new C0056c(this, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f11339b) {
            this.f11338a.m400f(motionEvent);
            if (this.f11338a.m401g()) {
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public InterfaceC0058e getDragListener() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f11338a.m402h(getHeight() * f11337c.floatValue());
    }

    public void setCanDrag(boolean z10) {
        this.f11339b = z10;
    }

    public void setDragListener(InterfaceC0058e interfaceC0058e) {
        this.f11338a.m403i(interfaceC0058e);
    }

    public DragFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11339b = false;
        m14863a();
    }

    public DragFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11339b = false;
        m14863a();
    }
}
