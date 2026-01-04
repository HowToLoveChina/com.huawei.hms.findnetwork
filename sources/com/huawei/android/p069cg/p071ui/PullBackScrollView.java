package com.huawei.android.p069cg.p071ui;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import huawei.android.widget.ScrollView;
import p514o9.C11839m;

/* loaded from: classes2.dex */
public class PullBackScrollView extends ScrollView {
    private static final String TAG = "PullBackScrollView";
    private float lastScrollY;
    private Activity mActivity;
    private float mLastY;
    private float startY;

    /* renamed from: com.huawei.android.cg.ui.PullBackScrollView$a */
    public interface InterfaceC2348a {
        /* renamed from: a */
        void m14742a(float f10, float f11);
    }

    public PullBackScrollView(Context context) {
        super(context);
        this.mLastY = -1.0f;
        this.startY = -1.0f;
        this.lastScrollY = -1.0f;
    }

    private void handleOverTouch() {
        resetHeaderHeight();
    }

    private void resetHeaderHeight() {
    }

    public Activity getmActivity() {
        return this.mActivity;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mLastY == -1.0f) {
            this.mLastY = motionEvent.getRawY();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mLastY = motionEvent.getRawY();
            this.startY = motionEvent.getRawY();
        } else if (action != 2) {
            this.mLastY = -1.0f;
            handleOverTouch();
        } else {
            C11839m.m70688i(TAG, "ACTION_MOVE:" + this.startY);
            this.mLastY = motionEvent.getRawY();
            float scrollY = (float) getScrollY();
            ComponentCallbacks2 componentCallbacks2 = this.mActivity;
            if (componentCallbacks2 != null) {
                if (componentCallbacks2 instanceof InterfaceC2348a) {
                    C11839m.m70686d(TAG, "getCurrentY:" + scrollY);
                    ((InterfaceC2348a) componentCallbacks2).m14742a(scrollY, this.lastScrollY);
                }
                this.lastScrollY = scrollY;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setmActivity(Activity activity) {
        this.mActivity = activity;
    }

    public PullBackScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastY = -1.0f;
        this.startY = -1.0f;
        this.lastScrollY = -1.0f;
    }

    public PullBackScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mLastY = -1.0f;
        this.startY = -1.0f;
        this.lastScrollY = -1.0f;
    }

    public PullBackScrollView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.mLastY = -1.0f;
        this.startY = -1.0f;
        this.lastScrollY = -1.0f;
    }
}
