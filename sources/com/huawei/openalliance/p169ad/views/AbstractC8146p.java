package com.huawei.openalliance.p169ad.views;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;

/* renamed from: com.huawei.openalliance.ad.views.p */
/* loaded from: classes2.dex */
public abstract class AbstractC8146p extends ClipDrawable {

    /* renamed from: a */
    private Drawable f38070a;

    /* renamed from: b */
    private Paint f38071b;

    /* renamed from: c */
    private Bitmap f38072c;

    /* renamed from: d */
    private Bitmap f38073d;

    /* renamed from: e */
    private Canvas f38074e;

    /* renamed from: f */
    private PorterDuffXfermode f38075f;

    /* renamed from: g */
    private boolean f38076g;

    public AbstractC8146p(Drawable drawable, int i10, int i11) {
        super(drawable, i10, i11);
        m50455a(drawable);
    }

    /* renamed from: a */
    private void m50454a() {
        if (this.f38072c != null) {
            return;
        }
        m50456b();
    }

    /* renamed from: b */
    private void m50456b() {
        Rect bounds = getBounds();
        if (bounds.width() <= 0 || bounds.height() <= 0) {
            return;
        }
        Bitmap bitmap = this.f38072c;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.f38072c = Bitmap.createBitmap(bounds.width(), bounds.height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f38072c);
        this.f38070a.setBounds(bounds);
        int level = this.f38070a.getLevel();
        this.f38070a.setLevel(10000);
        this.f38070a.draw(canvas);
        this.f38070a.setLevel(level);
    }

    /* renamed from: c */
    private void m50457c() {
        Rect bounds = getBounds();
        if (bounds.width() <= 0 || bounds.height() <= 0) {
            return;
        }
        Bitmap bitmap = this.f38073d;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.f38073d = Bitmap.createBitmap(bounds.width(), bounds.height(), Bitmap.Config.ARGB_8888);
        this.f38074e = new Canvas(this.f38073d);
    }

    /* renamed from: d */
    private void m50458d() {
        Canvas canvas;
        m50457c();
        Path pathMo49061a = mo49061a(getLevel());
        if (pathMo49061a == null || (canvas = this.f38074e) == null) {
            Log.e("HwEclipseClipDrawable", "getClipPath fail.");
        } else {
            canvas.drawPath(pathMo49061a, this.f38071b);
        }
    }

    /* renamed from: a */
    public abstract Path mo49061a(int i10);

    @Override // android.graphics.drawable.ClipDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        m50454a();
        m50458d();
        if (this.f38072c == null || this.f38073d == null) {
            return;
        }
        Rect bounds = getBounds();
        if (this.f38076g) {
            canvas.scale(-1.0f, 1.0f, bounds.width() / 2.0f, bounds.height() / 2.0f);
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, bounds.width(), bounds.height(), null);
        canvas.drawBitmap(this.f38073d, 0.0f, 0.0f, this.f38071b);
        this.f38071b.setXfermode(this.f38075f);
        canvas.drawBitmap(this.f38072c, 0.0f, 0.0f, this.f38071b);
        this.f38071b.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i10, int i11, int i12, int i13) {
        super.setBounds(i10, i11, i12, i13);
        this.f38070a.setBounds(i10, i11, i12, i13);
        if (this.f38072c != null) {
            m50456b();
        }
        if (this.f38073d != null) {
            m50457c();
            Path pathMo49061a = mo49061a(getLevel());
            if (pathMo49061a != null) {
                this.f38074e.drawPath(pathMo49061a, this.f38071b);
            } else {
                Log.e("HwEclipseClipDrawable", "getClipPath fail.");
            }
        }
    }

    /* renamed from: a */
    public void m50459a(PorterDuff.Mode mode) {
        this.f38075f = new PorterDuffXfermode(mode);
    }

    /* renamed from: a */
    private void m50455a(Drawable drawable) {
        Paint paint = new Paint();
        this.f38071b = paint;
        paint.setAntiAlias(true);
        this.f38071b.setColor(-16711936);
        this.f38070a = drawable;
        m50459a(PorterDuff.Mode.SRC_IN);
        this.f38076g = AbstractC7811dd.m48332h();
    }
}
