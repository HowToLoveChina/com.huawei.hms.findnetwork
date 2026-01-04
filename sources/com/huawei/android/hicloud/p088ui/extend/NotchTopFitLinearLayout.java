package com.huawei.android.hicloud.p088ui.extend;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.LinearLayout;
import p015ak.C0209d;
import p015ak.C0219i;
import p514o9.C11829c;
import p514o9.C11842p;
import sk.C12806c;
import sk.InterfaceC12805b;

/* loaded from: classes3.dex */
public class NotchTopFitLinearLayout extends LinearLayout implements InterfaceC12805b {

    /* renamed from: a */
    public int f17941a;

    /* renamed from: b */
    public int f17942b;

    /* renamed from: c */
    public Context f17943c;

    public NotchTopFitLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17941a = 0;
        this.f17942b = 0;
        this.f17943c = context;
        if (!C11829c.m70563b0(context) || C0219i.m1463a() < 17) {
            return;
        }
        this.f17941a = C11842p.m70789a0(context);
        if (C0209d.m1249e1()) {
            this.f17942b = this.f17941a;
        }
    }

    @Override // sk.InterfaceC12805b
    public void onRotation180(WindowInsets windowInsets) {
        if (!C11829c.m70556Y0(this.f17943c)) {
            setPadding(0, 0, 0, 0);
        } else {
            int i10 = this.f17941a;
            setPadding(0, i10, 0, i10);
        }
    }

    @Override // sk.InterfaceC12805b
    public void onRotation270(WindowInsets windowInsets) {
        if (C0209d.m1249e1()) {
            this.f17942b = this.f17941a;
        }
        setPadding(0, this.f17942b, 0, 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation90(WindowInsets windowInsets) {
        if (C0209d.m1249e1()) {
            this.f17942b = this.f17941a;
        }
        setPadding(0, this.f17942b, 0, 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotationPortrait(WindowInsets windowInsets) {
        Context context = this.f17943c;
        if (context instanceof Activity) {
            if (C0209d.m1237b1(context)) {
                boolean zM70502B0 = C11829c.m70502B0((Activity) this.f17943c);
                if (!C12806c.m76819j((Activity) this.f17943c) || zM70502B0) {
                    setPadding(0, 0, 0, 0);
                    return;
                } else {
                    setPadding(0, this.f17941a, 0, 0);
                    return;
                }
            }
            if (C11829c.m70502B0((Activity) this.f17943c) && C11842p.m70750N0()) {
                setPadding(0, this.f17941a, 0, 0);
            } else if (C11829c.m70556Y0(this.f17943c)) {
                setPadding(0, this.f17941a, 0, 0);
            } else {
                setPadding(0, 0, 0, 0);
            }
        }
    }
}
