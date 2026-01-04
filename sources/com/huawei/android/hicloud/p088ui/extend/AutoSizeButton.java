package com.huawei.android.hicloud.p088ui.extend;

import android.content.Context;
import android.util.AttributeSet;
import com.huawei.hicloud.base.view.widget.HiCloudAutoSizeButton;

/* loaded from: classes3.dex */
public class AutoSizeButton extends HiCloudAutoSizeButton {
    public AutoSizeButton(Context context) {
        this(context, null);
    }

    public AutoSizeButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoSizeButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        setAutoTextInfo(7, 2, 2);
    }
}
