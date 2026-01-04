package com.huawei.android.hicloud.p088ui.uiextend;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes3.dex */
public class CurrentOnTouchListener implements View.OnTouchListener {
    private ViewGroup mParentView;

    public CurrentOnTouchListener(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ViewGroup viewGroup;
        if (motionEvent.getAction() != 1 || (viewGroup = this.mParentView) == null) {
            return false;
        }
        viewGroup.performClick();
        return false;
    }
}
