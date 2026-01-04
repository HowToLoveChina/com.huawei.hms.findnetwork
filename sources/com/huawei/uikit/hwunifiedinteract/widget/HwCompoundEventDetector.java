package com.huawei.uikit.hwunifiedinteract.widget;

import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;

/* loaded from: classes5.dex */
public class HwCompoundEventDetector {

    /* renamed from: d */
    private static final String f44536d = "HwCompoundEventDetector";

    /* renamed from: e */
    private static final int f44537e = 1;

    /* renamed from: a */
    private OnZoomEventListener f44538a = null;

    /* renamed from: b */
    private OnMultiSelectListener f44539b = null;

    /* renamed from: c */
    private View f44540c = null;

    public interface OnMultiSelectListener {
        boolean onCancel(MotionEvent motionEvent);

        boolean onSelectContinuous(boolean z10, MotionEvent motionEvent);

        boolean onSelectDiscrete(MotionEvent motionEvent);
    }

    public interface OnZoomEventListener {
        boolean onZoom(float f10, MotionEvent motionEvent);
    }

    public HwCompoundEventDetector(Context context) {
    }

    public static HwCompoundEventDetector instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwCompoundEventDetector.class, HwWidgetInstantiator.getCurrentType(context, 1, 1)), HwCompoundEventDetector.class);
        if (objInstantiate instanceof HwCompoundEventDetector) {
            return (HwCompoundEventDetector) objInstantiate;
        }
        return null;
    }

    public OnMultiSelectListener getOnMultiSelectEventListener() {
        return this.f44539b;
    }

    public OnZoomEventListener getOnZoomEventListener() {
        return this.f44538a;
    }

    public void onDetachedFromWindow() {
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!motionEvent.isFromSource(2)) {
            return false;
        }
        int action = motionEvent.getAction();
        if ((motionEvent.getMetaState() & 4096) != 0 && this.f44538a != null && action == 8) {
            float axisValue = motionEvent.getAxisValue(10);
            if (Float.compare(axisValue, 0.0f) == 0) {
                axisValue = motionEvent.getAxisValue(9);
            }
            if (Float.compare(axisValue, 0.0f) != 0 && this.f44538a.onZoom(axisValue, motionEvent)) {
                return true;
            }
        }
        if (action == 11 && motionEvent.getActionButton() == 1 && this.f44539b != null) {
            if ((motionEvent.getMetaState() & 4096) != 0 && this.f44539b.onSelectDiscrete(motionEvent)) {
                return true;
            }
            if ((motionEvent.getMetaState() & 1) != 0 && this.f44539b.onSelectContinuous(false, motionEvent)) {
                return true;
            }
        }
        return false;
    }

    public boolean onKeyEvent(int i10, KeyEvent keyEvent) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void setOnMultiSelectEventListener(View view, OnMultiSelectListener onMultiSelectListener) {
        this.f44540c = view;
        this.f44539b = onMultiSelectListener;
    }

    public void setOnZoomEventListener(View view, OnZoomEventListener onZoomEventListener) {
        this.f44540c = view;
        this.f44538a = onZoomEventListener;
    }
}
