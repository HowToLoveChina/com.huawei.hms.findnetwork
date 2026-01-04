package androidx.transition;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes.dex */
class ViewOverlayApi14$OverlayViewGroup extends ViewGroup {

    /* renamed from: d */
    public static Method f4815d;

    /* renamed from: a */
    public ViewGroup f4816a;

    /* renamed from: b */
    public View f4817b;

    /* renamed from: c */
    public ArrayList<Drawable> f4818c;

    static {
        try {
            Class cls = Integer.TYPE;
            f4815d = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", cls, cls, Rect.class);
        } catch (NoSuchMethodException unused) {
        }
    }

    /* renamed from: a */
    public final void m5769a(int[] iArr) {
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        this.f4816a.getLocationOnScreen(iArr2);
        this.f4817b.getLocationOnScreen(iArr3);
        iArr[0] = iArr3[0] - iArr2[0];
        iArr[1] = iArr3[1] - iArr2[1];
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.f4816a.getLocationOnScreen(new int[2]);
        this.f4817b.getLocationOnScreen(new int[2]);
        canvas.translate(r0[0] - r1[0], r0[1] - r1[1]);
        canvas.clipRect(new Rect(0, 0, this.f4817b.getWidth(), this.f4817b.getHeight()));
        super.dispatchDraw(canvas);
        ArrayList<Drawable> arrayList = this.f4818c;
        int size = arrayList == null ? 0 : arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f4818c.get(i10).draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        if (this.f4816a == null) {
            return null;
        }
        rect.offset(iArr[0], iArr[1]);
        if (!(this.f4816a instanceof ViewGroup)) {
            invalidate(rect);
            return null;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        int[] iArr2 = new int[2];
        m5769a(iArr2);
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
        return super.verifyDrawable(drawable) || ((arrayList = this.f4818c) != null && arrayList.contains(drawable));
    }
}
