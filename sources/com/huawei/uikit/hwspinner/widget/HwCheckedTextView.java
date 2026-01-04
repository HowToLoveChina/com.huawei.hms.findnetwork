package com.huawei.uikit.hwspinner.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import android.widget.CheckedTextView;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes5.dex */
public class HwCheckedTextView extends CheckedTextView {
    public HwCheckedTextView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public boolean isClickable() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        return !(accessibilityManager != null && accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) && super.isClickable();
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z10) {
        boolean zIsPressed = isPressed();
        super.setSelected(z10);
        if (z10 || zIsPressed == isPressed()) {
            return;
        }
        setPressed(zIsPressed);
    }

    public HwCheckedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HwCheckedTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
