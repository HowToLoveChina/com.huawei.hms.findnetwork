package com.huawei.android.hicloud.p088ui.extend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import sk.InterfaceC12805b;

/* loaded from: classes3.dex */
public class InterceptingLinearLayout extends NotchFitLinearLayout implements InterfaceC12805b {
    public InterceptingLinearLayout(Context context) {
        super(context, null);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public InterceptingLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
