package com.huawei.uikit.hwunifiedinteract.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;

/* loaded from: classes5.dex */
public class HwGenericEventDetector {
    public static final int SCROLL_SENSITIVITY_FAST = 0;
    public static final int SCROLL_SENSITIVITY_NORMAL = 1;
    public static final int SCROLL_SENSITIVITY_SLOW = 2;

    /* renamed from: m */
    private static final float f44541m = 1.0f;

    /* renamed from: n */
    private static final float f44542n = 1.0f;

    /* renamed from: o */
    private static final float f44543o = 0.6f;

    /* renamed from: p */
    private static final String f44544p = "HwGenericEventDetector";

    /* renamed from: q */
    private static final int f44545q = 9;

    /* renamed from: r */
    private static final float f44546r = -1.0f;

    /* renamed from: s */
    private static final int f44547s = 1;

    /* renamed from: t */
    private static final int f44548t = 64;

    /* renamed from: g */
    private float f44555g;

    /* renamed from: h */
    private float f44556h;

    /* renamed from: i */
    private int f44557i;

    /* renamed from: l */
    private View f44560l;

    /* renamed from: a */
    private OnChangePageListener f44549a = null;

    /* renamed from: b */
    private OnChangeProgressListener f44550b = null;

    /* renamed from: c */
    private OnScrollListener f44551c = null;

    /* renamed from: d */
    private float f44552d = -1.0f;

    /* renamed from: e */
    private float f44553e = -1.0f;

    /* renamed from: f */
    private float f44554f = 0.0f;

    /* renamed from: j */
    private float f44558j = 0.0f;

    /* renamed from: k */
    private float f44559k = 1.0f;

    public interface OnChangePageListener {
        boolean onChangePage(float f10, MotionEvent motionEvent);
    }

    public interface OnChangeProgressListener {
        boolean onChangeProgress(int i10, int i11, MotionEvent motionEvent);
    }

    public interface OnChangeProgressListener2 extends OnChangeProgressListener {
        boolean onBegin();

        boolean onEnd(float f10);
    }

    public interface OnScrollListener {
        boolean onScrollBy(float f10, float f11, MotionEvent motionEvent);
    }

    public interface OnScrollListener2 extends OnScrollListener {
        boolean onBegin();

        boolean onEnd(float f10);
    }

    public HwGenericEventDetector(Context context) {
        this.f44555g = 0.0f;
        this.f44556h = 0.0f;
        this.f44557i = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f44555g = viewConfiguration.getScaledHorizontalScrollFactor();
        this.f44556h = viewConfiguration.getScaledVerticalScrollFactor();
        this.f44557i = viewConfiguration.getScaledTouchSlop();
    }

    /* renamed from: a */
    private boolean m55757a(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        float f10 = this.f44552d;
        float f11 = this.f44554f;
        if (f10 - f11 <= x10 && x10 <= f10 + f11) {
            float f12 = this.f44553e;
            if (f12 - f11 <= y10 && y10 <= f12 + f11) {
                return false;
            }
        }
        return true;
    }

    public static HwGenericEventDetector instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwGenericEventDetector.class, HwWidgetInstantiator.getCurrentType(context, 9, 1)), HwGenericEventDetector.class);
        if (objInstantiate instanceof HwGenericEventDetector) {
            return (HwGenericEventDetector) objInstantiate;
        }
        return null;
    }

    public float getHorizontalScrollFactor() {
        return this.f44555g * this.f44559k;
    }

    public OnChangePageListener getOnChangePageListener() {
        return this.f44549a;
    }

    public OnChangeProgressListener getOnChangeProgressListener() {
        return this.f44550b;
    }

    public OnScrollListener getOnScrollListener() {
        return this.f44551c;
    }

    public float getSensitivity() {
        return this.f44559k;
    }

    public float getStepValue() {
        return this.f44558j;
    }

    public View getTargetView() {
        return this.f44560l;
    }

    public int getTouchSlop() {
        return this.f44557i;
    }

    public float getVelocity() {
        return 0.0f;
    }

    public float getVerticalScrollFactor() {
        return this.f44556h * this.f44559k;
    }

    public boolean interceptGenericMotionEvent(MotionEvent motionEvent) {
        if (this.f44551c == null) {
            return false;
        }
        if (Float.compare(this.f44552d, -1.0f) == 0 && Float.compare(this.f44553e, -1.0f) == 0) {
            return false;
        }
        if (!m55757a(motionEvent)) {
            return onGenericMotionEvent(motionEvent);
        }
        this.f44552d = -1.0f;
        this.f44553e = -1.0f;
        return false;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (motionEvent.isFromSource(2) && motionEvent.getAction() == 8) {
            float axisValue = motionEvent.getAxisValue(10);
            float axisValue2 = motionEvent.getAxisValue(9);
            if (Float.compare(axisValue, 0.0f) == 0 && Float.compare(axisValue2, 0.0f) == 0) {
                return false;
            }
            float f10 = Float.compare(axisValue, 0.0f) == 0 ? -axisValue2 : axisValue;
            OnChangePageListener onChangePageListener = this.f44549a;
            if (onChangePageListener != null && onChangePageListener.onChangePage(f10, motionEvent)) {
                return true;
            }
            OnChangeProgressListener onChangeProgressListener = this.f44550b;
            if (onChangeProgressListener != null && onChangeProgressListener.onChangeProgress((int) (-axisValue), (int) axisValue2, motionEvent)) {
                return true;
            }
            if (this.f44551c != null) {
                if (this.f44551c.onScrollBy(Math.round(axisValue * getHorizontalScrollFactor()), Math.round((-axisValue2) * getVerticalScrollFactor()), motionEvent)) {
                    if (this.f44552d < 0.0f || this.f44553e < 0.0f) {
                        this.f44552d = motionEvent.getX();
                        this.f44553e = motionEvent.getY();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void setOnChangePageListener(OnChangePageListener onChangePageListener) {
        this.f44549a = onChangePageListener;
    }

    public void setOnChangeProgressListener(OnChangeProgressListener onChangeProgressListener) {
        this.f44550b = onChangeProgressListener;
    }

    public void setOnScrollListener(View view, OnScrollListener onScrollListener) {
        this.f44551c = onScrollListener;
        this.f44560l = view;
    }

    public void setRotaryConverter(HwRotaryConverter hwRotaryConverter) {
        Log.d(f44544p, "Implement setRotaryConverter in the watch package.");
    }

    public void setSensitivity(float f10) {
        this.f44559k = f10;
    }

    public void setSensitivityMode(int i10) {
        if (i10 == 0) {
            this.f44559k = 1.0f;
        } else if (i10 == 2) {
            this.f44559k = 0.6f;
        } else {
            this.f44559k = 1.0f;
        }
    }

    public void setStepValue(float f10) {
        this.f44558j = f10;
    }

    public void setOnChangeProgressListener(View view, OnChangeProgressListener onChangeProgressListener) {
        this.f44550b = onChangeProgressListener;
        this.f44560l = view;
    }
}
