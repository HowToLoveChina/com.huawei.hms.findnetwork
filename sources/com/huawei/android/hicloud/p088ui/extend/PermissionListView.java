package com.huawei.android.hicloud.p088ui.extend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.widget.ListView;
import p514o9.C11842p;
import sk.C12806c;
import sk.C12808e;
import sk.InterfaceC12805b;

/* loaded from: classes3.dex */
public class PermissionListView extends ListView implements InterfaceC12805b {

    /* renamed from: a */
    public Context f17950a;

    public PermissionListView(Context context) {
        super(context);
        this.f17950a = context;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    @Override // sk.InterfaceC12805b
    public void onRotation180(WindowInsets windowInsets) {
        setPadding(C12808e.m76823b(), 0, C12808e.m76823b(), 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation270(WindowInsets windowInsets) {
        Context context = this.f17950a;
        setPadding(0, 0, (context == null || !C12806c.m76818i(context)) ? 0 : C11842p.m70789a0(this.f17950a), 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotation90(WindowInsets windowInsets) {
        Context context = this.f17950a;
        setPadding(context != null ? C11842p.m70789a0(context) : 0, 0, 0, 0);
    }

    @Override // sk.InterfaceC12805b
    public void onRotationPortrait(WindowInsets windowInsets) {
        setPadding(C12808e.m76823b(), 0, C12808e.m76823b(), 0);
    }

    public PermissionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17950a = context;
    }

    public PermissionListView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f17950a = context;
    }
}
