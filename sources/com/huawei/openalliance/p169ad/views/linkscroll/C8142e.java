package com.huawei.openalliance.p169ad.views.linkscroll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebView;
import android.widget.Scroller;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;

/* renamed from: com.huawei.openalliance.ad.views.linkscroll.e */
/* loaded from: classes2.dex */
public class C8142e extends WebView implements InterfaceC8138a {

    /* renamed from: a */
    private int f37954a;

    /* renamed from: b */
    private final int[] f37955b;

    /* renamed from: c */
    private final int[] f37956c;

    /* renamed from: d */
    private int f37957d;

    /* renamed from: e */
    private C8140c f37958e;

    /* renamed from: f */
    private VelocityTracker f37959f;

    /* renamed from: g */
    private int f37960g;

    /* renamed from: h */
    private int f37961h;

    /* renamed from: i */
    private RectF f37962i;

    /* renamed from: j */
    private Paint f37963j;

    /* renamed from: k */
    private float[] f37964k;

    /* renamed from: l */
    private int f37965l;

    /* renamed from: m */
    private int f37966m;

    /* renamed from: n */
    private boolean f37967n;

    /* renamed from: o */
    private Scroller f37968o;

    /* renamed from: p */
    private a f37969p;

    /* renamed from: q */
    private int f37970q;

    /* renamed from: com.huawei.openalliance.ad.views.linkscroll.e$a */
    public interface a {
        /* renamed from: a */
        void mo50352a(View view);
    }

    public C8142e(Context context) {
        super(context);
        this.f37955b = new int[2];
        this.f37956c = new int[2];
        this.f37970q = -1;
        m50369a(context);
    }

    /* renamed from: b */
    private void m50370b() {
        AbstractC7185ho.m43817a("LinkScrollWebView", "abortFlingScroll");
        Scroller scroller = this.f37968o;
        if (scroller != null) {
            scroller.abortAnimation();
        }
    }

    /* renamed from: c */
    private void m50371c() {
        VelocityTracker velocityTracker = this.f37959f;
        if (velocityTracker == null) {
            this.f37959f = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    /* renamed from: d */
    private void m50373d() {
        if (this.f37959f == null) {
            this.f37959f = VelocityTracker.obtain();
        }
    }

    /* renamed from: e */
    private void m50374e() {
        VelocityTracker velocityTracker = this.f37959f;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f37959f = null;
        }
    }

    /* renamed from: a */
    public int m50375a(MotionEvent motionEvent) {
        return motionEvent.getAction() & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
    }

    @Override // android.webkit.WebView, android.view.View
    public void computeScroll() {
        Scroller scroller = this.f37968o;
        if (scroller == null || !scroller.computeScrollOffset()) {
            return;
        }
        scrollTo(0, this.f37968o.getCurrY());
        invalidate();
    }

    @Override // android.webkit.WebView
    public void destroy() {
        super.destroy();
        this.f37958e = null;
        this.f37969p = null;
        this.f37968o = null;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f37967n) {
            Path path = new Path();
            path.setFillType(Path.FillType.INVERSE_WINDING);
            this.f37962i.set(getScrollX(), getScrollY(), getScrollX() + this.f37965l, getScrollY() + this.f37966m);
            path.addRoundRect(this.f37962i, this.f37964k, Path.Direction.CW);
            canvas.drawPath(path, this.f37963j);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        a aVar;
        super.onScrollChanged(i10, i11, i12, i13);
        if (canScrollVertically(-1) || (aVar = this.f37969p) == null) {
            return;
        }
        aVar.mo50352a(this);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f37965l = i10;
        this.f37966m = i11;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEventObtain;
        int iM50375a;
        int y10;
        try {
            motionEventObtain = MotionEvent.obtain(motionEvent);
            iM50375a = m50375a(motionEvent);
            if (iM50375a == 0) {
                this.f37957d = 0;
                m50370b();
            }
            y10 = (int) motionEvent.getY();
            motionEvent.offsetLocation(0.0f, this.f37957d);
        } catch (Throwable th2) {
            AbstractC7185ho.m43824c("LinkScrollWebView", "onTouch error: %s", th2.getClass().getSimpleName());
        }
        if (iM50375a == 0) {
            this.f37970q = getScrollY();
            this.f37954a = y10;
            m50381b(2);
            m50371c();
            this.f37959f.addMovement(motionEvent);
            return super.onTouchEvent(motionEvent);
        }
        boolean z10 = true;
        if (iM50375a == 2) {
            m50373d();
            this.f37959f.addMovement(motionEvent);
            int i10 = this.f37954a - y10;
            int scrollY = getScrollY();
            if (m50380a(0, i10, this.f37956c, this.f37955b)) {
                i10 -= this.f37956c[1];
                motionEventObtain.offsetLocation(0.0f, this.f37955b[1]);
                this.f37957d += this.f37955b[1];
            }
            this.f37954a = y10 - this.f37955b[1];
            int iMax = Math.max(0, scrollY + i10);
            int i11 = i10 - (iMax - scrollY);
            if (m50379a(0, iMax - i11, 0, i11, this.f37955b)) {
                int i12 = this.f37954a;
                int i13 = this.f37955b[1];
                this.f37954a = i12 - i13;
                motionEventObtain.offsetLocation(0.0f, i13);
                this.f37957d += this.f37955b[1];
            }
            if (this.f37956c[1] == 0 && this.f37955b[1] == 0) {
                motionEventObtain.recycle();
                return super.onTouchEvent(motionEventObtain);
            }
        } else if (m50372c(iM50375a)) {
            if (this.f37970q != getScrollY()) {
                z10 = false;
            }
            m50373d();
            this.f37959f.addMovement(motionEvent);
            this.f37959f.computeCurrentVelocity(1000, this.f37960g);
            int yVelocity = (int) this.f37959f.getYVelocity();
            m50374e();
            if (Math.abs(yVelocity) > this.f37961h) {
                m50368a(-yVelocity, z10);
            }
            m50376a();
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setLinkScrollEnabled(boolean z10) {
        C8140c c8140c = this.f37958e;
        if (c8140c != null) {
            c8140c.m50354a(z10);
        }
    }

    public void setRadiusArray(float[] fArr) {
        this.f37964k = fArr;
    }

    public void setScrollListener(a aVar) {
        this.f37969p = aVar;
    }

    public void setSupportWebViewRadius(boolean z10) {
        this.f37967n = z10;
    }

    /* renamed from: c */
    private boolean m50372c(int i10) {
        return i10 == 5 || i10 == 1 || i10 == 3;
    }

    /* renamed from: a */
    public void m50376a() {
        C8140c c8140c = this.f37958e;
        if (c8140c != null) {
            c8140c.m50361c();
        }
    }

    /* renamed from: b */
    public boolean m50381b(int i10) {
        C8140c c8140c = this.f37958e;
        if (c8140c != null) {
            return c8140c.m50357a(i10);
        }
        return false;
    }

    /* renamed from: a */
    public void m50377a(int i10) {
        AbstractC7185ho.m43817a("LinkScrollWebView", "flingScroll");
        Scroller scroller = this.f37968o;
        if (scroller != null) {
            scroller.fling(0, getScrollY(), 0, i10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        invalidate();
    }

    /* renamed from: a */
    private void m50368a(int i10, boolean z10) {
        if (z10) {
            AbstractC7185ho.m43820b("LinkScrollWebView", "webview inner scroll");
        }
        if (m50378a(0.0f, i10) || z10) {
            return;
        }
        m50377a(i10);
    }

    /* renamed from: a */
    private void m50369a(Context context) {
        this.f37958e = new C8140c(this);
        setLinkScrollEnabled(true);
        this.f37968o = new Scroller(getContext());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f37960g = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f37961h = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f37970q = getScrollY();
        this.f37962i = new RectF();
        Paint paint = new Paint();
        this.f37963j = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f37963j.setAntiAlias(true);
        this.f37963j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    /* renamed from: a */
    public boolean m50378a(float f10, float f11) {
        C8140c c8140c = this.f37958e;
        if (c8140c != null) {
            return c8140c.m50356a(f10, f11);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m50379a(int i10, int i11, int i12, int i13, int[] iArr) {
        C8140c c8140c = this.f37958e;
        if (c8140c != null) {
            return c8140c.m50358a(i10, i11, i12, i13, iArr);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m50380a(int i10, int i11, int[] iArr, int[] iArr2) {
        C8140c c8140c = this.f37958e;
        if (c8140c != null) {
            return c8140c.m50359a(i10, i11, iArr, iArr2);
        }
        return false;
    }
}
