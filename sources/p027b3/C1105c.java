package p027b3;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import p356i3.C10432m;
import p356i3.C10433n;
import p723w.C13503b;

/* renamed from: b3.c */
/* loaded from: classes.dex */
public class C1105c extends Drawable {

    /* renamed from: b */
    public final Paint f5244b;

    /* renamed from: h */
    public float f5250h;

    /* renamed from: i */
    public int f5251i;

    /* renamed from: j */
    public int f5252j;

    /* renamed from: k */
    public int f5253k;

    /* renamed from: l */
    public int f5254l;

    /* renamed from: m */
    public int f5255m;

    /* renamed from: o */
    public C10432m f5257o;

    /* renamed from: p */
    public ColorStateList f5258p;

    /* renamed from: a */
    public final C10433n f5243a = C10433n.m64106k();

    /* renamed from: c */
    public final Path f5245c = new Path();

    /* renamed from: d */
    public final Rect f5246d = new Rect();

    /* renamed from: e */
    public final RectF f5247e = new RectF();

    /* renamed from: f */
    public final RectF f5248f = new RectF();

    /* renamed from: g */
    public final b f5249g = new b();

    /* renamed from: n */
    public boolean f5256n = true;

    /* renamed from: b3.c$b */
    public class b extends Drawable.ConstantState {
        public b() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return C1105c.this;
        }
    }

    public C1105c(C10432m c10432m) {
        this.f5257o = c10432m;
        Paint paint = new Paint(1);
        this.f5244b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    /* renamed from: a */
    public final Shader m6568a() {
        copyBounds(this.f5246d);
        float fHeight = this.f5250h / r1.height();
        return new LinearGradient(0.0f, r1.top, 0.0f, r1.bottom, new int[]{C13503b.m81222f(this.f5251i, this.f5255m), C13503b.m81222f(this.f5252j, this.f5255m), C13503b.m81222f(C13503b.m81226j(this.f5252j, 0), this.f5255m), C13503b.m81222f(C13503b.m81226j(this.f5254l, 0), this.f5255m), C13503b.m81222f(this.f5254l, this.f5255m), C13503b.m81222f(this.f5253k, this.f5255m)}, new float[]{0.0f, fHeight, 0.5f, 0.5f, 1.0f - fHeight, 1.0f}, Shader.TileMode.CLAMP);
    }

    /* renamed from: b */
    public RectF m6569b() {
        this.f5248f.set(getBounds());
        return this.f5248f;
    }

    /* renamed from: c */
    public void m6570c(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f5255m = colorStateList.getColorForState(getState(), this.f5255m);
        }
        this.f5258p = colorStateList;
        this.f5256n = true;
        invalidateSelf();
    }

    /* renamed from: d */
    public void m6571d(float f10) {
        if (this.f5250h != f10) {
            this.f5250h = f10;
            this.f5244b.setStrokeWidth(f10 * 1.3333f);
            this.f5256n = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f5256n) {
            this.f5244b.setShader(m6568a());
            this.f5256n = false;
        }
        float strokeWidth = this.f5244b.getStrokeWidth() / 2.0f;
        copyBounds(this.f5246d);
        this.f5247e.set(this.f5246d);
        float fMin = Math.min(this.f5257o.m64062r().mo63966a(m6569b()), this.f5247e.width() / 2.0f);
        if (this.f5257o.m64065u(m6569b())) {
            this.f5247e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f5247e, fMin, fMin, this.f5244b);
        }
    }

    /* renamed from: e */
    public void m6572e(int i10, int i11, int i12, int i13) {
        this.f5251i = i10;
        this.f5252j = i11;
        this.f5253k = i12;
        this.f5254l = i13;
    }

    /* renamed from: f */
    public void m6573f(C10432m c10432m) {
        this.f5257o = c10432m;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f5249g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f5250h > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.f5257o.m64065u(m6569b())) {
            outline.setRoundRect(getBounds(), this.f5257o.m64062r().mo63966a(m6569b()));
            return;
        }
        copyBounds(this.f5246d);
        this.f5247e.set(this.f5246d);
        this.f5243a.m64110d(this.f5257o, 1.0f, this.f5247e, this.f5245c);
        if (this.f5245c.isConvex()) {
            outline.setConvexPath(this.f5245c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        if (!this.f5257o.m64065u(m6569b())) {
            return true;
        }
        int iRound = Math.round(this.f5250h);
        rect.set(iRound, iRound, iRound, iRound);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f5258p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f5256n = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f5258p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.f5255m)) != this.f5255m) {
            this.f5256n = true;
            this.f5255m = colorForState;
        }
        if (this.f5256n) {
            invalidateSelf();
        }
        return this.f5256n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f5244b.setAlpha(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5244b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
