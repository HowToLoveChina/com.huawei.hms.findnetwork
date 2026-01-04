package com.huawei.android.remotecontrol.p093ui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import p015ak.C0219i;
import p514o9.C11842p;
import sk.C12806c;

/* loaded from: classes4.dex */
public class PadFitButton extends HwButton implements View.OnApplyWindowInsetsListener {
    private boolean needPadFit;

    public PadFitButton(Context context) {
        this(context, null);
    }

    private void padInit() {
        if (isAttachedToWindow() && C0219i.m1463a() < 23) {
            if (!this.needPadFit || !C11842p.m70771U0()) {
                setMinWidth(C11842p.m70876w(getContext()).widthPixels / 2);
            } else if (getResources().getConfiguration().orientation == 2) {
                setMinWidth(C11842p.m70876w(getContext()).widthPixels / 3);
            } else {
                setMinWidth(C11842p.m70876w(getContext()).widthPixels / 2);
            }
        }
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        setWidth(((C11842p.m70876w(getContext()).widthPixels - C12806c.m76813d(windowInsets)) - C12806c.m76814e(windowInsets)) / 2);
        return windowInsets;
    }

    @Override // com.huawei.uikit.phone.hwbutton.widget.HwButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        padInit();
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        padInit();
    }

    public PadFitButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PadFitButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.needPadFit = true;
    }
}
