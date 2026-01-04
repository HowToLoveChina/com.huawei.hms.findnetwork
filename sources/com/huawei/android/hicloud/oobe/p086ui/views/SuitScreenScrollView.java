package com.huawei.android.hicloud.oobe.p086ui.views;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.ScrollView;
import p399jk.AbstractC10896a;

/* loaded from: classes3.dex */
public class SuitScreenScrollView extends ScrollView {

    /* renamed from: a */
    public Context f12715a;

    public SuitScreenScrollView(Context context) {
        super(context);
        setContext(context);
    }

    private void setContext(Context context) {
        this.f12715a = context;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        try {
            Display defaultDisplay = ((Activity) this.f12715a).getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            i11 = View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels / 2, Integer.MIN_VALUE);
        } catch (Exception e10) {
            AbstractC10896a.m65887i("SuitScreenScrollView", e10.getMessage());
        }
        super.onMeasure(i10, i11);
    }

    public SuitScreenScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContext(context);
    }

    public SuitScreenScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        setContext(context);
    }
}
