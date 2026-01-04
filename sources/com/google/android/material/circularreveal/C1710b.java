package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.circularreveal.InterfaceC1711c;
import p045c3.C1382a;

/* renamed from: com.google.android.material.circularreveal.b */
/* loaded from: classes.dex */
public class C1710b {

    /* renamed from: j */
    public static final int f7854j = 2;

    /* renamed from: a */
    public final a f7855a;

    /* renamed from: b */
    public final View f7856b;

    /* renamed from: c */
    public final Path f7857c;

    /* renamed from: d */
    public final Paint f7858d;

    /* renamed from: e */
    public final Paint f7859e;

    /* renamed from: f */
    public InterfaceC1711c.e f7860f;

    /* renamed from: g */
    public Drawable f7861g;

    /* renamed from: h */
    public boolean f7862h;

    /* renamed from: i */
    public boolean f7863i;

    /* renamed from: com.google.android.material.circularreveal.b$a */
    public interface a {
        /* renamed from: c */
        void mo10176c(Canvas canvas);

        /* renamed from: d */
        boolean mo10177d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1710b(a aVar) {
        this.f7855a = aVar;
        View view = (View) aVar;
        this.f7856b = view;
        view.setWillNotDraw(false);
        this.f7857c = new Path();
        this.f7858d = new Paint(7);
        Paint paint = new Paint(1);
        this.f7859e = paint;
        paint.setColor(0);
    }

    /* renamed from: a */
    public void m10180a() {
        if (f7854j == 0) {
            this.f7862h = true;
            this.f7863i = false;
            this.f7856b.buildDrawingCache();
            Bitmap drawingCache = this.f7856b.getDrawingCache();
            if (drawingCache == null && this.f7856b.getWidth() != 0 && this.f7856b.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.f7856b.getWidth(), this.f7856b.getHeight(), Bitmap.Config.ARGB_8888);
                this.f7856b.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.f7858d;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.f7862h = false;
            this.f7863i = true;
        }
    }

    /* renamed from: b */
    public void m10181b() {
        if (f7854j == 0) {
            this.f7863i = false;
            this.f7856b.destroyDrawingCache();
            this.f7858d.setShader(null);
            this.f7856b.invalidate();
        }
    }

    /* renamed from: c */
    public void m10182c(Canvas canvas) {
        if (m10193n()) {
            int i10 = f7854j;
            if (i10 == 0) {
                InterfaceC1711c.e eVar = this.f7860f;
                canvas.drawCircle(eVar.f7868a, eVar.f7869b, eVar.f7870c, this.f7858d);
                if (m10195p()) {
                    InterfaceC1711c.e eVar2 = this.f7860f;
                    canvas.drawCircle(eVar2.f7868a, eVar2.f7869b, eVar2.f7870c, this.f7859e);
                }
            } else if (i10 == 1) {
                int iSave = canvas.save();
                canvas.clipPath(this.f7857c);
                this.f7855a.mo10176c(canvas);
                if (m10195p()) {
                    canvas.drawRect(0.0f, 0.0f, this.f7856b.getWidth(), this.f7856b.getHeight(), this.f7859e);
                }
                canvas.restoreToCount(iSave);
            } else {
                if (i10 != 2) {
                    throw new IllegalStateException("Unsupported strategy " + i10);
                }
                this.f7855a.mo10176c(canvas);
                if (m10195p()) {
                    canvas.drawRect(0.0f, 0.0f, this.f7856b.getWidth(), this.f7856b.getHeight(), this.f7859e);
                }
            }
        } else {
            this.f7855a.mo10176c(canvas);
            if (m10195p()) {
                canvas.drawRect(0.0f, 0.0f, this.f7856b.getWidth(), this.f7856b.getHeight(), this.f7859e);
            }
        }
        m10183d(canvas);
    }

    /* renamed from: d */
    public final void m10183d(Canvas canvas) {
        if (m10194o()) {
            Rect bounds = this.f7861g.getBounds();
            float fWidth = this.f7860f.f7868a - (bounds.width() / 2.0f);
            float fHeight = this.f7860f.f7869b - (bounds.height() / 2.0f);
            canvas.translate(fWidth, fHeight);
            this.f7861g.draw(canvas);
            canvas.translate(-fWidth, -fHeight);
        }
    }

    /* renamed from: e */
    public Drawable m10184e() {
        return this.f7861g;
    }

    /* renamed from: f */
    public int m10185f() {
        return this.f7859e.getColor();
    }

    /* renamed from: g */
    public final float m10186g(InterfaceC1711c.e eVar) {
        return C1382a.m7930b(eVar.f7868a, eVar.f7869b, 0.0f, 0.0f, this.f7856b.getWidth(), this.f7856b.getHeight());
    }

    /* renamed from: h */
    public InterfaceC1711c.e m10187h() {
        InterfaceC1711c.e eVar = this.f7860f;
        if (eVar == null) {
            return null;
        }
        InterfaceC1711c.e eVar2 = new InterfaceC1711c.e(eVar);
        if (eVar2.m10201a()) {
            eVar2.f7870c = m10186g(eVar2);
        }
        return eVar2;
    }

    /* renamed from: i */
    public final void m10188i() {
        if (f7854j == 1) {
            this.f7857c.rewind();
            InterfaceC1711c.e eVar = this.f7860f;
            if (eVar != null) {
                this.f7857c.addCircle(eVar.f7868a, eVar.f7869b, eVar.f7870c, Path.Direction.CW);
            }
        }
        this.f7856b.invalidate();
    }

    /* renamed from: j */
    public boolean m10189j() {
        return this.f7855a.mo10177d() && !m10193n();
    }

    /* renamed from: k */
    public void m10190k(Drawable drawable) {
        this.f7861g = drawable;
        this.f7856b.invalidate();
    }

    /* renamed from: l */
    public void m10191l(int i10) {
        this.f7859e.setColor(i10);
        this.f7856b.invalidate();
    }

    /* renamed from: m */
    public void m10192m(InterfaceC1711c.e eVar) {
        if (eVar == null) {
            this.f7860f = null;
        } else {
            InterfaceC1711c.e eVar2 = this.f7860f;
            if (eVar2 == null) {
                this.f7860f = new InterfaceC1711c.e(eVar);
            } else {
                eVar2.m10203c(eVar);
            }
            if (C1382a.m7931c(eVar.f7870c, m10186g(eVar), 1.0E-4f)) {
                this.f7860f.f7870c = Float.MAX_VALUE;
            }
        }
        m10188i();
    }

    /* renamed from: n */
    public final boolean m10193n() {
        InterfaceC1711c.e eVar = this.f7860f;
        boolean z10 = eVar == null || eVar.m10201a();
        return f7854j == 0 ? !z10 && this.f7863i : !z10;
    }

    /* renamed from: o */
    public final boolean m10194o() {
        return (this.f7862h || this.f7861g == null || this.f7860f == null) ? false : true;
    }

    /* renamed from: p */
    public final boolean m10195p() {
        return (this.f7862h || Color.alpha(this.f7859e.getColor()) == 0) ? false : true;
    }
}
