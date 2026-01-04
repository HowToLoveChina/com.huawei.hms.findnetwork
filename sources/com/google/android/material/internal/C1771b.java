package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import com.huawei.android.hicloud.sync.service.aidl.SyncType;
import p212d0.C8973e;
import p243e0.C9373h;
import p273f0.C9603h0;
import p273f0.C9614n;
import p276f3.C9647a;
import p276f3.C9650d;
import p276f3.C9654h;
import p666u2.C13110a;
import p760x2.C13689a;
import p827z.C14059a;

/* renamed from: com.google.android.material.internal.b */
/* loaded from: classes.dex */
public final class C1771b {

    /* renamed from: t0 */
    public static final boolean f8258t0 = false;

    /* renamed from: u0 */
    public static final Paint f8259u0 = null;

    /* renamed from: A */
    public Typeface f8260A;

    /* renamed from: B */
    public Typeface f8261B;

    /* renamed from: C */
    public Typeface f8262C;

    /* renamed from: D */
    public Typeface f8263D;

    /* renamed from: E */
    public C9647a f8264E;

    /* renamed from: F */
    public C9647a f8265F;

    /* renamed from: G */
    public CharSequence f8266G;

    /* renamed from: H */
    public CharSequence f8267H;

    /* renamed from: I */
    public boolean f8268I;

    /* renamed from: K */
    public boolean f8270K;

    /* renamed from: L */
    public Bitmap f8271L;

    /* renamed from: M */
    public Paint f8272M;

    /* renamed from: N */
    public float f8273N;

    /* renamed from: O */
    public float f8274O;

    /* renamed from: P */
    public float f8275P;

    /* renamed from: Q */
    public float f8276Q;

    /* renamed from: R */
    public float f8277R;

    /* renamed from: S */
    public int f8278S;

    /* renamed from: T */
    public int[] f8279T;

    /* renamed from: U */
    public boolean f8280U;

    /* renamed from: V */
    public final TextPaint f8281V;

    /* renamed from: W */
    public final TextPaint f8282W;

    /* renamed from: X */
    public TimeInterpolator f8283X;

    /* renamed from: Y */
    public TimeInterpolator f8284Y;

    /* renamed from: Z */
    public float f8285Z;

    /* renamed from: a */
    public final View f8286a;

    /* renamed from: a0 */
    public float f8287a0;

    /* renamed from: b */
    public boolean f8288b;

    /* renamed from: b0 */
    public float f8289b0;

    /* renamed from: c */
    public float f8290c;

    /* renamed from: c0 */
    public ColorStateList f8291c0;

    /* renamed from: d */
    public boolean f8292d;

    /* renamed from: d0 */
    public float f8293d0;

    /* renamed from: e */
    public float f8294e;

    /* renamed from: e0 */
    public float f8295e0;

    /* renamed from: f */
    public float f8296f;

    /* renamed from: f0 */
    public float f8297f0;

    /* renamed from: g */
    public int f8298g;

    /* renamed from: g0 */
    public ColorStateList f8299g0;

    /* renamed from: h */
    public final Rect f8300h;

    /* renamed from: h0 */
    public float f8301h0;

    /* renamed from: i */
    public final Rect f8302i;

    /* renamed from: i0 */
    public float f8303i0;

    /* renamed from: j */
    public final RectF f8304j;

    /* renamed from: j0 */
    public float f8305j0;

    /* renamed from: k0 */
    public StaticLayout f8307k0;

    /* renamed from: l0 */
    public float f8309l0;

    /* renamed from: m0 */
    public float f8311m0;

    /* renamed from: n0 */
    public float f8313n0;

    /* renamed from: o */
    public ColorStateList f8314o;

    /* renamed from: o0 */
    public CharSequence f8315o0;

    /* renamed from: p */
    public ColorStateList f8316p;

    /* renamed from: q */
    public int f8318q;

    /* renamed from: r */
    public float f8320r;

    /* renamed from: s */
    public float f8322s;

    /* renamed from: t */
    public float f8324t;

    /* renamed from: u */
    public float f8325u;

    /* renamed from: v */
    public float f8326v;

    /* renamed from: w */
    public float f8327w;

    /* renamed from: x */
    public Typeface f8328x;

    /* renamed from: y */
    public Typeface f8329y;

    /* renamed from: z */
    public Typeface f8330z;

    /* renamed from: k */
    public int f8306k = 16;

    /* renamed from: l */
    public int f8308l = 16;

    /* renamed from: m */
    public float f8310m = 15.0f;

    /* renamed from: n */
    public float f8312n = 15.0f;

    /* renamed from: J */
    public boolean f8269J = true;

    /* renamed from: p0 */
    public int f8317p0 = 1;

    /* renamed from: q0 */
    public float f8319q0 = 0.0f;

    /* renamed from: r0 */
    public float f8321r0 = 1.0f;

    /* renamed from: s0 */
    public int f8323s0 = C1780k.f8381n;

    /* renamed from: com.google.android.material.internal.b$a */
    public class a implements C9647a.a {
        public a() {
        }

        @Override // p276f3.C9647a.a
        /* renamed from: a */
        public void mo10675a(Typeface typeface) {
            C1771b.this.m10638h0(typeface);
        }
    }

    /* renamed from: com.google.android.material.internal.b$b */
    public class b implements C9647a.a {
        public b() {
        }

        @Override // p276f3.C9647a.a
        /* renamed from: a */
        public void mo10675a(Typeface typeface) {
            C1771b.this.m10660s0(typeface);
        }
    }

    public C1771b(View view) {
        this.f8286a = view;
        TextPaint textPaint = new TextPaint(SyncType.WLAN_CHANGE);
        this.f8281V = textPaint;
        this.f8282W = new TextPaint(textPaint);
        this.f8302i = new Rect();
        this.f8300h = new Rect();
        this.f8304j = new RectF();
        this.f8296f = m10631e();
        m10620V(view.getContext().getResources().getConfiguration());
    }

    /* renamed from: Q */
    public static boolean m10588Q(float f10, float f11) {
        return Math.abs(f10 - f11) < 1.0E-5f;
    }

    /* renamed from: U */
    public static float m10589U(float f10, float f11, float f12, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f12 = timeInterpolator.getInterpolation(f12);
        }
        return C13110a.m78884a(f10, f11, f12);
    }

    /* renamed from: a */
    public static int m10590a(int i10, int i11, float f10) {
        float f11 = 1.0f - f10;
        return Color.argb(Math.round((Color.alpha(i10) * f11) + (Color.alpha(i11) * f10)), Math.round((Color.red(i10) * f11) + (Color.red(i11) * f10)), Math.round((Color.green(i10) * f11) + (Color.green(i11) * f10)), Math.round((Color.blue(i10) * f11) + (Color.blue(i11) * f10)));
    }

    /* renamed from: a0 */
    public static boolean m10591a0(Rect rect, int i10, int i11, int i12, int i13) {
        return rect.left == i10 && rect.top == i11 && rect.right == i12 && rect.bottom == i13;
    }

    /* renamed from: A */
    public int m10592A() {
        return this.f8306k;
    }

    /* renamed from: A0 */
    public void m10593A0(float f10) {
        this.f8321r0 = f10;
    }

    /* renamed from: B */
    public float m10594B() {
        m10615O(this.f8282W);
        return -this.f8282W.ascent();
    }

    /* renamed from: B0 */
    public void m10595B0(int i10) {
        if (i10 != this.f8317p0) {
            this.f8317p0 = i10;
            m10641j();
            m10623Y();
        }
    }

    /* renamed from: C */
    public Typeface m10596C() {
        Typeface typeface = this.f8260A;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    /* renamed from: C0 */
    public void m10597C0(TimeInterpolator timeInterpolator) {
        this.f8283X = timeInterpolator;
        m10623Y();
    }

    /* renamed from: D */
    public float m10598D() {
        return this.f8290c;
    }

    /* renamed from: D0 */
    public void m10599D0(boolean z10) {
        this.f8269J = z10;
    }

    /* renamed from: E */
    public float m10600E() {
        return this.f8296f;
    }

    /* renamed from: E0 */
    public final boolean m10601E0(int[] iArr) {
        this.f8279T = iArr;
        if (!m10618S()) {
            return false;
        }
        m10623Y();
        return true;
    }

    /* renamed from: F */
    public int m10602F() {
        return this.f8323s0;
    }

    /* renamed from: F0 */
    public void m10603F0(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.f8266G, charSequence)) {
            this.f8266G = charSequence;
            this.f8267H = null;
            m10641j();
            m10623Y();
        }
    }

    /* renamed from: G */
    public int m10604G() {
        StaticLayout staticLayout = this.f8307k0;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    /* renamed from: G0 */
    public void m10605G0(TimeInterpolator timeInterpolator) {
        this.f8284Y = timeInterpolator;
        m10623Y();
    }

    /* renamed from: H */
    public float m10606H() {
        return this.f8307k0.getSpacingAdd();
    }

    /* renamed from: H0 */
    public void m10607H0(Typeface typeface) {
        boolean zM10640i0 = m10640i0(typeface);
        boolean zM10662t0 = m10662t0(typeface);
        if (zM10640i0 || zM10662t0) {
            m10623Y();
        }
    }

    /* renamed from: I */
    public float m10608I() {
        return this.f8307k0.getSpacingMultiplier();
    }

    /* renamed from: I0 */
    public final boolean m10609I0() {
        return this.f8317p0 > 1 && (!this.f8268I || this.f8292d) && !this.f8270K;
    }

    /* renamed from: J */
    public int m10610J() {
        return this.f8317p0;
    }

    /* renamed from: K */
    public final Layout.Alignment m10611K() {
        int iM60102b = C9614n.m60102b(this.f8306k, this.f8268I ? 1 : 0) & 7;
        return iM60102b != 1 ? iM60102b != 5 ? this.f8268I ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.f8268I ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
    }

    /* renamed from: L */
    public TimeInterpolator m10612L() {
        return this.f8283X;
    }

    /* renamed from: M */
    public CharSequence m10613M() {
        return this.f8266G;
    }

    /* renamed from: N */
    public final void m10614N(TextPaint textPaint) {
        textPaint.setTextSize(this.f8312n);
        textPaint.setTypeface(this.f8328x);
        textPaint.setLetterSpacing(this.f8301h0);
    }

    /* renamed from: O */
    public final void m10615O(TextPaint textPaint) {
        textPaint.setTextSize(this.f8310m);
        textPaint.setTypeface(this.f8260A);
        textPaint.setLetterSpacing(this.f8303i0);
    }

    /* renamed from: P */
    public final void m10616P(float f10) {
        if (this.f8292d) {
            this.f8304j.set(f10 < this.f8296f ? this.f8300h : this.f8302i);
            return;
        }
        this.f8304j.left = m10589U(this.f8300h.left, this.f8302i.left, f10, this.f8283X);
        this.f8304j.top = m10589U(this.f8320r, this.f8322s, f10, this.f8283X);
        this.f8304j.right = m10589U(this.f8300h.right, this.f8302i.right, f10, this.f8283X);
        this.f8304j.bottom = m10589U(this.f8300h.bottom, this.f8302i.bottom, f10, this.f8283X);
    }

    /* renamed from: R */
    public final boolean m10617R() {
        return C9603h0.m59832A(this.f8286a) == 1;
    }

    /* renamed from: S */
    public final boolean m10618S() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f8316p;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f8314o) != null && colorStateList.isStateful());
    }

    /* renamed from: T */
    public final boolean m10619T(CharSequence charSequence, boolean z10) {
        return (z10 ? C8973e.f45509d : C8973e.f45508c).mo56777a(charSequence, 0, charSequence.length());
    }

    /* renamed from: V */
    public void m10620V(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f8330z;
            if (typeface != null) {
                this.f8329y = C9654h.m60294b(configuration, typeface);
            }
            Typeface typeface2 = this.f8262C;
            if (typeface2 != null) {
                this.f8261B = C9654h.m60294b(configuration, typeface2);
            }
            Typeface typeface3 = this.f8329y;
            if (typeface3 == null) {
                typeface3 = this.f8330z;
            }
            this.f8328x = typeface3;
            Typeface typeface4 = this.f8261B;
            if (typeface4 == null) {
                typeface4 = this.f8262C;
            }
            this.f8260A = typeface4;
            m10624Z(true);
        }
    }

    /* renamed from: W */
    public final float m10621W(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    /* renamed from: X */
    public void m10622X() {
        this.f8288b = this.f8302i.width() > 0 && this.f8302i.height() > 0 && this.f8300h.width() > 0 && this.f8300h.height() > 0;
    }

    /* renamed from: Y */
    public void m10623Y() {
        m10624Z(false);
    }

    /* renamed from: Z */
    public void m10624Z(boolean z10) {
        if ((this.f8286a.getHeight() <= 0 || this.f8286a.getWidth() <= 0) && !z10) {
            return;
        }
        m10625b(z10);
        m10627c();
    }

    /* renamed from: b */
    public final void m10625b(boolean z10) {
        StaticLayout staticLayout;
        m10639i(1.0f, z10);
        CharSequence charSequence = this.f8267H;
        if (charSequence != null && (staticLayout = this.f8307k0) != null) {
            this.f8315o0 = TextUtils.ellipsize(charSequence, this.f8281V, staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.f8315o0;
        float fM10621W = 0.0f;
        if (charSequence2 != null) {
            this.f8309l0 = m10621W(this.f8281V, charSequence2);
        } else {
            this.f8309l0 = 0.0f;
        }
        int iM60102b = C9614n.m60102b(this.f8308l, this.f8268I ? 1 : 0);
        int i10 = iM60102b & 112;
        if (i10 == 48) {
            this.f8322s = this.f8302i.top;
        } else if (i10 != 80) {
            this.f8322s = this.f8302i.centerY() - ((this.f8281V.descent() - this.f8281V.ascent()) / 2.0f);
        } else {
            this.f8322s = this.f8302i.bottom + this.f8281V.ascent();
        }
        int i11 = iM60102b & 8388615;
        if (i11 == 1) {
            this.f8325u = this.f8302i.centerX() - (this.f8309l0 / 2.0f);
        } else if (i11 != 5) {
            this.f8325u = this.f8302i.left;
        } else {
            this.f8325u = this.f8302i.right - this.f8309l0;
        }
        m10639i(0.0f, z10);
        float height = this.f8307k0 != null ? r10.getHeight() : 0.0f;
        StaticLayout staticLayout2 = this.f8307k0;
        if (staticLayout2 == null || this.f8317p0 <= 1) {
            CharSequence charSequence3 = this.f8267H;
            if (charSequence3 != null) {
                fM10621W = m10621W(this.f8281V, charSequence3);
            }
        } else {
            fM10621W = staticLayout2.getWidth();
        }
        StaticLayout staticLayout3 = this.f8307k0;
        this.f8318q = staticLayout3 != null ? staticLayout3.getLineCount() : 0;
        int iM60102b2 = C9614n.m60102b(this.f8306k, this.f8268I ? 1 : 0);
        int i12 = iM60102b2 & 112;
        if (i12 == 48) {
            this.f8320r = this.f8300h.top;
        } else if (i12 != 80) {
            this.f8320r = this.f8300h.centerY() - (height / 2.0f);
        } else {
            this.f8320r = (this.f8300h.bottom - height) + this.f8281V.descent();
        }
        int i13 = iM60102b2 & 8388615;
        if (i13 == 1) {
            this.f8324t = this.f8300h.centerX() - (fM10621W / 2.0f);
        } else if (i13 != 5) {
            this.f8324t = this.f8300h.left;
        } else {
            this.f8324t = this.f8300h.right - fM10621W;
        }
        m10641j();
        m10672y0(this.f8290c);
    }

    /* renamed from: b0 */
    public void m10626b0(int i10, int i11, int i12, int i13) {
        if (m10591a0(this.f8302i, i10, i11, i12, i13)) {
            return;
        }
        this.f8302i.set(i10, i11, i12, i13);
        this.f8280U = true;
        m10622X();
    }

    /* renamed from: c */
    public final void m10627c() {
        m10635g(this.f8290c);
    }

    /* renamed from: c0 */
    public void m10628c0(Rect rect) {
        m10626b0(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* renamed from: d */
    public final float m10629d(float f10) {
        float f11 = this.f8296f;
        return f10 <= f11 ? C13110a.m78885b(1.0f, 0.0f, this.f8294e, f11, f10) : C13110a.m78885b(0.0f, 1.0f, f11, 1.0f, f10);
    }

    /* renamed from: d0 */
    public void m10630d0(int i10) {
        C9650d c9650d = new C9650d(this.f8286a.getContext(), i10);
        if (c9650d.m60283i() != null) {
            this.f8316p = c9650d.m60283i();
        }
        if (c9650d.m60284j() != 0.0f) {
            this.f8312n = c9650d.m60284j();
        }
        ColorStateList colorStateList = c9650d.f47785c;
        if (colorStateList != null) {
            this.f8291c0 = colorStateList;
        }
        this.f8287a0 = c9650d.f47790h;
        this.f8289b0 = c9650d.f47791i;
        this.f8285Z = c9650d.f47792j;
        this.f8301h0 = c9650d.f47794l;
        C9647a c9647a = this.f8265F;
        if (c9647a != null) {
            c9647a.m60258c();
        }
        this.f8265F = new C9647a(new a(), c9650d.m60279e());
        c9650d.m60282h(this.f8286a.getContext(), this.f8265F);
        m10623Y();
    }

    /* renamed from: e */
    public final float m10631e() {
        float f10 = this.f8294e;
        return f10 + ((1.0f - f10) * 0.5f);
    }

    /* renamed from: e0 */
    public final void m10632e0(float f10) {
        this.f8311m0 = f10;
        C9603h0.m59884g0(this.f8286a);
    }

    /* renamed from: f */
    public final boolean m10633f(CharSequence charSequence) {
        boolean zM10617R = m10617R();
        return this.f8269J ? m10619T(charSequence, zM10617R) : zM10617R;
    }

    /* renamed from: f0 */
    public void m10634f0(ColorStateList colorStateList) {
        if (this.f8316p != colorStateList) {
            this.f8316p = colorStateList;
            m10623Y();
        }
    }

    /* renamed from: g */
    public final void m10635g(float f10) {
        float f11;
        m10616P(f10);
        if (!this.f8292d) {
            this.f8326v = m10589U(this.f8324t, this.f8325u, f10, this.f8283X);
            this.f8327w = m10589U(this.f8320r, this.f8322s, f10, this.f8283X);
            m10672y0(f10);
            f11 = f10;
        } else if (f10 < this.f8296f) {
            this.f8326v = this.f8324t;
            this.f8327w = this.f8320r;
            m10672y0(0.0f);
            f11 = 0.0f;
        } else {
            this.f8326v = this.f8325u;
            this.f8327w = this.f8322s - Math.max(0, this.f8298g);
            m10672y0(1.0f);
            f11 = 1.0f;
        }
        TimeInterpolator timeInterpolator = C13110a.f59598b;
        m10632e0(1.0f - m10589U(0.0f, 1.0f, 1.0f - f10, timeInterpolator));
        m10652o0(m10589U(1.0f, 0.0f, f10, timeInterpolator));
        if (this.f8316p != this.f8314o) {
            this.f8281V.setColor(m10590a(m10669x(), m10665v(), f11));
        } else {
            this.f8281V.setColor(m10665v());
        }
        float f12 = this.f8301h0;
        float f13 = this.f8303i0;
        if (f12 != f13) {
            this.f8281V.setLetterSpacing(m10589U(f13, f12, f10, timeInterpolator));
        } else {
            this.f8281V.setLetterSpacing(f12);
        }
        this.f8275P = m10589U(this.f8293d0, this.f8285Z, f10, null);
        this.f8276Q = m10589U(this.f8295e0, this.f8287a0, f10, null);
        this.f8277R = m10589U(this.f8297f0, this.f8289b0, f10, null);
        int iM10590a = m10590a(m10667w(this.f8299g0), m10667w(this.f8291c0), f10);
        this.f8278S = iM10590a;
        this.f8281V.setShadowLayer(this.f8275P, this.f8276Q, this.f8277R, iM10590a);
        if (this.f8292d) {
            this.f8281V.setAlpha((int) (m10629d(f10) * this.f8281V.getAlpha()));
        }
        C9603h0.m59884g0(this.f8286a);
    }

    /* renamed from: g0 */
    public void m10636g0(int i10) {
        if (this.f8308l != i10) {
            this.f8308l = i10;
            m10623Y();
        }
    }

    /* renamed from: h */
    public final void m10637h(float f10) {
        m10639i(f10, false);
    }

    /* renamed from: h0 */
    public void m10638h0(Typeface typeface) {
        if (m10640i0(typeface)) {
            m10623Y();
        }
    }

    /* renamed from: i */
    public final void m10639i(float f10, boolean z10) {
        boolean z11;
        float f11;
        float f12;
        boolean z12;
        if (this.f8266G == null) {
            return;
        }
        float fWidth = this.f8302i.width();
        float fWidth2 = this.f8300h.width();
        if (m10588Q(f10, 1.0f)) {
            f11 = this.f8312n;
            f12 = this.f8301h0;
            this.f8273N = 1.0f;
            Typeface typeface = this.f8263D;
            Typeface typeface2 = this.f8328x;
            if (typeface != typeface2) {
                this.f8263D = typeface2;
                z12 = true;
            } else {
                z12 = false;
            }
        } else {
            float f13 = this.f8310m;
            float f14 = this.f8303i0;
            Typeface typeface3 = this.f8263D;
            Typeface typeface4 = this.f8260A;
            if (typeface3 != typeface4) {
                this.f8263D = typeface4;
                z11 = true;
            } else {
                z11 = false;
            }
            if (m10588Q(f10, 0.0f)) {
                this.f8273N = 1.0f;
            } else {
                this.f8273N = m10589U(this.f8310m, this.f8312n, f10, this.f8284Y) / this.f8310m;
            }
            float f15 = this.f8312n / this.f8310m;
            fWidth = (!z10 && fWidth2 * f15 > fWidth) ? Math.min(fWidth / f15, fWidth2) : fWidth2;
            f11 = f13;
            f12 = f14;
            z12 = z11;
        }
        if (fWidth > 0.0f) {
            z12 = ((this.f8274O > f11 ? 1 : (this.f8274O == f11 ? 0 : -1)) != 0) || ((this.f8305j0 > f12 ? 1 : (this.f8305j0 == f12 ? 0 : -1)) != 0) || this.f8280U || z12;
            this.f8274O = f11;
            this.f8305j0 = f12;
            this.f8280U = false;
        }
        if (this.f8267H == null || z12) {
            this.f8281V.setTextSize(this.f8274O);
            this.f8281V.setTypeface(this.f8263D);
            this.f8281V.setLetterSpacing(this.f8305j0);
            this.f8281V.setLinearText(this.f8273N != 1.0f);
            this.f8268I = m10633f(this.f8266G);
            StaticLayout staticLayoutM10643k = m10643k(m10609I0() ? this.f8317p0 : 1, fWidth, this.f8268I);
            this.f8307k0 = staticLayoutM10643k;
            this.f8267H = staticLayoutM10643k.getText();
        }
    }

    /* renamed from: i0 */
    public final boolean m10640i0(Typeface typeface) {
        C9647a c9647a = this.f8265F;
        if (c9647a != null) {
            c9647a.m60258c();
        }
        if (this.f8330z == typeface) {
            return false;
        }
        this.f8330z = typeface;
        Typeface typefaceM60294b = C9654h.m60294b(this.f8286a.getContext().getResources().getConfiguration(), typeface);
        this.f8329y = typefaceM60294b;
        if (typefaceM60294b == null) {
            typefaceM60294b = this.f8330z;
        }
        this.f8328x = typefaceM60294b;
        return true;
    }

    /* renamed from: j */
    public final void m10641j() {
        Bitmap bitmap = this.f8271L;
        if (bitmap != null) {
            bitmap.recycle();
            this.f8271L = null;
        }
    }

    /* renamed from: j0 */
    public void m10642j0(int i10) {
        this.f8298g = i10;
    }

    /* renamed from: k */
    public final StaticLayout m10643k(int i10, float f10, boolean z10) {
        return (StaticLayout) C9373h.m58745f(C1780k.m10743b(this.f8266G, this.f8281V, (int) f10).m10746d(TextUtils.TruncateAt.END).m10749g(z10).m10745c(i10 == 1 ? Layout.Alignment.ALIGN_NORMAL : m10611K()).m10748f(false).m10751i(i10).m10750h(this.f8319q0, this.f8321r0).m10747e(this.f8323s0).m10744a());
    }

    /* renamed from: k0 */
    public void m10644k0(int i10, int i11, int i12, int i13) {
        if (m10591a0(this.f8300h, i10, i11, i12, i13)) {
            return;
        }
        this.f8300h.set(i10, i11, i12, i13);
        this.f8280U = true;
        m10622X();
    }

    /* renamed from: l */
    public void m10645l(Canvas canvas) {
        int iSave = canvas.save();
        if (this.f8267H == null || !this.f8288b) {
            return;
        }
        this.f8281V.setTextSize(this.f8274O);
        float f10 = this.f8326v;
        float f11 = this.f8327w;
        boolean z10 = this.f8270K && this.f8271L != null;
        float f12 = this.f8273N;
        if (f12 != 1.0f && !this.f8292d) {
            canvas.scale(f12, f12, f10, f11);
        }
        if (z10) {
            canvas.drawBitmap(this.f8271L, f10, f11, this.f8272M);
            canvas.restoreToCount(iSave);
            return;
        }
        if (!m10609I0() || (this.f8292d && this.f8290c <= this.f8296f)) {
            canvas.translate(f10, f11);
            this.f8307k0.draw(canvas);
        } else {
            m10647m(canvas, this.f8326v - this.f8307k0.getLineStart(0), f11);
        }
        canvas.restoreToCount(iSave);
    }

    /* renamed from: l0 */
    public void m10646l0(Rect rect) {
        m10644k0(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* renamed from: m */
    public final void m10647m(Canvas canvas, float f10, float f11) {
        int alpha = this.f8281V.getAlpha();
        canvas.translate(f10, f11);
        float f12 = alpha;
        this.f8281V.setAlpha((int) (this.f8313n0 * f12));
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 31) {
            TextPaint textPaint = this.f8281V;
            textPaint.setShadowLayer(this.f8275P, this.f8276Q, this.f8277R, C13689a.m82287a(this.f8278S, textPaint.getAlpha()));
        }
        this.f8307k0.draw(canvas);
        this.f8281V.setAlpha((int) (this.f8311m0 * f12));
        if (i10 >= 31) {
            TextPaint textPaint2 = this.f8281V;
            textPaint2.setShadowLayer(this.f8275P, this.f8276Q, this.f8277R, C13689a.m82287a(this.f8278S, textPaint2.getAlpha()));
        }
        int lineBaseline = this.f8307k0.getLineBaseline(0);
        CharSequence charSequence = this.f8315o0;
        float f13 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f13, this.f8281V);
        if (i10 >= 31) {
            this.f8281V.setShadowLayer(this.f8275P, this.f8276Q, this.f8277R, this.f8278S);
        }
        if (this.f8292d) {
            return;
        }
        String strTrim = this.f8315o0.toString().trim();
        if (strTrim.endsWith("…")) {
            strTrim = strTrim.substring(0, strTrim.length() - 1);
        }
        String str = strTrim;
        this.f8281V.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.f8307k0.getLineEnd(0), str.length()), 0.0f, f13, (Paint) this.f8281V);
    }

    /* renamed from: m0 */
    public void m10648m0(float f10) {
        if (this.f8303i0 != f10) {
            this.f8303i0 = f10;
            m10623Y();
        }
    }

    /* renamed from: n */
    public final void m10649n() {
        if (this.f8271L != null || this.f8300h.isEmpty() || TextUtils.isEmpty(this.f8267H)) {
            return;
        }
        m10635g(0.0f);
        int width = this.f8307k0.getWidth();
        int height = this.f8307k0.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.f8271L = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.f8307k0.draw(new Canvas(this.f8271L));
        if (this.f8272M == null) {
            this.f8272M = new Paint(3);
        }
    }

    /* renamed from: n0 */
    public void m10650n0(int i10) {
        C9650d c9650d = new C9650d(this.f8286a.getContext(), i10);
        if (c9650d.m60283i() != null) {
            this.f8314o = c9650d.m60283i();
        }
        if (c9650d.m60284j() != 0.0f) {
            this.f8310m = c9650d.m60284j();
        }
        ColorStateList colorStateList = c9650d.f47785c;
        if (colorStateList != null) {
            this.f8299g0 = colorStateList;
        }
        this.f8295e0 = c9650d.f47790h;
        this.f8297f0 = c9650d.f47791i;
        this.f8293d0 = c9650d.f47792j;
        this.f8303i0 = c9650d.f47794l;
        C9647a c9647a = this.f8264E;
        if (c9647a != null) {
            c9647a.m60258c();
        }
        this.f8264E = new C9647a(new b(), c9650d.m60279e());
        c9650d.m60282h(this.f8286a.getContext(), this.f8264E);
        m10623Y();
    }

    /* renamed from: o */
    public void m10651o(RectF rectF, int i10, int i11) {
        this.f8268I = m10633f(this.f8266G);
        rectF.left = m10659s(i10, i11);
        rectF.top = this.f8302i.top;
        rectF.right = m10661t(rectF, i10, i11);
        rectF.bottom = this.f8302i.top + m10657r();
    }

    /* renamed from: o0 */
    public final void m10652o0(float f10) {
        this.f8313n0 = f10;
        C9603h0.m59884g0(this.f8286a);
    }

    /* renamed from: p */
    public ColorStateList m10653p() {
        return this.f8316p;
    }

    /* renamed from: p0 */
    public void m10654p0(ColorStateList colorStateList) {
        if (this.f8314o != colorStateList) {
            this.f8314o = colorStateList;
            m10623Y();
        }
    }

    /* renamed from: q */
    public int m10655q() {
        return this.f8308l;
    }

    /* renamed from: q0 */
    public void m10656q0(int i10) {
        if (this.f8306k != i10) {
            this.f8306k = i10;
            m10623Y();
        }
    }

    /* renamed from: r */
    public float m10657r() {
        m10614N(this.f8282W);
        return -this.f8282W.ascent();
    }

    /* renamed from: r0 */
    public void m10658r0(float f10) {
        if (this.f8310m != f10) {
            this.f8310m = f10;
            m10623Y();
        }
    }

    /* renamed from: s */
    public final float m10659s(int i10, int i11) {
        return (i11 == 17 || (i11 & 7) == 1) ? (i10 / 2.0f) - (this.f8309l0 / 2.0f) : ((i11 & 8388613) == 8388613 || (i11 & 5) == 5) ? this.f8268I ? this.f8302i.left : this.f8302i.right - this.f8309l0 : this.f8268I ? this.f8302i.right - this.f8309l0 : this.f8302i.left;
    }

    /* renamed from: s0 */
    public void m10660s0(Typeface typeface) {
        if (m10662t0(typeface)) {
            m10623Y();
        }
    }

    /* renamed from: t */
    public final float m10661t(RectF rectF, int i10, int i11) {
        if (i11 == 17 || (i11 & 7) == 1) {
            return (i10 / 2.0f) + (this.f8309l0 / 2.0f);
        }
        if ((i11 & 8388613) == 8388613 || (i11 & 5) == 5) {
            return this.f8268I ? rectF.left + this.f8309l0 : this.f8302i.right;
        }
        if (this.f8268I) {
            return this.f8302i.right;
        }
        return this.f8309l0 + rectF.left;
    }

    /* renamed from: t0 */
    public final boolean m10662t0(Typeface typeface) {
        C9647a c9647a = this.f8264E;
        if (c9647a != null) {
            c9647a.m60258c();
        }
        if (this.f8262C == typeface) {
            return false;
        }
        this.f8262C = typeface;
        Typeface typefaceM60294b = C9654h.m60294b(this.f8286a.getContext().getResources().getConfiguration(), typeface);
        this.f8261B = typefaceM60294b;
        if (typefaceM60294b == null) {
            typefaceM60294b = this.f8262C;
        }
        this.f8260A = typefaceM60294b;
        return true;
    }

    /* renamed from: u */
    public Typeface m10663u() {
        Typeface typeface = this.f8328x;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    /* renamed from: u0 */
    public void m10664u0(float f10) {
        float fM84262a = C14059a.m84262a(f10, 0.0f, 1.0f);
        if (fM84262a != this.f8290c) {
            this.f8290c = fM84262a;
            m10627c();
        }
    }

    /* renamed from: v */
    public int m10665v() {
        return m10667w(this.f8316p);
    }

    /* renamed from: v0 */
    public void m10666v0(boolean z10) {
        this.f8292d = z10;
    }

    /* renamed from: w */
    public final int m10667w(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.f8279T;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    /* renamed from: w0 */
    public void m10668w0(float f10) {
        this.f8294e = f10;
        this.f8296f = m10631e();
    }

    /* renamed from: x */
    public final int m10669x() {
        return m10667w(this.f8314o);
    }

    /* renamed from: x0 */
    public void m10670x0(int i10) {
        this.f8323s0 = i10;
    }

    /* renamed from: y */
    public int m10671y() {
        return this.f8318q;
    }

    /* renamed from: y0 */
    public final void m10672y0(float f10) {
        m10637h(f10);
        boolean z10 = f8258t0 && this.f8273N != 1.0f;
        this.f8270K = z10;
        if (z10) {
            m10649n();
        }
        C9603h0.m59884g0(this.f8286a);
    }

    /* renamed from: z */
    public float m10673z() {
        m10615O(this.f8282W);
        return (-this.f8282W.ascent()) + this.f8282W.descent();
    }

    /* renamed from: z0 */
    public void m10674z0(float f10) {
        this.f8319q0 = f10;
    }
}
