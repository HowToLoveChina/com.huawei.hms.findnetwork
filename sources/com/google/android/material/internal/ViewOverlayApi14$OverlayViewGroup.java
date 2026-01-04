package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor", "PrivateApi"})
/* loaded from: classes.dex */
class ViewOverlayApi14$OverlayViewGroup extends ViewGroup {

    /* renamed from: d */
    public static Method f8247d;

    /* renamed from: a */
    public ViewGroup f8248a;

    /* renamed from: b */
    public View f8249b;

    /* renamed from: c */
    public ArrayList<Drawable> f8250c;

    static {
        try {
            Class cls = Integer.TYPE;
            f8247d = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", cls, cls, Rect.class);
        } catch (NoSuchMethodException unused) {
        }
    }

    /* renamed from: a */
    public final void m10566a(int[] iArr) {
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        this.f8248a.getLocationOnScreen(iArr2);
        this.f8249b.getLocationOnScreen(iArr3);
        iArr[0] = iArr3[0] - iArr2[0];
        iArr[1] = iArr3[1] - iArr2[1];
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.f8248a.getLocationOnScreen(new int[2]);
        this.f8249b.getLocationOnScreen(new int[2]);
        canvas.translate(r0[0] - r1[0], r0[1] - r1[1]);
        canvas.clipRect(new Rect(0, 0, this.f8249b.getWidth(), this.f8249b.getHeight()));
        super.dispatchDraw(canvas);
        ArrayList<Drawable> arrayList = this.f8250c;
        int size = arrayList == null ? 0 : arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f8250c.get(i10).draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        if (this.f8248a == null) {
            return null;
        }
        rect.offset(iArr[0], iArr[1]);
        if (this.f8248a == null) {
            invalidate(rect);
            return null;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        int[] iArr2 = new int[2];
        m10566a(iArr2);
        rect.offset(iArr2[0], iArr2[1]);
        return super.invalidateChildInParent(iArr, rect);
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidate(drawable.getBounds());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        ArrayList<Drawable> arrayList;
        return super.verifyDrawable(drawable) || ((arrayList = this.f8250c) != null && arrayList.contains(drawable));
    }
}
