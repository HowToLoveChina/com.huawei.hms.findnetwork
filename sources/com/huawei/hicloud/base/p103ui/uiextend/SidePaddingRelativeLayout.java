package com.huawei.hicloud.base.p103ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.RelativeLayout;
import sk.C12808e;

/* loaded from: classes6.dex */
public class SidePaddingRelativeLayout extends RelativeLayout {

    /* renamed from: a */
    public Context f22175a;

    public SidePaddingRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22175a = context;
        C12808e.m76826e(this);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        C12808e.m76827f(this.f22175a, this);
        return super.onApplyWindowInsets(windowInsets);
    }
}
