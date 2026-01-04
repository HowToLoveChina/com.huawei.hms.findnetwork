package com.huawei.android.hicloud.p088ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import sk.C12809f;

/* loaded from: classes3.dex */
public class GradeRightDotView extends LinearLayout {

    /* renamed from: a */
    public View f19456a;

    /* renamed from: b */
    public Context f19457b;

    public GradeRightDotView(Context context) {
        super(context);
        this.f19457b = context;
        m25764a(context);
    }

    /* renamed from: a */
    public final void m25764a(Context context) {
        View.inflate(context, R$layout.member_right_dot, this);
        this.f19456a = C12809f.m76831d(this, R$id.member_right_dot);
    }

    public GradeRightDotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19457b = context;
        m25764a(context);
    }

    public GradeRightDotView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19457b = context;
        m25764a(context);
    }
}
