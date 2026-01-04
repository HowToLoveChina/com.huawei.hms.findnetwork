package com.huawei.uikit.animations.drawable;

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

/* loaded from: classes6.dex */
public abstract class HwEclipseClipDrawable extends ClipDrawable {

    /* renamed from: g */
    private static final String f40727g = "HwEclipseClipDrawable";

    /* renamed from: h */
    private static final int f40728h = 10000;

    /* renamed from: a */
    private Drawable f40729a;

    /* renamed from: b */
    private Paint f40730b;

    /* renamed from: c */
    private Bitmap f40731c;

    /* renamed from: d */
    private Bitmap f40732d;

    /* renamed from: e */
    private Canvas f40733e;

    /* renamed from: f */
    private PorterDuffXfermode f40734f;

    public HwEclipseClipDrawable(Drawable drawable, int i10, int i11) {
        super(drawable, i10, i11);
        m53620a(drawable);
    }

    /* renamed from: a */
    private void m53620a(Drawable drawable) {
        Paint paint = new Paint();
        this.f40730b = paint;
        paint.setAntiAlias(true);
        this.f40730b.setColor(-16711936);
        this.f40729a = drawable;
        setPorterDuffMode(PorterDuff.Mode.SRC_IN);
    }

    /* renamed from: b */
    private void m53621b() {
        Canvas canvas;
        m53623d();
        Path clipPath = getClipPath(getLevel());
        if (clipPath == null || (canvas = this.f40733e) == null) {
            Log.e(f40727g, "getClipPath fail.");
        } else {
            canvas.drawPath(clipPath, this.f40730b);
        }
    }

    /* renamed from: c */
    private void m53622c() {
        Rect bounds = getBounds();
        if (bounds.width() <= 0 || bounds.height() <= 0) {
            return;
        }
        Bitmap bitmap = this.f40731c;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.f40731c = Bitmap.createBitmap(bounds.width(), bounds.height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f40731c);
        this.f40729a.setBounds(bounds);
        int level = this.f40729a.getLevel();
        this.f40729a.setLevel(10000);
        this.f40729a.draw(canvas);
        this.f40729a.setLevel(level);
    }

    /* renamed from: d */
    private void m53623d() {
        Rect bounds = getBounds();
        if (bounds.width() <= 0 || bounds.height() <= 0) {
            return;
        }
        Bitmap bitmap = this.f40732d;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.f40732d = Bitmap.createBitmap(bounds.width(), bounds.height(), Bitmap.Config.ARGB_8888);
        this.f40733e = new Canvas(this.f40732d);
    }

    @Override // android.graphics.drawable.ClipDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        m53619a();
        m53621b();
        if (this.f40731c == null || this.f40732d == null) {
            return;
        }
        Rect bounds = getBounds();
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, bounds.width(), bounds.height(), null);
        canvas.drawBitmap(this.f40732d, 0.0f, 0.0f, this.f40730b);
        this.f40730b.setXfermode(this.f40734f);
        canvas.drawBitmap(this.f40731c, 0.0f, 0.0f, this.f40730b);
        this.f40730b.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    public abstract Path getClipPath(int i10);

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i10, int i11, int i12, int i13) {
        super.setBounds(i10, i11, i12, i13);
        this.f40729a.setBounds(i10, i11, i12, i13);
        if (this.f40731c != null) {
            m53622c();
        }
        if (this.f40732d != null) {
            m53623d();
            Path clipPath = getClipPath(getLevel());
            if (clipPath != null) {
                this.f40733e.drawPath(clipPath, this.f40730b);
            } else {
                Log.e(f40727g, "getClipPath fail.");
            }
        }
    }

    public void setEclipseInsideColor(int i10) {
        this.f40730b.setColor(i10);
    }

    public void setPorterDuffMode(PorterDuff.Mode mode) {
        this.f40734f = new PorterDuffXfermode(mode);
    }

    /* renamed from: a */
    private void m53619a() {
        if (this.f40731c != null) {
            return;
        }
        m53622c();
    }
}
