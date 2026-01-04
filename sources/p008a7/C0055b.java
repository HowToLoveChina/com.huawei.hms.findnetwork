package p008a7;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;

/* renamed from: a7.b */
/* loaded from: classes2.dex */
public class C0055b {

    /* renamed from: a */
    public int f182a = -1;

    /* renamed from: b */
    public int f183b = 0;

    /* renamed from: c */
    public final ScaleGestureDetector f184c;

    /* renamed from: d */
    public VelocityTracker f185d;

    /* renamed from: e */
    public boolean f186e;

    /* renamed from: f */
    public float f187f;

    /* renamed from: g */
    public float f188g;

    /* renamed from: h */
    public final float f189h;

    /* renamed from: i */
    public final float f190i;

    /* renamed from: j */
    public InterfaceC0059f f191j;

    /* renamed from: a7.b$a */
    public class a implements ScaleGestureDetector.OnScaleGestureListener {
        public a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            C0055b.this.f191j.mo405a(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public C0055b(Context context, InterfaceC0059f interfaceC0059f) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f190i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f189h = viewConfiguration.getScaledTouchSlop();
        this.f191j = interfaceC0059f;
        this.f184c = new ScaleGestureDetector(context, new a());
    }

    /* renamed from: g */
    public static int m386g(int i10) {
        return (i10 & 65280) >> 8;
    }

    /* renamed from: b */
    public final void m387b(MotionEvent motionEvent) {
        int iM386g = m386g(motionEvent.getAction());
        if (motionEvent.getPointerId(iM386g) == this.f182a) {
            int i10 = iM386g == 0 ? 1 : 0;
            this.f182a = motionEvent.getPointerId(i10);
            this.f187f = motionEvent.getX(i10);
            this.f188g = motionEvent.getY(i10);
        }
    }

    /* renamed from: c */
    public final void m388c(MotionEvent motionEvent) {
        this.f182a = -1;
        if (this.f186e && this.f185d != null) {
            this.f187f = m390e(motionEvent);
            this.f188g = m391f(motionEvent);
            this.f185d.addMovement(motionEvent);
            this.f185d.computeCurrentVelocity(1000);
            float xVelocity = this.f185d.getXVelocity();
            float yVelocity = this.f185d.getYVelocity();
            if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f190i) {
                this.f191j.mo406b(this.f187f, this.f188g, -xVelocity, -yVelocity);
            }
        }
        VelocityTracker velocityTracker = this.f185d;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f185d = null;
        }
    }

    /* renamed from: d */
    public final boolean m389d(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
        if (action == 0) {
            this.f182a = motionEvent.getPointerId(0);
            VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
            this.f185d = velocityTrackerObtain;
            if (velocityTrackerObtain != null) {
                velocityTrackerObtain.addMovement(motionEvent);
            }
            this.f187f = m390e(motionEvent);
            this.f188g = m391f(motionEvent);
            this.f186e = false;
        } else if (action == 1) {
            m388c(motionEvent);
        } else if (action == 2) {
            float fM390e = m390e(motionEvent);
            float fM391f = m391f(motionEvent);
            float f10 = fM390e - this.f187f;
            float f11 = fM391f - this.f188g;
            if (!this.f186e) {
                this.f186e = Math.sqrt((double) ((f10 * f10) + (f11 * f11))) >= ((double) this.f189h);
            }
            if (this.f186e) {
                this.f191j.mo407c(f10, f11);
                this.f187f = fM390e;
                this.f188g = fM391f;
                VelocityTracker velocityTracker = this.f185d;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.f182a = -1;
            VelocityTracker velocityTracker2 = this.f185d;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f185d = null;
            }
        } else if (action == 6) {
            m387b(motionEvent);
        }
        int i10 = this.f182a;
        this.f183b = motionEvent.findPointerIndex(i10 != -1 ? i10 : 0);
        return true;
    }

    /* renamed from: e */
    public final float m390e(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f183b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    /* renamed from: f */
    public final float m391f(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f183b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    /* renamed from: h */
    public boolean m392h() {
        return this.f186e;
    }

    /* renamed from: i */
    public boolean m393i() {
        return this.f184c.isInProgress();
    }

    /* renamed from: j */
    public boolean m394j(MotionEvent motionEvent) {
        try {
            this.f184c.onTouchEvent(motionEvent);
            return m389d(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }
}
