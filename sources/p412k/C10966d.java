package p412k;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* renamed from: k.d */
/* loaded from: classes.dex */
public class C10966d extends Drawable {

    /* renamed from: a */
    public float f51941a;

    /* renamed from: c */
    public final RectF f51943c;

    /* renamed from: d */
    public final Rect f51944d;

    /* renamed from: e */
    public float f51945e;

    /* renamed from: h */
    public ColorStateList f51948h;

    /* renamed from: i */
    public PorterDuffColorFilter f51949i;

    /* renamed from: j */
    public ColorStateList f51950j;

    /* renamed from: f */
    public boolean f51946f = false;

    /* renamed from: g */
    public boolean f51947g = true;

    /* renamed from: k */
    public PorterDuff.Mode f51951k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    public final Paint f51942b = new Paint(5);

    public C10966d(ColorStateList colorStateList, float f10) {
        this.f51941a = f10;
        m66191e(colorStateList);
        this.f51943c = new RectF();
        this.f51944d = new Rect();
    }

    /* renamed from: a */
    public final PorterDuffColorFilter m66187a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* renamed from: b */
    public ColorStateList m66188b() {
        return this.f51948h;
    }

    /* renamed from: c */
    public float m66189c() {
        return this.f51945e;
    }

    /* renamed from: d */
    public float m66190d() {
        return this.f51941a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z10;
        Paint paint = this.f51942b;
        if (this.f51949i == null || paint.getColorFilter() != null) {
            z10 = false;
        } else {
            paint.setColorFilter(this.f51949i);
            z10 = true;
        }
        RectF rectF = this.f51943c;
        float f10 = this.f51941a;
        canvas.drawRoundRect(rectF, f10, f10, paint);
        if (z10) {
            paint.setColorFilter(null);
        }
    }

    /* renamed from: e */
    public final void m66191e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f51948h = colorStateList;
        this.f51942b.setColor(colorStateList.getColorForState(getState(), this.f51948h.getDefaultColor()));
    }

    /* renamed from: f */
    public void m66192f(ColorStateList colorStateList) {
        m66191e(colorStateList);
        invalidateSelf();
    }

    /* renamed from: g */
    public void m66193g(float f10, boolean z10, boolean z11) {
        if (f10 == this.f51945e && this.f51946f == z10 && this.f51947g == z11) {
            return;
        }
        this.f51945e = f10;
        this.f51946f = z10;
        this.f51947g = z11;
        m66195i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f51944d, this.f51941a);
    }

    /* renamed from: h */
    public void m66194h(float f10) {
        if (f10 == this.f51941a) {
            return;
        }
        this.f51941a = f10;
        m66195i(null);
        invalidateSelf();
    }

    /* renamed from: i */
    public final void m66195i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f51943c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f51944d.set(rect);
        if (this.f51946f) {
            this.f51944d.inset((int) Math.ceil(C10967e.m66196a(this.f51945e, this.f51941a, this.f51947g)), (int) Math.ceil(C10967e.m66197b(this.f51945e, this.f51941a, this.f51947g)));
            this.f51943c.set(this.f51944d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f51950j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f51948h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m66195i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f51948h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z10 = colorForState != this.f51942b.getColor();
        if (z10) {
            this.f51942b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f51950j;
        if (colorStateList2 == null || (mode = this.f51951k) == null) {
            return z10;
        }
        this.f51949i = m66187a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f51942b.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f51942b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f51950j = colorStateList;
        this.f51949i = m66187a(colorStateList, this.f51951k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f51951k = mode;
        this.f51949i = m66187a(this.f51950j, mode);
        invalidateSelf();
    }
}
