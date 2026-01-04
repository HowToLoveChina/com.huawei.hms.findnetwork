package com.huawei.android.p069cg.p071ui.fileviewdrag;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.huawei.android.p069cg.p071ui.fileviewdrag.ViewOnTouchListenerC2380a;
import p008a7.InterfaceC0057d;
import p031b7.C1120a;

/* loaded from: classes2.dex */
public class FileViewerImageView extends ImageView {

    /* renamed from: a */
    public ViewOnTouchListenerC2380a f11340a;

    /* renamed from: b */
    public boolean f11341b;

    /* renamed from: c */
    public Movie f11342c;

    /* renamed from: d */
    public long f11343d;

    /* renamed from: e */
    public int f11344e;

    /* renamed from: f */
    public int f11345f;

    /* renamed from: g */
    public int f11346g;

    public FileViewerImageView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public final void m14864a() {
        this.f11340a = new ViewOnTouchListenerC2380a(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* renamed from: b */
    public final void m14865b() {
        ViewOnTouchListenerC2380a viewOnTouchListenerC2380a = this.f11340a;
        if (viewOnTouchListenerC2380a != null) {
            viewOnTouchListenerC2380a.m14897T();
        }
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f11340a.m14908y();
    }

    public float getScale() {
        return this.f11340a.m14884E();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f11340a.m14885F();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        C1120a.m6677i("FileViewerImageView", "onDraw isgif:" + this.f11341b);
        if (!this.f11341b) {
            super.onDraw(canvas);
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.f11343d == 0) {
            this.f11343d = jUptimeMillis;
        }
        Movie movie = this.f11342c;
        if (movie != null) {
            int iDuration = movie.duration();
            if (iDuration == 0) {
                iDuration = this.f11344e;
            }
            this.f11342c.setTime((int) ((jUptimeMillis - this.f11343d) % iDuration));
            canvas.save();
            if (this.f11342c.width() > 0 && this.f11342c.height() > 0) {
                float fWidth = this.f11342c.width();
                float fHeight = this.f11342c.height();
                float fMin = Math.min(this.f11345f / fWidth, this.f11346g / fHeight);
                canvas.scale(fMin, fMin);
                float f10 = this.f11345f - (fWidth * fMin);
                float f11 = 2.0f * fMin;
                this.f11342c.draw(canvas, f10 / f11, (this.f11346g - (fHeight * fMin)) / f11);
            }
            invalidate();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f11346g = getMeasuredHeight();
        this.f11345f = getMeasuredWidth();
    }

    public void setClickListener(InterfaceC0057d interfaceC0057d) {
        this.f11340a.m14889L(interfaceC0057d);
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i10, int i11, int i12, int i13) {
        boolean frame = super.setFrame(i10, i11, i12, i13);
        if (frame) {
            m14865b();
        }
        return frame;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m14865b();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        super.setImageResource(i10);
        m14865b();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m14865b();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f11340a.m14891N(onClickListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f11340a.m14892O(onLongClickListener);
    }

    public void setOnScaleListener(ViewOnTouchListenerC2380a.f fVar) {
        this.f11340a.m14893P(fVar);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        ViewOnTouchListenerC2380a viewOnTouchListenerC2380a = this.f11340a;
        if (viewOnTouchListenerC2380a != null) {
            viewOnTouchListenerC2380a.m14896S(scaleType);
        }
    }

    public FileViewerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FileViewerImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11341b = false;
        this.f11342c = null;
        this.f11343d = 0L;
        this.f11344e = 1000;
        m14864a();
    }
}
