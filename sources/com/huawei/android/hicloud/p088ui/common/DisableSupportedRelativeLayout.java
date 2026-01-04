package com.huawei.android.hicloud.p088ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hicloud.sync.R$dimen;
import com.huawei.hicloud.sync.R$drawable;
import p015ak.C0224k0;
import p514o9.C11842p;
import sk.C12806c;
import sk.C12808e;
import sk.InterfaceC12805b;

/* loaded from: classes3.dex */
public class DisableSupportedRelativeLayout extends RelativeLayout implements InterfaceC12805b {

    /* renamed from: a */
    public boolean f17842a;

    /* renamed from: b */
    public Context f17843b;

    public DisableSupportedRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17842a = true;
        this.f17843b = context;
    }

    /* renamed from: a */
    public void m23909a() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (!"disabled_false".equals((String) childAt.getTag())) {
                if (childAt instanceof DisableSupportedRelativeLayout) {
                    ((DisableSupportedRelativeLayout) childAt).m23909a();
                } else if (childAt instanceof UnionSwitch) {
                    ((UnionSwitch) childAt).setEnabled(false);
                } else if (childAt instanceof TextView) {
                    ((TextView) childAt).setEnabled(false);
                } else if (this.f17842a) {
                    childAt.setAlpha(C0224k0.m1555j(this.f17843b.getResources(), R$dimen.disable_alpha));
                }
            }
        }
        setEnabled(false);
        setBackground(this.f17843b.getDrawable(R$drawable.emui50_list_disable_selector));
    }

    /* renamed from: b */
    public void m23910b() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (!"disabled_false".equals((String) childAt.getTag())) {
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setEnabled(true);
                } else if (childAt instanceof UnionSwitch) {
                    ((UnionSwitch) childAt).setEnabled(true);
                } else if (childAt instanceof DisableSupportedRelativeLayout) {
                    ((DisableSupportedRelativeLayout) childAt).m23910b();
                } else if (this.f17842a) {
                    childAt.setAlpha(C0224k0.m1555j(this.f17843b.getResources(), R$dimen.enable_alpha));
                }
            }
        }
        setEnabled(true);
        setBackground(this.f17843b.getDrawable(R$drawable.emui50_list_selector));
    }

    @Override // sk.InterfaceC12805b
    public void onRotation180(WindowInsets windowInsets) {
        setPadding(C12808e.m76823b(), 0, C12808e.m76823b(), 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation270(WindowInsets windowInsets) {
        Context context = this.f17843b;
        setPadding(0, 0, (context == null || !C12806c.m76818i(context)) ? 0 : C11842p.m70789a0(this.f17843b), 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation90(WindowInsets windowInsets) {
        Context context = this.f17843b;
        setPadding(context != null ? C11842p.m70789a0(context) : 0, 0, 0, 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotationPortrait(WindowInsets windowInsets) {
        setPadding(C12808e.m76823b(), 0, C12808e.m76823b(), 0);
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void setIsSetTextViewAlpha(boolean z10) {
        this.f17842a = z10;
    }
}
