package com.huawei.hicloud.base.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;

/* loaded from: classes6.dex */
public class HiCloudAutoSizeButton extends HwButton {
    public HiCloudAutoSizeButton(Context context) {
        this(context, null);
    }

    public HiCloudAutoSizeButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HiCloudAutoSizeButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        setAutoTextInfo(9, 2, 2);
    }
}
