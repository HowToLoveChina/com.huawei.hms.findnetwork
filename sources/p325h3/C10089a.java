package p325h3;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import p723w.C13503b;

/* renamed from: h3.a */
/* loaded from: classes.dex */
public class C10089a {

    /* renamed from: i */
    public static final int[] f49264i = new int[3];

    /* renamed from: j */
    public static final float[] f49265j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k */
    public static final int[] f49266k = new int[4];

    /* renamed from: l */
    public static final float[] f49267l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a */
    public final Paint f49268a;

    /* renamed from: b */
    public final Paint f49269b;

    /* renamed from: c */
    public final Paint f49270c;

    /* renamed from: d */
    public int f49271d;

    /* renamed from: e */
    public int f49272e;

    /* renamed from: f */
    public int f49273f;

    /* renamed from: g */
    public final Path f49274g;

    /* renamed from: h */
    public Paint f49275h;

    public C10089a() {
        this(-16777216);
    }

    /* renamed from: a */
    public void m62883a(Canvas canvas, Matrix matrix, RectF rectF, int i10, float f10, float f11) {
        boolean z10 = f11 < 0.0f;
        Path path = this.f49274g;
        if (z10) {
            int[] iArr = f49266k;
            iArr[0] = 0;
            iArr[1] = this.f49273f;
            iArr[2] = this.f49272e;
            iArr[3] = this.f49271d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f10, f11);
            path.close();
            float f12 = -i10;
            rectF.inset(f12, f12);
            int[] iArr2 = f49266k;
            iArr2[0] = 0;
            iArr2[1] = this.f49271d;
            iArr2[2] = this.f49272e;
            iArr2[3] = this.f49273f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f13 = 1.0f - (i10 / fWidth);
        float[] fArr = f49267l;
        fArr[1] = f13;
        fArr[2] = ((1.0f - f13) / 2.0f) + f13;
        this.f49269b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, f49266k, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z10) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f49275h);
        }
        canvas.drawArc(rectF, f10, f11, true, this.f49269b);
        canvas.restore();
    }

    /* renamed from: b */
    public void m62884b(Canvas canvas, Matrix matrix, RectF rectF, int i10) {
        rectF.bottom += i10;
        rectF.offset(0.0f, -i10);
        int[] iArr = f49264i;
        iArr[0] = this.f49273f;
        iArr[1] = this.f49272e;
        iArr[2] = this.f49271d;
        Paint paint = this.f49270c;
        float f10 = rectF.left;
        paint.setShader(new LinearGradient(f10, rectF.top, f10, rectF.bottom, iArr, f49265j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f49270c);
        canvas.restore();
    }

    /* renamed from: c */
    public Paint m62885c() {
        return this.f49268a;
    }

    /* renamed from: d */
    public void m62886d(int i10) {
        this.f49271d = C13503b.m81226j(i10, 68);
        this.f49272e = C13503b.m81226j(i10, 20);
        this.f49273f = C13503b.m81226j(i10, 0);
        this.f49268a.setColor(this.f49271d);
    }

    public C10089a(int i10) {
        this.f49274g = new Path();
        this.f49275h = new Paint();
        this.f49268a = new Paint();
        m62886d(i10);
        this.f49275h.setColor(0);
        Paint paint = new Paint(4);
        this.f49269b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f49270c = new Paint(paint);
    }
}
