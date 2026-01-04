package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import p015ak.C0219i;
import p514o9.C11842p;
import sk.C12809f;

/* loaded from: classes3.dex */
public class StorageLabelView extends RelativeLayout {
    private View inflateView;
    private View mLabelIcon;
    private TextView mLabelText;

    public StorageLabelView(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        if (C0219i.m1463a() >= 14 || !C11842p.m70765S0()) {
            this.inflateView = View.inflate(context, R$layout.storage_label_layout, this);
        } else {
            this.inflateView = View.inflate(context, R$layout.storage_label_layout_5x, this);
        }
        this.mLabelIcon = C12809f.m76831d(this.inflateView, R$id.label_icon);
        this.mLabelText = (TextView) C12809f.m76831d(this.inflateView, R$id.label_text);
    }

    public void setLabelIcon(Drawable drawable) {
        View view = this.mLabelIcon;
        if (view != null) {
            view.setBackground(drawable);
        }
    }

    public void setLabelText(String str) {
        TextView textView = this.mLabelText;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public StorageLabelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }
}
