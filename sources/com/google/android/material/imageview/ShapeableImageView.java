package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import p211d.C8968a;
import p276f3.C9649c;
import p356i3.C10427h;
import p356i3.C10432m;
import p356i3.C10433n;
import p356i3.InterfaceC10435p;
import p416k3.C10981a;

/* loaded from: classes.dex */
public class ShapeableImageView extends AppCompatImageView implements InterfaceC10435p {

    /* renamed from: s */
    public static final int f8191s = R$style.Widget_MaterialComponents_ShapeableImageView;

    /* renamed from: a */
    public final C10433n f8192a;

    /* renamed from: b */
    public final RectF f8193b;

    /* renamed from: c */
    public final RectF f8194c;

    /* renamed from: d */
    public final Paint f8195d;

    /* renamed from: e */
    public final Paint f8196e;

    /* renamed from: f */
    public final Path f8197f;

    /* renamed from: g */
    public ColorStateList f8198g;

    /* renamed from: h */
    public C10427h f8199h;

    /* renamed from: i */
    public C10432m f8200i;

    /* renamed from: j */
    public float f8201j;

    /* renamed from: k */
    public Path f8202k;

    /* renamed from: l */
    public int f8203l;

    /* renamed from: m */
    public int f8204m;

    /* renamed from: n */
    public int f8205n;

    /* renamed from: o */
    public int f8206o;

    /* renamed from: p */
    public int f8207p;

    /* renamed from: q */
    public int f8208q;

    /* renamed from: r */
    public boolean f8209r;

    @TargetApi(21)
    /* renamed from: com.google.android.material.imageview.ShapeableImageView$a */
    public class C1762a extends ViewOutlineProvider {

        /* renamed from: a */
        public final Rect f8210a = new Rect();

        public C1762a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (ShapeableImageView.this.f8200i == null) {
                return;
            }
            if (ShapeableImageView.this.f8199h == null) {
                ShapeableImageView.this.f8199h = new C10427h(ShapeableImageView.this.f8200i);
            }
            ShapeableImageView.this.f8193b.round(this.f8210a);
            ShapeableImageView.this.f8199h.setBounds(this.f8210a);
            ShapeableImageView.this.f8199h.getOutline(outline);
        }
    }

    public ShapeableImageView(Context context) {
        this(context, null, 0);
    }

    /* renamed from: i */
    private boolean m10542i() {
        return getLayoutDirection() == 1;
    }

    /* renamed from: g */
    public final void m10543g(Canvas canvas) {
        if (this.f8198g == null) {
            return;
        }
        this.f8195d.setStrokeWidth(this.f8201j);
        int colorForState = this.f8198g.getColorForState(getDrawableState(), this.f8198g.getDefaultColor());
        if (this.f8201j <= 0.0f || colorForState == 0) {
            return;
        }
        this.f8195d.setColor(colorForState);
        canvas.drawPath(this.f8197f, this.f8195d);
    }

    public int getContentPaddingBottom() {
        return this.f8206o;
    }

    public final int getContentPaddingEnd() {
        int i10 = this.f8208q;
        return i10 != Integer.MIN_VALUE ? i10 : m10542i() ? this.f8203l : this.f8205n;
    }

    public int getContentPaddingLeft() {
        int i10;
        int i11;
        if (m10544h()) {
            if (m10542i() && (i11 = this.f8208q) != Integer.MIN_VALUE) {
                return i11;
            }
            if (!m10542i() && (i10 = this.f8207p) != Integer.MIN_VALUE) {
                return i10;
            }
        }
        return this.f8203l;
    }

    public int getContentPaddingRight() {
        int i10;
        int i11;
        if (m10544h()) {
            if (m10542i() && (i11 = this.f8207p) != Integer.MIN_VALUE) {
                return i11;
            }
            if (!m10542i() && (i10 = this.f8208q) != Integer.MIN_VALUE) {
                return i10;
            }
        }
        return this.f8205n;
    }

    public final int getContentPaddingStart() {
        int i10 = this.f8207p;
        return i10 != Integer.MIN_VALUE ? i10 : m10542i() ? this.f8205n : this.f8203l;
    }

    public int getContentPaddingTop() {
        return this.f8204m;
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    public C10432m getShapeAppearanceModel() {
        return this.f8200i;
    }

    public ColorStateList getStrokeColor() {
        return this.f8198g;
    }

    public float getStrokeWidth() {
        return this.f8201j;
    }

    /* renamed from: h */
    public final boolean m10544h() {
        return (this.f8207p == Integer.MIN_VALUE && this.f8208q == Integer.MIN_VALUE) ? false : true;
    }

    /* renamed from: j */
    public final void m10545j(int i10, int i11) {
        this.f8193b.set(getPaddingLeft(), getPaddingTop(), i10 - getPaddingRight(), i11 - getPaddingBottom());
        this.f8192a.m64110d(this.f8200i, 1.0f, this.f8193b, this.f8197f);
        this.f8202k.rewind();
        this.f8202k.addPath(this.f8197f);
        this.f8194c.set(0.0f, 0.0f, i10, i11);
        this.f8202k.addRect(this.f8194c, Path.Direction.CCW);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        setLayerType(0, null);
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f8202k, this.f8196e);
        m10543g(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (!this.f8209r && isLayoutDirectionResolved()) {
            this.f8209r = true;
            if (isPaddingRelative() || m10544h()) {
                setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            } else {
                setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        m10545j(i10, i11);
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        super.setPadding(i10 + getContentPaddingLeft(), i11 + getContentPaddingTop(), i12 + getContentPaddingRight(), i13 + getContentPaddingBottom());
    }

    @Override // android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
        super.setPaddingRelative(i10 + getContentPaddingStart(), i11 + getContentPaddingTop(), i12 + getContentPaddingEnd(), i13 + getContentPaddingBottom());
    }

    @Override // p356i3.InterfaceC10435p
    public void setShapeAppearanceModel(C10432m c10432m) {
        this.f8200i = c10432m;
        C10427h c10427h = this.f8199h;
        if (c10427h != null) {
            c10427h.setShapeAppearanceModel(c10432m);
        }
        m10545j(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f8198g = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(int i10) {
        setStrokeColor(C8968a.m56742a(getContext(), i10));
    }

    public void setStrokeWidth(float f10) {
        if (this.f8201j != f10) {
            this.f8201j = f10;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i10) {
        setStrokeWidth(getResources().getDimensionPixelSize(i10));
    }

    public ShapeableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ShapeableImageView(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f8191s;
        super(C10981a.m66348c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f8192a = C10433n.m64106k();
        this.f8197f = new Path();
        this.f8209r = false;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f8196e = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f8193b = new RectF();
        this.f8194c = new RectF();
        this.f8202k = new Path();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.ShapeableImageView, i10, i11);
        this.f8198g = C9649c.m60265a(context2, typedArrayObtainStyledAttributes, R$styleable.ShapeableImageView_strokeColor);
        this.f8201j = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_strokeWidth, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPadding, 0);
        this.f8203l = dimensionPixelSize;
        this.f8204m = dimensionPixelSize;
        this.f8205n = dimensionPixelSize;
        this.f8206o = dimensionPixelSize;
        this.f8203l = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingLeft, dimensionPixelSize);
        this.f8204m = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingTop, dimensionPixelSize);
        this.f8205n = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingRight, dimensionPixelSize);
        this.f8206o = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingBottom, dimensionPixelSize);
        this.f8207p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingStart, Integer.MIN_VALUE);
        this.f8208q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ShapeableImageView_contentPaddingEnd, Integer.MIN_VALUE);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint2 = new Paint();
        this.f8195d = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        this.f8200i = C10432m.m64049e(context2, attributeSet, i10, i11).m64093m();
        setOutlineProvider(new C1762a());
    }
}
