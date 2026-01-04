package com.huawei.android.hicloud.p088ui.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import p054cj.C1442a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class GradeRightItemView extends LinearLayout {

    /* renamed from: a */
    public TextView f19458a;

    /* renamed from: b */
    public String f19459b;

    /* renamed from: c */
    public View f19460c;

    /* renamed from: d */
    public LinearLayout f19461d;

    /* renamed from: e */
    public Context f19462e;

    /* renamed from: f */
    public int f19463f;

    public GradeRightItemView(Context context) {
        super(context);
        this.f19462e = context;
        m25765a(context);
    }

    /* renamed from: a */
    public final void m25765a(Context context) {
        View.inflate(context, R$layout.member_right_button_item, this);
        this.f19461d = (LinearLayout) C12809f.m76831d(this, R$id.right_tag_layout);
        this.f19458a = (TextView) C12809f.m76831d(this, R$id.grade_item_button);
        this.f19460c = C12809f.m76831d(this, R$id.current_right_cursor);
    }

    public int getPosition() {
        return this.f19463f;
    }

    public String getRightCode() {
        return this.f19459b;
    }

    public void setPosition(int i10) {
        this.f19463f = i10;
    }

    public void setRightCode(String str) {
        this.f19459b = str;
    }

    public void setmGradeRightName(String str) {
        if (TextUtils.isEmpty(str)) {
            C1442a.m8289e("GradeRightItemView", "the member right name is null");
        } else {
            this.f19458a.setText(str);
        }
    }

    public GradeRightItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19462e = context;
        m25765a(context);
    }

    public GradeRightItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19462e = context;
        m25765a(context);
    }
}
