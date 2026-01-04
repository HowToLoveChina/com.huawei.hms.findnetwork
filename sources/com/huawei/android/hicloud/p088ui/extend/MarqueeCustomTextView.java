package com.huawei.android.hicloud.p088ui.extend;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* loaded from: classes3.dex */
public class MarqueeCustomTextView extends AppCompatTextView {
    public MarqueeCustomTextView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean isFocused() {
        return true;
    }

    public MarqueeCustomTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MarqueeCustomTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
