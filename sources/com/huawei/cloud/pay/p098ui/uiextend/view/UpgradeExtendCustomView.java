package com.huawei.cloud.pay.p098ui.uiextend.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.cloud.pay.R$color;
import com.huawei.cloud.pay.R$id;
import com.huawei.cloud.pay.R$layout;
import com.huawei.cloud.pay.R$styleable;
import p054cj.C1442a;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes5.dex */
public class UpgradeExtendCustomView extends LinearLayout {

    /* renamed from: a */
    public Context f21480a;

    /* renamed from: b */
    public LinearLayout f21481b;

    /* renamed from: c */
    public TextView f21482c;

    /* renamed from: d */
    public int f21483d;

    /* renamed from: e */
    public int f21484e;

    /* renamed from: f */
    public int f21485f;

    /* renamed from: g */
    public String f21486g;

    public UpgradeExtendCustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (context != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.price_desc_dialog_attr);
            this.f21480a = context;
            m28608b(context);
            m28607a(typedArrayObtainStyledAttributes);
        }
    }

    /* renamed from: a */
    public final void m28607a(TypedArray typedArray) {
        if (typedArray != null) {
            this.f21483d = typedArray.getInt(R$styleable.price_desc_dialog_attr_tv_space, 0);
            this.f21484e = typedArray.getInt(R$styleable.price_desc_dialog_attr_tv_text_size, 14);
            this.f21485f = typedArray.getColor(R$styleable.price_desc_dialog_attr_tv_text_color, getResources().getColor(R$color.black));
            this.f21486g = typedArray.getString(R$styleable.price_desc_dialog_attr_tv_text_typeface);
            typedArray.recycle();
        }
    }

    /* renamed from: b */
    public final void m28608b(Context context) {
        addView(LayoutInflater.from(context).inflate(R$layout.upgrade_extend_text_view, (ViewGroup) null));
        this.f21481b = (LinearLayout) C12809f.m76831d(this, R$id.price_desc_dialog_content);
        this.f21482c = (TextView) C12809f.m76831d(this, R$id.price_desc_dialog_title);
    }

    /* renamed from: c */
    public void m28609c(String str, String[] strArr) {
        TextView textView = this.f21482c;
        if (textView != null) {
            textView.setText(str);
        }
        if (this.f21481b == null) {
            C1442a.m8289e("UpgradeExtendTextListView", "refreshList mContentLayout is null.");
            return;
        }
        if (strArr == null || strArr.length == 0) {
            C1442a.m8289e("UpgradeExtendTextListView", "refreshList dataList is empty.");
            return;
        }
        if (this.f21480a == null) {
            C1442a.m8289e("UpgradeExtendTextListView", "refreshList mContext is null.");
            return;
        }
        int i10 = 0;
        for (String str2 : strArr) {
            TextView textView2 = new TextView(this.f21480a);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            if (i10 == 0) {
                layoutParams.setMargins(0, 0, 0, 0);
            } else {
                layoutParams.setMargins(0, (int) C11842p.m70844o(this.f21480a, this.f21483d), 0, 0);
            }
            textView2.setLayoutParams(layoutParams);
            textView2.setTextSize(2, this.f21484e);
            textView2.setTextColor(this.f21485f);
            textView2.setTypeface(Typeface.create(this.f21486g, 0));
            textView2.setText(str2);
            this.f21481b.addView(textView2);
            i10++;
        }
    }
}
