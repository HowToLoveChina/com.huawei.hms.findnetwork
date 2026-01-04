package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R$styleable;
import p211d.C8968a;

/* loaded from: classes.dex */
public class ImageFilterView extends AppCompatImageView {

    /* renamed from: a */
    public C0574c f2839a;

    /* renamed from: b */
    public boolean f2840b;

    /* renamed from: c */
    public Drawable f2841c;

    /* renamed from: d */
    public Drawable f2842d;

    /* renamed from: e */
    public float f2843e;

    /* renamed from: f */
    public float f2844f;

    /* renamed from: g */
    public float f2845g;

    /* renamed from: h */
    public Path f2846h;

    /* renamed from: i */
    public ViewOutlineProvider f2847i;

    /* renamed from: j */
    public RectF f2848j;

    /* renamed from: k */
    public Drawable[] f2849k;

    /* renamed from: l */
    public LayerDrawable f2850l;

    /* renamed from: m */
    public float f2851m;

    /* renamed from: n */
    public float f2852n;

    /* renamed from: o */
    public float f2853o;

    /* renamed from: p */
    public float f2854p;

    /* renamed from: androidx.constraintlayout.utils.widget.ImageFilterView$a */
    public class C0572a extends ViewOutlineProvider {
        public C0572a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), (Math.min(r3, r4) * ImageFilterView.this.f2844f) / 2.0f);
        }
    }

    /* renamed from: androidx.constraintlayout.utils.widget.ImageFilterView$b */
    public class C0573b extends ViewOutlineProvider {
        public C0573b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.f2845g);
        }
    }

    /* renamed from: androidx.constraintlayout.utils.widget.ImageFilterView$c */
    public static class C0574c {

        /* renamed from: a */
        public float[] f2857a = new float[20];

        /* renamed from: b */
        public ColorMatrix f2858b = new ColorMatrix();

        /* renamed from: c */
        public ColorMatrix f2859c = new ColorMatrix();

        /* renamed from: d */
        public float f2860d = 1.0f;

        /* renamed from: e */
        public float f2861e = 1.0f;

        /* renamed from: f */
        public float f2862f = 1.0f;

        /* renamed from: g */
        public float f2863g = 1.0f;

        /* renamed from: a */
        public final void m3535a(float f10) {
            float[] fArr = this.f2857a;
            fArr[0] = f10;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f10;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f10;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        /* renamed from: b */
        public final void m3536b(float f10) {
            float f11 = 1.0f - f10;
            float f12 = 0.2999f * f11;
            float f13 = 0.587f * f11;
            float f14 = f11 * 0.114f;
            float[] fArr = this.f2857a;
            fArr[0] = f12 + f10;
            fArr[1] = f13;
            fArr[2] = f14;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f12;
            fArr[6] = f13 + f10;
            fArr[7] = f14;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f12;
            fArr[11] = f13;
            fArr[12] = f14 + f10;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        /* renamed from: c */
        public void m3537c(ImageView imageView) {
            boolean z10;
            this.f2858b.reset();
            float f10 = this.f2861e;
            boolean z11 = true;
            if (f10 != 1.0f) {
                m3536b(f10);
                this.f2858b.set(this.f2857a);
                z10 = true;
            } else {
                z10 = false;
            }
            float f11 = this.f2862f;
            if (f11 != 1.0f) {
                this.f2859c.setScale(f11, f11, f11, 1.0f);
                this.f2858b.postConcat(this.f2859c);
                z10 = true;
            }
            float f12 = this.f2863g;
            if (f12 != 1.0f) {
                m3538d(f12);
                this.f2859c.set(this.f2857a);
                this.f2858b.postConcat(this.f2859c);
            } else {
                z11 = z10;
            }
            float f13 = this.f2860d;
            if (f13 != 1.0f) {
                m3535a(f13);
                this.f2859c.set(this.f2857a);
                this.f2858b.postConcat(this.f2859c);
            } else if (!z11) {
                imageView.clearColorFilter();
                return;
            }
            imageView.setColorFilter(new ColorMatrixColorFilter(this.f2858b));
        }

        /* renamed from: d */
        public final void m3538d(float f10) {
            float fLog;
            float fPow;
            if (f10 <= 0.0f) {
                f10 = 0.01f;
            }
            float f11 = (5000.0f / f10) / 100.0f;
            if (f11 > 66.0f) {
                double d10 = f11 - 60.0f;
                fPow = ((float) Math.pow(d10, -0.13320475816726685d)) * 329.69873f;
                fLog = ((float) Math.pow(d10, 0.07551485300064087d)) * 288.12216f;
            } else {
                fLog = (((float) Math.log(f11)) * 99.4708f) - 161.11957f;
                fPow = 255.0f;
            }
            float fLog2 = f11 < 66.0f ? f11 > 19.0f ? (((float) Math.log(f11 - 10.0f)) * 138.51773f) - 305.0448f : 0.0f : 255.0f;
            float fMin = Math.min(255.0f, Math.max(fPow, 0.0f));
            float fMin2 = Math.min(255.0f, Math.max(fLog, 0.0f));
            float fMin3 = Math.min(255.0f, Math.max(fLog2, 0.0f));
            float fLog3 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float fLog4 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float fMin4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float fMin5 = Math.min(255.0f, Math.max(fLog3, 0.0f));
            float fMin6 = fMin3 / Math.min(255.0f, Math.max(fLog4, 0.0f));
            float[] fArr = this.f2857a;
            fArr[0] = fMin / fMin4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = fMin2 / fMin5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = fMin6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }
    }

    public ImageFilterView(Context context) {
        super(context);
        this.f2839a = new C0574c();
        this.f2840b = true;
        this.f2841c = null;
        this.f2842d = null;
        this.f2843e = 0.0f;
        this.f2844f = 0.0f;
        this.f2845g = Float.NaN;
        this.f2849k = new Drawable[2];
        this.f2851m = Float.NaN;
        this.f2852n = Float.NaN;
        this.f2853o = Float.NaN;
        this.f2854p = Float.NaN;
        init(context, null);
    }

    /* renamed from: e */
    private void m3533e() {
        if (Float.isNaN(this.f2851m) && Float.isNaN(this.f2852n) && Float.isNaN(this.f2853o) && Float.isNaN(this.f2854p)) {
            return;
        }
        float f10 = Float.isNaN(this.f2851m) ? 0.0f : this.f2851m;
        float f11 = Float.isNaN(this.f2852n) ? 0.0f : this.f2852n;
        float f12 = Float.isNaN(this.f2853o) ? 1.0f : this.f2853o;
        float f13 = Float.isNaN(this.f2854p) ? 0.0f : this.f2854p;
        Matrix matrix = new Matrix();
        matrix.reset();
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float width = getWidth();
        float height = getHeight();
        float f14 = f12 * (intrinsicWidth * height < intrinsicHeight * width ? width / intrinsicWidth : height / intrinsicHeight);
        matrix.postScale(f14, f14);
        float f15 = intrinsicWidth * f14;
        float f16 = f14 * intrinsicHeight;
        matrix.postTranslate((((f10 * (width - f15)) + width) - f15) * 0.5f, (((f11 * (height - f16)) + height) - f16) * 0.5f);
        matrix.postRotate(f13, width / 2.0f, height / 2.0f);
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    /* renamed from: f */
    private void m3534f() {
        if (Float.isNaN(this.f2851m) && Float.isNaN(this.f2852n) && Float.isNaN(this.f2853o) && Float.isNaN(this.f2854p)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            m3533e();
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ImageFilterView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            this.f2841c = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ImageFilterView_altSrc);
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.ImageFilterView_crossfade) {
                    this.f2843e = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R$styleable.ImageFilterView_warmth) {
                    setWarmth(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_saturation) {
                    setSaturation(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_contrast) {
                    setContrast(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_brightness) {
                    setBrightness(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_round) {
                    setRound(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_overlay) {
                    setOverlay(typedArrayObtainStyledAttributes.getBoolean(index, this.f2840b));
                } else if (index == R$styleable.ImageFilterView_imagePanX) {
                    setImagePanX(typedArrayObtainStyledAttributes.getFloat(index, this.f2851m));
                } else if (index == R$styleable.ImageFilterView_imagePanY) {
                    setImagePanY(typedArrayObtainStyledAttributes.getFloat(index, this.f2852n));
                } else if (index == R$styleable.ImageFilterView_imageRotate) {
                    setImageRotate(typedArrayObtainStyledAttributes.getFloat(index, this.f2854p));
                } else if (index == R$styleable.ImageFilterView_imageZoom) {
                    setImageZoom(typedArrayObtainStyledAttributes.getFloat(index, this.f2853o));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f2842d = drawable;
            if (this.f2841c == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.f2842d = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.f2849k;
                    Drawable drawableMutate = drawable2.mutate();
                    this.f2842d = drawableMutate;
                    drawableArr[0] = drawableMutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.f2849k;
            Drawable drawableMutate2 = getDrawable().mutate();
            this.f2842d = drawableMutate2;
            drawableArr2[0] = drawableMutate2;
            this.f2849k[1] = this.f2841c.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.f2849k);
            this.f2850l = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.f2843e * 255.0f));
            if (!this.f2840b) {
                this.f2850l.getDrawable(0).setAlpha((int) ((1.0f - this.f2843e) * 255.0f));
            }
            super.setImageDrawable(this.f2850l);
        }
    }

    private void setOverlay(boolean z10) {
        this.f2840b = z10;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getBrightness() {
        return this.f2839a.f2860d;
    }

    public float getContrast() {
        return this.f2839a.f2862f;
    }

    public float getCrossfade() {
        return this.f2843e;
    }

    public float getImagePanX() {
        return this.f2851m;
    }

    public float getImagePanY() {
        return this.f2852n;
    }

    public float getImageRotate() {
        return this.f2854p;
    }

    public float getImageZoom() {
        return this.f2853o;
    }

    public float getRound() {
        return this.f2845g;
    }

    public float getRoundPercent() {
        return this.f2844f;
    }

    public float getSaturation() {
        return this.f2839a.f2861e;
    }

    public float getWarmth() {
        return this.f2839a.f2863g;
    }

    @Override // android.view.View
    public void layout(int i10, int i11, int i12, int i13) {
        super.layout(i10, i11, i12, i13);
        m3533e();
    }

    public void setAltImageDrawable(Drawable drawable) {
        Drawable drawableMutate = drawable.mutate();
        this.f2841c = drawableMutate;
        Drawable[] drawableArr = this.f2849k;
        drawableArr[0] = this.f2842d;
        drawableArr[1] = drawableMutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f2849k);
        this.f2850l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f2843e);
    }

    public void setAltImageResource(int i10) {
        Drawable drawableM56743b = C8968a.m56743b(getContext(), i10);
        this.f2841c = drawableM56743b;
        setAltImageDrawable(drawableM56743b);
    }

    public void setBrightness(float f10) {
        C0574c c0574c = this.f2839a;
        c0574c.f2860d = f10;
        c0574c.m3537c(this);
    }

    public void setContrast(float f10) {
        C0574c c0574c = this.f2839a;
        c0574c.f2862f = f10;
        c0574c.m3537c(this);
    }

    public void setCrossfade(float f10) {
        this.f2843e = f10;
        if (this.f2849k != null) {
            if (!this.f2840b) {
                this.f2850l.getDrawable(0).setAlpha((int) ((1.0f - this.f2843e) * 255.0f));
            }
            this.f2850l.getDrawable(1).setAlpha((int) (this.f2843e * 255.0f));
            super.setImageDrawable(this.f2850l);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f2841c == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.f2842d = drawableMutate;
        Drawable[] drawableArr = this.f2849k;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f2841c;
        LayerDrawable layerDrawable = new LayerDrawable(this.f2849k);
        this.f2850l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f2843e);
    }

    public void setImagePanX(float f10) {
        this.f2851m = f10;
        m3534f();
    }

    public void setImagePanY(float f10) {
        this.f2852n = f10;
        m3534f();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i10) {
        if (this.f2841c == null) {
            super.setImageResource(i10);
            return;
        }
        Drawable drawableMutate = C8968a.m56743b(getContext(), i10).mutate();
        this.f2842d = drawableMutate;
        Drawable[] drawableArr = this.f2849k;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f2841c;
        LayerDrawable layerDrawable = new LayerDrawable(this.f2849k);
        this.f2850l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f2843e);
    }

    public void setImageRotate(float f10) {
        this.f2854p = f10;
        m3534f();
    }

    public void setImageZoom(float f10) {
        this.f2853o = f10;
        m3534f();
    }

    public void setRound(float f10) {
        if (Float.isNaN(f10)) {
            this.f2845g = f10;
            float f11 = this.f2844f;
            this.f2844f = -1.0f;
            setRoundPercent(f11);
            return;
        }
        boolean z10 = this.f2845g != f10;
        this.f2845g = f10;
        if (f10 != 0.0f) {
            if (this.f2846h == null) {
                this.f2846h = new Path();
            }
            if (this.f2848j == null) {
                this.f2848j = new RectF();
            }
            if (this.f2847i == null) {
                C0573b c0573b = new C0573b();
                this.f2847i = c0573b;
                setOutlineProvider(c0573b);
            }
            setClipToOutline(true);
            this.f2848j.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f2846h.reset();
            Path path = this.f2846h;
            RectF rectF = this.f2848j;
            float f12 = this.f2845g;
            path.addRoundRect(rectF, f12, f12, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f10) {
        boolean z10 = this.f2844f != f10;
        this.f2844f = f10;
        if (f10 != 0.0f) {
            if (this.f2846h == null) {
                this.f2846h = new Path();
            }
            if (this.f2848j == null) {
                this.f2848j = new RectF();
            }
            if (this.f2847i == null) {
                C0572a c0572a = new C0572a();
                this.f2847i = c0572a;
                setOutlineProvider(c0572a);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f2844f) / 2.0f;
            this.f2848j.set(0.0f, 0.0f, width, height);
            this.f2846h.reset();
            this.f2846h.addRoundRect(this.f2848j, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f10) {
        C0574c c0574c = this.f2839a;
        c0574c.f2861e = f10;
        c0574c.m3537c(this);
    }

    public void setWarmth(float f10) {
        C0574c c0574c = this.f2839a;
        c0574c.f2863g = f10;
        c0574c.m3537c(this);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2839a = new C0574c();
        this.f2840b = true;
        this.f2841c = null;
        this.f2842d = null;
        this.f2843e = 0.0f;
        this.f2844f = 0.0f;
        this.f2845g = Float.NaN;
        this.f2849k = new Drawable[2];
        this.f2851m = Float.NaN;
        this.f2852n = Float.NaN;
        this.f2853o = Float.NaN;
        this.f2854p = Float.NaN;
        init(context, attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2839a = new C0574c();
        this.f2840b = true;
        this.f2841c = null;
        this.f2842d = null;
        this.f2843e = 0.0f;
        this.f2844f = 0.0f;
        this.f2845g = Float.NaN;
        this.f2849k = new Drawable[2];
        this.f2851m = Float.NaN;
        this.f2852n = Float.NaN;
        this.f2853o = Float.NaN;
        this.f2854p = Float.NaN;
        init(context, attributeSet);
    }
}
