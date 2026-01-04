package com.huawei.phoneservice.faq.widget;

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

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class FaqSubmitButton extends Button {

    /* renamed from: a */
    public Context f39371a;

    public FaqSubmitButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        Configuration configuration = getResources().getConfiguration();
        WindowManager windowManager = (WindowManager) this.f39371a.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i13 = displayMetrics.widthPixels;
        if (2 != configuration.orientation || !FaqCommonUtils.isPad()) {
            if (1 == configuration.orientation && FaqCommonUtils.isPad()) {
                i12 = i13 / 2;
            }
            super.onMeasure(i10, i11);
        }
        i12 = i13 / 3;
        i10 = View.MeasureSpec.makeMeasureSpec(i12, View.MeasureSpec.getMode(i10));
        super.onMeasure(i10, i11);
    }

    public FaqSubmitButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaqSubmitButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f39371a = context;
    }
}
