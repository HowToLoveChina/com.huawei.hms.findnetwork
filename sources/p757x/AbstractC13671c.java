package p757x;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;

/* renamed from: x.c */
/* loaded from: classes.dex */
public abstract class AbstractC13671c extends Drawable {

    /* renamed from: a */
    public final Bitmap f61556a;

    /* renamed from: b */
    public int f61557b;

    /* renamed from: e */
    public final BitmapShader f61560e;

    /* renamed from: g */
    public float f61562g;

    /* renamed from: k */
    public boolean f61566k;

    /* renamed from: l */
    public int f61567l;

    /* renamed from: m */
    public int f61568m;

    /* renamed from: c */
    public int f61558c = 119;

    /* renamed from: d */
    public final Paint f61559d = new Paint(3);

    /* renamed from: f */
    public final Matrix f61561f = new Matrix();

    /* renamed from: h */
    public final Rect f61563h = new Rect();

    /* renamed from: i */
    public final RectF f61564i = new RectF();

    /* renamed from: j */
    public boolean f61565j = true;

    public AbstractC13671c(Resources resources, Bitmap bitmap) {
        this.f61557b = RecommendCardConstants.Num.BANNER_HEIGHT_FONT_SCALE;
        if (resources != null) {
            this.f61557b = resources.getDisplayMetrics().densityDpi;
        }
        this.f61556a = bitmap;
        if (bitmap != null) {
            m82250a();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f61560e = new BitmapShader(bitmap, tileMode, tileMode);
        } else {
            this.f61568m = -1;
            this.f61567l = -1;
            this.f61560e = null;
        }
    }

    /* renamed from: d */
    public static boolean m82249d(float f10) {
        return f10 > 0.05f;
    }

    /* renamed from: a */
    public final void m82250a() {
        this.f61567l = this.f61556a.getScaledWidth(this.f61557b);
        this.f61568m = this.f61556a.getScaledHeight(this.f61557b);
    }

    /* renamed from: b */
    public float m82251b() {
        return this.f61562g;
    }

    /* renamed from: c */
    public abstract void mo82248c(int i10, int i11, int i12, Rect rect, Rect rect2);

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f61556a;
        if (bitmap == null) {
            return;
        }
        m82254g();
        if (this.f61559d.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f61563h, this.f61559d);
            return;
        }
        RectF rectF = this.f61564i;
        float f10 = this.f61562g;
        canvas.drawRoundRect(rectF, f10, f10, this.f61559d);
    }

    /* renamed from: e */
    public void m82252e(float f10) {
        if (this.f61562g == f10) {
            return;
        }
        this.f61566k = false;
        if (m82249d(f10)) {
            this.f61559d.setShader(this.f61560e);
        } else {
            this.f61559d.setShader(null);
        }
        this.f61562g = f10;
        invalidateSelf();
    }

    /* renamed from: f */
    public final void m82253f() {
        this.f61562g = Math.min(this.f61568m, this.f61567l) / 2;
    }

    /* renamed from: g */
    public void m82254g() {
        if (this.f61565j) {
            if (this.f61566k) {
                int iMin = Math.min(this.f61567l, this.f61568m);
                mo82248c(this.f61558c, iMin, iMin, getBounds(), this.f61563h);
                int iMin2 = Math.min(this.f61563h.width(), this.f61563h.height());
                this.f61563h.inset(Math.max(0, (this.f61563h.width() - iMin2) / 2), Math.max(0, (this.f61563h.height() - iMin2) / 2));
                this.f61562g = iMin2 * 0.5f;
            } else {
                mo82248c(this.f61558c, this.f61567l, this.f61568m, getBounds(), this.f61563h);
            }
            this.f61564i.set(this.f61563h);
            if (this.f61560e != null) {
                Matrix matrix = this.f61561f;
                RectF rectF = this.f61564i;
                matrix.setTranslate(rectF.left, rectF.top);
                this.f61561f.preScale(this.f61564i.width() / this.f61556a.getWidth(), this.f61564i.height() / this.f61556a.getHeight());
                this.f61560e.setLocalMatrix(this.f61561f);
                this.f61559d.setShader(this.f61560e);
            }
            this.f61565j = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f61559d.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f61559d.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f61568m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f61567l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        return (this.f61558c != 119 || this.f61566k || (bitmap = this.f61556a) == null || bitmap.hasAlpha() || this.f61559d.getAlpha() < 255 || m82249d(this.f61562g)) ? -3 : -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.f61566k) {
            m82253f();
        }
        this.f61565j = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (i10 != this.f61559d.getAlpha()) {
            this.f61559d.setAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f61559d.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z10) {
        this.f61559d.setDither(z10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z10) {
        this.f61559d.setFilterBitmap(z10);
        invalidateSelf();
    }
}
