package p442l3;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1781l;
import com.google.android.material.internal.C1784o;
import p276f3.C9649c;
import p276f3.C9650d;
import p356i3.C10425f;
import p356i3.C10426g;
import p356i3.C10427h;
import p356i3.C10429j;
import p666u2.C13110a;
import p723w.C13503b;
import p760x2.C13689a;

/* renamed from: l3.a */
/* loaded from: classes.dex */
public class C11228a extends C10427h implements C1781l.b {

    /* renamed from: Q */
    public static final int f52719Q = R$style.Widget_MaterialComponents_Tooltip;

    /* renamed from: R */
    public static final int f52720R = R$attr.tooltipStyle;

    /* renamed from: A */
    public final Context f52721A;

    /* renamed from: B */
    public final Paint.FontMetrics f52722B;

    /* renamed from: C */
    public final C1781l f52723C;

    /* renamed from: D */
    public final View.OnLayoutChangeListener f52724D;

    /* renamed from: E */
    public final Rect f52725E;

    /* renamed from: F */
    public int f52726F;

    /* renamed from: G */
    public int f52727G;

    /* renamed from: H */
    public int f52728H;

    /* renamed from: I */
    public int f52729I;

    /* renamed from: J */
    public int f52730J;

    /* renamed from: K */
    public int f52731K;

    /* renamed from: L */
    public float f52732L;

    /* renamed from: M */
    public float f52733M;

    /* renamed from: N */
    public final float f52734N;

    /* renamed from: O */
    public float f52735O;

    /* renamed from: P */
    public float f52736P;

    /* renamed from: z */
    public CharSequence f52737z;

    /* renamed from: l3.a$a */
    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            C11228a.this.m67429E0(view);
        }
    }

    public C11228a(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f52722B = new Paint.FontMetrics();
        C1781l c1781l = new C1781l(this);
        this.f52723C = c1781l;
        this.f52724D = new a();
        this.f52725E = new Rect();
        this.f52732L = 1.0f;
        this.f52733M = 1.0f;
        this.f52734N = 0.5f;
        this.f52735O = 0.5f;
        this.f52736P = 1.0f;
        this.f52721A = context;
        c1781l.m10756e().density = context.getResources().getDisplayMetrics().density;
        c1781l.m10756e().setTextAlign(Paint.Align.CENTER);
    }

    /* renamed from: s0 */
    private float m67422s0() {
        this.f52723C.m10756e().getFontMetrics(this.f52722B);
        Paint.FontMetrics fontMetrics = this.f52722B;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    /* renamed from: u0 */
    public static C11228a m67423u0(Context context, AttributeSet attributeSet, int i10, int i11) {
        C11228a c11228a = new C11228a(context, attributeSet, i10, i11);
        c11228a.m67424z0(attributeSet, i10, i11);
        return c11228a;
    }

    /* renamed from: z0 */
    private void m67424z0(AttributeSet attributeSet, int i10, int i11) {
        TypedArray typedArrayM10770h = C1784o.m10770h(this.f52721A, attributeSet, R$styleable.Tooltip, i10, i11, new int[0]);
        this.f52730J = this.f52721A.getResources().getDimensionPixelSize(R$dimen.mtrl_tooltip_arrowSize);
        setShapeAppearanceModel(m63980E().m64066v().m64098s(m67432v0()).m64093m());
        m67427C0(typedArrayM10770h.getText(R$styleable.Tooltip_android_text));
        C9650d c9650dM60271g = C9649c.m60271g(this.f52721A, typedArrayM10770h, R$styleable.Tooltip_android_textAppearance);
        if (c9650dM60271g != null) {
            int i12 = R$styleable.Tooltip_android_textColor;
            if (typedArrayM10770h.hasValue(i12)) {
                c9650dM60271g.m60285k(C9649c.m60265a(this.f52721A, typedArrayM10770h, i12));
            }
        }
        m67428D0(c9650dM60271g);
        m64002b0(ColorStateList.valueOf(typedArrayM10770h.getColor(R$styleable.Tooltip_backgroundTint, C13689a.m82293g(C13503b.m81226j(C13689a.m82289c(this.f52721A, R.attr.colorBackground, C11228a.class.getCanonicalName()), 229), C13503b.m81226j(C13689a.m82289c(this.f52721A, R$attr.colorOnBackground, C11228a.class.getCanonicalName()), 153)))));
        m64019l0(ColorStateList.valueOf(C13689a.m82289c(this.f52721A, R$attr.colorSurface, C11228a.class.getCanonicalName())));
        this.f52726F = typedArrayM10770h.getDimensionPixelSize(R$styleable.Tooltip_android_padding, 0);
        this.f52727G = typedArrayM10770h.getDimensionPixelSize(R$styleable.Tooltip_android_minWidth, 0);
        this.f52728H = typedArrayM10770h.getDimensionPixelSize(R$styleable.Tooltip_android_minHeight, 0);
        this.f52729I = typedArrayM10770h.getDimensionPixelSize(R$styleable.Tooltip_android_layout_margin, 0);
        typedArrayM10770h.recycle();
    }

    /* renamed from: A0 */
    public void m67425A0(View view) {
        if (view == null) {
            return;
        }
        m67429E0(view);
        view.addOnLayoutChangeListener(this.f52724D);
    }

    /* renamed from: B0 */
    public void m67426B0(float f10) {
        this.f52735O = 1.2f;
        this.f52732L = f10;
        this.f52733M = f10;
        this.f52736P = C13110a.m78885b(0.0f, 1.0f, 0.19f, 1.0f, f10);
        invalidateSelf();
    }

    /* renamed from: C0 */
    public void m67427C0(CharSequence charSequence) {
        if (TextUtils.equals(this.f52737z, charSequence)) {
            return;
        }
        this.f52737z = charSequence;
        this.f52723C.m10760i(true);
        invalidateSelf();
    }

    /* renamed from: D0 */
    public void m67428D0(C9650d c9650d) {
        this.f52723C.m10759h(c9650d, this.f52721A);
    }

    /* renamed from: E0 */
    public final void m67429E0(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.f52731K = iArr[0];
        view.getWindowVisibleDisplayFrame(this.f52725E);
    }

    @Override // com.google.android.material.internal.C1781l.b
    /* renamed from: a */
    public void mo9678a() {
        invalidateSelf();
    }

    @Override // p356i3.C10427h, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        float fM67430r0 = m67430r0();
        float f10 = (float) (-((this.f52730J * Math.sqrt(2.0d)) - this.f52730J));
        canvas.scale(this.f52732L, this.f52733M, getBounds().left + (getBounds().width() * 0.5f), getBounds().top + (getBounds().height() * this.f52735O));
        canvas.translate(fM67430r0, f10);
        super.draw(canvas);
        m67434x0(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.f52723C.m10756e().getTextSize(), this.f52728H);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) Math.max((this.f52726F * 2) + m67435y0(), this.f52727G);
    }

    @Override // p356i3.C10427h, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        setShapeAppearanceModel(m63980E().m64066v().m64098s(m67432v0()).m64093m());
    }

    @Override // p356i3.C10427h, android.graphics.drawable.Drawable, com.google.android.material.internal.C1781l.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    /* renamed from: r0 */
    public final float m67430r0() {
        int i10;
        if (((this.f52725E.right - getBounds().right) - this.f52731K) - this.f52729I < 0) {
            i10 = ((this.f52725E.right - getBounds().right) - this.f52731K) - this.f52729I;
        } else {
            if (((this.f52725E.left - getBounds().left) - this.f52731K) + this.f52729I <= 0) {
                return 0.0f;
            }
            i10 = ((this.f52725E.left - getBounds().left) - this.f52731K) + this.f52729I;
        }
        return i10;
    }

    /* renamed from: t0 */
    public final float m67431t0(Rect rect) {
        return rect.centerY() - m67422s0();
    }

    /* renamed from: v0 */
    public final C10425f m67432v0() {
        float f10 = -m67430r0();
        float fWidth = ((float) (getBounds().width() - (this.f52730J * Math.sqrt(2.0d)))) / 2.0f;
        return new C10429j(new C10426g(this.f52730J), Math.min(Math.max(f10, -fWidth), fWidth));
    }

    /* renamed from: w0 */
    public void m67433w0(View view) {
        if (view == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.f52724D);
    }

    /* renamed from: x0 */
    public final void m67434x0(Canvas canvas) {
        if (this.f52737z == null) {
            return;
        }
        int iM67431t0 = (int) m67431t0(getBounds());
        if (this.f52723C.m10755d() != null) {
            this.f52723C.m10756e().drawableState = getState();
            this.f52723C.m10761j(this.f52721A);
            this.f52723C.m10756e().setAlpha((int) (this.f52736P * 255.0f));
        }
        CharSequence charSequence = this.f52737z;
        canvas.drawText(charSequence, 0, charSequence.length(), r0.centerX(), iM67431t0, this.f52723C.m10756e());
    }

    /* renamed from: y0 */
    public final float m67435y0() {
        CharSequence charSequence = this.f52737z;
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f52723C.m10757f(charSequence.toString());
    }
}
