package com.huawei.uikit.hwspinner.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import android.widget.LinearLayout;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes5.dex */
public class HwSpinnerItemLinearLayout extends LinearLayout {
    public HwSpinnerItemLinearLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public boolean isClickable() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        return !(accessibilityManager != null && accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) && super.isClickable();
    }

    @Override // android.view.View
    public void setSelected(boolean z10) {
        boolean zIsPressed = isPressed();
        super.setSelected(z10);
        if (z10 || zIsPressed == isPressed()) {
            return;
        }
        setPressed(zIsPressed);
    }

    public HwSpinnerItemLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HwSpinnerItemLinearLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
