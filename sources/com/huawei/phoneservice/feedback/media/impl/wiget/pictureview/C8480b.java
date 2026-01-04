package com.huawei.phoneservice.feedback.media.impl.wiget.pictureview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.huawei.phoneservice.faq.base.util.FaqLogger;
import com.huawei.uikit.hwadvancednumberpicker.utils.HwConstants;

/* renamed from: com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.b */
/* loaded from: classes5.dex */
public class C8480b {

    /* renamed from: a */
    public int f39553a = -1;

    /* renamed from: b */
    public int f39554b = 0;

    /* renamed from: c */
    public final ScaleGestureDetector f39555c;

    /* renamed from: d */
    public VelocityTracker f39556d;

    /* renamed from: e */
    public final float f39557e;

    /* renamed from: f */
    public final float f39558f;

    /* renamed from: g */
    public boolean f39559g;

    /* renamed from: h */
    public float f39560h;

    /* renamed from: i */
    public float f39561i;

    /* renamed from: j */
    public final InterfaceC8481c f39562j;

    /* renamed from: com.huawei.phoneservice.feedback.media.impl.wiget.pictureview.b$a */
    public class a implements ScaleGestureDetector.OnScaleGestureListener {

        /* renamed from: a */
        public float f39563a;

        /* renamed from: b */
        public float f39564b = 0.0f;

        public a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            if (scaleFactor < 0.0f) {
                return true;
            }
            C8480b.this.f39562j.mo52668a(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), scaleGestureDetector.getFocusX() - this.f39563a, scaleGestureDetector.getFocusY() - this.f39564b);
            this.f39563a = scaleGestureDetector.getFocusX();
            this.f39564b = scaleGestureDetector.getFocusY();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.f39563a = scaleGestureDetector.getFocusX();
            this.f39564b = scaleGestureDetector.getFocusY();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public C8480b(Context context, InterfaceC8481c interfaceC8481c) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f39558f = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f39557e = viewConfiguration.getScaledTouchSlop();
        this.f39562j = interfaceC8481c;
        this.f39555c = new ScaleGestureDetector(context, new a());
    }

    /* renamed from: a */
    public final float m52656a(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f39554b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    /* renamed from: c */
    public boolean m52657c() {
        return this.f39559g;
    }

    /* renamed from: d */
    public final float m52658d(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f39554b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    /* renamed from: e */
    public boolean m52659e() {
        return this.f39555c.isInProgress();
    }

    /* renamed from: f */
    public final void m52660f() {
        this.f39553a = -1;
        VelocityTracker velocityTracker = this.f39556d;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f39556d = null;
        }
    }

    /* renamed from: g */
    public boolean m52661g(MotionEvent motionEvent) {
        try {
            this.f39555c.onTouchEvent(motionEvent);
            return m52662h(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    /* renamed from: h */
    public final boolean m52662h(MotionEvent motionEvent) throws Throwable {
        int action = motionEvent.getAction() & HwConstants.SELECTOR_WHEEL_BRIGHT_ALPHA;
        if (action == 0) {
            m52663i(motionEvent);
        } else if (action == 1) {
            m52666l(motionEvent);
        } else if (action == 2) {
            m52664j(motionEvent);
        } else if (action == 3) {
            m52660f();
        } else if (action != 6) {
            FaqLogger.m51840e("GestureDetector", "processTouchEvent default!!!");
        } else {
            m52665k(motionEvent);
        }
        int i10 = this.f39553a;
        if (i10 == -1) {
            i10 = 0;
        }
        this.f39554b = motionEvent.findPointerIndex(i10);
        return true;
    }

    /* renamed from: i */
    public final void m52663i(MotionEvent motionEvent) {
        this.f39553a = motionEvent.getPointerId(0);
        VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
        this.f39556d = velocityTrackerObtain;
        if (velocityTrackerObtain != null) {
            velocityTrackerObtain.addMovement(motionEvent);
        }
        this.f39560h = m52656a(motionEvent);
        this.f39561i = m52658d(motionEvent);
        this.f39559g = false;
    }

    /* renamed from: j */
    public final void m52664j(MotionEvent motionEvent) {
        float fM52656a = m52656a(motionEvent);
        float fM52658d = m52658d(motionEvent);
        float f10 = fM52656a - this.f39560h;
        float f11 = fM52658d - this.f39561i;
        if (!this.f39559g) {
            this.f39559g = Math.sqrt((double) ((f10 * f10) + (f11 * f11))) >= ((double) this.f39557e);
        }
        if (this.f39559g) {
            this.f39562j.mo52669b(f10, f11);
            this.f39560h = fM52656a;
            this.f39561i = fM52658d;
            VelocityTracker velocityTracker = this.f39556d;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }
    }

    /* renamed from: k */
    public final void m52665k(MotionEvent motionEvent) {
        int iM52737a = C8490l.m52737a(motionEvent.getAction());
        if (motionEvent.getPointerId(iM52737a) == this.f39553a) {
            int i10 = iM52737a == 0 ? 1 : 0;
            this.f39553a = motionEvent.getPointerId(i10);
            this.f39560h = motionEvent.getX(i10);
            this.f39561i = motionEvent.getY(i10);
        }
    }

    /* renamed from: l */
    public final void m52666l(MotionEvent motionEvent) {
        this.f39553a = -1;
        if (this.f39559g && this.f39556d != null) {
            this.f39560h = m52656a(motionEvent);
            this.f39561i = m52658d(motionEvent);
            this.f39556d.addMovement(motionEvent);
            this.f39556d.computeCurrentVelocity(1000);
            float xVelocity = this.f39556d.getXVelocity();
            float yVelocity = this.f39556d.getYVelocity();
            if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f39558f) {
                this.f39562j.mo52670c(this.f39560h, this.f39561i, -xVelocity, -yVelocity);
            }
        }
        VelocityTracker velocityTracker = this.f39556d;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f39556d = null;
        }
    }
}
