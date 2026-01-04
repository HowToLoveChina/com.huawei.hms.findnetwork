package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import p757x.C13669a;

/* loaded from: classes.dex */
public class DrawerArrowDrawable extends Drawable {

    /* renamed from: m */
    public static final float f1440m = (float) Math.toRadians(45.0d);

    /* renamed from: a */
    public final Paint f1441a;

    /* renamed from: b */
    public float f1442b;

    /* renamed from: c */
    public float f1443c;

    /* renamed from: d */
    public float f1444d;

    /* renamed from: e */
    public float f1445e;

    /* renamed from: f */
    public boolean f1446f;

    /* renamed from: g */
    public final Path f1447g;

    /* renamed from: h */
    public final int f1448h;

    /* renamed from: i */
    public boolean f1449i;

    /* renamed from: j */
    public float f1450j;

    /* renamed from: k */
    public float f1451k;

    /* renamed from: l */
    public int f1452l;

    public DrawerArrowDrawable(Context context) {
        Paint paint = new Paint();
        this.f1441a = paint;
        this.f1447g = new Path();
        this.f1449i = false;
        this.f1452l = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R$styleable.DrawerArrowToggle, R$attr.drawerArrowStyle, R$style.Base_Widget_AppCompat_DrawerArrowToggle);
        m2302c(typedArrayObtainStyledAttributes.getColor(R$styleable.DrawerArrowToggle_color, 0));
        m2301b(typedArrayObtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_thickness, 0.0f));
        m2304e(typedArrayObtainStyledAttributes.getBoolean(R$styleable.DrawerArrowToggle_spinBars, true));
        m2303d(Math.round(typedArrayObtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.f1448h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.DrawerArrowToggle_drawableSize, 0);
        this.f1443c = Math.round(typedArrayObtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_barLength, 0.0f));
        this.f1442b = Math.round(typedArrayObtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.f1444d = typedArrayObtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public static float m2300a(float f10, float f11, float f12) {
        return f10 + ((f11 - f10) * f12);
    }

    /* renamed from: b */
    public void m2301b(float f10) {
        if (this.f1441a.getStrokeWidth() != f10) {
            this.f1441a.setStrokeWidth(f10);
            this.f1451k = (float) ((f10 / 2.0f) * Math.cos(f1440m));
            invalidateSelf();
        }
    }

    /* renamed from: c */
    public void m2302c(int i10) {
        if (i10 != this.f1441a.getColor()) {
            this.f1441a.setColor(i10);
            invalidateSelf();
        }
    }

    /* renamed from: d */
    public void m2303d(float f10) {
        if (f10 != this.f1445e) {
            this.f1445e = f10;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i10 = this.f1452l;
        boolean z10 = false;
        if (i10 != 0 && (i10 == 1 || (i10 == 3 ? C13669a.m82221b(this) == 0 : C13669a.m82221b(this) == 1))) {
            z10 = true;
        }
        float f10 = this.f1442b;
        float fM2300a = m2300a(this.f1443c, (float) Math.sqrt(f10 * f10 * 2.0f), this.f1450j);
        float fM2300a2 = m2300a(this.f1443c, this.f1444d, this.f1450j);
        float fRound = Math.round(m2300a(0.0f, this.f1451k, this.f1450j));
        float fM2300a3 = m2300a(0.0f, f1440m, this.f1450j);
        float fM2300a4 = m2300a(z10 ? 0.0f : -180.0f, z10 ? 180.0f : 0.0f, this.f1450j);
        double d10 = fM2300a;
        double d11 = fM2300a3;
        boolean z11 = z10;
        float fRound2 = Math.round(Math.cos(d11) * d10);
        float fRound3 = Math.round(d10 * Math.sin(d11));
        this.f1447g.rewind();
        float fM2300a5 = m2300a(this.f1445e + this.f1441a.getStrokeWidth(), -this.f1451k, this.f1450j);
        float f11 = (-fM2300a2) / 2.0f;
        this.f1447g.moveTo(f11 + fRound, 0.0f);
        this.f1447g.rLineTo(fM2300a2 - (fRound * 2.0f), 0.0f);
        this.f1447g.moveTo(f11, fM2300a5);
        this.f1447g.rLineTo(fRound2, fRound3);
        this.f1447g.moveTo(f11, -fM2300a5);
        this.f1447g.rLineTo(fRound2, -fRound3);
        this.f1447g.close();
        canvas.save();
        float strokeWidth = this.f1441a.getStrokeWidth();
        float fHeight = bounds.height() - (3.0f * strokeWidth);
        canvas.translate(bounds.centerX(), ((((int) (fHeight - (2.0f * r5))) / 4) * 2) + (strokeWidth * 1.5f) + this.f1445e);
        if (this.f1446f) {
            canvas.rotate(fM2300a4 * (this.f1449i ^ z11 ? -1 : 1));
        } else if (z11) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f1447g, this.f1441a);
        canvas.restore();
    }

    /* renamed from: e */
    public void m2304e(boolean z10) {
        if (this.f1446f != z10) {
            this.f1446f = z10;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1448h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1448h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (i10 != this.f1441a.getAlpha()) {
            this.f1441a.setAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1441a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
