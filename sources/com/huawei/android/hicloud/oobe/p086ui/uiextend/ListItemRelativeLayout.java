package com.huawei.android.hicloud.oobe.p086ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.RelativeLayout;
import p514o9.C11842p;
import sk.C12806c;
import sk.C12808e;
import sk.InterfaceC12805b;

/* loaded from: classes3.dex */
public class ListItemRelativeLayout extends RelativeLayout implements InterfaceC12805b {

    /* renamed from: a */
    public int f12665a;

    /* renamed from: b */
    public Context f12666b;

    public ListItemRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12665a = -1;
        this.f12666b = context;
    }

    public int getListIndex() {
        return this.f12665a;
    }

    @Override // sk.InterfaceC12805b
    public void onRotation180(WindowInsets windowInsets) {
        setPadding(C12808e.m76823b(), 0, C12808e.m76823b(), 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation270(WindowInsets windowInsets) {
        Context context = this.f12666b;
        setPadding(0, 0, (context == null || !C12806c.m76818i(context)) ? 0 : C11842p.m70789a0(this.f12666b), 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation90(WindowInsets windowInsets) {
        Context context = this.f12666b;
        setPadding(context != null ? C11842p.m70789a0(context) : 0, 0, 0, 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotationPortrait(WindowInsets windowInsets) {
        setPadding(C12808e.m76823b(), 0, C12808e.m76823b(), 0);
    }

    public void setListIndex(int i10) {
        this.f12665a = i10;
    }
}
