package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.R$styleable;
import p211d.C8968a;

/* loaded from: classes.dex */
public class ImageFilterButton extends AppCompatImageButton {

    /* renamed from: d */
    public ImageFilterView.C0574c f2821d;

    /* renamed from: e */
    public float f2822e;

    /* renamed from: f */
    public float f2823f;

    /* renamed from: g */
    public float f2824g;

    /* renamed from: h */
    public Path f2825h;

    /* renamed from: i */
    public ViewOutlineProvider f2826i;

    /* renamed from: j */
    public RectF f2827j;

    /* renamed from: k */
    public Drawable[] f2828k;

    /* renamed from: l */
    public LayerDrawable f2829l;

    /* renamed from: m */
    public boolean f2830m;

    /* renamed from: n */
    public Drawable f2831n;

    /* renamed from: o */
    public Drawable f2832o;

    /* renamed from: p */
    public float f2833p;

    /* renamed from: q */
    public float f2834q;

    /* renamed from: r */
    public float f2835r;

    /* renamed from: s */
    public float f2836s;

    /* renamed from: androidx.constraintlayout.utils.widget.ImageFilterButton$a */
    public class C0570a extends ViewOutlineProvider {
        public C0570a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), (Math.min(r3, r4) * ImageFilterButton.this.f2823f) / 2.0f);
        }
    }

    /* renamed from: androidx.constraintlayout.utils.widget.ImageFilterButton$b */
    public class C0571b extends ViewOutlineProvider {
        public C0571b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.this.f2824g);
        }
    }

    public ImageFilterButton(Context context) {
        super(context);
        this.f2821d = new ImageFilterView.C0574c();
        this.f2822e = 0.0f;
        this.f2823f = 0.0f;
        this.f2824g = Float.NaN;
        this.f2828k = new Drawable[2];
        this.f2830m = true;
        this.f2831n = null;
        this.f2832o = null;
        this.f2833p = Float.NaN;
        this.f2834q = Float.NaN;
        this.f2835r = Float.NaN;
        this.f2836s = Float.NaN;
        m3528c(context, null);
    }

    private void setOverlay(boolean z10) {
        this.f2830m = z10;
    }

    /* renamed from: c */
    public final void m3528c(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ImageFilterView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            this.f2831n = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ImageFilterView_altSrc);
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.ImageFilterView_crossfade) {
                    this.f2822e = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R$styleable.ImageFilterView_warmth) {
                    setWarmth(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_saturation) {
                    setSaturation(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_contrast) {
                    setContrast(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_round) {
                    setRound(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R$styleable.ImageFilterView_overlay) {
                    setOverlay(typedArrayObtainStyledAttributes.getBoolean(index, this.f2830m));
                } else if (index == R$styleable.ImageFilterView_imagePanX) {
                    setImagePanX(typedArrayObtainStyledAttributes.getFloat(index, this.f2833p));
                } else if (index == R$styleable.ImageFilterView_imagePanY) {
                    setImagePanY(typedArrayObtainStyledAttributes.getFloat(index, this.f2834q));
                } else if (index == R$styleable.ImageFilterView_imageRotate) {
                    setImageRotate(typedArrayObtainStyledAttributes.getFloat(index, this.f2836s));
                } else if (index == R$styleable.ImageFilterView_imageZoom) {
                    setImageZoom(typedArrayObtainStyledAttributes.getFloat(index, this.f2835r));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f2832o = drawable;
            if (this.f2831n == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.f2832o = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.f2828k;
                    Drawable drawableMutate = drawable2.mutate();
                    this.f2832o = drawableMutate;
                    drawableArr[0] = drawableMutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.f2828k;
            Drawable drawableMutate2 = getDrawable().mutate();
            this.f2832o = drawableMutate2;
            drawableArr2[0] = drawableMutate2;
            this.f2828k[1] = this.f2831n.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.f2828k);
            this.f2829l = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.f2822e * 255.0f));
            if (!this.f2830m) {
                this.f2829l.getDrawable(0).setAlpha((int) ((1.0f - this.f2822e) * 255.0f));
            }
            super.setImageDrawable(this.f2829l);
        }
    }

    /* renamed from: d */
    public final void m3529d() {
        if (Float.isNaN(this.f2833p) && Float.isNaN(this.f2834q) && Float.isNaN(this.f2835r) && Float.isNaN(this.f2836s)) {
            return;
        }
        float f10 = Float.isNaN(this.f2833p) ? 0.0f : this.f2833p;
        float f11 = Float.isNaN(this.f2834q) ? 0.0f : this.f2834q;
        float f12 = Float.isNaN(this.f2835r) ? 1.0f : this.f2835r;
        float f13 = Float.isNaN(this.f2836s) ? 0.0f : this.f2836s;
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

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    /* renamed from: e */
    public final void m3530e() {
        if (Float.isNaN(this.f2833p) && Float.isNaN(this.f2834q) && Float.isNaN(this.f2835r) && Float.isNaN(this.f2836s)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            m3529d();
        }
    }

    public float getContrast() {
        return this.f2821d.f2862f;
    }

    public float getCrossfade() {
        return this.f2822e;
    }

    public float getImagePanX() {
        return this.f2833p;
    }

    public float getImagePanY() {
        return this.f2834q;
    }

    public float getImageRotate() {
        return this.f2836s;
    }

    public float getImageZoom() {
        return this.f2835r;
    }

    public float getRound() {
        return this.f2824g;
    }

    public float getRoundPercent() {
        return this.f2823f;
    }

    public float getSaturation() {
        return this.f2821d.f2861e;
    }

    public float getWarmth() {
        return this.f2821d.f2863g;
    }

    @Override // android.view.View
    public void layout(int i10, int i11, int i12, int i13) {
        super.layout(i10, i11, i12, i13);
        m3529d();
    }

    public void setAltImageResource(int i10) {
        Drawable drawableMutate = C8968a.m56743b(getContext(), i10).mutate();
        this.f2831n = drawableMutate;
        Drawable[] drawableArr = this.f2828k;
        drawableArr[0] = this.f2832o;
        drawableArr[1] = drawableMutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f2828k);
        this.f2829l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f2822e);
    }

    public void setBrightness(float f10) {
        ImageFilterView.C0574c c0574c = this.f2821d;
        c0574c.f2860d = f10;
        c0574c.m3537c(this);
    }

    public void setContrast(float f10) {
        ImageFilterView.C0574c c0574c = this.f2821d;
        c0574c.f2862f = f10;
        c0574c.m3537c(this);
    }

    public void setCrossfade(float f10) {
        this.f2822e = f10;
        if (this.f2828k != null) {
            if (!this.f2830m) {
                this.f2829l.getDrawable(0).setAlpha((int) ((1.0f - this.f2822e) * 255.0f));
            }
            this.f2829l.getDrawable(1).setAlpha((int) (this.f2822e * 255.0f));
            super.setImageDrawable(this.f2829l);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f2831n == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.f2832o = drawableMutate;
        Drawable[] drawableArr = this.f2828k;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f2831n;
        LayerDrawable layerDrawable = new LayerDrawable(this.f2828k);
        this.f2829l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f2822e);
    }

    public void setImagePanX(float f10) {
        this.f2833p = f10;
        m3530e();
    }

    public void setImagePanY(float f10) {
        this.f2834q = f10;
        m3530e();
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageResource(int i10) {
        if (this.f2831n == null) {
            super.setImageResource(i10);
            return;
        }
        Drawable drawableMutate = C8968a.m56743b(getContext(), i10).mutate();
        this.f2832o = drawableMutate;
        Drawable[] drawableArr = this.f2828k;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f2831n;
        LayerDrawable layerDrawable = new LayerDrawable(this.f2828k);
        this.f2829l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f2822e);
    }

    public void setImageRotate(float f10) {
        this.f2836s = f10;
        m3530e();
    }

    public void setImageZoom(float f10) {
        this.f2835r = f10;
        m3530e();
    }

    public void setRound(float f10) {
        if (Float.isNaN(f10)) {
            this.f2824g = f10;
            float f11 = this.f2823f;
            this.f2823f = -1.0f;
            setRoundPercent(f11);
            return;
        }
        boolean z10 = this.f2824g != f10;
        this.f2824g = f10;
        if (f10 != 0.0f) {
            if (this.f2825h == null) {
                this.f2825h = new Path();
            }
            if (this.f2827j == null) {
                this.f2827j = new RectF();
            }
            if (this.f2826i == null) {
                C0571b c0571b = new C0571b();
                this.f2826i = c0571b;
                setOutlineProvider(c0571b);
            }
            setClipToOutline(true);
            this.f2827j.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f2825h.reset();
            Path path = this.f2825h;
            RectF rectF = this.f2827j;
            float f12 = this.f2824g;
            path.addRoundRect(rectF, f12, f12, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f10) {
        boolean z10 = this.f2823f != f10;
        this.f2823f = f10;
        if (f10 != 0.0f) {
            if (this.f2825h == null) {
                this.f2825h = new Path();
            }
            if (this.f2827j == null) {
                this.f2827j = new RectF();
            }
            if (this.f2826i == null) {
                C0570a c0570a = new C0570a();
                this.f2826i = c0570a;
                setOutlineProvider(c0570a);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f2823f) / 2.0f;
            this.f2827j.set(0.0f, 0.0f, width, height);
            this.f2825h.reset();
            this.f2825h.addRoundRect(this.f2827j, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f10) {
        ImageFilterView.C0574c c0574c = this.f2821d;
        c0574c.f2861e = f10;
        c0574c.m3537c(this);
    }

    public void setWarmth(float f10) {
        ImageFilterView.C0574c c0574c = this.f2821d;
        c0574c.f2863g = f10;
        c0574c.m3537c(this);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2821d = new ImageFilterView.C0574c();
        this.f2822e = 0.0f;
        this.f2823f = 0.0f;
        this.f2824g = Float.NaN;
        this.f2828k = new Drawable[2];
        this.f2830m = true;
        this.f2831n = null;
        this.f2832o = null;
        this.f2833p = Float.NaN;
        this.f2834q = Float.NaN;
        this.f2835r = Float.NaN;
        this.f2836s = Float.NaN;
        m3528c(context, attributeSet);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2821d = new ImageFilterView.C0574c();
        this.f2822e = 0.0f;
        this.f2823f = 0.0f;
        this.f2824g = Float.NaN;
        this.f2828k = new Drawable[2];
        this.f2830m = true;
        this.f2831n = null;
        this.f2832o = null;
        this.f2833p = Float.NaN;
        this.f2834q = Float.NaN;
        this.f2835r = Float.NaN;
        this.f2836s = Float.NaN;
        m3528c(context, attributeSet);
    }
}
