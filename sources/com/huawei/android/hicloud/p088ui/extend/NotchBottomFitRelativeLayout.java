package com.huawei.android.hicloud.p088ui.extend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.RelativeLayout;
import p015ak.C0209d;
import p015ak.C0219i;
import p514o9.C11842p;
import sk.C12806c;
import sk.InterfaceC12805b;

/* loaded from: classes3.dex */
public class NotchBottomFitRelativeLayout extends RelativeLayout implements InterfaceC12805b {

    /* renamed from: a */
    public int f17939a;

    public NotchBottomFitRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17939a = 0;
        if (!C12806c.m76815f(context) || C0219i.m1463a() < 17) {
            return;
        }
        this.f17939a = C11842p.m70789a0(context);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation180(WindowInsets windowInsets) {
        setPadding(0, 0, 0, this.f17939a);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation270(WindowInsets windowInsets) {
        setPadding(0, 0, 0, 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation90(WindowInsets windowInsets) {
        setPadding(0, 0, 0, 0);
    }

    public void onRotationPortrait(WindowInsets windowInsets) {
        setPadding(0, C0209d.m1249e1() ? this.f17939a : 0, 0, 0);
    }
}
