package com.huawei.uikit.phone.hwcheckbox.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.huawei.uikit.hwcheckbox.C8705R;
import com.huawei.uikit.hwresources.utils.AuxiliaryHelper;

/* loaded from: classes9.dex */
public class HwCheckBox extends com.huawei.uikit.hwcheckbox.widget.HwCheckBox {

    /* renamed from: a */
    private boolean f44961a;

    /* renamed from: b */
    private boolean f44962b;

    public HwCheckBox(Context context) {
        this(context, null);
    }

    public boolean isNeedAuxiliaryHelper() {
        return Float.compare(AuxiliaryHelper.getFontSize(getContext()), 1.75f) >= 0 && this.f44962b;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f44961a) {
            setGravity(8388659);
        } else {
            setGravity(8388627);
        }
        super.onDraw(canvas);
    }

    public HwCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C8705R.attr.hwCheckBoxStyle);
    }

    public HwCheckBox(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C8705R.styleable.HwCheckBox, i10, 0);
        this.f44961a = typedArrayObtainStyledAttributes.getBoolean(C8705R.styleable.HwCheckBox_hwAutoTopEnabled, false);
        this.f44962b = typedArrayObtainStyledAttributes.getBoolean(C8705R.styleable.HwCheckBox_hwAuxiliaryEnabled, true);
        typedArrayObtainStyledAttributes.recycle();
    }
}
