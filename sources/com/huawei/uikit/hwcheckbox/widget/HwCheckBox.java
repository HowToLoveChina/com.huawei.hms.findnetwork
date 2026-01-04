package com.huawei.uikit.hwcheckbox.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.huawei.uikit.hwcheckbox.C8705R;
import com.huawei.uikit.hwresources.utils.HwWidgetCompat;
import com.huawei.uikit.hwresources.utils.HwWidgetInstantiator;

/* loaded from: classes7.dex */
public class HwCheckBox extends CheckBox {

    /* renamed from: a */
    private static final int f41672a = 15;

    public HwCheckBox(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private static Context m54087a(Context context, int i10) {
        return HwWidgetCompat.wrapContext(context, i10, C8705R.style.Theme_Emui_HwCheckBox);
    }

    public static HwCheckBox instantiate(Context context) throws ClassNotFoundException {
        Object objInstantiate = HwWidgetInstantiator.instantiate(context, HwWidgetInstantiator.getDeviceClassName(context, HwCheckBox.class, HwWidgetInstantiator.getCurrentType(context, 15, 1)), HwCheckBox.class);
        if (objInstantiate instanceof HwCheckBox) {
            return (HwCheckBox) objInstantiate;
        }
        return null;
    }

    public HwCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8705R.attr.hwCheckBoxStyle);
    }

    public HwCheckBox(Context context, AttributeSet attributeSet, int i10) {
        super(m54087a(context, i10), attributeSet, i10);
        setDefaultFocusHighlightEnabled(false);
    }
}
