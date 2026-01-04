package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.InterfaceC0417n;

/* renamed from: androidx.appcompat.widget.u */
/* loaded from: classes.dex */
public abstract class AbstractViewOnTouchListenerC0546u implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a */
    public final float f2415a;

    /* renamed from: b */
    public final int f2416b;

    /* renamed from: c */
    public final int f2417c;

    /* renamed from: d */
    public final View f2418d;

    /* renamed from: e */
    public Runnable f2419e;

    /* renamed from: f */
    public Runnable f2420f;

    /* renamed from: g */
    public boolean f2421g;

    /* renamed from: h */
    public int f2422h;

    /* renamed from: i */
    public final int[] f2423i = new int[2];

    /* renamed from: androidx.appcompat.widget.u$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = AbstractViewOnTouchListenerC0546u.this.f2418d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.u$b */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractViewOnTouchListenerC0546u.this.m3149e();
        }
    }

    public AbstractViewOnTouchListenerC0546u(View view) {
        this.f2418d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f2415a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f2416b = tapTimeout;
        this.f2417c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    /* renamed from: h */
    public static boolean m3147h(View view, float f10, float f11, float f12) {
        float f13 = -f12;
        return f10 >= f13 && f11 >= f13 && f10 < ((float) (view.getRight() - view.getLeft())) + f12 && f11 < ((float) (view.getBottom() - view.getTop())) + f12;
    }

    /* renamed from: a */
    public final void m3148a() {
        Runnable runnable = this.f2420f;
        if (runnable != null) {
            this.f2418d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f2419e;
        if (runnable2 != null) {
            this.f2418d.removeCallbacks(runnable2);
        }
    }

    /* renamed from: b */
    public abstract InterfaceC0417n mo2324b();

    /* renamed from: c */
    public abstract boolean mo2325c();

    /* renamed from: d */
    public boolean mo2582d() {
        InterfaceC0417n interfaceC0417nMo2324b = mo2324b();
        if (interfaceC0417nMo2324b == null || !interfaceC0417nMo2324b.isShowing()) {
            return true;
        }
        interfaceC0417nMo2324b.dismiss();
        return true;
    }

    /* renamed from: e */
    public void m3149e() {
        m3148a();
        View view = this.f2418d;
        if (view.isEnabled() && !view.isLongClickable() && mo2325c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f2421g = true;
        }
    }

    /* renamed from: f */
    public final boolean m3150f(MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException {
        DropDownListView dropDownListView;
        View view = this.f2418d;
        InterfaceC0417n interfaceC0417nMo2324b = mo2324b();
        if (interfaceC0417nMo2324b == null || !interfaceC0417nMo2324b.isShowing() || (dropDownListView = (DropDownListView) interfaceC0417nMo2324b.getListView()) == null || !dropDownListView.isShown()) {
            return false;
        }
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        m3152i(view, motionEventObtainNoHistory);
        m3153j(dropDownListView, motionEventObtainNoHistory);
        boolean zMo2683e = dropDownListView.mo2683e(motionEventObtainNoHistory, this.f2422h);
        motionEventObtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return zMo2683e && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m3151g(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f2418d
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L41
            r3 = 1
            if (r1 == r3) goto L3d
            r4 = 2
            if (r1 == r4) goto L1a
            r6 = 3
            if (r1 == r6) goto L3d
            goto L6d
        L1a:
            int r1 = r5.f2422h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f2415a
            boolean r6 = m3147h(r0, r4, r6, r1)
            if (r6 != 0) goto L6d
            r5.m3148a()
            android.view.ViewParent r5 = r0.getParent()
            r5.requestDisallowInterceptTouchEvent(r3)
            return r3
        L3d:
            r5.m3148a()
            goto L6d
        L41:
            int r6 = r6.getPointerId(r2)
            r5.f2422h = r6
            java.lang.Runnable r6 = r5.f2419e
            if (r6 != 0) goto L52
            androidx.appcompat.widget.u$a r6 = new androidx.appcompat.widget.u$a
            r6.<init>()
            r5.f2419e = r6
        L52:
            java.lang.Runnable r6 = r5.f2419e
            int r1 = r5.f2416b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f2420f
            if (r6 != 0) goto L65
            androidx.appcompat.widget.u$b r6 = new androidx.appcompat.widget.u$b
            r6.<init>()
            r5.f2420f = r6
        L65:
            java.lang.Runnable r6 = r5.f2420f
            int r5 = r5.f2417c
            long r3 = (long) r5
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AbstractViewOnTouchListenerC0546u.m3151g(android.view.MotionEvent):boolean");
    }

    /* renamed from: i */
    public final boolean m3152i(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f2423i);
        motionEvent.offsetLocation(r1[0], r1[1]);
        return true;
    }

    /* renamed from: j */
    public final boolean m3153j(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f2423i);
        motionEvent.offsetLocation(-r1[0], -r1[1]);
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z10;
        boolean z11 = this.f2421g;
        if (z11) {
            z10 = m3150f(motionEvent) || !mo2582d();
        } else {
            z10 = m3151g(motionEvent) && mo2325c();
            if (z10) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f2418d.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f2421g = z10;
        return z10 || z11;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f2421g = false;
        this.f2422h = -1;
        Runnable runnable = this.f2419e;
        if (runnable != null) {
            this.f2418d.removeCallbacks(runnable);
        }
    }
}
