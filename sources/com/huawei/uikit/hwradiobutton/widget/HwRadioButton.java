package com.huawei.uikit.hwradiobutton.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.huawei.uikit.hwradiobutton.C8720R;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;

/* loaded from: classes4.dex */
public class HwRadioButton extends RadioButton {

    /* renamed from: a */
    private static final int f43231a = 15;

    public HwRadioButton(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private static Context m54797a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8720R.style.Theme_Emui_HwRadioButton);
    }

    public static HwRadioButton instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwRadioButton.class, HwWidgetInstantiator.getCurrentType(context, 15, 1)), HwRadioButton.class);
        if (objInstantiate instanceof HwRadioButton) {
            return (HwRadioButton) objInstantiate;
        }
        return null;
    }

    public HwRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8720R.attr.hwRadioButtonStyle);
    }

    public HwRadioButton(Context context, AttributeSet attributeSet, int i10) {
        super(m54797a(context, i10), attributeSet, i10);
        setDefaultFocusHighlightEnabled(false);
    }
}
