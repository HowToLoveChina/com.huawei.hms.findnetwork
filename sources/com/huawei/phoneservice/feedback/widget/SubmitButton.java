package com.huawei.phoneservice.feedback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.phoneservice.faq.base.util.FaqCommonUtils;
import com.huawei.phoneservice.faq.base.util.FaqLogger;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes5.dex */
public class SubmitButton extends Button {

    /* renamed from: a */
    public Context f40014a;

    public SubmitButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) throws Throwable {
        StringBuilder sb2;
        Configuration configuration = getResources().getConfiguration();
        FaqLogger.m51840e("widthMeasureSpec", i10 + "<<<<<<qian");
        WindowManager windowManager = (WindowManager) this.f40014a.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i12 = displayMetrics.widthPixels;
        if (2 != configuration.orientation || !FaqCommonUtils.isPad()) {
            if (1 == configuration.orientation && FaqCommonUtils.isPad()) {
                i10 = View.MeasureSpec.makeMeasureSpec(i12 / 2, View.MeasureSpec.getMode(i10));
                sb2 = new StringBuilder();
            }
            super.onMeasure(i10, i11);
        }
        i10 = View.MeasureSpec.makeMeasureSpec(i12 / 3, View.MeasureSpec.getMode(i10));
        sb2 = new StringBuilder();
        sb2.append(i10);
        sb2.append("<<<<<<<<hou");
        FaqLogger.m51840e("widthMeasureSpec", sb2.toString());
        super.onMeasure(i10, i11);
    }

    public SubmitButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SubmitButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f40014a = context;
    }
}
