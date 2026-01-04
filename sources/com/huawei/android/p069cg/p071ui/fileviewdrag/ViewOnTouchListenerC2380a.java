package com.huawei.android.p069cg.p071ui.fileviewdrag;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import p008a7.C0054a;
import p008a7.C0055b;
import p008a7.InterfaceC0057d;
import p008a7.InterfaceC0059f;
import p008a7.InterfaceC0060g;
import p008a7.InterfaceC0061h;
import p008a7.InterfaceC0062i;
import p031b7.C1120a;

/* renamed from: com.huawei.android.cg.ui.fileviewdrag.a */
/* loaded from: classes2.dex */
public class ViewOnTouchListenerC2380a implements View.OnTouchListener, InterfaceC0059f, View.OnLayoutChangeListener {

    /* renamed from: v */
    public static float f11347v = 3.0f;

    /* renamed from: g */
    public ImageView f11354g;

    /* renamed from: h */
    public GestureDetector f11355h;

    /* renamed from: i */
    public C0055b f11356i;

    /* renamed from: o */
    public View.OnClickListener f11362o;

    /* renamed from: p */
    public View.OnLongClickListener f11363p;

    /* renamed from: q */
    public e f11364q;

    /* renamed from: s */
    public float f11366s;

    /* renamed from: a */
    public Interpolator f11348a = new AccelerateDecelerateInterpolator();

    /* renamed from: b */
    public int f11349b = 200;

    /* renamed from: c */
    public float f11350c = 1.0f;

    /* renamed from: d */
    public float f11351d = 1.75f;

    /* renamed from: e */
    public boolean f11352e = true;

    /* renamed from: f */
    public boolean f11353f = false;

    /* renamed from: j */
    public final Matrix f11357j = new Matrix();

    /* renamed from: k */
    public final Matrix f11358k = new Matrix();

    /* renamed from: l */
    public final Matrix f11359l = new Matrix();

    /* renamed from: m */
    public final RectF f11360m = new RectF();

    /* renamed from: n */
    public final float[] f11361n = new float[9];

    /* renamed from: r */
    public int f11365r = 2;

    /* renamed from: t */
    public boolean f11367t = true;

    /* renamed from: u */
    public ImageView.ScaleType f11368u = ImageView.ScaleType.FIT_CENTER;

    /* renamed from: com.huawei.android.cg.ui.fileviewdrag.a$a */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            ViewOnTouchListenerC2380a.m14872h(ViewOnTouchListenerC2380a.this);
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (ViewOnTouchListenerC2380a.this.f11363p != null) {
                ViewOnTouchListenerC2380a.this.f11363p.onLongClick(ViewOnTouchListenerC2380a.this.f11354g);
            }
        }
    }

    /* renamed from: com.huawei.android.cg.ui.fileviewdrag.a$b */
    public class b implements GestureDetector.OnDoubleTapListener {
        public b() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float fM14884E = ViewOnTouchListenerC2380a.this.m14884E();
                float x10 = motionEvent.getX();
                float y10 = motionEvent.getY();
                if (fM14884E < ViewOnTouchListenerC2380a.this.m14882C()) {
                    ViewOnTouchListenerC2380a viewOnTouchListenerC2380a = ViewOnTouchListenerC2380a.this;
                    viewOnTouchListenerC2380a.m14895R(viewOnTouchListenerC2380a.m14882C(), x10, y10, true);
                } else if (fM14884E < ViewOnTouchListenerC2380a.this.m14882C() || fM14884E >= ViewOnTouchListenerC2380a.this.m14881B()) {
                    ViewOnTouchListenerC2380a viewOnTouchListenerC2380a2 = ViewOnTouchListenerC2380a.this;
                    viewOnTouchListenerC2380a2.m14895R(viewOnTouchListenerC2380a2.m14883D(), x10, y10, true);
                } else {
                    ViewOnTouchListenerC2380a viewOnTouchListenerC2380a3 = ViewOnTouchListenerC2380a.this;
                    viewOnTouchListenerC2380a3.m14895R(viewOnTouchListenerC2380a3.m14881B(), x10, y10, true);
                }
            } catch (ArrayIndexOutOfBoundsException e10) {
                C1120a.m6676e("PhotoViewAttacher", "onDoubleTap error : " + e10.toString());
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (ViewOnTouchListenerC2380a.this.f11362o != null) {
                ViewOnTouchListenerC2380a.this.f11362o.onClick(ViewOnTouchListenerC2380a.this.f11354g);
            }
            ViewOnTouchListenerC2380a.m14874j(ViewOnTouchListenerC2380a.this);
            RectF rectFM14905v = ViewOnTouchListenerC2380a.this.m14905v();
            if (rectFM14905v == null) {
                return false;
            }
            if (!rectFM14905v.contains(motionEvent.getX(), motionEvent.getY())) {
                ViewOnTouchListenerC2380a.m14876l(ViewOnTouchListenerC2380a.this);
                return false;
            }
            rectFM14905v.width();
            rectFM14905v.height();
            ViewOnTouchListenerC2380a.m14875k(ViewOnTouchListenerC2380a.this);
            return true;
        }
    }

    /* renamed from: com.huawei.android.cg.ui.fileviewdrag.a$c */
    public static /* synthetic */ class c {

        /* renamed from: a */
        public static final /* synthetic */ int[] f11371a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f11371a = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11371a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11371a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11371a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11371a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: com.huawei.android.cg.ui.fileviewdrag.a$d */
    public class d implements Runnable {

        /* renamed from: a */
        public final float f11372a;

        /* renamed from: b */
        public final float f11373b;

        /* renamed from: c */
        public final long f11374c = System.currentTimeMillis();

        /* renamed from: d */
        public final float f11375d;

        /* renamed from: e */
        public final float f11376e;

        public d(float f10, float f11, float f12, float f13) {
            this.f11372a = f12;
            this.f11373b = f13;
            this.f11375d = f10;
            this.f11376e = f11;
        }

        /* renamed from: a */
        public final float m14910a() {
            return ViewOnTouchListenerC2380a.this.f11348a.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.f11374c) * 1.0f) / ViewOnTouchListenerC2380a.this.f11349b));
        }

        @Override // java.lang.Runnable
        public void run() {
            float fM14910a = m14910a();
            float f10 = this.f11375d;
            ViewOnTouchListenerC2380a.this.mo405a((f10 + ((this.f11376e - f10) * fM14910a)) / ViewOnTouchListenerC2380a.this.m14884E(), this.f11372a, this.f11373b);
            if (fM14910a < 1.0f) {
                C0054a.m383a(ViewOnTouchListenerC2380a.this.f11354g, this);
            }
        }
    }

    /* renamed from: com.huawei.android.cg.ui.fileviewdrag.a$e */
    public class e implements Runnable {

        /* renamed from: a */
        public final OverScroller f11378a;

        /* renamed from: b */
        public int f11379b;

        /* renamed from: c */
        public int f11380c;

        public e(Context context) {
            this.f11378a = new OverScroller(context);
        }

        /* renamed from: a */
        public void m14911a() {
            this.f11378a.forceFinished(true);
        }

        /* renamed from: c */
        public void m14912c(int i10, int i11, int i12, int i13) {
            int i14;
            int iRound;
            int i15;
            int iRound2;
            RectF rectFM14905v = ViewOnTouchListenerC2380a.this.m14905v();
            if (rectFM14905v == null) {
                return;
            }
            int iRound3 = Math.round(-rectFM14905v.left);
            float f10 = i10;
            if (f10 < rectFM14905v.width()) {
                iRound = Math.round(rectFM14905v.width() - f10);
                i14 = 0;
            } else {
                i14 = iRound3;
                iRound = i14;
            }
            int iRound4 = Math.round(-rectFM14905v.top);
            float f11 = i11;
            if (f11 < rectFM14905v.height()) {
                iRound2 = Math.round(rectFM14905v.height() - f11);
                i15 = 0;
            } else {
                i15 = iRound4;
                iRound2 = i15;
            }
            this.f11379b = iRound3;
            this.f11380c = iRound4;
            if (iRound3 == iRound && iRound4 == iRound2) {
                return;
            }
            this.f11378a.fling(iRound3, iRound4, i12, i13, i14, iRound, i15, iRound2, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f11378a.isFinished() && this.f11378a.computeScrollOffset()) {
                int currX = this.f11378a.getCurrX();
                int currY = this.f11378a.getCurrY();
                ViewOnTouchListenerC2380a.this.f11359l.postTranslate(this.f11379b - currX, this.f11380c - currY);
                ViewOnTouchListenerC2380a viewOnTouchListenerC2380a = ViewOnTouchListenerC2380a.this;
                viewOnTouchListenerC2380a.m14890M(viewOnTouchListenerC2380a.m14907x());
                this.f11379b = currX;
                this.f11380c = currY;
                C0054a.m383a(ViewOnTouchListenerC2380a.this.f11354g, this);
            }
        }
    }

    /* renamed from: com.huawei.android.cg.ui.fileviewdrag.a$f */
    public interface f {
    }

    public ViewOnTouchListenerC2380a(ImageView imageView) {
        this.f11354g = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.f11366s = 0.0f;
        this.f11356i = new C0055b(imageView.getContext(), this);
        m14887I(imageView);
    }

    /* renamed from: H */
    public static boolean m14866H(ImageView imageView) {
        return imageView.getDrawable() != null;
    }

    /* renamed from: J */
    public static boolean m14867J(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (c.f11371a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalStateException("Matrix scale type is not supported");
    }

    /* renamed from: h */
    public static /* synthetic */ InterfaceC0062i m14872h(ViewOnTouchListenerC2380a viewOnTouchListenerC2380a) {
        viewOnTouchListenerC2380a.getClass();
        return null;
    }

    /* renamed from: j */
    public static /* synthetic */ InterfaceC0057d m14874j(ViewOnTouchListenerC2380a viewOnTouchListenerC2380a) {
        viewOnTouchListenerC2380a.getClass();
        return null;
    }

    /* renamed from: k */
    public static /* synthetic */ InterfaceC0061h m14875k(ViewOnTouchListenerC2380a viewOnTouchListenerC2380a) {
        viewOnTouchListenerC2380a.getClass();
        return null;
    }

    /* renamed from: l */
    public static /* synthetic */ InterfaceC0060g m14876l(ViewOnTouchListenerC2380a viewOnTouchListenerC2380a) {
        viewOnTouchListenerC2380a.getClass();
        return null;
    }

    /* renamed from: A */
    public final int m14880A(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    /* renamed from: B */
    public float m14881B() {
        return f11347v;
    }

    /* renamed from: C */
    public float m14882C() {
        return this.f11351d;
    }

    /* renamed from: D */
    public float m14883D() {
        return this.f11350c;
    }

    /* renamed from: E */
    public float m14884E() {
        return (float) Math.sqrt(((float) Math.pow(m14886G(this.f11359l, 0), 2.0d)) + ((float) Math.pow(m14886G(this.f11359l, 3), 2.0d)));
    }

    /* renamed from: F */
    public ImageView.ScaleType m14885F() {
        return this.f11368u;
    }

    /* renamed from: G */
    public final float m14886G(Matrix matrix, int i10) {
        matrix.getValues(this.f11361n);
        return this.f11361n[i10];
    }

    /* renamed from: I */
    public final void m14887I(ImageView imageView) {
        this.f11355h = new GestureDetector(imageView.getContext(), new a());
        m14904u();
    }

    /* renamed from: K */
    public final void m14888K() {
        this.f11359l.reset();
        m14894Q(this.f11366s);
        m14890M(m14907x());
        m14903t();
    }

    /* renamed from: L */
    public void m14889L(InterfaceC0057d interfaceC0057d) {
    }

    /* renamed from: M */
    public final void m14890M(Matrix matrix) {
        this.f11354g.setImageMatrix(matrix);
    }

    /* renamed from: N */
    public void m14891N(View.OnClickListener onClickListener) {
        this.f11362o = onClickListener;
    }

    /* renamed from: O */
    public void m14892O(View.OnLongClickListener onLongClickListener) {
        this.f11363p = onLongClickListener;
    }

    /* renamed from: P */
    public void m14893P(f fVar) {
    }

    /* renamed from: Q */
    public void m14894Q(float f10) {
        this.f11359l.postRotate(f10 % 360.0f);
        m14902s();
    }

    /* renamed from: R */
    public void m14895R(float f10, float f11, float f12, boolean z10) {
        if (f10 < this.f11350c || f10 > f11347v) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z10) {
            this.f11354g.post(new d(m14884E(), f10, f11, f12));
        } else {
            this.f11359l.setScale(f10, f10, f11, f12);
            m14902s();
        }
    }

    /* renamed from: S */
    public void m14896S(ImageView.ScaleType scaleType) {
        if (!m14867J(scaleType) || scaleType == this.f11368u) {
            return;
        }
        this.f11368u = scaleType;
        m14897T();
    }

    /* renamed from: T */
    public void m14897T() {
        if (this.f11367t) {
            m14898U(this.f11354g.getDrawable());
        } else {
            m14888K();
        }
    }

    /* renamed from: U */
    public final void m14898U(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float fM14880A = m14880A(this.f11354g);
        float fM14909z = m14909z(this.f11354g);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f11357j.reset();
        float f10 = intrinsicWidth;
        float f11 = fM14880A / f10;
        float f12 = intrinsicHeight;
        float f13 = fM14909z / f12;
        ImageView.ScaleType scaleType = this.f11368u;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.f11357j.postTranslate((fM14880A - f10) / 2.0f, (fM14909z - f12) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float fMax = Math.max(f11, f13);
            this.f11357j.postScale(fMax, fMax);
            this.f11357j.postTranslate((fM14880A - (f10 * fMax)) / 2.0f, (fM14909z - (f12 * fMax)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float fMin = Math.min(1.0f, Math.min(f11, f13));
            this.f11357j.postScale(fMin, fMin);
            this.f11357j.postTranslate((fM14880A - (f10 * fMin)) / 2.0f, (fM14909z - (f12 * fMin)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f10, f12);
            RectF rectF2 = new RectF(0.0f, 0.0f, fM14880A, fM14909z);
            if (((int) this.f11366s) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f12, f10);
            }
            int i10 = c.f11371a[this.f11368u.ordinal()];
            if (i10 == 2) {
                this.f11357j.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i10 == 3) {
                this.f11357j.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i10 == 4) {
                this.f11357j.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            } else if (i10 == 5) {
                this.f11357j.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            }
        }
        m14888K();
    }

    @Override // p008a7.InterfaceC0059f
    /* renamed from: a */
    public void mo405a(float f10, float f11, float f12) {
        if (m14884E() < f11347v || f10 < 1.0f) {
            if (m14884E() > this.f11350c || f10 > 1.0f) {
                this.f11359l.postScale(f10, f10, f11, f12);
                m14902s();
            }
        }
    }

    @Override // p008a7.InterfaceC0059f
    /* renamed from: b */
    public void mo406b(float f10, float f11, float f12, float f13) {
        e eVar = new e(this.f11354g.getContext());
        this.f11364q = eVar;
        eVar.m14912c(m14880A(this.f11354g), m14909z(this.f11354g), (int) f12, (int) f13);
        this.f11354g.post(this.f11364q);
    }

    @Override // p008a7.InterfaceC0059f
    /* renamed from: c */
    public void mo407c(float f10, float f11) {
        if (this.f11356i.m393i()) {
            return;
        }
        this.f11359l.postTranslate(f10, f11);
        m14902s();
        ViewParent parent = this.f11354g.getParent();
        if (!this.f11352e || this.f11356i.m393i() || this.f11353f) {
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
                return;
            }
            return;
        }
        int i10 = this.f11365r;
        if ((i10 == 2 || ((i10 == 0 && f10 >= 1.0f) || (i10 == 1 && f10 <= -1.0f))) && parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        m14898U(this.f11354g.getDrawable());
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        RectF rectFM14905v;
        boolean zM394j = false;
        if (!this.f11367t || !(view instanceof ImageView) || !m14866H((ImageView) view)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            m14899p(view);
        } else if (action == 1 || action == 3) {
            m14884E();
            if (m14884E() < this.f11350c && (rectFM14905v = m14905v()) != null) {
                view.post(new d(m14884E(), this.f11350c, rectFM14905v.centerX(), rectFM14905v.centerY()));
                zM394j = true;
            }
        }
        if (this.f11356i != null) {
            m14900q();
            zM394j = this.f11356i.m394j(motionEvent);
        }
        GestureDetector gestureDetector = this.f11355h;
        if (gestureDetector == null || !gestureDetector.onTouchEvent(motionEvent)) {
            return zM394j;
        }
        return true;
    }

    /* renamed from: p */
    public final void m14899p(View view) {
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        m14901r();
    }

    /* renamed from: q */
    public final void m14900q() {
        boolean zM393i = this.f11356i.m393i();
        boolean zM392h = this.f11356i.m392h();
        boolean z10 = false;
        boolean z11 = (zM393i || this.f11356i.m393i()) ? false : true;
        boolean z12 = (zM392h || this.f11356i.m392h()) ? false : true;
        if (z11 && z12) {
            z10 = true;
        }
        this.f11353f = z10;
    }

    /* renamed from: r */
    public final void m14901r() {
        e eVar = this.f11364q;
        if (eVar != null) {
            eVar.m14911a();
            this.f11364q = null;
        }
    }

    /* renamed from: s */
    public final void m14902s() {
        if (m14903t()) {
            m14890M(m14907x());
        }
    }

    /* renamed from: t */
    public final boolean m14903t() {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        RectF rectFM14906w = m14906w(m14907x());
        if (rectFM14906w == null) {
            return false;
        }
        float fHeight = rectFM14906w.height();
        float fWidth = rectFM14906w.width();
        float fM14909z = m14909z(this.f11354g);
        float f15 = 0.0f;
        if (fHeight <= fM14909z) {
            int i10 = c.f11371a[this.f11368u.ordinal()];
            if (i10 != 2) {
                if (i10 != 3) {
                    fM14909z = (fM14909z - fHeight) / 2.0f;
                    f11 = rectFM14906w.top;
                } else {
                    fM14909z -= fHeight;
                    f11 = rectFM14906w.top;
                }
            } else {
                f10 = rectFM14906w.top;
                f12 = -f10;
            }
        } else {
            f10 = rectFM14906w.top;
            if (f10 > 0.0f) {
                f12 = -f10;
            } else {
                f11 = rectFM14906w.bottom;
                f12 = f11 < fM14909z ? fM14909z - f11 : 0.0f;
            }
        }
        float fM14880A = m14880A(this.f11354g);
        if (fWidth <= fM14880A) {
            int i11 = c.f11371a[this.f11368u.ordinal()];
            if (i11 != 2) {
                if (i11 != 3) {
                    f13 = (fM14880A - fWidth) / 2.0f;
                    f14 = rectFM14906w.left;
                } else {
                    f13 = fM14880A - fWidth;
                    f14 = rectFM14906w.left;
                }
                f15 = f13 - f14;
            } else {
                f15 = -rectFM14906w.left;
            }
            this.f11365r = 2;
        } else {
            float f16 = rectFM14906w.left;
            if (f16 > 0.0f) {
                this.f11365r = 0;
                f15 = -f16;
            } else {
                float f17 = rectFM14906w.right;
                if (f17 < fM14880A) {
                    f15 = fM14880A - f17;
                    this.f11365r = 1;
                } else {
                    this.f11365r = -1;
                }
            }
        }
        this.f11359l.postTranslate(f15, f12);
        return true;
    }

    /* renamed from: u */
    public final void m14904u() {
        this.f11355h.setOnDoubleTapListener(new b());
    }

    /* renamed from: v */
    public RectF m14905v() {
        m14903t();
        return m14906w(m14907x());
    }

    /* renamed from: w */
    public final RectF m14906w(Matrix matrix) {
        if (this.f11354g.getDrawable() == null) {
            return null;
        }
        this.f11360m.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.f11360m);
        return this.f11360m;
    }

    /* renamed from: x */
    public final Matrix m14907x() {
        this.f11358k.set(this.f11357j);
        this.f11358k.postConcat(this.f11359l);
        return this.f11358k;
    }

    /* renamed from: y */
    public Matrix m14908y() {
        return this.f11358k;
    }

    /* renamed from: z */
    public final int m14909z(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }
}
