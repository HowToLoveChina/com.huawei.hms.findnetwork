package p356i3;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import com.google.android.material.R$attr;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;
import java.util.BitSet;
import p243e0.C9368c;
import p325h3.C10089a;
import p356i3.C10432m;
import p356i3.C10433n;
import p356i3.C10434o;
import p760x2.C13689a;

/* renamed from: i3.h */
/* loaded from: classes.dex */
public class C10427h extends Drawable implements InterfaceC10435p {

    /* renamed from: x */
    public static final String f50258x = "h";

    /* renamed from: y */
    public static final Paint f50259y;

    /* renamed from: a */
    public c f50260a;

    /* renamed from: b */
    public final C10434o.g[] f50261b;

    /* renamed from: c */
    public final C10434o.g[] f50262c;

    /* renamed from: d */
    public final BitSet f50263d;

    /* renamed from: e */
    public boolean f50264e;

    /* renamed from: f */
    public final Matrix f50265f;

    /* renamed from: g */
    public final Path f50266g;

    /* renamed from: h */
    public final Path f50267h;

    /* renamed from: i */
    public final RectF f50268i;

    /* renamed from: j */
    public final RectF f50269j;

    /* renamed from: k */
    public final Region f50270k;

    /* renamed from: l */
    public final Region f50271l;

    /* renamed from: m */
    public C10432m f50272m;

    /* renamed from: n */
    public final Paint f50273n;

    /* renamed from: o */
    public final Paint f50274o;

    /* renamed from: p */
    public final C10089a f50275p;

    /* renamed from: q */
    public final C10433n.b f50276q;

    /* renamed from: r */
    public final C10433n f50277r;

    /* renamed from: s */
    public PorterDuffColorFilter f50278s;

    /* renamed from: t */
    public PorterDuffColorFilter f50279t;

    /* renamed from: u */
    public int f50280u;

    /* renamed from: v */
    public final RectF f50281v;

    /* renamed from: w */
    public boolean f50282w;

    /* renamed from: i3.h$a */
    public class a implements C10433n.b {
        public a() {
        }

        @Override // p356i3.C10433n.b
        /* renamed from: a */
        public void mo64036a(C10434o c10434o, Matrix matrix, int i10) {
            C10427h.this.f50263d.set(i10 + 4, c10434o.m64124e());
            C10427h.this.f50262c[i10] = c10434o.m64125f(matrix);
        }

        @Override // p356i3.C10433n.b
        /* renamed from: b */
        public void mo64037b(C10434o c10434o, Matrix matrix, int i10) {
            C10427h.this.f50263d.set(i10, c10434o.m64124e());
            C10427h.this.f50261b[i10] = c10434o.m64125f(matrix);
        }
    }

    /* renamed from: i3.h$b */
    public class b implements C10432m.c {

        /* renamed from: a */
        public final /* synthetic */ float f50284a;

        public b(float f10) {
            this.f50284a = f10;
        }

        @Override // p356i3.C10432m.c
        /* renamed from: a */
        public InterfaceC10422c mo64038a(InterfaceC10422c interfaceC10422c) {
            return interfaceC10422c instanceof C10430k ? interfaceC10422c : new C10421b(this.f50284a, interfaceC10422c);
        }
    }

    static {
        Paint paint = new Paint(1);
        f50259y = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public /* synthetic */ C10427h(c cVar, a aVar) {
        this(cVar);
    }

    /* renamed from: V */
    public static int m63970V(int i10, int i11) {
        return (i10 * (i11 + (i11 >>> 7))) >>> 8;
    }

    /* renamed from: m */
    public static C10427h m63975m(Context context, float f10) {
        int iM82289c = C13689a.m82289c(context, R$attr.colorSurface, C10427h.class.getSimpleName());
        C10427h c10427h = new C10427h();
        c10427h.m63992Q(context);
        c10427h.m64002b0(ColorStateList.valueOf(iM82289c));
        c10427h.m64001a0(f10);
        return c10427h;
    }

    /* renamed from: A */
    public int m63976A() {
        return this.f50280u;
    }

    /* renamed from: B */
    public int m63977B() {
        c cVar = this.f50260a;
        return (int) (cVar.f50304s * Math.sin(Math.toRadians(cVar.f50305t)));
    }

    /* renamed from: C */
    public int m63978C() {
        c cVar = this.f50260a;
        return (int) (cVar.f50304s * Math.cos(Math.toRadians(cVar.f50305t)));
    }

    /* renamed from: D */
    public int m63979D() {
        return this.f50260a.f50303r;
    }

    /* renamed from: E */
    public C10432m m63980E() {
        return this.f50260a.f50286a;
    }

    /* renamed from: F */
    public ColorStateList m63981F() {
        return this.f50260a.f50290e;
    }

    /* renamed from: G */
    public final float m63982G() {
        if (m63991P()) {
            return this.f50274o.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    /* renamed from: H */
    public float m63983H() {
        return this.f50260a.f50297l;
    }

    /* renamed from: I */
    public ColorStateList m63984I() {
        return this.f50260a.f50292g;
    }

    /* renamed from: J */
    public float m63985J() {
        return this.f50260a.f50286a.m64062r().mo63966a(m64030u());
    }

    /* renamed from: K */
    public float m63986K() {
        return this.f50260a.f50286a.m64064t().mo63966a(m64030u());
    }

    /* renamed from: L */
    public float m63987L() {
        return this.f50260a.f50301p;
    }

    /* renamed from: M */
    public float m63988M() {
        return m64032w() + m63987L();
    }

    /* renamed from: N */
    public final boolean m63989N() {
        c cVar = this.f50260a;
        int i10 = cVar.f50302q;
        return i10 != 1 && cVar.f50303r > 0 && (i10 == 2 || m63998X());
    }

    /* renamed from: O */
    public final boolean m63990O() {
        Paint.Style style = this.f50260a.f50307v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    /* renamed from: P */
    public final boolean m63991P() {
        Paint.Style style = this.f50260a.f50307v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f50274o.getStrokeWidth() > 0.0f;
    }

    /* renamed from: Q */
    public void m63992Q(Context context) {
        this.f50260a.f50287b = new ElevationOverlayProvider(context);
        m64026p0();
    }

    /* renamed from: R */
    public final void m63993R() {
        super.invalidateSelf();
    }

    /* renamed from: S */
    public boolean m63994S() {
        ElevationOverlayProvider elevationOverlayProvider = this.f50260a.f50287b;
        return elevationOverlayProvider != null && elevationOverlayProvider.m10412e();
    }

    /* renamed from: T */
    public boolean m63995T() {
        return this.f50260a.f50286a.m64065u(m64030u());
    }

    /* renamed from: U */
    public final void m63996U(Canvas canvas) {
        if (m63989N()) {
            canvas.save();
            m63997W(canvas);
            if (!this.f50282w) {
                m64021n(canvas);
                canvas.restore();
                return;
            }
            int iWidth = (int) (this.f50281v.width() - getBounds().width());
            int iHeight = (int) (this.f50281v.height() - getBounds().height());
            if (iWidth < 0 || iHeight < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) this.f50281v.width()) + (this.f50260a.f50303r * 2) + iWidth, ((int) this.f50281v.height()) + (this.f50260a.f50303r * 2) + iHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            float f10 = (getBounds().left - this.f50260a.f50303r) - iWidth;
            float f11 = (getBounds().top - this.f50260a.f50303r) - iHeight;
            canvas2.translate(-f10, -f11);
            m64021n(canvas2);
            canvas.drawBitmap(bitmapCreateBitmap, f10, f11, (Paint) null);
            bitmapCreateBitmap.recycle();
            canvas.restore();
        }
    }

    /* renamed from: W */
    public final void m63997W(Canvas canvas) {
        canvas.translate(m63977B(), m63978C());
    }

    /* renamed from: X */
    public boolean m63998X() {
        if (m63995T()) {
            return false;
        }
        this.f50266g.isConvex();
        return false;
    }

    /* renamed from: Y */
    public void m63999Y(float f10) {
        setShapeAppearanceModel(this.f50260a.f50286a.m64067w(f10));
    }

    /* renamed from: Z */
    public void m64000Z(InterfaceC10422c interfaceC10422c) {
        setShapeAppearanceModel(this.f50260a.f50286a.m64068x(interfaceC10422c));
    }

    /* renamed from: a0 */
    public void m64001a0(float f10) {
        c cVar = this.f50260a;
        if (cVar.f50300o != f10) {
            cVar.f50300o = f10;
            m64026p0();
        }
    }

    /* renamed from: b0 */
    public void m64002b0(ColorStateList colorStateList) {
        c cVar = this.f50260a;
        if (cVar.f50289d != colorStateList) {
            cVar.f50289d = colorStateList;
            onStateChange(getState());
        }
    }

    /* renamed from: c0 */
    public void m64003c0(float f10) {
        c cVar = this.f50260a;
        if (cVar.f50296k != f10) {
            cVar.f50296k = f10;
            this.f50264e = true;
            invalidateSelf();
        }
    }

    /* renamed from: d0 */
    public void m64004d0(int i10, int i11, int i12, int i13) {
        c cVar = this.f50260a;
        if (cVar.f50294i == null) {
            cVar.f50294i = new Rect();
        }
        this.f50260a.f50294i.set(i10, i11, i12, i13);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f50273n.setColorFilter(this.f50278s);
        int alpha = this.f50273n.getAlpha();
        this.f50273n.setAlpha(m63970V(alpha, this.f50260a.f50298m));
        this.f50274o.setColorFilter(this.f50279t);
        this.f50274o.setStrokeWidth(this.f50260a.f50297l);
        int alpha2 = this.f50274o.getAlpha();
        this.f50274o.setAlpha(m63970V(alpha2, this.f50260a.f50298m));
        if (this.f50264e) {
            m64012i();
            m64008g(m64030u(), this.f50266g);
            this.f50264e = false;
        }
        m63996U(canvas);
        if (m63990O()) {
            m64023o(canvas);
        }
        if (m63991P()) {
            mo11281r(canvas);
        }
        this.f50273n.setAlpha(alpha);
        this.f50274o.setAlpha(alpha2);
    }

    /* renamed from: e0 */
    public void m64005e0(Paint.Style style) {
        this.f50260a.f50307v = style;
        m63993R();
    }

    /* renamed from: f */
    public final PorterDuffColorFilter m64006f(Paint paint, boolean z10) {
        if (!z10) {
            return null;
        }
        int color = paint.getColor();
        int iM64018l = m64018l(color);
        this.f50280u = iM64018l;
        if (iM64018l != color) {
            return new PorterDuffColorFilter(iM64018l, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    /* renamed from: f0 */
    public void m64007f0(float f10) {
        c cVar = this.f50260a;
        if (cVar.f50299n != f10) {
            cVar.f50299n = f10;
            m64026p0();
        }
    }

    /* renamed from: g */
    public final void m64008g(RectF rectF, Path path) {
        m64010h(rectF, path);
        if (this.f50260a.f50295j != 1.0f) {
            this.f50265f.reset();
            Matrix matrix = this.f50265f;
            float f10 = this.f50260a.f50295j;
            matrix.setScale(f10, f10, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f50265f);
        }
        path.computeBounds(this.f50281v, true);
    }

    /* renamed from: g0 */
    public void m64009g0(boolean z10) {
        this.f50282w = z10;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f50260a.f50298m;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f50260a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.f50260a.f50302q == 2) {
            return;
        }
        if (m63995T()) {
            outline.setRoundRect(getBounds(), m63985J() * this.f50260a.f50296k);
        } else {
            m64008g(m64030u(), this.f50266g);
            this.f50266g.isConvex();
            try {
                outline.setConvexPath(this.f50266g);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f50260a.f50294i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f50270k.set(getBounds());
        m64008g(m64030u(), this.f50266g);
        this.f50271l.setPath(this.f50266g, this.f50270k);
        this.f50270k.op(this.f50271l, Region.Op.DIFFERENCE);
        return this.f50270k;
    }

    /* renamed from: h */
    public final void m64010h(RectF rectF, Path path) {
        C10433n c10433n = this.f50277r;
        c cVar = this.f50260a;
        c10433n.m64111e(cVar.f50286a, cVar.f50296k, rectF, this.f50276q, path);
    }

    /* renamed from: h0 */
    public void m64011h0(int i10) {
        this.f50275p.m62886d(i10);
        this.f50260a.f50306u = false;
        m63993R();
    }

    /* renamed from: i */
    public final void m64012i() {
        C10432m c10432mM64069y = m63980E().m64069y(new b(-m63982G()));
        this.f50272m = c10432mM64069y;
        this.f50277r.m64110d(c10432mM64069y, this.f50260a.f50296k, m64031v(), this.f50267h);
    }

    /* renamed from: i0 */
    public void m64013i0(int i10) {
        c cVar = this.f50260a;
        if (cVar.f50302q != i10) {
            cVar.f50302q = i10;
            m63993R();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f50264e = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f50260a.f50292g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f50260a.f50291f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f50260a.f50290e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f50260a.f50289d) != null && colorStateList4.isStateful())));
    }

    /* renamed from: j */
    public final PorterDuffColorFilter m64014j(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z10) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z10) {
            colorForState = m64018l(colorForState);
        }
        this.f50280u = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    /* renamed from: j0 */
    public void m64015j0(float f10, int i10) {
        m64020m0(f10);
        m64019l0(ColorStateList.valueOf(i10));
    }

    /* renamed from: k */
    public final PorterDuffColorFilter m64016k(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z10) {
        return (colorStateList == null || mode == null) ? m64006f(paint, z10) : m64014j(colorStateList, mode, z10);
    }

    /* renamed from: k0 */
    public void m64017k0(float f10, ColorStateList colorStateList) {
        m64020m0(f10);
        m64019l0(colorStateList);
    }

    /* renamed from: l */
    public int m64018l(int i10) {
        float fM63988M = m63988M() + m64035z();
        ElevationOverlayProvider elevationOverlayProvider = this.f50260a.f50287b;
        return elevationOverlayProvider != null ? elevationOverlayProvider.m10410c(i10, fM63988M) : i10;
    }

    /* renamed from: l0 */
    public void m64019l0(ColorStateList colorStateList) {
        c cVar = this.f50260a;
        if (cVar.f50290e != colorStateList) {
            cVar.f50290e = colorStateList;
            onStateChange(getState());
        }
    }

    /* renamed from: m0 */
    public void m64020m0(float f10) {
        this.f50260a.f50297l = f10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f50260a = new c(this.f50260a);
        return this;
    }

    /* renamed from: n */
    public final void m64021n(Canvas canvas) {
        if (this.f50263d.cardinality() > 0) {
            Log.w(f50258x, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f50260a.f50304s != 0) {
            canvas.drawPath(this.f50266g, this.f50275p.m62885c());
        }
        for (int i10 = 0; i10 < 4; i10++) {
            this.f50261b[i10].m64168b(this.f50275p, this.f50260a.f50303r, canvas);
            this.f50262c[i10].m64168b(this.f50275p, this.f50260a.f50303r, canvas);
        }
        if (this.f50282w) {
            int iM63977B = m63977B();
            int iM63978C = m63978C();
            canvas.translate(-iM63977B, -iM63978C);
            canvas.drawPath(this.f50266g, f50259y);
            canvas.translate(iM63977B, iM63978C);
        }
    }

    /* renamed from: n0 */
    public final boolean m64022n0(int[] iArr) {
        boolean z10;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f50260a.f50289d == null || color2 == (colorForState2 = this.f50260a.f50289d.getColorForState(iArr, (color2 = this.f50273n.getColor())))) {
            z10 = false;
        } else {
            this.f50273n.setColor(colorForState2);
            z10 = true;
        }
        if (this.f50260a.f50290e == null || color == (colorForState = this.f50260a.f50290e.getColorForState(iArr, (color = this.f50274o.getColor())))) {
            return z10;
        }
        this.f50274o.setColor(colorForState);
        return true;
    }

    /* renamed from: o */
    public final void m64023o(Canvas canvas) {
        m64027q(canvas, this.f50273n, this.f50266g, this.f50260a.f50286a, m64030u());
    }

    /* renamed from: o0 */
    public final boolean m64024o0() {
        PorterDuffColorFilter porterDuffColorFilter = this.f50278s;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f50279t;
        c cVar = this.f50260a;
        this.f50278s = m64016k(cVar.f50292g, cVar.f50293h, this.f50273n, true);
        c cVar2 = this.f50260a;
        this.f50279t = m64016k(cVar2.f50291f, cVar2.f50293h, this.f50274o, false);
        c cVar3 = this.f50260a;
        if (cVar3.f50306u) {
            this.f50275p.m62886d(cVar3.f50292g.getColorForState(getState(), 0));
        }
        return (C9368c.m58729a(porterDuffColorFilter, this.f50278s) && C9368c.m58729a(porterDuffColorFilter2, this.f50279t)) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f50264e = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.C1781l.b
    public boolean onStateChange(int[] iArr) {
        boolean z10 = m64022n0(iArr) || m64024o0();
        if (z10) {
            invalidateSelf();
        }
        return z10;
    }

    /* renamed from: p */
    public void m64025p(Canvas canvas, Paint paint, Path path, RectF rectF) {
        m64027q(canvas, paint, path, this.f50260a.f50286a, rectF);
    }

    /* renamed from: p0 */
    public final void m64026p0() {
        float fM63988M = m63988M();
        this.f50260a.f50303r = (int) Math.ceil(0.75f * fM63988M);
        this.f50260a.f50304s = (int) Math.ceil(fM63988M * 0.25f);
        m64024o0();
        m63993R();
    }

    /* renamed from: q */
    public final void m64027q(Canvas canvas, Paint paint, Path path, C10432m c10432m, RectF rectF) {
        if (!c10432m.m64065u(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fMo63966a = c10432m.m64064t().mo63966a(rectF) * this.f50260a.f50296k;
            canvas.drawRoundRect(rectF, fMo63966a, fMo63966a, paint);
        }
    }

    /* renamed from: r */
    public void mo11281r(Canvas canvas) {
        m64027q(canvas, this.f50274o, this.f50267h, this.f50272m, m64031v());
    }

    /* renamed from: s */
    public float m64028s() {
        return this.f50260a.f50286a.m64055j().mo63966a(m64030u());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        c cVar = this.f50260a;
        if (cVar.f50298m != i10) {
            cVar.f50298m = i10;
            m63993R();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f50260a.f50288c = colorFilter;
        m63993R();
    }

    @Override // p356i3.InterfaceC10435p
    public void setShapeAppearanceModel(C10432m c10432m) {
        this.f50260a.f50286a = c10432m;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f50260a.f50292g = colorStateList;
        m64024o0();
        m63993R();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f50260a;
        if (cVar.f50293h != mode) {
            cVar.f50293h = mode;
            m64024o0();
            m63993R();
        }
    }

    /* renamed from: t */
    public float m64029t() {
        return this.f50260a.f50286a.m64057l().mo63966a(m64030u());
    }

    /* renamed from: u */
    public RectF m64030u() {
        this.f50268i.set(getBounds());
        return this.f50268i;
    }

    /* renamed from: v */
    public final RectF m64031v() {
        this.f50269j.set(m64030u());
        float fM63982G = m63982G();
        this.f50269j.inset(fM63982G, fM63982G);
        return this.f50269j;
    }

    /* renamed from: w */
    public float m64032w() {
        return this.f50260a.f50300o;
    }

    /* renamed from: x */
    public ColorStateList m64033x() {
        return this.f50260a.f50289d;
    }

    /* renamed from: y */
    public float m64034y() {
        return this.f50260a.f50296k;
    }

    /* renamed from: z */
    public float m64035z() {
        return this.f50260a.f50299n;
    }

    public C10427h() {
        this(new C10432m());
    }

    public C10427h(Context context, AttributeSet attributeSet, int i10, int i11) {
        this(C10432m.m64049e(context, attributeSet, i10, i11).m64093m());
    }

    public C10427h(C10432m c10432m) {
        this(new c(c10432m, null));
    }

    public C10427h(c cVar) {
        C10433n c10433n;
        this.f50261b = new C10434o.g[4];
        this.f50262c = new C10434o.g[4];
        this.f50263d = new BitSet(8);
        this.f50265f = new Matrix();
        this.f50266g = new Path();
        this.f50267h = new Path();
        this.f50268i = new RectF();
        this.f50269j = new RectF();
        this.f50270k = new Region();
        this.f50271l = new Region();
        Paint paint = new Paint(1);
        this.f50273n = paint;
        Paint paint2 = new Paint(1);
        this.f50274o = paint2;
        this.f50275p = new C10089a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            c10433n = C10433n.m64106k();
        } else {
            c10433n = new C10433n();
        }
        this.f50277r = c10433n;
        this.f50281v = new RectF();
        this.f50282w = true;
        this.f50260a = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        m64024o0();
        m64022n0(getState());
        this.f50276q = new a();
    }

    /* renamed from: i3.h$c */
    public static final class c extends Drawable.ConstantState {

        /* renamed from: a */
        public C10432m f50286a;

        /* renamed from: b */
        public ElevationOverlayProvider f50287b;

        /* renamed from: c */
        public ColorFilter f50288c;

        /* renamed from: d */
        public ColorStateList f50289d;

        /* renamed from: e */
        public ColorStateList f50290e;

        /* renamed from: f */
        public ColorStateList f50291f;

        /* renamed from: g */
        public ColorStateList f50292g;

        /* renamed from: h */
        public PorterDuff.Mode f50293h;

        /* renamed from: i */
        public Rect f50294i;

        /* renamed from: j */
        public float f50295j;

        /* renamed from: k */
        public float f50296k;

        /* renamed from: l */
        public float f50297l;

        /* renamed from: m */
        public int f50298m;

        /* renamed from: n */
        public float f50299n;

        /* renamed from: o */
        public float f50300o;

        /* renamed from: p */
        public float f50301p;

        /* renamed from: q */
        public int f50302q;

        /* renamed from: r */
        public int f50303r;

        /* renamed from: s */
        public int f50304s;

        /* renamed from: t */
        public int f50305t;

        /* renamed from: u */
        public boolean f50306u;

        /* renamed from: v */
        public Paint.Style f50307v;

        public c(C10432m c10432m, ElevationOverlayProvider elevationOverlayProvider) {
            this.f50289d = null;
            this.f50290e = null;
            this.f50291f = null;
            this.f50292g = null;
            this.f50293h = PorterDuff.Mode.SRC_IN;
            this.f50294i = null;
            this.f50295j = 1.0f;
            this.f50296k = 1.0f;
            this.f50298m = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
            this.f50299n = 0.0f;
            this.f50300o = 0.0f;
            this.f50301p = 0.0f;
            this.f50302q = 0;
            this.f50303r = 0;
            this.f50304s = 0;
            this.f50305t = 0;
            this.f50306u = false;
            this.f50307v = Paint.Style.FILL_AND_STROKE;
            this.f50286a = c10432m;
            this.f50287b = elevationOverlayProvider;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            C10427h c10427h = new C10427h(this, null);
            c10427h.f50264e = true;
            return c10427h;
        }

        public c(c cVar) {
            this.f50289d = null;
            this.f50290e = null;
            this.f50291f = null;
            this.f50292g = null;
            this.f50293h = PorterDuff.Mode.SRC_IN;
            this.f50294i = null;
            this.f50295j = 1.0f;
            this.f50296k = 1.0f;
            this.f50298m = HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
            this.f50299n = 0.0f;
            this.f50300o = 0.0f;
            this.f50301p = 0.0f;
            this.f50302q = 0;
            this.f50303r = 0;
            this.f50304s = 0;
            this.f50305t = 0;
            this.f50306u = false;
            this.f50307v = Paint.Style.FILL_AND_STROKE;
            this.f50286a = cVar.f50286a;
            this.f50287b = cVar.f50287b;
            this.f50297l = cVar.f50297l;
            this.f50288c = cVar.f50288c;
            this.f50289d = cVar.f50289d;
            this.f50290e = cVar.f50290e;
            this.f50293h = cVar.f50293h;
            this.f50292g = cVar.f50292g;
            this.f50298m = cVar.f50298m;
            this.f50295j = cVar.f50295j;
            this.f50304s = cVar.f50304s;
            this.f50302q = cVar.f50302q;
            this.f50306u = cVar.f50306u;
            this.f50296k = cVar.f50296k;
            this.f50299n = cVar.f50299n;
            this.f50300o = cVar.f50300o;
            this.f50301p = cVar.f50301p;
            this.f50303r = cVar.f50303r;
            this.f50305t = cVar.f50305t;
            this.f50291f = cVar.f50291f;
            this.f50307v = cVar.f50307v;
            if (cVar.f50294i != null) {
                this.f50294i = new Rect(cVar.f50294i);
            }
        }
    }
}
