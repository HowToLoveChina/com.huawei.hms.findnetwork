package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.cardview.R$attr;
import androidx.cardview.R$color;
import androidx.cardview.R$style;
import androidx.cardview.R$styleable;
import p412k.C10963a;
import p412k.InterfaceC10964b;
import p412k.InterfaceC10965c;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: h */
    public static final int[] f2464h = {R.attr.colorBackground};

    /* renamed from: i */
    public static final InterfaceC10965c f2465i;

    /* renamed from: a */
    public boolean f2466a;

    /* renamed from: b */
    public boolean f2467b;

    /* renamed from: c */
    public int f2468c;

    /* renamed from: d */
    public int f2469d;

    /* renamed from: e */
    public final Rect f2470e;

    /* renamed from: f */
    public final Rect f2471f;

    /* renamed from: g */
    public final InterfaceC10964b f2472g;

    /* renamed from: androidx.cardview.widget.CardView$a */
    public class C0552a implements InterfaceC10964b {

        /* renamed from: a */
        public Drawable f2473a;

        public C0552a() {
        }

        @Override // p412k.InterfaceC10964b
        /* renamed from: a */
        public void mo3214a(int i10, int i11, int i12, int i13) {
            CardView.this.f2471f.set(i10, i11, i12, i13);
            CardView cardView = CardView.this;
            Rect rect = cardView.f2470e;
            CardView.super.setPadding(i10 + rect.left, i11 + rect.top, i12 + rect.right, i13 + rect.bottom);
        }

        @Override // p412k.InterfaceC10964b
        /* renamed from: b */
        public void mo3215b(Drawable drawable) {
            this.f2473a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // p412k.InterfaceC10964b
        /* renamed from: c */
        public boolean mo3216c() {
            return CardView.this.getPreventCornerOverlap();
        }

        @Override // p412k.InterfaceC10964b
        /* renamed from: d */
        public boolean mo3217d() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // p412k.InterfaceC10964b
        /* renamed from: e */
        public Drawable mo3218e() {
            return this.f2473a;
        }

        @Override // p412k.InterfaceC10964b
        /* renamed from: f */
        public View mo3219f() {
            return CardView.this;
        }
    }

    static {
        C10963a c10963a = new C10963a();
        f2465i = c10963a;
        c10963a.mo66183m();
    }

    public CardView(Context context) {
        this(context, null);
    }

    /* renamed from: f */
    public void m3213f(int i10, int i11, int i12, int i13) {
        this.f2470e.set(i10, i11, i12, i13);
        f2465i.mo66180j(this.f2472g);
    }

    public ColorStateList getCardBackgroundColor() {
        return f2465i.mo66182l(this.f2472g);
    }

    public float getCardElevation() {
        return f2465i.mo66174d(this.f2472g);
    }

    public int getContentPaddingBottom() {
        return this.f2470e.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f2470e.left;
    }

    public int getContentPaddingRight() {
        return this.f2470e.right;
    }

    public int getContentPaddingTop() {
        return this.f2470e.top;
    }

    public float getMaxCardElevation() {
        return f2465i.mo66178h(this.f2472g);
    }

    public boolean getPreventCornerOverlap() {
        return this.f2467b;
    }

    public float getRadius() {
        return f2465i.mo66176f(this.f2472g);
    }

    public boolean getUseCompatPadding() {
        return this.f2466a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (f2465i instanceof C10963a) {
            super.onMeasure(i10, i11);
            return;
        }
        int mode = View.MeasureSpec.getMode(i10);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i10 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.mo66184n(this.f2472g)), View.MeasureSpec.getSize(i10)), mode);
        }
        int mode2 = View.MeasureSpec.getMode(i11);
        if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
            i11 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.mo66185o(this.f2472g)), View.MeasureSpec.getSize(i11)), mode2);
        }
        super.onMeasure(i10, i11);
    }

    public void setCardBackgroundColor(int i10) {
        f2465i.mo66177g(this.f2472g, ColorStateList.valueOf(i10));
    }

    public void setCardElevation(float f10) {
        f2465i.mo66173c(this.f2472g, f10);
    }

    public void setMaxCardElevation(float f10) {
        f2465i.mo66179i(this.f2472g, f10);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i10) {
        this.f2469d = i10;
        super.setMinimumHeight(i10);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i10) {
        this.f2468c = i10;
        super.setMinimumWidth(i10);
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
    }

    public void setPreventCornerOverlap(boolean z10) {
        if (z10 != this.f2467b) {
            this.f2467b = z10;
            f2465i.mo66171a(this.f2472g);
        }
    }

    public void setRadius(float f10) {
        f2465i.mo66181k(this.f2472g, f10);
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f2466a != z10) {
            this.f2466a = z10;
            f2465i.mo66175e(this.f2472g);
        }
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.cardViewStyle);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f2465i.mo66177g(this.f2472g, colorStateList);
    }

    public CardView(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        int color;
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i10);
        Rect rect = new Rect();
        this.f2470e = rect;
        this.f2471f = new Rect();
        C0552a c0552a = new C0552a();
        this.f2472g = c0552a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CardView, i10, R$style.CardView);
        int i11 = R$styleable.CardView_cardBackgroundColor;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(i11);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f2464h);
            int color2 = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(R$color.cardview_light_background);
            } else {
                color = getResources().getColor(R$color.cardview_dark_background);
            }
            colorStateListValueOf = ColorStateList.valueOf(color);
        }
        ColorStateList colorStateList = colorStateListValueOf;
        float dimension = typedArrayObtainStyledAttributes.getDimension(R$styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CardView_cardElevation, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(R$styleable.CardView_cardMaxElevation, 0.0f);
        this.f2466a = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CardView_cardUseCompatPadding, false);
        this.f2467b = typedArrayObtainStyledAttributes.getBoolean(R$styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPadding, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f10 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f2468c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_android_minWidth, 0);
        this.f2469d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_android_minHeight, 0);
        typedArrayObtainStyledAttributes.recycle();
        f2465i.mo66172b(c0552a, context, colorStateList, dimension, dimension2, f10);
    }
}
