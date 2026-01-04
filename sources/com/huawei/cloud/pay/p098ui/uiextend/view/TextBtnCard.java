package com.huawei.cloud.pay.p098ui.uiextend.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.huawei.cloud.pay.R$id;
import com.huawei.cloud.pay.R$layout;
import com.huawei.cloud.pay.R$styleable;
import com.huawei.uikit.hwtextview.widget.HwTextView;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;

/* loaded from: classes5.dex */
public class TextBtnCard extends LinearLayout {

    /* renamed from: a */
    public HwButton f21478a;

    /* renamed from: b */
    public HwTextView f21479b;

    public TextBtnCard(Context context) {
        super(context);
        m28603a(context);
    }

    /* renamed from: a */
    public final void m28603a(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.card_text_btn, this);
        this.f21479b = (HwTextView) viewInflate.findViewById(R$id.text_content);
        this.f21478a = (HwButton) viewInflate.findViewById(R$id.jump_button);
    }

    /* renamed from: b */
    public final void m28604b(Context context, TypedArray typedArray) {
        m28605c(typedArray.getString(R$styleable.text_btn_card_attr_btn_text)).m28606d(typedArray.getString(R$styleable.text_btn_card_attr_content_text));
    }

    /* renamed from: c */
    public TextBtnCard m28605c(String str) {
        this.f21478a.setText(str);
        return this;
    }

    /* renamed from: d */
    public TextBtnCard m28606d(String str) {
        this.f21479b.setText(str);
        return this;
    }

    public TextBtnCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m28603a(context);
        m28604b(context, context.obtainStyledAttributes(attributeSet, R$styleable.text_btn_card_attr));
    }

    public TextBtnCard(Context context, CharSequence charSequence, CharSequence charSequence2, View.OnClickListener onClickListener) {
        this(context);
        this.f21479b.setText(charSequence);
        if (!TextUtils.isEmpty(charSequence2)) {
            this.f21478a.setText(charSequence2);
            this.f21478a.setOnClickListener(onClickListener);
        } else {
            this.f21478a.setVisibility(8);
        }
    }
}
