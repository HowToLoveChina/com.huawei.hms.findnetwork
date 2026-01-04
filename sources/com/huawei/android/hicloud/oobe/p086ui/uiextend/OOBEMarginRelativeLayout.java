package com.huawei.android.hicloud.oobe.p086ui.uiextend;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.huawei.android.hicloud.oobe.R$styleable;
import p015ak.C0209d;
import p514o9.C11842p;

/* loaded from: classes3.dex */
public class OOBEMarginRelativeLayout extends RelativeLayout {

    /* renamed from: a */
    public boolean f12667a;

    public OOBEMarginRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12667a = true;
        if (context != null) {
            m17036a(context.obtainStyledAttributes(attributeSet, R$styleable.oobe_margin_relative_layout_attr));
        }
    }

    /* renamed from: a */
    public final void m17036a(TypedArray typedArray) {
        if (typedArray != null) {
            this.f12667a = typedArray.getBoolean(R$styleable.oobe_margin_relative_layout_attr_need_margin, true);
        }
    }

    /* renamed from: b */
    public void m17037b(Context context) {
        if (context != null && this.f12667a) {
            C11842p.m70823i2(this, C11842p.m70844o(context, C0209d.m1202Q0() ? 16 : 20));
        }
    }
}
