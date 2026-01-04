package com.huawei.uikit.hwunifiedinteract.widget;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;

/* loaded from: classes5.dex */
public class HwRotaryEventTracker {

    /* renamed from: h */
    private static final String f44570h = "HwRotaryEventTracker";

    /* renamed from: i */
    private static final int f44571i = 8;

    /* renamed from: j */
    private static final long f44572j = 50;

    /* renamed from: k */
    private static final int f44573k = 2;

    /* renamed from: l */
    private static final long f44574l = -1;

    /* renamed from: m */
    private static final int f44575m = 1000;

    /* renamed from: c */
    private OnRotaryListener f44578c;

    /* renamed from: d */
    private View f44579d;

    /* renamed from: e */
    private MotionEvent f44580e;

    /* renamed from: f */
    private MotionEvent f44581f;

    /* renamed from: a */
    private long f44576a = -1;

    /* renamed from: b */
    private aauaf f44577b = new aauaf();

    /* renamed from: g */
    private float f44582g = 0.0f;

    public interface OnRotaryListener {
        boolean onBeginScroll(MotionEvent motionEvent);

        boolean onEndScroll(MotionEvent motionEvent);

        boolean onMiddleScroll(MotionEvent motionEvent);
    }

    public class aauaf implements Runnable {

        /* renamed from: a */
        private OnRotaryListener f44583a;

        private aauaf() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            HwRotaryEventTracker.this.m55767b(null, this.f44583a);
        }
    }

    public HwRotaryEventTracker(Context context) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m55767b(MotionEvent motionEvent, OnRotaryListener onRotaryListener) throws Throwable {
        MotionEvent motionEvent2;
        this.f44576a = -1L;
        this.f44579d.removeCallbacks(this.f44577b);
        try {
            if (motionEvent != null) {
                boolean zOnEndScroll = onRotaryListener.onEndScroll(motionEvent);
                MotionEvent motionEvent3 = this.f44580e;
                if (motionEvent3 != null) {
                    motionEvent3.recycle();
                    this.f44580e = null;
                }
                MotionEvent motionEvent4 = this.f44581f;
                if (motionEvent4 != null) {
                    motionEvent4.recycle();
                    this.f44581f = null;
                }
                return zOnEndScroll;
            }
            MotionEvent motionEvent5 = this.f44580e;
            float f10 = 0.0f;
            try {
                if (motionEvent5 != null && this.f44581f != null) {
                    float axisValue = motionEvent5.getAxisValue(26);
                    float axisValue2 = this.f44581f.getAxisValue(26);
                    float eventTime = this.f44580e.getEventTime();
                    float eventTime2 = this.f44581f.getEventTime();
                    float f11 = (axisValue * axisValue2 < 0.0f || Float.compare(eventTime, eventTime2) >= 0) ? 0.0f : (((axisValue2 - axisValue) / (eventTime2 - eventTime)) * 50.0f) + axisValue2;
                    if (axisValue2 * f11 >= 0.0f) {
                        f10 = f11;
                    }
                    MotionEvent motionEventM55763a = m55763a(f10);
                    boolean zOnEndScroll2 = onRotaryListener.onEndScroll(motionEventM55763a);
                    MotionEvent motionEvent6 = this.f44580e;
                    if (motionEvent6 != null) {
                        motionEvent6.recycle();
                        this.f44580e = null;
                    }
                    MotionEvent motionEvent7 = this.f44581f;
                    if (motionEvent7 != null) {
                        motionEvent7.recycle();
                        this.f44581f = null;
                    }
                    if (motionEventM55763a != null) {
                        motionEventM55763a.recycle();
                    }
                    return zOnEndScroll2;
                }
                if (motionEvent5 != null || this.f44581f == null) {
                    Log.e(f44570h, "onEnd: event is null");
                    MotionEvent motionEvent8 = this.f44580e;
                    if (motionEvent8 != null) {
                        motionEvent8.recycle();
                        this.f44580e = null;
                    }
                    MotionEvent motionEvent9 = this.f44581f;
                    if (motionEvent9 == null) {
                        return false;
                    }
                    motionEvent9.recycle();
                    this.f44581f = null;
                    return false;
                }
                MotionEvent motionEventM55763a2 = m55763a(0.0f);
                boolean zOnEndScroll3 = onRotaryListener.onEndScroll(motionEventM55763a2);
                MotionEvent motionEvent10 = this.f44580e;
                if (motionEvent10 != null) {
                    motionEvent10.recycle();
                    this.f44580e = null;
                }
                MotionEvent motionEvent11 = this.f44581f;
                if (motionEvent11 != null) {
                    motionEvent11.recycle();
                    this.f44581f = null;
                }
                if (motionEventM55763a2 != null) {
                    motionEventM55763a2.recycle();
                }
                return zOnEndScroll3;
            } catch (Throwable th2) {
                motionEvent2 = motionEvent5;
                th = th2;
                MotionEvent motionEvent12 = this.f44580e;
                if (motionEvent12 != null) {
                    motionEvent12.recycle();
                    this.f44580e = null;
                }
                MotionEvent motionEvent13 = this.f44581f;
                if (motionEvent13 != null) {
                    motionEvent13.recycle();
                    this.f44581f = null;
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            motionEvent2 = null;
        }
    }

    /* renamed from: c */
    private boolean m55768c(MotionEvent motionEvent, OnRotaryListener onRotaryListener) {
        m55764a(false, motionEvent, onRotaryListener);
        return onRotaryListener.onMiddleScroll(motionEvent);
    }

    public static HwRotaryEventTracker instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwRotaryEventTracker.class, HwWidgetInstantiator.getCurrentType(context, 8, 8)), HwRotaryEventTracker.class);
        if (objInstantiate instanceof HwRotaryEventTracker) {
            return (HwRotaryEventTracker) objInstantiate;
        }
        return null;
    }

    public void computeCurrentVelocity() {
        MotionEvent motionEvent = this.f44580e;
        if (motionEvent == null || this.f44581f == null) {
            this.f44582g = 0.0f;
            return;
        }
        float axisValue = motionEvent.getAxisValue(26);
        float axisValue2 = this.f44581f.getAxisValue(26);
        float eventTime = this.f44580e.getEventTime();
        float eventTime2 = this.f44581f.getEventTime();
        if (Float.compare(eventTime, eventTime2) >= 0) {
            this.f44582g = 0.0f;
            return;
        }
        if (Float.compare(axisValue * axisValue2, 0.0f) > 0) {
            axisValue2 = (axisValue + axisValue2) / 2.0f;
        }
        this.f44582g = ((-axisValue2) / (eventTime2 - eventTime)) * 1000.0f;
    }

    public OnRotaryListener getOnRotaryListener() {
        return this.f44578c;
    }

    public float getVelocity() {
        return this.f44582g;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) throws Throwable {
        if (!motionEvent.isFromSource(4194304) || motionEvent.getAction() != 8 || this.f44578c == null) {
            return false;
        }
        long eventTime = motionEvent.getEventTime();
        long j10 = this.f44576a;
        if (j10 < 0) {
            boolean zM55765a = m55765a(motionEvent, this.f44578c);
            this.f44576a = eventTime;
            return zM55765a;
        }
        if (eventTime - j10 < f44572j) {
            boolean zM55768c = m55768c(motionEvent, this.f44578c);
            this.f44576a = eventTime;
            return zM55768c;
        }
        m55767b(motionEvent, this.f44578c);
        boolean zM55765a2 = m55765a(motionEvent, this.f44578c);
        this.f44576a = eventTime;
        return zM55765a2;
    }

    public void setOnRotaryListener(View view, OnRotaryListener onRotaryListener) {
        this.f44578c = onRotaryListener;
        this.f44579d = view;
    }

    /* renamed from: a */
    private boolean m55765a(MotionEvent motionEvent, OnRotaryListener onRotaryListener) {
        m55764a(true, motionEvent, onRotaryListener);
        return onRotaryListener.onBeginScroll(motionEvent);
    }

    /* renamed from: a */
    private void m55764a(boolean z10, MotionEvent motionEvent, OnRotaryListener onRotaryListener) {
        if (z10) {
            MotionEvent motionEvent2 = this.f44580e;
            if (motionEvent2 != null) {
                motionEvent2.recycle();
                this.f44580e = null;
            }
            MotionEvent motionEvent3 = this.f44581f;
            if (motionEvent3 != null) {
                motionEvent3.recycle();
            }
            this.f44581f = MotionEvent.obtain(motionEvent);
        } else {
            MotionEvent motionEvent4 = this.f44580e;
            if (motionEvent4 != null) {
                motionEvent4.recycle();
            }
            this.f44580e = this.f44581f;
            this.f44581f = MotionEvent.obtain(motionEvent);
        }
        this.f44579d.removeCallbacks(this.f44577b);
        this.f44577b.f44583a = onRotaryListener;
        this.f44579d.postDelayed(this.f44577b, f44572j);
    }

    /* renamed from: a */
    private MotionEvent m55763a(float f10) {
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.x = 0.0f;
        pointerCoords.y = 0.0f;
        pointerCoords.setAxisValue(26, f10);
        MotionEvent.PointerCoords[] pointerCoordsArr = {pointerCoords};
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = 0;
        long jUptimeMillis = SystemClock.uptimeMillis();
        return MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 8, 1, new MotionEvent.PointerProperties[]{pointerProperties}, pointerCoordsArr, 0, 0, 1.0f, 1.0f, 0, 0, 4194304, 0);
    }
}
