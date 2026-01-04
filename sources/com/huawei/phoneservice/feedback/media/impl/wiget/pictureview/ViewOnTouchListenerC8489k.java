package com.huawei.phoneservice.feedback.media.impl.wiget.pictureview;

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

/* renamed from: com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.k */
/* loaded from: classes5.dex */
public class ViewOnTouchListenerC8489k implements View.OnTouchListener, View.OnLayoutChangeListener {

    /* renamed from: h */
    public final ImageView f39573h;

    /* renamed from: i */
    public GestureDetector f39574i;

    /* renamed from: j */
    public C8480b f39575j;

    /* renamed from: p */
    public View.OnLongClickListener f39581p;

    /* renamed from: q */
    public View.OnClickListener f39582q;

    /* renamed from: t */
    public float f39585t;

    /* renamed from: u */
    public f f39586u;

    /* renamed from: x */
    public final InterfaceC8481c f39589x;

    /* renamed from: a */
    public boolean f39566a = true;

    /* renamed from: b */
    public boolean f39567b = false;

    /* renamed from: c */
    public int f39568c = 200;

    /* renamed from: d */
    public float f39569d = 1.0f;

    /* renamed from: e */
    public float f39570e = 1.75f;

    /* renamed from: f */
    public float f39571f = 3.0f;

    /* renamed from: g */
    public Interpolator f39572g = new AccelerateDecelerateInterpolator();

    /* renamed from: k */
    public final float[] f39576k = new float[9];

    /* renamed from: l */
    public final Matrix f39577l = new Matrix();

    /* renamed from: m */
    public final Matrix f39578m = new Matrix();

    /* renamed from: n */
    public final Matrix f39579n = new Matrix();

    /* renamed from: o */
    public final RectF f39580o = new RectF();

    /* renamed from: r */
    public boolean f39583r = true;

    /* renamed from: s */
    public ImageView.ScaleType f39584s = ImageView.ScaleType.FIT_CENTER;

    /* renamed from: v */
    public int f39587v = 2;

    /* renamed from: w */
    public int f39588w = 2;

    /* renamed from: com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.k$a */
    public class a implements InterfaceC8481c {
        public a() {
        }

        @Override // com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.InterfaceC8481c
        /* renamed from: a */
        public void mo52667a(float f10, float f11, float f12) {
            mo52668a(f10, f11, f12, 0.0f, 0.0f);
        }

        @Override // com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.InterfaceC8481c
        /* renamed from: b */
        public void mo52669b(float f10, float f11) {
            if (ViewOnTouchListenerC8489k.this.f39575j.m52659e()) {
                return;
            }
            ViewOnTouchListenerC8489k.m52674F(ViewOnTouchListenerC8489k.this);
            ViewOnTouchListenerC8489k.this.f39577l.postTranslate(f10, f11);
            ViewOnTouchListenerC8489k.this.m52691G();
            ViewParent parent = ViewOnTouchListenerC8489k.this.f39573h.getParent();
            boolean zM52732y = ViewOnTouchListenerC8489k.this.m52732y(f10, f11);
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(zM52732y);
            }
        }

        @Override // com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.InterfaceC8481c
        /* renamed from: c */
        public void mo52670c(float f10, float f11, float f12, float f13) {
            ViewOnTouchListenerC8489k viewOnTouchListenerC8489k = ViewOnTouchListenerC8489k.this;
            viewOnTouchListenerC8489k.f39586u = viewOnTouchListenerC8489k.new f(viewOnTouchListenerC8489k.f39573h.getContext());
            f fVar = ViewOnTouchListenerC8489k.this.f39586u;
            ViewOnTouchListenerC8489k viewOnTouchListenerC8489k2 = ViewOnTouchListenerC8489k.this;
            int iM52690D = viewOnTouchListenerC8489k2.m52690D(viewOnTouchListenerC8489k2.f39573h);
            ViewOnTouchListenerC8489k viewOnTouchListenerC8489k3 = ViewOnTouchListenerC8489k.this;
            fVar.m52736c(iM52690D, viewOnTouchListenerC8489k3.m52707b(viewOnTouchListenerC8489k3.f39573h), (int) f12, (int) f13);
            ViewOnTouchListenerC8489k.this.f39573h.post(ViewOnTouchListenerC8489k.this.f39586u);
        }

        @Override // com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.InterfaceC8481c
        /* renamed from: a */
        public void mo52668a(float f10, float f11, float f12, float f13, float f14) {
            if (ViewOnTouchListenerC8489k.this.m52708c0() < ViewOnTouchListenerC8489k.this.f39571f || f10 < 1.0f) {
                ViewOnTouchListenerC8489k.m52675K(ViewOnTouchListenerC8489k.this);
                ViewOnTouchListenerC8489k.this.f39577l.postScale(f10, f10, f11, f12);
                ViewOnTouchListenerC8489k.this.f39577l.postTranslate(f13, f14);
                ViewOnTouchListenerC8489k.this.m52691G();
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.k$b */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            ViewOnTouchListenerC8489k.m52677R(ViewOnTouchListenerC8489k.this);
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (ViewOnTouchListenerC8489k.this.f39581p != null) {
                ViewOnTouchListenerC8489k.this.f39581p.onLongClick(ViewOnTouchListenerC8489k.this.f39573h);
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.k$c */
    public class c implements GestureDetector.OnDoubleTapListener {
        public c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            ViewOnTouchListenerC8489k viewOnTouchListenerC8489k;
            float fM52706a0;
            try {
                float fM52708c0 = ViewOnTouchListenerC8489k.this.m52708c0();
                float x10 = motionEvent.getX();
                float y10 = motionEvent.getY();
                if (fM52708c0 < ViewOnTouchListenerC8489k.this.m52704Y()) {
                    viewOnTouchListenerC8489k = ViewOnTouchListenerC8489k.this;
                    fM52706a0 = viewOnTouchListenerC8489k.m52704Y();
                } else if (fM52708c0 < ViewOnTouchListenerC8489k.this.m52704Y() || fM52708c0 >= ViewOnTouchListenerC8489k.this.m52703W()) {
                    viewOnTouchListenerC8489k = ViewOnTouchListenerC8489k.this;
                    fM52706a0 = viewOnTouchListenerC8489k.m52706a0();
                } else {
                    viewOnTouchListenerC8489k = ViewOnTouchListenerC8489k.this;
                    fM52706a0 = viewOnTouchListenerC8489k.m52703W();
                }
                viewOnTouchListenerC8489k.m52714i(fM52706a0, x10, y10, true);
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return ViewOnTouchListenerC8489k.this.m52689A(motionEvent);
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.k$d */
    public static /* synthetic */ class d {

        /* renamed from: a */
        public static final /* synthetic */ int[] f39593a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f39593a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39593a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f39593a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f39593a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.k$e */
    public class e implements Runnable {

        /* renamed from: a */
        public final float f39594a;

        /* renamed from: b */
        public final float f39595b;

        /* renamed from: c */
        public final long f39596c = System.currentTimeMillis();

        /* renamed from: d */
        public final float f39597d;

        /* renamed from: e */
        public final float f39598e;

        public e(float f10, float f11, float f12, float f13) {
            this.f39594a = f12;
            this.f39595b = f13;
            this.f39597d = f10;
            this.f39598e = f11;
        }

        /* renamed from: a */
        public final float m52734a() {
            return ViewOnTouchListenerC8489k.this.f39572g.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.f39596c) * 1.0f) / ViewOnTouchListenerC8489k.this.f39568c));
        }

        @Override // java.lang.Runnable
        public void run() {
            float fM52734a = m52734a();
            float f10 = this.f39597d;
            ViewOnTouchListenerC8489k.this.f39589x.mo52667a((f10 + ((this.f39598e - f10) * fM52734a)) / ViewOnTouchListenerC8489k.this.m52708c0(), this.f39594a, this.f39595b);
            if (fM52734a < 1.0f) {
                C8479a.m52653a(ViewOnTouchListenerC8489k.this.f39573h, this);
            }
        }
    }

    /* renamed from: com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.k$f */
    public class f implements Runnable {

        /* renamed from: a */
        public final OverScroller f39600a;

        /* renamed from: b */
        public int f39601b;

        /* renamed from: c */
        public int f39602c;

        public f(Context context) {
            this.f39600a = new OverScroller(context);
        }

        /* renamed from: a */
        public void m52735a() {
            this.f39600a.forceFinished(true);
        }

        /* renamed from: c */
        public void m52736c(int i10, int i11, int i12, int i13) {
            int i14;
            int iRound;
            int i15;
            int iRound2;
            RectF rectFM52697N = ViewOnTouchListenerC8489k.this.m52697N();
            if (rectFM52697N == null) {
                return;
            }
            int iRound3 = Math.round(-rectFM52697N.left);
            float f10 = i10;
            if (f10 < rectFM52697N.width()) {
                iRound = Math.round(rectFM52697N.width() - f10);
                i14 = 0;
            } else {
                i14 = iRound3;
                iRound = i14;
            }
            int iRound4 = Math.round(-rectFM52697N.top);
            float f11 = i11;
            if (f11 < rectFM52697N.height()) {
                iRound2 = Math.round(rectFM52697N.height() - f11);
                i15 = 0;
            } else {
                i15 = iRound4;
                iRound2 = i15;
            }
            this.f39601b = iRound3;
            this.f39602c = iRound4;
            if (iRound3 == iRound && iRound4 == iRound2) {
                return;
            }
            this.f39600a.fling(iRound3, iRound4, i12, i13, i14, iRound, i15, iRound2, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f39600a.isFinished() && this.f39600a.computeScrollOffset()) {
                int currX = this.f39600a.getCurrX();
                int currY = this.f39600a.getCurrY();
                ViewOnTouchListenerC8489k.this.f39577l.postTranslate(this.f39601b - currX, this.f39602c - currY);
                ViewOnTouchListenerC8489k.this.m52691G();
                this.f39601b = currX;
                this.f39602c = currY;
                C8479a.m52653a(ViewOnTouchListenerC8489k.this.f39573h, this);
            }
        }
    }

    public ViewOnTouchListenerC8489k(ImageView imageView) {
        a aVar = new a();
        this.f39589x = aVar;
        this.f39573h = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.f39585t = 0.0f;
        this.f39575j = new C8480b(imageView.getContext(), aVar);
        this.f39574i = new GestureDetector(imageView.getContext(), new b());
        m52713h0();
    }

    /* renamed from: F */
    public static /* synthetic */ InterfaceC8487i m52674F(ViewOnTouchListenerC8489k viewOnTouchListenerC8489k) {
        viewOnTouchListenerC8489k.getClass();
        return null;
    }

    /* renamed from: K */
    public static /* synthetic */ InterfaceC8485g m52675K(ViewOnTouchListenerC8489k viewOnTouchListenerC8489k) {
        viewOnTouchListenerC8489k.getClass();
        return null;
    }

    /* renamed from: R */
    public static /* synthetic */ InterfaceC8486h m52677R(ViewOnTouchListenerC8489k viewOnTouchListenerC8489k) {
        viewOnTouchListenerC8489k.getClass();
        return null;
    }

    /* renamed from: A */
    public final boolean m52689A(MotionEvent motionEvent) {
        View.OnClickListener onClickListener = this.f39582q;
        if (onClickListener != null) {
            onClickListener.onClick(this.f39573h);
        }
        RectF rectFM52697N = m52697N();
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (rectFM52697N == null || !rectFM52697N.contains(x10, y10)) {
            return false;
        }
        rectFM52697N.width();
        rectFM52697N.height();
        return true;
    }

    /* renamed from: D */
    public final int m52690D(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    /* renamed from: G */
    public final void m52691G() {
        if (m52696M()) {
            m52693I(m52699Q());
        }
    }

    /* renamed from: H */
    public void m52692H(float f10) {
        C8490l.m52738b(this.f39569d, f10, this.f39571f);
        this.f39570e = f10;
    }

    /* renamed from: I */
    public final void m52693I(Matrix matrix) {
        this.f39573h.setImageMatrix(matrix);
    }

    /* renamed from: J */
    public void m52694J(boolean z10) {
        this.f39583r = z10;
        m52718k0();
    }

    /* renamed from: L */
    public void m52695L(float f10) {
        C8490l.m52738b(f10, this.f39570e, this.f39571f);
        this.f39569d = f10;
    }

    /* renamed from: M */
    public final boolean m52696M() {
        float f10;
        float f11;
        RectF rectFM52709d = m52709d(m52699Q());
        if (rectFM52709d == null) {
            return false;
        }
        float fHeight = rectFM52709d.height();
        float fWidth = rectFM52709d.width();
        float fM52707b = m52707b(this.f39573h);
        if (fHeight <= fM52707b) {
            int i10 = d.f39593a[this.f39584s.ordinal()];
            if (i10 == 3) {
                f11 = fM52707b - fHeight;
            } else if (i10 != 4) {
                f11 = (fM52707b - fHeight) / 2.0f;
            } else {
                f10 = -rectFM52709d.top;
                this.f39588w = 2;
            }
            f10 = f11 - rectFM52709d.top;
            this.f39588w = 2;
        } else {
            float f12 = rectFM52709d.top;
            if (f12 > 0.0f) {
                this.f39588w = 0;
                f10 = -f12;
            } else {
                float f13 = rectFM52709d.bottom;
                if (f13 < fM52707b) {
                    this.f39588w = 1;
                    f10 = fM52707b - f13;
                } else {
                    this.f39588w = -1;
                    f10 = 0.0f;
                }
            }
        }
        return m52733z(rectFM52709d, fWidth, 0.0f, f10);
    }

    /* renamed from: N */
    public RectF m52697N() {
        m52696M();
        return m52709d(m52699Q());
    }

    /* renamed from: P */
    public void m52698P(float f10) {
        this.f39577l.postRotate(f10 % 360.0f);
        m52691G();
    }

    /* renamed from: Q */
    public final Matrix m52699Q() {
        this.f39579n.set(this.f39578m);
        this.f39579n.postConcat(this.f39577l);
        return this.f39579n;
    }

    /* renamed from: S */
    public void m52700S(float f10) {
        this.f39577l.setRotate(f10 % 360.0f);
        m52691G();
    }

    /* renamed from: T */
    public Matrix m52701T() {
        return this.f39579n;
    }

    /* renamed from: V */
    public void m52702V(float f10) {
        m52715j(f10, false);
    }

    /* renamed from: W */
    public float m52703W() {
        return this.f39571f;
    }

    /* renamed from: Y */
    public float m52704Y() {
        return this.f39570e;
    }

    /* renamed from: a */
    public final float m52705a(Matrix matrix, int i10) {
        matrix.getValues(this.f39576k);
        return this.f39576k[i10];
    }

    /* renamed from: a0 */
    public float m52706a0() {
        return this.f39569d;
    }

    /* renamed from: b */
    public final int m52707b(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* renamed from: c0 */
    public final float m52708c0() {
        return (float) Math.sqrt(((float) Math.pow(m52705a(this.f39577l, 0), 2.0d)) + ((float) Math.pow(m52705a(this.f39577l, 3), 2.0d)));
    }

    /* renamed from: d */
    public final RectF m52709d(Matrix matrix) {
        if (this.f39573h.getDrawable() == null) {
            return null;
        }
        this.f39580o.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.f39580o);
        return this.f39580o;
    }

    /* renamed from: e0 */
    public ImageView.ScaleType m52710e0() {
        return this.f39584s;
    }

    /* renamed from: g */
    public final void m52711g() {
        f fVar = this.f39586u;
        if (fVar != null) {
            fVar.m52735a();
            this.f39586u = null;
        }
    }

    /* renamed from: h */
    public void m52712h(float f10) {
        C8490l.m52738b(this.f39569d, this.f39570e, f10);
        this.f39571f = f10;
    }

    /* renamed from: h0 */
    public final void m52713h0() {
        this.f39574i.setOnDoubleTapListener(new c());
    }

    /* renamed from: i */
    public void m52714i(float f10, float f11, float f12, boolean z10) {
        if (f10 < this.f39569d || f10 > this.f39571f) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z10) {
            this.f39573h.post(new e(m52708c0(), f10, f11, f12));
        } else {
            this.f39577l.setScale(f10, f10, f11, f12);
            m52691G();
        }
    }

    /* renamed from: j */
    public void m52715j(float f10, boolean z10) {
        m52714i(f10, this.f39573h.getRight() / 2, this.f39573h.getBottom() / 2, z10);
    }

    /* renamed from: j0 */
    public final void m52716j0() {
        this.f39577l.reset();
        m52698P(this.f39585t);
        m52693I(m52699Q());
        m52696M();
    }

    /* renamed from: k */
    public void m52717k(int i10) {
        this.f39568c = i10;
    }

    /* renamed from: k0 */
    public void m52718k0() {
        if (this.f39583r) {
            m52719l(this.f39573h.getDrawable());
        } else {
            m52716j0();
        }
    }

    /* renamed from: l */
    public final void m52719l(Drawable drawable) {
        Matrix matrix;
        Matrix.ScaleToFit scaleToFit;
        float fMin;
        if (drawable == null) {
            return;
        }
        float fM52690D = m52690D(this.f39573h);
        float fM52707b = m52707b(this.f39573h);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f39578m.reset();
        float f10 = intrinsicWidth;
        float f11 = fM52690D / f10;
        float f12 = intrinsicHeight;
        float f13 = fM52707b / f12;
        ImageView.ScaleType scaleType = this.f39584s;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.f39578m.postTranslate((fM52690D - f10) / 2.0f, (fM52707b - f12) / 2.0f);
        } else {
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                fMin = Math.max(f11, f13);
            } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
                fMin = Math.min(1.0f, Math.min(f11, f13));
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, f10, f12);
                RectF rectF2 = new RectF(0.0f, 0.0f, fM52690D, fM52707b);
                if (((int) this.f39585t) % 180 != 0) {
                    rectF = new RectF(0.0f, 0.0f, f12, f10);
                }
                int i10 = d.f39593a[this.f39584s.ordinal()];
                if (i10 == 1) {
                    matrix = this.f39578m;
                    scaleToFit = Matrix.ScaleToFit.FILL;
                } else if (i10 == 2) {
                    matrix = this.f39578m;
                    scaleToFit = Matrix.ScaleToFit.CENTER;
                } else if (i10 == 3) {
                    matrix = this.f39578m;
                    scaleToFit = Matrix.ScaleToFit.END;
                } else if (i10 == 4) {
                    matrix = this.f39578m;
                    scaleToFit = Matrix.ScaleToFit.START;
                }
                matrix.setRectToRect(rectF, rectF2, scaleToFit);
            }
            this.f39578m.postScale(fMin, fMin);
            this.f39578m.postTranslate((fM52690D - (f10 * fMin)) / 2.0f, (fM52707b - (f12 * fMin)) / 2.0f);
        }
        m52716j0();
    }

    /* renamed from: m */
    public void m52720m(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f39574i.setOnDoubleTapListener(onDoubleTapListener);
    }

    /* renamed from: n */
    public void m52721n(View.OnClickListener onClickListener) {
        this.f39582q = onClickListener;
    }

    /* renamed from: o */
    public void m52722o(View.OnLongClickListener onLongClickListener) {
        this.f39581p = onLongClickListener;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (i10 == i14 && i11 == i15 && i12 == i16 && i13 == i17) {
            return;
        }
        m52719l(this.f39573h.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b6  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r10.f39583r
            r1 = 0
            if (r0 == 0) goto Lc2
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.C8490l.m52740d(r0)
            if (r0 == 0) goto Lc2
            int r0 = r12.getAction()
            r2 = 1
            if (r0 == 0) goto L72
            if (r0 == r2) goto L22
            r3 = 3
            if (r0 == r3) goto L22
            java.lang.String r11 = "PictureViewAttaches"
            java.lang.String r0 = "MotionEvent default!!!"
            com.huawei.phoneservice.faq.base.util.FaqLogger.m51840e(r11, r0)
            goto L7e
        L22:
            float r0 = r10.m52708c0()
            float r3 = r10.f39569d
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L4c
            android.graphics.RectF r0 = r10.m52697N()
            if (r0 == 0) goto L7e
            com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.k$e r9 = new com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.k$e
            float r5 = r10.m52708c0()
            float r6 = r10.f39569d
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
        L47:
            r11.post(r9)
            r11 = r2
            goto L7f
        L4c:
            float r0 = r10.m52708c0()
            float r3 = r10.f39571f
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L7e
            android.graphics.RectF r0 = r10.m52697N()
            if (r0 == 0) goto L7e
            com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.k$e r9 = new com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.k$e
            float r5 = r10.m52708c0()
            float r6 = r10.f39571f
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            goto L47
        L72:
            android.view.ViewParent r11 = r11.getParent()
            if (r11 == 0) goto L7b
            r11.requestDisallowInterceptTouchEvent(r2)
        L7b:
            r10.m52711g()
        L7e:
            r11 = r1
        L7f:
            com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.b r0 = r10.f39575j
            if (r0 == 0) goto Lb6
            boolean r11 = r0.m52659e()
            com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.b r0 = r10.f39575j
            boolean r0 = r0.m52657c()
            com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.b r3 = r10.f39575j
            boolean r3 = r3.m52661g(r12)
            if (r11 != 0) goto L9f
            com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.b r11 = r10.f39575j
            boolean r11 = r11.m52659e()
            if (r11 != 0) goto L9f
            r11 = r2
            goto La0
        L9f:
            r11 = r1
        La0:
            if (r0 != 0) goto Lac
            com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.b r0 = r10.f39575j
            boolean r0 = r0.m52657c()
            if (r0 != 0) goto Lac
            r0 = r2
            goto Lad
        Lac:
            r0 = r1
        Lad:
            if (r11 == 0) goto Lb2
            if (r0 == 0) goto Lb2
            r1 = r2
        Lb2:
            r10.f39567b = r1
            r1 = r3
            goto Lb7
        Lb6:
            r1 = r11
        Lb7:
            android.view.GestureDetector r10 = r10.f39574i
            if (r10 == 0) goto Lc2
            boolean r10 = r10.onTouchEvent(r12)
            if (r10 == 0) goto Lc2
            r1 = r2
        Lc2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.ViewOnTouchListenerC8489k.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    /* renamed from: p */
    public void m52723p(ImageView.ScaleType scaleType) {
        if (!C8490l.m52739c(scaleType) || scaleType == this.f39584s) {
            return;
        }
        this.f39584s = scaleType;
        m52718k0();
    }

    /* renamed from: q */
    public void m52724q(InterfaceC8482d interfaceC8482d) {
    }

    /* renamed from: r */
    public void m52725r(InterfaceC8483e interfaceC8483e) {
    }

    /* renamed from: s */
    public void m52726s(InterfaceC8484f interfaceC8484f) {
    }

    /* renamed from: t */
    public void m52727t(InterfaceC8485g interfaceC8485g) {
    }

    /* renamed from: u */
    public void m52728u(InterfaceC8486h interfaceC8486h) {
    }

    /* renamed from: v */
    public void m52729v(InterfaceC8487i interfaceC8487i) {
    }

    /* renamed from: w */
    public void m52730w(InterfaceC8488j interfaceC8488j) {
    }

    /* renamed from: x */
    public void m52731x(boolean z10) {
        this.f39566a = z10;
    }

    /* renamed from: y */
    public final boolean m52732y(float f10, float f11) {
        if (!this.f39566a || this.f39575j.m52659e() || this.f39567b) {
            return true;
        }
        int i10 = this.f39587v;
        boolean z10 = i10 != 2;
        if (i10 == 0 && f10 >= 1.0f) {
            z10 = false;
        }
        if (i10 == 1 && f10 <= -1.0f) {
            z10 = false;
        }
        int i11 = this.f39588w;
        if (i11 == 0 && f11 >= 1.0f) {
            z10 = false;
        }
        if (i11 != 1 || f11 > -1.0f) {
            return z10;
        }
        return false;
    }

    /* renamed from: z */
    public final boolean m52733z(RectF rectF, float f10, float f11, float f12) {
        int i10;
        float f13;
        float fM52690D = m52690D(this.f39573h);
        if (f10 > fM52690D) {
            float f14 = rectF.left;
            if (f14 > 0.0f) {
                this.f39587v = 0;
                f11 = -f14;
            } else {
                float f15 = rectF.right;
                if (f15 < fM52690D) {
                    f11 = fM52690D - f15;
                    this.f39587v = 1;
                } else {
                    i10 = -1;
                }
            }
            this.f39577l.postTranslate(f11, f12);
            return true;
        }
        int i11 = d.f39593a[this.f39584s.ordinal()];
        if (i11 == 3) {
            f13 = fM52690D - f10;
        } else if (i11 != 4) {
            f13 = (fM52690D - f10) / 2.0f;
        } else {
            f11 = -rectF.left;
            i10 = 2;
        }
        f11 = f13 - rectF.left;
        i10 = 2;
        this.f39587v = i10;
        this.f39577l.postTranslate(f11, f12);
        return true;
    }
}
