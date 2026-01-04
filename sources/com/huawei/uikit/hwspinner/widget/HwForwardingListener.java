package com.huawei.uikit.hwspinner.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.InterfaceC0417n;
import com.huawei.uikit.hwcommon.utils.HwReflectUtil;

/* loaded from: classes5.dex */
public abstract class HwForwardingListener implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: h */
    private static final int f44113h = 2;

    /* renamed from: a */
    private final float f44114a;

    /* renamed from: b */
    private final int f44115b;

    /* renamed from: c */
    private final int f44116c;

    /* renamed from: d */
    private final View f44117d;

    /* renamed from: e */
    private Runnable f44118e;

    /* renamed from: f */
    private Runnable f44119f;

    /* renamed from: g */
    private int f44120g;
    protected boolean mIstransmitting;

    public class aauaf implements Runnable {
        private aauaf() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = HwForwardingListener.this.f44117d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    public class bqmxo implements Runnable {
        private bqmxo() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HwForwardingListener.this.m55494b();
        }
    }

    public HwForwardingListener(View view) {
        this.f44117d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f44114a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f44115b = tapTimeout;
        this.f44116c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public abstract InterfaceC0417n getPopup();

    public boolean onForwardingStarted() {
        InterfaceC0417n popup = getPopup();
        if (popup == null || popup.isShowing()) {
            return true;
        }
        popup.show();
        return true;
    }

    public boolean onForwardingStopped() {
        InterfaceC0417n popup = getPopup();
        if (popup == null || !popup.isShowing()) {
            return true;
        }
        popup.dismiss();
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z10;
        boolean z11 = this.mIstransmitting;
        if (z11) {
            z10 = m55493a(motionEvent) || !onForwardingStopped();
        } else {
            z10 = m55496b(motionEvent) && onForwardingStarted();
            if (z10) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f44117d.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.mIstransmitting = z10;
        return z10 || z11;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.mIstransmitting = false;
        this.f44120g = -1;
        Runnable runnable = this.f44118e;
        if (runnable != null) {
            this.f44117d.removeCallbacks(runnable);
        }
    }

    /* renamed from: a */
    private void m55492a() {
        Runnable runnable = this.f44119f;
        if (runnable != null) {
            this.f44117d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f44118e;
        if (runnable2 != null) {
            this.f44117d.removeCallbacks(runnable2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m55496b(android.view.MotionEvent r7) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        /*
            r6 = this;
            android.view.View r0 = r6.f44117d
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            int r1 = r7.getActionMasked()
            if (r1 == 0) goto L66
            r3 = 1
            if (r1 == r3) goto L62
            r4 = 2
            if (r1 == r4) goto L1b
            r7 = 3
            if (r1 == r7) goto L62
            goto L93
        L1b:
            int r1 = r6.f44120g
            int r1 = r7.findPointerIndex(r1)
            if (r1 < 0) goto L93
            float r4 = r7.getX(r1)
            float r7 = r7.getY(r1)
            java.lang.Class r1 = java.lang.Float.TYPE
            java.lang.Class[] r1 = new java.lang.Class[]{r1, r1, r1}
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            float r5 = r6.f44114a
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            java.lang.Object[] r7 = new java.lang.Object[]{r4, r7, r5}
            java.lang.String r4 = "pointInView"
            java.lang.Class<android.view.View> r5 = android.view.View.class
            java.lang.Object r7 = com.huawei.uikit.hwcommon.utils.HwReflectUtil.callMethod(r0, r4, r1, r7, r5)
            boolean r1 = r7 instanceof java.lang.Boolean
            if (r1 == 0) goto L57
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L93
        L57:
            r6.m55492a()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L62:
            r6.m55492a()
            goto L93
        L66:
            int r7 = r7.getPointerId(r2)
            r6.f44120g = r7
            java.lang.Runnable r7 = r6.f44118e
            r1 = 0
            if (r7 != 0) goto L78
            com.huawei.uikit.hwspinner.widget.HwForwardingListener$aauaf r7 = new com.huawei.uikit.hwspinner.widget.HwForwardingListener$aauaf
            r7.<init>()
            r6.f44118e = r7
        L78:
            java.lang.Runnable r7 = r6.f44118e
            int r3 = r6.f44115b
            long r3 = (long) r3
            r0.postDelayed(r7, r3)
            java.lang.Runnable r7 = r6.f44119f
            if (r7 != 0) goto L8b
            com.huawei.uikit.hwspinner.widget.HwForwardingListener$bqmxo r7 = new com.huawei.uikit.hwspinner.widget.HwForwardingListener$bqmxo
            r7.<init>()
            r6.f44119f = r7
        L8b:
            java.lang.Runnable r7 = r6.f44119f
            int r6 = r6.f44116c
            long r3 = (long) r6
            r0.postDelayed(r7, r3)
        L93:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.uikit.hwspinner.widget.HwForwardingListener.m55496b(android.view.MotionEvent):boolean");
    }

    /* renamed from: a */
    private boolean m55493a(MotionEvent motionEvent) throws NoSuchFieldException, NoSuchMethodException, SecurityException {
        HwDropDownListView hwDropDownListView;
        InterfaceC0417n popup = getPopup();
        if (popup == null || !popup.isShowing() || !(popup.getListView() instanceof HwDropDownListView) || (hwDropDownListView = (HwDropDownListView) popup.getListView()) == null || !hwDropDownListView.isShown()) {
            return false;
        }
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        HwReflectUtil.callMethod(this.f44117d, "toGlobalMotionEvent", new Class[]{MotionEvent.class}, new Object[]{motionEventObtainNoHistory}, View.class);
        HwReflectUtil.callMethod(hwDropDownListView, "toLocalMotionEvent", new Class[]{MotionEvent.class}, new Object[]{motionEventObtainNoHistory}, View.class);
        boolean zOnForwardedEvent = hwDropDownListView.onForwardedEvent(motionEventObtainNoHistory, this.f44120g);
        motionEventObtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return zOnForwardedEvent && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m55494b() {
        m55492a();
        View view = this.f44117d;
        if (view.isEnabled() && !view.isLongClickable() && onForwardingStarted()) {
            if (view.getParent() != null) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.mIstransmitting = true;
        }
    }
}
