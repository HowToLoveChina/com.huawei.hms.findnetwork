package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.C1781l;
import com.google.android.material.internal.C1784o;
import com.google.android.material.internal.C1788s;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import p211d.C8968a;
import p212d0.C8969a;
import p276f3.C9649c;
import p276f3.C9650d;
import p307g3.C9876b;
import p356i3.C10427h;
import p666u2.C13117h;
import p697v2.C13328a;
import p723w.C13503b;
import p757x.C13669a;
import p760x2.C13689a;
import p830z2.C14088a;

/* renamed from: com.google.android.material.chip.a */
/* loaded from: classes.dex */
public class C1708a extends C10427h implements Drawable.Callback, C1781l.b {

    /* renamed from: J0 */
    public static final int[] f7785J0 = {R.attr.state_enabled};

    /* renamed from: K0 */
    public static final ShapeDrawable f7786K0 = new ShapeDrawable(new OvalShape());

    /* renamed from: A */
    public ColorStateList f7787A;

    /* renamed from: A0 */
    public PorterDuff.Mode f7788A0;

    /* renamed from: B */
    public float f7789B;

    /* renamed from: B0 */
    public int[] f7790B0;

    /* renamed from: C */
    public float f7791C;

    /* renamed from: C0 */
    public boolean f7792C0;

    /* renamed from: D */
    public ColorStateList f7793D;

    /* renamed from: D0 */
    public ColorStateList f7794D0;

    /* renamed from: E */
    public float f7795E;

    /* renamed from: E0 */
    public WeakReference<a> f7796E0;

    /* renamed from: F */
    public ColorStateList f7797F;

    /* renamed from: F0 */
    public TextUtils.TruncateAt f7798F0;

    /* renamed from: G */
    public CharSequence f7799G;

    /* renamed from: G0 */
    public boolean f7800G0;

    /* renamed from: H */
    public boolean f7801H;

    /* renamed from: H0 */
    public int f7802H0;

    /* renamed from: I */
    public Drawable f7803I;

    /* renamed from: I0 */
    public boolean f7804I0;

    /* renamed from: J */
    public ColorStateList f7805J;

    /* renamed from: K */
    public float f7806K;

    /* renamed from: L */
    public boolean f7807L;

    /* renamed from: M */
    public boolean f7808M;

    /* renamed from: N */
    public Drawable f7809N;

    /* renamed from: O */
    public Drawable f7810O;

    /* renamed from: P */
    public ColorStateList f7811P;

    /* renamed from: Q */
    public float f7812Q;

    /* renamed from: R */
    public CharSequence f7813R;

    /* renamed from: S */
    public boolean f7814S;

    /* renamed from: T */
    public boolean f7815T;

    /* renamed from: U */
    public Drawable f7816U;

    /* renamed from: V */
    public ColorStateList f7817V;

    /* renamed from: W */
    public C13117h f7818W;

    /* renamed from: X */
    public C13117h f7819X;

    /* renamed from: Y */
    public float f7820Y;

    /* renamed from: Z */
    public float f7821Z;

    /* renamed from: a0 */
    public float f7822a0;

    /* renamed from: b0 */
    public float f7823b0;

    /* renamed from: c0 */
    public float f7824c0;

    /* renamed from: d0 */
    public float f7825d0;

    /* renamed from: e0 */
    public float f7826e0;

    /* renamed from: f0 */
    public float f7827f0;

    /* renamed from: g0 */
    public final Context f7828g0;

    /* renamed from: h0 */
    public final Paint f7829h0;

    /* renamed from: i0 */
    public final Paint f7830i0;

    /* renamed from: j0 */
    public final Paint.FontMetrics f7831j0;

    /* renamed from: k0 */
    public final RectF f7832k0;

    /* renamed from: l0 */
    public final PointF f7833l0;

    /* renamed from: m0 */
    public final Path f7834m0;

    /* renamed from: n0 */
    public final C1781l f7835n0;

    /* renamed from: o0 */
    public int f7836o0;

    /* renamed from: p0 */
    public int f7837p0;

    /* renamed from: q0 */
    public int f7838q0;

    /* renamed from: r0 */
    public int f7839r0;

    /* renamed from: s0 */
    public int f7840s0;

    /* renamed from: t0 */
    public int f7841t0;

    /* renamed from: u0 */
    public boolean f7842u0;

    /* renamed from: v0 */
    public int f7843v0;

    /* renamed from: w0 */
    public int f7844w0;

    /* renamed from: x0 */
    public ColorFilter f7845x0;

    /* renamed from: y0 */
    public PorterDuffColorFilter f7846y0;

    /* renamed from: z */
    public ColorStateList f7847z;

    /* renamed from: z0 */
    public ColorStateList f7848z0;

    /* renamed from: com.google.android.material.chip.a$a */
    public interface a {
        /* renamed from: a */
        void mo10003a();
    }

    public C1708a(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f7791C = -1.0f;
        this.f7829h0 = new Paint(1);
        this.f7831j0 = new Paint.FontMetrics();
        this.f7832k0 = new RectF();
        this.f7833l0 = new PointF();
        this.f7834m0 = new Path();
        this.f7844w0 = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
        this.f7788A0 = PorterDuff.Mode.SRC_IN;
        this.f7796E0 = new WeakReference<>(null);
        m63992Q(context);
        this.f7828g0 = context;
        C1781l c1781l = new C1781l(this);
        this.f7835n0 = c1781l;
        this.f7799G = "";
        c1781l.m10756e().density = context.getResources().getDisplayMetrics().density;
        this.f7830i0 = null;
        int[] iArr = f7785J0;
        setState(iArr);
        m10153r2(iArr);
        this.f7800G0 = true;
        if (C9876b.f48499a) {
            f7786K0.setTint(-1);
        }
    }

    /* renamed from: B0 */
    public static C1708a m10036B0(Context context, AttributeSet attributeSet, int i10, int i11) {
        C1708a c1708a = new C1708a(context, attributeSet, i10, i11);
        c1708a.m10042A1(attributeSet, i10, i11);
        return c1708a;
    }

    /* renamed from: t1 */
    public static boolean m10037t1(int[] iArr, int i10) {
        if (iArr == null) {
            return false;
        }
        for (int i11 : iArr) {
            if (i11 == i10) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: x1 */
    public static boolean m10038x1(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    /* renamed from: y1 */
    public static boolean m10039y1(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    /* renamed from: z1 */
    public static boolean m10040z1(C9650d c9650d) {
        return (c9650d == null || c9650d.m60283i() == null || !c9650d.m60283i().isStateful()) ? false : true;
    }

    /* renamed from: A0 */
    public final boolean m10041A0() {
        return this.f7815T && this.f7816U != null && this.f7814S;
    }

    /* renamed from: A1 */
    public final void m10042A1(AttributeSet attributeSet, int i10, int i11) {
        TypedArray typedArrayM10770h = C1784o.m10770h(this.f7828g0, attributeSet, R$styleable.Chip, i10, i11, new int[0]);
        this.f7804I0 = typedArrayM10770h.hasValue(R$styleable.Chip_shapeAppearance);
        m10131h2(C9649c.m60265a(this.f7828g0, typedArrayM10770h, R$styleable.Chip_chipSurfaceColor));
        m10074L1(C9649c.m60265a(this.f7828g0, typedArrayM10770h, R$styleable.Chip_chipBackgroundColor));
        m10115Z1(typedArrayM10770h.getDimension(R$styleable.Chip_chipMinHeight, 0.0f));
        int i12 = R$styleable.Chip_chipCornerRadius;
        if (typedArrayM10770h.hasValue(i12)) {
            m10080N1(typedArrayM10770h.getDimension(i12, 0.0f));
        }
        m10123d2(C9649c.m60265a(this.f7828g0, typedArrayM10770h, R$styleable.Chip_chipStrokeColor));
        m10127f2(typedArrayM10770h.getDimension(R$styleable.Chip_chipStrokeWidth, 0.0f));
        m10054E2(C9649c.m60265a(this.f7828g0, typedArrayM10770h, R$styleable.Chip_rippleColor));
        m10069J2(typedArrayM10770h.getText(R$styleable.Chip_android_text));
        C9650d c9650dM60271g = C9649c.m60271g(this.f7828g0, typedArrayM10770h, R$styleable.Chip_android_textAppearance);
        c9650dM60271g.m60286l(typedArrayM10770h.getDimension(R$styleable.Chip_android_textSize, c9650dM60271g.m60284j()));
        m10072K2(c9650dM60271g);
        int i13 = typedArrayM10770h.getInt(R$styleable.Chip_android_ellipsize, 0);
        if (i13 == 1) {
            m10167w2(TextUtils.TruncateAt.START);
        } else if (i13 == 2) {
            m10167w2(TextUtils.TruncateAt.MIDDLE);
        } else if (i13 == 3) {
            m10167w2(TextUtils.TruncateAt.END);
        }
        m10113Y1(typedArrayM10770h.getBoolean(R$styleable.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            m10113Y1(typedArrayM10770h.getBoolean(R$styleable.Chip_chipIconEnabled, false));
        }
        m10092R1(C9649c.m60269e(this.f7828g0, typedArrayM10770h, R$styleable.Chip_chipIcon));
        int i14 = R$styleable.Chip_chipIconTint;
        if (typedArrayM10770h.hasValue(i14)) {
            m10104V1(C9649c.m60265a(this.f7828g0, typedArrayM10770h, i14));
        }
        m10098T1(typedArrayM10770h.getDimension(R$styleable.Chip_chipIconSize, -1.0f));
        m10161u2(typedArrayM10770h.getBoolean(R$styleable.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            m10161u2(typedArrayM10770h.getBoolean(R$styleable.Chip_closeIconEnabled, false));
        }
        m10133i2(C9649c.m60269e(this.f7828g0, typedArrayM10770h, R$styleable.Chip_closeIcon));
        m10156s2(C9649c.m60265a(this.f7828g0, typedArrayM10770h, R$styleable.Chip_closeIconTint));
        m10143n2(typedArrayM10770h.getDimension(R$styleable.Chip_closeIconSize, 0.0f));
        m10050D1(typedArrayM10770h.getBoolean(R$styleable.Chip_android_checkable, false));
        m10071K1(typedArrayM10770h.getBoolean(R$styleable.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            m10071K1(typedArrayM10770h.getBoolean(R$styleable.Chip_checkedIconEnabled, false));
        }
        m10056F1(C9649c.m60269e(this.f7828g0, typedArrayM10770h, R$styleable.Chip_checkedIcon));
        int i15 = R$styleable.Chip_checkedIconTint;
        if (typedArrayM10770h.hasValue(i15)) {
            m10062H1(C9649c.m60265a(this.f7828g0, typedArrayM10770h, i15));
        }
        m10063H2(C13117h.m78897c(this.f7828g0, typedArrayM10770h, R$styleable.Chip_showMotionSpec));
        m10169x2(C13117h.m78897c(this.f7828g0, typedArrayM10770h, R$styleable.Chip_hideMotionSpec));
        m10119b2(typedArrayM10770h.getDimension(R$styleable.Chip_chipStartPadding, 0.0f));
        m10045B2(typedArrayM10770h.getDimension(R$styleable.Chip_iconStartPadding, 0.0f));
        m10173z2(typedArrayM10770h.getDimension(R$styleable.Chip_iconEndPadding, 0.0f));
        m10084O2(typedArrayM10770h.getDimension(R$styleable.Chip_textStartPadding, 0.0f));
        m10078M2(typedArrayM10770h.getDimension(R$styleable.Chip_textEndPadding, 0.0f));
        m10147p2(typedArrayM10770h.getDimension(R$styleable.Chip_closeIconStartPadding, 0.0f));
        m10137k2(typedArrayM10770h.getDimension(R$styleable.Chip_closeIconEndPadding, 0.0f));
        m10086P1(typedArrayM10770h.getDimension(R$styleable.Chip_chipEndPadding, 0.0f));
        m10051D2(typedArrayM10770h.getDimensionPixelSize(R$styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        typedArrayM10770h.recycle();
    }

    /* renamed from: A2 */
    public void m10043A2(int i10) {
        m10173z2(this.f7828g0.getResources().getDimension(i10));
    }

    /* renamed from: B1 */
    public void m10044B1() {
        a aVar = this.f7796E0.get();
        if (aVar != null) {
            aVar.mo10003a();
        }
    }

    /* renamed from: B2 */
    public void m10045B2(float f10) {
        if (this.f7821Z != f10) {
            float fM10154s0 = m10154s0();
            this.f7821Z = f10;
            float fM10154s02 = m10154s0();
            invalidateSelf();
            if (fM10154s0 != fM10154s02) {
                m10044B1();
            }
        }
    }

    /* renamed from: C0 */
    public final void m10046C0(Canvas canvas, Rect rect) {
        if (m10096S2()) {
            m10151r0(rect, this.f7832k0);
            RectF rectF = this.f7832k0;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.f7816U.setBounds(0, 0, (int) this.f7832k0.width(), (int) this.f7832k0.height());
            this.f7816U.draw(canvas);
            canvas.translate(-f10, -f11);
        }
    }

    /* renamed from: C1 */
    public final boolean m10047C1(int[] iArr, int[] iArr2) {
        boolean z10;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.f7847z;
        int iM64018l = m64018l(colorStateList != null ? colorStateList.getColorForState(iArr, this.f7836o0) : 0);
        boolean state = true;
        if (this.f7836o0 != iM64018l) {
            this.f7836o0 = iM64018l;
            zOnStateChange = true;
        }
        ColorStateList colorStateList2 = this.f7787A;
        int iM64018l2 = m64018l(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.f7837p0) : 0);
        if (this.f7837p0 != iM64018l2) {
            this.f7837p0 = iM64018l2;
            zOnStateChange = true;
        }
        int iM82293g = C13689a.m82293g(iM64018l, iM64018l2);
        if ((this.f7838q0 != iM82293g) | (m64033x() == null)) {
            this.f7838q0 = iM82293g;
            m64002b0(ColorStateList.valueOf(iM82293g));
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.f7793D;
        int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.f7839r0) : 0;
        if (this.f7839r0 != colorForState) {
            this.f7839r0 = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.f7794D0 == null || !C9876b.m61326e(iArr)) ? 0 : this.f7794D0.getColorForState(iArr, this.f7840s0);
        if (this.f7840s0 != colorForState2) {
            this.f7840s0 = colorForState2;
            if (this.f7792C0) {
                zOnStateChange = true;
            }
        }
        int colorForState3 = (this.f7835n0.m10755d() == null || this.f7835n0.m10755d().m60283i() == null) ? 0 : this.f7835n0.m10755d().m60283i().getColorForState(iArr, this.f7841t0);
        if (this.f7841t0 != colorForState3) {
            this.f7841t0 = colorForState3;
            zOnStateChange = true;
        }
        boolean z11 = m10037t1(getState(), R.attr.state_checked) && this.f7814S;
        if (this.f7842u0 == z11 || this.f7816U == null) {
            z10 = false;
        } else {
            float fM10154s0 = m10154s0();
            this.f7842u0 = z11;
            if (fM10154s0 != m10154s0()) {
                zOnStateChange = true;
                z10 = true;
            } else {
                z10 = false;
                zOnStateChange = true;
            }
        }
        ColorStateList colorStateList4 = this.f7848z0;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.f7843v0) : 0;
        if (this.f7843v0 != colorForState4) {
            this.f7843v0 = colorForState4;
            this.f7846y0 = C14088a.m84432c(this, this.f7848z0, this.f7788A0);
        } else {
            state = zOnStateChange;
        }
        if (m10039y1(this.f7803I)) {
            state |= this.f7803I.setState(iArr);
        }
        if (m10039y1(this.f7816U)) {
            state |= this.f7816U.setState(iArr);
        }
        if (m10039y1(this.f7809N)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.f7809N.setState(iArr3);
        }
        if (C9876b.f48499a && m10039y1(this.f7810O)) {
            state |= this.f7810O.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z10) {
            m10044B1();
        }
        return state;
    }

    /* renamed from: C2 */
    public void m10048C2(int i10) {
        m10045B2(this.f7828g0.getResources().getDimension(i10));
    }

    /* renamed from: D0 */
    public final void m10049D0(Canvas canvas, Rect rect) {
        if (this.f7804I0) {
            return;
        }
        this.f7829h0.setColor(this.f7837p0);
        this.f7829h0.setStyle(Paint.Style.FILL);
        this.f7829h0.setColorFilter(m10152r1());
        this.f7832k0.set(rect);
        canvas.drawRoundRect(this.f7832k0, m10082O0(), m10082O0(), this.f7829h0);
    }

    /* renamed from: D1 */
    public void m10050D1(boolean z10) {
        if (this.f7814S != z10) {
            this.f7814S = z10;
            float fM10154s0 = m10154s0();
            if (!z10 && this.f7842u0) {
                this.f7842u0 = false;
            }
            float fM10154s02 = m10154s0();
            invalidateSelf();
            if (fM10154s0 != fM10154s02) {
                m10044B1();
            }
        }
    }

    /* renamed from: D2 */
    public void m10051D2(int i10) {
        this.f7802H0 = i10;
    }

    /* renamed from: E0 */
    public final void m10052E0(Canvas canvas, Rect rect) {
        if (m10099T2()) {
            m10151r0(rect, this.f7832k0);
            RectF rectF = this.f7832k0;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.f7803I.setBounds(0, 0, (int) this.f7832k0.width(), (int) this.f7832k0.height());
            this.f7803I.draw(canvas);
            canvas.translate(-f10, -f11);
        }
    }

    /* renamed from: E1 */
    public void m10053E1(int i10) {
        m10050D1(this.f7828g0.getResources().getBoolean(i10));
    }

    /* renamed from: E2 */
    public void m10054E2(ColorStateList colorStateList) {
        if (this.f7797F != colorStateList) {
            this.f7797F = colorStateList;
            m10108W2();
            onStateChange(getState());
        }
    }

    /* renamed from: F0 */
    public final void m10055F0(Canvas canvas, Rect rect) {
        if (this.f7795E <= 0.0f || this.f7804I0) {
            return;
        }
        this.f7829h0.setColor(this.f7839r0);
        this.f7829h0.setStyle(Paint.Style.STROKE);
        if (!this.f7804I0) {
            this.f7829h0.setColorFilter(m10152r1());
        }
        RectF rectF = this.f7832k0;
        float f10 = rect.left;
        float f11 = this.f7795E;
        rectF.set(f10 + (f11 / 2.0f), rect.top + (f11 / 2.0f), rect.right - (f11 / 2.0f), rect.bottom - (f11 / 2.0f));
        float f12 = this.f7791C - (this.f7795E / 2.0f);
        canvas.drawRoundRect(this.f7832k0, f12, f12, this.f7829h0);
    }

    /* renamed from: F1 */
    public void m10056F1(Drawable drawable) {
        if (this.f7816U != drawable) {
            float fM10154s0 = m10154s0();
            this.f7816U = drawable;
            float fM10154s02 = m10154s0();
            m10105V2(this.f7816U);
            m10148q0(this.f7816U);
            invalidateSelf();
            if (fM10154s0 != fM10154s02) {
                m10044B1();
            }
        }
    }

    /* renamed from: F2 */
    public void m10057F2(int i10) {
        m10054E2(C8968a.m56742a(this.f7828g0, i10));
    }

    /* renamed from: G0 */
    public final void m10058G0(Canvas canvas, Rect rect) {
        if (this.f7804I0) {
            return;
        }
        this.f7829h0.setColor(this.f7836o0);
        this.f7829h0.setStyle(Paint.Style.FILL);
        this.f7832k0.set(rect);
        canvas.drawRoundRect(this.f7832k0, m10082O0(), m10082O0(), this.f7829h0);
    }

    /* renamed from: G1 */
    public void m10059G1(int i10) {
        m10056F1(C8968a.m56743b(this.f7828g0, i10));
    }

    /* renamed from: G2 */
    public void m10060G2(boolean z10) {
        this.f7800G0 = z10;
    }

    /* renamed from: H0 */
    public final void m10061H0(Canvas canvas, Rect rect) {
        if (m10102U2()) {
            m10159u0(rect, this.f7832k0);
            RectF rectF = this.f7832k0;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.f7809N.setBounds(0, 0, (int) this.f7832k0.width(), (int) this.f7832k0.height());
            if (C9876b.f48499a) {
                this.f7810O.setBounds(this.f7809N.getBounds());
                this.f7810O.jumpToCurrentState();
                this.f7810O.draw(canvas);
            } else {
                this.f7809N.draw(canvas);
            }
            canvas.translate(-f10, -f11);
        }
    }

    /* renamed from: H1 */
    public void m10062H1(ColorStateList colorStateList) {
        if (this.f7817V != colorStateList) {
            this.f7817V = colorStateList;
            if (m10041A0()) {
                C13669a.m82228i(this.f7816U, colorStateList);
            }
            onStateChange(getState());
        }
    }

    /* renamed from: H2 */
    public void m10063H2(C13117h c13117h) {
        this.f7818W = c13117h;
    }

    /* renamed from: I0 */
    public final void m10064I0(Canvas canvas, Rect rect) {
        this.f7829h0.setColor(this.f7840s0);
        this.f7829h0.setStyle(Paint.Style.FILL);
        this.f7832k0.set(rect);
        if (!this.f7804I0) {
            canvas.drawRoundRect(this.f7832k0, m10082O0(), m10082O0(), this.f7829h0);
        } else {
            m64010h(new RectF(rect), this.f7834m0);
            super.m64025p(canvas, this.f7829h0, this.f7834m0, m64030u());
        }
    }

    /* renamed from: I1 */
    public void m10065I1(int i10) {
        m10062H1(C8968a.m56742a(this.f7828g0, i10));
    }

    /* renamed from: I2 */
    public void m10066I2(int i10) {
        m10063H2(C13117h.m78898d(this.f7828g0, i10));
    }

    /* renamed from: J0 */
    public final void m10067J0(Canvas canvas, Rect rect) {
        Paint paint = this.f7830i0;
        if (paint != null) {
            paint.setColor(C13503b.m81226j(-16777216, 127));
            canvas.drawRect(rect, this.f7830i0);
            if (m10099T2() || m10096S2()) {
                m10151r0(rect, this.f7832k0);
                canvas.drawRect(this.f7832k0, this.f7830i0);
            }
            if (this.f7799G != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.f7830i0);
            }
            if (m10102U2()) {
                m10159u0(rect, this.f7832k0);
                canvas.drawRect(this.f7832k0, this.f7830i0);
            }
            this.f7830i0.setColor(C13503b.m81226j(-65536, 127));
            m10157t0(rect, this.f7832k0);
            canvas.drawRect(this.f7832k0, this.f7830i0);
            this.f7830i0.setColor(C13503b.m81226j(-16711936, 127));
            m10162v0(rect, this.f7832k0);
            canvas.drawRect(this.f7832k0, this.f7830i0);
        }
    }

    /* renamed from: J1 */
    public void m10068J1(int i10) {
        m10071K1(this.f7828g0.getResources().getBoolean(i10));
    }

    /* renamed from: J2 */
    public void m10069J2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.f7799G, charSequence)) {
            return;
        }
        this.f7799G = charSequence;
        this.f7835n0.m10760i(true);
        invalidateSelf();
        m10044B1();
    }

    /* renamed from: K0 */
    public final void m10070K0(Canvas canvas, Rect rect) {
        if (this.f7799G != null) {
            Paint.Align alignM10172z0 = m10172z0(rect, this.f7833l0);
            m10168x0(rect, this.f7832k0);
            if (this.f7835n0.m10755d() != null) {
                this.f7835n0.m10756e().drawableState = getState();
                this.f7835n0.m10761j(this.f7828g0);
            }
            this.f7835n0.m10756e().setTextAlign(alignM10172z0);
            int iSave = 0;
            boolean z10 = Math.round(this.f7835n0.m10757f(m10142n1().toString())) > Math.round(this.f7832k0.width());
            if (z10) {
                iSave = canvas.save();
                canvas.clipRect(this.f7832k0);
            }
            CharSequence charSequenceEllipsize = this.f7799G;
            if (z10 && this.f7798F0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f7835n0.m10756e(), this.f7832k0.width(), this.f7798F0);
            }
            CharSequence charSequence = charSequenceEllipsize;
            int length = charSequence.length();
            PointF pointF = this.f7833l0;
            canvas.drawText(charSequence, 0, length, pointF.x, pointF.y, this.f7835n0.m10756e());
            if (z10) {
                canvas.restoreToCount(iSave);
            }
        }
    }

    /* renamed from: K1 */
    public void m10071K1(boolean z10) {
        if (this.f7815T != z10) {
            boolean zM10096S2 = m10096S2();
            this.f7815T = z10;
            boolean zM10096S22 = m10096S2();
            if (zM10096S2 != zM10096S22) {
                if (zM10096S22) {
                    m10148q0(this.f7816U);
                } else {
                    m10105V2(this.f7816U);
                }
                invalidateSelf();
                m10044B1();
            }
        }
    }

    /* renamed from: K2 */
    public void m10072K2(C9650d c9650d) {
        this.f7835n0.m10759h(c9650d, this.f7828g0);
    }

    /* renamed from: L0 */
    public Drawable m10073L0() {
        return this.f7816U;
    }

    /* renamed from: L1 */
    public void m10074L1(ColorStateList colorStateList) {
        if (this.f7787A != colorStateList) {
            this.f7787A = colorStateList;
            onStateChange(getState());
        }
    }

    /* renamed from: L2 */
    public void m10075L2(int i10) {
        m10072K2(new C9650d(this.f7828g0, i10));
    }

    /* renamed from: M0 */
    public ColorStateList m10076M0() {
        return this.f7817V;
    }

    /* renamed from: M1 */
    public void m10077M1(int i10) {
        m10074L1(C8968a.m56742a(this.f7828g0, i10));
    }

    /* renamed from: M2 */
    public void m10078M2(float f10) {
        if (this.f7824c0 != f10) {
            this.f7824c0 = f10;
            invalidateSelf();
            m10044B1();
        }
    }

    /* renamed from: N0 */
    public ColorStateList m10079N0() {
        return this.f7787A;
    }

    @Deprecated
    /* renamed from: N1 */
    public void m10080N1(float f10) {
        if (this.f7791C != f10) {
            this.f7791C = f10;
            setShapeAppearanceModel(m63980E().m64067w(f10));
        }
    }

    /* renamed from: N2 */
    public void m10081N2(int i10) {
        m10078M2(this.f7828g0.getResources().getDimension(i10));
    }

    /* renamed from: O0 */
    public float m10082O0() {
        return this.f7804I0 ? m63985J() : this.f7791C;
    }

    @Deprecated
    /* renamed from: O1 */
    public void m10083O1(int i10) {
        m10080N1(this.f7828g0.getResources().getDimension(i10));
    }

    /* renamed from: O2 */
    public void m10084O2(float f10) {
        if (this.f7823b0 != f10) {
            this.f7823b0 = f10;
            invalidateSelf();
            m10044B1();
        }
    }

    /* renamed from: P0 */
    public float m10085P0() {
        return this.f7827f0;
    }

    /* renamed from: P1 */
    public void m10086P1(float f10) {
        if (this.f7827f0 != f10) {
            this.f7827f0 = f10;
            invalidateSelf();
            m10044B1();
        }
    }

    /* renamed from: P2 */
    public void m10087P2(int i10) {
        m10084O2(this.f7828g0.getResources().getDimension(i10));
    }

    /* renamed from: Q0 */
    public Drawable m10088Q0() {
        Drawable drawable = this.f7803I;
        if (drawable != null) {
            return C13669a.m82230k(drawable);
        }
        return null;
    }

    /* renamed from: Q1 */
    public void m10089Q1(int i10) {
        m10086P1(this.f7828g0.getResources().getDimension(i10));
    }

    /* renamed from: Q2 */
    public void m10090Q2(boolean z10) {
        if (this.f7792C0 != z10) {
            this.f7792C0 = z10;
            m10108W2();
            onStateChange(getState());
        }
    }

    /* renamed from: R0 */
    public float m10091R0() {
        return this.f7806K;
    }

    /* renamed from: R1 */
    public void m10092R1(Drawable drawable) {
        Drawable drawableM10088Q0 = m10088Q0();
        if (drawableM10088Q0 != drawable) {
            float fM10154s0 = m10154s0();
            this.f7803I = drawable != null ? C13669a.m82231l(drawable).mutate() : null;
            float fM10154s02 = m10154s0();
            m10105V2(drawableM10088Q0);
            if (m10099T2()) {
                m10148q0(this.f7803I);
            }
            invalidateSelf();
            if (fM10154s0 != fM10154s02) {
                m10044B1();
            }
        }
    }

    /* renamed from: R2 */
    public boolean m10093R2() {
        return this.f7800G0;
    }

    /* renamed from: S0 */
    public ColorStateList m10094S0() {
        return this.f7805J;
    }

    /* renamed from: S1 */
    public void m10095S1(int i10) {
        m10092R1(C8968a.m56743b(this.f7828g0, i10));
    }

    /* renamed from: S2 */
    public final boolean m10096S2() {
        return this.f7815T && this.f7816U != null && this.f7842u0;
    }

    /* renamed from: T0 */
    public float m10097T0() {
        return this.f7789B;
    }

    /* renamed from: T1 */
    public void m10098T1(float f10) {
        if (this.f7806K != f10) {
            float fM10154s0 = m10154s0();
            this.f7806K = f10;
            float fM10154s02 = m10154s0();
            invalidateSelf();
            if (fM10154s0 != fM10154s02) {
                m10044B1();
            }
        }
    }

    /* renamed from: T2 */
    public final boolean m10099T2() {
        return this.f7801H && this.f7803I != null;
    }

    /* renamed from: U0 */
    public float m10100U0() {
        return this.f7820Y;
    }

    /* renamed from: U1 */
    public void m10101U1(int i10) {
        m10098T1(this.f7828g0.getResources().getDimension(i10));
    }

    /* renamed from: U2 */
    public final boolean m10102U2() {
        return this.f7808M && this.f7809N != null;
    }

    /* renamed from: V0 */
    public ColorStateList m10103V0() {
        return this.f7793D;
    }

    /* renamed from: V1 */
    public void m10104V1(ColorStateList colorStateList) {
        this.f7807L = true;
        if (this.f7805J != colorStateList) {
            this.f7805J = colorStateList;
            if (m10099T2()) {
                C13669a.m82228i(this.f7803I, colorStateList);
            }
            onStateChange(getState());
        }
    }

    /* renamed from: V2 */
    public final void m10105V2(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    /* renamed from: W0 */
    public float m10106W0() {
        return this.f7795E;
    }

    /* renamed from: W1 */
    public void m10107W1(int i10) {
        m10104V1(C8968a.m56742a(this.f7828g0, i10));
    }

    /* renamed from: W2 */
    public final void m10108W2() {
        this.f7794D0 = this.f7792C0 ? C9876b.m61325d(this.f7797F) : null;
    }

    /* renamed from: X0 */
    public Drawable m10109X0() {
        Drawable drawable = this.f7809N;
        if (drawable != null) {
            return C13669a.m82230k(drawable);
        }
        return null;
    }

    /* renamed from: X1 */
    public void m10110X1(int i10) {
        m10113Y1(this.f7828g0.getResources().getBoolean(i10));
    }

    @TargetApi(21)
    /* renamed from: X2 */
    public final void m10111X2() {
        this.f7810O = new RippleDrawable(C9876b.m61325d(m10138l1()), this.f7809N, f7786K0);
    }

    /* renamed from: Y0 */
    public CharSequence m10112Y0() {
        return this.f7813R;
    }

    /* renamed from: Y1 */
    public void m10113Y1(boolean z10) {
        if (this.f7801H != z10) {
            boolean zM10099T2 = m10099T2();
            this.f7801H = z10;
            boolean zM10099T22 = m10099T2();
            if (zM10099T2 != zM10099T22) {
                if (zM10099T22) {
                    m10148q0(this.f7803I);
                } else {
                    m10105V2(this.f7803I);
                }
                invalidateSelf();
                m10044B1();
            }
        }
    }

    /* renamed from: Z0 */
    public float m10114Z0() {
        return this.f7826e0;
    }

    /* renamed from: Z1 */
    public void m10115Z1(float f10) {
        if (this.f7789B != f10) {
            this.f7789B = f10;
            invalidateSelf();
            m10044B1();
        }
    }

    @Override // com.google.android.material.internal.C1781l.b
    /* renamed from: a */
    public void mo9678a() {
        m10044B1();
        invalidateSelf();
    }

    /* renamed from: a1 */
    public float m10116a1() {
        return this.f7812Q;
    }

    /* renamed from: a2 */
    public void m10117a2(int i10) {
        m10115Z1(this.f7828g0.getResources().getDimension(i10));
    }

    /* renamed from: b1 */
    public float m10118b1() {
        return this.f7825d0;
    }

    /* renamed from: b2 */
    public void m10119b2(float f10) {
        if (this.f7820Y != f10) {
            this.f7820Y = f10;
            invalidateSelf();
            m10044B1();
        }
    }

    /* renamed from: c1 */
    public int[] m10120c1() {
        return this.f7790B0;
    }

    /* renamed from: c2 */
    public void m10121c2(int i10) {
        m10119b2(this.f7828g0.getResources().getDimension(i10));
    }

    /* renamed from: d1 */
    public ColorStateList m10122d1() {
        return this.f7811P;
    }

    /* renamed from: d2 */
    public void m10123d2(ColorStateList colorStateList) {
        if (this.f7793D != colorStateList) {
            this.f7793D = colorStateList;
            if (this.f7804I0) {
                m64019l0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // p356i3.C10427h, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i10 = this.f7844w0;
        int iM79931a = i10 < 255 ? C13328a.m79931a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i10) : 0;
        m10058G0(canvas, bounds);
        m10049D0(canvas, bounds);
        if (this.f7804I0) {
            super.draw(canvas);
        }
        m10055F0(canvas, bounds);
        m10064I0(canvas, bounds);
        m10052E0(canvas, bounds);
        m10046C0(canvas, bounds);
        if (this.f7800G0) {
            m10070K0(canvas, bounds);
        }
        m10061H0(canvas, bounds);
        m10067J0(canvas, bounds);
        if (this.f7844w0 < 255) {
            canvas.restoreToCount(iM79931a);
        }
    }

    /* renamed from: e1 */
    public void m10124e1(RectF rectF) {
        m10162v0(getBounds(), rectF);
    }

    /* renamed from: e2 */
    public void m10125e2(int i10) {
        m10123d2(C8968a.m56742a(this.f7828g0, i10));
    }

    /* renamed from: f1 */
    public final float m10126f1() {
        Drawable drawable = this.f7842u0 ? this.f7816U : this.f7803I;
        float f10 = this.f7806K;
        if (f10 > 0.0f || drawable == null) {
            return f10;
        }
        float fCeil = (float) Math.ceil(C1788s.m10782c(this.f7828g0, 24));
        return ((float) drawable.getIntrinsicHeight()) <= fCeil ? drawable.getIntrinsicHeight() : fCeil;
    }

    /* renamed from: f2 */
    public void m10127f2(float f10) {
        if (this.f7795E != f10) {
            this.f7795E = f10;
            this.f7829h0.setStrokeWidth(f10);
            if (this.f7804I0) {
                super.m64020m0(f10);
            }
            invalidateSelf();
        }
    }

    /* renamed from: g1 */
    public final float m10128g1() {
        Drawable drawable = this.f7842u0 ? this.f7816U : this.f7803I;
        float f10 = this.f7806K;
        return (f10 > 0.0f || drawable == null) ? f10 : drawable.getIntrinsicWidth();
    }

    /* renamed from: g2 */
    public void m10129g2(int i10) {
        m10127f2(this.f7828g0.getResources().getDimension(i10));
    }

    @Override // p356i3.C10427h, android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f7844w0;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f7845x0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f7789B;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.f7820Y + m10154s0() + this.f7823b0 + this.f7835n0.m10757f(m10142n1().toString()) + this.f7824c0 + m10165w0() + this.f7827f0), this.f7802H0);
    }

    @Override // p356i3.C10427h, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // p356i3.C10427h, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.f7804I0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.f7791C);
        } else {
            outline.setRoundRect(bounds, this.f7791C);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    /* renamed from: h1 */
    public TextUtils.TruncateAt m10130h1() {
        return this.f7798F0;
    }

    /* renamed from: h2 */
    public final void m10131h2(ColorStateList colorStateList) {
        if (this.f7847z != colorStateList) {
            this.f7847z = colorStateList;
            onStateChange(getState());
        }
    }

    /* renamed from: i1 */
    public C13117h m10132i1() {
        return this.f7819X;
    }

    /* renamed from: i2 */
    public void m10133i2(Drawable drawable) {
        Drawable drawableM10109X0 = m10109X0();
        if (drawableM10109X0 != drawable) {
            float fM10165w0 = m10165w0();
            this.f7809N = drawable != null ? C13669a.m82231l(drawable).mutate() : null;
            if (C9876b.f48499a) {
                m10111X2();
            }
            float fM10165w02 = m10165w0();
            m10105V2(drawableM10109X0);
            if (m10102U2()) {
                m10148q0(this.f7809N);
            }
            invalidateSelf();
            if (fM10165w0 != fM10165w02) {
                m10044B1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // p356i3.C10427h, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return m10038x1(this.f7847z) || m10038x1(this.f7787A) || m10038x1(this.f7793D) || (this.f7792C0 && m10038x1(this.f7794D0)) || m10040z1(this.f7835n0.m10755d()) || m10041A0() || m10039y1(this.f7803I) || m10039y1(this.f7816U) || m10038x1(this.f7848z0);
    }

    /* renamed from: j1 */
    public float m10134j1() {
        return this.f7822a0;
    }

    /* renamed from: j2 */
    public void m10135j2(CharSequence charSequence) {
        if (this.f7813R != charSequence) {
            this.f7813R = C8969a.m56746c().m56751h(charSequence);
            invalidateSelf();
        }
    }

    /* renamed from: k1 */
    public float m10136k1() {
        return this.f7821Z;
    }

    /* renamed from: k2 */
    public void m10137k2(float f10) {
        if (this.f7826e0 != f10) {
            this.f7826e0 = f10;
            invalidateSelf();
            if (m10102U2()) {
                m10044B1();
            }
        }
    }

    /* renamed from: l1 */
    public ColorStateList m10138l1() {
        return this.f7797F;
    }

    /* renamed from: l2 */
    public void m10139l2(int i10) {
        m10137k2(this.f7828g0.getResources().getDimension(i10));
    }

    /* renamed from: m1 */
    public C13117h m10140m1() {
        return this.f7818W;
    }

    /* renamed from: m2 */
    public void m10141m2(int i10) {
        m10133i2(C8968a.m56743b(this.f7828g0, i10));
    }

    /* renamed from: n1 */
    public CharSequence m10142n1() {
        return this.f7799G;
    }

    /* renamed from: n2 */
    public void m10143n2(float f10) {
        if (this.f7812Q != f10) {
            this.f7812Q = f10;
            invalidateSelf();
            if (m10102U2()) {
                m10044B1();
            }
        }
    }

    /* renamed from: o1 */
    public C9650d m10144o1() {
        return this.f7835n0.m10755d();
    }

    /* renamed from: o2 */
    public void m10145o2(int i10) {
        m10143n2(this.f7828g0.getResources().getDimension(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i10) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i10);
        if (m10099T2()) {
            zOnLayoutDirectionChanged |= C13669a.m82226g(this.f7803I, i10);
        }
        if (m10096S2()) {
            zOnLayoutDirectionChanged |= C13669a.m82226g(this.f7816U, i10);
        }
        if (m10102U2()) {
            zOnLayoutDirectionChanged |= C13669a.m82226g(this.f7809N, i10);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        boolean zOnLevelChange = super.onLevelChange(i10);
        if (m10099T2()) {
            zOnLevelChange |= this.f7803I.setLevel(i10);
        }
        if (m10096S2()) {
            zOnLevelChange |= this.f7816U.setLevel(i10);
        }
        if (m10102U2()) {
            zOnLevelChange |= this.f7809N.setLevel(i10);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // p356i3.C10427h, android.graphics.drawable.Drawable, com.google.android.material.internal.C1781l.b
    public boolean onStateChange(int[] iArr) {
        if (this.f7804I0) {
            super.onStateChange(iArr);
        }
        return m10047C1(iArr, m10120c1());
    }

    /* renamed from: p1 */
    public float m10146p1() {
        return this.f7824c0;
    }

    /* renamed from: p2 */
    public void m10147p2(float f10) {
        if (this.f7825d0 != f10) {
            this.f7825d0 = f10;
            invalidateSelf();
            if (m10102U2()) {
                m10044B1();
            }
        }
    }

    /* renamed from: q0 */
    public final void m10148q0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        C13669a.m82226g(drawable, C13669a.m82221b(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f7809N) {
            if (drawable.isStateful()) {
                drawable.setState(m10120c1());
            }
            C13669a.m82228i(drawable, this.f7811P);
            return;
        }
        Drawable drawable2 = this.f7803I;
        if (drawable == drawable2 && this.f7807L) {
            C13669a.m82228i(drawable2, this.f7805J);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    /* renamed from: q1 */
    public float m10149q1() {
        return this.f7823b0;
    }

    /* renamed from: q2 */
    public void m10150q2(int i10) {
        m10147p2(this.f7828g0.getResources().getDimension(i10));
    }

    /* renamed from: r0 */
    public final void m10151r0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (m10099T2() || m10096S2()) {
            float f10 = this.f7820Y + this.f7821Z;
            float fM10128g1 = m10128g1();
            if (C13669a.m82221b(this) == 0) {
                float f11 = rect.left + f10;
                rectF.left = f11;
                rectF.right = f11 + fM10128g1;
            } else {
                float f12 = rect.right - f10;
                rectF.right = f12;
                rectF.left = f12 - fM10128g1;
            }
            float fM10126f1 = m10126f1();
            float fExactCenterY = rect.exactCenterY() - (fM10126f1 / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fM10126f1;
        }
    }

    /* renamed from: r1 */
    public final ColorFilter m10152r1() {
        ColorFilter colorFilter = this.f7845x0;
        return colorFilter != null ? colorFilter : this.f7846y0;
    }

    /* renamed from: r2 */
    public boolean m10153r2(int[] iArr) {
        if (Arrays.equals(this.f7790B0, iArr)) {
            return false;
        }
        this.f7790B0 = iArr;
        if (m10102U2()) {
            return m10047C1(getState(), iArr);
        }
        return false;
    }

    /* renamed from: s0 */
    public float m10154s0() {
        if (m10099T2() || m10096S2()) {
            return this.f7821Z + m10128g1() + this.f7822a0;
        }
        return 0.0f;
    }

    /* renamed from: s1 */
    public boolean m10155s1() {
        return this.f7792C0;
    }

    /* renamed from: s2 */
    public void m10156s2(ColorStateList colorStateList) {
        if (this.f7811P != colorStateList) {
            this.f7811P = colorStateList;
            if (m10102U2()) {
                C13669a.m82228i(this.f7809N, colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j10);
        }
    }

    @Override // p356i3.C10427h, android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.f7844w0 != i10) {
            this.f7844w0 = i10;
            invalidateSelf();
        }
    }

    @Override // p356i3.C10427h, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f7845x0 != colorFilter) {
            this.f7845x0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // p356i3.C10427h, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.f7848z0 != colorStateList) {
            this.f7848z0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // p356i3.C10427h, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f7788A0 != mode) {
            this.f7788A0 = mode;
            this.f7846y0 = C14088a.m84432c(this, this.f7848z0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        if (m10099T2()) {
            visible |= this.f7803I.setVisible(z10, z11);
        }
        if (m10096S2()) {
            visible |= this.f7816U.setVisible(z10, z11);
        }
        if (m10102U2()) {
            visible |= this.f7809N.setVisible(z10, z11);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    /* renamed from: t0 */
    public final void m10157t0(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (m10102U2()) {
            float f10 = this.f7827f0 + this.f7826e0 + this.f7812Q + this.f7825d0 + this.f7824c0;
            if (C13669a.m82221b(this) == 0) {
                rectF.right = rect.right - f10;
            } else {
                rectF.left = rect.left + f10;
            }
        }
    }

    /* renamed from: t2 */
    public void m10158t2(int i10) {
        m10156s2(C8968a.m56742a(this.f7828g0, i10));
    }

    /* renamed from: u0 */
    public final void m10159u0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (m10102U2()) {
            float f10 = this.f7827f0 + this.f7826e0;
            if (C13669a.m82221b(this) == 0) {
                float f11 = rect.right - f10;
                rectF.right = f11;
                rectF.left = f11 - this.f7812Q;
            } else {
                float f12 = rect.left + f10;
                rectF.left = f12;
                rectF.right = f12 + this.f7812Q;
            }
            float fExactCenterY = rect.exactCenterY();
            float f13 = this.f7812Q;
            float f14 = fExactCenterY - (f13 / 2.0f);
            rectF.top = f14;
            rectF.bottom = f14 + f13;
        }
    }

    /* renamed from: u1 */
    public boolean m10160u1() {
        return this.f7814S;
    }

    /* renamed from: u2 */
    public void m10161u2(boolean z10) {
        if (this.f7808M != z10) {
            boolean zM10102U2 = m10102U2();
            this.f7808M = z10;
            boolean zM10102U22 = m10102U2();
            if (zM10102U2 != zM10102U22) {
                if (zM10102U22) {
                    m10148q0(this.f7809N);
                } else {
                    m10105V2(this.f7809N);
                }
                invalidateSelf();
                m10044B1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    /* renamed from: v0 */
    public final void m10162v0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (m10102U2()) {
            float f10 = this.f7827f0 + this.f7826e0 + this.f7812Q + this.f7825d0 + this.f7824c0;
            if (C13669a.m82221b(this) == 0) {
                float f11 = rect.right;
                rectF.right = f11;
                rectF.left = f11 - f10;
            } else {
                int i10 = rect.left;
                rectF.left = i10;
                rectF.right = i10 + f10;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    /* renamed from: v1 */
    public boolean m10163v1() {
        return m10039y1(this.f7809N);
    }

    /* renamed from: v2 */
    public void m10164v2(a aVar) {
        this.f7796E0 = new WeakReference<>(aVar);
    }

    /* renamed from: w0 */
    public float m10165w0() {
        if (m10102U2()) {
            return this.f7825d0 + this.f7812Q + this.f7826e0;
        }
        return 0.0f;
    }

    /* renamed from: w1 */
    public boolean m10166w1() {
        return this.f7808M;
    }

    /* renamed from: w2 */
    public void m10167w2(TextUtils.TruncateAt truncateAt) {
        this.f7798F0 = truncateAt;
    }

    /* renamed from: x0 */
    public final void m10168x0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.f7799G != null) {
            float fM10154s0 = this.f7820Y + m10154s0() + this.f7823b0;
            float fM10165w0 = this.f7827f0 + m10165w0() + this.f7824c0;
            if (C13669a.m82221b(this) == 0) {
                rectF.left = rect.left + fM10154s0;
                rectF.right = rect.right - fM10165w0;
            } else {
                rectF.left = rect.left + fM10165w0;
                rectF.right = rect.right - fM10154s0;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    /* renamed from: x2 */
    public void m10169x2(C13117h c13117h) {
        this.f7819X = c13117h;
    }

    /* renamed from: y0 */
    public final float m10170y0() {
        this.f7835n0.m10756e().getFontMetrics(this.f7831j0);
        Paint.FontMetrics fontMetrics = this.f7831j0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    /* renamed from: y2 */
    public void m10171y2(int i10) {
        m10169x2(C13117h.m78898d(this.f7828g0, i10));
    }

    /* renamed from: z0 */
    public Paint.Align m10172z0(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.f7799G != null) {
            float fM10154s0 = this.f7820Y + m10154s0() + this.f7823b0;
            if (C13669a.m82221b(this) == 0) {
                pointF.x = rect.left + fM10154s0;
            } else {
                pointF.x = rect.right - fM10154s0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - m10170y0();
        }
        return align;
    }

    /* renamed from: z2 */
    public void m10173z2(float f10) {
        if (this.f7822a0 != f10) {
            float fM10154s0 = m10154s0();
            this.f7822a0 = f10;
            float fM10154s02 = m10154s0();
            invalidateSelf();
            if (fM10154s0 != fM10154s02) {
                m10044B1();
            }
        }
    }
}
