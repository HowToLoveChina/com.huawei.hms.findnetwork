package com.huawei.android.hicloud.oobe.p086ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.oobe.R$dimen;
import com.huawei.android.hicloud.oobe.R$drawable;
import p015ak.C0224k0;

/* loaded from: classes3.dex */
public class DisableSupportedRelativeLayout extends RelativeLayout {

    /* renamed from: a */
    public boolean f12664a;

    public DisableSupportedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12664a = true;
    }

    /* renamed from: a */
    public void m17033a() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (!"disabled_false".equals((String) childAt.getTag())) {
                if (childAt instanceof UnionSwitch) {
                    ((UnionSwitch) childAt).setEnabled(false);
                } else if (childAt instanceof DisableSupportedRelativeLayout) {
                    ((DisableSupportedRelativeLayout) childAt).m17033a();
                } else if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    textView.setEnabled(false);
                    textView.setAlpha(0.62f);
                } else if (this.f12664a) {
                    childAt.setAlpha(0.62f);
                }
            }
        }
        setEnabled(false);
        setBackground(getContext().getDrawable(R$drawable.emui50_list_disable_selector));
    }

    /* renamed from: b */
    public void m17034b() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (!"disabled_false".equals((String) childAt.getTag())) {
                if (childAt instanceof UnionSwitch) {
                    ((UnionSwitch) childAt).setEnabled(true);
                } else if (childAt instanceof DisableSupportedRelativeLayout) {
                    ((DisableSupportedRelativeLayout) childAt).m17034b();
                } else if (childAt instanceof TextView) {
                    ((TextView) childAt).setEnabled(true);
                } else if (this.f12664a) {
                    childAt.setAlpha(C0224k0.m1555j(getContext().getResources(), R$dimen.enable_alpha));
                }
            }
        }
        setEnabled(true);
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void setIsSetTextViewAlpha(boolean z10) {
        this.f12664a = z10;
    }
}
